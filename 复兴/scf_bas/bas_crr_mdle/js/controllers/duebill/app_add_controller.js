/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var duebillappaddController = function(dialogScope,parentScope,dataDeliver,$state,$common,flag) {
    dialogScope.secondform = {};
    dialogScope.confirm_onClick = function(){
        if(!dialogScope.secondform.appId || dialogScope.secondform.appId==""){
            $common.get_tipDialog('合同号不可为空！','showError');
            return false;
        }
        dialogScope.flowsubmitdisable = true;
        dialogScope.closeThisDialog();
        dialogScope.secondform.flg = "add";
        var prdId = dialogScope.secondform.prdId;
        $common.get_asyncData('bCrrPrdMdService/findBCrrPrdMdByPrdId',{prdId:prdId}).then(function(res){
            if (res.errorCode =="SUC"){
                dialogScope.secondform.prdmd = res.contextData;
                $state.go("duebillapp");
                dataDeliver.setter(dialogScope.secondform);
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    };
    dialogScope.appId_onFocus = function(){
        document.getElementById("appId").blur();
        $common.get_ngDialog('duebill/conn_list.html', parentScope
            ,["$scope",function(secondScope){
                duebillappchooseController(secondScope,dialogScope,dataDeliver,$state,$common,"add");
            }],"合同选择",{showClose:false});
    }
    dialogScope.choose_onClick = function(){
        $common.get_ngDialog('duebill/conn_list.html', parentScope
            ,["$scope",function(secondScope){
                duebillappchooseController(secondScope,dialogScope,dataDeliver,$state,$common,"add");
            }],"合同选择",{showClose:false});
    };
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/10
 */
var diraddController = function($dirScope,parentScope,$common,flag) {
    dialogScope.selectCust = {
        ds:[]
    };
    var promiseCust = $common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByBCrm");
    promiseCust.then(function(res){
        var data;
        if (res.errorCode =="SUC"){
            data = res.contextData;
            dialogScope.selectCust.ds = data;
        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
    $dirScope.selectMdlCl = {
        ds:[]
    }
    var promiseCl = $common.get_asyncData("bFinCnfgClService/selectForSelect");
    promiseCl.then(function(res){
        var dataCl;
        if (res.errorCode =="SUC"){
            dataCl = res.contextData;
            $dirScope.selectMdlCl.ds = dataCl;
        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
    $dirScope.secondForm = parentScope.otherform;
    $dirScope.confirm_onClick = function(){
        if($.doValidate("secondForm")) {
            if(flag == "add"){
                var mdlId = $dirScope.secondForm.mdlIdIs+","+$dirScope.secondForm.mdlIdBs+","+$dirScope.secondForm.mdlIdCs;
                var finNm = $dirScope.secondForm.finNmIs+","+$dirScope.secondForm.finNmBs+","+$dirScope.secondForm.finNmCs;
                $dirScope.secondForm.mdlId = mdlId;
                $dirScope.secondForm.finNm = finNm;
                var primise = $common.get_asyncData("bFinCustDirService/add",{bFinCustDir:$dirScope.secondForm});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        parentScope.queryTable();
                        parentScope.selected.select=[];
                        $dirScope.closeThisDialog();
                        $common.get_tipDialog('新增成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            };
        };
    };
    $dirScope.closeThisDialog_onClick = function(){
        $dirScope.closeThisDialog();
    };
};

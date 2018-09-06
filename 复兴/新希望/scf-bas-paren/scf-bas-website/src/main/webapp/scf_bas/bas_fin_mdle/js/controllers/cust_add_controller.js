/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/10
 */
var custaddController = function(dialogScope,parentScope,dataDeliver,$state,$common,flag) {
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
    if(flag == "add"){
        dialogScope.secondForm = parentScope.otherform;
        dialogScope.otherform={};//定义form对象
    }else if (flag == "update"){
        dialogScope.otherform=$common.copy(parentScope.selected.select[0]);
    };
    /**
     * 客户名称查询加载开始
     */
    dialogScope.custcontent = {
        type:"table",//展示类型table  tree
        url:"bCrrLnAppService/queryCustSource",
        param:{},
        split:",",//分隔符
        extentColumn:"custNm",
        column:["custNm","custId"]//展示内容
    };
    dialogScope.dooextend = function(ds){
    	dialogScope.otherform.custNm=ds.custNm;
        dialogScope.otherform.custId=ds.custId;
    };
    dialogScope.$watch("otherform.custNm",function(){
        if(dialogScope.otherform.custNm!=null) dialogScope.custcontent.param ={custId:dialogScope.otherform.custNm,custNm:dialogScope.otherform.custNm};
    });
    /**
     * 客户名称查询加载结束
     */
    dialogScope.confirm_onClick = function(){
        var custNm = dialogScope.otherform.custNm;
        var custId = dialogScope.otherform.custId;
        var bCrmBaseInfo = {custCd:custId};
        //校验输入客户名称与获取客户名是否匹配
        var primise = $common.get_asyncData('bCrmBaseInfoService/findBCrmBaseInfoByKey',{bCrmBaseInfo:bCrmBaseInfo});
        primise.then(function(res){
            var custinfo;
            if (res.errorCode =="SUC") {
                custinfo = res.contextData;
                var cname = custinfo.cname;
                if (custNm == cname) {
                    if($.doValidate("otherform")) {
                        dialogScope.flowsubmitdisable = true;
                        if(flag == "add"){
                            dialogScope.otherform.stat = "0";
                            dialogScope.otherform.audFlg = "0";
                            var primise = $common.get_asyncData("bFinCustService/add",{bFinCust:dialogScope.otherform});
                            primise.then(function(res){
                                if (res.errorCode =="SUC"){
                                    parentScope.queryTable();
                                    parentScope.selected.select=[];
                                    dialogScope.closeThisDialog();
                                    $common.get_tipDialog('新增成功！','showSuccess');
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                };
                            });
                        }else if (flag == "update"){
                            var primise = $common.get_asyncData('bFinCustService/updateBFinCust',{bFinCust:dialogScope.otherform});
                            primise.then(function(res){
                                if (res.errorCode =="SUC"){
                                    parentScope.queryTable();
                                    parentScope.selected.select=[];
                                    dialogScope.closeThisDialog();
                                    $common.get_tipDialog('更新成功！','showSuccess');
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                };
                            });
                        };
                    };
                }
                else {
                    document.getElementById("custNm").focus();
                    $common.get_tipDialog("输入客户名称与客户号不匹配，请重新选择", 'showError');
                }
            }
        });
    };
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var OrgCodeController =  function(dialogScope,parentScope,$common,$state,dataDeliver){

    dialogScope.otherform={};
    dialogScope.confirm_onClick = function(){
        if($.doValidate("otherform")){
            var orgCodeVal = dialogScope.otherform.orgCode;
            $common.get_asyncData("bCrmInsureCustomerService/findCustomerInfoByKey",{bCrmBaseInfo:dialogScope.otherform}).then(
                function(res){
                    if(res.errorCode == "SUC"){
                        var data = res.contextData;//查到的数据
                        if (data.orgCode==dialogScope.otherform.orgCode && data.insureFlag=="1" ){
                            $common.get_tipDialog("该组织机构代码在系统中存在，不可以新增！",'showError');
                        }else if(data.orgCode==dialogScope.otherform.orgCode && data.insureFlag !="1" ) {
                            $common.get_tipDialog('该组织机构代码在系统中已经存在，但并不是保险公司，是否转为保险公司？','showTip').then(function(){
                                //if(data.ccmsCustcd==null||data.ccmsCustcd==undefined){
                                //	data.ccmsCustcd = ccmsCustcdVal;
                                //}
                                var data1= {
                                    flag: "update",
                                    orgCode:data.orgCode,
                                    bCrmBaseInfo:data
                                };
                                $state.go("tree");
                                dataDeliver.setter(data1);
                            });
                        }else if(data.orgCode==""||data.orgCode==undefined||data.orgCode!=orgCodeVal){
                            dataForm ={
                                tlrName:data.tlrName,
                                brName:data.brName,
                                ccmsCustcd:data.ccmsCustcd,
                                orgCode:orgCodeVal,
                                insureFlag:'1'
                            }
                            var deliverData ={
                                flag:"add",
                                orgCode:orgCodeVal,
                                bCrmBaseInfo:dataForm
                            };
                            $state.go("tree");
                            dataDeliver.setter(deliverData);
                        }
                        dialogScope.closeThisDialog();
                    }else{
                        $common.get_tipDialog(res.errorMsg,"showError");
                    }
                }
            );
        }
    };
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

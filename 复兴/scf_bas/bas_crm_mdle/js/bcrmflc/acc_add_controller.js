/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var AccInfoAddController =  function(dialogScope,parentScope,$common,flag,row){
    //***************初始化开始****************//
    //dialogScope.otherform.brNo = userInfo.brNo;
    //dialogScope.otherform={
    //    dialogScope.otherform.custcd =row.custcd;
    //    dialogScope.otherform.cname =row.cname;
    //};
    dialogScope.otherform={};

    if(flag=="add"){
        dialogScope.disable = false;
        dialogScope.disable1 = false;
        $common.get_asyncData("bCrmInsureCustomerService/findBAccAccountInfo").then(
            function(res){
                if(res.errorCode=="SUC"){
                    //dialogScope.otherform.brName =res.contextData.brName;
                    //dialogScope.otherform.brNo =res.contextData.brName;
                    //dialogScope.otherform.mgrName =res.contextData.brName;
                    dialogScope.otherform = res.contextData;
                    dialogScope.otherform.custcd = row.custcd;
                    dialogScope.otherform.cname = row.cname;
                }
            });
    }else if(flag=="update"){
            dialogScope.disable = false;
            dialogScope.disable1 = true;
            dialogScope.otherform = row;
    }else if(flag =="view"){
        dialogScope.disable = true;
        dialogScope.disable1 = true;
        dialogScope.otherform = row;
    }

    //***************初始化结束****************//


    dialogScope.confirm_onClick= function(){
        var data={bAccAccountInfo:{
                accountNo:dialogScope.otherform.accountNo,
                accountType:dialogScope.otherform.accountType,
                custcd:dialogScope.otherform.custcd
            }
        };

        $common.get_asyncData("bAccAccountInfoService/findBAccAccountInfoByKey",data).then(function(res){

            if(res.errorCode=="SUC"){
                data = res.contextData;
                if(data.accountNo==dialogScope.otherform.accountNo){
                    $common.get_tipDialog("当前账户已经存在，不可以添加",'showInform');
                }else{
                    data ={bAccAccountInfo:dialogScope.otherform}
                    $common.get_asyncData("bCrmInsureCustomerService/addOrUpdateBaccAcct",data).then(
                        function(res){
                            if(res.errorCode=="SUC"){
                                if(flag=="add") {
                                    $common.get_tipDialog("新增成功","showSuccess");
                                }else if(flag=="update"){
                                    $common.get_tipDialog("修改成功","showSuccess");
                                }

                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                            dialogScope.closeThisDialog();
                        }
                    );
                }

            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }

            parentScope.selected.select=[];
            parentScope.queryTabConditions();
        });

    };


    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };

};

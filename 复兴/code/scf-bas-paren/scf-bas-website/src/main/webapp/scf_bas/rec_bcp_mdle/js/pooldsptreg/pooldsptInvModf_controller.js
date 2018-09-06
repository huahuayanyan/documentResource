/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */

var pooldsptInvModfController = function(dialogScope,parentScope,$common,dataDeliver,$state,row) {
    dialogScope.otherform=row;
    if(!dialogScope.otherform.issueReason){//如果没有解决方式，直接先赋值一个
        dialogScope.otherform.issueReason=""
    }
    if(!dialogScope.otherform.money){//如果没有解决方式，直接先赋值一个
        dialogScope.otherform.money=""
    }
    var errorFlag=false;
    var errorMessage="";
    function checkForm (){
        var money=parseFloat(dialogScope.otherform.money);//争议金额
        var remainingAmount=0;
        if(dialogScope.otherform.remainingAmount){
            remainingAmount=parseFloat(dialogScope.otherform.remainingAmount);//应收账款余额
        }
        //争议金额不能小于等于0
        if(money <= 0){
            errorFlag=true;
            errorMessage=errorMessage+"争议金额不能小于等于0！"
        }
        if(money > remainingAmount){
            errorFlag=true;
            errorMessage=errorMessage+"争议金额必须小于等于应收账款余额！"
        }

    }
    dialogScope.save_onClick = function(){
        if($.doValidate("otherform")){
            checkForm ();
            if(errorFlag){
                $common.get_tipDialog(errorMessage,'showError');
                errorFlag=false;
                errorMessage="";
            }else{//因为下拉菜单还没有办法校验必输性
                if(dialogScope.otherform.issueReason !=""){
                    //页面争议金额计算,如果有争议计算才计算
                    var dsArray = parentScope.bcpDatasource.ds;
                    var selected = parentScope.bcpSelected.select[0];
                    var amount=0;
                    for (var k in dsArray ) {
                        if(dsArray[k].money){
                            var money1=parseFloat(dsArray[k].money)
                            amount=amount+money1;
                        }
                        if (dsArray[k].id == selected.id) {
                            parentScope.bcpDatasource.ds[k]=$common.copy(dialogScope.otherform);
                        }
                    }

                    parentScope.cntDebtInfoForm.amount=amount;
                    parentScope.bcpSelected.select=[];
                    dialogScope.closeThisDialog();
                }else{
                    $common.get_tipDialog('请选择争议解决方式！','showError');
                }
            }
        }
    }
    dialogScope.back_onClick = function(){
        dialogScope.closeThisDialog();
    }
};

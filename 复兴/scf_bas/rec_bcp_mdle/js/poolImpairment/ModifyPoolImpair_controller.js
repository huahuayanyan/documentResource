/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */

var modifyPoolImpairControl = function(dialogScope,parentScope,$common,dataDeliver,$state,row) {
    if(!row.rebateAmounts){
        row.rebateAmounts=0.00;
    }
   var rebateAmounts1=parseFloat(row.rebateAmounts);//原来的
    if(!row.rebatebalance){
        row.rebatebalance=row.remainingAmount;
    }
    if(!row.rebateAmount){
        row.rebateAmount=0.00;
    }
    dialogScope.otherform=$common.copy(row);
    var errorFlag=true;
    function checkFormRule(){
        var rebateAmounts=parseFloat(dialogScope.otherform.rebateAmounts);
        var remainingAmount=parseFloat(dialogScope.otherform.remainingAmount);
        if(rebateAmounts <= 0){
            $common.get_tipDialog('减值金额需大于零！','showError');
            errorFlag=false;
        }else{
            if(rebateAmounts > remainingAmount ){
                $common.get_tipDialog('减值金额不可大于应收账款余额！','showError');
                errorFlag=false;
            }
        }
    }

    dialogScope.rebateAmounts_onBlur= function (){
        var remainingAmount=parseFloat(dialogScope.otherform.remainingAmount);
        var rebateAmounts=parseFloat(dialogScope.otherform.rebateAmounts);
        if(rebateAmounts <= 0){
            $common.get_tipDialog('减值金额需大于零！','showError');
            errorFlag=false;
        }else if(rebateAmounts > remainingAmount){
            $common.get_tipDialog('减值金额不可大于应收账款余额！','showError');
            errorFlag=false;
        }else{
            dialogScope.otherform.rebatebalance=remainingAmount-rebateAmounts;
            dialogScope.$apply();
        }
    }
    dialogScope.save_onClick = function(){
        if($.doValidate("otherform")){
            checkFormRule();
            if(errorFlag){
                //parentScope.bcpDatasource.ds=[];
                var selected = parentScope.bcpSelected.select[0];
                var dsArray = parentScope.bcpDatasource.ds;
                var amount=parseFloat(parentScope.cntDebtInfoForm.amount);
                var rebateAmounts2=parseFloat(dialogScope.otherform.rebateAmounts);//现在的
                parentScope.cntDebtInfoForm.amount=amount+rebateAmounts2-rebateAmounts1;
                for (var i = 0; i < dsArray.length; i++) {
                    if (dsArray[i].id == selected.id) {
                        parentScope.bcpDatasource.ds[i]=$common.copy(dialogScope.otherform);
                    }
                }
                parentScope.bcpSelected.select=[];
                dialogScope.closeThisDialog();
            }
        }
    }
    dialogScope.back_onClick = function(){
        dialogScope.closeThisDialog();
    }
};

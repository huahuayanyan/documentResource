/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */

var dsptBillModifyController = function(dialogScope,parentScope,$common,dataDeliver,$state,row) {
    dialogScope.otherform=$common.copy(parentScope.bcpSelected.select[0]);
    dialogScope.disable=true;
    if(!dialogScope.otherform.reason){//如果没有解决方式，直接先赋值一个
        dialogScope.otherform.reason=""
    }
    if(dialogScope.otherform.reason=="04"){//争议解决方式
    	 dialogScope.disable=false;
    }
    //争议解决方式离焦事件
    dialogScope.reasonChange=function(val){
        if(val =="04"){
            dialogScope.disable=false;
        }else{
            dialogScope.otherform.otherReason="";
            dialogScope.otherform.otherWay="";
            dialogScope.disable=true;
        }
    }

    /*dialogScope.money_onBlur=function(val){
        var money=parseFloat(dialogScope.otherform.money);//争议金额
        var remainingAmount=parseFloat(dialogScope.otherform.remainingAmount);//应收账款余额
        //争议金额不能小于等于0
        if(money <= 0){
            $common.get_tipDialog('争议金额不能小于等于0！' , 'showError');
        }
        if(money > remainingAmount){
            $common.get_tipDialog('争议金额必须小于等于应收账款余额！' , 'showError');
        }
    }*/

    //$scope.bcpSelected.select;
    //保存事件
    //这里是商纠解除，所以页面实际上只有一个可以改
   /* dialogScope.save_onClick = function(){
        if($.doValidate("otherform")){
            var money=parseFloat(dialogScope.otherform.money);//争议金额
            var remainingAmount=parseFloat(dialogScope.otherform.remainingAmount);//应收账款余额
            //争议金额不能小于等于0
            if(money <= 0){
                $common.get_tipDialog('争议金额不能小于等于0！' , 'showError');
            }else{
                if(money > remainingAmount){
                    $common.get_tipDialog('争议金额必须小于等于应收账款余额！' , 'showError');
                }else{//实际上只要给页面两个字段
                    parentScope.bcpSelected.select[0].money=money;
                        parentScope.bcpSelected.select[0].issueReason=dialogScope.otherform.issueReason;
                    parentScope.bcpSelected.select=[];
                    dialogScope.closeThisDialog();
                }
            }
        }
    }*/
    dialogScope.save_onClick = function(){
        if($.doValidate("otherform")){
            if(dialogScope.otherform.reason !=""){
                //parentScope.bcpDatasource.ds=[];
                var selected = parentScope.bcpSelected.select[0];
                var dsArray = parentScope.bcpDatasource.ds;

                for (var i = 0; i < dsArray.length; i++) {
                    if (dsArray[i].id == selected.id) {
                        parentScope.bcpDatasource.ds[i]=$common.copy(dialogScope.otherform);
                    }
                }
                parentScope.bcpSelected.select=[];
                dialogScope.closeThisDialog();
            }else{
                $common.get_tipDialog('请选择争议解决方式！','showError');
            }
        }
    }
    dialogScope.back_onClick = function(){
        dialogScope.closeThisDialog();
    }
};

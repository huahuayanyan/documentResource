/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var bicrinfoSubViewController = function(dialogScope,parentScope,dataDeliver,$common,flag) {
    dialogScope.subform= {};
    var bData =dataDeliver.getter();

    //分项额度筛选
    dialogScope.creditTypeContent = {
        type:"table",//展示类型table  tree
        url:"bIcrTypeService/selectBIcrType",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"creditName",
        column:["creditType","creditName"]//展示内容
    };
    dialogScope.creditNamedooextent = function(ds){
        dialogScope.subform.creditType=ds.creditType;
    };
    dialogScope.$watch("otherform.creditName",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        dialogScope.creditTypeContent.param ={
            creditType:dialogScope.subform.creditType,
            creditName:dialogScope.subform.creditName,
            creditClass:"3" //间接额度
        }
    });
    if(flag=="add"){
        dialogScope.subform=bData;
        dialogScope.subform.suitBrcode=bData.suitBrcode;
        dialogScope.subform.suitbrName=bData.suitbrName;
    }else{
        selectInfoOrUp();
    }
    function selectInfoOrUp(){
        var data ={
            creditNo:bData.creditNo
        };
        var promise=$common.get_asyncData("bIcrInfoService/findBIcrInfoOrUpByCreditNo",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                dialogScope.subform=data;
                dialogScope.selectbrNo.ds =data.listBctl;
                dialogScope.subform.brNo=data.brcode;
                dialogScope.brNoDisable =true;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }


    dialogScope.back_onClick = function () {
        dialogScope.closeThisDialog();
    };
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

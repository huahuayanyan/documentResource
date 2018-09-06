/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var AppliCostOutController =  function(dialogScope,parentScope,$common,dataDeliver,$state){
    dialogScope.otherform=$common.copy(parentScope.costDatasource.ds[0]);
    //costAccount 字段因为可能是数据库里面查询出来的为string字段，页面需要number
    /*if(dialogScope.otherform.costAccount){
        dialogScope.otherform.costAccount=parseFloat(dialogScope.otherform.costAccount);
    }*/

    //网点查询
    dialogScope.brnameContent = {
        type:"table",//展示类型table  trees
        url:"bSysAcctBctlService/findBSysAcctBctlByPage",//请求url
        param:{status:"1"},//状态有效
        split:"-",//分隔符*/
        extentColumn:"brname",
        column:["brcode","brname"]//展示内容
    };
    dialogScope.brnameExtent = function(ds){
        dialogScope.otherform.brcode=ds.brcode;
    };
    //监听事件
    dialogScope.$watch("otherform.brname",function(){
        dialogScope.brnameContent.param ={
            status:"1",
            brname:dialogScope.otherform.brname,
        }
    });
    //减免金额离焦事件(减免金额不能大于费用小计)
    dialogScope.reduceAmt_onBlur=function(){
        var totalAmt=parseFloat(dialogScope.otherform.totalAmt);//费用总计
        var reduceAmt=parseFloat(dialogScope.otherform.reduceAmt);//减免金额
        if(reduceAmt >  totalAmt){
            $common.get_tipDialog("减免金额不可大于费用总额！",'showError');
        }else{//实收费用
            dialogScope.otherform.receiveAmount=totalAmt-reduceAmt;
            dialogScope.$apply();
        }
    }
    dialogScope.confirm_onClick=function(){
        if($.doValidate("otherform")){
            //页面对应字段的修改
            parentScope.otherform.totalReduce=dialogScope.otherform.reduceAmt;//减免金额
            parentScope.otherform.receiveAmount=dialogScope.otherform.receiveAmount;//实收费用
            parentScope.costDatasource.ds=[];
            parentScope.costSelected.select=[];//选中的数据清空
            dialogScope.otherform.costAmt=JSON.parse(dialogScope.otherform.costAmt);
            parentScope.costDatasource.ds.push(dialogScope.otherform);
            dialogScope.closeThisDialog();
        }
    }
    dialogScope.back_onClick = function(){
        dialogScope.closeThisDialog();
    }
};

/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var dcrlistcontroller = function(dialogScope,parentScope,dataDeliver,$state,$common,flag){
    dialogScope.otherform = parentScope.otherform;
    console.log("userInfo信息："+JSON.stringify(userInfo));//用户信息，全局变量
  //  dialogScope.userInfo=userInfo;
    dialogScope.conditionForm={};//初始化查询条件对象
    dialogScope.selected={select: []};//初始化对象
    dialogScope.datasource={ds: []};//初始化表格对象
    dialogScope.conf= {
        pageNo: 1,
        pageSize: 10
    };//初始化分页对象
    //监听分页
    dialogScope.$watch("conf.pageNo+conf.pageSize", function () {
        dialogScope.queryTable();
    });
    //搜索查询
    dialogScope.submit_onClick =function(){
        dialogScope.queryTable();
    };
    dialogScope.reset_onClick = function(){      
        dialogScope.$apply(function(){
        	dialogScope.conditionForm = {};
            dialogScope.selected.select=[];//清空选项
        });
    };
    dialogScope.queryTable = function(){
        var data= {
            pageNo: dialogScope.conf.pageNo,
            pageSize: dialogScope.conf.pageSize,
            custId: dialogScope.otherform.custId,
            prdId: dialogScope.otherform.prdmd.loanWay
        };
        var promise = $common.get_asyncData("ibDcrLinInfService/queryCusBDcrLinInf",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                dialogScope.datasource.ds = data.records;
                dialogScope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    dialogScope.choose_onClick = function(){
        dialogScope.flowsubmitdisable = true;
        if(dialogScope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            dialogScope.closeThisDialog();
            dialogScope.row = dialogScope.selected.select[0];
            parentScope.otherform.crNo = dialogScope.row.linId;
            parentScope.otherform.bcCrId = dialogScope.row.bcCrId;
            parentScope.otherform.crdtCustCd = dialogScope.row.custId;
            parentScope.otherform.crdtCustNm = dialogScope.row.custNm;
            //parentScope.otherform.crAmt = dialogScope.row.crAmt;
        };
    }
    dialogScope.close_onClick = function(){
        dialogScope.closeThisDialog();
    };
};
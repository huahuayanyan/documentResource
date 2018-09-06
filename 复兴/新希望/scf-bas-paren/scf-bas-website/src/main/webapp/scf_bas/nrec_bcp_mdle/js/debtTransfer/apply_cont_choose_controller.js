/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var ApplyContChooseController =  function(dialogScope,parentScope,$common,dataDeliver,$state,row){
    dialogScope.otherform = {};
    dialogScope.conditionForm={
        contStatus:"1"
    };//初始化查询条件对象
    dialogScope.datasource={//初始化表格对象
        ds: []
    };
    dialogScope.selected={//初始化对象
        select: []
    };
    dialogScope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //监听分页
    dialogScope.$watch("conf.pageNo+conf.pageSize",function() {
        dialogScope.queryTable();
    });
    //重置
    dialogScope.rebort_onClick =function(){
        dialogScope.$apply(function(){
            $scope.conditionForm = {
                contStatus:"1"
            };
            dialogScope.selected.select=[];//清空选项s
        })
    };
    //搜索查询
    dialogScope.submit_onClick =function(){
        dialogScope.queryTable();
        dialogScope.selected.select=[];
    };

    dialogScope.queryTable = function(paramData){
        var data= {
            pageNo: dialogScope.conf.pageNo,
            pageSize: dialogScope.conf.pageSize,
            bCntBcpInfoVO:dialogScope.conditionForm
        };
        $common.get_asyncData("bcntBcpInfoService/queryBCntBcpInfoByPage",data).then(function(res){
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

    dialogScope.confirm_onClick = function()
    {
        if(dialogScope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
            return;
        }
        dialogScope.otherform = dialogScope.selected.select[0];
        dialogScope.otherform.custcdBuyer = dialogScope.otherform.businessCustcd;
        dialogScope.otherform.cnameSeller = dialogScope.otherform.cname;//卖方名称
        dialogScope.otherform.custcdSaller = dialogScope.otherform.custcd;//卖方客户号
        dialogScope.otherform.cnameBuyer = dialogScope.otherform.businessName;
        dialogScope.otherform.bussType = dialogScope.otherform.supplyChainPdId;
        dialogScope.closeThisDialog();
        var data1= {mastContno:dialogScope.otherform.mastContno};
        dataDeliver.setter(data1);
        $state.go("transferApply");
    };
    dialogScope.close_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

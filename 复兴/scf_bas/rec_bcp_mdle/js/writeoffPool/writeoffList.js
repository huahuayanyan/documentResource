/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      yinyuling
 * @version     1.0
 * Create at:   2016/12/28
 */
var writeoffListController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
	$scope.conditionForm={
        financingType:"2",
        conStatus:"01",//查有效合同
        flag:"01"
    };//初始化查询条件对�???
    $scope.datasource={//初始化表格对�???
        ds:[]
    };
    $scope.selected={//初始化对�???
        select: []
    };
    $scope.conf= {//初始化分页对�???
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //监听分页
   $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick = function(){
        $scope.conditionForm={
            financingType:"2",
            conStatus:"01",//查有效合同
            flag:"01"};
        $scope.selected.select=[];//清空选项s
        $scope.queryTable();
    };
    //搜索
   $scope.submit_onClick =function(){
        $scope.queryTable();
    };
   $scope.queryTable = function(){
       var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            factType:"2",
            mastContQryVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("iRBcpWriteoffService/queryBCntDebtInfoListByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.selected.select=[];
    };


    $scope.writeoffRequest_onClick = function(){

        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('最少选择一行!','showInform');
            return false;
        }else{
            $state.go("writeoffRequest");
            var data=$scope.selected.select[0];
            data.mastContno = data.debtContno;
            data.custcdSaller=data.custcd;//卖方客户号
           //data.custcdBuyer=data.custcdBuyer;//买方客户号
            dataDeliver.setter(data);
        }

    };
    //表格--------结束-------------------------
};

/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var pooldebtdtlController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {


    var getter = dataDeliver.getter();

    console.log(JSON.stringify(getter));

    $scope.pooldebtdtlform = {};

    console.log(JSON.stringify(getter.pooldebtinfo));

    $scope.pooldebtdtlform = getter.pooldebtinfo;

    $scope.dtlBack_onClick = function(){
        $state.go("pooldebtList");
    }


    $scope.queryBcntBuyInfo = function(){
        var data= {
            returnAccount:$scope.dtlconditionForm.repayAccount,
            payDatefrom:$scope.dtlconditionForm.payDatefrom,
            payDateto:$scope.dtlconditionForm.payDateto,
            pageNo:$scope.dtlconf.pageNo,
            pageSize:$scope.dtlconf.pageSize
        };
        var promise = $common.get_asyncData("rBcpDebtReturnAccntQryService/getDebtReturnAccountImpDetail",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.dtldatasource.ds = data.records;
                $scope.dtlconf.totalRecord = data.totalRecord;

            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.dtldatasource.select=[];
    };

    $scope.queryBcntBuyInfoDtl = function(){
        $scope.cntinfoselected.select=[];
    }


    //表格--------结束-------------------------
};

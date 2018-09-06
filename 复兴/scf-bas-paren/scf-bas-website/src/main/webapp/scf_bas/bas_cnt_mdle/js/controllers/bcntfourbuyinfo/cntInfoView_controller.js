/**
 * Created by htrad0055 on 2016/12/7.
 */

var cntInfoViewController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {

    //表格--------结束-------------------------


    $scope.cntInfoViewForm={};

    $scope.mprotdatasource={
        ds:[]
    };

    $scope.mprotselected ={
        select:[]
    };


    $scope.mprotConf={
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };

    var row =dataDeliver.getter();

    $scope.cntInfoViewForm=row;

    $scope.datasource = {
        ds:[]
    };

    $scope.$watch("mprotConf.pageNo+mprotConf.pageSize",function(){$scope.queryMprotTable()});
    $scope.$watch("mprotDatasource.ds+mprotConf.totalRecord",function(){$scope.queryMprotTable()});

    $scope.queryMprotTable = function(paramData){

        var data = {
            pageNo: $scope.mprotConf.pageNo,
            pageSize: $scope.mprotConf.pageSize,
            bCntBuyInfo:$scope.cntInfoViewForm
        };
        var promise = $common.get_asyncData("iBCntMprotInfoService/findBCntMprotInfoVOByPage", data);
        promise.then(
            function (res) {
                if (res.errorCode == "SUC") {
                    //data = res.contextData;
                    $scope.mprotdatasource.ds = res.contextData.records;
                    console.log(JSON.stringify($scope.mprotdatasource.ds ));
                    $scope.mprotConf.totalRecord = res.contextData.totalRecord;

                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            }
        );


    };

    $scope.closeThisDialog_onClick = function(){
        $state.go("bcntBuyInfoList");
    };
};
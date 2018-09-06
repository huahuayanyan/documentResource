/**
 * Created by htrad0036 on 2017/2/21.
 */

//库存押品清单
var mortInfoController = function ($scope, $common, $state, dataDeliver) {

    $scope.datasource = {//初始化表格对象
    };
    $scope.selected = {//初始化对象
        select: []
    };
    $scope.conf = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };

    $scope.$watch("detailForm.supplyChainPdId",function(a, b){
        $scope.queryDetail();
    });

    $scope.queryDetail = function (paramData) {
        //查询明细
        var data = {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            condition :{
            conId : dataDeliver.getter().protocol_value.CON_ID
        }
        };
        var promise = $common.get_asyncData("mortgageChkStockMngService/queryMortInfo", data);
        promise.then(function (res) {
            var data1;
            if (res.errorCode == "SUC") {
                data1 = res.contextData;
                $scope.datasource.ds = data1.records;
                $scope.conf.totalRecord = data1.totalRecord;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    };

};
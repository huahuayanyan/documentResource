/**
 * Created by htrad0036 on 2017/2/21.
 */

//冲正流水查询
var changeMortSokDelController = function ($scope, $common, $state, dataDeliver) {

    $scope.otherform = {
        conId : dataDeliver.getter().data.SLAVE_CONTNO,
        mortgageNo : dataDeliver.getter().data.MORTGAGE_NO
    };//初始化查询条件对象

    //监听分页
    $scope.$watch("$scope.otherform.conId", function () {
        $scope.queryTable();
    });
    //查询操作
    $scope.queryTable = function (paramData) {
        var data = {
            pageNo: 1,
            pageSize: 10,
            //conId: $scope.otherform.conId
            bCrrGntyCon :{
                mortgageNo : $scope.otherform.mortgageNo,
                conId: $scope.otherform.conId
            }
        };
        var promise = $common.get_asyncData("bCntStockAdjustService/getSlaveContcode", data);
        promise.then(function (res) {
            var data1;
            if (res.errorCode == "SUC") {
                data1 = res.contextData;
                var record = data1.records[0];
                angular.extend($scope.otherform, record)
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    };

    //重置按钮
    $scope.back_onClick = function () {
        $state.go("changeMortSok");
    };
};
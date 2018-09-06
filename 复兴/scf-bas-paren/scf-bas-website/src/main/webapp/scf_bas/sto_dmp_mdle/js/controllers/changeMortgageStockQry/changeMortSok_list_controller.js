/**
 * Created by htrad0036 on 2017/2/21.
 */

//冲正流水查询
var changeMortSokController = function ($scope, $common, $state, dataDeliver) {

    $scope.conditionForm = {
    };//初始化查询条件对象
    $scope.datasource = {//初始化表格对象
    };
    $scope.selectSource = {
        ds:[]
    };
    $scope.selected = {//初始化对象
        select: []
    };
    $scope.conf = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize", function () {
        $scope.queryTable();
    });
    //点击查询之后的搜索
    $scope.submit_onClick = function () {
        $scope.queryTable();
        $scope.selected.select = [];
    };
    //查询操作
    $scope.queryTable = function (paramData) {
        var data = {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            conditionForm: $scope.conditionForm
        };
        data.conditionForm.flag = 1;
        var promise = $common.get_asyncData("changeMortStkQryService/queryChangeMortByPage", data);
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

    //查看按钮
    $scope.column = function(row){
        var data= {
            data : row,
        };
        dataDeliver.setter(data);
        $state.go("changeMortSokDel");
    };

    //重置按钮
    $scope.rebort_onClick = function () {
        $scope.$apply(function(){
            $scope.conditionForm = {};
        })
    };
};
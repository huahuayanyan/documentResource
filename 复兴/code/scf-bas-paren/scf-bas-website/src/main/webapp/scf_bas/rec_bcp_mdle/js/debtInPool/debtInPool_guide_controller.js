/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var debtInPoolGuideController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.taskform = {};
    $scope.source = {};
    var appno = window.appNo;
    $scope.datasource={//初始化表格对象
        ds:[]
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    $scope.queryTable = function(paramData)
    {
        $scope.otherform = {appno:appno};
        $common.get_asyncData("rBcpDebtInPoolAccountService/getDebtInPoolBussInfo", {debtBussInfoVO:$scope.otherform}).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.otherform2 = data.records[0];
                $scope.queryTaskForm();
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //获取任务信息
    $scope.queryTaskForm = function(paramData)
    {
        $common.get_asyncData("rBcpDebtInPoolAccountService/findBPbcAppliBaseInfoByAppno", {appno:appno}).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.source.applitask = data;
                $scope.otherform2.inpoolDate = data.startTaskDate;
                $scope.source.otherform = $scope.otherform2;
                $common.get_asyncData("processService/getCurrentNodeEntity", {pid:data.piid}).then(function (res) {
                    var taskform;
                    if (res.errorCode == "SUC") {
                        taskform = res.contextData;
                        $scope.source.taskform = taskform;
                        $state.go("debtinpoolguide");
                        window.source = $scope.source;
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                })
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //表格--------结束-------------------------
};

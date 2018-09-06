/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var backTransferController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();
    $scope.source = {};
    var appno;
    var factType;
    var stateUrl;
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
    $scope.$watch("otherform.mastContno",function(){
        $scope.queryTable();
    });
    $scope.queryTable = function(paramData)
    {
        $common.get_asyncData("factoringDebtBackService/getDebtBussInfo", {debtBussInfoVO:$scope.otherform}).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                if(data.bussType=="1230040"||data.bussType=="1230050"||data.bussType=="1230060"
                    ||data.bussType=="1240050"||data.bussType=="3200")
                {//应收账款池融资  国内保理池   应收账款质押池     出口退税池   票据池      票据池
                    factType = "2";
                    stateUrl = "backtransfer.debtbackpool";
                }
                else
                {//应收账款融资
                    factType = "1";
                    stateUrl = "backtransfer.debtback";
                }
                data.factType = factType;
                $scope.otherform2 = data;
                $scope.queryTaskForm();
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //获取任务信息
    $scope.queryTaskForm = function(paramData)
    {
        $common.get_asyncData("factoringDebtBackService/findRBcpAppliBussInfoByAppno", {appno:appno,factType:factType}).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.taskform = data;
                $scope.otherform2.insertDate = $scope.taskform.startTaskDate;
                $scope.source.otherform = $scope.otherform2;
                if(!data.piid)
                {
                    $scope.source.taskform = {};
                    $scope.baseUrl = stateUrl;
                    $state.go(stateUrl);
                    window.source = $scope.source;
                }
                else
                {
                    $common.get_asyncData("processService/getCurrentNodeEntity", {pid:data.piid}).then(function (res) {
                        var taskform;
                        if (res.errorCode == "SUC") {
                            taskform = res.contextData;
                            $scope.source.taskform = taskform;
                            $scope.baseUrl = stateUrl;
                            $state.go(stateUrl);
                            window.source = $scope.source;
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showInform');
                        }
                    })
                }
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    $scope.back_onClick = function(){
        $state.go("list");
    };
    //表格--------结束-------------------------
};

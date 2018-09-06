/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var transferOutApplyGudieController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    var appno = window.appNo;
    $scope.otherform = {};
    $scope.source = {};
    $scope.source.gntyform = $scope.otherform;
    //监听分页
    $scope.$watch("",function(){
        $scope.queryTaskForm();
    });
    //获取任务信息
    $scope.queryTaskForm = function(paramData)
    {
        $common.get_asyncData("maximumBailTransferOutApplyService/findBPbcAppliBaseInfoByAppno", {appno:appno}).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.taskform = data;
                var conId = data.businessno;
                $common.get_asyncData("maximumBailTransferOutApplyService/findBCrrGntyConByConId",{conId:conId}).then(function (res) {
                    var gntycon;
                    if (res.errorCode =="SUC"){
                        gntycon = res.contextData;
                        gntycon.appno = appno;
                        $scope.source.gntyform = gntycon;
                        $scope.otherform = gntycon;
                        if(!data.piid)
                        {
                            $scope.source.taskform = {};
                            $scope.queryTable();
                        }
                        else
                        {
                            $common.get_asyncData("processService/getCurrentNodeEntity", {pid:data.piid}).then(function (res) {
                                var taskform;
                                if (res.errorCode == "SUC") {
                                    taskform = res.contextData;
                                    $scope.source.taskform = taskform;
                                    $scope.queryTable();
                                } else {
                                    $common.get_tipDialog(res.errorMsg, 'showInform');
                                }
                            })
                        }
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                })
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    $scope.queryTable = function(paramData)
    {
        var data =
        {
            bCrrGntyConVO:$scope.otherform
        }
        $common.get_asyncData("maximumBailTransferApplyService/BailAccountBaseInfoGetter",data).then(function (res) {
            var data;
            var transferform;
            if (res.errorCode =="SUC"){
                transferform = res.contextData;
                var transfer = transferform.records[0];
                $scope.source.transferform = transfer;
                $state.go("transferOutApply");
                window.source = $scope.source;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //表格--------结束-------------------------
};

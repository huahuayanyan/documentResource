/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var transferOutApplyController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();
    $scope.source = {};
    $scope.source.gntyform = $scope.otherform;
    var appno;
    //监听分页
    $scope.$watch("otherform.mastContno",function(){
        $scope.queryTable();
    });
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
                $scope.queryTaskForm();
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //获取任务信息
    $scope.queryTaskForm = function(paramData)
    {
        $common.get_asyncData("maximumBailTransferOutApplyService/findBPbcAppliBaseInfoByAppno", {appno:appno}).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.taskform = data;
                if(!data.piid)
                {
                    $scope.source.taskform = {};
                    $state.go("transferOutApply.edit");
                    window.source = $scope.source;
                }
                else
                {
                    $common.get_asyncData("processService/getCurrentNodeEntity", {pid:data.piid}).then(function (res) {
                        var taskform;
                        if (res.errorCode == "SUC") {
                            taskform = res.contextData;
                            $scope.source.taskform = taskform;
                            $state.go("transferOutApply.edit");
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

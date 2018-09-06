/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var deliveryApplyGuideController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    var appno = window.appNo;
    $scope.source = {};
    $scope.baseinfo = {};
    $scope.baseinfo.appno = appno;
    $scope.taskform = {};
    //监听分页
    $scope.$watch("baseinfo.appno",function(){
        $scope.queryBaseInfo();
    });
    $scope.queryBaseInfo = function(paramData)
    {
        var data = {
            gntyConVO:$scope.baseinfo
        }
        $common.get_asyncData("staticDeliveryApplyService/DeliveryApplyQryGetter", data).then(function (res) {
            var baseinfo;
            if (res.errorCode == "SUC") {
                baseinfo = res.contextData;
                $scope.baseinfo = baseinfo.records[0];
                $scope.source.baseinfo = $scope.baseinfo;
                $scope.queryTaskForm();
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //获取任务信息
    $scope.queryTaskForm = function(paramData)
    {
        $common.get_asyncData("staticDeliveryApplyService/findRBcpAppliBussInfoByAppno", {appno:appno}).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.taskform = data;
                if(!data.piid)
                {
                    $scope.source.taskform = {};
                    $state.go("staticDeliveryapply");
                    window.source = $scope.source;
                    window.Write = false;
                }
                else
                {
                    $common.get_asyncData("processService/getCurrentNodeEntity", {pid:data.piid}).then(function (res) {
                        var taskform;
                        if (res.errorCode == "SUC") {
                            taskform = res.contextData;
                            $scope.source.taskform = taskform;
                            $state.go("staticDeliveryapply");
                            window.source = $scope.source;
                            if(taskform.id == "Write")
                            {//填写岗
                                window.Write = false;
                            }
                            else if(taskform.id == "Issued")
                            {//复核岗
                                window.Issued = false;
                                window.Notice = false;
                            }
                            else if(taskform.id == "Receipt")
                            {//回执
                                window.Receipt = false;
                                window.Notice = false;
                            }
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
    //表格--------结束-------------------------
};

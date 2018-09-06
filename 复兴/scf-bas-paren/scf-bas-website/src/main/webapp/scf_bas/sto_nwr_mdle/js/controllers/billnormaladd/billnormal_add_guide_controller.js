/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var billNormalAddGuideController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel)
{
    var appno = window.appNo;
    $scope.source = {};
    $scope.baseinfo = {};
    $scope.baseinfo.appno = appno;
    //监听分页
    $scope.$watch("baseinfo.appno",function(){
        $scope.queryBillNormal();
    });
    $scope.queryBillNormal = function(paramData)
    {
        var data = {
            bussInfoVO:$scope.baseinfo
        }
        $common.get_asyncData("billNormalPledgeMngService/BillStandardBussInfoGetter", data).then(function (res) {
            var baseinfo;
            if (res.errorCode == "SUC") {
                baseinfo = res.contextData;
                $scope.baseinfo = baseinfo;
                $scope.source.baseinfo = baseinfo;
                $scope.queryTaskForm();
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //获取任务信息
    $scope.queryTaskForm = function(paramData)
    {
        $common.get_asyncData("billNormalAddService/findRBcpAppliBussInfoByAppno", {appno:appno}).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.taskform = data;
                if(!data.piid)
                {
                    $scope.source.taskform = {};
                    $state.go("billnormaladdapply");
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
                            $state.go("billnormaladdapply");
                            window.source = $scope.source;
                            if(taskform.id == "Write")
                            {//普通仓单追加填写岗
                                window.Write = false;
                            }
                            else if(taskform.id == "Check")
                            {//普通仓单追加核价岗
                                window.Check = false;
                                window.BackToModify = false;
                            }
                            else if(taskform.id == "Review")
                            {//普通仓单追加审核
                                window.Review = false;
                                window.BackToModify = false;
                            }
                            else if(taskform.id == "Receipt")
                            {//普通仓单追加监管商回执
                                window.Receipt = false;
                                window.BackToModify = false;
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

/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var mngExcgController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.baseinfo = dataDeliver.getter();
    $scope.source = {};
    $scope.source.baseinfo = $scope.baseinfo;
    var appno;
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
    $scope.$watch("conf.pageNo",function(){
        $scope.queryTaskForm();
    });
    //获取任务信息
    $scope.queryTaskForm = function(paramData)
    {
        $common.get_asyncData("billNormalMngExcgService/findRBcpAppliBussInfoByAppno", {appno:appno}).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.taskform = data;
                if(!data.piid)
                {
                    $scope.source.taskform = {};
                    window.source = $scope.source;
                    window.Write = false;
                    $scope.Write = window.Write;
                }
                else
                {
                    $common.get_asyncData("processService/getCurrentNodeEntity", {pid:data.piid}).then(function (res) {
                        var taskform;
                        if (res.errorCode == "SUC") {
                            taskform = res.contextData;
                            $scope.source.taskform = taskform;
                            window.source = $scope.source;
                            if(taskform.id == "Write")
                            {//填写岗
                                window.Write = false;
                            }
                            else if(taskform.id == "Pricing")
                            {//核价岗
                                window.Check = false;
                                window.BackToModify = false;
                            }
                            else if(taskform.id == "Review")
                            {//复核岗
                                window.Review = false;
                                window.BackToModify = false;
                            }
                            else if(taskform.id == "Confirm")
                            {//回执
                                window.Confirm = false;
                                window.BackToModify = false;
                            }
                            $scope.Write = window.Write;
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showInform');
                        }
                    })
                }
                $scope.Write = window.Write;
                $scope.Check = window.Check;
                $scope.Review = window.Review;
                $scope.Confirm = window.Confirm;
                $scope.BackToModify = window.BackToModify;
                $state.go("mngexcftask.applyin");
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    $scope.back_onClick = function(){
        $state.go("list");
    };

    //填写岗提交
    $scope.submit_onClick = function()
    {
        var inVal = Number(window.source.baseinfo.receiptPledgeAmount);//换入仓单总价值
        var outVal = Number(window.source.baseinfo.removePledgeAmount);//换出仓单总价值
        if(inVal<outVal){
            $common.get_tipDialog('换入仓单总价值不能小于换出仓单总价值！','showInform');
            return;
        }
        $scope.WriteDisable = true;
        var data = {
           appno:window.source.baseinfo.appno
        };
        $common.get_asyncData("billNormalMngExcgService/BillNorExchangAppSubmitUpdate",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("操作完成",'showSuccess');
                $state.go("list");
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.WriteDisable = false;
            }
        });
    };
    //表格--------结束-------------------------
};

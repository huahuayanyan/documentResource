/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */
var fourDeliveryAppController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();
    var appno = $scope.otherform.appno;
    var process="One2OneFourDeliveryApply";// 先票款后货提货申请（一一对应）
    queryTaskInfo();//任务信息
    //获取任务信息
    function queryTaskInfo(){
        var data = {
            appno:appno,
            process:process
        };
        $common.get_asyncData("iScfWorkFlowService/findBPbcAppliBaseInfoByAppno",data).then(function (res) {
            var task;
            if (res.errorCode == "SUC") {
                task = res.contextData;
                $scope.taskform = task;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    }

    $state.go("fourDeliveryApp.dtl");
    dataDeliver.setter($scope.otherform);
    //表格--------结束-------------------------
};

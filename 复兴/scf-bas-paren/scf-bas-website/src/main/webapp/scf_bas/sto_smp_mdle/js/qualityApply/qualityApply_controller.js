/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var fourPledgeApplyController = function($scope,$common,$state,dataDeliver) {
    $scope.otherform = dataDeliver.getter();
    var appno = $scope.otherform.appno;
    var process="StaticQualityApply";//现货静态
    queryTaskInfo();//任务信息
    //获取任务信息
    function queryTaskInfo(){
        var data = {
            appno:appno,
            process:process
        };
        $common.get_asyncData("iScfWorkFlowService/findBPbcAppliBaseInfoByAppno",data).then(function (res) {
            if (res.errorCode == "SUC") {
                $scope.taskform = res.contextData;
                dataDeliver.setter($scope.otherform);
                $state.go("fourPledgeApply.dtl");
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    }
};
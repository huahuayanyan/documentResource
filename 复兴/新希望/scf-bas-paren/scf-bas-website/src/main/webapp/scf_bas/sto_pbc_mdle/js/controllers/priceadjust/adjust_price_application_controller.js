/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      gongzhao
 * @version     1.0
 * Create at:   2017/05/03
 */

var adjustPriceApplicationController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    $scope.otherform=dataDeliver.getter();
    var appno = $scope.otherform.appno;
    var process = "AdjustPriceApply";//价格调整申请
    queryTaskInfo();//任务信息
    //获取任务信息
    function queryTaskInfo(){
    	var data = {
    			appno:appno,
    			process:process
    	}
        $common.get_asyncData("iScfWorkFlowService/findBPbcAppliBaseInfoByAppno",data).then(function (res) {
        	var task;
        	if (res.errorCode == "SUC"){
        		task = res.contextData;
        		$scope.taskform = task;
        	} else {
        		$common.get_tipDialog(res.errorMsg, 'showInform');
        	}
        });
    }
    var datas = $scope.otherform;
    datas.custcd = $scope.otherform.gutId;//客户号
    datas.protocolNo = $scope.otherform.prtclNo;//监管合同号
	$scope.source={otherform:datas};
	 window.source=$scope.source;
    $state.go("adjustPriceApplication.adjustPrice");
   /* dataDeliver.setter($scope.otherform);*/
};

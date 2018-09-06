/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var bsysTaskTabController = function($scope,$common,$state,$stateParams,dataDeliver,$eventCommunicationChannel) {
	console.log("$stateParams"+JSON.stringify($stateParams));

	$scope.back_onClick =function(){
		//返回到待办任务列表页面
		$state.go("bsystask");
	};
	pageUrl=$stateParams.pageUrl;
	window.appNo=$stateParams.appNo;
	window.processId = $stateParams.processId;
	window.modelId = $stateParams.modelId;
	window.taskId = $stateParams.taskId;
	//控制字段只读
	window.viewdisable=true;
	//控制按钮隐藏
	window.viewhide=true;
	$scope.tabUrl1=pageUrl;
	//默认通用审批意见
	$scope.tabUrl2="bsystasktab.commentview";
	//默认打开任务详情页面
	$state.go(pageUrl);
	var data = {
		appNo:window.appNo,
		processId:window.processId,
		modelId:window.modelId,
		taskId:window.taskId
	}
	dataDeliver.setter(data);

};

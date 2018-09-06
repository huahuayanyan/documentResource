/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2016/4/21
 */

var repayBillNormalGuideController = function($scope,$common,$state,dataDeliver) {
	$scope.taskform = {};
	$scope.otherform = {};
	$scope.source = {};
	var appno = window.appNo;
	$scope.baseurl = "";
	//监听分页
	$scope.$watch("appno",function(){
		$scope.queryTaskForm();
	});
	//获取任务信息
	$scope.queryTaskForm = function(paramData)
	{
		$common.get_asyncData("billNormalLoanApplyService/findRBcpAppliBussInfoByAppno", {appno:appno}).then(function (res) {
			var data;
			if (res.errorCode == "SUC") {
				data = res.contextData;
				$scope.taskform = data;
				if(!data.piid)
				{
					$scope.source.taskform = {};
					window.source = $scope.source;
					$scope.queryBaseForm();
				}
				else
				{
					$common.get_asyncData("processService/getCurrentNodeEntity", {pid:data.piid}).then(function (res) {
						var taskform;
						if (res.errorCode == "SUC") {
							taskform = res.contextData;
							$scope.source.taskform = taskform;
							$scope.queryBaseForm();
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

	//获取详情页基本信息
	$scope.queryBaseForm = function(paramData)
	{
		var debtCommonQryVO ={
			appno:appno
		};
		var data ={
			billCommonQryVO:debtCommonQryVO
		};
		var promise = $common.get_asyncData("billNormalLoanApplyService/BillNormalLoanApplyBaseInfoGetter",data);
		promise.then(function (res) {
			var data;
			if (res.errorCode == "SUC") {
				data = res.contextData;
				$scope.otherform = data; //信贷合同号 保证金列表页面需要这个参数
				$scope.otherform.appId = $scope.otherform.mastContno;
				if(window.modelId)
				{
					$state.go("repaydetail");
				}
				else
				{
					debugger;
					var loanWay = data.loanWay;
					var baseurl = "";
					if(loanWay=="01")
					{
						baseurl = "billnormal.cashdetail";
					}
					else if(loanWay=="02")
					{
						baseurl = "billnormal.billdetail";
					}
					$scope.baseurl = baseurl;
					$state.go(baseurl);
				}
				$scope.source.otherform = $scope.otherform;
				window.source = $scope.source;
				dataDeliver.setter($scope.otherform);
			} else {
				$common.get_tipDialog(res.errorMsg, 'showError');
			}
		});
	};

	$scope.back_onClick = function()
	{
		$state.go("list");
	}
};

/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2016/4/21
 */

var repayFourWareController = function($scope,$common,$state,dataDeliver) {
	$scope.taskform = {};
	$scope.otherform = {};
	var pid = window.parent.processId;
	var modelid = window.parent.modelId;
	var appno = window.parent.appNo;
	var flag = window.parent.flag;
	if(flag =='view'){
		$scope.hidddd = false;
	}else{
		$scope.hidddd = true;
	}
	var flowData;
	//获取当前节点信息
	var promise = $common.get_asyncData("processService/getCurrentNodeEntity",{pid:pid});
	promise.then(function(res){
		if (res.errorCode =="SUC"){
			flowData = res.contextData;
			var seq = parseFloat(flowData.seq);
			/**获取放款基本信息*/
			var id = window.parent.appNo;
			var promise = $common.get_asyncData("bPbcAppliBaseInfoService/findBPbcAppliBaseInfoByKey", {key: id});
			promise.then(function (res){
				var taskData;
				if(res.errorCode == 'SUC'){
					taskData = res.contextData;
					if(!taskData){
						$common.get_tipDialog('流程信息数据丢失','showInform');
						return;
					}
					$scope.taskform = taskData;
					var bCrmBrInfo={
						brNo:userInfo.brNo
					};
					var promiseA = $common.get_asyncData("bCrmBaseInfoService/findBCrmBrInfo",{bCrmBrInfo:bCrmBrInfo});
					promiseA.then(function (res){
						if(res.errorCode == 'SUC'){
							$scope.taskform.appTlrcd = userInfo.tlrName;
							$scope.taskform.approveBrcode = res.contextData.brName;
						}else{
							$common.get_tipDialog(res.errorMsg, 'showError');
						}
					})
				} else {
					$common.get_tipDialog(res.errorMsg, 'showError');
				}
			});
			var debtCommonQryVO ={
				appno:id
			};
			var data ={
				debtCommonQryVO:debtCommonQryVO
			};
			var promise = $common.get_asyncData("bLanLoanApplyService/getMortgageLoanApplyInfo",data);
			promise.then(function (res) {
				var data;
				if (res.errorCode == "SUC") {
					data = res.contextData;
					$scope.otherform = data;
					$scope.otherform.appId=data.mastContcode; //信贷合同号 保证金列表页面需要这个参数
					var loanWay = data.loanWay; //出账方式
					var baseparam;
					// TODO
							if(loanWay=="02") {//银承
								if(seq>=1){
									baseparam = "repayFourWare";

								}
							} else {//--流贷  信用证
								if(seq>=1){
									baseparam = "XXX";
									/*$("#cc").show();
									$("#bb").remove();
									$("#dd").remove();
									$("#ee").remove();*/
								}
							}
							$scope.baseparam = baseparam;
							$state.go(baseparam);
							$scope.otherform.taskform = $scope.taskform;
							$scope.otherform.flag = flag;
							dataDeliver.setter($scope.otherform);
						/*}else{
							$common.get_tipDialog(res.errorMsg,'showError');
						};*/
					//});
				} else {
					$common.get_tipDialog(res.errorMsg, 'showError');
				}
			});
			/*$state.go("repaybase");
			dataDeliver.setter($scope.taskform);*/
		}else{
			$common.get_tipDialog(res.errorMsg,'showError');
		}
	});

	$scope.goback_onClick =function(){
		$state.go("invoiceFinancingApply");
	}
};

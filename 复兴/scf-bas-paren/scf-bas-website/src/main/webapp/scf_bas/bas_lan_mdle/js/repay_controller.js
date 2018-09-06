/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2016/4/21
 */

var repayController = function($scope,$common,$state,dataDeliver) {
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
					}
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
			var promise = $common.get_asyncData("bLanRepayDetailService/findBLanRepayDetailById", {id: id});
			promise.then(function (res) {
				var data;
				if (res.errorCode == "SUC") {
					data = res.contextData;
					if(!data||!data.appId){
						$common.get_tipDialog('出账申请数据丢失','showInform');
						return;
					}
					$scope.otherform = data;
					$scope.otherform.relaId = id;
					/*var appId = $scope.otherform.appId;
					$common.get_asyncData('bCrrLnConService/findBCrrLnConByAppId',{appId:appId}).then(function(res){*/
						//if (res.errorCode =="SUC"){
							//$scope.otherform.lncon = res.contextData;
							$scope.otherform.debtContno = data.vidNo;
							prdId = data.prdId;
							var bigProductId = data.bigProductId;
							var vidBusTyp = data.vidBusTyp;
							var baseparam;
							if(prdId=="003") {//信用证
								baseparam = "repaybaselc";
								$("#bb").remove();
								$("#cc").remove();
								$("#dd").remove();
								$("#ee").remove();
							} else if(prdId=="004") {//银承
								if(seq>=1){
									baseparam = "repayyc";
									$("#bb").show();
									$("#cc").remove();
									$("#dd").remove();
									$("#ee").remove();
								}
							} else {//--流贷
								if(seq>=1&&bigProductId=="3000"&&(vidBusTyp=="1230010"||vidBusTyp=="1230020"||vidBusTyp=="1230030")){//应收-国内保理,反向保理，应收账款质押
									baseparam = "repayyszk";
									$("#cc").show();
									$("#bb").remove();
									$("#dd").remove();
									$("#ee").remove();
								}else if(seq>=1&&bigProductId=="3000"&&(vidBusTyp=="1230040"||vidBusTyp=="1230050"||vidBusTyp=="1230060")){//国内保理池,应收账款质押池，出口退税池
									baseparam = "repaygnblc";
									$("#cc").remove();
									$("#bb").remove();
									$("#dd").remove();
									$("#ee").show();
								}else if(seq>=1&&bigProductId=="1000"){//存货/现货-现货动态质押
									baseparam = "repayxhdy";
									$("#cc").remove();
									$("#bb").remove();
									$("#ee").remove();
									$("#dd").show();
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

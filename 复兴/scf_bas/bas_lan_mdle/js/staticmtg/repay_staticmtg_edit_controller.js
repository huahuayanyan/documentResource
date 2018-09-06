/**
 * @author 	liph
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var repayStaticMtgEditController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
	$scope.source = window.source;
	$scope.otherform = $scope.source.otherform;
	$scope.taskform = $scope.source.taskform;
	$scope.hidedj = window.hide;
	if(!$scope.taskform||!$scope.taskform.id)
	{
		$scope.hide = true;
		$("#showIdea").css('display','none');
	}
	else
	{
		$("#showIdea").css('display','');
		$scope.hide = true;
		if($scope.taskform.id == "duebilladd")
		{
			$scope.hide = false;
			$scope.disablesubmit = true;
		}
		else
		{
			$scope.disable = true;
		}
	}
	if(!$scope.otherform.graceDays)
	{
		$scope.otherform.graceDays = 0;
	}
	var riskAmt = Number($scope.otherform.riskAmt);
	if(riskAmt<0)
	{
		$scope.otherform.riskAmt = 0.00;
	}
	if($scope.otherform.rateType)
	{
		checkInt($scope.otherform.rateType);
	}
	var processId = window.processId;//流程点

	$scope.applyDtlForm = {};
	$scope.datasourcetask={//初始化表格对象
		ds:[
		]
	};
	$scope.selectedtask={//初始化对象
		select: []
	};
	$scope.conftask= {//初始化分页对象
		pageNo: 1,
		pageSize: 10,
		totalRecord: 0
	};

	$scope.applyDtlForm={
		taskComment:''
	}
	var flag = window.flag;
	if(flag=="view")
	{
		$scope.disable = true;
		$scope.hide = true;
	}
	//监听分页
	$scope.$watch("conftask.pageNo+conftask.pageSize",function(){
		$scope.queryTabletask();
	});

	//查询
	$scope.queryTabletask = function(){
		var data= {
			processId:processId,
			pageNo: $scope.conftask.pageNo,
			pageSize: $scope.conftask.pageSize
		};
		var promise = $common.get_asyncData("taskService/getDoneTask",data);
		promise.then(function(res){
			var data;
			if (res.errorCode =="SUC"){
				data = res.contextData;
				$scope.datasourcetask.ds = data.records;
				$scope.conftask.totalRecord = data.totalRecord;
			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		});
	};

	/**现金等价物改变同时修改其本笔风险敞口*/
	//$scope.initCashEqtAmt_onBlur = function()
	//{
	//	var initCashEqtAmt = Number($scope.otherform.initCashEqtAmt);
	//	var number;
	//	if(initCashEqtAmt>riskAmt)
	//	{
	//		number = 0.00;
	//	}
	//	else
	//	{
	//		number = riskAmt - initCashEqtAmt;
	//	}
	//	$scope.$apply(
	//		$scope.otherform.riskAmt = number
	//	)
	//};
	/**
	 * 根据利率代码获取利率信息
	 * @param val
	 */
	function checkInt(val)
	{
		if(val!=null&&val!=""&&val!=undefined)
		{
			var intId = val;
			$common.get_asyncData('bSysLnCdService/findBSysLnCdByRatecode',{ratecode:intId}).then(function(res){
				var data;
				if (res.errorCode =="SUC"){
					data = res.contextData;
					$scope.otherform.rateTypeNm = data.ratecode+"-"+data.ratename;
				}else{
					$common.get_tipDialog(res.errorMsg,'showError');
				};
			});
		}
	}

	//供应链补录保存
	$scope.confirm_onClick = function()
	{
		if($.doValidate("otherform")) {
			var avaliableRiskAmt = Number($scope.otherform.avaliableRiskAmt);
			var cycle = Number($scope.otherform.cycle);    //循环合同
			if(cycle=="1")
			{
				if(avaliableRiskAmt <=0)
				{
					$common.get_tipDialog("信贷合同可用敞口必须大于0,才能进行放款！", 'showError');
					return;
				}
			}
			$common.get_asyncData('mtgLoanApplyService/MortgageLoanApplySaveUpdate',{mortgageLnciBaseInfoVO:$scope.otherform}).then(function(res){
				if (res.errorCode =="SUC"){
					$common.get_tipDialog('保存成功！','showSuccess');
					$scope.disablesubmit = false;
				}else{
					$common.get_tipDialog(res.errorMsg,'showError');
				};
			});
		}
	};

	//供应链补录提交
	$scope.submit_onClick = function()
	{
		if($.doValidate("otherform")) {
			var avaliableRiskAmt = Number($scope.otherform.avaliableRiskAmt);
			var cycle = Number($scope.otherform.cycle);    //循环合同
			if(cycle=="1")
			{
				if(avaliableRiskAmt <=0)
				{
					$common.get_tipDialog("信贷合同可用敞口必须大于0,才能进行放款！", 'showError');
					return false;
				}
			}
			$scope.otherform.taskComment = $scope.applyDtlForm.taskComment;
			$common.get_asyncData('mtgLoanApplyService/MortgageLoanApplyWriteSubmitUpdater',{mortgageLnciBaseInfoVO:$scope.otherform}).then(function(res){
				if (res.errorCode =="SUC"){
					$common.get_tipDialog('提交成功！','showSuccess');
					$scope.hide = true;
					$scope.queryTabletask();
				}else{
					$common.get_tipDialog(res.errorMsg,'showError');
				};
			});
		}
	};

	//供应链补录退回
	$scope.refuser_onClick = function()
	{
		if($.doValidate("otherform")) {
			$scope.otherform.comment = $scope.applyDtlForm.taskComment;
			$common.get_asyncData('mtgLoanApplyService/LoanApplyBackSubmitUpdater',{applyDtlInfoVO:$scope.otherform}).then(function(res){
				if (res.errorCode =="SUC"){
					$common.get_tipDialog('已退回首节点！','showSuccess');
					$scope.hide = true;
					$scope.queryTabletask();
				}else{
					$common.get_tipDialog(res.errorMsg,'showError');
				};
			});
		}
	};
};

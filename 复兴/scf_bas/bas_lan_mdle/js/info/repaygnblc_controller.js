/**
 * @author 	liph
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var gnblcController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
	$scope.firstform=dataDeliver.getter();//定义form对象
	$scope.otherform = $scope.firstform;
	$scope.otherform.oldPoolUseableAmount = $scope.otherform.poolUseableAmount;
	var oldPoolUseableAmount = $scope.otherform.oldPoolUseableAmount;//可融资金额
	//可融资金额：可融资金额（池）=可融资金额(TBL_DEBT_POOL的POOL_USEABLE_AMOUNT)+池保证金余额-池敞口余额
	getPooluserableamount();
	function getPooluserableamount()
	{
		var newamount = 0;//经计算得到的可融资金额
		var totalBailAmount = Number($scope.otherform.totalBailAmount);//池保证金余额
		var poolRiskAmt = Number($scope.otherform.poolRiskAmt);//池敞口余额
		if(!totalBailAmount)
		{
			newamount = oldPoolUseableAmount - poolRiskAmt;
		}
		else
		{
			newamount = oldPoolUseableAmount + totalBailAmount - poolRiskAmt;
		}
		$scope.otherform.poolUseableAmount = newamount;
	}
	var bbfxck = Number($scope.otherform.bbfxck);
	if(bbfxck<0)
	{
		$scope.otherform.bbfxck = 0.00;
	}
	$scope.datasource={//初始化表格对象
		ds: []
	};
	$scope.selected={//初始化对象
		select: []
	};
	$scope.conf= {//初始化分页对象
		pageNo: 1,
		pageSize: 10,
		totalRecord: 0}
	var seq;//流程节点顺序
	var flowdata;
	var flagg = $scope.otherform.flag;
	var processId = window.processId;//流程点
	var modelId = window.modelId;//模版
	var iddd = window.appNo;
	var prdid = $scope.otherform.prdId;

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

	var promise = $common.get_asyncData("processService/getCurrentNodeEntity", {pid: processId});
	promise.then(function (res) {
		if (res.errorCode == "SUC") {
			$scope.sumbitdisable= true;
			flowdata = res.contextData;
			seq = parseFloat(flowdata.seq);
			if (seq == 2 && modelId == 'BCrrDuebillApp') {
				$scope.hidd = false;
				$scope.disable = false;
			}else if(seq ==3 && (modelId =='BCrrDuebillApp'||modelId =='FinancingPoolApply')){
				$scope.hidd = true;
				$scope.disable = true;
			}
			if(flagg == 'view'){
				$scope.hidd = true;
				$scope.disable = true;
				//详情页面审批意见显示
				$("#showIdea").css('display','');
			}
		} else {
			$common.get_tipDialog(res.errorMsg, 'showError');
		}
	});

	//流贷--国内保理池--供应链补录保存
	$scope.gnblcconfirm_onClick = function() {
		//应收账款页面数值传递--otherform--datasource
		if($.doValidate("otherform")) {
			var bcrrDuebillDetail = $scope.otherform;
			var data = {
				bcrrDuebillDetail: bcrrDuebillDetail
			};
			var primise = $common.get_asyncData("bLanRepaySaveService/flowCreditSave", data);
			primise.then(function (res) {
				if (res.errorCode == "SUC") {
					$common.get_tipDialog('保存成功！', 'showSuccess');
					$scope.sumbitdisable= false;
				} else {
					$common.get_tipDialog('保存失败!' + res.errorMsg, 'showError');
				}
				;
			})
		}
	}
	//国内保理池-供应链提交-自定义
	$scope.gnblcbltj_onClick = function(){
		var comment = $scope.applyDtlForm.taskComment;
		if(comment!=null&&comment!=undefined)
		{
			var realLen = 0;
			var len = comment.length;
			var charCode = -1;
			for(var i=0;i<len;i++)
			{
				charCode = comment.charCodeAt(i);
				if(charCode>=0&&charCode<=128)
				{
					realLen += 1;
				}
				else
				{
					realLen += 3;
				}
			}
			if(realLen>255)
			{
				$common.get_tipDialog('“审批意见”长度超过限值，请重新输入……','showError');
				return;
			}
		}
		$scope.sumbitdisable = true;
		$scope.savedisable = true;
		var bcrrduebilldetail = $scope.otherform;
		bcrrduebilldetail.taskComment = $scope.applyDtlForm.taskComment;
		var primise = $common.get_asyncData('bLanRepaySubmitService/flowCreditSubmit',{appno:iddd,bcrrduebilldetail:bcrrduebilldetail});
		primise.then(function (res) {
			if (res.errorCode == "SUC") {
				$common.get_tipDialog('提交成功！', 'showSuccess');
			} else {
				$common.get_tipDialog(res.errorMsg, 'showError');
			}
		});
	}
	/**查询核心按钮触发事件*/
	$scope.queryacctamt_onClick = function(){
		var data = {
			txnCode:"s033",
			bailAccountno:''
		}
		promise = $common.get_asyncData("interfaceButtonQueryService/InterfaceButtonQuery",{extInterface:data}).then(function(res){
			var data;
			if (res.errorCode =="SUC"){
				data = res.contextData;
				$scope.otherform.totalBailAmount = data.records[0].accountBalance*10;
				//可融资金额：可融资金额（池）=可融资金额(TBL_DEBT_POOL的POOL_USEABLE_AMOUNT)+池保证金余额-池敞口余额
				getPooluserableamount();
			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		});
	}
	/**修改初始现金等价物金额-本笔风险敞口随之改变*/
	$scope.csxjdjwbl_onBlur = function(){
		var csxjdjw = Number($scope.otherform.csxjdjwbl);
		var number;
		if(csxjdjw>bbfxck)
		{
			number = 0.00;
		}
		else
		{
			number = bbfxck - csxjdjw;
		}
		$scope.$apply(
			$scope.otherform.bbfxck = number
		)
	}
};

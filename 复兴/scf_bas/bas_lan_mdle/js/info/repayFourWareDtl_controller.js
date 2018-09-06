/**
 * @author 	liph
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var repayFourWareDtlController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
	$scope.firstform = dataDeliver.getter();//定义form对象

	$scope.otherform = $scope.firstform;

	$scope.datasource = {//初始化表格对象
		ds: []
	};
	$scope.selected = {//初始化对象
		select: []
	};
	$scope.conf = {//初始化分页对象
		pageNo: 1,
		pageSize: 10,
		totalRecord: 0
	};

	var seq;//流程节点顺序
	var flagg = $scope.otherform.flag;
	var flowdata;
	var processId = window.processId;//流程点
	var modelId = window.modelId;//模版
	var iddd = window.appNo;
	var prdid = $scope.otherform.prdId;
	//-----间接额度判断----
	var hasIndirectCredit = $scope.otherform.hasIndirectCredit;
	if (hasIndirectCredit == "0") {
		$scope.hidehide = true;
	} else {
		$scope.hidehide = false;
	}

	$scope.applyDtlForm = {};
	$scope.datasourcetask = {//初始化表格对象
		ds: []
	};
	$scope.selectedtask = {//初始化对象
		select: []
	};
	$scope.conftask = {//初始化分页对象
		pageNo: 1,
		pageSize: 10,
		totalRecord: 0
	};

	$scope.applyDtlForm = {
		taskComment: ''
	};
	$scope.productSource = {
		ds: []
	}; //业务品种

	/**
	 * 业务品种
	 */
	var productPar = {
		pageNo: '1',
		pageSize: '999999',
		bPrdInfo: {/*parentId:'2100'*/}
	};
	var promise = $common.get_asyncData("bPrdInfoService/findPrdInfoByPage", productPar);
	promise.then(function (res) {
		var data;
		if (res.errorCode == "SUC") {
			data = res.contextData;
			$scope.productSource.ds = data.records;
		} else {
			$common.get_tipDialog(res.errorMsg, 'showError');
		}
	});

	//监听分页
	$scope.$watch("conftask.pageNo+conftask.pageSize", function () {
		$scope.queryTabletask();
	});

	//查询
	$scope.queryTabletask = function () {
		var data = {
			processId: processId,
			pageNo: $scope.conftask.pageNo,
			pageSize: $scope.conftask.pageSize
		};
		var promise = $common.get_asyncData("taskService/getDoneTask", data);
		promise.then(function (res) {
			var data;
			if (res.errorCode == "SUC") {
				data = res.contextData;
				$scope.datasourcetask.ds = data.records;
				$scope.conftask.totalRecord = data.totalRecord;
			} else {
				$common.get_tipDialog(res.errorMsg, 'showError');
			}
		});
	};


	var promise = $common.get_asyncData("processService/getCurrentNodeEntity", {pid: processId});
	promise.then(function (res) {
		if (res.errorCode == "SUC") {
			$scope.sumbitdisable = true;
			flowdata = res.contextData;
			seq = parseFloat(flowdata.seq);
			if (seq == 2) {
				$scope.disable = false;
			} else if (seq > 2) {
				$scope.disable = true;
				$scope.hid = true; //隐藏按钮
				//$("#yincang").css('display','none');
			}
			if (flagg == 'view') {
				$scope.disable = true;
				$scope.hid = true;
				//详情页面审批意见显示
				$("#showIdea").css('display', '');
			}
			//购销合同列表添加
			var da = {
				pageNo: $scope.conf.pageNo,
				pageSize: $scope.conf.pageSize,
				value: {appno: iddd}
			};
			//监听分页
			$scope.$watch("conf.pageNo+conf.pageSize", function () {
				$scope.queryTable();
			});
			$scope.queryTable = function (paramData) {
				var promise = $common.get_asyncData("bLanLnciBuyInfoService/getLoanApplyBuyContnoInfo", da);
				promise.then(function (res) {
					var data2;
					if (res.errorCode == "SUC") {//数据中的经办机构要转换成中文
						data2 = res.contextData;
						$scope.datasource.ds = data2.records;
						$scope.conf.totalRecord = data2.totalRecord;
					} else {
						$common.get_tipDialog(res.errorMsg, 'showError');
					}
				});
			}
		} else {
			$common.get_tipDialog(res.errorMsg, 'showError');
		}
	});

	//***********************************银承购销合同处理***********************************
	var appno = window.appNo;
	var vidNo = $scope.otherform.protocolNo;
	//新增购销合同
	$scope.add_onClick = function () {
		var row = {};
		$common.get_ngDialog('info/fourLoanBuy_add.html', $scope
			, ["$scope", function (dialogScope) {
				fourLoanBuyAddController(dialogScope, $scope, $common, $state, appno, vidNo);
			}], "新增购销合同", {showClose: true});
	};
	//修改购销合同
	$scope.update_onClick = function () {
		var row = {};
		if ($scope.selected.select.length == 1) {
			$common.get_ngDialog('info/buy_update.html', $scope
				, ["$scope", function (dialogScope) {
					buyInfoUpdateController(dialogScope, $scope, $common, "update", row, appno);
				}], "修改购销合同", {showClose: true});
		} else {
			$common.get_tipDialog('请选择一条记录！', 'showInform');
		}
	};
	//购销合同删除
	var del_gx = [];
	$scope.delete_onClick = function () {
		$common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
			var dsArray = $scope.datasource.ds;
			var selected = $scope.selected.select;
			for (var m = 0; m < selected.length; m++) {
				for (var i = 0; i < dsArray.length; i++) {
					if (dsArray[i].tradeContcode == selected[m].tradeContcode) {
						del_gx.push(selected[m].tradeContcode);
						$scope.datasource.ds.splice(i, 1);
						$scope.selected.select = [];
					}
				}
			}
		});
	};


	//先票款后货银承--供应链添加购销合同--赎货期限保存按钮
	$scope.save_onClick = function () {
		//购销合同添加
		if ($.doValidate("otherform")) {
			checkInputData();
			if(!ischeck){
				return false;
			}
			$scope.savedisable = true; //点击保存之后保存按钮不可用
			var primise = $common.get_asyncData("bLanLoanApplyService/LoanApplySaveUpdate", {
				mortgageLnciBaseInfoVO: $scope.otherform,
				list: $scope.datasource.ds
			});
			primise.then(function (res) {
				if (res.errorCode == "SUC") {
					$scope.queryTable();
					$scope.selected.select = [];
					$common.get_tipDialog('保存成功！', 'showSuccess');
					$scope.sumbitdisable = false;
				} else {
					$common.get_tipDialog(res.errorMsg, 'showError');
				}
				$scope.savedisable = false; //返回结果后按钮可用
			});
		}
	};
	//银承-供应链补录-提交按钮-自定义
	$scope.submit_onClick = function () {
		if ($.doValidate("otherform")) {
			checkInputData();
			if(!ischeck){
				return false;
			}
			$scope.sumbitdisable = true; //点击保存之后保存按钮不可用
			var primise = $common.get_asyncData("bLanLoanApplyService/LoanApplyWriteSubmit", {
				mortgageLnciBaseInfoVO: $scope.otherform,
				list: $scope.datasource.ds
			});
			primise.then(function (res) {
				if (res.errorCode == "SUC") {
					$scope.queryTable();
					$scope.selected.select = [];
					$common.get_tipDialog('提交成功！', 'showSuccess');
					$scope.hid = true;
				} else {
					$common.get_tipDialog(res.errorMsg, 'showError');
				}
				$scope.sumbitdisable = false; //返回结果后按钮可用
			});
		}
	};

//页面规则校验
	var ischeck=true;
	function checkInputData() {
		ischeck=true;
		var msg = "";
		//间接额度验证
		var hasIndirectCredit = $scope.otherform.hasIndirectCredit;//间接额度类型
		var creditUseBal = $scope.otherform.indirectCreaditLastAmt;//间接额度可用额度
		var openAmount = $scope.otherform.riskAmt;//本笔风险敞口
		var avaliableRiskAmt = $scope.otherform.avaliableRiskAmt;//可用敞口
		if ("1" == hasIndirectCredit && parseFloat(openAmount) > parseFloat(creditUseBal)) {
			$common.get_tipDialog('担保方间接额度可用余额不足!', 'showInform');
			ischeck = false;
			return false;
		}

		if (parseFloat(avaliableRiskAmt) <= 0) {
			$common.get_tipDialog('信贷合同可用敞口不足！', 'showError');
			ischeck = false;
			return false;
		}
		//本次出账金额校验
		var amount = 0;
		var msg = "";
		var record = $scope.datasource.ds;
		for (i = 0; i < record.length; i++) {
			var tradeContno = record[i].tradeContno;
			var tradeContcode = record[i].tradeContcode;
			var currOutAmt = record[i].loanAmt;
			var totAmt = record[i].accuLoanAmt;
			var amt = record[i].contAmt;
			var remainAmt = record[i].remainAmt;//审批中出账金额
			if (isNaN(currOutAmt)) {
				msg = msg + "购销合同号为【" + tradeContcode + "】的记录本次出账金额不能为空!\n";
				$common.get_tipDialog(msg, 'showError');
				ischeck = false;
				return false;
			} else {
				if (parseFloat(currOutAmt) <= 0) {
					msg = msg + "购销合同号为【" + tradeContcode + "】的记录本次出账金额必须大于0!\n";
					$common.get_tipDialog(msg, 'showError');
					ischeck = false;
					return false;
				}

				if (parseFloat(amt) < parseFloat(currOutAmt) + parseFloat(totAmt + remainAmt)) {
					if (parseFloat(remainAmt) > 0) {
						msg = msg + "购销合同号为【" + tradeContcode + "】的记录本次出账金额与累计出账金额(包含审批中出账金额)之和不能大于购销合同金额,当前购销合同下审批中出账金额为：" + remainAmt + "!\n";
					} else {
						msg = msg + "购销合同号为【" + tradeContcode + "】的记录本次出账金额与累计出账金额之和不能大于购销合同金额!\n";
					}
					$common.get_tipDialog(msg, 'showError');
					ischeck = false;
					return false;
				}
				amount = parseFloat(amount) + parseFloat(currOutAmt)
			}
		}

		//判断与本次申请金额的比较
		var lnciAmt = $scope.otherform.lnciAmt;
		if (lnciAmt > 0) {
			if (record.length <= 0) {
				msg = msg + "请先添加购销合同!\n";
				$common.get_tipDialog(msg, 'showError');
				ischeck = false;
				return false;
			}
			else if (amount != parseFloat(lnciAmt)) {
				msg = msg + "本次申请金额必须等于购销合同出账金额之和!\n";
				$common.get_tipDialog(msg, 'showError');
				ischeck = false;
				return false;
			}
		}
	}

};

/**
 * Filename: Description: Copyright: Copyright (c) 2013 Company: Shanghai
 * Huateng Software Systems Co., Ltd.
 * 
 * @author Wubin
 * @version 1.0 Create at: 2016/4/21
 */
var CopLibBindAddController = function(dialogScope, parentScope, $common, $state, dataDeliver) {
	var data1 = dataDeliver.getter();
	var productId = data1.productId;
	dialogScope.otherform = {// 初始化
		productId:productId
	};
	dialogScope.conditionForm = {};// 初始化条件查询框 otherform

	dialogScope.datasource = {// 初始化表格对象
		ds : []
	};
	dialogScope.selected = {// 初始化对象
		select : []
	};
	dialogScope.conf = {// 初始化分页对象
		pageNo : 1,
		pageSize : 10,
		totalRecord : 0
	};
	// 监听分页
	dialogScope.$watch("conf.pageNo+conf.pageSize", function() {
		dialogScope.queryTable();
	});
	// 清空按钮
	dialogScope.rebort_onClick = function() {
		dialogScope.conditionForm = {};
		dialogScope.queryTable();
	};
	// 点击查询之后的搜索
	dialogScope.submit_onClick = function() {
		dialogScope.queryTable();
		dialogScope.selected.select = [];
	};
	/** *-----------------------查询操作------------------** */
	dialogScope.queryTable = function(paramData) {
		var data = {
			pageNo : dialogScope.conf.pageNo,
			pageSize : dialogScope.conf.pageSize,
			value : dialogScope.conditionForm
		};
		var promiseQ = $common.get_asyncData(
				"bPrdCopLibService/findBPrdCopLibByPage", data);
		promiseQ.then(function(res) {
			var data;
			if (res.errorCode == "SUC") {
				data = res.contextData;
				dialogScope.datasource.ds = data.records;
				dialogScope.conf.totalRecord = data.totalRecord;
			} else {
				$common.get_tipDialog(res.errorMsg, 'showError');
			}
		});
	};

	/** ***----------------------保存按钮--------------------***** */
	// (保存即是新增，不会有修改的操作。)
	dialogScope.save_onClick = function() {
		if (dialogScope.selected.select.length==1) {
			// 需要校验otherform中productId.copOrder是否为空，只能逐条添加
			if ($.doValidate("otherform")) {// 页面otherform的校验
				var arrs = $common.copy(dialogScope.selected.select[0]);// table表中选中的数据
				var bPrdCopLibBind = {// 后台需要的字段
					relId : arrs.relId,
					copName : arrs.copName,
					copType : arrs.copType,
					status : arrs.status,
					productId :productId,
					copOrder : dialogScope.otherform.copOrder,
				};
				var primiseS = $common.get_asyncData(
						'bPrdCopLibBindService/add', {
							bPrdCopLibBind : bPrdCopLibBind
						});
				primiseS.then(function(res) {
					if (res.errorCode == "SUC") {// 新增成功之后，要将对应的数据显示在前台table上
						parentScope.queryTable();
						dialogScope.closeThisDialog();
						$common.get_tipDialog('保存组件关联信息成功！', 'showSuccess');
					} else {
						$common.get_tipDialog(res.errorMsg, 'showError');
					}
				});
			} else {
				$common.get_tipDialog('顺序不能为空，请填写！', 'showInform');
			}
		} else {
			$common.get_tipDialog('请选择一条记录！', 'showInform');
		}
	};

	/** ***---------返回按钮----------**** */
	dialogScope.back_onClick = function() {
		dialogScope.closeThisDialog();
	};
};

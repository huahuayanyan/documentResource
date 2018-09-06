/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2016/4/21
 */

var repayBillNormalStockController = function($scope,$common,$state,dataDeliver) {
	$scope.conditionForm = window.source.otherform;//初始化条件查询框
	$scope.datasource={//初始化表格对象
		ds: []
	};
	$scope.conf= {//初始化分页对象
		pageNo: 1,
		pageSize: 10,
		totalRecord: 0}
	//监听分页
	$scope.$watch("conf.pageNo+conf.pageSize",function(){
		$scope.queryTable();
	});
	//查询操作brName,brNo
	$scope.queryTable = function(paramData){
				var data= {
			pageNo: $scope.conf.pageNo,
			pageSize: $scope.conf.pageSize,
			billCommonQryVO:$scope.conditionForm
		};
		var promise = $common.get_asyncData("billNormalLoanApplyService/BillMortgageChkStockInfoGetter",data);
		promise.then(function(res){
			var data;
			if (res.errorCode =="SUC"){
				data = res.contextData;
				$scope.datasource.ds = data.records;
				$scope.conf.totalRecord = data.totalRecord;
			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		});
	};
	//点击查询之后的搜索
	$scope.submit_onClick =function(){
		$scope.queryTable();
		$scope.selected.select=[];
	};
	//重置按钮accountNo,accountType
	$scope.rebort_onClick =function(){
		$scope.conditionForm = {
			flag:"6"
		};
		$scope.$apply();
	}
	/**查看详情按钮*/
	$scope.column = function(row){
		var flag = "view";
		$scope.row = row;
		window.appNo = row.appno;
		window.processId = row.piid;
		window.flag = flag;
		$state.go("billnormal");//跳转
	}
};

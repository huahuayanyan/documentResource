/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2016/4/21
 */

var acctController = function($scope,$common,$state,dataDeliver) {
	//这里有一个问题就是当为新增页面跳转过来的时候，页面的点击事件不生效，所以，这里我折衷用了另一个方法，把所有的点击事件单独放了出来。
	var data1= dataDeliver.getter();
	//-------------------页面初始化--------------
	$scope.conditionForm={};//初始化条件查询框
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
		var id = window.appNo;
		var accountNo = $scope.conditionForm.accountNo;
		var data= {
			pageNo: $scope.conf.pageNo,
			pageSize: $scope.conf.pageSize,
			appId: data1.appId
		};
		var promise = $common.get_asyncData("bMrnAppliAcctInfoService/findBMrnAppliAcctInfoByPageConNo",data);
		promise.then(function(res){
			var data;
			if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
				data = res.contextData;
				$scope.datasource.ds = data.records;
				$scope.conf.totalRecord = data.totalRecord;
			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		});
	};
	//----------------------------------点击事件------------------------------
	//点击查询之后的搜索
	$scope.submit_onClick =function(){
		$scope.queryTable();
		$scope.selected.select=[];
	};
	//重置按钮accountNo,accountType
	$scope.rebort_onClick =function(){
		$scope.conditionForm.accountNo = "";
		$scope.queryTable();
	}
	//账户信息查看操作！
	$scope.column = function(row){
		$common.get_ngDialog('bcrmcredit/acc_add.html', $scope
			,["$scope",function(dialogScope){
				AccInfoAddController(dialogScope,$scope,$common,"view",row);
			}],"查看账户",{showClose:true});
	}
};

/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2016/4/21
 */

var repayBillNormalMortController = function($scope,$common,$state,dataDeliver) {
	$scope.source = window.source;
	$scope.otherform = $scope.source.otherform;
	$scope.otherform.modelId = window.modelId;
	$scope.datasource={//初始化表格对象
		ds:[]
	};
	$scope.selected={//初始化对象
		select: []
	};
	$scope.conf= {//初始化分页对象
		pageNo: 1,
		pageSize: 10,
		totalRecord: 0};

//监听分页
	$scope.$watch("conf.pageNo",function(){
		$scope.queryTable();
	});
	//仓单列表
	$scope.queryTable = function(paramData)
	{
		var data= {
			pageNo: $scope.conf.pageNo,
			pageSize: $scope.conf.pageSize,
			billNormalVO:$scope.otherform
		};
		var promise = $common.get_asyncData("billNormalLoanApplyService/ApplyBillNormalListGetter",data);
		promise.then(function(res){
			var data;
			if (res.errorCode =="SUC"){
				data = res.contextData;
				$scope.datasource.ds = data.records||[];
				$scope.conf.totalRecord = data.totalRecord;
				if($scope.datasource.ds!=[]&&$scope.datasource.ds.length>0)
				{
					var billno = "";
					for(var i=0; i<$scope.datasource.ds.length; i++)
					{
						billno = billno + $scope.datasource.ds[i].billno+"/f";
					}
					$scope.otherform.billno = billno;
				}
				$scope.queryTableMort();
			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		});
	};
	$scope.datasourcemort = {//初始化表格对象
		ds:[]
	};
	$scope.selectedmort ={//初始化对象
		select: []
	};
	$scope.confmort = {//初始化分页对象
		pageNo: 1,
		pageSize: 10,
		totalRecord: 0};
	//仓单下押品列表
	$scope.queryTableMort = function(paramData)
	{
		var data= {
			pageNo: $scope.confmort.pageNo,
			pageSize: $scope.confmort.pageSize,
			mortgageQryVO:$scope.otherform
		};
		var promise = $common.get_asyncData("sBcpMortBillNormalService/BillstandardMortgageBaseGetter",data);
		promise.then(function(res){
			var data;
			if (res.errorCode =="SUC"){
				data = res.contextData;
				$scope.datasourcemort.ds = data.records;
				$scope.confmort.totalRecord = data.totalRecord;
			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		});
	};

	$scope.column = function(row)
	{
		$common.get_ngDialog('billnormal/repay_billnormal_mortedit.html', $scope,["$scope",function(dialogScope){
			dialogScope.mortgageInfo = row;
			dialogScope.disable = true;
			//查询押品一级
			dialogScope.mortgageLevelOneSource = {
				ds:[]
			};
			dialogScope.$watch("conf.pageNo+conf.pageSize",function() {
				dialogScope.mortgageLevelOneSourceList(1);
				if(dialogScope.mortgageInfo.mortgageLevelOne)
				{
					var dataItemsDO = {mortgageCode:dialogScope.mortgageInfo.mortgageLevelOne};
					var data = {dataItemsDO:dataItemsDO};
					var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
					primise.then(function(res){
						if(res.errorCode =="SUC"){
							dialogScope.mortgageLevelTwoSource.ds = res.contextData;
						}else{
							$common.get_tipDialog(res.errorMsg,'showInform');
						}
					});
				}
			});
			dialogScope.mortgageLevelOneSourceList = function(level)
			{
				//业务品种下拉框
				var dataItemsDO = {levels:level};
				var data = {dataItemsDO:dataItemsDO};
				var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
				promise.then(function(res){
					if (res.errorCode =="SUC"){
						dialogScope.mortgageLevelOneSource.ds = res.contextData;
					}else{
						$common.get_tipDialog(res.errorMsg,'showInform');
					}
				});
			};
			//押品二级
			dialogScope.mortgageLevelTwoSource = {
				ds:[]
			};
			dialogScope.mortgageLevelOneName = function (val){
				dialogScope.mortgageInfo.mortgageLevelTwo = "";
				if(null != val){
					var dataItemsDO = {mortgageCode:val};
					var data = {dataItemsDO:dataItemsDO};
					var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
					mortgageName.then(function(res){
						if(res.errorCode =="SUC"){
							dialogScope.mortgageInfo.mortgageLevelOneName = res.contextData.mortgageName;
						}else{
							$common.get_tipDialog(res.errorMsg,'showInform');
						}
					});
					var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
					primise.then(function(res){
						if(res.errorCode =="SUC"){
							dialogScope.mortgageLevelTwoSource.ds = res.contextData;
						}else{
							$common.get_tipDialog(res.errorMsg,'showInform');
						}
					});
				}else{
					dialogScope.mortgageLevelTwoSource.ds = [];
				}
			};
			//押品三级
			dialogScope.mortgageLevelThreeSource = {
				ds:[]
			};
			dialogScope.mortgageLevelTwoName = function (val){
				dialogScope.mortgageInfo.mortgageLevelThreeSource = "";
				if(null != val){
					var dataItemsDO = {mortgageCode:val};
					var data = {dataItemsDO:dataItemsDO};
					var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
					mortgageName.then(function(res){
						if(res.errorCode =="SUC"){
							dialogScope.mortgageInfo.mortgageLevelTwoName = res.contextData.mortgageName;
						}else{
							$common.get_tipDialog(res.errorMsg,'showInform');
						}
					});
					var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
					primise.then(function(res){
						if(res.errorCode =="SUC"){
							dialogScope.mortgageLevelThreeSource.ds = res.contextData;
						}else{
							$common.get_tipDialog(res.errorMsg,'showInform');
						}
					});
				}else{
					dialogScope.mortgageLevelThreeSource.ds = [];
				}
			};
			//返回
			dialogScope.close_onClick = function(){
				dialogScope.closeThisDialog();
			};
		}],"押品信息")
	};

};

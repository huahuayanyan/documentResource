/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var postLoanAnalysisController = function($scope, $common, dataDeliver, $state,
		$eventCommunicationChannel) {
	$scope.conditionForm={};//初始化查询条件对象
	
	$scope.riskdatasource = {//初始化表格对象
			ds : []
		};
		$scope.riskselected = {//初始化对象
			select : []
		};
		$scope.riskconf = {//初始化分页对象
			pageNo : 1,
			pageSize : 10,
			totalRecord : 0
		};
		
	$scope.datasource = {//初始化表格对象
		ds : []
	};
	$scope.selected = {//初始化对象
		select : []
	};
	$scope.conf = {//初始化分页对象
		pageNo : 1,
		pageSize : 10,
		totalRecord : 0
	};
	//监听分页
	$scope.$watch("conf.pageNo+conf.pageSize", function() {
		$scope.queryTable();
	});
	//监听分页
	$scope.$watch("riskconf.pageNo+riskconf.pageSize", function() {
		$scope.queryRiskTable();
	});

	  //重置
    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
        	$scope.conditionForm={};
            $scope.selected.select=[];//清空选项
            $scope.riskselected.select=[];
        })
    };
    //搜索
   $scope.submit_onClick =function(){
       $scope.queryRiskTable();
        $scope.queryTable();
    };
	$scope.queryRiskTable = function() {
		var data = {
			pageNo : $scope.riskconf.pageNo,
			pageSize : $scope.riskconf.pageSize,
			value:$scope.conditionForm
			
		
		};
		var promise = $common.get_asyncData(
				"statisAnalysisService/getPostLoanRiskList", data);
		promise.then(function(res) {
			var data;
			if (res.errorCode == "SUC") {
				data = res.contextData;
				$scope.riskdatasource.ds = data.records;
				$scope.riskconf.totalRecord = data.totalRecord;
			} else {
				$common.get_tipDialog(res.errorMsg, 'showError');
			}
		});
		$scope.riskselected.select = [];
	};
	$scope.queryTable = function() {
		var data = {
			pageNo : $scope.conf.pageNo,
			pageSize : $scope.conf.pageSize,
			value:$scope.conditionForm
		
		};
		var promise = $common.get_asyncData(
				"statisAnalysisService/getPostLoanWarnStaList", data);
		promise.then(function(res) {
			var data;
			if (res.errorCode == "SUC") {
				data = res.contextData;
				$scope.datasource.ds = data.records;
				$scope.conf.totalRecord = data.totalRecord;
			} else {
				$common.get_tipDialog(res.errorMsg, 'showError');
			}
		});
		$scope.selected.select = [];
	};
	
    //查看预警详情
    $scope.column = function(row){
    	 dataDeliver.setter(row);
    	if(row.postLoanWarnType=="1"){
    		$state.go("bussWarnDtl");
    	}else if(row.postLoanWarnType=="2"){
    		$state.go("finWarnDtl");
    	}
        
       
    };
};

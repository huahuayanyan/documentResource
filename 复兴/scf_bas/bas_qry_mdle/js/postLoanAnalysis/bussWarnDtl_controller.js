/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var bussWarnDtlController = function($scope, $common, dataDeliver, $state,
		$eventCommunicationChannel) {
	var deliverData = dataDeliver.getter();
	
	$scope.conditionForm={
	        custcd:deliverData.custcd
	    };//初始化查询条件对象
	
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
    //重置
    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
        	$scope.conditionForm={
        	        custcd:deliverData.custcd
        	    }
            $scope.selected.select=[];//清空选项
        })
    };
    //搜索
   $scope.submit_onClick =function(){
        $scope.queryTable();
    };

	$scope.queryTable = function() {
		var data = {
			pageNo : $scope.conf.pageNo,
			pageSize : $scope.conf.pageSize,
			value:$scope.conditionForm
		
		};
		var promise = $common.get_asyncData(
				"statisAnalysisService/getPostLoanWarnDtlList", data);
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
	
    $scope.back_onClick = function () {
        $state.go("postLoan");
    };
};

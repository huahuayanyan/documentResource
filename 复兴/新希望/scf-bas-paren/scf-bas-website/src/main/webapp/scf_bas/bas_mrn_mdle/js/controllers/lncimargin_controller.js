/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var lncimarginController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel){
    $scope.conditionForm={};//初始化查询条件对象
    $scope.selected={select: []};//初始化对象
    $scope.datasource={ds: []};//初始化表格对象
    $scope.conf= {pageNo: 1, pageSize: 10};//初始化分页对象
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize", function () {
    	$scope.queryLoanTable();
    });
  
    $scope.queryLoanTable=function(){
		    var data= {
		        pageNo: $scope.conf.pageNo,
		        pageSize: $scope.conf.pageSize,
		        bLanLnciBase:$scope.conditionForm
		    };
		    var promise = $common.get_asyncData("incimarginService/findBLanLnciBaseList",data);
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

    $scope.reset_onClick = function(){      
        $scope.$apply(function(){
        	$scope.conditionForm = {};
            $scope.selected.select=[];//清空选项
        });
    };
    
    //搜索查询
    $scope.submit_onClick =function(){
    	$scope.queryLoanTable();
    };
            
    $scope.apply_onClick = function(){
	    if($scope.selected.select.length <= 0||$scope.selected.select.length > 1){
	        $common.get_tipDialog('请选择一条记录！','showInform');
	        return;
	    }
	    dataDeliver.setter($scope.selected.select[0]);
	    $state.go("lncimarginapply");
    };
    
    


};
/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var FactorListController = function($scope,$common,$state,dataDeliver) {

//****************初始化开始*****************//
	$scope.conditionForm = {
		factorFlag_Q:1,
		overseasFlag_Q:0
	};

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
//****************初始化结束*****************//


	//监听分页
	$scope.$watch("conf.pageNo+conf.pageSize",function(){
		$scope.queryTable();
	});

	//查询操作
	$scope.queryTable = function(paramData){
		var data= {
			pageNo: $scope.conf.pageNo,
			pageSize: $scope.conf.pageSize,
			customerQryVO:$scope.conditionForm
		};
		var promise = $common.get_asyncData("bCrmInsureCustomerService/findInsureCustomerByPage",data);
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
	
	$scope.add_onClick = function(){
		$common.get_ngDialog("bcrmfactor/orgcode_dialog.html",$scope,["$scope",function(dialogScope){
			OrgCodeDialogController(dialogScope,$scope,$common,$state,dataDeliver);
		}]);
	}

	$scope.update_onClick = function(){
		if($scope.selected.select.length<=0||$scope.selected.select.length>1){
			$common.get_tipDialog("请选择一条记录!",'showInform');
		}else{
			var row = $scope.selected.select[0];
			var data ={
				flag :"update",
				orgCode:row.orgCode,
				bCrmBaseInfo:row
			}
			$state.go("tree");
			dataDeliver.setter(data)

		}

	}

	$scope.submit_onClick = function(){
		$scope.queryTable();
	}

	$scope.rebort_onClick = function(){
		$scope.conditionForm ={};
		$scope.conditionForm.factorFlag_Q =1;
		$scope.conditionForm.overseasFlag_Q=0;
		$scope.selected.select=[];
		$scope.queryTable();
	}

	$scope.delete_onClick = function(){
		if($scope.selected.select.length==1){
			var row =$scope.selected.select[0];
			$common.get_tipDialog("确定删除吗？","showTip").then(function(){
				$common.get_asyncData('bCrmBaseInfoService/deleteBCrmBaseInfoCompletely', {bCrmBaseInfo: row}).then(
					function(res){
						if(res.errorCode=="SUC"){
							$scope.queryTable();
							$scope.selected.select = [];
							$common.get_tipDialog("删除成功",'showInform');
						}else{
							$common.get_tipDialog(res.errorMsg,'showError');
						}
					}
				);
			});
		}else{
			$common.get_tipDialog("请选择一条记录",'showInform')
		}

	}

	$scope.column = function(row){
		var data ={
			flag :"view",
			orgCode:row.orgCode,
			bCrmBaseInfo:row
		}
		$state.go("tree");
		dataDeliver.setter(data)
	}

    //表格--------结束-------------------------
};

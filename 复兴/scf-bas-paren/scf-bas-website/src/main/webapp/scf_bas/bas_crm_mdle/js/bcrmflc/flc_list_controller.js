/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var FlcListController = function($scope,$common,$state,dataDeliver) {

	$scope.conditionForm = {
		cname_Q:'',
		custno_Q:'',
		custStatus_Q:''
	};
	$scope.datasource ={ds:[]};
	$scope.selected ={select:[]};
	$scope.conf = 	{pageNo:1,
						pageSize:10,
							totalRecord:0};

	$scope.$watch("conf.pageNo+conf.pageSize",function(){
		$scope.queryTable();
	});

	$scope.queryTable = function(){
			var data ={
				pageNo:$scope.conf.pageNo,
				pageSize:$scope.conf.pageSize,
				customerQryVO:$scope.conditionForm
			}
			$common.get_asyncData("bCrmCustomerService/findFlcCustomerPage",data).then(function(res){
				if(res.errorCode=="SUC"){
					data = res.contextData;
					$scope.datasource.ds=data.records;
					$scope.conf.totalRecord = data.totalRecord;
				}else{
					$common.get_tipDialog(res.errorMsg,'showError');
				}
			});
	}

	$scope.add_onClick =function(){
		$common.get_ngDialog("bcrmflc/orgcode_dialog.html",$scope,["$scope",function(dialogScope){
			OrgCodeDialogController(dialogScope,$scope,$common,$state,dataDeliver);
		}]);

	}



	$scope.update_onClick = function(){
		if($scope.selected.select.length==1){
			var row = $scope.selected.select[0];
			//var bCrmBaseInfoVal ={};
			var qryParams={customerQryVO: {custcd:row.custcd}};
			$common.get_asyncData("bCrmInsureCustomerService/findCustomerInfoDetails",qryParams).then(function(res){
				if(res.errorCode="SUC"){
					row = res.contextData;
					$state.go("tree");
					var data ={
						flag:"update",
						bCrmBaseInfo:row
					}
					dataDeliver.setter(data);
				}else{
					$common.get_tipDialog(res.errorMsg, 'showError');
				}
			})
		}else{
			$common.get_tipDialog("请选择一条记录",'showInform');
		}
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
		var qryParams={customerQryVO: {custcd:row.custcd}};
		$common.get_asyncData("bCrmInsureCustomerService/findCustomerInfoDetails",qryParams).then(function(res){
			if(res.errorCode="SUC"){
				row = res.contextData;
				$state.go("tree");
				var data ={
					flag:"view",
					bCrmBaseInfo:row
				}
				dataDeliver.setter(data);
			}else{
				$common.get_tipDialog(res.errorMsg, 'showError');
			}
		});
	}

	$scope.submit_onClick=function(){
		$scope.queryTable();
	}

	$scope.rebort_onClick=function(){
		$scope.conditionForm={};
		$scope.selected.select=[];
		$scope.queryTable();
	}
};

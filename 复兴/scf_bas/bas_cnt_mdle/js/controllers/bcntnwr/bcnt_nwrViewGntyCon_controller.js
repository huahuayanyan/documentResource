/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      gongzhao
 * @version     1.0
 * Create at:   2017/04/12
 */
var nwrViewGntyConController = function($scope,$common,$state,dataDeliver)  {
		$scope.conditionForm=dataDeliver.getter();
		$scope.conditionForm.conStat="1";
	    $scope.datasource={//初始化表格对象
	        ds: []
	    };
	    $scope.selected={//初始化对象
	        select: []
	    };
	    $scope.conf= {//初始化分页对象
	        pageNo: 1,
	        pageSize: 10,
	        totalRecord: 0};
	    //监听分页
	    $scope.$watch("conf.pageNo+conf.pageSize",function() {
	        $scope.queryTable();
	    });
	    $scope.queryTable = function(paramData){
	        var data= {
	            pageNo: $scope.conf.pageNo,
	            pageSize: $scope.conf.pageSize,
	            bCrrGntyCon:$scope.conditionForm
	        };
	        var promise = $common.get_asyncData("bCrrGntyConService/findBCrrGntyConByPage",data);
	        promise.then(function(res){
	            var gnty;
	            if (res.errorCode =="SUC"){
	                gnty = res.contextData;
	                $scope.datasource.ds = gnty.records;
	                $scope.conf.totalRecord = gnty.totalRecord;
	            }else{
	                $common.get_tipDialog(res.errorMsg,'showError');
	            }
	        });
	    };
	    //查看
	    $scope.view_onClick = function(row){
	        if($scope.selected.select.length <= 0){
	            $common.get_tipDialog('请至少选择一条抵质押合同记录！','showInform');
	        }else{
	            $scope.otherform = $scope.selected.select[0];
	            var flag = "view";
	            var conId = $scope.selected.select[0].conId;
	            $common.get_asyncData("bCrrGntyConService/findBCrrGntyConByConId",{conId:conId}).then(function(res){
	                var gnty;
	                if (res.errorCode =="SUC"){
	                    gnty = res.contextData;
	                    $scope.otherform.row = gnty;
	                    $scope.otherform.flag = flag;
	                    $scope.otherform.bCrrGntyCon =  $scope.conditionForm;
	                    $state.go("edit");
	                    dataDeliver.setter($scope.otherform);
	                }else{
	                    $common.get_tipDialog(res.errorMsg,'showError');
	                }
	            });
	        }
	    };
	    $scope.column = function(row){
	        $scope.otherform = row;
	        var flag = "view";
	        var conId = row.conId;
	        $common.get_asyncData("bCrrGntyConService/findBCrrGntyConByConId",{conId:conId}).then(function(res){
	            var gnty;
	            if (res.errorCode =="SUC"){
	                gnty = res.contextData;
	                $scope.otherform.row = gnty;
	                $scope.otherform.flag = flag;
	                $scope.otherform.bCrrGntyCon =  $scope.conditionForm;
	                $state.go("edit");
	                dataDeliver.setter($scope.otherform);
	            }else{
	                $common.get_tipDialog(res.errorMsg,'showError');
	            }
	        });
	    };
	    $scope.closeThisDialog_onClick = function(){
	      $state.go("list");
	    };
};

/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      gongzhao
 * @version     1.0
 * Create at:   2017/04/12
 */
var gntyconViewController = function($scope,$common,$state,dataDeliver)  {
	var wData = window.source.otherform; //processTemplateName "StockListImportApply"
	$scope.slaveForm = {};

		$scope.$watch("slaveForm.vidPrdId",function(newVal,oldVal){
			if(!$scope.slaveForm.vidPrdId) return;
			var data ={
				key : $scope.slaveForm.vidPrdId
			};
			$common.get_asyncData("bPrdInfoService/findBPrdInfoObjectByKey",data).then(function(res){
				var gnty;
				if (res.errorCode =="SUC"){
					gnty = res.contextData;
					$scope.slaveForm.productName = gnty.productName;
				}else{
					$common.get_tipDialog(res.errorMsg,'showError');
				}
			});
		});

	    $scope.queryTable = function(paramData){
	        var data= {
				conId : wData ? wData.slaveContno : dataDeliver.getter().conId
	        };
	        var promise = $common.get_asyncData("bCrrGntyConService/findBCrrGntyConByConId",data);
	        promise.then(function(res){
	            var gnty;
	            if (res.errorCode =="SUC"){
	                gnty = res.contextData;
	                $scope.slaveForm = gnty;
	            }else{
	                $common.get_tipDialog(res.errorMsg,'showError');
	            }
	        });
	    };

	$scope.queryTable();

};

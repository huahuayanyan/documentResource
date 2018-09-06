/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2017/1/22
 */

var warnInfoListController = function($scope, $common, $state, dataDeliver) {
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
	$scope.queryTable = function() {
		var data = {
			pageNo : $scope.conf.pageNo,
			pageSize : $scope.conf.pageSize
		};
		var promise = $common.get_asyncData("statisAnalysisService/getWarnInfoListByPage",data);
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

	//查看
    $scope.column = function(row){
    	var url = row.url;
    	var warnName = row.warnName;
    	  if(url&&url!=undefined&&url!=null&&url!=""){
    		  url = window._HTTP_IP_PORT+url; 
    		  
    		  if(url.indexOf("http://")!=-1){

                  window.location.href=url+'?needBackFlag=true';
 
              }else{
                  //window.parent.parent.doWork(waringNo,name,url,waringNo);
              }
    	  }else{
    		  $common.get_tipDialog('【'+warnName+'】的预警参数未设置该预警的明细页面！','showInform');
    		  return ;
    	  }
    };
    //返回主页
	  $scope.homeBackHide =true;
	    var url = window.location.href;
	    if(url.indexOf("needBackFlag")!=-1){
	    	 $scope.homeBackHide = false;
	    }
	    //获得数据字典中配置的主页的URL
	   var mainPage ="";
	   mainPage = window.dictionary.main_pagePath.dataItems[0].dataVal;
	    //返回主页按钮
	    $scope.homeBack_onClick = function () {
	    	 if(mainPage&&mainPage!=undefined&&mainPage!=null&&mainPage!=""){
	    		//window.location.href =window._HTTP_IP_PORT+"scf_bas/bas_main_mdle/html/bmain_mdle.html";
	    		window.location.href =window._HTTP_IP_PORT+mainPage;
	    	}
	    };
};

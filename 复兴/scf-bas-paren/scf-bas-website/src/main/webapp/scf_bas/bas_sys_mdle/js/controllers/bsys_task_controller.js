/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var bsysTaskController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    $scope.conditionForm={};//初始化查询条件对象
    $scope.datasource={//初始化表格对象
        ds:[
        ]
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
   };
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
            $scope.conditionForm={};
            $scope.selected.select=[];//清空选项
        })
    };
    //搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //查询
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bSysTask:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bSysTaskService/queryTaskListByPage",data);
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
    //我要办理按钮
    $scope.doProcess_onClick = function(){
    	 if($scope.selected.select.length <= 0){
             $common.get_tipDialog('请至少选择一条记录！','showInform');
         }else{
	         var data= {
	             	appNo:$scope.selected.select[0].appNo,
	             	pageUrl:$scope.selected.select[0].pageUrl,
	             	taskId:$scope.selected.select[0].taskId,
	             	processId: $scope.selected.select[0].processId,
	             	custId:$scope.selected.select[0].name2,
	             	custNm:$scope.selected.select[0].custName,
	             	modelId:$scope.selected.select[0].modelId,
	             	nodeButton:$scope.selected.select[0].nodeButton
	              };
        	 $state.go("bsystasktab",data);

         }
        
    };

    $scope.fresh_onClick = function(){
        $scope.queryTable($scope.conditionForm);
        $scope.selected.select=[];
    };
    $scope.column = function(row){
        $scope.row = row;
        alert(JSON.stringify($scope.row));
        /*console.log(JSON.stringify(row));
        var appNo=row.appNo;
	   	var pageUrl=row.pageUrl;*/
	   	 //console.log("appNo:"+appNo);
	   	 //console.log("pageUrl:"+pageUrl);
	   	$state.go(""+pageUrl+"");
        var data= {
        	creditNo:appNo
        };
        dataDeliver.setter(data);
    };
    //表格--------结束-------------------------
    
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

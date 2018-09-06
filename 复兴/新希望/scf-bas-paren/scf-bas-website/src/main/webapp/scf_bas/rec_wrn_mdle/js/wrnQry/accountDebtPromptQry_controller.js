/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2017/1/13
 */

var accountDebtPromptController = function($scope,$common,$state,dataDeliver) {
    var data1= dataDeliver.getter();
    $scope.conditionForm={};//初始化条件查询框
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //查询操作brName,brNo
    $scope.queryTable = function(paramData){
        var billsNo = $scope.conditionForm.billsNo;
        var bussContcode = $scope.conditionForm.bussContcode;
        var startYj = $scope.conditionForm.startYj;
        var endYj = $scope.conditionForm.endYj;
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bWrnDebtPdoInfoDetail:{billsNo: billsNo,bussContcode: bussContcode,startYj: startYj,endYj: endYj},
            flag: '1'
        };
        var promise = $common.get_asyncData("rWrnBaseInfoService/findWrnBaseInfoByCondition",data);
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


    //点击查询之后的搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //重置按钮
    $scope.rebort_onClick =function(){
        $scope.conditionForm.billsNo = "";
        $scope.conditionForm.bussContcode = "";
        $scope.conditionForm.startYj = "";
        $scope.conditionForm.endYj = "";
        $scope.queryTable();
    }
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

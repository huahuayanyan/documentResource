/**
 * Created by htrad0036 on 2017/2/21.
 */

//押品流水查询
var CheckStockWarnQryController = function ($scope, $common, $state, dataDeliver) {
	//warnNo=122001005&bussiFlag=4
    $scope.conditionForm = {
        warnNo_Q:'122002005'
    };//初始化查询条件对象
    $scope.datasource = {//初始化表格对象
    };
    $scope.selected = {//初始化对象
        select: []
    };
    $scope.conf = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize", function () {
        $scope.queryTable();
    });

    //点击查询之后的搜索
    $scope.submit_onClick = function () {
        $scope.queryTable();
        $scope.selected.select = [];
    };
    //查询操作
    $scope.queryTable = function (paramData) {
        var data = {
            warnQryVO: $scope.conditionForm,
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize
        };
        var promise = $common.get_asyncData("bCheckStockWarnService/queryCheckStockWarnByPage", data);

        promise.then(function (res) {
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    };

    //重置按钮
    $scope.rebort_onClick = function () {
        $scope.$apply(function(){
            $scope.conditionForm = {};
            $scope.selected.select=[];
            $scope.conditionForm.warnNo_Q ='122002005';
        })
        $scope.queryTable();
    };
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
/**
 * Created by htrad0036 on 2017/2/21.
 */

//押品流水查询
var PriceFallExptController = function ($scope, $common, $state, dataDeliver) {

    $scope.conditionForm = {
        //warType=0&warnNo=122001003
        warnType_Q:'0',
        warnNo_Q:'122001003'
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
        var fluctuation1_Q = parseFloat($scope.conditionForm.fluctuation1_Q);
        var fluctuation2_Q = parseFloat($scope.conditionForm.fluctuation2_Q);
        if(fluctuation1_Q>fluctuation2_Q){
           $common.get_tipDialog("请确保跌幅查询范围 由小到大","showInform");
           return;
        }
        if(fluctuation1_Q<0){
            $common.get_tipDialog("跌幅范围(%)必须为0-100","showInform");
            return;
        }

        if(fluctuation1_Q>100){
            $common.get_tipDialog("跌幅范围(%)必须为0-100","showInform");
            return;
        }
        var data = {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            warnQryVO: $scope.conditionForm
        };

        var promise = $common.get_asyncData("bPriceFlucExceptionService/findPriceFlucExceptionPage", data);
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
            $scope.conditionForm.warnType_Q='0';
            $scope.conditionForm.warnNo_Q='122001003';
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
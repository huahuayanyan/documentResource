/**
 * @author 	huangshuidan
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2017/6/20
 */
var bigDataAnalysisController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $state.go("bigData.finAmtDistrib");//跳转
    //dataDeliver.setter({data:"我是父页面传过来的值"})//传值[可选]
    //todo
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

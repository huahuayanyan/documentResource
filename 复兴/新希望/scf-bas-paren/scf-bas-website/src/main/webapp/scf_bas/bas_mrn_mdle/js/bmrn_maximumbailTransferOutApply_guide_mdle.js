/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */
(function(){
	var parentwindow = window.parent;
	window.userInfo = parentwindow.userInfo;
	window.authorization=parentwindow.authorization;
	window.httpIpPort = parentwindow.httpIpPort;
	window.dictionary = parentwindow.dictionary;
	window._HTTP_IP_PORT = parentwindow._HTTP_IP_PORT;
	window.appNo = parentwindow.appNo;

	//跳转的路由配置
	var routeArry=[
		{
			'state':'transferOutApply',
			'url':'/transferOutApply',
			'templateUrl':'../html/maximumbail/transferOutApply_edit.html',
			'controller':'transferOutApplyEditController'
		},
		{
			'state':'transferOutApplyGuide',
			'templateUrl':'../html/bmrn_maximumbailTransferOutApply_guide_mdle.html'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bmrn_maximumbailTransferOutApply_guide',dependency,routeArry);
	//手动拉起angular应用程序
	angular.element(document).ready(function() {
		angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
	});

}());

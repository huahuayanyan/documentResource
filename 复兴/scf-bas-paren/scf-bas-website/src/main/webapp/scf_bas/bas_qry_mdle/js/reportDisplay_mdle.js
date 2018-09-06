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

	//跳转的路由配置
	var routeArry=[
		{
			'state':'list',
			'url':'/class_list',
			'default':'true',
			'templateUrl':'../html/reportDisplay/reportDisplay.html',
			'controller':'reportDisplayController'
		}
		,{
			'state':'display',
			'url':'/display',
			'default':'true',
			'templateUrl':'../html/reportDisplay/reportDisplayDtl.html',
			//'templateUrl':'../../report/htReport.html',
			'controller':'reportDisplayDtlController'
		}
	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('reportDisplay_mdle',dependency,routeArry);
}());

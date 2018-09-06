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
			'state':'ft',
			'url':'/ft',
			'default':'true',
			'templateUrl':'ft/ft.html',
			'controller':'ftController'
		},
		{
			'state':'view',
			'url':'/ftView',
			'templateUrl':'ft/ftView.html',
			'controller':'viewController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bas_intcptCnf',dependency,routeArry);
}());

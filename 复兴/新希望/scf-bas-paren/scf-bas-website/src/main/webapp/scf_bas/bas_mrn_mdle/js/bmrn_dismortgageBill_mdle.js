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
			'url':'/bill_list',
			'default':'true',
			'templateUrl':'../html/dismortgageBill/bill_list.html',
			'controller':'billlistController'
		},
		{
			'state':'billedit',
			'url':'/billedit',
			'default':'true',
			'templateUrl':'../html/dismortgageBill/bill_edit.html',
			'controller':'billEditController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bmrn_dismortgageBill',dependency,routeArry);
}());

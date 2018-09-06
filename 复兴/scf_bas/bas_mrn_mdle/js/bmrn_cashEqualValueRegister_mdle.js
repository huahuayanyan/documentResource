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
			'url':'/register_list',
			'default':'true',
			'templateUrl':'../html/cashEqualValueRegister/register_list.html',
			'controller':'registerlistController'
		},
		{
			'state':'registeredit',
			'url':'/registeredit',
			'default':'true',
			'templateUrl':'../html/cashEqualValueRegister/register_edit.html',
			'controller':'registerEditController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bmrn_cashEqualValueRegister',dependency,routeArry);
}());

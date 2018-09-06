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
			'url':'/list',
			'default':'true',
			'templateUrl':'eval/crgeval_list.html',
			'controller':'listController'
		},
		{
			'state':'apply',
			'url':'/aply',
			'templateUrl':'eval/crgeval_aply.html',
			'controller':'aplyController'
		},
		{
			'state':'add',
			'url':'/add',
			'templateUrl':'eval/crgeval_add.html',
			'controller':'viewController'
		},
		{
			'state':'tabadd',
			'url':'/tabadd',
			'templateUrl':'eval/crgeval_tabadd.html',
			'controller':'tabaddController'
		},
		{
			'state':'tabupdate',
			'url':'/tabupdate',
			'templateUrl':'eval/crgeval_tabupdate.html',
			'controller':'tabupdateController'
		},
		{
			'state':'tabview',
			'url':'/tabview',
			'templateUrl':'eval/crgeval_tabview.html',
			'controller':'tabviewController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bas_crgEval',dependency,routeArry);
}());

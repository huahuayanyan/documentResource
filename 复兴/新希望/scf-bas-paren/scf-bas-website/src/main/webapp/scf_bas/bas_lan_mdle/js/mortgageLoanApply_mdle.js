/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2016/4/21
 */
(function(){

	//跳转的路由配置
	var routeArry=[
		{
			'state':'mortgageLoanApply',
			'url':'/mortgageLoanApply',
			'default':'true',
			'templateUrl':'approve/mortgageLoanApply.html',
			'controller':'mortgageLoanApplyController'
		},
		{
			'state':'repay',
			'url':'/repay',
			'templateUrl':'approve/repayDetail.html',
			'controller':'mortgageLoanApplyDetailController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bas_lan_mdle',dependency,routeArry);
}());
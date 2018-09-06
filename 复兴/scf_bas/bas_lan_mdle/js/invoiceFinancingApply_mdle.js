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
			'state':'invoiceFinancingApply',
			'url':'/invoiceFinancingApply',
			'default':'true',
			'templateUrl':'approve/invoiceFinancingApply.html',
			'controller':'invoiceFinancingApplyController'
		},
		{
			'state':'repay',
			'url':'/repay',
			'templateUrl':'approve/repayDetail.html',
			'controller':'invoiceFinancingApplyDetailController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bas_lan_mdle',dependency,routeArry);
}());
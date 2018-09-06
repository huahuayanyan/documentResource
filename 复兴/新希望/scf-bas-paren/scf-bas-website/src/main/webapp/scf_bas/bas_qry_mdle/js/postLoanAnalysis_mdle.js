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
			'state':'postLoan',
			'url':'/postLoan',
			'default':'true',
			'templateUrl':'../html/postLoanAnalysis/postLoanAnalysis.html',
			'controller':'postLoanAnalysisController'
		},
		{
			'state':'bussWarnDtl',
			'url':'/bussWarnDtl',
			'templateUrl':'../html/postLoanAnalysis/bussWarnDtl.html',
			'controller':'bussWarnDtlController'
		},
		{
			'state':'finWarnDtl',
			'url':'/finWarnDtl',
			'templateUrl':'../html/postLoanAnalysis/finWarnDtl.html',
			'controller':'finWarnDtlController'
		}
	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('postLoanAnalysis_mdle',dependency,routeArry);
}());

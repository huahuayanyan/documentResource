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
			'state':'fourWareLoanApply',
			'url':'/fourWareLoanApply',
			'default':'true',
			'templateUrl':'approve/fourWareLoanApply.html',
			'controller':'fourWareLoanApplyController'
		},
		{
			'state':'repay',
			'url':'/repay',
			'templateUrl':'approve/fourWareLoanApplyDetail.html',
			'controller':'fourWareLoanApplyDetailController'
		},
		{
			'state':'repayLiuDai',
			'url':'/repayLiuDai',
			'templateUrl':'approve/fourWareLoanApplyDetailLiuDai.html',
			'controller':'fourWareLoanApplyDetailController'
		}
	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bas_lan_mdle',dependency,routeArry);
}());
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
			'state':'list',
			'url':'/list',
			'default':'true',
			'templateUrl':'../html/billnormal/repay_billnormal_list.html',
			'controller':'repayBillNormalListController'
		},
		{
			'state':'billnormal',
			'url':'/billnormal',
			'default':'true',
			'templateUrl':'../html/billnormal/repay_billnormal.html',
			'controller':'repayBillNormalGuideController'
		},
		{
			'state':'billnormal.billdetail',
			'url':'/billnormal.billdetail',
			'templateUrl':'../html/billnormal/repay_billnormal_billedit.html',
			'controller':'repayBillNormalEditController'
		},
		{
			'state':'billnormal.cashdetail',
			'url':'/billnormal.cashdetail',
			'templateUrl':'../html/billnormal/repay_billnormal_cashedit.html',
			'controller':'repayBillNormalEditController'
		},
		{
			//仓单清单
			'state':'billnormal.mort',
			'url':'/billnormal.mort',
			'templateUrl':'../html/billnormal/repay_billnormal_mort.html',
			'controller':'repayBillNormalMortController'
		},
		{
			//保证金列表
			'state':'billnormal.acct',
			'url':'/billnormal.acct',
			'templateUrl':'info/acct.html',
			'controller':'acctController'
		},
		{
			//核库信息
			'state':'billnormal.stock',
			'url':'/billnormal.stock',
			'templateUrl':'../html/billnormal/repay_billnormal_stock.html',
			'controller':'repayBillNormalStockController'
		},
		{
			//抵质押合同
			'state':'billnormal.gntycon',
			'url':'/billnormal.gntycon',
			'templateUrl':'info/gntycon.html',
			'controller':'gntyconController'
		},
		{
			//信贷合同
			'state':'billnormal.lncon',
			'url':'/billnormal.lncon',
			'templateUrl':'info/lncon.html',
			'controller':'lanconController'
		}

	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('blan_billNormal_mdle',dependency,routeArry);

}());

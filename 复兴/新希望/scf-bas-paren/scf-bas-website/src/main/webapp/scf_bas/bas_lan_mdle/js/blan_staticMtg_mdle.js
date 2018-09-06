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
			'templateUrl':'../html/staticmtg/repay_staticmtg_applyList.html',
			'controller':'MtgStaticApplyListController'
		},
		{
			'state':'mtgdetail',
			'url':'/mtgdetail',
			'default':'true',
			'templateUrl':'../html/staticmtg/repay_mtg.html',
			'controller':'repayStaticMtgGuideController'
		},
		{
			//放款信息
			'state':'mtgdetail.cashdetail',
			'url':'/mtgdetail.cashdetail',
			'templateUrl':'../html/staticmtg/repay_staticmtg_cashedit.html',
			'controller':'repayStaticMtgEditController'
		},
		{
			//放款信息
			'state':'mtgdetail.billdetail',
			'url':'/mtgdetail.billdetail',
			'templateUrl':'../html/staticmtg/repay_staticmtg_billedit.html',
			'controller':'repayStaticMtgEditController'
		},
		{
			'state':'mtgdetail.bill',
			'url':'/mtgdetail.bill',
			'templateUrl':'info/bill.html',
			'controller':'billController'
		},
		{
			'state':'mtgdetail.acct',
			'url':'/mtgdetail.acct',
			'templateUrl':'info/acct.html',
			'controller':'acctController'
		},
		{
			'state':'mtgdetail.yp',
			'url':'/mtgdetail.yp',
			'templateUrl':'info/yp.html',
			'controller':'ypController'
		},
		{
			//抵质押合同
			'state':'mtgdetail.gntycon',
			'url':'/mtgdetail.gntycon',
			'templateUrl':'info/gntycon.html',
			'controller':'gntyconController'
		},
		{
			'state':'mtgdetail.hk',
			'url':'/mtgdetail.hk',
			'templateUrl':'info/hk.html',
			'controller':'hkController'
		},
		{
			'state':'mtgdetail.lncon',
			'url':'/mtgdetail.lncon',
			'templateUrl':'info/lncon.html',
			'controller':'lanconController'
		}

	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bas_lan_mdle',dependency,routeArry);
}());
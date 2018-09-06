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
	var parentwindow = window.parent;
	window.userInfo = parentwindow.userInfo;
	window.authorization=parentwindow.authorization;
	window.httpIpPort = parentwindow.httpIpPort;
	window.dictionary = parentwindow.dictionary;
	window._HTTP_IP_PORT = parentwindow._HTTP_IP_PORT;
	window.appNo = parentwindow.appNo;
	window.flag = parentwindow.flag;
	window.processId = parentwindow.processId;
	window.modelId = parentwindow.modelId;

	//跳转的路由配置
	var routeArry=[
		{
			//放款信息
			'state':'repaycashdetail',
			'url':'/repaycashdetail',
			'templateUrl':'../html/staticmtg/repay_staticmtg_cashedit.html',
			'controller':'repayStaticMtgEditController'
		},
		{
			//放款信息
			'state':'repaybilldetail',
			'url':'/repaybilldetail',
			'templateUrl':'../html/staticmtg/repay_staticmtg_billedit.html',
			'controller':'repayStaticMtgEditController'
		},
		{
			'state':'repaybill',
			'url':'/repaybill',
			'templateUrl':'info/bill.html',
			'controller':'billController'
		},
		{
			'state':'repayacct',
			'url':'/acct',
			'templateUrl':'info/acct.html',
			'controller':'acctController'
		},
		{
			'state':'repayyp',
			'url':'/yp',
			'templateUrl':'info/yp.html',
			'controller':'ypController'
		},
		{
			//抵质押合同
			'state':'repaygntycon',
			'url':'/repaygntycon',
			'templateUrl':'info/gntycon.html',
			'controller':'gntyconController'
		},
		{
			'state':'repayhk',
			'url':'/hk',
			'templateUrl':'info/hk.html',
			'controller':'hkController'
		},
		{
			'state':'repaylncon',
			'url':'/lncon',
			'templateUrl':'info/lncon.html',
			'controller':'lanconController'
		}

	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('blan_billNormal_cashGuide',dependency,routeArry);
	//手动拉起angular应用程序
	angular.element(document).ready(function() {
		angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
	});
}());

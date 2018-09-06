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
			'state':'repaydetail',
			'url':'/repaydetail',
			'templateUrl':'../html/billnormal/repay_billnormal_billedit.html',
			'controller':'repayBillNormalEditController'
		},
		{
			//仓单清单
			'state':'repaymort',
			'url':'/repaymort',
			'templateUrl':'../html/billnormal/repay_billnormal_mort.html',
			'controller':'repayBillNormalMortController'
		},
		{
			//保证金列表
			'state':'repayacct',
			'url':'/acct',
			'templateUrl':'info/acct.html',
			'controller':'acctController'
		},
		{
			//核库信息
			'state':'repaystock',
			'url':'/repaystock',
			'templateUrl':'../html/billnormal/repay_billnormal_stock.html',
			'controller':'repayBillNormalStockController'
		},
		{
			//抵质押合同
			'state':'repaygntycon',
			'url':'/repaygntycon',
			'templateUrl':'info/gntycon.html',
			'controller':'gntyconController'
		},
		{
			//信贷合同
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
	scubeUI.module('blan_billNormal_billGuide',dependency,routeArry);
	//手动拉起angular应用程序
	angular.element(document).ready(function() {
		angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
	});
}());

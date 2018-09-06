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
			'state':'repayyc',
			'url':'/repaybest',
			'templateUrl':'info/repayyc.html',
			'controller':'repayycController'
		},
		{
			'state':'repayyszk',
			'url':'/repayyszk',
			'templateUrl':'info/repayyszk.html',
			'controller':'repayyszkController'
		},
		{
			'state':'repayxhdy',
			'url':'/repayxhdy',
			'templateUrl':'info/repayxhdy.html',
			'controller':'repayxhdyController'
		},
		{
			'state':'repaybill',
			'url':'/bill',
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
			'state':'repaycntlncon',
			'url':'/cntlncon',
			'templateUrl':'info/cntlncon.html',
			'controller':'cntlnconController'
		},
		{
			'state':'repayhk',
			'url':'/hk',
			'templateUrl':'info/hk.html',
			'controller':'hkController'
		},
		{
			'state':'repayprotocol',
			'url':'../../bas_cnt_mdle/html/bcntthreeProtocol/bcnt_threeProtocolAdd',
			'templateUrl':'../../bas_cnt_mdle/html/bcntthreeProtocol/bcnt_threeProtocolAdd.html',
			'controller':'threeProDetailController'
		},
		{
			'state':'repayysht',
			'url':'../../bas_cnt_mdle/html/bcntdebt/debtConView',
			'templateUrl':'../../bas_cnt_mdle/html/bcntdebt/debtConView.html',
			'controller':'debtConViewController'
		},
		{
			'state':'repaylncon',
			'url':'/lncon',
			'templateUrl':'info/lncon.html',
			'controller':'lanconController'
		},
		{
			'state':'repaygnblc',
			'url':'/gnblc',
			'templateUrl':'info/repaygnblc.html',
			'controller':'gnblcController'
		},
		{
			'state':'repaycyszk',
			'url':'/cyszk',
			'templateUrl':'info/cyszk.html',
			'controller':'cyszkController'
		},
		{
			'state':'repayyscht',
			'url':'/yscht',
			'templateUrl':'../../bas_cnt_mdle/html/bcntdebtpool/debtPoolConView.html',
			'controller':'debtPoolConViewController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bLan_mdle',dependency,routeArry);
	//手动拉起angular应用程序
	angular.element(document).ready(function() {
		angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
	});
}());

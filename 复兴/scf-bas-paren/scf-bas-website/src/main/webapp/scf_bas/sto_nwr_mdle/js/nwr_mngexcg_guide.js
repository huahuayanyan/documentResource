/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
(function(){
	var parentwindow = window.parent;
	window.userInfo = parentwindow.userInfo;
	window.authorization=parentwindow.authorization;
	window.httpIpPort = parentwindow.httpIpPort;
	window.dictionary = parentwindow.dictionary;
	window._HTTP_IP_PORT = parentwindow._HTTP_IP_PORT;
	window.appNo = parentwindow.appNo;
	window.processId = parentwindow.processId;

	window.Write = true;
	window.Check = true;
	window.Review = true;
	window.Confirm = true;
	window.BackToModify = true;


	//跳转的路由配置
	var routeArry=[
		{
			'state':'mngexcftaskapplyin',
			'url':'/mngexcftaskapplyin',
			'templateUrl':'../html/mngexcg/mng_excg_applyin.html',
			'controller':'mngExcgApplyInController'
		},
		{
			'state':'mngexcftaskapplyout',
			'url':'/mngexcftaskapplyout',
			'templateUrl':'../html/mngexcg/mng_excg_applyout.html',
			'controller':'mngExcgApplyOutController'
		},
		{//质押合同
			'state':'mngexcftaskslave',
			'url':'/mngexcftaskslave',
			'templateUrl':'../html/nwrinfo/nwrinfo_slave.html',
			'controller':'nwrinfoSlaveController'
		},
		{//仓单质押监管协议
			'state':'mngexcftaskprotocol',
			'url':'/mngexcftaskprotocol',
			'templateUrl':'../html/nwrinfo/nwrinfo_protocol.html',
			'controller':'nwrinfoProtocolController'
		},
		{//出质人信息
			'state':'mngexcftaskcust',
			'url':'/mngexcftaskcust',
			'templateUrl':'../html/nwrinfo/nwrinfo_cust.html',
			'controller':'nwrinfoCustController'
		},
		{//监管商信息
			'state':'mngexcftaskmonicust',
			'url':'/mngexcftaskmonicust',
			'templateUrl':'../html/nwrinfo/nwrinfo_monicust.html',
			'controller':'nwrinfoProtocolController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('stoNwrMngExcgGuide',dependency,routeArry);
	//手动拉起angular应用程序
	angular.element(document).ready(function() {
		angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
	});

}());

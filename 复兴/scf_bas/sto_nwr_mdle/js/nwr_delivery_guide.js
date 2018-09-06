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
	window.Issued = true;
	window.Receipt = true;
	window.Notice = true;

	//跳转的路由配置
	var routeArry=[
		{//提货申请
			'state':'deliveryapply',
			'url':'/deliveryapply',
			'templateUrl':'../html/delivery/delivery_apply.html',
			'controller':'deliveryApplyController'
		},
		{//保证金追加
			'state':'deliveryacctadd',
			'url':'/deliveryacctadd',
			'templateUrl':'../html/nwrinfo/nwrinfo_acctadd.html',
			'controller':'nwrinfoAcctaddController'
		},
		{//质押合同
			'state':'deliveryslave',
			'url':'/deliveryslave',
			'templateUrl':'../html/nwrinfo/nwrinfo_slave.html',
			'controller':'nwrinfoSlaveController'
		},
		{//仓单质押监管协议
			'state':'deliveryprotocol',
			'url':'/deliveryprotocol',
			'templateUrl':'../html/nwrinfo/nwrinfo_protocol.html',
			'controller':'nwrinfoProtocolController'
		},
		{//出质人信息
			'state':'deliverycust',
			'url':'/deliverycust',
			'templateUrl':'../html/nwrinfo/nwrinfo_cust.html',
			'controller':'nwrinfoCustController'
		},
		{//监管商信息
			'state':'deliverymonicust',
			'url':'/deliverymonicust',
			'templateUrl':'../html/nwrinfo/nwrinfo_monicust.html',
			'controller':'nwrinfoProtocolController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('stoNwrPledgeMngGuide',dependency,routeArry);
	//手动拉起angular应用程序
	angular.element(document).ready(function() {
		angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
	});

}());

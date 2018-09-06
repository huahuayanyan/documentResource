/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
(function(){

	window.Write = true;
	window.Issued = true;
	window.Receipt = true;
	window.Notice = true;

	//跳转的路由配置
	var routeArry=[
		{
			'state':'list',
			'url':'/deliverylist',
			'default':'true',
			'templateUrl':'../html/delivery/delivery_list.html',
			'controller':'deliveryListController'
		},
		{
			'state':'deliverytask',
			'url':'/deliverytask',
			'default':'true',
			'templateUrl':'../html/delivery/delivery.html',
			'controller':'deliveryController'
		},
		{//提货申请
			'state':'deliverytask.apply',
			'url':'/deliverytask.apply',
			'templateUrl':'../html/delivery/delivery_apply.html',
			'controller':'deliveryApplyController'
		},
		{//保证金追加
			'state':'deliverytask.acctadd',
			'url':'/deliverytask.acctadd',
			'templateUrl':'../html/nwrinfo/nwrinfo_acctadd.html',
			'controller':'nwrinfoAcctaddController'
		},
		{//质押合同
			'state':'deliverytask.slave',
			'url':'/deliverytask.slave',
			'templateUrl':'../html/nwrinfo/nwrinfo_slave.html',
			'controller':'nwrinfoSlaveController'
		},
		{//仓单质押监管协议
			'state':'deliverytask.protocol',
			'url':'/deliverytask.protocol',
			'templateUrl':'../html/nwrinfo/nwrinfo_protocol.html',
			'controller':'nwrinfoProtocolController'
		},
		{//出质人信息
			'state':'deliverytask.cust',
			'url':'/deliverytask.cust',
			'templateUrl':'../html/nwrinfo/nwrinfo_cust.html',
			'controller':'nwrinfoCustController'
		},
		{//监管商信息
			'state':'deliverytask.monicust',
			'url':'/deliverytask.monicust',
			'templateUrl':'../html/nwrinfo/nwrinfo_monicust.html',
			'controller':'nwrinfoProtocolController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('stoNwrPledgeMng',dependency,routeArry);
}());

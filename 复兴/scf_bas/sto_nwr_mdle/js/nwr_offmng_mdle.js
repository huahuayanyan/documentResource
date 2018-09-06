/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
(function(){

	window.Write = true;
	window.Check = true;
	window.Review = true;
	window.Confirm = true;
	window.BackToModify = true;

	//跳转的路由配置
	var routeArry=[
		{
			'state':'list',
			'url':'/offmnglist',
			'default':'true',
			'templateUrl':'../html/offmng/off_mng_list.html',
			'controller':'offMnglistController'
		},
		{
			'state':'offmngtask',
			'url':'/offmngtask',
			'default':'true',
			'templateUrl':'../html/offmng/off_mng.html',
			'controller':'offMngController'
		},
		{
			'state':'offmngtask.apply',
			'url':'/offmngtask.apply',
			'templateUrl':'../html/offmng/off_mng_apply.html',
			'controller':'offMngApplyController'
		},
		{//质押合同
			'state':'offmngtask.slave',
			'url':'/offmngtask.slave',
			'templateUrl':'../html/nwrinfo/nwrinfo_slave.html',
			'controller':'nwrinfoSlaveController'
		},
		{//仓单质押监管协议
			'state':'offmngtask.protocol',
			'url':'/offmngtask.protocol',
			'templateUrl':'../html/nwrinfo/nwrinfo_protocol.html',
			'controller':'nwrinfoProtocolController'
		},
		{//出质人信息
			'state':'offmngtask.cust',
			'url':'/offmngtask.cust',
			'templateUrl':'../html/nwrinfo/nwrinfo_cust.html',
			'controller':'nwrinfoCustController'
		},
		{//监管商信息
			'state':'offmngtask.monicust',
			'url':'/offmngtask.monicust',
			'templateUrl':'../html/nwrinfo/nwrinfo_monicust.html',
			'controller':'nwrinfoProtocolController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('stoNwrOffMng',dependency,routeArry);
}());

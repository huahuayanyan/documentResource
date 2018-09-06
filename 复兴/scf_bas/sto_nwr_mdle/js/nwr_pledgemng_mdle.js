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
			'url':'/pledgemnglist',
			'default':'true',
			'templateUrl':'../html/pledgemng/pledge_mng_list.html',
			'controller':'pledgeMnglistController'
		},
		{
			'state':'mngtask',
			'url':'/mngtask',
			'default':'true',
			'templateUrl':'../html/pledgemng/pledge_mng.html',
			'controller':'pledgeMngController'
		},
		{
			'state':'mngtask.apply',
			'url':'/mngtask.apply',
			'templateUrl':'../html/pledgemng/pledge_mng_apply.html',
			'controller':'pledgeMngApplyController'
		},
		{//质押合同
			'state':'mngtask.slave',
			'url':'/mngtask.slave',
			'templateUrl':'../html/nwrinfo/nwrinfo_slave.html',
			'controller':'nwrinfoSlaveController'
		},
		{//仓单质押监管协议
			'state':'mngtask.protocol',
			'url':'/mngtask.protocol',
			'templateUrl':'../html/nwrinfo/nwrinfo_protocol.html',
			'controller':'nwrinfoProtocolController'
		},
		{//出质人信息
			'state':'mngtask.cust',
			'url':'/mngtask.cust',
			'templateUrl':'../html/nwrinfo/nwrinfo_cust.html',
			'controller':'nwrinfoCustController'
		},
		{//监管商信息
			'state':'mngtask.monicust',
			'url':'/mngtask.mprot',
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

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
			'url':'/mngexcglist',
			'default':'true',
			'templateUrl':'../html/offmng/off_mng_list.html',
			'controller':'mngExcglistController'
		},
		{
			'state':'mngexcftask',
			'url':'/mngexcftask',
			'default':'true',
			'templateUrl':'../html/mngexcg/mng_excg.html',
			'controller':'mngExcgController'
		},
		{
			'state':'mngexcftask.applyin',
			'url':'/mngexcftask.applyin',
			'templateUrl':'../html/mngexcg/mng_excg_applyin.html',
			'controller':'mngExcgApplyInController'
		},
		{
			'state':'mngexcftask.applyout',
			'url':'/mngexcftask.applyout',
			'templateUrl':'../html/mngexcg/mng_excg_applyout.html',
			'controller':'mngExcgApplyOutController'
		},
		{//质押合同
			'state':'mngexcftask.slave',
			'url':'/mngexcftask.slave',
			'templateUrl':'../html/nwrinfo/nwrinfo_slave.html',
			'controller':'nwrinfoSlaveController'
		},
		{//仓单质押监管协议
			'state':'mngexcftask.protocol',
			'url':'/mngexcftask.protocol',
			'templateUrl':'../html/nwrinfo/nwrinfo_protocol.html',
			'controller':'nwrinfoProtocolController'
		},
		{//出质人信息
			'state':'mngexcftask.cust',
			'url':'/mngexcftask.cust',
			'templateUrl':'../html/nwrinfo/nwrinfo_cust.html',
			'controller':'nwrinfoCustController'
		},
		{//监管商信息
			'state':'mngexcftask.monicust',
			'url':'/mngexcftask.monicust',
			'templateUrl':'../html/nwrinfo/nwrinfo_monicust.html',
			'controller':'nwrinfoProtocolController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('stoNwrMngExcg',dependency,routeArry);
}());

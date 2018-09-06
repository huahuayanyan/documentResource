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
	window.Receipt = true;
	window.BackToModify = true;

	//跳转的路由配置
	var routeArry=[
		{
			'state':'list',
			'url':'/billnormaladdlist',
			'default':'true',
			'templateUrl':'../html/billnormaladd/billnormal_add_list.html',
			'controller':'billNormaAddllistController'
		},
		{
			'state':'billnormaladd',
			'url':'/billnormaladd',
			'default':'true',
			'templateUrl':'../html/billnormaladd/billnormal_add.html',
			'controller':'billNormalAddController'
		},
		{
			'state':'billnormaladd.apply',
			'url':'/billnormaladd.apply',
			'templateUrl':'../html/billnormaladd/billnormal_add_apply.html',
			'controller':'billNormalAddApplyController'
		},
		{//质押合同
			'state':'billnormaladd.slave',
			'url':'/billnormaladd.slave',
			'templateUrl':'../html/nwrinfo/nwrinfo_slave.html',
			'controller':'nwrinfoSlaveController'
		},
		{//仓单质押监管协议
			'state':'billnormaladd.protocol',
			'url':'/billnormaladd.protocol',
			'templateUrl':'../html/nwrinfo/nwrinfo_protocol.html',
			'controller':'nwrinfoProtocolController'
		},
		{//出质人信息
			'state':'billnormaladd.cust',
			'url':'/billnormaladd.cust',
			'templateUrl':'../html/nwrinfo/nwrinfo_cust.html',
			'controller':'nwrinfoCustController'
		},
		{//监管商信息
			'state':'billnormaladd.monicust',
			'url':'/billnormaladd.mprot',
			'templateUrl':'../html/nwrinfo/nwrinfo_monicust.html',
			'controller':'nwrinfoProtocolController'
		}
	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('stoNwrBillNormalAdd',dependency,routeArry);
}());

/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
(function(){

	//跳转的路由配置
	var routeArry=[
		{
			'state':'list',
			'url':'/genledgerlist',
			'default':'true',
			'templateUrl':'../html/genledger/general_ledger_list.html',
			'controller':'generalLedgerlistController'
		},
		{
			'state':'genldeger',
			'url':'/genldeger',
			'default':'true',
			'templateUrl':'../html/genledger/general_ledger.html',
			'controller':'generalLedgerController'
		},
		{
			'state':'genldeger.detail',
			'url':'/genldeger.detail',
			'templateUrl':'../html/genledger/general_ledger_detail.html',
			'controller':'generalLedgerDetailController'
		},
		{//抵质押合同信息
			'state':'genldeger.slavemort',
			'url':'/genldeger.slavemort',
			'templateUrl':'../html/nwrinfo/nwrinfo_slavemort.html',
			'controller':'nwrinfoSlaveMortController'
		},
		{//仓单监管协议信息
			'state':'genldeger.protocol',
			'url':'/genldeger.protocol',
			'templateUrl':'../html/nwrinfo/nwrinfo_protocol.html',
			'controller':'nwrinfoProtocolController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('stoNwrGenLedger',dependency,routeArry);
}());

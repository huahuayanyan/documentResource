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
			'url':'/contunlist',
			'default':'true',
			'templateUrl':'../html/buscont/bcp_cont_unlist.html',
			'controller':'nrBcpContUnListController'
		},
		{//国内信保保理
			'state':'credit',
			'url':'/contcredit',
			'default':'true',
			'templateUrl':'../html/buscont/creditFactoringConInfo.html',
			'controller':'nrBcpContEditController'
		},
		{//国内双保理
			'state':'double',
			'url':'/contdouble',
			'default':'true',
			'templateUrl':'../html/buscont/doublfactorContAdd.html',
			'controller':'nrBcpContEditController'
		},
		{//租赁保理
			'state':'lease',
			'url':'/contlist',
			'default':'true',
			'templateUrl':'../html/buscont/leasefactorContAdd.html',
			'controller':'nrBcpContEditController'
		},
		{//国内保理/反保理/应收账款质押/国内保理池/应收账款质押池/出口退税池
			'state':'local',
			'url':'/contlocal',
			'default':'true',
			'templateUrl':'../html/buscont/localfactorContAdd.html',
			'controller':'nrBcpContEditController'
		}
	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('nrecBcpUnCont_mdle',dependency,routeArry);
}());

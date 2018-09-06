/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 * 非标仓单抵质押合同管理
 */
(function(){

	//跳转的路由配置
	var routeArry=[
		{
			'state':'list',
			'url':'/mongntycon_list',
			'default':'true',
			'templateUrl':'../html/mortgageContSlave/mort_cont_slave_list.html',
			'controller':'monGntyconlistController'
		},
		{
			'state':'edit',
			'url':'/mongntyconedit',
			'default':'true',
			'templateUrl':'../html/mortgageContSlave/mort_cont_slave_Add.html',
			'controller':'monGntyconeditController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bcntmongntycon',dependency,routeArry);
}());

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
			'url':'/nwrgntycon_list',
			'default':'true',
			'templateUrl':'../html/bcntnwr/nwr_gntycon_list.html',
			'controller':'nwrGntyconlistController'
		},
		{
			'state':'edit',
			'url':'/nwrgntyconedit',
			'default':'true',
			'templateUrl':'../html/bcntnwr/nwr_gntycon_edit.html',
			'controller':'nwrGntyconeditController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bcntnwrgntycon',dependency,routeArry);
}());

/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/10
 */
(function(){

	//跳转的路由配置
	var routeArry=[
		{
			'state':'cl',
			'url':'/cl_list',
			'default':'true',
			'templateUrl':'cl/cl_list.html',
			'controller':'cllistController'
		},
		{
			'state':'view',
			'url':'/cl_view',
			'templateUrl':'cl/cl_view.html',
			'controller':'clviewController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bFinCnfgCl',dependency,routeArry);
}());

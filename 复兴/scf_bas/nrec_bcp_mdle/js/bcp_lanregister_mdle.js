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
			'url':'/nrlanregisterlist',
			'default':'true',
			'templateUrl':'../html/dueregister/bcp_lanregister_list.html',
			'controller':'nrBcpLanRegisterListController'
		},
		{
			'state':'registeredit',
			'url':'/registeredit',
			'default':'true',
			'templateUrl':'../html/dueregister/bcp_lanregister_edit.html',
			'controller':'nrBcpLanRegisterEditController'
		}
	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('nrecBcpLanLnciRegister_mdle',dependency,routeArry);
}());

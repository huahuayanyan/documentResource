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
			'state':'cust',
			'url':'/cust_list',
			'default':'true',
			'templateUrl':'cust/cust_list.html',
			'controller':'custlistController'
		},
		{
			'state':'ds',
			'url':'/ds_view',
			'default':'true',
			'templateUrl':'cust/ds_view.html',
			'controller':'dsviewController'
		},
		{
			'state':'fin',
			'url':'/cust',
			'default':'true',
			'templateUrl':'cust/cust.html',
			'controller':'custController'
		},
		{
			'state':'fin.view',
			'url':'/cust_view/:mdlTyp/:finDirId/:mdlId',
			'templateUrl':'cust/cust_view.html',
			'controller':'custviewController'
		}
		
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bFinCust',dependency,routeArry);
}());

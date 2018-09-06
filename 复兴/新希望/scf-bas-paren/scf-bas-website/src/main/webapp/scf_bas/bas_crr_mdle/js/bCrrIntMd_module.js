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
			'url':'/lncdvallist',
			'default':'true',
			'templateUrl':'lncdval/lncdval_list.html',
			'controller':'lnvallistController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bCrrIntMd',dependency,routeArry);
}());

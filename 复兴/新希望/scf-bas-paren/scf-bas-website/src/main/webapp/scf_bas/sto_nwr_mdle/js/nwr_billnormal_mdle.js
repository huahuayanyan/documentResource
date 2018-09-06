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
			'url':'/billnormallist',
			'default':'true',
			'templateUrl':'../html/billnormal/bill_normal_list.html',
			'controller':'billNormallistController'
		},
		{
			'state':'editlist',
			'url':'/billnormaleditlist',
			'default':'true',
			'templateUrl':'../html/billnormal/bill_normal_addlist.html',
			'controller':'billNormaleditlistController'
		},
		{
			'state':'mortlist',
			'url':'/billnormalmortlist',
			'default':'true',
			'templateUrl':'../html/billnormal/bill_normal_mortlist.html',
			'controller':'billNormalmortlistController'
		}
	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('stoNwrBillNormal',dependency,routeArry);
}());

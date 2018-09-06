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
			'url':'/querylist',
			'default':'true',
			'templateUrl':'../html/query/query_list.html',
			'controller':'queryListController'
		},
		{
			'state':'detail',
			'url':'/querydetail',
			'default':'true',
			'templateUrl':'../html/query/query_detail.html',
			'controller':'queryDetailController'
		}
	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('stoNwrQuery',dependency,routeArry);
}());

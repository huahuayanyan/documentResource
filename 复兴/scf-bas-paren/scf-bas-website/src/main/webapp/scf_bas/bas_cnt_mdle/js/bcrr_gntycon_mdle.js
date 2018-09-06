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
			'url':'/gntycon_list',
			'default':'true',
			'templateUrl':'bcrrlncon/gntycon_list.html',
			'controller':'gntyconlistController'
		},
		{
			'state':'edit',
			'url':'/gntyconedit',
			'default':'true',
			'templateUrl':'bcrrlncon/gntycon_edit.html',
			'controller':'gntyconeditController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bcrrgntycon',dependency,routeArry);
}());

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
			'state':'subj',
			'url':'/subj_list',
			'default':'true',
			'templateUrl':'subj/subj_list.html',
			'controller':'subjlistController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bFinCnfgSubj',dependency,routeArry);
}());

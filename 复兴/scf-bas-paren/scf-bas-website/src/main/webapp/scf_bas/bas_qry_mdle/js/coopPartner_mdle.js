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
			'url':'/coopPartner_list',
			'default':'true',
			'templateUrl':'coopPartner/coopPartner_list.html',
			'controller':'coopPartnerlistController'
		}
		,{
			'state':'custcdRel',
			'url':'/coopPartner_custcdRel',
			'default':'true',
			'templateUrl':'coopPartner/custcdRelCoop.html',
			'controller':'custcdRelCoopController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bCrrPrdMdService',dependency,routeArry);
}());

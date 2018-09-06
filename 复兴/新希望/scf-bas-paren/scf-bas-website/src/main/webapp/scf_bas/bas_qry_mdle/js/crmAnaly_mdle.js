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
			'url':'/crmAnaly_list',
			'default':'true',
			'templateUrl':'crmAnaly/crmAnaly_list.html',
			'controller':'crmAnalylistController'
		}
		,{
			'state':'custcdRel',
			'url':'/crmAnaly_custcdRel',
			'templateUrl':'crmAnaly/custcdRelCrmAnaly.html',
			'controller':'custcdRelCrmAnalyController'
		}
	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('crmAnaly_mdle',dependency,routeArry);
}());

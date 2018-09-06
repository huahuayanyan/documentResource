/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 * 非标仓单抵质押合同管理
 */
(function(){

	//跳转的路由配置
	var routeArry=[
		{
			'state':'list',
			'url':'/stockAdjust_list',
			'default':'true',
			'templateUrl':'../html/standingBookMng/stockAdjustList.html',
			'controller':'stockAdjustListController'
		},
		{
			'state':'edit',
			'url':'/stockAdjust_edit',
			'default':'true',
			'templateUrl':'../html/standingBookMng/stockAdjustAdd.html',
			'controller':'stockAdjustAddController'
		},
		{
			'state':'bound',
			'url':'/stockAdjust_bound',
			'default':'true',
			'templateUrl':'../html/standingBookMng/marPri_infoList.html',
			'controller':'MarPricInfoListController'
		},
		{
			'state':'change',
			'url':'/stockAdjust_change',
			'default':'true',
			'templateUrl':'../html/standingBookMng/stockAdjustChange.html',
			'controller':'stockAdjustChangeController'
		},
		{
			'state':'update',
			'url':'/stockAdjust_update',
			'default':'true',
			'templateUrl':'../html/standingBookMng/stockAdjustUpdate.html',
			'controller':'stockAdjustUpdateController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bcntstockAdjust',dependency,routeArry);
}());

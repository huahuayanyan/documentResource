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
			'url':'/app_list',
			'default':'true',
			'templateUrl':'../html/duebill/app_list.html',
			'controller':'duebillapplistController'
		},
		{
			'state':'duebillapp',
			'url':'/duebillapp',
			'default':'true',
			'templateUrl':'../html/duebill/duebillapp.html',
			'controller':'duebillappController'
		},
		{
			'state':'duebillapp.edit',
			'url':'/duebillappedit',
			'templateUrl':'../html/duebill/app_edit.html',
			'controller':'duebillappeditController'
		},
		{
			'state':'duebillapp.lcedit',
			'url':'/duebillapplcedit',
			'templateUrl':'../html/duebill/app_lcedit.html',
			'controller':'duebillappeditController'
		},
		{
			'state':'duebillapp.ycedit',
			'url':'/duebillappycedit',
			'templateUrl':'../html/duebill/app_ycedit.html',
			'controller':'duebillappeditController'
		},
		{
			'state':'duebillapp.lcinfo',
			'url':'/duebillapplcinfo',
			'templateUrl':'../../bas_crr_mdle/html/info/lc_edit.html',
			'controller':'duebillinfoController'
		},
		{
			'state':'duebillapp.billinfo',
			'url':'/duebillappbillinfo',
			'templateUrl':'../../bas_crr_mdle/html/info/bill_list.html',
			'controller':'duebillinfoController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bCrrDuebillAppService',dependency,routeArry);
}());

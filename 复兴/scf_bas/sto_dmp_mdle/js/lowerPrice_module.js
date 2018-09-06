/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */
(function(){

	//跳转的路由配置
	var routeArry=[
		{
			'state':'list',
			'url':'/lowerpricelist',
			'default':'true',
			'templateUrl':'../html/lowerprice/lowerprice_gntycon_list.html',
			'controller':'lowerpricegntyconlistController'
		},
		//跳过guide任务基本信息tab页
		//{
		//	'state':'priceedit',
		//	'url':'/priceedit',
		//	'default':'true',
		//	'templateUrl':'../../sto_dmp_mdle/html/lowerprice/lowerprice_guide.html'
		//},
		//进入guide任务基本信息tab页
		/*{
			'state':'priceedit',
			'url':'/priceedit',
			'default':'true',
			'templateUrl':'../html/lowerprice/lowerprice.html',
			'controller':'lowerpriceController'
		},
		{
			'state':'priceedit.lowerprice',
			'url':'/lowerprice',
			'templateUrl':'../../sto_dmp_mdle/html/lowerprice/lowerprice_guide.html'
		}*/
		//一般形式
		{
			'state':'priceedit',
			'url':'/priceedit',
			'default':'true',
			'templateUrl':'../html/lowerprice/lowerprice.html',
			'controller':'lowerpriceController'
		},
		{
			'state':'priceedit.priceadjust',
			'url':'/priceadjust',
			'templateUrl':'lowerprice/priceadjust.html',
			'controller':'priceadjustController'
		},
		{
			'state':'priceedit.mrninfo',
			'url':'/mrninfo',
			'templateUrl':'lowerprice/mrninfo.html',
			'controller':'mrninfoController'
		},
		{
			'state':'priceedit.gntycon',
			'url':'/gntycon',
			'templateUrl':'lowerprice/gntycon.html',
			'controller':'gntyconController'
		},
		{
			'state':'priceedit.prtclinfo',
			'url':'/prtclinfo',
			'templateUrl':'lowerprice/prtclinfo.html',
			'controller':'prtclinfoController'
		},
		{
			'state':'priceedit.fileupload',
			'url':'/fileupload',
			'templateUrl':'lowerprice/fileupload.html',
			'controller':'fileuploadController'
		}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('lowerPriceService',dependency,routeArry);
}());

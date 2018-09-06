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

	//跳转的路由配置tab页面ID：bigData.finAmtDistrib,菜单加载总的视图页面路由ID必须为：bigData
	var routeArry=[
		{
			'state':'bigData',
			'url':'/bigData',
			'default':'true',
			'templateUrl':'../html/bigDataAnalysis/bigDataAnalysis.html',
			'controller':'bigDataAnalysisController'
		}
		//融资金额分布
		,{
			'state':'bigData.finAmtDistrib',
			'url':'/finAmtDistrib',
			'templateUrl':'../html/bigDataAnalysis/finAmtDistrib.html',
			'controller':'finAmtDistribController'
		}
		//资金迁移
		,{
			'state':'bigData.fundTransfer',
			'url':'/fundTransfer',
			'templateUrl':'../html/bigDataAnalysis/fundTransfer.html',
			'controller':'fundTransferController'
		}
	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bigDataAnalysis_mdle',dependency,routeArry);
}());

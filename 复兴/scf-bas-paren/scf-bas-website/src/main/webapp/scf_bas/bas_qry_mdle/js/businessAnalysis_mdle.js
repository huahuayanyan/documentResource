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
			'state':'business',
			'url':'/business',
			'default':'true',
			'templateUrl':'../html/businessAnalysis/businessAnalysis.html',
			'controller':'businessAnalysisController'
		}
		,{
			'state':'business.custPro',
			'url':'/custPro',
			'templateUrl':'../html/businessAnalysis/baCustPro.html',
			//'templateUrl':'../../report/htReport.html',
			'controller':'baCustProController'
		}
		//客户运营分析
		,{
			'state':'business.custOperate',
			'url':'/baCustOperate',
			'templateUrl':'../html/businessAnalysis/baCustOperate.html',
			//'templateUrl':'../../report/htReport.html',
			'controller':'baCustOperateController'
		}
		//客户信用视图
		,{
			'state':'business.custCreditResult',
			'url':'/custCreditResult',
			'templateUrl':'../html/businessAnalysis/custCreditResult.html',
			'controller':'custCreditResultController'
		}
		//贸易关系网状分析
		,{
			'state':'business.upanddownrel',
			'url':'/upanddownrel',
			//'templateUrl':'../../bas_crm_mdle/html/bcrmcore/upanddownrel_view.html',
			//'controller':'UpanddownrelViewController'
			'templateUrl':'../html/businessAnalysis/upanddownrel.html',
			'controller':'UpanddownrelController'
		}
		//主要财务指标分析
		,{
			'state':'business.custFinTarget',
			'url':'/custFinTarget',
			//'templateUrl':'../../bas_fin_mdle/html/cust/cust_view.html',
			//'controller':'custlViewController'
			'templateUrl':'../html/businessAnalysis/custFinTarget.html',
			'controller':'custFinTargetController'
		}
        //客户信用视图
		//财报查看
		,{
			'state':'custFin',
			'url':'/custFin',
			'default':'true',
			'templateUrl':'../html/businessAnalysis/custFinTab.html',
			'controller':'custFinTabController'
		},
		{
			'state':'custFin.view',
			'url':'/custFin_view/:mdlTyp/:finDirId/:mdlId',
			'templateUrl':'../html/businessAnalysis/custFinView.html',
			'controller':'custFinViewController'
		}
		//了解信用
		,{
			'state':'custCrgevalView',
			'url':'/custCrgeval',
			//'templateUrl':'../../bas_fin_mdle/html/cust/cust_view.html',
			//'controller':'custlViewController'
			'templateUrl':'../../bas_crg_mdle/html/eval/crgeval_tabview.html',
			//'controller':'custCrgevalViewController'
			'controller':'tabviewController'
		}

		
	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('businessAnalysis_mdle',dependency,routeArry);
}());

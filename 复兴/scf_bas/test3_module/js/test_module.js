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
			'state':'state',
			//'default':'true',
			'url':'/state',
			'views':[
				{   'view':"viewName1",
					'templateUrl':'mx/fkxx.html',
					'controller':'fkxxController'
				},
				{   'view':"viewName2",
					'templateUrl':'mx/tree.html',
					'controller':'mxController'
				}
			]
		},
		{
			'state':'mx.fkxx',
			'url':'/fkxx/:aaa/:bbb',
			'templateUrl':'mx/fkxx.html',
			'controller':'fkxxController'
		},
		{
			'state':'mx.jbxx',
			'url':'/jbxx/:aaa2',
			'templateUrl':'mx/jbxx.html',
			'controller':'jbxxController'
		},
		{
			'state':'mx.upload',
			'url':'/upload/:aaa3',
			'templateUrl':'mx/upload.html',
			'controller':'uploadController'
		},
		{
			'state':'mx.dbselect',
			'url':'/dbselect/:aaa4',
			'templateUrl':'mx/dbselect.html',
			'controller':'dbselectController'
		},
		{
			'state':'mx.guide',
			'url':'/guide/:aaa5',
			'templateUrl':'mx/guide.html',
			'controller':'guideController'
		},
		{
			'state':'mx.guide.aaa',
			'url':'/guide.aaa',
			'templateUrl':'mx/tree.html',
			'controller':'treeController'
		},
		{
			'state':'mx.guide.bbb',
			'url':'/guide.bbb',
			'templateUrl':'mx/dbselect.html',
			'controller':'dbselectController'
		},
		{
			'state':'mx.tips&btn',
			'url':'/tips&btn',
			'templateUrl':'mx/tips&btn.html',
			'controller':'tipsbtnController'
		},
		{
			'state':'mx.tree',
			'url':'/tree',
			'templateUrl':'mx/tree.html',
			'controller':'treeController'
		},
		{
			'state':'mx',
			'url':'/mx',
			'default':'true',
			'templateUrl':'mx/mx.html',
			'controller':'mxController'
		}

	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('testModule3',dependency,routeArry);
}());

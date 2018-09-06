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
			'url':'/nrlanlist',
			'default':'true',
			'templateUrl':'../html/lanlnci/bcp_lan_list.html',
			'controller':'nrBcpLanListController'
		},
		{
			'state':'lnciedit',
			'url':'/lnciedit',
			'default':'true',
			'templateUrl':'../html/lanlnci/bcp_lan_edit.html',
			'controller':'nrBcpLanEditController'
		},
		{
			'state':'poollnciedit',
			'url':'/poollnciedit',
			'default':'true',
			'templateUrl':'../html/lanlnci/bcp_lan_pooledit.html',
			'controller':'nrBcpLanPoolEditController'
		},
		{
			'state':'showProcess',
			'url':'/showProcess',
			'default':'true',
			'templateUrl':'../html/showProcess/showProcess.html',
			'controller':'showProcessController'
		}
	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('nrecBcpLanLnci_mdle',dependency,routeArry);
}());

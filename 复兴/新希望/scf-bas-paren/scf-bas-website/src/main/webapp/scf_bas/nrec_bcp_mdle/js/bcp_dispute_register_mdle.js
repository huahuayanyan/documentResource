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
			'url':'/list',
			'default':'true',
			'templateUrl':'../html/disputeRegister/dRegister_apply_list.html',
			'controller':'dRegisterApplyListController'
		},
		{
			'state':'tab.apply',
			'url':'/tab.apply',
			'templateUrl':'../html/disputeRegister/dispute_register_apply.html',
			'controller':'dRegisterApplyController'
		},
		{
			'state':'showProcess',
			'url':'/showProcess',
			'default':'true',
			'templateUrl':'../html/showProcess/showProcess.html',
			'controller':'showProcessController'
		},
		{
			'state':'tab',
			'url':'/tab',
			'templateUrl':'../html/disputeRegister/disputeRegister_tab.html',
			'controller':'disputeRegisterTabController'
		},
		{
			'state':'tab.fileupload',
			'url':'/tab.fileupload',
			'templateUrl':'../html/disputeRegister/dispute_fileupload_list.html',
			'controller':'disputeRegisterFileUploadController'
		}
	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bcp_dispute_register_mdle',dependency,routeArry);
}());

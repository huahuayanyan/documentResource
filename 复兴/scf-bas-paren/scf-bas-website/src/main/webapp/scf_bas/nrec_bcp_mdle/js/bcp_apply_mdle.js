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
			'url':'/nrapplylist',
			'default':'true',
			'templateUrl':'../html/busapply/bcp_apply_list.html',
			'controller':'nrBcpApplyListController'
		},
		{
			'state':'bcpApply',
			'url':'/bcpApply',
			'default':'true',
			'templateUrl':'../html/busapply/bcp_apply.html',
			'controller':'nrBcpApplyController'
		},
		{
			'state':'bcpApply.baseinfo',
			'url':'/bcpApply.baseinfo',
			'templateUrl':'../html/busapply/bcp_apply_edit.html',
			'controller':'nrBcpApplyEditController'
		},
		{
			'state':'bcpApply.detail',
			'url':'/bcpApply.detail',
			'templateUrl':'../html/busapply/bcp_apply_detail.html',
			'controller':'nrBcpApplyDetailController'
		},
		{
			'state':'bcpApply.fileupload',
			'url':'/bcpApply.fileupload',
			'templateUrl':'../html/busapply/bcp_apply_fileupload.html',
			'controller':'nrecBcpApplyFileUploadController'
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
	scubeUI.module('nrecBcpApply_mdle',dependency,routeArry);
}());

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
			'state':'returnAcct',
			'url':'/returnAcct',
			'default':'true',
			'templateUrl':'busqry/bcp_return_acct.html',
			'controller':'nrBcpReturnAcctController'
		}
	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bcp_returnAcct_mdle',dependency,routeArry);
}());

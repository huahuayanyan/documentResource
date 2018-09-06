/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
(function(){
	var parentwindow = window.parent;
    window.userInfo = parentwindow.userInfo;
    window.authorization=parentwindow.authorization;
    window.httpIpPort = parentwindow.httpIpPort;
    window.dictionary = parentwindow.dictionary;
    window._HTTP_IP_PORT = parentwindow._HTTP_IP_PORT;
    window.appNo = parentwindow.appNo;

    //跳转的路由配置
    var routeArry=[
        {
            'state':'debtback',
            'url':'/debtback',
            'templateUrl':'../html/backtransfer/debtback.html',
            'controller':'debtBackController'
        },
        {
            'state':'debtbackpool',
            'url':'/debtbackpool',
            'templateUrl':'../html/backtransfer/debtbackpool.html',
            'controller':'debtBackController'
        },
        {
            'state':'fileupload',
            'url':'/fileupload',
            'templateUrl':'../html/backtransfer/backfileupload.html',
            'controller':'backFileUploadController'
        },
        {
            'state':'debtbackguide',
            'templateUrl':'../rbcp_info_backtransferguide_module.html'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];

  scubeUI.module('rbcp_info_backtransferguide_mdle',dependency,routeArry);
  //手动拉起angular应用程序
  angular.element(document).ready(function() {
      angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
  });
        
}());

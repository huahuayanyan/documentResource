/**
 * @author 	shangxiujuan
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
    //window.source = parentwindow.source;
    window.appNo = parentwindow.appNo;
    window.processId = parentwindow.processId;
    //跳转的路由配置
    var routeArry=[
        {
            'state':'debtPoolPressDtlApp',
            'url':'/debtPoolPressDtlApp',
            'templateUrl':'debtPoolPress/debtPoolPressDtl.html',
            'controller':'debtPoolPressDtlController'
        }
    ];

    //模块的依赖加载配置
    var dependency=[
        //todo
    ];

  scubeUI.module('rbcp_debtPoolPressApp_mdle',dependency,routeArry);
  //手动拉起angular应用程序
  angular.element(document).ready(function() {
      angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
  });
        
}());

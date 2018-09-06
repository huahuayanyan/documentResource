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
    window.flag = parentwindow.flag;
    window.processId = parentwindow.processId;
    window.modelId = parentwindow.modelId;

    //跳转的路由配置
    var routeArry=[
        {
            'state':'edit',
            'url':'/app_edit',
            'templateUrl':'../html/duebill/app_edit.html',
            'controller':'duebillappeditController'
        },
        {
            'state':'lcedit',
            'url':'/app_lcedit',
            'templateUrl':'../html/duebill/app_lcedit.html',
            'controller':'duebillappeditController'
        },
        {
            'state':'ycedit',
            'url':'/app_ycedit',
            'templateUrl':'../html/duebill/app_ycedit.html',
            'controller':'duebillappeditController'
        },
        {
            'state':'lcinfo',
            'url':'/applcinfo',
            'templateUrl':'../html/info/lc_edit.html',
            'controller':'duebillinfoController'
        },
        {
            'state':'billinfo',
            'url':'/appbillinfo',
            'templateUrl':'../html/info/bill_list.html',
            'controller':'duebillinfoController'
        },
        {
            'state':'duebillguide',
            'templateUrl':'duebillappguide_module.html'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];

  scubeUI.module('duebillappguideMdle',dependency,routeArry);
  //手动拉起angular应用程序
  angular.element(document).ready(function() {
      angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
  });
        
}());

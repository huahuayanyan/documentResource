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
    window.source = parentwindow.source;
    window.appNo = parentwindow.appNo;

    //跳转的路由配置
    var routeArry=[
        {
            'state':'priceadjust',
            'url':'/priceadjust',
            'templateUrl':'lowerprice/priceadjust.html',
            'controller':'priceadjustController'
        },
        {
            'state':'mrninfo',
            'url':'/mrninfo',
            'templateUrl':'lowerprice/mrninfo.html',
            'controller':'mrninfoController'
        },
        {
            'state':'gntycon',
            'url':'/gntycon',
            'templateUrl':'lowerprice/gntycon.html',
            'controller':'gntyconController'
        },
        {
            'state':'prtclinfo',
            'url':'/prtclinfo',
            'templateUrl':'lowerprice/prtclinfo.html',
            'controller':'prtclinfoController'
        },
        {
            'state':'lowerpriceguide',
            'templateUrl':'lowerpriceguide_mdle.html'
        },
        {
            'state':'fileupload',
            'url':'/fileupload',
            'templateUrl':'lowerprice/fileupload.html',
            'controller':'fileuploadController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];

  scubeUI.module('lowerpriceguideMdle',dependency,routeArry);
  //手动拉起angular应用程序
  angular.element(document).ready(function() {
      angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
  });
        
}());

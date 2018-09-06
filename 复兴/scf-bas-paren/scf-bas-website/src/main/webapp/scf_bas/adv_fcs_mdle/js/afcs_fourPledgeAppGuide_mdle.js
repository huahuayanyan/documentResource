/**
 * @author 	shangxiujuan
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/16
 */
(function(){
	var parentwindow = window.parent;
    window.userInfo = parentwindow.userInfo;
    window.authorization=parentwindow.authorization;
    window.httpIpPort = parentwindow.httpIpPort;
    window.dictionary = parentwindow.dictionary;
    window._HTTP_IP_PORT = parentwindow._HTTP_IP_PORT;
    window.appNo = parentwindow.appNo;
    window.processId = parentwindow.processId;
    //跳转的路由配置
    var routeArry=[

        {
            'state':'fourPledgeAppdtl',
            'url':'/fourPledgeApp.dtl',
            'templateUrl':'afcsfourPledge/fourPledgeDtl.html',
            'controller':'fourPledgeDtlController'
        },
        {
            'state':'fourPledgeAppPrice',
            'url':'/fourPledgeApp.pric',
            'templateUrl':'afcsfourPledge/fourPledgePrice.html',
            'controller':'fourPledgePriceController'
        },
        {
            'state':'gntyconInfo',
            'url':'/fourPledgeApp.gntyconInfo',
            'templateUrl':'../html/afcsfour/gntyconInfo.html',
            'controller':'gntyconInfoController'
        },
        {
            'state':'monitorProtocol',
            'url':'/fourPledgeApp.monitorProtocol',
            'templateUrl':'../html/afcsfour/monitorProtocol.html',
            'controller':'monitorProtocolController'
        },
        {
            'state':'custInfo',
            'url':'/fourPledgeApp.custInfo',
            'templateUrl':'../html/afcsfour/custInfo.html',
            'controller':'custInfoController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];

  scubeUI.module('afcsfourPledgeAppGuideMdle',dependency,routeArry);
  //手动拉起angular应用程序
  angular.element(document).ready(function() {
      angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
  });
        
}());

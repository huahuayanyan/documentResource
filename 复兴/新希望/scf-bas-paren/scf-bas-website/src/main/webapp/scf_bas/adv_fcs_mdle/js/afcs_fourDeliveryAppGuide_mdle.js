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
            'state':'fourDeliveryDtl',
            'url':'/fourDeliveryApply_dtl',
            'templateUrl':'afcsfourDelivery/fourDeliveryDtl.html',
            'controller':'fourDeliveryDtlController'
        },
        {
            'state':'fourDeliveryMrninfo',
            'url':'/fourDeliveryApply_mrninfo',
           // 'templateUrl':'../../sto_dmp_mdle/html/lowerprice/mrninfo.html',
            'templateUrl':'afcsfourDelivery/appendBailAmount.html',
            'controller':'mrnDeliveryController'
        },
        {
            'state':'fourDeliveryFileupload',
            'url':'/fileupload',
            'templateUrl':'../../sto_dmp_mdle/html/lowerprice/fileupload.html',
            'controller':'fileuploadController'
        },
        {
            'state':'monitorProtocol',
            'url':'/fourDeliveryApply.monitorProtocol',
            'templateUrl':'../html/afcsfour/monitorProtocol.html',
            'controller':'monitorProtocolController'
        },
        {
            'state':'gntyconInfo',
            'url':'/fourDeliveryApply.gntyconInfo',
            'templateUrl':'../html/afcsfour/gntyconInfo.html',
            'controller':'gntyconInfoController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];

  scubeUI.module('afcsfourDeliveryAppGuideMdle',dependency,routeArry);
  //手动拉起angular应用程序
  angular.element(document).ready(function() {
      angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
  });
        
}());

/**
 * Created by gongzhao on 2017/04/12.
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
            'state':'adjustPriceApplicationAdjust',
            'url':'/adjustPriceApplication_adjustPrice',
            'templateUrl':'priceadjust/adjustPriceApplicationAdjustPrice.html',
            'controller':'adjustPriceApplicationAdjustPriceController'
        },
        {
            'state':'adjustPriceApplicationMc',
            'url':'/adjustPriceApplication_mortgageCont',
            'templateUrl':'priceadjust/adjustPriceApplicationMortgageCont.html',
            'controller':'adjustPriceApplicationMortgageContController'
        },
        {
            'state':'adjustPriceApplicationMp',
            'url':'/adjustPriceApplication_mntProtocol',
            'templateUrl':'priceadjust/adjustPriceApplicationMntProtocol.html',
            'controller':'adjustPriceApplicationMntProtocolController'
        },
        {
            'state':'adjustPriceApplicationCi',
            'url':'/adjustPriceApplication_custInfo',
            'templateUrl':'priceadjust/adjustPriceApplicationCustInfo.html',
            'controller':'adjustPriceApplicationCustInfoController'
        }
		
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('adjustPriceApplication',dependency,routeArry)
    //手动拉起angular应用程序
    angular.element(document).ready(function() {
        angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
    });
        
}());

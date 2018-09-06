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
            'templateUrl':'adjustpricebill/adjustPriceApplicationAdjustPrice.html',
            'controller':'adjustPriceApplicationAdjustPriceController'
        },
        {//仓单质押监管协议
			'state':'adjustPriceApplicationProtocol',
			'url':'/adjustPriceApplicationProtocol',
			'templateUrl':'../html/nwrinfo/nwrinfo_protocol.html',
			'controller':'nwrinfoProtocolController'
		},
		{//出质人信息
			'state':'adjustPriceApplicationCust',
			'url':'/adjustPriceApplicationCust',
			'templateUrl':'../html/nwrinfo/nwrinfo_cust.html',
			'controller':'nwrinfoCustController'
		},
		{//监管商信息
			'state':'adjustPriceApplicationMonicust',
			'url':'/adjustPriceApplicationMonicust',
			'templateUrl':'../html/nwrinfo/nwrinfo_monicust.html',
			'controller':'nwrinfoProtocolController'
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

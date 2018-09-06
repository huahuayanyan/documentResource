/**
 * Created by gongzhao on 2017/04/12.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'adjustPriceApplyMain',
            'url':'/adjustPriceApplyMain',
            'default':'true',
            'templateUrl':'adjustpricebill/adjustPriceApplyMain.html',
            'controller':'adjustPriceApplyMainController'
        },
        {
            'state':'adjustPriceApplication',
            'url':'/adjustPriceApplication',
            'default':'true',
            'templateUrl':'adjustpricebill/adjustPriceApplication.html',
            'controller':'adjustPriceApplicationController'
        },
        {
            'state':'adjustPriceApplication.adjustPrice',
            'url':'/adjustPriceApplication_adjustPrice',
            'default':'true',
            'templateUrl':'adjustpricebill/adjustPriceApplicationAdjustPrice.html',
            'controller':'adjustPriceApplicationAdjustPriceController'
        },
		{//仓单质押监管协议
			'state':'adjustPriceApplication.protocol',
			'url':'/adjustPriceApplication.protocol',
			'templateUrl':'../html/nwrinfo/nwrinfo_protocol.html',
			'controller':'nwrinfoProtocolController'
		},
		{//出质人信息
			'state':'adjustPriceApplication.cust',
			'url':'/adjustPriceApplication.cust',
			'templateUrl':'../html/nwrinfo/nwrinfo_cust.html',
			'controller':'nwrinfoCustController'
		},
		{//监管商信息
			'state':'adjustPriceApplication.monicust',
			'url':'/adjustPriceApplication.monicust',
			'templateUrl':'../html/nwrinfo/nwrinfo_monicust.html',
			'controller':'nwrinfoProtocolController'
		}
		
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('mortgageMntProtocol',dependency,routeArry)
}());

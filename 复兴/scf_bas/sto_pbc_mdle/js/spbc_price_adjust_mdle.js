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
            'templateUrl':'priceadjust/adjustPriceApplyMain.html',
            'controller':'adjustPriceApplyMainController'
        },
        {
            'state':'adjustPriceApplication',
            'url':'/adjustPriceApplication',
            'default':'true',
            'templateUrl':'priceadjust/adjustPriceApplication.html',
            'controller':'adjustPriceApplicationController'
        },
        {
            'state':'adjustPriceApplication.adjustPrice',
            'url':'/adjustPriceApplication_adjustPrice',
            'default':'true',
            'templateUrl':'priceadjust/adjustPriceApplicationAdjustPrice.html',
            'controller':'adjustPriceApplicationAdjustPriceController'
        },
        {
            'state':'adjustPriceApplication.mortgageCont',
            'url':'/adjustPriceApplication_mortgageCont',
            'default':'true',
            'templateUrl':'priceadjust/adjustPriceApplicationMortgageCont.html',
            'controller':'adjustPriceApplicationMortgageContController'
        },
        {
            'state':'adjustPriceApplication.mntProtocol',
            'url':'/adjustPriceApplication_mntProtocol',
            'default':'true',
            'templateUrl':'priceadjust/adjustPriceApplicationMntProtocol.html',
            'controller':'adjustPriceApplicationMntProtocolController'
        },
        {
            'state':'adjustPriceApplication.custInfo',
            'url':'/adjustPriceApplication_custInfo',
            'default':'true',
            'templateUrl':'priceadjust/adjustPriceApplicationCustInfo.html',
            'controller':'adjustPriceApplicationCustInfoController'
        }
		
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('mortgageMntProtocol',dependency,routeArry)
}());

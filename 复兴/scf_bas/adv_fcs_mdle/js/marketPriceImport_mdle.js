/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'marketPriceQuery',
            'url':'/marketPriceQuery',
            'default':'true',
            'templateUrl':'marketPriceImport/baiInfoMarketPriceQry.html',
            'controller':'marketPriceQueryController'
        },
        {
            'state':'historyQuery',
            'url':'/historyQuery',
            'templateUrl':'marketPriceImport/mortgageMarketPrice_HisQry.html',
            'controller':'historyQueryController'
        },


    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bcntbuyindoModule',dependency,routeArry)
}());

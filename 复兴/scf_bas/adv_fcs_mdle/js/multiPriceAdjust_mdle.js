/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'multiPriceAdjust',
            'url':'/multiPriceAdjust',
            'default':'true',
            'templateUrl':'multiPriceAdjust/multiPriceAdjust_Apply_Info.html',
            'controller':'multiPriceAdjustController'
        },

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bcntbuyindoModule',dependency,routeArry)
}());

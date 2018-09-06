/**
 * Created by htrad0036 on 2017/2/21.
 */

(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'mortAPTQuery',
            'url':'/mortAPTQuery',
            'default':'true',
            'templateUrl':'mortAdjustPriceTypeQuery/mortAPTQry_list.html',
            'controller':'mortAPTQueryListController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('sto_smp_mdle',dependency,routeArry);
}());
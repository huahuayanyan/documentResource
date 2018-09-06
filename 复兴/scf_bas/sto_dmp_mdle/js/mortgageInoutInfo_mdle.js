/**
 * Created by htrad0036 on 2017/2/21.
 */

(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'mortgageInoutInfo',
            'url':'/mortgageInoutInfo',
            'default':'true',
            'templateUrl':'mortgageInoutInfo/mortgageInoutInfo_qry.html',
            'controller':'mortgageInoutInfoController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_qry_mdle',dependency,routeArry);
}());
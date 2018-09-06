/**
 * Created by htrad0036 on 2017/2/21.
 */

(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'stockAccountQuery',
            'url':'/stockAccountQuery',
            'default':'true',
            'templateUrl':'stockAccountQuery/stockAccount_qry.html',
            'controller':'stockAccountQueryController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('sto_smp_mdle',dependency,routeArry);
}());
/**
 * Created by htrad0036 on 2017/2/21.
 */

(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'unConfirmPayWarn',
            'url':'/unConfirmPayWarn',
            'default':'true',
            'templateUrl':'noConfirmPayWarn/noConfirmPayWarn.html',
            'controller':'NoConfirmPayWarnController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_wrn_mdle',dependency,routeArry);
}());
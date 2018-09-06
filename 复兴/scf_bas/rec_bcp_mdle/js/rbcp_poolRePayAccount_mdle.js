/**
 * Created by htrad0001 on 2017/1/11.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'poolRePayMain',
            'url':'/poolRePayMain',
            'default':'true',
            'templateUrl':'poolRePay/poolRePayMain.html',
            'controller':'poolRePayMainController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('rbcpPoolRePayAccountMdle',dependency,routeArry)
}());

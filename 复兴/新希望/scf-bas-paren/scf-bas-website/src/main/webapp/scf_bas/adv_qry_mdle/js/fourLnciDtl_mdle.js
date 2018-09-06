/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'fourLnciDtlList',
            'url':'/fourLnciDtlList',
            'default':'true',
            'templateUrl':'fourLnciDtl/fourLnciDtlList.html',
            'controller':'fourLnciDtlListController'
        },
        {
            'state':'trLnContInfo',
            'url':'/trLnContInfo',
            'templateUrl':'fourLnciDtl/trLnContInfo.html',
            'controller':'trLnContInfoController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('fourLnciDtl',dependency,routeArry)
}());

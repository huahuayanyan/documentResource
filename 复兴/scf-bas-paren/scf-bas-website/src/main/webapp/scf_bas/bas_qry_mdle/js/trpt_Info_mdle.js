/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'trptInfoList',
            'url':'/trptInfoList',
            'default':'true',
            'templateUrl':'trpt/trptInfoList.html',
            'controller':'trptInfoListController'
        },
        {
            'state':'trLnContInfo',
            'url':'/trLnContInfo',
            'templateUrl':'trpt/trLnContInfo.html',
            'controller':'trLnContInfoController'
        },
        {
            'state':'trptInfoDtl',
            'url':'/trptInfoDtl',
            'templateUrl':'trpt/trptInfoDtl.html',
            'controller':'trptInfoDtlController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('trptInfoList',dependency,routeArry)
}());

/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'list',
            'url':'/list',
            'default':'true',
            'templateUrl':'../html/querylimits/query_limits_list.html',
            'controller':'queryLimitsListController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('query_limits_mdle',dependency,routeArry)
}());
/**
 * Created by htrad0016 on 2016/8/23.
 * 间接额度领用
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'drawqryList',
            'url':'/drawqryList',
            'default':'true',
            'templateUrl':'bicrinfodrawqry/drawqryList.html',
            'controller':'drawqryListController'

        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bicrinfodrawqryModule',dependency,routeArry)
}());

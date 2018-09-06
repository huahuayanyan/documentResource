/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'bicrprd',
            'url':'/bicrprd',
            'default':'true',
            'templateUrl':'bicrprd/bicrprdList.html',
            'controller':'bicrprdListController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bicrprdModule',dependency,routeArry)
}());

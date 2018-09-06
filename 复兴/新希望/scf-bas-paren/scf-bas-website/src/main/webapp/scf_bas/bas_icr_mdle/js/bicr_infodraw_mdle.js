/**
 * Created by htrad0016 on 2016/8/23.
 * 间接额度领用
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'drawList',
            'url':'/drawList',
            'default':'true',
            'templateUrl':'bicrinfodraw/drawList.html',
            'controller':'drawListController'

        },
        {
            'state':'drawApply',
            'url':'/drawApply',
            'templateUrl':'bicrinfodraw/drawApply.html',
            'controller':'drawApplyController'

        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bicrinfodrawModule',dependency,routeArry)
}());

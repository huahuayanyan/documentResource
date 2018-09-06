/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'bicrtype',
            'url':'/bicrtype',
            'default':'true',
            'templateUrl':'bicrtype/bicrtype.html',
            'controller':'bicrtypeController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bicrtypeModule',dependency,routeArry)
}());

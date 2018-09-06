/**
 * Created by huangshuidan on 2016/11/11.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'bsyscanceltask',
            'url':'/bsyscanceltask',
            'default':'true',
            'templateUrl':'bsyscanceltask/bsys_canceltask.html',
            'controller':'bsysCancelTaskController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('bsysCancelTaskModule',dependency,routeArry)
}());

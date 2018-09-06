
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'task',
            'url':'/task',
            'default':'true',
            'templateUrl':'../html/bsysautotask/task.html',
            'controller':'proController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('autotask_man',dependency,routeArry);
}());

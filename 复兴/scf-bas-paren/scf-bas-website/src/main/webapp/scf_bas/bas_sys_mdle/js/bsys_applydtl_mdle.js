/**
 * Created by huangshuidan on 2016/11/11.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'bsysapplydtl',
            'url':'/bsysapplydtl',
            'default':'true',
            'templateUrl':'bsysapplydtl/bsys_applydtl.html',
            'controller':'bsysApplyDtlController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('bsystaskModule',dependency,routeArry)
}());

/**
 * Created by fangquan on 2017/06/17.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'pro',
            'url':'/pro',
            'default':'true',
            'templateUrl':'../html/bsysglobalinfo/pro.html',
            'controller':'proController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    
    scubeUI.module('s_product_man',dependency,routeArry)
}());

/**
 * Created by htrad0055 on 2017/4/18.
 */

(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'unPatrolStrore',
            'url':'/unPatrolStrore',
            'default':'true',
            'templateUrl':'unPatrolStoreWarn/unPatrolStoreWarn.html',
            'controller':'UnPatrolStoreWarnController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_wrn_mdle',dependency,routeArry);
}());
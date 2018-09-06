/**
 * Created by htrad0016 on 2016/8/23.
 * 间接额度领用
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'recoverList',
            'url':'/recoverList',
            'default':'true',
            'templateUrl':'bicrinforecover/recoverList.html',
            'controller':'recoverListController'

        },
        {
            'state':'recoverApply',
            'url':'/recoverApply',
            'templateUrl':'bicrinforecover/recoverApply.html',
            'controller':'recoverApplyController'

        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bicrinforecoverModule',dependency,routeArry)
}());

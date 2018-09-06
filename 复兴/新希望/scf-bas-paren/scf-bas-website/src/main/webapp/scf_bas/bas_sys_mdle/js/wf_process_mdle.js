/**
 * Created by htrad0036 on 2017/3/15.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'wfProcess',
            'url':'/wfProcess',
            'default':'true',
            'templateUrl':'workFlowProcess/wf_process_list.html',
            'controller':'wfProcessController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];



    scubeUI.module('wfProcessModule',dependency,routeArry)
}());

/**
 * Created by htrad0036 on 2017/2/21.
 */

(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'inspectWhseMng',
            'url':'/inspectWhseMng',
            'default':'true',
            'templateUrl':'inspectWhseMng/inspectWhseMng_list.html',
            'controller':'inspectWhseMngListController'
        },
        {
            'state':'inspectWhseMngQry',
            'url':'/inspectWhseMngQry',
            'templateUrl':'inspectWhseMng/inspectWhseMng_qry.html',
            'controller':'inspectWhseMngQryController'
        },
        {
            'state':'tree',
            'url':'/tree',
            'templateUrl':'inspectWhseMng/base_tree.html',
            'controller':'BaseTreeController'
        },
        {
            'state':'tree.iWhseDetail',
            'url':'/tree.iWhseDetail',
            'templateUrl':'inspectWhseMng/iWhse_detail.html',
            'controller':'iWhseDetailController'
        },
        {
            'state':'tree.contSlave',
            'url':'/tree.contSlave',
            'templateUrl':'inspectWhseMng/contSlave_detail.html',
            'controller':'contSlvaeDetailController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('sto_smp_mdle',dependency,routeArry);
}());
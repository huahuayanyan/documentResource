/**
 * Created by htrad0036 on 2017/2/21.
 */

(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'stockListImportApply',
            'url':'/stockListImportApply',
            'default':'true',
            'templateUrl':'stockListImportApply/stockListImportApply_qry.html',
            'controller':'stockListImportApplyController'
        },
        {
            'state':'stockImportApply',
            'url':'/stockImportApply',
            'templateUrl':'stockListImportApply/stockImport_apply.html',
            'controller':'stockImportApplyController'
        },
        {
            'state':'stockImportApply.import',
            'url':'/stockImportApply.import',
            'templateUrl':'stockListImportApply/stockImportApply_import.html',
            'controller':'stockImportApplyImportController'
        },
        {
            'state':'stockImportApply.slave',
            'url':'/stockImportApply.slave',
            'templateUrl':'stockListImportApply/gntycon_view.html',
            'controller':'gntyconViewController'
        },
        {
            'state':'stockImportApply.protocol',
            'url':'/stockImportApply.protocol',
            'templateUrl':'stockListImportApply/monitorProtocol.html',
            'controller':'monitorProtocolController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('sto_dmp_mdle',dependency,routeArry);
}());
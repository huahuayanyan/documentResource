/**
 * Created by htrad0036 on 2017/2/21.
 */

(function(){
    var parentwindow = window.parent;
    window.userInfo = parentwindow.userInfo;
    window.authorization=parentwindow.authorization;
    window.httpIpPort = parentwindow.httpIpPort;
    window.dictionary = parentwindow.dictionary;
    window._HTTP_IP_PORT = parentwindow._HTTP_IP_PORT;
    window.appNo = parentwindow.appNo;
    window.processId = parentwindow.processId;

    //跳转的路由配置
    var routeArry=[
        {
            'state':'stockImportApplyImport',
            'url':'/stockImportApplyImport',
            'templateUrl':'stockListImportApply/stockImportApply_import.html',
            'controller':'stockImportApplyImportController'
        },
        {
            'state':'stockImportApplySlave',
            'url':'/stockImportApplySlave',
            'templateUrl':'stockListImportApply/gntycon_view.html',
            'controller':'gntyconViewController'
        },
        {
            'state':'stockImportApplyProtocol',
            'url':'/stockImportApplyProtocol',
            'templateUrl':'stockListImportApply/monitorProtocol.html',
            'controller':'monitorProtocolController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('sto_dmp_mdle',dependency,routeArry);
    //手动拉起angular应用程序
    angular.element(document).ready(function() {
        angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
    });
}());
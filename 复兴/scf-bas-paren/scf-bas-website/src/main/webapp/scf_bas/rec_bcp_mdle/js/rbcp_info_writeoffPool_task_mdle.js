/**
 * Created by htrad0039 on 2017/1/7.
 */

(function(){
    //跳转的路由配置
    var parentwindow = window.parent;
    window.userInfo = parentwindow.userInfo;
    window.authorization=parentwindow.authorization;
    window.httpIpPort = parentwindow.httpIpPort;
    window.dictionary = parentwindow.dictionary;
    window._HTTP_IP_PORT = parentwindow._HTTP_IP_PORT;
    window.appNo = parentwindow.appNo;
    window.processId = parentwindow.processId;
    var routeArry=[
        {
            'state':'writeoffPoolRequest',
            'url':'/writeoffPoolRequest',
            'templateUrl':'writeoffPool/writeoffRequest.html',
            'controller':'writeoffRequestController'

        }
    ];
    var dependency=[
        //todo
    ];
    scubeUI.module('rbcpinfowriteoffpooltaskmdle',dependency,routeArry);
    //手动拉起angular应用程序
    angular.element(document).ready(function() {
        angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
    });
}());


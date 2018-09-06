/**
 * Created by htrad0039 on 2017/1/7.
 */

(function(){
    //��ת��·������
    var parentwindow = window.parent;
    window.userInfo = parentwindow.userInfo;
    window.authorization=parentwindow.authorization;
    window.httpIpPort = parentwindow.httpIpPort;
    window.dictionary = parentwindow.dictionary;
    window._HTTP_IP_PORT = parentwindow._HTTP_IP_PORT;
    window.appNo = parentwindow.appNo;
    var routeArry=[


    ];
    var dependency=[
        //todo
    ];
    scubeUI.module('rbcpimpairmenttaskmdle',dependency,routeArry);
    //�ֶ�����angularӦ�ó���
    angular.element(document).ready(function() {
        angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
    });
}());


/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */
(function(){
    var parentwindow = window.parent;
    window.userInfo = parentwindow.userInfo;
    window.authorization=parentwindow.authorization;
    window.httpIpPort = parentwindow.httpIpPort;
    window.dictionary = parentwindow.dictionary;
    window._HTTP_IP_PORT = parentwindow._HTTP_IP_PORT;
    window.appNo = parentwindow.appNo;

    //跳转的路由配置
    var routeArry=[
        {
            'state':'debtinpoolguide',
            'url':'/debtinpoolguide',
            'templateUrl':'debtInPool/debtInPool_edit.html',
            'controller':'debtInPoolEditController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('rbcp_info_debtInPoolGuide_mdle',dependency,routeArry);
    //手动拉起angular应用程序
    angular.element(document).ready(function() {
        angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
    });

}());
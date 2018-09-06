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

    //跳转的路由配置
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
            'state':'dsptBillModify',
            'url':'/dsptBillModify',
            'templateUrl':'poolDisputeRemove/dsptBillModify.html',
            'controller':'dsptBillModifyController'
        },
        {
            'state':'progress',
            'url':'/progress',
            'templateUrl':'manage/bcp_progress_list.html',
            'controller':'ProgressController'
        },
        {
            'state':'bcpBaseInfo',
            'url':'/bcp_base_info_list',
            'templateUrl':'debtPoolTransfer/bcp_base_info_list.html',
            'controller':'BcpBaseInfoController'
        },
        {
            'state':'disputeRemoveApply',
            'url':'/disputeRemoveApply',
            'templateUrl':'appli/disputeRemoveApply.html',
            'controller':'disputeRemoveApplyController'
        },
        {
            'state':'disputeRemove',
            'url':'/disputeRemove',
            'templateUrl':'appli/disputeRemove.html',
            'controller':'disputeRemoveController'
        },

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];

    scubeUI.module('disputeRem_apply_mdle',dependency,routeArry);
    //手动拉起angular应用程序
     angular.element(document).ready(function() {
     angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
     });
}());
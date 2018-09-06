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
    var routeArry=[
        {
            'state':'list',
            'url':'/debtpresslist',
            'default':'true',
            'templateUrl':'../html/debtPress/bcp_press_list.html',
            'controller':'nrecBcpPressListController'
        },
        {
            'state':'pressedit',
            'url':'/debtpresslist',
            'default':'true',
            'templateUrl':'../html/debtPress/bcp_press_edit.html',
            'controller':'nrecBcpPressEditController'
        },
        {
            'state':'showProcess',
            'url':'/showProcess',
            'default':'true',
            'templateUrl':'../html/showProcess/showProcess.html',
            'controller':'showProcessController'
        }

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('nrecBcpDebtPress_mdle',dependency,routeArry);
}());
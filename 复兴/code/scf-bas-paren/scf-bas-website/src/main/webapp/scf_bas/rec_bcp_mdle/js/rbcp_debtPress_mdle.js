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
            'state':'debtConList',
            'url':'/debtConList',
            'default':'true',
            'templateUrl':'debtPress/debtConList.html',
            'controller':'debtConListController'
        },
        {
            'state':'debtPressDtl',
            'url':'/debtPressDtl',
            'templateUrl':'debtPress/debtPressDtl.html',
            'controller':'debtPressDtlController'
        }


    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('rbcp_debtPress_mdle',dependency,routeArry);
}());
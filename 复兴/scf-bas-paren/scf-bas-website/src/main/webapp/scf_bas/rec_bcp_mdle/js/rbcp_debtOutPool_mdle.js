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
            'state':'debtPoolConList',
            'url':'/debtPoolConList',
            'default':'true',
            'templateUrl':'debtOutPool/debtPoolConList.html',
            'controller':'debtPoolConListController'
        },
        {
            'state':'debtOutPoolDtl',
            'url':'/debtOutPoolDtl',
            'templateUrl':'debtOutPool/debtOutPoolDtl.html',
            'controller':'debtOutPoolDtlController'
        }/*,
        {
            'state':'debtPoolPressDtlUpdate',
            'url':'/debtPoolPressDtlUpdate',
            'templateUrl':'debtPoolPress/debtPoolPressDtlSet.html',
            'controller':'DebtPressDtlUpdateController'
        },
        {
            'state':'bcpBaseInfo',
            'url':'/bcp_base_info_list',
            'templateUrl':'debtPress/bcp_base_info_list.html',
            'controller':'BcpBaseInfoController'
        },*/


    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('rbcp_debtOutPool_mdle',dependency,routeArry);
}());
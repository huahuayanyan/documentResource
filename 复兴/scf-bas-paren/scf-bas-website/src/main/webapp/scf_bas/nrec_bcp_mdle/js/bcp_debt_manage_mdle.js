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
            'state':'bcpInfoList',
            'url':'/bcpInfoList',
            'default':'true',
            'templateUrl':'debtmanage/bcp_debt_list.html',
            'controller':'DebtInfoListController'
        },
        {
            'state':'debtInfoEdit',
            'url':'/debtInfoEdit',
            'templateUrl':'debtmanage/bcp_debt_edit.html',
            'controller':'DebtInfoEditController'
        },
        {
            'state':'progress',
            'url':'/progress',
            'templateUrl':'debtmanage/bcp_debt_progress_list.html',
            'controller':'DebtInfoProgressController'
        },

    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('rbcp_info_manage_mdle',dependency,routeArry);
}());
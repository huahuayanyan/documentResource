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
            'state':'base',
            'url':'/base_list',
            'default':'true',
            'templateUrl':'bcrmflc/flc_list.html',
            'controller':'FlcListController'
        },
        {
            'state':'tree',
            'url':'/tree',
            'templateUrl':'bcrmflc/flc_tree.html',
            'controller':'FlcTreeController'
        },
        {
            'state':'tree.basic',
            'url':'/tree_basic',
            'templateUrl':'bcrmflc/tab_basicInfo.html',
            'controller':'TabBasicInfoController'
        },
        {
            'state':'tree.acct',
            'url':'/tree_acct',
            'templateUrl':'bcrmflc/tab_acctList.html',
            'controller':'TabAcctListController'
        },
        {
            'state':'accAdd',
            'url':'/acc_add',
            'templateUrl':'bcrmflc/acct_add.html',
            'controller':'AccInfoAddController'
        },
        {
            'state':'orgcode',
            'url':'/orgcode',
            'templateUrl':'bcrmflc/orgcode_dialog.html',
            'controller':'OrgCodeDialogController'
        }

    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bcrm_flc_mdle',dependency,routeArry);
}());
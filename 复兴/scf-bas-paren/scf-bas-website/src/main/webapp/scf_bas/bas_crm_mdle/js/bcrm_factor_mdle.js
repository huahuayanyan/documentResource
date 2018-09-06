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
            'templateUrl':'bcrmfactor/factor_list.html',
            'controller':'FactorListController'
        },
        {
            'state':'tree',
            'url':'/tree',
            'templateUrl':'bcrmfactor/factor_tree.html',
            'controller':'FactorTreeController'
        },
        {
            'state':'tree.basic',
            'url':'/tree_basic',
            'templateUrl':'bcrmfactor/tab_basicInfo.html',
            'controller':'TabBasicInfoController'
        },
        {
            'state':'tree.acct',
            'url':'/tree_acct',
            'templateUrl':'bcrmfactor/tab_acctList.html',
            'controller':'TabAcctListController'
        },
        {
            'state':'tree.relation',
            'url':'/tree_relation',
            'templateUrl':'bcrmfactor/tab_relationList.html',
            'controller':'TabRelationListController'
        },
        {
            'state':'orgcode',
            'url':'/orgcode',
            'templateUrl':'bcrmfactor/orgcode_dialog.html',
            'controller':'OrgCodeController'
        },
        {
            'state':'accAdd',
            'url':'/acc_add',
            'templateUrl':'bcrmfactor/acc_add.html',
            'controller':'AccInfoAddController'
        }


    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bcrm_insure_mdle',dependency,routeArry);
}());
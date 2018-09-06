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
            'templateUrl':'bcrminsure/insure_list.html',
            'controller':'InsureListController'
        },
        {
            'state':'tree',
            'url':'/tree',
            'templateUrl':'bcrminsure/insure_tree.html',
            'controller':'InsureTreeController'
        },
        {
            'state':'tree.basic',
            'url':'/tree_basic',
            'templateUrl':'bcrminsure/info_basic.html',
            'controller':'InsureBasicController'
        },
        {
            'state':'tree.acct',
            'url':'/tree_acct',
            'templateUrl':'bcrminsure/info_acctList.html',
            'controller':'AccInfoListController'
        },
        {
            'state':'tree.relation',
            'url':'/tree_relation',
            'templateUrl':'bcrminsure/info_relationList.html',
            'controller':'RelationListController'
        },
        {
            'state':'orgcode',
            'url':'/orgcode',
            'templateUrl':'bcrminsure/orgcode_dialog.html',
            'controller':'OrgCodeController'
        }


    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bcrm_insure_mdle',dependency,routeArry);
}());
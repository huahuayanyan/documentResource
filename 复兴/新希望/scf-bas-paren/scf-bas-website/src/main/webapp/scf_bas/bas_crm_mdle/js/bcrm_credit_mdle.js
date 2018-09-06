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
            'templateUrl':'bcrmcredit/base_list.html',
            'controller':'BaseListController'
        },
        {
            'state':'tree',
            'url':'/tree',
            'templateUrl':'bcrmcredit/base_tree.html',
            'controller':'BaseTreeController'
        },
        {
            'state':'tree.add',
            'url':'/base_add',
            'templateUrl':'bcrmcredit/base_add.html',
            'controller':'BaseAddController'
        },        
        {
            'state':'orgcode',
            'url':'/orgcode',
            'templateUrl':'bcrmcredit/orgcode_validate.html',
            'controller':'OrgCodeController'
        },
        {
            'state':'tree.anal',
            'url':'/anal_list',
            'templateUrl':'bcrmcredit/anal_list.html',
            'controller':'AnalListController'
        },
        {
            'state':'analAdd',
            'url':'/anal_add',
            'templateUrl':'bcrmcredit/anal_add.html',
            'controller':'AnalAddController'
        },
        {
            'state':'tree.acc',
            'url':'/acc_list',
            'templateUrl':'bcrmcredit/acc_list.html',
            'controller':'AccInfoListController'
        },
        {
            'state':'accAdd',
            'url':'/acc_add',
            'templateUrl':'bcrmcredit/acc_add.html',
            'controller':'AccInfoAddController'
        },
        {
            'state':'tree.attach',
            'url':'/attachment_info',
            'templateUrl':'bcrmcredit/attachment_info.html',
            'controller':'AttInfoController'
        },
        {
        	'state':'tree.tag',
        	'url':'/bcrm_tag',
        	'templateUrl':'bcrmcredit/bcrm_tag.html',
        	'controller':'BcrmTagController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bcrm_credit_mdle',dependency,routeArry);
}());
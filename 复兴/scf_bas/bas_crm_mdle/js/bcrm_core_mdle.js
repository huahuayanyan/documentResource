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
            'templateUrl':'bcrmcore/base_list.html',
            'controller':'BaseListController'
        },
        {
            'state':'tree',
            'url':'/tree',
            'templateUrl':'bcrmcore/base_tree.html',
            'controller':'BaseTreeController'
        },
        {
            'state':'tree.add',
            'url':'/base_add',
            'templateUrl':'bcrmcore/base_add.html',
            'controller':'BaseAddController'
        },
        {
            'state':'orgcode',
            'url':'/orgcode',
            'templateUrl':'bcrmcore/orgcode_validate.html',
            'controller':'OrgCodeController'
        },
        {
            'state':'tree.relation',
            'url':'/relation_list',
            'templateUrl':'bcrmcore/relation_list.html',
            'controller':'RelationListController'
        },
        {
            'state':'relationAdd',
            'url':'/relation_add',
            'templateUrl':'bcrmcore/relation_add.html',
            'controller':'RelationAddController'
        },
        {
            'state':'tree.upanddown',
            'url':'/upanddown_list',
            'templateUrl':'bcrmcore/upanddown_list.html',
            'controller':'UpanddownListController'
        },
        {
        	'state':'tree.upanddownrel',
        	'url':'/upanddownrel_view',
        	'templateUrl':'bcrmcore/upanddownrel_view.html',
        	'controller':'UpanddownrelViewController'
        },
        {
            'state':'upanddownAdd',
            'url':'/upanddown_add',
            'templateUrl':'bcrmcore/upanddown_add.html',
            'controller':'UpanddownAddController'
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
    scubeUI.module('bcrm_core_mdle',dependency,routeArry);
}());
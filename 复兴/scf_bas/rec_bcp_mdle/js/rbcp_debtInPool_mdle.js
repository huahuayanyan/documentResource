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
            'url':'/list',
            'default':'true',
            'templateUrl':'debtInPool/debtInPool_list.html',
            'controller':'debtInPoolListController'
        },
        {
            'state':'debtinpooledit',
            'url':'/debtinpooledit',
            'default':'true',
            'templateUrl':'debtInPool/debtInPool_edit.html',
            'controller':'debtInPoolEditController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('rbcp_info_debtInPool_mdle',dependency,routeArry);
}());
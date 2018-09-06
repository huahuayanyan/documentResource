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
            'state':'bbrpnotice',
            'url':'/bbrpnotice',
            'default':'true',
            'templateUrl':'notice/bbrp_notice_list.html',
            'controller':'BbrpNoticeListController'
        },
        {
            'state':'bbrpnoticeurl',
            'url':'/bbrpNoticeUrl',
            'templateUrl':'notice/bbrp_notice_load.html',
            'controller':'BbrpNoticeLoadController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bbrp_notice_mdle',dependency,routeArry);
}());
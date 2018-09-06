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
            'state':'noticeQryVO',
            'url':'/noticeQryVO',
            'default':'true',
            'templateUrl':'noticeqry/bnte_notice_qry.html',
            'controller':'BnteNoticeQryController'
        },
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('bas_nte_mdle',dependency,routeArry);
}());
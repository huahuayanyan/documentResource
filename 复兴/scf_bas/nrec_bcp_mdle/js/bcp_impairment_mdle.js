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
            'templateUrl':'../html/debtImpairment/bcp_impairment_list.html',
            'controller':'nrecBcpImpairmentListController'
        },
        {
            'state':'impairment',
            'url':'/list',
            'default':'true',
            'templateUrl':'../html/debtImpairment/bcp_impairment.html',
            'controller':'nrecBcpImpairmentController'
        },
        {
            'state':'impairment.edit',
            'url':'/impairment.edit',
            'templateUrl':'../html/debtImpairment/bcp_impairment_edit.html',
            'controller':'nrecBcpImpairmentEditController'
        },
        {
            'state':'impairment.pooledit',
            'url':'/impairment.pooledit',
            'templateUrl':'../html/debtImpairment/bcp_impairment_pooledit.html',
            'controller':'nrecBcpImpairmentPoolEditController'
        },
        {
            'state':'impairment.fileupload',
            'url':'/impairment.fileupload',
            'templateUrl':'../html/fileupload/fileupload_list.html',
            'controller':'nrecBcpImpairmentFileUploadController'
        },
        {
            'state':'showProcess',
            'url':'/showProcess',
            'default':'true',
            'templateUrl':'../html/showProcess/showProcess.html',
            'controller':'showProcessController'
        }

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('nrecBcpDebtImpairment_mdle',dependency,routeArry);
}());
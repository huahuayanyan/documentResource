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
            'templateUrl':'backtransfer/debtBackConList.html',
            'controller':'debtBackConListController'
        },
        {
            'state':'backtransfer',
            'url':'/backtransfer',
            'default':'true',
            'templateUrl':'backtransfer/backtransfer.html',
            'controller':'backTransferController'
        },
        {
            'state':'backtransfer.debtback',
            'url':'/backtransfer.debtback',
            'templateUrl':'backtransfer/debtback.html',
            'controller':'debtBackController'
        },
        {
            'state':'backtransfer.fileupload',
            'url':'/backtransfer.fileupload',
            'templateUrl':'backtransfer/backfileupload.html',
            'controller':'backFileUploadController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('rbcp_info_backtransfer_mdle',dependency,routeArry);
}());
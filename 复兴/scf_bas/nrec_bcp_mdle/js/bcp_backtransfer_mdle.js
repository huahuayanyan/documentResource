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
            'templateUrl':'../html/backTransfer/bcp_backtransfer_list.html',
            'controller':'nrecBcpBackTransferListController'
        },
        {
            'state':'backtransfer',
            'url':'/backtransfer',
            'default':'true',
            'templateUrl':'../html/backTransfer/bcp_backtransfer.html',
            'controller':'nrecBcpBackTransferController'
        },
        {
            'state':'backtransfer.debtbackedit',
            'url':'/backtransfer.debtbackedit',
            'templateUrl':'../html/backTransfer/bcp_backtransfer_edit.html',
            'controller':'nrecBcpBackTransferEditController'
        },
        {
            'state':'backtransfer.debtbackpooledit',
            'url':'/backtransfer.debtbackpooledit',
            'templateUrl':'../html/backTransfer/bcp_backtransfer_pooledit.html',
            'controller':'nrecBcpBackTransferPoolEditController'
        },
        {
            'state':'backtransfer.fileupload',
            'url':'/backtransfer.fileupload',
            'templateUrl':'../html/fileupload/fileupload_list.html',
            'controller':'nrecBcpBackTransferFileUploadController'
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
    scubeUI.module('nrecBcpDebtBackTransfer_mdle',dependency,routeArry);
}());
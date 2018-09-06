/**
 * Created by htrad0036 on 2017/1/19.
 */

(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'promptPaymentNoticeQry',
            'url':'/promptPaymentNoticeQry',
            'default':'true',
            'templateUrl':'debtPoolPromptPaymentNotice/debtPoolPromptPaymentNoticeQry.html',
            'controller':'promptPayNoticeController'
        },
        {
            'state':'promptPaymentNoticeDTL',
            'url':'/promptPaymentNoticeDTL',
            'default':'true',
            'templateUrl':'debtPoolPromptPaymentNotice/debtPoolPromptPaymentNoticeDTL.html',
            'controller':'promptPayNtcDtlController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('rec_wrn_mdle',dependency,routeArry);
}());
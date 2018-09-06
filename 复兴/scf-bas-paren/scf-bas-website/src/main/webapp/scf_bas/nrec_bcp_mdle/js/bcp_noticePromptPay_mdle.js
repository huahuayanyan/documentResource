/**
 * Created by htrad0036 on 2017/1/19.
 */

(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'promptPayNoticeQry',
            'url':'/promptPayNoticeQry',
            'default':'true',
            'templateUrl':'noticeqry/debtPromptPayNotice/debtPromptPayNoticeQry.html',
            'controller':'promptPayNoticeController'
        },
        {
            'state':'promptPayNoticeDtl',
            'url':'/promptPayNoticeDtl',
            'default':'true',
            'templateUrl':'noticeqry/debtPromptPayNotice/debtPromptPayNoticeDtl.html',
            'controller':'promptPayNtcDtlController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('rec_wrn_mdle',dependency,routeArry);
}());
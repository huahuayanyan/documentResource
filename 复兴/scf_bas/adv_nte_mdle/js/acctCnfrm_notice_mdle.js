
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'accountConfirmNoticeQry',
            'url':'/accountConfirmNoticeQry',
            'default':'true',
            'templateUrl':'acctCnfrmNotice/acctCnfrm_notice_list_qry.html',
            'controller':'AcctConfirmNoticeListController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_nte_mdle',dependency,routeArry);
}());
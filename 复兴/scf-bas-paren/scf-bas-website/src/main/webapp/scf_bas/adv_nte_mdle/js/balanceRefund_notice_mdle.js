
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'balanceRefund',
            'url':'/balanceRefund',
            'default':'true',
            'templateUrl':'balanceRefundNotice/balanceRefund_notice_list_qry.html',
            'controller':'BalanceRefundNoticeListController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_nte_mdle',dependency,routeArry);
}());
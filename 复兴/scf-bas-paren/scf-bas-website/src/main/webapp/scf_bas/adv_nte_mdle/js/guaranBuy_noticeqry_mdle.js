
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'guaranBuyNoticeQry',
            'url':'/guaranBuyNoticeQry',
            'default':'true',
            'templateUrl':'guaranBuyNotice/guaranBuy_notice_qry.html',
            'controller':'guaranBuyNoticeQryController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_nte_mdle',dependency,routeArry);
}());
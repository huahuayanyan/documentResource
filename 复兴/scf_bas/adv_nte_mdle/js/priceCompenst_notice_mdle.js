
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'priceCompenstNoticeQry',
            'url':'/priceCompenstNoticeQry',
            'default':'true',
            'templateUrl':'priceCompenstNotice/priceCompenst_notice_list_qry.html',
            'controller':'PriceCompenstNoticeListController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_nte_mdle',dependency,routeArry);
}());
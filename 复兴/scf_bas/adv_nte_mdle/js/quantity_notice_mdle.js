
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'quantityNoticeQry',
            'url':'/quantityNoticeQry',
            'default':'true',
            'templateUrl':'quantityNotice/quantity_notice_list_qry.html',
            'controller':'QuantityNoticeListController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_nte_mdle',dependency,routeArry);
}());
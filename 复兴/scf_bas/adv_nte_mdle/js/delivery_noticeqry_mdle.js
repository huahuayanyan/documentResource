/**
 * Created by htrad0036 on 2017/2/17.
 */

(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'deliveryNteQry',
            'url':'/deliveryNteQry',
            'default':'true',
            'templateUrl':'deliveryNotice/delivery_notice_qry.html',
            'controller':'deliveryNoticeQryController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_nte_mdle',dependency,routeArry);
}());
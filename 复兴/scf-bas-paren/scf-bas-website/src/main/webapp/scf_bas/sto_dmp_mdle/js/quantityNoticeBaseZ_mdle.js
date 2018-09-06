/**
 * Created by htrad0036 on 2017/2/21.
 */

(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'quantityNoticeBaseZ',
            'url':'/quantityNoticeBaseZ',
            'default':'true',
            'templateUrl':'quantityNoticeBaseZ/quantityNoticeBaseZ_qry.html',
            'controller':'quantityNoticeBaseZController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('sto_dmp_mdle',dependency,routeArry);
}());
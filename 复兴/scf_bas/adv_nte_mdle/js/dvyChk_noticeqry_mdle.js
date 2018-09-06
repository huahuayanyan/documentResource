
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'dvyChkNoticeQry',
            'url':'/dvyChkNoticeQry',
            'default':'true',
            'templateUrl':'dvyChkNotice/dvyChk_notice_qry.html',
            'controller':'dvyChkNoticeQryController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_nte_mdle',dependency,routeArry);
}());
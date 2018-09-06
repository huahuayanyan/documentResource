
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'fcsDvyChkNoticeQry',
            'url':'/fcsDvyChkNoticeQry',
            'default':'true',
            'templateUrl':'fcsDvyChkNotice/fcsDvyChk_notice_qry.html',
            'controller':'fcsDvyChkNoticeQryController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('adv_nte_mdle',dependency,routeArry);
}());
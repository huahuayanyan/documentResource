/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'fourConfirmList',
            'url':'/fourConfirmList',
            'default':'true',
            'templateUrl':'abcpfourConfirm/fourConfirmList.html',
            'controller':'fourConfirmListController'
        },
      {
            'state':'fourConfirmApply',
            'url':'/fourConfirmApply',
            //'default':'true',
            'templateUrl':'abcpfourConfirm/fourConfirmApply.html',
            'controller':'fourConfirmApplyController'
        },
        {
            'state':'fourConfirmApply.dtl',
            'url':'/fourConfirmApply_dtl',
            'templateUrl':'abcpfourConfirm/fourConfirmDtl.html',
            'controller':'fourConfirmDtlController'
        },
        {
            'state':'fourConfirmApply.fourProtocol',
            'url':'/fourConfirmApply_fourProtocol',
            'templateUrl':'../../bas_cnt_mdle/html/fourProtocol/four_Protocol_Add.html',
            'controller':'fourProtocolDtlController'
        }

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('afcsfourConfirmModule',dependency,routeArry)
}());

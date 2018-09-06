/**
 * Created by huangshuidan on 2016/11/11.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'fourGuaBuyback',
            'url':'/fourGuaBuyback',
            'default':'true',
            'templateUrl':'abcpfourGuaBuyback/fourGuaBuyback.html',
            'controller':'fourGuaBuybackController'
        }
        ,{
            'state':'fourGuaBuybackApp',
            'url':'/fourGuaBuybackApp',
            //'default':'true',
            'templateUrl':'abcpfourGuaBuyback/fourGuaBuybackApp.html',
            'controller':'fourGuaBuybackAppController'
        },
        {
            'state':'fourGuaBuybackApp.Dtl',
            'url':'/fourGuaBuybackApp_dtl',
            'templateUrl':'abcpfourGuaBuyback/fourGuaBuybackDtl.html',
            'controller':'fourGuaBuybackDtlController'
        },
        {
            'state':'fourGuaBuybackApp.fourProtocol',
            'url':'/fourGuaBuybackApp_fourProtocol',
            'templateUrl':'../../bas_cnt_mdle/html/fourProtocol/four_Protocol_Add.html',
            'controller':'fourProtocolDtlController'
        }

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('abcpfourGuaBuyback',dependency,routeArry)
}());

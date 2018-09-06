/**
 * Created by huangshuidan on 2016/11/11.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'threeGuaBuyback',
            'url':'/threeGuaBuyback',
            'default':'true',
            'templateUrl':'atcsthreeGuaBuyback/threeGuaBuyback.html',
            'controller':'threeGuaBuybackController'
        }
        ,{
            'state':'threeGuaBuybackApp',
            'url':'/threeGuaBuybackApp',
            //'default':'true',
            'templateUrl':'atcsthreeGuaBuyback/threeGuaBuybackApp.html',
            'controller':'threeGuaBuybackAppController'
        },
        {
            'state':'threeGuaBuybackApp.Dtl',
            'url':'/threeGuaBuybackApp_dtl',
            'templateUrl':'atcsthreeGuaBuyback/threeGuaBuybackDtl.html',
            'controller':'threeGuaBuybackDtlController'
        },
        {
            'state':'threeGuaBuybackApp.threeProtocol',
            'url':'/threeConfirmApply_threeProtocol',
            'templateUrl':'../../bas_cnt_mdle/html/bcntthreeProtocol/bcnt_threeProtocolAdd.html',
            'controller':'bcntThreeProtocolAddController'
        }

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('atcsthreeGuaBuyback',dependency,routeArry)
}());

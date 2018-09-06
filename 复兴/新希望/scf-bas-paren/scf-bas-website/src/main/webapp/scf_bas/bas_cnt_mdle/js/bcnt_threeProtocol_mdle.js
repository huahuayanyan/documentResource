/**
 * Created by huangshuidan on 2016/11/11.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'bcntthreeProtocol',
            'url':'/bcntthreeProtocol',
            'default':'true',
            'templateUrl':'bcntthreeProtocol/bcnt_threeProtocol.html',
            'controller':'bcntThreeProtocolController'
        },
        {
            'state':'bcntThreeProtocolAdd',
            'url':'/bcntThreeProtocolAdd',
            'templateUrl':'bcntthreeProtocol/bcnt_threeProtocolAdd.html',
            'controller':'bcntThreeProtocolAddController'
        },
        {
            'state':'bcntThreeProtocolModify',
            'url':'/bcntThreeProtocolModify',
            'templateUrl':'bcntthreeProtocol/bcnt_threeProtocolModify.html',
            'controller':'bcntThreeProtocolAddController'
        }
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('bsysthreeProtocol',dependency,routeArry)
}());

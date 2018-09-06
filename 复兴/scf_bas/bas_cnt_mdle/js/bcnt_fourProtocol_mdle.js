/**
 * Created by huangshuidan on 2016/11/11.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'fourProtocolList',
            'url':'/fourProtocolList',
            'default':'true',
            'templateUrl':'fourProtocol/four_Protocol_list.html',
            'controller':'bcntFourProtocolController'
        },
        {
            'state':'fourProtocolAdd',
            'url':'/fourProtocolAdd',
            'templateUrl':'fourProtocol/four_Protocol_Add.html',
            'controller':'bcntFourProtocolAddController'
        },
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('bsysthreeProtocol',dependency,routeArry)
}());

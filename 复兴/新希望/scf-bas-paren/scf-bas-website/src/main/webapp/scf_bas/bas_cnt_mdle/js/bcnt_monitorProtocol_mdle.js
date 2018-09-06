/**
 * Created by huangshuidan on 2016/11/11.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'bcntMonitorProtocol',
            'url':'/bcntMonitorProtocol',
            'default':'true',
            'templateUrl':'../html/bcntmonitorProtocol/bcnt_monitorProtocol.html',
            'controller':'bcntMonitorProtocolController'
        },
        {
            'state':'viewGntyCon',
            'url':'/viewGntyCon',
            'default':'true',
            'templateUrl':'mortgageMntProtocol/mortgage_gntycon_list.html',
            'controller':'viewGntyConController'
        },
		{
			'state':'edit',
			'url':'/edit',
			'default':'true',
			'templateUrl':'../html/bcntmonitorProtocol/bcnt_monitorProtocol_gntycon_view.html',
			'controller':'viewController'
		}
    ]
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    

    
    scubeUI.module('bcntMonitorProtocol',dependency,routeArry)
}());

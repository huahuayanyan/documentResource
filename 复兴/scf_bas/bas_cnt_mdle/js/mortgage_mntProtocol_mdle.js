/**
 * Created by gongzhao on 2017/04/12.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'mortgageMntProtocol',
            'url':'/mortgageMntProtocol',
            'default':'true',
            'templateUrl':'mortgageMntProtocol/mortgage_mntProtocol.html',
            'controller':'mortgageMntProtocolController'
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
    

    
    scubeUI.module('mortgageMntProtocol',dependency,routeArry)
}());

/**
 * Created by htrad0027 on 2016/10/26.
 */
/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */
(function(){
	var parentwindow=window.parent;
    window.userInfo = parentwindow.userInfo;
    window.authorization=parentwindow.authorization;
    window.httpIpPort = parentwindow.httpIpPort;
    window.dictionary = parentwindow.dictionary;
    window._HTTP_IP_PORT = parentwindow._HTTP_IP_PORT;
  
	

    //跳转的路由配置
    var routeArry=[
        {
            'state':'updateindex',
            'url':'/updateindex',
        	'templateUrl':'app/updateindex.html',
			'controller':'updateindexController'
         } ,
        {
			'state':'apptree',
			'templateUrl':'apptree_mdle.html',
			'controller':'appTreeController'
		},
		{
            'state':'updateline',
            'url':'/updateline',
        	'templateUrl':'app/updateline.html',
			'controller':'updatelineController'			
			
		}        
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];

  scubeUI.module('apptreeMdle',dependency,routeArry);
  //手动拉起angular应用程序
  angular.element(document).ready(function() {
      angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
  });
        
}());

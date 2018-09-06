/**
 * @author 	shangxiujuan
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/16
 */
(function(){
	var parentwindow = window.parent;
    window.userInfo = parentwindow.userInfo;
    window.authorization=parentwindow.authorization;
    window.httpIpPort = parentwindow.httpIpPort;
    window.dictionary = parentwindow.dictionary;
    window._HTTP_IP_PORT = parentwindow._HTTP_IP_PORT;
    window.appNo = parentwindow.appNo;

    //跳转的路由配置
    var routeArry=[
     
        {
            'state':'threeConfirmDtl',
            'url':'/threeConfirmApply_dtl',
            'templateUrl':'atcsthreeConfirm/threeConfirmDtl.html',
            'controller':'threeConfirmDtlController'
        },
        {
            'state':'threeProtocol',
            'url':'/threeConfirmApply_threeProtocol',
            'templateUrl':'../../bas_cnt_mdle/html/bcntthreeProtocol/bcnt_threeProtocolAdd.html',
            'controller':'bcntThreeProtocolAddController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];

  scubeUI.module('atcsThreeConfirmApplyMdle',dependency,routeArry);
  //手动拉起angular应用程序
  angular.element(document).ready(function() {
      angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
  });
        
}());

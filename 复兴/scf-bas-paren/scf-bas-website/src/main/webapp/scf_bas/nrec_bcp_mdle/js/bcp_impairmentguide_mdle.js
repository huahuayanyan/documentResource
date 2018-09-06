/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
(function(){
	var parentwindow = window.parent;
    window.userInfo = parentwindow.userInfo;
    window.authorization=parentwindow.authorization;
    window.httpIpPort = parentwindow.httpIpPort;
    window.dictionary = parentwindow.dictionary;
    window._HTTP_IP_PORT = parentwindow._HTTP_IP_PORT;
    window.appNo = parentwindow.appNo;
    window.taskId = parentwindow.taskId;

    //跳转的路由配置
    var routeArry=[
        {
            'state':'impairmentedit',
            'url':'/impairmentedit',
            'templateUrl':'../html/debtImpairment/bcp_impairment_edit.html',
            'controller':'nrecBcpImpairmentEditController'
        },
        {
            'state':'impairmentpooledit',
            'url':'/impairmentpooledit',
            'templateUrl':'../html/debtImpairment/bcp_impairment_pooledit.html',
            'controller':'nrecBcpImpairmentPoolEditController'
        },
        {
            'state':'fileupload',
            'url':'/fileupload',
            'templateUrl':'../html/fileupload/fileupload_list.html',
            'controller':'nrecBcpImpairmentFileUploadController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];

  scubeUI.module('nrecBcpDebtImpairmentGuide_mdle',dependency,routeArry);
  //手动拉起angular应用程序
  angular.element(document).ready(function() {
      angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
  });
        
}());

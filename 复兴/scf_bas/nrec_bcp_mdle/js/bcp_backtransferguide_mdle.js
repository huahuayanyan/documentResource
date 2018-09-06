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
            'state':'debtbackedit',
            'url':'/debtbackedit',
            'templateUrl':'../html/backTransfer/bcp_backtransfer_edit.html',
            'controller':'nrecBcpBackTransferEditController'
        },
        {
            'state':'debtbackpooledit',
            'url':'/debtbackpooledit',
            'templateUrl':'../html/backTransfer/bcp_backtransfer_pooledit.html',
            'controller':'nrecBcpBackTransferPoolEditController'
        },
        {
            'state':'fileupload',
            'url':'/fileupload',
            'templateUrl':'../html/fileupload/fileupload_list.html',
            'controller':'nrecBcpBackTransferFileUploadController'
        },
        {
            'state':'debtbackguide',
            'templateUrl':'../html/bcp_backtransferguide_mdle.html'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];

  scubeUI.module('nrecBcpDebtBackTransferGuide_mdle',dependency,routeArry);
  //手动拉起angular应用程序
  angular.element(document).ready(function() {
      angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
  });
        
}());

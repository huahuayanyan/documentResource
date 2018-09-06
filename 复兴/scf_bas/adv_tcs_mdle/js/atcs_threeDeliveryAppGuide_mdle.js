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
    window.processId = parentwindow.processId;
    //跳转的路由配置
    var routeArry=[
      /*  {
            'state':'threeConfirmApply',
            'url':'/threeConfirmApply',
            'templateUrl':'atcs_threeConfirmApply_mdle.html'
        },
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
        ,{
            'state':'threeConfirmList',
            'url':'/threeConfirmList',
            'templateUrl':'atcsthreeConfirm/threeConfirmList.html',
               'controller':'threeConfirmListController'
            //'templateUrl':'atcs_threeConfirm_mdle.html'

        }*/

        {
            'state':'threeDeliveryDtl',
            'url':'/threeDeliveryApply_dtl',
            'templateUrl':'atcsthreeDelivery/threeDeliveryDtl.html',
            'controller':'threeDeliveryDtlController'
        },
        {
            'state':'threeDeliveryMrninfo',
            'url':'/threeDeliveryApply_mrninfo',
           // 'templateUrl':'../../sto_dmp_mdle/html/lowerprice/mrninfo.html',
            'templateUrl':'atcsthreeDelivery/appendBailAmount.html',
            'controller':'mrnDeliveryController'
        },
        {
            'state':'threeDeliveryFileupload',
            'url':'/fileupload',
            'templateUrl':'../../sto_dmp_mdle/html/lowerprice/fileupload.html',
            'controller':'fileuploadController'
        },
        {
            'state':'threeProtocol',
            'url':'/threeDeliveryApply_threeProtocol',
            'templateUrl':'../../bas_cnt_mdle/html/bcntthreeProtocol/bcnt_threeProtocolAdd.html',
            'controller':'bcntThreeProtocolAddController'
        }
    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];

  scubeUI.module('atcsThreeDeliveryAppGuideMdle',dependency,routeArry);
  //手动拉起angular应用程序
  angular.element(document).ready(function() {
      angular.bootstrap(document.getElementsByTagName("body"),[scubeUI.moduleName]);
  });
        
}());

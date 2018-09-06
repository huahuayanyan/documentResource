/**
 * Created by htrad0016 on 2016/8/23.
 */
(function(){
    //跳转的路由配置
    var routeArry=[
        {
            'state':'threeConfirmList',
            'url':'/threeConfirmList',
            'default':'true',
            'templateUrl':'atcsthreeConfirm/threeConfirmList.html',
            'controller':'threeConfirmListController'
        },
      {
            'state':'threeConfirmApply',
            'url':'/threeConfirmApply',
            //'default':'true',
            'templateUrl':'atcsthreeConfirm/threeConfirmApply.html',
            'controller':'threeConfirmApplyController'
        },
        {
            'state':'threeConfirmApply.dtl',
            'url':'/threeConfirmApply_dtl',
            'templateUrl':'atcsthreeConfirm/threeConfirmDtl.html',
            'controller':'threeConfirmDtlController'
        },
        {
            'state':'threeConfirmApply.threeProtocol',
            'url':'/threeConfirmApply_threeProtocol',
            'templateUrl':'../../bas_cnt_mdle/html/bcntthreeProtocol/bcnt_threeProtocolAdd.html',
            'controller':'bcntThreeProtocolAddController'
        }

    ];
    //模块的依赖加载配置
    var dependency=[
        //todo
    ];
    scubeUI.module('atcsthreeConfirmModule',dependency,routeArry)
}());

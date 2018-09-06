/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var DebtInfoManageController =  function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();
    //页面单据查询
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();

    });
    $scope.queryTable = function(paramData){
        var rbcpdebtinfovo = {mastContno:$scope.otherform.mastContno};
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            value:rbcpdebtinfovo
        };
        $common.get_asyncData("rbcpDebtInfoService/findRBcpDebtInfoByPage",data).then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //历程信息查看
    $scope.progress_onClick = function(){
        if($scope.selected.select.length == 1){
            var data1= {
                baseinfo:$scope.otherform,
                rBcpDebtInfo:$scope.selected.select[0],
                flag:"contview"
            };
            dataDeliver.setter(data1);
            $state.go("progress");
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
    //back
    $scope.back_onClick=function(){
        $state.go("list");//返回首页面
    }
};

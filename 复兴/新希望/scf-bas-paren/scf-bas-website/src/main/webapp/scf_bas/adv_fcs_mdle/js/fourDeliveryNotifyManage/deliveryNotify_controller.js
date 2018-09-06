/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var deliveryNotifyController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    $scope.conditionForm={};//初始化查询条件对象

    $scope.datasource={//初始化表格对象
        ds:[]
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick = function(){
        $scope.conditionForm={};
        $scope.selected.select=[];//清空选项
        $scope.$apply();
    };
    //搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //查询
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            NoticeQryVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bNteNoticeBaseService/getAdvDeliveryNotifyByParam",data);
        promise.then(function(res){
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
    //发货通知书新增按钮
    $scope.doAdd_onClick = function(){
        $state.go("deliveryNotifyConfirm");
     };
    //发货通知书修改按钮
    $scope.doUpdate_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            if($scope.selected.select[0].ext2=="01"){
                $common.get_tipDialog('已提交通知书不可修改！','showInform');
            }else{
                var data= {
                    deliveryNotify:$scope.selected.select[0],
                    flag:"update"
                };
                dataDeliver.setter(data);
                $state.go("deliveryNotifyAdd");
            }
        }
     };
    //发货通知书删除按钮
    $scope.doDelete_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            if($scope.selected.select[0].ext2=="01"){
                $common.get_tipDialog('已提交通知书不可删除！','showInform');
            }else{
                var BNteNoticeBase={
                    ext1:$scope.selected.select[0].ext1,
                    appno:$scope.selected.select[0].deliveryAppno
                };
                var primise = $common.get_asyncData('bNteNoticeBaseService/deleteDeliveryNotify',{BNteNoticeBase:BNteNoticeBase});
                primise.then(function(res){
                    $common.get_tipDialog('删除成功！', 'showSuccess');
                    $scope.queryTable();
                    $scope.selected.select=[];
                });
            }
        }
     };
    //发货通知书提交按钮
    $scope.doSubmit_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            if($scope.selected.select[0].ext2=="01"){
                $common.get_tipDialog('只有状态为[已录入]的通知书才可提交！','showInform');
            }else{
                var BNteNoticeBase={
                    ext1:$scope.selected.select[0].ext1,
                    appno:$scope.selected.select[0].deliveryAppno
                };
                var primise = $common.get_asyncData('bNteNoticeBaseService/submitDeliveryNotify2',{BNteNoticeBase:BNteNoticeBase});
                primise.then(function(res){
                    $common.get_tipDialog('提交成功！', 'showSuccess');
                    $scope.queryTable();
                    $scope.selected.select=[];
                });
            }
        }
     };


    //查看对应信息
    $scope.column = function(data1){
    var data= {
        deliveryNotify:data1,
        flag:"view"
    };
    dataDeliver.setter(data);
    $state.go("deliveryNotifyAdd");
    }

    //删除协议按钮
    /*$scope.doDelete_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
        	var conInfo=$scope.selected.select[0];
            var conId=conInfo.conId;//抵质押合同号
            var msg='确认删除抵/质押合同号为[' + conId + "]的合同吗？"
            $common.get_tipDialog(msg,'showTip').then(function(){
                if(conInfo.prtclNo && conInfo.prtclNo !=""){
                    $common.get_tipDialog("该质押合同已关联监管合同，不可删除!",'showInform');
                }else{
                    var primise = $common.get_asyncData('bCrrGntyConService/deleteGntyConAndMortAndInsu',{conId:conId});
                    primise.then(function(res){
                        if (res.errorCode =="SUC"){
                            $scope.queryTable();
                            $scope.selected.select=[];
                            $common.get_tipDialog('删除成功！','showSuccess');
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                }
            });
        }
    };*/
};

/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var worthCompensateController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    //初始化查询条件对象
    $scope.conditionForm={
        noticeType:"23",//跌价补偿通知书
        bussTypeName:"先票/款后货",
        bussType:1210020,
    };
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
    /**
     * 业务品种筛选开始
     */
    $scope.productNameContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBusinessTypeByPage",
        param:{ tFactType:"0" },
        split:",",//分隔符
        extentColumn:"productName",
        column:["productName"]//展示内容
    };
    $scope.productNamedooextent = function(ds){
        $scope.conditionForm.bussTypeName=ds.productName;
        $scope.conditionForm.bussType=ds.productId; //业务品种
    };
    $scope.$watch("otherform.vidPrdNm",function(newVal,oldVal){
        $scope.productNameContent.param ={
            productName:$scope.conditionForm.bussTypeName,
            tFactType:"0"
        };
    });
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick = function(){
        $scope.conditionForm={
            noticeType:"23",//跌价补偿通知书
            bussTypeName:"先票/款后货",
            bussType:1210020,
        };
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
        var promise = $common.get_asyncData("bNteNoticeBaseService/selectNoticePageByParam",data);
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
        $state.go("mortgageRegularContSlave");
     };

    //通知书删除按钮
    /*$scope.doDelete_onClick = function(){
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
     };*/

};

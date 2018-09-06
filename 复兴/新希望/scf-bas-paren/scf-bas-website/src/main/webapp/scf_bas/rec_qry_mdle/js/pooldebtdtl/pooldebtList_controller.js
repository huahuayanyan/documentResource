/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var pooldebtListController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {

    //初始化查询条件对象
    $scope.conditionForm={
    };

    $scope.listdatasource={//初始化表格对象
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
        $scope.$apply(function(){
            $scope.conditionForm={};
            $scope.selected.select=[];//清空选项s
        })
    };

    //搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
    };
//todo
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            commonQueryVO:$scope.conditionForm
        };

        var promise = $common.get_asyncData("rBcpPoolDebtDtlInfoQryService/getDebtQuery",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.listdatasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
                console.log(JSON.stringify($scope.listdatasource.ds ));
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        //$scope.selected.select=[];
    };

    //查看明细
    $scope.detail_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{

            var debtCont=$scope.selected.select[0];
            var data = {pooldebtinfo:debtCont};

            $state.go("pooldebtdtl");
            dataDeliver.setter(data);

        }
    }


    $scope.procss_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var debtCont=$scope.selected.select[0];
            var data = {pooldebtinfo:debtCont};
            $state.go("pooldebtprcs");
            dataDeliver.setter(data);

        }
    }


    $scope.regBack_onClick = function(){
        $state.go("dsptRegAdd");
    }

  
    //表格--------结束-------------------------
};

/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var bsysCancelTaskController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    $scope.conditionForm={};//初始化查询条件对象
    $scope.datasource={//初始化表格对象
        ds:[
        ]
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
   };
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
            $scope.conditionForm={};
            $scope.selected.select=[];//清空选项
        })
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
            bSysTask:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bSysTaskService/queryTaskListByPage",data);
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
    //我要办理按钮
    $scope.doCancelTask_onClick = function(){
    	 if($scope.selected.select.length <= 0){
             $common.get_tipDialog('请至少选择一条记录！','showInform');
         }else{
        	 var appNo=$scope.selected.select[0].appNo;
        	 var processId=$scope.selected.select[0].processId;
        	 //console.log("appNo:"+appNo);
        	 console.log("processId:"+processId);
        	 $common.get_tipDialog('确定撤销任务吗！','showTip').then(function(){
                 //如果有对应单据信息，则解锁对应单据信息，但并不删除对应的申请明细信息。
                 var primise = $common.get_asyncData('bSysTaskService/cancelTask',{processId:processId,appno:appNo});
                 primise.then(function(res){
                     if (res.errorCode =="SUC"){
                         $scope.queryTable();
                         $scope.selected.select=[];
                         $common.get_tipDialog('任务撤销成功！','showSuccess');
                     }else{
                         $common.get_tipDialog(res.errorMsg,'showError');
                     }
                 })
             })
         }
        
    };

    $scope.fresh_onClick = function(){
        $scope.queryTable($scope.conditionForm);
        $scope.selected.select=[];
    };
    $scope.column = function(row){
        console.log(JSON.stringify(row));
    };
    //表格--------结束-------------------------
};

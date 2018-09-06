/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var bsysApplyDtlController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
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

    $scope.applyDtlForm={
        attitude:''
    }
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
            pageSize: $scope.conf.pageSize
        };
        var promise = $common.get_asyncData("bSysApplyDtlService/queryBSysApplyDtlListByPage",data);
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
    $scope.doProcess_onClick = function(){
    	 if($scope.selected.select.length <= 0){
             $common.get_tipDialog('请至少选择一条记录！','showInform');
         }else{
        	 var appNo=$scope.selected.select[0].appNo;
        	 var pageUrl=$scope.selected.select[0].pageUrl;
        	 //console.log("appNo:"+appNo);
        	 //console.log("pageUrl:"+pageUrl);
        	 $state.go(""+pageUrl+"");
             var data= {
            	appNo:appNo
             };
             dataDeliver.setter(data);
         }
        
    };

    $scope.textarea_onBlur = function(){
        window.apply_attitude =  $scope.applyDtlForm.attitude;
    }


    $scope.fresh_onClick = function(){
        $scope.queryTable($scope.conditionForm);
        $scope.selected.select=[];
    };
    $scope.column = function(row){
        console.log(JSON.stringify(row));
    };
    //表格--------结束-------------------------
};

/**
 * Created by htrad0036 on 2017/3/15.
 */
var wfProcessController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
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

    //流程选择
    $scope.processContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectWKFlowByPage",
        param:{},    //应收账款池融资
        /*split:",",//分隔符*/
        extentColumn:"processName",
        column:["flowName"]//展示内容
    };
    $scope.processdooextent = function(ds){
        $scope.conditionForm.processName=ds.flowName;
        $scope.conditionForm.flowCopId=ds.flowCopId;
    };
    $scope.$watch("conditionForm.processName",function(a, b){
        $scope.processContent.param ={
            flowName:$scope.conditionForm.processName
        };
        if($scope.conditionForm.processName==null||$scope.conditionForm.processName==""){
            $scope.conditionForm.flowCopId=null;
        }
    });
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
            conditionForm:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bSysTaskService/queryWFProcessByPage",data);
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
    //查看待办人员
    $scope.viewTlr_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            if($scope.selected.select[0].status=="已结束"){
                $common.get_tipDialog('流程已结束，不能查看待办人员！','showInform');
            }else{
                $common.get_ngDialog('workFlowProcess/wf_task_tlrList.html', $scope
                    ,["$scope",function(dialogScope){
                        wfTaskTlrController(dialogScope,$scope,$common,$scope.selected.select[0]);
                    }],"待办人员列表",{showClose:true});
            }
        }
    };

    $scope.homeBackHide =true;
    var url = window.location.href;
    if(url.indexOf("needBackFlag")!=-1){
    	 $scope.homeBackHide = false;
    }
    //获得数据字典中配置的主页的URL
   var mainPage ="";
   mainPage = window.dictionary.main_pagePath.dataItems[0].dataVal;
    //返回主页按钮
    $scope.homeBack_onClick = function () {
    	 if(mainPage&&mainPage!=undefined&&mainPage!=null&&mainPage!=""){
    		//window.location.href =window._HTTP_IP_PORT+"scf_bas/bas_main_mdle/html/bmain_mdle.html";
    		window.location.href =window._HTTP_IP_PORT+mainPage;
    	}
    };

};

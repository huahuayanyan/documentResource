/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      gongzhao
 * @version     1.0
 * Create at:   2017/05/02
 */

var adjustPriceApplyMainController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    var dataX=dataDeliver.getter();
    $scope.otherform={};
    
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
            $scope.otherform={
            		vidPrdId:"1220010",//非表仓单
            		custcd:$scope.otherform.custId
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
                conditionForm:{vidPrdId:"1220010",//非表仓单
        		custcd:$scope.otherform.custId}
            };
            var promise = $common.get_asyncData("mortAdjustPriceTypeQryService/integratedLedgersQry",data);
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

        

    /**
     * 出质人名称筛选开始
     */
    $scope.gutNmContent = {
            type: "table",//展示类型table  tree
            url: "monitorProtocolService/getSecNamebyProtocol",//请求url
            //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
            split: "",//分隔符
            extentColumn: "codeName",
            column: ["codeName"]//展示内容
    };
    $scope.gutNmdoextent = function (ds) {
    	$scope.otherform.gutNm = ds.codeName;
    	$scope.otherform.custId = ds.code;
    }
    $scope.$watch("otherform.gutNm",function(){
        if($scope.otherform.gutNm!=null)
        	$scope.gutNmContent.param ={secName:$scope.otherform.gutNm};
    });
    /**
     * 抵/质押合同号查询加载开始
     *//*
    $scope.conIdContent = {
        type:"table",//展示类型table  tree
        url:"adjustPriceService/SlaveContractGetter",
        param:{},
        split:",",//分隔符
        extentColumn:"conId",
        column:["conId"]//展示内容
    };
    $scope.conIddoextent = function(ds){
        $scope.otherform.conIddoextent = ds.conId;
    };
    $scope.$watch("otherform.conId+otherform.custId",function(){
        	$scope.conIdContent.param ={custcd:$scope.otherform.custId,slaveContno:$scope.otherform.conId,supplyChainPdId:1220010};
    });*/
    /**
     * 抵/质押合同号查询加载结束
     */
    
    //发起申请
    $scope.apply_onClick = function(){
    	if($scope.selected.select.length!=1)
    		 $common.get_tipDialog('请选择一条记录！','showInform');
    	else{
    		 var data =$scope.selected.select[0];
    		 dataDeliver.setter(data);
   		   $state.go("adjustPriceApplication");
    	}
     };
    
};

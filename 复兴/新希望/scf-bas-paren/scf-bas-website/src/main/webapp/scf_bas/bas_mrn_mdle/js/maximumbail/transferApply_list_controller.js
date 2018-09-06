/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      mengjiajia
 * @version     1.0
 * Create at:   2016/5/18
 */
var transferApplyListController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel){
    $scope.conditionForm={};//初始化查询条件对象
    $scope.selected={select: []};//初始化对象
    $scope.datasource={ds: []};//初始化表格对象
    $scope.conf= {pageNo: 1, pageSize: 10};//初始化分页对象
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize", function () {
    	$scope.queryTable();
    });
  
    $scope.queryTable=function(){
		    var data= {
		        pageNo: $scope.conf.pageNo,
		        pageSize: $scope.conf.pageSize,
                bCrrGntyConVO:$scope.conditionForm
		    };
		    var promise = $common.get_asyncData("maximumBailTransferApplyService/findBCrrGntyConByPage",data);
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

    $scope.reset_onClick = function(){      
        $scope.$apply(function(){
        	$scope.conditionForm = {};
            $scope.selected.select=[];//清空选项
        });
    };
    
    //搜索查询
    $scope.submit_onClick =function(){
    	$scope.queryTable();
    };

    /**
     * 客户名称查询加载开始
     */
    $scope.custcontent = {
        type:"table",//展示类型table  tree
        url:"bCrrLnAppService/queryCustSource",
        param:{},
        split:",",//分隔符
        extentColumn:"gutNm",
        column:["custNm","custId"]//展示内容
    };
    $scope.dooextend = function(ds){
        $scope.conditionForm.gutNm=ds.custNm;
    };
    $scope.$watch("conditionForm.gutNm",function(){
        if($scope.conditionForm.gutNm!=null) $scope.custcontent.param ={custId:$scope.conditionForm.gutNm,custNm:$scope.conditionForm.gutNm};
    });
    /**
     * 客户名称查询加载结束
     */
    /**
     * 业务品种筛选开始
     */
    $scope.productNameContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBusinessType",
        param:{ factType:"0" },    //应收账款融资
        split:",",//分隔符
        extentColumn:"vidPrdNm",
        column:["productName","productId"]//展示内容
    };
    $scope.productNamedooextent = function(ds){
        $scope.conditionForm.vidPrdNm=ds.productName;
        $scope.conditionForm.vidPrdId=ds.productId; //业务品种
    };
    $scope.$watch("conditionForm.vidPrdId",function(newVal,oldVal){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.productNameContent.param ={
            tFactType:"0",  //应收账款融资
            parentId:"1000"
        };
    });
    /**
     * 业务品种筛选结束
     */
    $scope.source = {};
    //发起申请
    $scope.startApply_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
        else
        {
            $scope.flowsubmitdisable = true;
            $scope.row = $scope.selected.select[0];
            $scope.source.gntyform = $scope.row;
            var data =
            {
                bCrrGntyConVO:$scope.row
            }
            var promise = $common.get_asyncData("maximumBailTransferApplyService/BailAccountBaseInfoGetter",data);
            promise.then(function(res){
                var transferform;
                if (res.errorCode =="SUC"){
                    transferform = res.contextData;
                    var transfer = transferform.records[0];
                    $scope.source.transferform = transfer;
                    $state.go("transferApplyedit");//跳转
                    window.source = $scope.source;
                }else{
                    $scope.flowsubmitdisable = false;
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        };
    };
};
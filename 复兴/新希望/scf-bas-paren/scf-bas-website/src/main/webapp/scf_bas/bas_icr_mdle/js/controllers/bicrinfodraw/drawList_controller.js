/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var drawListController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
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
    //分项额度筛选
    $scope.creditTypeContent = {
        type:"table",//展示类型table  tree
        url:"bIcrTypeService/selectBIcrType",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"creditName",
        column:["creditType","creditName"]//展示内容
    };
    $scope.creditNamedooextent = function(ds){
    	$scope.conditionForm.creditType=ds.creditType;
    };
    $scope.$watch("conditionForm.creditName",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
    	$scope.creditTypeContent.param ={
            creditType:$scope.conditionForm.creditType,
            creditName:$scope.conditionForm.creditName,
            creditClass:"3" //间接额度
        }
    });

    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bIcrInfo:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bIcrInfoService/findBIcrInfoDrawByPage",data);
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
        $scope.selected.select=[];
    };

    //领用申请
   $scope.apply_onClick = function(){
	   if($scope.selected.select.length != 1){
           $common.get_tipDialog('请选择一条记录！','showInform');
	   }else{
		   $state.go("drawApply");
		   var data= $scope.selected.select[0];
	       dataDeliver.setter(data);  
	   }
	  
    };
  
    //表格--------结束-------------------------
};

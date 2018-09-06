/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var contController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel){

    console.log("userInfo信息："+JSON.stringify(userInfo));//用户信息，全局变量
  //  $scope.userInfo=userInfo;
    $scope.conditionForm={};//初始化查询条件对象
    $scope.selected={select: []};//初始化对象
    $scope.datasource={ds: []};//初始化表格对象
    $scope.conf= {pageNo: 1, pageSize: 10};//初始化分页对象
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize", function () {
        queryTable();
    });
    //搜索查询
    $scope.submit_onClick =function(){
        queryTable();
    };


    $scope.reset_onClick = function(){      
        $scope.$apply(function(){
        	$scope.conditionForm = {};
            $scope.selected.select=[];//清空选项
        });
    };
    $scope.column = function(row){
    	$scope.selected.select[0]=row;
    	doView();
    };
    
    $scope.view_onClick = function(){
    	
        if($scope.selected.select.length <= 0||$scope.selected.select.length > 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{ doView();}
    	   
      };
    
    function doView(){
    	window.bcCrId=$scope.selected.select[0].bcCrId;
    	window.viewhide=false;
    	window.updatehide=true;
        $common.get_ngDialog('cont/contguide.html',$scope,["$scope",function(guideScope){	            	 
      	 window.closeDialog=function(){	            		 
      		 guideScope.closeThisDialog();
      		 queryTable();		            	
      	 };
      }],'授信额度协议',{showClose:true},850);               
     } ;
     
    function queryTable(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            vbDcrLin:$scope.conditionForm
        };
        var promise = $common.get_asyncData("ibDcrLinService/findObjectConditionByPage",data);
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

};
/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var bailtransferqueryController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel){
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
		        bMrnAcctBussInfo:$scope.conditionForm
		    };
		    data.bMrnAcctBussInfo.bailType="03";
		    var promise = $common.get_asyncData("bMrnAcctBussInfoService/queryTblCustAccountBussInfoList",data);
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

    
    $scope.custcontent = {
            type:"table",//展示类型table  tree
            url:"ibDcrLinAppService/queryCustSource",
            param:{},
            split:"-",//分隔符
            extentColumn:"",
            column:["custcd","cname"]//展示内容
        };
    $scope.doextend= function(ds){
        	$scope.conditionForm.custcd=ds.custcd;
        };   
      $scope.$watch("conditionForm.custcd",function(){
        	if($scope.conditionForm.custcd!=null) $scope.custcontent.param ={custcd:$scope.conditionForm.custcd,cname:$scope.conditionForm.custcd};
        });    


};
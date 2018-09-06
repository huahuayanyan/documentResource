/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2017/1/12
 */
var paymentPoolApplyListController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel){
    $scope.conditionForm={appliType:'3286'};//初始化查询条件对象
    $scope.productSource={
        ds: []
    };
    $scope.selected={select: []};//初始化对象
    $scope.datasource={ds: []};//初始化表格对象
    $scope.conf= {pageNo: 1, pageSize: 10};//初始化分页对象
    $scope.flowsubmitdisable=false;
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize", function () {
        queryTable();
    });
    //搜索查询
    $scope.submit_onClick =function(){
        queryTable();
    };
    //新增
    $scope.add_onClick = function(){
        add();
    };
    $scope.update_onClick = function(){
      update();
    };
    $scope.delete_onClick = function(){
    	del();
    };
    $scope.reset_onClick = function(){      
        $scope.$apply(function(){
        	$scope.conditionForm = {appliType:'3286',supplyChainPdId:'1230040'};
            $scope.selected.select=[];//清空选项
        });
    };
    $scope.conditionForm.supplyChainPdId='1230040';//初始化产品类型为国内保理池
    var productPar= {
        pageNo: '1',
        pageSize: '999999',
        bPrdInfo:{/*parentId:'2100'*/}
    };
    var promise = $common.get_asyncData("bPrdInfoService/findPrdInfoByPage",productPar);
    promise.then(function(res){
        var data;
        if (res.errorCode =="SUC"){
            data = res.contextData;
            $scope.productSource.ds = data.records;
        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
     
    function queryTable(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            value:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bPbcAppliBaseInfoService/queryBPbcAppliBaseInfoList",data);
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
    
    $scope.column = function(row){
 	      window.viewhide=true;
	      window.viewdisable=true;
	      window.backhide=false;
     	 $state.go("paymentpoolupdate",{appNo:row.appno});
     };
    
    

    function add(){	
    	 $state.go("paymentpoolapply");
    };
  
    
    

    
    function update(){
        if($scope.selected.select.length <= 0||$scope.selected.select.length > 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{ 
            var row = $scope.selected.select[0];
        	      if(row.appliStatusDtl!='000'){
        	            $common.get_tipDialog('只有未提交申请可修改！','showInform');
                         return;        	    	  
        	      }
         	      window.viewhide=false;
        	      window.viewdisable=false;
        				        
			        $state.go("paymentpoolupdate",{appNo:row.appno});
               }

    };
    function del(){
        if($scope.selected.select.length <= 0||$scope.selected.select.length > 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            var row = $scope.selected.select[0];
  	      if(row.appliStatusDtl!='000'){
	            $common.get_tipDialog('只有未提交申请可删除！','showInform');
               return;        	    	  
	      }
            $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
                var primise = $common.get_asyncData("irBcpPaymentService/delPaymentApply",{appno:row.appno});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $common.get_tipDialog('删除成功！','showSuccess');
                        queryTable();
                        $scope.selected.select=[];
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
            });
        }
    }
};
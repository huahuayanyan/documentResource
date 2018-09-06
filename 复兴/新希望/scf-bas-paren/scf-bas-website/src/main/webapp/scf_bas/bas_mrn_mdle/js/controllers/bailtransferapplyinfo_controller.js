/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var bailtransferapplyinfoController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel){
			$scope.applyform = dataDeliver.getter();
			$scope.continfoform={};
			$scope.updateForm={};
		    $scope.bailselected={select: []};//初始化对象
		    $scope.baildatasource={ds: []};//初始化表格对象
		    $scope.bailconf= {pageNo: 1, pageSize: 10};//初始化分页对象
			
			$scope.querycontinfo=function(){
				    var data= {
				           appId:$scope.applyform.mastContCode
				    };
				    var promise = $common.get_asyncData("bCrrLnConService/findBCrrLnConByAppId",data);
				    promise.then(function(res){
				        var data;
				        if (res.errorCode =="SUC"){
				            data = res.contextData;
				            $scope.continfoform = data;
				        }else{
				            $common.get_tipDialog(res.errorMsg,'showError');
				        }
				    });
				
			};
			$scope.querycontinfo();
		    //监听分页
		    $scope.$watch("bailconf.pageNo+bailconf.pageSize", function () {
		    	$scope.querybailTable();
		    });
		  
		    $scope.querybailTable=function(){
				    var data= {
				        pageNo: $scope.bailconf.pageNo,
				        pageSize: $scope.bailconf.pageSize,
				        bMrnAcctBussInfo:{mastContno:$scope.applyform.mastContCode,custcd:$scope.applyform.custcd}
				    };				    
				    var promise = $common.get_asyncData("bMrnAcctBussInfoService/queryTblCustAccountBussInfoList",data);
				    promise.then(function(res){
				        var data;
				        if (res.errorCode =="SUC"){
				            data = res.contextData;
							for (var j = 0;j<data.records.length;j++) {
								var bailAmount=data.records[j].bailAmount;
								var bailRate =data.records[j].bailRate;
								if(bailAmount==null){
									bailAmount=0;
								}
								if(bailRate==null){
									bailRate=0;
								}
								data.records[j].gageAmount=(bailAmount*bailRate)/100;
						
							}
				            $scope.baildatasource.ds = data.records;
			                $scope.bailconf.totalRecord = data.totalRecord;			                
				        }else{
				            $common.get_tipDialog(res.errorMsg,'showError');
				        }
				    });
		    	
		    };
		
		    $scope.loanselected={select: []};//初始化对象
		    $scope.loandatasource={ds: []};//初始化表格对象
		    $scope.loanconf= {pageNo: 1, pageSize: 10};//初始化分页对象
		    //监听分页
		    $scope.$watch("loanconf.pageNo+loanconf.pageSize", function () {
		    	$scope.queryLoanTable();
		    });
		  
		    $scope.queryLoanTable=function(){
				    var data= {
				        pageNo: $scope.loanconf.pageNo,
				        pageSize: $scope.loanconf.pageSize,
				        bLanLnciBase:{mastContcode:$scope.applyform.mastContCode}
				    };
				    var promise = $common.get_asyncData("incimarginService/findBLanLnciBaseList",data);
				    promise.then(function(res){
				        var data;
				        if (res.errorCode =="SUC"){
				            data = res.contextData;
				            $scope.loandatasource.ds = data.records;
			                $scope.loanconf.totalRecord = data.totalRecord;
				        }else{
				            $common.get_tipDialog(res.errorMsg,'showError');
				        }
				    });
		    	
		    };			
			
			
		  //回款保证金账号
		    $scope.bailAcctNoContent = {
		        type:"table",//展示类型table  tree
		        url:"bSysCommonService/selectAccountNo",//请求url
		        param:{custcd:$scope.applyform.custcd, accountType:"3" },//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
		        split:"-",//分隔符
		        extentColumn:"accountNo",
		        column:["accountNo"]//展示内容
		    };
		    $scope.bailAcctNodooextent = function(ds){
		        $scope.updateForm.bailAccountno=ds.accountNo;
		        //  $scope.otherform.ID=ds.ID;
		    };
 
		    $scope.back_onClick = function(){
		    	    $state.go("bailtransferapply");
		    };	
		    
		    $scope.save_onClick = function(){
		    	 if($.doValidate("updateForm")) {
		    		 
		    		    if($scope.loanselected.select.length <= 0||$scope.loanselected.select.length > 1){
		    		        $common.get_tipDialog('请选择一条借据记录！','showInform');
		    		        return;
		    		    }
		    		    
		    	        var data = {
		    	          	  bmrnAppliAcctInfo: $scope.updateForm
		    	          };
		    	          data.bmrnAppliAcctInfo.debetNo=$scope.loanselected.select[0].debetNo;
		    	          data.bmrnAppliAcctInfo.custcd=$scope.applyform.custcd;
		    	          data.bmrnAppliAcctInfo.mastContno=$scope.applyform.mastContCode;   	          
		    	        var primise = $common.get_asyncData("incimarginService/saveBailTransferApplySingle", data);
		    	          primise.then(function (res) {
		    	              if (res.errorCode == "SUC") {
		    	                  $common.get_tipDialog('保存成功！', 'showSuccess');
		    	                  $state.go("bailtransferapply");
		    	                  //$scope.updateForm.appno=res.contextData.value;
		    	              } else {
		    	                  $common.get_tipDialog(res.errorMsg, 'showError');
		    	              }
		    	          });	 
		    		 
		    		 
		    	 }	

		};  
		    
		    
			

};
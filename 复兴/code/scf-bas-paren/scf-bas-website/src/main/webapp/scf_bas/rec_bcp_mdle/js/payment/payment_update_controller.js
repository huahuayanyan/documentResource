/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/9/29
 */
var paymentUpdateController =  function($scope,$common,$stateParams,dataDeliver,$state,$eventCommunicationChannel){
	   $scope.viewhide=window.viewhide;
	   $scope.viewdisable=window.viewdisable;
	   if(window.backhide!=null){
		    $scope.backhide=window.backhide;
	     }else {
	    	 $scope.backhide=window.viewhide;  
	     }
	    $scope.infoform={};
	    $scope.paydatasource={//初始化表格对象
	            ds: []
	        };
	    $scope.payselected={//初始化对象
	            select: []
	        };
	    $scope.payconf= {//初始化分页对象
	            pageNo: 1,
	            pageSize: 10,
	            totalRecord: 0};
	    
	    $scope.loandatasource={//初始化表格对象
	            ds: []
	        };
	    $scope.loanselected={//初始化对象
	            select: []
	        };
	    $scope.loanconf= {//初始化分页对象
	            pageNo: 1,
	            pageSize: 10,
	            totalRecord: 0};

	    
	    function queryCancelTable(){
	        var data= {
	            pageNo: $scope.payconf.pageNo,
	            pageSize: $scope.payconf.pageSize,
	            value:{appno:$stateParams.appNo}
	        };
	        var promise = $common.get_asyncData("rBcpAppliBussDtlService/findRBcpAppliBussDtlPageByPage",data);
	        promise.then(function(res){
	            var data;
	            if (res.errorCode =="SUC"){
	                data = res.contextData;
	                $scope.paydatasource.ds = data.records;
	                $scope.payconf.totalRecord = data.totalRecord;
	            }else{
	                $common.get_tipDialog(res.errorMsg,'showError');
	            }
	        });
	    };
	
	    //查询关联借据信息
	    function queryLoanTable(){
	        var data= {
	            pageNo: $scope.loanconf.pageNo,
	            pageSize: $scope.loanconf.pageSize,
	            appno:$stateParams.appNo
	        };
	        var promise = $common.get_asyncData("irBcpPaymentService/findLoanByPage",data);
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

	$scope.otherform = {};
	$scope.queryTaskForm = function(paramData)
	{
		var processId=$stateParams.processId;
		var modelId=$stateParams.modelId;
		var appno = $stateParams.appNo;
		//通过申请编号获得申请相关的信息
		var promise = $common.get_asyncData("bPbcAppliBaseInfoService/findBPbcAppliBaseInfoByKey",{"key":appno});
		promise.then(function(res){
			if (res.errorCode =="SUC"){
				$scope.otherform=res.contextData;
				var bCrmBrInfo={
					brNo:res.contextData.startBrcode
				}
				var promiseA = $common.get_asyncData("bCrmBaseInfoService/findBCrmBrInfo",{bCrmBrInfo:bCrmBrInfo});
				promiseA.then(function(res1){
					if(res1.errorCode =="SUC"){
						$scope.otherform.tlrName=userInfo.tlrName;//经办人
						$scope.otherform.brName=res1.contextData.brName;//经办机构
						$scope.otherform.processId=processId;
						$scope.otherform.modelId=modelId;
					}else{
						$common.get_tipDialog(res1.errorMsg,'showError');
					}
				});
			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		});
	}
	if($stateParams.appNo)
	{
		$("#taskform").css("display","");
		$scope.queryTaskForm();
	}
	else
	{
		$("#taskform").css("display","none");
	}
	    
	$scope.querypaymentinfo=function(){
		    var data= {
		    		rBcpAppliBussInfo:{
		    			appno:$stateParams.appNo
		    		}
		    };
		    var promise = $common.get_asyncData("irBcpPaymentService/getInvoicePaymentInfo",data);
		    promise.then(function(res){
		        var data;
		        if (res.errorCode =="SUC"){
		            data = res.contextData;
		            $scope.infoform=data;

		        }else{
		            $common.get_tipDialog(res.errorMsg,'showError');
		        }
		    });
    };  

    
    

   
   $scope.init=function(){
	     $scope.repayPurposedisable=false;
		if($scope.infoform.loanWay=='02'){
			$scope.repayPurposedisable=true;

		}
   };
   
   $scope.querytransaction_onClick=function(){
  	   $scope.$apply(function(){
		   //简单模拟
		   $scope.infoform.transactionNo="SM"+new Date().getTime();
		   $scope.infoform.returnAmount=5000;
		   $scope.infoform.totalOverAmount=5000;
       });
	   
	  var data= {
 		  paymentBussInfo:$scope.infoform
     };
     var primise = $common.get_asyncData("irBcpPaymentService/updatePaymentApply",data);
     primise.then(function(res){
         if (res.errorCode =="SUC"){

         }else{
             $common.get_tipDialog(res.errorMsg,'showError');
         }
     });
       
       
   };
   
   
   $scope.queryBalance_onClick=function(){
  	   $scope.$apply(function(){
		   //简单模拟
		   $scope.infoform.returnAccountBalance=10000000;
		   
       });
 	  var data= {
	 		  paymentBussInfo:$scope.infoform
	     };
	     var primise = $common.get_asyncData("irBcpPaymentService/updatePaymentApply",data);
	     primise.then(function(res){
	         if (res.errorCode =="SUC"){

	         }else{
	             $common.get_tipDialog(res.errorMsg,'showError');
	         }
	     });
	   
   };
   
   
   $scope.assignAmount_onClick=function(){
	      if($scope.infoform.returnAmount==null){
	    	  return;
	    	  
	      }
	     
	      var data= {
	    		  paymentBussInfo:$scope.infoform
	        };
            var primise = $common.get_asyncData("irBcpPaymentService/assignAmount",data);
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('计算成功！','showSuccess');
                    queryCancelTable();
                    queryLoanTable();
                    $scope.querypaymentinfo();

                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
	   

	   
   };
   
   $scope.updateloan_onClick=function(){
	   
       if($scope.loanselected.select.length <= 0||$scope.loanselected.select.length > 1){
           $common.get_tipDialog('请选择一条记录！','showInform');
           $scope.loanselected.select=[];

       }else{
			$common.get_ngDialog('payment/loan_update.html',$scope,["$scope",function(guideScope){
				      guideScope.loaninfo=$scope.loanselected.select[0];	
				      guideScope.save_onClick =function(){	
					  if($.doValidate("loaninfo")){

			                   var data={
			                		   appno:$stateParams.appNo,
			                		   payMentLanInfo:$scope.loanselected.select[0]
			                      };
				                var primise = $common.get_asyncData("irBcpPaymentService/updatePayMentLanInfo",data);
				                primise.then(function(res){
				                    if (res.errorCode =="SUC"){
				                    	
				                    	 $scope.loanselected.select=[];
					                      guideScope.closeThisDialog();
					                      queryCancelTable();
					                      queryLoanTable();
					                      $scope.querypaymentinfo();
				                    }else{
				                        $common.get_tipDialog(res.errorMsg,'showError');
				                    }
				                });
							  
						  }				  
				  };
				
			}],'修改融资信息',{showClose:true},750);       	   
    	    
       }
   };
   
   
   $scope.addcancel_onClick=function(){
		$common.get_ngDialog('payment/select_bcp_list.html',$scope,["$scope",function(guideScope){

			guideScope.conditionForm={
	    			appno:$scope.infoform.appno,
	    			mastContno:$scope.infoform.mastContno,
	    			custcdBuyer:$scope.infoform.custcdBuyer
			};
			guideScope.rebort_onClick =function(){
		        guideScope.conditionForm.billsDateFrom = "";
		        guideScope.conditionForm.billsDateTo = "";
		        guideScope.conditionForm.debtEndFrom = "";
		        guideScope.conditionForm.debtEndTo = "";
		        guideScope.conditionForm.billsNo = "";
		        guideScope.conditionForm.billsType = "";
		        guideScope.queryTable();
		    }
		    guideScope.datasource={//初始化表格对象
		            ds: []
		        };
		        guideScope.selected={//初始化对象
		            select: []
		        };
		        guideScope.conf= {//初始化分页对象
		            pageNo: 1,
		            pageSize: 10,
		            totalRecord: 0};
		        //监听分页
		        guideScope.$watch("conf.pageNo+conf.pageSize",function(){
		            guideScope.queryTable();
		        });
			
		        //点击查询之后的搜索
		        guideScope.submit_onClick =function(){
		        	guideScope.queryTable();
		        	guideScope.selected.select=[];
		        };
			
		    //查询操作
		    guideScope.queryTable = function(paramData){
		        var data= {
		            pageNo: guideScope.conf.pageNo,
		            pageSize: guideScope.conf.pageSize,
		            value:guideScope.conditionForm
		        };
		        var promise = $common.get_asyncData("irBcpPaymentService/findCancelRBcpDebtBaseInfoPageByPage",data);
		        promise.then(function(res){
		            var data;
		            if (res.errorCode =="SUC"){
		                data = res.contextData;
		                guideScope.datasource.ds = data.records;
		                guideScope.conf.totalRecord = data.totalRecord;
		            }else{
		                $common.get_tipDialog(res.errorMsg,'showError');
		            }
		        });
		    };
			
			
	        guideScope.cancel_onClick =function(){	
	        	guideScope.closeThisDialog();
	        };
			
	        guideScope.confirm_onClick =function(){	
		            if(guideScope.selected.select.length <= 0||guideScope.selected.select.length > 1){
		                $common.get_tipDialog('请选择一条记录！','showInform');
		            }
		            else{
	                   var data={
	                		     appno:$stateParams.appNo,
	                		     rBcpAppliBussDtl:guideScope.selected.select[0]
	                      };
		                var primise = $common.get_asyncData("irBcpPaymentService/addRBcpAppliBussDtl",data);
		                primise.then(function(res){
		                    if (res.errorCode =="SUC"){
		                        guideScope.selected.select=[];
		                        guideScope.closeThisDialog();
		                        queryCancelTable();
		                        queryLoanTable();
		                    }else{
		                        $common.get_tipDialog(res.errorMsg,'showError');
		                    }
		                });		            	
		            }
	        };		
		  }],'添加单据',{showClose:true},750);   
	   
   }; 
   

   
   $scope.updatecancel_onClick=function(){
	   
       if($scope.payselected.select.length <= 0||$scope.payselected.select.length > 1){
           $common.get_tipDialog('请选择一条记录！','showInform');
           $scope.payselected.select=[];

       }else{
			$common.get_ngDialog('payment/bcp_update.html',$scope,["$scope",function(guideScope){
				      guideScope.billinfo=$scope.payselected.select[0];	
				      guideScope.save_onClick =function(){	
					  if($.doValidate("billinfo")){
							  if(parseFloat(guideScope.billinfo.removeAmount)>parseFloat(guideScope.billinfo.remainingAmount)){
								  $common.get_tipDialog("核销金额必须小于等于[应收账款余额]",'showError');
								  return;
							  }
							  if(parseFloat(guideScope.billinfo.payAmount)>parseFloat(guideScope.billinfo.removeAmount)){
								  $common.get_tipDialog("入账金额必须小于等于[核销金额]",'showError');
								  return;
							  }

			                   var data={
			                		     rBcpAppliBussDtl:guideScope.billinfo
			                      };
				                var primise = $common.get_asyncData("irBcpPaymentService/updateRBcpAppliBussDtl",data);
				                primise.then(function(res){
				                    if (res.errorCode =="SUC"){
				                    	
				                    	 $scope.payselected.select=[];
					                      guideScope.closeThisDialog();
					                      queryCancelTable();
					                      queryLoanTable();
					                      $scope.querypaymentinfo();
				                    }else{
				                        $common.get_tipDialog(res.errorMsg,'showError');
				                    }
				                });
							  
						  }				  
				  };
				
			}],'修改单据',{showClose:true},750);       	   
    	    
       }
   };
   
   $scope.delcancel_onClick=function(){
	   
       if($scope.payselected.select.length <= 0||$scope.payselected.select.length > 1){
           $common.get_tipDialog('请选择一条记录！','showInform');
           $scope.payselected.select=[];

       }else{
		       var data={
		  		     rBcpAppliBussDtl:$scope.payselected.select[0]
		        };
		      var primise = $common.get_asyncData("irBcpPaymentService/deleteRBcpAppliBussDtl",data);
		      primise.then(function(res){
		          if (res.errorCode =="SUC"){
		          	 $scope.payselected.select=[];
		              queryCancelTable();
		              queryLoanTable();
		              $scope.querypaymentinfo();
		          }else{
		              $common.get_tipDialog(res.errorMsg,'showError');
		          }
		      });  
       }
   };   
   
   
   $scope.rebate_onClick=function(){
	   
       if($scope.payselected.select.length <= 0||$scope.payselected.select.length > 1){
           $common.get_tipDialog('请选择一条记录！','showInform');
           $scope.payselected.select=[];

       }else{

			  if($scope.payselected.select[0].remainingAmount==null||parseFloat($scope.payselected.select[0].remainingAmount)<=0){
				  return;
			  }
			  
			  $scope.payselected.select[0].payAmount=$scope.payselected.select[0].remainingAmount;
			  $scope.payselected.select[0].removeAmount=$scope.payselected.select[0].remainingAmount;

            var data={
         		     rBcpAppliBussDtl: $scope.payselected.select[0]
               };
             var primise = $common.get_asyncData("irBcpPaymentService/updateRBcpAppliBussDtl",data);
             primise.then(function(res){
                 if (res.errorCode =="SUC"){
                 	
                 	 $scope.payselected.select=[];
	                      queryCancelTable();
	                      queryLoanTable();
	                      $scope.querypaymentinfo();
                 }else{
                     $common.get_tipDialog(res.errorMsg,'showError');
                 }
             });

       }
   };
   
   $scope.save_onClick =function(){	
		  if($.doValidate("infoform")){
			      var data= {
			    		  paymentBussInfo:$scope.infoform
			        };
	                var primise = $common.get_asyncData("irBcpPaymentService/updatePaymentApply",data);
	                primise.then(function(res){
	                    if (res.errorCode =="SUC"){
	                        $common.get_tipDialog('保存成功！','showSuccess');

	                    }else{
	                        $common.get_tipDialog(res.errorMsg,'showError');
	                    }
	                });
				  
			  }				  
	  };
	  

	   
	  
	   //提交
	    $scope.flowsubmit_onClick = function(){
	    	
	    	
			  if($.doValidate("infoform")){

				  //偿还融资金额
				  if($scope.infoform.totalRepayAmount==null||$scope.infoform.totalRepayAmount==0||$scope.infoform.totalRepayAmount==undefined){
					  $common.get_tipDialog("“偿还融资金额”不能为空且大于零！",'showError');
					  return;
				  }
				  //尾款金额
				  if($scope.infoform.totalOverAmount<0){
					  $common.get_tipDialog("“尾款金额”不能为空且大于等于零！",'showError');
					  return;
				  }
				  var returnAmount = Number($scope.infoform.returnAmount);//本次入账总额
				  var repayAmount = Number($scope.loandatasource.ds[0].repayAmount);//还款金额
				  if(repayAmount>returnAmount)
				  {
					  $common.get_tipDialog("融资列表“还款金额”不能大于“本次入账总额”！",'showError');
					  return;
				  }
			      var data= {
			    		  paymentBussInfo:$scope.infoform
			        };
	                var primise = $common.get_asyncData("irBcpPaymentService/updatePaymentApply",data);
	                primise.then(function(res){
	                    if (res.errorCode =="SUC"){
	                    	
	                    
					        		        var primise = $common.get_asyncData("irBcpPaymentService/submitFlow",{key:$stateParams.appNo});
					        			    primise.then(function(res){
					        			            if (res.errorCode =="SUC"){
					        			            	
					        			      	      //发起工作流
					        			                var data = {
					        			                    modelId : 'CashPaymentApply',
					        			                    ProcessName : '应收账款回款申请',
					        			                    NodeId : 'Write',
					        			                    startedUserId : userInfo.tlrNo,
					        			                    bizId : $stateParams.appNo,
					        			                    bizData : [
					                                               $stateParams.appNo,
					                                               $scope.infoform.custcdSaller,
					        			                           $scope.infoform.cnameSeller,
					        			                           'CashPaymentApply'
					        			                    ]
					        			                };
					        			                var primise = $common.get_asyncData("processService/startProcess",data);
					        			                primise.then(function(res){
					        			                    if (res.errorCode =="SUC"){
					        			                    	$common.get_tipDialog('发起成功！','showSuccess');
					        			                    	 $state.go("paymentapplylist");	
					        			                    	
					        			                      }else{
					        			                    	$common.get_tipDialog('发起失败!'+res.errorMsg,'showError');
					        			                   	  //  $scope.flowsubmitdisable=false;
					        			                     }
					        			                    
					        			                });
					        			            	
					        			            }else{
					        			                $common.get_tipDialog(res.errorMsg,'showError');
					        			      	 	  //  $scope.flowsubmitdisable=false;
					        			            }
					        			        });
	                    	
	                    	
	                    	
	                    	

	                    }else{
	                        $common.get_tipDialog(res.errorMsg,'showError');
	                    }
	                });
				  
			  }	

		      


	    };  
	  
   
   
   $scope.back_onClick =function(){	
          $state.go("paymentapplylist");	
   };
	
   //监听分页
   $scope.$watch("payconf.pageNo+payconf.pageSize", function () {
       queryCancelTable();
   });   
   
   $scope.$watch("loanconf.pageNo+loanconf.pageSize", function () {
   	queryLoanTable();
   });   
   
   $scope.querypaymentinfo();
   $scope.init();
};

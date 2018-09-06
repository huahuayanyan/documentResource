/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var bsysTaskCommentController = function($scope,$common,$stateParams,$state,dataDeliver,$eventCommunicationChannel) {
	console.log("bsysTaskCommentController:$stateParams"+JSON.stringify($stateParams));
	//任务节点按钮属性初始化
	if($stateParams.nodeButton==null||$stateParams.nodeButton==undefined||$stateParams.nodeButton==""){ 
		   $stateParams.nodeButton={};
	  }else{
		  $stateParams.nodeButton=eval("("+$stateParams.nodeButton+")");
	  }
	//审批通过，流程结束
	if($stateParams.nodeButton.approvalHide==null||$stateParams.nodeButton.approvalHide==undefined){
		$scope.approvalHide=true;
	}else{
		$scope.approvalHide=$stateParams.nodeButton.approvalHide;
	}
	if($stateParams.nodeButton.approvalName==null||$stateParams.nodeButton.approvalName==undefined){
		$scope.approvalName="审批通过";
	}else{
		$scope.approvalName=$stateParams.nodeButton.approvalName;
	}
	//审批否决，流程结束
	if($stateParams.nodeButton.rejectHide==null||$stateParams.nodeButton.rejectHide==undefined){
		$scope.rejectHide=true;
	}else{
		$scope.rejectHide=$stateParams.nodeButton.rejectHide;
	}
	
	if($stateParams.nodeButton.rejectName==null||$stateParams.nodeButton.rejectName==undefined){
		$scope.rejectName="审批否决";
	}else{
		$scope.rejectName=$stateParams.nodeButton.rejectName;
	}
	
	//提交下一步流转
	if($stateParams.nodeButton.nextHide==null||$stateParams.nodeButton.nextHide==undefined){
		$scope.nextHide=false;
	}else{
		$scope.nextHide=$stateParams.nodeButton.nextHide;
	}
	
	if($stateParams.nodeButton.nextName==null||$stateParams.nodeButton.nextName==undefined){
		$scope.nextName="提交";
	}else{
		$scope.nextName=$stateParams.nodeButton.nextName;
	}

	//退回修改按钮
	if($stateParams.nodeButton.IssuedHide==null||$stateParams.nodeButton.IssuedHide==undefined){
		$scope.IssuedHide=true;
	}else{
		$scope.IssuedHide=$stateParams.nodeButton.IssuedHide;
	}

	if($stateParams.nodeButton.IssuedName==null||$stateParams.nodeButton.IssuedName==undefined){
		$scope.IssuedName="退回修改";
	}else{
		$scope.IssuedName=$stateParams.nodeButton.IssuedName;
	}
	//查看通知书
	if($stateParams.nodeButton.NoteHide==null||$stateParams.nodeButton.NoteHide==undefined){
		$scope.NoteHide=true;
	}else{
		$scope.NoteHide=$stateParams.nodeButton.NoteHide;
	}

	if($stateParams.nodeButton.NoteName==null||$stateParams.nodeButton.NoteName==undefined){
		$scope.NoteName="查看通知书";
	}else{
		$scope.NoteName=$stateParams.nodeButton.NoteName;
	}

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
    		taskComment:''
    };
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });


    //查询
    $scope.queryTable = function(){
		var list = [];
		var count = 0;
		var param = {
			pageNo: $scope.conf.pageNo,
			pageSize: $scope.conf.pageSize,
			appno:$stateParams.appNo,
			processId:$stateParams.processId,
			flag:"2"
		};
		$common.get_asyncData("bSysTaskService/getBaseNodeAttitudeByAppno",param).then(function(res){
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

    var bizData=[
		$stateParams.appNo,
		$stateParams.custId,
		$stateParams.custNm,
		$stateParams.modelId,
		userInfo.tlrName
	];
    $scope.commFlow=function(extfunction){
		var comment = $scope.applyDtlForm.taskComment;
		if(comment!=null&&comment!=undefined) {
			var realLen = 0;
			var len = comment.length;
			var charCode = -1;
			for(var i=0;i<len;i++) {
				charCode = comment.charCodeAt(i);
				if(charCode>=0&&charCode<=128) {
					realLen += 1;
				} else {
					realLen += 3;
				}
			}
			if(realLen>255) {
				$common.get_tipDialog('“审批意见”长度超过限值，请重新输入……','showError');
				return;
			}
		}
			$scope.disable=true;
			 //领取当前任务
			   var data = {
			           taskId: $stateParams.taskId,
			           processId:$stateParams.processId,
			           userId: userInfo.tlrNo,
			           //第五个参数默认处理人名称
			           bizData: [
			                     $stateParams.appNo,
			                     $stateParams.custId,
			                     $stateParams.custNm,
			                     $stateParams.modelId,
			                      userInfo.tlrName
			                   ]
			       };
			       var primise = $common.get_asyncData("taskService/takeTask",data);
			       primise.then(function(res){
			           if (res.errorCode == "SUC") {
			      		                  //完成当前任务
			        	                 //意见
			                              data.comment=$scope.applyDtlForm.taskComment;
			                              var primise = $common.get_asyncData("taskService/completeTask", data);
			                              primise.then(function(res){
			                                  if (res.errorCode == "SUC") {
			                                	         //回调函数
			                                	          extfunction(data);

			                                   }else{
			                                      $common.get_tipDialog(res.errorMsg,'showError');
			                                      $scope.disable=false;
			                                  }
			                              });
			           }else{
			               $common.get_tipDialog(res.errorMsg,'showError');
			               $scope.disable=false;
			           }
			       });
    };
	//校验页面审批意见字段
    function checkFormRule(){
		var comment = $scope.applyDtlForm.taskComment;
		if($scope.applyDtlForm.taskComment) {
			var realLen = 0;
			var len = comment.length;
			var charCode = -1;
			for(var i=0;i<len;i++) {
				charCode = comment.charCodeAt(i);
				if(charCode>=0&&charCode<=128) {
					realLen += 1;
				} else {
					realLen += 3;
				}
			}
			if(realLen>255) {
				$common.get_tipDialog('“审批意见”长度超过限值，请重新输入……','showError');
				return false;
			}
			return true;
		}else{//没有写意见也是可以的
			return true;
		}
	}
    //提交下一步
    $scope.next_onClick = function(button){	
    	//判断当前节点的下一个节点为结束节点时，点击提交按钮弹出选择终审选择框；否则正常提交下一个节点。
        var promise = $common.get_asyncData("processService/getNextNode", {pid:$stateParams.processId});
        promise.then(function (res) {
            if (res.errorCode == "SUC") {
                   var data = res.contextData;
                   //结束节点
                   if(data.nodeType=='2'){
                       $common.get_tipDialog('确认审批通过?','showTip').then(
                    		   function () {
                    			   //确认，审批通过
                    			   $scope.approval_onClick();
                               },
			                   function(){
                            	   //取消,审批否决
                            	   //$scope.reject_onClick();
			                   }
                       );
                   }
                   //非结束节点，正常提交
                   else{
					   if(checkFormRule()==true){
						   $scope.nextDisable=true;//防止多次点击
						   //回调业务处理
						   var taskComment = $scope.applyDtlForm.taskComment;
						   if(!$scope.applyDtlForm.taskComment||$scope.applyDtlForm.taskComment==null||$scope.applyDtlForm.taskComment==""||$scope.applyDtlForm.taskComment==undefined)
						   {
							   taskComment = "同意";
						   }
						   var promise = $common.get_asyncData("bSysTaskService/flowSumbitProcess",{comment:taskComment,appNo:$stateParams.appNo,processId:$stateParams.processId,modelId:$stateParams.modelId,bizData:bizData});
						   promise.then(function(res){
							   if (res.errorCode =="SUC"){
								   $common.get_tipDialog('流程提交成功！','showSuccess');
								   //跳到主页列表页面
								   $state.go("bsystask");
							   }else{
								   $scope.nextDisable=false;
								   $common.get_tipDialog(res.errorMsg,'showError');
							   }
						   });
					   }
		               }
            }else {
                $common.get_tipDialog('结束节点未配置','showError');
            }
        });	
   };   
    
    
    
    //审批通过,流程结束
    $scope.approval_onClick = function(button){
		if(checkFormRule()==true){
			$scope.approvalDisable=true;//防止多次点击
			//回调业务处理
			var taskComment = $scope.applyDtlForm.taskComment;
			if(!$scope.applyDtlForm.taskComment||$scope.applyDtlForm.taskComment==null||$scope.applyDtlForm.taskComment==""||$scope.applyDtlForm.taskComment==undefined)
			{
				taskComment = "通过";
			}
			var promise = $common.get_asyncData("bSysTaskService/bizProcess",{comment:taskComment,appNo:$stateParams.appNo,processId:$stateParams.processId,modelId:$stateParams.modelId,flag:"pass",bizData:bizData});
			promise.then(function(res){
				if (res.errorCode =="SUC"){
					$common.get_tipDialog('审批通过！','showSuccess');
					//跳到主页列表页面
					$state.go("bsystask");
				}else{
					$scope.approvalDisable=false;
					$common.get_tipDialog(res.errorMsg,'showError');
				}
			});
		}
    };




    //审批否决,流程结束
    $scope.reject_onClick = function(button){
		if(checkFormRule()==true){
			$scope.rejectDisable=true;//防止多次点击
			//回调业务处理
			var taskComment = $scope.applyDtlForm.taskComment;
			if(!$scope.applyDtlForm.taskComment||$scope.applyDtlForm.taskComment==null||$scope.applyDtlForm.taskComment==""||$scope.applyDtlForm.taskComment==undefined)
			{
				taskComment = "否决";
			}
			var promise = $common.get_asyncData("bSysTaskService/bizProcess",{comment:taskComment,appNo:$stateParams.appNo,processId:$stateParams.processId,modelId:$stateParams.modelId,flag:"reject",bizData:bizData});
			promise.then(function(res){
				if (res.errorCode =="SUC"){
					$common.get_tipDialog('审批否决成功！','showSuccess');
					//跳到主页列表页面
					$state.go("bsystask");
				}else{
					$scope.rejectDisable=false;
					$common.get_tipDialog(res.errorMsg,'showError');
				}
			});
		}
    };

	//退回
	$scope.BackSubmit_onClick = function(button) {
		if(checkFormRule()==true){
			$scope.IssuedDisable=true;//防止多次点击
			//回调业务处理
			var taskComment = $scope.applyDtlForm.taskComment;
			if(!$scope.applyDtlForm.taskComment||$scope.applyDtlForm.taskComment==null||$scope.applyDtlForm.taskComment==""||$scope.applyDtlForm.taskComment==undefined)
			{
				taskComment = "退回";
			}
			var promise = $common.get_asyncData("bSysTaskService/bizProcess",{comment:taskComment,appNo:$stateParams.appNo,processId:$stateParams.processId,modelId:$stateParams.modelId,flag:"back",bizData:bizData});
			promise.then(function(res){
				if (res.errorCode =="SUC"){
					$common.get_tipDialog('任务已退回！','showSuccess');
					//跳到主页列表页面
					$state.go("bsystask");
				}else{
					$scope.IssuedDisable=false;
					$common.get_tipDialog(res.errorMsg,'showError');
				}
			});
		}
	};

};

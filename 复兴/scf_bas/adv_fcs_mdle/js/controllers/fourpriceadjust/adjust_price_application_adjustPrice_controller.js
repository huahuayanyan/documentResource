/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      gongzhao
 * @version     1.0
 * Create at:   2017/05/03
 */

var adjustPriceApplicationAdjustPriceController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
	 $scope.otherform={};
	 var bData = window.source.otherform;
	 $scope.otherform=bData;
	 $scope.conf= {//初始化分页对象
	        pageNo: 1,
	        pageSize: 10,
	        totalRecord: 0};
	    $scope.datasource={//初始化表格对象
	            ds: []
	        };
	        $scope.selected={//初始化对象
	            select: []
	        };
	        $scope.source={
	            addBailAmount:[]
	        };
	        var seq;//流程节点顺序
	        var processId = window.processId;//流程点
	        
	        
	        $scope.taskform =  window.source.taskform;
	        $("#showIdea").css('display','');
	     /*   if(!$scope.taskform)
	        {
	            $("#showIdea").css('display','none');
	            $scope.morthide = true;
	            $scope.disable = false;
	        }
	        else
	        {
	            $scope.hide = true;
	            if($scope.taskform.id == "Write")
	            {//普通仓单质押填写岗
	                $scope.hide = false;
	                $scope.morthide = true;
	                $scope.disable = false;
	            }
	           
	        }*/
	        $scope.applyDtlForm = {};
	        $scope.datasourcetask={//初始化表格对象
	            ds:[
	            ]
	        };
	        $scope.selectedtask={//初始化对象
	            select: []
	        };
	        $scope.conftask= {//初始化分页对象
	            pageNo: 1,
	            pageSize: 10,
	            totalRecord: 0
	        };

	        $scope.applyDtlForm={
	            taskComment:''
	        }

	        //监听分页
	        $scope.$watch("conftask.pageNo+conftask.pageSize",function()
	        {
	            if(window.processId)
	            {
	                $scope.queryTabletask();
	            }
	        });

	        //查询
	        $scope.queryTabletask = function(){
	            var data= {
	                processId:window.processId,
	                pageNo: $scope.conftask.pageNo,
	                pageSize: $scope.conftask.pageSize
	            };
	            var promise = $common.get_asyncData("taskService/getDoneTask",data);
	            promise.then(function(res){
	                var data;
	                if (res.errorCode =="SUC"){
	                    data = res.contextData;
	                    $scope.datasourcetask.ds = data.records;
	                    $scope.conftask.totalRecord = data.totalRecord;
	                }else{
	                    $common.get_tipDialog(res.errorMsg,'showError');
	                }
	            });
	        };
	        
	        var appno = bData.appno;
	        
	        //设置回执确认隐藏
            $scope.hidereceipt =window.hidereceipt;
            //设置同意按钮隐藏
            $scope.hideconfirm =window.hideconfirm;
            //设置退回按钮
            $scope.hidedoBack =window.hidedoBack;
            //设置查看通知书按钮
            $scope.hideviewNotice =window.hideviewNotice;
	        if(appno==null){
	            $scope.sumbitdisable=true;
	            window.hidereceipt=true;
            	$scope.hidereceipt=true;
            	window.hideconfirm=true;
            	$scope.hideconfirm=true;
            	window.hidedoBack=true;
            	$scope.hidedoBack=true;
            	window.hideviewNotice=true;
            	$scope.hideviewNotice=true;
	           
	        }else{ //流程中的处理
	            $scope.sumbitdisable= false;
	            $scope.hideback=true; //返回按钮隐藏
	            queryBaseInfo();
	            queryMortListByAppno();
	            if(window.appNo){
	            	getCurrentNodeEntity();
	            }
	        }
	         
	        function queryBaseInfo(){
	            var data ={
	                commonQryVO:{
	                	appno:appno,
	                	slaveContno:bData.slaveContno
	                }
	            };
	            var promise=$common.get_asyncData("adjustPriceService/getQueryResultWhenAppnoIsEmpty",data);
	            promise.then(function (res) {
	                if(res.errorCode=="SUC"){
	                    data = res.contextData;
	                    $scope.otherform=data;
	                    $scope.otherform.appno=appno;
	                    bData.protocolNo=$scope.otherform.protocolCode;
	                    dataDeliver.setter(bData);
	                }else{
	                    $common.get_tipDialog(res.errorMsg,'showError');
	                }
	            })
	        }
	        
	         
	        function queryMortListByAppno(){
                var data= {
                        pageNo: $scope.conf.pageNo,
                        pageSize:$scope.conf.pageSize,
                        appno:appno
                    };
                    var promise=$common.get_asyncData("adjustPriceService/getMortListByAppno",data);
                    promise.then(function (res) {
                    	  if(res.errorCode=="SUC"){
                              data = res.contextData;
                              $scope.datasource.ds = data.records;
                              $scope.conf.totalRecord = data.totalRecord;
                          }else{
                              $common.get_tipDialog(res.errorMsg,'showError');
                          }
                    })
	        }
	        
	        //获得当前流程节点的信息
	        function getCurrentNodeEntity(){
	            var data = {
	                pid:processId
	            };
	            var promise = $common.get_asyncData("processService/getCurrentNodeEntity", data);
	            promise.then(function (res) {
	                if(res.errorCode=="SUC"){
	                    var flowdata = res.contextData;
	                    seq = parseFloat(flowdata.seq);
	                    if (flowdata.id != "Write") { //提交后的流程
	                        //设置只读熟悉
	                        $scope.taskdisable =true;
	                        //按钮隐藏
	                        $scope.hidetask = true;
	                        $scope.hidesumbit = true;
	                        $scope.hidesave = true;

	                    }
	                    if(flowdata.id == "Write"){
	                    	  //查看通知书隐藏
	                        window.hideviewNotice=true;
	                    	$scope.hideviewNotice=true;
	                    }
	                    if(flowdata.id != "AdjusPrice_receipt"){
	                    	window.hidereceipt=true;
	                    	$scope.hidereceipt=true;
	                    }
	                    if(flowdata.id != "Approve"){
	                    	window.hideconfirm=true;
	                    	$scope.hideconfirm=true;
	                    	window.hidedoBack=true;
	                    	$scope.hidedoBack=true;
	                    }
	                }else{
	                    $common.get_tipDialog(res.errorMsg,'showError');
	                }
	            })
	        }
	        
	        //调价押品添加begin
	        $scope.add_onClick = function(){
	            $common.get_ngDialog('fourpriceadjust/adjustPriceApplicationAdjustPriceAdd.html', $scope
	                ,["$scope",function(dialogScope){
	                    dialogScope.datasourceDialog={//初始化表格对象
	                        ds:[]
	                    };
	                    dialogScope.selectedDialog={//初始化对象
	                        select: []
	                    };
	                    dialogScope.confDialog= {//初始化分页对象
	                        pageNo: 1,
	                        pageSize: 10,
	                        totalRecord: 0};

	                    //监听分页
	                    dialogScope.$watch("confDialog.pageNo+confDialog.pageSize",function(){
	                        dialogScope.queryTable();
	                    });

	                    dialogScope.queryTable = function(){
	                        var data= {
	                            pageNo: dialogScope.confDialog.pageNo,
	                            pageSize:dialogScope.confDialog.pageSize,
	                            mortgageEnter:{slaveContcode:bData.conId}
	                        };
	                        var promise=$common.get_asyncData("adjustPriceService/queryMortgageEnteringListByPage",data);
	                        promise.then(function (res) {
	                            if(res.errorCode=="SUC"){
	                                data = res.contextData;
	                                dialogScope.datasourceDialog.ds = data.records;
	                                dialogScope.confDialog.totalRecord = data.totalRecord;
	                                dialogScope.selectedDialog.select=$common.copy($scope.datasource.ds);
	                            }else{
	                                $common.get_tipDialog(res.errorMsg,'showError');
	                            }
	                        })
	                    };

	                    dialogScope.confirm_onClick = function(){
	                        if(dialogScope.selectedDialog.select.length <= 0){
	                            $common.get_tipDialog('请勾选记录之后再提交！','showInform');
	                            return false;
	                        }
	                        //赋值到上一个页面
	                        $scope.datasource.ds=[];
	                        $scope.datasource.ds = $common.copy(dialogScope.selectedDialog.select);
	                        dialogScope.closeThisDialog();
	                        
	                        //调整前押品总价值计算begin
	                        var array = $scope.datasource.ds;
	                        var totalamt = 0;
	                        for(var j=0;j<array.length;j++){
	                            totalamt = parseFloat(totalamt) + parseFloat(array[j].totPrice);
	                        }
	                        $scope.otherform.originalTotPrice = totalamt;
	                        //调整前押品总价值计算end
	                    };
	                    //返回
	                    dialogScope.closeThisDialog_onClick = function(){
	                        dialogScope.closeThisDialog();
	                    };
	                }],"价格调整列表选择",{showClose:true});

	        };
	        
	        //押品信息修改begin
	        $scope.update_onClick = function(){
	            if($scope.selected.select.length != 1){
	                $common.get_tipDialog('请选择一条记录！','showInform');
	            }else {
	                $common.get_ngDialog('fourpriceadjust/adjustPriceApplicationAdjustPriceUpdate.html', $scope
	                    , ["$scope", function (dialogScope) {
	                        dialogScope.dialogform = {};
	                        //值
	                        dialogScope.dialogform=$common.copy($scope.selected.select[0]);
	                        dialogScope.disable = true;
	                        //查询押品一级
	                        mortgageLevelOneSource();
	                        function mortgageLevelOneSource(){
	                            //业务品种下拉框
	                            var dataItemsDO = {levels:"1"};
	                            var data = {dataItemsDO:dataItemsDO};
	                            var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
	                            dialogScope.mortgageLevelOneSource= {
	                                ds: []
	                            };
	                            promise.then(function(res){
	                                if (res.errorCode =="SUC"){
	                                    dialogScope.mortgageLevelOneSource.ds = res.contextData;
	                                }else{
	                                    $common.get_tipDialog(res.errorMsg,'showInform');
	                                }
	                            });
	                        }
	                        //押品二级
	                        mortgageLevelTwoSource();
	                        function mortgageLevelTwoSource(){
	                            //业务品种下拉框
	                            var dataItemsDO = {levels:"2"};
	                            var data = {dataItemsDO:dataItemsDO}
	                            var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
	                            dialogScope.mortgageLevelTwoSource= {
	                                ds: []
	                            };
	                            promise.then(function(res){
	                                if (res.errorCode =="SUC"){
	                                    dialogScope.mortgageLevelTwoSource.ds = res.contextData;
	                                }else{
	                                    $common.get_tipDialog(res.errorMsg,'showInform');
	                                }
	                            });
	                        }

	                        dialogScope.confirm_onClick = function () {
	                            if($.doValidate("dialogform")) {
	                                //赋值到上一个页面
	                                //遍历已增加记录，修改相应的记录
	                                var dsArray = $scope.datasource.ds;
	                                var selected = $scope.selected.select[0];
	                                for (var i = 0; i < dsArray.length; i++) {
	                                    if (dsArray[i].mortgageNo == selected.mortgageNo) {
	                                        $scope.datasource.ds[i] =$common.copy(dialogScope.dialogform);
	                                        $scope.datasource.ds[i].totChangePrice=parseFloat(dialogScope.dialogform.afterConfirmPrice)*parseFloat(dialogScope.dialogform.quantity);
	                                    }
	                                }
	                                //调整后押品总价值begin
	                                var array = $scope.datasource.ds;
	                                var totalamt = 0;
	                                for(var j=0;j<array.length;j++){
	                                	var  confirmPrice = array[j].afterConfirmPrice;
	                                	if(confirmPrice != undefined && confirmPrice != null)
	                                    totalamt = parseFloat(totalamt) + parseFloat(array[j].afterConfirmPrice)*parseFloat(array[j].quantity);
	                                }
	                                $scope.otherform.totPrice = totalamt;
	                                //本次申请提货总金额的计算end
	                                dialogScope.closeThisDialog();
	                                $scope.selected.select=[]; //清空选中记录
	                            }
	                        };

	                        //返回
	                        dialogScope.closeThisDialog_onClick = function () {
	                            dialogScope.closeThisDialog();
	                        };
	                    }], "", {showClose: true});


	            }
	        };

	        
	        //调价押品列表删除
	        $scope.delete_onClick = function() {
	            if ($scope.selected.select.length != 1) {
	                $common.get_tipDialog('请选择一条记录！', 'showInform');
	            }else {
	                $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
	                    var dsArray = $scope.datasource.ds;
	                    var selected = $scope.selected.select[0];
	                    for (var i = 0; i < dsArray.length; i++) {
	                        if (dsArray[i].mortgageNo == selected.mortgageNo) {
	                            $scope.datasource.ds.splice(i, 1);
	                            $scope.selected.select = [];
	                        }
	                    }
                        //调整前押品总价值计算begin
                        var array = $scope.datasource.ds;
                        var totalamt = 0;
                        var totChangePrice = 0;
                        for(var j=0;j<array.length;j++){
                            totalamt = parseFloat(totalamt) + parseFloat(array[j].totPrice);
                            totChangePrice = parseFloat(totChangePrice) + parseFloat(array[j].totChangePrice);

                        }
                        $scope.otherform.originalTotPrice = totalamt;
                        $scope.otherform.totPrice = totChangePrice;
                        //调整前押品总价值计算end
	                })
	            }
	        };
	        
	        //保存押品信息列表
	        $scope.save_onClick = function()
	        {
	            var list = $scope.datasource.ds;
	            if($scope.datasource.ds.length==0)
	            {
	                $common.get_tipDialog('调价押品列表记录不能为空！','showInform');
	                return;
	            }
	            for(var i =0;i<list.length;i++){
	            	if(list[i].afterConfirmPrice==null || list[i].afterConfirmPrice==undefined||list[i].afterConfirmPrice==0){
	            		  $common.get_tipDialog('调整后单价不能为空和0！','showInform');
	  	                return;
	            	}
	            }
	            if($.doValidate("otherform")) {
	                var totPrice=parseFloat($scope.otherform.totPrice);
	                if(totPrice = 0){
	                    $common.get_tipDialog('调整后价格不能为0！','showInform');
	                    return ;
	                }
	                $scope.otherform.productId='1210020';
	            	var applyVO =$scope.otherform;
                	applyVO.slaveContno =$scope.otherform.conId;
                	applyVO.custcd = $scope.otherform.gutId;
	                    var data={"applyVO": applyVO,
	                    		"list":$scope.datasource.ds
	                    };
	                    var promise = $common.get_asyncData("adjustPriceService/singlePriceAdjustWriteSaveUpdater",data);
	                    promise.then(function(res){
	                        if (res.errorCode =="SUC"){
	                            $scope.otherform.appno= res.contextData.value;
	                            if(seq == "1"|| seq=="2"){

	                            }else{
	                                $scope.hidesumbit=false;
	                                $scope.sumbitdisable=false;
	                            }
	                            $common.get_tipDialog('保存成功！', 'showSuccess');
	                        }else{
	                            $common.get_tipDialog(res.errorMsg,'showError');
	                        }
	                    });
	            }
	        };
	        
	        //提交
	        $scope.sumbit_onClick = function(){
	        	var list = $scope.datasource.ds;
	            if($scope.datasource.ds.length==0)
	            {
	                $common.get_tipDialog('调价押品列表记录不能为空！','showInform');
	                return;
	            }
	            if($.doValidate("otherform")) {
	                var totPrice=parseFloat($scope.otherform.totPrice);
	                if(totPrice = 0){
	                    $common.get_tipDialog('调整后价格不能为0！','showInform');
	                    return ;
	                }
	                $scope.sumbitdisable= true; //点击提交之后提交按钮不可用
	                $scope.otherform.productId='1210020';

	                    var data={"applyVO": $scope.otherform,
	                    		"list":$scope.datasource.ds
	                    };
	                    var promise = $common.get_asyncData("adjustPriceService/singlePriceAdjustSubmit",data);
	                    promise.then(function(res){
	                        if (res.errorCode =="SUC"){
	                            $common.get_tipDialog('提交成功！', 'showSuccess');
	                            if(window.appNo){
	                                //隐藏提货信息列表按钮
	                                $scope.hidetask = true;
	                                $scope.hidesave = true;
	                                $scope.hidesumbit = true;
	                                $scope.hideback = true;

	                            } else {
	                                $scope.back_onClick();
	                            }
	                        }else{
	                            $common.get_tipDialog(res.errorMsg,'showError');
	                        }
	                        $scope.sumbitdisable= false; //返回结果后按钮可用
	                    });
	                  
	            }
	        };
	        
	        //复核确认
	        $scope.confirm_onClick = function()
	        {
	            $scope.ReceiptDisable = true;
	            var data = {
	                appno:appno,
	                taskComment:$scope.applyDtlForm.taskComment
	                };
	            $common.get_asyncData("singlePriceAdjustService/adjustPriceConfirm",data).then(function(res){
	                if (res.errorCode =="SUC"){
	                    $common.get_tipDialog("已跳转下一节点",'showSuccess');
	                    $scope.selected.select = [];
	                    window.hideconfirm=true;
                    	$scope.hideconfirm=true;
                    	window.hidedoBack=true;
                    	$scope.hidedoBack=true;
	                }else{
	                    $common.get_tipDialog(res.errorMsg,'showError');
	                    $scope.ReceiptDisable = false;
	                }
	            });
	        };

	        //回执确认
	        $scope.receipt_onClick = function()
	        {
	            $scope.ReceiptDisable = true;
	            var data = {
	                appno:appno,
	                taskComment:$scope.applyDtlForm.taskComment
	            };
	            $common.get_asyncData("adjustPriceService/adjustPriceAppSignUpdater",data).then(function(res){
	                if (res.errorCode =="SUC"){
	                    $common.get_tipDialog("操作成功，流程结束",'showSuccess');
	                    $scope.selected.select = [];
                    	window.hidereceipt=true;
                    	$scope.hidereceipt=true;
	                }else{
	                    $common.get_tipDialog(res.errorMsg,'showError');
	                    $scope.ReceiptDisable = false;
	                }
	            });
	        };
	        
	      //退回
	        $scope.doBack_onClick = function()
	        {
	            var data = {
	                appno:appno,
	                taskComment:$scope.applyDtlForm.taskComment
	            };
	            var primise = $common.get_asyncData("adjustPriceService/adjustPriceDoBack",data).then(function(res){
	                if (res.errorCode =="SUC"){
	                    $common.get_tipDialog("已退回",'showSuccess');
	                    $scope.selected.select = [];
                    	window.hideconfirm=true;
                    	$scope.hideconfirm=true;
                    	window.hidedoBack=true;
                    	$scope.hidedoBack=true;
	                }else{
	                    $common.get_tipDialog(res.errorMsg,'showError');
	                    $scope.ReceiptDisable = false;
	                }
	            });
	        };
	        
	        //返回
	        $scope.back_onClick = function(){
	        	$state.go("adjustPriceApplyMain");
	        };
};

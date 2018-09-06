/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var billNormalAddApplyController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.baseinfo = $scope.source.baseinfo;
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
    if(!$scope.baseinfo.appno)
    {
        $scope.submitDisable = true;
    }
    else
    {
        $scope.submitDisable = false;
    }
    $scope.taskform = $scope.source.taskform;
    $("#showIdea").css('display','')
    if(!$scope.taskform||!$scope.taskform.id)
    {
        $("#showIdea").css('display','none');
        $("#priceCheck").remove();
        $scope.billhide = true;
    }
    else
    {
    	if($scope.taskform.id != "Write")
    		$scope.hide = true;
    	
        $scope.href = false;
        $scope.billhide = false;
        if($scope.taskform.id == "Write")
        {//普通仓单追加填写岗
            $("#priceCheck").remove();
            $scope.billhide = true;
        }
        else if($scope.taskform.id == "Check")
        {//普通仓单追加核价岗
            $("#priceCheck").show();
            $scope.href = true;
        }
        else if($scope.taskform.id == "Review")
        {//普通仓单追加审核
            $("#priceCheck").remove();
        }
        else if($scope.taskform.id == "Receipt")
        {//普通仓单追加监管商回执
            $("#priceCheck").remove();
        }
        else
        {
            $("#priceCheck").remove();
        }
    }
    $scope.Write = window.Write;
    $scope.Check = window.Check;
    $scope.Review = window.Review;
    $scope.Receipt = window.Receipt;
    $scope.BackToModify = window.BackToModify;

    //监听分页
    $scope.$watch("conf.pageNo",function(){
        $scope.queryTable();
    });
    //仓单列表
    $scope.queryTable = function(paramData)
    {
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            mortgageQryVO:$scope.baseinfo
        };
        var promise = $common.get_asyncData("billNormalAddService/BillNomalDetailGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records||[];
                $scope.conf.totalRecord = data.totalRecord;
                if(!$scope.baseinfo.billno)
                {
                    $scope.baseinfo.billno = $scope.datasource.ds[0].billno;
                }
                $scope.queryTableMort();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    $scope.datasourcemort = {//初始化表格对象
        ds:[]
    };
    $scope.selectedmort ={//初始化对象
        select: []
    };
    $scope.confmort = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //仓单下押品列表
    $scope.queryTableMort = function(paramData)
    {
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            mortgageQryVO:$scope.baseinfo
        };
        var promise = $common.get_asyncData("sBcpMortBillNormalService/BillstandardMortgageBaseGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasourcemort.ds = data.records;
                $scope.confmort.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

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

    //修改押品
    $scope.editmort_onClick = function()
    {
        if($scope.selectedmort.select.length != 1){
            $common.get_tipDialog('请选择一条押品记录！','showInform');
        }else{
            $common.get_ngDialog('nwrinfo/nwrinfo_mortedit.html', $scope,["$scope",function(dialogScope){
                dialogScope.mortgageInfo = $scope.selectedmort.select[0];
                dialogScope.disable = true;
                //查询押品一级
                dialogScope.mortgageLevelOneSource = {
                    ds:[]
                };
                dialogScope.$watch("conf.pageNo+conf.pageSize",function() {
                    dialogScope.mortgageLevelOneSourceList(1);
                    if(dialogScope.mortgageInfo.mortgageLevelOne)
                    {
                        var dataItemsDO = {mortgageCode:dialogScope.mortgageInfo.mortgageLevelOne};
                        var data = {dataItemsDO:dataItemsDO};
                        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }
                });
                dialogScope.mortgageLevelOneSourceList = function(level)
                {
                    //业务品种下拉框
                    var dataItemsDO = {levels:level};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelOneSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                };
                //押品二级
                dialogScope.mortgageLevelTwoSource = {
                    ds:[]
                };
                dialogScope.mortgageLevelOneName = function (val){
                    dialogScope.mortgageInfo.mortgageLevelTwo = "";
                    if(null != val){
                        var dataItemsDO = {mortgageCode:val};
                        var data = {dataItemsDO:dataItemsDO};
                        var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
                        mortgageName.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageInfo.mortgageLevelOneName = res.contextData.mortgageName;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }else{
                        dialogScope.mortgageLevelTwoSource.ds = [];
                    }
                };
                //押品三级
                dialogScope.mortgageLevelThreeSource = {
                    ds:[]
                };
                dialogScope.mortgageLevelTwoName = function (val){
                    dialogScope.mortgageInfo.mortgageLevelThreeSource = "";
                    if(null != val){
                        var dataItemsDO = {mortgageCode:val};
                        var data = {dataItemsDO:dataItemsDO};
                        var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
                        mortgageName.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageInfo.mortgageLevelTwoName = res.contextData.mortgageName;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageLevelThreeSource.ds = res.contextData;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }else{
                        dialogScope.mortgageLevelThreeSource.ds = [];
                    }
                };
                //追加数量失去焦点事件
                dialogScope.addQuantity_onBlur = function()
                {
                    var addQuantity = Number(dialogScope.mortgageInfo.addQuantity);
                    if(addQuantity!=undefined&&addQuantity!=null&&addQuantity!="")
                    {
                        var confirmPrice = Number(dialogScope.mortgageInfo.confirmPrice);
                        var quantity = Number(dialogScope.mortgageInfo.quantity);

                        var amt = addQuantity*confirmPrice;
                        var totPrice = quantity*confirmPrice;

                        dialogScope.mortgageInfo.totPrice = amt+totPrice;
                        dialogScope.$apply();
                    }
                };
                //确认
                dialogScope.save_onClick = function()
                {
                    $scope.$apply();
                    $scope.selectedmort.select = [];
                    dialogScope.closeThisDialog();
                }
                //返回
                dialogScope.close_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"货物维护")
        }
    };
    //查看押品
    $scope.viewmort_onClick = function()
    {
        if($scope.selectedmort.select.length != 1){
            $common.get_tipDialog('请选择一条押品记录！','showInform');
        }else{
            $common.get_ngDialog('nwrinfo/nwrinfo_mortedit.html', $scope,["$scope",function(dialogScope){
                dialogScope.mortgageInfo = $scope.selectedmort.select[0];
                dialogScope.disable = true;
                dialogScope.addQuantityDisable = true;
                dialogScope.saveHide = true;
                //查询押品一级
                dialogScope.mortgageLevelOneSource = {
                    ds:[]
                };
                dialogScope.$watch("conf.pageNo+conf.pageSize",function() {
                    dialogScope.mortgageLevelOneSourceList(1);
                    if(dialogScope.mortgageInfo.mortgageLevelOne)
                    {
                        var dataItemsDO = {mortgageCode:dialogScope.mortgageInfo.mortgageLevelOne};
                        var data = {dataItemsDO:dataItemsDO};
                        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }
                });
                dialogScope.mortgageLevelOneSourceList = function(level)
                {
                    //业务品种下拉框
                    var dataItemsDO = {levels:level};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelOneSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                };
                //押品二级
                dialogScope.mortgageLevelTwoSource = {
                    ds:[]
                };
                dialogScope.mortgageLevelOneName = function (val){
                    dialogScope.mortgageInfo.mortgageLevelTwo = "";
                    if(null != val){
                        var dataItemsDO = {mortgageCode:val};
                        var data = {dataItemsDO:dataItemsDO};
                        var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
                        mortgageName.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageInfo.mortgageLevelOneName = res.contextData.mortgageName;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }else{
                        dialogScope.mortgageLevelTwoSource.ds = [];
                    }
                };
                //押品三级
                dialogScope.mortgageLevelThreeSource = {
                    ds:[]
                };
                dialogScope.mortgageLevelTwoName = function (val){
                    dialogScope.mortgageInfo.mortgageLevelThreeSource = "";
                    if(null != val){
                        var dataItemsDO = {mortgageCode:val};
                        var data = {dataItemsDO:dataItemsDO};
                        var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
                        mortgageName.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageInfo.mortgageLevelTwoName = res.contextData.mortgageName;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageLevelThreeSource.ds = res.contextData;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }else{
                        dialogScope.mortgageLevelThreeSource.ds = [];
                    }
                };

                //返回
                dialogScope.close_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"货物维护")
        }
    };

    //填写岗保存
    $scope.save_onClick = function()
    {
        if($scope.datasource.ds==[]||$scope.datasource.ds.length==0)
        {
            $common.get_tipDialog('请先添加仓单信息！','showInform');
            return;
        }
        var data = {
            billStandardBussInfoVO:$scope.baseinfo,
            billNormalList:$scope.datasource.ds,
            billNormalMortList:$scope.datasourcemort.ds
        };
        $common.get_asyncData("billNormalAddService/BillNormalAddAppUpdate",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("保存成功",'showSuccess');
                var appno = res.contextData.value;
                $scope.baseinfo.appno = appno;
                $scope.submitDisable = false;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //填写岗提交
    $scope.submit_onClick = function()
    {
        if($scope.datasource.ds==[]||$scope.datasource.ds.length==0)
        {
            $common.get_tipDialog('请先添加仓单信息！','showInform');
            return;
        }
        $scope.WriteDisable = true;
        $scope.submitDisable = true;
        var data = {
            billStandardBussInfoVO:$scope.baseinfo,
            billNormalList:$scope.datasource.ds
        };
        $common.get_asyncData("billNormalAddService/BillNorAddAppSubmitUpdate",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("操作完成",'showSuccess');
                $scope.queryTabletask();
                if(window.appNo)
                {
                    $scope.Write = true;
                    window.Write = true;
                }
                else
                {
                    $state.go("list");
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.WriteDisable = false;
                $scope.submitDisable = false;
            }
        });
    };

    //仓单详情
    $scope.viewbill_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条押品记录！','showInform');
        }else{
            $common.get_ngDialog('pledgemng/pledge_mng_billedit.html', $scope,["$scope",function(dialogScope){
                dialogScope.billnormal = $common.copy($scope.selected.select[0]);
                //返回
                dialogScope.close_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"仓单信息详情")
        }
    };

    //押品核价
    $scope.mortprice = {};
    $scope.column = function(row)
    {
        $scope.selectedmort.select = [];
        $scope.mortprice.confirmPrice = row.confirmPrice;
        $scope.$apply();
    };
    
    //根据核定价格计算总价
    $scope.calculateTotPrice = function(){
    	if($scope.selectedmort.select.length <1){
	   		 $common.get_tipDialog("请选择需要核价的押品",'showError');
	   		 return false;
    	}else{
	   		for(var i=0;i<$scope.selectedmort.select.length;i++){
		    		var row = $scope.selectedmort.select[i];
		            var quantity = 0;
		            var confirmPrice = 0;
		            if(row.quantity)
		            {
		                quantity = Number(row.quantity)+Number(row.addQuantity);
		            }
		            if($scope.mortprice.confirmPrice)
		            {
		                confirmPrice = Number($scope.mortprice.confirmPrice);
		            }
		            $scope.$apply(
		                row.confirmPrice = confirmPrice,
		                row.totPrice = quantity*confirmPrice
		            )
	   		}
    	}
       
    }
    
    //核价失去焦点事件
    $scope.confirmPrice_onBlur = function()
    {
    	$scope.calculateTotPrice();
    }
    //押品核价保存
    $scope.saveprice_onClick = function()
    {
	    	if($scope.selectedmort.select.length <1){
		   		 $common.get_tipDialog("请选择需要核价的押品",'showError');
		   		 return false;
	    	}else{
	    		$scope.calculateTotPrice();
	   	  	}
    	
        var data = {
            billNormalVO:$scope.baseinfo,
            list:$scope.datasourcemort.ds
        };
        $common.get_asyncData("billNormalAddService/BillNormalAddMorgListUpdate",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("保存成功",'showSuccess');
                $scope.queryTableMort();
                $scope.selectedmort.select = [];
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.$apply();
    };
    //核价提交
    $scope.pricingSubmit_onClick = function()
    {
        $scope.CheckDisable = true;
        $scope.taskDisable = true;
        $scope.baseinfo.taskComment = $scope.applyDtlForm.taskComment;
        var data = {
            billStandardBussInfoVO:$scope.baseinfo
        };
        $common.get_asyncData("billNormalAddService/BillNorAddPricingUpdate",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("已跳转下一节点",'showSuccess');
                $scope.selectedmort.select = [];
                $scope.selected.select = [];
                $scope.Check = true;
                window.Check = true;
                $scope.BackToModify = true;
                window.BackToModify = true;
                $scope.queryTabletask();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.CheckDisable = false;
                $scope.taskDisable = false;
            }
        });
    };

    //复核提交
    $scope.reviewSubmit_onClick = function()
    {
        $scope.ReviewDisable = true;
        $scope.taskDisable = true;
        $scope.baseinfo.taskComment = $scope.applyDtlForm.taskComment;
        var data = {
            billStandardBussInfoVO:$scope.baseinfo
        };
        $common.get_asyncData("billNormalAddService/BillNorAddReviewUpdate",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("已跳转下一节点",'showSuccess');
                $scope.selectedmort.select = [];
                $scope.selected.select = [];
                $scope.Review = true;
                window.Review = true;
                $scope.BackToModify = true;
                window.BackToModify = true;
                $scope.queryTabletask();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.ReviewDisable = false;
                $scope.taskDisable = false;
            }
        });
    };

    //回执确认
    $scope.receiptSubmit_onClick = function()
    {
        $scope.ReceiptDisable = true;
        $scope.taskDisable = true;
        $scope.baseinfo.taskComment = $scope.applyDtlForm.taskComment;
        var data = {
            billStandardBussInfoVO:$scope.baseinfo
        };
        $common.get_asyncData("billNormalAddService/BillNorAddConfirmUpdate",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("操作成功，流程结束",'showSuccess');
                $scope.selectedmort.select = [];
                $scope.selected.select = [];
                window.Receipt = true;
                $scope.BackToModify = true;
                window.BackToModify = true;
                $scope.queryTabletask();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.ReceiptDisable = false;
                $scope.taskDisable = false;
            }
        });
    };

    //退回
    $scope.BackToModify_onClick = function()
    {
        $scope.CheckDisable = true;
        $scope.ReviewDisable = true;
        $scope.ReceiptDisable = true;
        $scope.taskDisable = true;
        $scope.baseinfo.taskComment = $scope.applyDtlForm.taskComment;
        var data = {
            billStandardBussInfoVO:$scope.baseinfo
        };
        $common.get_asyncData("billNormalAddService/BillNorAddBackToModifyUpdate",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("已退回",'showSuccess');
                $scope.selectedmort.select = [];
                $scope.selected.select = [];
                window.Check = true;
                window.Review = true;
                window.Receipt = true;
                $scope.BackToModify = true;
                window.BackToModify = true;
                $scope.queryTabletask();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.CheckDisable = false;
                $scope.ReviewDisable = false;
                $scope.ReceiptDisable = false;
                $scope.taskDisable = false;
            }
        });
    };

    //查看通知书
    $scope.noticePrint_onClick = function()
    {
        if(!$scope.baseinfo.appno)
        {
            $common.get_tipDialog("申请编号获取失败!",'showInform');
            return;
        }
        $common.get_ngDialog('nwrinfo/nwrinfo_notice.html', $scope
            ,["$scope",function(dialogScope){
                dialogScope.noticeForm = {};
                dialogScope.noticeForm.noticeType = '128';
                dialogScope.noticeForm.appno = $scope.baseinfo.appno;
                $common.get_asyncData('billNormalPledgeMngService/NoticePrintInfoGetter',{noticeQryVO:dialogScope.noticeForm}).then(function(res) {
                    var notice;
                    if (res.errorCode == "SUC") {
                        notice = res.contextData;
                        dialogScope.noticeForm = notice;
                    }
                    else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
                dialogScope.closeThisDialog_onClick = function(){
                    dialogScope.closeThisDialog();
                }
            }],"通知书页面",{showClose:false});
    }
    //表格--------结束-------------------------
};

/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var mngExcgApplyInController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.baseinfo = $scope.source.baseinfo;
    /**
     * 仓单信息初始化
     * @type {{ds: Array}}
     */
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
        $scope.baseinfo.receiptPledgeAmount = 0;
        $scope.baseinfo.removePledgeAmount = 0;
    }
    $scope.taskform = $scope.source.taskform;
    $scope.hide = true;
    $scope.disable = true;

    $scope.Write = window.Write;
    $scope.Check = window.Check;
    $scope.Review = window.Review;
    $scope.Confirm = window.Confirm;
    $scope.BackToModify = window.BackToModify;

    if(!$scope.taskform||!$scope.taskform.id)
    {
        $scope.hide = window.Write;
        $scope.disable = window.Write;
        $scope.billhide = true;
        $("#priceCheck").remove();
    }
    else
    {
        $scope.hide = true;
        $scope.disable = true;
        $scope.href = false;
        $scope.billhide = false;
        if($scope.taskform.id == "Write")
        {//填写岗
            $scope.hide = window.Write;
            $scope.disable = window.Write;
            $scope.href = window.Write;
            $scope.billhide = true;
            $("#priceCheck").remove();
        }
        else if($scope.taskform.id == "Pricing")
        {//核价岗
            $("#priceCheck").show();
            $scope.href = true;
        }
        else if($scope.taskform.id == "Review")
        {//复核岗
            $("#priceCheck").remove();
        }
        else if($scope.taskform.id == "Check")
        {//审批岗
            $("#priceCheck").remove();
        }
        else if($scope.taskform.id == "Confirm")
        {//回执
            $("#priceCheck").remove();
        }
        else
        {
            $("#priceCheck").remove();
        }
    }

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
            billNormalVO:$scope.baseinfo
        };
        var promise = $common.get_asyncData("billNormalPledgeMngService/BillNormalMngQueryGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records||[];
                $scope.conf.totalRecord = data.totalRecord;
                if($scope.datasource.ds!=[]&&$scope.datasource.ds.length>0)
                {
                    var billno = "";
                    for(var i=0; i<$scope.datasource.ds.length; i++)
                    {
                        billno = billno + $scope.datasource.ds[i].billno+"/f";
                    }
                    $scope.baseinfo.billno = billno;
                    $scope.queryTableMort();
                }
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
            pageNo: $scope.confmort.pageNo,
            pageSize: $scope.confmort.pageSize,
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

    $scope.addin_onClick = function()
    {
        $common.get_ngDialog('pledgemng/pledge_mng_qrylist.html', $scope,["$scope",function(dialogScope){
            dialogScope.conditionForm = {};
            dialogScope.conditionForm = $scope.baseinfo;
            dialogScope.billList = {//已存在列表
                ds:[]
            };
            dialogScope.billList.ds = $scope.datasource.ds||[];
            dialogScope.datasource={//初始化表格对象
                ds:[]
            };
            dialogScope.selected={//初始化对象
                select: []
            };
            dialogScope.conf= {//初始化分页对象
                pageNo: 1,
                pageSize: 10,
                totalRecord: 0};
            //监听分页
            dialogScope.$watch("conf.pageNo",function(){
                dialogScope.queryTable();
            });
            //重置
            dialogScope.rebort_onClick =function(){
                dialogScope.$apply(function(){
                    dialogScope.conditionForm = $scope.baseinfo;
                    dialogScope.selected.select=[];//清空选项s
                })
            };
            //搜索查询
            dialogScope.submit_onClick =function(){
                dialogScope.queryTable();
                dialogScope.selected.select=[];
            };
            //仓单信息列表
            dialogScope.queryTable = function(paramData)
            {
                dialogScope.conditionForm.flag = "1";
                var data= {
                    pageNo: dialogScope.conf.pageNo,
                    pageSize: dialogScope.conf.pageSize,
                    billNormalVO:dialogScope.conditionForm
                };
                var promise = $common.get_asyncData("billNormalPledgeMngService/BillNormalMngQueryGetter",data);
                promise.then(function(res){
                    var data;
                    if (res.errorCode =="SUC"){
                        data = res.contextData;
                        dialogScope.datasource.ds = data.records||[];
                        dialogScope.conf.totalRecord = data.totalRecord;
                        var selectedList = [];
                        if(dialogScope.billList.ds.length>0)
                        {
                            for(var x in dialogScope.billList.ds)
                            {
                                var xbillno = dialogScope.billList.ds[x].billno;
                                for(var y in dialogScope.datasource.ds)
                                {
                                    var ybillno = dialogScope.datasource.ds[y].billno;
                                    if(xbillno==ybillno)
                                    {
                                        selectedList.push(dialogScope.datasource.ds[y]);
                                    }
                                }
                            }
                        }
                        dialogScope.selected.select = selectedList;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            };
            //确认
            dialogScope.confirm_onClick = function()
            {
                if(dialogScope.selected.select.length == 0){
                    $common.get_tipDialog('请至少选择一条记录！','showInform');
                }else{
                    $scope.datasource.ds = [];
                    dialogScope.closeThisDialog();
                    $scope.datasource.ds = dialogScope.selected.select;
                    $scope.conf.totalRecord = dialogScope.selected.select.length;
                    var billno = "";
                    for(var i=0; i<dialogScope.selected.select.length; i++)
                    {
                        billno = billno + dialogScope.selected.select[i].billno+"/f";
                    }
                    $scope.baseinfo.billno = billno;
                    $scope.queryTableMort();
                }
            };
            //返回
            dialogScope.close_onClick = function(){
                dialogScope.closeThisDialog();
            };
        }],"添加页面")
    };

    $scope.deletein_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            var selectedList = $scope.selected.select;
            var dsArray = $scope.datasource.ds;
            $scope.selected.select=[];
            //删除仓单列表
            for (var i = 0; i < dsArray.length; i++)
            {
                var dsbillno = dsArray[i].billno;
                for(var j = 0; j<selectedList.length; j++)
                {
                    var selectbillno = selectedList[j].billno;
                    if (dsbillno == selectbillno) {
                        $scope.datasource.ds.splice(i, 1);
                        $scope.conf.totalRecord --;
                    }
                }
            }
            //删除对应押品列表信息
            var mortArray = $common.copy($scope.datasourcemort.ds);
            for (var i = 0; i < selectedList.length; i++)
            {
                var selectbillno = selectedList[i].billno;
                var num = 0;
                for(var k = 0; k<mortArray.length; k++)
                {
                    var mortbillno = mortArray[k].billno;
                    if(selectbillno==mortbillno)
                    {
                        $scope.datasourcemort.ds.splice(k - num, 1);
                        $scope.confmort.totalRecord --;
                        num ++;
                    }
                }
            }
            $scope.$apply();
        }
    };

    $scope.viewmort_onClick = function()
    {
        if($scope.selectedmort.select.length != 1){
            $common.get_tipDialog('请选择一条押品记录！','showInform');
        }else{
            $common.get_ngDialog('nwrinfo/nwrinfo_mortedit.html', $scope,["$scope",function(dialogScope){
                dialogScope.mortgageInfo = $scope.selectedmort.select[0];
                dialogScope.disable = true;
                dialogScope.addQuantityHide = true;
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
            }],"押品信息")
        }
    };

    //换入仓单保存
    $scope.save_onClick = function()
    {
        if($scope.datasource.ds==[]||$scope.datasource.ds.length==0)
        {
            $common.get_tipDialog('当前没有记录,不能进行押品清单维护！','showInform');
            return;
        }
        var receiptPledgeAmount = 0;
        for(var x in $scope.datasource.ds)
        {
            receiptPledgeAmount += $scope.datasource.ds[x].whReceiptValue;
        }
        $scope.baseinfo.receiptPledgeAmount = receiptPledgeAmount;
        window.source.baseinfo = $scope.baseinfo;
        $scope.$apply();
        var data = {
            billNormalAppVO:$scope.baseinfo,
            insertList:$scope.datasource.ds
        };
        $common.get_asyncData("billNormalMngExcgService/BillMngExcgEnterListUpdater",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("保存成功",'showSuccess');
                var appno = res.contextData.value;
                $scope.baseinfo.appno = appno;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
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
    
    //根据核价计算总价
    $scope.calculateTotPrice = function(){
    	if($scope.selectedmort.select.length <1){
	   		 $common.get_tipDialog("请选择需要核价的押品",'showError');
	   		 return false;
    	}else{
	   		for(var i=0;i<$scope.selectedmort.select.length;i++){
			        var row = $scope.selectedmort.select[i];
			        var oldtotPrice = row.totPrice;
			        var billno = row.billno;
			        var quantity = 0;
			        var confirmPrice = 0;
			        if(row.quantity)
			        {
			            quantity = Number(row.quantity);
			        }
			        if($scope.mortprice.confirmPrice)
			        {
			            confirmPrice = Number($scope.mortprice.confirmPrice);
			        }
			        var newtotPrice = quantity*confirmPrice;
			        $scope.$apply(
			            row.confirmPrice = confirmPrice,
			            row.totPrice = newtotPrice
			        );
			        //押品价格修改后联动修改对应仓单价值 减去核价前总价值加上核价后总价值
			        for(var x in $scope.datasource.ds)
			        {
			            var billinfo = $scope.datasource.ds[x];
			            var normalbillno = billinfo.billno;
			            if(billno==normalbillno)
			            {
			                var whReceiptValue = billinfo.whReceiptValue;
			                whReceiptValue = whReceiptValue - oldtotPrice + newtotPrice;
			                billinfo.whReceiptValue = whReceiptValue;
			                break;
			            }
			        }
			        $scope.$apply();
			        
	   		}
    	}
    };
    
    //核价失去焦点事件
    $scope.confirmPrice_onBlur = function()
    {
    	$scope.calculateTotPrice(); 

    };

    //押品核价保存
    $scope.saveprice_onClick = function()
    {
    	if($scope.selectedmort.select.length <1){
	   		 $common.get_tipDialog("请选择需要核价的押品",'showError');
	   		 return false;
    	}else{
    		$scope.calculateTotPrice(); 
    	}
        var receiptPledgeAmount = 0;
        for(var x in $scope.datasource.ds)
        {
            receiptPledgeAmount += $scope.datasource.ds[x].whReceiptValue;
        }
        $scope.baseinfo.receiptPledgeAmount = receiptPledgeAmount;
        window.source.baseinfo = $scope.baseinfo;
        $scope.$apply();
        var data = {
            billNormalAppVO:$scope.baseinfo,
            list:$scope.datasourcemort.ds
        };
        $common.get_asyncData("billNormalMngExcgService/BillNorExcgPricingUpdate",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("核价成功",'showSuccess');
                $scope.queryTableMort();
                $scope.selectedmort.select = [];
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.$apply();
    };
    //表格--------结束-------------------------
};

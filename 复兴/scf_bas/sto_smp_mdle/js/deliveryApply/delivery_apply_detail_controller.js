/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var deliveryApplyDetailController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.deliver = $scope.source.baseinfo;
    if(!$scope.deliver.bailAmount)
    {
        $scope.deliver.bailAmount = 0.00;
    }
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
    if(!$scope.deliver.appno)
    {
        $scope.submitDisable = true;
    }
    else
    {
        $scope.submitDisable = false;
    }
    $scope.taskform = $scope.source.taskform;
    $scope.disable = true;
    $("#showIdea").css('display','');
    if(!$scope.taskform||!$scope.taskform.id)
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
        else if($scope.taskform.id == "Issued")
        {//普通仓单质押核价岗

        }
        else if($scope.taskform.id == "Receipt")
        {//普通仓单质押核价岗
        }
    }
    $scope.Write = window.Write;
    $scope.Issued = window.Issued;
    $scope.Receipt = window.Receipt;

    //监听分页
    $scope.$watch("conf.pageNo",function(){
        $scope.queryTable();
    });
    //提货押品列表
    $scope.queryTable = function(paramData)
    {
        $scope.deliver.selectFlag = false;
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            mortgageBaseQryVO:$scope.deliver
        };
        var promise = $common.get_asyncData("staticDeliveryApplyService/DeliveryAppListMngGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records||[];
                $scope.conf.totalRecord = data.totalRecord;
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

    $scope.addmort_onClick = function(){
        $common.get_ngDialog('deliveryApply/info_mtglist.html',$scope,["$scope",function(dialogScope){

            dialogScope.datasource = {ds:[]};
            dialogScope.selected = {select:[]};
            dialogScope.conf = {
                pageNo: 1,
                pageSize: 10,
                totalRecord:0
            };
            dialogScope.$watch("conf.pageNo+conf.pageSize",function(){
                dialogScope.queryTableMort();
            });
            // 押品列表获取查询
            dialogScope.queryTableMort = function(dataParam)
            {
                var data = {
                    pageNo: dialogScope.conf.pageNo,
                    pageSize: dialogScope.conf.pageSize,
                    mortgageBaseQryVO:  $scope.deliver
                };
                var promise = $common.get_asyncData("staticDeliveryApplyService/PriceAdjustMortListAddGetter", data);
                promise.then(function (res) {
                    var data;
                    if (res.errorCode == "SUC") {
                        data = res.contextData;
                        dialogScope.datasource.ds = data.records||[];
                        dialogScope.conf.totalRecord = data.totalRecord;
                        var list = $scope.datasource.ds;
                        var slist = [];//选中的列表
                        for(var x in dialogScope.datasource.ds)
                        {
                            var dmtgno = dialogScope.datasource.ds[x].mortgageNo;
                            for(var y in list)
                            {
                                var mtgno = list[y].mortgageNo;
                                if(dmtgno==mtgno)
                                {
                                    slist.push(dialogScope.datasource.ds[x]);
                                }
                            }
                        }
                        dialogScope.selected.select = slist;
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                })
            }
            //确认按钮
            dialogScope.save_onClick = function(){
                if(dialogScope.selected.select.length<1){
                    $common.get_tipDialog('请至少选择一条记录!','showInform');
                }else{
                    $scope.datasource.ds = dialogScope.selected.select;
                    var deliverValue = 0;
                    for(var x in $scope.datasource.ds)
                    {
                        var totprice = Number($scope.datasource.ds[x].totPrice);
                        deliverValue += totprice;
                    }
                    $scope.conf.totalRecord = $scope.datasource.ds.length;
                    dialogScope.closeThisDialog();
                    $scope.selected.select = [];
                    dialogScope.$apply();
                }
            };
            //关闭按钮
            dialogScope.cancel_onClick = function(){
                dialogScope.closeThisDialog();
                $scope.selected.select = [];
            };
        }],"提货列表选择",{showClose:true});
    };

    //修改押品
    $scope.editmort_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('deliveryApply/info_mortedit.html', $scope,["$scope",function(dialogScope){
                dialogScope.mortgageInfo = $scope.selected.select[0];
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
                dialogScope.balQuantity_onBlur = function()
                {
                    var balQuantity = Number(dialogScope.mortgageInfo.balQuantity);
                    var confirmPrice = Number(dialogScope.mortgageInfo.confirmPrice);//当前押品单价
                    var quantity = Number(dialogScope.mortgageInfo.quantity);//当前押品数量
                    var deliveryAmt = 0;//本次提货申请总金额
                    var amt = balQuantity*confirmPrice;//提货金额
                    if(balQuantity>quantity)
                    {
                        $common.get_tipDialog('押品名称为'+dialogScope.mortgageInfo.mortgageName+'的提货数量必须小于等于押品数量！','showInform');
                        return;
                    }
                    if(balQuantity!=undefined&&balQuantity!=null&&balQuantity!="")
                    {
                        for(var x in $scope.datasource.ds)
                        {
                            var mortinfo = $scope.datasource.ds[x];
                            var mtgNo = mortinfo.mortgageNo;
                            if(dialogScope.mortgageInfo.mortgageNo!=mtgNo)
                            {
                                var deliveryQ = Number(mortinfo.balQuantity);//提货数量
                                var deliveryCp = Number(mortinfo.confirmPrice);//核定单价
                                if(deliveryQ!=undefined&&deliveryQ!=null&&deliveryQ!="")
                                {
                                    deliveryAmt += deliveryQ*deliveryCp
                                }
                            }
                        }
                        deliveryAmt += amt;
                        $scope.deliver.deliverValue = deliveryAmt;
                        dialogScope.$apply();
                    }
                };
                //确认
                dialogScope.save_onClick = function()
                {
                    dialogScope.closeThisDialog();
                }
                //返回
                dialogScope.close_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"押品详情")
        }
    };

    $scope.deletemort_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            var selectedList = $scope.selected.select;
            var dsArray = $scope.datasource.ds;
            $scope.selected.select=[];
            var deliverValue = Number($scope.deliver.deliverValue);//本次提货申请总金额
            //删除押品列表
            for (var i = 0; i < dsArray.length; i++)
            {
                var dsmtgno = dsArray[i].mortgageNo;
                for(var j = 0; j<selectedList.length; j++)
                {
                    var selectmtgno = selectedList[j].mortgageNo;
                    if (dsmtgno == selectmtgno) {
                        var deliveryQ = Number(selectedList[j].balQuantity);//提货数量
                        var deliveryCp = Number(selectedList[j].confirmPrice);//核定单价
                        if(deliveryQ!=undefined&&deliveryQ!=null&&deliveryQ!="")
                        {
                            deliverValue -= deliveryQ*deliveryCp
                        }
                        $scope.datasource.ds.splice(i, 1);
                        $scope.conf.totalRecord --;
                    }
                }
            }
            $scope.deliver.deliverValue = deliverValue;
            $scope.$apply();
        }
    };

    //查看押品
    $scope.viewmort_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('deliveryApply/info_mortedit.html', $scope,["$scope",function(dialogScope){
                dialogScope.mortgageInfo = $scope.selected.select[0];
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
            }],"押品详情")
        }
    };

    //填写岗保存
    $scope.save_onClick = function()
    {
        if($scope.datasource.ds==[]||$scope.datasource.ds.length==0)
        {
            $common.get_tipDialog('请先添加提货押品信息！','showInform');
            return;
        }
        var bailAmount = parseFloat($scope.deliver.bailAmount);
        var v_deliverValue = parseFloat($scope.deliver.deliverValue);    //本次提货申请金额
        var v_maxDeliverValue = parseFloat($scope.deliver.maxDeliverValue);    //本次可提押品价值
        var v_debtAmount = parseFloat($scope.deliver.debtAmount);    //敞口余额
        for (var x in $scope.datasource.ds)
        {
            var mortinfo = $scope.datasource.ds[x];
            var num = parseFloat(mortinfo.balQuantity);
            //var price = mortinfo.confirmPrice;
            var quantity = parseFloat(mortinfo.quantity);
            var mortgageName_v = mortinfo.mortgageName;
            if(isNaN(num))
            {
                $common.get_tipDialog("押品名称为:"+mortgageName_v+" 的提货数量不能为空，请填写！",'showInform');
                return;
                break;
            }
            if(num<=0||num>quantity){
                $common.get_tipDialog("押品名称为:"+mortgageName_v+" 的提货数量必须大于0,且小于等于在库押品数量！",'showInform');
                return;
                break;
            }
        }

        if(bailAmount<0){
            $common.get_tipDialog("本次追加保证金总额不能小于0！",'showInform');
            return;
        }

        if((bailAmount -v_debtAmount)>=0.005)
        {
            $common.get_tipDialog("本次追加保证金总额不能大于敞口余额！",'showInform');
            return;
        }

        if(v_maxDeliverValue <=0)
        {
            $common.get_tipDialog("本次可提押品价值小于等于0，不能进行提货申请操作！",'showInform');
            return;
        }

        if(v_deliverValue > v_maxDeliverValue)
        {
            $common.get_tipDialog("本次提货申请总金额不能大于本次可押品总价值！",'showInform');
            return;
        }
        var data = {
            mortgageApplyVO:$scope.deliver,
            insertList:$scope.datasource.ds
        };
        $common.get_asyncData("staticDeliveryApplyService/DeliveryProcessStartSaveUpdater",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("保存成功",'showSuccess');
                var appno = res.contextData.value;
                $scope.deliver.appno = appno;
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
            $common.get_tipDialog('请先添加提货押品信息！','showInform');
            return;
        }
        var bailAmount = parseFloat($scope.deliver.bailAmount);
        var v_deliverValue = parseFloat($scope.deliver.deliverValue);    //本次提货申请金额
        var v_maxDeliverValue = parseFloat($scope.deliver.maxDeliverValue);    //本次可提押品价值
        var v_debtAmount = parseFloat($scope.deliver.debtAmount);    //敞口余额

        for (var x in $scope.datasource.ds)
        {
            var mortinfo = $scope.datasource.ds[x];
            var num = mortinfo.balQuantity;
            var price = mortinfo.confirmPrice;
            var quantity = mortinfo.quantity;
            var mortgageName_v = mortinfo.mortgageName;
            if(isNaN(num))
            {
                $common.get_tipDialog("押品名称为:"+mortgageName_v+" 的提货数量不能为空，请填写！",'showInform');
                return;
                break;
            }
            if(num<=0||num>quantity){
                $common.get_tipDialog("押品名称为:"+mortgageName_v+" 的提货数量必须大于0,且小于等于在库押品数量！",'showInform');
                return;
                break;
            }
        }

        if(bailAmount<0){
            $common.get_tipDialog("本次追加保证金总额不能小于0！",'showInform');
            return;
        }

        if((bailAmount -v_debtAmount)>=0.005)
        {
            $common.get_tipDialog("本次追加保证金总额不能大于敞口余额！",'showInform');
            return;
        }

        if(v_maxDeliverValue <=0)
        {
            $common.get_tipDialog("本次可提押品价值小于等于0，不能进行提货申请操作！",'showInform');
            return;
        }

        if(v_deliverValue > v_maxDeliverValue)
        {
            $common.get_tipDialog("本次提货申请总金额不能大于本次可押品总价值！",'showInform');
            return;
        }
        $scope.WriteDisable = true;
        $scope.submitDisable = true;
        $scope.deliver.taskComment = $scope.applyDtlForm.taskComment;
        var data = {
            mortgageApplyVO:$scope.deliver,
            insertList:$scope.datasource.ds
        };
        $common.get_asyncData("staticDeliveryApplyService/DeliveryProcessStartSubmit",data).then(function(res){
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

    //复核提交
    $scope.IssuedSubmit_onClick = function()
    {
        $scope.IssuedDisable = true;
        var data = {
            appno:$scope.deliver.appno,
            taskComment:$scope.applyDtlForm.taskComment
        };
        $common.get_asyncData("staticDeliveryApplyService/DeliveryAppSignUpdater",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("已跳转下一节点",'showSuccess');
                $scope.selected.select = [];
                $scope.Issued = true;
                window.Issued = true;
                $scope.queryTabletask();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.IssuedDisable = false;
            }
        });
    };

    //退回
    $scope.IssuedGoBack_onClick = function()
    {
        $scope.IssuedDisable = true;
        $scope.deliver.taskComment = $scope.applyDtlForm.taskComment;
        var data = {
            appno:$scope.deliver.appno,
            taskComment:$scope.applyDtlForm.taskComment
        };
        $common.get_asyncData("staticDeliveryApplyService/DeliveryAppReviewBackUpdater",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("已退回",'showSuccess');
                $scope.selected.select = [];
                $scope.Issued = true;
                window.Issued = true;
                $scope.queryTabletask();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.IssuedDisable = false;
            }
        });
    };

    //回执确认
    $scope.ReceiptSubmit_onClick = function()
    {
        $scope.ReceiptDisable = true;
        var data = {
            appno:$scope.deliver.appno,
            taskComment:$scope.applyDtlForm.taskComment
        };
        $common.get_asyncData("staticDeliveryApplyService/DeliveryAppReceiptUpdater",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("操作成功，流程结束",'showSuccess');
                $scope.selected.select = [];
                window.Receipt = true;
                $scope.queryTabletask();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.ReceiptDisable = false;
            }
        });
    };

    //查看通知书
    $scope.noticePrint_onClick = function()
    {
        if(!$scope.deliver.appno)
        {
            $common.get_tipDialog("申请编号获取失败!",'showInform');
            return;
        }
        $common.get_ngDialog('deliveryApply/info_notice.html', $scope
            ,["$scope",function(dialogScope){
                dialogScope.noticeForm = {};
                dialogScope.noticeForm.noticeType = '22';
                dialogScope.noticeForm.appno = $scope.deliver.appno;
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
    };
    //表格--------结束-------------------------
};

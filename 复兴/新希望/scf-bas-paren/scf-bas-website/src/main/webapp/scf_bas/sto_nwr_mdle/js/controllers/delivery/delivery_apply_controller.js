/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var deliveryApplyController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.baseinfo = $scope.source.baseinfo;
    $scope.deliver = {};//申请信息

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
    $("#showIdea").css('display','');
    if(!$scope.taskform||!$scope.taskform.id)
    {
        $("#showIdea").css('display','none');
    }
    else
    {
        $scope.hide = true;
        if($scope.taskform.id == "Write")
        {//普通仓单质押填写岗
            $scope.hide = false;
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
    $scope.Notice = window.Notice;
    //监听分页
    $scope.$watch("conf.pageNo",function(){
        $scope.queryBillNormalDelivery();
    });
    //申请内容
    $scope.queryBillNormalDelivery = function(paramData)
    {
        var data = {
            billNormalAppVO:$scope.baseinfo
        }
        $common.get_asyncData("billNormalDeliveryApplyService/BillNormalDeliveryApplyInfoGetter", data).then(function (res) {
            var deliver;
            if (res.errorCode == "SUC") {
                deliver = res.contextData;
                $scope.deliver = deliver;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };

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
        var promise = $common.get_asyncData("billNormalDeliveryApplyService/BillNormalDeliveryListGetter",data);
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
            pageNo: $scope.confmort.pageNo,
            pageSize: $scope.confmort.pageSize,
            mortgageQryVO:$scope.baseinfo
        };
        var promise = $common.get_asyncData("billNormalDeliveryApplyService/BillNormalDeliveryApplyListGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasourcemort.ds = data.records||[];
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

    //押品信息修改
    $scope.editmort_onClick = function()
    {
        if($scope.selectedmort.select.length != 1){
            $common.get_tipDialog('请选择一条押品记录！','showInform');
        }else{
            $common.get_ngDialog('delivery/delivery_mortedit.html', $scope,["$scope",function(dialogScope){
                dialogScope.mortgageInfo = $scope.selectedmort.select[0];
                dialogScope.disable = true;

                dialogScope.balQuantity_onBlur = function()
                {
                    var quantity = Number(dialogScope.mortgageInfo.quantity);
                    var balQuantity = Number(dialogScope.mortgageInfo.balQuantity);
                    if(balQuantity>quantity)
                    {
                        $common.get_tipDialog("提货数量不能大于押品数量", 'showError');
                        return;
                    }
                    var confirmPrice = Number(dialogScope.mortgageInfo.confirmPrice);
                    var amt = balQuantity*confirmPrice;
                    dialogScope.mortgageInfo.amt = amt;
                    dialogScope.$apply();
                };
                dialogScope.save_onClick = function()
                {
                    if($.doValidate("mortgageInfo")){
                        var deliverValue = 0;
                        for(var x in $scope.datasourcemort.ds)
                        {
                            var mortinfo = $scope.datasourcemort.ds[x];
                            if(mortinfo.mortgageNo!=dialogScope.mortgageInfo.mortgageNo)
                            {
                                var balQuantity = Number(mortinfo.balQuantity);
                                var confirmPrice = Number(mortinfo.confirmPrice);
                                var amt = balQuantity*confirmPrice;
                                deliverValue += amt;
                            }
                        }
                        $scope.deliver.deliverValue = deliverValue+Number(dialogScope.mortgageInfo.amt);
                        $scope.$apply();
                        $scope.selectedmort.select = [];
                        dialogScope.closeThisDialog();
                    }
                };
                //返回
                dialogScope.close_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"凭证信息编辑")
        }
    };

    //全部提货
    $scope.allBal_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条押品记录！','showInform');
        }else{
            var deliverValue = 0;
            for(var x in $scope.datasourcemort.ds)
            {
                var mortinfo = $scope.datasourcemort.ds[x];
                mortinfo.balQuantity = mortinfo.quantity;
                mortinfo.amt = mortinfo.totPrice;
                deliverValue += mortinfo.amt;
            }
            $scope.deliver.deliverValue = deliverValue;
            $scope.$apply();
            $scope.selected.select = [];
        }
    };

    //非标仓单申请保存发起
    $scope.save_onClick = function()
    {
        if($scope.datasourcemort.ds==[]||$scope.datasource.ds.length==0)
        {
            $common.get_tipDialog('该仓单目前没有押品，不可提货！','showInform');
            return;
        }
        var deliverValue = Number($scope.deliver.deliverValue);
        var maxDeliverValue = Number($scope.deliver.maxDeliverValue);
        if(deliverValue<=0)
        {
            $common.get_tipDialog('本次提货总价值必须大于0','showInform');
            return;
        }
        if(deliverValue>maxDeliverValue)
        {
            $common.get_tipDialog('本次提货价值不能大于可提货价值','showInform');
            return;
        }
        var data = {
            deliveyApplyVO:$scope.deliver,
            billList:$scope.datasource.ds,
            mortList:$scope.datasourcemort.ds
        };
        $common.get_asyncData("billNormalDeliveryApplyService/BillNormalDeliveryApplySaveUpdater",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("保存成功",'showSuccess');
                var appno = res.contextData.value;
                $scope.deliver.appno = appno;
                $scope.baseinfo.appno = appno;
                $scope.submitDisable = false;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //非标仓单提货申请提交
    $scope.submit_onClick = function()
    {
        $scope.WriteDisable = true;
        $scope.submitDisable = true;
        var data = {
            deliveyApplyVO:$scope.deliver,
            billList:$scope.datasource.ds,
            mortList:$scope.datasourcemort.ds
        };
        $common.get_asyncData("billNormalDeliveryApplyService/BillNormalDeliveryApplySubmitUpdater",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("操作完成",'showSuccess');
                $scope.queryTabletask();
                if(window.appNo)
                {
                    $scope.Write = true;
                    window.Write = true;
                    $scope.hide = true;
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

    //同意(非标仓单 提货 审批)
    $scope.IssuedSubmit_onClick = function()
    {
        $scope.IssuedDisable = true;
        $scope.baseinfo.deliver = $scope.applyDtlForm.taskComment;
        var data = {
            deliveyApplyVO:$scope.deliver,
            flag:true
        };
        $common.get_asyncData("billNormalDeliveryApplyService/BillNormalDeliveryApplyIssuedUpdate",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("操作完成，提交下一节点",'showSuccess');
                $scope.selectedmort.select = [];
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
            deliveyApplyVO:$scope.deliver,
            flag:false
        };
        $common.get_asyncData("billNormalDeliveryApplyService/BillNormalDeliveryApplyIssuedUpdate",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("已退回",'showSuccess');
                $scope.selectedmort.select = [];
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
        $scope.deliver.taskComment = $scope.applyDtlForm.taskComment;
        var data = {
            deliveyApplyVO:$scope.deliver
        };
        $common.get_asyncData("billNormalDeliveryApplyService/BillNormalDeliveryApplyReceiptUpdate",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("操作成功，流程结束",'showSuccess');
                $scope.selectedmort.select = [];
                $scope.selected.select = [];
                $scope.Receipt = true;
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

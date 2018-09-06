/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var offMngApplyController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
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

    /**
     * 预解押仓单信息初始化
     * @type {{ds: Array}}
     */
    $scope.datasourceoff={//初始化表格对象
        ds:[]
    };
    $scope.selectedoff={//初始化对象
        select: []
    };
    $scope.confoff= {//初始化分页对象
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
        $("#showIdea").css('display','none');
        $("#billCheck").show();
    }
    else
    {
        $scope.hide = true;
        $scope.disable = true;
        $scope.href = false;
        if($scope.taskform.id == "Write")
        {//普通仓单质押填写岗
            $scope.hide = window.Write;
            $scope.disable = window.Write;
            $("#billCheck").show();
        }
        else if($scope.taskform.id == "Review")
        {//复核岗
            $("#billCheck").remove();
        }
        else if($scope.taskform.id == "Check")
        {//审批岗
            $("#billCheck").remove();
            $scope.href = true;
        }
        else if($scope.taskform.id == "Confirm")
        {//回执
            $("#billCheck").remove();
        }
        else
        {
            $("#billCheck").remove();
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
            billNormalAppVO:$scope.baseinfo
        };
        var promise = $common.get_asyncData("billNormalOffMngService/BillNormalOffListQueryGetter",data);
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

    //监听分页
    $scope.$watch("conf.pageNo",function(){
        $scope.queryTableOff();
    });
    //预解除质押仓单列表
    $scope.queryTableOff = function(paramData)
    {
        var data= {
            pageNo: $scope.confoff.pageNo,
            pageSize: $scope.confoff.pageSize,
            billNormalVO:$scope.baseinfo
        };
        var promise = $common.get_asyncData("billNormalOffMngService/BillNormalOffListMngDetailGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasourceoff.ds = data.records||[];
                $scope.confoff.totalRecord = data.totalRecord;
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

    $scope.columnbill = function(row)
    {
        var rowbillno = row.billno;
        if($scope.selected.select.length == 0){
            $scope.baseinfo.billno = rowbillno;
        }else{
            var basebillno = "";
            var flag = true;
            for(var x in $scope.selected.select)
            {
                var selected = $scope.selected.select[x];
                var billno = selected.billno;
                if(rowbillno==billno)
                {
                    flag = false;
                }
                else
                {
                    basebillno += billno + "/f";
                }
            }
            if(flag)
            {
                basebillno += rowbillno;
            }
            $scope.baseinfo.billno = basebillno;
        }
        $scope.queryTableMort();
    };

    $scope.columnoff = function(row)
    {
        var rowbillno = row.billno;
        if($scope.selectedoff.select.length == 0){
            $scope.baseinfo.billno = rowbillno;
        }else{
            var basebillno = "";
            var flag = true;
            for(var x in $scope.selected.select)
            {
                var selected = $scope.selectedoff.select[x];
                var billno = selected.billno;
                if(rowbillno==billno)
                {
                    flag = false;
                }
                else
                {
                    basebillno += billno + "/f";
                }
            }
            if(flag)
            {
                basebillno += rowbillno;
            }
            $scope.baseinfo.billno = basebillno;
        }
        $scope.queryTableMort();
    };

    $scope.offmng_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            var offmng = $scope.selected.select[0];
            $scope.confoff.totalRecord ++;
            var billno = offmng.billno;
            var removePledgeAmount = offmng.whReceiptValue;
            var basebillno = billno + "/f";
            for(var x in $scope.datasourceoff.ds)
            {
                var off = $scope.datasourceoff.ds[x];
                var offbillno = off.billno;
                if(billno==offbillno)
                {
                    $common.get_tipDialog('该信息已经加入解押列表，不能重复加入！','showInform');
                    return;
                }
                basebillno += offbillno +"/f";
                var whReceiptValue = Number(off.whReceiptValue);
                removePledgeAmount += whReceiptValue;
            }
            $scope.datasourceoff.ds.push(offmng);
            $scope.selected.select = [];
            $scope.baseinfo.removePledgeAmount = removePledgeAmount;
            $scope.baseinfo.billno = basebillno;
            $scope.queryTableMort();
            $scope.$apply();
        }
    };

    $scope.deleteoff_onClick = function()
    {
        if($scope.selectedoff.select.length != 1){
            $common.get_tipDialog('请选择一条预解除质押仓单记录！','showInform');
        }else{
            var selectedList = $scope.selectedoff.select;
            var dsArray = $scope.datasourceoff.ds;
            $scope.selectedoff.select=[];
            //删除仓单列表
            for (var i = 0; i < dsArray.length; i++)
            {
                var dsbillno = dsArray[i].billno;
                for(var j = 0; j<selectedList.length; j++)
                {
                    var selectbillno = selectedList[j].billno;
                    var whReceiptValue = Number(selectedList[j].whReceiptValue);
                    if (dsbillno == selectbillno) {
                        $scope.datasourceoff.ds.splice(i, 1);
                        $scope.confoff.totalRecord --;
                        $scope.baseinfo.removePledgeAmount -= whReceiptValue;
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

    //经办岗保存
    $scope.save_onClick = function()
    {
        if($scope.datasourceoff.ds==[]||$scope.datasourceoff.ds.length==0)
        {
            $common.get_tipDialog('请选择一条仓单信息再进行解押！','showInform');
            return;
        }
        var removePledgeAmount = Number($scope.baseinfo.removePledgeAmount);//解押仓单价值
        var receiptPledgeAmount = Number($scope.baseinfo.receiptPledgeAmount);//质押仓单总价值
        var ration = Number($scope.baseinfo.ration);//质押率
        var riskAmount = Number($scope.baseinfo.riskAmount);//敞口
        var leftAmount =parseFloat(receiptPledgeAmount-removePledgeAmount);//剩余仓单价值

        //剩余仓单价值乘以质押率后与敞口比较
        if((leftAmount*ration) < riskAmount)
        {
            $common.get_tipDialog('剩余质押仓单总额不能覆盖敞口，不允许解押！','showInform');//校验剩余仓单总额是否能够覆盖敞口
            return;
        }

        var data = {
            billNormalAppVO:$scope.baseinfo,
            list:$scope.datasourceoff.ds
        };
        $common.get_asyncData("billNormalOffMngService/BillNormalOffListAddUpdater",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("保存成功",'showSuccess');
                var appno = res.contextData.value;
                $scope.baseinfo.appno = appno;
                //$scope.baseinfo.appno = appno;
                $scope.submitDisable = false;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //经办岗提交
    $scope.submit_onClick = function()
    {
        if($scope.datasourceoff.ds==[]||$scope.datasourceoff.ds.length==0)
        {
            $common.get_tipDialog('请选择一条仓单信息再进行解押！','showInform');
            return;
        }
        var removePledgeAmount = Number($scope.baseinfo.removePledgeAmount);//解押仓单价值
        var receiptPledgeAmount = Number($scope.baseinfo.receiptPledgeAmount);//质押仓单总价值
        var ration = Number($scope.baseinfo.ration);//质押率
        var riskAmount = Number($scope.baseinfo.riskAmount);//敞口
        var leftAmount =parseFloat(receiptPledgeAmount-removePledgeAmount);//剩余仓单价值

        //剩余仓单价值乘以质押率后与敞口比较
        if((leftAmount*ration) < riskAmount)
        {
            $common.get_tipDialog('剩余质押仓单总额不能覆盖敞口，不允许解押！','showInform');//校验剩余仓单总额是否能够覆盖敞口
            return;
        }

        $scope.WriteDisable = true;
        $scope.submitDisable = true;
        var data = {
            billNormalAppVO:$scope.baseinfo,
            list:$scope.datasourceoff.ds
        };
        $common.get_asyncData("billNormalOffMngService/BillNormalOffMngSubmit",data).then(function(res){
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
    $scope.reviewSubmit_onClick = function()
    {
        $scope.ReviewDisable = true;
        $scope.taskDisable = true;
        $scope.baseinfo.taskComment = $scope.applyDtlForm.taskComment;
        var data = {
            billNormalAppVO:$scope.baseinfo
        };
        $common.get_asyncData("billNormalOffMngService/BillNormalOffReviewUpdate",data).then(function(res){
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

    //审批岗提交
    $scope.checkSubmit_onClick = function()
    {
        $scope.CheckDisable = true;
        $scope.taskDisable = true;
        $scope.baseinfo.taskComment = $scope.applyDtlForm.taskComment;
        var data = {
            billNormalAppVO:$scope.baseinfo
        };
        $common.get_asyncData("billNormalOffMngService/BillNormalOffNoticeUpdate",data).then(function(res){
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

    //回执确认
    $scope.confirmSubmit_onClick = function()
    {
        $scope.ConfirmDisable = true;
        $scope.taskDisable = true;
        $scope.baseinfo.taskComment = $scope.applyDtlForm.taskComment;
        var data = {
            billNormalAppVO:$scope.baseinfo
        };
        $common.get_asyncData("billNormalOffMngService/BillNormalOffConfirmUpdate",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("操作成功，流程结束",'showSuccess');
                $scope.selectedmort.select = [];
                $scope.selected.select = [];
                $scope.Confirm = true;
                window.Confirm = true;
                $scope.BackToModify = true;
                window.BackToModify = true;
                $scope.queryTabletask();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.ConfirmDisable = false;
                $scope.taskDisable = false;
            }
        });
    };

    //退回
    $scope.BackToModify_onClick = function()
    {
        $scope.CheckDisable = true;
        $scope.ReviewDisable = true;
        $scope.ConfirmDisable = true;
        $scope.taskDisable = true;
        $scope.baseinfo.taskComment = $scope.applyDtlForm.taskComment;
        var data = {
            billNormalAppVO:$scope.baseinfo
        };
        $common.get_asyncData("billNormalOffMngService/BillNormalOffBackUpdate",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("已退回",'showSuccess');
                $scope.selectedmort.select = [];
                $scope.selected.select = [];
                $scope.Check = true;
                $scope.Review = true;
                $scope.Confirm = true;
                window.Check = true;
                window.Review = true;
                window.Confirm = true;
                $scope.BackToModify = true;
                window.BackToModify = true;
                $scope.queryTabletask();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.CheckDisable = false;
                $scope.ReviewDisable = false;
                $scope.ConfirmDisable = false;
                $scope.taskDisable = false;
            }
        });
    };
    //表格--------结束-------------------------
};

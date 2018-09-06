/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var mngExcgGuideController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel)
{
    var appno = window.appNo;
    $scope.source = {};
    $scope.baseinfo = {};
    $scope.baseinfo.appno = appno;
    //监听分页
    $scope.$watch("baseinfo.appno",function(){
        $scope.queryBillNormal();
    });
    $scope.queryBillNormal = function(paramData)
    {
        var data = {
            bussInfoVO:$scope.baseinfo
        }
        $common.get_asyncData("billNormalPledgeMngService/BillStandardBussInfoGetter", data).then(function (res) {
            var baseinfo;
            if (res.errorCode == "SUC") {
                baseinfo = res.contextData;
                $scope.baseinfo = baseinfo;
                $scope.baseinfo.flag = "6";
                $scope.source.baseinfo = $scope.baseinfo;
                $scope.queryTaskForm();
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //获取任务信息
    $scope.queryTaskForm = function(paramData)
    {
        $common.get_asyncData("billNormalMngExcgService/findRBcpAppliBussInfoByAppno", {appno:appno}).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.taskform = data;
                if(!data.piid)
                {
                    $scope.source.taskform = {};
                    $scope.source.baseinfo.taskName = "Write";
                    window.source = $scope.source;
                    $state.go("mngexcftaskapplyin");
                    window.Write = false;
                    $("#showIdea").css('display','none');
                }
                else
                {
                    $common.get_asyncData("processService/getCurrentNodeEntity", {pid:data.piid}).then(function (res) {
                        var taskform;
                        if (res.errorCode == "SUC") {
                            taskform = res.contextData;
                            $scope.source.taskform = taskform;
                            $state.go("mngexcftaskapplyin");
                            $scope.source.baseinfo.taskName = taskform.id;
                            window.source = $scope.source;
                            $("#showIdea").css('display','');
                            if(taskform.id == "Write")
                            {//填写岗
                                window.Write = false;
                                $("#showIdea").css('display','none');
                            }
                            else if(taskform.id == "Pricing")
                            {//核价岗
                                window.Check = false;
                                window.BackToModify = false;
                            }
                            else if(taskform.id == "Review")
                            {//复核岗
                                window.Review = false;
                                window.BackToModify = false;
                            }
                            else if(taskform.id == "Confirm")
                            {//回执
                                window.Confirm = false;
                                window.BackToModify = false;
                            }
                            $scope.Write = window.Write;
                            $scope.Check = window.Check;
                            $scope.Review = window.Review;
                            $scope.Confirm = window.Confirm;
                            $scope.BackToModify = window.BackToModify;
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showInform');
                        }
                    })
                }
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
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

    //填写岗提交
    $scope.submit_onClick = function()
    {
        var inVal = Number(window.source.baseinfo.receiptPledgeAmount);//换入仓单总价值
        var outVal = Number(window.source.baseinfo.removePledgeAmount);//换出仓单总价值
        if(inVal<outVal){
            $common.get_tipDialog('换入仓单总价值不能小于换出仓单总价值！','showInform');
            return;
        }
        $scope.WriteDisable = true;
        var data = {
            appno:window.source.baseinfo.appno
        };
        $common.get_asyncData("billNormalMngExcgService/BillNorExchangAppSubmitUpdate",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("操作完成",'showSuccess');
                $scope.queryTabletask();
                $scope.Write = true;
                window.Write = true;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.WriteDisable = false;
            }
        });
    };

    //核价岗提交
    $scope.pricingSubmit_onClick = function()
    {
        $scope.CheckDisable = true;
        $scope.taskDisable = true;
        $scope.baseinfo.taskComment = $scope.applyDtlForm.taskComment;
        var data = {
            bussVO:$scope.baseinfo
        };
        $common.get_asyncData("billNormalMngExcgService/BillNorExchangePricingUpdate",data).then(function(res){
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

    //复核岗 提交
    $scope.reviewSubmit_onClick = function()
    {
        $scope.ReviewDisable = true;
        $scope.taskDisable = true;
        $scope.baseinfo.taskComment = $scope.applyDtlForm.taskComment;
        var data = {
            billNormalAppVO:$scope.baseinfo
        };
        $common.get_asyncData("billNormalMngExcgService/BillNorExchangReviewUpdate",data).then(function(res){
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
    $scope.confirmSubmit_onClick = function()
    {
        $scope.ConfirmDisable = true;
        $scope.taskDisable = true;
        $scope.baseinfo.taskComment = $scope.applyDtlForm.taskComment;
        var data = {
            billNormalAppVO:$scope.baseinfo
        };
        $common.get_asyncData("billNormalMngExcgService/BillNorExchangeConfirmUpdate",data).then(function(res){
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
            billStandardBussInfoVO:$scope.baseinfo
        };
        $common.get_asyncData("billNormalPledgeMngService/BillNorQualityBackToModifyUpdate",data).then(function(res){
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

    //查看通知书
    $scope.noticeIn_onClick = function()
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
                    if(res.errorCode == "SUC") {
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
    //查看通知书
    $scope.noticeOut_onClick = function()
    {
        if(!$scope.baseinfo.appno)
        {
            $common.get_tipDialog("申请编号获取失败!",'showInform');
            return;
        }
        $common.get_ngDialog('nwrinfo/nwrinfo_notice.html', $scope
            ,["$scope",function(dialogScope){
                dialogScope.noticeForm = {};
                dialogScope.noticeForm.noticeType = '127';
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
    };
    //表格--------结束-------------------------
};

/**
 * Created by mengjiajia on 2017/2/27.
 */
var transferOutApplyEditController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel){
    $scope.source = window.source;
    $scope.gntyform = $scope.source.gntyform;
    $scope.transferform = $scope.source.transferform;
    $scope.taskform = $scope.source.taskform;
    var appno;
    if(!window.appNo)
    {
        $scope.buttonHide = false;
        $scope.taskHide = true;
        $scope.hideButton = false;
        if($scope.gntyform.appno)
        {
            appno = $scope.gntyform.appno;
        }
    }
    else
    {
        $scope.buttonHide = true;
        $scope.taskHide = false;
        $scope.hideButton = true;
        appno = window.appNo;
    }
    if(!$scope.transferform.bailAccountno)
    {
        $scope.disable = false;
    }
    else
    {
        $scope.disable = true;
    }
    if(!$scope.gntyform.appno)
    {
        $scope.disableButton = true;
    }
    else
    {
        $scope.disableButton = false;
    }
    //判断不同节点按钮显示
    if(!$scope.taskform||!$scope.taskform.id)
    {
        $scope.Write = false;
        $scope.Review = true;
        $scope.Check = true;
        $scope.Approve = true;
        $scope.backHide = true;
        $scope.taskDisable = false;
    }
    else
    {
        $scope.taskDisable = true;
        if($scope.taskform.id == "Write")
        {//录入提交申请
            $scope.Write = false;
            $scope.Review = true;
            $scope.Check = true;
            $scope.Approve = true;
            $scope.backHide = true;
            $scope.taskDisable = false;
        }
        else if($scope.taskform.id == "Review")
        {//经办机构审查岗复核
            $scope.Write = true;
            $scope.Review = false;
            $scope.Check = true;
            $scope.Approve = true;
            $scope.backHide = false;
        }
        else if($scope.taskform.id== "Check")
        {//交易融资部贷权内控岗复核
            $scope.Write = true;
            $scope.Review = true;
            $scope.Check = false;
            $scope.Approve = true;
            $scope.backHide = false;
        }
        else if($scope.taskform.id== "Approve")
        {//中心负责人审批
            $scope.Write = true;
            $scope.Review = true;
            $scope.Check = true;
            $scope.Approve = false;
            $scope.backHide = false;
        }
        else
        {
            $scope.Write = true;
            $scope.Review = true;
            $scope.Check = true;
            $scope.Approve = true;
            $scope.backHide = true;
        }
    }
    $scope.doBalance_onClick = function()
    {
        var bailAccountno = $scope.transferform.bailAccountno;
        if(bailAccountno==null || bailAccountno==""||!bailAccountno){
            $common.get_tipDialog('请输入保证金账号！','showInform');
            return false;
        }
        var amount = $scope.transferform.amount;
        $scope.transferform.npsBailAmount = amount;
        $scope.$apply();
    }
    //保存
    $scope.save_onClick = function()
    {
        if($.doValidate("transferform")) {
            $scope.flowsubmitdisable = true;
            var data = {
                bCrrGntyConVO:$scope.gntyform,
                value:$scope.transferform
            }
            var primise = $common.get_asyncData("maximumBailTransferOutApplyService/BailTransferOutWriteUpdate",data);
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    appno = res.contextData.value;
                    $scope.gntyform.appno = appno;
                    $scope.disableButton = false;
                    $common.get_tipDialog('保存成功！','showSuccess');
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    }
    //保证金转出申请录入提交申请
    $scope.submit_onClick = function()
    {
        if($.doValidate("transferform")) {
            $scope.flowsubmitdisable = true;
            var primise = $common.get_asyncData("maximumBailTransferOutApplyService/BailTransferOutWriteSubmit",{appno:appno,isProcess:true});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('流程提交成功！','showSuccess');
                    $state.go("list");
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    }
    //保证金转出申请经办机构审查岗复核
    //保证金转出申请交易融资部贷权内控岗复核
    $scope.checkAgree_onClick = function()
    {
        $scope.ReviewDisable = true;
        $scope.CheckDisable = true;
        $scope.backHideDisable = true;
        var primise = $common.get_asyncData("maximumBailTransferOutApplyService/BailTransferOutSubmit",{appno:appno,isProcess:true});
        primise.then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog('流程提交成功！','showSuccess');
                $state.go("list");
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    }
    //保证金转出申请中心负责人审批
    $scope.ApproveAgree_onClick = function()
    {
        $scope.ApproveDisable = true;
        $scope.backHideDisable = true;
        var primise = $common.get_asyncData("maximumBailTransferOutApplyService/BailTransferOutApproveSubmit",{appno:appno,isProcess:true});
        primise.then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog('流程审批通过！','showSuccess');
                $state.go("list");
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    }
    //退回
    $scope.BackToModify_onClick = function()
    {
        $scope.ReviewDisable = true;
        $scope.CheckDisable = true;
        $scope.ApproveDisable = true;
        $scope.backHideDisable = true;
        var primise = $common.get_asyncData("maximumBailTransferOutApplyService/BailTransferOutBackToModUpdate",{appno:appno,isProcess:true});
        primise.then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog('流程退回成功！','showSuccess');
                $state.go("list");
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    }
    $scope.back_onClick = function(){
        $state.go("list");
    };
};
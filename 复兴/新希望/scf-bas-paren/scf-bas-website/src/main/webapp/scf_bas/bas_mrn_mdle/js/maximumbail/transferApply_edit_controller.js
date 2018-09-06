/**
 * Created by mengjiajia on 2017/2/27.
 */
var transferApplyEditController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel){
    $scope.source = window.source;
    $scope.gntyform = $scope.source.gntyform;
    $scope.transferform = $scope.source.transferform;
    if(!$scope.transferform.bailAccountno)
    {
        $scope.disable = false;
    }
    else
    {
        $scope.disable = true;
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
            var primise = $common.get_asyncData("maximumBailTransferApplyService/BailTransferApplyUpdate",data);
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('保存成功！','showSuccess');
                    $state.go("list");
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    }
    $scope.back_onClick = function(){
        $state.go("list");
    };
};
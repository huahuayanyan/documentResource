/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var rePayMainController =  function($scope,$common,$state,dataDeliver){
    var data = dataDeliver.getter();
    var appNo = data.appNo;
    $scope.poolRePay = {};
    $scope.submit=true;
    if($state.current.name=="bsystasktab.rePayWrite"){
        queryPoolRePayMainInfo();
        returnAccountSource();
        balanceAccountSource();
        $scope.submit=false;
    }
    if($state.current.name=="bsystasktab.rePayCheck"){
        queryPoolRePayMainInfo();
        returnAccountSource();
        balanceAccountSource();
    }
    function queryPoolRePayMainInfo(){
        var data = {appNo:appNo}
        var promise = $common.get_asyncData("rBcpPoolRePayService/findPoolRePay",data);
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.poolRePay = res.contextData;
                $scope.poolRePay.returnAmount = 1000000;
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    }

    $scope.save_onClick = function(){
        $scope.poolRePay.factType="1";
        if($.doValidate("poolRePay")){
        var amount=parseFloat($scope.poolRePay.amount);//转出金额
        var returnAmount=1000000;//这里先这样做，回款专户可用余额固定为1000000
        if(amount > returnAmount){
            $common.get_tipDialog('转出金额不可大于回款专户可用余额！','showInform');
        }else{
            if(appNo){
                //var bcpPoolRePayVO = {appNo:appNo,};
                var data = {
                    appNo:appNo,
                    bcpPoolRePayVO:$scope.poolRePay
                };
                var promise = $common.get_asyncData("rBcpPoolRePayService/updatePoolRePay",data);
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        //appNo = res.contextData.value;
                        $common.get_tipDialog('修改成功!','showInform');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
            }else{
                    var data = {bcpPoolRePayVO:$scope.poolRePay};
                    var promise = $common.get_asyncData("rBcpPoolRePayService/savePoolRePay",data);
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            appNo = res.contextData.value;
                            $common.get_tipDialog('保存成功!','showInform');
                            $scope.submit=false;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                }
            }
        }
    }
    $scope.submit_onClick = function(){
        $scope.poolRePay.factType="1";
        if($.doValidate("poolRePay")) {
            var amount = parseFloat($scope.poolRePay.amount);//转出金额
            var returnAmount = 1000000;//这里先这样做，回款专户可用余额固定为1000000
            if (amount > returnAmount) {
                $common.get_tipDialog('转出金额不可大于回款专户可用余额！', 'showInform');
            } else {
                var data = {
                    appNo: appNo,
                    bcpPoolRePayVO: $scope.poolRePay
                }
                var primise = $common.get_asyncData("rBcpPoolRePayService/submitPoolRePay", data);
                primise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        $common.get_tipDialog('提交成功！', 'showSuccess');
                        if ($state.current.name == "bsystasktab.rePayWrite") {
                            $state.go("bsystask");
                        } else {
                            $scope.poolRePay = {};
                            $scope.submit = true;
                        	appNo = undefined;
                        }
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                });
            }
        }
    }
    $scope.cnameContent = {
        type:"table",//展示类型table  tree
        url:"rBcpPoolRePayService/getCustNameBycd",
        split:"-",//分隔符
        extentColumn:"cname",
        column:["cname","custcd"]//展示内容
    };
    $scope.cnameChange = function(ds){
        $scope.poolRePay.custcd = ds.custcd;
        $scope.poolRePay.cname = ds.cname;
        returnAccountSource();
        balanceAccountSource();
    };
    $scope.$watch("poolRePay.cname",function(){
        $scope.cnameContent.param = {
            cname:$scope.poolRePay.cname,
            financingType:"1"
        };
    });
    //回款专户
    $scope.returnAccountSource = {ds:[]};
    function returnAccountSource(){
        var bAccAccountInfo = {custcd:$scope.poolRePay.custcd,accountType:"2"};
        var data = {bAccAccountInfo:bAccAccountInfo}
        var promise = $common.get_asyncData("rBcpPoolRePayService/getReturnAccountbyCustcd",data);
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.returnAccountSource.ds = res.contextData;
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    }
    $scope.balanceAccountSource = {ds:[]}
    function balanceAccountSource(){
        var bAccAccountInfo = {custcd:$scope.poolRePay.custcd,accountType:"1"};
        var data = {bAccAccountInfo:bAccAccountInfo}
        var promise = $common.get_asyncData("rBcpPoolRePayService/getReturnAccountbyCustcd",data);
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.balanceAccountSource.ds = res.contextData;
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    };
    $scope.queryAmount_onClick = function(){
        $scope.$apply(function(){
            $scope.poolRePay.returnAmount = 1000000;
        });
    }
};

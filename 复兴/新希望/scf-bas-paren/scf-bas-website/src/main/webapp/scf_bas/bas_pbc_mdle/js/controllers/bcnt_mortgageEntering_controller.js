/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var bcntMortgageEnteringController = function($scope,$common,$state,dataDeliver) {
    productSource();
    mortgageLevelOneSource();
    $scope.mortgage = {};
    $scope.datasource = {};
    $scope.selected = {select:[]};
    $scope.conf = {
        pageNo: 1,
        pageSize: 10,
        totalRecord:0
    };
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryMortgageInfo();
    });

    $scope.queryMortgageInfo = function(paramData){
        var data = {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            mortgageEnter: $scope.mortgage
        };
        var promise = $common.get_asyncData("mortgageEnteringService/queryMortgageEnteringListByPage", data);
        promise.then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //查询业务品种
    function productSource(){
        //业务品种下拉框
        var dataItemsDO = {};
        var data = {dataItemsDO:dataItemsDO};
        var promise = $common.get_asyncData("monitorProtocolService/getProductId",data);
        $scope.productSource = {};
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.productSource.ds = res.contextData;
                //$scope.protocol.productId="1220020";
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    }
    //查询押品一级
    function mortgageLevelOneSource(){
        //业务品种下拉框
        var dataItemsDO = {levels:"1"};
        var data = {dataItemsDO:dataItemsDO};
        var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
        $scope.mortgageLevelOneSource = {};
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.mortgageLevelOneSource.ds = res.contextData;
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    }
    //联动下拉
    $scope.mortgageLevelTwoSource = {};
    $scope.mortgageLevelOneName = function (val){
        $scope.mortgage.mortgageLevelTwoName = "";
        if(null != val){
            var dataItemsDO = {mortgageCode:val};
            var data = {dataItemsDO:dataItemsDO};
            var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
            primise.then(function(res){
                if(res.errorCode =="SUC"){
                    $scope.mortgageLevelTwoSource.ds = res.contextData;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
        }else{
            $scope.mortgageLevelTwoSource.ds = [];
        }
    };
    //查询
    $scope.submit_onClick = function(){
        $scope.queryMortgageInfo();
        $scope.selected.select = [];
    };

    //重置
    $scope.reset_onClick = function(){
        $scope.$apply(function () {
            $scope.mortgage = {};
        })
    };

    //新增
    $scope.add_onClick = function(){
        $state.go("bcntMortgageEnteringAdd");//跳转
    };
    //查看
    $scope.detail_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('只能选择一条记录！', 'showInform');
        }else{
            $common.get_ngDialog('mortgageEntering/bcnt_mortgageEnteringInfo.html', $scope,["$scope",function(dialogScope) {
                dialogScope.confirm = true;
                dialogScope.disable = true;
                dialogScope.mortgageInfo={};
                var mortgageNo = $scope.selected.select[0].mortgageNo;
                var data = {mortgageNo:mortgageNo};
                var promise = $common.get_asyncData("mortgageEnteringService/bPbcMtgBaseInfoQuery",data);
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.mortgageInfo = res.contextData;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
                //查询押品一级
                mortgageLevelOneSource();
                function mortgageLevelOneSource(){
                    //业务品种下拉框
                    var dataItemsDO = {levels:"1"};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    dialogScope.mortgageLevelOneSource = {};
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
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    dialogScope.mortgageLevelTwoSource = {};
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                }
                //押品三级
                mortgageLevelThreeSource();
                function mortgageLevelThreeSource(){
                    //业务品种下拉框
                    var dataItemsDO = {levels:"3"};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    dialogScope.mortgageLevelThreeSource = {};
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelThreeSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                }
                dialogScope.cancel_onClick = function () {
                    dialogScope.closeThisDialog();
                    $scope.selected.select = [];
                };
            }],"入库押品详情录入")
        }
    };

    //修改
    $scope.update_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('只能选择一条记录！', 'showInform');
        }else if($scope.selected.select[0].stockStatus=="02"){
            $common.get_tipDialog('已出质的信息不允许修改！', 'showInform');
        }else{
            $common.get_ngDialog('mortgageEntering/bcnt_mortgageEnteringInfo.html', $scope,["$scope",function(dialogScope) {
                dialogScope.mortgageInfo = {};
                var mortgageNo = $scope.selected.select[0].mortgageNo;
                var data = {mortgageNo:mortgageNo};
                var promise = $common.get_asyncData("mortgageEnteringService/bPbcMtgBaseInfoQuery",data);
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.mortgageInfo = res.contextData;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
                //查询押品一级
                mortgageLevelOneSource();
                function mortgageLevelOneSource(){
                    //业务品种下拉框
                    var dataItemsDO = {levels:"1"};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    dialogScope.mortgageLevelOneSource = {};
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelOneSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                }
                //押品二级
                dialogScope.mortgageLevelTwoSource = {};
                mortgageLevelTwoSource();
                function mortgageLevelTwoSource(){
                    //业务品种下拉框
                    var dataItemsDO = {mortgageCode:$scope.selected.select[0].mortgageLevelOne,levels:"2"};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                }
                dialogScope.mortgageLevelOneName = function (val){
                    if(null != val){
                        var dataItemsDO = {mortgageCode:val};
                        var data = {dataItemsDO:dataItemsDO};
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
                dialogScope.mortgageLevelThreeSource = {};
                mortgageLevelThreeSource();
                function mortgageLevelThreeSource(){
                    //业务品种下拉框
                    var dataItemsDO = {mortgageCode:$scope.selected.select[0].mortgageLevelTwo,levels:"3"};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelThreeSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                }
                dialogScope.mortgageLevelTwoName = function (val){
                    if(null != val){
                        var dataItemsDO = {mortgageCode:val};
                        var data = {dataItemsDO:dataItemsDO};
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
                dialogScope.confirm_onClick = function(){
                    if($.doValidate("mortgageInfoForm")){
                        //var bPbcMtgBaseInfoDO = {bPbcMtgBaseInfoDO:}
                        var data = {bPbcMtgBaseInfoDO:dialogScope.mortgageInfo};
                        var primise = $common.get_asyncData("mortgageEnteringService/bPbcMtgBaseInfoUpdate",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                $common.get_tipDialog('修改成功!','showInform');
                                dialogScope.closeThisDialog();
                                $scope.queryMortgageInfo();
                                $scope.selected.select = [];
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }
                };
                dialogScope.cancel_onClick = function () {
                    dialogScope.closeThisDialog();
                    $scope.selected.select = [];
                };
            }],"入库押品详情录入")
        }
    };

    //删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录!','showInform')
        }else if($scope.selected.select[0].stockStatus=="02"){
            $common.get_tipDialog('已出质的信息不允许删除！', 'showInform');
        }else{
            $common.get_tipDialog('确定删除吗？','showTip').then(function(){
                var data = {bPbcMtgBaseInfoDO:$scope.selected.select};
                var primise = $common.get_asyncData("mortgageEnteringService/bPbcMtgBaseInfoDelete",data);
                primise.then(function(res){
                    if(res.errorCode =="SUC"){
                        $common.get_tipDialog('删除成功!','showInform');
                        $scope.queryMortgageInfo();
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
            })
        }
    }
};

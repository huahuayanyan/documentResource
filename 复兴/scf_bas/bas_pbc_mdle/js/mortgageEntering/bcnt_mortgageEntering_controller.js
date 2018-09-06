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

    mortgageLevelOneSource();
    $scope.mortgage = {
        productId:"1220020",
        suppProductName:"1220020"
    };
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
        var promise = $common.get_asyncData("mortgageEnteringService/queryMortgageEnteringListByPageForManage", data);
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
    $scope.productSource = {
        ds:[
            {productId:"1220010",productName:'现货静态质押'},
            {productId:"1220020",productName:'现货动态质押'},
        ]
    };
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
            $scope.mortgage = {
                productId:"1220020",
                suppProductName:"1220020"
            };
        });
    };

    //新增
    $scope.add_onClick = function(){
        $state.go("bcntMortgageEnteringAdd");//跳转
    };
    //查看
    $scope.detail_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        }else{
            $common.get_ngDialog('mortgageEnteringXhdt/bcnt_mortgageEnteringInfo.html', $scope,["$scope",function(dialogScope) {
                dialogScope.confirm = true;
                dialogScope.disable = true;
                dialogScope.mortgageInfo={};
                var mortgageNo = $scope.selected.select[0].mortgageNo;
                var data = {mortgageNo:mortgageNo};
                var promise = $common.get_asyncData("mortgageEnteringService/bPbcMtgBaseInfoQuery",data);
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.mortgageInfo = res.contextData;
                        var allQuality = (dialogScope.mortgageInfo.quantity==null?0:dialogScope.mortgageInfo.quantity)+(dialogScope.mortgageInfo.invQuantity==null?0:dialogScope.mortgageInfo.invQuantity);
                        dialogScope.mortgageInfo.invQuantity=allQuality;
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
            }],"入库押品详情录入",{showClose:true});
        }
    };

    //修改
    $scope.update_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        }else if($scope.selected.select[0].ext3=="0"){
            $common.get_tipDialog('该押品已出质，不可修改！', 'showInform');
        }else{
            $common.get_ngDialog('mortgageEnteringXhdt/bcnt_mortgageEnteringInfo.html', $scope,["$scope",function(dialogScope) {
                dialogScope.mortgageInfo = {};
                var mortgageNo = $scope.selected.select[0].mortgageNo;
                var data = {mortgageNo:mortgageNo};
                var promise = $common.get_asyncData("mortgageEnteringService/bPbcMtgBaseInfoQuery",data);
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.mortgageInfo = res.contextData;
                        var allQuality = (dialogScope.mortgageInfo.quantity==null?0:dialogScope.mortgageInfo.quantity)+(dialogScope.mortgageInfo.invQuantity==null?0:dialogScope.mortgageInfo.invQuantity);
                        dialogScope.mortgageInfo.invQuantity=allQuality;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
                //查询押品一级
                mortgageLevelOneSource();
                
                var mortgageCodeOneList = new Array();//拼装押品一级Code
                var mortgageCodeTwoList = new Array();//拼装押品二级Code
                
                function mortgageLevelOneSource(){
                	
                	//查询一级押品前，先查询该抵质押合同录入的押品信息
                	
                    var dataMtg= {
                        pageNo: 1,
                        pageSize: 10000,
                        bCntSlaveMtgRel:{slaveContno:$scope.selected.select[0].slaveContno},
                        cache:0
                    };
                    var promiseMtg = $common.get_asyncData("bCntSlaveMtgRelService/findBCntSlaveMtgRelByPage",dataMtg);
                    dialogScope.mortgageLevelOneSource = {};
                    promiseMtg.then(function(res){
                        var data;
                        if (res.errorCode =="SUC"){
                            data = res.contextData;
                            
                            for(var i=0;i<data.records.length;i++){
                            	var mtgModel = data.records[i];
                            	mortgageCodeOneList.push(mtgModel.mortgageLevelOne);
                            	mortgageCodeTwoList.push(mtgModel.mortgageLevelTwo);
                         } 
                	
                    //业务品种下拉框
                    var dataItemsDO = {levels:"1",mortgageCodeList:mortgageCodeOneList};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelOneSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                    
                    }else{
                         $common.get_tipDialog(res.errorMsg,'showError');
                      }
                   });
                }
                //押品二级
                dialogScope.mortgageLevelTwoSource = {};
                mortgageLevelTwoSource();
                function mortgageLevelTwoSource(){
                    //业务品种下拉框
                    var dataItemsDO = {mortgageCode:$scope.selected.select[0].mortgageLevelOne,levels:"2",mortgageCodeList:mortgageCodeTwoList};
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
                        var dataItemsDO = {mortgageCode:val,mortgageCodeList:mortgageCodeTwoList};
                        var data = {dataItemsDO:dataItemsDO};
                        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                                //清空三级押品的内容
                                dialogScope.mortgageLevelThreeSource.ds=[];
                                dialogScope.mortgageInfo.mortgageLevelThree=null;
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
                    if($.doValidate("mortgageInfo")){
                        var price = parseFloat(dialogScope.mortgageInfo.price) ;
                        var invQuantity = parseFloat(dialogScope.mortgageInfo.invQuantity);
                        var originalTotPrice = price * invQuantity;
                        dialogScope.mortgageInfo.originalTotPrice = originalTotPrice;
                        var data = {bPbcMtgBaseInfoDO:dialogScope.mortgageInfo};
                        var primise = $common.get_asyncData("mortgageEnteringService/bPbcMtgBaseInfoUpdateSelective",data);
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
            }],"入库押品详情录入",{showClose:true});
        }
    };

    //删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录!','showInform')
        }else if($scope.selected.select[0].ext3=="0"){
            $common.get_tipDialog('该押品已出质，不可删除！', 'showInform');
        }else{
            $common.get_tipDialog('确定删除吗？','showTip').then(function(){
                var data = {bPbcMtgBaseInfoDO:$scope.selected.select};
                var primise = $common.get_asyncData("mortgageEnteringService/bPbcMtgBaseInfoDelete",data);
                primise.then(function(res){
                    if(res.errorCode =="SUC"){
                        $common.get_tipDialog('删除成功!','showInform');
                        $scope.selected.select=[];
                        $scope.queryMortgageInfo();
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
            })
        }
    }
};

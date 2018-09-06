/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var qualityApplyInfoController = function($scope,$common,$state,dataDeliver) {
    var data = dataDeliver.getter();
    var appNo = data.appNo;
    var conId = data.conId;
    var gutId = data.gutId;
    var processId =data.processId;
    var modelId = data.modelId;
    if(window.appNo)
    {
        $scope.hide = true;
    }
    else
    {
        $scope.hide = false;
    }
    init();
    function init(){
        if($state.current.name=="qualityApply.qualityInfo"&&appNo==null){
            $scope.disable = true;
        }
    }
    $scope.conf = {
        pageNo:1,
        pageSize:10
    }
    if(appNo){
        var promise = $common.get_asyncData("bPbcAppliBaseInfoService/findBPbcAppliBaseInfoByKey",{"key":appNo});
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                conId = data.slaveContno;
                gutId = data.custcd;
                queryMortgageTaskInfo();//待办任务基本信息查询
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }else{
        queryMortgageInfo();//申请基本信息查询
    }
    $scope.datasource = {ds:[]};
    $scope.qualityApplyInfo = {};
    function queryMortgageInfo(){
        var qualityApplyDO = {conId:conId,appNo:appNo};
        var data = {
            pageNo:$scope.conf.pageNo,
            pageSize:$scope.conf.pageSize,
            qualityApplyDO: qualityApplyDO
        }
        var promise = $common.get_asyncData("qualityApplyService/slaveProtocontInfo", data);
        promise.then(function (res) {
            if (res.errorCode == "SUC") {
                $scope.qualityApplyInfo = res.contextData;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    }
    function queryMortgageTaskInfo(){
        var qualityApplyDO = {conId:conId,appNo:appNo};
        var data = {
            pageNo:$scope.conf.pageNo,
            pageSize:$scope.conf.pageSize,
            qualityApplyDO: qualityApplyDO
        }
        var promise = $common.get_asyncData("qualityApplyService/slaveProtocontInfo", data);
        promise.then(function (res) {
            if (res.errorCode == "SUC") {
                $scope.qualityApplyInfo = res.contextData;
                $scope.datasource.ds = res.contextData.page.records;
                $scope.conf.totalRecord = res.contextData.page.totalRecord;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    }
    productSource();
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
    //已入库押品详情查看按钮
    $scope.enterDetail_onClick = function(){
        $common.get_ngDialog('qualityApply/mortgageEnterList.html',$scope,["$scope",function(dialogScope){
            dialogScope.mortgageList = {slaveContno:$scope.qualityApplyInfo.conId,custcd:gutId,isLocked:"1",stockStatus:"02"};
            dialogScope.datasource = {};
            dialogScope.selected = {select:[]};
            dialogScope.conf = {
                pageNo: 1,
                pageSize: 10
            };
            dialogScope.$watch("conf.pageNo+conf.pageSize", queryMortgageListInfo);

            function queryMortgageListInfo(){
                var data = {
                    pageNo: dialogScope.conf.pageNo,
                    pageSize: dialogScope.conf.pageSize,
                    mortgageEnter: dialogScope.mortgageList
                }
                var promise = $common.get_asyncData("mortgageEnteringService/queryMortgageEnteringListByPage", data);
                promise.then(function (res) {
                    var data;
                    if (res.errorCode == "SUC") {
                        data = res.contextData;
                        dialogScope.datasource.ds = data.records;
                        dialogScope.conf.totalRecord = data.totalRecord;
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                })
            }
            dialogScope.cancel_onClick = function(){
                dialogScope.closeThisDialog();
                dialogScope.selected.select = [];
            }
        }
        ],"押品列表")
    };
    //查看按钮
    $scope.detail_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('只能选择一条记录！', 'showInform');
        }else{
            $common.get_ngDialog('qualityApply/mortgageDetail.html',$scope,["$scope",function(dialogScope){
            	dialogScope.mortgageDetail = {};
            	dialogScope.disable = true;
                var mortgageNo = $scope.selected.select[0].mortgageNo;
                var data = {mortgageNo:mortgageNo}
                var promise = $common.get_asyncData("mortgageEnteringService/bPbcMtgBaseInfoQuery",data);
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.mortgageDetail;
                        dialogScope.mortgageDetail = res.contextData;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
                //查询押品一级
                mortgageLevelOneSource();
                function mortgageLevelOneSource(){
                    //业务品种下拉框
                    var dataItemsDO = {levels:"1"};
                    var data = {dataItemsDO:dataItemsDO}
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
                    var data = {dataItemsDO:dataItemsDO}
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
                    var data = {dataItemsDO:dataItemsDO}
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
                dialogScope.cancel_onClick = function(){
                    dialogScope.closeThisDialog();
                    dialogScope.selected.select = [];
                };
            }])
        }
    };
    //新增
    $scope.add_onClick = function(){
        $common.get_ngDialog('qualityApply/mortgageList.html',$scope,["$scope",function(dialogScope){
            mortgageLevelOneSource();
            dialogScope.mortgageList = {custcd:gutId,slaveContno:conId,isLocked:"0"};
            dialogScope.datasource = {};
            dialogScope.selected = {select:[]};
            dialogScope.conf = {
                pageNo: 1,
                pageSize: 10
            };
            dialogScope.$watch("conf.pageNo+conf.pageSize",function(){
                dialogScope.queryMortgageListInfo();
            });
            //dialogScope.$watch("conf.pageNo+conf.pageSize", queryMortgageListInfo);
            dialogScope.queryMortgageListInfo = function(paramData){
                var data = {
                    pageNo: dialogScope.conf.pageNo,
                    pageSize: dialogScope.conf.pageSize,
                    mortgageEnter: dialogScope.mortgageList
                }
                var promise = $common.get_asyncData("mortgageEnteringService/queryMortgageEnteringListByPage", data);
                promise.then(function (res) {
                    var data;
                    if (res.errorCode == "SUC") {
                        data = res.contextData;
                        dialogScope.datasource.ds = data.records;
                        dialogScope.conf.totalRecord = data.totalRecord;
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                })
            }
            //查询押品一级
            function mortgageLevelOneSource(){
                //业务品种下拉框
                var dataItemsDO = {levels:"1"};
                var data = {dataItemsDO:dataItemsDO}
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
            //联动下拉
            dialogScope.mortgageLevelTwoSource = {};
            dialogScope.mortgageLevelOneName = function (val){
                dialogScope.mortgageList.mortgageLevelTwoName = "";
                if(null != val){
                    var dataItemsDO = {mortgageCode:val}
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
            }
            //查询按钮
            dialogScope.submit_onClick = function(){
                dialogScope.queryMortgageListInfo();
                dialogScope.selected.select = [];
            };
            //重置按钮
            dialogScope.reset_onClick = function(){
                $scope.$apply(function () {
                    dialogScope.mortgageList = {custcd:gutId,slaveContno:conId,isLocked:"0"};
                })
            };
            //保存按钮
            dialogScope.save_onClick = function(){
                if(dialogScope.selected.select.length<1){
                    $common.get_tipDialog('请至少选择一条记录!','showInform');
                }else{
                    $scope.datasource.ds.splice(0);
                    for(var i=0;i<dialogScope.selected.select.length;i++){
                        $scope.datasource.ds.push(dialogScope.selected.select[i]);
                    }
                    $scope.conf.totalRecord = dialogScope.selected.select.length;
                    dialogScope.closeThisDialog();
                    $scope.selected.select = [];
                    totPrice();
                }
            };
            //取消按钮
            dialogScope.cancel1_onClick = function(){
                dialogScope.closeThisDialog();
                $scope.selected.select = [];
            };
        }])
    };
    //删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length < 1){
            $common.get_tipDialog('请至少选择一条记录!','showInform')
        }else{
            $common.get_tipDialog('确定删除吗？','showTip').then(function(){
                for(i = 0;i<$scope.selected.select.length;i++){
                    var mortgageNo = $scope.selected.select[i].mortgageNo;
                    var isLocked = "0";
                    var bPbcMtgBaseInfoDO = {mortgageNo:mortgageNo,isLocked:isLocked};
                    var data = {bPbcMtgBaseInfoDO:bPbcMtgBaseInfoDO}
                    $common.get_asyncData("mortgageEnteringService/bPbcMtgBaseInfoUpdate",data);
                    $scope.datasource.ds.splice($scope.selected.select[i], 1);
                }
                $scope.conf.totalRecord = $scope.conf.totalRecord - $scope.selected.select.length;
                totPrice();
            })
        }
    };
    //保存
    $scope.save_onClick = function(){
        if(appNo){
            //修改申请信息
            if($scope.datasource.ds.length<1){
                $common.get_tipDialog('请添加押品信息!','showInform');
            }else{
                var data = {
                    appNo:appNo,
                    conId:$scope.qualityApplyInfo.conId,
                    lowPriceNew:$scope.qualityApplyInfo.lowPriceNew,
                    mortgageInfoList:$scope.datasource.ds
                }
                var primise = $common.get_asyncData("qualityApplyService/updateQualityApplyInfo",data);
                primise.then(function(res){
                    if(res.errorCode =="SUC"){
                        appNo = res.contextData.value;
                        $common.get_tipDialog('修改成功!','showInform');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
            }
        }else{
            //新增申请信息
            if($scope.datasource.ds.length<1){
                $common.get_tipDialog('请添加押品信息!','showInform');
            }else{
                var data = {
                    //gutId:$scope.qualityApplyInfo.gutId,
                    conId:$scope.qualityApplyInfo.conId,
                    lowPriceNew:$scope.qualityApplyInfo.lowPriceNew,
                    mortgageInfoList:$scope.datasource.ds
                }
                var primise = $common.get_asyncData("qualityApplyService/saveQualityApplyInfo",data);
                primise.then(function(res){
                    if(res.errorCode =="SUC"){
                        appNo = res.contextData.value;
                        var appNo={
                            appNo:appNo
                        };
                        $.extend(dataDeliver.getter(),appNo);
                        dataDeliver.setter(dataDeliver.getter());
                        $scope.disable = false;
                        $common.get_tipDialog('保存成功!','showInform');
                        //var data1 = {appNo:appNo}
                        //$state.go("qualityApply");//跳转
                        //dataDeliver.setter(data1)//传值[可选]
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
            }
        }
    };
    //提交
    $scope.submit_onClick = function(){
        var state;
        if($state.current.name=="qualityApply.qualityInfo"){
            state = "write_task";
            //修改申请信息
            if($scope.datasource.ds.length<1){
                $common.get_tipDialog('请添加押品信息!','showInform');
            }else{
                var data = {
                    appNo:appNo,
                    conId:$scope.qualityApplyInfo.conId,
                    lowPriceNew:$scope.qualityApplyInfo.lowPriceNew,
                    mortgageInfoList:$scope.datasource.ds
                }
                var primise = $common.get_asyncData("qualityApplyService/updateQualityApplyInfo",data);
                primise.then(function(res){
                    if(res.errorCode =="SUC"){
                        appNo = res.contextData.value;
                        //$common.get_tipDialog('修改成功!','showInform');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
            }
        }
        if($state.current.name=="bsystasktab.qualityApplyWrite.qualityInfo"){
            state = "write_task";
            //修改申请信息
            if($scope.datasource.ds.length<1){
                $common.get_tipDialog('请添加押品信息!','showInform');
            }else{
                var data = {
                    appNo:appNo,
                    conId:$scope.qualityApplyInfo.conId,
                    lowPriceNew:$scope.qualityApplyInfo.lowPriceNew,
                    mortgageInfoList:$scope.datasource.ds
                }
                var primise = $common.get_asyncData("qualityApplyService/updateQualityApplyInfo",data);
                primise.then(function(res){
                    if(res.errorCode =="SUC"){
                        appNo = res.contextData.value;
                        //$common.get_tipDialog('修改成功!','showInform');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
            }
        }
        if($state.current.name=="bsystasktab.qualityApplyCheck.qualityInfo"){
            state = "check_task";
        }
        if($state.current.name=="bsystasktab.qualityApplyApprove.qualityInfo"){
            state = "approve_task";
        }
        if($state.current.name=="bsystasktab.qualityApplyReceipt.qualityInfo"){
            state = "receipt_task";
        }
        //提交业务处理
        var data1 = {
            appNo:appNo,
            conId:$scope.qualityApplyInfo.conId,
            lowPriceNew:$scope.qualityApplyInfo.lowPriceNew,
            mortgageInfoList:$scope.datasource.ds,
            state:state
        };
        var primise = $common.get_asyncData("qualityApplyService/submitQualityApplyInfo", data1);
        primise.then(function (res) {
            if (res.errorCode == "SUC") {
                //$scope.queryTable();
                //$scope.selected.select = [];
                $common.get_tipDialog('提交成功！', 'showSuccess');
                //$state.go("bsystask");
                if(!window.appNo)
                {
                    $state.go("qualityApplyMain");
                }
                else
                {
                    $scope.disable = true;
                    $scope.savedisable = true;
                }
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    };
    //返回
    $scope.cancel_onClick = function(){
        $state.go("qualityApplyMain");
    };
    totPrice();
    //计算本次申请入库押品总价值
    function totPrice(){
        if($scope.datasource.ds){
            var amount = 0;
            var totPrice = 0;
            for(i=0;i<$scope.datasource.ds.length;i++){
                totPrice = $scope.datasource.ds[i].totPrice;
                amount = totPrice + amount;
            }
            $scope.qualityApplyInfo.amount = amount;
        }
    }
    //流程提交页面
    //已入库押品详情查看按钮
    $scope.enterDetailWrite_onClick = function(){
        $common.get_ngDialog('../../bas_pbc_mdle/html/qualityApply/mortgageEnterList.html',$scope,["$scope",function(dialogScope){
            dialogScope.mortgageList = {slaveContno:$scope.qualityApplyInfo.conId,custcd:gutId,isLocked:"1",stockStatus:"02"};
            dialogScope.datasource = {};
            dialogScope.selected = {select:[]};
            dialogScope.conf = {
                pageNo: 1,
                pageSize: 10
            };
            dialogScope.$watch("conf.pageNo+conf.pageSize", queryMortgageListInfo);

            function queryMortgageListInfo(){
                var data = {
                    pageNo: dialogScope.conf.pageNo,
                    pageSize: dialogScope.conf.pageSize,
                    mortgageEnter: dialogScope.mortgageList
                }
                var promise = $common.get_asyncData("mortgageEnteringService/queryMortgageEnteringListByPage", data);
                promise.then(function (res) {
                    var data;
                    if (res.errorCode == "SUC") {
                        data = res.contextData;
                        dialogScope.datasource.ds = data.records;
                        dialogScope.conf.totalRecord = data.totalRecord;
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                })
            }
            dialogScope.cancel_onClick = function(){
                dialogScope.closeThisDialog();
                dialogScope.selected.select = [];
            }
        }
        ],"押品列表")
    };
    //查看按钮
    $scope.detailWrite_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('只能选择一条记录！', 'showInform');
        }else{
            $common.get_ngDialog('../../bas_pbc_mdle/html/qualityApply/mortgageDetail.html',$scope,["$scope",function(dialogScope){
                dialogScope.disable = true;
                dialogScope.mortgageDetail={};
                var mortgageNo = $scope.selected.select[0].mortgageNo;
                var data = {mortgageNo:mortgageNo}
                var promise = $common.get_asyncData("mortgageEnteringService/bPbcMtgBaseInfoQuery",data);
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.mortgageDetail;
                        dialogScope.mortgageDetail = res.contextData;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
                //查询押品一级
                mortgageLevelOneSource();
                function mortgageLevelOneSource(){
                    //业务品种下拉框
                    var dataItemsDO = {levels:"1"};
                    var data = {dataItemsDO:dataItemsDO}
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
                    var data = {dataItemsDO:dataItemsDO}
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
                    var data = {dataItemsDO:dataItemsDO}
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
                dialogScope.cancel_onClick = function(){
                    dialogScope.closeThisDialog();
                    dialogScope.selected.select = [];
                };
            }])
        }
    };
    //新增
    $scope.addWrite_onClick = function(){
        $common.get_ngDialog('../../bas_pbc_mdle/html/qualityApply/mortgageList.html',$scope,["$scope",function(dialogScope){
            mortgageLevelOneSource();
            dialogScope.mortgageList = {isLocked:"0"};
            dialogScope.datasource = {};
            dialogScope.selected = {select:[]};
            dialogScope.conf = {
                pageNo: 1,
                pageSize: 10
            };
            dialogScope.$watch("conf.pageNo+conf.pageSize", queryMortgageListInfo);

            function queryMortgageListInfo(){
                var data = {
                    pageNo: dialogScope.conf.pageNo,
                    pageSize: dialogScope.conf.pageSize,
                    mortgageEnter: dialogScope.mortgageList
                }
                var promise = $common.get_asyncData("mortgageEnteringService/queryMortgageEnteringListByPage", data);
                promise.then(function (res) {
                    var data;
                    if (res.errorCode == "SUC") {
                        data = res.contextData;
                        dialogScope.datasource.ds = data.records;
                        dialogScope.conf.totalRecord = data.totalRecord;
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                })
            }
            //查询押品一级
            function mortgageLevelOneSource(){
                //业务品种下拉框
                var dataItemsDO = {levels:"1"};
                var data = {dataItemsDO:dataItemsDO}
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
            //联动下拉
            dialogScope.mortgageLevelTwoSource = {};
            dialogScope.mortgageLevelOneName = function (val){
                dialogScope.mortgageList.mortgageLevelTwoName = "";
                if(null != val){
                    var dataItemsDO = {mortgageCode:val}
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
            }
            //查询按钮
            dialogScope.submit_onClick = function(){
                queryMortgageListInfo();
                dialogScope.selected.select = [];
            };
            //重置按钮
            dialogScope.reset_onClick = function(){
                $scope.$apply(function () {
                    dialogScope.mortgageList = {};
                })
            };
            //保存按钮
            dialogScope.save_onClick = function(){
                if(dialogScope.selected.select.length<1){
                    $common.get_tipDialog('请至少选择一条记录!','showInform');
                }else{
                    $scope.datasource.ds.splice(0);
                    for(var i=0;i<dialogScope.selected.select.length;i++){
                        $scope.datasource.ds.push(dialogScope.selected.select[i]);
                    }
                    $scope.conf.totalRecord = dialogScope.selected.select.length;
                    dialogScope.closeThisDialog();
                    $scope.selected.select = [];
                    totPrice();
                }
            };
            //取消按钮
            dialogScope.cancel1_onClick = function(){
                dialogScope.closeThisDialog();
                $scope.selected.select = [];
            };
        }])
    };


    //核价
    $scope.check_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('只能选择一条记录！', 'showInform');
        } else {
            $common.get_ngDialog('../../bas_pbc_mdle/html/qualityApply/qualityApplyCheck.html',$scope,["$scope",function(dialogScope){
                //dialogScope.qualityApplyCheck = {};
                dialogScope.qualityApplyCheck = $scope.selected.select[0];
                dialogScope.confirm_onClick = function(){
                    if($.doValidate("qulityApplyCheckForm")){
                        $scope.selected.select[0] = dialogScope.qualityApplyCheck;
                        $scope.selected.select[0].totPrice = dialogScope.qualityApplyCheck.weightAll * dialogScope.qualityApplyCheck.confirmPrice;
                        $common.get_tipDialog('修改成功！','showSuccess');
                        dialogScope.closeThisDialog();
                        $scope.selected.select=[];
                    }
                }
                dialogScope.cancel_onClick = function(){
                    dialogScope.closeThisDialog();
                    //queryProtocolInfo();
                    $scope.selected.select=[];
                };
            }],"入库押品详细信息");
        }
    };
    //核价已入库押品详情查看按钮
    $scope.enterDetailCheck_onClick = function(){
        $common.get_ngDialog('../../bas_pbc_mdle/html/qualityApply/mortgageEnterList.html',$scope,["$scope",function(dialogScope){
            dialogScope.mortgageList = {slaveContno:$scope.qualityApplyInfo.conId,custcd:gutId,isLocked:"1",stockStatus:"02"};
            dialogScope.datasource = {};
            dialogScope.selected = {select:[]};
            dialogScope.conf = {
                pageNo: 1,
                pageSize: 10
            };
            dialogScope.$watch("conf.pageNo+conf.pageSize", queryMortgageListInfo);

            function queryMortgageListInfo(){
                var data = {
                    pageNo: dialogScope.conf.pageNo,
                    pageSize: dialogScope.conf.pageSize,
                    mortgageEnter: dialogScope.mortgageList
                }
                var promise = $common.get_asyncData("mortgageEnteringService/queryMortgageEnteringListByPage", data);
                promise.then(function (res) {
                    var data;
                    if (res.errorCode == "SUC") {
                        data = res.contextData;
                        dialogScope.datasource.ds = data.records;
                        dialogScope.conf.totalRecord = data.totalRecord;
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                })
            }
            dialogScope.cancel_onClick = function(){
                dialogScope.closeThisDialog();
                dialogScope.selected.select = [];
            }
        }
        ],"押品列表")
    };
    //核价
    $scope.detailApprove_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('只能选择一条记录！', 'showInform');
        } else {
            $common.get_ngDialog('../../bas_pbc_mdle/html/qualityApply/qualityApplyCheck.html',$scope,["$scope",function(dialogScope){
                dialogScope.qualityApplyCheck = $scope.selected.select[0];
                dialogScope.cancel_onClick = function(){
                    dialogScope.closeThisDialog();
                    //queryProtocolInfo();
                    $scope.selected.select=[];
                };
            }],"入库押品详细信息");
        }
    };
};

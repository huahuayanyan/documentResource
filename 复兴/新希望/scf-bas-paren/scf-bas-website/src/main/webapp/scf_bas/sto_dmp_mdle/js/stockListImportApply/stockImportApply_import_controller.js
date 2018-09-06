/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var stockImportApplyImportController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {

    var wData = window.source.otherform; //processTemplateName "StockListImportApply"
    //保存、提交按钮显示
    $scope.Write = false;
    $scope.submitD = true;
    $scope.conditionForm={

    };//初始化查询条件对象
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 20,
        totalRecord: 0};

    if(wData){
        $scope.submitD = false;
        $common.get_asyncData("processService/getCurrentNodeEntity", {pid:wData.piid}).then(function (res) {
            var taskform;
            if (res.errorCode == "SUC") {
                taskform = res.contextData;
                //window.source = $scope.source;
                if(taskform.id == "Write") {//填写岗
                }
                else if(taskform.id == "Approve") {//复核岗
                    $scope.Write = true;
                    //window.Issued = false;
                    //window.Notice = false;
                }
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    }

    //基本信息
    $common.get_asyncData("stockListImportApplyService/getStockImportInfo", {
        appno : wData ? wData.appno : undefined,
        slaveContno : dataDeliver.getter() ? dataDeliver.getter().conId : wData.appno
    }).then(function (res) {
        var baseinfo;
        if (res.errorCode == "SUC") {
            baseinfo = res.contextData;
            $scope.conditionForm = baseinfo;
        } else {
            $common.get_tipDialog(res.errorMsg, 'showInform');
        }
    })

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize", function () {
        $scope.queryTable();
    });
    $scope.queryTable = function(paramData){
        var data= {
            appno : wData ? wData.appno : undefined
        };
        var promise = $common.get_asyncData("stockListImportApplyService/getStockImportList",data);
        promise.then(function(res){
            var gnty;
            if (res.errorCode =="SUC"){
                gnty = res.contextData;
                if(gnty.length > 0){
                    $scope.datasource.ds = gnty;
                    $scope.conf.totalRecord = gnty.length;
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //新增  模拟导入  待功能完善后删除
    $scope.add_onClick = function() {
        $common.get_asyncData("bPbcMtgBaseInfoService/findBPbcMtgBaseInfoBySlaveContno", {slaveContno : $scope.conditionForm.slaveContno})
            .then(function (res) {
                if (res.errorCode == "SUC") {
                    if(res.contextData.length < 1){
                        $common.get_tipDialog('找不到库存信息', 'showInform');
                    }else{
                        for(var i = 0;i < res.contextData.length;i++){//设置押品数量
                            res.contextData[i].nowQuantity = res.contextData[i].quantity;
                            res.contextData[i].quantity = 0;
                            res.contextData[i].remainQuantity = res.contextData[i].nowQuantity;
                        }
                        $scope.datasource.ds = res.contextData;
                        $scope.conf.totalRecord = res.contextData.length;
                    }
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showInform');
                }
            })
    };

    //修改
    $scope.modify_onClick = function() {
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        } else {
            $common.get_ngDialog('stockListImportApply/stockImportMortInfo.html', $scope
                ,["$scope",function(dialogScope){
                    stockImportMortInfoController(dialogScope,$scope,$common,"modify",$scope.selected.select[0]);
                }],"修改在库押品",{showClose:true});
        }
    };

    //删除
    $scope.delete_onClick = function() {
        for(var i = 0;i < $scope.selected.select.length; i++){
            for(var j in $scope.datasource.ds){
                if($scope.datasource.ds[j].mortgageNo == $scope.selected.select[i].mortgageNo){
                    $scope.datasource.ds.splice(j, 1);
                    break;
                }
            }
        }
        $scope.selected.select = [];
        $scope.conf.totalRecord = $scope.datasource.ds.length;
        $scope.$apply();
    };

    //保存
    $scope.save_onClick = function() {
        if($scope.datasource.ds.length < 1){
            $common.get_tipDialog('请添加库存信息！', 'showInform');
            return;
        }
        var data = {
            appliInfo : $scope.conditionForm,
            list : $scope.datasource.ds
        }

        $common.get_asyncData("stockListImportApplyService/stockListImportSaveUpdater", data)
            .then(function (res) {
                if (res.errorCode == "SUC") {
                    $scope.conditionForm.appno = res.contextData.value;
                    $scope.submitD = false;
                    $common.get_asyncData("bPbcAppliBaseInfoService/findBPbcAppliBaseInfoByKey",{"key":res.contextData.value})
                        .then(function(res){
                            if (res.errorCode =="SUC"){
                                window.source = {otherform:res.contextData};
                                wData = window.source.otherform;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        });
                    $common.get_tipDialog('保存成功！', 'showInform');
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showInform');
                }
            })
    };

    //提交
    $scope.submit_onClick = function() {
        if($scope.datasource.ds.length < 1){
            $common.get_tipDialog('请添加库存信息！', 'showInform');
            return;
        }
        var data = {
            appliInfo : $scope.conditionForm,
            list : $scope.datasource.ds
        }

        $common.get_asyncData("stockListImportApplyService/StockListImportWriteSubmitUpdate", data)
            .then(function (res) {
                if (res.errorCode == "SUC") {
                    $scope.conditionForm.appno = res.contextData.value;
                    $common.get_tipDialog('提交成功！', 'showInform');
                    $scope.Write = true;
                    if($state.current.name=="stockImportApply.import")$state.go("stockListImportApply");
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showInform');
                }
            })
    };
};

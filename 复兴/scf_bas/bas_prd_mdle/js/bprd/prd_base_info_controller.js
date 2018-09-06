/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var PrdBaseInfoController = function ($scope, $common, $state, dataDeliver) {
    //prdBaseForm,induestryForm(induestryTypeName),costDatasource,costSelected,costConf,
    // warnDatasource,warnSelected,warnConf,former,next,complete
    var data1 = dataDeliver.getter();
    var flag1 = data1.flag;
    var productId = data1.productId;

    if (productId != "") {//只有有产品号才可以进行一下的操作。
        if (flag1 == "add") { //新增的时候，页面的完成按钮是隐藏的
            $scope.hide = true;
        }
        $scope.prdBaseForm = {
            productId: productId
        };
        $scope.industryForm = {
            productId: productId
        };
        $scope.costDatasource = {
            ds: []
        };
        $scope.costSelected = {
            select: []
        };
        $scope.warnDatasource = {
            ds: []
        };
        $scope.warnSelected = {
            select: []
        };
        $scope.costConf = {//初始化费用分页对象
            pageNo: 1,
            pageSize: 10,
            totalRecord: 0
        }
        $scope.warnConf = {//初始化预警分页对象 warnDatasource
            pageNo: 1,
            pageSize: 10,
            totalRecord: 0
        }
        var bPrdBaseInfo = {
            productId: productId
        }
        var bPrdIndustryType = {
            productId: productId
        }

        //-----------------------页面产品基本信息的查询赋值-----------------
        var promise1 = $common.get_asyncData("bPrdBaseInfoService/findBPrdBaseInfoByKey", {bPrdBaseInfo: bPrdBaseInfo});
        promise1.then(function (res) {
            if (res.errorCode == "SUC") {
                $scope.prdBaseForm = res.contextData;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
        //-----------------------页面准入行业信息的查询赋值-----------------
        var promise = $common.get_asyncData("bPrdIndustryTypeService/findBPrdIndustryTypeByKey", {bPrdIndustryType: bPrdIndustryType});
        promise.then(function (res) {
            if (res.errorCode == "SUC") {
                $scope.industryForm = res.contextData;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });

        //-----------------------------------费用绑定信息表，监听分页 costConf,warnConf
        $scope.$watch("costConf.pageNo+costConf.pageSize", function () {
            $scope.queryCostTable();
        });
        //费用查询操作（用于页面初始化和新增完成之后的刷新）
        var bPrdCostBind = {//要把对应的产品号放进去
            productId: productId,
        };
        $scope.queryCostTable = function (paramData) {
            var data2 = {
                pageNo: $scope.costConf.pageNo,
                pageSize: $scope.costConf.pageSize,
                value: bPrdCostBind
            };
            var promise2 = $common.get_asyncData("bPrdCostBindService/selectBPrdCostBindByPage", data2);
            promise2.then(function (res) {
                var data3;
                if (res.errorCode == "SUC") {
                    data3 = res.contextData;
                    $scope.costDatasource.ds = data3.records;
                    $scope.costConf.totalRecord = data3.totalRecord;
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        };

        //------------------------------------风险绑定信息表，监听分页 costConf,warnConf
        $scope.$watch("warnConf.pageNo+warnConf.pageSize", function () {
            $scope.queryWarnTable();
        });
        //费用查询操作（用于页面初始化和新增完成之后的刷新）
        var bPrdWarnBind = {//要把对应的产品号放进去
            productId: productId,
        };
        $scope.queryWarnTable = function (paramData) {
            var data4 = {
                pageNo: $scope.warnConf.pageNo,
                pageSize: $scope.warnConf.pageSize,
                value: bPrdWarnBind
            };
            var promise3 = $common.get_asyncData("bPrdWarnBindService/selectBPrdWarnBindByPage", data4);
            promise3.then(function (res) {
                var data5;
                if (res.errorCode == "SUC") {
                    data5 = res.contextData;
                    $scope.warnDatasource.ds = data5.records;
                    $scope.warnConf.totalRecord = data5.totalRecord;
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        };
        //------------------------------------点击事件--------------------------------------
        //页面行业选择，choose
        $scope.choose_onClick = function () {
                $common.get_ngDialog('bprd/industry_choose.html', $scope
                    , ["$scope", function (dialogScope) {
                        IndustryChooseController(dialogScope, $scope, $common, $state, dataDeliver);
                    }], "选择准入行业", {showClose: true});

        }
        //费用新增按钮
        $scope.costAdd_onClick = function () {
            $common.get_ngDialog('bprd/cost_bind_add.html', $scope
                , ["$scope", function (dialogScope) {
                    CostBindAddController(dialogScope, $scope, $common, $state, dataDeliver);
                }], "新增费用关联信息", {showClose: true});
        };
        //费用删除按钮    costAdd，costDelete，warnAdd，warnDelete，former，next，complete,costSelected,warnSelected
        $scope.costDelete_onClick = function () {
            if ($scope.costSelected.select.length == 1) {
                $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
                    var id = $scope.costSelected.select[0].id;
                    var primiseA = $common.get_asyncData('bPrdCostBindService/delete', {id: id})
                    primiseA.then(function (res) {
                        if (res.errorCode == "SUC") {
                            $scope.queryCostTable();
                            $scope.costSelected.select = [];
                            $common.get_tipDialog('删除成功！', 'showSuccess');
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showError');
                        }
                    });
                });
            } else {
                $common.get_tipDialog('请选择一条记录！', 'showInform');
            }
        }
        //风险新增按钮
        $scope.warnAdd_onClick = function () {
            $common.get_ngDialog('bprd/warn_bind_add.html', $scope
                , ["$scope", function (dialogScope) {
                    WarnBindAddController(dialogScope, $scope, $common, $state, dataDeliver);
                }], "新增风险关联信息", {showClose: true});
        };

        //风险删除按钮    costAdd，costDelete，warnAdd，warnDelete，former，next，complete,costSelected,warnSelected
        $scope.warnDelete_onClick = function () {
            if ($scope.warnSelected.select.length == 1) {
                $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
                    var id = $scope.warnSelected.select[0].id;
                    var primiseB = $common.get_asyncData('bPrdWarnBindService/delete', {id: id})
                    primiseB.then(function (res) {
                        if (res.errorCode == "SUC") {
                            $scope.queryWarnTable();
                            $scope.warnSelected.select = [];
                            $common.get_tipDialog('删除成功！', 'showSuccess');
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showError');
                        }
                    });
                });
            } else {
                $common.get_tipDialog('请选择一条记录！', 'showInform');
            }
        }

        //----------------------------------上一步，下一步，完成--------------------------------------former，next，complete
        //----------点击上一步-----------------------
        $scope.former_onClick = function () {
            if ($.doValidate("prdBaseForm")) {//校验数据
                var bPrdBaseInfo = $scope.prdBaseForm;
                if (flag1 == "add") {
                    var primise = $common.get_asyncData("bPrdBaseInfoService/add", {bPrdBaseInfo: bPrdBaseInfo});
                    primise.then(function (res) {
                        if (res.errorCode == "SUC") {
                            $state.go("tree.prdInfoAdd");
                            $scope.$parent.panes.forEach(function(pane){
                                if (pane.uiSref == "tree.prdInfoAdd"){
                                    $scope.$parent.select(pane);
                                };
                            });
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showError');
                        }
                    });
                } else if (flag1 == "update") {
                    var primise = $common.get_asyncData("bPrdBaseInfoService/update", {bPrdBaseInfo: bPrdBaseInfo});
                    primise.then(function (res) {
                        if (res.errorCode == "SUC") {
                            $state.go("tree.prdInfoAdd");
                            $scope.$parent.panes.forEach(function(pane){
                                if (pane.uiSref == "tree.prdInfoAdd"){
                                    $scope.$parent.select(pane);
                                };
                            });
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showError');
                        }
                    });
                }
            } else {
                $common.get_tipDialog("页面数据有误！", 'showError');
            }
        }

        //----------点击下一步---------------------
        $scope.next_onClick = function () {
            if ($.doValidate("prdBaseForm")) {//校验数据
                var bPrdBaseInfo = $scope.prdBaseForm;
                if (flag1 == "add") {
                    var primise = $common.get_asyncData("bPrdBaseInfoService/add", {bPrdBaseInfo: bPrdBaseInfo});
                    primise.then(function (res) {
                        if (res.errorCode == "SUC") {
                            $state.go("tree.prdCreditPly");
                            $scope.$parent.panes.forEach(function(pane){
                                if (pane.uiSref == "tree.prdCreditPly"){
                                    $scope.$parent.select(pane);
                                };
                            });
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showError');
                        }
                    });
                } else if (flag1 == "update") {
                    var primise = $common.get_asyncData("bPrdBaseInfoService/update", {bPrdBaseInfo: bPrdBaseInfo});
                    primise.then(function (res) {
                        if (res.errorCode == "SUC") {
                            $state.go("tree.prdCreditPly");
                            $scope.$parent.panes.forEach(function(pane){
                                if (pane.uiSref == "tree.prdCreditPly"){
                                    $scope.$parent.select(pane);
                                };
                            });
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showError');
                        }
                    });
                }
            } else {
                $common.get_tipDialog("页面数据有误！", 'showError');
            }
        }
        //------------------点击完成（新增的时候是没有完成按钮的 ）------------------
        $scope.complete_onClick = function () {
            if ($.doValidate("prdBaseForm")) {//校验数据
                var bPrdBaseInfo = $scope.prdBaseForm;
                var primise = $common.get_asyncData("bPrdBaseInfoService/update", {bPrdBaseInfo: bPrdBaseInfo});
                primise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        $state.go("tree.prdReportInfo");
                        $scope.$parent.panes.forEach(function(pane){
                            if (pane.uiSref == "tree.prdReportInfo"){
                                $scope.$parent.select(pane);
                            };
                        });
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
            } else {
                $common.get_tipDialog("页面数据有误！", 'showError');
            }
        }
    } else {
        $common.get_tipDialog('产品号丢失，请重新进入产品工厂！', 'showError');
    }
}

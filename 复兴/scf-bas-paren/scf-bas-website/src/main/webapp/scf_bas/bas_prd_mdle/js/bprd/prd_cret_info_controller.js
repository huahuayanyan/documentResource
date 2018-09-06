/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var PrdCretInfoController = function ($scope, $common, $state, dataDeliver) {
    //prdBaseForm,induestryForm(induestryTypeName),costDatasource,costSelected,costConf,
    // warnDatasource,warnSelected,warnConf,former,next,complete
    var data1 = dataDeliver.getter();
    var flag1 = data1.flag;
    var productId = data1.productId;

    if (productId != "") {//只有有产品号才可以进行一下的操作。
        if (flag1 == "add") { //新增的时候，页面的完成按钮是隐藏的
            $scope.hide = true;
        }
        $scope.prdCreditPlyForm = {
            productId: productId,
        };
        $scope.receMatlDatasource = {
            ds: [],
            receMatlId: "",
        };
        $scope.receMatlSelected = {
            select: []
        };
        $scope.bizSurBindDatasource = {
            ds: []
        };
        $scope.bizSurBindSelected = {
            select: []
        };
        $scope.receMatlConf = {//初始化应收材料分页对象
            pageNo: 1,
            pageSize: 10,
            totalRecord: 0
        }
        $scope.bizSurBindConf = {//初始化业务调查材料分页对象 warnDatasource
            pageNo: 1,
            pageSize: 10,
            totalRecord: 0
        }

        //-----------------------页面准入条件信息的查询赋值-----------------
        var promise = $common.get_asyncData("bPrdCreditPlyService/findBPrdCreditPlyByProductId", {bPrdCreditPly: $scope.prdCreditPlyForm});
        promise.then(function (res) {
            if (res.errorCode == "SUC") {
                $scope.prdCreditPlyForm=res.contextData;

            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });

        //-----------------------------------应收材料绑定信息表，监听分页 receMatlConf,bizSurConf
        $scope.$watch("receMatlConf.pageNo+receMatlConf.pageSize", function () {
            $scope.queryReceMatlTable();
        });

        $scope.queryReceMatlTable = function () {
            var promise2 = $common.get_asyncData("bPrdReceMatlBindService/findBPrdReceMatlBindByProductId", {productId: productId});
            promise2.then(function (res) {
                var data;
                if (res.errorCode == "SUC") {
                    data = res.contextData;
                    var idList = [];
                    for (var i = 0; i < data.length; i++) {
                        idList[i] = data[i].receMatlId;
                    }
                    var data1 = {
                        pageNo: $scope.receMatlConf.pageNo,
                        pageSize: $scope.receMatlConf.pageSize,
                        idList: idList
                    };
                    var promise3 = $common.get_asyncData("bPrdReceMatlService/selectByIdListToPage", data1);
                    promise3.then(function (res2) {
                        var data2;
                        if (res2.errorCode == "SUC") {
                            data2 = res2.contextData;
                            $scope.receMatlDatasource.ds = data2.records;
                            $scope.receMatlConf.totalRecord = data2.totalRecord;
                        } else {
                            $common.get_tipDialog(res2.errorMsg, 'showError');
                        }
                    });
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        };
        //------------------------------------业务调查绑定信息表，监听分页

        $scope.$watch("bizSurBindConf.pageNo+bizSurBindConf.pageSize", function () {
            $scope.queryBizSurBindTable();
        });
        var bPrdBizSurBind = {//要把对应的产品号放进去
            productId: productId,
        };
        $scope.queryBizSurBindTable = function (paramData) {
            var data4 = {
                pageNo: $scope.bizSurBindConf.pageNo,
                pageSize: $scope.bizSurBindConf.pageSize,
                value: bPrdBizSurBind
            };
            var promise3 = $common.get_asyncData("bPrdBizSurBindService/findBPrdBizSurBindByPage", data4);
            promise3.then(function (res) {
                var data5;
                if (res.errorCode == "SUC") {
                    data5 = res.contextData;
                    $scope.bizSurBindDatasource.ds = data5.records;
                    $scope.bizSurBindConf.totalRecord = data5.totalRecord;
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        };
        //------------------------------------点击事件--------------------------------------

        //应收材料关联信息新增按钮
        $scope.receMatlAdd_onClick = function () {
            $common.get_ngDialog('bprd/rece_matl_bind_add.html', $scope
                , ["$scope", function (dialogScope) {
                    ReceMatlBindAddController(dialogScope, $scope, $common, $state, dataDeliver);
                }], "新增应收材料关联信息", {showClose: true});
        };
        //应收材料关联信息删除按钮
        $scope.receMatlDelete_onClick = function () {
            if ($scope.receMatlSelected.select.length == 1) {
                $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
                    var receMatlId = $scope.receMatlSelected.select[0].id;
                    var primiseA = $common.get_asyncData('bPrdReceMatlBindService/deleteByReceMatlId', {receMatlId: receMatlId})
                    primiseA.then(function (res) {
                        if (res.errorCode == "SUC") {
                            $scope.queryReceMatlTable();
                            $scope.receMatlSelected.select = [];
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
        //业务调查新增按钮
        $scope.bizSurBindAdd_onClick = function () {
            $common.get_ngDialog('bprd/biz_sur_bind_add.html', $scope
                , ["$scope", function (dialogScope) {
                    BizSurBindAddController(dialogScope, $scope, $common, $state, dataDeliver);
                }], "新增业务调查关联信息", {showClose: true});
        };

        //业务调查删除按钮
        $scope.bizSurBindDelete_onClick = function () {
            if ($scope.bizSurBindSelected.select.length == 1) {
                $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
                    var id = $scope.bizSurBindSelected.select[0].id;
                    var primiseB = $common.get_asyncData('bPrdBizSurBindService/delete', {id: id})
                    primiseB.then(function (res) {
                        if (res.errorCode == "SUC") {
                            $scope.queryBizSurBindTable();
                            $scope.bizSurBindSelected.select = [];
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
        //---------------------点击上一步------------------------
        $scope.former_onClick = function () {
            var bPrdCreditPly = {
                productId: productId,
                entAcs: $scope.prdCreditPlyForm.entAcs,
                //修改时需要id
                id: $scope.prdCreditPlyForm.id,
            }
            if (flag1 == "add") {
                var primise = $common.get_asyncData("bPrdCreditPlyService/add", {bPrdCreditPly: bPrdCreditPly});
                primise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        $state.go("tree.prdBaseInfo");
                        $scope.$parent.panes.forEach(function(pane){
                            if (pane.uiSref == "tree.prdBaseInfo"){
                                $scope.$parent.select(pane);
                            };
                        });
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
            } else if (flag1 == "update") {
                var primise = $common.get_asyncData("bPrdCreditPlyService/update", {bPrdCreditPly: bPrdCreditPly});
                primise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        $state.go("tree.prdBaseInfo");
                        $scope.$parent.panes.forEach(function(pane){
                            if (pane.uiSref == "tree.prdBaseInfo"){
                                $scope.$parent.select(pane);
                            };
                        });
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
            }

        }
        //-----------------点击下一步-----------------
        $scope.next_onClick = function () {
            var bPrdCreditPly = {
                productId: productId,
                entAcs: $scope.prdCreditPlyForm.entAcs,
                id: $scope.prdCreditPlyForm.id,
            }
            if (flag1 == "add") {
                var primise = $common.get_asyncData("bPrdCreditPlyService/add", {bPrdCreditPly: bPrdCreditPly});
                primise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        $state.go("tree.prdIcrSetInfo");
                        $scope.$parent.panes.forEach(function(pane){
                            if (pane.uiSref == "tree.prdIcrSetInfo"){
                                $scope.$parent.select(pane);
                            };
                        });
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
            } else if (flag1 == "update") {
                var primise = $common.get_asyncData("bPrdCreditPlyService/update", {bPrdCreditPly: bPrdCreditPly});
                primise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        $state.go("tree.prdIcrSetInfo");
                        $scope.$parent.panes.forEach(function(pane){
                            if (pane.uiSref == "tree.prdIcrSetInfo"){
                                $scope.$parent.select(pane);
                            };
                        });
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
            }
        }
        //------------------点击完成（新增的时候是没有完成按钮的 ）------------------
        $scope.complete_onClick = function () {
            var bPrdCreditPly = $scope.prdCreditPlyForm;
            var primise = $common.get_asyncData("bPrdCreditPlyService/update", {bPrdCreditPly: bPrdCreditPly});
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
        }
    } else {
        $common.get_tipDialog('产品号丢失，请重新进入产品工厂！', 'showError');
    }
}

/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var PrdCopLibBindInfoController = function ($scope, $common, $state, dataDeliver) {
    var data1 = dataDeliver.getter();
    var flag1 = data1.flag;
    var productId = data1.productId;

    if (productId != "") {//只有有产品号才可以进行一下的操作。
        if (flag1 == "add") { //新增的时候，页面的完成按钮是隐藏的
            $scope.hide = true;
        }
        $scope.conditionForm = {
            productId: productId
        };

        $scope.datasource = {
            ds: [],
        };
        $scope.selected = {
            select: []
        };

        $scope.conf = {//初始化分页对象 datasource
            pageNo: 1,
            pageSize: 10,
            totalRecord: 0
        };

        //-----------------------------------监听分页 conf
        $scope.$watch("conf.pageNo+conf.pageSize", function () {
            $scope.queryTable();
        });
        //点击查询之后的搜索
        $scope.submit_onClick = function () {
            $scope.queryTable();
            $scope.selected.select = [];
        };
        //清空操作
        $scope.rebort_onClick = function () {
            $scope.conditionForm = {productId: productId};
            $scope.queryTable();
        };
        //查询操作
        $scope.queryTable = function (paramData) {
            var data = {
                pageNo: $scope.conf.pageNo,
                pageSize: $scope.conf.pageSize,
                value: $scope.conditionForm,

            };
            var promise = $common.get_asyncData("bPrdCopLibBindService/findBPrdCopLibBindByPage", data);
            promise.then(function (res) {
                var data2;
                if (res.errorCode == "SUC") {
                    data2 = res.contextData;
                    $scope.datasource.ds = data2.records;
                    $scope.conf.totalRecord = data2.totalRecord;
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        };
        //------------------------------------点击事件--------------------------------------

        //组件关联信息新增按钮
        $scope.add_onClick = function () {
            $common.get_ngDialog('bprd/cop_lib_bind_add.html', $scope
                , ["$scope", function (dialogScope) {
                    CopLibBindAddController(dialogScope, $scope, $common, $state, dataDeliver);
                }], "新增组件关联信息", {showClose: true});
        };

        //组件关联信息删除 根据主键ID
        $scope.delete_onClick = function () {
            if ($scope.selected.select.length == 1) {
                $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
                    var id = $scope.selected.select[0].id;//定义选中组件的组件id
                    var primiseA = $common.get_asyncData('bPrdCopLibBindService/delete', {id: id});
                    primiseA.then(function (res) {
                        if (res.errorCode == "SUC") {
                            $scope.queryTable();
                            $scope.selected.select = [];
                            $common.get_tipDialog('删除成功！', 'showSuccess');
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showError');
                        }
                    });
                });
            } else {
                $common.get_tipDialog('请选择一条记录！', 'showInform');
            }
        };

        //----------------------------------上一步，下一步，完成--------------------------------------former，next，complete
        //---------------------点击上一步-----------
        $scope.former_onClick = function () {
            $state.go("tree.prdIcrSetInfo");
            $scope.$parent.panes.forEach(function (pane) {
                if (pane.uiSref == "tree.prdIcrSetInfo") {
                    $scope.$parent.select(pane);
                };
            });
        };
        //-----------------点击下一步-----------------
        $scope.next_onClick = function () {
            $state.go("tree.prdReportInfo");
            $scope.$parent.panes.forEach(function (pane) {
                if (pane.uiSref == "tree.prdReportInfo") {
                    $scope.$parent.select(pane);
                };
            });
        };
        //------点击完成（新增的时候是没有完成按钮的 ）--------
        $scope.complete_onClick = function () {
            $state.go("tree.prdReportInfo");
            $scope.$parent.panes.forEach(function (pane) {
                if (pane.uiSref == "tree.prdReportInfo") {
                    $scope.$parent.select(pane);
                } ;
            });
        };
    } else {
        $common.get_tipDialog('产品号丢失，请重新进入产品工厂！', 'showError');
    }
};

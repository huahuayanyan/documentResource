/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var PrdReportInfoController = function ($scope, $common, $state, dataDeliver) {
    /*otherform,prdBaseForm,industryForm,
     costDatasource,warnDatasource,receMatlDatasource,
     prdCreditPlyForm,bizSurBindDatasource,icrDatasource,
     copDatasource
     */
    var data1 = dataDeliver.getter();
    var flag1 = data1.flag;
    var productId = data1.productId;

    if (productId != "") {//只有有产品号才可以进行一下的操作。
        $scope.otherform = {};

        //产品大类
        $scope.parentId = {ds: []};

        $scope.prdBaseForm = {};
        $scope.industryForm = {};
        $scope.prdCreditPlyForm = {};
        $scope.receMatlDatasource = {
            ds: []
        };

        $scope.bizSurBindDatasource = {
            ds: []
        };

        $scope.icrDatasource = {
            ds: []
        };

        $scope.copDatasource = {
            ds: []
        };
        $scope.copSelected = {
            select: []
        };
        $scope.costDatasource = {
            ds: []
        };

        $scope.warnDatasource = {
            ds: []
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
        $scope.icrConf = {//初始化额度设置分页对象 warnDatasource
            pageNo: 1,
            pageSize: 10,
            totalRecord: 0
        }
        $scope.copConf = {//初始化组件定义分页对象 warnDatasource
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
        

        /****--------------------产品概要查询------------------*******/
        var bPrdInfo = {
            productId: data1.productId
        };
        var primise = $common.get_asyncData("bPrdInfoService/findBPrdInfoByKey", {bPrdInfo: bPrdInfo});
        primise.then(function (res) {
            if (res.errorCode == "SUC") {
                if (res.contextData != "" && res.contextData != null) {
                    $scope.otherform = res.contextData;
                }

                //产品大类查询
                var bPrdInfo1 = {
                     productId: $scope.otherform.parentId,
                }
                var promise1 = $common.get_asyncData("bPrdInfoService/findBPrdInfoByBPrd", {bPrdInfo: bPrdInfo1});
                promise1.then(function (res1) {
                    if (res1.errorCode == "SUC") {
                        $scope.parentId.ds = res1.contextData;
                    } else {
                        $common.get_tipDialog(res1.errorMsg, 'showError');
                    }
                });
            }
            else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });


        /*****----------------------页面产品基本信息的查询赋值-----------------****/
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

        //-----------------------页面准入条件信息的查询赋值-----------------
        var bPrdCreditPly = {
            productId: productId,
        }
        var promise = $common.get_asyncData("bPrdCreditPlyService/findBPrdCreditPlyByProductId", {bPrdCreditPly: bPrdCreditPly});
        promise.then(function (res) {
            if (res.errorCode == "SUC") {
                $scope.prdCreditPlyForm = res.contextData;

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

        /****----------------产品额度查询操作---------------***/
        $scope.$watch("icrConf.pageNo+icrConf.pageSize", function () {
            $scope.queryIcrTable();
        });
        $scope.queryIcrTable = function (paramData) {
            var bPrdCreditBind = {
                productId: productId,
                productName: data1.productName,
            };
            var data4 = {
                pageNo: $scope.icrConf.pageNo,
                pageSize: $scope.icrConf.pageSize,
                value: bPrdCreditBind
            };
            var promise = $common.get_asyncData("bPrdCreditBindService/findBPrdCreditBindByPage", data4);
            promise.then(function (res) {
                if (res.errorCode == "SUC") {
                    var data5 = res.contextData;
                    $scope.icrDatasource.ds = data5.records;
                    $scope.icrConf.totalRecord = data5.totalRecord;

                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        }

        /****----------------组件定义查询操作---------------***/

        $scope.$watch("copConf.pageNo+copConf.pageSize", function () {
            $scope.queryCopTable();
        });
        $scope.queryCopTable = function (paramData) {
            var bPrdCopLibBind = {
                productId: productId
            }
            var data4 = {
                pageNo: $scope.copConf.pageNo,
                pageSize: $scope.copConf.pageSize,
                value: bPrdCopLibBind
            };
            var promise = $common.get_asyncData("bPrdCopLibBindService/findBPrdCopLibBindByPage", data4);
            promise.then(function (res) {
                if (res.errorCode == "SUC") {
                    var data5 = res.contextData;
                    $scope.copDatasource.ds = data5.records;
                    $scope.copConf.totalRecord = data5.totalRecord;
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        }
        /**********----------------------------------完成-----------------------------******/

        $scope.complete_onClick = function () {//点击完成
            $state.go("prdInfo");
        }
    } else {
        $common.get_tipDialog('产品号丢失，请重新进入产品工厂！', 'showError');
    }
}

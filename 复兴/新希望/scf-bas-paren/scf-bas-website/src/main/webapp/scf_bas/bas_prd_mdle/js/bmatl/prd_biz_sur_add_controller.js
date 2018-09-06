/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */
var PrdBizSurAddController = function (dialogScope, parentScope, $common, flag, row) {
    dialogScope.otherform = {//初始化
        productId: "",
    };
    if (flag == "update") {//根据客户号修改
        dialogScope.otherform = $common.copy(parentScope.selected.select[0]);
    } else if (flag == "view") {//查看的时候，只读，确定按钮隐藏。
        dialogScope.otherform = row;
        dialogScope.disable = true;
        dialogScope.hide = true;
    }

    dialogScope.productNameContent = {
        type: "table",//展示类型table  tree
        url: "bPrdInfoService/selectBPrdInfoBySelect",//请求url
        //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split: "-",//分隔符
        extentColumn: "productName",
        column: ["productId", "productName"]//展示内容
    };
    dialogScope.productNameExtent = function (ds) {
        dialogScope.otherform.productId = ds.productId;
    };
    dialogScope.$watch("otherform.productName", function () {
        dialogScope.productNameContent.param = {
            productName: dialogScope.otherform.productName,
            productType: "000",
        }
    });
    dialogScope.confirm_onClick = function () {
        if ($.doValidate("otherform")) {//校验数据格式
            if (flag == "add") {
                var primise = $common.get_asyncData("bPrdBizSurService/add", {bPrdBizSur: dialogScope.otherform});
                primise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        parentScope.queryTable();
                        parentScope.selected.select = [];
                        dialogScope.closeThisDialog();
                        $common.get_tipDialog('新增成功！', 'showSuccess');

                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });

            } else if (flag == "update") {
                var primise = $common.get_asyncData("bPrdBizSurService/update", {bPrdBizSur: dialogScope.otherform});
                primise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        parentScope.queryTable();
                        parentScope.selected.select = [];
                        dialogScope.closeThisDialog();
                        $common.get_tipDialog('修改成功！', 'showSuccess');
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
            }
        }
        else {
            $common.get_tipDialog("页面数据格式错误！", 'showError');
        }
    }
    dialogScope.closeThisDialog_onClick = function () {
        dialogScope.closeThisDialog();
    }
}


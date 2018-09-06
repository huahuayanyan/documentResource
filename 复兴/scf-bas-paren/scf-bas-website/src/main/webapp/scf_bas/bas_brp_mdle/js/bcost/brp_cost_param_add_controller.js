/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */
var BrpCostParamAddController = function (dialogScope, parentScope, $common, flag, row) {
    dialogScope.otherform = {};
    if (flag == "update") {
        dialogScope.disable1 = true;
        row = $common.copy(parentScope.selected.select[0]);
        query(row);
        parentScope.queryTable();
    }
    if (flag == "view") {//查看的时候，只读，确定按钮隐藏。
        query(row);
        parentScope.queryTable();
        dialogScope.disable = true;
        dialogScope.disable1 = true;
        dialogScope.hide = true;

    }
    //将costClass，costType，costCalcType，chargeType转换为数据字典的数据，并进行切割，用于复选框内容回显
    function query(row) {
      var bBrpCostParam={ id:row.id};
        var promise = $common.get_asyncData("bBrpCostParamService/findBBrpCostParamByKey",{bBrpCostParam:bBrpCostParam});
        promise.then(function(res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                if ( data != null) {
                    // 收取种类：1-整体、2-单张
                    var costClass = null;
                    if (data.costClass == "10") {
                        costClass = "1";
                    } else if (data.costClass == "01") {
                        costClass = "2";
                    } else if (data.costClass == "11") {
                        costClass = "1,2";
                    }
                    // 收取方式 第1位-先收；第2位-后收；第3位-免收
                    var costType = null;
                    if (data.costType == "100") {
                        costType = "1";
                    } else if (data.costType == "010") {
                        costType = "2";
                    } else if (data.costType == "001") {
                        costType = "3";
                    } else if (data.costType == "101") {
                        costType = "1,3";
                    } else if (data.costType == "111") {
                        costType = "1,2,3";
                    } else if (data.costType == "110") {
                        costType = "1,2";
                    } else if (data.costType == "011") {
                        costType = "2,3";
                    }
                    // 计算方式 第1位-固定、第2位-按比率
                    var costCalcType = null;
                    if (data.costCalcType == "10") {
                        costCalcType = "1";
                    } else if (data.costCalcType == "11") {
                        costCalcType = "1,2";
                    } else if (data.costCalcType == "01") {
                        costCalcType = "2";
                    }
                    // 扣取方式 第1位-外扣，第2位-内收
                    var chargeType = null;
                    if (data.chargeType == "10") {
                        chargeType = "1";
                    } else if (data.chargeType == "11") {
                        chargeType = "1,2";
                    } else if (data.chargeType == "01") {
                        chargeType = "2";
                    }
                    dialogScope.otherform = data;
                    dialogScope.otherform.costClass = costClass.split(",");
                    dialogScope.otherform.costType = costType.split(",");
                    dialogScope.otherform.costCalcType = costCalcType.split(",");
                    dialogScope.otherform.chargeType = chargeType.split(",");
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }

    dialogScope.confirm_onClick = function () {
        if ($.doValidate("otherform")) {//校验数据格式
            var costClass = dialogScope.otherform.costClass;
            var costType = dialogScope.otherform.costType;
            var costCalcType = dialogScope.otherform.costCalcType;
            var chargeType = dialogScope.otherform.chargeType;
            if(costClass.length==0)
            {
                $common.get_tipDialog('“允许收取种类”不能为空！', 'showError');
                return;
            }
            if(costType.length==0)
            {
                $common.get_tipDialog('“收取方式”不能为空！', 'showError');
                return;
            }
            if(costCalcType.length==0)
            {
                $common.get_tipDialog('“计算方式”不能为空！', 'showError');
                return;
            }
            if(chargeType.length==0)
            {
                $common.get_tipDialog('“扣取方式”不能为空！', 'showError');
                return;
            }
            var minRate = dialogScope.otherform.minRate;
            var maxRate = dialogScope.otherform.maxRate;
            if(minRate.length>6)
            {
                $common.get_tipDialog('“最小比率”输入超过限值，请重新输入！', 'showError');
                return;
            }
            if(maxRate.length>6)
            {
                $common.get_tipDialog('“最大比率”输入超过限值，请重新输入！', 'showError');
                return;
            }
            if(maxRate<minRate){
            	$common.get_tipDialog('最小比率不能大于最大比率！', 'showError');
            	return;
            }
            if (flag == "add") {
                var primise = $common.get_asyncData("bBrpCostParamService/add", {bBrpCostParam: dialogScope.otherform});
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
            }
            else if (flag == "update") {
                var primise = $common.get_asyncData("bBrpCostParamService/update", {bBrpCostParam: dialogScope.otherform});
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
    }
    dialogScope.closeThisDialog_onClick = function () {
        dialogScope.closeThisDialog();
    };
};

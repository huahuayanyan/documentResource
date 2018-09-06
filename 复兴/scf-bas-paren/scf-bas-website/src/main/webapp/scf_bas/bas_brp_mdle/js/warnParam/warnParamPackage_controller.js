/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/29
 */

var warnParampackageController = function(dialogScope,parentScope,$common,dataDeliver,flag) {
    dialogScope.warnParamForm={};
    var deliverData = dataDeliver.getter();


    if(flag == "add"){
        dialogScope.warnParamForm.superId =deliverData.superId;
    }else if (flag == "update"){
        var data={
            key:deliverData.id
        };
        queryWarnParamPackage(data);
        //设置只读
        dialogScope.updateDisable=true;//
        
    }



   //根据ID加载 预警参数设置分类信息
    function queryWarnParamPackage(data){

        var promise=$common.get_asyncData("warnParamMngService/findBBrpPageParamPackageByKey",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                dialogScope.warnParamForm=data;

            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    //确定按钮
    dialogScope.save_onClick = function(){
        if($.doValidate("warnParamForm")) {

            var data = {
                bBrpPageParamPackage: dialogScope.warnParamForm
            };
            if(flag == "add"){
                //新增信息保存
                var primise = $common.get_asyncData("warnParamMngService/addBBrpPageParamPackage", data);
            }else if (flag == "update"){
                var primise = $common.get_asyncData("warnParamMngService/updateBBrpPageParamPackage", data);
            }
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    $common.get_tipDialog('保存成功！', 'showSuccess');
                    dialogScope.closeThisDialog();
                    parentScope.queryTable();//
                    parentScope.queryTree();
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        }
    };
    //返回
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };

    //表格--------结束-------------------------
};

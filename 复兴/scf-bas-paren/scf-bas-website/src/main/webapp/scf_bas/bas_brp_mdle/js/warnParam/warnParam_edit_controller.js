/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/29
 */

var warnParamEditController = function(dialogScope,parentScope,$common,dataDeliver,flag) {
    dialogScope.warnParamForm={};
    var deliverData = dataDeliver.getter();


    if(flag == "add"){
        dialogScope.warnParamForm.packageId =deliverData.packageId;
    }else if (flag == "update"){
    	queryWarnParam();
        //设置只读
        dialogScope.updateDisable=true;//
        
    }else if (flag == "view"){
        queryWarnParam();
        dialogScope.suspendFlagDisable=true;//
        dialogScope.targetTypeDisable = true;
        dialogScope.updateDisable=true;//
        dialogScope.viewDisable=true;//
    }

    /**
     * 目标岗位筛选
     */
    dialogScope.roleNameContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectRoleInfo",
        split:",",//分隔符
        extentColumn:"roleName",
        //column:["roleName","id"]//展示内容
        column:["roleName"]//展示内容
    };
    dialogScope.roleNamedooextent = function(ds){
        dialogScope.warnParamForm.roleName=ds.roleName;
        dialogScope.warnParamForm.targetRoleid=ds.id; //业务品种
    };
/*    dialogScope.$watch("warnParamForm.roleName",function(newVal,oldVal){
        //ht-input-extent  需要用监听的方式来传额外的参数
        dialogScope.roleNameContent.param ={
            roleName:dialogScope.warnParamForm.roleName
        };
    });*/
    //-------------------------------------点击事件----------------------------------
    //是否可忽略
    dialogScope.suspendFlagChange=function(val){
        if(val=="0"){ //否  可忽略天数 只读，非必输
            dialogScope.suspendFlagDisable= true;
            ////清空
            dialogScope.warnParamForm.suspendDay="";
        }else if(val=="1"){ //是
            dialogScope.suspendFlagDisable=false;
            dialogScope.suspendFlagRequire = "common.require";
        }
    };

    //预警目标类型	targetType
    dialogScope.targetTypeChange=function(val){
        if(val=="1"){ //客户经理  目标机构级别 目标岗位 只读
            dialogScope.targetTypeDisable= true;
            ////清空
            dialogScope.warnParamForm.targetBrclass="";
            dialogScope.warnParamForm.targetRoleid="";
        }else if(val=="2"){ //机构级别+岗位
            dialogScope.targetTypeDisable=false;
        }
    };

   //根据协议号加载担保提货协议信息
    function queryWarnParam(){
        var bBrpWarnParam ={
            warnNo:parentScope.selected.select[0].warnNo
        };
        var data = {
            bBrpWarnParam:bBrpWarnParam
        };
        var promise=$common.get_asyncData("bBrpWarnParamService/findBBrpWarnParamByKey",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                dialogScope.warnParamForm=data;
                if(dialogScope.warnParamForm.suspendFlag=="0"){//是否可忽略
                    dialogScope.suspendFlagDisable=true;
                }else{
                    dialogScope.suspendFlagRequire = "common.require";
                }
                if(dialogScope.warnParamForm.targetType=="1"){//预警目标类型
                    dialogScope.targetTypeDisable=true;
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    //确定按钮
    dialogScope.save_onClick = function(){
        if($.doValidate("warnParamForm")) {

            var data = {
                bBrpWarnParam: dialogScope.warnParamForm
            };
            if(flag == "add"){
                //新增信息保存
                var primise = $common.get_asyncData("bBrpWarnParamService/addBBrpWarnParam", data);
            }else if (flag == "update"){
                var primise = $common.get_asyncData("bBrpWarnParamService/updateBBrpWarnParam", data);
            }
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    $common.get_tipDialog('保存成功！', 'showSuccess');
                    dialogScope.closeThisDialog();
                    parentScope.queryTable();//
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

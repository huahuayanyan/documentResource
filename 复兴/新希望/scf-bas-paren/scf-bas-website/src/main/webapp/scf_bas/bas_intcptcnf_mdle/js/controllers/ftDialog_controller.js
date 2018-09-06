/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var ftDialogController = function(dialogScope,parentScope,$common,flag,dataDeliver) {


    dialogScope.datasourceDialog={//初始化表格对象
        ds: []
    };

    dialogScope.confDialog= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}

    dialogScope.thirdForm={
        chkItId:'',
        rem:'',
        clazz:''
    }


    if(flag == "add"){
        dialogScope.otherform={};//定义form对象
    }else if (flag == "update"){
        dialogScope.otherform=$common.copy(parentScope.selected.select[0]);
    };

    dialogScope.confirm_onClick = function(){
        /*alert(JSON.stringify(dialogScope.selectedDialog.select));*/

        if($.doValidate("otherform")) {

            var remLength =dialogScope.otherform.rem.length;
            var clazzLength=dialogScope.otherform.clazz.length;
            var passed = true;
            var errorMsg ="";
            if(remLength>256){
                passed = passed&&false;
                errorMsg =errorMsg+"拦截项描述,字符串长度不得超过256";
            }else if(clazzLength>100){
                passed = passed&&false;
                errorMsg =errorMsg+"服务名,字符串长度不得超过100";
            }

            if(passed){

                if(flag == "add"){

                    var primise = $common.get_asyncData("bSysChkCnfgService/add",{"otherform":dialogScope.otherform});
                    primise.then(function(res){
                        if (res.errorCode =="SUC"){
                            /*debugger;*/
                            parentScope.queryTable();
                            parentScope.selected.select=[];
                            dialogScope.closeThisDialog();
                            $common.get_tipDialog('新增成功！','showSuccess');

                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        };

                    });
                }else if (flag == "update"){
                    var primise = $common.get_asyncData('bSysChkCnfgService/update',{"otherform":dialogScope.otherform});
                    primise.then(function(res){
                        if (res.errorCode =="SUC"){
                            parentScope.queryTable();
                            parentScope.selected.select=[];
                            dialogScope.closeThisDialog();
                            $common.get_tipDialog('更新成功！','showSuccess');
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        };
                    });
                };
            }else{
                $common.get_tipDialog(errorMsg,'showError');
            }
        }
    };
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

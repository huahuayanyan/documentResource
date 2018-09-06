/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var ftDialog1Controller = function(dialogScope, parentScope, $common, flag, dataDeliver) {
    dialogScope.datasourceDialog={//初始化表格对象
        ds: []
    };
    dialogScope.confDialog= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}

    if(flag == "add"){
        dialogScope.otherform={};//定义form对象
        dialogScope.disable=false;
    }else if (flag == "update"){
        dialogScope.disable=true;
        dialogScope.otherform=$common.copy(parentScope.selected.select[0]);
    };
    dialogScope.chkItIds={ds: []};
    dialogScope.confirm_onClick = function(){
        /*alert(JSON.stringify(dialogScope.selectedDialog.select));*/
        if($.doValidate("otherform")) {
            if(flag == "add"){
                var primise = $common.get_asyncData("bSysChkDirService/add",{"otherform":dialogScope.otherform});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                            /*debugger;*/
                            parentScope.queryTable();
                            parentScope.selected.select=[];
                            dialogScope.closeThisDialog();
                            //跳转到第二个对话框
                            //parentScope为新生成Dialog所基于的域
                            //
                            $common.get_ngDialog('ft/ft2Dialog.html', parentScope
                                ,["$scope",function($sndDialogScope){
                                    ftDialog2Controller($sndDialogScope,dialogScope,$common,"add",dataDeliver);
                                }],"新增操作",{showClose:false});

                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        };

                });
            }else if (flag == "update"){
                var primise = $common.get_asyncData('bSysChkDirService/update',{"otherform":dialogScope.otherform});
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
        };
    };
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var ftDialog2Controller = function(dialogScope,parentScope,$common,flag,dataDeliver) {
    dialogScope.chkItIds={//初始化表格对象
        ds: [
        /*    {key:"1",value:'票据业务1'},
            {key:"2",value:'测试业务2'},
            {key:"3",value:'票据业务3'}*/
        ]
    };
    dialogScope.datasource={//初始化表格对象
        ds: []
    };
    dialogScope.thirdForm={};
    //初始化值
    if(flag == "add"){
        dialogScope.thirdform=parentScope.otherform;
    }else if (flag == "update"){
        dialogScope.thirdform=parentScope.selected.select[0];
    };
    dialogScope.confDialog= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}


    //监听分页
    dialogScope.$watch("confDialog.pageNo+confDialog.pageSize",function(){dialogScope.queryTable()})

        dialogScope.queryTable = function(paramData){
            var data= {
                pageNo: dialogScope.confDialog.pageNo,
                pageSize: dialogScope.confDialog.pageSize,
                bSysChkPl:{mdlId:dialogScope.thirdform.mdlId}
            };

            //alert("pageNo"+data.pageNo+" "+"pageSize"+data.pageSize);
            var promise = $common.get_asyncData("bSysChkPlService/findBSysChkPlByPage",data);
        promise.then(

            function(res){
                var data;
                if (res.errorCode =="SUC"){
                    data = res.contextData;
                    dialogScope.datasource.ds = data.records;
                    dialogScope.confDialog.totalRecord = data.totalRecord;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            }
        );
    }

    dialogScope.chkItIdsList= {ds:[]};

    dialogScope.queryIncpt = function(flag,instrument){

        var promise =  $common.get_asyncData("bSysChkCnfgService/findAllBSysChkCnfgList");

        promise.then(function(res){
            if (res.errorCode =="SUC"){
                if(res.scubeBody.contextData.data!=null&&res.scubeBody.contextData.data.length>0){
                    dialogScope.chkItIdsList.ds= eval(res.scubeBody.contextData.data);
                    //alert("dialogScope.chkItIdsList.ds:  "+JSON.stringify(dialogScope.chkItIdsList.ds));

                    //跳到会话框
                    $common.get_ngDialog('ft/ft3Dialog.html', dialogScope
                        ,["$scope",function($3dialogScope){
                            ftDialog3Controller($3dialogScope,dialogScope,$common,flag);
                        }],instrument,{showClose:false});
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });

    }

    dialogScope.addNew_onClick = function(){
        //var jsonStr = $common.get_asyncData("bSysChkCnfgService/findJSONObject");
        //JSON.parse(jsonStr);
        dialogScope.queryIncpt("add","新增操作");

    };

    dialogScope.updateNew_onClick = function(){
        //跳到会话框
        if(dialogScope.selected.select.length !=1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            dialogScope.queryIncpt("update","修改操作");
        }

    };

    dialogScope.chkItIds={ds: []};

    dialogScope.confirm_onClick = function(){
        /*alert(JSON.stringify(dialogScope.selectedDialog.select));*/
        if($.doValidate("thirdform")) {
            var primise = $common.get_asyncData('bSysChkDirService/update',{otherform:dialogScope.thirdform});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    parentScope.queryTable();
                    parentScope.selected.select=[];
                    $common.get_tipDialog('更新成功！','showSuccess');
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    };

    //取消标识
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };

    dialogScope.selected={//初始化对象
        select: []
    };

    dialogScope.deleteNew_onClick = function(){
        if(dialogScope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                var primise = $common.get_asyncData('bSysChkPlService/delete',{key:dialogScope.selected.select[0].chkPlId})
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.queryTable();
                        dialogScope.selected.select=[];
                        $common.get_tipDialog('删除成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
            })
        }
    };

    dialogScope.column = function(row)
    {
        $common.get_asyncData("bSysChkCnfgService/findAllBSysChkCnfgList").then(function(res){
            if (res.errorCode =="SUC"){
                if(res.scubeBody.contextData.data!=null&&res.scubeBody.contextData.data.length>0){
                    dialogScope.chkItIdsList.ds= eval(res.scubeBody.contextData.data);
                    //alert("dialogScope.chkItIdsList.ds:  "+JSON.stringify(dialogScope.chkItIdsList.ds));

                    //跳到会话框
                    $common.get_ngDialog('ft/ft3Dialog.html', dialogScope
                        ,["$scope",function($3dialogScope){
                            $3dialogScope.datasourceDialog={//初始化表格对象
                                ds: []
                            };

                            //初始化值
                            $3dialogScope.fourthform = {};

                            $3dialogScope.chkItIdsList={
                                ds:[]
                            };

                            $3dialogScope.selectChkPlIds={
                                ds:[
                                ]
                            };

                            $3dialogScope.chkItIdsList = dialogScope.chkItIdsList;

                            for(var i=0;i<$3dialogScope.chkItIdsList.ds.length;i++){
                                $3dialogScope.selectChkPlIds.ds[i]={key:JSON.stringify(i),value:$3dialogScope.chkItIdsList.ds[i].chkItId};
                            }

                            $3dialogScope.fourthform=$common.copy(row);
                            $3dialogScope.disable = true;
                            $3dialogScope.hide = true;

                            $3dialogScope.closeThisDialog_onClick = function(){
                                $3dialogScope.closeThisDialog();
                                dialogScope.selected.select=[];
                            };
                        }],'查看操作',{showClose:false});
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }
};



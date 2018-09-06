/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var ftDialog3Controller = function(dialogScope,parentScope,$common,flag) {

    /*alert(JSON.stringify(parentScope.otherform));*/
    /*dataDeliver.set("");*/
    /*thirdForm:{'chkItId':parentScope.otherform.chkItId,'rem':parentScope.otherform.rem,'clazz':clazz:parentScope.otherform.clazz}*/
    /*dataDeliver.setter({thirdForm:parentScope.otherform});*/
    dialogScope.datasourceDialog={//初始化表格对象
        ds: []
    };

    //初始化值
    dialogScope.fourthform = {};

    dialogScope.chkItIdsList={
        ds:[]
    };

    dialogScope.selectChkPlIds={
        ds:[
        ]
    }

    dialogScope.chkItIdsList = parentScope.chkItIdsList;

    for(var i=0;i<dialogScope.chkItIdsList.ds.length;i++){
        dialogScope.selectChkPlIds.ds[i]={key:JSON.stringify(i),value:dialogScope.chkItIdsList.ds[i].chkItId};
    }
    
    

    if(flag == "add"){
        //alert(JSON.stringify(dialogScope.selectChkPlIds));
        dialogScope.fourthform.stat= parentScope.thirdform.stat;
        dialogScope.fourthform.mdlId=parentScope.thirdform.mdlId;

    }else if (flag == "update"){
        dialogScope.fourthform.stat=parentScope.thirdForm.stat;
        dialogScope.fourthform.mdlId=parentScope.thirdForm.mdlId;
        dialogScope.fourthform=$common.copy(parentScope.selected.select[0]);
    }

    //dialogScope.chkItId={};
    dialogScope.setClazzName=function(){
        var index = fourthform.chkItId.value;
        //alert("value"+fourthform.chkItId.value);
        var name = dialogScope.chkItIdsList.ds[index].rem;
        dialogScope.fourthform.nm =name;

    };


    dialogScope.confirm_onClick = function(){
        /*alert(JSON.stringify(dialogScope.selectedDialog.select));*/
        if($.doValidate("otherform")) {
            if(flag == "add"){
                //noinspection JSDuplicatedDeclaration
                var primise = $common.get_asyncData('bSysChkPlService/add',{'otherform':dialogScope.fourthform});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        parentScope.queryTable();
                        parentScope.selected.select=[];
                        dialogScope.closeThisDialog();
                        $common.get_tipDialog('新增成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }else if (flag == "update"){
                var primise = $common.get_asyncData('bSysChkPlService/update',{"otherform":dialogScope.fourthform});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        parentScope.queryTable();
                        parentScope.selected.select=[];
                        dialogScope.closeThisDialog();
                        $common.get_tipDialog('更新成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }
        }
    }
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

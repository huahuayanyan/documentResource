var proDialogController = function(dialogScope,parentScope,$common,flag) {
    dialogScope.datasourceDialog={//初始化表格对象
            ds: []
        };
        dialogScope.selectedDialog={//初始化对象
            select: []
        };
        dialogScope.confDialog = {//初始化分页对象
            pageNo: 1,
            pageSize: 10,
            totalRecord: 0
        };

    if(flag == "add"){
        dialogScope.otherform={};//定义form对象
        dialogScope.disable=false;
    }else if (flag =="update"){
        dialogScope.otherform=$common.copy(parentScope.selected.select[0]);
        dialogScope.disable=true;
    };
    dialogScope.confirm_onClick = function(){
        if($.doValidate("otherform")) {
            if(flag =="add"){
                var primise = $common.get_asyncData("batchFileService/addJobDes",{jobDes:dialogScope.otherform});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        parentScope.queryTable();
                        parentScope.selected.select=[];
                        dialogScope.closeThisDialog();
                        $common.get_tipDialog('新增成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            }else if(flag == "update"){
                var primise = $common.get_asyncData('batchFileService/updateJobDes',{jobDes:dialogScope.otherform});
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

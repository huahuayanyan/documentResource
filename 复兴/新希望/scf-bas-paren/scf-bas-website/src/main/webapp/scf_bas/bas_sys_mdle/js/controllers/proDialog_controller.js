var proDialogController = function(dialogScope,parentScope,$common,flag) {
/*    if(flag == "add"){
        dialogScope.otherform={};//定义form对象
        dialogScope.disable=false;
    }else */if (flag =="update"){
        dialogScope.otherform=$common.copy(parentScope.selected.select[0]);
        dialogScope.disable=true;
    };
    dialogScope.confirm_onClick = function(){
        if($.doValidate("otherform")) {
              if(flag == "update"){
                var primise = $common.get_asyncData('bSysGlobalInfoService/update',{bSysGlobalInfo:dialogScope.otherform});
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

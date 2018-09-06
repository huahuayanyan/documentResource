var stockImportMortInfoController = function(dialogScope,parentScope,$common,flag,row) {

    dialogScope.cancel_onClick = function () {
        dialogScope.closeThisDialog();
        parentScope.selected.select = [];
    }

    /*查询押品信息*/
    if(flag == 'modify'){
        dialogScope.mortgageInfo = row;
    }

    dialogScope.confirm_onClick = function () {
        if ($.doValidate("mortgageInfo")) {
            if(flag == 'modify'){
                for(var i in parentScope.datasource.ds){
                    if(parentScope.datasource.ds[i].mortgageNo == dialogScope.mortgageInfo.mortgageNo){
                        parentScope.datasource.ds[i] = dialogScope.mortgageInfo;
                        dialogScope.closeThisDialog();
                        return;
                    }
                }
            }
        }
    }
}
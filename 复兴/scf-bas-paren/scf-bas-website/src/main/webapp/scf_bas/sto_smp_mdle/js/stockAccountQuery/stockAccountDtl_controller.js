/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var stockAccountDtlController = function(dialogScope,parentScope,$common,flag,row) {

    dialogScope.trptInfoDtlForm = {};
    dialogScope.trptInfoDtlForm = row;

    dialogScope.clsDtlDlg_onClick = function(){
        dialogScope.closeThisDialog();
    }
};

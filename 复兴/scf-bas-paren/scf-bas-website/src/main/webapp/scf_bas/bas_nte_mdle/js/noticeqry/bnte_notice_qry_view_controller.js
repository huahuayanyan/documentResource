/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */
var BnteNoticeQryViewController = function (dialogScope, parentScope, $common, row) {
      dialogScope.otherform = row;
    dialogScope.closeThisDialog_onClick = function () {
        dialogScope.closeThisDialog();
    };
};

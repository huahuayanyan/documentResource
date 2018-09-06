/**
 * Created by htrad0036 on 2017/2/17.
 */

var deliveryNoticeQryViewController = function (dialogScope, parentScope, $common, row) {
    dialogScope.otherform = row;
    dialogScope.closeThisDialog_onClick = function () {
        dialogScope.closeThisDialog();
    };
};
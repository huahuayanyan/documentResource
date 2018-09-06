var debtPoolPressNoticeDtlController = function (dialogScope, parentScope, $common, row) {
    dialogScope.otherform = row;
    dialogScope.closeThisDialog_onClick = function () {
        dialogScope.closeThisDialog();
    };
};
var monitorProtocolController = function ($scope, $common, $state, dataDeliver) {

    var wData = window.source.otherform; //processTemplateName "StockListImportApply"
    $scope.protocolForm = {};
    //业务品种下拉框
    var dataItemsDO = {parentId: "1000", productId: "1220020"};
    var data = {dataItemsDO: dataItemsDO}
    var promise = $common.get_asyncData("monitorProtocolService/getProductId", data);
    $scope.productSource = {};
    promise.then(function (res) {
        if (res.errorCode == "SUC") {
            $scope.productSource.ds = res.contextData;
        } else {
            $common.get_tipDialog(res.errorMsg, 'showInform');
        }
    });
    var protocolCode =  wData ? wData.protocolNo : dataDeliver.getter().prtclNo;
    var key = {protocolCode: protocolCode}
    var primise = $common.get_asyncData("monitorProtocolService/monitorProtocolQuery", key);
    primise.then(function (res) {
        if (res.errorCode == "SUC") {
            $scope.protocolForm = res.contextData;
            thrNameInfo(res.contextData.thrCode);
        } else {
            $common.get_tipDialog(res.errorMsg, 'showInform');
        }
    })
    function thrNameInfo(ds) {
        var custCd = ds;
        var data = {key: custCd}
        var promise = $common.get_asyncData("monitorProtocolService/getThrNamebycustCd", data);
        promise.then(function (res) {
            if (res.errorCode == "SUC") {
                $scope.protocolForm.thrName = res.contextData.thrName;
                $scope.protocolForm.levels = res.contextData.levels;
                $scope.protocolForm.monitorArea = res.contextData.monitorArea;
                $scope.protocolForm.monitortype = JSON.parse(res.contextData.monitortype);
                $scope.protocolForm.detailMonitorArea = res.contextData.detailMonitorArea;
                $scope.protocolForm.limitSum = res.contextData.limitSum;
                $scope.protocolForm.monitorStatus = res.contextData.monitorStatus;
                $scope.protocolForm.levelCogniDate = res.contextData.levelCogniDate;
                $scope.protocolForm.levelEndDate = res.contextData.levelEndDate;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        });
    }

    $scope.cancel_onClick = function () {
        $scope.closeThisDialog();
        $scope.queryprotocolForm();
        $scope.selected.select = [];
    };
}
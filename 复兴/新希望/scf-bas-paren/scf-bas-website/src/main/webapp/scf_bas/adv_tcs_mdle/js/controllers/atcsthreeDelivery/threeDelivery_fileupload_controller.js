/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var fileuploadController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.priceadjust = dataDeliver.getter();
    /*if(!$scope.priceadjust.appno)
    {
        $scope.priceadjust = $scope.source.priceadjust;
    }*/
    if(!$scope.priceadjust.appno)
    {
        $common.get_tipDialog("保证金追加与附件上传，需要在第一个table页面保存后，才能查看!",'showInform');
        //$state.go("priceadjust");
        //$scope.$parent.panes.forEach(function(pane){
        //    if (pane.uiSref == "priceadjust"){
        //        $scope.$parent.select(pane);
        //    }
        //});
        //一般形式
        $state.go("threeDeliveryApp.dtl");
        $scope.$parent.panes.forEach(function(pane){
            if (pane.uiSref == "threeDeliveryApp.dtl"){
                $scope.$parent.select(pane);
            }
        });
        return;
    }
    //表格--------结束-------------------------
};

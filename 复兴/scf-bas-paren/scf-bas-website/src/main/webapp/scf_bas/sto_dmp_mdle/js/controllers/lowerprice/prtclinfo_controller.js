/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var prtclinfoController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.mortgageInfo = $scope.source.mortgageInfo;
    $scope.productSource = {
        ds:[]
    }
    /**
     * ҵ��Ʒ��ɸѡ��ʼ
     */
    var dataItemsDO = {productId:$scope.mortgageInfo.productId};
    var data = {dataItemsDO:dataItemsDO}
    var promise = $common.get_asyncData("monitorProtocolService/getProductId",data);
    $scope.productSource = {};
    promise.then(function(res){
        if (res.errorCode =="SUC"){
            $scope.productSource.ds = res.contextData;
            //$scope.protocol.productId="1220020";
        }else{
            $common.get_tipDialog(res.errorMsg,'showInform');
        }
    });
    /**
     * ҵ��Ʒ��ɸѡ����
     */
    //���--------����-------------------------
};

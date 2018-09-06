/**
 * 弹出子窗体
 * @param $scope
 * @param $common
 * @param type
 *
 */
function promptPayNtcDtlController($scope, $common, type, param) {

    $scope.otherform = param;
    //$scope.confirm= function(){
    //    console.log(JSON.stringify( $scope.appAlertInfo));//控制台打印输入的对象
    //        var primise = $common.get_asyncData("alertsListService/add",param);
    //        primise.then(function(res){
    //            var data;
    //            if (res.errorCode =="SUC"){
    //                data = res.contextData;
    //                $scope.otherform = data.records;
    //            }else{
    //                $common.get_tipDialog(res.errorMsg,'showError');
    //            }
    //        })
    //};

    $scope.closeThisDialog_onClick = function(){
        $scope.closeThisDialog();
    };


}
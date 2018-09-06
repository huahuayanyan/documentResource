var writeoffTaskController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {

    $scope.otherform = {};
    var bdata = window.parent.data;
    var appno = window.parent.appNo;
    var promise = $common.get_asyncData("bPbcAppliBaseInfoService/findBPbcAppliBaseInfoByKey",{"key":appno});
    promise.then(function(res){
        var data;
        if (res.errorCode =="SUC"){
            data = res.contextData;
            $scope.otherform = data;
            $scope.otherform.mastContno=data.mastContno;
            dataDeliver.setter($scope.otherform);
            $state.go("writeoffRequest");

        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
};
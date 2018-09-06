/**
 * 
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:42:40
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 */
var lnappguideController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = {};
    var prdId;
    var appId = window.parent.appNo;
    var promise = $common.get_asyncData("bCrrLnAppService/findBCrrLnAppByAppId",{appId:appId});
    promise.then(function(res){
        var data;
        if (res.errorCode =="SUC"){
            data = res.contextData;
            $scope.otherform = data;
            prdId = $scope.otherform.prdId;
            var prdId = $scope.otherform.prdId;
            var baseparam;
            if(prdId=="003")
            {
                baseparam = "lcapp";
            }
            else if(prdId=="004")
            {
                baseparam = "ycapp";
            }
            else
            {
                baseparam = "app";
            }
            $scope.baseparam = baseparam;
            $common.get_asyncData('bCrrPrdMdService/findBCrrPrdMdByPrdId',{prdId:prdId}).then(function(res){
                if (res.errorCode =="SUC"){
                    $scope.otherform.prdmd = res.contextData;
                    $scope.title = $scope.otherform.prdmd.titNm;
                    $scope.param = $scope.otherform.prdmd.prdTyp;
                    var stat = $scope.otherform.prdmd.stat;
                    if(stat=="0")
                    {
                        //$("#no").show();
                        //$("#yes").remove();
                        $scope.hide = true;
                    }
                    if(stat=="1")
                    {
                        //$("#no").remove();
                        //$("#yes").show();
                        $scope.hide = false;
                    }
                    /*if(stat=="0")
                    {
                        document.getElementById("no").style.display = "";
                        document.getElementById("yes").style.display = "none";
                    }
                    if(stat=="1")
                    {
                        document.getElementById("no").style.display = "none";
                        document.getElementById("yes").style.display = "";
                    }*/
                    $state.go(baseparam);
                    dataDeliver.setter($scope.otherform);
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
    //表格--------结束-------------------------
};

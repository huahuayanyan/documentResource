/**
 * 
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:42:40
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 */
var duebillappguideController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = {};
    var prdId;
    var id = window.parent.appNo;
    var promise = $common.get_asyncData("bCrrDuebillAppService/findBCrrDuebillAppById", {id: id});
    promise.then(function (res) {
        var data;
        if (res.errorCode == "SUC") {
            data = res.contextData;
            if(!data||!data.appId){
                $common.get_tipDialog('该数据非法删除,重新选择！','showInform');
                return;
            }
            $scope.otherform = data;
            $scope.otherform.relaId = id;
            var appId = $scope.otherform.appId;
            $common.get_asyncData('bCrrLnConService/findBCrrLnConByAppId',{appId:appId}).then(function(res){
                if (res.errorCode =="SUC"){
                    var lncon = res.contextData;
                    prdId = lncon.prdId;
                    var extId = lncon.extId;
                    $scope.otherform.extId = extId;
                    $common.get_asyncData('bCrrPrdMdService/findBCrrPrdMdByPrdId',{prdId:prdId}).then(function(res){
                        if (res.errorCode =="SUC"){
                            $scope.otherform.prdmd = res.contextData;
                            $scope.title = $scope.otherform.prdmd.titNm;
                            var param = $scope.otherform.prdmd.prdTyp;
                            $scope.param = param;
                            var stat = $scope.otherform.prdmd.stat;
                            if(stat=="0")
                            {
                                $("#no").show();
                                $("#yes").remove();
                            }
                            if(stat=="1")
                            {
                                $("#no").remove();
                                $("#yes").show();
                            }
                            var prdId = $scope.otherform.prdId;
                            var baseparam;
                            if(prdId=="003")
                            {
                                baseparam = "lcedit";
                            }
                            else if(prdId=="004")
                            {
                                baseparam = "ycedit";
                            }
                            else
                            {
                                baseparam = "edit";
                            }
                            $scope.baseparam = baseparam;
                            $state.go(baseparam);
                            dataDeliver.setter($scope.otherform);
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        };
                    });
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        } else {
            $common.get_tipDialog(res.errorMsg, 'showError');
        }
    });
    //表格--------结束-------------------------
};

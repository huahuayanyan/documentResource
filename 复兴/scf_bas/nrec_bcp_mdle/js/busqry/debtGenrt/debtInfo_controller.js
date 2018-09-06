var infoController  = function($scope,$timeout,$common,$state,dataDeliver) {
    var obj = angular.fromJson(dataDeliver.getter());
    var stateUrl;
    $scope.baseurl = "";

    //监听分页
    $scope.$watch("obj.mastContno",function() {
        $scope.queryState(obj);
    });
    //查询对应业务品种跳转state
    $scope.queryState = function(paramData)
    {
        var data = {
            productId:paramData.supplyChainPdId,
            invokPhase:"02"
        };
        $common.get_asyncData("bprdFlowService/findBPrdFlowVOByParam",data).then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                stateUrl = data.url;
                if(stateUrl==undefined||stateUrl==""||stateUrl==null)
                {
                    $common.get_tipDialog('跳转路由路径为空，请维护数据！','showInform');
                }
                else
                {
                    $common.get_asyncData("bcntBcpInfoService/findBCntBcpInfoByMastContno",{bCntBcpInfoVO:paramData}).then(function(res){
                        var cntinfo;
                        if (res.errorCode =="SUC"){
                            cntinfo = res.contextData;
                            cntinfo.flag = obj.flag;
                            cntinfo.tlrnm = obj.tlrnm;
                            $scope.baseurl = "info."+stateUrl;
                            $state.go("info.staticInfo");//跳转
                            dataDeliver.setter(cntinfo);
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    };

    $scope.tabClose_onClick = function(){
        $state.go("debtList");
    };
};
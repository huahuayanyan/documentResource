/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/10
 */
var custController = function($scope,$timeout,$common,$state,dataDeliver){
	$scope.otherform = dataDeliver.getter();
	$scope.finform = {};
    /*根据客户的客户类型在财报模版中动态搜索财报模板信息*/
    var primisefin = $common.get_asyncData("bFinCustService/findMdlClsByCustId",{bFinCust:$scope.otherform});
    primisefin.then(function(res){
        var data;
        if (res.errorCode =="SUC"){
            data = res.contextData;
            $scope.finform = data;
            for(var i =0;i<$scope.finform.length;i++){
            	$scope.finform[i].param = {
                		mdlTyp: $scope.finform[i].mdlTyp,
                		finDirId: $scope.finform[i].finDirId,
                        mdlId:$scope.finform[i].mdlId
                };
            }
            var mdlTyp = $scope.finform[0].mdlTyp;
            var finDirId = $scope.finform[0].finDirId;
            var mdlId = $scope.finform[0].mdlId;
            $state.go("fin.view",{mdlTyp:mdlTyp,finDirId:finDirId,mdlId:mdlId});//跳转
        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    })
}
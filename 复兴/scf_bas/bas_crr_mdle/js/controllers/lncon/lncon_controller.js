/**
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:42:40
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 */
var lnconController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();
    $scope.title = $scope.otherform.prdmd.titNm;
    var prdId = $scope.otherform.prdId;
    var param = "lncon."+$scope.otherform.prdmd.prdTyp;
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
        baseparam = "lncon.lccon";
    }
    else if(prdId=="004")
    {
        baseparam = "lncon.yccon";
    }
    else
    {
        baseparam = "lncon.con";
    }
    $scope.baseparam = baseparam;
    $state.go(baseparam);
    $scope.back_onClick = function(){
        $state.go("list");
    };
    //表格--------结束-------------------------
};

/**
 * 
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:42:40
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 */
var lnappController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();
    $scope.title = $scope.otherform.prdmd.titNm;
    var param = "lnapp."+$scope.otherform.prdmd.prdTyp;
    $scope.param = param;
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
    var prdId = $scope.otherform.prdId;
    var baseparam;
    if(prdId!=null&&prdId!=""&&prdId!=undefined)
    {
        if(prdId=="003")
        {//信用证
            baseparam = "lnapp.lcapp";
        }
        else if(prdId=="004")
        {//银承
            baseparam = "lnapp.ycapp";
        }
        else if(prdId=="01")
        {//流贷
            baseparam = "lnapp.app";
        }
        $scope.baseparam = baseparam;
        $scope.otherform.baseparam = baseparam;
        $state.go(baseparam);
    }
    else
    {
        $common.get_tipDialog('业务品种信息丢失，请重试！','showInform');
    }
    $scope.back_onClick = function(){
        $state.go("list");
    };
    //表格--------结束-------------------------
};

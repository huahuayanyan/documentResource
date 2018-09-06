/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var NbasPrdLoanWayListController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.baseinfo = dataDeliver.getter();
    $scope.loanwayform = {};
    var flag = $scope.baseinfo.flag;
    if(flag == "add")
    {
        $common.get_tipDialog("请先保存产品基本信息！",'showInform');
        var url = "prddtl.baseinfo";
        $state.go(url);
        $scope.$parent.panes.forEach(function(pane){
            if (pane.uiSref == url){
                $scope.$parent.select(pane);
            }
        });
        return;
    }
    if(flag == "update")
    {

    }
    if(flag == "view")
    {
        $scope.disable = true;
        $scope.hide = true;
    }

    //监听分页
    $scope.$watch("baseinfo.productId",function(){
        $scope.queryTable();
    });

    //查询操作
    $scope.queryTable = function(paramData){
        $common.get_asyncData("nbprdBaseInfoService/findBPrdBaseInfoByKey",{bPrdBaseInfoVO:$scope.baseinfo}).then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.loanwayform = data;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //上一步
    $scope.former_onClick = function()
    {
        var url = "prddtl.cont";
        $state.go(url);
        $scope.$parent.panes.forEach(function(pane){
            if (pane.uiSref == url){
                $scope.$parent.select(pane);
            }
        });
        return;
    };
    //下一步-执行保存操作
    $scope.next_onClick = function()
    {
        var data = {
            bPrdBaseInfoVO:$scope.loanwayform,
            productId:$scope.baseinfo.productId
        };
        $common.get_asyncData("nbprdBaseInfoService/saveBPrdBaseInfo",data).then(function(res){
            if (res.errorCode =="SUC"){
                var url = "prddtl.flwork";
                $state.go(url);
                $scope.$parent.panes.forEach(function(pane){
                    if (pane.uiSref == url){
                        $scope.$parent.select(pane);
                    }
                });
                return;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //完成-执行相应业务逻辑
    $scope.complete_onClick = function()
    {
        var data = {
            bPrdBaseInfoVO:$scope.loanwayform,
            productId:$scope.baseinfo.productId
        };
        $common.get_asyncData("nbprdBaseInfoService/saveBPrdBaseInfo",data).then(function(res){
            if (res.errorCode =="SUC"){
                $state.go("list");
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
  //表格--------结束-------------------------
};

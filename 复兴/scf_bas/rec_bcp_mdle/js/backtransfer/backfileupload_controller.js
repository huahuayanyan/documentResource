/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var backFileUploadController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.taskform = $scope.source.taskform;
    if(window.appNo)
    {
        $scope.hideButton = true;
    }
    $scope.otherform = dataDeliver.getter();
    if(!$scope.otherform.appno)
    {
        $scope.otherform = $scope.source.otherform;
    }
    if(!$scope.otherform.appno)
    {
        $common.get_tipDialog("请先保存后上传附件！",'showInform');
        //$state.go("priceadjust");
        //$scope.$parent.panes.forEach(function(pane){
        //    if (pane.uiSref == "priceadjust"){
        //        $scope.$parent.select(pane);
        //    }
        //});
        //一般形式
        var stateUrl;
        if($scope.otherform.bussType=="1230040"||$scope.otherform.bussType=="1230050"||$scope.otherform.bussType=="1230060"
            ||$scope.otherform.bussType=="1240050"||$scope.otherform.bussType=="3200")
        {//应收账款池融资  国内保理池   应收账款质押池     出口退税池   票据池      票据池
            stateUrl = "backtransfer.debtbackpool";
        }
        else
        {//应收账款融资
            stateUrl = "backtransfer.debtback";
        }
        $state.go(stateUrl);
        $scope.$parent.panes.forEach(function(pane){
            if (pane.uiSref == stateUrl){
                $scope.$parent.select(pane);
            }
        });
        return;
    }
    $scope.fileupload={};//初始化查询条件对象
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    })
    //重置
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.fileupload = {};
            $scope.selected.select=[];//清空选项s
        })
    }
    //搜索查询
    $scope.submit_onClick =function(){
        $scope.queryTable();
    }
    $scope.queryTable = function(paramData){
        //var promise = $common.get_asyncData("bCrrGntyConService/findBCrrGntyConByPage",data)
        //promise.then(function(res){
        //    var gnty;
        //    if (res.errorCode =="SUC"){
        //        gnty = res.contextData;
        //        $scope.datasource.ds = gnty.records;
        //        $scope.conf.totalRecord = gnty.totalRecord;
        //    }else{
        //        $common.get_tipDialog(res.errorMsg,'showError');
        //    }
        //});
    };
    $scope.back_onClick = function()
    {
        $state.go("list");
    }
    //表格--------结束-------------------------
};

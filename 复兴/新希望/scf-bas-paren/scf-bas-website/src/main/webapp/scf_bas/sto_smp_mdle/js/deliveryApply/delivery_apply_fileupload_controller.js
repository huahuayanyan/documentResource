/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var fileuploadController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.priceadjust = dataDeliver.getter();
    if(!$scope.priceadjust.appno)
    {
        $scope.priceadjust = $scope.source.priceadjust;
    }
    if(!$scope.priceadjust.appno)
    {
        $common.get_tipDialog("保证金追加与附件上传，需要在第一个table页面保存后，才能查看!",'showInform');
        //$state.go("priceadjust");
        //$scope.$parent.panes.forEach(function(pane){
        //    if (pane.uiSref == "priceadjust"){
        //        $scope.$parent.select(pane);
        //    }
        //});
        //一般形式
        $state.go("priceedit.priceadjust");
        $scope.$parent.panes.forEach(function(pane){
            if (pane.uiSref == "priceedit.priceadjust"){
                $scope.$parent.select(pane);
            }
        });
        return;
    }
    if(window.appNo)
    {
        $scope.hide = true;
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

/**
 * Created by htrad0036 on 2017/1/12.
 */

var staticController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {

    $scope.otherform={};
    $scope.creditdatasource = {
        ds:[]
    };
    $scope.creditselected = {//初始化对象
        select: []
    };
    $scope.creditconf = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };
    $scope.lncidatasource = {
        ds:[]
    };
    $scope.lnciselected = {//初始化对象
        select: []
    };
    $scope.lnciconf = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };

    $scope.debtOverdatasource = {
        ds:[]
    };

    $scope.debtOverselected = {//初始化对象
        select: []
    };

    $scope.debtOverconf = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };

    var obj = angular.fromJson(dataDeliver.getter());
    if(obj.financingType=="1")
    {
        $scope.hide = true;
    }
    //监听分页
    $scope.$watch("obj.mastContno", function () {
        $scope.queryBaseInfo();
    });
    //监听分页
    $scope.$watch("lnciconf.pageNo+lnciconf.pageSize",function(){
        $scope.queryLnciData();
    });

    //监听分页
    $scope.$watch("debtOverconf.pageNo+debtOverconf.pageSize",function(){
        $scope.queryOverData();
    });

    //基本信息
    $scope.queryBaseInfo = function(){
        var promise = $common.get_asyncData("bcntBcpInfoService/queryBCntBcpInfoByMastContno",{key:obj.mastContno});
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.otherform = res.contextData;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //借据信息
    $scope.queryLnciData = function(){
        var data= {
            pageNo: $scope.lnciconf.pageNo,
            pageSize: $scope.lnciconf.pageSize,
            mastContno:obj.mastContno
        };
        var promise = $common.get_asyncData("bCntBcpInfoBussQryService/getLnciBaseInfoByProtocolNo",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.lncidatasource.ds = data.records;
                $scope.lnciconf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.lnciselected.select=[];
    };
    //应收账款清单
    $scope.queryOverData = function(){
        var data= {
            pageNo: $scope.debtOverconf.pageNo,
            pageSize: $scope.debtOverconf.pageSize,
            value:{mastContno:obj.mastContno}
        };
        var promise = $common.get_asyncData("rbcpDebtInfoService/findRBcpDebtInfoByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.debtOverdatasource.ds = data.records;
                $scope.debtOverconf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.debtOverselected.select=[];
    };
};
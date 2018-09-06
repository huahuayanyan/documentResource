/**
 * Created by htrad0036 on 2017/1/12.
 */

var staticController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {

    $scope.otherform={};
    $scope.creditdatasource = {};
    $scope.creditselected = {//初始化对象
        select: []
    };
    $scope.creditconf = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };
    $scope.lncidatasource = {};
    $scope.lnciselected = {//初始化对象
        select: []
    };
    $scope.lnciconf = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };
    $scope.debtOverdatasource = {};
    $scope.debtOverselected = {//初始化对象
        select: []
    };
    $scope.debtOverconf = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };
    var obj = angular.fromJson(dataDeliver.getter());

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize", function () {
        $scope.queryBaseInfo();
    });
    $scope.$watch("creditconf.pageNo+creditconf.pageSize", function () {
        $scope.queryCreditData();
    });
    $scope.$watch("lnciconf.pageNo+lnciconf.pageSize", function () {
        $scope.queryLnciData();
    });
    $scope.$watch("debtOverconf.pageNo+debtOverconf.pageSize", function () {
        $scope.queryOverData();
    });
    //基本信息
    $scope.queryBaseInfo = function(){
        var data= {
            mastContno:obj.debtContno
        };
        var promise = $common.get_asyncData("debtPoolGenerateQueryService/queryDebtGenaralLedger",data);
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.otherform = res.contextData;
                $scope.otherform.cname= obj.cname;
                $scope.otherform.productName= obj.productName;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //信贷合同
    $scope.queryCreditData = function(){
        var data= {
            pageNo: $scope.creditconf.pageNo,
            pageSize: $scope.creditconf.pageSize,
            mastContno:obj.debtContno
        };
        var promise = $common.get_asyncData("debtPoolGenerateQueryService/getCreditLoanContInfoByParam",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.creditdatasource.ds = data.records;
                $scope.creditconf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.creditselected.select=[];
    };
//借据信息
    $scope.queryLnciData = function(){
        var data= {
            pageNo: $scope.lnciconf.pageNo,
            pageSize: $scope.lnciconf.pageSize,
            mastContno:obj.debtContno
        };
        var promise = $common.get_asyncData("debtPoolGenerateQueryService/getLnciBaseInfoByProtocolNo",data);
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
            paramMap: {debtContno_Q:obj.debtContno,sellerCustcd_Q:obj.cname,factType:"2"}
        };
        var promise = $common.get_asyncData("debtPoolGenerateQueryService/getDebtBillsInfo",data);
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
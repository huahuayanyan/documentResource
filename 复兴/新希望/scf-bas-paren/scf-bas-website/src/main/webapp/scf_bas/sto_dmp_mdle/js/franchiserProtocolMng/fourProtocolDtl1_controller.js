
var baseInfoController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    $scope.otherform=dataDeliver.getter().info;
    var obj = dataDeliver.getter();
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
    
    $scope.mortgagedatasource = {};
    $scope.mortgageselected = {//初始化对象
        select: []
    };
    $scope.mortgageconf = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };

    //监听分页
    $scope.$watch("creditconf.pageNo+creditconf.pageSize", function () {
        $scope.queryCreditData();
    });
    $scope.$watch("lnciconf.pageNo+lnciconf.pageSize", function () {
        $scope.queryLnciData();
    });
    $scope.$watch("mortgageconf.pageNo+mortgageconf.pageSize", function () {
        $scope.queryMortgageData();
    });

   //信贷合同
    $scope.queryCreditData = function(){
        var data= {
            pageNo: $scope.creditconf.pageNo,
            pageSize: $scope.creditconf.pageSize,
            slaveContno:obj.info.conId
        };
        var promise = $common.get_asyncData("billNormalGeneralLedgerService/ContBaseInfoGetter",data);
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
    };
//借据信息
    $scope.queryLnciData = function(){
        var data= {
            pageNo: $scope.lnciconf.pageNo,
            pageSize: $scope.lnciconf.pageSize,
            slaveContno:obj.info.conId
        };
        var promise = $common.get_asyncData("billNormalGeneralLedgerService/LnciBaseInfoListGetter",data);
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
    };
    
  //库存列表
    $scope.queryMortgageData = function(){
        var data= {
            pageNo: $scope.mortgageconf.pageNo,
            pageSize: $scope.mortgageconf.pageSize,
            mortgageEnter: {slaveContcode:obj.info.conId,
            	productId:obj.info.vidPrdId
            }
        };
        var promise = $common.get_asyncData("mortgageEnteringService/queryMortgageEnteringListByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.mortgagedatasource.ds = data.records;
                $scope.mortgageconf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.mortgageselected.select=[];
    };

};
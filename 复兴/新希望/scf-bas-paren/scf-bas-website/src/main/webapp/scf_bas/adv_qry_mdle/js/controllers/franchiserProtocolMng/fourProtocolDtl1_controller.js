
var baseInfoController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
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

    var obj = angular.fromJson(dataDeliver.getter());

    //监听分页
    $scope.$watch("creditconf.pageNo+creditconf.pageSize", function () {
        $scope.queryBaseInfo();
        $scope.queryCreditData();
    });
    $scope.$watch("lnciconf.pageNo+lnciconf.pageSize", function () {
        $scope.queryLnciData();
    });

    //基本信息
    $scope.queryBaseInfo = function(){
        var data= {
            protocolNo:obj.info.protocolNo
        };
        var promise = $common.get_asyncData("franchiserProtocolMngService/getFourProtocolInfo",data);
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.otherform = res.contextData;
                $scope.otherform.protocolCode= obj.info.protocolCode;
                $scope.otherform.productName= obj.info.productName;
                $scope.otherform.sellerNm= obj.info.sellerNm;
                $scope.otherform.coreNm= obj.info.coreNm;
                $scope.otherform.tlrno= obj.info.tlrno;
                $scope.otherform.brcode= obj.info.brcode;
                $scope.otherform.startDate= obj.info.startDate;
                $scope.otherform.endDate= obj.info.endDate;
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
            protocolNo:obj.info.protocolNo
        };
        var promise = $common.get_asyncData("franchiserProtocolMngService/getFourMastContInfoByParam",data);
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
            protocolNo:obj.info.protocolNo
        };
        var promise = $common.get_asyncData("franchiserProtocolMngService/getFourProtocolLnciList",data);
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

};
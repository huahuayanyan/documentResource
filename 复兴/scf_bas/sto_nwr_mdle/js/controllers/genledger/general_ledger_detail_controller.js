/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var generalLedgerDetailController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.baseinfo = $scope.source.baseinfo;

    $scope.datasource={//初始化表格对象
        ds:[]
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    $scope.datasourcelnci={//初始化表格对象
        ds:[]
    };
    $scope.selectedlnci={//初始化对象
        select: []
    };
    $scope.conflnci= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    $scope.datasourcebill={//初始化表格对象
        ds:[]
    };
    $scope.selectedbill={//初始化对象
        select: []
    };
    $scope.confbill= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    $scope.datasourcemort={//初始化表格对象
        ds:[]
    };
    $scope.selectedmort={//初始化对象
        select: []
    };
    $scope.confmort= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize", function () {
        $scope.queryTable();
    });
    $scope.$watch("conflnci.pageNo+conflnci.pageSize", function () {
        $scope.queryTableLnci();
    });
    $scope.$watch("confbill.pageNo+confbill.pageSize", function () {
        $scope.queryTableBill();
    });
    $scope.$watch("confmort.pageNo+confmort.pageSize", function () {
        $scope.queryTableMort();
    });
    //信贷合同
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            slaveContno:$scope.baseinfo.slaveContno
        };
        var promise = $common.get_asyncData("billNormalGeneralLedgerService/ContBaseInfoGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //借据信息
    $scope.queryTableLnci = function(){
        var data= {
            pageNo: $scope.conflnci.pageNo,
            pageSize: $scope.conflnci.pageSize,
            slaveContno:$scope.baseinfo.slaveContno
        };
        var promise = $common.get_asyncData("billNormalGeneralLedgerService/LnciBaseInfoListGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasourcelnci.ds = data.records;
                $scope.conflnci.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //质押仓单信息
    $scope.queryTableBill = function(){
        $scope.baseinfo.flag = "1";
        var data= {
            pageNo: $scope.confbill.pageNo,
            pageSize: $scope.confbill.pageSize,
            billNormalVO:$scope.baseinfo
        };
        var promise = $common.get_asyncData("billNormalGeneralLedgerService/BillNormalDeliverableListGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasourcebill.ds = data.records;
                $scope.confbill.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //库存押品列表
    $scope.queryTableMort = function(){
        var mortgageQryVO = {
            monitorProtocolNo:$scope.baseinfo.protocolNo,
            slaveContno:$scope.baseinfo.slaveContno
        }
        var data= {
            pageNo: $scope.confmort.pageNo,
            pageSize: $scope.confmort.pageSize,
            mortgageQryVO:mortgageQryVO
        };
        var promise = $common.get_asyncData("billNormalGeneralLedgerService/MutiMortInfoGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasourcemort.ds = data.records;
                $scope.confmort.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //表格--------结束-------------------------
};

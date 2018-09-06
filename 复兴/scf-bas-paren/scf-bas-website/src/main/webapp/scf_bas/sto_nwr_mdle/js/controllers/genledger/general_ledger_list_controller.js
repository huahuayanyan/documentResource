/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var generalLedgerlistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.conditionForm={
        flag:"6",
        supplyChainPdId:"1202"
    };//初始化查询条件对象
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    $scope.productselect = {//业务品种下拉框
        ds:[]
    };
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.productSourceList();
    });
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm = {
                flag:"6",
                supplyChainPdId:"1202"
            };
            $scope.selected.select=[];//清空选项s
        })
    }
    //搜索查询
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    }
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            contSlaveQryVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("billNormalGeneralLedgerService/MortgageContSlaveQryGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records||[];
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    /**
     * 业务品种筛选开始
     */
        //查询业务品种
    $scope.productSourceList = function(){
        //业务品种下拉框
        var dataItemsDO = {parentId:"1000",productId:"1202"};
        var data = {dataItemsDO:dataItemsDO}
        var promise = $common.get_asyncData("monitorProtocolService/getProductId",data);
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.productselect.ds = res.contextData||[];
                $scope.conditionForm={
                    flag:"6",
                    supplyChainPdId:"1202"
                };
                $scope.queryTable();
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    }
    /**
     * 业务品种筛选结束
     */

    $scope.query_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else {
            var row = $scope.selected.select[0];
            $state.go("genldeger");
            dataDeliver.setter(row);
        }
    }
    //表格--------结束-------------------------
};

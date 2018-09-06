/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var maxquerylistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.conditionForm={};//初始化查询条件对象
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
    /*$scope.$watch("conf.pageNo+conf.pageSize",$scope.queryTable)*/
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    })
    //重置
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm = {};
            $scope.selected.select=[];//清空选项s
        })
    }
    //搜索查询
    $scope.submit_onClick =function(){
        $scope.queryTable();
    }
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            value:$scope.conditionForm
        };
        var promise = $common.get_asyncData("maxmumBailTransferQueryService/MaxmumBailTransferQueryGetter",data);
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
     * 客户名称查询加载开始
     */
    $scope.custcontent = {
        type:"table",//展示类型table  tree
        url:"bCrrLnAppService/queryCustSource",
        param:{},
        split:",",//分隔符
        extentColumn:"cname",
        column:["custNm","custId"]//展示内容
    };
    $scope.dooextend = function(ds){
        $scope.conditionForm.cname=ds.custNm;
        $scope.conditionForm.custcd = ds.custId;
    };
    $scope.$watch("conditionForm.cname",function(){
        if($scope.conditionForm.cname!=null) $scope.custcontent.param ={custId:$scope.conditionForm.cname,custNm:$scope.conditionForm.cname};
    });
    /**
     * 客户名称查询加载结束
     */

    /**
     * 质押监管协议编号查询加载开始
     */
    $scope.subcontent = {
        type:"table",//展示类型table  tree
        url:"maxmumBailTransferQueryService/MutiProtDropDownGetter",
        param:{},
        split:",",//分隔符
        extentColumn:"subContno",
        column:["protocolNo"]//展示内容
    };
    $scope.subdooextend = function(ds){
        $scope.conditionForm.subContno = ds.protocolNo;
        $scope.slavecontent.param = {subContno:$scope.conditionForm.subContno};
    };
    $scope.$watch("conditionForm.subContno",function(){
        if($scope.conditionForm.subContno!=null) $scope.subcontent.param = {subContno:$scope.conditionForm.subContno};
    });
    /**
     * 质押监管协议编号查询加载结束
     */

    /**
     * 抵/质押合同号查询加载开始
     */
    $scope.slavecontent = {
        type:"table",//展示类型table  tree
        url:"maxmumBailTransferQueryService/SlaveContractGetter",
        param:{},
        split:",",//分隔符
        extentColumn:"slaveContno",
        column:["conId"]//展示内容
    };
    $scope.slavedooextend = function(ds){
        $scope.conditionForm.slaveContno = ds.conId;
    };
    $scope.$watch("conditionForm.slaveContno",function(){
        if($scope.conditionForm.subContno!=null) $scope.slavecontent.param ={slaveContno:$scope.conditionForm.slaveContno};
    });
    /**
     * 抵/质押合同号查询加载结束
     */
    //表格--------结束-------------------------
};

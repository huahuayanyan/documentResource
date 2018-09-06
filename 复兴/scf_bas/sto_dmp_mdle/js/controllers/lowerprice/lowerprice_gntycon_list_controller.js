/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var lowerpricegntyconlistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = {};
    $scope.conditionForm={conStat:"1"};//初始化查询条件对象
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
            $scope.conditionForm = {conStat:"1"};
            $scope.selected.select=[];//清空选项s
        })
    }
    //搜索查询
    $scope.submit_onClick =function(){
        $scope.queryTable();
    }
    $scope.queryTable = function(paramData){
        $scope.conditionForm.vidPrdId = "1220020";
        $scope.conditionForm.lowPrice = "0";
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bCrrGntyCon:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bCrrGntyConService/findBCrrGntyConByPage",data)
        promise.then(function(res){
            var gnty;
            if (res.errorCode =="SUC"){
                gnty = res.contextData;
                $scope.datasource.ds = gnty.records;
                $scope.conf.totalRecord = gnty.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    /**
     * 担保人名称查询加载开始
     */
    $scope.gutcontent = {
        type:"table",//展示类型table  tree
        url:"bCrrLnAppService/queryCustSource",
        param:{},
        split:",",//分隔符
        extentColumn:"custNm",
        column:["custNm","custId"]//展示内容
    };
    $scope.gutextend = function(ds){
        $scope.conditionForm.gutNm = ds.custNm;
    };
    $scope.$watch("conditionForm.gutNm",function(){
        if($scope.conditionForm.gutNm!=null) $scope.gutcontent.param ={custId:$scope.conditionForm.gutNm,custNm:$scope.conditionForm.gutNm};
    });
    /**
     * 担保人名称查询加载结束
     */
    //发起申请
    $scope.application_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var row = $scope.selected.select[0];
            var slaveContno = row.conId;
            $common.get_asyncData("lowerPriceService/checkIsApprove",{slaveContno:slaveContno}).then(function(res){
                var flag;
                if (res.errorCode =="SUC"){
                    flag = res.contextData.value;
                    if(flag=="false")
                    {
                        $common.get_tipDialog('抵/质押合同号为'+slaveContno+'的合同已进入审批流程，请稍候……！','showInform');
                        $scope.selected.select = [];
                        return;
                    }
                    row.flag = "update";
                    $state.go("priceedit");
                    dataDeliver.setter(row);
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };
    //查看
    $scope.column = function(row)
    {
        row.flag = "view";
        $state.go("priceedit");
        dataDeliver.setter(row);
    }
    //表格--------结束-------------------------
};

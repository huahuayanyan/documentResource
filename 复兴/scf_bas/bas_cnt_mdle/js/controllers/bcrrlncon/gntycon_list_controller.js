/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var gntyconlistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
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
        totalRecord: 0};
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm = {conStat:"1"};
            $scope.selected.select=[];//清空选项s
        })
    };
    //搜索查询
    $scope.submit_onClick =function(){
        $scope.queryTable();
    };
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bCrrGntyCon:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bCrrGntyConService/findBCrrGntyConByPage",data);
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
        if($scope.conditionForm.gutNm!=null) {
            $scope.gutcontent.param = {
                custId: $scope.conditionForm.gutNm,
                custNm: $scope.conditionForm.gutNm
            };
        }
    });
    /**
     * 担保人名称查询加载结束
     */
    /**
     * 业务品种筛选开始
     */
    $scope.productNameContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBusinessTypeByPage",
        param:{ tFactType:"0" },
        split:",",//分隔符
        extentColumn:"vidPrdNm",
        column:["productName","productId"]//展示内容
    };
    $scope.productNamedooextent = function(ds){
        $scope.conditionForm.vidPrdNm=ds.productName;
        $scope.conditionForm.vidPrdId=ds.productId; //业务品种
    };
    $scope.$watch("conditionForm.vidPrdNm",function(a, b){
        $scope.productNameContent.param ={
            productId:$scope.conditionForm.vidPrdNm,
            productName:$scope.conditionForm.vidPrdNm,
            tFactType:"0"
        };
        if($scope.conditionForm.vidPrdNm==null||$scope.conditionForm.vidPrdNm==""){
            $scope.conditionForm.vidPrdId=null;
        }
    });
    /**
     * 业务品种筛选结束
     */
    //补录
    $scope.update_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $scope.otherform = $scope.selected.select[0];
            var flag = "update";
            var conId = $scope.selected.select[0].conId;
            $common.get_asyncData("bCrrGntyConService/findBCrrGntyConByConId",{conId:conId}).then(function(res){
                var gnty;
                if (res.errorCode =="SUC"){
                    gnty = res.contextData;
                    $scope.otherform.row = gnty;
                    $scope.otherform.flag = flag;
                    $state.go("edit");
                    dataDeliver.setter($scope.otherform);
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };
    //查看
    $scope.view_onClick = function(row){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条抵质押合同记录！','showInform');
        }else{
            $scope.otherform = $scope.selected.select[0];
            var flag = "view";
            var conId = $scope.selected.select[0].conId;
            $common.get_asyncData("bCrrGntyConService/findBCrrGntyConByConId",{conId:conId}).then(function(res){
                var gnty;
                if (res.errorCode =="SUC"){
                    gnty = res.contextData;
                    $scope.otherform.row = gnty;
                    $scope.otherform.flag = flag;
                    $state.go("edit");
                    dataDeliver.setter($scope.otherform);
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };
    $scope.column = function(row){
        $scope.otherform = row;
        var flag = "view";
        var conId = row.conId;
        $common.get_asyncData("bCrrGntyConService/findBCrrGntyConByConId",{conId:conId}).then(function(res){
            var gnty;
            if (res.errorCode =="SUC"){
                gnty = res.contextData;
                $scope.otherform.row = gnty;
                $scope.otherform.flag = flag;
                $state.go("edit");
                dataDeliver.setter($scope.otherform);
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //表格--------结束-------------------------
};

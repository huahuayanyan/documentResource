/**
 * Created by htrad0036 on 2017/2/21.
 */

//押品流水查询
var inspectWhseMngListController = function ($scope, $common, $state, dataDeliver) {

    $scope.conditionForm = {
    };//初始化查询条件对象
    $scope.datasource = {//初始化表格对象
    };
    $scope.selectSource = {
        ds:[]
    };
    $scope.selected = {//初始化对象
        select: []
    };
    $scope.conf = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };

    //业务品种
    $scope.supply = {
        type:"table",//展示类型table  tree
        url:"bPrdInfoService/selectBPrdInfoBySelect",//请求url
        //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"-",//分隔符
        extentColumn:"productName",
        column:["productName"]//展示内容
    };
    $scope.doSupply = function(ds){
        $scope.conditionForm.prdId=ds.productId;
    };
    $scope.$watch("conditionForm.prdName",function(){
        $scope.supply.param ={
            productName:$scope.conditionForm.prdName,
        };
        if($scope.conditionForm.prdName==null||$scope.conditionForm.prdName==""){
            $scope.conditionForm.prdId=null;
            $scope.conditionForm.prdName=null;
        }
    });

    //树==上级机构
    $scope.content = {
        type:"table",//展示类型table  tree
        url:"mortgageInoutService/selectOrg",//请求url
        //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"-",//分隔符
        extentColumn:"brName",
        column:["brNo","brName"]//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.conditionForm.brCode=ds.brNo;
    };
    $scope.$watch("conditionForm.brName",function(){
        $scope.content.param ={
            brNameLike:$scope.conditionForm.brName
        };
        if($scope.conditionForm.brName==null||$scope.conditionForm.brName==""){
            $scope.conditionForm.brCode=null;
            $scope.conditionForm.brName=null;
        }
    });

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize", function () {
        $scope.queryTable();
    });
    //点击查询之后的搜索
    $scope.submit_onClick = function () {
        $scope.queryTable();
        $scope.selected.select = [];
    };
    //查询操作
    $scope.queryTable = function (paramData) {
        var data = {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            conditionForm: $scope.conditionForm
        };
        if($scope.conditionForm.prdId==null||$scope.conditionForm.prdId==""){
            if($scope.conditionForm.prdName!=null&&$scope.conditionForm.prdName!=""){
                $common.get_tipDialog('请从下拉框选择业务品种！','showError');
                return;
            }
        }
        if($scope.conditionForm.brCode==null||$scope.conditionForm.brCode==""){
            if($scope.conditionForm.brName!=null&&$scope.conditionForm.brName!=""){
                $common.get_tipDialog('请从下拉框选择经办机构！','showError');
                return;
            }
        }
        data.conditionForm.flag = 1;
        var promise = $common.get_asyncData("inspectWhseMngService/queryCheckStockByPage", data);
        promise.then(function (res) {
            var data1;
            if (res.errorCode == "SUC") {
                data1 = res.contextData;
                $scope.datasource.ds = data1.records;
                $scope.conf.totalRecord = data1.totalRecord;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    };

    //新增按钮
    $scope.addBtn_onClick = function(){
        var data= {
            flag:"add"
        };
        dataDeliver.setter(data);
        $state.go("inspectWhseMngQry");
    };

    //修改按钮
    $scope.updateBtn_onClick = function(){
        if($scope.selected.select.length == 1){
            var data= {
                protocol_value:$scope.selected.select[0],
            };
            dataDeliver.setter(data);
            $state.go("tree");
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };

    //查看按钮
    $scope.viewBtn_onClick = function(){
        if($scope.selected.select.length == 1){
            var data= {
                protocol_value:$scope.selected.select[0],
                view : true,
            };
            dataDeliver.setter(data);
            $state.go("tree");
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };

    //重置按钮
    $scope.rebort_onClick = function () {
        $scope.$apply(function(){
            $scope.conditionForm = {};
        })
    };
};
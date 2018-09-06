/**
 * Created by htrad0036 on 2017/2/21.
 */

//提货台帐查询
var triDeliveryQryController = function ($scope, $common, $state, dataDeliver) {

    $scope.conditionForm = {
    };//初始化查询条件对象
    $scope.datasource = {//初始化表格对象
    };
    $scope.selectSource = {
    };
    $scope.selected = {//初始化对象
        select: []
    };
    $scope.conf = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };
    //树==上级机构
    $scope.content = {
        type:"tree",//展示类型table  tree
        url:"orgService/selectBctlTree",//请求url
        param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"",//分隔符
        extentColumn:"",
        column:['brName']//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.conditionForm.treeName=ds.brName;
        $scope.conditionForm.brcode=ds.brNo;
    };
    $scope.$watch("conditionForm.treeName",function(a, b){
        $scope.content.param ={
            brName:$scope.conditionForm.treeName
        };
        if($scope.conditionForm.treeName==null||$scope.conditionForm.treeName==""){
            $scope.conditionForm.brcode=null;
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
        var promise = $common.get_asyncData("triDeliveryService/queryTriDeliveryByPage", data);
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

    //重置按钮
    $scope.rebort_onClick = function () {
        $scope.$apply(function(){
            $scope.conditionForm = {};
            $scope.selected.select=[];//清空选项s
        })
    };
};
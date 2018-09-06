/**
 * Created by htrad0036 on 2017/2/21.
 */

//押品调价查询
var mortAPTQueryListController = function ($scope, $common, $state, dataDeliver) {

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

    // 押品一级
    $scope.levelOneContent = {
        type:"table",//展示类型table  tree
        url:"bPbcMtgClassService/findBPbcMtgClassForThreeLevelSelect",
        //param:{levels:"1"},    //应收账款融资
        //split:"",//分隔符
        extentColumn:"mortgageName",
        column:["mortgageName"]//展示内容
    };
    $scope.levelOnedooextent = function(ds){
        $scope.conditionForm.One=ds.mortgageCode;
        $scope.conditionForm.oneName=ds.mortgageName;
        $scope.conditionForm.parentCode = ds.mortgageCode;
        $scope.levelTwoContent.param ={
            levels:"2",
            parentCode:$scope.conditionForm.parentCode
        }
    };
    $scope.$watch("conditionForm.oneName",function(newVal,oldVal){
        if($scope.conditionForm.oneName ==''){
            $scope.conditionForm.One='';
        }
        if($scope.conditionForm.Two){
            $scope.conditionForm.Two=null;
            $scope.conditionForm.twoName="";
        }
        if($scope.conditionForm.Three){
            $scope.conditionForm.Three=null;
            $scope.conditionForm.threeName="";
        }
        $scope.levelOneContent.param ={
            levels:"1",
            mortgageName:$scope.conditionForm.oneName
        };
    });
    //押品二级
    $scope.levelTwoContent = {
        type:"table",//展示类型table  tree
        url:"bPbcMtgClassService/findBPbcMtgClassForThreeLevelSelect",
        param:{levels:"2"},
        //split:"",//分隔符
        extentColumn:"mortgageName",
        column:["mortgageName"]//展示内容
    };
    $scope.levelTwodooextent = function(ds){
        $scope.conditionForm.Two=ds.mortgageCode;
        $scope.conditionForm.twoName=ds.mortgageName;
        $scope.conditionForm.ext1=ds.mortgageCode;
        $scope.levelThreeContent.param ={
            levels:"3",
            ext1:$scope.conditionForm.ext1
        }
    };
    $scope.$watch("conditionForm.twoName",function(newVal,oldVal){
        if($scope.conditionForm.twoName ==''){
            $scope.conditionForm.Two='';
        }
        if($scope.conditionForm.Three){
            $scope.conditionForm.Three=null;
            $scope.conditionForm.threeName="";
        }
        $scope.levelTwoContent.param ={
            levels:"2",
            parentCode:$scope.conditionForm.One,
            mortgageName:$scope.conditionForm.twoName,
        };
    });
    //押品三级
    $scope.levelThreeContent = {
        type:"table",//展示类型table  tree
        url:"bPbcMtgClassService/findBPbcMtgClassForThreeLevelSelect",
        param:{levels:"3"},
        //split:"",//分隔符
        extentColumn:"mortgageName",
        column:["mortgageName"]//展示内容
    };
    $scope.levelThreedooextent = function(ds){
        $scope.conditionForm.Three=ds.mortgageCode;
        $scope.conditionForm.threeName=ds.mortgageName;
    };
    $scope.$watch("conditionForm.threeName",function(newVal,oldVal){
        if($scope.conditionForm.threeName ==''){
            $scope.conditionForm.Three='';
        }
        $scope.levelThreeContent.param ={
            levels:"3",
            ext1:$scope.conditionForm.Two,
            mortgageName:$scope.conditionForm.threeName,
        };
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

        if($scope.conditionForm.brCode==null||$scope.conditionForm.brCode==""){
            if($scope.conditionForm.brName!=null&&$scope.conditionForm.brName!=""){
                $common.get_tipDialog('请从下拉框选择经办机构！','showError');
                return;
            }
        }

        var data = {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            conditionForm: $scope.conditionForm
        };
        data.conditionForm.flag = 1;
        var promise = $common.get_asyncData("mortAdjustPriceTypeQryService/getAdjustPriceTypeList", data);
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

    //查看按钮
    $scope.column = function(row){
        var data= {
            data : row,
        };
        dataDeliver.setter(data);
        $state.go("changeMortSokDel");
    };

    //重置按钮
    $scope.rebort_onClick = function () {
        $scope.$apply(function(){
            $scope.conditionForm = {};
            $scope.levelOneContent.param ={
                levels:"1",
            };
            $scope.levelTwoContent.param ={
                levels:"2",
            };
            $scope.levelThreeContent.param ={
                levels:"3",
            };
        })
    };
};
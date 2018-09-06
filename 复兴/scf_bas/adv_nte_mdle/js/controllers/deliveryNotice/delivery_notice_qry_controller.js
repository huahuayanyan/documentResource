/**
 * Created by htrad0036 on 2017/2/17.
 */

//提货通知书列表
var deliveryNoticeQryController = function ($scope, $common, $state, dataDeliver) {

    $scope.conditionForm = {productId:'1210010',
        noticeType:"80"
    };//初始化查询条件对象
    $scope.productSource={
    		  ds:[
    	            {code:"1210010",codeName:'担保提货'}
    	        ]
    };
    $scope.datasource = {//初始化表格对象

    };
    $scope.selectSource = {
        ds:[
            {key:"80",value:'担保提货提货通知书'}
        ]
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
        var promise = $common.get_asyncData("deliveryNoticeService/queryDeliveryNteByPage", data);
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
//查看操作！
    $scope.column = function(row){
        $common.get_ngDialog('deliveryNotice/delivery_notice_qry_view.html', $scope
            ,["$scope",function(dialogScope){
                deliveryNoticeQryViewController(dialogScope,$scope,$common,row);
            }],"提货通知书基本信息",{showClose:true});
    };
    //重置按钮
    $scope.rebort_onClick = function () {
        $scope.$apply(function(){
            $scope.conditionForm = {productId:"1210010",noticeType:"80"};
            $scope.selected.select=[];//清空选项s
        })
    };
    $scope.view_onClick = function(){
        if($scope.selected.select.length == 1){
            var id = $scope.selected.select[0].id;//定义选中参数id
            var noticeType = $scope.selected.select[0].noticeType;
            var appno = $scope.selected.select[0].appno;
            // var param={id:"1B63J91TS007A2C7FCAA0000939BE0E9",noticeType:"71",appno:"CETKT2017011000020"};
            var param={id:id,noticeType:noticeType,appno:appno};
            toPrint(param);
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
};
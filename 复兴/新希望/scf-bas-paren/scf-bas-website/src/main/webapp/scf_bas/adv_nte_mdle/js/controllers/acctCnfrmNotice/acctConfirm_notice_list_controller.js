
//收款确认通知书列表
var AcctConfirmNoticeListController = function ($scope, $common, $state, dataDeliver) {

    //初始化查询条件对象
    $scope.conditionForm = {
        productId_Q:'1210020'
    };


    $scope.datasource = {//初始化表格对象
    };
    $scope.selected = {//初始化对象
    };

    $scope.selectSource = {
        ds:[
            {key:"77",value:'先票/款后货流贷收款确认通知书'},
            {key:"79",value:'先票/款后货银承收款确认通知书'}
        ]
    };

    $scope.productSource = {
        ds:[
            {key:"1210020",value:'先票/款后货'},
        ]
    };

    $scope.conf = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };
    //productSource();

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize", function () {
        $scope.queryTable();
    });

//树==上级机构
    $scope.content = {
        type:"tree",//展示类型table  tree
        url:"orgService/selectBctlTree",//请求url
        param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"",//分隔符
        extentColumn:"brname_Q",
        column:['brName']//展示内容
    };

    $scope.dooextent = function(ds){
        $scope.conditionForm.brname_Q=ds.brName;
        $scope.conditionForm.brcode=ds.brNo;
    };



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
            qryVO: $scope.conditionForm
        };
        var promise = $common.get_asyncData("bFourWareAcctConfirmNoticeService/queryAcctConfirmNoticeByPage", data);
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
        $common.get_ngDialog('acctCnfrmNotice/acctCnfrm_notice_view_qry.html', $scope
            ,["$scope",function(dialogScope){
                AcctConfirmNoticeViewController(dialogScope,$scope,$common,row);
            }],"收款确认通知书基本信息",{showClose:true});
    };
    //重置按钮
    $scope.rebort_onClick = function () {
        $scope.$apply(function(){
            $scope.conditionForm = {productId_Q:"1210020"};
            $scope.selected.select=[];//清空选项s
        })
        $scope.queryTable();
    };
    $scope.view_onClick = function(){
        if($scope.selected.select.length == 1){
            var id = $scope.selected.select[0].id;//定义选中参数id
            var noticeType = $scope.selected.select[0].noticeType;
            var appno = $scope.selected.select[0].appno;
            var param={id:id,noticeType:noticeType,appno:appno};
            toPrint(param);
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
};
/**
 * Created by htrad0036 on 2017/1/19.
 */

var promptPayNoticeController = function($scope,$common,$state,dataDeliver) {

    $scope.conditionForm={};//初始化条件查询框
    //业务品种筛选 bussType，conditionForm，bussTypeContent,bussTypedooextent
    $scope.bussTypeContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBusinessType",
        param:{ tFactType:"2" },    //应收账款池融资
        /*split:",",//分隔符*/
        extentColumn:"productName",
        column:["productName"]//展示内容
    };
    $scope.bussTypedooextent = function(ds){
        $scope.conditionForm.vidBusTyp=ds.productId; //业务品种
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
        $scope.conditionForm.brCode=ds.brNo;
    };
    $scope.$watch("conditionForm.bussTypeName",function() {
        $scope.bussTypeContent.param = {
            productName: $scope.conditionForm.bussTypeName,
            tFactType: "2"   //应收账款池融资
        };
    });
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //查询操作brName,brNo
    $scope.queryTable = function(){
        if($scope.conditionForm.noticeType==null||$scope.conditionForm.noticeType==''){
            $scope.conditionForm.noticeType = '117';//应收账款提示付款通知书
        }

        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            conditionForm:$scope.conditionForm
        };
        var promise = $common.get_asyncData("promptPaymentNoticeQryService/queryPromptPayNotice",data);
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


    //点击查询之后的搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //重置按钮
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm = {noticeType:"117"};
            $scope.selected.select=[];//清空选项s
        })
    };

    ////查看详情
    //$scope.detail_onClick =function() {
    //    if ($scope.selected.select.length != 1) {
    //        $common.get_tipDialog('请选择一条记录！', 'showInform');
    //    } else {
    //        var data =  $scope.selected.select[0];
    //        $common.get_ngDialog('debtPoolPromptPaymentNotice/debtPoolPromptPaymentNoticeDTL.html',$scope,["$scope",function(dialogScope){
    //            promptPayNtcDtlController(dialogScope, $common, '',  data);
    //        }],'', {showClose: true});
    //    }
    //}
    //查看操作！
    $scope.column = function(row){
        $common.get_ngDialog('debtPoolPromptPaymentNotice/debtPoolPromptPaymentNoticeDTL.html', $scope
            ,["$scope",function(dialogScope){
                promptPayNtcDtlController(dialogScope, $common, '', row);
            }],"应收账款提示付款通知书基本信息",{showClose:true});
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

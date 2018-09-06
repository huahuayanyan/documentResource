/**
 * Created by htrad0036 on 2017/1/19.
 */

var promptPayNoticeController = function($scope,$common,$state,dataDeliver) {

    $scope.conditionForm={
        noticeTypeSet:[116,117,118,119,120,121]
    };//初始化条件查询框

    $scope.noticeTypeDataSrc={
        ds:[
            {nteKey:"116",nteVal:'应收账款融资-提示付款通知书'},
            {nteKey:"117",nteVal:'应收账款池融资-提示付款通知书'},
            {nteKey:"118",nteVal:'国内双保理-应收账款提示付款通知书'},
            {nteKey:"119",nteVal:'信保保理-应收账款提示付款通知书'},
            {nteKey:"120",nteVal:'租赁保理-应收租金提示付款通知书'},
            //{nteKey:"123",nteVal:'订单融资-应收账款账款提示付款函'},
            {nteKey:"121",nteVal:'应收账款质押-提示付款通知书'}
            ]};

    //***************************************************************//
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

    //***************************************************************//

    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    $scope.productselect = {//业务品种下拉框
        ds:[]
    };

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.productSourceList();
        $scope.queryTable();
    });
    //查询操作brName,brNo
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            commonQueryVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bCntBcpNoticeQryService/queryFactoringNoticeCommon",data);
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

    //查询业务品种
    $scope.productSourceList = function(){
        //业务品种下拉框
        var bPrdInfo = {parentId:"3000",status:"1"};
        var data = {bPrdInfo:bPrdInfo};
        var promise = $common.get_asyncData("bcntBcpAppliBaseInfoService/getProductId",data);
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.productselect.ds = res.contextData||[];
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    };

    /**
     *  融资企业查询加载开始
     */
    $scope.custcontent = {
        type:"table",//展示类型table  tree
        url:"bcntBcpAppliBaseInfoService/queryBCrmBaseInfoSource",
        param:{flag:"cont"},
        split:",",//分隔符
        extentColumn:"sallerName",
        column:["cname","custcd"]//展示内容
    };
    $scope.dooextend = function(ds){
        $scope.conditionForm.sallerName = ds.cname;
    };
    $scope.$watch("conditionForm.sallerName",function(){
        $scope.custcontent.param ={flag:"cont",custcd:$scope.conditionForm.sallerName,cname:$scope.conditionForm.sallerName};
    });
    /**
     *  融资企业查询加载结束
     */

    //点击查询之后的搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //重置按钮
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm = {
                noticeTypeSet:[116,117,118,119,120,121]
            };
            $scope.selected.select=[];//清空选项s
        })
    };

    //查看操作！
    $scope.column = function(row){
        //$common.get_ngDialog('noticeqry/debtPromptPayNotice/debtPromptPayNoticeDtl.html', $scope
        //    ,["$scope",function(dialogScope){
        //        promptPayNtcDtlController(dialogScope, $common, '', row);
        //    }],"应收账款提示付款通知书基本信息",{showClose:true});
        var param = {
            id:"1BJ9DNGK1000A3C7FCAA000014792BBC",
            noticeType:"116",
            num:row.num,
            appno:row.appno,
            mastContno:row.mastContno,
            invokPhase:"13"
        };
        toFactoringPrint(param);
    };
    $scope.view_onClick = function(){
        if($scope.selected.select.length == 1){
            //若提示付款通知书不同业务品种打印模版不同，则通知书编号直接使用选中通知书的编号，现在写死
            var param = {
                id:"1BJ9DNGK1000A3C7FCAA000014792BBC",
                noticeType:"116",
                num:$scope.selected.select[0].num,
                appno:$scope.selected.select[0].appno,
                mastContno:$scope.selected.select[0].mastContno,
                invokPhase:"13"
            };
            toFactoringPrint(param);
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
};

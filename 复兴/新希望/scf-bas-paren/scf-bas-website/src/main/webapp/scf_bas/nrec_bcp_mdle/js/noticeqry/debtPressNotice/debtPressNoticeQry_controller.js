/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2017/1/13
 */

var debtPressNoticeController = function($scope,$common,$state,dataDeliver) {
    var data1= dataDeliver.getter();
    $scope.conditionForm={
        noticeTypeSet:[33,110,111,112,113,115]
    };//初始化条件查询框

    $scope.noticeTypeDataSrc={
        ds:[{nteKey:"33",nteVal:'应收账款融资-应收账款催收通知书'},
            //{nteKey:"108",nteVal:'订单融资-应收账款催收通知书'},
            {nteKey:"110",nteVal:'应收账款池融资-应收账款池融资催收'},
            {nteKey:"111",nteVal:'国内双保理-应收账款催收通知书'},
            {nteKey:"112",nteVal:'信保保理-应收账款催收通知书'},
            {nteKey:"113",nteVal:'租赁保理-应收账款催收通知书'},
            {nteKey:"115",nteVal:'应收账款质押-应收账款质押催收通知书'}]};

    //===========================================//
    //业务品种筛选 bussType，conditionForm，bussTypeContent,bussTypedooextent
    $scope.bussTypeContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBusinessType",
        param:{ tFactType:"1" },    //应收账款融资
        /*split:",",//分隔符*/
        extentColumn:"productName",
        column:["productName"]//展示内容
    };
    $scope.bussTypedooextent = function(ds){
        $scope.conditionForm.vidBusTyp=ds.productId; //业务品种
    };
    //===========================================//

    //*******************************************//
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
    $scope.$watch("conditionForm.bussTypeName",function() {
        $scope.bussTypeContent.param = {
            productName: $scope.conditionForm.bussTypeName,
            tFactType: "1"  //应收账款融资
        };
    });
    //******************************************//

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
    $scope.queryTable = function(paramData){
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
    //重置按钮accountNo,accountType
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm= {
                noticeTypeSet:[33,110,111,112,113,115]
            };
            $scope.selected.select=[];//清空选项s
        })
    };
    //查看操作！
    $scope.column = function(row){
        //$common.get_ngDialog('debtPoolPressNotice/debtPoolPressNoticeDtl.html', $scope
        //    ,["$scope",function(dialogScope){
        //        debtPressNoticeDtlController(dialogScope,$scope,$common,row);
        //    }],"应收账款催收通知书基本信息",{showClose:true});
        var param = {
            id:"1BJ9T6IA2000A3C7FCAA0000174A5899",
            noticeType:"33",
            num:row.num,
            appno:row.appno,
            mastContno:row.mastContno,
            invokPhase:"07"
        };
        toFactoringPrint(param);
    };
    $scope.view_onClick = function(){
        if($scope.selected.select.length == 1){
            var param = {
                id:"1BJ9T6IA2000A3C7FCAA0000174A5899",
                noticeType:"33",
                num:$scope.selected.select[0].num,
                appno:$scope.selected.select[0].appno,
                mastContno:$scope.selected.select[0].mastContno,
                invokPhase:"07"
            };
            toFactoringPrint(param);
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
};

/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2017/1/13
 */

var debtPoolPressNoticeController = function($scope,$common,$state,dataDeliver) {
    var data1= dataDeliver.getter();
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
        totalRecord: 0}
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //查询操作brName,brNo
    $scope.queryTable = function(paramData){
        if($scope.conditionForm.noticeType==null||$scope.conditionForm.noticeType==''){
            $scope.conditionForm.noticeType = '110';//应收账款转让/出质通知书
        }
        var sallerName = $scope.conditionForm.sallerName;
        var mastContno = $scope.conditionForm.mastContno;
        var vidBusTyp = $scope.conditionForm.vidBusTyp;
        var noticeType = $scope.conditionForm.noticeType;
        var noticeStatus = $scope.conditionForm.noticeStatus;
        var jbjg = $scope.conditionForm.brCode;
        var startQf = $scope.conditionForm.startQf;
        var endQf = $scope.conditionForm.endQf;
        var startHz= $scope.conditionForm.startHz;
        var endHz = $scope.conditionForm.endHz;
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bNteNoticeBaseCon:{mastContno:mastContno,bussType:vidBusTyp,noticeType:noticeType,status:noticeStatus,brcode:jbjg,sallerName:sallerName,
                startQf:startQf, endQf:endQf, startHz:startHz, endHz:endHz}
        };
        var promise = $common.get_asyncData("rNteNoticeBaseService/findNoticeBaseInfoByCondition",data);
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
    //重置按钮accountNo,accountType
    $scope.rebort_onClick =function(){
//        $scope.conditionForm.sallerName = "";
//        $scope.conditionForm.mastContno = "";
//        $scope.conditionForm.vidBusTyp = "";
//        $scope.conditionForm.noticeType = "";
//        $scope.conditionForm.noticeStatus = "";
//        $scope.conditionForm.brCode = "";
//        $scope.conditionForm.startQf = "";
//        $scope.conditionForm.endQf = "";
//        $scope.conditionForm.startHz = "";
//        $scope.conditionForm.endHz = "";
//        $scope.queryTable();
    	$scope.$apply(function(){
            $scope.conditionForm = {noticeType:"110"};
            $scope.selected.select=[];//清空选项s
        })
    };
    //查看操作！
    $scope.column = function(row){
        $common.get_ngDialog('debtPoolPressNotice/debtPoolPressNoticeDtl.html', $scope
            ,["$scope",function(dialogScope){
                debtPoolPressNoticeDtlController(dialogScope,$scope,$common,row);
            }],"应收账款催收通知书基本信息",{showClose:true});
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

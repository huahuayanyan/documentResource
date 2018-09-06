/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/12
 */
var priceCompensationNoticeController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    $scope.conditionForm={
        bussType:"1220020",//业务品种默认值
        noticeType:"23"
    };//初始化查询条件对象
    //业务品种
    $scope.productSource = {
        ds:[{productKey:"1220020",productValue:'现货动态质押'},]
    };
    //通知书类型
    $scope.noticeSource = {
        ds:[{noticeKey:"23",noticeValue:'跌价补偿通知书'},]
    };
    $scope.datasource={//初始化表格对象
        ds:[]
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //经办机构
    $scope.content = {
        type:"table",//展示类型table  tree
        url:"mortgageInoutService/selectOrg",//请求url
        //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"-",//分隔符
        extentColumn:"brName",
        column:["brNo","brName"]//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.conditionForm.brcode=ds.brNo;
    };
    $scope.$watch("conditionForm.brName",function(){
        $scope.content.param ={
            brNameLike:$scope.conditionForm.brName
        };
        if($scope.conditionForm.brName==null||$scope.conditionForm.brName==""){
            $scope.conditionForm.brcode=null;
            $scope.conditionForm.brName=null;
        }
    });

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick = function(){
        $scope.conditionForm={
            bussType:"1220020",//业务品种默认值
            noticeType:"23"
        };
        $scope.selected.select=[];//清空选项
        $scope.$apply();
    };
    //搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //查询
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            NoticeQryPrintVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bNteNoticeBaseService/selectQuantityNoticeBaseInfoForPage",data);
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
};

/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Qinwei
 * @version     1.0
 * Create at:   2017/05/23
 */
var debtListController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {

    //初始化查询条件对象
    $scope.conditionForm={};
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //业务品种筛选 bussType，conditionForm，bussTypeContent,bussTypedooextent
    $scope.productselect = {//业务品种下拉框
        ds:[]
    };
    //卖方客户查询
    $scope.sellerContent = {
        type:"table",//展示类型table  tree
        url:"bcntBcpAppliBaseInfoService/queryBCrmBaseInfoSource",
        param:{flag:"cont"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"-",//分隔符*/
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.sellerExtent = function(ds){
        $scope.conditionForm.custcdSaller=ds.custcd;
    };
    //监听事件 ！功能简述1.当卖方客户名称，发生改变，并且点击查询按钮，则再次重新查询两个表
    $scope.$watch("conditionForm.cnameSeller",function(){//一旦改变开始查询业务合同
        if($scope.conditionForm.cnameSeller == ""){//如果卖方客户名称为空，则卖方那个客户号也是空
            $scope.conditionForm.custcdSaller=null;
        }
        $scope.sellerContent.param ={
            flag:"cont",//授信客户
            cname:$scope.conditionForm.cnameSeller,
            custcd:$scope.conditionForm.cnameSeller
        }
    });
    //买方客户查询
    $scope.buyerContent = {
        type:"table",//展示类型table  tree
        url:"bcntBcpAppliBaseInfoService/queryBCrmBaseInfoSource",
        param:{flag2:"cont"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"-",//分隔符*/
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.buyerExtent = function(ds){
        $scope.conditionForm.custcdBuyer=ds.custcd;
    };
    $scope.$watch("conditionForm.cnameBuyer",function(){
        if($scope.conditionForm.cnameBuyer == ""){
            $scope.conditionForm.custcdBuyer=null;
        }
        $scope.buyerContent.param ={
            flag2:"cont",
            cname:$scope.conditionForm.cnameBuyer,
            custcd:$scope.conditionForm.cnameBuyer
        }
    });

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.productSourceList();
        $scope.queryTable();
    });
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
    $scope.rebort_onClick =function(){
        $scope.conditionForm={};
        $scope.selected.select=[];
        $scope.$apply();
    };
    //点击查询之后的搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    //查询操作
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            commonQueryVO:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bCntBcpInfoBussQryService/getDebtQuery",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //查看明细
    $scope.detail_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{

            var debtCont=$scope.selected.select[0];
            var data = {pooldebtinfo:debtCont};

            $state.go("pooldebtdtl");
            dataDeliver.setter(data);

        }
    };

    $scope.procss_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            var debtCont=$scope.selected.select[0];
            var data = {pooldebtinfo:debtCont};
            $state.go("pooldebtprcs");
            dataDeliver.setter(data);

        }
    }

  
    //表格--------结束-------------------------
};

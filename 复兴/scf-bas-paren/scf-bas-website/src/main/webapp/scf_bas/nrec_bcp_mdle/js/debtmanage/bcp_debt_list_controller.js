/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var DebtInfoListController = function($scope,$common,$state,dataDeliver) {
    //console.log("userInfo信息："+JSON.stringify(userInfo));//用户信息，全局变量
    /*alert("userInfo信息："+JSON.stringify(userInfo));*/
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

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.productSourceList();
        $scope.queryTable();
    });
    //查询业务品种
    $scope.productSourceList = function(){
        //业务品种下拉框
        var bPrdInfo = {parentId:"3000",status:"1"};
        var data = {bPrdInfo:bPrdInfo}
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
            value:$scope.conditionForm
        };
        var promise = $common.get_asyncData("rbcpDebtInfoService/findRBcpDebtInfoByPage",data);
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

    /**
     *  融资企业查询加载开始
     */
    $scope.custcontent = {
        type:"table",//展示类型table  tree
        url:"bcntBcpAppliBaseInfoService/queryBCrmBaseInfoSource",
        param:{flag:"cont"},
        split:",",//分隔符
        extentColumn:"cnameSeller",
        column:["cname","custcd"]//展示内容
    };
    $scope.dooextend = function(ds){
        $scope.conditionForm.cnameSeller = ds.cname;
    };
    $scope.$watch("conditionForm.cname",function(){
        $scope.custcontent.param ={flag:"cont",custcd:$scope.conditionForm.cnameSeller,cname:$scope.conditionForm.cnameSeller};
    });
    /**
     *  融资企业查询加载结束
     */
    /**
     *  贸易对手查询加载结束
     */
    $scope.busiContent = {
        type:"table",//展示类型table  tree
        url:"bcntBcpAppliBaseInfoService/queryBCrmBaseInfoSource",
        param:{flag2:"cont"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"-",//分隔符*/
        extentColumn:"cnameBuyer",
        column:["custcd","cname"]//展示内容
    };
    $scope.busiExtent = function(ds)
    {
        $scope.conditionForm.cnameBuyer=ds.cname;
    };
    $scope.$watch("conditionForm.cnameBuyer",function(){
        $scope.busiContent.param ={
            flag2:"cont",
            cname:$scope.conditionForm.cnameBuyer,
            custcd:$scope.conditionForm.cnameBuyer
        }
    });
    /**
     *  贸易对手查询加载结束
     */

    //查看按钮
    $scope.view_onClick = function(){
        if($scope.selected.select.length == 1){
          var dataX=$scope.selected.select[0];
            dataDeliver.setter(dataX);
            $state.go("debtInfoEdit");
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };

    //账户信息查看操作！
    $scope.column = function(row){
        var data1= row;
        dataDeliver.setter(data1);
        $state.go("debtInfoEdit");
    }
    //应收账款历程信息
    $scope.progress_onClick = function(){
        if($scope.selected.select.length == 1){
                var data1= {
                    rBcpDebtInfo:$scope.selected.select[0],
                };
                dataDeliver.setter(data1);
                $state.go("progress");
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
};

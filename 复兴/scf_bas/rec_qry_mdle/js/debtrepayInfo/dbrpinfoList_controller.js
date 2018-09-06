/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var dbrpinfoListController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {

    //初始化查询条件对象
    $scope.conditionForm={
    };

    $scope.datasource={//初始化表格对象
        ds:[
        ]
    };

    $scope.selected={//初始化对象
        select: []
    };

    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    //树==上级机构
    $scope.content = {
        type:"tree",//展示类型table  tree
        url:"orgService/selectBctlTree",//请求url
        param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"",//分隔符
        extentColumn:"treeName",
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
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });

    //重置
    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
            $scope.conditionForm={};
            $scope.selected.select=[];//清空选项s
        })
    };

    //搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
    };

//todo
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            commonQueryVO:$scope.conditionForm
        };

        //(@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO,@ScubeParam("pageSize")int pageSize,@ScubeParam("pageNo")int pageNo);
        var promise = $common.get_asyncData("rBcpDebtRepaymentInfoQryService/getDebtRepaymentInfo",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
                console.log(JSON.stringify($scope.datasource.ds ));
                //for(var i=0;i<$scope.conf.totalRecord;i++){
                //    console.log(JSON.stringify($scope.datasource.ds[i] ));
                //}
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.selected.select=[];
    };

    //查看明细
    $scope.acctdtlcolumn = function(row){
        $state.go("dbrtacctdtl");
        dataDeliver.setter(row);
    };


    //查看购销合同
    $scope.bctbuycolumn = function(row){
        $state.go("dbrtacctdtl");
        dataDeliver.setter(row);
    };

    //$scope.debtCont={buyerCustcd:'',buyerName:''};
    $scope.buyerList;
    $scope.dptReg_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{

           var debtCont=$scope.selected.select[0];
           var data = {bCntDebtInfo:debtCont};

            $state.go("dsptRegAdd");
            dataDeliver.setter(data);

        }
    }

    $scope.regBack_onClick = function(){
        $state.go("dsptRegAdd");
    }

  
    //表格--------结束-------------------------
};

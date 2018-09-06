/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */

var threeConfirmDtlController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    $scope.otherform={};
    $scope.threeConfirmform={};
    var  bData =dataDeliver.getter();
    /**开票信息**/
    $scope.billconf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    $scope.billdatasource={//初始化表格对象
        ds: []
    };
    $scope.billselected={//初始化对象
        select: []
    };


    /**购销合同信息**/
    $scope.contconf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    $scope.contdatasource={//初始化表格对象
        ds: []
    };
    $scope.contselected={//初始化对象
        select: []
    };
    if(bData.flag=="task"){ //待办任务隐藏申请页面按钮
        $scope.hidebutton=true;
    }
    queryBaseInfo();
    queryBillList();
    queryContTradeList();
//根据合同编号加载合同基本信息
    function queryBaseInfo(){
        var data ={
            deliveryQryVO:{
                mastContno:bData.mastContno,
                debetNo:bData.debetNo
            }
        };
        var promise=$common.get_asyncData("aTcsThreeConfirmService/queryContOrProByMastContno",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.threeConfirmform=data;
                queryDebtInfo();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    /*根据借据编号加载出账信息**/
    function queryDebtInfo(){
        var data ={
            deliveryQryVO:{
                mastContno:bData.mastContno,
                debetNo:bData.debetNo
            }
        };
        var promise=$common.get_asyncData("aTcsThreeConfirmService/queryThreeConfirmByDebet",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
               // $scope.debtform=data;
                $.extend($scope.threeConfirmform,res.contextData); //合并
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }

    //根据借据编号查询开票信息
    function queryBillList(){
        var data ={
            pageNo: $scope.billconf.pageNo,
            pageSize: $scope.billconf.pageSize,
            deliveryQryVO:{
                mastContno:bData.mastContno,
                debetNo:bData.debetNo
            }
        };
        var promise=$common.get_asyncData("aTcsThreeConfirmService/queryThreeConfirmBillListByPage",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.billdatasource.ds =data.records;
                $scope.billconf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    //根据借据编号查询购销合同信息
    function queryContTradeList(){
        var data ={
            pageNo: $scope.billconf.pageNo,
            pageSize: $scope.billconf.pageSize,
            deliveryQryVO:{
                mastContno:bData.mastContno,
                debetNo:bData.debetNo
            }
        };
        var promise=$common.get_asyncData("aTcsThreeConfirmService/queryConfirmContTradeListByPage",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.contdatasource.ds =data.records;
                $scope.contconf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    //卖方名称
    $scope.coreNmContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.coreNmdooextent = function(ds){
        $scope.threeConfirmform.coreCustcd=ds.custcd;
        $scope.threeConfirmform.coreNm=ds.cname;
    };
    $scope.$watch("threeConfirmform.coreNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.coreNmContent.param ={
            coreFlag:"1", //核心厂商
            cname:$scope.threeConfirmform.cname
            // custcd:$scope.otherform.custcd
        };

    });

//买方名称
    $scope.cnameContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.threeConfirmform.custcd=ds.custcd;
        $scope.threeConfirmform.cname=ds.cname;
    };
    $scope.$watch("threeConfirmform.cname",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.cnameContent.param ={
            creditFlag:"1", //授信客户
            cname:$scope.threeConfirmform.cname
        };
    });

    /**
     * 业务品种筛选
     */
    $scope.productNameContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBusinessType",
        param:{ tfactType:"1" },    //应收账款融资
        split:",",//分隔符
        extentColumn:"productName",
        column:["productName","productId"]//展示内容
    };
    $scope.productNamedooextent = function(ds){
        $scope.threeConfirmform.productName=ds.productName;
        $scope.threeConfirmform.productId=ds.productId; //业务品种
        $scope.threeConfirmform.factType=ds.factType;
        $scope.threeConfirmform.financingType=ds.financingType;
    };
    $scope.$watch("threeConfirmform.productName",function(newVal,oldVal){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.productNameContent.param ={
            productName:$scope.threeConfirmform.productName,
            //productId:$scope.otherform.supplyChainPdId,
            tFactType:"1"  //应收账款融资
        };
    });

//购销合同查看
    $scope.column = function(row){
        //dataDeliver.setter(row);//20170321：这里会导致参数被覆盖，tab页面跳转会出错
        $common.get_ngDialog('atcsthreeConfirm/contTradeInfoView.html',$scope
            ,["$scope",function(dialogScope){
                //bicrinfoSubViewController(dialogScope,$scope,dataDeliver,$common,"view");
                dialogScope.contform={};
                dialogScope.conf= {//初始化分页对象
                    pageNo: 1,
                    pageSize: 10,
                    totalRecord: 0};

                dialogScope.datasource={//初始化表格对象
                    ds: []
                };
                dialogScope.selected={//初始化对象
                    select: []
                };
                queryContBuyDtl();
                queryContBuyMprotList();
                //购销合同基本信息
                function queryContBuyDtl(){
                    var data ={
                        deliveryQryVO:{
                            tradeContno:row.tradeContno
                        }
                    };
                    var promise=$common.get_asyncData("aTcsThreeConfirmService/queryContBuyInfoDtl",data);
                    promise.then(function (res) {
                        if(res.errorCode=="SUC"){
                            data = res.contextData;
                            dialogScope.contform=data;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    })
                };
                //采购商品信息列表
                function queryContBuyMprotList(){
                    var data ={
                        pageNo: dialogScope.conf.pageNo,
                        pageSize: dialogScope.conf.pageSize,
                        deliveryQryVO:{
                            tradeContno:row.tradeContno
                        }
                    };
                    var promise=$common.get_asyncData("aTcsThreeConfirmService/queryContBuyMprotListByPage",data);
                    promise.then(function (res) {
                        if(res.errorCode=="SUC"){
                            data = res.contextData;
                            dialogScope.datasource.ds =data.records;
                            dialogScope.conf.totalRecord = data.totalRecord;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    })
                };
                //返回
                dialogScope.closeThisDialog_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"查看明细",{showClose:true});
    };
    $scope.save_onClick = function(){
        //点击按钮之后按钮变为不可用
        $scope.savedisable = true;
            var data = {
                threeConfirmVO: $scope.threeConfirmform
            };
          var primise = $common.get_asyncData("aTcsThreeConfirmService/threeConfirmApplySubmit", data);
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    //$scope.queryTable();
                    //$scope.selected.select = [];
                    $common.get_tipDialog('提交成功！', 'showSuccess');
                    //$state.go("bsysthreeProtocol");
                    $scope.back_onClick();
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
                $scope.savedisable= false; //返回后按钮可用
            });
    };
    $scope.back_onClick = function () {
        $state.go("threeConfirmList");
    };
    //表格--------结束-------------------------
};

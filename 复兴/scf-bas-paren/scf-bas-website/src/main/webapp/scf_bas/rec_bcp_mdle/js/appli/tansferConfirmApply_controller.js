/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var TransferConfirmApplyController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    var dataX=dataDeliver.getter();
    var appno=dataX.appno;//业务申请号
    var debtInfo={};
    //费用信息初始化
    $scope.otherform={};//初始化页面form
    $scope.costDatasource={//初始化表格对象
        ds:[]
    };
    $scope.costSelected={//初始化对象
        select: []
    };
    $scope.costConf= {//初始化分页对象
        pageNo: 1,
        pageSize: 1,
        totalRecord: 1};
    //费用监听分页
    $scope.$watch("costConf.pageNo+costConf.pageSize",function(){
        $scope.queryCostTable();
        $scope.queryForm();
    });
    //应收账款转让表单据信息
    $scope.bcpDatasource={//初始化表格对象
        ds:[]
    };
    $scope.bcpSelected={//初始化对象
        select: []
    };
    $scope.bcpConf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //应收账款转让明细信息监听分页
    $scope.$watch("bcpConf.pageNo+bcpConf.pageSize",function(){
        $scope.queryBcpTable();
    });
    //申请基本信息查询赋值给页面
    $scope.queryForm = function(){
        var rBcpAppliBussInfo={
            appno:appno
        }
        var promise = $common.get_asyncData("rBcpAppliBussInfoService/findBcpAppliBussInfoByKey",{rBcpAppliBussInfo:rBcpAppliBussInfo});
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.otherform = res.contextData;
                var promise2 = $common.get_asyncData("bCntDebtInfoService/findBCntDebtInfoByKey",{key:$scope.otherform.mastContno});
                promise2.then(function(res1){
                    if (res1.errorCode =="SUC"){
                        debtInfo=res1.contextData
                        $scope.otherform.bussTypeName=res1.contextData.bussTypeName
                        var bussType=$scope.otherform.bussType
                        //todo!!!!实际上这里应该还有4种现在只涉及2个，先这样写，以后再改
                        if(bussType=="1230040" || bussType=="1230060"||bussType=="1230050"){//国内保理池，出口退税池,应收账款质押池
                            $scope.otherform.factType="8"//保理池融资
                            $scope.otherform.mastContno1=$scope.otherform.mastContno;
                            $scope.pool=false;
                            $scope.NoPool=true;
                        }
                        if(bussType=="1230010"||bussType=="1230020"||bussType=="1230030"){//国内保理,反向保理，应收账款质押
                            $scope.otherform.factType="1"//保理融资
                            $scope.otherform.mastContno1=$scope.otherform.mastContno;
                            $scope.pool=true;
                            $scope.NoPool=false;
                        }
                    }else{
                        $common.get_tipDialog(res1.errorMsg,'showError');
                    }
                });
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //费用信息查询操作
    $scope.queryCostTable = function(){
        var rBcpAppliCostOut={appno:appno}
        var promise = $common.get_asyncData("rBcpAppliCostOutService/findRBcpAppliCostOutByKey",{rBcpAppliCostOut:rBcpAppliCostOut});
        promise.then(function(res){
            if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                if(res.contextData.id){
                    $scope.costDatasource.ds[0]= res.contextData
                }else{
                    //没有对应的费用信息则将对应的信息隐藏掉
                    $("#costinfo").css('display','none'); //不显示费用信息
                    $("#costDatasource").css('display','none'); //不显示费用信息
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //应收账款转让明细信息查询操作
    $scope.queryBcpTable = function(){
        var data= {
            pageNo: $scope.bcpConf.pageNo,
            pageSize: $scope.bcpConf.pageSize,
            value:{appno:appno}
        };
        var promise = $common.get_asyncData("rBcpAppliBussDtlService/findRBcpAppliBussDtlPageByPage",data);
        promise.then(function(res){
            if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                $scope.bcpDatasource.ds = res.contextData.records;
                $scope.bcpConf.totalRecord = res.contextData.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //-------------------------------------点击事件----------------------------------
    //editCost，addBill，deleteBill，save，commit，back
    //编辑费用信息(因为页面的字段里面没有对应的brcode字段，所以要设置一个字段。)
    $scope.editCost_onClick = function(){
        if($scope.costSelected.select.length == 1){
            if($scope.bcpDatasource.ds[0]){
                $common.get_ngDialog('transfer/appli_cost_out.html', $scope
                    ,["$scope",function(dialogScope){
                        AppliCostOutController(dialogScope,$scope,$common,dataDeliver,$state);
                    }],"费用明细编辑",{showClose:true});
            }else{
                $common.get_tipDialog('请先添加转让应收账款的凭证信息！','showInform');
            }
        }else{
            $common.get_tipDialog('请选择数据！','showInform');
        }

    }
    //添加票据信息（应收账款基本信息和业务合同号）
    $scope.addBill_onClick = function(){
        var row={
            bcpDatasource:$scope.bcpDatasource.ds,
            debtInfo:$scope.otherform
        }
        $common.get_ngDialog('transfer/bcp_base_info_list.html', $scope
            ,["$scope",function(dialogScope){
                BcpBaseInfoController(dialogScope,$scope,$common,dataDeliver,$state,row);
            }],"新增票据信息",{showClose:true});
    };

    //删除票据信息(这里的票据信删除必须要删除对应的后台的信息，并且将对于的票据信息的状态改变)
    //当要删除的数据没有申请号，则说明是刚刚添加，还未保存的数据，这个时候就不要到数据库里删除，直接在页面删除
    $scope.deleteBill_onClick = function() {
        if ($scope.bcpSelected.select.length != 1) {
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        } else {
            $common.get_tipDialog('确定删除吗?','showTip').then(function(){
                var dsArray = $scope.bcpDatasource.ds;
                var selected = $scope.bcpSelected.select[0];
                for (var i = 0; i < dsArray.length; i++) {
                    if (dsArray[i].billsNo == selected.billsNo) {
                        $scope.bcpDatasource.ds.splice(i, 1);
                        $scope.bcpSelected.select = [];
                        //改变转让出质总金额，转让份数，费用总额，实收费用
                        $scope.otherform.debtNum = parseFloat($scope.otherform.debtNum) - 1;//转让出质份数减一
                        if($scope.otherform.debtNum == 0){//没有出质票据,全部置空
                            $scope.otherform.totalFee="0.00";
                            $scope.otherform.totalReduce="0.00";$scope.otherform.receiveAmount="0.00";
                            //合同的费用收取方式按年时 费用空
                            if($scope.costDatasource.ds.length>0) {
                                $scope.costDatasource.ds[0].totalAmt = "0.00";//费用小计
                                $scope.costDatasource.ds[0].reduceAmt = "0.00";//减免金额
                                $scope.costDatasource.ds[0].receiveAmount = "0.00";//实收费用金额
                            }
                            $scope.otherform.totalDebtAmount="0.00";//转让出质总金额
                            $scope.$apply();
                        }else{
                            $scope.otherform.totalDebtAmount = $scope.otherform.totalDebtAmount - selected.billsAmountView;//转让出质总金额
                            //合同的费用收取方式按年时 费用空
                            if($scope.costDatasource.ds.length>0) {
                                //按比例计算费用的时候费用要改变
                                if($scope.costDatasource.ds[0].costCalcType == "2") {
                                    $scope.otherform.totalFee = $scope.otherform.totalDebtAmount * ($scope.costDatasource.ds[0].costRate / 100);
                                    var totalReduce = parseFloat($scope.otherform.totalReduce);//减免金额
                                    //如果删除一张票据之后，按比列收费算出的费用小于减免金额则需要调整减免金额
                                    if (totalReduce > $scope.otherform.totalFee) {
                                        $scope.otherform.totalReduce = $scope.otherform.totalFee;
                                        $scope.costDatasource.ds[0].reduceAmt = $scope.otherform.totalReduce;
                                    }
                                    $scope.costDatasource.ds[0].totalAmt = $scope.otherform.totalFee;
                                    $scope.costDatasource.ds[0].receiveAmount = $scope.otherform.receiveAmount;
                                }
                                $scope.otherform.receiveAmount=$scope.otherform.totalFee-$scope.otherform.totalReduce;

                            }
                            $scope.$apply();

                        }
                    }
                }
            });
        }
    };
    //这里是修改操作
    //这里是修改操作
    $scope.save_onClick=function(){
        //验证减免金额及费用小计
        var totalReduce= parseFloat($scope.otherform.totalReduce);//减免金额
        //按比列收费算出的费用小于减免金额则无法保存
        if(totalReduce > $scope.otherform.totalFee){
            $common.get_tipDialog('减免金额大于费用总计，请验证！', 'showInform');
            return;
        }
        if ($scope.bcpDatasource.ds.length <= 0) {//判断票据信息有没有添加 custcdSaller,cnameSeller
            $common.get_tipDialog("请添加票据信息！", 'showError');
            return false;
        }
        var costDatasource;
        if($scope.costDatasource.ds.length > 0){
            if ($scope.costDatasource.ds[0].brname && $scope.costDatasource.ds[0].brname != "") {//判断费用的收费网点有没有写
            } else {
                $common.get_tipDialog("请填写费用收取网点等费用明细信息！", 'showError');
                return false;
            }
            //如果有费用信息赋值给后台添加
            costDatasource= $scope.costDatasource.ds[0]
        }
        var data2={
            rBcpAppliBussInfo:$scope.otherform,//应收账款转让申请基本信息
            rBcpAppliCostOut:costDatasource,//应收装款申请转让费用信息
            rBcpAppliBussDtl:$scope.bcpDatasource.ds//应收账款申请明细信息
        }
        var promise = $common.get_asyncData("rBcpAppliBussInfoService/updateRBcpAppliBussInfo",data2);
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog('保存成功！', 'showSuccess');
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }
    //点击提交操作 commit，修改下通知书和申请基本信息表
    $scope.commit_onClick=function(){
        if($.doValidate("otherform")) {
            //验证减免金额及费用小计
            var totalReduce= parseFloat($scope.otherform.totalReduce);//减免金额
            //按比列收费算出的费用小于减免金额则无法保存
            if(totalReduce > parseFloat($scope.otherform.totalFee)){
                $common.get_tipDialog('减免金额大于费用总计，请验证！', 'showInform');
                return;
            }
            if ($scope.bcpDatasource.ds.length <= 0) {//判断票据信息有没有添加 custcdSaller,cnameSeller
                $common.get_tipDialog("请添加票据信息！", 'showError');
                return false;
            }
            var costDatasource;
            if($scope.costDatasource.ds.length > 0){
                if ($scope.costDatasource.ds[0].brname && $scope.costDatasource.ds[0].brname != "") {//判断费用的收费网点有没有写
                } else {
                    $common.get_tipDialog("请填写费用收取网点等费用明细信息！", 'showError');
                    return false;
                }
                //如果有费用信息赋值给后台添加
                costDatasource= $scope.costDatasource.ds[0]
            }
            $scope.otherform.factType="8";//保理池融资
            var data2={
                rBcpAppliBussInfo:$scope.otherform,//应收账款转让申请基本信息
                rBcpAppliCostOut:costDatasource,//应收装款申请转让费用信息
                rBcpAppliBussDtl:$scope.bcpDatasource.ds,//应收账款申请明细信息
            }
            var primiseX = $common.get_asyncData("rBcpAppliBussInfoService/submitRBcpAppliBussInfo",data2);
            primiseX.then(function (res) {
                if (res.errorCode == "SUC") {
                    $common.get_tipDialog('流程提交成功！', 'showSuccess');
                    //跳到主页列表页面
                    $scope.hide=true;
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        }
    }
    //返回按钮
    $scope.back_onClick = function() {
        $state.go("debtConList");
    }
};

/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var DebtPoolTransferController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    var dataX=dataDeliver.getter();
    var debtInfo=dataX.debtInfo;
    $scope.otherform=debtInfo;
    var mastContno=debtInfo.mastContno;//业务合同号
    $scope.otherformX={};
    $scope.otherformX.ext2='应收账款池融资转让申请';
    //页面经办机构信息
    var bCrmBrInfo={}
    var promiseA = $common.get_asyncData("bCrmBaseInfoService/findBCrmBrInfo",{bCrmBrInfo:bCrmBrInfo});
    promiseA.then(function(res1){
        if(res1.errorCode =="SUC") {
            $scope.otherformX.tlrName = userInfo.tlrName;//经办人
            $scope.otherformX.brName = res1.contextData.brName;//经办机构
        }else{
            $common.get_tipDialog(res1.errorMsg,'showError');
        }
    });
    //买方客户查询(这里要防止卖卖方是一个客户)
    $scope.buyerContent = {
        type:"table",//展示类型table  tree
        url:"bCntDebtExtInfoService/selectBCntDebtExtInfoByPage",//请求url
        param:{businessNo:mastContno},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"",//分隔符*/
        extentColumn:"buyerName",
        column:["buyerName"]//展示内容
    };
    var cnameBuyer="";
    $scope.buyerExtent = function(ds){
        if(ds.buyerCustcd == $scope.otherform.custcdSaller){
            $common.get_tipDialog("买卖双方不能是同一客户！",'showError');
            $scope.otherform.custcdBuyer="";
        }else{
            $scope.otherform.custcdBuyer=ds.buyerCustcd;//获得买方客户号
            $scope.otherform.aging=parseFloat(ds.loanDays);//获得账期
            $scope.otherform.gracePeriod=parseFloat(ds.debtGraceDays);//获得宽限期
            //当买方客户改变时，下面的票据信息要清空
            if(ds !="" && ds.buyerCustcd != cnameBuyer){
                $scope.bcpDatasource.ds=[];
                cnameBuyer=ds.buyerCustcd
            }
        }
    };
    $scope.$watch("otherform.cnameBuyer",function(){
        $scope.buyerContent.param ={
            //coreFlag:"1",//必须是核心厂商
            businessNo:mastContno,//将之前查处的业务合同号传参
            buyerName:$scope.otherform.cnameBuyer//买方名称
        }
    });
    //页面转让/出质信息
    var date=new Date();
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    var d = date.getDate();
    if(m < 10){
        m = "0" + m;
    }
    if(d < 10){
        d = "0" + d;
    }
    $scope.otherform.purchaseDate="" + y + m + d;//出质日期为当天
    $scope.otherformX.stratDate="" + y + m + d; //流程发起日起
    $scope.otherform.debtNum="0";//转让/出质总份数为0
    $scope.otherform.totalDebtAmount="0.00";//转让/出质总金额 0
    $scope.otherform.totalFee="0.00";//费用总额
    $scope.otherform.totalReduce="0.00";//减免总额
    $scope.otherform.receiveAmount="0.00";//实收费用总额

    //费用信息初始化
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
    //监听费用表的分页1
    $scope.$watch("costConf.pageNo+costConf.pageSize",function(){
        $scope.queryTable();
    });
    //应收账款转让表单
    $scope.bcpDatasource={//初始化表格对象
        ds:[]
    };
    $scope.bcpSelected={//初始化对象
        select: []
    };
    $scope.bcpConf= {//初始化分页对象
        pageNo: 1,
        pageSize: 15,
        totalRecord: 0};
    //费用查询
    $scope.queryTable = function(){
        var data= {
            pageSize: $scope.costConf.pageSize,
            pageNo: $scope.costConf.pageNo,
            value:{relaNo:mastContno}//业务合同号
        };
        var promise = $common.get_asyncData("bCntCostInfoService/findBCntCostInfoByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){//custcdSaller
                if(res.contextData.records[0]){
                    $scope.costDatasource.ds = res.contextData.records;
                    //扣费账号
                    $scope.costDatasource.ds[0].costAccount=$scope.otherform.accountNo;
                    //当所传的固定费用为空的时候要给一个初始值 ，costAmt
                    if(res.contextData.records[0].costAmt==null){
                        $scope.costDatasource.ds[0].costAmt="0.00"
                    }
                    $scope.costDatasource.ds[0].brcode="",$scope.costDatasource.ds[0].brname="",
                        $scope.costDatasource.ds[0].totalAmt="0.00", $scope.costDatasource.ds[0].reduceAmt="0.00",
                        $scope.costDatasource.ds[0].receiveAmount="0.00",$scope.costDatasource.ds[0].custcd=debtInfo.custcdSaller,
                        $scope.costConf.totalRecord = res.contextData.totalRecord;
                    //从应收账款管理页面跳转过来的
                    //如果有对应的应收账款基本信息就直接赋值,并且买方名称直接只读
                    if(dataX.bcpDatasource){
                        $scope.bcpDatasource.ds=dataX.bcpDatasource;
                        $scope.disable=true;
                        var data1=$scope.bcpDatasource.ds;
                        var totalDebtAmount=0;//转让/出质总金额
                        var debtNum=0;//转让出质份数
                        //计算票面金额的总额，计算费用。
                        for(var k in data1){
                            totalDebtAmount=totalDebtAmount+data1[k].billsAmountView;
                            debtNum=debtNum+1;
                        }
                        $scope.bcpConf.totalRecord=debtNum;
                        //费用总额=固定费用+票面金额*费用比率/100（因为费用比率是%的）。
                        $scope.otherform.totalDebtAmount=totalDebtAmount;
                        $scope.otherform.debtNum=debtNum;
                        //计算方式为固定的时候，费用固定。
                        if($scope.costDatasource.ds[0].costCalcType == "1"){
                            $scope.otherform.totalFee=$scope.costDatasource.ds[0].costAmt;
                            $scope.otherform.receiveAmount=$scope.otherform.totalFee-$scope.otherform.totalReduce;
                        }else if($scope.costDatasource.ds[0].costCalcType == "2"){
                            $scope.otherform.totalFee=totalDebtAmount*($scope.costDatasource.ds[0].costRate/100);
                            $scope.otherform.receiveAmount=$scope.otherform.totalFee-$scope.otherform.totalReduce;
                        }
                        //费用表中的字段要和这个字段同步 费用小计和出质费用相同，减免金额,实收费用总额
                        $scope.costDatasource.ds[0].totalAmt=$scope.otherform.totalFee;
                        $scope.costDatasource.ds[0].receiveAmount=$scope.otherform.receiveAmount;

                    }
                }else{
                    //没有对应的费用信息则将对应的信息隐藏掉
                    $("#costinfo").css('display','none'); //不显示费用信息
                    $("#costDatasource").css('display','none'); //不显示费用信息
                    if(dataX.bcpDatasource){
                        $scope.bcpDatasource.ds=dataX.bcpDatasource;
                        $scope.disable=true;
                        var data1=$scope.bcpDatasource.ds
                        var totalDebtAmount=0;//转让/出质总金额
                        var debtNum=0;//转让出质份数
                        //计算票面金额的总额，计算费用。
                        for(var k in data1){
                            totalDebtAmount=totalDebtAmount+data1[k].billsAmountView;
                            debtNum=debtNum+1;
                        }
                        $scope.otherform.totalDebtAmount=totalDebtAmount;
                        $scope.otherform.debtNum=debtNum;}
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        $scope.costSelected.select=[];
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
        if($.doValidate("otherform")) {
            var row={
                bcpDatasource:$scope.bcpDatasource.ds,
                debtInfo:$scope.otherform
            }
            $common.get_ngDialog('debtPoolTransfer/bcp_base_info_list.html', $scope
                ,["$scope",function(dialogScope){
                    BcpBaseInfoController(dialogScope,$scope,$common,dataDeliver,$state,row);
                }],"新增票据信息",{showClose:true});
        }
    };

    //删除票据信息
    $scope.deleteBill_onClick = function() {
        if ($scope.bcpSelected.select.length != 1) {
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        } else {
            var dsArray = $scope.bcpDatasource.ds;
            var selected = $scope.bcpSelected.select[0];
            for (var i = 0; i < dsArray.length; i++) {
                if (dsArray[i].billsNo == selected.billsNo) {
                    $scope.bcpDatasource.ds.splice(i, 1);
                    $scope.bcpSelected.select = [];
                    //改变转让出质总金额，转让份数，费用总额，实收费用
                    $scope.otherform.debtNum = $scope.bcpDatasource.ds.length;//转让出质份数减一
                    $scope.bcpConf.totalRecord=$scope.bcpDatasource.ds.length;
                    if($scope.otherform.debtNum == 0){//没有出质票据,全部置空
                        $scope.otherform.totalFee="0.00";
                        $scope.otherform.totalReduce="0.00";$scope.otherform.receiveAmount="0.00";
                        //合同的费用收取方式按年时 费用空
                        if($scope.costDatasource.ds.length>0) {
                            $scope.costDatasource.ds[0].totalAmt = "0.00";//费用小计
                            $scope.costDatasource.ds[0].reduceAmt = "0.00";//减免金额
                            $scope.costDatasource.ds[0].receiveAmount = "0.00";//实收费用金额
                        }
                        $scope.otherform.totalDebtAmount="0.00"//转让出质总金额
                        $scope.$apply();
                    }else{
                        $scope.otherform.totalDebtAmount = $scope.otherform.totalDebtAmount - selected.billsAmountView;//转让出质总金额
                        //合同的费用收取方式按年时 费用空
                        if($scope.costDatasource.ds.length>0) {
                        //按比例计算费用的时候费用要改变
                        var totalDebtAmount=parseFloat($scope.otherform.totalDebtAmount);
                        if($scope.costDatasource.ds[0].costCalcType == "2") {
                            $scope.otherform.totalFee = totalDebtAmount * ($scope.costDatasource.ds[0].costRate / 100);
                            var totalReduce = parseFloat($scope.otherform.totalReduce);//减免金额
                            //如果删除一张票据之后，按比列收费算出的费用小于减免金额则需要调整减免金额
                            if (totalReduce > $scope.otherform.totalFee) {
                                $scope.otherform.totalReduce = $scope.otherform.totalFee;
                                $scope.costDatasource.ds[0].reduceAmt = $scope.otherform.totalReduce;
                            }
                            $scope.costDatasource.ds[0].totalAmt = $scope.otherform.totalFee;
                        }
                            $scope.otherform.receiveAmount=$scope.otherform.totalFee-$scope.otherform.totalReduce;
                            $scope.costDatasource.ds[0].receiveAmount = $scope.otherform.receiveAmount;
                        }
                        $scope.$apply();

                    }
                }
            }
        }
    };
    //直接保存并发起流程
    $scope.save_onClick=function(){
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
            var data33 = {
                modelId: 'FactoringPoolAanwinstApply',
                ProcessName: '应收账款池融资转让申请',
                NodeId: 'Write',
                startedUserId: userInfo.tlrNo,
                bizId: "",
                bizData: [
                    appno = "",
                    $scope.otherform.custcdSaller,
                    $scope.otherform.cnameSeller,
                    'FactoringPoolAanwinstApply',
                    "",
                ]
            };
            //这里给amount赋值为转让总额
            $scope.otherform.amount=parseFloat($scope.otherform.totalDebtAmount);
            $scope.otherform.factType="8";//保理池融资
            var data2 = {
                rBcpAppliBussInfo: $scope.otherform,//应收账款转让申请基本信息
                rBcpAppliCostOut: costDatasource,//应收装款申请转让费用信息
                rBcpAppliBussDtl: $scope.bcpDatasource.ds,//应收账款申请明细信息
                processModel: data33
            }
            var promise = $common.get_asyncData("rBcpAppliBussInfoService/addBcpAppliBussInfo", data2);
            promise.then(function (res) {
                if (res.errorCode == "SUC") {
                    $common.get_tipDialog('保存成功！', 'showSuccess');
                    var data3 = {
                        appno: res.contextData.appno
                    };
                    dataDeliver.setter(data3);
                    $state.go("debtPoolTransferApply");
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });

        }
 };
    //返回按钮
    $scope.back_onClick = function() {
        $state.go("debtPoolConList");
    }
};

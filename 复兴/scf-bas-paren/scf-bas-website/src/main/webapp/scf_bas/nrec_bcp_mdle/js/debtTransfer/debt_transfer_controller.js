/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var nRDebtTransferController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    var dataX=dataDeliver.getter();
    //页面初始化
    $scope.otherform={};
    //应收账款转让表单
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

    //页面数据加载
    var appno;
    var mastContno=dataX.mastContno;
    $scope.dataSource=[];
    if(window.appNo){
        var processId=window.processId;
        var modelId=window.modelId;
        appno = window.appNo;
        //在这里要一旦提交就无法修改，所以，不需要判断节点
        $scope.task1=true;
        $scope.task2=true;
        /*var flowData;
        var seq;
        //获取当前节点信息
        var promiseB = $common.get_asyncData("processService/getCurrentNodeEntity",{pid:processId});
        promiseB.then(function(res){
            if (res.errorCode =="SUC") {
                flowData = res.contextData;
                seq = parseFloat(flowData.seq);
                if (seq == 1) {//第一个节点,返回隐藏
                    $scope.task1=true;
                } else {//第二个节点，所有按钮隐藏,不可修改减免金额
                    $scope.task1=true;
                    $scope.task2=true;
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });*/
        queryFormResourseByAppno();
    }else if(dataX.appno){//如果是修改按钮跳转过来
        appno=dataX.appno;
        queryFormResourseByAppno();
        if(dataX.flag){//是超链接查看按钮跳转过来的
            $scope.task2=true;
        }
    }else{//如果是新增按钮跳转过来
        $scope.submit=true;//提交按钮只读
        var datasource=dataX.list;
        if(dataX.datasource){
            $scope.dataSource=datasource;
        }
        var promiseA = $common.get_asyncData("bcntBcpInfoService/queryBCntBcpInfoByMastContno",{key:mastContno});
        promiseA.then(function(res1){
            if(res1.errorCode =="SUC") {
                $scope.otherform= res1.contextData;
                // 账期 loanDays，宽限期 debtGraceDays
                $scope.otherform.aging=$scope.otherform.loanDays;
                $scope.otherform.gracePeriod=$scope.otherform.debtGraceDays;
                //买方，卖方客户号，业务品种， financingType实际上融资方式，就可以判断factType是1还是8
                $scope.otherform.custcdSaller=$scope.otherform.custcd;
                $scope.otherform.custcdBuyer=$scope.otherform.businessCustcd;
                $scope.otherform.bussType=$scope.otherform.supplyChainPdId;
                $scope.otherform.cnameSeller=$scope.otherform.cname;
                factTypeJudge();//判断保理业务类型
                totalFee();
            }else{
                $common.get_tipDialog(res1.errorMsg,'showError');
            }
        });
    }
    //有申请号时页面信息加载方法
    function queryFormResourseByAppno(){
        //页面form
        var promiseA = $common.get_asyncData("nRBcpAppliBussInfoService/findBcpAppliBussInfoByAppno",{key:appno});
        promiseA.then(function(res1){
            if(res1.errorCode =="SUC") {
                var formInfo=res1.contextData;
                var promise = $common.get_asyncData("bcntBcpInfoService/queryBCntBcpInfoByMastContno",{key:formInfo.mastContno});
                promise.then(function(res){
                    if(res.errorCode =="SUC") {
                        $scope.otherform= res.contextData;
                        // 账期 loanDays，宽限期 debtGraceDays
                        $scope.otherform.aging=$scope.otherform.loanDays;
                        $scope.otherform.gracePeriod=$scope.otherform.debtGraceDays;
                        //买方，卖方客户号，业务品种，手续费率 financingType实际上融资方式，就可以判断factType是1还是8
                        $scope.otherform.custcdSaller=$scope.otherform.custcd;
                        $scope.otherform.custcdBuyer=$scope.otherform.businessCustcd;
                        $scope.otherform.bussType=$scope.otherform.supplyChainPdId;
                        $scope.otherform.cnameSeller=$scope.otherform.cname;
                        $scope.otherform.appno=appno;
                        //转让时间 purchaseDate，出质总分数 debtNum，总金额 totalDebtAmount，费用信息 totalFee reduceAmount receiveAmount
                        $scope.otherform.purchaseDate=formInfo.purchaseDate;
                        $scope.otherform.debtNum=formInfo.debtNum;
                        $scope.otherform.totalDebtAmount=formInfo.totalDebtAmount;
                        $scope.otherform.totalFee=formInfo.totalFee;
                        $scope.otherform.reduceAmount=formInfo.reduceAmount;
                        $scope.otherform.receiveAmount=formInfo.receiveAmount;
                        factTypeJudge();//判断保理业务类型
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }else{
                $common.get_tipDialog(res1.errorMsg,'showError');
            }
        });
        //页面table
        var promise= $common.get_asyncData("nRBcpAppliBussDtlService/queryAppliBussDetailByAppnoForTransfer",{appno:appno});
        promise.then(function(res){
            if(res.errorCode =="SUC") {
                $scope.dataSource = res.contextData||[];
                $scope.bcpConf.totalRecord = $scope.dataSource.length;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }
    //监听分页
    $scope.$watch("bcpConf.pageNo+bcpConf.pageSize+dataSource",function(){
        pageHelper();
    });
    //前台分页
    function pageHelper(){
        $scope.bcpDatasource.ds=[];
        var pageNo=parseFloat($scope.bcpConf.pageNo);
        var pageSize=parseFloat($scope.bcpConf.pageSize);
        var y ;
        if(pageNo*pageSize>=$scope.bcpConf.totalRecord){
            y=$scope.bcpConf.totalRecord-1;
        }else{
            y=pageNo*pageSize-1;
        }
        for(var x =(pageNo-1)*pageSize;x<=y;x++){
            $scope.bcpDatasource.ds.push($scope.dataSource[x]);
        }
    }
    //页面任务信息加载 scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
    $scope.otherformX={};

    //页面factType 判断 以及任务页面信息加载
    function factTypeJudge(){
       var factType = $scope.otherform.factType;
        var data={
            appno:appno,
            factType:factType
        };
        var promiseA = $common.get_asyncData("transferApplyService/findRBcpAppliBussInfoByAppno",data);
        promiseA.then(function(res1){
            if(res1.errorCode =="SUC") {
                $scope.otherformX = res1.contextData;//经办机构
                if(!window.appNo){
                    $scope.otherform.purchaseDate=$scope.otherformX.startTaskDate;
                }
                costQuery();//费用信息查询
            }else{
                $common.get_tipDialog(res1.errorMsg,'showError');
            }
        });
    }

    //费用信息查询
    function costQuery(){
        var promise= $common.get_asyncData("bcntBcpInfoService/queryCntCostInfoByMastContno",{key:$scope.otherform.mastContno});
        promise.then(function(res){
            if(res.errorCode =="SUC") {
                var dataY= res.contextData;
                $scope.otherform.costCalcType=dataY.costCalcType;
                if(dataY.costCalcType=='1'){//按照固定费用
                    $scope.cost1=true;//手续费率隐藏
                    $scope.otherform.costAmt=dataY.costAmt;
                    $scope.otherform.totalFee=dataY.costAmt;//费用总金额
                }else{
                    $scope.cost2=true;//固定费用隐藏
                    $scope.otherform.feeRate=dataY.costRate;//费用比列
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }
    //页面金额计算
    function totalFee(){
        var datasourceX=$scope.dataSource;
        var debtNum=0;
        var totalDebtAmount=0;
        for(var x in datasourceX){
            if(!datasourceX[x].billsAmount){
                datasourceX[x].billsAmount=0;
            }
            debtNum=debtNum+1;
            totalDebtAmount=totalDebtAmount+parseFloat(datasourceX[x].billsAmount);
        }
        $scope.otherform.debtNum=debtNum;//转让总份数
        $scope.otherform.totalDebtAmount=totalDebtAmount;//转让总金额
        if(!$scope.otherform.reduceAmount){
            $scope.otherform.reduceAmount=0;
        }
        var reduceAmount=parseFloat($scope.otherform.reduceAmount);//减免金额
        if(datasourceX.length == 0){
            $scope.otherform.reduceAmount=0;
            $scope.otherform.totalFee=0;
            $scope.otherform.receiveAmount=0;
        }else{
            if( $scope.otherform.costCalcType!='1'){//不是固定费用
                $scope.otherform.totalFee=totalDebtAmount*parseFloat($scope.otherform.feeRate)/100;//费用总金额
            }
            $scope.otherform.receiveAmount=$scope.otherform.totalFee-reduceAmount;//实收费用
            $scope.bcpConf.totalRecord=$scope.dataSource.length;//页面单据数量
        }
    }
    //减免金额离焦事件
    $scope.reduceAmount_onBlur=function(){
        if($scope.otherform.reduceAmount!="" && $scope.otherform.reduceAmount!=0){
            var reduceAmount=parseFloat($scope.otherform.reduceAmount);
            var totalFee=parseFloat($scope.otherform.totalFee);
            if(reduceAmount < 0){
                $common.get_tipDialog("减免金额不可小于0！",'showError');
            }
            if(reduceAmount > totalFee){
                $scope.otherform.reduceAmount=0;
                $common.get_tipDialog("减免金额不可大于费用总额！",'showError');
            }
            $scope.otherform.receiveAmount=totalFee-reduceAmount;
        }else{//实收费用等于费用总额
            $scope.otherform.receiveAmount=$scope.otherform.totalFee;
        }
        $scope.$apply();
    };

    //-------------------------------------点击事件----------------------------------
    //页面单据新增
    $scope.addBill_onClick = function() {
        if ($.doValidate("otherform")) {
        var url;
        if (window.appNo) {
            url = '../../nrec_bcp_mdle/html/debtTransfer/debt_info_add.html'
        } else {
            url = 'debtTransfer/debt_info_add.html';
        }
        $common.get_ngDialog(url, $scope
            , ["$scope", function (dialogScope) {
                dialogScope.otherform = $common.copy($scope.otherform);
                dialogScope.otherform.billsDate="";
                /*dialogScope.otherform.debtEnd="";
                 dialogScope.otherform.deadline="";*/
                //币种默认是人名币
                dialogScope.otherform.curcd = "CNY";
                //凭证编号离焦去重查询
                dialogScope.billsNo_onBlur = function () {//凭证编号到前台查重
                    if (dialogScope.otherform.billsNo != "") {
                        var datasource = $scope.dataSource;
                        if (!$scope.dataSource) {
                            $scope.dataSource = [];
                        }
                        if ($scope.dataSource.length != 0) {
                            for (var k in datasource) {
                                if (datasource[k].billsNo == dialogScope.otherform.billsNo) {
                                    $common.get_tipDialog("该凭证编号已存在!", 'showError');
                                    dialogScope.otherform.billsNo = "";//清空凭证编号
                                }
                            }
                        }
                    }
                };
                //时间，这里先获得系统时间
                var date = new Date();
                var y = date.getFullYear();
                var m = date.getMonth() + 1;
                var d = date.getDate();
                if (m < 10) {
                    m = "0" + m;
                }
                if (d < 10) {
                    d = "0" + d;
                }
                var sysDate = "" + y + m + d;//当前日期
                var sysDate1 = parseFloat(sysDate);
                var startDate = parseFloat(dialogScope.otherform.startDate);//合同生效日
                var endDate = parseFloat(dialogScope.otherform.endDate);//合同到期日
                var billsDate;//应收账款日期
                var debtEnd;//应收账款到期日
                //aging  账期,宽限期  gracePeriod
                dialogScope.$watch("otherform.billsDate",function() {
                    if (dialogScope.otherform.billsDate != "") {
                        if (aging_rules() == true) {
                            calculate_debtEnd();
                            calculate_deadline();
                            times_rules();
                            dialogScope.$apply();

                        }
                    }
                });
                /*dialogScope.billsDate_onChange = function (val) {


                };*/
                //账期离焦事件
                dialogScope.aging_onBlur = function () {
                    //如果账期未填写，则到期日，最迟付款日，都应该是空的
                    if (!dialogScope.otherform.aging || dialogScope.otherform.aging == "") {
                        dialogScope.otherform.debtEnd = "";
                        dialogScope.otherform.deadline = "";
                        dialogScope.$apply();
                    } else {//如果有对应的宽限日则可以计算最迟付款日，没有则赋值于最迟付款日为空
                        if (dialogScope.otherform.aging == 0) {
                            $common.get_tipDialog("账期必须大于0!", 'showError');
                        } else {
                            if(dialogScope.otherform.billsDate !=""){
                                calculate_debtEnd();
                                calculate_deadline();
                                times_rules();
                                dialogScope.$apply();
                            }
                        }
                    }
                };
                //宽限期离焦事件
                dialogScope.gracePeriod_onBlur = function () {
                    //如果没有账期，则直接赋值为空
                    if ((!dialogScope.otherform.aging) || dialogScope.otherform.aging == "") {
                        dialogScope.otherform.debtEnd = "";
                        dialogScope.otherform.deadline = "";
                        dialogScope.$apply();
                    } else {
                        if ((!dialogScope.otherform.gracePeriod) || dialogScope.otherform.gracePeriod == "") {
                            dialogScope.otherform.deadline = "";
                            dialogScope.$apply();
                        } else {
                            calculate_deadline();
                            times_rules();
                            dialogScope.$apply();
                        }
                    }
                };
                //票面金额填写完毕，会自动复制赋值给有效金额，这里默认将应收账款余额等同于票面金额，三者相等
                dialogScope.billsAmountView_onBlur = function () {
                    if (dialogScope.otherform.billsAmountView != "") {
                        dialogScope.otherform.billsAmount = dialogScope.otherform.billsAmountView;
                        dialogScope.$apply();
                    }
                };
                //当客户修改有效金额，会与票面金额做对比，不可大于票面金额
                dialogScope.billsAmount_onBlur = function () {
                    if (dialogScope.otherform.billsAmount != "") {
                        if (moneyRules() == true) {
                            dialogScope.otherform.remainingAmount = dialogScope.otherform.billsAmount;
                        } else {
                            dialogScope.otherform.billsAmount = dialogScope.otherform.billsAmountView;
                            dialogScope.$apply();
                        }
                    }
                };
                //---------------------------------页面校验规则----------------------------
                //计算应收账款到期日（在有账期和应收账款日期的时候）
                function calculate_debtEnd() {
                    //应收账款到期日=应收账款日期+账期
                    billsDate = dialogScope.otherform.billsDate;
                    var dateMilli = new Date(billsDate.replace(/^(\d{4})(\d{2})(\d{2})$/, '$1/$2/$3')).getTime();
                    var dayMilli = (dialogScope.otherform.aging) * 24 * 60 * 60 * 1000;
                    var dateMilliAndDayMilli = dateMilli + dayMilli;
                    var date = new Date(dateMilliAndDayMilli);
                    var y = date.getFullYear();
                    var m = date.getMonth() + 1;
                    var d = date.getDate();
                    if (m < 10) {
                        m = "0" + m;
                    }
                    if (d < 10) {
                        d = "0" + d;
                    }
                    dialogScope.otherform.debtEnd = "" + y + m + d;
                }

                //计算应收账款最迟付款日（必须要账期，宽限期，应收账款日期和应收账款到期日的情况下）
                function calculate_deadline() {
                    //最迟付款日=应收账款日期+账期+宽限期
                    debtEnd = dialogScope.otherform.debtEnd;
                    if (dialogScope.otherform.gracePeriod == 0) {
                        dialogScope.otherform.deadline = dialogScope.otherform.debtEnd;
                    } else {
                        var dateMilliAndDayMilli = new Date(debtEnd.replace(/^(\d{4})(\d{2})(\d{2})$/, '$1/$2/$3')).getTime();
                        var dateMilliAndDayMilli2 = dateMilliAndDayMilli + (dialogScope.otherform.gracePeriod) * 24 * 60 * 60 * 1000;
                        var date2 = new Date(dateMilliAndDayMilli2);
                        var y2 = date2.getFullYear();
                        var m2 = date2.getMonth() + 1;
                        var d2 = date2.getDate();
                        if (m2 < 10) {
                            m2 = "0" + m2;
                        }
                        if (d2 < 10) {
                            d2 = "0" + d2;
                        }
                        dialogScope.otherform.deadline = "" + y2 + m2 + d2;
                    }
                    dialogScope.$apply();
                }

                //账期校验
                function aging_rules() {
                    if (dialogScope.otherform.aging == "" || !(dialogScope.otherform.aging)) {
                        $common.get_tipDialog("请填写数值大于0的[账期]!", 'showError');
                        return false;
                    } else {
                        var aging = parseFloat(dialogScope.otherform.aging);
                        if (aging <= 0) {
                            $common.get_tipDialog("账期必须大于 0 !", 'showError');
                            return false;
                        }
                    }
                    return true;
                }

                //宽限期校验
                /*function gracePeriod_rules(){
                 if((dialogScope.otherform.gracePeriod==""|| dialogScope.otherform.gracePeriod==undefined)&& dialogScope.otherform.gracePeriod < 0){
                 $common.get_tipDialog("请填写宽限期!",'showError');
                 return false;
                 }
                 return true;
                 }*/
                //应收账款日期，到期日，合同生效日  startDate ，合同到期日  endDate 当前日期 sysDate1 ，5个日期校验
                function times_rules() {
                    var billsDate = parseFloat(dialogScope.otherform.billsDate);//应收账款日期
                    var debtEnd = parseFloat(dialogScope.otherform.debtEnd);//到期日
                    var deadline = parseFloat(dialogScope.otherform.deadline);//最迟付款日

                    //应收账款日期不能在合同到期日之后
                    if (billsDate >= endDate) {
                        $common.get_tipDialog("应收账款日期须在合同到期日之前!", 'showError');
                        return false;
                    }
                    //应收账款到期日不能在合同生效日之前
                    if (debtEnd < startDate) {
                        $common.get_tipDialog("应收账款到期日不能在合同生效日之前!", 'showError');
                        return false;
                    }
                    //应收账款日期须小于等于当前日期！
                    if (billsDate > sysDate1) {
                        $common.get_tipDialog("应收账款日期须小于等于当前日期！", 'showError');
                        return false;
                    }
                    //应收账款到期日须小于合同到期日
                    if (billsDate >= endDate) {
                        $common.get_tipDialog("应收账款到期日须小于合同到期日！", 'showError');
                        return false;
                    }
                    //最迟付款日须在合同到期日之前
                    if (deadline >= endDate) {
                        $common.get_tipDialog("最迟付款日须小于合同到期日！", 'showError');
                        return false;
                    }
                    return true;
                }

                //页面金额校验
                function moneyRules() {
                    var billsAmount = parseFloat(dialogScope.otherform.billsAmount);//有效金额
                    var billsAmountView = parseFloat(dialogScope.otherform.billsAmountView);//票面金额
                    if (billsAmount > billsAmountView) {
                        $common.get_tipDialog("单据有效金额不能大于票面金额！", 'showError');
                        return false;
                    }
                    return true;
                }

                function checkFormRules() {
                    if (aging_rules() == false) {
                        return false;
                    }
                    /*if(gracePeriod_rules() == false){
                     return false;
                     }*/
                    if (times_rules() == false) {
                        return false;
                    }
                    if (moneyRules() == false) {
                        return false;
                    }
                    return true;
                }

                //保存按钮
                dialogScope.save_onClick = function () {
                    if ($.doValidate("otherform")) {
                        //页面规则校验
                        if (checkFormRules() == true) {
                            //后台凭证编号查重（这里虽然是查重了，但是实际上，在保存的时候还是要再查询一遍，所以，这里还是不做查询了）
                            //这里将宽限期和最迟付款日保存下到其他字段中去，因为申请明细表中没有该字段
                            //gracePeriod=badReason 宽限期先赋值给呆账原因
                            dialogScope.otherform.badReason = dialogScope.otherform.gracePeriod;
                            //deadline = unpledgeActiveDate 最迟付款日赋值给解押生效日期
                            dialogScope.otherform.unpledgeActiveDate = dialogScope.otherform.deadline;
                            dialogScope.otherform.remainingAmount = dialogScope.otherform.billsAmount;
                            dialogScope.otherform.remainingUseableAmount = dialogScope.otherform.billsAmount;
                            var loanPercent = parseFloat(dialogScope.otherform.loanPercent);
                            if (loanPercent && loanPercent > 0) {
                                dialogScope.otherform.remainingUseableAmount = parseFloat(dialogScope.otherform.billsAmount) * loanPercent / 100;
                            }
                            $scope.dataSource.push(dialogScope.otherform);
                            totalFee();//页面金额计算
                            $scope.bcpSelected.select = [];
                            dialogScope.closeThisDialog();
                        }
                    }
                };
                dialogScope.back_onClick = function () {
                    dialogScope.closeThisDialog();
                };
            }], "编辑票据信息", {showClose: true});
        }
    };

    //页面单据修改
    $scope.updateBill_onClick = function(){
        if ($.doValidate("otherform")) {
            if ($scope.bcpSelected.select.length != 1) {
                $common.get_tipDialog('请选择一条记录！', 'showInform');
            } else {
                var url;
                if (window.appNo) {
                    url = '../../nrec_bcp_mdle/html/debtTransfer/debt_info_add.html'
                } else {
                    url = 'debtTransfer/debt_info_add.html';
                }
                $common.get_ngDialog(url, $scope
                    , ["$scope", function (dialogScope) {
                        dialogScope.otherform = $common.copy($scope.bcpSelected.select[0]);
                        //宽限期，最迟付款日两个字段的暂时保存到另两个字段上需要转换赋值
                        /* dialogScope.otherform.gracePeriod=dialogScope.otherform.badReason;
                         dialogScope.otherform.deadline=dialogScope.otherform.unpledgeActiveDate;*/
                        //合同生效日,到期日
                        dialogScope.otherform.startDate = $scope.otherform.startDate;
                        dialogScope.otherform.endDate = $scope.otherform.endDate;
                        //凭证编号离焦去重查询
                        dialogScope.billsNo_onBlur = function () {//凭证编号到前台查重
                            if (dialogScope.otherform.billsNo != "") {
                                if (!$scope.dataSource) {
                                    $scope.dataSource= [];
                                }
                                //防止客户点击了凭证编号输入框但是未做修改，导致，也会报错。
                                if ($scope.dataSource.length != 0) {
                                    var bcpDatasource=$common.copy($scope.dataSource);
                                    for(var k in bcpDatasource){
                                        if (bcpDatasource[k].billsNo == $scope.bcpSelected.select[0].billsNo) {
                                            bcpDatasource.splice(k,1);
                                        }
                                    }
                                    for (var k in bcpDatasource) {
                                        if (bcpDatasource[k].billsNo == dialogScope.otherform.billsNo) {
                                            $common.get_tipDialog("该凭证编号已存在!", 'showError');
                                            dialogScope.otherform.billsNo = "";//清空凭证编号
                                        }
                                    }
                                }
                            }
                        };
                        //时间，这里先获得系统时间
                        var date = new Date();
                        var y = date.getFullYear();
                        var m = date.getMonth() + 1;
                        var d = date.getDate();
                        if (m < 10) {
                            m = "0" + m;
                        }
                        if (d < 10) {
                            d = "0" + d;
                        }
                        var sysDate = "" + y + m + d;//当前日期
                        var sysDate1 = parseFloat(sysDate);
                        var startDate = parseFloat(dialogScope.otherform.startDate);//合同生效日
                        var endDate = parseFloat(dialogScope.otherform.endDate);//合同到期日
                        var billsDate;//应收账款日期
                        var debtEnd;//应收账款到期日
                        //aging  账期,宽限期  gracePeriod
                        dialogScope.billsDate_onChange = function (val) {
                            if (val != "") {
                                if (aging_rules() == true) {
                                    calculate_debtEnd();
                                    calculate_deadline();
                                    times_rules();
                                    dialogScope.$apply();

                                }
                            }
                        };
                        //账期离焦事件
                        dialogScope.aging_onBlur = function () {
                            //如果账期未填写，则到期日，最迟付款日，都应该是空的
                            if (!dialogScope.otherform.aging || dialogScope.otherform.aging == "") {
                                dialogScope.otherform.debtEnd = "";
                                dialogScope.otherform.deadline = "";
                                dialogScope.$apply();
                            } else {//如果有对应的宽限日则可以计算最迟付款日，没有则赋值于最迟付款日为空
                                if (dialogScope.otherform.aging == 0) {
                                    $common.get_tipDialog("账期必须大于0!", 'showError');
                                } else {
                                    if(dialogScope.otherform.billsDate !=""){
                                        calculate_debtEnd();
                                        calculate_deadline();
                                        times_rules();
                                        dialogScope.$apply();
                                    }
                                }
                            }
                        };
                        //宽限期离焦事件
                        dialogScope.gracePeriod_onBlur = function () {
                            //如果没有账期，则直接赋值为空
                            if ((!dialogScope.otherform.aging) || dialogScope.otherform.aging == "") {
                                dialogScope.otherform.debtEnd = "";
                                dialogScope.otherform.deadline = "";
                                dialogScope.$apply();
                            } else {
                                if ((!dialogScope.otherform.gracePeriod) || dialogScope.otherform.gracePeriod == "") {
                                    dialogScope.otherform.deadline = "";
                                    dialogScope.$apply();
                                } else {
                                    calculate_deadline();
                                    times_rules();
                                    dialogScope.$apply();
                                }
                            }
                        };
                        //票面金额填写完毕，会自动复制赋值给有效金额，这里默认将应收账款余额等同于票面金额，三者相等
                        dialogScope.billsAmountView_onBlur = function () {
                            if (dialogScope.otherform.billsAmountView != "") {
                                dialogScope.otherform.billsAmount = dialogScope.otherform.billsAmountView;
                                dialogScope.$apply();
                            }
                        };
                        //当客户修改有效金额，会与票面金额做对比，不可大于票面金额
                        dialogScope.billsAmount_onBlur = function () {
                            if (dialogScope.otherform.billsAmount != "") {
                                if (moneyRules() == true) {
                                    dialogScope.otherform.remainingAmount = dialogScope.otherform.billsAmount;
                                } else {
                                    dialogScope.otherform.billsAmount = dialogScope.otherform.billsAmountView;
                                    dialogScope.$apply();
                                }
                            }
                        };
                        //---------------------------------页面校验规则----------------------------
                        //计算应收账款到期日（在有账期和应收账款日期的时候）
                        function calculate_debtEnd() {
                            //应收账款到期日=应收账款日期+账期
                            billsDate = dialogScope.otherform.billsDate;
                            var dateMilli = new Date(billsDate.replace(/^(\d{4})(\d{2})(\d{2})$/, '$1/$2/$3')).getTime();
                            var dayMilli = (dialogScope.otherform.aging) * 24 * 60 * 60 * 1000;
                            var dateMilliAndDayMilli = dateMilli + dayMilli;
                            var date = new Date(dateMilliAndDayMilli);
                            var y = date.getFullYear();
                            var m = date.getMonth() + 1;
                            var d = date.getDate();
                            if (m < 10) {
                                m = "0" + m;
                            }
                            if (d < 10) {
                                d = "0" + d;
                            }
                            dialogScope.otherform.debtEnd = "" + y + m + d;
                        }

                        //计算应收账款最迟付款日（必须要账期，宽限期，应收账款日期和应收账款到期日的情况下）
                        function calculate_deadline() {
                            //最迟付款日=应收账款日期+账期+宽限期
                            debtEnd = dialogScope.otherform.debtEnd;
                            if (dialogScope.otherform.gracePeriod == 0) {
                                dialogScope.otherform.deadline = dialogScope.otherform.debtEnd;
                            } else {
                                var dateMilliAndDayMilli = new Date(debtEnd.replace(/^(\d{4})(\d{2})(\d{2})$/, '$1/$2/$3')).getTime();
                                var dateMilliAndDayMilli2 = dateMilliAndDayMilli + (dialogScope.otherform.gracePeriod) * 24 * 60 * 60 * 1000;
                                var date2 = new Date(dateMilliAndDayMilli2);
                                var y2 = date2.getFullYear();
                                var m2 = date2.getMonth() + 1;
                                var d2 = date2.getDate();
                                if (m2 < 10) {
                                    m2 = "0" + m2;
                                }
                                if (d2 < 10) {
                                    d2 = "0" + d2;
                                }
                                dialogScope.otherform.deadline = "" + y2 + m2 + d2;
                            }
                            dialogScope.$apply();
                        }

                        //账期校验
                        function aging_rules() {
                            if (dialogScope.otherform.aging == "" || !(dialogScope.otherform.aging)) {
                                $common.get_tipDialog("请填写数值大于0的[账期]!", 'showError');
                                return false;
                            } else {
                                var aging = parseFloat(dialogScope.otherform.aging);
                                if (aging <= 0) {
                                    $common.get_tipDialog("账期必须大于0!", 'showError');
                                    return false;
                                }
                            }
                            return true;
                        }

                        //宽限期校验
                        /*function gracePeriod_rules(){
                         if((dialogScope.otherform.gracePeriod==""|| dialogScope.otherform.gracePeriod==undefined)&& dialogScope.otherform.gracePeriod < 0){
                         $common.get_tipDialog("请填写宽限期!",'showError');
                         return false;
                         }
                         return true;
                         }*/
                        //应收账款日期，到期日，合同生效日  startDate ，合同到期日  endDate 当前日期 sysDate1 ，5个日期校验
                        function times_rules() {
                            var billsDate = parseFloat(dialogScope.otherform.billsDate);//应收账款日期
                            var debtEnd = parseFloat(dialogScope.otherform.debtEnd);//到期日
                            var deadline = parseFloat(dialogScope.otherform.deadline);//最迟付款日

                            //应收账款日期不能在合同到期日之后
                            if (billsDate >= endDate) {
                                $common.get_tipDialog("应收账款日期须在合同到期日之前!", 'showError');
                                return false;
                            }
                            //应收账款到期日不能在合同生效日之前
                            if (debtEnd < startDate) {
                                $common.get_tipDialog("应收账款到期日不能在合同生效日之前!", 'showError');
                                return false;
                            }
                            //应收账款日期须小于等于当前日期！
                            if (billsDate > sysDate1) {
                                $common.get_tipDialog("应收账款日期须小于等于当前日期！", 'showError');
                                return false;
                            }
                            //应收账款到期日须小于合同到期日
                            if (billsDate >= endDate) {
                                $common.get_tipDialog("应收账款到期日须小于合同到期日！", 'showError');
                                return false;
                            }
                            //最迟付款日须在合同到期日之前
                            if (deadline >= endDate) {
                                $common.get_tipDialog("最迟付款日须小于合同到期日！", 'showError');
                                return false;
                            }
                            return true;
                        }

                        //页面金额校验
                        function moneyRules() {
                            var billsAmount = parseFloat(dialogScope.otherform.billsAmount);//有效金额
                            var billsAmountView = parseFloat(dialogScope.otherform.billsAmountView);//票面金额
                            if (billsAmount > billsAmountView) {
                                $common.get_tipDialog("单据有效金额不能大于票面金额！", 'showError');
                                return false;
                            }
                            return true;
                        }

                        function checkFormRules() {
                            if (aging_rules() == false) {
                                return false;
                            }
                            /*if(gracePeriod_rules() == false){
                             return false;
                             }*/
                            if (times_rules() == false) {
                                return false;
                            }
                            if (moneyRules() == false) {
                                return false;
                            }
                            return true;
                        }

                        //保存按钮
                        dialogScope.save_onClick = function () {
                            if ($.doValidate("otherform")) {
                                //页面规则校验
                                if (checkFormRules() == true) {
                                    //后台凭证编号查重（这里虽然是查重了，但是实际上，在保存的时候还是要再查询一遍，所以，这里还是不做查询了）
                                    dialogScope.otherform.remainingAmount = dialogScope.otherform.billsAmount;
                                    var loanPercent = parseFloat(dialogScope.otherform.loanPercent);
                                    if (loanPercent && loanPercent > 0) {
                                        dialogScope.otherform.remainingUseableAmount = parseFloat(dialogScope.otherform.billsAmount) * loanPercent / 100;
                                    }
                                    var dsArray = $scope.dataSource;
                                    var selected = $scope.bcpSelected.select[0];
                                    for (var i = 0; i < dsArray.length; i++) {
                                        if (dsArray[i].billsNo == selected.billsNo) {
                                            $scope.dataSource.splice(i, 1);
                                        }
                                    }
                                    $scope.bcpSelected.select = [];
                                    $scope.dataSource.push(dialogScope.otherform);
                                    totalFee();//页面金额计算
                                    pageHelper();
                                    dialogScope.$apply();
                                    dialogScope.closeThisDialog();
                                }
                            }
                        };
                        dialogScope.back_onClick = function () {
                            dialogScope.closeThisDialog();
                        };
                    }], "编辑票据信息", {showClose: true});
            }
        }
    };
   //删除票据信息
    $scope.deleteBill_onClick = function() {
        if ($scope.bcpSelected.select.length != 1) {
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        } else {
            var dsArray = $scope.dataSource;
            var selected = $scope.bcpSelected.select[0];
            for(var x in dsArray){
                if(dsArray[x].billsNo==selected.billsNo){
                    dsArray.splice(x,1);
                }
            }
            $scope.bcpSelected.select=[];
            totalFee();//页面数据计算
            $scope.$apply();
        }
    };
    //查看按钮
    $scope.viewBill_onClick = function(){
        if($scope.bcpSelected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        }else{
            var url;
            if(window.appNo){
                url='../../nrec_bcp_mdle/html/debtTransfer/debt_info_add.html'
            }else{
                url='debtTransfer/debt_info_add.html';
            }
            $common.get_ngDialog(url, $scope
                ,["$scope",function(dialogScope){
                    dialogScope.otherform=$common.copy($scope.bcpSelected.select[0]);
                    //宽限期，最迟付款日两个字段的暂时保存到另两个字段上需要转换赋值
                    /*dialogScope.otherform.gracePeriod=dialogScope.otherform.badReason;
                    dialogScope.otherform.deadline=dialogScope.otherform.unpledgeActiveDate;*/
                    //合同生效日
                    dialogScope.otherform.startDate=$scope.otherform.startDate;
                    dialogScope.otherform.endDate=$scope.otherform.endDate;
                    dialogScope.view=true;

                    dialogScope.back_onClick = function(){
                        dialogScope.closeThisDialog();
                    };
                }],"查看票据信息",{showClose:true});
        }
    };
    //上传
    $scope.uploadoption = {
        inputHidden:[
            /* 上传到文件服务器 start */
            {name:'uploadType', value:'1002'},
            {name:'mastContno', value:mastContno},
            /* 上传到文件服务器 end */
            /* 上传到服务部署所在机器 start */
            {
                name:'callback',
                value: function(){
                    return "fileUpAndDownLoadService/upload";
                }
            }
            /* 上传到服务部署所在机器 end */
        ],
        callbackFun: function(res,status){
            if (res!=null&&res!=''&&res.errorCode == "SUC") {
                var dataNum=res.data.indexOf("%3A");
                if(dataNum == 9){
                    var dataList=$.parseJSON(decodeURIComponent(res.data));
                    //这里要注意，如果这次导入的数据中有页面上相同的单据号的应收账款，这里应该将页面
                    // 上的单据删除之后再新增新的导入的单据，
                    //如果页面已经有单据了，则要先将与批量导入的数据中凭证编号相同的去掉再新增导入数据
                    if($scope.dataSource && $scope.dataSource.length > 0){
                        for(var x in dataList){
                            for(var y in $scope.dataSource){
                                if(dataList[x].billsNo==$scope.dataSource[y].billsNo){
                                    $scope.dataSource.splice(y,1);
                                }
                            }
                        }
                    }
                    for(var x in dataList){
                        $scope.dataSource.push(dataList[x]);
                    }
                    totalFee();
                    $scope.$apply();
                    $common.get_tipDialog('导入成功！', 'showSuccess');
                }else{

                    $common.get_tipDialog(res.data,'showError');
                }
            }else{
                $common.get_tipDialog('导入失败，请重新上传！', 'showError');
            }
        },
        fileServerUrl:false //true：上传到文件服务器；false：上传到服务部署所在机器
    };

    //下载
    $scope.downloadoption = {
        inputHidden:[
            {name:'callback', value: 'fileServiceSupport/download' },
            {name:'genFileName',value: '应收账款单据导入模版.xlsx'},
            {name:'downloadType', value: "2001"},
            {name:'id', value: "1BJJNFM65000A4C7FCAA0000981EE544"}
            /* 从服务部署所在机器下载  end */
        ],
        callbackFun: function(res,status){
            if(res.errorCode == "SUC"){
                //$common.get_tipDialog('导出成功！', 'showSuccess');
            }else{
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
            console.log("res: "+res+"  status: "+status);
        },
        fileServerUrl:false //true：从文件服务器下载；false：从服务部署所在机器下载
    };
    //保存但不发起流程
    $scope.save_onClick=function(){
        if($.doValidate("otherform")) {
            if ($scope.dataSource.length <= 0) {//判断票据信息有没有添加 custcdSaller,cnameSeller
                $common.get_tipDialog("请添加票据信息！", 'showError');
                return false;
            }
            var reduceAmount=parseFloat($scope.otherform.reduceAmount);
            var totalFee=parseFloat($scope.otherform.totalFee);
            if(reduceAmount < 0){
                $common.get_tipDialog("减免金额不可小于0！",'showError');
                return;
            }
            if(reduceAmount > totalFee){
                $common.get_tipDialog("减免金额不可大于费用总额！",'showError');
                return;
            }
            //这里给amount赋值为转让总额
            $scope.otherform.amount=parseFloat($scope.otherform.totalDebtAmount);
            var data2 = {
                value: $scope.otherform,//应收账款转让申请基本信息
                list: $scope.dataSource//应收账款申请明细信息
            };
            var promise = $common.get_asyncData("transferApplyService/saveOrUpdateTransferInfo", data2);
            promise.then(function (res) {
                if (res.errorCode == "SUC") {
                    $common.get_tipDialog('保存成功！', 'showSuccess');
                    $scope.otherform.appno=res.contextData.value;
                    $scope.submit=false;
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
            
            }
        }
    //直接保存并发起流程并跳转节点
    $scope.submit_onClick=function(){
        if($.doValidate("otherform")) {
            if ($scope.dataSource.length <= 0) {//判断票据信息有没有添加 custcdSaller,cnameSeller
                $common.get_tipDialog("请添加票据信息！", 'showError');
                return false;
            }
            $scope.submit=true;
            var param = {
                productId:$scope.otherform.supplyChainPdId,
                invokPhase:"05"
            };
            //获取风险拦截模型ID
            $common.get_asyncData("bprdChkdirInfoService/findBPrdChkdirInfoByParam",{omap:param}).then(function(res){
                if (res.errorCode =="SUC"){
                    var data = res.contextData;
                    var mdlId = data.mdlId;
                    if(mdlId==undefined||mdlId==""||mdlId==null)
                    {
                        $scope.submit=false;
                        $common.get_tipDialog('该业务品种对应调用阶段的风险拦截模型未绑定,请在业务配置中绑定！','showInform');
                        return;
                    }
                    //调用业务拦截
                    dataDeliver.setter({modelId:mdlId,chkMap:$scope.otherform});//传值
                    $common.get_ngDialog('../../bas_intcpdir_mdle/html/ft/intcpline.html',$scope,intcplineController,'业务拦截',{showClose:false},700);
                }else{
                    $scope.submit=false;
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
        }
    };
    //监听业务拦截事件
    $scope.$on('interceptEvent',function(event,data) {
        //根据业务拦截处理结果，执行成功继续提交，未执行成功返回
        if(data.checkResult!='SUC'){
            $scope.submit=false;
            return;
        }
        //这里给amount赋值为转让总额
        $scope.otherform.amount=parseFloat($scope.otherform.totalDebtAmount);
        var data2 = {
            value: $scope.otherform,//应收账款转让申请基本信息
            list: $scope.dataSource//应收账款申请明细信息
        };
        var promise = $common.get_asyncData("transferApplyService/submitTransferInfo", data2);
        promise.then(function (res) {
            if (res.errorCode == "SUC") {
                $common.get_tipDialog('提交成功！', 'showSuccess');
                if(window.appNo){
                    $scope.task2=true;
                }else{
                    $state.go("list");
                }
            } else {
                $scope.submit=false;
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    });
    //返回按钮
    $scope.back_onClick = function() {
        $state.go("list");
    }
};

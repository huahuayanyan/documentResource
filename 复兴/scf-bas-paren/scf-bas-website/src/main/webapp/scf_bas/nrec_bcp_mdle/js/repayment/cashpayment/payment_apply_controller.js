/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var paymentApplyController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    var dataX=dataDeliver.getter();
    //页面初始化
    $scope.otherform={};
    //页面任务信息加载 scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
    $scope.otherformX={};
    //单据信息
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

    //融资借据信息
    $scope.loandatasource={//初始化表格对象
        ds:[]
    };
    $scope.loanselected={//初始化对象
        select: []
    };
    $scope.loanconf= {//初始化分页对象
        pageNo: 1,
        pageSize: 15,
        totalRecord: 0};

    //页面数据加载
    var appno;
    $scope.dataSource=[];
    $scope.loanSource=[];
    if(window.appNo){
        appno = window.appNo;
        $scope.hide=true;//按钮隐藏
        $scope.hide1=true;//按钮隐藏
        //$scope.poolAndView=true;
       // $("#zidong").css('display','none'); //不显示自动分配按钮
        queryFormResourseByAppno();
    }else if(dataX.appno){//如果是修改按钮跳转过来
        appno=dataX.appno;
        queryFormResourseByAppno();
       // $("#zidong").css('display','none'); //不显示自动分配按钮
        if(dataX.flag){//是超链接查看按钮跳转过来的
            $scope.hide=true;
            //$scope.poolAndView=true;
        }
    }else{//如果是新增按钮跳转过来
        $scope.submit=true;//提交按钮只读
        var mastContno=dataX.mastContno;
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
                $scope.otherform.reason='02'//这里的回款用途，默认就是还贷，不会是入保证金
                factTypeJudge();//判断保理业务类型
            }else{
                $common.get_tipDialog(res1.errorMsg,'showError');
            }
        });
    }
    //借据信息的每次改变都需要按照到期日正序排列
    function sequenceLoanInfo(){
        if($scope.loanSource.length>1){
            //调用后台方法
            var data={
                list:$scope.loanSource
            };
            var promiseA = $common.get_asyncData("nRBcpPaymentService/sequenceLoanInfo",data);
            promiseA.then(function(res1){
                if(res1.errorCode =="SUC") {
                    $scope.loanSource=res1.contextData;
                    $scope.loanconf.totalRecord=$scope.loanSource.length;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    }
    //用于自动分配借据信息按照到期日
    function sequenceLoanInfo2(){
        //调用后台方法
        var data={
            list:$scope.loanSource,
            assignRule:$scope.otherform.assignRule,
            returnAmount:$scope.otherform.returnAmount
        };
        var promiseA = $common.get_asyncData("nRBcpPaymentService/repayLoanInfoAuto",data);
        promiseA.then(function(res1){
            if(res1.errorCode =="SUC") {
                $scope.loanselected.select=[];
                $scope.loanSource=res1.contextData;
                $scope.loanconf.totalRecord=$scope.loanSource.length;
                remainAmount ();
                pageHelper2();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });

    }
    //监听应收账款分页
    $scope.$watch("bcpConf.pageNo+bcpConf.pageSize+dataSource",function(){
        pageHelper();
    });
    //前台分页
    function pageHelper(){
        $scope.bcpDatasource.ds=[];
        var pageNo=parseFloat($scope.bcpConf.pageNo);
        var pageSize=parseFloat($scope.bcpConf.pageSize);
        var y ;
        if(pageNo*pageSize>=$scope.dataSource.length){
            y=$scope.dataSource.length-1;
        }else{
            y=pageNo*pageSize-1;
        }
        for(var x =(pageNo-1)*pageSize;x<=y;x++){
            $scope.bcpDatasource.ds.push($scope.dataSource[x]);
        }
    }
    //监听借据融资信息分页
    $scope.$watch("loanconf.pageNo+loanconf.pageSize+loanSource",function(){
        pageHelper2();
    });
    //前台分页
    function pageHelper2(){
        $scope.loandatasource.ds=[];
        var pageNo=parseFloat($scope.loanconf.pageNo);
        var pageSize=parseFloat($scope.loanconf.pageSize);
        var y ;
        if(pageNo*pageSize>=$scope.loanSource.length){
            y=$scope.loanSource.length-1;
        }else{
            y=pageNo*pageSize-1;
        }
        for(var x =(pageNo-1)*pageSize;x<=y;x++){
            $scope.loandatasource.ds.push($scope.loanSource[x]);
        }
    }

    //----------------------------------------------页面点击事件--------------------------------------------------------
    //+++++++++++++++++++++++++++++++++++++++++单据按钮+++++++++++++++++++++++++++++++++++++++
    //页面单据新增
    $scope.addDebt_onClick = function(){
        addDebt();
    };
    //页面单据编辑
    $scope.editDebt_onClick = function(){
        editDebt();
    };
    //票据全额核销(核销金额和入账金额等于应收账款余额。)
    $scope.rebate_onClick = function(){
        if($scope.bcpSelected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        }else{
            if((!$scope.otherform.returnAmount)|| $scope.otherform.returnAmount==""){
                $common.get_tipDialog("请点击'入账记录'按钮得到'回款交易编号'填入'本次入账总额’！", 'showInform');
                return;
            }
            //校验计算，能否进行全额核销，能则进行，不能则提示
            var payAmountZ=0;//原有的还款金额
            if($scope.bcpSelected.select[0].repayAmount){//如果有写回款金额则取出
                payAmountZ=parseFloat($scope.bcpSelected.select[0].repayAmount);//原来的回款金额
            }
            var remainingAmount=parseFloat($scope.bcpSelected.select[0].remainingAmount);//单据的应收账款余额,即现在的回款金额
            var totalRepayAmount=payAmount_sum();//偿还融资金额，就是已经填写的回款金额总和
            totalRepayAmount=totalRepayAmount-payAmountZ+remainingAmount;//页面总已填写的回款金额-原来此张票据的回款金额+现在的回款金额
            var returnAmount=parseFloat($scope.otherform.returnAmount);//本次回款总金额
            if(returnAmount >=totalRepayAmount){//允许核销，钱足够核销的。
                $scope.bcpSelected.select[0].removeAmount=$scope.bcpSelected.select[0].remainingAmount;
                $scope.bcpSelected.select[0].payAmount=$scope.bcpSelected.select[0].remainingAmount;
                //如果是单笔，需要考虑到借据的还款金额的计算回显
                $scope.bcpSelected.select=[];
                $scope.$apply();
            }else{
                $common.get_tipDialog('‘本次入账总额’不足以核销单据！', 'showInform');
                return;
            }
        }
    };
    //页面单据删除
    $scope.delDebt_onClick = function() {
        delDebt();
    };

    //+++++++++++++++++++++++++++++++++++++++++借据按钮+++++++++++++++++++++++++++++++++++++++
    //融资信息（借据信息）新增
    $scope.addloan_onClick=function(){
        addLoan();
    };
    //融资信息修改（借据信息）修改
//借据信息修改
    $scope.editloan_onClick = function(){
        editLoan();
    };
    //删除对应借据信息
    $scope.deleteloan_onClick = function() {
        deleteloan();
    };
    //+++++++++++++++++++++++++++++++++++++++页面其他按钮+++++++++++++++++++++++++++++++++++
    //入账记录按钮，回款交易编号查询
    $scope.querytransaction_onClick=function() {
        $scope.$apply(function () {
            //简单模拟
            $scope.otherform.transactionNo = "SM" + new Date().getTime();
            $scope.otherform.returnAmount = 5000;
            $scope.otherform.totalOverAmount = 5000;
            $scope.otherform.totalRepayAmount = 0;
        });
    };
    //totalRepayAmount，assignAmount 自动分配按钮
    //自动分配按钮
    $scope.assignAmount_onClick=function(){
        if(!$scope.otherform.assignRule){
            $common.get_tipDialog("请先选择'回款核销规则'！",'showError');
            return;
        }
        if(!$scope.otherform.returnAmount){
            $common.get_tipDialog("请点击'入账记录'按钮得到'回款交易编号'填入'本次入账总额’！",'showError');
            return;
        }

        if($scope.dataSource.length==0){
            $common.get_tipDialog("请添加核销应收账款列表信息！",'showError');
            return;
        }
        //调用后台方法,现在保函将对应的借据信息也自动分配金额
        var data={
            returnAmount:$scope.otherform.returnAmount,
            assignRule:$scope.otherform.assignRule,
            list:$scope.dataSource
        };
        var promiseA = $common.get_asyncData("nRBcpPaymentService/sequenceDebtAndReturnAmount",data);
        promiseA.then(function(res1){
            if(res1.errorCode =="SUC") {
                $scope.dataSource=res1.contextData;
                $scope.bcpSelected.select=[];
                pageHelper();
                sequenceLoanInfo2();

            }else{
                $common.get_tipDialog(res1.errorMsg,'showError');
            }
        });
    };
    //回款账户余额查询
    $scope.queryBalance_onClick=function(){
        $scope.$apply(function(){
            //简单模拟
            $scope.otherform.returnAccountBalance=10000000;
        });
    };
    //-------------------------------------页面核销金额,入账总额，融资信息的还款金额金额校验和计算公式--------------------------
    //计算单据本次实际入账金额总和
    function payAmount_sum(){
        var sum =0;
        if($scope.dataSource.length > 0){
            for(var x in $scope.dataSource){
                if($scope.dataSource[x].payAmount){
                    sum=sum+parseFloat($scope.dataSource[x].payAmount);
                }
            }
        }
        return sum;
    }
    //借据，融资信息总额 repayAmount
    function repayAmount_sum(){
        var sumX=0;
        if($scope.loanSource.length > 0){
            for(var y in $scope.loanSource){
                if($scope.loanSource[y].repayAmount){
                    sumX=sumX+parseFloat($scope.loanSource[y].repayAmount);
                }
            }
        }
        return sumX;
    }
    //尾款计算（将本次入账总额减去所有核销单据的入账金额之和）
    //用到这个计算公式，页面必须填写回款入账总额
    function remainAmount (){
        var returnAmount=parseFloat($scope.otherform.returnAmount);//回款总金额
        var loanRepay=repayAmount_sum();//借据的入账总额
        var totalRepayAmount=0;//本次实际入账总和
        var totalOverAmount=0;//尾款金额
        //页面上的尾款金额等只与借据的本次入账总额相关，与单据的无关。
        totalRepayAmount=loanRepay;
        var totalOverAmount=returnAmount-totalRepayAmount;
        if(totalOverAmount >=0){
            $scope.otherform.totalRepayAmount=totalRepayAmount;
            $scope.otherform.totalOverAmount=totalOverAmount;
            $scope.otherform.toSallerAmount=totalOverAmount;

            return true;
        }else{
            $common.get_tipDialog('‘本次入账总额’不足以还款借据！', 'showInform');
            return false;
        }
    }
    //页面上的对应的所有的字段都需要校验必须填写
    function checkMoneyRules(){
        //1.所有的单据的核销金额实际入账金额必须填写
        if($scope.dataSource.length==0){
            $common.get_tipDialog('请添加核销应收账款列表信息！','showError');
            return false;
        }
        var sum1=0;
        //几个字段不能不填，还有就是，检验，实际入账金额还是要小于等于本次核销金额，小于等于对应单据的应收账款余额
        for(var x in $scope.dataSource){
            var benci=$scope.dataSource[x];
            if((!benci.payAmount)|| benci.payAmount==0||benci.payAmount=='0'){
                $common.get_tipDialog('请填写凭证编号为'+$scope.dataSource[x].billsNo+'单据的实际入账金额！','showError');
                return false;
            }
            if((!benci.removeAmount)|| benci.removeAmount==0||benci.removeAmount=='0'){
                $common.get_tipDialog('请填写凭证编号为'+$scope.dataSource[x].billsNo+'单据的本次核销金额！','showError');
                return false;
            }
            var payAmount =parseFloat(benci.payAmount);//本次入账金额
            var removeAmount=parseFloat(benci.removeAmount);//本次核销金额
            var　remainingAmountx=parseFloat(benci.remainingAmount);//单据对应应收账款余额
            //本次入账金额不可大于核销金额
            //这里主要是防止，当自动分配和全额核销等按钮，导致的金额不对。
            if(payAmount > removeAmount){
                $common.get_tipDialog('凭证编号为'+$scope.dataSource[x].billsNo+'单据的本次实际入账金额不可大于本次核销金额！','showError');
                return false;
            }
            if(removeAmount > remainingAmountx){
                $common.get_tipDialog('凭证编号为'+$scope.dataSource[x].billsNo+'单据的本次本次核销金额不可大于单据的应收账款余额！','showError');
                return false;
            }
            sum1=sum1+parseFloat($scope.dataSource[x].payAmount);
        }
        var returnAmount=parseFloat($scope.otherform.returnAmount);
        if(sum1 > returnAmount){
            $common.get_tipDialog("核销应收账款列表的'实际入账总额'不可大于'本次入账总额'，请修改核销应收账款列表的'实际入账金额'！",'showError');
            return false;
        }
        //2.所有的融资信息中的回款金额必填
        var sum2=0;//实际还款金额
        if($scope.loanSource.length >0){
            for(var y in $scope.loanSource ){
                var benci2=$scope.loanSource[y];
                if((!benci2.repayAmount)||benci2.repayAmount==0||benci2.repayAmount=='0'){
                    /*$common.get_tipDialog('请填写借据号为'+$scope.bcpDatasource.ds[x].billsNo+'融资信息的还款金额！','showError');
                    return false;*/
                }else{
                    var lnciBal=parseFloat(benci2.lnciBal);
                    var repayAmount=parseFloat(benci2.repayAmount);
                    if(repayAmount > lnciBal){
                        $common.get_tipDialog('借据号为'+$scope.dataSource[x].billsNo+'融资信息的还款金额不可大于借据余额！','showError');
                        return false;
                    }
                   sum2=sum2+parseFloat($scope.loanSource[y].repayAmount);
                }
            }
        }
        //3.单据的总还款金额以及借据的还款金额都不能超过总还款金额
        if(sum2 > returnAmount){
            $common.get_tipDialog("'关联的融资信息列表'的'还款金额总和'不可大于'本次入账总额'，请修改关联的融资信息的'还款金额'！",'showError');
            return false;
        }
        return true;
    }
    //-------------------------------------页面数据加载方法---------------------------------------
    //有申请号时页面信息加载方法
    function queryFormResourseByAppno(){
        //页面form
        var promiseA = $common.get_asyncData("nRBcpAppliBussInfoService/findBcpAppliBussInfoByAppno",{key:appno});
        promiseA.then(function(res1){
            if(res1.errorCode =="SUC") {
                $scope.otherform=res1.contextData;
                var promise = $common.get_asyncData("bcntBcpInfoService/queryBCntBcpInfoByMastContno",{key:$scope.otherform.mastContno});
                promise.then(function(res){
                    if(res.errorCode =="SUC") {
                        var formInfo = res.contextData;
                        //买方，卖方客户号，业务品种，手续费率 financingType实际上融资方式，就可以判断factType是1还是8
                        $scope.otherform.custcdSaller=formInfo.custcd;
                        $scope.otherform.custcdBuyer=formInfo.businessCustcd;
                        $scope.otherform.bussType=formInfo.supplyChainPdId;
                        $scope.otherform.supplyChainPdId=formInfo.supplyChainPdId;
                        $scope.otherform.supplyChainPdName=formInfo.supplyChainPdName;
                        $scope.otherform.cname=formInfo.cname;
                        $scope.otherform.cnameBuyer=formInfo.cnameBuyer;
                        $scope.otherform.mastContno=formInfo.mastContno;
                        $scope.otherform.startDate=formInfo.startDate;
                        $scope.otherform.endDate=formInfo.endDate;
                        $scope.otherform.poolUseableAmount=formInfo.poolUseableAmount;
                        $scope.otherform.poolRiskAmt=formInfo.poolRiskAmt;
                        $scope.otherform.factType=formInfo.factType;
                        $scope.otherform.appno=appno;
                        // 账期 loanDays，宽限期 debtGraceDays
                        $scope.otherform.aging=formInfo.loanDays;
                        $scope.otherform.gracePeriod=formInfo.debtGraceDays;
                        $scope.otherform.returnAmount=$scope.otherform.amount;//本次入账总额才是本次回款总额
                        $scope.otherform.totalRepayAmount=parseFloat($scope.otherform.returnAmount)-parseFloat($scope.otherform.totalOverAmount);
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
        var promise= $common.get_asyncData("nRBcpAppliBussDtlService/queryAppliBussDetailByAppno",{appno:appno});
        promise.then(function(res){
            if(res.errorCode =="SUC") {
                $scope.dataSource = res.contextData||[];
                $scope.bcpConf.totalRecord = $scope.dataSource.length;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
        //页面融资信息列表（通过申请号，去查找对应的融资借据信息。）
        var promise = $common.get_asyncData("nRBcpPaymentService/getDebtLnciBaseListByAppno",{key:appno});
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.loanSource = res.contextData||[];
                $scope.loanconf.totalRecord = $scope.loanSource.length;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });

    }
    //页面factType 判断 以及任务页面信息加载
    function factTypeJudge(){
        var factType=$scope.otherform.factType;
        if(factType!='7'&&factType!='8'&&factType!='9'){//当为单笔的时候，借据信息是没有新增按钮的，是在选中对应的单据之后，自动带出对应的借据信息。
            $scope.pool=true;//隐藏池信息，以及对应的借据信息的新增修改按钮
            //$scope.poolAndView=true;
        }
        var data={
            appno:appno,
            factType:factType
        };
        var promiseA = $common.get_asyncData("nRBcpPaymentService/findRBcpAppliBussInfoByAppno",data);
        promiseA.then(function(res1){
            if(res1.errorCode =="SUC") {
                $scope.otherformX = res1.contextData;//经办机构
                if(!window.appNo){
                    $scope.otherform.returnDate=$scope.otherformX.startTaskDate;
                }
                if(factType == '8'){
                    $scope.otherformX.processTemplateName='应收账款池融资回款申请';
                }else if(factType == '1'){
                    $scope.otherformX.processTemplateName='应收账款融资回款申请';
                }

            }else{
                $common.get_tipDialog(res1.errorMsg,'showError');
            }
        });
    }
    //------------------------------------------调用方法-----------------------------------------------
    //页面单据新增
    function addDebt(){
        if((!$scope.otherform.returnAmount)||$scope.otherform.returnAmount==""){
            $common.get_tipDialog("请点击'入账记录'按钮确定'回款交易编号'填入'本次入账总额'！", 'showInform');
            return;
        }
        $common.get_ngDialog('repayment/cashpayment/select_bcp_list.html', $scope
            ,["$scope",function(dialogScope){

                var list=$common.copy($scope.dataSource);
                var mastContno=$scope.otherform.mastContno;

                dialogScope.conditionForm={//需要先定义业务品种对应的产品ID
                    mastContno:mastContno,//业务合同号
                    lockAppno:appno,
                    factType:$scope.otherform.factType
                };
                dialogScope.datasource={//初始化表格对象
                    ds: []
                };
                dialogScope.selected={//初始化对象
                    select: []
                };
                dialogScope.conf= {//初始化分页对象
                    pageNo: 1,
                    pageSize: 10,
                    totalRecord: 0};

                //监听分页
                dialogScope.$watch("conf.pageNo+conf.pageSize",function(){
                    dialogScope.queryTable();
                });
                dialogScope.rebort_onClick =function(){
                    dialogScope.conditionForm={//需要先定义业务品种对应的产品ID
                        mastContno:mastContno,//业务合同号
                        lockAppno:appno,
                        factType:$scope.otherform.factType
                    };
                    dialogScope.selected.select=[];
                    dialogScope.$apply();
                };
                //点击查询之后的搜索
                dialogScope.submit_onClick =function(){
                    dialogScope.selected.select=[];
                    dialogScope.queryTable();

                };
                //查询操作
                dialogScope.queryTable = function(paramData){
                    var data= {
                        pageNo: dialogScope.conf.pageNo,
                        pageSize: dialogScope.conf.pageSize,
                        value:dialogScope.conditionForm,
                        list:list
                    };
                   /* var url;以前的，默认为当单笔融资的回款的时候，必须要有对应的借据信息。但是实际上不需要
                    if($scope.otherform.factType=='1'){
                        url="nRBcpPaymentService/findCancelRBcpDebtBaseInfoPageByPage2"
                    }else{
                        url="nRBcpPaymentService/findCancelRBcpDebtBaseInfoPageByPage";
                    }*/
                    var promise = $common.get_asyncData("nRBcpPaymentService/findCancelRBcpDebtBaseInfoPageByPage",data);
                    promise.then(function(res){
                        var data;
                        if (res.errorCode =="SUC"){
                            data = res.contextData;
                            dialogScope.datasource.ds = data.records;
                            dialogScope.conf.totalRecord =data.totalRecord;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                };
                /* 确定按钮 */
                //如果是单笔的情况，就应该将新增的对应的单据信息的借据号去查出对应的借据信息。并赋给页面的对应table里面
                dialogScope.confirm_onClick=function(){
                    if(dialogScope.selected.select.length == 0){
                        $common.get_tipDialog("请选择数据！",'showError');
                        return;
                    }
                    //如果是单笔的放款需要通过选择的单据信息的借据号带出对应的借据信息.
                    if($scope.otherform.financingType=='1'){
                        var promise = $common.get_asyncData("nBLanLnciBaseService/selectBLanLnciBaseListByDebetId",{list:dialogScope.selected.select});
                        promise.then(function(res){
                            var data;
                            if (res.errorCode =="SUC"){//获得的是单据对应的页面上的借据信息
                                data = res.contextData||[];
                                if(data!=[]){
                                    //这地方要判断，页面上的是否已经有了对应的借据信息，只新增不同的借据信息。
                                    //页面上无借据信息，直接新增。页面上有借据则需要剔除
                                    if($scope.loanSource.length>0){
                                        var data1=$scope.loanSource;
                                        for(var a in data1){//页面上已有的
                                            for(var b in data){//这次新增的
                                                if(data1[a].debetId==data[b].debetId){
                                                    data.splice(b,1);
                                                }
                                            }
                                        }
                                    }
                                    if(data != null && data.length >0){
                                        for(var y in data){
                                            $scope.loanSource.push(data[y]);
                                        }
                                        sequenceLoanInfo();
                                    }
                                }
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        });
                    }
                    for(var x in dialogScope.selected.select){
                        $scope.dataSource.push(dialogScope.selected.select[x]);
                    }
                    //如果单据超过1个，则将页面上的核销单据按照到期日倒叙排序
                    if($scope.dataSource.length > 1){
                        //调用后台方法
                        var data={
                            list:$scope.dataSource
                        };
                        var promiseA = $common.get_asyncData("nRBcpPaymentService/sequenceDebtAndReturnAmount",data);
                        promiseA.then(function(res1){
                            if(res1.errorCode =="SUC") {
                                $scope.dataSource=res1.contextData;
                                pageHelper();
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        });
                    }
                    $scope.bcpConf.totalRecord=$scope.dataSource.length;
                    $scope.bcpSelected.select=[];
                    dialogScope.closeThisDialog();
                };
                dialogScope.back_onClick = function(){
                    dialogScope.closeThisDialog();
                }
            }],"选择核销单据",{showClose:true});
    }


    //页面单据信息修改
    function editDebt(){
        //添加本次入账总额的校验
        if((!$scope.otherform.returnAmount)||$scope.otherform.returnAmount==""){
            $common.get_tipDialog("请点击'入账记录'按钮确定'回款交易编号'填入'本次入账总额'！", 'showInform');
            return;
        }
        if($scope.bcpSelected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        }else{
            var url;
            if(window.appNo){
                url='../../nrec_bcp_mdle/html/repayment/cashpayment/bcp_update.html'
            }else{
                url='repayment/cashpayment/bcp_update.html';
            }
            $common.get_ngDialog(url, $scope
                ,["$scope",function(dialogScope){
                    dialogScope.billinfo=$common.copy($scope.bcpSelected.select[0]);
                    var payAmountZ=0;//未修改前的单据还款金额
                    if( dialogScope.billinfo.payAmount && dialogScope.billinfo.payAmount!=""){
                        payAmountZ=parseFloat(dialogScope.billinfo.payAmount);
                    }
                    //本次核销总金额
                    function checkMoney(){
                        //1.核销金额必须小于应收账款余额
                        var removeAmount=parseFloat(dialogScope.billinfo.removeAmount);//核销金额
                        var remainingAmount=parseFloat(dialogScope.billinfo.remainingAmount);//应收账款余额
                        var payAmount=parseFloat(dialogScope.billinfo.payAmount);//入账金额
                        if(removeAmount > remainingAmount){
                            $common.get_tipDialog("核销金额不可大于应收账款余额！", 'showError');
                            return false;
                        }
                        //2.入账金额必须小于等于核销金额
                        if(payAmount >removeAmount ){
                            $common.get_tipDialog("入账金额不可大于核销金额！", 'showError');
                            return false;
                        }
                        //3.如果页面上已经有 returnAmount，核销金额不可大于本次入账总额！
                        if($scope.otherform.returnAmount){
                            var totalRepayAmount=payAmount_sum();//所有单据的本次入账总额
                            totalRepayAmount=totalRepayAmount-payAmountZ+payAmount;//减去原有的，加上现在的入账金额
                            var returnAmount=parseFloat($scope.otherform.returnAmount);//本次入账总额
                            if(returnAmount<totalRepayAmount){
                                $common.get_tipDialog("本次入账总额不足以核销单据，请降低'实际入账金额'！", 'showError');
                                return false;
                            }
                        }else{
                            $common.get_tipDialog("请点击'入账记录'按钮确定'回款交易编号'填入'本次入账总额'！", 'showInform');
                            return false;
                        }
                        return true;
                    }
                    //计算借据还款金额（单笔的时候使用）
                    /*function checkLoanRule(){
                        for(var z in  $scope.loandatasource.ds){
                            if($scope.loandatasource.ds[z].debetId==dialogScope.billinfo.debetNo){
                                var repayAmount;//回款金额
                                if( !$scope.loandatasource.ds[z].repayAmount){
                                    $scope.loandatasource.ds[z].repayAmount=0;
                                    repayAmount=0;
                                }else{
                                    repayAmount=parseFloat($scope.loandatasource.ds[z].repayAmount);
                                }
                                //减去原有的，加上现在的。
                                repayAmount=repayAmount-payAmountZ+parseFloat(dialogScope.billinfo.payAmount);
                                var lnciBal=parseFloat($scope.loandatasource.ds[z].lnciBal);
                                //如果还款金额比借据余额还大，则报错
                                if(repayAmount >lnciBal){
                                    $common.get_tipDialog("对应的融资信息中，还款金额已超出借据余额，请降低'实际入账金额'！", 'showInform');
                                    return false;
                                }else{
                                    $scope.loandatasource.ds[z].repayAmount=repayAmount;
                                }
                                return true;
                            }
                        }
                    }*/
                    dialogScope.save_onClick = function(){
                        if($.doValidate("billinfo")){
                            if(checkMoney() == true){
                                var dsArray = $scope.dataSource;
                                var selected = $scope.bcpSelected.select[0];
                                for(var k in dsArray){
                                    if (dsArray[k].id == selected.id) {
                                        $scope.dataSource[k]=$common.copy(dialogScope.billinfo);
                                       // remainAmount ();//页面上所有的金额计算
                                    }
                                }
                                pageHelper();
                                $scope.bcpSelected.select=[];
                                dialogScope.closeThisDialog();
                            }
                        }
                    };
                    dialogScope.back_onClick = function(){
                        dialogScope.closeThisDialog();
                    }
                }],"编辑单据核销信息",{showClose:true});
        }
    }


    //删除票据信息（当为单笔的时候，需要单据借据关联删除）
    function delDebt(){
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
            $scope.bcpConf.totalRecord=$scope.dataSource.length;
            //如果是单笔
            /*if($scope.otherform.factType=='1'){
                if($scope.bcpDatasource.ds==[]){//如果无单据信息，则无借据信息
                    $scope.loandatasource.ds=[];
                }else{
                    var dataY=[];
                    for(var a in dsArray){
                        for(var b in $scope.loandatasource.ds){
                            if(dsArray[a].debetNo==$scope.loandatasource.ds[b].debetId){
                                dataY.push($scope.loandatasource.ds[b]);
                            }
                        }
                    }
                    //将能对应上借据号的借据信息留下塞入融资信息table中。
                    $scope.loandatasource.ds=dataY;
                }
            }*/
            //remainAmount ();//页面上的金额计算。
            //$scope.loanconf.totalRecord=$scope.loandatasource.ds.length;
            $scope.bcpSelected.select=[];
            $scope.$apply();
        }
    }

    //添加借据信息
    function addLoan (){
        if((!$scope.otherform.returnAmount)||$scope.otherform.returnAmount==""){
            $common.get_tipDialog("请点击'入账记录'按钮确定'回款交易编号'填入'本次入账总额'！", 'showInform');
            return;
        }
        var url;
        if(window.appNo){
            url='../../nrec_bcp_mdle/html/repayment/cashpayment/select_loan_list.html'
        }else{
            url='repayment/cashpayment/select_loan_list.html';
        }
        $common.get_ngDialog(url, $scope
            ,["$scope",function(dialogScope){

                var list=$common.copy($scope.loanSource);
                var mastContno=$scope.otherform.mastContno;

                dialogScope.conditionForm={//需要先定义业务品种对应的产品ID
                    lnciType:'01',
                    bussContno:mastContno,//业务合同号
                    appno:appno
                };
                dialogScope.datasource={//初始化表格对象
                    ds: []
                };
                dialogScope.selected={//初始化对象
                    select: []
                };
                dialogScope.conf= {//初始化分页对象
                    pageNo: 1,
                    pageSize: 10,
                    totalRecord: 0}

                //监听分页
                dialogScope.$watch("conf.pageNo+conf.pageSize",function(){
                    dialogScope.queryTable();
                });
                dialogScope.rebort_onClick =function(){
                    dialogScope.conditionForm={//需要先定义业务品种对应的产品ID
                        lnciType:'01',
                        bussContno:mastContno,//业务合同号
                        appno:appno
                    };
                    dialogScope.selected.select=[];
                    dialogScope.$apply();
                };
                //点击查询之后的搜索
                dialogScope.submit_onClick =function(){
                    dialogScope.selected.select=[];
                    dialogScope.queryTable();

                };
                //查询操作
                dialogScope.queryTable = function(paramData){
                    var data= {
                        pageNo: dialogScope.conf.pageNo,
                        pageSize: dialogScope.conf.pageSize,
                        value:dialogScope.conditionForm,
                        list:list
                    };
                    var promise = $common.get_asyncData("nRBcpPaymentService/queryLoanByPageForPay",data);
                    promise.then(function(res){
                        var data;
                        if (res.errorCode =="SUC"){
                            data = res.contextData;
                            dialogScope.datasource.ds = data.records;
                            dialogScope.conf.totalRecord =data.totalRecord;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                };
                /* 确定按钮 */
                //如果是单笔的情况，就应该将新增的对应的单据信息的借据号去查出对应的借据信息。并赋给页面的对应table里面
                dialogScope.confirm_onClick=function(){
                    if(dialogScope.selected.select.length == 0){
                        $common.get_tipDialog("请选择数据！",'showError');
                        return;
                    }
                    for(var x in dialogScope.selected.select){
                        $scope.loanSource.push(dialogScope.selected.select[x]);
                    }
                    sequenceLoanInfo();
                    $scope.loanselected.select=[];
                    dialogScope.closeThisDialog();
                };
                dialogScope.back_onClick = function(){
                    dialogScope.closeThisDialog();
                }
            }],"选择融资信息",{showClose:true});
    }

    //借据信息修改
    function editLoan(){
        if((!$scope.otherform.returnAmount)||$scope.otherform.returnAmount==""){
            $common.get_tipDialog("请点击'入账记录'按钮确定'回款交易编号'填入'本次入账总额'！", 'showInform');
            return;
        }
        if($scope.loanselected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        }else{
            var url;
            if(window.appNo){
                url='../../nrec_bcp_mdle/html/repayment/cashpayment/loan_update.html'
            }else{
                url='repayment/cashpayment/loan_update.html';
            }
            $common.get_ngDialog(url, $scope
                ,["$scope",function(dialogScope){
                    dialogScope.loaninfo=$common.copy($scope.loanselected.select[0]);
                    var repayAmountZ=0;
                    if(dialogScope.loaninfo.repayAmount){
                        repayAmountZ=parseFloat(dialogScope.loaninfo.repayAmount);
                    }
                    dialogScope.save_onClick = function(){
                        if($.doValidate("loaninfo")){
                            //repayAmount 回款金额不能大于页面的本次入账总额，如果页面有的话
                            //本次入账总额
                            var returnAmount=parseFloat($scope.otherform.returnAmount);
                            var totalRepayAmount=repayAmount_sum();//页面所有借据的本次入账总额
                            var repayAmount =parseFloat(dialogScope.loaninfo.repayAmount);
                            totalRepayAmount=totalRepayAmount-repayAmountZ+repayAmount;
                            //页面的偿还金额-原借据还款金额+现在的还款金额=现在的页面的偿还金额
                            //如果现在的偿还金额>本次偿还总金额，则报错
                            if(returnAmount<totalRepayAmount){
                                $common.get_tipDialog("本次还款金额不足以还款，请降低融资信息'还款金额'！",'showError');
                                return;
                            }
                            var lnciBal=parseFloat(dialogScope.loaninfo.lnciBal);
                            if(lnciBal < repayAmount ){
                                $common.get_tipDialog("'还款金额'不可超过'借据余额'！",'showError');
                                return;
                            }
                            var dsArray = $scope.loanSource;
                            var selected = $scope.loanselected.select[0];
                            for(var k in dsArray){
                                if (dsArray[k].debetId == selected.debetId) {
                                    $scope.loanSource[k]=$common.copy(dialogScope.loaninfo);
                                }
                            }
                            pageHelper2();
                            remainAmount ();//尾款金额计算
                            $scope.loanselected.select=[];
                            $scope.$apply();
                            dialogScope.closeThisDialog();
                        }
                    };
                    dialogScope.back_onClick = function(){
                        dialogScope.closeThisDialog();
                    }
                }],"编辑融资信息",{showClose:true});
        }
    }
   //页面融资信息删除
    function deleteloan(){
        if ($scope.loanselected.select.length != 1) {
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        } else {
            var dsArray = $scope.loanSource;
            var selected = $scope.loanselected.select[0];
            for(var x in dsArray){
                if(dsArray[x].debetId==selected.debetId){
                    dsArray.splice(x,1);
                }
            }
            sequenceLoanInfo();
            remainAmount ();//尾款金额计算
            $scope.loanselected.select=[];
            $scope.$apply();
        }
    }

    //保存但不发起流程
    $scope.saveForm_onClick=function(){
        if($.doValidate("otherform")) {
            if(checkMoneyRules()==true){
                $scope.otherform.amount=$scope.otherform.returnAmount;//本次入账总额才是本次回款总额
                var data2 = {
                    value: $scope.otherform,//申请业务信息
                    debtList: $scope.dataSource,//核销单据信息
                    loanList:$scope.loanSource//借据信息
                };
                var promise = $common.get_asyncData("nRBcpPaymentService/saveCashPaymentInfoApply", data2);
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
    };
    //直接保存并发起流程
    $scope.submitForm_onClick=function(){
        if($.doValidate("otherform")) {
            if(checkMoneyRules()==true){
                $scope.submit=true;
                var param = {
                    productId:$scope.otherform.supplyChainPdId,
                    invokPhase:"06"
                };
                $scope.otherform.invokPhase = "06";
                //获取风险拦截模型ID
                $common.get_asyncData("bprdChkdirInfoService/findBPrdChkdirInfoByParam",{omap:param}).then(function(res){
                    if (res.errorCode =="SUC"){
                        var data = res.contextData;
                        var mdlId = data.mdlId;
                        if(mdlId==undefined||mdlId==""||mdlId==null)
                        {
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
        }
    };
    //监听业务拦截事件
    $scope.$on('interceptEvent',function(event,data) {
        console.log("data信息："+JSON.stringify(data));
        //根据业务拦截处理结果，执行成功继续提交，未执行成功返回
        if(data.checkResult!='SUC'){
            $scope.submit=false;
            return;
        }
        $scope.otherform.amount=$scope.otherform.returnAmount;//本次入账总额才是本次回款总额
        var data2 = {
            value: $scope.otherform,//申请业务信息
            debtList: $scope.dataSource,//核销单据信息
            loanList:$scope.loanSource//借据信息
        };
        var promise = $common.get_asyncData("nRBcpPaymentService/submitCashPaymentInfoApplyInfo", data2);
        promise.then(function (res) {
            if (res.errorCode == "SUC") {
                $common.get_tipDialog('提交成功！', 'showSuccess');
                $state.go("list");
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

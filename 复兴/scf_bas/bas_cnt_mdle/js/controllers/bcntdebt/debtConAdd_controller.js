/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */

var debtConAddController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {

    /**合同基本信息 开始**/
    $scope.otherform={};
    $scope.selectbrNo={}; //机构
    var  bData =dataDeliver.getter();
    if(bData.flag == "add"){
        //新增信息初始化
        initBCntDebtInfo();
    }else if (bData.flag == "update"){
        queryBCntDebtInfo();
        //设置只读
        $scope.productNameDisable=true;
        $scope.cnameDisable=true;
    }
    function initBCntDebtInfo(){
        var data ={
        };
        var promise=$common.get_asyncData("bCntDebtInfoService/initBCntDebtInfo",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.otherform=data;
                $scope.selectbrNo.ds =data.listBctl;
                $scope.otherform.brNo=data.brcode;
                $scope.brNoDisable =true;
                //设置页面的默认值 币种，费用收取方式，服务内容，回款是否自动还款
                $scope.otherform.curcd="CNY";
                $scope.otherform.chargeType="02";
                $scope.otherform.serviceContent=["1"];
                $scope.otherform.isAutoPay="00";
                //回款是否自动还款 默认否，自动还款提前天数只读
                $scope.autoPayDaysDisable=true;
                /*  $scope.queryTable();
                 $scope.querysubTable();*/
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    };
//根据合同编号加载应收账款合同信息
    function queryBCntDebtInfo(){
        var data ={
            debtContVO:{debtContno:bData.debtContno}
        };
        var promise=$common.get_asyncData("bCntDebtInfoService/queryBCntDebtInfoByContno",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.otherform=data;
                $scope.selectbrNo.ds =data.listBctl;
                $scope.otherform.brNo=data.brcode;
                if(data.serviceContent) {
                    $scope.otherform.serviceContent=JSON.parse(data.serviceContent);
                }
                if(data.loanWay){
                    $scope.otherform.loanWay=JSON.parse(data.loanWay);
                }
                if( $scope.otherform.chargeType=="02"){ //单笔
                    findCostInfoList();
                } else{
                    $("#costinfo").css('display','none'); //不显示费用信息
                }
                if( $scope.otherform.isAutoPay=="00"){//回款是否自动还款 01 是，00 否
                    $scope.autoPayDaysDisable=true;
                }
                queryDebtExtInfo();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    };
//卖方名称筛选
    $scope.cnameContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.otherform.custcd=ds.custcd;
        $scope.otherform.cname=ds.cname;
    };
    $scope.$watch("otherform.cname",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.cnameContent.param ={
            custType:"1", //法人
            cname:$scope.otherform.cname,
            creditFlag:"1" //授信客户
        };
        //结算账户参数
        $scope.accountNoContent.param ={
            accountNo:$scope.otherform.accountNo,
            custcd:$scope.otherform.custcd,   //客户
            accountType:"1"  //客户结算账户
        };
        //回款账户参数
        $scope.returnAccountContent.param ={
            accountNo:$scope.otherform.returnAccount,
            custcd:$scope.otherform.custcd,   //客户
            accountType:"2"  //回款专户
        };
        //保证金账号参数
        $scope.bailAcctNoContent.param ={
            accountNo:$scope.otherform.bailAcctNo,
            custcd:$scope.otherform.custcd,   //客户
            accountType:"3"  //保证金账户
        };
        //
    });
    /**
     * 业务品种筛选
     */
    $scope.productNameContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBusinessType",
        param:{ factType:"1" },    //应收账款融资
        split:",",//分隔符
        extentColumn:"productName",
        column:["productName","productId"]//展示内容
    };
    $scope.productNamedooextent = function(ds){
        $scope.otherform.productName=ds.productName;
        $scope.otherform.supplyChainPdId=ds.productId; //业务品种
        $scope.otherform.factType=ds.factType;
        $scope.otherform.financingType=ds.financingType;
    };
    $scope.$watch("otherform.productName",function(newVal,oldVal){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.productNameContent.param ={
            productName:$scope.otherform.productName,
            //productId:$scope.otherform.supplyChainPdId,
            tFactType:"1"  //应收账款融资
        };
        if(bData.flag == "add")
            if (newVal != oldVal) { //获得费用信息
                findCostInfoByProduct();
            }
    });

//结算账号筛选
    $scope.accountNoContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectAccountNo",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"accountNo",
        column:["accountNo"]//展示内容
    };
    $scope.accountNodooextent = function(ds){
        $scope.otherform.accountNo=ds.accountNo;
        $scope.otherform.ID=ds.ID;
    };
    //todo 筛选前的校验
    $scope.$watch("otherform.accountNo",function(){
        //if($scope.otherform.accountNo!=null){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.accountNoContent.param ={
            accountNo:$scope.otherform.accountNo,
            custcd:$scope.otherform.custcd,   //客户
            accountType:"1"  //客户结算账户
        };
        //}
    });

    //回款专户筛选
    $scope.returnAccountContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectAccountNo",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"accountNo",
        column:["accountNo"]//展示内容
    };
    $scope.returnAccountdooextent = function(ds){
        $scope.otherform.returnAccount=ds.accountNo;
        //  $scope.otherform.ID=ds.ID;
    };
    //todo 筛选前的校验
    $scope.$watch("otherform.returnAccount",function(){
        //if($scope.otherform.returnAccount!=null){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.returnAccountContent.param ={
            accountNo:$scope.otherform.returnAccount,
            custcd:$scope.otherform.custcd,   //客户
            accountType:"2"  //回款专户
        };
        //}
    });

    //回款保证金账号
    $scope.bailAcctNoContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectAccountNo",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"accountNo",
        column:["accountNo"]//展示内容
    };
    $scope.bailAcctNodooextent = function(ds){
        $scope.otherform.bailAcctNo=ds.accountNo;
        //  $scope.otherform.ID=ds.ID;
    };
    //todo 筛选前的校验
    $scope.$watch("otherform.bailAcctNo",function(){
        //if($scope.otherform.accountNo!=null){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.bailAcctNoContent.param ={
            accountNo:$scope.otherform.bailAcctNo,
            custcd:$scope.otherform.custcd,   //客户
            accountType:"3"  //保证金账户
        };
        //}
    });
    //合作机构筛选
    $scope.cooperationBrcodeContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBranchInfo",//请求url
        param:{ brAttr:"1"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"brName",
        column:["brNo","brName"]//展示内容
    };
    $scope.cooperationBrcodedooextent = function(ds){
        $scope.otherform.cooperationBrcode=ds.brNo;
        $scope.otherform.cooperationBrcodeNm=ds.brName;
    };
    $scope.$watch("otherform.cooperationBrcodeName",function(){
        //if($scope.otherform.cooperationBrcodeName!=null){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.cooperationBrcodeContent.param ={
            brNo:$scope.otherform.cooperationBrcode,
            brName:$scope.otherform.cooperationBrcodeNm,
            brAttr:"1"  //机构属性：0-非村镇银行、1-村镇银行
        };
        //}
    });
//费用收取方式
    $scope.chargeTypeChange=function(val){
        if(val=="01"){ //按年
           // $scope.costtableIdhide =true;
            $scope.costdatasource.ds=[];//按年时清空费用信息
            $scope.costselected.select=[];
        	$("#costinfo").css('display','none'); //不显示费用信息
        }else if(val=="02"&&$scope.otherform.supplyChainPdId!=null){
        	$("#costinfo").css('display','');
            if($scope.otherform.debtContno==null){ //  新增
                findCostInfoByProduct(); //获得费用信息
            } else if(bData.flag == "update"){ //获得费用信息
                findCostInfoByProduct();
            }else{
                findCostInfoList();
            }
        }
    };
   /**回款是否自动还款 **/
   $scope.isAutoPayChange =function(val){
        if(val=="01"){// 是
            $scope.autoPayDaysDisable=false;
        }else if(val=="00"){
            $scope.autoPayDaysDisable=true;
            //清空
            $scope.otherform.autoPayDays="";
        };
    };
    /**合同基本信息 结束**/



    /**费用 开始**/
    $scope.costconf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    $scope.costdatasource={//初始化表格对象
        ds: []
    };
    $scope.costselected={//初始化对象
        select: []
    };
    function findCostInfoByProduct(){
        var data={
            value:{
                productId:$scope.otherform.supplyChainPdId
            }
        };
        var promise=$common.get_asyncData("bCntDebtInfoService/findCostInfoByProduct",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.costdatasource.ds=data.records;
               $scope.costconf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    //根据合同编号加载费用信息
    function findCostInfoList(){
        var data={
            mastContQryVO:{
                mastContCode:bData.debtContno
            }
        };
        var promise=$common.get_asyncData("bCntDebtInfoService/findCostInfoListByContno",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.costdatasource.ds=data;
                //$scope.costconf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    //费用修改
    $scope.costInfoupdate_onClick = function(){
        if($scope.costselected.select.length <= 0){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('bcntdebt/costInfoMod.html',$scope
                ,["$scope",function(dialogScope){
                    // bicrinfosubController(dialogScope,$scope,$common,"update");
                    dialogScope.costform=$common.copy($scope.costselected.select[0]);
                    if(dialogScope.costform.costCalcType==1){
                        dialogScope.costRateDisable=true; //只读
                        dialogScope.costAmtRequire = "common.require"; //必输
                    }else if(dialogScope.costform.costCalcType==2){
                        dialogScope.costAmtDisable=true;  //只读
                        dialogScope.costRateRequire = "common.require"; //必输
                    }
                    dialogScope.costCalcTypeChange =function(val){
                        if(val==1){//固定
                            //设置只读
                            dialogScope.costRateDisable=true;
                            dialogScope.costAmtDisable=false;
                            dialogScope.costform.costRate="";//清空比率
                            //设置是否必输
                            dialogScope.costAmtRequire = "common.require";
                            dialogScope.costRateRequire = "";
                        }else if(val==2){ //按比率
                            //设置只读
                            dialogScope.costRateDisable=false;
                            dialogScope.costAmtDisable=true;
                            dialogScope.costform.costAmt="";//清空费用
                            //设置是否必输
                            dialogScope.costRateRequire = "common.require";
                            dialogScope.costAmtRequire = "";
                        }
                    };
                    //确认
                    dialogScope.confirm_onClick = function(){
                        if($.doValidate("costform")) {
                            if(dialogScope.costform.costRate)
                            {
                                var costRate = dialogScope.costform.costRate;//费用比率(%)
                                if(costRate<0||costRate>100)
                                {
                                    $common.get_tipDialog('费用比率(%)必须>=0并且<=100！','showInform');
                                    return;
                                }
                            }
                            if(dialogScope.costform.costAmt)
                            {
                                var costAmt = dialogScope.costform.costAmt;//固定费用
                                if(costAmt<0)
                                {
                                    $common.get_tipDialog('固定费用必须>=0！','showInform');
                                    return;
                                }
                            }
                            //遍历已增加记录，修改相应的记录
                            var dsArray = $scope.costdatasource.ds;
                            var selected = $scope.costselected.select[0];
                            for (var i = 0; i < dsArray.length; i++) {
                                if (dsArray[i].productId == selected.productId) {
                                    $scope.costdatasource.ds[i] =$common.copy(dialogScope.costform);
                                    $scope.costselected.select=[]; //清空选中记录
                                }
                            }
                        }else{
                            //$common.get_tipDialog('页面输入校验不通过，请检查！','showInform');
                            return false;
                        }
                        dialogScope.closeThisDialog();
                    };
                    //返回
                    dialogScope.closeThisDialog_onClick = function(){
                        dialogScope.closeThisDialog();
                    };
                }],"",{showClose:true});
        }
    };

    /**费用 结束**/
    /* 交易对手 开始*/
  $scope.debtExtconf= {//初始化分页对象交易对手
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    $scope.debtExtdatasource={//初始化表格对象
        ds: []
    };
    $scope.debtExtselected={//初始化对象
        select: []
    };
    $scope.extdatasource={//初始化表格对象
        ds: []
    };
    //交易对手新增
    $scope.debtExtadd_onClick = function(){
        if($scope.otherform.custcd==null||$scope.otherform.cname==null) {
            $common.get_tipDialog('客户号获取失败，请重新选择客户名称！','showInform');
            return false;
        }
     var data={
         custcd :$scope.otherform.custcd
     };
       /* if($scope.debtExtdatasource.ds.length>0){
            for(var i=0;i<$scope.debtExtdatasource.ds.length;i++){
                $scope.extdatasource.ds[i]={
                    buyerCustcd:$scope.debtExtdatasource.ds[i].buyerCustcd,
                    buyerName:$scope.debtExtdatasource.ds[i].buyerName
                }
            }
        }*/
        dataDeliver.setter(data);
        $common.get_ngDialog('bcntdebt/debtExtSelect.html', $scope
            ,["$scope",function(dialogScope){
                debtExtSelectController(dialogScope,$scope,$common,dataDeliver,"add");
            }],"",{showClose:true});

    };
    //交易对手修改
    $scope.debtExtupdate_onClick = function(){
     if($scope.debtExtselected.select.length <= 0){
     $common.get_tipDialog('请选择一条记录！','showInform');
     }else{
     $common.get_ngDialog('bcntdebt/debtExtMod.html',$scope
     ,["$scope",function(dialogScope){
    // bicrinfosubController(dialogScope,$scope,$common,"update");
    dialogScope.debtExtform=$common.copy($scope.debtExtselected.select[0]);
        //有无追索权
         if(dialogScope.debtExtform.recoverType==1){
             dialogScope.creditTermDisable=true;
             dialogScope.creditAmtDisable=true;
             dialogScope.riskTermDisable=true;
             dialogScope.recoverTypeRequire="";//有追索
         }else{
             dialogScope.creditTermDisable=false;
             dialogScope.creditAmtDisable=false;
             dialogScope.riskTermDisable=false;
             dialogScope.recoverTypeRequire="common.require";//无追索必输
             }
         dialogScope.recoverTypeChange =function(val){
             if(val==1){// 有追索
                 //设置只读
                 dialogScope.creditTermDisable=true;
                 dialogScope.creditAmtDisable=true;
                 dialogScope.riskTermDisable=true;
                 //清空
                 dialogScope.debtExtform.creditTerm ="";
                 dialogScope.debtExtform.creditAmt ="";
                 dialogScope.debtExtform.riskTerm ="";
                 //设置是否必输
                 dialogScope.recoverTypeRequire="";//有追索
             }else if(val==2){//无追索
                 dialogScope.creditTermDisable=false;
                 dialogScope.creditAmtDisable=false;
                 dialogScope.riskTermDisable=false;
                 dialogScope.recoverTypeRequire="common.require";//无追索必输
             }
         };
         // 保理方式
         if(dialogScope.debtExtform.factPattern==2){
             dialogScope.noticeTypeDisable=true;
             dialogScope.noticeTypeRequire="";
         }else{
             dialogScope.noticeTypeRequire="common.require";
         }
         dialogScope.factPatternChange =function(val){
             if(val==2){// 暗保理
                 dialogScope.noticeTypeDisable=true;
                 dialogScope.debtExtform.noticeType ="";//清空通知书方式
                 dialogScope.noticeTypeRequire="";
             }else if(val==1){
                 dialogScope.noticeTypeDisable=false;
                 //明保理通知书方式必输
                 dialogScope.noticeTypeRequire="common.require";
             }
         };
        //确认
         dialogScope.confirm_onClick = function(){
             if($.doValidate("debtExtform")) {
                 var loanDays = Number(dialogScope.debtExtform.loanDays);//账期（天）
                 if(loanDays<=0)
                 {
                     $common.get_tipDialog('账期（天）必须>0！','showInform');
                     return;
                 }
                 var debtGraceDays = dialogScope.debtExtform.debtGraceDays;//宽限期（天）
                 if(debtGraceDays<0)
                 {
                     $common.get_tipDialog('宽限期（天）必须>=0！','showInform');
                     return;
                 }
                 var loanPercent = dialogScope.debtExtform.loanPercent;//融资比例（%）0-100
                 if(loanPercent<=0||loanPercent>100)
                 {
                     $common.get_tipDialog('融资比例（%）必须>0并且<=100！','showInform');
                     return;
                 }
                 var creditTerm = dialogScope.debtExtform.creditTerm;//信用期限（天）
                 if(creditTerm<0)
                 {
                     $common.get_tipDialog('信用期限（天）必须>=0！','showInform');
                     return;
                 }
                 var creditAmt = dialogScope.debtExtform.creditAmt;//信用限额
                 if(creditAmt<0)
                 {
                     $common.get_tipDialog('信用限额必须>=0！','showInform');
                     return;
                 }
                 var riskTerm = dialogScope.debtExtform.riskTerm;//信险宽限期（天）
                 if(riskTerm<0)
                 {
                     $common.get_tipDialog('信险宽限期（天）必须>=0！','showInform');
                     return;
                 }
                 //遍历已增加记录，修改相应的记录
                var dsArray = $scope.debtExtdatasource.ds;
                  var selected = $scope.debtExtselected.select[0];
                  for (var i = 0; i < dsArray.length; i++) {
                  if (dsArray[i].buyerCustcd == selected.buyerCustcd) {
                      $scope.debtExtdatasource.ds[i] =$common.copy(dialogScope.debtExtform);
                      $scope.debtExtselected.select=[]; //清空选中记录
                    }
                  }
             }else{
               //  $common.get_tipDialog('页面输入校验不通过，请检查！','showInform');
                 return false;
             };
             $scope.debtExtselected.select=[];
             dialogScope.closeThisDialog();
         };
         //返回
         dialogScope.closeThisDialog_onClick = function(){
             dialogScope.closeThisDialog();
         };
     }],"",{showClose:true});
     }
     };


    //交易对手删除
    var del_buyerCustcd=[];
    $scope.debtExtdelete_onClick = function() {
        if ($scope.debtExtselected.select.length != 1) {
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        }else {
            $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
                var dsArray = $scope.debtExtdatasource.ds;
                var selected = $scope.debtExtselected.select[0];
                for (var i = 0; i < dsArray.length; i++) {
                    if (dsArray[i].buyerCustcd == selected.buyerCustcd) {
                        del_buyerCustcd.push(selected.buyerCustcd);
                        $scope.debtExtdatasource.ds.splice(i, 1);
                        $scope.debtExtselected.select = [];
                    }
                }
            })
        }
    };
    //根据合同编号加载交易对手信息
    function queryDebtExtInfo(){
        var data ={
            pageNo: $scope.debtExtconf.pageNo,
            pageSize: $scope.debtExtconf.pageSize,
            debtContVO:{debtContno:bData.debtContno}
        };
        var promise=$common.get_asyncData("bCntDebtInfoService/queryBCntDebtExtInfoByContno",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.debtExtdatasource.ds =data.records;
                $scope.debtExtconf.totalRecord = data.totalRecord;
                // $scope.querysubTable();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    /* 交易对手 结束*/
    $scope.save_onClick = function(){
        if($.doValidate("otherform")) {
            var serviceContent = $scope.otherform.serviceContent;//服务内容
            if(serviceContent==null||serviceContent==undefined||serviceContent.length==0){
                $common.get_tipDialog("请选择服务内容！", 'showInform');
                return false;
            }
            var loanWay = $scope.otherform.loanWay;//出账方式
            if(loanWay==null||loanWay==undefined||loanWay.length==0){
                $common.get_tipDialog("请选择出账方式！", 'showInform');
                return false;
            }
            var data = {
                debtContVO: $scope.otherform,
                //delbuyerCustcd:del_buyerCustcd,
                costInfoList:$scope.costdatasource.ds,
                debtExtInfoList: $scope.debtExtdatasource.ds
            };
            var isAutoPay = $scope.otherform.isAutoPay; //回款是否自动还款 01 是，00 否
            if(isAutoPay == "01"){
                var isAutoPay = $scope.otherform.autoPayDays; //自动还款提前天数
                if(isAutoPay==null || isAutoPay == ""){
                    $common.get_tipDialog("自动还款提前天数不能为空！", 'showInform');
                    return false;
                }
            }
            var chargeType = $scope.otherform.chargeType;//费用收取方式01	按年 02	单笔
            //todo
            // 费用校验
            if(chargeType == "02"){
                var record = $scope.costdatasource.ds;
                for (i = 0; i < record.length;i++) {
                    var costName =record[i].costName;
                    var costClass=record[i].costClass;
                    var costPhase=record[i].costPhase;
                    var costType=record[i].costType;
                    var chargeType=record[i].chargeType;
                    var costCalcType=record[i].costCalcType;

                    if(costType==null){
                       $common.get_tipDialog(costName+"-费用收取方式不能为空！", 'showInform');
                       return false;
                   }
                    if(costType!="3"){

                        if(costClass==null || costClass == undefined){
                            $common.get_tipDialog(costName+"-费用种类不能为空！", 'showInform');
                            return false;
                        }
                        if(costPhase==null || costPhase == undefined){
                            $common.get_tipDialog(costName+"-费用收取阶段不能为空！", 'showInform');
                            return false;
                        }
                        if(chargeType==null || chargeType == undefined){
                            $common.get_tipDialog(costName+"-费用扣取方式不能为空！", 'showInform');
                            return false;
                        }
                        if(costCalcType==null || costCalcType == undefined){
                            $common.get_tipDialog(costName+"-费用计算方式不能为空！", 'showInform');
                            return false;
                        }
                        if(costCalcType=="1"){
                            var costAmt=record[i].costAmt;
                            if(costAmt==null||costAmt==undefined||isNaN(costAmt)){
                                $common.get_tipDialog(costName+"-固定费用不能为空！", 'showInform');
                                return false;
                            }
                        }
                        if(costCalcType=="2"){
                            var costRate=record[i].costRate;
                            if(costRate==null||costRate==undefined||isNaN(costRate)){
                                $common.get_tipDialog(costName+"-费用比率(%)不能为空！", 'showInform');
                                return false;
                            }
                        }
                    }else{
                        if(costType==null || costType == undefined){
                            $common.get_tipDialog(costName+"-费用收取方式不能为空！", 'showInform');
                            return false;
                        }
                    }
                }
            }
            //交易对手校验
            if($scope.debtExtdatasource.ds.length<=0){
                $common.get_tipDialog("请添加交易对手！", 'showInform');
                return false;
            }else{
                var sellerCustcd =$scope.otherform.custcd; //卖方客户
                var debtExt =$scope.debtExtdatasource.ds;
                for(var k=0; k< debtExt.length;k++){
                    var cname = debtExt[k].buyerName;
                    var loanDays = debtExt[k].loanDays;
                    var debtGraceDays = debtExt[k].debtGraceDays;
                    var buyerCustcd =debtExt[k].buyerCustcd;
                    var recoverType = debtExt[k].recoverType;
                    var factPattern = debtExt[k].factPattern;
                    var noticeType = debtExt[k].noticeType;
                    var creditAmt = debtExt[k].creditAmt;
                    var creditTerm = debtExt[k].creditTerm;
                    var loanPercentExt = debtExt[k].loanPercent;
                    var riskTerm = debtExt[k].riskTerm;
                    if(sellerCustcd!=null&&sellerCustcd!=""){
                        if(buyerCustcd==sellerCustcd){
                            $common.get_tipDialog("交易对手不能为卖方客户！", 'showInform');
                            return false;
                        }
                    }
                    if(recoverType==null || recoverType==undefined){
                        $common.get_tipDialog("请点击[修改]按钮后选择交易对手【"+cname+"】有无追索权！", 'showInform');
                        return false;
                    }
                    if(factPattern==null || factPattern==undefined){
                         $common.get_tipDialog("请点击[修改]按钮后选择交易对手【"+cname+"】保理方式！", 'showInform');
                        return false;
                    }
                    if(factPattern=="1" &&(noticeType == null|| noticeType==undefined)){
                         $common.get_tipDialog("请点击[修改]按钮后选择交易对手【"+cname+"】通知方式！", 'showInform');
                        return false;
                    }
                    if(loanDays==null || loanDays==undefined){
                         $common.get_tipDialog("交易对手【"+cname+"】账期不能为空", 'showInform');
                        return false;
                    }
                    if(debtGraceDays==null || debtGraceDays==undefined){
                         $common.get_tipDialog("交易对手【"+cname+"】宽限日不能为空", 'showInform');
                        return false;
                    }
                    if(loanPercentExt==null || loanPercentExt==undefined){
                         $common.get_tipDialog("交易对手【"+cname+"】融资比例不能为空", 'showInform');
                        return false;
                    }
                    if(recoverType==2){
                        if(creditAmt==null || creditAmt==undefined){
                             $common.get_tipDialog("交易对手【"+cname+"】信用限额不能为空", 'showInform');
                            return false;
                        }
                        if(creditTerm==null || creditTerm==undefined){
                             $common.get_tipDialog("交易对手【"+cname+"】信用期限不能为空", 'showInform');
                            return false;
                        }
                        if(riskTerm==null || riskTerm==undefined){
                             $common.get_tipDialog("交易对手【"+cname+"】信险宽限期不能为空", 'showInform');
                            return false;
                        }
                    }
                }
            }


            if(bData.flag == "add"){
                //新增信息保存
                var primise = $common.get_asyncData("bCntDebtInfoService/saveCntDebtInfoAdd", data);
            }else if (bData.flag == "update"){
                var primise = $common.get_asyncData("bCntDebtInfoService/saveCntDebtInfoModify", data);
            }
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                   // $scope.queryTable();
                   // $scope.selected.select = [];
                    $common.get_tipDialog('保存成功！', 'showSuccess');
                    $scope.back_onClick();//返回列表
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        }
    };
    $scope.back_onClick = function () {
        $state.go("bcntdebtList");
    };
    //表格--------结束-------------------------
};

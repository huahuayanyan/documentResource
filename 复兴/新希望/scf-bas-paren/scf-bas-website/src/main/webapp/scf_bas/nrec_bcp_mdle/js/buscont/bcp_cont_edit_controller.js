/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2017/5/19
 */
var nrBcpContEditController =  function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    //页面 custcd,cname客户名称，supplyChainPdId,supplyChainPdNm业务品种，tlrcd,tlrNm以及创建人都是需要翻译的
    $scope.otherform = dataDeliver.getter();
    $scope.costform = {};
    var factType = $scope.otherform.factType;
    if(factType=="1"||factType=="2"||factType=="6")
    {
        if($scope.otherform.recoverType=="1")
        {//有追索
            $scope.creditDisable=true;
            $scope.creditRequire="";
        }
        else if($scope.otherform.recoverType=="2")
        {//无追索
            $scope.creditDisable=false;
            $scope.creditRequire="common.require";
        }
    }
    else if(factType=="7"||factType=="8"||factType=="9")
    {
        $scope.creditHide = true;
    }
    else
    {
        $scope.creditDisable=false;
        $scope.creditRequire="common.require";
    }

    var flag = $scope.otherform.flag;
    if(flag=="edit")
    {
        $scope.disable = false;
    }
    if(flag=="view")
    {
        $scope.disable = true;
        $scope.creditDisable=true;
        $scope.noticeTypeDisable=true;
        $scope.costRateDisable = true;
        $scope.costAmtDisable = true;
        $scope.hide = true;
        if(factType=="1"||factType=="2"||factType=="6")
        {
            if($scope.otherform.recoverType=="1")
            {//有追索
                $scope.creditRequire="";
            }
            else if($scope.otherform.recoverType=="2")
            {//无追索
                $scope.creditRequire="common.require";
            }
        }
        else if(factType=="7"||factType=="8"||factType=="9")
        {
            $scope.creditHide = true;
        }
        else
        {
            $scope.creditRequire="common.require";
        }
    }
    if(flag=="genview")
    {//综合台帐查询时使用
        $scope.disable = true;
        $scope.creditDisable=true;
        $scope.noticeTypeDisable=true;
        $scope.costRateDisable = true;
        $scope.costAmtDisable = true;
        $scope.hide = true;
        $scope.genHide = true;
        if(factType=="1"||factType=="2"||factType=="6")
        {
            if($scope.otherform.recoverType=="1")
            {//有追索
                $scope.creditRequire="";
            }
            else if($scope.otherform.recoverType=="2")
            {//无追索
                $scope.creditRequire="common.require";
            }
        }
        else if(factType=="7"||factType=="8"||factType=="9")
        {
            $scope.creditHide = true;
        }
        else
        {
            $scope.creditRequire="common.require";
        }
    }

    $scope.productselect = {//业务品种下拉框
        ds:[]
    };
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.productSourceList();
        $scope.productCost();
    });
    //查询业务品种
    $scope.productSourceList = function(){
        //业务品种下拉框
        var bPrdInfo = {parentId:"3000",status:"1"};
        var data = {bPrdInfo:bPrdInfo};
        $common.get_asyncData("bcntBcpAppliBaseInfoService/getProductId",data).then(function(res){
            if (res.errorCode =="SUC"){
                $scope.productselect.ds = res.contextData||[];
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    };

    //查询费用信息
    $scope.productCost = function(){
        var data = {
            mastContno: $scope.otherform.mastContno,
            productId: $scope.otherform.supplyChainPdId,
            costPhase: "01"
        };
        $common.get_asyncData("nbprdCostBindService/findBPrdCostInfoByProductIdAndCostPhase", {omap:data}).then(function (res) {
            if (res.errorCode == "SUC") {
                $scope.costform = res.contextData[0];
                if(flag!="view"&&flag!="genview")
                {
                    if($scope.costform.costCalcType=="1")
                    {//固定
                        $scope.costform.costRate = "";//费用比率为空
                        $scope.amtregexp = "common.require";
                        $scope.rateregexp = "";
                        $scope.costRateDisable = true;
                        $scope.costAmtDisable = false;
                    }
                    else if($scope.costform.costCalcType=="2")
                    {//按比率
                        $scope.costform.costAmt = "";//固定费用为空
                        $scope.amtregexp = "";
                        $scope.rateregexp = "common.require";
                        $scope.costRateDisable = false;
                        $scope.costAmtDisable = true;
                    }
                }
                $scope.$apply();
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        });
    };

    $scope.costCalcTypeChange = function(val)
    {
        if(val=="1")
        {//固定
            $scope.costform.costRate = "";//费用比率为空
            $scope.amtregexp = "common.require";
            $scope.rateregexp = "";
            $scope.costRateDisable = true;
            $scope.costAmtDisable = false;
        }
        else if(val=="2")
        {//按比率
            $scope.costform.costAmt = "";//固定费用为空
            $scope.amtregexp = "";
            $scope.rateregexp = "common.require";
            $scope.costRateDisable = false;
            $scope.costAmtDisable = true;
        }
    };

    $scope.$watch("otherform.cname",function(){
        //保险公司参数
        $scope.cnameContent.param ={
            custType:"1", //法人
            insureFlag:"1"//保险公司
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
        //贸易对手保理商参数
        $scope.factoringContent.param ={
            custType:"1", //法人
            factorFlag:"1"//保理公司
        };
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
    });

    //回款专户筛选
    $scope.returnAccountContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectAccountNo",//请求url
        split:"-",//分隔符
        extentColumn:"accountNo",
        column:["accountNo"]//展示内容
    };
    $scope.returnAccountdooextent = function(ds){
        $scope.otherform.returnAccount=ds.accountNo;
    };
    $scope.$watch("otherform.returnAccount",function(){
        $scope.returnAccountContent.param ={
            accountNo:$scope.otherform.returnAccount,
            custcd:$scope.otherform.custcd,   //客户
            accountType:"2"  //回款专户
        };
        //}
    });

    //保险公司筛选
    $scope.cnameContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBCrmBaseInfo",//请求url
        split:"-",//分隔符
        extentColumn:"insuranceName",
        column:["cname","custcd"]//展示内容
    };
    $scope.cnameExtent = function(ds){
        $scope.otherform.insuranceName=ds.cname;
        $scope.otherform.insuranceCustcd = ds.custcd;
    };
    //todo 筛选前的校验
    $scope.$watch("otherform.insuranceName",function(){
        if($scope.otherform.insuranceName)
        $scope.cnameContent.param ={
            custcd:$scope.otherform.insuranceCustcd,
            cname:$scope.otherform.insuranceName   //客户
        };
    });

    //贸易对手保理商筛选
    $scope.factoringContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBCrmBaseInfo",//请求url
        split:"-",//分隔符
        extentColumn:"factoringBrcodeName",
        column:["cname","custcd"]//展示内容
    };
    $scope.factoringExtent = function(ds){
        $scope.otherform.factoringBrcodeName=ds.cname;
        $scope.otherform.factoringBrcode = ds.custcd;
    };
    //todo 筛选前的校验
    $scope.$watch("otherform.factoringBrcodeName",function(){
        if($scope.otherform.factoringBrcode)
        $scope.factoringContent.param ={
            custcd:$scope.otherform.factoringBrcode,
            cname:$scope.otherform.factoringBrcodeName
        };
    });

    $scope.recoverTypeChange =function(val){
        if(factType=="1"||factType=="2"||factType=="6")
        {
            if(val==1)
            {// 有追索
                //设置只读
                $scope.creditDisable=true;
                //清空
                $scope.otherform.creditTerm ="";
                $scope.otherform.creditAmt ="";
                $scope.otherform.riskTerm ="";
                //设置是否必输
                $scope.creditRequire="";//有追索
            }
            else if(val==2)
            {//无追索
                $scope.creditDisable=false;
                $scope.creditRequire="common.require";//无追索必输
            }
        }
        else if(factType=="7"||factType=="8"||factType=="9")
        {
            $scope.creditHide = true;
        }
        else
        {
            $scope.creditDisable=false;
            $scope.creditRequire="common.require";
        }
    };
    // 保理方式
    if($scope.otherform.factPattern==2){
        $scope.noticeTypeDisable=true;
        $scope.noticeTypeRequire="";
    }else{
        $scope.noticeTypeRequire="common.require";
    }
    $scope.factPatternChange =function(val){
        if(val==2){// 暗保理
            $scope.noticeTypeDisable=true;
            $scope.otherform.noticeType ="";//清空通知书方式
            $scope.noticeTypeRequire="";
        }else if(val==1){
            $scope.noticeTypeDisable=false;
            //明保理通知书方式必输
            $scope.noticeTypeRequire="common.require";
        }
    };

    //保存
    $scope.save_onClick = function(){
        if($.doValidate("otherform")) {
            if($scope.costform.costCalcType=="1") {//固定
                if($scope.costform.costAmt)
                {
                    var costAmt = Number($scope.costform.costAmt);//固定费用
                    if(costAmt<0)
                    {
                        $common.get_tipDialog('固定费用必须>=0！','showInform');
                        return;
                    }
                }
            }
            else  if($scope.costform.costCalcType=="1") {//按比率
                if($scope.costform.costRate)
                {
                    var costRate = Number($scope.costform.costRate);//费用比率(%)
                    var minRate = Number($scope.costform.minRate);
                    var maxRate = Number($scope.costform.maxRate);
                    if(costRate<minRate||costRate>maxRate)
                    {
                        $common.get_tipDialog('费用比率必须大于等于'+minRate+'%小于等于'+maxRate+'！','showInform');
                        return;
                    }
                }
            }
            var loanDays = Number($scope.otherform.loanDays);//账期（天）
            if(loanDays<=0)
            {
                $common.get_tipDialog('账期（天）必须>0！','showInform');
                return;
            }
            var debtGraceDays = $scope.otherform.debtGraceDays;//宽限期（天）
            if(debtGraceDays<0)
            {
                $common.get_tipDialog('宽限期（天）必须>=0！','showInform');
                return;
            }
            var loanPercent = $scope.otherform.loanPercent;//融资比例（%）0-100
            if(loanPercent<=0||loanPercent>100)
            {
                $common.get_tipDialog('融资比例（%）必须>0并且<=100！','showInform');
                return;
            }
            var creditTerm = $scope.otherform.creditTerm;//信用期限（天）
            if(creditTerm<0)
            {
                $common.get_tipDialog('信用期限（天）必须>=0！','showInform');
                return;
            }
            var creditAmt = $scope.otherform.creditAmt;//信用限额
            if(creditAmt<0)
            {
                $common.get_tipDialog('信用限额必须>=0！','showInform');
                return;
            }
            var riskTerm = $scope.otherform.riskTerm;//信险宽限期（天）
            if(riskTerm<0)
            {
                $common.get_tipDialog('信险宽限期（天）必须>=0！','showInform');
                return;
            }
            var data = {
                bcntBcpInfoVO:$scope.otherform,
                bCntCostInfoVO:$scope.costform
            };
            $common.get_asyncData("bcntBcpInfoService/saveOrUpdateBCntBcpInfo",data).then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('保存成功！','showSuccess');
                    $state.go("list");
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };

    $scope.back_onClick = function()
    {
        $state.go("list");
    }
};

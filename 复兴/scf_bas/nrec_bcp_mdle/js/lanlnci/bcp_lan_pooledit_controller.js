/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var nrBcpLanPoolEditController = function($scope,$common,$location,dataDeliver,$stateParams,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();

    var debtList = [];//应收账款总列表

    var appno = $scope.otherform.appno;
    if(!appno||appno==undefined)
    {
        appno = window.appNo;
    }
    if(!$scope.otherform.actBrCd)
    {
        $scope.disablepay = true;
    }
    var flag;
    var flag3;
    if($scope.otherform.flag)
    {
        flag = $scope.otherform.flag;
        if(flag=="add")
        {
            $scope.disable = false;
            $scope.hide = false;
            $scope.sumbitdisable = true;
            flag3 = "2";
        }
        else if(flag=="update")
        {
            $scope.disable = false;
            $scope.hide = false;
        }
        else if(flag=="view")
        {
            $scope.disable = true;
            $scope.hide = true;
            $scope.disablepay = true;
        }
    }
    else
    {
        $scope.disable = true;
        $scope.hide = true;
        $scope.disablepay = true;
        $scope.hideback = true;
    }

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
    //监听分页
    var count = 0;
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        if(count==0)
        {
            $scope.queryBaseInfo();
        }
        else
        {
            $scope.getListByPage();
        }
        count++;
    });
    $scope.$watch("otherform.appno",function() {
        if(count!=0)
        {
            $scope.queryDebtAppliList();
        }
    });
    //应收账款放款详情页
    $scope.queryBaseInfo = function(){
        var rbcpduebillappvo = $scope.otherform;
        if(flag3!=undefined||flag3!=null||flag3!="")
        {
            rbcpduebillappvo.flag = flag3;
        }
        var data = {
            rBcpDuebillAppVO:rbcpduebillappvo,
            appno:appno
        };
        $common.get_asyncData("rbcpDuebillAppService/findBCntBcpInfoByMastContno",data).then(function(res){
            if (res.errorCode =="SUC"){
                var data = res.contextData;
                $scope.otherform = data;
                if(!data.appStat)
                {
                    $scope.otherform.appStat = "00";
                }
                if(!$scope.otherform.inpDt)
                {
                    var date = new Date();
                    var year = date.getFullYear();
                    var month = date.getMonth() + 1;
                    var day = date.getDate();
                    if(month < 10){
                        month = "0" + month;
                    }
                    if(day < 10){
                        day = "0" + day;
                    }
                    var currentDate = year + month + day;
                    $scope.otherform.inpDt = currentDate;
                }
                $scope.otherform.financingType_Q = $scope.otherform.financingType;
                $scope.otherform.custcdBuyer_Q = $scope.otherform.businessCustcd;
                $scope.otherform.custcdSaller_Q = $scope.otherform.custcd;
                $scope.otherform.appno_Q = appno;
                if(appno==null||appno==""||appno==undefined)
                {
                    $scope.queryTable();
                }
                else
                {
                    $scope.queryDebtAppliList();
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    $scope.queryTable = function(paramData){
        $scope.otherform.flag = false;
        var data = {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            debtCommonQryVO:$scope.otherform
        };
        $common.get_asyncData("rbcpDuebillAppService/DebtFindGetter",data).then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                debtList = data.records||[];
                $scope.getListByPage();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //利率查询，调用接口
    $scope.checkIntRate_onClick = function()
    {
        var productId = $scope.otherform.supplyChainPdId;
        $common.get_asyncData("rbcpDuebillAppService/CheckActInt",{productId:productId}).then(function(res){
            if (res.errorCode =="SUC"){
                var actInt = res.contextData;
                $scope.otherform.actInt = actInt;
                $scope.$apply();
            }
            else
            {
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    /**
     *  资金提供方查询加载开始
     */
    $scope.custcontent = {
        type:"table",//展示类型table  tree
        url:"bcntBcpAppliBaseInfoService/queryBCrmBaseInfoSource",
        param:{isBank:"1"},
        split:",",//分隔符
        extentColumn:"actBrNm",
        column:["cname","custcd"]//展示内容
    };
    $scope.dooextend = function(ds){
        $scope.otherform.actBrNm = ds.cname;
        $scope.otherform.actBrCd = ds.custcd;
        $scope.disablepay = false;
        //结算账户参数
        $scope.accountNoContent.param ={
            accountNo:$scope.otherform.payActNo,
            custcd:$scope.otherform.actBrCd,   //客户
            accountType:"1"  //客户结算账户
        };
    };
    $scope.$watch("otherform.actBrNm",function(){
        if($scope.otherform.actBrNm!=null)
            $scope.custcontent.param ={
                custcd:$scope.otherform.actBrNm,
                cname:$scope.otherform.actBrNm,
                isBank:"1"
            };
    });
    /**
     * 资金提供方
     */

    //结算账号筛选
    $scope.accountNoContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectAccountNo",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"payActNo",
        column:["accountNo"]//展示内容
    };
    $scope.accountNodooextent = function(ds){
        $scope.otherform.payActNo=ds.accountNo;
        $scope.otherform.payActName = ds.accountName;
        $scope.otherform.payActBank = ds.openAccBankNm;
    };
    //todo 筛选前的校验
    $scope.$watch("otherform.payActNo",function(){
        $scope.accountNoContent.param ={
            accountNo:$scope.otherform.payActNo,
            custcd:$scope.otherform.actBrCd,   //客户
            accountType:"1"  //客户结算账户
        };
    });

    $scope.crNoContent = {
        type:"table",//展示类型table  tree
        url:"rbcpDuebillAppService/queryCustBDcrLinInf",//请求url
        //param:{custcd: $scope.otherform.custcd,otherCustcd:$scope.otherform.businessCustcd},
        param:{custcd: $scope.otherform.businessCustcd},
        split:"-",//分隔符
        extentColumn:"crNo",
        column:["creditNo"]//展示内容
    };
    $scope.crNodooextent = function(ds){
        $scope.otherform.crNo=ds.creditNo;
        $scope.otherform.totalPrice = ds.creditAmount;//核定额度
        $scope.otherform.ableNum = ds.creditUsableAmount;//可用额度
    };
    //todo 筛选前的校验
    $scope.$watch("otherform.crNo",function(){
        if($scope.otherform.crNo)
        {
            $scope.crNoContent.param ={
                creditNo:$scope.otherform.crNo
            };
        }
        else
        {
            $scope.crNoContent.param ={
                //custcd: $scope.otherform.custcd,
                //otherCustcd:$scope.otherform.businessCustcd
                custcd: $scope.otherform.businessCustcd
            };
        }
    });

    $scope.trmMon_onBlur = function(){
        if($scope.otherform.trmMon)
        {
            var trmMon = Number($scope.otherform.trmMon);
            if(trmMon<=0)
            {
                $common.get_tipDialog("期限月不能小于零，请重新输入",'showError');
                $scope.otherform.trmMon="";
                return false;
            }
        }
    };
    $scope.trmDay_onBlur = function(){
        if(($scope.otherform.trmDay!=null&&$scope.otherform.trmDay!=""&&$scope.otherform.trmDay!=undefined)||$scope.otherform.trmDay==0)
        {
            var trmDay = Number($scope.otherform.trmDay);
            if(trmDay<0)
            {
                $common.get_tipDialog("期限日不能小于零，请重新输入",'showError');
                $scope.otherform.trmDay="";
                return false;
            }
            //if(trmDay>31)
            //{
            //    $common.get_tipDialog("期限日不能大于31，请重新输入",'showError');
            //    $scope.otherform.trmDay="";
            //    return;
            //}
        }
        else
        {
            $common.get_tipDialog("期限日不能为空，请重新输入",'showError');
            $scope.otherform.trmDay="";
            return;
        }

    };

    $scope.jxDay_onBlur = function()
    {
        if($scope.otherform.jxDay!=null&&$scope.otherform.jxDay!=""&&$scope.otherform.jxDay!=undefined)
        {
            var jxDay = Number($scope.otherform.jxDay);
            if(jxDay<=0)
            {
                $common.get_tipDialog("结息日不能小于零，请重新输入",'showError');
                $scope.otherform.jxDay="";
                return false;
            }
            var day = 28;
            if(jxDay>day)
            {
                $common.get_tipDialog("结息日不能大于28，请重新输入",'showError');
                $scope.otherform.jxDay="";
                return;
            }
        }
        else
        {
            $common.get_tipDialog("结息日不能为空，请重新输入",'showError');
            $scope.otherform.jxDay="";
            return;
        }
    };

    $scope.save_onClick = function(){
        if($.doValidate("otherform")) {
            //1.应收账款列表不为空
            if(debtList==[])
            {
                $common.get_tipDialog('请添加应收账款信息！','showInform');
                return;
            }
            //2.贸易对手买方保理额度可覆盖申请金额
            var ableNum = Number($scope.otherform.ableNum);//可用额度
            var lnAmt = Number($scope.otherform.lnAmt);//申请金额
            if(lnAmt>ableNum)
            {
                $common.get_tipDialog('保理买方额度可用额度不能覆盖申请金额！','showInform');
                return;
            }
            //3.可融资余额可覆盖申请金额
            var poolUseableAmount = Number($scope.otherform.poolUseableAmount);//可融资金额
            if(lnAmt>poolUseableAmount)
            {
                $common.get_tipDialog('申请金额大于可融资金额！','showInform');
                return;
            }

            $scope.otherform.appno = appno;
            var data = {
                rBcpDuebillAppVO:$scope.otherform,
                debtList:debtList
            };
            $common.get_asyncData("rbcpDuebillAppService/DebtFinancingApplySaveUpdate",data).then(function(res){
                var data;
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('保存成功！','showSuccess');
                    $scope.flowsubmitdisable = false;
                    flag = "update";
                    $scope.otherform.flag = flag;
                    appno = res.contextData.value;
                    $scope.otherform.appno = res.contextData.value;
                    $scope.sumbitdisable = false;
                    $scope.queryDebtAppliList();
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };

    $scope.submit_onClick = function()
    {
        if($.doValidate("otherform")) {
            //1.应收账款列表不为空
            if(debtList==[])
            {
                $common.get_tipDialog('请添加应收账款信息！','showInform');
                return;
            }
            //2.贸易对手买方保理额度可覆盖申请金额
            var ableNum = Number($scope.otherform.ableNum);//可用额度
            var lnAmt = Number($scope.otherform.lnAmt);//申请金额
            if(lnAmt>ableNum)
            {
                $common.get_tipDialog('保理买方额度可用额度不能覆盖申请金额！','showInform');
                return;
            }
            //3.可融资余额可覆盖申请金额
            var poolUseableAmount = Number($scope.otherform.poolUseableAmount);//可融资金额
            if(lnAmt>poolUseableAmount)
            {
                $common.get_tipDialog('申请金额大于可融资金额！','showInform');
                return;
            }
            var param = {
                productId:$scope.otherform.supplyChainPdId,
                invokPhase:"03"
            };
            $scope.otherform.invokPhase = "03";
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
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
        }
    };

    //监听业务拦截事件
    $scope.$on('interceptEvent',function(event,data) {
        console.log("data信息："+JSON.stringify(data));
        //根据业务拦截处理结果，执行成功继续提交，未执行成功返回
        if(data.checkResult!='SUC'){
            return;
        }
        //锁定当前申请状态,防重复提交
        $scope.flowsubmitdisable=true;
        $scope.otherform.appno = appno;
        //池可融资余额
        $scope.otherform.loanRemainingAmount = $scope.otherform.poolUseableAmount;
        var data = {
            rBcpDuebillAppVO:$scope.otherform,
            debtList:debtList
        };
        $common.get_asyncData("rbcpDuebillAppService/DebtFinancingApplySubmitUpdate",data).then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                $common.get_tipDialog('提交成功！','showSuccess');
                $scope.flowsubmitdisable = false;
                $state.go("list");
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    });

    $scope.back_onClick = function()
    {
        $state.go("list");
    };

    //获取已选择并已入库的应收账款列表
    $scope.queryDebtAppliList = function(paramData)
    {
        var appno = $scope.otherform.appno;
        if(appno!=null&&appno!=""&&appno!=undefined)
        {
            $common.get_asyncData("nRBcpAppliBussDtlService/queryRBcpAppliBussDtlByAppno", {appno:appno}).then(function (res) {
                var data;
                if (res.errorCode == "SUC") {
                    data = res.contextData;
                    debtList = data;
                    if(debtList!=[])
                    {
                        for(var x in debtList)
                        {
                            debtList[x].id = debtList[x].debtId;
                        }
                    }
                    $scope.getListByPage();
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showInform');
                }
            });
        }
    };

    $scope.getListByPage = function(paramData)
    {
        var param = {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            list:debtList
        };
        $common.get_asyncData("rbcpDebtInfoService/getListByPage", param).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.datasource.ds = data.records||[];
                $scope.conf.totalRecord = data.totalRecord;
                $scope.selected.select = [];
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    };

    //历程信息
    $scope.progress_onClick=function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        } else {
            var url = "";
            if(window.appNo){
                url='../../nrec_bcp_mdle/html/debtmanage/bcp_debt_progress_list.html'
            }else{
                url='debtmanage/bcp_debt_progress_list.html';
            }
            $common.get_ngDialog(url, $scope
                ,["$scope",function(dialogScope){
                    var row = $scope.selected.select[0];
                    var debtId = row.debtId;
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
                    var rBcpDebtBussDtl={debtId:debtId};
                    //查询操作
                    dialogScope.queryTable = function(paramData){
                        var data= {
                            pageNo: dialogScope.conf.pageNo,
                            pageSize: dialogScope.conf.pageSize,
                            rBcpDebtBussDtl:rBcpDebtBussDtl
                        };
                        var promise = $common.get_asyncData("nrbcpDebtBussDtlService/findRBcpDebtBussDtlPageByPage",data);
                        promise.then(function(res){
                            var data;
                            if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                                data = res.contextData;
                                dialogScope.datasource.ds = data.records;
                                dialogScope.conf.totalRecord = data.totalRecord;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        });
                    };
                    dialogScope.back_onClick = function(){
                        dialogScope.closeThisDialog();
                        $scope.selected.select = [];
                    }
                }],"单据历程信息",{showClose:true});
        }
    };
};

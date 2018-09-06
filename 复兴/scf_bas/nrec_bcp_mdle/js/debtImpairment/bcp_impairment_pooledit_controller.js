/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var nrecBcpImpairmentPoolEditController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.otherform = $scope.source.otherform;
    $scope.otherform.totalNum=0;
    $scope.otherform.totalAmount="0.00";

    var debtList = [];//应收账款总列表

    var flag3 = "";
    var flag = $scope.otherform.flag;
    if(!flag||flag==undefined||flag==""||flag==null)
    {
        flag = dataDeliver.getter().flag;
    }
    if(flag)
    {
        if(flag=="add")
        {
            flag3 = "2";
        }
        if(flag=="update")
        {

        }
        if(flag=="view")
        {
            $scope.hide = true;
            $scope.disable = true;
        }
    }
    else
    {
        $scope.hide = true;
        $scope.disable = true;
    }
    if(!$scope.otherform.appno)
    {
        $scope.disableButton = true;
    }
    else
    {
        $scope.disableButton = false;
    }
    if($scope.otherform.totalAmount==0)
    {
        $scope.otherform.totalAmount = "0.00";
    }

    $scope.disableReason = true;

    $scope.datasourcedebt={//初始化表格对象
        ds:[]
    };
    $scope.selecteddebt={//初始化对象
        select: []
    };
    $scope.confdebt= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    $scope.datasourcelnci={//初始化表格对象
        ds:[]
    };
    $scope.selectedlnci={//初始化对象
        select: []
    };
    $scope.conflnci= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //监听分页
    var count = 0;
    $scope.$watch("confdebt.pageNo+confdebt.pageSize",function(){
        if(count==0)
        {
            //$scope.queryTableDebt();
        }
        else
        {
            $scope.getListByPage();
        }
        count++;
    });
    $scope.$watch("otherform.appno",function() {
        $scope.queryDebtAppliList();
    });
    $scope.checkReason = function(val)
    {
        if(val=="06")
        {
            $scope.disableReason = false;
            $scope.regexp = "common.require";
        }
        else
        {
            $scope.disableReason = true;
            $scope.regexp = "";
        }
    };
    //减值应收账款列表
    //$scope.queryTableDebt = function(paramData)
    //{
    //    if(flag3!=undefined||!flag3)
    //    {
    //        $scope.otherform.flag = flag3;
    //    }
    //    var data= {
    //        pageNo: $scope.confdebt.pageNo,
    //        pageSize: $scope.confdebt.pageSize,
    //        debtCommonQryVO:$scope.otherform
    //    };
    //    $common.get_asyncData("ndebtImpairmentService/InvoiceAllowanceQuryHandleGetter", data).then(function (res) {
    //        var data;
    //        if (res.errorCode == "SUC") {
    //            data = res.contextData;
    //            $scope.datasourcedebt.ds = data.records;
    //            $scope.confdebt.totalRecord = data.totalRecord;
    //            $scope.otherform.totalNum = data.totalRecord;
    //            var totalAmount = 0;
    //            for(var i=0;i<$scope.datasourcedebt.ds.length;i++)
    //            {
    //                var billsAmount= $scope.datasourcedebt.ds[i].rebateAmounts;//减值金额
    //                if(!isNaN(billsAmount)){
    //                    totalAmount = totalAmount + billsAmount;
    //                }
    //            }
    //            if(totalAmount==0)
    //            {
    //                $scope.otherform.totalAmount = "0.00";
    //            }
    //            else
    //            {
    //                $scope.otherform.totalAmount = totalAmount;
    //            }
    //        } else {
    //            $common.get_tipDialog(res.errorMsg, 'showInform');
    //        }
    //    })
    //};

    $scope.add_onClick = function() {
        if($.doValidate("otherform")){
            $common.get_ngDialog('backTransfer/bcp_debtdtlpool.html', $scope
                ,["$scope",function(dialogScope){
                    dialogScope.conditionForm={
                        mastContno:$scope.otherform.mastContno,
                        appno_Q:$scope.otherform.appno,
                        custcdSaller_Q:$scope.otherform.custcd,//卖方客户号
                        custcdBuyer_Q:$scope.otherform.custcdBuyer,//买方客户号
                        bussType_Q:$scope.otherform.bussType//业务品种
                    };//初始化查询条件
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
                    dialogScope.serch_onClick = function() {
                        dialogScope.queryTable();
                    };
                    dialogScope.rebort_onClick = function() {
                        dialogScope.conditionForm={
                            mastContno:$scope.otherform.mastContno,
                            appno_Q:$scope.otherform.appno,
                            custcdSaller_Q:$scope.otherform.custcd,//卖方客户号
                            custcdBuyer_Q:$scope.otherform.custcdBuyer,//买方客户号
                            bussType_Q:$scope.otherform.bussType//业务品种
                        };
                        $scope.$apply();
                    };
                    //监听分页
                    dialogScope.$watch("conf.pageNo+conf.pageSize",function() {
                        dialogScope.queryTable();
                    });
                    dialogScope.queryTable = function(paramData){
                        var data= {
                            pageNo: dialogScope.conf.pageNo,
                            pageSize: dialogScope.conf.pageSize,
                            debtCommonQryVO:dialogScope.conditionForm,
                            list:debtList
                        };
                        var promise = $common.get_asyncData("ndebtImpairmentService/InvoiceAllowanceAddQryGetter",data);
                        promise.then(function(res){
                            var data;
                            if (res.errorCode =="SUC"){
                                data = res.contextData;
                                dialogScope.datasource.ds = data.records;
                                dialogScope.conf.totalRecord = data.totalRecord;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        });
                    };

                    dialogScope.save_onClick = function(){
                        if(dialogScope.selected.select.length <= 0){
                            $common.get_tipDialog('请至少选择一条借据记录','showInform');
                        }else{
                            dialogScope.closeThisDialog();
                            var selected = dialogScope.selected.select;
                            var totalAmount = Number($scope.otherform.totalAmount);//减值总金额
                            var totalNum = Number($scope.otherform.totalNum);//减值份数
                            //计算票面金额的总额，计算费用。
                            for(var k in selected)
                            {
                                if(!selected[k].rebateAmounts)
                                {
                                    selected[k].rebateAmounts = 0;
                                }
                                totalAmount=totalAmount+parseFloat(selected[k].rebateAmounts);
                                totalNum=totalNum+1;
                                selected[k].rebatebalance = parseFloat(selected[k].remainingAmount)-parseFloat(selected[k].rebateAmounts);
                                debtList.push(selected[k]);
                            }
                            $scope.otherform.totalAmount=totalAmount;
                            $scope.otherform.totalNum=totalNum;
                            $scope.getListByPage();
                        }
                    };

                    dialogScope.closeThisDialog_onClick = function(){
                        $scope.selecteddebt.select = [];
                        dialogScope.closeThisDialog();
                    };
                }],"添加页面",{showClose:false});
        }
    };

    //修改
    $scope.edit_onClick = function()
    {
        if($scope.selecteddebt.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('debtImpairment/bcp_debtimpairment_detail.html', $scope
                ,["$scope",function(dialogScope){
                    var baseinfo = $scope.selecteddebt.select[0];
                    dialogScope.detailForm = baseinfo;
                    if(!dialogScope.detailForm.rebateAmount||dialogScope.detailForm.rebateAmount==null
                        ||dialogScope.detailForm.rebateAmount==""||dialogScope.detailForm.rebateAmount==undefined)
                    {
                        dialogScope.detailForm.rebateAmount = "0.00";
                    }
                    dialogScope.rebateAmounts_onBlur = function()
                    {
                        var rebateAmounts_v = Number(dialogScope.detailForm.rebateAmounts);
                        var remainingAmount_v = Number(dialogScope.detailForm.remainingAmount);
                        if(rebateAmounts_v>remainingAmount_v)
                        {
                            $common.get_tipDialog('减值金额不能大于应收账款余额！','showInform');
                            return;
                        }
                        dialogScope.detailForm.rebatebalance = remainingAmount_v - rebateAmounts_v;
                    };
                    dialogScope.confirm_onClick = function()
                    {
                        if($.doValidate("detailForm")) {
                            var rebateAmounts_v = Number(dialogScope.detailForm.rebateAmounts);
                            var remainingAmount_v = Number(dialogScope.detailForm.remainingAmount);
                            if(rebateAmounts_v < 0)
                            {
                                $common.get_tipDialog('减值金额不能为小于0！','showInform');
                                return;
                            }
                            if(rebateAmounts_v>remainingAmount_v)
                            {
                                $common.get_tipDialog('减值金额不能大于应收账款余额！','showInform');
                                return;
                            }
                            var totalAmount = Number($scope.otherform.totalAmount);
                            for(var x in debtList)
                            {
                                if(debtList[x].id==dialogScope.detailForm.id)
                                {
                                    totalAmount = totalAmount-Number(debtList[x].rebateAmounts);
                                    debtList[x].rebateAmounts = rebateAmounts_v;
                                    debtList[x].rebatebalance = dialogScope.detailForm.rebatebalance;
                                    totalAmount = totalAmount + rebateAmounts_v;
                                }
                            }
                            $scope.otherform.totalAmount = totalAmount;
                            $scope.selecteddebt.select = [];
                            dialogScope.closeThisDialog();
                        }
                    };
                    dialogScope.closeThisDialog_onClick = function()
                    {
                        $scope.selecteddebt.select = [];
                        dialogScope.closeThisDialog();
                    }
                }],"应收账款减值明细信息",{showClose:false});
        }
    };

    //查看
    $scope.viewdebt_onClick = function() {
        if($scope.selecteddebt.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('debtImpairment/bcp_debtimpairment_detail.html', $scope
                ,["$scope",function(dialogScope){
                    dialogScope.disable = true;
                    var baseinfo = $scope.selecteddebt.select[0];
                    dialogScope.detailForm = baseinfo;
                    if(!dialogScope.detailForm.rebateAmount||dialogScope.detailForm.rebateAmount==null
                        ||dialogScope.detailForm.rebateAmount==""||dialogScope.detailForm.rebateAmount==undefined)
                    {
                        dialogScope.detailForm.rebateAmount = "0.00";
                    }
                    dialogScope.closeThisDialog_onClick = function(){
                        $scope.selecteddebt.select = [];
                        dialogScope.closeThisDialog();
                    }
                }],"应收账款减值明细信息",{showClose:false});
        }
    };

    $scope.delete_onClick = function() {
        if($scope.selecteddebt.select.length == 0){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            var dsArray = debtList;
            var selected = $scope.selecteddebt.select;
            for (var i = 0; i < dsArray.length; i++)
            {
                for(var x in selected)
                {
                    if (dsArray[i].debtId == selected[x].debtId)
                    {
                        debtList.splice(i, 1);
                        $scope.selecteddebt.select = [];
                        //改变催收总金额，催收份数，费用总额，实收费用
                        $scope.otherform.totalNum = parseFloat($scope.otherform.totalNum) - 1;//催收份数减一
                        if($scope.otherform.totalNum == 0){//没有出质票据,全部置空
                            $scope.otherform.totalAmount="0.00";//催收票据总金额
                            $scope.$apply();
                        }else{
                            $scope.otherform.totalAmount = parseFloat($scope.otherform.totalAmount) - parseFloat(selected[x].rebateAmounts);//催收总金额
                            $scope.$apply();
                        }
                    }
                }
            }
            $scope.getListByPage();
        }
    };

    //保存操作
    $scope.save_onClick = function(){
        if(debtList.length==0) {
            $common.get_tipDialog("请先添加减值的应收账款信息！",'showError');
            return;
        }
        var record = debtList;
        var count = 0;
        var error="";
        for(var x in record)
        {
            var billsNo_v = record[x].billsNo;
            var rebateAmounts_v = Number(record[x].rebateAmounts);
            if(rebateAmounts_v<= 0||isNaN(rebateAmounts_v)){
                if(x==record.length-1)
                {
                    error=error+"【"+billsNo_v+"】";
                }
                else
                {
                    error=error+"【"+billsNo_v+"】、";
                }
                count++;
            }
        }
        error = "凭证编号"+error+"减值金额不能为空或小于零，请录入减值金额！";
        if(count>0){
            $common.get_tipDialog(error,'showError');
            return;
        }
        if($.doValidate("otherform")) {
            $scope.savedisable = true;
            var param = {
                debtBussInfoVO:$scope.otherform,
                insertDebtList:debtList
            };
            $common.get_asyncData("ndebtImpairmentService/FactoringAllowanceSaveUpdate",param).then(function(res){
                var data ;
                if (res.errorCode =="SUC"){
                    data = res.contextData;
                    var appno = data.value;
                    $scope.otherform.appno = appno;
                    $scope.disableButton = false;
                    $scope.savedisable = false;
                    window.source.otherform = $scope.otherform;
                    $common.get_tipDialog('保存成功！','showSuccess');
                    $scope.queryDebtAppliList();
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };

    //提交操作
    $scope.submit_onClick = function() {
        if(debtList.length==0) {
            $common.get_tipDialog("请先添加减值的应收账款信息！",'showError');
            return;
        }

        var record = debtList;
        var count = 0;
        var error="";
        for(var x in record)
        {
            var billsNo_v = record[x].billsNo;
            var rebateAmounts_v = Number(record[x].rebateAmounts);
            if(rebateAmounts_v<= 0||isNaN(rebateAmounts_v)){
                if(x==record.length-1)
                {
                    error=error+"【"+billsNo_v+"】";
                }
                else
                {
                    error=error+"【"+billsNo_v+"】、";
                }
                count++;
            }
        }
        error = "凭证编号"+error+"减值金额不能为空或小于零，请录入减值金额！";
        if(count>0){
            $common.get_tipDialog(error,'showError');
            return;
        }

        if($.doValidate("otherform")) {
            var param = {
                productId:$scope.otherform.bussType,
                invokPhase:"10"
            };
            $scope.otherform.invokPhase = "10";
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
        $scope.savedisable = true;
        $scope.disableButton = true;
        var data = {
            debtBussInfoVO:$scope.otherform,
            insertDebtList:debtList
        };
        $common.get_asyncData("ndebtImpairmentService/FactoringAllowanceAddSave",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog('提交成功！','showSuccess');
                if(window.appNo) {
                    $scope.hide = true;
                } else {
                    $state.go("list");
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.savedisable = false;
                $scope.disableButton = false;
            }
        });
    });


    //获取已选择并已入库的应收账款列表
    $scope.queryDebtAppliList = function(paramData)
    {
        var appno = $scope.otherform.appno;
        if(appno!=null&&appno!=""&&appno!=undefined)
        {
            $common.get_asyncData("ndebtImpairmentService/queryRBcpAppliBussDtlByAppno", {appno:appno}).then(function (res) {
                var data;
                if (res.errorCode == "SUC") {
                    data = res.contextData;
                    debtList = data;
                    var totalAmount = 0;
                    for(var i=0;i<debtList.length;i++)
                    {
                        debtList[i].id = debtList[i].debtId;
                        var billsAmount= debtList[i].rebateAmounts;//应收账款余额
                        if(!isNaN(billsAmount)){
                            totalAmount = totalAmount + billsAmount;
                        }
                    }
                    if(totalAmount==0)
                    {
                        $scope.otherform.totalAmount = "0.00";
                    }
                    else
                    {
                        $scope.otherform.totalAmount = totalAmount;
                    }
                    $scope.otherform.totalNum = debtList.length;
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
            pageNo: $scope.confdebt.pageNo,
            pageSize: $scope.confdebt.pageSize,
            list:debtList
        };
        $common.get_asyncData("rbcpDebtInfoService/getListByPage", param).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.datasourcedebt.ds = data.records||[];
                $scope.confdebt.totalRecord = data.totalRecord;
                $scope.selecteddebt.select = [];
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    };

    //历程信息
    $scope.progress_onClick=function(){
        if ($scope.selecteddebt.select.length != 1) {
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
                    var row = $scope.selecteddebt.select[0];
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
                        $scope.selecteddebt.select = [];
                    }
                }],"单据历程信息",{showClose:true});
        }
    };
    //表格--------结束-------------------------
};

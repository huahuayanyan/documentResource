/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var nrecBcpBackTransferPoolEditController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.otherform = $scope.source.otherform;
    $scope.otherform.totalNum=0;
    $scope.otherform.totalAmount="0.00";

    var debtList = [];//应收账款总列表

    $scope.$watch("otherform.reason",function(){
        $scope.checkReason($scope.otherform.reason);
    });
    var flag = $scope.otherform.flag;
    if(flag)
    {
        if(flag=="add")
        {

        }
        if(flag=="update")
        {

        }
        if(flag=="view")
        {
            $scope.hide = true;
            $scope.disableOther = true;
            $scope.disableReason = true;
        }
    }
    else
    {
        $scope.hide = true;
        $scope.disableOther = true;
        $scope.disableReason = true;
    }
    if(!$scope.otherform.appno)
    {
        $scope.disableButton = true;
    }
    else
    {
        $scope.disableButton = false;
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

    if(!window.appNo)
    {
        $scope.disable = false;
    }
    else
    {
        $scope.disable = true;
    }

    $scope.checkReason = function(val)
    {
        if(val=="06")
        {
            if(flag=="view"||flag==undefined)
            {
                $scope.disableReason = true;
            }
            else
            {
                $scope.disableReason = false;
            }
            $scope.regexp = "common.require";
        }
        else
        {
            $scope.disableReason = true;
            $scope.regexp = "";
        }
    };
    //反转让应收账款列表
    //$scope.queryTableDebt = function(paramData)
    //{
    //    var data= {
    //        pageNo: $scope.confdebt.pageNo,
    //        pageSize: $scope.confdebt.pageSize,
    //        rBcpAppliBussInfo:$scope.otherform
    //    };
    //    $common.get_asyncData("nfactoringDebtBackService/getRBcpDebtBussDtl", data).then(function (res) {
    //        var data;
    //        if (res.errorCode == "SUC") {
    //            data = res.contextData;
    //            $scope.datasourcedebt.ds = data.records;
    //            $scope.confdebt.totalRecord = data.totalRecord;
    //            $scope.otherform.totalNum = data.totalRecord;
    //            var totalAmount = 0;
    //            for(var i=0;i<$scope.datasourcedebt.ds.length;i++)
    //            {
    //                var billsAmount= $scope.datasourcedebt.ds[i].remainingAmount;//应收账款余额
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
                            commonQueryVO:dialogScope.conditionForm,
                            list:debtList
                        };
                        $common.get_asyncData("nfactoringDebtBackService/InvoiceDebtBackAddQryGetter",data).then(function(res){
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
                            var totalAmount = Number($scope.otherform.totalAmount);//反转让总金额
                            var totalNum = Number($scope.otherform.totalNum);//反转让份数
                            //计算票面金额的总额，计算费用。
                            for(var k in selected)
                            {
                                debtList.push(selected[k]);
                                totalAmount=parseFloat(totalAmount)+parseFloat(selected[k].buyBackAmount);
                                totalNum=totalNum+1;
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

    $scope.viewdebt_onClick = function() {
        if($scope.selecteddebt.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('backTransfer/bcp_debt_detail.html', $scope
                ,["$scope",function(dialogScope){
                    var baseinfo = $scope.selecteddebt.select[0];
                    if($scope.otherform.financingType=="2") {
                        dialogScope.hidePoolFlag = false;
                    }
                    else {
                        dialogScope.hidePoolFlag = true;
                    }
                    var id = baseinfo.id;
                    dialogScope.detailForm = {};
                    $common.get_asyncData('rbcpDebtInfoService/queryRBcpDebtInfoById',{key:id}).then(function(res) {
                        var debtbase;
                        if (res.errorCode == "SUC") {
                            debtbase = res.contextData;
                            dialogScope.detailForm = debtbase;
                            if(!debtbase.remainingAmount||debtbase.remainingAmount==0) {
                                dialogScope.detailForm.remainingAmount = "0.00";
                            }
                            if(!debtbase.remainingUseableAmount||debtbase.remainingUseableAmount==0) {
                                dialogScope.detailForm.remainingUseableAmount = "0.00";
                            }
                            if(!debtbase.otherSum||debtbase.otherSum==0) {
                                dialogScope.detailForm.otherSum = "0.00";
                            }
                        }
                        else {
                            $common.get_tipDialog(res.errorMsg, 'showError');
                        }
                    });
                    dialogScope.closeThisDialog_onClick = function(){
                        $scope.selecteddebt.select = [];
                        dialogScope.closeThisDialog();
                    }
                }],"应收账款回购管理",{showClose:false});
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
                        $scope.otherform.totalNum = parseFloat($scope.otherform.totalNum) - 1;//反转让份数减一
                        if($scope.otherform.totalNum == 0){//没有出质票据,全部置空
                            $scope.otherform.totalAmount="0.00";//反转让票据总金额
                            $scope.$apply();
                        }else{
                            $scope.otherform.totalAmount = parseFloat($scope.otherform.totalAmount) - parseFloat(selected[x].buyBackAmount);//反转让总金额
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
            $common.get_tipDialog("请添加应收账款！",'showError');
            return;
        }

        if($.doValidate("otherform")) {
            $scope.savedisable = true;
            var param = {
                debtBussInfoVO:$scope.otherform,
                insertDebtList:debtList
            };
           	$common.get_asyncData("nfactoringDebtBackService/DebtBackApplySaveUpdate",param).then(function(res){
                var data ;
                if (res.errorCode =="SUC"){
                    data = res.contextData;
                    var appno = data.value;
                    $scope.otherform.appno = appno;
                    $scope.disableButton = false;
                    $scope.savedisable = false;
                    $scope.disable = true;
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
            $common.get_tipDialog("请添加应收账款！",'showError');
            return;
        }
        if($.doValidate("otherform")) {
            var param = {
                productId:$scope.otherform.bussType,
                invokPhase:"11"
            };
            $scope.otherform.invokPhase = "11";
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
        $common.get_asyncData("nfactoringDebtBackService/DebtBackWriteSubmitUpdate",data).then(function(res){
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
            $common.get_asyncData("nRBcpAppliBussDtlService/queryRBcpAppliBussDtlByAppno", {appno:appno}).then(function (res) {
                var data;
                if (res.errorCode == "SUC") {
                    data = res.contextData;
                    debtList = data;
                    var totalAmount = 0;
                    for(var i=0;i<debtList.length;i++)
                    {
                        debtList[i].id = debtList[i].debtId;
                        var billsAmount= debtList[i].buyBackAmount;//回购金额
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

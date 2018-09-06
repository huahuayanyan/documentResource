/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var debtBackController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.otherform = $scope.source.otherform;
    if(!$scope.otherform.appno)
    {
        $scope.disableButton = true;
    }
    else
    {
        $scope.disableButton = false;
        $scope.hideButton = true;
    }
    if($scope.otherform.totalAmount==0)
    {
        $scope.otherform.totalAmount = "0.00";
    }
    if(!$scope.otherform.mastContno)
    {
        $scope.otherform.mastContno = $scope.otherform.debtContno;
    }
    $scope.taskform = $scope.source.taskform;
    if(!$scope.taskform||!$scope.taskform.id)
    {
        $scope.Write = false;
        $scope.Approve = true;
    }
    else
    {
        $scope.hide = true;
        if($scope.taskform.id == "Write")
        {//申请复核
            $scope.Write = false;
            $scope.Approve = true;
            $scope.hide = false;
        }
        else if($scope.taskform.id == "Approve")
        {//审批节点
            $scope.Write = true;
            $scope.Approve = false;
            $scope.disableOther = true;
        }
        else
        {
            $scope.Write = true;
            $scope.Approve = true;
            $scope.disableOther = true;
        }
    }
    $scope.disableReason = true;
    var appno ;
    var bussType ;
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
    $scope.cache = "0";
    //监听分页
    $scope.$watch("confdebt.pageNo+confdebt.pageSize",function(){
        $scope.queryTableDebt();
    });
    if(!window.appNo)
    {
        $scope.disable = false;
    }
    else
    {
        $scope.disable = true;
        $scope.hideButton = true;
    }
    //买方客户查询
    $scope.buyerContent = {
        type:"table",//展示类型table  tree
        url:"bCntDebtExtInfoService/selectBCntDebtExtInfoByPage",//请求url
        param:{businessNo:$scope.otherform.mastContno},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"",//分隔符*/
        extentColumn:"buyerName",
        column:["buyerName"]//展示内容
    };
    $scope.buyerExtent = function(ds){
        $scope.otherform.custcdBuyer=ds.buyerCustcd;//获得买方客户号
    };
    $scope.$watch("otherform.cnameBuyer",function(){
        $scope.buyerContent.param ={
            businessNo:$scope.otherform.mastContno,//将之前查处的业务合同号传参
            buyerName:$scope.otherform.cnameBuyer//买方名称
        }
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
    //反转让应收账款列表
    $scope.queryTableDebt = function(paramData)
    {
        var data= {
            pageNo: $scope.confdebt.pageNo,
            pageSize: $scope.confdebt.pageSize,
            rBcpAppliBussInfo:$scope.otherform,
            cache:$scope.cache
        };
        $common.get_asyncData("factoringDebtBackService/getRBcpDebtBussDtl", data).then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.datasourcedebt.ds = data.records;
                $scope.confdebt.totalRecord = data.totalRecord;
                $scope.otherform.totalNum = data.totalRecord;
                var totalAmount = 0;
                var debetNo = "";
                for(var i=0;i<$scope.datasourcedebt.ds.length;i++)
                {
                    if($scope.datasourcedebt.ds[i].debetNo)
                    {
                        debetNo = debetNo + $scope.datasourcedebt.ds[i].debetNo+"/f";
                    }
                    var billsAmount= $scope.datasourcedebt.ds[i].remainingAmount;//应收账款余额
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
                $scope.otherform.debetNo = debetNo;
                $scope.queryTableLnci();
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    //关联的融资信息
    $scope.queryTableLnci = function(paramData)
    {
        if($scope.otherform.debetNo==undefined||$scope.otherform.debetNo==null||
            $scope.otherform.debetNo==""||!$scope.otherform.debetNo)
        {
            $scope.datasourcelnci.ds = [];
            $scope.conflnci.totalRecord = 0;
        }
        else
        {
            var data= {
                pageNo: $scope.conflnci.pageNo,
                pageSize: $scope.conflnci.pageSize,
                appliBussInfo:$scope.otherform
            };
            $common.get_asyncData("factoringDebtBackService/getLanLnciInfoByContno", data).then(function (res) {
                var data;
                if (res.errorCode == "SUC") {
                    data = res.contextData;
                    $scope.datasourcelnci.ds = data.records;
                    $scope.conflnci.totalRecord = data.totalRecord;
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showInform');
                }
            })
        }
    };
    $scope.add_onClick = function() {
        if(!$scope.otherform.custcdBuyer) {
            $common.get_tipDialog('请选择买方名称！','showInform');
            return;
        }
        var dtlUrl;
        if($scope.otherform.factType == "2") {
            dtlUrl = 'backtransfer/debtdtlpool.html';
        } else {
            dtlUrl = 'backtransfer/debtdtl.html'
        }
        $common.get_ngDialog(dtlUrl, $scope
            ,["$scope",function(dialogScope){
                var factType;
                if($scope.otherform.factType == "2"){
                    factType="8";
                }else{
                    factType="1";
                }
                dialogScope.conditionForm={
                    mastContno:$scope.otherform.mastContno,
                    isLocked:"0",//查询未锁定的票据信息
                    custcdBuyer:$scope.otherform.custcdBuyer,//买方客户名称
                    status:"01",//只能查询出状态为已录入的，其他的状态不行。
                    flawFlag:"0",//无瑕疵
                    factType:factType
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
                    totalRecord: 0}
                //监听分页
                dialogScope.$watch("conf.pageNo+conf.pageSize",function() {
                    dialogScope.queryTable();
                })
                dialogScope.queryTable = function(paramData){
                    var data= {
                        pageNo: dialogScope.conf.pageNo,
                        pageSize: dialogScope.conf.pageSize,
                        commonQueryVO:dialogScope.conditionForm,
                        list:$scope.datasourcedebt.ds
                    };
                    var promise = $common.get_asyncData("factoringDebtBackService/queryRBcpDebtBaseInfo",data);
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
                //dialogScope.selected.select=$scope.datasourcedebt.ds;
                dialogScope.save_onClick = function(){
                    if(dialogScope.selected.select.length <= 0){
                        $common.get_tipDialog('请至少选择一条借据记录','showInform');
                    }else{
                        dialogScope.closeThisDialog();
                        var list = dialogScope.selected.select;
                        var primise = $common.get_asyncData('factoringDebtBackService/cacheAdd',{list:list});
                        primise.then(function(res){
                            if (res.errorCode =="SUC"){
                                dialogScope.closeThisDialog();
                                $scope.cache = "1";
                                $scope.selecteddebt.select = [];
                                $scope.queryTableDebt();
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            };
                        });
                    }
                };
                dialogScope.serch_onClick = function() {
                    dialogScope.queryTable();
                }
                dialogScope.rebort_onClick = function() {
                    dialogScope.conditionForm={
                        mastContno:$scope.otherform.mastContno,
                        isLocked:"0",//查询未锁定的票据信息
                        custcdBuyer:$scope.otherform.custcdBuyer,//买方客户名称
                        status:"01",//只能查询出状态为已录入的，其他的状态不行。
                        flawFlag:"0",//无瑕疵
                        factType:factType
                    };
                    $scope.$apply();
                }
                dialogScope.closeThisDialog_onClick = function(){
                    $scope.selecteddebt.select = [];
                    dialogScope.closeThisDialog();
                };
            }],"添加页面",{showClose:false});
    };
    $scope.back_onClick = function(){
        $state.go("list");
    };
    $scope.viewdebt_onClick = function() {
        if($scope.selecteddebt.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('backtransfer/debtdtl_detail.html', $scope
                ,["$scope",function(dialogScope){
                    var baseinfo = $scope.selecteddebt.select[0];
                    if($scope.otherform.factType=="2") {
                        dialogScope.hidePoolFlag = false;
                    }
                    else {
                        dialogScope.hidePoolFlag = true;
                    }
                    var id = baseinfo.debtId;
                    dialogScope.detailForm = {};
                    $common.get_asyncData('rBcpDebtBaseInfoService/findRBcpDebtBaseInfoByPrimaryKey',{id:id}).then(function(res) {
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
    }
    $scope.delete_onClick = function() {
        if($scope.selecteddebt.select.length == 0){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            var primise = $common.get_asyncData('factoringDebtBackService/batchDeleteRBcpDebtBaseInfo',{list:$scope.selecteddebt.select,appno:$scope.otherform.appno});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $scope.cache = "1";
                    $scope.queryTableDebt();
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        }
    }
    //保存操作
    $scope.save_onClick = function(){
        if($scope.datasourcedebt.ds.length==0) {
            $common.get_tipDialog("请添加应收账款后再提交！",'showError');
            return;
        }
        var cnameBuyer = $scope.otherform.cnameBuyer;
        var custcdBuyer = $scope.otherform.custcdBuyer;
        if(!custcdBuyer||custcdBuyer==null||custcdBuyer=="") {
            document.getElementById("cnameBuyer").focus();
            $common.get_tipDialog("未对买方名称进行选择，请重新选择",'showError');
            return;
        }
        var infoForm = {
            businessNo:$scope.otherform.mastContno,//将之前查处的业务合同号传参
            buyerName:cnameBuyer//买方名称
        }
        $common.get_asyncData('bCntDebtExtInfoService/selectBCntDebtExtInfoByBuyerNameBusinessNo',infoForm).then(function(res){
            var buyinfo;
            if (res.errorCode =="SUC"){
                buyinfo = res.contextData;
                var result = buyinfo.value;
                if(result=="1") {
                    if($.doValidate("otherform")) {
                        $scope.savedisable = true;
                        var primise = $common.get_asyncData("factoringDebtBackService/debtBackApplySave",{appliBussInfoVO:$scope.otherform,insertDebtList:$scope.datasourcedebt.ds});
                        var data ;
                        primise.then(function(res){
                            if (res.errorCode =="SUC"){
                                data = res.contextData;
                                var appno = data.value;
                                $scope.otherform.appno = appno;
                                $scope.disableButton = false;
                                $scope.savedisable = false;
                                $scope.disable = true;
                                window.source.otherform = $scope.otherform;
                                $scope.cache = "0";
                                $common.get_tipDialog('保存成功！','showSuccess');
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            };
                        });
                    };
                }
                else {
                    document.getElementById("cnameBuyer").focus();
                    $common.get_tipDialog("买方名称与其客户号不匹配，请重新选择",'showError');
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    };
    //提交操作
    $scope.submit_onClick = function() {
        if($scope.datasourcedebt.ds.length==0) {
            $common.get_tipDialog("请添加应收账款后再提交！",'showError');
            return;
        }
        if($.doValidate("otherform")) {
            $scope.savedisable = true;
            $scope.disableButton = true;
            var primise = $common.get_asyncData("factoringDebtBackService/debtBackApplySubmit",{appliBussInfoVO:$scope.otherform,insertDebtList:$scope.datasourcedebt.ds,isProcess:true});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('已提交！','showSuccess');
                    if(window.appNo) {
                        $scope.Write = true;
                    } else {
                        $state.go("list");
                    }
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    };
    //审批通过
    $scope.pass_onClick = function() {
        if($.doValidate("otherform")) {
            $scope.passdisable = true;
            $scope.BackToModifydisable = true;
            var primise = $common.get_asyncData("factoringDebtBackService/debtBackApplyPassSubmit",{appliBussInfoVO:$scope.otherform,insertDebtList:$scope.datasourcedebt.ds,isProcess:true});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('审批通过','showSuccess');
                    if(window.appNo) {
                        $scope.Approve = true;
                    } else {
                        $state.go("list");
                    }
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    }
    //退回
    $scope.BackToModify_onClick = function() {
        if($.doValidate("otherform")) {
            $scope.passdisable = true;
            $scope.BackToModifydisable = true;
            var primise = $common.get_asyncData("factoringDebtBackService/debtBackApplyBackToModify",{appno:$scope.otherform.appno,isProcess:true});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('已退回','showSuccess');
                    if(window.appNo) {
                        $scope.Approve = true;
                    } else {
                        $state.go("list");
                    }
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    }
    //表格--------结束-------------------------
};

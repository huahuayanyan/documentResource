/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var priceadjustController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.priceadjust = $scope.source.priceadjust;
    $scope.gntycon = $scope.source.gntycon;
    $scope.taskform = $scope.source.taskform;
    if(!$scope.taskform||!$scope.taskform.id)
    {
        $scope.Write = false;
        $scope.Issued = true;
        $scope.Receipt = true;
    }
    else
    {
        if($scope.taskform.id == "sbcpappli_approve")
        {//申请
            $scope.Write = false;
            $scope.Issued = true;
            $scope.Receipt = true;
        }
        else if($scope.taskform.id == "sbcpappli_check")
        {//复核
            $scope.Write = true;
            $scope.Issued = false;
            $scope.Receipt = true;
        }
        else if($scope.taskform.id == "sbcpappli_confirm")
        {//回执确认
            $scope.Write = true;
            $scope.Issued = true;
            $scope.Receipt = false;
        }
        else
        {//审批通过
            $scope.Write = true;
            $scope.Issued = true;
            $scope.Receipt = true;
        }
    }
    if(window.appNo)
    {
        $scope.hide = true;
    }
    if(!$scope.priceadjust.piid)
    {
        $scope.disablebutton = true;
    }
    if(!$scope.priceadjust.businessno)
    {
        $scope.priceadjust.businessno = $scope.gntycon.conId;
    }
    if(!$scope.priceadjust.moniModel)
    {
        $scope.priceadjust.moniModel = $scope.source.mortgageInfo.moniType;
    }
    if(!$scope.priceadjust.protocolNo)
    {
        $scope.priceadjust.protocolNo = $scope.gntycon.prtclNo;
    }
    if(!$scope.priceadjust.slaveContno)
    {
        $scope.priceadjust.slaveContno = $scope.gntycon.conId;
    }
    if(!$scope.priceadjust.moniOfCustcd)
    {
        $scope.priceadjust.moniOfCustcd = $scope.source.mortgageInfo.thrCode;
    }
    if(!$scope.priceadjust.lowPrice)
    {
        $scope.priceadjust.lowPrice = $scope.gntycon.lowPriceNew;
    }
    //现最低控货价值
    if($scope.priceadjust.lowPriceNew==0)
    {
        $scope.priceadjust.lowPriceNew = "0.00";
    }
    if(!$scope.priceadjust.supplyChainPdId)
    {
        $scope.priceadjust.supplyChainPdId = $scope.gntycon.vidPrdId;
    }
    //质押模式
    if(!$scope.priceadjust.pledgeMode)
    {
        $scope.priceadjust.pledgeMode = $scope.source.mortgageInfo.moniType;
    }
    //敞口余额
    if(!$scope.priceadjust.debtAmount||$scope.priceadjust.debtAmount==0)
    {
    	$scope.priceadjust.debtAmount = "0.00";
    }
    //押品总价值
    if($scope.priceadjust.mortAmount==0)
    {
        $scope.priceadjust.mortAmount = "0.00";
    }
    //本次追加保证金总额
    if($scope.priceadjust.amt==0)
    {
        $scope.priceadjust.amt = "0.00";
    }
    //客户号
    if(!$scope.priceadjust.custcd)
    {
        $scope.priceadjust.custcd = $scope.gntycon.gutId;
    }
    //币种
    if(!$scope.priceadjust.curcd)
    {
        $scope.priceadjust.curcd = $scope.gntycon.gutCurcd;
    }
    $scope.$watch("$scope.gntycon.conId",function() {
        $scope.queryMortgageList();
    })
    //初始化
    $scope.datasource={//初始化押品信息
        ds: []
    };
    $scope.selected={
        select: []
    };
    $scope.conf= {
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    $scope.bPbcMtgBaseInfo = {};
    $scope.queryMortgageList = function(paramData)
    {
        $scope.bPbcMtgBaseInfo.slaveContno=$scope.source.gntycon.conId;
        $scope.bPbcMtgBaseInfo.supplyChainPdId=$scope.source.gntycon.vidPrdId;
        $scope.bPbcMtgBaseInfo.monitorProtocolNo = $scope.gntycon.prtclNo;
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bPbcMtgBaseInfo:$scope.bPbcMtgBaseInfo
        };
        $common.get_asyncData("lowerPriceService/findBPbcMtgBaseInfoByPage", data).then(function (res) {
            var record ;
            if (res.errorCode == "SUC") {
                record = res.contextData;
                $scope.datasource.ds = record.records;
                $scope.conf.totalRecord = record.totalRecord;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showInform');
            }
        })
    };
    /**
     * 业务品种筛	开始
     */
    $scope.productNameContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBusinessType",
        param:{ factType:"0" },    //设置参数
        split:",",//设置分隔符
        extentColumn:"productName",
        column:["productName","productId"]//设置显示信息
    };
    $scope.productNamedooextent = function(ds){
        $scope.priceadjust.suppProductName=ds.productName;
        $scope.priceadjust.supplyChainPdId=ds.productId; //业务品种
    };
    $scope.$watch("priceadjust.supplyChainPdId",function(newVal,oldVal){
        $scope.productNameContent.param ={
            tFactType:"0"  //筛选产品种类，部分品种设置为0
        };
    });
    /**
     * 业务品种筛	结束
     */
    $scope.lowPriceNew_onBlur = function()
    {
        var newprice = Number($scope.priceadjust.lowPriceNew);
        var mortAmount = Number($scope.priceadjust.mortAmount);
        if(newprice>mortAmount)
        {
            $common.get_tipDialog("新设置的最低控货价值，必须小于等于当前库存押品总价！", 'showInform');
            document.getElementById("lowPriceNew").focus;
        }
    }
    //最低控货价值调整申请保存
    $scope.confirm_onClick = function()
    {
        var newprice = Number($scope.priceadjust.lowPriceNew);
    	var debtAmount = Number($scope.priceadjust.debtAmount);
        var addBailAmt = Number($scope.priceadjust.amt);
        var ration = Number($scope.gntycon.ration);
        var temp = (debtAmount - addBailAmt)/(ration/100);
        if(temp.toFixed(2) > newprice){
            $common.get_tipDialog("新设置的最低控货价值不能小于" + temp.toFixed(2) + ",否则不能覆盖敞口！", 'showInform');
            return;
        }
        if($.doValidate("priceadjust")) {
            $scope.confirmdisable = true;
            var primise = $common.get_asyncData("lowerPriceService/save",{lowerPrice:$scope.priceadjust});
            primise.then(function(res){
                var priceadjust;
                if (res.errorCode =="SUC"){
                    priceadjust = res.contextData;
                    $common.get_tipDialog('保存成功','showSuccess');
                    $scope.priceadjust = priceadjust;
                    initNumber();
                    window.source.priceadjust = priceadjust;
                    if($scope.priceadjust.piid)
                    {
                        $scope.disablebutton = false;
                    }
                    dataDeliver.setter(priceadjust);
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    };
    var isProcess = true;
    //最低控货价值调整填写岗提交审批
    $scope.submit_onClick = function()
    {
        var newprice = Number($scope.priceadjust.lowPriceNew);
        var debtAmount = Number($scope.priceadjust.debtAmount);
        var addBailAmt = Number($scope.priceadjust.amt);
        var ration = Number($scope.gntycon.ration);
        var temp = (debtAmount - addBailAmt)/(ration/100);
        if(temp.toFixed(2) > newprice){
            top.alert("新设置的最低控货价值不能小于" + temp.toFixed(2) + ",否则不能覆盖敞口！");
            return;
        }
        if($.doValidate("priceadjust")) {
            $scope.confirmdisable = true;
            $scope.disablebutton = true;
            var primise = $common.get_asyncData("lowerPriceService/submit",{lowerPrice:$scope.priceadjust,isProcess:isProcess});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('提交成功','showSuccess');
                    $state.go("list");
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    };
    //最低控货价值调整申请复核提交
    $scope.IssuedAgreeSubmit_onClick = function()
    {
        var newprice = Number($scope.priceadjust.lowPriceNew);
        var debtAmount = Number($scope.priceadjust.debtAmount);
        var addBailAmt = Number($scope.priceadjust.amt);
        var ration = Number($scope.gntycon.ration);
        var temp = (debtAmount - addBailAmt)/(ration/100);
        if(temp.toFixed(2) > newprice){
            top.alert("新设置的最低控货价值不能小于" + temp.toFixed(2) + ",否则不能覆盖敞口！");
            return;
        }
        if($.doValidate("priceadjust")) {
            $scope.Issueddisable = true;
            $scope.BackSubmitdisable = true;
            $scope.Noticedisable = true;
            var primise = $common.get_asyncData("lowerPriceService/IssuedAgreeSubmit",{lowerPrice:$scope.priceadjust,isProcess:isProcess});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('提交成功','showSuccess');
                    $state.go("list");
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    };
    //最低控货价值调整申请复核岗退回
    $scope.BackSubmit_onClick = function()
    {
        if($.doValidate("priceadjust")) {
            $scope.Issueddisable = true;
            $scope.BackSubmitdisable = true;
            $scope.Noticedisable = true;
            var primise = $common.get_asyncData("lowerPriceService/BackSubmit",{appno:$scope.priceadjust.appno,isProcess:isProcess});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('退回成功','showSuccess');
                    $state.go("list");
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    }
    //最低控货价值调整申请回执确认
    $scope.ApproveSubmit2_onClick = function()
    {
        if($.doValidate("priceadjust")) {
            $scope.ApproveSubmit2disable = true;
            $scope.Noticedisable = true;
            var primise = $common.get_asyncData("lowerPriceService/ApproveSubmit2",{appno:$scope.priceadjust.appno,isProcess:isProcess});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('回执确认成功','showSuccess');
                    $state.go("list");
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    }
    $scope.mortgage = {};
    //查看按钮
    $scope.column = function(row){
        $scope.mortgage = row;
        $common.get_ngDialog('lowerprice/mortgage.html',$scope,["$scope",function(dialogScope){
            dialogScope.disable = true;
            dialogScope.mortgageDetail = $scope.mortgage;
            //查询押品一级
            mortgageLevelOneSource();
            function mortgageLevelOneSource(){
                //业务品种下拉框
                var dataItemsDO = {levels:"1"};
                var data = {dataItemsDO:dataItemsDO}
                var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                dialogScope.mortgageLevelOneSource = {};
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.mortgageLevelOneSource.ds = res.contextData;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
            }
            //押品二级
            mortgageLevelTwoSource();
            function mortgageLevelTwoSource(){
                //业务品种下拉框
                var dataItemsDO = {levels:"2"};
                var data = {dataItemsDO:dataItemsDO}
                var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                dialogScope.mortgageLevelTwoSource = {};
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
            }
            //押品三级
            mortgageLevelThreeSource();
            function mortgageLevelThreeSource(){
                //业务品种下拉框
                var dataItemsDO = {levels:"3"};
                var data = {dataItemsDO:dataItemsDO}
                var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                dialogScope.mortgageLevelThreeSource = {};
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.mortgageLevelThreeSource.ds = res.contextData;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
            }
            dialogScope.cancel_onClick = function(){
                dialogScope.closeThisDialog();
                dialogScope.selected.select = [];
            };
        }])
    };
    function initNumber()
    {
        //敞口余额
        if(!$scope.priceadjust.debtAmount||$scope.priceadjust.debtAmount==0)
        {
            $scope.priceadjust.debtAmount = "0.00";
        }
        //押品总价值
        if($scope.priceadjust.mortAmount==0)
        {
            $scope.priceadjust.mortAmount = "0.00";
        }
        //现最低控货价值
        if($scope.priceadjust.lowPriceNew==0)
        {
            $scope.priceadjust.lowPriceNew = "0.00";
        }
        //本次追加保证金总额
        if($scope.priceadjust.amt==0)
        {
            $scope.priceadjust.amt = "0.00";
        }
    }
    $scope.Notice_onClick = function()
    {
        if(!$scope.priceadjust.appno)
        {
            $common.get_tipDialog("找不到相关的类型通知书",'showInform');
            return;
        }
        $common.get_ngDialog('lowerprice/notice.html', $scope
            ,["$scope",function(dialogScope){
                dialogScope.noticeForm = {};
                $common.get_asyncData('lowerPriceService/NoticePrintInfo',{lowerPrice:$scope.priceadjust}).then(function(res) {
                    var notice;
                    if (res.errorCode == "SUC") {
                        notice = res.contextData;
                        dialogScope.noticeForm = notice;
                    }
                    else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
                dialogScope.closeThisDialog_onClick = function(){
                    dialogScope.closeThisDialog();
                }
            }],"通知书信息",{showClose:false});
    }
    $scope.back_onClick = function()
    {
        $state.go("list");
    }
    //表格--------结束-------------------------
};

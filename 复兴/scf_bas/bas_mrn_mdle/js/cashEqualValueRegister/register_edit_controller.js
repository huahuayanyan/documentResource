/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var registerEditController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.applitask = $scope.source.applitask;
    $scope.lnconform = $scope.source.lnconform;
    var appno;
    if(window.appNo)
    {
        appno = window.appNo;
    }
    else
    {
        appno = $scope.lnconform.appno;
    }
    //保证金及现金等价物列表信息
    $scope.datasourcecash={//初始化表格对象
        ds: []
    };
    $scope.selectedcash={//初始化对象
        select: []
    };
    $scope.confcash= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    $scope.$watch("confcash.pageNo+confcash.pageSize",function() {
        $scope.queryTableCash();
    })
    $scope.queryTableCash = function(paramData){
        var data= {
            pageNo: $scope.confcash.pageNo,
            pageSize: $scope.confcash.pageSize,
            bCrrLnConCash:$scope.lnconform
        };
        var promise = $common.get_asyncData("cashEqualValueRegisterService/AccountInfoEqualCashGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasourcecash.ds = data.records || [];
                $scope.confcash.totalRecord = data.totalRecord;
                for(var i=0;i<$scope.datasourcecash.ds.length;i++)
                {
                    var cash = $scope.datasourcecash.ds[i];
                    if(!cash.bailRate)
                    {
                        cash.bailRate = 0.00;
                    }
                    var bailRate = Number(cash.bailRate);
                    var bailAmount = Number(cash.bailAmount);
                    var value = bailAmount*bailRate/100;
                    cash.value = value;
                }
                $scope.lnconform.bailAmount = lnbailAmount;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //融资列表
    $scope.datasourcelnci={//初始化表格对象
        ds: []
    };
    $scope.selectedlnci={//初始化对象
        select: []
    };
    $scope.conflnci= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    $scope.$watch("conflnci.pageNo+conflnci.pageSize",function() {
        $scope.queryTablelnci();
    })
    $scope.queryTablelnci = function(paramData){
        var data= {
            pageNo: $scope.confcash.pageNo,
            pageSize: $scope.confcash.pageSize,
            bCrrLnConCash:$scope.lnconform
        };
        var promise = $common.get_asyncData("cashEqualValueRegisterService/CashEqualValueLnciWriteGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasourcelnci.ds = data.records || [];
                $scope.conflnci.totalRecord = data.totalRecord;
                if(appno)
                {
                    $common.get_asyncData("cashEqualValueRegisterService/getChoosedLnciInfo",{appno:appno}).then(function(res){
                        var choosedlist;
                        if (res.errorCode =="SUC"){
                            choosedlist = res.contextData;
                            var list = [];
                            for(var j=0;j<choosedlist.length;j++)
                            {
                                var chooselnci = choosedlist[j];
                                for(var i=0;i<$scope.datasourcelnci.ds.length;i++)
                                {
                                    var lnci = $scope.datasourcelnci.ds[i];
                                    if(lnci.debetNo==chooselnci.debetNo)
                                    {
                                        list.push(lnci);
                                        break;
                                    }
                                }
                            }
                            $scope.selectedlnci.select = list;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    $scope.datasource={//初始化表格对象
        ds:[]
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryCashAdd();
    });
    $scope.queryCashAdd = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            appno:$scope.lnconform.appno
        };
        var promise = $common.get_asyncData("cashEqualValueRegisterService/CashEqualAddInfoGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records || [];
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    if(!$scope.lnconform.appno)
    {
        $scope.disableButton = true;
    }
    else
    {
        $scope.disableButton = false;
    }
    if($scope.lnconform.bailAmount==0)
    {
        $scope.lnconform.bailAmount = "0.00";
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
/*        else if($scope.taskform.id == "Approve")
        {//审批节点
            $scope.Write = true;
            $scope.Approve = true;
            $scope.disableOther = true;
        }*/
        else
        {
            $scope.Write = true;
            $scope.Approve = true;
            $scope.disableOther = true;
        }
    }
    if(!window.appNo)
    {
        $scope.hideButton = false;
    }
    else
    {
        $scope.hideButton = true;
    }
    $scope.add_onClick = function()
    {
        if($scope.selectedlnci.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
        else
        {
            var dd = {};
            $scope.datasource.ds.push(dd);
            $scope.conf.totalRecord++;
            $common.get_ngDialog("cashEqualValueRegister/register_add.html", $scope
                ,["$scope",function(dialogScope){
                    dialogScope.cashadd = dd;
                    dialogScope.lnci = $scope.selectedlnci.select[0];
                    dialogScope.cashadd.protocolNo = dialogScope.lnci.protocolNo;
                    $scope.datasource.ds[$scope.datasource.ds.length-1] = dialogScope.cashadd;
                    dialogScope.save_onClick = function(){
                        if($.doValidate("cashadd")) {
                            dialogScope.closeThisDialog();
                            $scope.selected.select = [];
                        };
                    };
                    dialogScope.bailAmount_onBlur = function()
                    {
                        getValue();
                    }
                    dialogScope.bailRate_onBlur = function()
                    {
                        getValue();
                    }
                    function getValue()
                    {
                        var bailAmount = dialogScope.cashadd.bailAmount;
                        var bailRate = dialogScope.cashadd.bailRate;
                        if(bailAmount&&bailRate)
                        {
                            var value = Number(bailAmount)*Number(bailRate)/100;
                            dialogScope.$apply(
                                dialogScope.cashadd.value = value,
                                dialogScope.lnci.addCashEqtAmt = dialogScope.lnci.addCashEqtAmt+value
                            )
                        }
                    }
                }],"",{showClose:false});
        }
    };
    $scope.edit_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条添加等价物记录！','showInform');
        }else{
            $common.get_ngDialog("cashEqualValueRegister/register_add.html", $scope
                ,["$scope",function(dialogScope){
                    dialogScope.cashadd = $scope.selected.select[0];
                    var oldValue = dialogScope.cashadd.value;
                    dialogScope.save_onClick = function(){
                        if($.doValidate("cashadd")) {
                            dialogScope.closeThisDialog();
                            $scope.selected.select = [];
                        };
                    };
                    dialogScope.bailAmount_onBlur = function()
                    {
                        getValue();
                    }
                    dialogScope.bailRate_onBlur = function()
                    {
                        getValue();
                    }
                    function getValue()
                    {
                        var bailAmount = dialogScope.cashadd.bailAmount;
                        var bailRate = dialogScope.cashadd.bailRate;
                        if(bailAmount&&bailRate)
                        {
                            var value = Number(bailAmount)*Number(bailRate)/100;
                            dialogScope.$apply(
                                dialogScope.cashadd.value = value,
                                dialogScope.lnci.addCashEqtAmt = dialogScope.lnci.addCashEqtAmt-oldValue+value
                            )
                        }
                    }
                }],"",{showClose:false});
        }
    }
    //删除
    $scope.delete_onClick = function()
    {
        if($scope.selectedlnci.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
            return;
        }
        if($scope.selected.select.length == 0){
            $common.get_tipDialog('请选择一条添加的现金等价物记录！','showInform');
        }else{
            var lnci = $scope.selectedlnci.select[0];
            var listAdd = $scope.datasource.ds;
            var list = $scope.selected.select;//页面选中的现金等价物
            for(var i=0;i<listAdd.length;i++)
            {
                var oldcash = listAdd[i];
                for(var j=0;j<list.length;j++)
                {
                    var cache = list[j];
                    if(oldcash==cache)
                    {
                        var value = cache.value;
                        $scope.$apply(
                            $scope.datasource.ds.splice(i,1),//从第i个开始删除一个
                            $scope.conf.totalRecord--,
                            lnci.addCashEqtAmt = lnci.addCashEqtAmt - value
                        )
                    }
                }
            }
        }
    }
    //查询核心金额
    $scope.checkNum_onClick = function()
    {
        if($scope.selected.select.length == 0){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            var cashadd = $scope.selected.select[0];
            $scope.$apply(
                cashadd.npsBailAmount = cashadd.bailAmount,
                $scope.selected.select = []
            )
        }
    }
    //保存操作
    $scope.save_onClick = function(){
        if($scope.selectedlnci.select.length != 1)
        {
            $common.get_tipDialog("请选择一条借据！",'showError');
            return;
        }
        if($scope.datasource.ds.length==0)
        {
            $common.get_tipDialog("请添加现金等价物信息！",'showError');
            return;
        }
        var cashaddlist = $scope.datasource.ds;
        for(var i=0;i<cashaddlist.length;i++)
        {
            var cashadd = cashaddlist[i];
            if(!cashadd.npsBailAmount)
            {
                $common.get_tipDialog("请先查询现金等价物的核心金额！",'showError');
                return;
            }
        }
        $scope.savedisable = true;
        $common.get_asyncData("cashEqualValueRegisterService/CashEqualValueInfoSinglesUpdate",{bCrrLnConCash:$scope.lnconform,lnciBaseInfoForCash:$scope.selectedlnci.select,cashEqualValueInfo:$scope.datasource.ds}).then(function(res){
            var data ;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                appno = data.value;
                $scope.lnconform.appno = appno;
                $scope.queryCashAdd();
                $scope.disableButton = false;
                $common.get_tipDialog('保存成功！','showSuccess');
                $scope.savedisable = false;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.savedisable = false;
            };
        });
    };
    //提交操作
    $scope.submit_onClick = function()
    {
        if($scope.selectedlnci.select.length != 1)
        {
            $common.get_tipDialog("请选择一条借据！",'showError');
            return;
        }
        if($scope.datasource.ds.length==0)
        {
            $common.get_tipDialog("请添加现金等价物信息！",'showError');
            return;
        }
        var cashaddlist = $scope.datasource.ds;
        for(var i=0;i<cashaddlist.length;i++)
        {
            var cashadd = cashaddlist[i];
            if(!cashadd.npsBailAmount)
            {
                $common.get_tipDialog("请先查询现金等价物的核心金额！",'showError');
                return;
            }
        }
        $common.get_asyncData("cashEqualValueRegisterService/CashEqualValueInfoWriteSubmitUpdate",{bCrrLnConCash:$scope.lnconform,lnciBaseInfoForCash:$scope.selectedlnci.select,cashEqualValueInfo:$scope.datasource.ds,isProcess:true}).then(function(res){
            var data ;
            if (res.errorCode =="SUC"){
                $common.get_tipDialog('已提交！','showSuccess');
                $state.go("list");
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    };
    //同意
    $scope.ReviewAgree_onClick = function()
    {
        if($.doValidate("otherform")) {
            $scope.ReviewAgreedisable = true;
            $scope.BackToModifydisable = true;
            var primise = $common.get_asyncData("cashEqualValueRegisterService/CashEqualValueRegCheckUpdateAgree",{appno:appno,isProcess:true});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('操作已完成','showSuccess');
                    if(window.appNo)
                    {
                        $scope.Approve = true;
                    }
                    else
                    {
                        $state.go("list");
                    }
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    }
    //退回
    $scope.BackToModify_onClick = function()
    {
        if($.doValidate("otherform")) {
            $scope.ReviewAgreedisable = true;
            $scope.BackToModifydisable = true;
            var primise = $common.get_asyncData("cashEqualValueRegisterService/CashEqualValueRegCheckUpdateBack",{appno:appno,isProcess:true});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('已退回','showSuccess');
                    if(window.appNo)
                    {
                        $scope.Approve = true;
                    }
                    else
                    {
                        $state.go("list");
                    }
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    }
    $scope.back_onClick = function(){
        $state.go("list");
    };
	//表格--------结束-------------------------
};

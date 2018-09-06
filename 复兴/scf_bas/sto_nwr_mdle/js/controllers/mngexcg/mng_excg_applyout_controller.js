/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var mngExcgApplyOutController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.baseinfo = $scope.source.baseinfo;
    /**
     * 仓单信息初始化
     * @type {{ds: Array}}
     */
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

    /**
     * 换出仓单信息初始化
     * @type {{ds: Array}}
     */
    $scope.datasourceexcg={//初始化表格对象
        ds:[]
    };
    $scope.selectedexcg={//初始化对象
        select: []
    };
    $scope.confexcg= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    $scope.taskform = $scope.source.taskform;
    $scope.hide = true;
    $scope.disable = true;

    $scope.Write = window.Write;
    $scope.Check = window.Check;
    $scope.Review = window.Review;
    $scope.Confirm = window.Confirm;
    $scope.BackToModify = window.BackToModify;
    if(!$scope.taskform||!$scope.taskform.id)
    {
        $scope.hide = window.Write;
        $scope.disable = window.Write;
        $("#billCheck").show();
    }
    else
    {
        $scope.hide = true;
        $scope.disable = true;
        if($scope.taskform.id == "Write")
        {//普通仓单质押填写岗
            $scope.hide = window.Write;
            $scope.disable = window.Write;
            $("#billCheck").show();
        }
        else if($scope.taskform.id == "Review")
        {//复核岗
            $("#billCheck").remove();
        }
        else if($scope.taskform.id == "Check")
        {//审批岗
            $("#billCheck").remove();
        }
        else if($scope.taskform.id == "Confirm")
        {//回执
            $("#billCheck").remove();
        }
        else
        {
            $("#billCheck").remove();
        }
    }

    //监听分页
    $scope.$watch("conf.pageNo",function(){
        $scope.queryTable();
    });
    //仓单列表
    $scope.queryTable = function(paramData)
    {
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            billNormalAppVO:$scope.baseinfo
        };
        var promise = $common.get_asyncData("billNormalOffMngService/BillNormalOffListQueryGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records||[];
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //监听分页
    $scope.$watch("conf.pageNo",function(){
        $scope.queryTableExcg();
    });
    //预解除质押仓单列表
    $scope.queryTableExcg = function(paramData)
    {
        var data= {
            pageNo: $scope.confexcg.pageNo,
            pageSize: $scope.confexcg.pageSize,
            billNormalVO:$scope.baseinfo
        };
        var promise = $common.get_asyncData("billNormalMngExcgService/BillMngExcgEnteringListGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasourceexcg.ds = data.records||[];
                $scope.confexcg.totalRecord = data.totalRecord;
                if($scope.datasourceexcg.ds!=[]&&$scope.datasourceexcg.ds.length>0)
                {
                    var billno = "";
                    for(var i=0; i<$scope.datasourceexcg.ds.length; i++)
                    {
                        billno = billno + $scope.datasourceexcg.ds[i].billno+"/f";
                    }
                    $scope.baseinfo.billno = billno;
                    $scope.queryTableMort();
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    $scope.datasourcemort = {//初始化表格对象
        ds:[]
    };
    $scope.selectedmort ={//初始化对象
        select: []
    };
    $scope.confmort = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //仓单下押品列表
    $scope.queryTableMort = function(paramData)
    {
        var data= {
            pageNo: $scope.confmort.pageNo,
            pageSize: $scope.confmort.pageSize,
            mortgageQryVO:$scope.baseinfo
        };
        var promise = $common.get_asyncData("sBcpMortBillNormalService/BillstandardMortgageBaseGetter",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasourcemort.ds = data.records;
                $scope.confmort.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    $scope.applyDtlForm = {};
    $scope.datasourcetask={//初始化表格对象
        ds:[
        ]
    };
    $scope.selectedtask={//初始化对象
        select: []
    };
    $scope.conftask= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };

    $scope.applyDtlForm={
        taskComment:''
    }

    //监听分页
    $scope.$watch("conftask.pageNo+conftask.pageSize",function()
    {
        if(window.processId)
        {
            $scope.queryTabletask();
        }
    });

    //查询
    $scope.queryTabletask = function(){
        var data= {
            processId:window.processId,
            pageNo: $scope.conftask.pageNo,
            pageSize: $scope.conftask.pageSize
        };
        var promise = $common.get_asyncData("taskService/getDoneTask",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasourcetask.ds = data.records;
                $scope.conftask.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    $scope.mngexcg_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            var excgmng = $scope.selected.select[0];
            $scope.confexcg.totalRecord ++;
            var billno = excgmng.billno;
            var basebillno = billno + "/f";
            for(var x in $scope.datasourceexcg.ds)
            {
                var excg = $scope.datasourceexcg.ds[x];
                var excgbillno = excg.billno;
                if(billno==excgbillno)
                {
                    $common.get_tipDialog('该信息已经加入解押列表，不能重复加入！','showInform');
                    return;
                }
                basebillno += excgbillno +"/f";
            }
            $scope.datasourceexcg.ds.push(excgmng);
            $scope.selected.select = [];
            $scope.baseinfo.billno = basebillno;
            $scope.queryTableMort();
            $scope.$apply();
        }
    };

    $scope.deleteexcg_onClick = function()
    {
        if($scope.selectedexcg.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            var selectedList = $scope.selectedexcg.select;
            var dsArray = $scope.datasourceexcg.ds;
            $scope.selectedexcg.select=[];
            //删除仓单列表
            for (var i = 0; i < dsArray.length; i++)
            {
                var dsbillno = dsArray[i].billno;
                for(var j = 0; j<selectedList.length; j++)
                {
                    var selectbillno = selectedList[j].billno;
                    if (dsbillno == selectbillno) {
                        $scope.datasourceexcg.ds.splice(i, 1);
                        $scope.confexcg.totalRecord --;
                    }
                }
            }
            //删除对应押品列表信息
            var mortArray = $common.copy($scope.datasourcemort.ds);
            for (var i = 0; i < selectedList.length; i++)
            {
                var selectbillno = selectedList[i].billno;
                var num = 0;
                for(var k = 0; k<mortArray.length; k++)
                {
                    var mortbillno = mortArray[k].billno;
                    if(selectbillno==mortbillno)
                    {
                        $scope.datasourcemort.ds.splice(k - num, 1);
                        $scope.confmort.totalRecord --;
                        num ++;
                    }
                }
            }
            $scope.$apply();
        }
    };

    $scope.viewmort_onClick = function()
    {
        if($scope.selectedmort.select.length != 1){
            $common.get_tipDialog('请选择一条押品记录！','showInform');
        }else{
            $common.get_ngDialog('nwrinfo/nwrinfo_mortedit.html', $scope,["$scope",function(dialogScope){
                dialogScope.mortgageInfo = $scope.selectedmort.select[0];
                dialogScope.disable = true;
                dialogScope.addQuantityHide = true;
                dialogScope.saveHide = true;
                //查询押品一级
                dialogScope.mortgageLevelOneSource = {
                    ds:[]
                };
                dialogScope.$watch("conf.pageNo+conf.pageSize",function() {
                    dialogScope.mortgageLevelOneSourceList(1);
                    if(dialogScope.mortgageInfo.mortgageLevelOne)
                    {
                        var dataItemsDO = {mortgageCode:dialogScope.mortgageInfo.mortgageLevelOne};
                        var data = {dataItemsDO:dataItemsDO};
                        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }
                });
                dialogScope.mortgageLevelOneSourceList = function(level)
                {
                    //业务品种下拉框
                    var dataItemsDO = {levels:level};
                    var data = {dataItemsDO:dataItemsDO};
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelOneSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                };
                //押品二级
                dialogScope.mortgageLevelTwoSource = {
                    ds:[]
                };
                dialogScope.mortgageLevelOneName = function (val){
                    dialogScope.mortgageInfo.mortgageLevelTwo = "";
                    if(null != val){
                        var dataItemsDO = {mortgageCode:val};
                        var data = {dataItemsDO:dataItemsDO};
                        var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
                        mortgageName.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageInfo.mortgageLevelOneName = res.contextData.mortgageName;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }else{
                        dialogScope.mortgageLevelTwoSource.ds = [];
                    }
                };
                //押品三级
                dialogScope.mortgageLevelThreeSource = {
                    ds:[]
                };
                dialogScope.mortgageLevelTwoName = function (val){
                    dialogScope.mortgageInfo.mortgageLevelThreeSource = "";
                    if(null != val){
                        var dataItemsDO = {mortgageCode:val};
                        var data = {dataItemsDO:dataItemsDO};
                        var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
                        mortgageName.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageInfo.mortgageLevelTwoName = res.contextData.mortgageName;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageLevelThreeSource.ds = res.contextData;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }else{
                        dialogScope.mortgageLevelThreeSource.ds = [];
                    }
                };
                //返回
                dialogScope.close_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"押品信息")
        }
    };

    //换出仓单保存
    $scope.save_onClick = function()
    {
        if($scope.datasourceexcg.ds==[]||$scope.datasourceexcg.ds.length==0)
        {
            $common.get_tipDialog('换出仓单列表不能为空！','showInform');
            return;
        }
        if($scope.baseinfo.appno==null||$scope.baseinfo.appno==""||$scope.baseinfo.appno==undefined)
        {
            $common.get_tipDialog('申请编号不存在，请先保存换入仓单信息！','showInform');
            return;
        }
        var removePledgeAmount = 0;
        for(var x in $scope.datasourceexcg.ds)
        {
            var excg = $scope.datasourceexcg.ds[x];
            var whReceiptValue = Number(excg.whReceiptValue);
            removePledgeAmount += whReceiptValue;
        }
        $scope.baseinfo.removePledgeAmount = removePledgeAmount;
        window.source.baseinfo = $scope.baseinfo;
        $scope.$apply();
        var data = {
            billNormalAppVO:$scope.baseinfo,
            list:$scope.datasourceexcg.ds
        };
        $common.get_asyncData("billNormalMngExcgService/BillNorExcgOutListUpdater",data).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog("保存成功",'showSuccess');
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //表格--------结束-------------------------
};

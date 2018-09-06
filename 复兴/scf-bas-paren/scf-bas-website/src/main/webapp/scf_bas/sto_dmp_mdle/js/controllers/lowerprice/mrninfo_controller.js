/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var mrninfoController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.taskform = $scope.source.taskform;
    if(!$scope.taskform||!$scope.taskform.id)
    {
        $scope.saveHide = false;
    }
    else
    {
        if ($scope.taskform.id == "sbcpappli_approve") {//申请
            $scope.saveHide = false;
        }
        else
        {
            $scope.saveHide = true;
        }
    }
    $scope.gntycon = $scope.source.gntycon;
    $scope.priceadjust = dataDeliver.getter();
    if(!$scope.priceadjust.appno)
    {
        $scope.priceadjust = $scope.source.priceadjust;
    }
    $scope.gntycon.addBailAmount = $scope.priceadjust.amt;
    if(!$scope.priceadjust.appno)
    {
        $common.get_tipDialog("保证金追加与附件上传，需要在第一个table页面保存后，才能查看!",'showInform');
        //进入guideҳ
        //$state.go("priceadjust");
        //$scope.$parent.panes.forEach(function(pane){
        //    if (pane.uiSref == "priceadjust"){
        //        $scope.$parent.select(pane);
        //    }
        //});
        //一般形式
        $state.go("priceedit.priceadjust");
        $scope.$parent.panes.forEach(function(pane){
            if (pane.uiSref == "priceedit.priceadjust"){
                $scope.$parent.select(pane);
            }
        });
        return;
    }
    $scope.conditionForm={};//初始化查询条件对象
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    $scope.cache = "0";
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    })
    $scope.queryTable = function(paramData){
        $scope.conditionForm.slaveContno = $scope.gntycon.conId;
        $scope.conditionForm.appno = $scope.priceadjust.appno;
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bMrnAppliAcctInfo:$scope.conditionForm,
            cache:$scope.cache
        };
        var promise = $common.get_asyncData("bMrnAppliAcctInfoService/findBMrnAppliAcctInfoByPageAndSlaveContno",data)
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    /**
     * 担保人名称查询加载开始
     */
    $scope.gutcontent = {
        type:"table",//展示类型table  tree
        url:"bCrrLnAppService/queryCustSource",
        param:{},
        split:",",//设置分隔符
        extentColumn:"custNm",
        column:["custNm","custId"]//设置显示信息
    };
    $scope.gutextend = function(ds){
        $scope.gntycon.gutNm = ds.custNm;
        $scope.gntycon.gutId = ds.custId;
        $scope.gntycon.gcrtId = ds.idno;
        $scope.gntycon.gcrtTyp = ds.idtype;
        $scope.number = ds;
    };
    $scope.$watch("gntycon.gutNm",function(){
        if($scope.gntycon.gutNm!=null) $scope.gutcontent.param ={custId:$scope.gntycon.gutNm,custNm:$scope.gntycon.gutNm};
    });
    /**
     * 担保人名称查询加载结束
     */
    /**
     * 业务品种筛选开始
     */
    $scope.productNameContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBusinessType",
        param:{ factType:"0" },   //设置参数
        split:",",//设置分隔符
        extentColumn:"productName",
        column:["productName","productId"]//设置宣誓内容
    };
    $scope.productNamedooextent = function(ds){
        $scope.gntycon.vidPrdNm=ds.productName;
        $scope.gntycon.vidPrdId=ds.productId; //业务品种
    };
    $scope.$watch("gntycon.vidPrdId",function(newVal,oldVal){
        $scope.productNameContent.param ={
            tFactType:"0"  //筛选产品种类，部分品种设置为0
        };
    });
    /**
     * 业务品种筛选结束
     */
    //新增
    $scope.add_onClick = function()
    {
        $common.get_ngDialog('lowerprice/lanlnci.html', $scope
            ,["$scope",function(dialogScope){
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
                        gntyconid:$scope.gntycon.conId,
                        list:$scope.datasource.ds
                    };
                    var promise = $common.get_asyncData("lowerPriceService/findBLanLnciBaseByMastContnoAndPage",data);
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
                        var list = dialogScope.selected.select;
                        var primise = $common.get_asyncData('bMrnAppliAcctInfoService/cacheAdd',{list:list,lowerprice:$scope.priceadjust});
                        primise.then(function(res){
                            if (res.errorCode =="SUC"){
                                dialogScope.closeThisDialog();
                                $scope.cache = "1";
                                $scope.queryTable();
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            };
                        });
                    }
                };
                dialogScope.closeThisDialog_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"添加页面",{showClose:false});
    }
    //修改
    $scope.update_onClick = function()
    {
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录','showInform');
        }else{
            $common.get_ngDialog('lowerprice/mrnedit.html', $scope
                ,["$scope",function(dialogScope){
                    dialogScope.mrnedit = $common.copy($scope.selected.select[0]);
                    dialogScope.confirm_onClick = function()
                    {
                        if($.doValidate("mrnedit")) {
                            $scope.selected.select[0].bailAccountno = dialogScope.mrnedit.bailAccountno;
                            $scope.selected.select[0].addBailAmount = dialogScope.mrnedit.addBailAmount;
                            $scope.selected.select = [];
                            dialogScope.closeThisDialog();
                        };
                    }
                    dialogScope.closeThisDialog_onClick = function(){
                        dialogScope.closeThisDialog();
                    };
                }],"冻结保证金明细编辑",{showClose:false});
        }
    }
    //删除
    $scope.delete_onClick = function()
    {
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录','showInform');
        }else{
            var primise = $common.get_asyncData('bMrnAppliAcctInfoService/batchDelete',{list:$scope.selected.select});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $scope.cache = "1";
                    $scope.queryTable();
                    $common.get_tipDialog('删除成功！','showSuccess');
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        }
    }
    //保存融资借据列表
    $scope.confirm_onClick = function()
    {
        var list = $scope.datasource.ds;
        if($scope.datasource.ds.length==0)
        {
            $common.get_tipDialog('冻结保证金列表记录不能为空!','showInform');
            return;
        }
        for(var i=0;i<list.length;i++)
        {
            var mtrinfo = list[i];
            var debetNo = mtrinfo.debetNo;
            var accoutno = mtrinfo.bailAccountno;
            var addamount = Number(mtrinfo.addBailAmount);
            var riskAmt = Number(mtrinfo.riskAmt);
            var showinfo = "";
            if(!accoutno)
            {
                showinfo = showinfo + "借据号为【"+debetNo+"】的记录【保证金帐号】不能为空\t";
            }
            if(!addamount||addamount<=0)
            {
                showinfo = showinfo + "借据号为【"+debetNo+"】的记录【追加冻结金额】必须大于0\t";
            }
            if(addamount>riskAmt)
            {
                showinfo = showinfo + "借据号为【"+debetNo+"】的记录【追加冻结金额】必须小于等于该笔的敞口余额\t";
            }
        }
        if(showinfo!="")
        {
            $common.get_tipDialog(showinfo,'showInform');
            return;
        }
        var primise = $common.get_asyncData('bMrnAppliAcctInfoService/save',{list:list});
        primise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.cache = "0";
                $scope.queryTable();
                $common.get_tipDialog('保存成功！','showSuccess');
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    };
    //表格--------结束-------------------------
};

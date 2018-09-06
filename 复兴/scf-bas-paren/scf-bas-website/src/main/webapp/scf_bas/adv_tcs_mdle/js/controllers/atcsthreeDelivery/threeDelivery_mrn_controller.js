/**
 * @author 	liph
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var mrnDeliveryController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = {};

    var conId;
    var appno;
    var  bData =dataDeliver.getter();
    if(!bData ){
        var  bData = window.parent.data;
    }
    conId = bData.protocolNo;
    appno = bData.appno;
    if(!appno){
        $common.get_tipDialog("保证金追加与附件上传，需要在第一个table页面保存后，才能查看!",'showInform');
        $state.go("threeDeliveryApp.dtl");
        $scope.$parent.panes.forEach(function(pane){
            if (pane.uiSref == "threeDeliveryApp.dtl"){
                $scope.$parent.select(pane);
            }
        });
        return;
    }
    //----------------------end------------------------
    $scope.taskform = $scope.source.taskform;
    $scope.saveHide = false;
    $scope.otherform = bData;
    $scope.otherform.custno=bData.custcd;
   // $scope.priceadjust = bData;
    //基本信息赋值---start
    /* $scope.otherform.gutId = bData.custno;
   $scope.otherform.gutNm = bData.cname;
    $scope.otherform.vidPrdNm = bData.productName;
    $scope.otherform.conId = bData.protocolNo;
    $scope.otherform.addBailAmount = bData.addBailAmount;*/
    //基本信息赋值---end
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
        totalRecord: 0};
    $scope.cache = "0";
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    });
    $scope.queryTable = function(paramData){
     //   $scope.conditionForm.slaveContno = $scope.gntycon.conId;
      //  $scope.conditionForm.appno = $scope.priceadjust.appno;
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            appno:appno
        };
        var promise = $common.get_asyncData("aTcsThreeDeliveryService/getAddBailAmountListByAppno",data)
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
    var seq;//流程节点顺序
    var processId = window.processId;//流程点
    if(window.appNo)
    	getCurrentNodeEntity();
    //获得当前流程节点的信息
    function getCurrentNodeEntity(){
        var data = {
            pid:processId
        };
        var promise = $common.get_asyncData("processService/getCurrentNodeEntity", data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                var flowdata = res.contextData;
                seq = parseFloat(flowdata.seq);
                if (seq > 1) { //提交后的流程
                    //按钮隐藏
                    $scope.saveHide = true;

                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
     /**
     * 客户名称查询加载开始
     */
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
            creditFlag:"1", //授信客户
            cname:$scope.otherform.cname
        };
    });
    /**
     * 客户名称查询加载结束
     */

    /**
     * 业务品种筛选
     */
    $scope.productNameContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBusinessType",
        param:{ tfactType:"1" },    //应收账款融资
        split:",",//分隔符
        extentColumn:"productName",
        column:["productName","productId"]//展示内容
    };
    $scope.productNamedooextent = function(ds){
        $scope.otherform.productName=ds.productName;
        $scope.otherform.productId=ds.productId; //业务品种
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
    });
    //新增
    $scope.add_onClick = function()
    {
        //lowerprice/lanlnci.html
        $common.get_ngDialog('atcsthreeDelivery/debetListAdd.html', $scope
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
                    totalRecord: 0};
                //监听分页
                dialogScope.$watch("conf.pageNo+conf.pageSize",function() {
                    dialogScope.queryTable();
                });
                dialogScope.queryTable = function(paramData){
                    var deliveryQryVO={
                        operationType:"02",//担保提货
                        debetNo:bData.debetNo,
                        businessNo:bData.debetNo
                    };
                    var data= {
                        pageNo: dialogScope.conf.pageNo,
                        pageSize: dialogScope.conf.pageSize,
                        deliveryQryVO:deliveryQryVO
                    };
                    var promise = $common.get_asyncData("aTcsThreeDeliveryService/getDebetList",data);
                    promise.then(function(res){
                        var data;
                        if (res.errorCode =="SUC"){
                            data = res.contextData;
                            dialogScope.datasource.ds = data.records;
                            dialogScope.conf.totalRecord = data.totalRecord;
                            //选中记录
                            dialogScope.selected.select=$common.copy($scope.datasource.ds);
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
                        /* var list = dialogScope.selected.select;
                        var primise = $common.get_asyncData('bMrnAppliAcctInfoService/cacheAdd',{list:list,lowerprice:$scope.priceadjust});
                        primise.then(function(res){
                            if (res.errorCode =="SUC"){
                                dialogScope.closeThisDialog();
                                $scope.cache = "1";
                                $scope.queryTable();
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            };
                        });*/
                        //赋值到上一个页面
                        $scope.datasource.ds=[];
                        $scope.datasource.ds = $common.copy(dialogScope.selected.select);
                    }
                };
                dialogScope.closeThisDialog_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"添加页面",{showClose:true});
    };
    //修改
    $scope.update_onClick = function()
    {
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录','showInform');
        }else{
            $common.get_ngDialog('atcsthreeDelivery/appendmrnEdit.html', $scope
                ,["$scope",function(dialogScope){
                    dialogScope.mrnedit = $common.copy($scope.selected.select[0]);
                    dialogScope.confirm_onClick = function()
                    {
                        if($.doValidate("mrnedit")) {
                            $scope.selected.select[0].bailAccount = dialogScope.mrnedit.bailAccount;
                            $scope.selected.select[0].addBailAmount = dialogScope.mrnedit.addBailAmount;
                            $scope.selected.select = [];
                            dialogScope.closeThisDialog();
                        }
                    };
                    dialogScope.closeThisDialog_onClick = function(){
                        dialogScope.closeThisDialog();
                    };
                }],"冻结保证金明细编辑",{showClose:false});
        }
    };
    //删除
    $scope.delete_onClick = function()
    {
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录','showInform');
        }else{
           /* var primise = $common.get_asyncData('bMrnAppliAcctInfoService/batchDelete',{list:$scope.selected.select});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $scope.cache = "1";
                    $scope.queryTable();
                    $common.get_tipDialog('删除成功！','showSuccess');
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });*/
            $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
                var dsArray = $scope.datasource.ds;
                var selected = $scope.selected.select[0];
                for (var i = 0; i < dsArray.length; i++) {
                    if (dsArray[i].debetId == selected.debetId) {
                        $scope.datasource.ds.splice(i, 1);
                        $scope.selected.select = [];
                    }
                }
            })
        }
    };
    //保存融资借据列表
    $scope.confirm_onClick = function()
    {
        var list = $scope.datasource.ds;
        if($scope.datasource.ds.length==0)
        {
            $common.get_tipDialog('保证金追加列表记录不能为空！','showInform');
            return;
        }
        var tatolBailAmont = 0;
        for(var i=0;i<list.length;i++)
        {
            var mtrinfo = list[i];
            var debetNo = mtrinfo.debetId;
            var accoutno = mtrinfo.bailAccount;
            var addamount = Number(mtrinfo.addBailAmount);
            var riskAmt = Number(mtrinfo.riskAmt);
            tatolBailAmont=tatolBailAmont+addamount;
            var showinfo = "";
            if(!accoutno)
            {
                //showinfo = showinfo + "借据号为【"+debetNo+"】的记录【保证金帐号】不能为空"+"\n";
                showinfo = showinfo + "【保证金帐号】不能为空!";
            }
            if(!addamount||addamount<=0)
            {
               // showinfo = showinfo + "借据号为【"+debetNo+"】的记录【追加冻结金额】必须大于0"+"\n";
                showinfo = showinfo + "【追加冻结金额】必须大于0!";
            }
            if(addamount>riskAmt)
            {
                //showinfo = showinfo + "借据号为【"+debetNo+"】的记录【追加冻结金额】必须小于等于该笔的敞口余额"+"\n";
                showinfo = showinfo + "【追加冻结金额】必须小于等于该笔的敞口余额!"+"\n";
            }
        }
        if(showinfo!="")
        {
            $common.get_tipDialog( "借据号为【"+debetNo+"】的记录:"+showinfo,'showInform');
            return false;
        }
        var addBailAmount = $scope.otherform.addBailAmount;
        if(parseFloat(addBailAmount)!=parseFloat(tatolBailAmont)){
            $common.get_tipDialog('列表中的【追加冻结金额】累加金额必须等于【本次追加保证金总额】','showInform');
            return false;
        }
        var data= {
            vo: $scope.otherform,
            debetList: $scope.datasource.ds
        };
        var primise = $common.get_asyncData('aTcsThreeDeliveryService/ThreeDeliveryAddBailAmountSave',data);
        primise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.queryTable();
                $common.get_tipDialog('保存成功！','showSuccess');
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //表格--------结束-------------------------
};

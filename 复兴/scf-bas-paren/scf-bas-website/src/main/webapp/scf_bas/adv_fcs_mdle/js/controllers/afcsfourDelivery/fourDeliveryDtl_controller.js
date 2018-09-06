/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */

var fourDeliveryDtlController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    $scope.otherform={};
    $scope.fourDeliveryform={};
    var  bData =dataDeliver.getter();

    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.source={
        addBailAmount:[]
    };
    var seq;//流程节点顺序
    var processId = window.processId;//流程点
    var appno = bData.appno;
    if(appno==null){
        $scope.sumbitdisable=true;
        queryBaseInfo();
        //本次申请提货总金额
        $scope.fourDeliveryform.amount=0.0;
    }else{ //流程中的处理
        $scope.sumbitdisable= false;
        $scope.hideback=true; //返回按钮隐藏
        queryBaseInfo();
        queryMortgageListByAppno();
    }
    if(window.appNo){ //待办任务
        getCurrentNodeEntity();
    }
//根据合同编号加载合同基本信息
    function queryBaseInfo(){
        var data ={
            deliveryQryVO:{
                mastContno:bData.mastContno,
                debetNo:bData.debetNo
            }
        };
        var promise=$common.get_asyncData("aTcsThreeConfirmService/queryContOrProByMastContno",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.fourDeliveryform=data;
                queryDebtInfo();
                queryDeliveryInfo();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    /*根据借据编号加载出账信息**/
    function queryDebtInfo(){
        var data ={
            deliveryQryVO:{
                mastContno:bData.mastContno,
                debetNo:bData.debetNo
            }
        };
        var promise=$common.get_asyncData("aTcsThreeConfirmService/queryThreeConfirmByDebet",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $.extend($scope.fourDeliveryform,res.contextData); //合并
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    /*根据借据编号或申请编号加载提货申请信息**/
    function queryDeliveryInfo(){
        var data ={
            deliveryQryVO:{
                appno:bData.appno,
                debetNo:bData.debetNo
            }
        };
        var promise=$common.get_asyncData("fourDeliveryService/getFourDeliveryInfo",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                if($scope.source.addBailAmount == null||$scope.source.addBailAmount ==''){
                }else{
                    $scope.fourDeliveryform.addBailAmount = $scope.source.addBailAmount;
                }
                $.extend($scope.fourDeliveryform,res.contextData); //合并
                dataDeliver.setter($scope.fourDeliveryform);
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }

    /**
     * 申请编号查询提货货物信息
     */
    function queryMortgageListByAppno(){
        var deliveryQryVO={
            appno:bData.appno,
            debetNo:bData.debetNo
        };
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize:$scope.conf.pageSize,
            deliveryQryVO:deliveryQryVO
        };
        var promise=$common.get_asyncData("aTcsThreeDeliveryService/getDeliveryMortgageListByAppno",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    };

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
                    //设置只读熟悉
                    $scope.taskdisable =true;
                    //按钮隐藏
                    $scope.hidetask = true;
                    $scope.hidesumbit = true;
                    $scope.hidesave = true;
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    //卖方名称
    $scope.coreNmContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.coreNmdooextent = function(ds){
        $scope.fourDeliveryform.coreCustcd=ds.custcd;
        $scope.fourDeliveryform.coreNm=ds.cname;
    };
    $scope.$watch("fourDeliveryform.coreNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.coreNmContent.param ={
            coreFlag:"1", //核心厂商
            cname:$scope.fourDeliveryform.cname
        };
    });

    //买方名称
    $scope.cnameContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.fourDeliveryform.custcd=ds.custcd;
        $scope.fourDeliveryform.cname=ds.cname;
    };
    $scope.$watch("fourDeliveryform.cname",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.cnameContent.param ={
            creditFlag:"1", //授信客户
            cname:$scope.fourDeliveryform.cname
        };
    });

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
        $scope.fourDeliveryform.productName=ds.productName;
        $scope.fourDeliveryform.productId=ds.productId; //业务品种
        $scope.fourDeliveryform.factType=ds.factType;
        $scope.fourDeliveryform.financingType=ds.financingType;
    };
    $scope.$watch("fourDeliveryform.productName",function(newVal,oldVal){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.productNameContent.param ={
            productName:$scope.fourDeliveryform.productName,
            //productId:$scope.otherform.supplyChainPdId,
            tFactType:"1"  //应收账款融资
        };
    });
    //提货信息添加begin
    $scope.add_onClick = function(){
        $common.get_ngDialog('afcsfourDelivery/fourDeliveryMortListAdd.html', $scope
            ,["$scope",function(dialogScope){
                // debtExtSelectController(dialogScope,$scope,$common,dataDeliver,"add");
                dialogScope.datasourceDialog={//初始化表格对象
                    ds:[]
                };
                dialogScope.selectedDialog={//初始化对象
                    select: []
                };
                dialogScope.confDialog= {//初始化分页对象
                    pageNo: 1,
                    pageSize: 10,
                    totalRecord: 0};

                //监听分页
                dialogScope.$watch("confDialog.pageNo+confDialog.pageSize",function(){
                    dialogScope.queryTable();
                });

                dialogScope.queryTable = function(){
                    var deliveryQryVO={
                        appno:bData.appno,
                        debetNo:bData.debetNo
                    };
                    var data= {
                        pageNo: dialogScope.confDialog.pageNo,
                        pageSize:dialogScope.confDialog.pageSize,
                        deliveryQryVO:deliveryQryVO,
                        list:$scope.datasource.ds //已有的列表
                    };
                    var promise=$common.get_asyncData("aTcsThreeDeliveryService/getTripartiteDeliveryAppMortList",data);
                    promise.then(function (res) {
                        if(res.errorCode=="SUC"){
                            data = res.contextData;
                            dialogScope.datasourceDialog.ds = data.records;
                            dialogScope.confDialog.totalRecord = data.totalRecord;
                            dialogScope.selectedDialog.select=$common.copy($scope.datasource.ds);
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    })
                };

                dialogScope.confirm_onClick = function(){
                    if(dialogScope.selectedDialog.select.length <= 0){
                        $common.get_tipDialog('请勾选记录之后再提交！','showInform');
                        return false;
                    }
                    //赋值到上一个页面
                    $scope.datasource.ds=[];
                    $scope.datasource.ds = $common.copy(dialogScope.selectedDialog.select);
                    dialogScope.closeThisDialog();
                };
                //返回
                dialogScope.closeThisDialog_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"提货列表选择",{showClose:true});

    };
    //提货信息修改begin
    $scope.update_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else {
            $common.get_ngDialog('afcsfourDelivery/fourDeliveryMortListDtl.html', $scope
                , ["$scope", function (dialogScope) {
                    dialogScope.dialogform = {};
                    //值
                    dialogScope.dialogform=$common.copy($scope.selected.select[0]);

                    //查询押品一级
                    mortgageLevelOneSource();
                    function mortgageLevelOneSource(){
                        //业务品种下拉框
                        var dataItemsDO = {levels:"1"};
                        var data = {dataItemsDO:dataItemsDO};
                        var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        dialogScope.mortgageLevelOneSource= {
                            ds: []
                        };
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
                        var data = {dataItemsDO:dataItemsDO};
                        var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        dialogScope.mortgageLevelTwoSource= {
                            ds: []
                        };
                        promise.then(function(res){
                            if (res.errorCode =="SUC"){
                                dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }

                    //提货数量 失去焦点
                    dialogScope.outQuantity_onBlur = function(){
                        var outQuantity =parseFloat(dialogScope.dialogform.outQuantity);
                        var price =parseFloat(dialogScope.dialogform.price);
                        dialogScope.dialogform.totPrice=outQuantity*price;
                        dialogScope.$apply();
                    };
                    dialogScope.confirm_onClick = function () {
                        if($.doValidate("dialogform")) {
                            /*if (dialogScope.selectedDialog.select.length <= 0) {
                             $common.get_tipDialog('请勾选记录之后再提交！', 'showInform');
                             return false;
                             }*/
                            //documentNo 提货凭证号 "/^[A-Za-z0-9]{1,32}$/"
                            /* if(dialogScope.dialogform.documentNo || dialogScope.dialogform.documentNo != ""){
                             var regTel = new RegExp(/^[A-Za-z0-9]{8}-[A-Za-z0-9]{1}$/);
                             var r = regTel.test(dialogScope.dialogform.documentNo);
                             if(!r){
                             $common.get_tipDialog('提货凭证编号格式错误！', 'showInform');
                             return false;
                             }
                             }*/
                            //提货数量不能大于货物数量的校验
                            var outQuantity =dialogScope.dialogform.outQuantity;
                            var quantity =dialogScope.dialogform.quantity;
                            if(parseFloat(outQuantity) > parseFloat(quantity) ){
                                $common.get_tipDialog('提货数量不能大于货物数量!', 'showInform');
                                return false;
                            }
                            //赋值到上一个页面
                            //遍历已增加记录，修改相应的记录
                            var dsArray = $scope.datasource.ds;
                            var selected = $scope.selected.select[0];
                            for (var i = 0; i < dsArray.length; i++) {
                                if (dsArray[i].mortgageNo == selected.mortgageNo) {
                                    $scope.datasource.ds[i] =$common.copy(dialogScope.dialogform)
                                }
                            }
                            //本次申请提货总金额的计算begin
                            var array = $scope.datasource.ds;
                            var totalamt = 0;
                            for(var j=0;j<array.length;j++){
                                totalamt = parseFloat(totalamt) + parseFloat(array[j].totPrice);
                            }
                            $scope.fourDeliveryform.amount = totalamt;
                            //本次申请提货总金额的计算end
                            dialogScope.closeThisDialog();
                            $scope.selected.select=[]; //清空选中记录
                        }
                    };

                    //返回
                    dialogScope.closeThisDialog_onClick = function () {
                        dialogScope.closeThisDialog();
                    };
                }], "", {showClose: true});


        }
    };
    //提货信息列表删除

    $scope.delete_onClick = function() {
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('请选择一条记录！', 'showInform');
        }else {
            $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
                var dsArray = $scope.datasource.ds;
                var selected = $scope.selected.select[0];
                for (var i = 0; i < dsArray.length; i++) {
                    if (dsArray[i].mortgageNo == selected.mortgageNo) {
                        $scope.datasource.ds.splice(i, 1);
                        $scope.selected.select = [];
                    }
                }
                //本次申请提货总金额的计算begin
                var array = $scope.datasource.ds;
                var totalamt = 0;
                for(var j=0;j<array.length;j++){
                    totalamt = parseFloat(totalamt) + parseFloat(array[j].totPrice);
                }
                $scope.fourDeliveryform.amount = totalamt;
                //本次申请提货总金额的计算end
            })
        }
    };

    //提货信息添加end

    //本次追加保证金失去焦点 计算本次可提货金额 begin
    $scope.addBailAmount_onBlur = function(newVal,oldVal){
        //if(oldVal!=null&&newVal !== oldVal){
        //金额长度的校验
        //追加保证金长度校验
        var addBailAmount = $scope.fourDeliveryform.addBailAmount;
        if(addBailAmount === undefined || addBailAmount.length < 1) return;
        if( checkLenght(addBailAmount.toString())>16)
        {
            $common.get_tipDialog('【本次追加保证金总额】系统允许最大输入长度为16位，请重新输入','showError');
            $scope.fourDeliveryform.addBailAmount="";;
            return false;
        }
        $scope.fourDeliveryform.loanWay=$scope.fourDeliveryform.lnciType;
            var data = {
                threeDeliveryVO: $scope.fourDeliveryform
            };
            var primise = $common.get_asyncData("aTcsThreeDeliveryService/getCanDeliveryAmt", data);
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    data = res.contextData;
                    $scope.fourDeliveryform.canDeliveryAmt=data;
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
       // }
    };
    //本次追加保证金失去焦点 计算本次可提货金额 end

    //保存
    $scope.save_onClick = function(){
        if($.doValidate("otherform")) {
            if ($scope.datasource.ds.length <= 0) {
                $common.get_tipDialog("提货信息列表记录不能为空!", 'showInform');
                return false;
            }
            //校验输入字段的长度
           //追加保证金长度校验
           var addBailAmount = $scope.fourDeliveryform.addBailAmount;
            var openAmount = $scope.fourDeliveryform.openAmount;
            if( checkLenght(addBailAmount.toString())>16)
            {
                $common.get_tipDialog('【本次追加保证金总额】系统允许最大输入长度为16位，请重新输入','showError');
                return false;
            }
            if(parseFloat(addBailAmount)>parseFloat(openAmount)){
                $common.get_tipDialog('【本次追加保证金总金额】必须小于等于该笔申请的【敞口余额】','showError');
                return false;
            }
           var msg = checkData();
            if(msg!=null && msg!=""){
                $common.get_tipDialog(msg, 'showInform');
                return false;
            }
            $scope.savedisable= true; //点击保存之后保存按钮不可用
            var data = {
                fourDeliveryVO: $scope.fourDeliveryform,
                threeBuyMortgageInfoVOList: $scope.datasource.ds
            };
            var primise = $common.get_asyncData("fourDeliveryService/saveFourDeliveryAppInfoUpdate", data);
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    data = res.contextData;
                    $scope.fourDeliveryform.appno=data.value;
                    $scope.source.addBailAmount = $scope.fourDeliveryform.addBailAmount;//本次追加保证金总额--放到公共里面\
                    window.source = $scope.source;
                    dataDeliver.setter( $scope.fourDeliveryform);
                    $scope.sumbitdisable= false;
                    $common.get_tipDialog('保存成功！', 'showSuccess');
                    //$state.go("bsysthreeProtocol");
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
                $scope.savedisable= false; //返回结果后按钮可用
            });
        }
    };
    //提交
    $scope.sumbit_onClick = function(){
        if($.doValidate("otherform")) {
            if ($scope.datasource.ds.length <= 0) {
                $common.get_tipDialog("提货信息列表记录不能为空!", 'showInform');
                return false;
            }
            //校验输入字段的长度
            //追加保证金长度校验
            var addBailAmount = $scope.fourDeliveryform.addBailAmount;
            var openAmount = $scope.fourDeliveryform.openAmount;
            if( checkLenght(addBailAmount.toString())>16)
            {
                $common.get_tipDialog('“追加保证金”长度大于16，请重新输入','showError');
                return false;
            }
            //增加校验 【本次追加保证金总金额】必须小于等于该笔申请【敞口余额】
            if(parseFloat(addBailAmount)>parseFloat(openAmount)){
                $common.get_tipDialog('【本次追加保证金总金额】必须小于等于该笔申请的【敞口余额】','showError');
                return false;
            }
            var msg = checkData();
            if(msg!=null && msg!=""){
                $common.get_tipDialog(msg, 'showInform');
                return false;
            }
            $scope.sumbitdisable= true; //点击提交之后提交按钮不可用
            var data = {
                fourDeliveryVO: $scope.fourDeliveryform,
                threeBuyMortgageInfoVOList: $scope.datasource.ds
            };
            var primise = $common.get_asyncData("fourDeliveryService/saveFourDeliveryAppInfoSubmit", data);
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    $common.get_tipDialog('提交成功！', 'showSuccess');
                    //从待办任务进来提交之后的处理
                    if(window.appNo){
                        //隐藏提货信息列表按钮
                        $scope.hidetask = true;
                        $scope.hidesave = true;
                        $scope.hidesumbit = true;
                        $scope.hideback = true;

                    } else {
                        $scope.back_onClick();
                    }
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
                $scope.sumbitdisable= false; //返回结果后按钮可用
            });
        }
    };

    //校验数据
    function checkData(){
        //购销合同信息屏蔽检验
        selectFlag = "true";
        var flag = 0;//异常标志
        var msg = "";
        var addBailAmount = 0;
        var openAmount = 0;
        addBailAmount = $scope.fourDeliveryform.addBailAmount;
        openAmount  = $scope.fourDeliveryform.openAmount;
        var records = $scope.datasource.ds;
        for (i = 0; i < records.length;i++) {
            var record = records[i];
            var id =  record.id;
            var mortgageNo =  record.mortgageNo;
            var mortgageModel = record.mortgageModel;
            var quantity =  record.quantity;
            var totPrice =  record.totPrice;
            var originalTotPrice =  record.originalTotPrice;
            var outQuantity =  record.outQuantity;
            if(mortgageModel==null){
                flag++;
                msg = msg+"货物编号为【"+mortgageNo+"】的记录【规格型号】不能为空"+"\n";
            }
            if(quantity<0){
                flag++;
                msg = msg+"货物编号为【"+mortgageNo+"】的记录【数量/重量】不能小于等于0"+"\n";
            }
            if(outQuantity<0){
                flag++;
                msg = msg+"货物编号为【"+mortgageNo+"】的记录【提货数量/重量】不能小于等于0"+"\n";
            }
            if(isNaN(totPrice)){
                flag++;
                msg = msg+"货物编号为【"+mortgageNo+"】的记录【提货金额】不能为空"+"\n";
            }

            if(totPrice<=0){
                flag++;
                msg = msg+"货物编号为【"+mortgageNo+"】的记录【提货金额】必须大于0"+"\n";
            }

            //if(originalTotPrice>0 && totPrice>originalTotPrice){
            //	flag++;
            //	msg = msg+"货物编号为【"+mortgageNo+"】的记录【提货金额】不能大于【货物价值】"+"\n";
            //}
        }

        var amount = $scope.fourDeliveryform.amount;
        var canDeliveryAmt = $scope.fourDeliveryform.canDeliveryAmt;
        if(!amount){
            amount=0;
        };
        if(!canDeliveryAmt){
            canDeliveryAmt=0;
        }
        if(parseFloat(canDeliveryAmt)<parseFloat(amount)){
            flag++;
            msg = msg+"【本次申请提货总金额】不能大于【本次可提货金额】"+"\n";
        }
        // 增加校验
        if(parseFloat(outQuantity) > parseFloat(quantity) ){
            flag++;
            msg = msg+"货物编号为:【"+mortgageNo+"】提货数量不能大于货物数量!"+"\n";
        }
        //if(totprice > originalTotPrice ){
        //	alert('货物编号为:【'+mortgageNo+'】提货金额不能大于货物金额!');
        //	fourDeliveryAppInfoMortList_dataset.setValue("totprice",0);
        //}

        if(flag>0){
            return msg;
        }else{
            return "";
        }
    }
    $scope.back_onClick = function () {
        $state.go("fourDelivery");
    };
    //表格--------结束-------------------------
};

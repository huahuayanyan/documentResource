/**findBCrmBaseInfoByKey
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var nrBcpContDebtController =function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
//先将之前的数据赋值给对应的页面，底下的是没新增一个赋值给页面一个，最后是批量新增，这样的话，后台的方法就需要新增一个批量新增操作。
    $scope.contHide = true;
    var data1 = dataDeliver.getter();
    var flag = data1.flag;
    data1.aging = parseFloat(data1.aging);
    $scope.otherform = data1;//将之前的数据赋值给页面。币种要赋值给下面的table
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

    $scope.productselect = {//业务品种下拉框
        ds:[]
    };

    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    });
    $scope.queryTable = function(paramData){
        var rbcpdebtinfovo = $scope.otherform;
        rbcpdebtinfovo.billsType = "";
        rbcpdebtinfovo.billsNo = "";
        rbcpdebtinfovo.remainingAmount = "";
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            rBcpDebtInfoVO:rbcpdebtinfovo
        };
        var promise = $common.get_asyncData("rbcpDebtInfoService/findRBcpDebtInfoPageByPage",data);
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

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.productSourceList();
    });
    //查询业务品种
    $scope.productSourceList = function(){
        //业务品种下拉框
        var bPrdInfo = {parentId:"3000",status:"1"};
        var data = {bPrdInfo:bPrdInfo};
        var promise = $common.get_asyncData("bcntBcpAppliBaseInfoService/getProductId",data);
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.productselect.ds = res.contextData||[];
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    };

    //新增应收账款凭据信息（弹出框）
    $scope.add_onClick = function(){
        if($.doValidate("otherform")){
            $common.get_ngDialog('debtmanage/bcp_debt_detail.html', $scope
                ,["$scope",function(dialogScope){
                    dialogScope.billForm = $common.copy($scope.otherform);
                    //billsNo，凭证编号，billsDate，应收账款日期，debtEnd，应收账款到期日，deadline，最迟付款日，billsAmountView，票面金额，billsAmount，有效金额
                    //billsDate.setDate(billsDate.getDate()+parseInt(value));获得的时间参数的加值,aging:aging,//账期  gracePeriod:gracePeriod,//宽限期
                    //凭证编号重复录入检验（页面凭证编号离焦事件，这里只是对应页面上的，后台还要校验。
                    dialogScope.billsNo_onBlur=function(){//凭证编号到前台查重
                        if(flag != "update"){
                            if(dialogScope.billForm.billsNo != ""){
                                var datasource = $scope.datasource.ds;//取到前台table的数据，如果为空，直接过，没有则需要遍历对比判断。
                                if(datasource != ""){
                                    for(var k in datasource){
                                        if(datasource[k].billsNo == dialogScope.billForm.billsNo ){
                                            $common.get_tipDialog("该凭证编号已存在!",'showError');
                                        }
                                    }
                                }
                            }
                        }
                    };

                    var date=new Date();
                    var y = date.getFullYear();
                    var m = date.getMonth() + 1;
                    var d = date.getDate();
                    if(m < 10){
                        m = "0" + m;
                    }
                    if(d < 10){
                        d = "0" + d;
                    }
                    var sysDate="" + y + m + d;//当前日期s
                    var sysDate1=parseFloat(sysDate);
                    //应收账款日期离焦之后，将对应的应收账款到期日，最迟付款日自动填充

                    var debtEnd;
                    var endDate;
                    var billsDate;
                    dialogScope.billsDate_onBlur=function(){
                        if(dialogScope.billForm.billsDate != ""){
                            //应收账款到期日=应收账款日期+账期
                            billsDate=dialogScope.billForm.billsDate;
                            var dateMilli=new Date(billsDate.replace(/^(\d{4})(\d{2})(\d{2})$/,'$1/$2/$3')).getTime();
                            var dayMilli=(dialogScope.billForm.aging)*24*60*60*1000;
                            var dateMilliAndDayMilli=dateMilli+dayMilli;
                            var date = new Date(dateMilliAndDayMilli);
                            var y = date.getFullYear();
                            var m = date.getMonth() + 1;
                            var d = date.getDate();
                            if(m < 10){
                                m = "0" + m;
                            }
                            if(d < 10){
                                d = "0" + d;
                            }
                            dialogScope.billForm.debtEnd="" + y + m + d;
                            debtEnd=parseFloat(dialogScope.billForm.debtEnd);//应收账款到期日
                            endDate=parseFloat(dialogScope.billForm.endDate);//合同到期日
                            //最迟付款日=应收账款日期+账期+宽限期
                            var dateMilliAndDayMilli2=dateMilliAndDayMilli+(dialogScope.billForm.gracePeriod)*24*60*60*1000;
                            var date2 = new Date(dateMilliAndDayMilli2);
                            var y2 = date2.getFullYear();
                            var m2 = date2.getMonth() + 1;
                            var d2 = date2.getDate();
                            if(m2 < 10){
                                m2 = "0" + m2;
                            }
                            if(d2 < 10){
                                d2 = "0" + d2;
                            }
                            dialogScope.billForm.deadline="" + y2 + m2 + d2;
                            dialogScope.$apply();
                        }else{//应收账款日为空，其他两个也是空
                            dialogScope.billForm.debtEnd="";
                            dialogScope.billForm.deadline="";
                            dialogScope.$apply();
                        }
                    };
                    //票面金额填写完毕，会自动复制赋值给有效金额，这里默认将应收账款余额等同于票面金额，三者相等
                    dialogScope.billsAmountView_onBlur=function(){
                        if(dialogScope.billForm.billsAmountView != ""){
                            dialogScope.billForm.billsAmount=dialogScope.billForm.billsAmountView;
                            dialogScope.$apply();
                        }
                    };
                    //当客户修改有效金额，会与票面金额做对比，不可大于票面金额
                    var billsAmount;
                    var billsAmountView;
                    dialogScope.billsAmount_onBlur=function(){
                        if(dialogScope.billForm.billsAmount != ""){
                            billsAmount =parseFloat(dialogScope.billForm.billsAmount);//有效金额
                            billsAmountView=parseFloat(dialogScope.billForm.billsAmountView) ;//票面金额
                            if(billsAmount > billsAmountView){
                                $common.get_tipDialog("应收账款有效金额不能大于票面金额！",'showError');
                            }else{
                                dialogScope.billForm.remainingAmount=dialogScope.billForm.billsAmount;
                            }
                        }
                    };
                    //页面规则校验
                    var errorflag=false;
                    var errorMessage="";
                    function checkFormRule(){
                        // 页面存在三个教校验规则
                        //1.凭证编号查重
                        var datasource = $scope.datasource.ds;//取到前台table的数据，如果为空，直接过，没有则需要遍历对比判断。
                        for(var k in datasource){
                            if(datasource[k].billsNo == dialogScope.billForm.billsNo ){
                                errorflag=true;
                                errorMessage=errorMessage+"该凭证编号已存在!";
                            }
                        }

                        //2.日期
                        if(!errorflag){
                            if(billsDate>sysDate1){
                                errorflag=true;
                                errorMessage=errorMessage+"应收账款日期须小于等于当前日期！" ;
                            }else{
                                if(endDate < debtEnd){
                                    errorflag=true;
                                    errorMessage=errorMessage+"应收账款到期日须小于等于合同到期日！" ;
                                }else{
                                    if(debtEnd <= sysDate1){
                                        errorflag=true;
                                        errorMessage=errorMessage+"应收账款到期日须大于当前日期！" ;
                                    }
                                }
                            }
                        }
                        //3.金额
                        if(billsAmount > billsAmountView){
                            errorflag=true;
                            errorMessage=errorMessage+"应收账款有效金额不能大于票面金额！" ;
                        }else{
                            dialogScope.billForm.remainingAmount=dialogScope.billForm.billsAmount;
                            var loanPercent=parseFloat(dialogScope.billForm.loanPercent);
                            dialogScope.billForm.remainingUseableAmount=parseFloat(dialogScope.billForm.billsAmount)*loanPercent/100;
                        }
                    }
                    //点击确定，将对应的值插入前一个页面的table中
                    dialogScope.confirm_onClick=function(){
                        if($.doValidate("billForm")){
                            //如果是修改，则需要将对应页面的那条先删除，再新增
                            checkFormRule();
                            if(errorflag){
                                $common.get_tipDialog(errorMessage,'showError');
                                errorflag=false;
                                errorMessage="";
                            }else{
                                $common.get_asyncData("rbcpDebtInfoService/addRBcpDebtInfo",{rBcpDebtInfoVO:dialogScope.billForm}).then(function(res){
                                    if (res.errorCode =="SUC"){
                                        $common.get_tipDialog('保存成功！','showSuccess');
                                        $scope.queryTable();
                                        dialogScope.closeThisDialog();
                                        $scope.selected.select = [];
                                    }else{
                                        $common.get_tipDialog(res.errorMsg,'showError');
                                    }
                                });
                            }
                        }
                    };
                    dialogScope.closeThisDialog_onClick = function(){
                        dialogScope.closeThisDialog();
                    };
                }],"凭证信息编辑",{showClose:true});
        }
    };

    //应收账款凭据信息删除操作
    $scope.delete_onClick = function(){
        if($scope.selected.select.length >= 1){
            $common.get_tipDialog('确定删除此记录？','showTip').then(function(){
                $common.get_asyncData("rbcpDebtInfoService/deleteRBcpDebtInfo",{list:$scope.selected.select}).then(function(res){
                    if (res.errorCode =="SUC"){
                        $common.get_tipDialog('删除成功！','showSuccess');
                        $scope.queryTable();
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            });
        }else{
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }
    };

    //应收账款单据信息修改操作
    $scope.update_onClick = function(){
        if($scope.selected.select.length == 1){
            if($scope.selected.select.length == 1){
                if($scope.selected.select[0].isLocked == "0"){
                    if($scope.selected.select[0].status == "01"){
                        var data1= {
                            baseinfo:$scope.otherform,
                            flag:"contupdate",
                            rBcpDebtInfo:$scope.selected.select[0]
                        };
                        dataDeliver.setter(data1);
                        $state.go("debtedit");
                    }else{
                        $common.get_tipDialog('该记录发票状态不为“已录入”，不可修改！','showInform');
                    }
                }else{
                    $common.get_tipDialog('该信息已被锁定，无法修改！','showInform')
                }
            }else{
                $common.get_tipDialog('请选择一条记录！','showInform');
            }
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };

    $scope.validate_onClick = function()
    {
        if($scope.selected.select.length == 1){
            var row = $scope.selected.select[0];
            if(row.contStatus=="1")
            {
                $common.get_tipDialog('该合同已生效！','showInform');
                return;
            }
            row.contStatus = "1";
            $common.get_asyncData("rbcpDebtInfoService/setContStatus",{rBcpDebtInfoVO:row}).then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('已生效！','showSuccess');
                    $scope.queryTable();
                    $scope.selected.select = [];
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
    //应收账款历程信息
    $scope.progress_onClick = function(){
        if($scope.selected.select.length == 1){
            var data1= {
                baseinfo:$scope.otherform,
                rBcpDebtInfo:$scope.selected.select[0],
                flag:"contview"
            };
            dataDeliver.setter(data1);
            $state.go("progress");
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };

    //返回按钮
    $scope.back_onClick = function()
    {
        var url = "bcpInfoList";
        if(flag=="cont")
        {
            url = "list";
        }
        $state.go(url);//返回首页面
    }
};




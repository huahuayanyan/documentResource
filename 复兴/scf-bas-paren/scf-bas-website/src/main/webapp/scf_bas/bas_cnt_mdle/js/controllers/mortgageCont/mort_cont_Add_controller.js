/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/29
 */

var mortgageContAddController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    var dataX=dataDeliver.getter();
    $scope.otherform={};
    if(dataX.flag=="add"){
        $scope.otherform.conStat="1";//默认为有效合同
        $scope.otherform.gutCurcd="CNY";//币种默认为人名币
        $scope.otherform.vidPrdId="1210020";//业务品种默认值
    }else if(dataX.flag=="update"){
       findFormInfo();
        //$scope.otherform=dataX.protocol;
        $scope.update=true;
    }else if(dataX.flag=="view"){
        findFormInfo();
        //$scope.otherform=dataX.protocol;
        $scope.view=true;
        $scope.update=true;
        $scope.isPrtclNo=true;
    }
    if(dataX && dataX.protocol && dataX.protocol.prtclNo){
    	$scope.isPrtclNo=true;
    }
    //页面信息实时查询加载
    function findFormInfo(){
        var data= {
            pageNo: 1,
            pageSize: 10,
            bCrrGntyCon:{conId:dataX.protocol.conId}
        };
        var promise = $common.get_asyncData("bCrrGntyConService/getSlaveContList",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                if(data.records[0]){
                    $scope.otherform = data.records[0];
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }

    //--------------押品信息表初始化-------------
    $scope.datasourcemort={//初始化表格对象
        ds: []
    };
    $scope.selectedmort={//初始化对象
        select: []
    };
    $scope.confmort= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    $scope.$watch("otherform.conId",function() {
        $scope.queryTablemort();
    });
    $scope.queryTablemort = function(paramData){
        var data= {
            pageNo: $scope.confmort.pageNo,
            pageSize: $scope.confmort.pageSize,
            value:{ slaveContno:$scope.otherform.conId},
        };
        var promise = $common.get_asyncData("bCntSlaveMtgRelService/findBPbcMtgClassForMortage",data);
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

    //----------------合同下保险列表初始化----------------
    $scope.datasourceins={//初始化表格对象
        ds: []
    };
    $scope.selectedins={//初始化对象
        select: []
    };
    $scope.confins= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    $scope.$watch("otherform.conId",function() {
        $scope.queryTableins();
    });
    $scope.queryTableins = function(paramData){
        var data= {
            pageNo: $scope.confins.pageNo,
            pageSize: $scope.confins.pageSize,
            value:{ slaveContno:$scope.otherform.conId},
        };
        var promise = $common.get_asyncData("bCntInsuranceBaseInfoService/findBCntInsuranceBaseInfoByContNo",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasourceins.ds = data.records;
                $scope.confins.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //------------------业务品种---------------
    $scope.selectSource = {
        ds:[{key:"1210020",value:'先票/款后货'},]
    };
    //经办机构，客户经理页面数据赋值
    var bCrmBrInfo={};
    var primiseB = $common.get_asyncData("bCrmBaseInfoService/findBCrmBrInfo",{bCrmBrInfo:bCrmBrInfo});
    primiseB.then(function(res1){
        if (res1.errorCode =="SUC") {
            $scope.otherform.brNm=res1.contextData.brName;
            $scope.otherform.brcode=res1.contextData.brNo;
        }else{
            $common.get_tipDialog(res1.errorMsg,'showError');
        }
    });
    $scope.otherform.tlrNm=userInfo.tlrName;
    /**
     * 监管合同筛选开始
     */
    $scope.prtclNoContent = {
        type:"table",//展示类型table  tree
        url:"bCrrGntyConService/queryMonitorProtocolListByPageForGntyCon",
        param:{productId:$scope.otherform.vidPrdId},
        split:"-",//分隔符
        extentColumn:"protocolNo",
        column:["protocolNo","thrName"]//展示内容
    };
    $scope.prtclNodooextent = function(ds){
        $scope.otherform.prtclNo=ds.protocolNo;//监管合同号
        $scope.otherform.prtclBrNm=ds.thrName; //监管公司名称
        $scope.otherform.gutNm=ds.secName; //出质人名称
        $scope.otherform.gutId=ds.secCd; //出质人
    };
    $scope.$watch("otherform.prtclNo",function(newVal,oldVal){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.prtclNoContent.param ={
            productId:$scope.otherform.vidPrdId,
            protocolCode:$scope.otherform.prtclNo,
            state:"1"//查询有效的监管合同
        };
    });

    //------------------------------押品信息新增删除---------------------------------------
    $scope.addmort_onClick = function(){
        $common.get_ngDialog('bcrrlncon/mort_edit.html', $scope,["$scope",function(dialogScope){
            dialogScope.mort = {};
        // 押品一级
            dialogScope.levelOneContent = {
                type:"table",//展示类型table  tree
                url:"bPbcMtgClassService/findBPbcMtgClassForTwoLevelSelect",
                //param:{levels:"1"},    //应收账款融资
                //split:"",//分隔符
                extentColumn:"mortgageName",
                column:["mortgageName"]//展示内容
            };
            dialogScope.levelOnedooextent = function(ds){
                dialogScope.mort.mortgageLevelOne=ds.mortgageCode;
                dialogScope.mort.mortgageLevelOneNm=ds.mortgageName;
                dialogScope.mort.parentCode = ds.mortgageCode;
                if(dialogScope.mort.mortgageLevelTwo){
                    dialogScope.mort.mortgageLevelTwo=null;
                    dialogScope.mort.mortgageLevelTwoNm="";
                }
                dialogScope.levelTwoContent.param ={
                    levels:"2",
                    parentCode:dialogScope.mort.parentCode
                }
            };
            dialogScope.$watch("mort.mortgageLevelOneNm",function(newVal,oldVal){
                dialogScope.levelOneContent.param ={
                    levels:"1",
                    mortgageName:dialogScope.mort.mortgageLevelOneNm
                };
            });
            //押品二级
            dialogScope.levelTwoContent = {
                type:"table",//展示类型table  tree
                url:"bPbcMtgClassService/findBPbcMtgClassForTwoLevelSelect",
                //param:{levels:"2",parentCode:dialogScope.mort.mortgageLevelOne},
                //split:"",//分隔符
                extentColumn:"mortgageName",
                column:["mortgageName"]//展示内容
            };
            dialogScope.levelTwodooextent = function(ds){
                dialogScope.mort.mortgageLevelTwo=ds.mortgageCode;
                dialogScope.mort.mortgageLevelTwoNm=ds.mortgageName;
            };
            dialogScope.$watch("mort.mortgageLevelTwoNm",function(newVal,oldVal){
                dialogScope.levelTwoContent.param ={
                    levels:"2",
                    parentCode:dialogScope.mort.mortgageLevelOne,
                    mortgageName:dialogScope.mort.mortgageLevelTwoNm,
                };
            });
            //页面下拉菜单押品名称和押品号一致问题
            function checkInfoForSelect(){
                if(!dialogScope.mort.mortgageLevelOne){
                    $common.get_tipDialog('一级押品押品号与押品名称不一致，请通过查询按钮选择一级押品！','showInform');
                }
                if(!dialogScope.mort.mortgageLevelTwo){
                    $common.get_tipDialog('二级押品押品号与押品名称不一致，请通过查询按钮选择二级押品！','showInform');
                }
                var bPbcMtgClassVO1={
                    mortgageCode:dialogScope.mort.mortgageLevelOne,
                    mortgageName:dialogScope.mort.mortgageLevelOneNm,
                }
                var primise = $common.get_asyncData('bPbcMtgClassService/checkInfoForSelect',{bPbcMtgClassVO:bPbcMtgClassVO1});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        if(parseFloat(res.contextData.value)==1){
                            var bPbcMtgClassVO2={
                                mortgageCode:dialogScope.mort.mortgageLevelTwo,
                                mortgageName:dialogScope.mort.mortgageLevelTwoNm,
                            }
                            var primise = $common.get_asyncData('bPbcMtgClassService/checkInfoForSelect',{bPbcMtgClassVO:bPbcMtgClassVO2});
                            primise.then(function(res){
                                if (res.errorCode =="SUC"){
                                    if(parseFloat(res.contextData.value)!=1){
                                        $common.get_tipDialog('二级押品押品号与押品名称不一致，请通过查询按钮选择二级押品！','showInform');
                                    }
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                }
                            });
                        }else{
                            $common.get_tipDialog('一级押品押品号与押品名称不一致，请通过查询按钮选择一级押品！','showInform');
                        }
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            }
            dialogScope.mortConfirm_onClick = function() {
                if($.doValidate("mort")) {
                    checkInfoForSelect();
                    for(var x in $scope.datasourcemort.ds ){
                        if(dialogScope.mort.mortgageLevelOneNm == $scope.datasourcemort.ds[x].mortgageLevelOneNm
                            && dialogScope.mort.mortgageLevelTwoNm== $scope.datasourcemort.ds[x].mortgageLevelTwoNm){
                            $common.get_tipDialog('该押品信息已存在，不可新增！','showInform');
                            return ;
                        }
                    }
                    var mort= $common.copy(dialogScope.mort);
                    if( !$scope.datasourcemort.ds){
                        $scope.datasourcemort.ds=[];
                    }
                    $scope.datasourcemort.ds.push(mort);
                    $scope.confmort.totalRecord=$scope.datasourcemort.ds.length;
                    dialogScope.closeThisDialog();
                };
            };
            dialogScope.mortCloseDialog_onClick = function(){
                dialogScope.closeThisDialog();
            };
        }],"押品信息新增",{showClose:true});
    };
    $scope.deletemort_onClick = function(){
        if($scope.selectedmort.select.length <= 0){
            $common.get_tipDialog('请至少选择一条押品信息！','showInform');
        }else{
            $common.get_tipDialog('确定删除吗？','showTip').then(function() {
                var list=$scope.selectedmort.select;
                var data=$scope.datasourcemort.ds;
                for(var x in list){
                    for(var y = 0; y< data.length; y++){
                        if(list[x].mortgageLevelOne== data[y].mortgageLevelOne
                            &&list[x].mortgageLevelTwo==data[y].mortgageLevelTwo){
                            $scope.datasourcemort.ds.splice(y,1);
                            $scope.selectedmort.select=[];
                        }
                    }
                }
                $scope.$apply();
                $scope.confmort.totalRecord=$scope.datasourcemort.ds.length;
            });
        }
    };
    //------------------------------合同下保险列表新增删除---------------------------------
    $scope.addins_onClick=function(){
        $common.get_ngDialog('bcrrlncon/insurance_edit.html', $scope,["$scope",function(dialogScope){
            dialogScope.ins={};
            var errorFlag=true;
            function checkFormRuleForIns(){
                // ins.insuranceCode 100
                if(dialogScope.ins.insuranceCode.length > 100){
                    $common.get_tipDialog('[保单号]长度不可超过100位！','showInform');
                    errorFlag=false;
                    return ;
                }
                //ins.insuranceName 120  保险公司名称
                if(dialogScope.ins.insuranceName.length > 120){
                    $common.get_tipDialog('[保险公司名称]长度不可超过40个字！','showInform');
                    errorFlag=false;
                    return ;
                }
                //ins.insuranceType 100 保险类型
                if(dialogScope.ins.insuranceType.length > 100){
                    $common.get_tipDialog('[保险类型]长度不可超过33个字！','showInform');
                    errorFlag=false;
                    return ;
                }
                //ins.beneficiary 100 受益人
                if(dialogScope.ins.beneficiary.length > 100){
                    $common.get_tipDialog('[受益人]长度不可超过33个字！','showInform');
                    errorFlag=false;
                    return ;
                }
                //ins.amount  22 保险金额
                if(dialogScope.ins.amount.length > 22){
                    $common.get_tipDialog('[保险金额]长度不可超过20位！','showInform');
                    errorFlag=false;
                    return ;
                }
                //[保险到期日]不能早于[当前日期]
                var endDate=parseFloat(dialogScope.ins.endDate);
                if(endDate < sysDate){
                    $common.get_tipDialog('[保险到期日]不能早于[当前日期]！', 'showInform');
                    errorFlag=false;
                    return false;
                }
            }
            dialogScope.insConfirm_onClick = function(){
                if($.doValidate("ins")) {
                    for(var x in $scope.datasourceins.ds){
                        if($scope.datasourceins.ds[x].insuranceCode == dialogScope.ins.insuranceCode){
                            $common.get_tipDialog('[保单号]已存在，不可新增！','showInform');
                            return ;
                        }
                    }
                    checkFormRuleForIns();
                    if(errorFlag){
                        var ins= $common.copy(dialogScope.ins);
                        if(!$scope.datasourceins.ds){
                            $scope.datasourceins.ds=[];
                        }
                        $scope.datasourceins.ds.push(ins);
                        $scope.confins.totalRecord=$scope.datasourceins.ds.length;
                        dialogScope.closeThisDialog();
                    }else{
                        errorFlag=true;
                    }
                }
            }
            dialogScope.insCloseDialog_onClick = function(){
                dialogScope.closeThisDialog();
            };
        }],"合同下保险信息新增",{showClose:true});

    }
    $scope.deleteins_onClick = function(){
        if($scope.selectedins.select.length <= 0){
            $common.get_tipDialog('请至少选择一条合同下保险信息！','showInform');
        }else{
            $common.get_tipDialog('确定删除吗？','showTip').then(function() {
                var list=$scope.selectedins.select;
                var data=$scope.datasourceins.ds;
                for(var x in list){
                    for(var y = 0; y< data.length; y++){
                        if(list[x].insuranceCode== data[y].insuranceCode){
                            $scope.datasourceins.ds.splice(y,1);
                            $scope.selectedins.select=[];
                        }
                    }
                }
                $scope.$apply();
                $scope.confins.totalRecord=$scope.datasourceins.ds.length;
            });
        }
    };

    //系统当前日期
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
    $scope.otherform.sysDate="" + y + m + d;
    var sysDate=parseFloat($scope.otherform.sysDate);//当前日期

    var errorFlag=true;//true为没有错误可以调用新增修改方法
    //页面规则校验
    function checkFormRules(){
        //ration 抵/质押率
        if(!(/^(\d{1,2}(\.\d{1,2})?|99)$/.test($scope.otherform.ration))){
            $common.get_tipDialog('[抵/质押率]范围为[0，99%]！', 'showInform');
            errorFlag=false;
            return false;
        }
        //guardRat 市值抵/质押率警戒线
        if(!(/^(\d{1,2}(\.\d{1,2})?|100)$/.test($scope.otherform.guardRat))){
            $common.get_tipDialog('[市值抵/质押率警戒线]范围为[0，100%]！', 'showInform');
            errorFlag=false;
            return false;
        }
        //[协议到期日期]不能早于[当前日期]
        var endDate=parseFloat($scope.otherform.endDt);
        if(endDate < sysDate){
            $common.get_tipDialog('[合同到期日]不能早于[当前日期]！', 'showInform');
            errorFlag=false;
            return false;
        }

        //校验输入长度
        if($scope.otherform.gutVal && $scope.otherform.gutVal.length > 0){
            var gutVal = $scope.otherform.gutVal;
            if(parseFloat(gutVal) < 0){
                $common.get_tipDialog('[合同金额]不能小于零！','showError');
                errorFlag=false;
                return false;
            }
            if( gutVal.length>20) {
                $common.get_tipDialog('[合同金额]不可超过20位！','showError');
                errorFlag=false;
                return false;
            }
        }
    }
    //保存/修改操作按钮 otherform.gutNm otherform.prtclBrNm
    $scope.confirm_onClick = function(){
        if($scope.otherform.prtclNo && (!$scope.otherform.gutNm) &&(!$scope.otherform.prtclBrNm)){
            $common.get_tipDialog('请不要通过手写输入监管合同号，请通过查询按钮选择监管合同号！', 'showInform');
            return false;
        }
        if($.doValidate("otherform")) {
            //页面字段规则校验
            checkFormRules();
            if(errorFlag){
            //校验页面监管合同号是否通过查询按钮选择的避免手写
                var data={
                    pageNo: 1,
                    pageSize: 10,
                    value:{
                        productId:$scope.otherform.vidPrdId,
                        protocolCode:$scope.otherform.prtclNo
                    },
                };
                var primiseB = $common.get_asyncData("bCrrGntyConService/queryMonitorProtocolListByPageForGntyCon",data);
                primiseB.then(function(res){
                    if (res.errorCode =="SUC") {
                        if(res.contextData.records[0]){
                            var protocol=res.contextData.records[0];
                            if((protocol.thrName!=$scope.otherform.prtclBrNm) || ($scope.otherform.gutNm != protocol.secName)){
                                $common.get_tipDialog('请不要通过手写输入监管合同号，请通过查询按钮选择监管合同号！', 'showInform');
                            }else{

                                var data1={
                                    bCntSlaveMtgRel:$scope.datasourcemort.ds,
                                    bCntInsuranceBaseInfo:$scope.datasourceins.ds,
                                    bCrrGntyCon:$scope.otherform,
                                }
                                if(dataX.flag == "add"){
                                    var primise = $common.get_asyncData("bCrrGntyConService/addGntyConAndMortAndInsu",data1);
                                }else if (dataX.flag == "update"){
                                    var primise = $common.get_asyncData("bCrrGntyConService/updateGntyConAndMortAndInsu",data1 );
                                }
                                primise.then(function (res) {
                                    if (res.errorCode == "SUC") {
                                        $common.get_tipDialog('保存成功！', 'showSuccess');
                                        $state.go("mortgageContList");
                                    } else {
                                        $common.get_tipDialog(res.errorMsg, 'showError');
                                    }
                                });
                            }
                        }else{
                            $common.get_tipDialog('请不要通过手写输入监管合同号，请通过查询按钮选择监管合同号！', 'showInform');
                        }
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }else{
                errorFlag=true;
            }
        }
    };
    //返回按钮
    $scope.back_onClick = function () {
        $state.go("mortgageContList");
    };
};

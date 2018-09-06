/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      gongzhao
 * @version     1.0
 * Create at:   2017/04/18
 */

var stockAdjustAddController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    var dataX=dataDeliver.getter();
    $scope.otherform={};
    if(dataX.flag=="add"){
    	$scope.otherform = dataX;
        $scope.otherform.curcd="CNY";//币种默认为人名币
    }else if(dataX.flag=="update"){
        $scope.disable=true;
    }else if(dataX.flag=="view"){
        findFormInfo();
        $scope.view=true;
        $scope.update=true;
    }
    
    $scope.mortgageLevelOneSource={
            ds:[]
        };
        
    $scope.mortgageLevelTwoSource= {
            ds: []
        };
    $scope.mortgageLevelThreeSource= {
            ds: []
        };
    mortgageLevelOneSource();

    mortgageLevelTwoSource();
    
    mortgageLevelThreeSource();

    //初始化--------结束------------------------

    //押品等级 ------------开始----------------
    var mortgageCodeOneList = new Array();//拼装押品一级Code
    var mortgageCodeTwoList = new Array();//拼装押品二级Code
    function mortgageLevelOneSource(){
     	//查询一级押品前，先查询该抵质押合同录入的押品信息
     	
         var dataMtg= {
             pageNo: 1,
             pageSize: 10000,
             bCntSlaveMtgRel:{slaveContno:dataX.slaveContno},
             cache:0
         };
         var promiseMtg = $common.get_asyncData("bCntSlaveMtgRelService/findBCntSlaveMtgRelByPage",dataMtg);
         $scope.mortgageLevelOneSource = {};
         promiseMtg.then(function(res){
             var data;
             if (res.errorCode =="SUC"){
                 data = res.contextData;
                 
                 for(var i=0;i<data.records.length;i++){
                 	var mtgModel = data.records[i];
                 	mortgageCodeOneList.push(mtgModel.mortgageLevelOne);
                 	mortgageCodeTwoList.push(mtgModel.mortgageLevelTwo);
                 } 
			        //业务品种下拉框
			        var dataItemsDO = {levels:"1",mortgageCodeList:mortgageCodeOneList};
			        var data = {dataItemsDO:dataItemsDO}
			        var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
			        promise.then(function(res){
			            if (res.errorCode =="SUC"){
			                $scope.mortgageLevelOneSource.ds = res.contextData;
			            }else{
			                $common.get_tipDialog(res.errorMsg,'showInform');
			            }
			        });
             }else{
                 $common.get_tipDialog(res.errorMsg,'showError');
             }
         });
    }
    function mortgageLevelTwoSource(){
        //业务品种下拉框
        var levelOne = $scope.otherform.mortgageLevelOne;
        var dataItemsDO = {mortgageCode:levelOne,mortgageCodeList:mortgageCodeTwoList}
        var data = {dataItemsDO:dataItemsDO};
        $scope.mortgageLevelTwoSource = {};
        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
        primise.then(function(res){
            if(res.errorCode =="SUC"){
                $scope.mortgageLevelTwoSource.ds = res.contextData;
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    }
    
    function mortgageLevelThreeSource(){
        //业务品种下拉框
        var dataItemsDO = {levels:"3"};
        var data = {dataItemsDO:dataItemsDO};
        var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
        $scope.mortgageLevelThreeSource = {};
        promise.then(function(res){
            if (res.errorCode =="SUC"){
            	$scope.mortgageLevelThreeSource.ds = res.contextData;
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    }

    $scope.mortgageLevelOneName = function (val){
        $scope.otherform.mortgageLevelTwo = "";
        if(null != val){
            var dataItemsDO = {mortgageCode:val,mortgageCodeList:mortgageCodeTwoList}
            var data = {dataItemsDO:dataItemsDO};
            var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
            mortgageName.then(function(res){
                if(res.errorCode =="SUC"){
                    $scope.otherform.mortgageLevelOneName = res.contextData.mortgageName;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
            var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
            primise.then(function(res){
                if(res.errorCode =="SUC"){
                    $scope.mortgageLevelTwoSource.ds = res.contextData;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
        }else{
            $scope.mortgageLevelTwoSource.ds = [];
        }
    }


    $scope.mortgageLevelTwoName = function (val){
        $scope.otherform.mortgageLevelThreeSource = "";
        if(null != val){
            var dataItemsDO = {mortgageCode:val}
            var data = {dataItemsDO:dataItemsDO};
            var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
            mortgageName.then(function(res){
                if(res.errorCode =="SUC"){
                    $scope.otherform.mortgageLevelTwoName = res.contextData.mortgageName;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
            var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
            primise.then(function(res){
                if(res.errorCode =="SUC"){
                    $scope.mortgageLevelThreeSource.ds = res.contextData;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
        }else{
            $scope.mortgageLevelThreeSource.ds = [];
        }
    }
    //押品等级 ------------结束----------------
    
    //绑定市价
    $scope.bound_onClick = function(){
    	var data = $scope.otherform;
    	dataDeliver.setter(data);
    	 $state.go("bound");
    }
    
    //取消绑定
    $scope.unBound_onClick = function(){
    	$scope.otherform.fixMortgageNo="";
    	$scope.otherform.marketPrice="";
    	$scope.$apply(
    		)
    }

    //保存
    $scope.save_onClick = function(){
    	if($.doValidate("otherform")) {
    		var bPbcMtgBaseInfoDO = $scope.otherform;
    		bPbcMtgBaseInfoDO.supplyChainPdId="1220020";
            if(dataX.flag == "add"){
                var primise = $common.get_asyncData("bCntStockAdjustService/saveStockAdjust",{bPbcMtgBaseInfoDO: bPbcMtgBaseInfoDO});
            }else if (dataX.flag == "update"){
               
            }
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    $common.get_tipDialog('保存成功！', 'showSuccess');
                    $state.go("list");
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
    	}
    	
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
        if(!(/^(\d{1,2}(\.\d{1,2})?|100)$/.test($scope.otherform.ration))){
            $common.get_tipDialog('[抵/质押率]范围为[0，100%]！', 'showInform');
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
                            if(errorFlag){
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
                            }else{
                                errorFlag=true;
                            }
                        }
                    }else{
                        $common.get_tipDialog('请不要通过手写输入监管合同号，请通过查询按钮选择监管合同号！', 'showInform');
                    }
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };
    
    //返回按钮
    $scope.back_onClick = function () {
        $state.go("list");
    };
};

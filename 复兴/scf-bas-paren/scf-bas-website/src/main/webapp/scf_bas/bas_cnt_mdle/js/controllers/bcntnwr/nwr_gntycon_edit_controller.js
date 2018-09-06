/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var nwrGntyconeditController = function($scope,$common,dataDeliver,$state,$rootScope) {
    $scope.otherform = dataDeliver.getter();
    $scope.row = $scope.otherform.row;
    $scope.cache = "0";
    $scope.productselect = {
        ds:$scope.otherform.productselect.ds
    };
    $scope.row.vidPrdId = $scope.productselect.ds[0].code;
    var flag = $scope.otherform.flag;
    if($scope.row.prtclNo){
    	$scope.isPrtclNo=true;
    }
    if(flag=="view")
    {
    	$scope.isPrtclNo=true;
        $scope.disable = true;
        $scope.hide = true;
    }
    if(flag=="update")
    {
        $scope.disable = false;
        $scope.hide = false;
        $scope.row.rltTyp = "0";//借用rltTyp字段用于判断是否clear押品信息中的listrel;
    }
    /**
     * 担保人名称查询加载开始
     */
    $scope.gutcontent = {
        type:"table",//展示类型table  tree
        url:"bCrrLnAppService/queryCustSource",
        param:{},
        split:",",//分隔符
        extentColumn:"custNm",
        column:["custNm","custId"]//展示内容
    };
    $scope.gutextend = function(ds){
        $scope.row.gutNm = ds.custNm;
        $scope.row.gutId = ds.custId;
        $scope.row.gcrtId = ds.idno;
        $scope.row.gcrtTyp = ds.idtype;
        $scope.number = ds;
    };
    $scope.$watch("row.gutNm",function(){
        if($scope.row.gutNm!=null) $scope.gutcontent.param ={custId:$scope.row.gutNm,custNm:$scope.row.gutNm};
    });
    /**
     * 担保人名称查询加载结束
     */

    /**
     * 监管合同筛选开始
     */
    $scope.prtclNoContent = {
        type:"table",//展示类型table  tree
        url:"bCrrGntyConService/queryMonitorProtocolListByPageForGntyCon",
        param:{productId:$scope.row.vidPrdId},    //应收账款融资
        split:",",//分隔符
        extentColumn:"protocolNo",
        column:["protocolNo","thrName"]//展示内容
    };
    $scope.prtclNodooextent = function(ds){
        $scope.row.prtclNo=ds.protocolNo;//监管合同号
        $scope.row.prtclBrNm=ds.thrName; //监管公司名称
    };
    $scope.$watch("row.prtclNo",function(newVal,oldVal){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.prtclNoContent.param ={
            productId:$scope.row.vidPrdId,
            secName:$scope.row.gutNm,
            protocolCode:$scope.row.prtclNo
        };
    });
    /**
     * 监管合同筛选结束
     */
    $scope.confirm_onClick = function(){
        if($.doValidate("row")) {
            var ration = $scope.row.ration;//抵/质押率（%）
            var guardRat = $scope.row.guardRat;//市值抵/质押率警戒线（%）
            if(ration<0)
            {
                $common.get_tipDialog('“抵/质押率（%）”不能小于零,请重新输入！','showInform');
                return;
            }
            if(guardRat<0)
            {
                $common.get_tipDialog('“市值抵/质押率警戒线（%）”不能小于零,请重新输入！','showInform');
                return;
            }
            $scope.disableconfirm = true;
            var primise = $common.get_asyncData('bCrrGntyConService/update',{bCrrGntyCon:$scope.row});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $state.go("list");
                    $common.get_tipDialog('保存成功！','showSuccess');
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    };
    /**
     * 押品信息
     * @type {{ds: Array}}
     */
    $scope.mortForm = {};
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
    $scope.$watch("confmort.pageNo+confmort.pageSize",function() {
        $scope.queryTablemort();
    });
    $scope.queryTablemort = function(paramData){
        $scope.mortForm.slaveContno = $scope.row.conId;
        var data= {
            pageNo: $scope.confmort.pageNo,
            pageSize: $scope.confmort.pageSize,
            bCntSlaveMtgRel:$scope.mortForm,
            cache:$scope.cache
        };
        var promise = $common.get_asyncData("bCntSlaveMtgRelService/findBCntSlaveMtgRelByPage",data);
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
    $scope.addmort_onClick = function(){
        if($.doValidate("row")) {
            $common.get_ngDialog('bcrrlncon/mort_edit.html', $scope,["$scope",function(dialogScope){
                dialogScope.mort = {};
                dialogScope.mort.slaveContno = $scope.row.conId;
                /**
                 * 押品一级筛选开始
                 */
                dialogScope.levelOneContent = {
                    type:"table",//展示类型table  tree
                    url:"bCntSlaveMtgRelService/findBPbcMtgClassByPage",
                    param:{levels:"1"},    //应收账款融资
                    split:",",//分隔符
                    extentColumn:"mortgageCode",
                    column:["mortgageName"]//展示内容
                };
                dialogScope.levelOnedooextent = function(ds){
                    dialogScope.mort.mortgageLevelOne=ds.mortgageCode;//监管合同号
                    dialogScope.mort.mortgageLevelOneNm=ds.mortgageName; //监管公司名称
                    dialogScope.mort.parentCode = ds.mortgageCode;
                    dialogScope.levelTwoContent.param = {
                        levels:"2",
                        parentCode:dialogScope.mort.mortgageLevelOne
                    }
                };
                dialogScope.$watch("mort.mortgageLevelOne",function(newVal,oldVal){
                    //ht-input-extent  需要用监听的方式来传额外的参数
                    if(dialogScope.mort.mortgageLevelOne!=null)
                        dialogScope.levelOneContent.param ={
                            mortgageCode:dialogScope.mort.mortgageLevelOne
                        };
                });
                /**
                 * 押品一级筛选结束
                 */
                /**
                 * 押品二级筛选开始
                 */
                dialogScope.levelTwoContent = {
                    type:"table",//展示类型table  tree
                    url:"bCntSlaveMtgRelService/findBPbcMtgClassByPage",
                    param:{levels:"2",parentCode:dialogScope.mort.mortgageLevelOne},
                    split:",",//分隔符
                    extentColumn:"mortgageCode",
                    column:["mortgageName"]//展示内容
                };
                dialogScope.levelTwodooextent = function(ds){
                    dialogScope.mort.mortgageLevelTwo=ds.mortgageCode;//监管合同号
                    dialogScope.mort.mortgageLevelTwoNm=ds.mortgageName; //监管公司名称
                };
                dialogScope.$watch("mort.mortgageLevelTwo",function(newVal,oldVal){
                    //ht-input-extent  需要用监听的方式来传额外的参数
                    if(dialogScope.mort.mortgageLevelTwo!=null)
                        dialogScope.levelTwoContent.param ={
                            //levels:"2",
                            //parentCode:dialogScope.mort.mortgageLevelOne,
                            mortgageCode:dialogScope.mort.mortgageLevelTwo
                        };
                });
                /**
                 * 押品二级筛选结束
                 */
                dialogScope.mortConfirm_onClick = function()
                {
                    if($.doValidate("mort")) {
                        dialogScope.flowsubmitdisable = true;
                        var primise = $common.get_asyncData('bCntSlaveMtgRelService/cacheAdd',{bCntSlaveMtgRel:dialogScope.mort});
                        primise.then(function(res){
                            if (res.errorCode =="SUC"){
                                dialogScope.closeThisDialog();
                                $scope.cache = "1";
                                $scope.queryTablemort();
                                //$common.get_tipDialog('保存成功！','showSuccess');
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            };
                        });
                    };
                };
                dialogScope.mortCloseDialog_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }],"押品信息新增")
        }
    };
    $scope.deletemort_onClick = function(){
        if($scope.selectedmort.select.length <= 0){
            $common.get_tipDialog('请至少选择一条押品信息！','showInform');
        }else{
            var primise = $common.get_asyncData('bCntSlaveMtgRelService/batchDelete',{list:$scope.selectedmort.select});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $scope.cache = "1";
                    $scope.queryTablemort();
                    //$common.get_tipDialog('删除成功！','showSuccess');
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        }
    };
    /**
     * 质押合同保险单信息
     * @type {{ds: Array}}
     */
    $scope.insForm = {};
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
    $scope.$watch("confins.pageNo+confins.pageSize",function() {
        $scope.queryTableins();
    });
    $scope.queryTableins = function(paramData){
        $scope.insForm.slaveContno = $scope.row.conId;
        var data= {
            pageNo: $scope.confins.pageNo,
            pageSize: $scope.confins.pageSize,
            bCntInsBaseInfo:$scope.insForm,
            cache:$scope.cache
        };
        var promise = $common.get_asyncData("bCntInsuranceBaseInfoService/findBCntInsuranceBaseInfoByPage",data);
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
    $scope.addins_onClick = function(){
        if($.doValidate("row")) {
            $common.get_ngDialog('bcrrlncon/insurance_edit.html', $scope,["$scope",function(dialogScope){
                dialogScope.ins = {};
                dialogScope.ins.slaveContno = $scope.row.conId;
                dialogScope.insConfirm_onClick = function()
                {
                    if($.doValidate("ins")) {
                        var realinsuranceCodeLen = 0;
                        var insuranceCode = dialogScope.ins.insuranceCode;//保单号
                        var insuranceCodelen = insuranceCode.length;
                        var insuranceCodecharCode = -1;
                        for(var i=0;i<insuranceCodelen;i++)
                        {
                            insuranceCodecharCode = insuranceCode.charCodeAt(i);
                            if(insuranceCodecharCode>=0&&insuranceCodecharCode<=128)
                            {
                                realinsuranceCodeLen += 1;
                            }
                            else
                            {
                                realinsuranceCodeLen += 3;
                            }
                        }
                        if(realinsuranceCodeLen>100)
                        {
                            $common.get_tipDialog('“保单号”长度超过限值，请重新输入……','showError');
                            return;
                        }
                        var realinsuranceNameLen = 0;
                        var insuranceName = dialogScope.ins.insuranceName;//保险公司名称
                        var insuranceNamelen = insuranceName.length;
                        var insuranceNamecharCode = -1;
                        for(var i=0;i<insuranceNamelen;i++)
                        {
                            insuranceNamecharCode = insuranceName.charCodeAt(i);
                            if(insuranceNamecharCode>=0&&insuranceNamecharCode<=128)
                            {
                                realinsuranceNameLen += 1;
                            }
                            else
                            {
                                realinsuranceNameLen += 3;
                            }
                        }
                        if(realinsuranceNameLen>120)
                        {
                            $common.get_tipDialog('“保险公司名称”长度超过限值，请重新输入……','showError');
                            return;
                        }
                        var realinsuranceTypeLen = 0;
                        var insuranceType = dialogScope.ins.insuranceType;//保险类型
                        var insuranceTypelen = insuranceType.length;
                        var insuranceTypecharCode = -1;
                        for(var i=0;i<insuranceTypelen;i++)
                        {
                            insuranceTypecharCode = insuranceType.charCodeAt(i);
                            if(insuranceTypecharCode>=0&&insuranceTypecharCode<=128)
                            {
                                realinsuranceTypeLen += 1;
                            }
                            else
                            {
                                realinsuranceTypeLen += 3;
                            }
                        }
                        if(realinsuranceTypeLen>100)
                        {
                            $common.get_tipDialog('“保险类型”长度超过限值，请重新输入……','showError');
                            return;
                        }
                        var realbeneficiaryLen = 0;
                        var beneficiary = dialogScope.ins.beneficiary;//受益人
                        var beneficiarylen = beneficiary.length;
                        var beneficiarycharCode = -1;
                        for(var i=0;i<beneficiarylen;i++)
                        {
                            beneficiarycharCode = beneficiary.charCodeAt(i);
                            if(beneficiarycharCode>=0&&beneficiarycharCode<=128)
                            {
                                realbeneficiaryLen += 1;
                            }
                            else
                            {
                                realbeneficiaryLen += 3;
                            }
                        }
                        if(realbeneficiaryLen>100)
                        {
                            $common.get_tipDialog('“受益人”长度超过限值，请重新输入……','showError');
                            return;
                        }
                        dialogScope.flowsubmitdisable = true;
                        var primise = $common.get_asyncData('bCntInsuranceBaseInfoService/cacheAdd',{bCntInsBaseInfo:dialogScope.ins});
                        primise.then(function(res){
                            if (res.errorCode =="SUC"){
                                dialogScope.closeThisDialog();
                                $scope.cache = "1";
                                $scope.queryTableins();
                                //$common.get_tipDialog('保存成功！','showSuccess');
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            };
                        });
                    };
                };
                dialogScope.insCloseDialog_onClick = function(){
                    dialogScope.closeThisDialog();
                };
            }])
        }
    };
    $scope.deleteins_onClick = function(){
        if($scope.selectedins.select.length <= 0){
            $common.get_tipDialog('请至少选择一条合同下保险信息！','showInform');
        }else{
            var primise = $common.get_asyncData('bCntInsuranceBaseInfoService/batchDelete',{list:$scope.selectedins.select});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $scope.cache = "1";
                    $scope.queryTableins();
                    //$common.get_tipDialog('删除成功！','showSuccess');
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        }
    };
    $scope.closeThisDialog_onClick = function(){
        $state.go("list");
    };
};

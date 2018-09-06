var conInfoTab2Controller = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    /**合同基本信息 开始**/
    $scope.otherform={};
    $scope.selectbrNo={}; //机构
    var  bData =dataDeliver.getter();
    queryBCntDebtInfo();
//根据合同编号加载应收账款合同信息
    function queryBCntDebtInfo(){
        var data ={
            debtContVO:{debtContno:bData.debtContno}
        };
        var promise=$common.get_asyncData("bCntDebtInfoService/queryBCntDebtInfoByContno",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.otherform=data;
                $scope.selectbrNo.ds =data.listBctl;
                $scope.otherform.brNo=data.brcode;
                $scope.otherform.serviceContent=JSON.parse(data.serviceContent);
                $scope.otherform.loanWay=JSON.parse(data.loanWay);
                if( $scope.otherform.chargeType=="02"){ //单笔
                    findCostInfoList();
                }
                queryDebtExtInfo();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
//卖方名称筛选
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
            custType:"1", //法人
            cname:$scope.otherform.cname,
            creditFlag:"1" //授信客户
        };
        //结算账户参数
        $scope.accountNoContent.param ={
            accountNo:$scope.otherform.accountNo,
            custcd:$scope.otherform.custcd,   //客户
            accountType:"1"  //客户结算账户
        };
        //回款账户参数
        $scope.returnAccountContent.param ={
            accountNo:$scope.otherform.returnAccount,
            custcd:$scope.otherform.custcd,   //客户
            accountType:"2"  //回款专户
        };
        //保证金账号参数
        $scope.bailAcctNoContent.param ={
            accountNo:$scope.otherform.bailAcctNo,
            custcd:$scope.otherform.custcd,   //客户
            accountType:"3"  //保证金账户
        };
        //
    });
    /**
     * 业务品种筛选
     */
    $scope.productNameContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBusinessType",
        param:{ factType:"1" },    //应收账款融资
        split:",",//分隔符
        extentColumn:"productName",
        column:["productName","productId"]//展示内容
    };
    $scope.productNamedooextent = function(ds){
        $scope.otherform.productName=ds.productName;
        $scope.otherform.supplyChainPdId=ds.productId; //业务品种
        $scope.otherform.factType=ds.factType;
        $scope.otherform.financingType=ds.financingType;
    };
    $scope.$watch("otherform.productName",function(newVal,oldVal){
        // if($scope.otherform.bussTypeName!=null){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.productNameContent.param ={
            productName:$scope.otherform.productName,
            //productId:$scope.otherform.supplyChainPdId,
            tFactType:"2"  //应收账款池融资
        };
        // }
    });

//结算账号筛选
    $scope.accountNoContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectAccountNo",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"accountNo",
        column:["accountNo"]//展示内容
    };
    $scope.accountNodooextent = function(ds){
        $scope.otherform.accountNo=ds.accountNo;
        $scope.otherform.ID=ds.ID;
    };
    //todo 筛选前的校验
    $scope.$watch("otherform.accountNo",function(){
        //if($scope.otherform.accountNo!=null){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.accountNoContent.param ={
            accountNo:$scope.otherform.accountNo,
            custcd:$scope.otherform.custcd,   //客户
            accountType:"1"  //客户结算账户
        };
        //}
    });

    //回款专户筛选
    $scope.returnAccountContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectAccountNo",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"accountNo",
        column:["accountNo"]//展示内容
    };
    $scope.returnAccountdooextent = function(ds){
        $scope.otherform.returnAccount=ds.accountNo;
        //  $scope.otherform.ID=ds.ID;
    };
    //todo 筛选前的校验
    $scope.$watch("otherform.returnAccount",function(){
        //if($scope.otherform.returnAccount!=null){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.returnAccountContent.param ={
            accountNo:$scope.otherform.returnAccount,
            custcd:$scope.otherform.custcd,   //客户
            accountType:"2"  //回款专户
        };
        //}
    });

    //回款保证金账号
    $scope.bailAcctNoContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectAccountNo",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"accountNo",
        column:["accountNo"]//展示内容
    };
    $scope.bailAcctNodooextent = function(ds){
        $scope.otherform.bailAcctNo=ds.accountNo;
        //  $scope.otherform.ID=ds.ID;
    };
    //todo 筛选前的校验
    $scope.$watch("otherform.bailAcctNo",function(){
        //if($scope.otherform.accountNo!=null){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.bailAcctNoContent.param ={
            accountNo:$scope.otherform.bailAcctNo,
            custcd:$scope.otherform.custcd,   //客户
            accountType:"3"  //保证金账户
        };
        //}
    });
    //合作机构筛选
    $scope.cooperationBrcodeContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBranchInfo",//请求url
        param:{ brAttr:"1"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"brName",
        column:["brNo","brName"]//展示内容
    };
    $scope.cooperationBrcodedooextent = function(ds){
        $scope.otherform.cooperationBrcode=ds.brNo;
        $scope.otherform.cooperationBrcodeNm=ds.brName;
    };
    $scope.$watch("otherform.cooperationBrcodeName",function(){
        //if($scope.otherform.cooperationBrcodeName!=null){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.cooperationBrcodeContent.param ={
            brNo:$scope.otherform.cooperationBrcode,
            brName:$scope.otherform.cooperationBrcodeNm,
            brAttr:"1"  //机构属性：0-非村镇银行、1-村镇银行
        };
        //}
    });
//费用收取方式
    $scope.chargeTypeChange=function(val){
        if(val=="01"){ //按年
            // $scope.costtableIdhide =true;
            $scope.costdatasource.ds=[];//按年时清空费用信息
            $scope.costselected.select=[];
        }else if(val=="02"&&$scope.otherform.supplyChainPdId!=null){
            findCostInfoByProduct(); //获得费用信息
        }
    };
    /**合同基本信息 结束**/



    /**费用 开始**/
    $scope.costconf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    $scope.costdatasource={//初始化表格对象
        ds: []
    };
    $scope.costselected={//初始化对象
        select: []
    };
    function findCostInfoByProduct(){
        var data={
            pageNo: $scope.costconf.pageNo,
            pageSize: $scope.costconf.pageSize,
            value:{
                productId:$scope.otherform.supplyChainPdId
            }
        };
        var promise=$common.get_asyncData("bCntDebtInfoService/findCostInfoByProduct",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.costdatasource.ds=data.records;
                $scope.costconf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    };
    //根据合同编号加载费用信息
    function findCostInfoList(){
        var data={
            mastContQryVO:{
                mastContCode:bData.debtContno
            }
        };
        var promise=$common.get_asyncData("bCntDebtInfoService/findCostInfoListByContno",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.costdatasource.ds=data;
                //$scope.costconf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    };
//费用查看
    $scope.column = function(row){
        //dataDeliver.setter(row);
        $common.get_ngDialog('contractMng/costInfoMod.html',$scope
            ,["$scope",function(dialogScope){
                //bicrinfoSubViewController(dialogScope,$scope,dataDeliver,$common,"view");
                dialogScope.costform={};
                //dialogScope.costRateDisable=true;
                //dialogScope.costAmtDisable=true;
                //dialogScope.hideFlag=true;
                findCostInfo();
                //根据合同编号加载费用信息列表
                function findCostInfo(){
                    var data={
                        mastContQryVO:{
                            mastContCode:bData.debtContno
                        }
                    };
                    var promise=$common.get_asyncData("bCntDebtInfoService/findCostInfoByContno",data);
                    promise.then(function (res) {
                        if(res.errorCode=="SUC"){
                            data = res.contextData;
                            dialogScope.costform=data;
                            //$scope.costconf.totalRecord = data.totalRecord;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    })
                };
                //返回
                dialogScope.closeThisDialog_onClick = function(){
                    dataDeliver.setter(dataDeliver.getter());
                    dialogScope.closeThisDialog();
                };
            }],"费用信息",{showClose:true});
    };

    /**费用 结束**/
    /* 交易对手 开始*/
    $scope.debtExtconf= {//初始化分页对象交易对手
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    $scope.debtExtdatasource={//初始化表格对象
        ds: []
    };
    $scope.debtExtselected={//初始化对象
        select: []
    };
    $scope.extdatasource={//初始化表格对象
        ds: []
    };
    //根据合同编号加载交易对手信息
    function queryDebtExtInfo(){
        var data ={
            pageNo: $scope.debtExtconf.pageNo,
            pageSize: $scope.debtExtconf.pageSize,
            debtContVO:{debtContno:bData.debtContno}
        };
        var promise=$common.get_asyncData("bCntDebtInfoService/queryBCntDebtExtInfoByContno",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.debtExtdatasource.ds =data.records;
                $scope.debtExtconf.totalRecord = data.totalRecord;
                // $scope.querysubTable();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    };

};

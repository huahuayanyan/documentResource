
var protocolInfoController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {

    var dataX=dataDeliver.getter();
    $scope.threeProtocolForm={};
    if(dataX.flag=="add"){
        $scope.threeProtocolForm.state="1";//默认为有效协议
        $scope.threeProtocolForm.sellOffFlag="1";//是否签订委托变卖协议 默认为是
        $scope.threeProtocolForm.deliveryMode="2";//提货模式 默认为总量对应
        $scope.threeProtocolForm.dutyAssumeType=["02"];//卖方责任承担方式 默认为 违约退款
        $scope.threeProtocolForm.productId="1210020"
    }else if(dataX.flag=="update"){
        //$scope.threeProtocolForm=dataX.protocol;
        findthreeProtocolFormInfo();
        $scope.update=true;
    }else if(dataX.flag=="view"){
        //$scope.threeProtocolForm=dataX.protocol;
        findthreeProtocolFormInfo();
        $scope.view=true;
        $scope.update=true;
    }
    //页面信息实时查询
    function findthreeProtocolFormInfo(){
        var data= {
            pageNo: 1,
            pageSize: 10,
            deliveryQryVO:{protocolNo:dataX.info.protocolNo}
        };
        var promise = $common.get_asyncData("fourProtocolService/getFranchiserProtocolQuery",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                if(data.records[0]){
                    $scope.threeProtocolForm = data.records[0];
                    if($scope.threeProtocolForm.dutyAssumeType){
                        $scope.threeProtocolForm.dutyAssumeType=($scope.threeProtocolForm.dutyAssumeType).split(",");
                    }
                    if($scope.threeProtocolForm.loanWay){
                        $scope.threeProtocolForm.loanWay=($scope.threeProtocolForm.loanWay).split(",");
                    }
                    findCrmBrInfo();
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }
    //合作机构代码转译
    function translateBrInfo(){
        if($scope.threeProtocolForm.cooperationBrcode){
            var brinfo={brNo:$scope.threeProtocolForm.cooperationBrcode};
            var data={
                pageNo:1,
                pageSize:10,
                value:brinfo
            };
            var primiseB = $common.get_asyncData("bSysCommonService/selectBranchInfo",data);
            primiseB.then(function(res1){
                if (res1.errorCode =="SUC") {
                    $scope.threeProtocolForm.cooperationBrcodeNm=res1.contextData.records[0].brName;
                }else{
                    $common.get_tipDialog(res1.errorMsg,'showError');
                }
            });
        }
    }
    //业务品种
    $scope.selectSource = {
        ds:[{key:"1210020",value:'先票/款后货'}]
    };
    //经办机构，客户经理页面数据赋值
    function findCrmBrInfo(){
        var bCrmBrInfo={};
        var primiseB = $common.get_asyncData("bCrmBaseInfoService/findBCrmBrInfo",{bCrmBrInfo:bCrmBrInfo});
        primiseB.then(function(res1){
            if (res1.errorCode =="SUC") {
                $scope.threeProtocolForm.brName=res1.contextData.brName;
                $scope.threeProtocolForm.inputorgname=res1.contextData.brName;
                $scope.threeProtocolForm.brcode=res1.contextData.brNo;
                $scope.threeProtocolForm.tlrName=userInfo.tlrName;
                translateBrInfo();
            }else{
                $common.get_tipDialog(res1.errorMsg,'showError');
            }
        });
    }



    //买方客户名称下拉-begin
    $scope.sellerNmContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.threeProtocolForm.custcd=ds.custcd;
    };
    $scope.$watch("threeProtocolForm.sellerNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.sellerNmContent.param ={
            creditFlag:'1',
            custType:'1',
            cname:$scope.threeProtocolForm.sellerNm
            //custcd:$scope.threeProtocolForm.custcd
        }
    });
    //卖方客户名称下拉-begin
    $scope.coreNmContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.coreNmExtent = function(ds){
        $scope.threeProtocolForm.coreCustcd=ds.custcd;
    };
    $scope.$watch("threeProtocolForm.coreNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.coreNmContent.param ={
            coreFlag:'1',
            custType:'1',
            custStatus:'01',
            cname:$scope.threeProtocolForm.coreNm
            //custcd:$scope.threeProtocolForm.coreCustcd
        }
    });
    //卖方客户名称下拉-end
    //监管方客户名称下拉-begin
    $scope.moniNmContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.moniNmExtent = function(ds){
        $scope.threeProtocolForm.moniCustcd=ds.custcd;
    };
    $scope.$watch("threeProtocolForm.moniNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.moniNmContent.param ={
            moniFlag:'1',
            custType:'1',
            custStatus:'01',
            cname:$scope.threeProtocolForm.moniNm
        }
    });
    //监管方客户名称下拉-end
    //承担方客户名称下拉-begin
    $scope.fouNameContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.fouNameExtent = function(ds){
        $scope.threeProtocolForm.fouCd=ds.custcd;
    };
    $scope.$watch("threeProtocolForm.fouName",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.fouNameContent.param ={
            coreFlag:'1',
            custType:'1',
            custStatus:'01',
            cname:$scope.threeProtocolForm.fouName
        }
    });
    //承担方客户名称下拉-end
    //合作机构下拉-begin
    $scope.cooperationBrcodeNmContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBranchInfo",//请求url
        param:{ brAttr:"1"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"brName",
        column:["brNo","brName"]//展示内容
    };
    $scope.cooperationBrcodeNmExtent = function(ds){
        $scope.threeProtocolForm.cooperationBrcode=ds.brNo;
        $scope.threeProtocolForm.cooperationBrcodeNm=ds.brName;
    };
    $scope.$watch("threeProtocolForm.cooperationBrcodeNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.cooperationBrcodeNmContent.param ={
            brNo:$scope.threeProtocolForm.cooperationBrcode,
            brName:$scope.threeProtocolForm.cooperationBrcodeNm,
            brAttr:"1"  //机构属性：0-非村镇银行、1-村镇银行
        };
    });
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
    $scope.threeProtocolForm.sysDate="" + y + m + d;
    var sysDate=parseFloat($scope.threeProtocolForm.sysDate);//当前日期

    var errorFlag=true;//true为没有错误可以调用新增修改方法
    //页面规则校验
    function checkFormRule(){
        //出账方式
        if((!$scope.threeProtocolForm.loanWay)||$scope.threeProtocolForm.loanWay.length<1){
            $common.get_tipDialog('请选择出账方式！', 'showInform');
            errorFlag=false;
            return false;
        }
        //初始保证金比例
        if(!(/^(\d{1,2}(\.\d{1,2})?|100)$/.test($scope.threeProtocolForm.firstBailRatio))){
            $common.get_tipDialog('初始保证金比例范围应该是[0，100%]！', 'showInform');
            errorFlag=false;
            return false;
        }
        //[协议到期日期]不能早于[当前日期]
        var endDate=parseFloat($scope.threeProtocolForm.endDate);
        if(endDate < sysDate){
            $common.get_tipDialog('[协议到期日期]不能早于[当前日期]', 'showInform');
            errorFlag=false;
            return false;
        }
        //这里应该还有一个协议生效日期 todo
        //校验买方名称，卖方名称，承担方名称，监管公司名称,合作机构
        if( !$scope.threeProtocolForm.custcd){
            $common.get_tipDialog('请通过查询按钮选择买方名称！', 'showInform');
            errorFlag=false;
            return false;
        }
        if(  !$scope.threeProtocolForm.coreCustcd){
            $common.get_tipDialog('请通过查询按钮选择卖方名称！！', 'showInform');
            errorFlag=false;
            return false;
        }
        if( !$scope.threeProtocolForm.fouCd){
            $common.get_tipDialog('请通过查询按钮选择承担方名称！', 'showInform');
            errorFlag=false;
            return false;
        }
        if(!$scope.threeProtocolForm.moniCustcd){
            $common.get_tipDialog('请通过查询按钮选择监管公司名称！', 'showInform');
            errorFlag=false;
            return false;
        }
        if( (!$scope.threeProtocolForm.cooperationBrcode) && $scope.threeProtocolForm.cooperationBrcodeNm){
            $common.get_tipDialog('请通过查询按钮选择合作机构！', 'showInform');
            errorFlag=false;
            return false;
        }
        //买方、卖方不可为同一企业!
        if($scope.threeProtocolForm.sellerNm==$scope.threeProtocolForm.coreNm){
            $common.get_tipDialog('买方、卖方不可为同一企业!', 'showInform');
            errorFlag=false;
            return false;
        }
        //买方、担保方不可为同一企业!
        if($scope.threeProtocolForm.sellerNm==$scope.threeProtocolForm.fouName){
            $common.get_tipDialog('买方、担保方不可为同一企业!', 'showInform');
            errorFlag=false;
            return false;
        }
        //校验输入长度
        if($scope.threeProtocolForm.otherDes && $scope.threeProtocolForm.otherDes.length > 0){
            var otherDes = $scope.threeProtocolForm.otherDes;
            if( otherDes.length>500) {
                $common.get_tipDialog('[备注]内容过长，请输入160字以内内容！','showError');
                errorFlag=false;
                return false;
            }
        }
    }
    //保存/修改操作按钮
    $scope.save_onClick = function(){
        if($.doValidate("threeProtocolForm")) {
            //当合作机构从有对应名称改为无值的时候要把合作机构代码清空
            if($scope.threeProtocolForm.cooperationBrcodeNm ==""){
                $scope.threeProtocolForm.cooperationBrcode="";
            }
            //页面字段规则校验
            checkFormRule();
            if(errorFlag){
                if(dataX.flag == "add"){
                    //新增信息保存
                    var primise = $common.get_asyncData("fourProtocolService/franchiserProtocolAdd", {FourProtocolVO:$scope.threeProtocolForm});
                }else if (dataX.flag == "update"){
                    var primise = $common.get_asyncData("fourProtocolService/franchiserProtocolModify",{FourProtocolVO:$scope.threeProtocolForm} );
                }
                primise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        $common.get_tipDialog('保存成功！', 'showSuccess');
                        $state.go("fourProtocolList");
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
            }else{
                errorFlag=true;
            }
        }
    };
    //返回按钮
    $scope.back_onClick = function () {
        $state.go("fourProtocolList");
    };
};
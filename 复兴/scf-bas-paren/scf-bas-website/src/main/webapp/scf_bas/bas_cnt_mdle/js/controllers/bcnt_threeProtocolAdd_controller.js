/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      huangshuidan
 * @version     1.0
 * Create at:   2016/11/29
 */

var bcntThreeProtocolAddController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {
    $scope.threeProtocolForm={};
    $scope.productSource={
        ds: []
    };
    $scope.selectbrcode={
        ds: []
    };

    var  bData =dataDeliver.getter();
    if(bData.flag == "add"){
    	initPageUserOrg();
        //新增信息初始化
    	$scope.threeProtocolForm.state="1";
    	$scope.threeProtocolForm.productId="1210010";
    }else if (bData.flag == "update"){
    	queryProtocol();
        //设置只读
        $scope.cnameDisable=true;//
        
    }
    var productPar= {
		pageNo: '1',
		pageSize: '999999',
		bPrdInfo:{/*parentId:'2100'*/}
    };
    var promise = $common.get_asyncData("bPrdInfoService/findPrdInfoByPage",productPar);
    promise.then(function(res){
        var data;
        if (res.errorCode =="SUC"){
            data = res.contextData;
            $scope.productSource.ds = data.records;
        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
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
        $scope.threeProtocolForm.sellerNm=ds.cname;
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
    //买方客户名称下拉-end
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
        $scope.threeProtocolForm.coreNm=ds.cname;
    };
    $scope.$watch("threeProtocolForm.coreNm",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.coreNmContent.param ={
        	coreFlag:'1',
        	custType:'1',
            cname:$scope.threeProtocolForm.coreNm
            //custcd:$scope.threeProtocolForm.coreCustcd
        }
    });
    //卖方客户名称下拉-end
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
        $scope.threeProtocolForm.fouName=ds.cname;
    };
    $scope.$watch("threeProtocolForm.fouName",function(){
        //ht-input-extent  需要用监听的方式来传额外的参数
        $scope.fouNameContent.param ={
        	coreFlag:'1',
        	custType:'1',
            cname:$scope.threeProtocolForm.fouName
            //custcd:$scope.threeProtocolForm.fouCd
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
        if($scope.threeProtocolForm.cooperationBrcodeNm == "") $scope.threeProtocolForm.cooperationBrcodeNm = null;
        $scope.cooperationBrcodeNmContent.param ={
            //brNo:$scope.threeProtocolForm.cooperationBrcode,
            brName:$scope.threeProtocolForm.cooperationBrcodeNm,
            brAttr:"1"  //机构属性：0-非村镇银行、1-村镇银行
        };
    });
    //合作机构下拉-end
    //初始化客户经理、机构信息
    function initPageUserOrg(){
        var data ={};
        var promise=$common.get_asyncData("threeProtocolService/initPageUserOrg",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.selectbrcode.ds =data.listBctl;
                $scope.threeProtocolForm.brcode=data.brcode;
                $scope.threeProtocolForm.inputorgname=data.inputorgname;
                $scope.threeProtocolForm.tlrName=data.tlrName;
                $scope.brcodeDisable =true;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    //根据协议号加载担保提货协议信息
    function queryProtocol(){
        var threeProtocolVO ={
        	protocolNo:bData.protocolNo
        };
        var data = {
            threeProtocolVO:threeProtocolVO
        }
        console.log("protocolNo:"+bData.protocolNo);
        var promise=$common.get_asyncData("threeProtocolService/queryThreeProtocolForOneObject",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                $scope.threeProtocolForm=data;
                $scope.selectbrcode.ds =data.listBctl;
                $scope.threeProtocolForm.brcode=data.brcode;
                $scope.threeProtocolForm.inputorgname=data.inputorgname;
                if(data.dutyAssumeType!=null){
                    $scope.threeProtocolForm.dutyAssumeType=JSON.parse(data.dutyAssumeType);
                }
                if(data.loanWay!=null){
                    $scope.threeProtocolForm.loanWay=JSON.parse(data.loanWay);
                }
                $scope.brcodeDisable =true;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    }
    //保存/修改操作按钮
    $scope.save_onClick = function(){
        if($.doValidate("threeProtocolForm")) {
            if($scope.threeProtocolForm.loanWay.length<1){
                $common.get_tipDialog('请选择出账方式！', 'showInform');
                return false;
            }
            if(!(/^(\d{1,2}(\.\d{1,2})?|100)$/.test($scope.threeProtocolForm.firstBailRatio))){
                $common.get_tipDialog('初始保证金比例范围应该是[0，100%]！', 'showInform');
                return false;
            }
            //校验买方名称，卖方名称，承担方名称
            if( $scope.threeProtocolForm.custcd==null){
                $common.get_tipDialog('请选择正确的买方名称！', 'showInform');
                return false;
            }
            if(  $scope.threeProtocolForm.coreCustcd==null){
                $common.get_tipDialog('请选择正确的卖方名称！', 'showInform');
                return false;
            }
            if( $scope.threeProtocolForm.fouCd==null){
                $common.get_tipDialog('请选择正确的承担方名称！', 'showInform');
                return false;
            }
            //校验输入长度
            var otherDes = $scope.threeProtocolForm.otherDes;
            if(otherDes!=null&&otherDes!=""&&otherDes!=undefined){
                if( checkLenght(otherDes)>500)
                {
                    $common.get_tipDialog('“备注”超过系统允许存储的最大数值长度500位，请重新输入','showError');
                    return false;
                }
            }

            var data = {
                threeProtocolVO: $scope.threeProtocolForm
            };
            if(bData.flag == "add"){
                //新增信息保存
                var primise = $common.get_asyncData("threeProtocolService/threeProtocolAdd", data);
            }else if (bData.flag == "update"){
                var primise = $common.get_asyncData("threeProtocolService/threeProtocolModify", data);
            }
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    $common.get_tipDialog('保存成功！', 'showSuccess');
                    $state.go("bcntthreeProtocol");
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        }
    };
    $scope.back_onClick = function () {
        $state.go("bcntthreeProtocol");
    };

    //表格--------结束-------------------------
};

/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var nrBcpApplyEditController = function($scope,$common,$location,dataDeliver,$stateParams,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.baseinfo = $scope.source.baseinfo;
    var flag;
    if($scope.baseinfo.flag)
    {
        flag = $scope.baseinfo.flag;
        if(flag=="add")
        {
            $scope.disable = false;
            $scope.hide = false;
        }
        else if(flag=="update")
        {
            $scope.disable = false;
            $scope.hide = false;
        }
        else
        {
            $scope.disable = true;
            $scope.hide = true;
        }
    }
    else
    {
        $scope.disable = true;
        $scope.hide = true;
    }

    if(!$scope.baseinfo.appno)
    {
        $scope.disableButton = true;
    }
    else
    {
        $scope.disableButton = false;
    }

    $scope.productselect = {//业务品种下拉框
        ds:[]
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

    /**
     * 客户名称查询加载开始
     */
    $scope.custcontent = {
        type:"table",//展示类型table  tree
        url:"bcntBcpAppliBaseInfoService/queryBCrmBaseBusinessInfo",
        param:{custcd :$scope.baseinfo.custcd,coreFlag:"1"},
        split:",",//分隔符
        extentColumn:"businessCname",
        column:["cname","custcd"]//展示内容
    };
    $scope.dooextend = function(ds){
        $scope.baseinfo.businessCname = ds.cname;
        $scope.baseinfo.businessCustcd = ds.custcd;
    };
    $scope.$watch("baseinfo.businessCustcd",function(){
        if($scope.baseinfo.businessCname!=null)
        {
            $scope.custcontent.param ={
                custcd :$scope.baseinfo.custcd,
                coreFlag:"1",
                businessCustcd:$scope.baseinfo.businessCname,
                businessCname:$scope.baseinfo.businessCname
            };
        }
    });
    /**
     * 客户名称查询加载结束
     */

    $scope.confirm_onClick = function(){
        $scope.savedisable = true;
        if($.doValidate("baseinfo")) {
            var custNm = $scope.baseinfo.businessCname;
            var custId = $scope.baseinfo.businessCustcd;
            var bCrmBaseInfo = {custCd:custId};
            $common.get_asyncData('bCrmBaseInfoService/findBCrmBaseInfoByKey',{bCrmBaseInfo:bCrmBaseInfo}).then(function(res){
                var custinfo;
                if (res.errorCode =="SUC"){
                    custinfo = res.contextData;
                    var cname = custinfo.cname;
                    if(custNm == cname)
                    {
                        if(flag=="add")
                        {
                            $common.get_asyncData("bcntBcpAppliBaseInfoService/add",{bCntBcpAppliBaseInfoVO:$scope.baseinfo}).then(function(res){
                                var data;
                                if (res.errorCode =="SUC"){
                                    data = res.contextData;
                                    $scope.baseinfo.appno = data.value;
                                    $common.get_tipDialog('保存成功！','showSuccess');
                                    $scope.disableButton = false;
                                    flag = "update";
                                    $scope.baseinfo.flag = flag;
                                    window.source.baseinfo = $scope.baseinfo;
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                }
                            });
                        }
                        else if(flag="update")
                        {
                            $common.get_asyncData('bcntBcpAppliBaseInfoService/update',{bCntBcpAppliBaseInfoVO:$scope.baseinfo}).then(function(res){
                                if (res.errorCode =="SUC"){
                                    $common.get_tipDialog('保存成功！','showSuccess');
                                    $scope.savedisable = false;
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                }
                            });
                        }
                    }
                    else
                    {
                        document.getElementById("businessCname").focus();
                        $common.get_tipDialog("贸易对手名称与贸易对手客户号不匹配，请重新选择",'showError');
                    }
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
        $scope.savedisable = false;
    };

    //提交
    $scope.submitApply_onClick = function()
    {
        var param = {
            productId:$scope.baseinfo.supplyChainPdId,
            invokPhase:"01"
        };
        //获取风险拦截模型ID
        $common.get_asyncData("bprdChkdirInfoService/findBPrdChkdirInfoByParam",{omap:param}).then(function(res){
            if (res.errorCode =="SUC"){
                var data = res.contextData;
                var mdlId = data.mdlId;
                if(mdlId==undefined||mdlId==""||mdlId==null)
                {
                    $common.get_tipDialog('该业务品种对应调用阶段的风险拦截模型未绑定,请在业务配置中绑定！','showInform');
                    return;
                }
                //调用业务拦截
                dataDeliver.setter({modelId:mdlId,chkMap:$scope.baseinfo});//传值
                $common.get_ngDialog('../../bas_intcpdir_mdle/html/ft/intcpline.html',$scope,intcplineController,'业务拦截',{showClose:false},700);
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    };
    //监听业务拦截事件
    $scope.$on('interceptEvent',function(event,data) {
        console.log("data信息："+JSON.stringify(data));
        //根据业务拦截处理结果，执行成功继续提交，未执行成功返回
        if(data.checkResult!='SUC'){
            return;
        }
        //锁定当前申请状态,防重复提交
        $scope.disableButton = true;
        $common.get_asyncData('bcntBcpAppliBaseInfoService/submitAndUpdate',{bCntBcpAppliBaseInfoVO:$scope.baseinfo}).then(function(res){
            if (res.errorCode =="SUC"){
                $common.get_tipDialog('提交成功！','showSuccess');
                $scope.disableButton = false;
                $state.go("list");
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
                $scope.disableButton = false;
            }
        })
    });
};

/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var lnconeditController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();
    var lnAmt=$scope.otherform.lnAmt;
    $scope.vidnosource={
        ds:[]
    };
    //页面的几个字段，在对应的数据库中没有对应的字段,现在在页面写死
    //信贷合同总敞口riskAmt,信贷合同可用敞口avaliableRiskAmt,最低保证金比例lowestBailPercent,总余额totalBalance，垫款金额prePaidAmt
    //信贷合同金额 lnAmt
    $scope.otherform.riskAmt=lnAmt;//信贷合同总敞口
    $scope.otherform.avaliableRiskAmt=lnAmt;//信贷合同可用敞口
    $scope.otherform.lowestBailPercent="30.00";//最低保证金比例
    $scope.otherform.totalBalance=lnAmt;//总余额
    $scope.otherform.prePaidAmt="0.00";//垫款金额
    var flag = $scope.otherform.flag;
    if(flag=="lnconedit") {
        $scope.hide = false;
        $scope.disable = true;
    }
    else if(flag=='lnconview') {
        $scope.disable1 = true;
        $scope.disable = true;
        $scope.hide = true;
    }
    //业务合同号查询选择
    $scope.vidNoContent = {
        type:"table",//展示类型table  tree
        url:"bCntDebtInfoService/selectContNoByPage",
        param:{parentId:$scope.otherform.parentId},
        split:"",//分隔符
        extentColumn:"debtContno",
        column:["debtContno"]//展示内容
    };
    $scope.vidNodooextent = function(ds){
        $scope.otherform.vidNo=ds.debtContno;//业务合同号
    };
    $scope.$watch("otherform.vidNo+otherform.parentId+otherform.vidBusiTyp",function(){
        $scope.vidNoContent.param ={
            custcd:$scope.otherform.custId,//客户号
            parentId:$scope.otherform.parentId,//对应的大类的产品号
            supplyChainPdId:$scope.otherform.vidBusiTyp,//所选业务品种对应产品号 vidPrdId
            debtContno:$scope.otherform.vidNo//业务合同号
        };
    });
    /**
     * 业务品种筛选开始
     */
    $scope.productNameContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectBusinessTypeByPage",
        param:{ tFactType:"0" },
        split:",",//分隔符
        extentColumn:"productName",
        column:["productName","productId"]//展示内容
    };
    var oldData = $scope.otherform.vidBusiTyp;
    $scope.productNamedooextent = function(ds){
        //当业务品种改变的时候，对应的业务合同号要清空
        if(ds != "" && ds.productId != oldData){
            $scope.otherform.vidNo="",
            oldData=ds.productId;
        }
        $scope.otherform.vidPrdNm=ds.productName;
        $scope.otherform.vidBusiTyp=ds.productId; //业务品种
        $scope.otherform.parentId = ds.parentId;
    };
    $scope.$watch("otherform.vidPrdNm",function(newVal,oldVal){
        if($scope.otherform.vidPrdNm!=null) $scope.productNameContent.param ={
            productName:$scope.otherform.vidPrdNm,
            tFactType:"0"
        };
    });
    $scope.confirm_onClick = function(){
        if($.doValidate("otherform")) {
            $scope.flowsubmitdisable = true;
            var bPrdInfo={
                productId:$scope.otherform.vidBusiTyp,
                productName:$scope.otherform.vidPrdNm,
            }
            //页面业务品种名称和业务品种产品号一致性校验
            var primise = $common.get_asyncData('bPrdInfoService/checkPrdInfoForSelect',{bPrdInfo:bPrdInfo});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    if(res.contextData.productId){//如果没有查询到对象，说明业务品种名称和产品号是一致的
                        var primise = $common.get_asyncData('bCrrLnConService/update',{bCrrLnCon:$scope.otherform});
                        primise.then(function(res){
                            if (res.errorCode =="SUC"){
                                $state.go("list");
                                $common.get_tipDialog('保存成功！','showSuccess');
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            };
                        });
                    }else{
                        $common.get_tipDialog('请通过查询按钮选择业务品种！','showError');
                    }
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });




        };
    };
    $scope.closeThisDialog_onClick = function(){
        $state.go("list");
    };
};

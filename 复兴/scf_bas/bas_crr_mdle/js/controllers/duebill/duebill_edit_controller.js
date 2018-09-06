/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var duebilleditController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();//定义form对象
    $scope.lncon = $scope.otherform.lncon;
    var flag = $scope.otherform.flag;
    $scope.hidden = true;
    $scope.hid = true;
    $("#gxht").css('display', 'none');
    if(flag=="view")
    {
        $scope.disable = true;
        $scope.disableview = true;
        $scope.hide = true;
    }
    checkInt($scope.otherform.intCd);
    checkDisable();
    /**
     * 客户名称查询加载开始
     */
    $scope.custcontent = {
        type:"table",//展示类型table  tree
        url:"bCrrLnAppService/queryCustSource",
        param:{},
        split:",",//分隔符
        extentColumn:"custNm",
        column:["custNm","custId"]//展示内容
    };
    $scope.dooextend = function(ds){
        $scope.otherform.custNm=ds.custNm;
        $scope.otherform.custCd=ds.custId;
    };
    $scope.$watch("otherform.custNm",function(){
        if($scope.otherform.custNm!=null) $scope.custcontent.param ={custId:$scope.otherform.custNm,custNm:$scope.otherform.custNm};
    });
    /**
     * 客户名称查询加载结束
     */
    /**
     * 账务机构查询加载开始
     */
    $scope.brnameContent = {
        type:"table",//展示类型table  trees
        url:"bSysAcctBctlService/findBSysAcctBctlByPage",//请求url
        param:{status:"1"},//状态有效
        split:"-",//分隔符*/
        extentColumn:"brname",
        column:["brcode","brname"]//展示内容
    };
    $scope.brnameExtent = function(ds){
        $scope.otherform.actBrCd=ds.brcode;
        $scope.otherform.actBrNm=ds.brname;
    };
    //监听事件
    $scope.$watch("otherform.actBrCd",function(){
        $scope.brnameContent.param ={
            status:"1",
            brname:$scope.otherform.actBrNm
        }
    });
    /**
     * 账务机构查询加载结束
     */
    /**
     * 根据利率代码获取利率信息
     * @param val
     */
    function checkInt(val){
        var primise = $common.get_asyncData('bSysLnCdService/findBSysLnCdByRatecode',{ratecode:val});
        primise.then(function(res){
            if (res.errorCode =="SUC"){
                var data = res.contextData;
                $scope.otherform.intId = data.ratecode+"-"+data.ratename;
                $scope.otherform.basInt = data.rateval;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    }
    /**
     * 判断字段是否显示
     */
    function checkDisable(){
        var intAdj = $scope.otherform.intAdj;
        if($scope.otherform.intAdj&&intAdj=="0") {
            $scope.hideadj = true;
        }
    }
    $scope.confirm_onClick = function(){
        if($.doValidate("otherform")) {
            $scope.flowsubmitdisable = true;
            if(flag=="add")
            {
                var primise = $common.get_asyncData("bCrrDuebillService/add",{bCrrDuebill:$scope.otherform});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $common.get_tipDialog('新增成功！','showSuccess');
                        $state.go("list");
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            }
            else if(flag="update")
            {
                var primise = $common.get_asyncData('bCrrDuebillService/update',{bCrrDuebill:$scope.otherform});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $common.get_tipDialog('更新成功！','showSuccess');
                        $state.go("list");
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            }
        };
    };
    $scope.closeThisDialog_onClick = function(){
        $state.go("list");
    };
};

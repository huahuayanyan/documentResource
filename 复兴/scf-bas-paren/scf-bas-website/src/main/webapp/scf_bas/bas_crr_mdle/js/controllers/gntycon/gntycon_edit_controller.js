/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var gntyconeditController = function($scope,$common,dataDeliver,$state,$rootScope) {
    $scope.otherform = dataDeliver.getter();
    $scope.row = $scope.otherform.row;
    $scope.hideCon = true;
    $scope.number = {};
    var flg = $scope.otherform.flg;
    var flag = $scope.otherform.flag;
    var appId = $scope.otherform.appId;
    $scope.disable = true;
    if(!$scope.otherform.flag)
    {
        $scope.disableview = true;
        $scope.hide = true;
    }
    else
    {
        $scope.hide = true;
        if(flag=="lnconview"||flag=="lnconedit")
        {
            $scope.hideCon = false;
            if(flag=="lnconedit")
            {
                $scope.disable = false;
                $scope.hide = false;
                if(flg=="view")
                {
                    $scope.disable = true;
                    $scope.hide = true;
                }
            }
            $scope.disableview = true;
        }
        else
        {
            if(flg=="add")
            {
                $scope.hide = false;
            }
            else
            {
                if(flg=="update")
                {
                    $scope.hide = false;
                }
                else if(flg=="view")
                {
                    $scope.hide = true;
                    $scope.disableview = true;
                }
            }
        }
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

    $scope.confirm_onClick = function(){
        var gutNm = $scope.row.gutNm;
        var gutId = $scope.row.gutId;
        var gcrtId = $scope.row.gcrtId;
        var title;
        var gcrtTyp = $scope.row.gcrtTyp;
        if(gcrtTyp == '01'){
            if(!/^[A-Za-z0-9]{8}-[A-Za-z0-9]{1}$/.test(gcrtId)){
                $common.get_tipDialog("请输入正确的组织机构代码！",'showError');
                return;
            }
        }
        var gutyTyp = $scope.row.gutyTyp;
        if(gutyTyp=="01")
        {//抵押
            title = "抵押人名称";
        }
        if(gutyTyp=="02")
        {//质押
            title = "出质人名称";
        }
        if(gutyTyp=="03")
        {//保证
            title = "保证人名称";
        }
        if(gutyTyp=="04")
        {//保证金
            title = "担保人名称";
        }
        if(!gutId||gutId==null||gutId=="")
        {
            document.getElementById("gutNm").focus();
            $common.get_tipDialog("未对"+title+"进行选择，请重新选择",'showError');
            return;
        }
        var bCrmBaseInfo = {custCd:gutId};
        $common.get_asyncData('bCrmBaseInfoService/findBCrmBaseInfoByKey',{bCrmBaseInfo:bCrmBaseInfo}).then(function(res){
            var custinfo;
            if (res.errorCode =="SUC"){
                custinfo = res.contextData;
                var cname = custinfo.cname;
                if(gutNm == cname)
                {
                    if($.doValidate("row")) {
                        $scope.flowsubmitdisable = true;
                        if(flg=="add")
                        {
                            $scope.row.conStat = "0";
                            var primise = $common.get_asyncData('bCrrGntyConService/add',{bCrrGntyCon:$scope.row});
                            primise.then(function(res){
                                var data;
                                if (res.errorCode =="SUC"){
                                    data = res.contextData;
                                    $scope.relaform = {};
                                    $scope.relaform.rltNo = data.conId;
                                    $scope.relaform.serialno = appId;
                                    $scope.relaform.rltTyp = "01";
                                    $scope.relaform.isRelate = "01";
                                    var primise = $common.get_asyncData("bCrrLnAppRelaService/add",{bCrrLnAppRela:$scope.relaform});
                                    primise.then(function(res){
                                        if (res.errorCode =="SUC"){
                                            $state.go("lnapp.gnty");
                                            $common.get_tipDialog('新增成功！','showSuccess');
                                        }else{
                                            $common.get_tipDialog(res.errorMsg,'showError');
                                        };
                                    });
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                };
                            });
                        }
                        else if(flg=="update"||flg=="lnconedit")
                        {
                            var primise = $common.get_asyncData('bCrrGntyConService/update',{bCrrGntyCon:$scope.row});
                            primise.then(function(res){
                                if (res.errorCode =="SUC"){
                                    if(flg=="update")
                                    {
                                        $state.go("lnapp.gnty");
                                    }
                                    if(flg=="lnconedit")
                                    {
                                        $state.go("lncon.gnty");
                                    }
                                    $common.get_tipDialog('更新成功！','showSuccess');
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                };
                            });
                        }
                        $scope.$parent.panes.forEach(function(pane){
                            if (pane.uiSref == "lnapp.gnty"){
                                $scope.$parent.select(pane);
                            }
                        });
                        return;
                    };
                }
                else
                {
                    document.getElementById("gutNm").focus();
                    $common.get_tipDialog(title+"与其编号不匹配，请重新选择",'showError');
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    };
    $scope.closeThisDialog_onClick = function(){
        if(!$scope.otherform.flag)
        {
            $state.go("gnty");
            $scope.$parent.panes.forEach(function(pane){
                if (pane.uiSref == "gnty"){
                    $scope.$parent.select(pane);
                }
            });
        }
        else
        {
            if(flag == "lnconview"||flag=="lnconedit")
            {
                $state.go("lncon.gnty");
                $scope.$parent.panes.forEach(function(pane){
                    if (pane.uiSref == "lncon.gnty"){
                        $scope.$parent.select(pane);
                    }
                });
            }
            else
            {
                $state.go("lnapp.gnty");
                $scope.$parent.panes.forEach(function(pane){
                    if (pane.uiSref == "lnapp.gnty"){
                        $scope.$parent.select(pane);
                    }
                });
            }
        }
    };
};

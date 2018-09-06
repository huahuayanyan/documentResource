/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var duebillappeditController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.firstform=dataDeliver.getter();//定义form对象
    $scope.otherform = $scope.firstform;
    checkInt($scope.otherform.intCd);
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    //结算账户查询
    $scope.accountNoContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectAccountNo",//请求url
        // param:{creditType: $scope.conditionForm.creditType},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"-",//分隔符
        extentColumn:"lnNo",
        column:["accountNo"]//展示内容
    };
    $scope.accountNodooextent = function(ds){
        $scope.otherform.lnNo=ds.accountNo;
    };
    $scope.$watch("otherform.custCd",function(){
        $scope.accountNoContent.param ={
            accountNo:$scope.otherform.lnNo,
            custcd:$scope.otherform.custCd,   //客户
            accountType:"1"  //客户结算账户
        };
    });

    //流贷--买方名称查询
    var custcd = $scope.otherform.crdtCustCd;
    $scope.cnameContent = {
        type:"table",//展示类型table  trees
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        param:{custcd:custcd},//客户号
        split:"-",//分隔符*/
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    $scope.cnameExtent = function(ds){
        $scope.otherform.custCd=ds.custcd;
    };
    var flag = $scope.firstform.flg;
    if (!window.appNo) {
        if(flag=="add")
        {
            $scope.lncon = $scope.otherform;
        }
        if(flag=="update"||flag=="view") {
            $scope.disable = false;
            if(flag=="view") {
                $scope.disable = true;
                $scope.hide = true;
                $scope.hidesubmit = true;
            }
        }
        checkDisable();
    } else {
        $scope.disable = true;
        $scope.hide = true;
        $scope.hidesubmit = true;
        checkDisable();
        $scope.disableview = true;
        $scope.hideback = true;
        $scope.hidesubmit = true;
    }
    /**
     *  国际行业分类(不支持页面的模糊查询)  开始
     */
    $scope.lnDircontent = {
        type:"tree",//展示类型table  tree
        url:"bBrpIndustryTypesService/findBBrpIndustryTypesTree",//请求url
        //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"-",//分隔符
        extentColumn:["treeName"],
        column:["treeName","treeId"]//展示内容
    };
    $scope.lnDirExtent = function(ds){
        $scope.otherform.lnDir=ds.treeId;
        $scope.otherform.dirNm=ds.treeName;
    };
    $scope.$watch("otherform.lnDir",function(){
        $scope.lnDircontent.param ={industryName:$scope.otherform.lnDir};
    });
    /**
     *  国际行业分类(不支持页面的模糊查询)  结束
     */
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
        $scope.otherform.custId=ds.custId;
    };
    $scope.$watch("otherform.custNm",function(){
        if($scope.otherform.custNm!=null) $scope.custcontent.param ={custId:$scope.otherform.custNm,custNm:$scope.otherform.custNm};
    });
    /**
     * 客户名称查询加载结束
     */
    /**
     * 额度编号查询加载开始
     */
    $scope.crnocontent = {
        type:"table",//展示类型table  tree
        url:"bCrrLnAppService/queryCrnoSource",
        param:{},
        split:",",//分隔符
        extentColumn:"appCrId",
        column:["appCrId","crNm"]//展示内容
    };
    $scope.crnoextend = function(ds){
        $scope.otherform.crNo=ds.appCrId;
    };
    $scope.$watch("otherform.crNo",function(){
        $scope.crnocontent.param ={custId:$scope.otherform.custId,stat:"1"};
    });
    /**
     * 额度编号查询加载结束
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
        var crMdl = $scope.otherform.crMdl;
        if($scope.otherform.crMdl&&crMdl=="0")
        {
            $scope.hidecrmdl = true;
        }
        var intAdj = $scope.otherform.intAdj;
        if($scope.otherform.intAdj&&intAdj=="0") {
            $scope.hideadj = true;
        }
    }
    $scope.confirm_onClick = function(){
        if($.doValidate("otherform")) {
            //合同可用金额
            var amt = Number($scope.otherform.lnSum);
            //出账金额
            var sum = Number($scope.otherform.lnAmt);
            if(sum>amt)
            {
                $common.get_tipDialog('出账金额大于合同可用金额，不可出账!');
                return;
            }
            var actBrNm = $scope.otherform.actBrNm;
            var actBrCd = $scope.otherform.actBrCd;
            if(!actBrCd||actBrCd==null||actBrCd=="")
            {
                document.getElementById("actBrNm").focus();
                $common.get_tipDialog("未对财务机构进行选择，请重新选择",'showError');
                return;
            }
            $common.get_asyncData("bSysAcctBctlService/findBSysAcctBctlByBrcode",{brcode:actBrCd}).then(function(res){
                var data;
                if (res.errorCode =="SUC"){
                    data = res.contextData;
                    var brname = data.brname;
                    if(actBrNm==brname)
                    {
                        $scope.flowsubmitdisable = true;
                        if(flag=="add")
                        {
                            var primise = $common.get_asyncData("bCrrDuebillAppService/add",{bCrrDuebillApp:$scope.otherform});
                            primise.then(function(res){
                                var data;
                                if (res.errorCode =="SUC"){
                                    data = res.contextData;
                                    $scope.otherform = data;
                                    flag = "update";
                                    $state.go("list");
                                    $common.get_tipDialog('保存成功！','showSuccess');
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                };
                            });
                        } else if(flag=="update") {
                            var primise = $common.get_asyncData('bCrrDuebillAppService/update',{bCrrDuebillApp:$scope.otherform});
                            primise.then(function(res){
                                if (res.errorCode =="SUC"){
                                    $common.get_tipDialog('保存成功！','showSuccess');
                                    $state.go("list");
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                };
                            });
                        }else {
                        }
                    }
                    else
                    {
                        document.getElementById("actBrNm").focus();
                        $common.get_tipDialog("输入财务机构与其编号不匹配，请重新选择",'showError');
                        $scope.flowsubmitdisable = false;
                    }
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    };
    /*//银承--供应链添加购销合同--赎货期限保存按钮
    $scope.repayconfirm_onClick = function() {
        //购销合同添加
        if($.doValidate("otherform")) {
            var buyinfoArray = $scope.datasource.ds;
            for (var i = 0; i < buyinfoArray.length; i++) {
                if (buyinfoArray[i].loanAmt == '' || buyinfoArray[i].loanAmt == null) {
                    $common.get_tipDialog('本次出账金额不能为空', 'showInform');
                    return false;
                }
            }
            var drawbackTerm = $scope.otherform.drawbackTerm;
            var primise = $common.get_asyncData("bLanLnciBuyBizService/add", {
                buyinfoArray: buyinfoArray,
                appno: appno,
                drawbackTerm: drawbackTerm
            });
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    $scope.queryTable();
                    $scope.selected.select = [];
                    $common.get_tipDialog('新增成功！', 'showSuccess');
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        }
    }
    //流贷--应收账款--供应链补录保存
    $scope.ysconfirm_onClick = function() {
        //应收账款页面数值传递--otherform--datasource
        if($.doValidate("otherform")) {
            var bcrrDuebillDetail = $scope.otherform;
            var abc = $scope.datasource.ds;
            if(abc.length == 0){
                $common.get_tipDialog('请添加应收账款');
            }else {
                var data = {
                    bcrrDuebillDetail: bcrrDuebillDetail,
                    bussDtlList: abc
                };
                var primise = $common.get_asyncData("bLanRepaySaveService/flowCreditSave", data);
                primise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        $common.get_tipDialog('保存成功！', 'showSuccess');
                    } else {
                        $common.get_tipDialog('保存失败!' + res.errorMsg, 'showError');
                    }
                    ;
                })
            }
        }
    }*/
    $scope.lnAmt_onBlur = function(val){
        //合同可用金额
        var amt = Number($scope.otherform.lnSum);
        //出账金额
        var sum = Number($scope.otherform.lnAmt);
        if(sum>amt)
        {
            $common.get_tipDialog('出账金额大于合同可用金额，不可出账!');
        }
    }
    $scope.closeThisDialog_onClick = function(){
        /*$scope.closeThisDialog();*/
        $state.go("list");
    };
    //***********************************银承购销合同处理***********************************
    /*var appno = window.appNo;
    //新增购销合同
    $scope.add_onClick = function(){
        var row={};
        $common.get_ngDialog('../../bas_crr_mdle/html/duebill/buy_add.html', $scope
            ,["$scope",function(dialogScope){
                buyInfoAddController(dialogScope,$scope,$common,$state,appno);
            }],"新增购销合同",{showClose:true});
    };
    //修改购销合同
    $scope.update_onClick = function(){
        var row ={};
        if($scope.selected.select.length == 1){
            $common.get_ngDialog('../../bas_crr_mdle/html/duebill/buy_update.html', $scope
                ,["$scope",function(dialogScope){
                    buyInfoUpdateController(dialogScope,$scope,$common,"update",row,appno);
                }],"修改购销合同",{showClose:true});
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
    //购销合同删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length == 1){
            $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                var buybiz_id = $scope.selected.select[0].id;//单条删除
                var primise = $common.get_asyncData('bLanLnciBuyBizService/delete',{id:buybiz_id})
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.queryTable();
                        $scope.selected.select = [];
                        $common.get_tipDialog('删除成功！', 'showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            });
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    }
    //!***********************************************流贷应收账款(发票)处理*********************************************
    //新增应收账款
    $scope.addys_onClick = function(){
        var row={};
        $common.get_ngDialog('../../bas_crr_mdle/html/duebill/dtl_add.html', $scope
            ,["$scope",function(dialogScope){
                dtlInfoAddController(dialogScope,$scope,$common,$state,appno);
            }],"新增应收账款",{showClose:true});
    };
    //应收账款删除
    var del_ys=[];
    $scope.deleteys_onClick = function(){
        $common.get_tipDialog('确定删除吗！','showTip').then(function(){
            var dsArray = $scope.datasource.ds;
            var selected = $scope.selected.select;
            for(var m=0;m<selected.length;m++){
                for (var i = 0; i < dsArray.length; i++) {
                    if (dsArray[i].id == selected[m].id) {
                        del_ys.push(selected[m].id);
                        $scope.datasource.ds.splice(i, 1);
                        $scope.selected.select = [];
                    }
                }
            }
            var list = $scope.datasource.ds;
            var aaaa = 0;
            for(var i=0;i<list.length;i++){
                aaaa = aaaa + list[i].remainingAmount;
            }
            $scope.otherform.ysTotalAmt = aaaa;
        });
    }*/
};

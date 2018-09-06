/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var lnappeditController = function($scope,$common,$location,dataDeliver,$stateParams,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();
    $scope.prdmd = $scope.otherform.prdmd;
    var flag;
    if($scope.otherform.flag)
    {
        flag = $scope.otherform.flag;
        if(flag=="add")
        {
            $scope.hideadj = true;
            $scope.hidecrmdl = true;
            $scope.disable = false;
            $scope.hide = false;
        }
        else
        {
            checkInt($scope.otherform.intCd);
            checkDisable();
            if(flag=="update")
            {
                $scope.disable = true;
                $scope.hide = false;
            }
            if(flag=="view")
            {
                $scope.disableview = true;
                $scope.disable = true;
                $scope.hide = true;
            }
        }
    }
    else
    {
        checkInt($scope.otherform.intCd);
        checkDisable();
        $scope.disableview = true;
        $scope.disable = true;
        $scope.hide = true;
        $scope.hideback = true;
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
    $scope.$watch("otherform.dirNm",function(){
       $scope.lnDircontent.param ={industryName:$scope.otherform.dirNm};
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
    $scope.crNo_onFocus = function(){
        document.getElementById("crNo").blur();
        $common.get_ngDialog('lnapp/dcr_list.html', $scope
            ,["$scope",function(dialogScope){
                dcrlistcontroller(dialogScope,$scope,dataDeliver,$state,$common,"view");
            }],"授信额度选择",{showClose:false});
    }
    /**
     * 额度编号查询加载结束
     */
    /**
     *占用额度模式onchange时间
     * @param val
     */
    $scope.changeCrMdl = function(val){
        if(val=="1")
        {
            $scope.hidecrmdl = false;
        }
        if(val=="0")
        {
            $scope.hidecrmdl = true;
            $scope.otherform.crNo = "";
        }
    }
    /**
     *利率调整onchange事件
     * @param val
     */
    $scope.changeAdj = function(val){
        if(val=="0")
        {
            $scope.hideadj = true;
        }
        else
        {
            $scope.hideadj = false;
        }
    }
    /**
     * 获取执行利率
     * @param val
     */
    $scope.changeFltTyp = function(val)
    {
        var basInt = $scope.otherform.basInt;
        var fltIntRt = $scope.otherform.fltIntRt;
        if(val=="1")
        {//浮点
            $scope.otherform.actInt = basInt+fltIntRt;
        }
        if(val=="0")
        {//浮比
            var index = (100+fltIntRt)*1000;
            var basIntIndex = basInt*1000;
            var actIntIndex = index*basIntIndex;
            var actInt = actIntIndex/100000000;
            $scope.otherform.actInt = actInt;
        }
    }
    $scope.fltIntRt_onBlur = function(){
        var intFltTyp = $scope.otherform.intFltTyp;
        var basInt = $scope.otherform.basInt;
        var fltIntRt = $scope.otherform.fltIntRt;
        if(intFltTyp=="1")
        {//浮点
            $scope.otherform.actInt = basInt+fltIntRt;
        }
        if(intFltTyp=="0")
        {//浮比
            var index = (100+fltIntRt)*1000;
            var basIntIndex = basInt*1000;
            var actIntIndex = index*basIntIndex;
            var actInt = actIntIndex/100000000;
            $scope.otherform.actInt = actInt;
        }
        $scope.$apply();
    }
    /**
     * 判断字段是否显示
     */
    function checkDisable(){
        var crMdl = $scope.otherform.crMdl;
        if(crMdl=="0")
        {
            $scope.hidecrmdl = true;
        }
        var intAdj = $scope.otherform.intAdj;
        if(intAdj=="0")
        {
            $scope.hideadj = true;
        }
    }
    $scope.feeRat_onBlur = function()
    {
        if($scope.otherform.feeRat)
        {
            var feeRat = Number($scope.otherform.feeRat);
            if(feeRat<0||feeRat>100)
            {
                $common.get_tipDialog("手续费率必须大于零并且小于一百，请重新输入",'showError');
                $scope.otherform.feeRat="";
                return false;
            }
        }
    }
    $scope.trmMon_onBlur = function(){
        if($scope.otherform.trmMon)
        {
            var trmMon = Number($scope.otherform.trmMon);
            if(trmMon<=0)
            {
                $common.get_tipDialog("期限月不能小于零，请重新输入",'showError');
                $scope.otherform.trmMon="";
                return false;
            }
        }
        if($scope.otherform.prdId!="004")
        {
            checkTrm();
        }
    }
    $scope.trmDay_onBlur = function(){
        if($scope.otherform.trmDay)
        {
            var trmDay = Number($scope.otherform.trmDay);
            if(trmDay<=0)
            {
                $common.get_tipDialog("期限日不能小于零，请重新输入",'showError');
                $scope.otherform.trmDay="";
                return false;
            }
        }
        var trmDay = $scope.otherform.trmDay;
        if(trmDay>31)
        {
            $common.get_tipDialog("期限日不能大于31，请重新输入",'showError');
            $scope.otherform.trmDay="";
            return;
        }
        if($scope.otherform.prdId!="004")
        {
            checkTrm();
        }
    }
    function checkTrm(){
        var trmYear;
        var trmMon = $scope.otherform.trmMon;
        var trmDay = $scope.otherform.trmDay;
        if(trmMon>12)
        {
            trmYear = parseInt(trmMon/12);
            trmMon = trmMon%12;
        }
        else
        {
            trmYear = 0;
        }
        var intId;
        if(trmYear==0&&trmMon==0&&trmDay==0)
        {
            $common.get_tipDialog("期限值不能为0",'showError');
        }
        else if(trmYear==0&&trmMon==0)
        {//六个月以内（含6个月）
            intId = "5000";
        }
        else if(trmYear==0&&trmDay==0)
        {
            if(trmMon<=6)
            {//六个月以内（含6个月）
                intId = "5000";
            }
            else
            {//六个月到一年（含一年）
                intId = "5001";
            }
        }
        else if(trmMon==0&&trmDay==0)
        {
            if(trmYear==1)
            {//六个月到一年（含一年）
                intId = "5001";
            }
            else if(trmYear>1&&trmYear<=3)
            {//一年到三年（含三年）
                intId = "5201";
            }
            else if(trmYear>3&&trmYear<=5)
            {//三年到五年（含五年）
                intId = "5202";
            }
            else
            {//五年以上
                intId = "5203";
            }
        }
        else if(trmYear==0)
        {
            if(trmMon<6)
            {//六个月以内（含6个月）
                intId = "5000";
            }
            else
            {//六个月到一年（含一年）
                intId = "5001";
            }
        }
        else if(trmMon==0)
        {
            if(trmYear>=1&&trmYear<3)
            {//一年到三年（含三年）
                intId = "5201";
            }
            else if(trmYear>=3&&trmYear<5)
            {//三年到五年（含五年）
                intId = "5202";
            }
            else
            {//五年以上
                intId = "5203";
            }
        }
        else if(trmDay==0)
        {
            if(trmYear>=1&&trmYear<3)
            {//一年到三年（含三年）
                intId = "5201";
            }
            else if(trmYear>=3&&trmYear<5)
            {//三年到五年（含五年）
                intId = "5202";
            }
            else
            {//五年以上
                intId = "5203";
            }
        }
        else
        {
            if(trmYear>=1&&trmYear<3)
            {//一年到三年（含三年）
                intId = "5201";
            }
            else if(trmYear>=3&&trmYear<5)
            {//三年到五年（含五年）
                intId = "5202";
            }
            else
            {//五年以上
                intId = "5203";
            }
        }
        $scope.otherform.intCd = intId;
        checkInt(intId);
    }
    /**
     * 根据利率代码获取利率信息
     * @param val
     */
    function checkInt(val){
        if(val!=null&&val!=""&&val!=undefined)
        {
            var intId = val;
            $common.get_asyncData('bSysLnCdService/findBSysLnCdByRatecode',{ratecode:intId}).then(function(res){
                var data;
                if (res.errorCode =="SUC"){
                    data = res.contextData;
                    $scope.otherform.intId = data.ratecode+"-"+data.ratename;
                    $scope.otherform.basInt = data.rateval;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        }
    }

    $scope.confirm_onClick = function(){
        if($.doValidate("otherform")) {
            var dirNm = $scope.otherform.dirNm;
            var lnDir = $scope.otherform.lnDir;
            if(!lnDir||lnDir==null||lnDir=="")
            {
                $common.get_tipDialog("未对贷款投向进行选择，请重新选择",'showError');
                return;
            }
            var bBrpIndustryTypes = {industryCode:lnDir};
            $common.get_asyncData('bBrpIndustryTypesService/findBBrpIndustryTypesByKey',{bBrpIndustryTypes:bBrpIndustryTypes}).then(function(res){
                var industry;
                if (res.errorCode =="SUC"){
                    industry = res.contextData;
                    var industryNm = industry.industryName;
                    if(dirNm==industryNm)
                    {
                        if(flag=="add")
                        {
                            var primise = $common.get_asyncData("bCrrLnAppService/add",{bCrrLnApp:$scope.otherform});
                            primise.then(function(res){
                                if (res.errorCode =="SUC"){
                                    $common.get_tipDialog('新增成功！','showSuccess');
                                    $scope.flowsubmitdisable = false;
                                    $scope.otherform = res.contextData;
                                    $scope.otherform.flag = "update";
                                    $scope.otherform.prdmd = $scope.prdmd;
                                    dataDeliver.setter($scope.otherform);
                                    checkInt($scope.otherform.intCd);
                                    flag = "update";
                                    $scope.disable = true;
                                    $scope.hide = false;
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                };
                            });
                        }
                        else if(flag="update")
                        {
                            var primise = $common.get_asyncData('bCrrLnAppService/update',{bCrrLnApp:$scope.otherform});
                            primise.then(function(res){
                                if (res.errorCode =="SUC"){
                                    $common.get_tipDialog('更新成功！','showSuccess');
                                    $scope.flowsubmitdisable = false;
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                };
                            });
                        }
                    }
                    else
                    {
                        document.getElementById("dirNm").focus();
                        $common.get_tipDialog("贷款投向名称与选中标号不匹配，请重新选择",'showError');
                    }
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    };
};

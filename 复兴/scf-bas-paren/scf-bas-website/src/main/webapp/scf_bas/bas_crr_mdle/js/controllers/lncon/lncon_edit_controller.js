/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var lnconeditController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();
    $scope.hideclose = true;
    checkInt($scope.otherform.intCd);
    checkDisable();
    $scope.prdmd = $scope.otherform.prdmd;
    var flag = $scope.otherform.flag;
    var prdId = $scope.otherform.prdId;
    if(flag=="lnconedit")
    {
        //if(prdId=="01")
        //{
        //    $scope.hide = false;
        //}
        //else
        //{
        //    $scope.hide = true;
        //}
    }
    else if(flag=='lnconview')
    {
        $scope.disable = true;
        $scope.hide = true;
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
     * 根据利率代码获取利率信息
     * @param val
     */
    function checkInt(val){
        if(val!=null&&val!=""&&val!=undefined)
        {
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

    /**
     * 计算贷款期限
     */
    $scope.lnStrtDt_onBlur = function()
    {
        if(!$scope.otherform.lnStrtDt)
        {
            $scope.$apply(
                $scope.otherform.lnEndDt = ""
            )
        }
        else
        {
            var val = $scope.otherform.lnStrtDt;
            var currentDate = getCurrentDate();
            if(val<currentDate){
            	$common.get_tipDialog('信贷合同的起始日期应该大于等于当前日期！','showInform');
            	$scope.otherform.lnStrtDt="";
            	return false;
            }
            checkTrm(val);
        }
    };
    function checkTrm(start){
        var startYear = Number(start.substring(0,4));
        var startMon = Number(start.substring(4,6));
        var startDay = Number(start.substring(6,8));
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
        var endYear = startYear+trmYear;
        var endMon = startMon+trmMon;
        if(endMon>12)
        {
            endYear = endYear+1;
            endMon = endMon-12;
        }
        var endDay = startDay+trmDay;
        var perMonday;
        if(endMon=="01"||endMon=="03"||endMon=="05"||endMon=="07"||endMon=="08"||endMon=="10"||endMon=="12")
        {
            perMonday = 31;
        }
        if(endMon=="04"||endMon=="06"||endMon=="09"||endMon=="11")
        {
            perMonday = 30;
        }
        if(endMon=="02")
        {
            var sum = endYear%4;
            if(sum==0)
            {
                perMonday = 28;
            }
            else
            {
                perMonday = 29;
            }
        }
        if(endDay>perMonday)
        {
            endMon = endMon+1;
            endDay = endDay-perMonday;
        }
        if(endMon>12)
        {
            endYear = endYear+1;
            endMon = endMon-12;
        }
        if(endMon<10)
        {
            endMon = "0"+endMon;
        }
        if(endDay<10)
        {
            endDay = "0"+endDay;
        }
        $scope.otherform.lnEndDt = endYear+""+endMon+""+endDay;
        $scope.$apply();
    }
    $scope.confirm_onClick = function(){
        if($.doValidate("otherform")) {
            var primise = $common.get_asyncData('bCrrLnConService/update',{bCrrLnCon:$scope.otherform});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('更新成功！','showSuccess');
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };
    
    function getCurrentDate(){
    	var date = new Date();
    	var year = date.getFullYear();
    	var month = date.getMonth() + 1;
    	var day = date.getDate();
    	if(month < 10){
    		month = "0" + month;
        }
        if(day < 10){
        	day = "0" + day;
        } 
        var currentDate = year + month + day;
        return currentDate;
    }
};

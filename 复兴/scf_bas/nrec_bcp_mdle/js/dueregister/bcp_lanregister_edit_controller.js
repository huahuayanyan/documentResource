/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var nrBcpLanRegisterEditController = function($scope,$common,$location,dataDeliver,$stateParams,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();
    var flag = $scope.otherform.flag;
    if(flag=="add")
    {

    }
    if(flag=="update")
    {
        $scope.disablesubmit = true;
    }
    if(flag=="view")
    {
        $scope.disable = true;
        $scope.hide = true;
        $scope.disablesubmit = true;
    }

    //监听分页
    $scope.$watch("otherform.flag",function() {
        $scope.queryBaseInfo();
    });
    $scope.queryBaseInfo = function(paramData){
        $common.get_asyncData("rbcpDuebillRegisterService/findRBcpDuebillRegisterByAppno",{rBcpDuebillRegisterVO:$scope.otherform}).then(function(res){
            if (res.errorCode =="SUC"){
                var data = res.contextData;
                $scope.otherform = data;
                $scope.$apply();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    /**
     *  融资企业查询加载开始
     */
    $scope.custcontent = {
        type:"table",//展示类型table  tree
        url:"bcntBcpAppliBaseInfoService/queryBCrmBaseInfoSource",
        param:{flag:"cont"},
        split:",",//分隔符
        extentColumn:"cname",
        column:["cname","custcd"]//展示内容
    };
    $scope.dooextend = function(ds){
        $scope.otherform.cname = ds.cname;
        $scope.otherform.custcd = ds.custcd;
        $scope.appnocontent.param = {custcd:$scope.otherform.custcd};
    };
    $scope.$watch("otherform.cname",function(){
        if($scope.otherform.cname!=null) $scope.custcontent.param ={flag:"cont",custcd:$scope.otherform.cname,cname:$scope.otherform.cname};
    });

    $scope.appnocontent = {
        type:"table",//展示类型table  tree
        url:"rbcpDuebillRegisterService/getAppnoByCustcd",
        param:{},
        split:",",//分隔符
        extentColumn:"appno",
        column:["appno"]//展示内容
    };
    $scope.appnodooextend = function(ds){
        $scope.otherform.appno = ds.appno;
        $scope.otherform.mastContno = ds.mastContno;
        $scope.queryBaseInfo();
    };
    $scope.$watch("otherform.appno",function(){
        $scope.appnocontent.param ={custcd:$scope.otherform.custcd,appno:$scope.otherform.appno};
    });
    /**
     *  融资企业查询加载结束
     */

    $scope.lnAmt_onBlur = function()
    {
        var dueAmount = Number($scope.otherform.dueAmount);
        var lnAmt = Number($scope.otherform.lnAmt);
        if(lnAmt>dueAmount)
        {
            $common.get_tipDialog('放款金额不得大于可放款金额！','showInform');
            return;
        }
        var feeRate = Number($scope.otherform.feeRate);
        $scope.otherform.feeAmt = lnAmt*feeRate/100;
        $scope.$apply();
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

    //根据起始日期计算结束日期
    $scope.startDate_onBlur = function()
    {
        if(!$scope.otherform.startDate)
        {
            $scope.$apply(
                $scope.otherform.endDate = ""
            )
        }
        else
        {
            var val = $scope.otherform.startDate;
            var currentDate = getCurrentDate();
            if(val<currentDate){
                $common.get_tipDialog('起始日期应该大于等于当前日期！','showInform');
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
        while(endMon>12)
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
        while(endDay>perMonday)
        {
            endMon = endMon+1;
            endDay = endDay-perMonday;
        }
        while(endMon>12)
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
        $scope.$apply(
            $scope.otherform.endDate = endYear+""+endMon+""+endDay
        );
    }

    $scope.save_onClick = function(){
        if($.doValidate("otherform")) {
            var dueAmount = Number($scope.otherform.dueAmount);
            var lnAmt = Number($scope.otherform.lnAmt);
            if(lnAmt>dueAmount)
            {
                $common.get_tipDialog('放款金额不得大于可放款金额！','showInform');
                return;
            }
            $scope.otherform.state = "0";
            $common.get_asyncData("rbcpDuebillRegisterService/saveAndUpdate",{rBcpDuebillRegisterVO:$scope.otherform}).then(function(res){
                var data;
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('保存成功！','showSuccess');
                    data = res.contextData.value;
                    $scope.otherform.id = data;
                    $scope.disablesubmit = true;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };

    $scope.submit_onClick = function()
    {
        if($.doValidate("otherform")) {
            var dueAmount = Number($scope.otherform.dueAmount);
            var lnAmt = Number($scope.otherform.lnAmt);
            if(lnAmt>dueAmount)
            {
                $common.get_tipDialog('放款金额不得大于可放款金额！','showInform');
                return;
            }
            $scope.otherform.state = "1";
            $common.get_asyncData("rbcpDuebillRegisterService/saveAndUpdate",{rBcpDuebillRegisterVO:$scope.otherform}).then(function(res){
                var data;
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('已确认出账！','showSuccess');
                    $state.go("list");
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };

    $scope.back_onClick = function()
    {
        $state.go("list");
    }
};

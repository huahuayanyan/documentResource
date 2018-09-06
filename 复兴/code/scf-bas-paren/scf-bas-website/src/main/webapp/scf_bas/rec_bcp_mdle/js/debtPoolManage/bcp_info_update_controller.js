/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var BcpInfoUpdateController =  function($scope,$common,$state,dataDeliver){
    var data1=dataDeliver.getter();
    var flag=data1.flag;
    $scope.otherform=data1.rBcpDebtBaseInfo;
    if(flag == "view"){
        $scope.disable=true;
        $scope.hide=true;
    }
    //票面金额,billsAmountView,有效金额,billsAmount,应收账款日期,billsDate,账期,aging,宽限期,gracePeriod aging,gracePeriod
    // 应收账款日期,billsDate,到期日期,debtEnd,最迟付款日,deadline
    //应收账款日期离焦之后，将对应的应收账款到期日，最迟付款日自动填充
    var aging;
    if($scope.otherform.aging || $scope.otherform.aging!=""){
        aging =parseFloat($scope.otherform.aging);
    }else{
        $scope.otherform.aging=0;
        aging=0;
    }
    $scope.billsDate_onBlur=function(){
        if($scope.otherform.billsDate != ""){
            var billsDate=$scope.otherform.billsDate;
            var dateMilli=new Date(billsDate.replace(/^(\d{4})(\d{2})(\d{2})$/,'$1/$2/$3')).getTime();
            if($scope.otherform.aging == ""){//
                $common.get_tipDialog("请填写账期！",'showError');
            }else{
                var dayMilli=(aging)*24*60*60*1000;
                var dateMilliAndDayMilli=dateMilli+dayMilli;
                var date = new Date(dateMilliAndDayMilli);
                var y = date.getFullYear();
                var m = date.getMonth() + 1;
                var d = date.getDate();
                if(m < 10){
                    m = "0" + m;
                }
                if(d < 10){
                    d = "0" + d;
                }
                $scope.otherform.debtEnd="" + y + m + d;
                //应收账款到期日=应收账款日期+账期
                if($scope.otherform.gracePeriod == ""){
                    $scope.otherform.deadline=$scope.otherform.debtEnd;
                }else{
                    var dateMilliAndDayMilli2=dateMilliAndDayMilli+($scope.otherform.gracePeriod)*24*60*60*1000;
                    var date2 = new Date(dateMilliAndDayMilli2);
                    var y2 = date2.getFullYear();
                    var m2 = date2.getMonth() + 1;
                    var d2 = date2.getDate();
                    if(m2 < 10){
                        m2 = "0" + m2;
                    }
                    if(d2 < 10){
                        d2 = "0" + d2;
                    }
                    $scope.otherform.deadline="" + y2 + m2 + d2;
                }
                //最迟付款日=应收账款日期+账期+宽限期
                /*$scope.otherform.deadline=$scope.otherform.debtEnd + parseInt(row.gracePeriod);*/
                $scope.$apply();
            }
        }else{//应收账款日为空，其他两个也是空
            $scope.otherform.debtEnd="";
            $scope.otherform.deadline="";
            $scope.$apply();
        }
    }
    //账期离焦事件，将对应的应收账款到期日和最迟付款日更新
    $scope.aging_onBlur=function() {
        if ($scope.otherform.aging == "") {
            $common.get_tipDialog("请填写账期！", 'showError');
        } else {
            var billsDate = $scope.otherform.billsDate;
            var dateMilli = new Date(billsDate.replace(/^(\d{4})(\d{2})(\d{2})$/, '$1/$2/$3')).getTime();
            var dayMilli = (aging) * 24 * 60 * 60 * 1000;
            var dateMilliAndDayMilli = dateMilli + dayMilli;
            var date = new Date(dateMilliAndDayMilli);
            var y = date.getFullYear();
            var m = date.getMonth() + 1;
            var d = date.getDate();
            if (m < 10) {
                m = "0" + m;
            }
            if (d < 10) {
                d = "0" + d;
            }
            $scope.otherform.debtEnd = "" + y + m + d;
            //应收账款到期日=应收账款日期+账期
            if ($scope.otherform.gracePeriod == "") {
                $scope.otherform.deadline=$scope.otherform.debtEnd;
            } else {
                var dateMilliAndDayMilli2 = dateMilliAndDayMilli + ($scope.otherform.gracePeriod) * 24 * 60 * 60 * 1000;
                var date2 = new Date(dateMilliAndDayMilli2);
                var y2 = date2.getFullYear();
                var m2 = date2.getMonth() + 1;
                var d2 = date2.getDate();
                if (m2 < 10) {
                    m2 = "0" + m2;
                }
                if (d2 < 10) {
                    d2 = "0" + d2;
                }
                $scope.otherform.deadline = "" + y2 + m2 + d2;
            }
            $scope.$apply();
        }
    };
    //宽限期离焦事件（最迟付款日会自动添加） debtEnd 到期日
    $scope.gracePeriod_onBlur=function() {
        //应收账款到期日=应收账款日期+账期
        if ($scope.otherform.gracePeriod == "") {
            $scope.otherform.deadline=$scope.otherform.debtEnd;
        } else {
            var debtEnd=$scope.otherform.debtEnd;
            var dateMilli = new Date(debtEnd.replace(/^(\d{4})(\d{2})(\d{2})$/, '$1/$2/$3')).getTime();
            var dateMilliAndDayMilli2 = dateMilli + ($scope.otherform.gracePeriod) * 24 * 60 * 60 * 1000;
            var date2 = new Date(dateMilliAndDayMilli2);
            var y2 = date2.getFullYear();
            var m2 = date2.getMonth() + 1;
            var d2 = date2.getDate();
            if (m2 < 10) {
                m2 = "0" + m2;
            }
            if (d2 < 10) {
                d2 = "0" + d2;
            }
            $scope.otherform.deadline = "" + y2 + m2 + d2;
            $scope.$apply();
        }
    }
    //票面金额填写完毕，会自动复制赋值给有效金额
    $scope.billsAmountView_onBlur=function(){
        if($scope.otherform.billsAmountView != ""){
            $scope.otherform.billsAmount=$scope.otherform.billsAmountView;
            $scope.$apply();
        }
    }
    //当客户修改有效金额，会与票面金额做对比，不可大于票面金额
    var billsAmount;
    var billsAmountView;
    $scope.billsAmount_onBlur=function(){
        if($scope.otherform.billsAmount != ""){
            billsAmount=parseFloat($scope.otherform.billsAmount);//有效金额
            billsAmountView= parseFloat($scope.otherform.billsAmountView);//票面金额
            if(billsAmount > billsAmountView){
                $common.get_tipDialog("有效金额不能大于票面金额！",'showError');
                $scope.otherform.remainingAmount="";
            }else{
                //如果符合规则，则将有效金额赋值给应收账款余额
                $scope.otherform.remainingAmount=$scope.otherform.billsAmount;
                return false;
            }
        }
    }
    //页面规则校验
    var errorflag=false;
    var errorMessage="";
    function checkFormRule(){
        //1.日期 应收账款到期日期必须大于登记日期
        var debtEnd=parseFloat($scope.otherform.debtEnd);//到期日期
        var billsDate1=parseFloat($scope.otherform.billsDate);
        var insertDate=parseFloat($scope.otherform.insertDate);//登记日期
        if(billsDate1> insertDate){
            errorflag=true;
            errorMessage=errorMessage+"应收账款日期应小于等于登记日期！" ;
        }
        if(debtEnd < insertDate){
            errorflag=true;
            errorMessage=errorMessage+"应收账款到期日应大于登记日期！" ;
        }
        //2.金额
        if(billsAmount > billsAmountView){
            errorflag=true;
            errorMessage=errorMessage+"有效金额不能大于票面金额！" ;
        }else{
            //如果符合规则，则将有效金额赋值给应收账款余额
            $scope.otherform.remainingAmount=$scope.otherform.billsAmount;
        }
    }
    $scope.save_onClick=function(){
            if($.doValidate("otherform")){
                checkFormRule();
                if(errorflag){
                    $common.get_tipDialog(errorMessage,'showError');
                    errorflag=false;
                    errorMessage="";
                }else{
                    var primise = $common.get_asyncData('rBcpDebtBaseInfoService/updateRBcpDebtBaseInfo',{rBcpDebtBaseInfo:$scope.otherform})
                    primise.then(function(res){
                        if (res.errorCode =="SUC"){
                            $common.get_tipDialog('修改成功！', 'showSuccess');
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                }
            }
        }
    //back
    $scope.back_onClick=function(){
        $state.go("bcpInfoList");//返回首页面
    }
};

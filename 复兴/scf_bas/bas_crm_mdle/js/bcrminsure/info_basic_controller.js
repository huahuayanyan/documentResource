/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var InsureBasicController = function($scope,$common,$state,dataDeliver){
    //JSON.stringify(userInfo)
    ////*****************初始化开始******************//
    //var data1 = dataDeliver.getter();
    //var flag=data1.flag;
    //var ccmsCustcdVal = data1.bCrmBaseInfo.ccmsCustcd;
    //
    //$scope.otherform={//页面初始化字段 coreFlag
    //    orgCode:"",
    //    coreFlag:"1",
    //    brManagerNo:userInfo.brManagerNo,
    //    brNo:userInfo.brNo,
    //    mgrno:"",//管户员初始化
    //    industryType:"",//数据库国际行业代码的字段
    //    industryTypeName:"",//页面的国际行业代码名称
    //    area:"",//区域，省份，直辖市
    //    ccmsCustcd:"",
    //    tlrcd:""
    //};
    //
    //
    //
    //var bCrmBrInfo={//   brManagerName,brName
    //    brNo:userInfo.brNo
    //};
    //
    /////前台页面赋值(不通过flag去决定是否到后台查询数据，而是什么时候都要查询，防止，新增成功之后，去账户信息等页面，再跳转回此页面)
    //var bCrmBaseInfo={
    //    orgCode:data1.orgCode
    //};
    //
    //$common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByKey2",{bCrmBaseInfoAndEntInfo:bCrmBaseInfo}).then(function(res){
    //    if (res.errorCode =="SUC") {
    //        if(res.contextData.idno){
    //            res.contextData.idno=parseFloat(res.contextData.idno) ;
    //        }
    //        $scope.otherform=res.contextData;
    //        //经办机构，操作人页面数据赋值
    //        var primiseB = $common.get_asyncData("bCrmBaseInfoService/findBCrmBrInfo",{bCrmBrInfo:bCrmBrInfo});
    //        primiseB.then(function(res1){
    //            if (res1.errorCode =="SUC") {
    //                $scope.otherform.brName=res1.contextData.brName;
    //            }else{
    //                $common.get_tipDialog(res1.errorMsg,'showError');
    //            }
    //        });
    //        $scope.otherform.tlrName=userInfo.tlrName;
    //        //根据状态初始化信息
    //        if (flag == "add"){//先把之前的客户经理缺失的给加上去
    //            $scope.otherform.insureFlag="1";//防止是一个已注册的非授信客户转成授信客户时候，授信客户标识不为1
    //            $scope.otherform.ccmsCustcd=data1.bCrmBaseInfo.ccmsCustcd;
    //            $scope.otherform.orgCode =data1.orgCode;
    //            //$scope.otherform.importantFlag="0";
    //        }else if (flag == "view"){ //查看的时候有两个功能1.保存按钮隐藏！2.页面所有字段全部不可读
    //            $scope.disable=true;
    //            $scope.hide1=true;
    //            $scope.otherform = data1.bCrmBaseInfo
    //
    //            var qryParams={customerQryVO: {custcd:data1.bCrmBaseInfo.custcd}}
    //            $common.get_asyncData("bCrmInsureCustomerService/findCustomerInfoDetails",qryParams ).then(function (res) {
    //                if (res.errorCode == "SUC") {//如果查到，提示，此组织机构代码已使用，不可新增！
    //                    //var data2 = res.contextData;
    //                    $scope.otherform = res.contextData;
    //                }else {
    //                    $common.get_tipDialog(res.errorMsg, 'showError');
    //                };
    //            });
    //
    //        }else if(flag == "update"){
    //            $scope.otherform=data1.bCrmBaseInfo;
    //            $scope.otherform.insureFlag=1;
    //        }
    //
    //    }else{
    //        $common.get_tipDialog(res.errorMsg,'showError');
    //    }
    //});
    //
    //
    ////*************国标行业分类******************//
    //$scope.industryTypeContent = {
    //    type:"tree",//展示类型table  tree
    //    url:"bBrpIndustryTypesService/findBBrpIndustryTypesTree",//请求url
    //    //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
    //    split:"-",//分隔符
    //    extentColumn:["treeName"],
    //    column:["treeName","treeId"]//展示内容
    //};
    //
    //$scope.industryTypeExtent = function(ds){
    //    $scope.otherform.industryType=ds.treeId;
    //};
    //
    //$scope.$watch("otherform.industryTypeName",function(){
    //    $scope.industryTypeContent.param ={
    //        industryName:$scope.otherform.industryTypeName,
    //    }
    //});
    ////*************国标行业分类******************//
    //
    ////*************省份、直辖市、自治区下拉查询******************//
    ////（数据库area字段为100长度，此处可直接存储对应地区名称，而不是代码。）
    //$scope.areaContent = {
    //    type:"table",//展示类型table  tree
    //    url:"bSysRegionService/findBSysRegionByPage",//请求url
    //    //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
    //    split:"-",//分隔符*/
    //    extentColumn:"regionName",
    //    column:["regionName"]//展示内容
    //};
    //
    //$scope.dooextent = function(ds){
    //    $scope.otherform.area=ds.regionName;
    //};
    //
    //$scope.$watch("otherform.area",function(){
    //    $scope.areaContent.param ={
    //        regionName:$scope.otherform.area,
    //    }
    //});
    ////*************省份、直辖市、自治区下拉查询******************//
    //
    //
    ////*****************初始化结束******************//
    //
    //
    ////新增按钮
    //$scope.confirm_onClick = function(){
    //    //当前日期
    //    var date=new Date();
    //    var y = date.getFullYear();
    //    var m = date.getMonth() + 1;
    //    var d = date.getDate();
    //    if(m < 10){
    //        m = "0" + m;
    //    }
    //    if(d < 10){
    //        d = "0" + d;
    //    }
    //    $scope.otherform.sysDate="" + y + m + d;//出质日期为当天
    //    var sysDate=parseFloat($scope.otherform.sysDate);
    //
    //    if($.doValidate("otherform")) {//mgrno，tlrNo
    //        var establishDate=parseFloat($scope.otherform.establishDate);//企业成立日期
    //        if(establishDate > sysDate){
    //            $common.get_tipDialog("企业成立日期不可在当前日期之后",'showError');
    //        }else {
    //            if(flag=="add") {
    //                //{客户基本信息和企业基本信息表的对应的页面内容，放在同一个service中进行。
    //                $common.get_asyncData("bCrmInsureCustomerService/addOrUpdateCustomer", {customerVO: $scope.otherform}).then(function (res) {
    //                    if (res.errorCode == "SUC") {//客户信息新增成功，企业信息
    //                        $common.get_tipDialog('新增成功！', 'showSuccess');
    //                    } else {
    //                        $common.get_tipDialog(res.errorMsg, 'showError');
    //                    };
    //                });
    //            } else if (flag == "update") {//更新的时候，需要获取客户号，到企业信息表中去查询，然后将结果赋值给页面，然后修改的时候再价格修改的数据传给后台
    //                //因为客户号好组织机构代码都是唯一的，都在页面钉死了，所以，不需要查重，去重。
    //                var primise = $common.get_asyncData('bCrmInsureCustomerService/addOrUpdateCustomer', {customerVO: $scope.otherform});
    //                primise.then(function (res) {
    //                    if (res.errorCode == "SUC") {
    //                        $common.get_tipDialog('更新成功！', 'showSuccess');
    //                    } else {
    //                        $common.get_tipDialog(res.errorMsg, 'showError');
    //                    }
    //                });
    //            }
    //        }
    //    }else{
    //        $common.get_tipDialog('页面客户信息数据格式有误！','showError');
    //    }
    //};
    ////点击取消按钮，返回原来页面，并且让原来页面刷新！
    //$scope.confuse_onClick=function(){
    //    $state.go("base");
    //}



    var dataGet =dataDeliver.getter();
    var flag = dataGet.flag;
    //var orgCodeVal = dataGet.orgCode;
    $scope.otherform={};
    $scope.otherform=dataGet.bCrmBaseInfo;


    $scope.disable=false;
    $scope.hide=false;

    if(flag=="add"){
        $scope.otherform.industryTypeName='';
        $scope.otherform.area='';
    }

    if(flag=="view"){
        $scope.disable=true;
        $scope.hide=true;
    }

    //========初始化国标行业分类开始========//
    $scope.industryTypeContent = {
        type:"tree",
        url:"bBrpIndustryTypesService/findBBrpIndustryTypesTree",
        split:"-",
        extentColumn:"treeName",
        column:["treeName","treeId"]
    };

    $scope.industryTypeExtent =function(ds){
        $scope.otherform.industryType=ds.treeId;
    }

    $scope.$watch("otherfrom.industryTypeName",function(){
        $scope.industryTypeContent.param ={
            industryName:$scope.otherform.industryTypeName
        }
    });
    //=========初始化国标行业分类结束=========//

    //=========初始化省份、直辖市、自治区开始=========//
    $scope.areaContent = {
        type:"table",//展示类型table  tree
        url:"bSysRegionService/findBSysRegionByPage",//请求url
        //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"-",//分隔符*/
        extentColumn:"regionName",
        column:["regionName","regionCode"]//展示内容
    };

    $scope.areaExtent = function(ds){
        $scope.otherform.area=ds.regionName;
    };

    $scope.$watch("otherform.area",function(){
        $scope.areaContent.param ={
            regionName:$scope.otherform.area,
        }
    });
    //=========初始化省份、直辖市、自治区结束=========//


    $scope.confirm_onClick = function(){
        if($.doValidate("otherform")){
            var establishDateVal = parseFloat($scope.otherform.establishDate);
            if(compareThisDate(establishDateVal)){
                $common.get_tipDialog("企业成立日期不可在当前日期之后，请确认","showError");
            }else{
                var data ={
                    customerVO:$scope.otherform
                }
                $common.get_asyncData("bCrmInsureCustomerService/addOrUpdateCustomer",data).then(
                    function(res){
                        if(res.errorCode=="SUC"){
                            if(flag=="add"){
                                $common.get_tipDialog("新增成功",'showSuccess');
                            }else if(flag=="update"){
                                $common.get_tipDialog("修改成功",'showSuccess');
                            }
                        }else{
                            $common.get_tipDialog(res.errorMsg,"showError");
                        }
                    }
                );
            }
        }
    }

    //点击取消按钮，返回原来页面，并且让原来页面刷新！
    $scope.confuse_onClick=function(){
        $state.go("base");
    }


    function compareThisDate(val){
        //当前日期
        var date=new Date();
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        if(m < 10){
            m = "0" + m;
        }
        if(d < 10){
            d = "0" + d;
        }
        $scope.otherform.sysDate="" + y + m + d;//出质日期为当天
        var thisDate =parseFloat($scope.otherform.sysDate);
        var flag = false;
        if(val>=thisDate){
            flag = true;
        }
        return flag;
    }

};

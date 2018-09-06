/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var TabBasicInfoController = function($scope,$common,$state,dataDeliver){
    var dataGet =dataDeliver.getter();
    var flag = dataGet.flag;
    //var orgCodeVal = dataGet.orgCode;
    $scope.otherform={};
    $scope.otherform=dataGet.bCrmBaseInfo;

    if(flag=="add"){
        $scope.otherform.industryTypeName='';
        $scope.otherform.area='';
    }

    //========初始化国标行业分类========//
    $scope.industryTypeContent = {
        type:"tree",
        url:"bBrpIndustryTypesService/findBBrpIndustryTypesTree",
        split:"-",
        extentColumn:"treeName",
        column:['treeName','treeId']
    };

    $scope.industryTypeExtent =function(ds){
        $scope.otherform.industryType=ds.treeId;
    }

    $scope.$watch("otherfrom.industryTypeName",function(){
        $scope.industryTypeContent.param ={
            industryName:$scope.otherform.industryTypeName
        }
    });
    //=========初始化国标行业分类=========//

    //=========初始化省份、直辖市、自治区=========//
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
    //=========初始化省份、直辖市、自治区=========//

    $scope.disable=false;
    $scope.hide=false;

    if(flag=="view"){
        $scope.disable=true;
        $scope.hide1=true;
    }



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
                            }else if(flag =="update"){
                                $common.get_tipDialog("更新成功",'showSuccess');
                            }
                        }else{
                            $common.get_tipDialog(res.errorMsg,"showError");
                        }
                    }
                );
            }
        }
    }

    $scope.back_onClick = function(){
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

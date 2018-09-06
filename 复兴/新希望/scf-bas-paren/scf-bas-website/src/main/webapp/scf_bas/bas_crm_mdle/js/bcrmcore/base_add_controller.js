/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var BaseAddController = function($scope,$common,$state,dataDeliver){
    //JSON.stringify(userInfo)
    var data1 = dataDeliver.getter();
    var flag=data1.flag;
    $scope.otherform={//页面初始化字段 coreFlag
        orgCode:"",
        coreFlag:"1",
        brManagerNo:userInfo.brManagerNo,
        brNo:userInfo.brNo,
        mgrno:"",//管户员初始化
        industryType:"",//数据库国际行业代码的字段
        industryTypeName:"",//页面的国际行业代码名称
        area:""//区域，省份，直辖市
    };
    var bCrmBrInfo={//   brManagerName,brName
        brNo:userInfo.brNo
    }
    ///前台页面赋值(不通过flag去决定是否到后台查询数据，而是什么时候都要查询，防止，新增成功之后，去账户信息等页面，再跳转回此页面)
    var bCrmBaseInfo={
        orgCode:data1.orgCode
    };
    var primiseA = $common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByKey2",{bCrmBaseInfoAndEntInfo:bCrmBaseInfo});
    primiseA.then(function(res){
        if (res.errorCode =="SUC") {
            //这里有一个上下游关系字段需要修改一下
            if(res.contextData.supplyPosition){
                res.contextData.supplyPosition=res.contextData.supplyPosition.split(",");
            }
            $scope.otherform=res.contextData;
            //经办机构，操作人页面数据赋值
            var primiseB = $common.get_asyncData("bCrmBaseInfoService/findBCrmBrInfo",{bCrmBrInfo:bCrmBrInfo});
            primiseB.then(function(res1){
                if (res1.errorCode =="SUC") {
                    $scope.otherform.brName=res1.contextData.brName;
                }else{
                    $common.get_tipDialog(res1.errorMsg,'showError');
                }
            });
            $scope.otherform.coreFlag="1";
            $scope.otherform.tlrName=userInfo.tlrName;
            if(flag=="add"){//新增的时候需要考虑到数据库查不出来空值赋给页面，需要进行页面初始化。
                $scope.otherform.orgCode=data1.orgCode;
                $scope.otherform.importantFlag="0";//默认是非重点客户
            }
        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
    //修改，查看初始化
    if (flag == "update"){//先把之前的客户经理缺失的给加上去
        $scope.otherform.coreFlag="1";//防止是一个已注册的非授信客户转成授信客户时候，授信客户标识不为1
    }else if (flag == "view"){ //查看的时候有两个功能1.保存按钮隐藏！2.页面所有字段全部不可读
        $scope.disable=true;
        $scope.hide1=true;
    };
    //国际行业分类(不支持页面的模糊查询。)
    $scope.industryTypeContent = {
        type:"tree",//展示类型table  tree
        url:"bBrpIndustryTypesService/findBBrpIndustryTypesTree",//请求url
        //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"-",//分隔符
        extentColumn:["treeName"],
        column:["treeName","treeId"]//展示内容
    };
    $scope.industryTypeExtent = function(ds){
        $scope.otherform.industryType=ds.treeId;
    };
    $scope.$watch("otherform.industryTypeName",function(){
        $scope.industryTypeContent.param ={
            industryName:$scope.otherform.industryTypeName,
        }
    });
    //省份、直辖市、自治区下拉查询（数据库area字段为100长度，此处可直接存储对应地区名称，而不是代码。）
  /*    $scope.areaContent = {
        type:"table",//展示类型table  tree
        url:"bSysRegionService/findBSysRegionByPage",//请求url
        //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"",//分隔符
        extentColumn:"regionName",
        column:["regionName"]//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.otherform.areaName=ds.regionName;
        $scope.otherform.area=ds.regionCode;
        //areaName regionCode
    };
    $scope.$watch("otherform.areaName",function(){
        $scope.areaContent.param ={
            regionName:$scope.otherform.areaName,
        }
    });*/
    //省份、直辖市、自治区下拉查询（数据库area字段为100长度，此处可直接存储对应地区名称，而不是代码。）
    $scope.areaContent_one = {
        type:"table",//展示类型table  tree
        url:"bSysRegionService/findBSysRegionByPage",//请求url
        param:{flag:1},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"",//分隔符*/
        extentColumn:"regionName",
        column:["regionName"]//展示内容
    };
    $scope.areaContent_two = {
            type:"table",//展示类型table  tree
            url:"bSysRegionService/findBSysRegionByPage",//请求url
            param:{flag:2},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
            split:"",//分隔符*/
            extentColumn:"regionName",
            column:["regionName"]//展示内容
        };
    $scope.areaContent_three = {
            type:"table",//展示类型table  tree
            url:"bSysRegionService/findBSysRegionByPage",//请求url
            param:{flag:3},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
            split:"",//分隔符*/
            extentColumn:"regionName",
            column:["regionName"]//展示内容
        };
    $scope.dooextent_one = function(ds){
        $scope.otherform.provinceName=ds.regionName;
        $scope.otherform.province=ds.regionCode;
        $scope.areaContent_two.param.upCode=ds.regionCode;
        
        $scope.otherform.cityName='';
        $scope.otherform.city='';
        $scope.otherform.areaName='';
        $scope.otherform.area='';
    };
    $scope.dooextent_two = function(ds){
        $scope.otherform.cityName=ds.regionName;
        $scope.otherform.city=ds.regionCode;
        $scope.areaContent_three.param.upCode=ds.regionCode;
        
        $scope.otherform.areaName='';
        $scope.otherform.area='';
    };
    $scope.dooextent_three = function(ds){
        $scope.otherform.areaName=ds.regionName;
        $scope.otherform.area=ds.regionCode;
    };
    $scope.$watch("otherform.provinceName",function(){
        $scope.areaContent_one.param.regionName=$scope.otherform.provinceName;
        if(!$scope.otherform.provinceName){
        	 $scope.areaContent_one.param.regionCode='';
        	 $scope.areaContent_two.param.upCode='';
        	 $scope.areaContent_three.param.upCode='';
        	 $scope.otherform.cityName='';
             $scope.otherform.city='';
             $scope.otherform.areaName='';
             $scope.otherform.area='';
        }
    });
    $scope.$watch("otherform.cityName",function(){
    	$scope.areaContent_two.param.regionName=$scope.otherform.cityName;
    	
    	if(!$scope.otherform.cityName){
    		$scope.areaContent_two.param.regionCode='';
    		$scope.areaContent_three.param.upCode='';
            $scope.otherform.city='';
            $scope.otherform.areaName='';
            $scope.otherform.area='';
       }
    });
    $scope.$watch("otherform.areaName",function(){
        	$scope.areaContent_three.param.regionName=$scope.otherform.areaName;
    });   
    
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
    var sysDate=parseFloat($scope.otherform.sysDate);
    //页面数据字段格式校验
    var errorFlag=false;//默认为false，无错误信息
    var errorMessage="";
    function checkFormRules(){
        //客户名称(因为已经doValidate，作为必输项肯定有内容)
        var cname=$scope.otherform.cname;
        if(cname.length > 80){
            errorFlag=true;
            errorMessage=errorMessage+"客户名称过长！"+"\n";
        }
        //证件类型和证件号码
        //01 组织机构代码证 02 营业执照 03 其他企业证件 04 社会信用代码证 05 个人身份证
        if($scope.otherform.idtype){
            if($scope.otherform.idno && $scope.otherform.idno != "" ){
                var idno=$scope.otherform.idno;
                if($scope.otherform.idtype == "01"){
                    var regTel = new RegExp(/^[A-Za-z0-9]{8}-[A-Za-z0-9]{1}$/);
                    var r = regTel.test(idno);
                    if(!r){
                        errorFlag=true;
                        errorMessage=errorMessage+"“组织机构代码”证件号码格式应为8位数字或者英文字母+'-'+1位数字或者英文字母！"+"\n";
                    }
                }
                if($scope.otherform.idtype == "02"){
                    var regTel = new RegExp(/^\d{15}$/);
                    var r = regTel.test(idno);
                    if(!r){
                        errorFlag=true;
                        errorMessage=errorMessage+"“营业执照”证件号码格式应为15位数字！"+"\n";
                    }
                }
                if($scope.otherform.idtype == "03"){
                    var regTel = new RegExp(/^[A-Za-z0-9]{1,32}$/);
                    var r = regTel.test(idno);
                    if(!r){
                        errorFlag=true;
                        errorMessage=errorMessage+"“其他企业证件”证件号码格式默认为32位内数字或者英文字母或者组合！"+"\n";
                    }
                }
                if($scope.otherform.idtype == "04"){
                    var regTel = new RegExp(/^[0-9A-Z]{18}$/);
                    var r = regTel.test(idno);
                    if(!r){
                        errorFlag=true;
                        errorMessage=errorMessage+"“社会信用代码证”证件号码格式应为18位数字或者英文字母或者组合！"+"\n";
                    }
                }
                if($scope.otherform.idtype == "05"){
                    var regTel = new RegExp(/^([0-9]{15})|([0-9]{17}([0-9]|X))$/);
                    var r = regTel.test(idno);
                    if(!r){
                        errorFlag=true;
                        errorMessage=errorMessage+"“个人身份证”证件号码格式错误！"+"\n";
                    }
                }
            }
        }
        if($scope.otherform.idno && $scope.otherform.idno !=""&& (!$scope.otherform.idtype || $scope.otherform.idtype=="")){
            //证件号码不为空，证件类型丢失
            errorFlag=true;
            errorMessage=errorMessage+"请选择证件类型！"+"\n";
        }
        //电话号码
        if($scope.otherform.contactTel){
            var contactTel=$scope.otherform.contactTel;
            if(contactTel.length > 0){
                var regTel = new RegExp(/^(\d{11})$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/);
                var r = regTel.test(contactTel);
                if(!r){
                    errorFlag=true;
                    errorMessage=errorMessage+"请输入正确的电话号码！"+"\n";
                }
            }
        }
        //传真号码

        if($scope.otherform.fax){
            var fax=$scope.otherform.fax;
            if( 0 < fax.length < 30){
                var fax_regTel = new RegExp(/^(\d{11})$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/);
                var fax_r = fax_regTel.test(fax);
                if(!fax_r){
                    errorFlag=true;
                    errorMessage=errorMessage+"请输入正确的传真号码！"+"\n";
                }
            }else if(fax.length >= 30){
                errorFlag=true;
                errorMessage=errorMessage+"传真号码长度过长！"+"\n";
            }
        }
        //地址 contactAddr
        if($scope.otherform.contactAddr){
            var contactAddr=$scope.otherform.contactAddr;
            if(contactAddr.length > 50){
                errorFlag=true;
                errorMessage=errorMessage+"地址长度过长！"+"\n";
            }
        }
        //注册资本 regCapital
        if($scope.otherform.regCapital){
            var regCapital=$scope.otherform.regCapital;
            if(regCapital.length > 22){
                errorFlag=true;
                errorMessage=errorMessage+"注册资本长度不得超过22位！"+"\n";
            }
        }
        //英文名称 /[a-zA-Z]/
        if($scope.otherform.ename){
            var ename=$scope.otherform.ename;
            if( 0 <ename.length <100 ){
                var ename_regTel = new RegExp(/[a-zA-Z]/);
                var ename_r = ename_regTel.test(ename);
                if(!ename_r){
                    errorFlag=true;
                    errorMessage=errorMessage+"英文名称格式错误！"+"\n";
                }
            }else if(ename.length >100){
                errorFlag=true;
                errorMessage=errorMessage+"英文名称过长！"+"\n";
            }
        }
    }
    //新增按钮
    $scope.confirm_onClick = function(){
        $scope.otherform.coreFlag="1";
        if($.doValidate("otherform")) {//mgrno，tlrNo
            var establishDate=parseFloat($scope.otherform.establishDate);//企业成立日期
            if(establishDate > sysDate){
                $common.get_tipDialog("企业成立日期不可在当前日期之后",'showError');
            }else {
                checkFormRules();
                if(errorFlag){
                    var length = errorMessage.lastIndexOf("\n")-1;
                    errorMessage.substring(length);
                    $common.get_tipDialog(errorMessage,'showError');
                    errorMessage="";
                    errorFlag=false;
                }else{
                    $scope.otherform.mgrno = userInfo.tlrNo;//页面管户员初始化赋值。
                    if (flag == "add") {
                        //在查询重复数据的时候干脆把国际行业代码和省份直辖市自治区的数据校验都做掉
                        var primise2 = $common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByKey", {bCrmBaseInfo: $scope.otherform});
                        primise2.then(function (res) {
                            if (res.errorCode == "SUC") {//如果查到，提示，此组织机构代码已使用，不可新增！
                                var data2 = res.contextData;
                                if (data2.orgCode == $scope.otherform.orgCode) {//说明是已经新增，然后又回来修改的
                                    var primise = $common.get_asyncData('bCrmBaseInfoService/update', {bCrmBaseInfo: $scope.otherform});
                                    primise.then(function (res) {
                                        if (res.errorCode == "SUC") {
                                            $common.get_tipDialog('保存成功！', 'showSuccess');
                                        } else {
                                            $common.get_tipDialog(res.errorMsg, 'showError');
                                        }
                                    });
                                } else {//客户基本信息和企业基本信息表的对应的页面内容，放在同一个service中进行。
                                    var primise3 = $common.get_asyncData("bCrmBaseInfoService/addBcrmBaseInfo", {bCrmBaseInfo: $scope.otherform});
                                    primise3.then(function (res) {
                                        if (res.errorCode == "SUC") {//客户信息新增成功，企业信息
                                            $scope.otherform=res.contextData;
                                          //新增之后将客户信息放到dataDeliver中
                                            var data = {
                                            	bCrmBaseInfo : res.contextData
                                            };
                                            dataDeliver.setter(data);
                                            $common.get_tipDialog('保存成功！', 'showSuccess');
                                        } else {
                                            $common.get_tipDialog(res.errorMsg, 'showError');
                                        }
                                        ;
                                    });
                                }
                            } else {
                                $common.get_tipDialog(res.errorMsg, 'showError');
                            }
                            ;
                        });
                    } else if (flag == "update") {//更新的时候，需要获取客户号，到企业信息表中去查询，然后将结果赋值给页面，然后修改的时候再价格修改的数据传给后台
                        //因为客户号好组织机构代码都是唯一的，都在页面钉死了，所以，不需要查重，去重。
                        var primise = $common.get_asyncData('bCrmBaseInfoService/update', {bCrmBaseInfo: $scope.otherform});
                        primise.then(function (res) {
                            if (res.errorCode == "SUC") {
                                $common.get_tipDialog('保存成功！', 'showSuccess');
                            } else {
                                $common.get_tipDialog(res.errorMsg, 'showError');
                            }
                        });
                    }
                }
            }
        }
    };
    //点击取消按钮，返回原来页面，并且让原来页面刷新！
    $scope.confuse_onClick=function(){
        $state.go("base");
    }
    /*dialogScope.closeThisDialog_onClick = function(){
     dialogScope.closeThisDialog();
     };*/
};

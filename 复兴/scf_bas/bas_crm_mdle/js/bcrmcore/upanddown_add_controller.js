/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var UpanddownAddController = function(dialogScope,parentScope,$common,flag,row){
    <!-- disable1修改的时候客户名称是不可以修改的，状态在修改的时候是可以修改的，新增的时候，状态是默认为有效的，1，hide是true，hide1在查看的时候是隐藏的 -->
    dialogScope.otherform={//一定不要忘记先给页面定义一个客户号字段，现在页面是没有客户号输入字段的。
        custcd:"",
        coreCustName:""
    };
    dialogScope.disable=false;
    if(flag == "add"){
        dialogScope.otherform={//定义form对象
            coreCustcd:row.coreCustcd,//核心客户的客户号
            coreCustName:row.coreCustName,//核心客户名称
            state:"1",//新增的时候默认客户状态为有效
        };
        dialogScope.disable2=true;//状态默认为有效只读
        dialogScope.hide=true;
        dialogScope.otherform.tlrName=userInfo.tlrName;
    }else if (flag == "update"){//点击修改的时候，这个时候客户号是能修改的，但是应该不能修改，因为页面显示是以客户号为主不是ID
        dialogScope.otherform=$common.copy(parentScope.selected.select[0]);
        dialogScope.disable1=true;
        dialogScope.otherform.tlrName=userInfo.tlrName;
    }else if (flag == "view"){//查看的时候有两个功能1.保存按钮隐藏！2.页面所有字段全部不可读
        dialogScope.otherform=row
        dialogScope.disable=true;
        dialogScope.disable1=true;//页面保存按钮
        dialogScope.disable2=true;//状态
        dialogScope.hide1=true;
    };
    if(flag != "view"){
        var bCrmBrInfo={
            brNo:userInfo.brNo,
        }
        var primise1 = $common.get_asyncData("bCrmBaseInfoService/findBCrmBrInfo",{bCrmBrInfo:bCrmBrInfo});
        primise1.then(function(res1){
            if (res1.errorCode == "SUC") {
                if(res1.contextData != null && res1.contextData!=""){
                    dialogScope.otherform.brName=res1.contextData.brName;
                }else{
                    $common.get_tipDialog("经办机构信息查询失败！", 'showError');
                }
            }else{
                $common.get_tipDialog(res1.errorMsg, 'showError');
            }
        });
    }
    var coreCustcd1=dialogScope.otherform.coreCustcd;//这个是核心厂商的客户号，不是在这个页面输入的客户号

    //页面客户名称查询框
    dialogScope.cnameContent = {
        type:"table",//展示类型table  tree
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"-",//分隔符
        extentColumn:"cname",
        column:["custcd","cname"]//展示内容
    };
    dialogScope.cnameExtent = function(ds){
        dialogScope.otherform.custcd=ds.custcd;
        if (dialogScope.otherform.custcd != "") {
            var bCrmBaseInfo1 = {
                custcd: dialogScope.otherform.custcd
            };
            var primise = $common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByKey", {bCrmBaseInfo: bCrmBaseInfo1});
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    if (res.contextData.custcd == bCrmBaseInfo1.custcd) {//查到对应客户则将对应组织机构代码赋值给页面字段orgCode
                        dialogScope.otherform.orgCode = res.contextData.orgCode
                    } else {//没有查询到对应数据，则提示不存在该用户。
                        $common.get_tipDialog('不存在对应组织机构代码！', 'showError');
                    }
                } else {
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        }
    };
    dialogScope.$watch("otherform.cname",function(){
        dialogScope.cnameContent.param ={
            cname:dialogScope.otherform.cname,
        }
    });
//----------------------------点击事件---------------------------------------
    //去重功能直接将页面数据传入后台，不需要考虑页面的经办人和经办机构有影响，因为后台只取6个字段进行查询，但是绝对不能传ID
    dialogScope.confirm_onClick = function(){
        if($.doValidate("otherform")) {
            if(dialogScope.otherform.custcd != coreCustcd1) {//客户号不能与核心客户号重复
                if (flag == "add") {//新增和修改操作之前都要去重，都不能将ID传过去，但是修改的时候需要将ID传过去。
                    //后台查重字段ID,核心厂商客户号,客户号,添加状态state,组织机构代码,与核心厂商关系coreRelationFlg
                    var bCrmUpanddownRel2={//不能有ID字段，要不然不可能会查到重复数据。
                        coreCustcd:coreCustcd1,
                        custcd:dialogScope.otherform.custcd,
                        state:dialogScope.otherform.state,
                        orgCode:dialogScope.otherform.orgCode,
                        coreRelationFlg:dialogScope.otherform.coreRelationFlg
                    };
                    var primise = $common.get_asyncData("bCrmUpanddownRelService/findBCrmUpanddownRelByKey", {bCrmUpanddownRel: bCrmUpanddownRel2});
                    primise.then(function (res) {
                        if (res.errorCode == "SUC") {
                            if (res.contextData != null && res.contextData.coreCustcd == coreCustcd1) {//查到对应的相同的客户，则提示错误。
                                $common.get_tipDialog('您添加的数据已经存在！', 'showError');
                            } else {//添加的时候就算是有ID也没有问题，后台会再设置一个ID给它。
                                var primise = $common.get_asyncData("bCrmUpanddownRelService/add", {bCrmUpanddownRel: dialogScope.otherform});
                                primise.then(function (res) {
                                    if (res.errorCode == "SUC") {
                                        parentScope.queryTable();
                                        parentScope.selected.select = [];
                                        dialogScope.closeThisDialog();
                                        parentScope.disable=false;
                                        $common.get_tipDialog('新增成功！', 'showSuccess');
                                    } else {
                                        $common.get_tipDialog(res.errorMsg, 'showError');
                                    }
                                });
                            }
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showError');
                        }
                    });

                } else if (flag == "update") {//修改之前先去重，再新建对象，将之前取出的ID再传给新对象。
                    var bCrmUpanddownRel2={//不能有ID字段，要不然不可能会查到重复数据。
                        coreCustcd:coreCustcd1,
                        custcd:dialogScope.otherform.custcd,
                        state:dialogScope.otherform.state,
                        orgCode:dialogScope.otherform.orgCode,
                        coreRelationFlg:dialogScope.otherform.coreRelationFlg
                    };
                    var primise = $common.get_asyncData("bCrmUpanddownRelService/findBCrmUpanddownRelByKey", {bCrmUpanddownRel: bCrmUpanddownRel2});
                    primise.then(function (res) {
                        if (res.errorCode == "SUC") {
                            if (res.contextData != null && res.contextData.coreCustcd == coreCustcd1) {//查到对应的相同的客户，则提示错误。
                                $common.get_tipDialog('您修改完成的数据已经存在！', 'showError');
                            } else {//没有查询到对应数据，则修改操作。必须传值ID
                                var primise = $common.get_asyncData("bCrmUpanddownRelService/update", {bCrmUpanddownRel:dialogScope.otherform});
                                primise.then(function (res) {
                                    if (res.errorCode == "SUC") {
                                        parentScope.queryTable();
                                        parentScope.selected.select = [];
                                        dialogScope.closeThisDialog();
                                        parentScope.disable=false;
                                        $common.get_tipDialog('修改成功！', 'showSuccess');
                                    } else {
                                        $common.get_tipDialog(res.errorMsg, 'showError');
                                    }
                                });
                            }
                        } else {
                            $common.get_tipDialog(res.errorMsg, 'showError');
                        }
                    });
                }//页面点击查看过来的时候，是没有确定按钮的。不需要考虑。
            }else{//页面上核心厂商客户号和客户号相同
                $common.get_tipDialog('核心厂商客户号和上下游客户号不能相同！','showError');
            }
        } else{
            $common.get_tipDialog('页面数据格式有误！','showError');
        }
    };
    dialogScope.closeThisDialog_onClick = function(){
        parentScope.disable=false;
        dialogScope.closeThisDialog();
    };
};

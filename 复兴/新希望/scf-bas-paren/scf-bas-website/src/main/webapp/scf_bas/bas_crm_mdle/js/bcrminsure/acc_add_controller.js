/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var AccInfoAddController =  function(dialogScope,parentScope,$common,flag,row){
    dialogScope.otherform={//初始化账户       brNameContent,brNameExtent,cnameContent,cnameExtent
        cname:"",//页面上的客户名称 brName,mgrName
        brNo:"",
        custcd:"",
    };
    dialogScope.disable=false;
    dialogScope.disable1=false;
    if(flag == "add"){//新增的是后客户号和客户名称就要给了disable1 accountNo
        dialogScope.otherform.custcd=row.custcd;
        dialogScope.otherform.cname=row.cname;
    }else if(flag == "update"){//根据客户号修改,修改的时候，经办机构是可以修改的。
        dialogScope.disable1=true;//新增的时候客户名称只读
        var acc=$common.copy(parentScope.selected.select[0]);
        acc.accountNo=parseFloat(acc.accountNo);
        dialogScope.otherform=acc;
    }else if(flag == "view"){//查看的时候，只读，确定按钮隐藏。
        row.accountNo=parseFloat(row.accountNo);
        dialogScope.otherform=row;
        dialogScope.disable=true;
        dialogScope.disable1=true;
        dialogScope.hide=true;
    }
    //页面经办机构初始化从后台查询(如果是查看的话就直接回显数据库数据)
    dialogScope.otherform.mgrName=userInfo.tlrName;
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


    //这里不能用客户名称或者经办机构名称去查询客户号或者经办机构名称，因为客户号可以唯一确定一个客户，但是客户名称不能唯一去顶客户号。
    //客户名称extent="custcdContent" on-change="custcdExtent",将页面客户名称和客户号输入功能
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
    };
    dialogScope.$watch("otherform.cname",function(){
        dialogScope.cnameContent.param ={
            cname:dialogScope.otherform.cname,
        }
    });
    //经办机构brName，brNo，brNameContent，brNameExtent
    dialogScope.brNameContent = {
        type:"table",//展示类型table  tree
        url:"bAccAccountInfoService/selectOrgByPage",//请求url
        //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"-",//分隔符
        extentColumn:"brName",
        column:["brNo","brName"]//展示内容
    };
    dialogScope.brNameExtent = function(ds){
        dialogScope.otherform.brcode=ds.brNo;
    };
    dialogScope.$watch("otherform.brName",function(){
        dialogScope.brNameContent.param ={
            brName:dialogScope.otherform.brName,
        }
    });

    dialogScope.confirm_onClick=function(){
        if($.doValidate("otherform")){//校验数据格式
            if(flag == "add"){//如果是新增，先去查重，如果有对应的帐号，则提示，该帐号已经被使用，不可新增！
                var bAccAccountInfo={//accountType，custcd，accountNo，这三者都一样就是重复了。
                    accountNo:dialogScope.otherform.accountNo,
                    accountType:dialogScope.otherform.accountType,
                    custcd:dialogScope.otherform.custcd,
                }
                var primise = $common.get_asyncData("bAccAccountInfoService/findBAccAccountInfoByKey",{bAccAccountInfo:bAccAccountInfo});
                primise.then(function(res){
                    if (res.errorCode == "SUC") {
                        var data1 = res.contextData;//查到的数据
                        if (data1.accountNo == dialogScope.otherform.accountNo) {//查到了数据
                            $common.get_tipDialog("该账户已经存在，不可新增！", 'showError');
                        } else {//
                            var primise = $common.get_asyncData("bAccAccountInfoService/add", {bAccAccountInfo: dialogScope.otherform});
                            primise.then(function (res) {
                                if (res.errorCode == "SUC") {
                                    parentScope.queryTable();
                                    parentScope.selected.select=[];
                                    dialogScope.closeThisDialog();
                                    parentScope.disable=false;
                                    $common.get_tipDialog('新增成功！', 'showSuccess');

                                } else {
                                    $common.get_tipDialog(res.errorMsg, 'showError');
                                }
                            });
                        }
                    }else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
            }else if(flag == "update"){//如果是修改,需要先根据帐号查询，如果帐号已经有了，则提示：修改的帐号已经存在，不可修改！
                //还有一种情况，就是说本身修改的时候，并未修改这三个数据，导致，实际查询的结果是有相同数据，但是其实是本身数据，这样就无法修改。
                //所以，应该将查询出的结果进行判断，如果是本身信息的ID，那就允许修改。
                var bAccAccountInfo={//accountType，custcd，accountNo，这三者都一样就是重复了。
                    accountNo:dialogScope.otherform.accountNo,
                    accountType:dialogScope.otherform.accountType,
                    custcd:dialogScope.otherform.custcd,
                }
                var primise = $common.get_asyncData("bAccAccountInfoService/findBAccAccountInfoByKey",{bAccAccountInfo:bAccAccountInfo});
                primise.then(function(res){
                    if (res.errorCode == "SUC") {
                        var data1 = res.contextData;//查到的数据
                        if (data1.accountNo == dialogScope.otherform.accountNo && data1.id !=dialogScope.otherform.id) {//查到了数据
                            $common.get_tipDialog("该账户信息已经存在！", 'showError');
                        } else {//
                            var primise = $common.get_asyncData("bAccAccountInfoService/update", {bAccAccountInfo: dialogScope.otherform});
                            primise.then(function (res) {
                                if (res.errorCode == "SUC") {
                                    parentScope.queryTable();
                                    parentScope.selected.select=[];
                                    dialogScope.closeThisDialog();
                                    parentScope.disable=false;
                                    $common.get_tipDialog('修改成功！', 'showSuccess');

                                } else {
                                    $common.get_tipDialog(res.errorMsg, 'showError');
                                }
                            });
                        }
                    }else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
            }
        }else{
            $common.get_tipDialog("页面数据格式错误！",'showError');
        }
    }
    dialogScope.closeThisDialog_onClick = function(){
        parentScope.disable=false;
        dialogScope.closeThisDialog();
    };
};

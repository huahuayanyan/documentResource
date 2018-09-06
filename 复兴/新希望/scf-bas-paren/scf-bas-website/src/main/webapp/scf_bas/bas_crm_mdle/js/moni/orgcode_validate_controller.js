/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var OrgCodeController =  function(dialogScope,parentScope,$common,$state,dataDeliver){
    //检查组织机构代码格式，之后的主要功能 ：通过组织机构代码去查询，1.如果有，要判断是否是该功能模块的组织机构代码2.没有则直接跳转到对应的新增页面
    //如果查到对应的数据，要再判断，1.如果也是该模块功能的客户，则提示，组织机构代码已经存在，不可新增。2.如果不是该模块用户，则提示该公司已经存在，
    // 但不是该功能模块用户，是否转为xx用户。1.如果确定转，则跳转到修改页面，将查到的客户赋值到上面去，点击确定就修改了。2.如果不决定转，则回到
    //组织机构代码框那以个页面
    dialogScope.otherform={};
    dialogScope.confirm_onClick=function(){
        if($.doValidate("otherform")){//校验数据格式
            var primise = $common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByKey",{bCrmBaseInfo:dialogScope.otherform});
            primise.then(function(res){
                if (res.errorCode == "SUC"){
                    var data1 = res.contextData;//查到的数据
                    if (data1.orgCode==dialogScope.otherform.orgCode && data1.moniFlag=="1" ){//查到的客户也是授信客户则提示该组织机构代码已经存在
                        $common.get_tipDialog("该组织机构代码已经存在，不可新增！",'showError');
                    }else if(data1.orgCode==dialogScope.otherform.orgCode && data1.moniFlag !="1" ) {//查到了客户，但是不是授信客户提示是否要转
                        var data= {
                            flag: "update",
                            bCrmBaseInfo:data1,
                            orgCode:data1.orgCode
                        };
                        $common.get_tipDialog('该用户已经存在，但并不是监管公司，是否保存为监管公司？','showTip').then(function(){//点击确定就直接会使用一下的功能
                            dataDeliver.setter(data);
                            $state.go("tree");
                        });
                    }else if(data1 == "" || data1.orgCode != dialogScope.otherform.orgCode){//不是上述两种状况，则直接跳转到新增页面，授信客户新增。
                        var data= {
                            flag: "add",
                            orgCode:dialogScope.otherform.orgCode
                        };
                        $state.go("tree");
                        dataDeliver.setter(data);
                    }
                    dialogScope.closeThisDialog();
                }else{
                    $common.get_tipDialog(res.errorMsg, 'showError');
                }
            });
        }
    }
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
   /* if (res.errorCode =="SUC"){
        $common.get_tipDialog("组织机构代码重复！",'showError');
    }*/
};

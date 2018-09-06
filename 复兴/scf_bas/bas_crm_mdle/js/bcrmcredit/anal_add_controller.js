/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var AnalAddController = function(dialogScope,parentScope,$common,flag,row){
    //根据flag改写页面属性disable是查看的时候页面只读，hide新增的时候登记日期和分析人隐藏。hide1是查看的时候隐藏保存按钮。
    dialogScope.otherform={
        id:"",
        custcd:"",
    };
    if(flag == "add"){
        dialogScope.otherform={
            custcd:row.custcd//定义页面的客户号
        };
    }else if(flag == "update"){//修改的时候是根据ID来修改的
        dialogScope.otherform=$common.copy(parentScope.selected.select[0]);
    }else if(flag == "view"){//查看的时候有两个功能1.保存按钮隐藏！2.页面所有字段全部不可读
        dialogScope.otherform=row;
        dialogScope.disable=true;
    }
    dialogScope.otherform.registerN=userInfo.tlrName;
    dialogScope.confirm_onClick = function(){
        if($.doValidate("otherform")) {
            if(flag == "add"){//这里添加是不需要去重的。
                var primise = $common.get_asyncData("bCrmAnalInfoService/add",{bCrmAnalInfo:dialogScope.otherform});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        parentScope.queryTable();
                        parentScope.selected.select=[];
                        dialogScope.closeThisDialog();
                        $common.get_tipDialog('新增成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            }else if (flag == "update"){
                var primise = $common.get_asyncData('bCrmAnalInfoService/update',{bCrmAnalInfo:dialogScope.otherform});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        parentScope.queryTable();
                        parentScope.selected.select=[];
                        dialogScope.closeThisDialog();
                        $common.get_tipDialog('更新成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            }
        }else{
            $common.get_tipDialog('页面数据格式有误！','showError');
        }
    };
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

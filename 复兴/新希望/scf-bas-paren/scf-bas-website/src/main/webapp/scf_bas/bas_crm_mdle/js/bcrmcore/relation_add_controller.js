/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var RelationAddController = function(dialogScope,parentScope,$common,flag,row){
    <!--hide1是在新增修改的的时候隐藏经办人经办机构 ，只有查看的时候才显示。 hide是在查看的时候隐藏确定按钮-->
    //根据flag改写页面属性
    if(flag == "add"){
        dialogScope.otherform={//定义form对象
            coreCustcd:row.coreCustcd//核心客户号
        };
        dialogScope.hide1=true;
    };
    if (flag == "update"){
        dialogScope.otherform=$common.copy(parentScope.selected.select[0]);
        dialogScope.hide1=true;
    };
    //查看的时候有两个功能1.保存按钮隐藏！2.页面所有字段全部不可读
    if (flag == "view"){
        dialogScope.otherform=row
        dialogScope.disable=true;
        dialogScope.hide=true;

    };
    //这里有一个问题，在点击事件之前，可以取到之前对应字段赋的值，但是在点击事件之后，页面隐藏的字段的信息就不能再读取了。
    var coreCustcd1=dialogScope.otherform.coreCustcd;
    var id1=dialogScope.otherform.id;
    dialogScope.confirm_onClick = function(){
        //alert(JSON.stringify(dialogScope.selectedDialog.select));
        if($.doValidate("otherform")) {
            if(flag == "add"){//新增的时候要先去查下，有没有对应的相同的数据，如果没有再用新增操作。对应主键是ID的表都要先查询下,会不会添加重复信息
                var primise = $common.get_asyncData("bCrmRelationInfoService/findBCrmRelationInfoByKey",{bCrmRelationInfo:dialogScope.otherform});
                primise.then(function(res){
                    if (res.contextData.coreCustcd == dialogScope.otherform.coreCustcd){//查到对应的相同的客户，则提示错误。
                        $common.get_tipDialog('您添加的数据已经存在！','showError');
                    }else{//没有查询到对应数据，则新增操作。
                        var primise = $common.get_asyncData("bCrmRelationInfoService/add",{bCrmRelationInfo:dialogScope.otherform});
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
                    };
                });

            }else if (flag == "update") {//修改之前的查重，所给数据不能带ID，否则无法查询到相同的数据。数据添加的时候，添加页面上是没有ID的。
                debugger
                var bCrmRelationInfo1={//coreCustcd,buyerCustcd,sellerCustcd,moniCustcd,state,relaType
                    coreCustcd:coreCustcd1,
                    buyerCustcd:dialogScope.otherform.buyerCustcd,
                    sellerCustcd:dialogScope.otherform.sellerCustcd,
                    moniCustcd:dialogScope.otherform.moniCustcd,
                    state:dialogScope.otherform.state,
                    relaType:dialogScope.otherform.relaType
                };
                var primise = $common.get_asyncData("bCrmRelationInfoService/findBCrmRelationInfoByKey", {bCrmRelationInfo:bCrmRelationInfo1});
                primise.then(function (res) {
                    if (res.contextData.coreCustcd == coreCustcd1) {//查到对应的相同的客户，则提示错误。
                        $common.get_tipDialog('此数据已经存在！', 'showError');
                    } else {//没有查询到对应数据，则修改操作，修改的时候是用ID来进行修改的。id1
                        var bCrmRelationInfo2={//coreCustcd,buyerCustcd,sellerCustcd,moniCustcd,state,relaType
                            id:id1,
                            coreCustcd:coreCustcd1,
                            buyerCustcd:dialogScope.otherform.buyerCustcd,
                            sellerCustcd:dialogScope.otherform.sellerCustcd,
                            moniCustcd:dialogScope.otherform.moniCustcd,
                            state:dialogScope.otherform.state,
                            relaType:dialogScope.otherform.relaType
                        };
                        var primise = $common.get_asyncData("bCrmRelationInfoService/update", {bCrmRelationInfo:bCrmRelationInfo2});
                        primise.then(function (res) {
                            if (res.errorCode == "SUC") {
                                parentScope.queryTable();
                                parentScope.selected.select = [];
                                dialogScope.closeThisDialog();
                                $common.get_tipDialog('新增成功！', 'showSuccess');
                            } else {
                                $common.get_tipDialog(res.errorMsg, 'showError');
                            }
                            ;
                        });
                    }
                    ;
                });
            }//页面点击查看过来的时候，是没有确定按钮的。
            } else{
            $common.get_tipDialog('页面数据格式有误！','showError');
        }
    };
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

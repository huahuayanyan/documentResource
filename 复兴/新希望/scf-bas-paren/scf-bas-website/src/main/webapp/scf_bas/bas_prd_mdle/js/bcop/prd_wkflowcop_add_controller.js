/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */
var PrdWkflowCopAddController =  function(dialogScope,parentScope,$common,flag,row){
    dialogScope.otherform={//初始化
        flowName:"",//页面上的流程组件名称
        flowCopId:"",
    };


    if(flag == "add"){
    }else if(flag == "update"){//根据客户号修改
        dialogScope.disable1=true;
        dialogScope.otherform=$common.copy(parentScope.selected.select[0]);
    }else if(flag == "view"){//查看的时候，只读，确定按钮隐藏。
        dialogScope.otherform=row;
        dialogScope.disable=true;
        dialogScope.disable1=true;
        dialogScope.hide1=true;
    }
    dialogScope.confirm_onClick=function(){
        if($.doValidate("otherform")){//校验数据格式
            if(flag == "add"){//如果是新增，先去查重，如果有对应的组件，则提示，该组件已经被使用，不可新增！
                var bPrdWkflowCop={//flowName，flowCopId这两者都一样就是重复了。
                    flowName:dialogScope.otherform.flowName,
                    flowCopId:dialogScope.otherform.flowCopId,
                }
                var primise = $common.get_asyncData("bPrdWkflowCopService/findBPrdWkflowCopByBPrd",{bPrdWkflowCop:bPrdWkflowCop});
                primise.then(function(res){
                    if (res.errorCode == "SUC") {
                        var data1s = res.contextData;//查到的数据是数组,取其中一个判断即可
                        var datal=null;
                        if(data1s.length>0 ){
                            datal =data1s[0];
                        }
                        if (datal!=null&&datal.flowName == dialogScope.otherform.flowName &&datal.flowCopId == dialogScope.otherform.flowCopId) {//查到了数据
                            $common.get_tipDialog("该流程组件已经存在，不可新增！", 'showError');
                        } else {//
                            var primise = $common.get_asyncData("bPrdWkflowCopService/add", {bPrdWkflowCop: dialogScope.otherform});
                            primise.then(function (res) {
                                if (res.errorCode == "SUC") {
                                    parentScope.queryTable();
                                    parentScope.selected.select=[];
                                    dialogScope.closeThisDialog();
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
            }else if(flag == "update"){//如果是修改,需要先根据组件查询，如果组件已经有了，则提示：修改的组件已经存在，不可修改！
                //还有一种情况，就是说本身修改的时候，并未修改这三个数据，导致，实际查询的结果是有相同数据，但是其实是本身数据，这样就无法修改。
                //所以，应该将查询出的结果进行判断，如果是本身信息的ID，那就允许修改。
                var bPrdWkflowCop={//flowName，flowCopId这两者都一样就是重复了。
                    flowName:dialogScope.otherform.flowName,
                    flowCopId:dialogScope.otherform.flowCopId,
                }
                var primise = $common.get_asyncData("bPrdWkflowCopService/findBPrdWkflowCopByBPrd",{bPrdWkflowCop:bPrdWkflowCop});
                primise.then(function(res){
                    if (res.errorCode == "SUC") {
                        var data1s = res.contextData;//查到的数据是数组,取其中一个判断即可
                        var datal=null;
                        if(data1s.length>0 ){
                            datal =data1s[0];
                        }
                        if (datal!=null&&datal.flowName == dialogScope.otherform.flowName && datal.flowCopId == dialogScope.otherform.flowCopId && datal.id !=dialogScope.otherform.id) {//查到了数据
                            $common.get_tipDialog("该组件信息已经存在，不可修改成此组件！", 'showError');
                        } else {//
                            var primise = $common.get_asyncData("bPrdWkflowCopService/update", {bPrdWkflowCop: dialogScope.otherform});
                            primise.then(function (res) {
                                if (res.errorCode == "SUC") {
                                    parentScope.queryTable();
                                    parentScope.selected.select=[];
                                    dialogScope.closeThisDialog();
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
        dialogScope.closeThisDialog();
    };
};

/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/10
 */
var claddController = function(dialogScope,parentScope,$common,flag) {
    if(flag == "add"){
        dialogScope.otherform={};//定义form对象
    }else if (flag == "update"){
        dialogScope.otherform=$common.copy(parentScope.selected.select[0]);
    };
    dialogScope.selectMdlCl = {
        ds:[
            {key:"1",value:'类型1'}
        ]
    }
    dialogScope.confirm_onClick = function(){
        if($.doValidate("otherform")) {
            dialogScope.flowsubmitdisable = true;
            if(flag == "add"){
                var checkId = $common.get_asyncData("bFinCnfgClService/checkMdlId",{mdlId:dialogScope.otherform.mdlId});
                checkId.then(function(res){
                    var dataId;
                    if (res.errorCode =="SUC"){
                        dataId = res.contextData.value;
                        var mdlId = dialogScope.otherform.mdlId;
                        if(dataId==mdlId)
                        {
                            $common.get_tipDialog('模型分类编号已存在，请重新输入……','showError');
                            dialogScope.flowsubmitdisable = false;
                        }
                        else
                        {
                            var checkNm = $common.get_asyncData("bFinCnfgClService/checkMdlNm",{mdlNm:dialogScope.otherform.mdlNm});
                            checkNm.then(function(res){
                                var dataNm;
                                if (res.errorCode =="SUC"){
                                    dataNm = res.contextData.value;
                                    var subjNm = dialogScope.otherform.mdlNm;
                                    if(dataNm==subjNm)
                                    {
                                        $common.get_tipDialog('模型分类名称已存在，请重新输入……','showError');
                                        dialogScope.flowsubmitdisable = false;
                                    }
                                    else
                                    {
                                        var checkTyp = $common.get_asyncData("bFinCnfgClService/checkMdlTyp",{bFinCnfgCl:dialogScope.otherform});
                                        checkTyp.then(function(res){
                                            var dataNm;
                                            if (res.errorCode =="SUC"){
                                                dataNm = res.contextData.value;
                                                if(dataNm=="false")
                                                {
                                                    $common.get_tipDialog('相同模型分类下的模型种类重复，请重新选择……','showError');
                                                    dialogScope.flowsubmitdisable = false;
                                                }
                                                else
                                                {
                                                    dialogScope.otherform.delFlg = "0";
                                                    var primise = $common.get_asyncData("bFinCnfgClService/add",{bFinCnfgCl:dialogScope.otherform});
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
                                                }
                                            }else{
                                                $common.get_tipDialog(res.errorMsg,'showError');
                                            };
                                        });
                                    }
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                };
                            });
                        }
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            }else if (flag == "update"){
                var checkNm = $common.get_asyncData("bFinCnfgClService/checkMdl",{bFinCnfgCl:dialogScope.otherform});
                checkNm.then(function(res){
                    var dataNm;
                    if (res.errorCode =="SUC"){
                        dataNm = res.contextData.value;
                        if(dataNm=="false")
                        {
                            $common.get_tipDialog('财报科目名称已存在，请重新输入……','showError');
                            dialogScope.flowsubmitdisable = false;
                        }
                        else
                        {
                            var checkTyp = $common.get_asyncData("bFinCnfgClService/checkMdlTypById",{bFinCnfgCl:dialogScope.otherform});
                            checkTyp.then(function(res){
                                var dataNm;
                                if (res.errorCode =="SUC"){
                                    dataNm = res.contextData.value;
                                    if(dataNm=="false")
                                    {
                                        $common.get_tipDialog('相同模型分类下的模型种类重复，请重新选择……','showError');
                                        dialogScope.flowsubmitdisable = false;
                                    }
                                    else
                                    {
                                        var primise = $common.get_asyncData('bFinCnfgClService/update',{bFinCnfgCl:dialogScope.otherform});
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
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                };
                            });
                        }
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                })
            };
        };
    };
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

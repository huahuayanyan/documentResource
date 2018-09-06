/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var lnvaleditController = function(dialogScope,parentScope,$common,flag) {
    if(flag == "add"){
        dialogScope.lnvalform={};//定义form对象
        dialogScope.lnvalform.state = "1";
        dialogScope.lnvalform.valStat = "1";
    }else if (flag == "update"){
        dialogScope.disable = true;
        dialogScope.lnvalform=$common.copy(parentScope.selected.select[0]);
    }else if(flag=="view"){
        dialogScope.disable = true;
        dialogScope.disableview = true;
        dialogScope.lnvalform=parentScope.row;
    };
    dialogScope.confirm_onClick = function(){
        if($.doValidate("lnvalform")) {
            var term = dialogScope.lnvalform.term;
            var ratecode = dialogScope.lnvalform.ratecode;
            if(term!=ratecode)
            {
                $common.get_tipDialog("期限选择与利率对应信息不符，请重新选择！",'showError');
                return;
            }
            var rateval = String(dialogScope.lnvalform.rateval);
            if(rateval.indexOf(".")>-1)
            {
                var left = rateval.substring(0,rateval.lastIndexOf("."));
                var right = rateval.substring(rateval.lastIndexOf(".")+1,rateval.length);
                if(left.length>2||right.length>6)
                {
                    $common.get_tipDialog("“基准利率值(%)”超过限值，请重新输入！",'showError');
                    return;
                }
            }
            else
            {
                if(rateval.length>2)
                {
                    $common.get_tipDialog("“基准利率值(%)”超过限值，请重新输入！",'showError');
                    return;
                }
            }
            if(flag == "add"){
                var primise = $common.get_asyncData("bSysLnCdService/add",{bSysLnCd:dialogScope.lnvalform});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        parentScope.queryTable();
                        dialogScope.closeThisDialog();
                        $common.get_tipDialog('新增成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            }else if (flag == "update"){
                var primise = $common.get_asyncData('bSysLnValService/update',{bSysLnVal:dialogScope.lnvalform});
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
            };
        };
    };
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

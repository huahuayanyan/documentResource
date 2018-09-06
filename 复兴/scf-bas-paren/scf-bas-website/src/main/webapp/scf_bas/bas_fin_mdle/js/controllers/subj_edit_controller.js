/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/10
 */
var subjeditController = function(dialogScope,parentScope,$common,flag) {
    if(flag == "add"){
    	dialogScope.hide = true;
        dialogScope.otherform={};//定义form对象
    }else if (flag == "update"){
        dialogScope.otherform=$common.copy(parentScope.selected.select[0]);
    }else if(flag == "view")
    {
        dialogScope.hideButton = true;
    	dialogScope.disable = true;
    	dialogScope.otherform=$common.copy(parentScope.row);
    }
    dialogScope.confirm_onClick = function(){
        if($.doValidate("otherform")) {
            var realLen = 0;
            var subjNm = dialogScope.otherform.subjNm;
            var len = subjNm.length;
            var charCode = -1;
            for(var i=0;i<len;i++)
            {
                charCode = subjNm.charCodeAt(i);
                if(charCode>=0&&charCode<=128)
                {
                    realLen += 1;
                }
                else
                {
                    realLen += 3;
                }
            }
            if(realLen>150)
            {
                $common.get_tipDialog('财报科目名称长度超过限值，请重新输入……','showError');
                return;
            }
            if(flag == "add"){
                $common.get_asyncData("bFinCnfgSubjService/checkSubjNm",{subjNm:dialogScope.otherform.subjNm}).then(function(res){
                    dialogScope.otherform.delFlg = "0";
                    $common.get_asyncData("bFinCnfgSubjService/add",{bFinCnfgSubj:dialogScope.otherform}).then(function(res){
                        if (res.errorCode =="SUC"){
                            parentScope.queryTable();
                            parentScope.selected.select=[];
                            dialogScope.closeThisDialog();
                            $common.get_tipDialog('新增成功！','showSuccess');
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                });
            }else if (flag == "update"){
                $common.get_asyncData('bFinCnfgSubjService/update',{bFinCnfgSubj:dialogScope.otherform}).then(function(res){
                    if (res.errorCode =="SUC"){
                        parentScope.queryTable();
                        parentScope.selected.select=[];
                        dialogScope.closeThisDialog();
                        $common.get_tipDialog('更新成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }
        }
    };
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

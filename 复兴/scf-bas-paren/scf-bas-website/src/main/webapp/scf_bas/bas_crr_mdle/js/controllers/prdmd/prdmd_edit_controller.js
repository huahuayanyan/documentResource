/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var prdmdeditController = function(dialogScope,parentScope,$common,flag) {
    if(flag == "add"){
        dialogScope.otherform={};//定义form对象
    }else if (flag == "update"){
        dialogScope.disable = true;
        dialogScope.otherform=$common.copy(parentScope.selected.select[0]);
    }else if(flag=="view"){
        dialogScope.disableview = true;
        dialogScope.disable = true;
        dialogScope.hide = true;
        dialogScope.otherform=parentScope.row;
    };
    if(flag=="update"||flag=="view")
    {
        checkStat(dialogScope.otherform.stat);
        checkList(dialogScope.otherform.isList);
    }
    dialogScope.confirm_onClick = function(){
        if($.doValidate("otherform")) {
            var prdNm = dialogScope.otherform.prdNm;
            var nmLen = checkLenght(prdNm);
            if(nmLen>60)
            {
                $common.get_tipDialog('“模版名称”长度大于60，请重新输入……','showError');
                return;
            }
            var prdTyp = dialogScope.otherform.prdTyp;
            var typLen = checkLenght(prdTyp);
            if(typLen>60)
            {
                $common.get_tipDialog('“模版类型”长度大于60，请重新输入……','showError');
                return;
            }
            var titNm = dialogScope.otherform.titNm;
            var titNmLen = checkLenght(titNm);
            if(titNmLen>60)
            {
                $common.get_tipDialog('“显示名称”长度大于60，请重新输入……','showError');
                return;
            }
            var addUrl = dialogScope.otherform.addUrl;
            if(addUrl)
            {
                var addUrlLen = checkLenght(addUrl);
                if(addUrlLen>60)
                {
                    $common.get_tipDialog('“新增URL”长度大于60，请重新输入……','showError');
                    return;
                }
            }
            var updUrl = dialogScope.otherform.updUrl;
            if(updUrl)
            {
                var updUrlLen = checkLenght(updUrl);
                if(updUrlLen>60)
                {
                    $common.get_tipDialog('“修改URL”长度大于60，请重新输入……','showError');
                    return;
                }
            }
            var finUrl = dialogScope.otherform.finUrl;
            if(finUrl)
            {
                var finUrlLen = checkLenght(finUrl);
                if(finUrlLen>60)
                {
                    $common.get_tipDialog('“查找URL”长度大于60，请重新输入……','showError');
                    return;
                }
            }
            var pageUrl = dialogScope.otherform.pageUrl;
            if(pageUrl)
            {
                var pageUrlLen = checkLenght(pageUrl);
                if(pageUrlLen>60)
                {
                    $common.get_tipDialog('“分页查询URL”长度大于60，请重新输入……','showError');
                    return;
                }
            }
            var obj = dialogScope.otherform.obj;
            if(obj)
            {
                var objLen = checkLenght(obj);
                if(objLen>60)
                {
                    $common.get_tipDialog('“对象参数”长度大于60，请重新输入……','showError');
                    return;
                }
            }

            if(flag == "add"){
                var checkId = $common.get_asyncData("bCrrPrdMdService/checkPrdId",{prdId:dialogScope.otherform.prdId});
                checkId.then(function(res){
                    var dataId;
                    if (res.errorCode =="SUC"){
                        dataId = res.contextData.value;
                        var prdId = dialogScope.otherform.prdId;
                        if(dataId==prdId)
                        {
                            $common.get_tipDialog('业务编号已存在，请重新输入……','showError');
                        }
                        else
                        {
                            var checkNm = $common.get_asyncData("bCrrPrdMdService/checkPrdNm",{prdNm:dialogScope.otherform.prdNm});
                            checkNm.then(function(res){
                                var dataNm;
                                if (res.errorCode =="SUC"){
                                    dataNm = res.contextData.value;
                                    var prdNm = dialogScope.otherform.prdNm;
                                    if(dataNm==prdNm)
                                    {
                                        $common.get_tipDialog('业务品种已存在，请重新输入……','showError');
                                    }
                                    else
                                    {
                                        var primise = $common.get_asyncData("bCrrPrdMdService/add",{bCrrPrdMd:dialogScope.otherform});
                                        primise.then(function(res){
                                            if (res.errorCode =="SUC"){
                                                parentScope.queryTable();
                                                parentScope.selected.select=[];
                                                dialogScope.closeThisDialog();
                                                $common.get_tipDialog('新增成功！','showSuccess');
                                            }else{
                                                $common.get_tipDialog(res.errorMsg,'showError');
                                            }
                                        });
                                    }
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                }
                            });
                        }
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }else if (flag == "update"){
                var checkNm = $common.get_asyncData("bCrrPrdMdService/checkPrdMd",{bCrrPrdMd:dialogScope.otherform});
                checkNm.then(function(res){
                    var dataNm;
                    if (res.errorCode =="SUC"){
                        dataNm = res.contextData.value;
                        if(dataNm=="false")
                        {
                            $common.get_tipDialog('业务品种已存在，请重新输入……','showError');
                        }
                        else
                        {
                            var primise = $common.get_asyncData('bCrrPrdMdService/update',{bCrrPrdMd:dialogScope.otherform});
                            primise.then(function(res){
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
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
            }
        }
    };
    dialogScope.changeStat = function(val)
    {
        checkStat(val);
    };
    dialogScope.changeList = function(val)
    {
        checkList(val);
    };
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
    function checkStat(val)
    {
        if(val=="0")
        {
            dialogScope.hides = true;
            dialogScope.hidepage = true;
        }
        if(val == "1")
        {
            dialogScope.hides = false;
            dialogScope.hidepage = false;
        }
    }
    function checkList(val)
    {
        if(val=="0")
        {
            dialogScope.hidepage = true;
        }
        if(val == "1")
        {
            dialogScope.hidepage = false;
        }
    }

    function checkLenght(obj)
    {
        var realLen = 0;
        if(obj!=undefined&&obj!=null&&obj!="")
        {
            var strlen = obj.length;
            var charCode = -1;
            for(var i=0;i<strlen;i++)
            {
                charCode = obj.charCodeAt(i);
                if(charCode>=0&&charCode<=128)
                {
                    realLen += 1;
                }
                else
                {
                    realLen += 3;
                }
            }
        }
        return realLen;
    }
};

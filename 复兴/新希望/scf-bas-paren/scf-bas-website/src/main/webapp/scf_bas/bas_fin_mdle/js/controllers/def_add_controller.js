/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/10
 */
var defaddController = function(dialogScope,parentScope,$common,flag,obj){
    var signal;
    dialogScope.secondform=obj;
    if(!obj.cal)
    {
        dialogScope.secondform.cal = "";
        dialogScope.secondform.calNm = "";
    }
    if(!obj.chk)
    {
        dialogScope.secondform.chk = "";
        dialogScope.secondform.chkNm = "";
    }
    var data = {
        calCode:obj.cal,
        chkCode:obj.chk
    }
    $common.get_asyncData("bFinCnfgDefService/getSubjInfoByCode",data).then(function(res){
        var code;
        if (res.errorCode =="SUC"){
            code = res.contextData;
            dialogScope.secondform.calNm = code.calNm;
            dialogScope.secondform.chkNm = code.chkNm;
        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
    dialogScope.secondform.mdlId = parentScope.otherform.mdlId;
    if(dialogScope.secondform.edTyp=="2")
    {
        dialogScope.chkCodeMust = "common.require";
    }
    else
    {
        dialogScope.chkCodeMust = "";
    }

	/**
	 * 科目名称查询加载开始
	 */
	dialogScope.subjcontent = {
            type:"table",//展示类型table  tree
            url:"bFinCnfgSubjService/querySubjSource",
            param:{},
            split:",",//分隔符
            extentColumn:"subjId",
            column:["subjNm","subjId"]//展示内容
        };
	dialogScope.dooextend = function(ds){
		dialogScope.secondform.subjNm=ds.subjNm;
		dialogScope.secondform.subjId=ds.subjId;
        };
    dialogScope.$watch("secondform.subjId",function(){
        	if(dialogScope.secondform.subjId!=null) dialogScope.subjcontent.param ={subjNm:dialogScope.secondform.subjId,subjId:dialogScope.secondform.subjId};
        }); 
    /**
     * 科目名称查询加载结束
     */
    /**
     * 检查公式查询加载开始
     */
    dialogScope.chkCodecontent = {
        type:"table",//展示类型table  tree
        url:"bFinCnfgDefService/queryBFinCnfgDefSubjByPage",
        param:{edTyp:"1"},
        split:",",//分隔符
        extentColumn:"subjNm",
        column:["subjNm","subjId"]//展示内容
    };
    dialogScope.chkCodedooextend = function(ds){
        signal = "chk";
        dialogScope.secondform.chk = dialogScope.secondform.chk+"<"+ds.subjId+">";
        dialogScope.secondform.chkNm = dialogScope.secondform.chkNm+ds.subjNm;
    };
    dialogScope.$watch("secondform.chkCode",function(){
        dialogScope.chkCodecontent.param ={edTyp:"1",mdlId:dialogScope.secondform.mdlId,subjId:dialogScope.secondform.chkCode,subjNm:dialogScope.secondform.chkCode};
    });
    /**
     * 检查公式查询加载结束
     */
    /**
     * 计算公式查询加载开始
     */
    dialogScope.calCodecontent = {
        type:"table",//展示类型table  tree
        url:"bFinCnfgDefService/queryBFinCnfgDefSubjByPage",
        param:{edTyp:"1"},
        split:",",//分隔符
        extentColumn:"subjNm",
        column:["subjNm","subjId"]//展示内容
    };
    dialogScope.calCodedooextend = function(ds){
        signal = "cal";
        dialogScope.secondform.cal = dialogScope.secondform.cal+"<"+ds.subjId+">";
        dialogScope.secondform.calNm = dialogScope.secondform.calNm+ds.subjNm;
    };
    dialogScope.$watch("secondform.calCode",function(){
        dialogScope.calCodecontent.param ={edTyp:"1",mdlId:dialogScope.secondform.mdlId,subjId:dialogScope.secondform.calCode,subjNm:dialogScope.secondform.calCode};
    });
    /**
     * 计算公式查询加载结束
     */
    dialogScope.selectMdlCl={
        ds:[]
    };
    var promiseCl = $common.get_asyncData("bFinCnfgClService/selectForSelect");
    promiseCl.then(function(res){
        var dataCl;
        if (res.errorCode =="SUC"){
            dataCl = res.contextData;
            dialogScope.selectMdlCl.ds = dataCl;
        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
    dialogScope.mdlId_change = function (val) {
        var promise = $common.get_asyncData("bFinCnfgSubjService/findBFinCnfgSubjByMdlId",{mdlId:val});
        promise.then(function(res){
            var dataSubj;
            if (res.errorCode =="SUC"){
                dataSubj = res.contextData;
                dialogScope.selectSubjByMdlId.ds = dataSubj;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }
    dialogScope.confirm_onClick = function () {
        if($.doValidate("secondform")) {
            var flagCal;
            $common.get_asyncData("bFinCnfgDefService/checkRight",{value:dialogScope.secondform.cal}).then(function(res){
                if (res.errorCode =="SUC"){
                    flagCal = res.contextData.value;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
            if(flagCal==false)
            {
                $common.get_tipDialog("核对计算公式是否正确！",'showInform');
                return;
            }
            var flagChk;
            $common.get_asyncData("bFinCnfgDefService/checkRight",{value:dialogScope.secondform.chk}).then(function(res){
                if (res.errorCode =="SUC"){
                    flagChk = res.contextData.value;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
            if(flagChk==false)
            {
                $common.get_tipDialog("核对检查公式是否正确！",'showInform');
                return;
            }
            dialogScope.flowsubmitdisable = true;
            var primise = $common.get_asyncData('bFinCnfgDefService/saveBFinCnfgDef',{bFinCnfgDef:dialogScope.secondform});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    dialogScope.closeThisDialog();
                    $common.get_tipDialog('保存成功！','showSuccess');
                    parentScope.queryFinRePort();
                    obj.$edit=false;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        };
    };
    dialogScope.edTyp_change = function(val)
    {
        if(val=="2")
        {
            dialogScope.chkCodeMust = "common.require";
        }
        else
        {
            dialogScope.chkCodeMust = "";
        }
    }

    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };

    //加
    dialogScope.plus_onClick = function()
    {
        if(!signal||signal==""||signal==null)
        {
            $common.get_tipDialog("公式科目未选择，请选择！",'showInform');
            return;
        }
        if(signal == "chk")
        {
            dialogScope.secondform.chk = dialogScope.secondform.chk + "+";
            dialogScope.secondform.chkNm = dialogScope.secondform.chkNm + "+";
        }
        if(signal == "cal")
        {
            dialogScope.secondform.cal = dialogScope.secondform.cal + "+";
            dialogScope.secondform.calNm = dialogScope.secondform.calNm + "+";
        }
        dialogScope.$apply();
    }
    //减
    dialogScope.minus_onClick = function(val)
    {
        if(!signal)
        {
            $common.get_tipDialog("公式科目未选择，请选择！",'showInform');
            return;
        }
        if(signal == "chk")
        {
            dialogScope.secondform.chk = dialogScope.secondform.chk + "-";
            dialogScope.secondform.chkNm = dialogScope.secondform.chkNm + "-";
        }
        if(signal == "cal")
        {
            dialogScope.secondform.cal = dialogScope.secondform.cal + "-";
            dialogScope.secondform.calNm = dialogScope.secondform.calNm + "-";
        }
        dialogScope.$apply();
    }
    //乘
    dialogScope.multiply_onClick = function(val)
    {
        if(!signal)
        {
            $common.get_tipDialog("公式科目未选择，请选择！",'showInform');
            return;
        }
        if(signal == "chk")
        {
            dialogScope.secondform.chk = dialogScope.secondform.chk + "*";
            dialogScope.secondform.chkNm = dialogScope.secondform.chkNm + "*";
        }
        if(signal == "cal")
        {
            dialogScope.secondform.cal = dialogScope.secondform.cal + "*";
            dialogScope.secondform.calNm = dialogScope.secondform.calNm + "*";
        }
        dialogScope.$apply();
    }
    //除
    dialogScope.eliminate_onClick = function(val)
    {
        if(!signal)
        {
            $common.get_tipDialog("公式科目未选择，请选择！",'showInform');
            return;
        }
        if(signal == "chk")
        {
            dialogScope.secondform.chk = dialogScope.secondform.chk + "/";
            dialogScope.secondform.chkNm = dialogScope.secondform.chkNm + "/";
        }
        if(signal == "cal")
        {
            dialogScope.secondform.cal = dialogScope.secondform.cal + "/";
            dialogScope.secondform.calNm = dialogScope.secondform.calNm + "/";
        }
        dialogScope.$apply();
    }
    //小括号（
    dialogScope.left_onClick = function(val)
    {
        if(!signal)
        {
            $common.get_tipDialog("公式科目未选择，请选择！",'showInform');
            return;
        }
        if(signal == "chk")
        {
            dialogScope.secondform.chk = dialogScope.secondform.chk + "(";
            dialogScope.secondform.chkNm = dialogScope.secondform.chkNm + "(";
        }
        if(signal == "cal")
        {
            dialogScope.secondform.cal = dialogScope.secondform.cal + "(";
            dialogScope.secondform.calNm = dialogScope.secondform.calNm + "(";
        }
        dialogScope.$apply();
    }
    //小括号)
    dialogScope.right_onClick = function(val)
    {
        if(!signal)
        {
            $common.get_tipDialog("公式科目未选择，请选择！",'showInform');
            return;
        }
        if(signal == "chk")
        {
            dialogScope.secondform.chk = dialogScope.secondform.chk + ")";
            dialogScope.secondform.chkNm = dialogScope.secondform.chkNm + ")";
        }
        if(signal == "cal")
        {
            dialogScope.secondform.cal = dialogScope.secondform.cal + ")";
            dialogScope.secondform.calNm = dialogScope.secondform.calNm + ")";
        }
        dialogScope.$apply();
    }
    //中括号[
    dialogScope.midLeft_onClick = function(val)
    {
        if(!signal)
        {
            $common.get_tipDialog("公式科目未选择，请选择！",'showInform');
            return;
        }
        if(signal == "chk")
        {
            dialogScope.secondform.chk = dialogScope.secondform.chk + "[";
            dialogScope.secondform.chkNm = dialogScope.secondform.chkNm + "[";
        }
        if(signal == "cal")
        {
            dialogScope.secondform.cal = dialogScope.secondform.cal + "[";
            dialogScope.secondform.calNm = dialogScope.secondform.calNm + "[";
        }
        dialogScope.$apply();
    }
    //中括号]
    dialogScope.midRight_onClick = function(val)
    {
        if(!signal)
        {
            $common.get_tipDialog("公式科目未选择，请选择！",'showInform');
            return;
        }
        if(signal == "chk")
        {
            dialogScope.secondform.chk = dialogScope.secondform.chk + "]";
            dialogScope.secondform.chkNm = dialogScope.secondform.chkNm + "]";
        }
        if(signal == "cal")
        {
            dialogScope.secondform.cal = dialogScope.secondform.cal + "]";
            dialogScope.secondform.calNm = dialogScope.secondform.calNm + "]";
        }
        dialogScope.$apply();
    }
    //清空计算公式
    dialogScope.clearChk_onClick = function()
    {
        dialogScope.secondform.chk = "";
        dialogScope.secondform.chkNm = "";
        dialogScope.$apply();
    }
    //清空检查公式
    dialogScope.clearCal_onClick = function()
    {
        dialogScope.secondform.cal = "";
        dialogScope.secondform.calNm = "";
        dialogScope.$apply();
    }
    //检验公式运算符准确性
    function checkRight(val)
    {
        if(val)
        {
            var promise = $common.get_asyncData("bFinCnfgDefService/checkRight",{value:val});
            promise.then(function(res){
                var flag;
                if (res.errorCode =="SUC"){
                    flag = res.contextData.value;
                    return flag;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
        else
        {
            return true;
        }
    }
}
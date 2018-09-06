/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var lnappaddController = function(dialogScope,parentScope,dataDeliver,$state,$common,flag) {
    dialogScope.otherform={};
    dialogScope.otherform.lnTyp = "1";
    /**
     * 业务品种查询加载开始
     */
    dialogScope.prdmdcontent = {
        type:"table",//展示类型table  tree
        url:"bCrrPrdMdService/queryPrdMdSource",
        param:{},
        split:",",//分隔符
        extentColumn:"prdNm",
        column:["prdNm","prdId"]//展示内容
    };
    dialogScope.prdmdextend = function(ds){
        dialogScope.otherform.prdNm=ds.prdNm;
        dialogScope.otherform.prdId=ds.prdId;
        dialogScope.otherform.extTyp = ds.prdTyp;
        dialogScope.otherform.prdmd = ds;
    };
    dialogScope.$watch("otherform.prdNm",function(){
        if(dialogScope.otherform.prdNm!=null) dialogScope.prdmdcontent.param ={prdId:dialogScope.otherform.prdNm,prdNm:dialogScope.otherform.prdNm};
    });
    /**
     * 业务品种查询加载结束
     */
    /**
     * 客户名称查询加载开始
     */
    dialogScope.custcontent = {
        type:"table",//展示类型table  tree
        url:"bCrrLnAppService/queryCustSource",
        param:{},
        split:",",//分隔符
        extentColumn:"custNm",
        column:["custNm","custId"]//展示内容
    };
    dialogScope.dooextend = function(ds){
        dialogScope.otherform.custNm=ds.custNm;
        dialogScope.otherform.custId=ds.custId;
    };
    dialogScope.$watch("otherform.custNm",function(){
        if(dialogScope.otherform.custNm!=null) dialogScope.custcontent.param ={custId:dialogScope.otherform.custNm,custNm:dialogScope.otherform.custNm};
    });
    /**
     * 客户名称查询加载结束
     */
    dialogScope.confirm_onClick = function(){
        var custNm = dialogScope.otherform.custNm;
        var custId = dialogScope.otherform.custId;
        var bCrmBaseInfo = {custCd:custId};
        //校验输入客户名称与获取客户名是否匹配
        var primise = $common.get_asyncData('bCrmBaseInfoService/findBCrmBaseInfoByKey',{bCrmBaseInfo:bCrmBaseInfo});
        primise.then(function(res){
            var custinfo;
            if (res.errorCode =="SUC"){
                custinfo = res.contextData;
                var cname = custinfo.cname;
                if(custNm == cname)
                {
                    //校验输入业务品种是否完全
                    var prdId = dialogScope.otherform.prdId;
                    var prdNm = dialogScope.otherform.prdNm;
                    if(!prdId||prdId==null||prdId=="")
                    {
                        document.getElementById("prdNm").focus();
                        $common.get_tipDialog("未对业务品种进行选择，请重新选择",'showError');
                        return;
                    }
                    $common.get_asyncData('bCrrPrdMdService/findBCrrPrdMdByPrdId',{prdId:prdId}).then(function(res){
                        var prdmd;
                        if (res.errorCode =="SUC"){
                            prdmd = res.contextData;
                            var prdMdNm = prdmd.prdNm;
                            if(prdMdNm==prdNm)
                            {
                                if($.doValidate("otherform")) {
                                    dialogScope.flowsubmitdisable = true;
                                    var primise = $common.get_asyncData('bCrrLnAppService/cachadd',{bCrrLnApp:dialogScope.otherform});
                                    primise.then(function(res){
                                        if (res.errorCode =="SUC"){
                                            dialogScope.closeThisDialog();
                                            dialogScope.otherform = res.contextData;
                                            dialogScope.otherform.flag = flag;
                                            dialogScope.otherform.prdmd = prdmd;
                                            $state.go("lnapp");
                                            dataDeliver.setter(dialogScope.otherform);
                                        }else{
                                            $common.get_tipDialog(res.errorMsg,'showError');
                                        };
                                    });
                                };
                            }
                            else
                            {
                                document.getElementById("prdNm").focus();
                                $common.get_tipDialog("输入业务品种不合法，请重新选择",'showError');
                            }
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        };
                    });
                }
                else
                {
                    document.getElementById("custNm").focus();
                    $common.get_tipDialog("输入客户名称与客户号不匹配，请重新选择",'showError');
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    };
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

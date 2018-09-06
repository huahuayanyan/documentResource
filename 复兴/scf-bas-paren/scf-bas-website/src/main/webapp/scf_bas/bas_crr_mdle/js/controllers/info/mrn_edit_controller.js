/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var mrneditController = function(dialogScope,parentScope,dataDeliver,$state,$common,flag,row) {
    var pageUrl = parentScope.otherform.prdmd.pageUrl;
    var titNm = parentScope.otherform.prdmd.titNm;
    var obj = parentScope.otherform.prdmd.obj;
    if(flag == "add")
    {
        dialogScope.secondform={};
    }
   if(flag == "update")
    {
       dialogScope.secondform = $common.copy(parentScope.selectedinfo.select[0]);
    }
    if(flag == "view"||flag=="lnconview"||flag=="lnconedit")
    {
        dialogScope.secondform = $common.copy(parentScope.row);
        dialogScope.disableview = true;
        dialogScope.disable = true;
        dialogScope.hide = true;
    }
    dialogScope.secondform.custcd = parentScope.otherform.custId;
    if(!parentScope.otherform.prdmd.pageUrl)
    {
        dialogScope.disable = true;
        dialogScope.secondform.billId = parentScope.otherform.extId;
        dialogScope.secondform.billNo = parentScope[obj].billNo;
    }
    /**
     * 加载票据信息   开始
     */
    //dialogScope.billcontent = {
    //    type:"table",//չʾ��ʽtable  tree
    //    url:pageUrl+"Ext",
    //    param:{},
    //    split:",",//�ָ���
    //    extentColumn:"billNo",
    //    column:["billId","billNo"]//չʾ�ֶ�
    //};
    //dialogScope.dooextend = function(ds){
    //    dialogScope.secondform.billNo=ds.billNo;
    //    dialogScope.secondform.billId=ds.billId;
    //};
    //dialogScope.$watch("secondform.billNo",function(){
    //    var data = {};
    //    data.pageNo = dialogScope.conf.pageNo;
    //    data.pageSize = dialogScope.conf.pageSize;
    //    if(dialogScope.secondform.billNo!=null)
    //    {
    //        dialogScope.billcontent.param ={extId:parentScope.otherform.extId,billNo:dialogScope.secondform.billNo};
    //    }
    //    else
    //    {
    //        dialogScope.billcontent.param ={extId:parentScope.otherform.extId};
    //    }
    //});
    /**
     * 加载票据信息   结束
     */
    /**
     * 加载财务机构信息 开始
     */
    dialogScope.brnameContent = {
        type:"table",//显示形式 table tree
        url:"bSysAcctBctlService/findBSysAcctBctlByPage",//调用路径 url
        param:{status:"1"},//参数
        split:"-",//分隔符
        extentColumn:"brname",
        column:["brcode","brname"]//显示内容
    };
    dialogScope.brnameExtent = function(ds){
        dialogScope.secondform.actBrCd=ds.brcode;
        dialogScope.secondform.actBrNm=ds.brname;
    };
    //监听分页
    dialogScope.$watch("secondform.actBrNm",function(){
        dialogScope.brnameContent.param ={
            status:"1",
            brname:dialogScope.secondform.actBrNm
        }
    });
    /**
     * 加载财务机构信息 开始
     */
    dialogScope.confirm_onClick = function(){
        if($.doValidate("secondform")) {
            var actBrNm = dialogScope.secondform.actBrNm;
            var actBrCd = dialogScope.secondform.actBrCd;
            //“冻结金额”必须小于等于“保证金金额”
            var amount = dialogScope.secondform.amount;
            var bailFrozenAmt = dialogScope.secondform.bailFrozenAmt;
            if(parseFloat(amount)<=0){
           	 $common.get_tipDialog("【保证金金额】必须大于0",'showError');
           	 dialogScope.secondform.amount="";
              return ;
           }
            if(parseFloat(bailFrozenAmt)<=0){
              	 $common.get_tipDialog("【冻结金额】必须大于0",'showError');
              	 dialogScope.secondform.bailFrozenAmt="";
                 return ;
              }
            if(parseFloat(bailFrozenAmt)>parseFloat(amount)){
            	 $common.get_tipDialog("【冻结金额】必须小于等于【保证金金额】",'showError');
            	 dialogScope.secondform.bailFrozenAmt="";
                 return ;
            }
            if(!actBrCd||actBrCd==null||actBrCd=="")
            {
                document.getElementById("actBrNm").focus();
                $common.get_tipDialog("未对财务机构进行选择，请重新选择",'showError');
                return;
            }
            $common.get_asyncData("bSysAcctBctlService/findBSysAcctBctlByBrcode",{brcode:actBrCd}).then(function(res){
                var data;
                if (res.errorCode =="SUC"){
                    data = res.contextData;
                    var brname = data.brname;
                    if(actBrNm==brname)
                    {
                        dialogScope.disableconfirm = true;
                        if(flag=="add")
                        {
                            dialogScope.secondform.appno = parentScope.otherform.appId;
                            //票据ID
                            dialogScope.secondform.billId =parentScope.otherform.extId;
                            var primise = $common.get_asyncData('bMrnAppliAcctInfoService/add',{bMrnAppliAcctInfo:dialogScope.secondform});
                            primise.then(function(res){
                                if (res.errorCode =="SUC"){
                                    parentScope.queryTableInfo();
                                    parentScope.selectedinfo.select = [];
                                    dialogScope.closeThisDialog();
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                };
                            });
                        }
                        else if(flag=="update")
                        {
                            var primise = $common.get_asyncData('bMrnAppliAcctInfoService/update',{bMrnAppliAcctInfo:dialogScope.secondform});
                            primise.then(function(res){
                                if (res.errorCode =="SUC"){
                                    parentScope.queryTableInfo();
                                    parentScope.selectedinfo.select = [];
                                    dialogScope.closeThisDialog();
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                };
                            });
                        }
                    }
                    else
                    {
                        document.getElementById("actBrNm").focus();
                        $common.get_tipDialog("输入财务机构与其编号不匹配，请重新选择",'showError');
                    }
                }
            });
        };
    };
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

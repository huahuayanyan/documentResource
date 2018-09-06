/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var infoeditController = function(dialogScope,parentScope,dataDeliver,$state,$common,flag) {
    var obj = parentScope.otherform.prdmd.obj;
    var addUrl = parentScope.otherform.prdmd.addUrl;
    var updUrl = parentScope.otherform.prdmd.updUrl;
    var  trmMo =parentScope.otherform.trmMo; //期限(月)
    var  trmDay =parentScope.otherform.trmMo;//期限(日)
    if(flag == "add")
    {
        dialogScope[obj]={};
        dialogScope[obj].extId = parentScope.otherform.extId;
        dialogScope[obj].trmMo =parentScope.otherform.trmMo;
        dialogScope[obj].trmDay =parentScope.otherform.trmDay;
    }
    if(flag == "update")
    {
        dialogScope[obj] = $common.copy(parentScope.selected.select[0]);
    }
    if(flag == "view"||flag=="lnconview"||flag=="lnconedit")
    {
        dialogScope[obj] = $common.copy(parentScope.row);
        dialogScope.disableview = true;
        dialogScope.disable = true;
        dialogScope.hide = true;
    }
    dialogScope.confirm_onClick = function(){
        if($.doValidate(""+obj)) {
            var val = dialogScope[obj].wrtDt;
           var endDate= checkTrm(val);
            if(dialogScope[obj].mtrDt >endDate){
                $common.get_tipDialog("业务申请下银承开票的起始日期与到期日期超过了业务申请的期限",'showError');
                dialogScope[obj].mtrDt="";
                return false;
            }
            dialogScope.disableconfirm = true;
            if(flag=="add")
            {
                var data={};
                data[obj]=dialogScope[obj];
                var primise = $common.get_asyncData(addUrl,data);
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        parentScope.queryTable();
                        parentScope.selected.select = [];
                        dialogScope.closeThisDialog();
                        $common.get_tipDialog("新增成功","showSuccess");
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            }
            else if(flag=="update")
            {
                var data={};
                data[obj]=dialogScope[obj];
                var primise = $common.get_asyncData(updUrl,data);
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        parentScope.queryTable();
                        parentScope.selected.select = [];
                        dialogScope.closeThisDialog();
                        $common.get_tipDialog("更新成功","showSuccess");
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            }
        };
    };
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
    
	

    dialogScope.mtrDt_onBlur = function()
    {
        if(!dialogScope[obj].wrtDt)
        {
        	dialogScope.$apply(
        			dialogScope[obj].mtrDt = ""
            )
        }
        else
        {
            var val = dialogScope[obj].wrtDt;
        }
    };
    dialogScope.wrtDt_onBlur = function()
    {
        if(!dialogScope[obj].wrtDt)
        {
            dialogScope.$apply(
                dialogScope[obj].mtrDt = ""
            )
        }
        else
        {
            var val = dialogScope[obj].wrtDt;
        }
    };
    /**
     * 计算票据到期日mtrDt允许的最大日期
     */
    function checkTrm(start){
        var startYear = Number(start.substring(0,4));
        var startMon = Number(start.substring(4,6));
        var startDay = Number(start.substring(6,8));
        var trmYear;
        var trmMon = parentScope.otherform.trmMon;
        var trmDay = parentScope.otherform.trmDay;
        if(trmMon>12)
        {
            trmYear = parseInt(trmMon/12);
            trmMon = trmMon%12;
        }
        else
        {
            trmYear = 0;
        }
        var endYear = startYear+trmYear;
        var endMon = startMon+trmMon;
        if(endMon>12)
        {
            endYear = endYear+1;
            endMon = endMon-12;
        }
        var endDay = startDay+trmDay;
        var perMonday;
        if(endMon=="01"||endMon=="03"||endMon=="05"||endMon=="07"||endMon=="08"||endMon=="10"||endMon=="12")
        {
            perMonday = 31;
        }
        if(endMon=="04"||endMon=="06"||endMon=="09"||endMon=="11")
        {
            perMonday = 30;
        }
        if(endMon=="02")
        {
            var sum = endYear%4;
            if(sum==0)
            {
                perMonday = 28;
            }
            else
            {
                perMonday = 29;
            }
        }
        if(endDay>perMonday)
        {
            endMon = endMon+1;
            endDay = endDay-perMonday;
        }
        if(endMon>12)
        {
            endYear = endYear+1;
            endMon = endMon-12;
        }
        if(endMon<10)
        {
            endMon = "0"+endMon;
        }
        if(endDay<10)
        {
            endDay = "0"+endDay;
        }
        
        var endDate = endYear+""+endMon+""+endDay; //mtrDt wrtDt
        return endDate;
    }
};

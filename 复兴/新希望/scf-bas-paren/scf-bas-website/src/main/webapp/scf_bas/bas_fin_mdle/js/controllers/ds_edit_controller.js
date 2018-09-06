/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/10
 */
var dseditController = function(dialogScope,parentScope,$common,flag) {
    dialogScope.otherform = {};
    if(flag=="update")
    {
        dialogScope.otherform = $common.copy(parentScope.selected.select[0]);
    }
    else if(flag=="view")
    {
        dialogScope.otherform = $common.copy(parentScope.row);
    }
    dialogScope.selectCust = {
        ds:[]
    };
    var promiseCust = $common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByBCrm");
    promiseCust.then(function(res){
        var data;
        if (res.errorCode =="SUC"){
            data = res.contextData;
            dialogScope.selectCust.ds = data;
        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
    dialogScope.confirm_onClick = function(){
        if($.doValidate("otherform")) {
            if(flag=="update")
            {
                parentScope.selected.select[0].colVal1 = dialogScope.otherform.colVal1;
                parentScope.selected.select[0].colVal2 = dialogScope.otherform.colVal2;
                parentScope.selected.select = [];
            }
            else if(flag=="view")
            {
                parentScope.row.colVal1 = dialogScope.otherform.colVal1;
                parentScope.row.colVal2 = dialogScope.otherform.colVal2;
                parentScope.selected.select = [];
            }
            dialogScope.closeThisDialog();
        };
    };
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

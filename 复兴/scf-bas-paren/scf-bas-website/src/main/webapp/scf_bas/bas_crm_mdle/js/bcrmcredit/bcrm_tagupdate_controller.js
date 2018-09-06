/**
 * Filename:
 * Description: 新增云标签
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      doujun
 * @version     1.0
 * Create at:   2017/07/05
 */
var TagUpdateController =  function(dialogScope,parentScope,$common,$state,dataDeliver){
	
	var dataTrasfer = dataDeliver.getter();
	var seletedRow = parentScope.selected.select[0];
	
	//设备模板中不可编辑标签
	dialogScope.disable= true;
	
	//填充模版数据
	dialogScope.otherform= $common.copy(parentScope.selected.select[0]);
	
	//修改
    dialogScope.confirm_onClick=function(){
    	var data= {
            pageNo: parentScope.conf.pageNo,
            pageSize: parentScope.conf.pageSize,
            bCrmTagCloudRel: {
            	id : seletedRow.id,
            	custcd : dataTrasfer.bCrmBaseInfo.custcd,
            	tagCode : dialogScope.otherform.tagCode,
            	tagValue : dialogScope.otherform.tagValue
            }
        };
        var promise = $common.get_asyncData("bCrmTagCloudRelService/update",data);
        promise.then(function(res){
            var resData;
            if (res.errorCode =="SUC"){
            	resData = res.contextData;
            	dialogScope.closeThisDialog();
            	parentScope.queryTable();
            	parentScope.selected.select = [];
            	$common.get_tipDialog("修改成功！",'showSuccess');
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }
    
    //取消
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

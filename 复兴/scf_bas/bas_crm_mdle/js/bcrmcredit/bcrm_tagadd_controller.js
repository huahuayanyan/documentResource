/**
 * Filename:
 * Description: 新增客户标签
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      doujun
 * @version     1.0
 * Create at:   2017/07/05
 */
var TagAddController =  function(dialogScope,parentScope,$common,$state,dataDeliver){
	var dataTrasfer = dataDeliver.getter();
	dialogScope.otherform={};
    dialogScope.confirm_onClick=function(){
    	var data= {
            pageNo: parentScope.conf.pageNo,
            pageSize: parentScope.conf.pageSize,
            bCrmTagCloudRel: {
            	custcd : dataTrasfer.bCrmBaseInfo.custcd,
            	tagCode : dialogScope.otherform.dataVal,
            	tagValue : dialogScope.otherform.tagValue
            }
        };
        var promise = $common.get_asyncData("bCrmTagCloudRelService/findBCrmTagCloudInfoByPage",data);
        promise.then(function(res){
            var resData;
            if (res.errorCode =="SUC"){
            	resData = res.contextData;
                if(resData.totalRecord > 0){
                	 $common.get_tipDialog("该客户标签已经存在，不可新增！", "showError");
                }else{
                	addCloudTag({bCrmTagCloudRel:data.bCrmTagCloudRel});
                }
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }
    
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };

    //客户标签下拉查询
    dialogScope.areaContent = {
            type:"table",//展示类型table  tree
            url:"bCrmBaseInfoService/findBCrmTabByPage",//请求url
            param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查dictCode:custTagType
            split:"",//分隔符*/
            extentColumn:"dataTrsVal",
            column:["dataTrsVal"]//展示内容
        };
    dialogScope.dooextent = function(ds){
    	dialogScope.otherform.dataTrsVal=ds.dataTrsVal;
    	dialogScope.otherform.dataVal=ds.dataVal;
      
    }; 

    dialogScope.$watch("otherform.dataTrsVal",function(){
    	dialogScope.areaContent.param ={
        		dataTrsVal:dialogScope.otherform.dataTrsVal,
        }
    });


    //新增一条客户标签
    function addCloudTag(data){
    	var promise = $common.get_asyncData("bCrmTagCloudRelService/add",data);
    	 promise.then(function(res){
    		 var data;
    		 if (res.errorCode =="SUC"){
    			 dialogScope.closeThisDialog();
    			 parentScope.queryTable();
    			 parentScope.selected.select = [];
    			 $common.get_tipDialog('新增成功！', 'showSuccess');
             }else{
                 $common.get_tipDialog(res.errorMsg,'showError');
             }
    	 });
    }

};

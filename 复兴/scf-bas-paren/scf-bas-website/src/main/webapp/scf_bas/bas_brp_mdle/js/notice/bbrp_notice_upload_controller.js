/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */
var BrpNoticeUploadController = function (dialogScope, parentScope, $common, flag, row) {
    dialogScope.otherform = {};
	dialogScope.uploadoption = { 
		    inputHidden:[ 
		        /* 上传到文件服务器 start */ 
		       // {name:'expiryDate', value: "2028-02-03"},//文件过期日期 
		       // {name:'appId', value: "2134324243"},//业务系统号 
		       // {name:'roate', value: "360"},//图片旋转角度 
		       // {name:'noticeType', value: $scope.otherform}, 
		        {name:'uploadType', value: "1001"}, 
		        //{name:'reservedValue2', value: "保留字段1"}, 
		        //{name:'reservedValue3', value: "保留字段1"} 
		        /* 上传到文件服务器 end */ 
		        /* 上传到服务部署所在机器 start */ 
		        { 
		            name:'callback', 
		            value: function(){
		                return "fileServiceSupport/upload";
		            } 
		        } 
		        /* 上传到服务部署所在机器 end */ 
		    ], 
		    callbackFun: function(res,status){ 
		    	 if (res!=null&&res!=''&&res.errorCode == "SUC") {
                 	    alert("上传成功！");
                 	    dialogScope.closeThisDialog();
   			            parentScope.queryTable();
                 }
                 else{
				        alert("上传失败，请重新上传！"); 
                 }
		    	   
		       // alert("res: "+JSON.stringify(res)+"  status: "+status) 
		        //console.log("res: "+res+"  status: "+status); 
		    }, 
		    fileServerUrl:false //true：上传到文件服务器；false：上传到服务部署所在机器 
		}; 
	
	/**
     * 通知书类型筛选
     */
	dialogScope.noticeTypeValContent = {
        type:"table",//展示类型table  tree
        url:"bSysCommonService/selectNoticeType",
        split:",",//分隔符
        extentColumn:"dataTrsVal",
        //column:["dataTrsVal","dataVal"]//展示内容
	    column:["dataTrsVal"]//展示内容
    };
	dialogScope.noticeTypeValdooextent = function(ds){
		dialogScope.otherform.noticeTypeVal=ds.dataTrsVal;
		dialogScope.otherform.noticeType=ds.dataVal; 
    };
    dialogScope.$watch("otherform.noticeTypeVal+otherform.noticeType",function(newVal,oldVal){
        //ht-input-extent  需要用监听的方式来传额外的参数
    	dialogScope.noticeTypeValContent.param ={
        	   noticeTypeVal:dialogScope.otherform.noticeTypeVal
        };
    	dialogScope.changeNoticeType(dialogScope.otherform.noticeType);
    });
    
	dialogScope.changeNoticeType=function(val){
		if(val!=null&&""!=val&&val!=undefined){
			dialogScope.uploadoption = { 
				    inputHidden:[ 
				        /* 上传到文件服务器 start */ 
				       // {name:'expiryDate', value: "2028-02-03"},//文件过期日期 
				       // {name:'appId', value: "2134324243"},//业务系统号 
				       // {name:'roate', value: "360"},//图片旋转角度 
				        {name:'noticeType', value: val}, 
				        {name:'uploadType', value: "1001"}, 
				        //{name:'reservedValue2', value: "保留字段1"}, 
				        //{name:'reservedValue3', value: "保留字段1"} 
				        /* 上传到文件服务器 end */ 
				        /* 上传到服务部署所在机器 start */ 
				        { 
				            name:'callback', 
				            value: function(){ 
				                return "fileServiceSupport/upload"; 
				            } 
				        } 
				        /* 上传到服务部署所在机器 end */ 
				    ], 
				    callbackFun: function(res,status){ 
				    	 if (res!=null&&res!=''&&res.errorCode == "SUC") {
	                    	alert("上传成功！");	
	                    	 dialogScope.closeThisDialog();
						     parentScope.queryTable();
	                    }
	                    else{
					        alert("上传失败，请重新上传！"); 
	                    }
					      //  alert("res: "+JSON.stringify(res)+"  status: "+status) 

				        // console.log("res: "+res+"  status: "+status); 
				    }, 
				    fileServerUrl:false //true：上传到文件服务器；false：上传到服务部署所在机器 
				}; 
			
		}
		
	}	
	  dialogScope.closeThisDialog_onClick = function () {
	        dialogScope.closeThisDialog();
	    }
};

/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var selectOrgController = function(selectScope,dialogScope,parentScope,$common,flag) {
	selectScope.conditionForm= {};
	selectScope.datasource={//初始化表格对象
        ds:[
        ]
    };
	selectScope.selected={//初始化对象
        select: []
    };
	selectScope.datasource={//初始化表格对象
        ds:[
        ]
    };

	selectScope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    //监听分页
    selectScope.$watch("conf.pageNo+conf.pageSize",function(){
        selectScope.queryTable();
    });
    //搜索
    selectScope.submit_onClick =function(){
        selectScope.queryTable();
        selectScope.selected.select=[];
    };
    selectScope.queryTable = function(){
        var data={
            pageNo: selectScope.conf.pageNo,
            pageSize: selectScope.conf.pageSize,
            bctlVO:selectScope.conditionForm
        };
        // var promise=$common.get_asyncData("orgService/selectByPage",data);
       var promise=$common.get_asyncData("bIcrInfoService/findOrgByPage",data);

        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                selectScope.datasource.ds = data.records;
                selectScope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    };
    //保存
    selectScope.confirm_onClick = function(){
    	 if(selectScope.selected.select.length <= 0){
    		 $common.get_tipDialog('请至少选择一条记录！','showInform');
         }else{
        	 var arrs = $common.copy(selectScope.selected.select);
        	  dialogScope.subform.suitbrName="";//清空机构信息
              dialogScope.subform.suitBrcode="";
        	  var brNames = [];
        	  var brNos = [];
              for(var i=0 ; i<arrs.length ; i++)
              {
            	  brNames.push(arrs[i].brName);
            	  brNos.push(arrs[i].brNo);
              }
            dialogScope.subform.suitbrName=brNames;
            dialogScope.subform.suitBrcode=brNos;
         }
    	 selectScope.closeThisDialog();
    }

    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

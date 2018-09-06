/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var debtExtSelectController = function(dialogScope,parentScope,$common,dataDeliver,flag) {
	dialogScope.conditionForm={};//初始化查询条件
    dialogScope.datasourceDialog={//初始化表格对象
        ds:[
        ]
    };
    dialogScope.selectedDialog={//初始化对象
        select: []
    };
    dialogScope.confDialog= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    //监听分页
    dialogScope.$watch("confDialog.pageNo+confDialog.pageSize",function(){
        //alert("我是分页监听器");
        dialogScope.queryTable();
    });
    //搜索
    dialogScope.submit_onClick =function(){
        dialogScope.queryTable();
    };
    var  bData =dataDeliver.getter();
    dialogScope.conditionForm={
        custcd:bData.custcd,
        coreFlag:"1"
        /*custStatus:"1",
         custType:"",*/
        //commercialFlag:"",
        //creditFlag:"1",

    };
    //重置
    dialogScope.rebort_onClick = function(){
        dialogScope.$apply(function(){
            dialogScope.conditionForm={
                custcd:bData.custcd,
                coreFlag:"1"
                /*custStatus:"1",
                 custType:"",*/
                //commercialFlag:"",
                //creditFlag:"1",

            };
           // dialogScope.selectedDialog.select=[];//清空选项
        })
    };


  // 查询买方客户
    dialogScope.queryTable = function(){
        var data= {
            pageNo: dialogScope.confDialog.pageNo,
            pageSize:dialogScope.confDialog.pageSize,
            value: dialogScope.conditionForm,
            list:parentScope.debtExtdatasource.ds //已有的交易对手列表
        };
        var promise=$common.get_asyncData("bCntDebtInfoService/findBCrmBaseInfoListByPage",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                dialogScope.datasourceDialog.ds = data.records;
                dialogScope.confDialog.totalRecord = data.totalRecord;
                //选中记录
               // dialogScope.selectedDialog.select=parentScope.debtExtdatasource.ds;
               // dialogScope.selectedDialog.select=$common.copy(parentScope.debtExtdatasource.ds);
               // dialogScope.selectedDialog.select=$common.copy(parentScope.extdatasource.ds);
             /*   var dsArray = parentScope.debtExtdatasource.ds; //已有的交易对手列表
                var querydsArray =dialogScope.datasourceDialog.ds;//查询出来的交易对手列表
                for (var i = 0; i < dsArray.length; i++) {
                    for (var j = 0; j < querydsArray.length; j++) {
                        if (dsArray[i].buyerCustcd == querydsArray[j].buyerCustcd) { //设置选中
                            dialogScope.selectedDialog.select.push(querydsArray[j]);
                        }
                    }
                }
*/
                //findBIcrprdBind();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    };

    dialogScope.confirm_onClick = function(){
        if(dialogScope.selectedDialog.select.length <= 0){
            $common.get_tipDialog('请勾选记录之后再提交！','showInform');
            return false;
        }
        //赋值到上一个页面的交易对手基本信息
       /*  var dsArray = parentScope.debtExtdatasource.ds;
         var selected =  dialogScope.selectedDialog.select;
         var addArray = []; //临时存储交易对手信息
            for (var j = 0; j < selected.length; j++) {
                addArray.push(selected[j]);
                for (var i = 0; i < dsArray.length; i++) {
                if (dsArray[i].buyerCustcd == selected[j].buyerCustcd) {
                    addArray.splice(j,1);//移除选择的这条记录
                    //客户名称被修改过的处理
                    parentScope.debtExtdatasource.ds[i].buyerName = selected[j].buyerName;
                    addArray.push(parentScope.debtExtdatasource.ds[i]);
                }
            }
        }
        parentScope.debtExtdatasource.ds=[];//清空列表
        parentScope.debtExtdatasource.ds = $common.copy(addArray);*/
        for (var i = 0; i < dialogScope.selectedDialog.select.length; i++) {
            parentScope.debtExtdatasource.ds.push(dialogScope.selectedDialog.select[i]);
        }
        dialogScope.closeThisDialog();
    };
    //取消
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
    //表格--------结束-------------------------
};

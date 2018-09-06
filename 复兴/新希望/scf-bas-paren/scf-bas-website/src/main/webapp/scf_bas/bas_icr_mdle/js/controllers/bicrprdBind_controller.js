/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      shangxiujuan
 * @version     1.0
 * Create at:   2016/11/01
 */
var bicrprdBindController = function(dialogScope,parentScope,$common,dataDeliver) {

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
  var  selected=[];
    var creditType =dataDeliver.getter().creditType;

    //监听分页
    dialogScope.$watch("confDialog.pageNo+confDialog.pageSize",function(){
        //alert("我是分页监听器");
        dialogScope.queryTable();
    });
  // 查询所有供应链品种(小类)
    dialogScope.queryTable = function(){
        var data= {
            pageNo: dialogScope.confDialog.pageNo,
            pageSize:dialogScope.confDialog.pageSize,
            bPrdInfo:{
                productType:"002" // 供应链产品种类 :小类
            }
        };
        var promise=$common.get_asyncData("bPrdInfoService/findPrdInfoByPage",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                dialogScope.datasourceDialog.ds = data.records;
                dialogScope.confDialog.totalRecord = data.totalRecord;
                findBIcrprdBind();
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    };

    //查询额度与产品的绑定
    function findBIcrprdBind() {
        var data= {
            pageNo: dialogScope.confDialog.pageNo,
            pageSize:dialogScope.confDialog.pageSize,
            bIcrPrdBind:dataDeliver.getter()
        };
        var promise=$common.get_asyncData("bIcrPrdBindService/findBIcrTypePrdBind",data);
        promise.then(function (res) {
            if(res.errorCode=="SUC"){
                data = res.contextData;
                dialogScope.selectedDialog.select = data.records;
                selected=data.records;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        })
    };

    dialogScope.confirm_onClick = function(){
        if($.doValidate("otherform")){
            var data={
                bIcrPrdBindList:dialogScope.selectedDialog.select,
                creditType:creditType
            };
            var primise = $common.get_asyncData("bIcrPrdBindService/saveBIcrTypePrdBind",data);
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog('修改成功！','showSuccess');
                    parentScope.queryTable();
                    parentScope.selected.select=[];
                    dialogScope.closeThisDialog();
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            })
        }
    };
    //取消
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
    //表格--------结束-------------------------
};

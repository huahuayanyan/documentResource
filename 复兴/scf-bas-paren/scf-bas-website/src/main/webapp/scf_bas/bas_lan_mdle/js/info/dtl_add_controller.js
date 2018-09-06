/**
 * @author 	liph
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/21
 */
var dtlInfoAddController = function(dialogScope,parentScope,$common,$state,row) {
    var datasource=row.datasource;
    var custcdBuyer=row.custcd;
    var vidBusTyp = row.vidBusTyp;
    var mastContno  = row.mastContno;
    dialogScope.conditionForm={//需要先定义业务品种对应的产品ID
        //custcdBuyer:custcdBuyer//买方客户号 C20161210000120
        custcdBuyer:custcdBuyer,
        isLocked:"0",
        bussType:vidBusTyp,
        mastContno:mastContno
    };
    dialogScope.datasource={//初始化表格对象
        ds: []
    };
    dialogScope.selected={//初始化对象
        select: []
    };
    dialogScope.selected.select=datasource;
    dialogScope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    //监听分页
    dialogScope.$watch("conf.pageNo+conf.pageSize",function(){
        dialogScope.queryTable();
    });
    //点击重置之后的搜索
    dialogScope.rebort_onClick =function(){
        dialogScope.conditionForm={
            custcdBuyer:custcdBuyer,
            isLocked:"0",
            bussType:vidBusTyp
        };
        dialogScope.queryTable();
        dialogScope.selected.select=[];
    };
    //点击查询之后的搜索
    dialogScope.submit_onClick =function(){
        dialogScope.queryTable();
        dialogScope.selected.select=[];
    };

    //查询操作brName,brNo
    dialogScope.queryTable = function(paramData){
        var data= {
            pageNo: dialogScope.conf.pageNo,
            pageSize: dialogScope.conf.pageSize,
            value:dialogScope.conditionForm
        };
        var promise = $common.get_asyncData("rBcpDebtBaseInfoService/selectRBcpDebtBaseInfoForPay",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){//数据中的经办机构要转换成中文
                data = res.contextData;
                dialogScope.datasource.ds = data.records;
                dialogScope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    //点击确认触发按钮--添加到父页面上面
    dialogScope.ysconfirm_onClick = function(){
        var data = dialogScope.selected.select;
        var parentda = parentScope.datasource.ds;
        parentScope.datasource.ds=data;
        var a = 0;
        /*for(var i=0;i<data.length;i++) {
            var parentlist = new Array();
            for(var j=0;j<parentda.length;j++){
                parentlist.push(parentda[j].billsNo);
            }
            if($.inArray(data[i].billsNo,parentlist) == -1){
                parentScope.datasource.ds.push(data[i]);
            }else{
                $common.get_tipDialog('应收账款重复','showInform');
            }
        }*/

        var pda = parentScope.datasource.ds;
        for(var m=0;m<pda.length;m++){
            a = a + pda[m].remainingAmount;
        }
        dialogScope.otherform.ysTotalAmt = a;
        dialogScope.otherform.krzje = a * (dialogScope.otherform.rzbl)/100;
        dialogScope.closeThisDialog();
    }
    dialogScope.goback_onClick = function(){
        dialogScope.closeThisDialog();
    }
};

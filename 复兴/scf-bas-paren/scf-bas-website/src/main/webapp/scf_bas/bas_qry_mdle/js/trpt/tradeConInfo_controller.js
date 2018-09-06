/**
 * Created by htrad0036 on 2017/3/22.
 */
var tradeConInfoController = function (dialogScope, parentScope, $common, row) {
    dialogScope.cntInfoForm={};

    dialogScope.mprotdatasource={ds:[]};

    dialogScope.mprotselected={select:[]};

    dialogScope.mprotConf = {
        pageNo:1,
        pageSize:10,
        totalRecord:0
    };
    //采购商品信息列表监听分页
    dialogScope.$watch("mprotConf.pageNo+mprotConf.pageSize",function(){
        dialogScope.queryBcntBuyInfo();
    });

    dialogScope.queryBcntBuyInfo = function() {
        dialogScope.cntInfoForm = row;
        data = {
            pageNo: dialogScope.mprotConf.pageNo,
            pageSize: dialogScope.mprotConf.pageSize,
            bCntBuyInfo: dialogScope.cntInfoForm
        };
        var mprotPromise = $common.get_asyncData("iBCntMprotInfoService/findBCntMprotInfoVOByPage", data);
        mprotPromise.then(function (res) {
            if (res.errorCode == "SUC") {
                data = res.contextData;
                dialogScope.mprotdatasource.ds = data.records;
                dialogScope.mprotConf.totalRecord = data.totalRecord;
            }
        });
    };

    dialogScope.closeThisDialog_onClick = function () {
        dialogScope.closeThisDialog();
    };
};
/**
 * Created by htrad0036 on 2017/2/21.
 */

//库存押品清单
var mortInfoController = function(dialogScope,parentScope,$common,flag,row) {

    dialogScope.datasource = {//初始化表格对象
    };
    dialogScope.selected = {//初始化对象
        select: []
    };
    dialogScope.conf = {//初始化分页对象
        pageNo: 1,
        pageSize: 20,
        totalRecord: 0
    };

    dialogScope.$watch("conf.pageNo + conf.pageSize",function(){
        dialogScope.queryDetail();
    });

    //点击查询之后的搜索
    dialogScope.search_onClick = function () {
        dialogScope.queryDetail();
    };

    dialogScope.queryDetail = function (paramData) {
        //查询明细
        var data = {
            pageNo: dialogScope.conf.pageNo,
            pageSize: dialogScope.conf.pageSize,
            condition :{
                conId : parentScope.detailForm.CON_ID
            }
        };
        var promise = $common.get_asyncData("inspectWhseMngService/queryMortInfo", data);
        promise.then(function (res) {
            var data1;
            if (res.errorCode == "SUC") {
                data1 = res.contextData;
                dialogScope.datasource.ds = data1.records;
                dialogScope.conf.totalRecord = data1.totalRecord;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    };

    dialogScope.save_onClick = function () {
        if(dialogScope.selected.select.length > 0){
            var existData = parentScope.dataMort.ds;
            var toAdd = [];
            for(var i = 0; i<dialogScope.selected.select.length; i++){
                var now = dialogScope.selected.select[i];
                for(var j = 0; j<existData.length; j++){
                    var exist = existData[j];
                    if(now.MORTGAGE_NO == exist.MORTGAGE_NO){
                        $common.get_tipDialog('押品编号'+now.MORTGAGE_NO+'已经在巡库押品列表，无需再次添加', 'showError');
                        return;
                    }
                }
                toAdd.push(now);
            }
            existData.push.apply(existData, toAdd);
            var tP = 0, snum = 0, sprice = 0;
            for(var j = 0; j<dialogScope.datasource.ds.length; j++){
                tP += dialogScope.datasource.ds[j].TOT_PRICE;
            }
            for(var j = 0; j<toAdd.length; j++){
                snum += toAdd[j].QUANTITY;
                sprice += toAdd[j].TOT_PRICE;
            }
            //填充数据
            var is26 = parseFloat(parentScope.detailForm.inspectElement26);
            if(!parentScope.detailForm.warehouseName)parentScope.detailForm.warehouseName = toAdd[0].WAREHOUSE;
            if(!parentScope.detailForm.inspectElement30)parentScope.detailForm.inspectElement30 = toAdd[0].WAREHOUSE_ADDRESS;
            parentScope.detailForm.inspectElement26 = sprice + is26;  //总价值
            parentScope.detailForm.inspectElement25 = snum + parseFloat(parentScope.detailForm.inspectElement25);    //总数量
            parentScope.detailForm.inspectElement33 = (is26+sprice)/tP*100;    //比例
            parentScope.$apply();
            dialogScope.closeThisDialog();
        }else{
            $common.get_tipDialog('请选择至少一条记录！','sInform');
        }
    };

    dialogScope.back_onClick = function () {
        dialogScope.closeThisDialog();
    };
};
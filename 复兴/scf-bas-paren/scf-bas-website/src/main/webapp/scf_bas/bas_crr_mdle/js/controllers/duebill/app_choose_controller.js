/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var duebillappchooseController = function(secondScope,dialogScope,dataDeliver,$state,$common,flag) {
    secondScope.conditionForm={};//初始化查询条件对象
    secondScope.datasource={//初始化表格对象
        ds: []
    };
    secondScope.selected={//初始化对象
        select: []
    };
    secondScope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    //监听分页
    secondScope.$watch("conf.pageNo+conf.pageSize",function() {
        secondScope.queryTable();
    })
    //重置
    secondScope.rebort_onClick =function(){
        secondScope.$apply(function(){
            secondScope.conditionForm = {};
            secondScope.selected.select=[];//清空选项s
        })
    }
    //搜索查询
    secondScope.submit_onClick =function(){
        secondScope.queryTable();
    }
    secondScope.queryTable = function(paramData){
        secondScope.conditionForm.appStat = '1';
        secondScope.conditionForm.isMore = '1';
        secondScope.conditionForm.lnSum = 0;
        var data= {
            pageNo: secondScope.conf.pageNo,
            pageSize: secondScope.conf.pageSize,
            bCrrLnCon:secondScope.conditionForm
        };
        var promise = $common.get_asyncData("bCrrLnConService/findBCrrLnConByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                secondScope.datasource.ds = data.records;
                secondScope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    secondScope.choose_onClick = function(){
        secondScope.flowsubmitdisable = true;
        if(secondScope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
            secondScope.flowsubmitdisable = false;
        }else{
            secondScope.closeThisDialog();
            dialogScope.secondform = secondScope.selected.select[0];
            dialogScope.secondform.custCd = dialogScope.secondform.custId;
            dialogScope.secondform.isDt = dialogScope.secondform.lnStrtDt;
            dialogScope.secondform.teDt = dialogScope.secondform.lnEndDt;
            dialogScope.secondform.lnSum = dialogScope.secondform.lnSum;
            dialogScope.secondform.lnAmt = dialogScope.secondform.lnSum;
        }
    };
    secondScope.conview_onClick = function(){
        if(secondScope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            secondScope.row = secondScope.selected.select[0];
            var prdId = secondScope.row.prdId;
            var page;
            if(prdId=="003")
            {
                page = "lncon/con_lcedit.html";
            }
            else if(prdId=="004")
            {
                page = "lncon/con_ycedit.html";
            }
            else
            {
                page = "lncon/con_edit.html";
            }
            $common.get_ngDialog(page, dialogScope
                ,["$scope",function(thirdScope){
                    duebillapplnconController(thirdScope,secondScope,dataDeliver,$state,$common,"con");
                }],"合同详情信息",{showClose:false});
        }
    }
    secondScope.prdview_onClick = function(){
        if(secondScope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            secondScope.row = secondScope.selected.select[0];
            var prdId = secondScope.row.prdId;
            var page;
            if(prdId=="003")
            {
                page = "duebill/conn/lc_edit.html";
            }
            else if(prdId=="004")
            {
                page = "duebill/conn/bill_list.html";
            }
            else
            {
                $common.get_tipDialog('流贷类合同信息无业务信息！','showInform');
                return;
            }
            $common.get_asyncData('bCrrPrdMdService/findBCrrPrdMdByPrdId',{prdId:prdId}).then(function(res){
                if (res.errorCode =="SUC"){
                    secondScope.row.prdmd = res.contextData;
                    var titNm = secondScope.row.prdmd.titNm;
                    $common.get_ngDialog(page, dialogScope
                        ,["$scope",function(thirdScope){
                            duebillapplnconController(thirdScope,secondScope,dataDeliver,$state,$common,"prd");
                        }],"业务信息详情",{showClose:false});
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        }
    }
    secondScope.gntyview_onClick = function(){
        if(secondScope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            secondScope.row = secondScope.selected.select[0];
            $common.get_ngDialog('duebill/conn/gntycon_list.html', dialogScope
                ,["$scope",function(thirdScope){
                    duebillapplnconController(thirdScope,secondScope,dataDeliver,$state,$common,"gnty");
                }],"担保信息详情",{showClose:false});
        }
    }
    secondScope.closeThisDialog_onClick = function(){
        secondScope.closeThisDialog();
    };
};

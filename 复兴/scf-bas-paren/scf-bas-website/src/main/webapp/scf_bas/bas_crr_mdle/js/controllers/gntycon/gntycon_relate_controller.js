/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var gntyconrelateController = function(dialogScope,parentScope,dataDeliver,$state,$common,flag) {
    dialogScope.datasource={//初始化表格对象
        ds: []
    };
    dialogScope.selected={//初始化对象
        select: []
    };
    dialogScope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //监听分页
    dialogScope.$watch("conf.pageNo+conf.pageSize",function() {
        dialogScope.queryTable();
    });
    dialogScope.queryTable = function(paramData){
        var data= {
            pageNo: dialogScope.conf.pageNo,
            pageSize: dialogScope.conf.pageSize,
            value:{appId:parentScope.otherform.appId,custId:parentScope.otherform.custId,conTyp:"02"}
        };
        $common.get_asyncData("bCrrGntyConService/findBCrrGntyConRelateByPage",data).then(function(res){
            var gnty;
            if (res.errorCode =="SUC"){
                gnty = res.contextData;
                dialogScope.datasource.ds = gnty.records;
                dialogScope.conf.totalRecord = gnty.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    dialogScope.choose_onClick = function(){
        dialogScope.flowsubmitdisable = true;
        if(dialogScope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
            dialogScope.flowsubmitdisable = false;
        }else{
            dialogScope.relaform = {};
            dialogScope.relaform.rltNo = dialogScope.selected.select[0].conId;
            dialogScope.relaform.serialno = parentScope.otherform.appId;
            dialogScope.relaform.rltTyp = "01";
            dialogScope.relaform.isRelate = "02";
            var primise = $common.get_asyncData("bCrrLnAppRelaService/add",{bCrrLnAppRela:dialogScope.relaform});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    dialogScope.closeThisDialog();
                    parentScope.queryTable();
                    $common.get_tipDialog('引入成功！','showSuccess');
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };

    dialogScope.view_onClick = function()
    {
        if(dialogScope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
            dialogScope.flowsubmitdisable = false;
        }else{
            dialogScope.otherform = $common.copy(parentScope.otherform);
            dialogScope.otherform.row = dialogScope.selected.select[0];
            var flg = "view";
            dialogScope.otherform.flg = flg;
            var url;
            var gutyTyp = dialogScope.otherform.row.gutyTyp;
            if(gutyTyp=="03")
            {//保证
                url = "gntycon/bail_edit.html"
            }
            else if(gutyTyp=="04")
            {//保证金
                url="gntycon/bailcash_edit.html"
            }
            else if(gutyTyp=="01")
            {//抵押
                url="gntycon/mortgage_edit.html"
            }
            else if(gutyTyp=="02")
            {//质押
                url="gntycon/pledge_edit.html"
            }
            $common.get_ngDialog(url, dialogScope
                ,["$scope",function(secondScope){
                    secondScope.otherform = dataDeliver.getter();
                    secondScope.row = dialogScope.otherform.row;
                    secondScope.hide = true;
                    secondScope.disableview = true;


                    /**
                     * 担保人名称查询加载开始
                     */
                    secondScope.gutcontent = {
                        type:"table",//展示类型table  tree
                        url:"bCrrLnAppService/queryCustSource",
                        param:{},
                        split:",",//分隔符
                        extentColumn:"gutNm",
                        column:["custNm","custId"]//展示内容
                    };
                    secondScope.gutextend = function(ds){
                        secondScope.row.gutNm = ds.custNm;
                        secondScope.row.gutId = ds.custId;
                        secondScope.row.gcrtId = ds.idno;
                        secondScope.row.gcrtTyp = ds.idtype;
                        secondScope.number = ds;
                    };
                    secondScope.$watch("row.gutNm",function(){
                        if(secondScope.row.gutNm!=null) secondScope.gutcontent.param ={custId:secondScope.row.gutNm,custNm:secondScope.row.gutNm};
                    });
                    /**
                     * 担保人名称查询加载结束
                     */

                    secondScope.closeThisDialog_onClick = function(){
                        secondScope.closeThisDialog();
                    }
                }],"担保合同信息",{showClose:false});
        }
    };

    dialogScope.close_onClick = function(){
        dialogScope.closeThisDialog();
    };
    //表格--------结束-------------------------
};

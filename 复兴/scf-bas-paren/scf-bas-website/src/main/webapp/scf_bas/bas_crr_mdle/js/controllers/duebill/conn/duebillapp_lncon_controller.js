/**
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:42:40
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 */
var duebillapplnconController = function(thirdScope,secondScope,dataDeliver,$state,$common,flag) {
    thirdScope.otherform = secondScope.row;
    var appId = thirdScope.otherform.appId;
    thirdScope.disable = true;
    thirdScope.hide = true;
    thirdScope.disableview = true;
    thirdScope.conditionForm={};//初始化查询条件对象
    thirdScope.datasource={//初始化表格对象
        ds: []
    };
    thirdScope.selected={//初始化对象
        select: []
    };
    thirdScope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    thirdScope.datasourceinfo={//初始化担保物表格对象
        ds: []
    };
    thirdScope.selectedinfo={//初始化担保物对象
        select: []
    };
    thirdScope.confinfo= {//初始化担保物分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    /**
     * 保证金信息
     */
    thirdScope.mrnFrom = {};
    if(flag=="con")
    {

    }
    else if(flag=="prd")
    {
        var prdTyp = thirdScope.otherform.prdmd.prdTyp;
        var finUrl = thirdScope.otherform.prdmd.finUrl;
        var addUrl = thirdScope.otherform.prdmd.addUrl;
        var updUrl = thirdScope.otherform.prdmd.updUrl;
        var pageUrl = thirdScope.otherform.prdmd.pageUrl;
        var titNm = thirdScope.otherform.prdmd.titNm;
        var obj = thirdScope.otherform.prdmd.obj;
        thirdScope[obj] = {};
        var extId = thirdScope.otherform.extId;
        if(thirdScope.otherform.prdmd.pageUrl)
        {
            thirdScope.$watch("conf.pageNo+conf.pageSize",function() {
                thirdScope.queryTablePrd();
            })
        }
        else
        {
            $common.get_asyncData(finUrl,{id:extId}).then(function(res){
                var data;
                if (res.errorCode =="SUC"){
                    data = res.contextData;
                    thirdScope[obj] = data.record;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                };
            });
        }
    }
    else if(flag=="gnty")
    {
        //监听分页
        thirdScope.$watch("conf.pageNo+conf.pageSize",function() {
            thirdScope.queryTable();
        })
    }
    /**
     * 业务信息查询
     * @param paramData
     */
    thirdScope.queryTablePrd = function(paramData){
        thirdScope.conditionForm.extId = extId;
        var data = {};
        data.pageNo = thirdScope.conf.pageNo;
        data.pageSize = thirdScope.conf.pageSize;
        data[obj]=thirdScope.conditionForm;
        var promise = $common.get_asyncData(pageUrl,data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                thirdScope.datasource.ds = data.records;
                thirdScope.conf.totalRecord = data.totalRecord;
                //var list = thirdScope.datasource.ds;
                //var info = {
                //    pageNo : thirdScope.confinfo.pageNo,
                //    pageSize : thirdScope.confinfo.pageSize,
                //    list : list
                //};
                //var promise = $common.get_asyncData("bMrnAppliAcctInfoService/findBMrnAppliAcctInfoByPage"+obj,info);
                //promise.then(function(res){
                //    var data;
                //    if (res.errorCode =="SUC"){
                //        data = res.contextData;
                //        thirdScope.datasourceinfo.ds = data.records;
                //        thirdScope.confinfo.totalRecord = data.totalRecord;
                //    }else{
                //        $common.get_tipDialog(res.errorMsg,'showError');
                //    }
                //});
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //监听分页,分页查询字段为空或未定义，则执行
    thirdScope.$watch("confinfo.pageNo+confinfo.pageSize",function() {
        thirdScope.queryTableInfoPrd();
    })
    thirdScope.queryTableInfoPrd = function(paramData){
        var data = {
            pageNo : thirdScope.confinfo.pageNo,
            pageSize : thirdScope.confinfo.pageSize,
            appId : thirdScope.otherform.appId
        };
        var promise = $common.get_asyncData("bMrnAppliAcctInfoService/findBMrnAppliAcctInfoByPageConNo",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                thirdScope.datasourceinfo.ds = data.records;
                thirdScope.confinfo.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    thirdScope.row = {};
    //查看发票信息
    thirdScope.viewinv_onClick = function(){
        if(thirdScope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            thirdScope.row = thirdScope.selected.select[0];
            $common.get_ngDialog('duebill/conn/inv_edit.html', thirdScope
                ,["$scope",function(forthScope){
                    duebillappprdinfoController(forthScope,thirdScope,dataDeliver,$state,$common,"view");
                }],"查看发票信息",{showClose:false});
        };
    }
    //查看票据信息
    thirdScope.viewbill_onClick = function(){
        if(thirdScope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            thirdScope.row = thirdScope.selected.select[0];
            $common.get_ngDialog('duebill/conn/bill_edit.html', secondScope
                ,["$scope",function(forthScope){
                    duebillappprdinfoController(forthScope,thirdScope,dataDeliver,$state,$common,"view");
                }],"查看票据信息",{showClose:false});
        }
    }
    /**
     * 担保信息查询
     * @param paramData
     */
    thirdScope.queryTable = function(paramData){
        thirdScope.conditionForm.appId = appId;
        var data= {
            pageNo: thirdScope.conf.pageNo,
            pageSize: thirdScope.conf.pageSize,
            bCrrGntyCon:thirdScope.conditionForm
        };
        var promise = $common.get_asyncData("bCrrGntyConService/findConBCrrGntyConByPage",data);
        promise.then(function(res){
            var gnty;
            if (res.errorCode =="SUC"){
                gnty = res.contextData;
                thirdScope.datasource.ds = gnty.records;
                thirdScope.conf.totalRecord = gnty.totalRecord;
                var list = thirdScope.datasource.ds;
                var datainfo= {
                    pageNo: thirdScope.confinfo.pageNo,
                    pageSize: thirdScope.confinfo.pageSize,
                    list:list
                };
                var promise = $common.get_asyncData("bCrrGntyInfoService/findBCrrGntyInfoByPageAndConId",datainfo);
                promise.then(function(res){
                    var info;
                    if (res.errorCode =="SUC"){
                        info = res.contextData;
                        thirdScope.datasourceinfo.ds = info.records;
                        thirdScope.confinfo.totalRecord = info.totalRecord;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //查看
    thirdScope.gntycon = {};
    thirdScope.view_onClick = function(row){
        if(thirdScope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条担保合同记录！','showInform');
        }else{
            var flg = "view";
            thirdScope.gntycon = thirdScope.selected.select[0];
            var url;
            var gutyTyp = thirdScope.gntycon.gutyTyp;
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
            $common.get_ngDialog(url, secondScope
                ,["$scope",function(forthScope){
                    duebillappgntyconController(forthScope,thirdScope,dataDeliver,$state,$common,"view");
                }],"担保合同详情",{showClose:false});
        }
    }
    thirdScope.columninfo = function(row){
        thirdScope.row = row;
        if(flag=="prd")
        {
            //查看保证金信息
            $common.get_ngDialog('info/mrn_edit.html', thirdScope
                ,["$scope",function(dialogScope){
                    mrneditController(dialogScope,thirdScope,dataDeliver,$state,$common,"view");
                }],"保证金信息详情",{showClose:false});
        }
        if(flag=="gnty")
        {
            var gntyTyp = thirdScope.row.gntyTyp;
            var url;
            if(gntyTyp=="010010")
            {//抵押-房产
                url = "gntyinfo/mort_house.html";
            }
            else if(gntyTyp=="010020")
            {//抵押-土地
                url = "gntyinfo/mort_land.html";
            }
            else if(gntyTyp=="010025")
            {//抵押-在建工程
                url = "gntyinfo/mort_build.html";
            }
            else if(gntyTyp=="010030")
            {//抵押-交通工具
                url = "gntyinfo/mort_traffic.html";
            }
            else if(gntyTyp=="010040")
            {//抵押-设备
                url = "gntyinfo/mort_eqpt.html";
            }
            else if(gntyTyp=="010050")
            {//抵押-其他
                url = "gntyinfo/mort_other.html";
            }
            else if(gntyTyp=="020050010")
            {//质押-银行承兑汇票
                url = "gntyinfo/pledge_bakdraft.html";
            }
            else if(gntyTyp=="020020020"||gntyTyp=="020020030")
            {//质押-城市重点建设债券/企业债券
                url = "gntyinfo/pledgebudbusbond.html";
            }
            else if(gntyTyp=="020060090")
            {//质押-汽车合格证
                url = "gntyinfo/pledge_carcert.html";
            }
            else if(gntyTyp=="020010010")
            {//质押-存单
                url = "gntyinfo/pledge_cert.html";
            }
            else if(gntyTyp=="020060070")
            {//质押-仓单
                url = "gntyinfo/pledge_dockwar.html";
            }
            else if(gntyTyp=="020050020")
            {//质押-汇票、本票、支票
                url = "gntyinfo/pledge_draft.html";
            }
            else if(gntyTyp=="020060030")
            {//质押-出口退税
                url = "gntyinfo/pledge_export.html";
            }
            else if(gntyTyp=="020010020")
            {//质押-外汇
                url = "gntyinfo/pledge_forexchg.html";
            }
            else if(gntyTyp=="020060010")
            {//质押-基金
                url = "gntyinfo/pledge_fund.html";
            }
            else if(gntyTyp=="020060020")
            {//质押-黄金
                url = "gntyinfo/pledge_gold.html";
            }
            else if(gntyTyp=="020020010")
            {//质押-国库券
                url = "gntyinfo/pledge_govbond.html";
            }
            else if(gntyTyp=="020060080")
            {//质押-提单
                url = "gntyinfo/pledge_ladbill.html";
            }
            else if(gntyTyp=="020060060")
            {//质押-备用信用证
                url = "gntyinfo/pledge_lecrbak.html";
            }
            else if(gntyTyp=="020060050")
            {//质押-信用证
                url = "gntyinfo/pledge_lecred.html";
            }
            else if(gntyTyp=="020030030")
            {//质押-非上市公司股权
                url = "gntyinfo/pledge_misquote.html";
            }
            else if(gntyTyp=="020040020")
            {//质押-其他动产
                url = "gntyinfo/pledge_movable.html";
            }
            else if(gntyTyp=="020060130")
            {//质押-其他
                url = "gntyinfo/pledge_other.html";
            }
            else if(gntyTyp=="020030020")
            {//质押-上市公司流通股
                url = "gntyinfo/pledge_quotecricult.html";
            }
            else if(gntyTyp=="020030010")
            {//质押-上市公司法人股
                url = "gntyinfo/pledge_quoteown.html";
            }
            else if(gntyTyp=="020060100")
            {//质押-应收账款
                url = "gntyinfo/pledge_recvacct.html";
            }
            else if(gntyTyp=="020060120")
            {//质押-存货
                url = "gntyinfo/pledge_stock.html";
            }
            else if(gntyTyp=="020040010")
            {//质押-交通工具
                url = "gntyinfo/pledge_traffic.html";
            }
            else if(gntyTyp=="020060110")
            {//质押-其他可转让权利
                url = "gntyinfo/pledge_transfer.html";
            }
            else if(gntyTyp=="020060040")
            {//质押-保单
                url = "gntyinfo/pledge_warnty.html";
            }
            $common.get_ngDialog(url, secondScope
                ,["$scope",function(forthScope){
                    duebillappgntyinfoController(forthScope,thirdScope,dataDeliver,$state,$common,"view");
                }],"担保物信息详情",{showClose:false});
        }
    };
    thirdScope.gntyinfo = {};
    thirdScope.column = function(row){
        if(flag=="prd")
        {
            $("#billinfo").css('display', '');
            var info = {
                pageNo : thirdScope.confinfo.pageNo,
                pageSize : thirdScope.confinfo.pageSize,
                list : [row]
            };
            var promise = $common.get_asyncData("bMrnAppliAcctInfoService/findBMrnAppliAcctInfoByPage"+obj,info);
            promise.then(function(res){
                var data;
                if (res.errorCode =="SUC"){
                    data = res.contextData;
                    thirdScope.datasourceinfo.ds = data.records;
                    thirdScope.confinfo.totalRecord = data.totalRecord;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
        if(flag=="gnty")
        {
            $("#gntyinfo").css('display', '');
            thirdScope.gntyinfo.conId = row.conId;
            thirdScope.gntyinfo.conNo = row.conNo;
            var data= {
                pageNo: thirdScope.confinfo.pageNo,
                pageSize: thirdScope.confinfo.pageSize,
                bCrrGntyInfo:thirdScope.gntyinfo
            };
            var promise = $common.get_asyncData("bCrrGntyInfoService/findBCrrGntyInfoByPage",data);
            promise.then(function(res){
                var data;
                if (res.errorCode =="SUC"){
                    data = res.contextData;
                    thirdScope.datasourceinfo.ds = data.records;
                    thirdScope.confinfo.totalRecord = data.totalRecord;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };
    /**
     *  国际行业分类(不支持页面的模糊查询)  开始
     */
    thirdScope.lnDircontent = {
        type:"tree",//展示类型table  tree
        url:"bBrpIndustryTypesService/findBBrpIndustryTypesTree",//请求url
        //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"-",//分隔符
        extentColumn:["treeName"],
        column:["treeName","treeId"]//展示内容
    };
    thirdScope.lnDirExtent = function(ds){
        thirdScope.otherform.lnDir=ds.treeId;
        thirdScope.otherform.dirNm=ds.treeName;
    };
    thirdScope.$watch("otherform.lnDir",function(){
        thirdScope.lnDircontent.param ={industryName:thirdScope.otherform.lnDir};
    });
    /**
     *  国际行业分类(不支持页面的模糊查询)  结束
     */
    /**
     * 客户名称查询加载开始
     */
    thirdScope.custcontent = {
        type:"table",//展示类型table  tree
        url:"bCrrLnAppService/queryCustSource",
        param:{},
        split:",",//分隔符
        extentColumn:"custNm",
        column:["custNm","custId"]//展示内容
    };
    thirdScope.dooextend = function(ds){
        thirdScope.otherform.custNm=ds.custNm;
        thirdScope.otherform.custId=ds.custId;
    };
    thirdScope.$watch("otherform.custNm",function(){
        if(thirdScope.otherform.custNm!=null) thirdScope.custcontent.param ={custId:thirdScope.otherform.custNm,custNm:thirdScope.otherform.custNm};
    });
    /**
     * 客户名称查询加载结束
     */
    /**
     * 额度编号查询加载开始
     */
    thirdScope.crnocontent = {
        type:"table",//展示类型table  tree
        url:"bCrrLnAppService/queryCrnoSource",
        param:{},
        split:",",//分隔符
        extentColumn:"appCrId",
        column:["appCrId","crNm"]//展示内容
    };
    thirdScope.crnoextend = function(ds){
        thirdScope.otherform.crNo=ds.appCrId;
    };
    thirdScope.$watch("otherform.crNo",function(){
        thirdScope.crnocontent.param ={custId:thirdScope.otherform.custId,stat:"1"};
    });
    /**
     * 额度编号查询加载结束
     */
    /**
     * 根据利率代码获取利率信息
     * @param val
     */
    function checkInt(val){
        var primise = $common.get_asyncData('bSysLnCdService/findBSysLnCdByRatecode',{ratecode:val});
        primise.then(function(res){
            if (res.errorCode =="SUC"){
                var data = res.contextData;
                thirdScope.otherform.intId = data.ratecode+"-"+data.ratename;
                thirdScope.otherform.basInt = data.rateval;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            };
        });
    }
    /**
     * 判断字段是否显示
     */
    function checkDisable(){
        var crMdl = thirdScope.otherform.crMdl;
        if(crMdl=="0")
        {
            thirdScope.hidecrmdl = true;
        }
        var intAdj = thirdScope.otherform.intAdj;
        if(intAdj=="0")
        {
            thirdScope.hideadj = true;
        }
    }
    thirdScope.close_onClick = function(){
        thirdScope.closeThisDialog();
    };
    //表格--------结束-------------------------
};

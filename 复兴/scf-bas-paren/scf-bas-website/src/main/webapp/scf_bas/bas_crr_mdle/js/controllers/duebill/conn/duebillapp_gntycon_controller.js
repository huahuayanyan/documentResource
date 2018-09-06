/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var duebillappgntyconController = function(forthScope,thirdScope,dataDeliver,$state,$common,flag) {
    forthScope.row = thirdScope.gntycon;
    forthScope.number = {};
    var appId = forthScope.row.appId;
    forthScope.disable = true;
    forthScope.hide = true;
    forthScope.disableview = true;
    /**
     * 担保人名称查询加载开始
     */
    forthScope.gutcontent = {
        type:"table",//展示类型table  tree
        url:"bCrrLnAppService/queryCustSource",
        param:{},
        split:",",//分隔符
        extentColumn:"custNm",
        column:["custNm","custId"]//展示内容
    };
    forthScope.gutextend = function(ds){
        forthScope.row.gutNm = ds.custNm;
        forthScope.row.gutId = ds.custId;
        forthScope.row.gcrtId = ds.idno;
        forthScope.row.gcrtTyp = ds.idtype;
        forthScope.number = ds;
    };
    forthScope.$watch("row.gutNm",function(){
        if(forthScope.row.gutNm!=null) forthScope.gutcontent.param ={custId:forthScope.row.gutNm,custNm:forthScope.row.gutNm};
    });
    /**
     * 担保人名称查询加载结束
     */
    forthScope.closeThisDialog_onClick = function(){
        forthScope.closeThisDialog();
    };
};

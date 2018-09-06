/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var gntyinforelaController = function(dialogScope,parentScope,dataDeliver,$state,$common,flag) {
    dialogScope.otherform = $common.copy(parentScope.otherform);
    dialogScope.relaform = $common.copy(parentScope.selected.select[0]);
    dialogScope.relaform.serialno = dialogScope.relaform.conId;
    dialogScope.disable = false;
    dialogScope.hide = true;
    var dictCode = "GuarantyList";
    var dataVal = dialogScope.relaform.gutyTyp+"0";
    var data = {
        value:{dataVal:dataVal,dictCode:dictCode}
    }
    var autoTPromise = $common.get_asyncData('bCrrGntyInfoService/changeGuarantyListToTree',data);
    autoTPromise.then(function(res) {
        dialogScope.autotree.allChildNode =  res.contextData;
    })
    dialogScope.autotree = {
        isCheckBox:false,       // 是否加入CheckBox复选框
        isClickRow: true,  	 // 是否点击行触发事件
        isAutoSelect: false,   // 是否自动勾选父子级关系
        isAllShow: false,      // 是否打开全部节点（异步树，此值不能随意修改）
        //headNode: {treeId: 0,treeName: '首节点'},  // 自定义首目录节点
        allChildNode: [],  // 首目录下所有的子节点
        //树必须包含的字段"treeId  treeName  treeParentId  hasChilds  isChecked"
        //allChildNode:[{"treeId": "1003", "treeName": "文本", "treeLevel":"1", "treeParentId":"0",hasChilds:true,isChecked:true},]
        //dPicUrl: '../../images/',  // 默认图片路径
        customFun: function(node){
            dialogScope.relaform.gntyTypId=node.treeId;
            dialogScope.relaform.gntyTyp=node.treeName;
            dialogScope.relaform.treeLevel = node.treeLevel;
        },  // 自定义文字点击函数,isClickRow=true生效
        boxEventFun: function(node,isSelect){
        },  // 自定义checkbox点击函数，isCheckBox=true生效
        showBoxFun: function(node){
            //alert("showBoxFun: "+JSON.stringify(node));
            return true
        }/*,   // 自定义是否展示checkbox复选框，isCheckBox=true生效

         async: true,          //是否异步查询树
         url:'/autoTree',  //父节点点击异步查询树地址,后台接口接受固定参数格式 key:fId  {fId:"1000"}
         dataFilter: function(treeDataList){   // 过滤callback数据
         return treeDataList
         }*/
    };
   /* /!**
     *  担保物类型树状结构  开始
     *!/
    dialogScope.gntyTypcontent = {
        type:"tree",//展示类型table  tree
        url:"bCrrGntyInfoService/changeGuarantyListToTree",//请求url
        //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"-",//分隔符
        extentColumn:["treeName"],
        column:["treeName"]//展示内容
    };
    dialogScope.gntyTypextend = function(ds){
        dialogScope.relaform.gntyTypId=ds.treeId;
        dialogScope.relaform.gntyTyp=ds.treeName;
    };
    dialogScope.$watch("relaform.gntyTyp",function(){
        /!*if(dialogScope.relaform.gntyTyp!=null)*!/ dialogScope.gntyTypcontent.param ={dataVal:dataVal,dictCode:dictCode};
    });
    /!**
     *  担保物类型树状结构  结束
     *!/
    dialogScope.checkGntyTyp = function(val)
    {
        if(val=="010")
        {
            $common.get_tipDialog("请重新选择抵押类型！",'showError');
        }
    }*/
    dialogScope.confirm_onClick = function(){
        if($.doValidate("relaform")) {
            dialogScope.disable = true;
            var gntyTyp = dialogScope.relaform.gntyTypId;
            var level = dialogScope.relaform.treeLevel;
            if(level=="1")
            {
                $common.get_tipDialog("请重新选择类型！",'showError');
                dialogScope.disable = false;
            }
            else
            {
                if(dataVal=="020")
                {
                    if(level=="2")
                    {
                        $common.get_tipDialog("请重新选择类型！",'showError');
                        dialogScope.disable = false;
                        return;
                    }
                }
                //先查询后修改或新增
                var primise = $common.get_asyncData("bCrrGntyRelaService/cachadd",{bCrrGntyRela:dialogScope.relaform});
                primise.then(function(res){
                    var data;
                    if (res.errorCode =="SUC"){
                        dialogScope.closeThisDialog();
                        data = res.contextData;
                        dialogScope.relaform = data;
                        var gntyId = dialogScope.relaform.rltNo;
                        dialogScope.relaform.gntyId = gntyId;
                        dialogScope.relaform.gntyTyp = gntyTyp;
                        dialogScope.otherform.row = dialogScope.relaform;
                        var flg = "add";
                        dialogScope.otherform.flg = flg;
                        var url;
                        if(gntyTyp=="010010")
                        {//抵押-房产
                            url = "morthouse";
                        }
                        else if(gntyTyp=="010020")
                        {//抵押-土地
                            url = "mortland";
                        }
                        else if(gntyTyp=="010025")
                        {//抵押-在建工程
                            url = "mortbuild";
                        }
                        else if(gntyTyp=="010030")
                        {//抵押-交通工具
                            url = "morttraffic";
                        }
                        else if(gntyTyp=="010040")
                        {//抵押-设备
                            url = "morteqpt";
                        }
                        else if(gntyTyp=="010050")
                        {//抵押-其他
                            url = "mortother";
                        }
                        else if(gntyTyp=="020050010")
                        {//质押-银行承兑汇票
                            url = "plbakdraft";
                        }
                        else if(gntyTyp=="020020020"||gntyTyp=="020020030")
                        {//质押-城市重点建设债券/企业债券
                            url = "plbbbond";
                        }
                        else if(gntyTyp=="020060090")
                        {//质押-汽车合格证
                            url = "plcarcert";
                        }
                        else if(gntyTyp=="020010010")
                        {//质押-存单
                            url = "plcert";
                        }
                        else if(gntyTyp=="020060070")
                        {//质押-仓单
                            url = "pldockwar";
                        }
                        else if(gntyTyp=="020050020")
                        {//质押-汇票、本票、支票
                            url = "pldraft";
                        }
                        else if(gntyTyp=="020060030")
                        {//质押-出口退税
                            url = "plexport";
                        }
                        else if(gntyTyp=="020010020")
                        {//质押-外汇
                            url = "plforexchg";
                        }
                        else if(gntyTyp=="020060010")
                        {//质押-基金
                            url = "plfund";
                        }
                        else if(gntyTyp=="020060020")
                        {//质押-黄金
                            url = "plgold";
                        }
                        else if(gntyTyp=="020020010")
                        {//质押-国库券
                            url = "plgovbond";
                        }
                        else if(gntyTyp=="020060080")
                        {//质押-提单
                            url = "plladbill";
                        }
                        else if(gntyTyp=="020060060")
                        {//质押-备用信用证
                            url = "pllecrbak";
                        }
                        else if(gntyTyp=="020060050")
                        {//质押-信用证
                            url = "pllecred";
                        }
                        else if(gntyTyp=="020030030")
                        {//质押-非上市公司股权
                            url = "plmisquote";
                        }
                        else if(gntyTyp=="020040020")
                        {//质押-其他动产
                            url = "plmovable";
                        }
                        else if(gntyTyp=="020060130")
                        {//质押-其他
                            url = "plother";
                        }
                        else if(gntyTyp=="020030020")
                        {//质押-上市公司流通股
                            url = "plqutcriclt";
                        }
                        else if(gntyTyp=="020030010")
                        {//质押-上市公司法人股
                            url = "plqutown";
                        }
                        else if(gntyTyp=="020060100")
                        {//质押-应收账款
                            url = "plrecvacct";
                        }
                        else if(gntyTyp=="020040010")
                        {//质押-交通工具
                            url = "pltraffic";
                        }
                        else if(gntyTyp=="020060110")
                        {//质押-其他可转让权利
                            url = "pltransfer";
                        }
                        else if(gntyTyp=="020060040")
                        {//质押-保单
                            url = "plwarnty";
                        }
                        else if(gntyTyp=="020060120")
                        {//质押-存货
                            url = "plstock";
                        }
                        $state.go("lnapp."+url);
                        dataDeliver.setter(dialogScope.otherform);
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            }
        };
    };
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

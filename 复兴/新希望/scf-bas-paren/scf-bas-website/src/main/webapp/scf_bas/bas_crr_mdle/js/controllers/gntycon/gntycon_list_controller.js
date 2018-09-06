/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var gntyconlistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform = dataDeliver.getter();
    $scope.hidecon = true;
    $scope.gntycon = {};
    var count = 0;//记录查询担保物列表的次数
    var flag = $scope.otherform.flag;
    var appId = $scope.otherform.appId;
    if($scope.otherform.flag == "add"){
        $common.get_tipDialog("请先维护业务申请信息！",'showInform');
        var baseparam = $scope.otherform.baseparam;
        $state.go(baseparam);
        $scope.$parent.panes.forEach(function(pane){
            if (pane.uiSref == baseparam){
                $scope.$parent.select(pane);
            }
        });
        return;
    }
    $scope.conditionForm={};//初始化查询条件对象
    if(!$scope.otherform.flag)
    {
        $scope.disable = true;
        $scope.hide = true;
        $scope.hideinfo = true;
        $scope.hidecon = true;
    }
    else
    {
        if(flag=="view"||flag=="lnconview"||flag=="lnconedit")
        {
            $scope.disable = true;
            $scope.hide = true;
            $scope.hideinfo = true;
            $scope.hidecon = true;
            if(flag=="lnconedit")
            {
                $scope.hidecon = false;
            }
        }
        else if(flag=="add")
        {
            $scope.disable = false;
            $scope.hide = false;
        }
        else if(flag=="update")
        {
            $scope.disable = true;
            $scope.hide = false;
        }
    }
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    $scope.datasourceinfo={//初始化表格对象
        ds: []
    };
    $scope.selectedinfo={//初始化对象
        select: []
    };
    $scope.confinfo= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    });

    $scope.queryTable = function(paramData){
        $scope.conditionForm.appId = appId;
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bCrrGntyCon:$scope.conditionForm
        };
        var promise;
        if(flag=="lnconview"||flag=="lnconedit")
        {
            promise = $common.get_asyncData("bCrrGntyConService/findConBCrrGntyConByPage",data);
        }
        else
        {
            promise = $common.get_asyncData("bCrrGntyConService/findAppBCrrGntyConByPage",data);
        }
        promise.then(function(res){
            var gnty;
            if (res.errorCode =="SUC"){
                gnty = res.contextData;
                $scope.datasource.ds = gnty.records;
                $scope.conf.totalRecord = gnty.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    //新增
    $scope.add_onClick = function(){
        $common.get_ngDialog('gntycon/con_add.html', $scope
            ,["$scope",function(dialogScope){
                gntyconaddController(dialogScope,$scope,dataDeliver,$state,$common,"add");
            }],"担保合同类型选择",{showClose:false},500);
    };
    //编辑
    $scope.update_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $scope.otherform.row = $scope.selected.select[0];
            if($scope.otherform.row.isRelate!="01")
            {
                $common.get_tipDialog('引入担保合同信息不可修改！','showInform');
                $scope.selected.select=[];
                return;
            }
            var flg = "update";
            $scope.otherform.flg = flg;
            var url;
            var gutyTyp = $scope.otherform.row.gutyTyp;
            if(gutyTyp=="03")
            {//保证
                url = "bail"
            }
            else if(gutyTyp=="04")
            {//保证金
                url="bailcash"
            }
            else if(gutyTyp=="01")
            {//抵押
                url="mortgage"
            }
            else if(gutyTyp=="02")
            {//质押
                url="pledge"
            }
            $state.go("lnapp."+url);
            dataDeliver.setter($scope.otherform);
        }
    };
    //删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                var data = {
                    list:$scope.selected.select,
                    value:{appId:appId}
                };
                var primise = $common.get_asyncData('bCrrGntyConService/batchDelete',data)
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.queryTable();
                        $scope.selected.select=[];
                        $common.get_tipDialog('删除成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
            })
        }
    };
    //查看
    $scope.view_onClick = function(row){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条担保合同记录！','showInform');
        }else{
            var flg = "view";
            $scope.otherform.row = $scope.selected.select[0];
            $scope.otherform.flg = flg;
            var url;
            var gutyTyp = $scope.otherform.row.gutyTyp;
            if(gutyTyp=="03")
            {//保证
                url = "bail"
            }
            else if(gutyTyp=="04")
            {//保证金
                url="bailcash"
            }
            else if(gutyTyp=="01")
            {//抵押
                url="mortgage"
            }
            else if(gutyTyp=="02")
            {//质押
                url="pledge"
            }
            if(!$scope.otherform.flag)
            {
                $state.go(""+url);
            }
            else
            {
                if(flag == "lnconview"||flag=="lnconedit")
                {
                    $state.go("lncon."+url);
                }
                else
                {
                    $state.go("lnapp."+url);
                }
            }
            dataDeliver.setter($scope.otherform);
        }
    };
    /**
     * 担保物信息js开始
     */
    //监听分页
    $scope.$watch("confinfo.pageNo+confinfo.pageSize",function() {
        if(count!=0)
        {

            $scope.findinfo_onClick();
        }
        count++;
    });
    $scope.gntyinfo = {};
    $scope.findinfo_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条担保合同记录！','showInform');
        }else{
            $("#gntyinfo").css('display', '');
            $scope.gntycon = $scope.selected.select[0];
            if(flag=="lnconview"||flag=="lnconedit")
            {
                $scope.hideinfo = true;
            }
            else
            {
                if($scope.gntycon.isRelate!="01")
                {
                    $scope.hideinfo = true;
                }
                else
                {
                    $scope.hideinfo = false;
                }
            }
            $scope.gntyinfo.conId = $scope.selected.select[0].conId;
            $scope.gntyinfo.conNo = $scope.selected.select[0].conNo;
            var data= {
                pageNo: $scope.confinfo.pageNo,
                pageSize: $scope.confinfo.pageSize,
                bCrrGntyInfo:$scope.gntyinfo
            };
            var promise = $common.get_asyncData("bCrrGntyInfoService/findBCrrGntyInfoByPage",data);
            promise.then(function(res){
                var data;
                if (res.errorCode =="SUC"){
                    data = res.contextData;
                    $scope.datasourceinfo.ds = data.records;
                    $scope.confinfo.totalRecord = data.totalRecord;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    };
    //新增
    $scope.addinfo_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条担保合同记录！','showInform');
        }else{
            var gutyTyp = $scope.selected.select[0].gutyTyp;
            if(gutyTyp=="03"||gutyTyp=="04")
            {
                $common.get_tipDialog('保证及保证金式担保合同不需维护担保物信息！','showInform');
                $scope.selected.select=[];
            }
            else
            {
                $common.get_ngDialog('gntyinfo/info_rela.html', $scope
                    ,["$scope",function(dialogScope){
                        gntyinforelaController(dialogScope,$scope,dataDeliver,$state,$common,flag);
                    }],"担保物抵质押类型选择",{showClose:false},500);
            }
        }
    };
    //编辑
    $scope.updateinfo_onClick = function(){
        if($scope.selectedinfo.select.length <= 0){
            $common.get_tipDialog('请至少选择一条担保物记录！','showInform');
        }else{
            var flg = "update";
            $scope.disable = true;
            $scope.otherform.row = $scope.selectedinfo.select[0];
            $scope.otherform.flg = flg;
            var gntyTyp = $scope.otherform.row.gntyTyp;
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
            dataDeliver.setter($scope.otherform);
        }
    };
    //删除
    $scope.deleteinfo_onClick = function(){
        if($scope.selectedinfo.select.length <= 0){
            $common.get_tipDialog('请至少选择一条担保物记录！','showInform');
        }else{
            var arrs = $common.copy($scope.selected.select);
            $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                var primise = $common.get_asyncData('bCrrGntyInfoService/batchDelete',{list:$scope.selectedinfo.select})
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $scope.queryTable();
                        $scope.selectedinfo.select=[];
                        $common.get_tipDialog('删除成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
            })
        }
    };
    $scope.columninfo = function(row){
        var flg = "view";
        $scope.otherform.row = row;
        $scope.otherform.flg = flg;
        var gntyTyp = $scope.otherform.row.gntyTyp;
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
        if(!$scope.otherform.flag)
        {
            $state.go(""+url);
        }
        else
        {
            if(flag == "lnconview"||flag=="lnconedit")
            {
                $state.go("lncon."+url);
            }
            else
            {
                $state.go("lnapp."+url);
            }
        }
        dataDeliver.setter($scope.otherform);
    };
    $scope.column = function(row){
        $("#gntyinfo").css('display', '');
        $scope.gntycon = row;
        if(flag=="lnconview"||flag=="lnconedit")
        {
            $scope.hideinfo = true;
        }
        else
        {
            if($scope.gntycon.isRelate!="01")
            {
                $scope.hideinfo = true;
            }
            else
            {
                $scope.hideinfo = false;
            }
        }
        $scope.gntyinfo.conId = row.conId;
        $scope.gntyinfo.conNo = row.conNo;
        var data= {
            pageNo: $scope.confinfo.pageNo,
            pageSize: $scope.confinfo.pageSize,
            bCrrGntyInfo:$scope.gntyinfo
        };
        var promise = $common.get_asyncData("bCrrGntyInfoService/findBCrrGntyInfoByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasourceinfo.ds = data.records;
                $scope.confinfo.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    /**
     * 担保物信息js结束
     */
    $scope.relate_onClick = function(){
        $common.get_ngDialog('gntycon/gntycon_relate.html', $scope
            ,["$scope",function(dialogScope){
                gntyconrelateController(dialogScope,$scope,dataDeliver,$state,$common,flag);
            }],"担保合同引入",{showClose:false});
    };

    $scope.updateCon_onClick = function(row){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $scope.otherform.row = $scope.selected.select[0];
            if($scope.otherform.row.isRelate!="01")
            {
                $common.get_tipDialog('引入担保合同信息不可修改！','showInform');
                $scope.selected.select=[];
                return;
            }
            var flg = "lnconedit";
            $scope.otherform.flg = flg;
            var url;
            var gutyTyp = $scope.otherform.row.gutyTyp;
            if(gutyTyp=="03")
            {//保证
                url = "bail"
            }
            else if(gutyTyp=="04")
            {//保证金
                url="bailcash"
            }
            else if(gutyTyp=="01")
            {//抵押
                url="mortgage"
            }
            else if(gutyTyp=="02")
            {//质押
                url="pledge"
            }
            $state.go("lncon."+url);
            dataDeliver.setter($scope.otherform);
        }
    };
    //表格--------结束-------------------------
};

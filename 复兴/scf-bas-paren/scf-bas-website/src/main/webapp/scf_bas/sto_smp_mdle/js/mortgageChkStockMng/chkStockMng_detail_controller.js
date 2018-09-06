/**
 * Created by htrad0036 on 2017/2/21.
 */

//核库详情
var chkStockMngDetailController = function ($scope, $common, $state, dataDeliver) {
    var row = dataDeliver.getter().protocol_value;
    row.supplyChainPdId = '1220010';
    $scope.detailForm = row;
    $scope.view = dataDeliver.getter().view;

    //查询明细
    $scope.queryDetail = function (paramData) {
        var data = {condition :{}};
        if(dataDeliver.getter().protocol_value.ID) {
            data.condition.id = dataDeliver.getter().protocol_value.ID;
        }
        if(dataDeliver.getter().protocol_value.view) {
            data.condition.view = dataDeliver.getter().protocol_value.view;
        }
        data.condition.prtclNo = dataDeliver.getter().protocol_value.PRTCL_NO;
        data.condition.conId = dataDeliver.getter().protocol_value.CON_ID;
        var promise = $common.get_asyncData("mortgageChkStockMngService/queryCekStkDetailById", data);
        promise.then(function (res) {
            var data1;
            if (res.errorCode == "SUC") {
                data1 = res.contextData;
                var record = data1.records[0];
                angular.extend($scope.detailForm, record);
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    };
    $scope.$watch("detailForm.supplyChainPdId",function(a, b){
        $scope.queryDetail();
    });
    $scope.datasource = {//初始化表格对象
    };
    $scope.selectSource = {
        ds:[{key:"1220010",value:'现货静态质押'}]
    };
    $scope.selected = {//初始化对象
        select: []
    };
    $scope.conf = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };
    //树==上级机构
    $scope.content = {
        type:"table",//展示类型table  tree
        url:"mortgageInoutService/selectOrg",//请求url
        //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
        split:"-",//分隔符
        extentColumn:"brName",
        column:["brNo","brName"]//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.detailForm.brCode=ds.brNo;
    };
    $scope.$watch("detailForm.brName",function(a, b){
        $scope.content.param ={
            brName:$scope.detailForm.brName
        };
        if($scope.detailForm.brName==null||$scope.detailForm.brName==""){
            $scope.detailForm.brCode=null;
            $scope.detailForm.brName=null;
        }
    });

    $scope.checkFormEles = function(){
        var errorMsg = '内容不能为空！';
        if(!$.doValidate("detailForm")) return false;
        if(!$scope.detailForm.inspectElement1){
            $common.get_tipDialog('[是否制定安全保卫制度]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement2){
            $common.get_tipDialog('[是否设定验货、入库、出库等内部操作岗位]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement3){
            $common.get_tipDialog('[以往客户货物进出手续是否齐全]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement4){
            result = false;
            $common.get_tipDialog('[管理人员综合素质]'+errorMsg, 'showError');
        }
        if(!$scope.detailForm.inspectElement5){
            $common.get_tipDialog('[操作人员行业经验]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement6){
            result = false;
            $common.get_tipDialog('[监管公司对我行核库配合]'+errorMsg, 'showError');
        }
        if(!$scope.detailForm.inspectElement7){
            $common.get_tipDialog('[仓储环境是否适合质押货物保管]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement8){
            $common.get_tipDialog('[仓库是否具备基本仓储设施]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement9){
            $common.get_tipDialog('[安保体系是否落实]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement36){
            $common.get_tipDialog('[第三方（或授信客户）对监管的配合]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement10){
            $common.get_tipDialog('[押品保管是否有明确的仓位]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement11){
            $common.get_tipDialog('[押品是否悬挂质押标识]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement12){
            $common.get_tipDialog('[押品运输单据、入库单与监管公司账务记载货主是否相符]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement13){
            $common.get_tipDialog('[质物运输单据、入库单、监管方账务与质物清单是否相符]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement14){
            $common.get_tipDialog('[与购销合同（单证）约定货物是否相符]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement15){
            $common.get_tipDialog('[到货时间、收货人、到货港（站）与购销合同约定是否相符]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement16){
            $common.get_tipDialog('[监管公司是否进驻]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement18){
            $common.get_tipDialog('[适时审核监督是否落实]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement19){
            $common.get_tipDialog('[是否按我行最低控货价值进行监管]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement20){
            $common.get_tipDialog('[在库质押货物与质物清单是否相符]'+errorMsg, 'showError');
            return false;
        }
        if(!$scope.detailForm.inspectElement21){
            $common.get_tipDialog('[第三方或授信客户是否配合监管]'+errorMsg, 'showError');
            return false;
        }
        return true;
    };

    //保存按钮
    $scope.save_onClick = function () {
        if(!$scope.checkFormEles()) return;
        if(!isNaN($scope.detailForm.inspectElement34)){
            if($scope.detailForm.inspectElement34 != $scope.detailForm.inspectElement26){
                $common.get_tipDialog("当前查库总价值不等于该质押合同下的押品总价值，是否继续？",'showTip').then(function() {
                        $scope.saveDate();
                    })
            }else{
                $scope.saveDate();
            }
        }else{
            $scope.saveDate();
        }
    };

    $scope.saveDate = function () {
        $scope.detailForm.conId = $scope.detailForm.CON_ID;
        $scope.detailForm.brcode = $scope.detailForm.BRCODE;//核库机构
        $scope.detailForm.tlrcd = $scope.detailForm.TLRNO;//核库人
        $scope.detailForm.moniCustcd = $scope.detailForm.CUSTCD;//监管公司
        $scope.detailForm.inspectElement22 = $scope.detailForm.GUT_ID;//出质人
        var data = {
            detailsObj :$scope.detailForm
        };
        var promise = $common.get_asyncData("mortgageChkStockMngService/addWhseInspectDetail", data);
        promise.then(function (res) {
            var data1;
            if (res.errorCode == "SUC") {
                $state.go("mortgageChkStockMng")
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    };

    //返回按钮
    $scope.back_onClick = function () {
        dataDeliver.setter();
        $state.go("mortgageChkStockMng");
    };
};
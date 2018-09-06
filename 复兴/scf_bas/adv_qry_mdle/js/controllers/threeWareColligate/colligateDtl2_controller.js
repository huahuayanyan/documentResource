/**
 * Created by htrad0036 on 2017/2/23.
 */
var protocolInfoController = function($scope,$common,dataDeliver,$state,$compile,$eventCommunicationChannel) {

    var obj = angular.fromJson(dataDeliver.getter());
    var threeProtocolVO = {
        protocolNo: obj.info.protocolNo
    };
    var data = {
        threeProtocolVO: threeProtocolVO
    };
    $scope.threeProtocolForm = {};
    $scope.selectbrcode = {};
    var promise = $common.get_asyncData("threeProtocolService/queryThreeProtocolForOneObject", data);
    promise.then(function (res) {
        if (res.errorCode == "SUC") {
            data = res.contextData;
            $scope.threeProtocolForm = data;
            $scope.selectbrcode.ds = data.listBctl;
            $scope.threeProtocolForm.brcode = data.brcode;
            $scope.threeProtocolForm.inputorgname = data.inputorgname;
            if (data.dutyAssumeType != null) {
                $scope.threeProtocolForm.dutyAssumeType = JSON.parse(data.dutyAssumeType);
            }
            if (data.loanWay != null) {
                $scope.threeProtocolForm.loanWay = JSON.parse(data.loanWay);
            }
            $scope.brcodeDisable = true;
        } else {
            $common.get_tipDialog(res.errorMsg, 'showError');
        }
    });
    $scope.back_onClick = function () {
        $scope.closeThisDialog();
        $scope.queryTable();
        $scope.selected.select = [];
    };
    //合作机构下拉-begin
    $scope.cooperationBrcodeNmContent = {
        type: "table",//展示类型table  tree
        url: "bSysCommonService/selectBranchInfo",//请求url
        param: {brAttr: "1"},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split: "-",//分隔符
        extentColumn: "brName",
        column: ["brNo", "brName"]//展示内容
    };
    $scope.cooperationBrcodeNmExtent = function (ds) {
        $scope.threeProtocolForm.cooperationBrcode = ds.brNo;
        $scope.threeProtocolForm.cooperationBrcodeNm = ds.brName;
    };
    //承担方客户名称下拉-begin
    $scope.fouNameContent = {
        type: "table",//展示类型table  tree
        url: "bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split: "-",//分隔符
        extentColumn: "cname",
        column: ["custcd", "cname"]//展示内容
    };
    $scope.fouNameExtent = function (ds) {
        $scope.threeProtocolForm.fouCd = ds.custcd;
        $scope.threeProtocolForm.fouName = ds.cname;
    };
    //卖方客户名称下拉-begin
    $scope.coreNmContent = {
        type: "table",//展示类型table  tree
        url: "bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split: "-",//分隔符
        extentColumn: "cname",
        column: ["custcd", "cname"]//展示内容
    };
    $scope.coreNmExtent = function (ds) {
        $scope.threeProtocolForm.coreCustcd = ds.custcd;
        $scope.threeProtocolForm.coreNm = ds.cname;
    };
    //买方客户名称下拉-begin
    $scope.sellerNmContent = {
        type: "table",//展示类型table  tree
        url: "bCrmBaseInfoService/selectBCrmBaseInfoByPage",//请求url
        //param:{creditFlag: '1',custType:'1'},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split: "-",//分隔符
        extentColumn: "cname",
        column: ["custcd", "cname"]//展示内容
    };
    $scope.dooextent = function (ds) {
        $scope.threeProtocolForm.custcd = ds.custcd;
        $scope.threeProtocolForm.sellerNm = ds.cname;
    };
    var productPar = {
        pageNo: '1',
        pageSize: '999999',
        bPrdInfo: {parentId: '2100'}
    };
    //业务品种
    product();
    $scope.productSource = {};
    function product() {
        var promise = $common.get_asyncData("bPrdInfoService/findPrdInfoByPage", productPar);
        promise.then(function (res) {
            var data;
            if (res.errorCode == "SUC") {
                data = res.contextData;
                $scope.productSource.ds = data.records;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    }

};
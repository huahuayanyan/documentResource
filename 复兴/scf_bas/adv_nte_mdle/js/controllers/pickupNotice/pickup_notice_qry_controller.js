/**
 * Created by htrad0036 on 2017/2/17.
 */

//提货通知书列表
var pickupNoticeQryController = function ($scope, $common, $state, dataDeliver) {

    //初始化查询条件对象
    $scope.conditionForm = {
        bussType:"1210020",
        //noticeTypeSet:["22","83"]
        noticeType:'83'
    };


    $scope.datasource = {//初始化表格对象
    };
    $scope.selected = {//初始化对象
    };

    $scope.selectSource = {
        ds:[
            {key:"22",value:'动产融资提货通知书'},
            {key:"83",value:'先票/款后货提货通知书'}
        ]
    };

    $scope.productSource = {
        ds:[
            {key:"1210020",value:'先票/款后货'},
        ]
    };

    $scope.conf = {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };
    //productSource();

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize", function () {
        $scope.queryTable();
    });

    $scope.productSource = {
        ds:[
            {key:"1210020",value:'先票/款后货'},
        ]
    };

    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize", function () {
        $scope.queryTable();
    });
    //点击查询之后的搜索
    $scope.submit_onClick = function () {
        $scope.queryTable();
        $scope.selected.select = [];
    };
    //查询操作
    $scope.queryTable = function (paramData) {
        var data = {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            noticeQryVO: $scope.conditionForm
        };
        var promise = $common.get_asyncData("aQuantityNoticeService/queryQuantityNoticeByPage", data);
        promise.then(function (res) {
            var data1;
            if (res.errorCode == "SUC") {
                data1 = res.contextData;
                $scope.datasource.ds = data1.records;
                $scope.conf.totalRecord = data1.totalRecord;
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    };
//查看操作！
    $scope.column = function(row){
        $common.get_ngDialog('pickupNotice/pickup_notice_qry_view.html', $scope
            ,["$scope",function(dialogScope){
                //pickupNoticeQryViewController(dialogScope,$scope,$common,row);
                dialogScope.otherform = row;
                dialogScope.closeThisDialog_onClick = function () {
                    dialogScope.closeThisDialog();
                };
            }],"提货通知书基本信息",{showClose:true});
    };
    //重置按钮
    $scope.rebort_onClick = function () {
        $scope.$apply(function(){
            $scope.conditionForm = {
                bussType:"1210020",
                //noticeTypeSet:["22","83"]
                noticeType:'83'
            };
            $scope.selected.select=[];//清空选项s
            $scope.queryTable();
        })
    };
    $scope.view_onClick = function(){
        if($scope.selected.select.length == 1){
            var id = $scope.selected.select[0].id;//定义选中参数id
            var noticeType = $scope.selected.select[0].noticeType;
            var appno = $scope.selected.select[0].appno;
            // var param={id:"1B63J91TS007A2C7FCAA0000939BE0E9",noticeType:"71",appno:"CETKT2017011000020"};
            var param={id:id,noticeType:noticeType,appno:appno};
            toPrint(param);
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
};
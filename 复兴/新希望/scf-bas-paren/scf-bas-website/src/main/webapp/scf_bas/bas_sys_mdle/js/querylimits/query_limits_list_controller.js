/**
 * Created by htrad0016 on 2016/8/23.
 */
var queryLimitsListController= function ($scope,$common) {
    //分页
    $scope.conf= {pageNo: 1, pageSize: 10};
    //查询条件对象
    $scope.roleInfoVO={};
    $scope.selected={};
    $scope.datasource={};
    //分页监控
    $scope.$watch("conf.pageNo+conf.pageSize", function (a,b) {
        if(a!==b){
            queryTable($scope.roleInfoVO);
        }
    });
    queryTable($scope.roleInfoVO);
    //树==上级机构
    $scope.content = {
        type:"autoTree",//展示类型table  tree
        url:"orgService/selectBctlTree",//请求url
        param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"",//分隔符
        extentColumn:"",
        column:['brName'],//展示内容
        func: function (node) {
            $scope.roleInfoVO.treeName=node.treeName;
            $scope.roleInfoVO.brId=node.treeId;
        }
    };
    $scope.readonly=true;
    //查询
    function queryTable(param){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            roleInfoVO:param
        };
        var promise = $common.get_asyncData("bsysQueryLimitsService/findRoleInfoAndLimitsByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else if(res.errorMsg=='您已被踢出,请重新登录'){
                $common.get_tipDialog(res.errorMsg,'showTip').then(function () {
                    window.parent.document.location.href='../../../scube_ui/index.html';
                });
            }else {
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    }

    //查询按钮
    $scope.submit_onClick = function () {
        $scope.selected.select=[];
        if($('input[id="treeName"]').val()==''){
            $scope.roleInfoVO.brId=null;
        }
        queryTable($scope.roleInfoVO)
    };
    //重置
    $scope.rebort_onClick = function()
    {
        $scope.roleInfoVO={};
        $scope.selected.select = [];
        $scope.$apply();
    };

    //刷新按钮
    $scope.fresh_onClick = function(){
        $scope.roleInfoVO={};
        $scope.selected.select=[];
        queryTable($scope.roleInfoVO);
    };

    //权限设置按钮
    $scope.limits_onClick = function(){
        if($scope.selected.select.length <= 0||$scope.selected.select.length > 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('querylimits/query_limits_edit.html',$scope,["$scope",function(updateScope){
                updateScope.disableBrId=true;
                updateScope.otherform=$common.copy($scope.selected.select[0]);
                updateScope.otherform.treeName=$scope.selected.select[0].brName;
                if($scope.selected.select[0].roleType=='超级管理员'){
                    updateScope.otherform.roleType='1';
                }else if($scope.selected.select[0].roleType=='管理员'){
                    updateScope.otherform.roleType='2';
                }else if($scope.selected.select[0].roleType=='非管理员'){
                    updateScope.otherform.roleType='3';
                }
                //树==上级机构
                updateScope.content = {
                    type:"autoTree",//展示类型table  tree
                    url:"orgService/selectBctlTree",//请求url
                    param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
                    split:"",//分隔符
                    extentColumn:"",
                    column:['brName'],//展示内容
                    func: function (node) {
                        updateScope.otherform.treeName=node.treeName;
                        updateScope.otherform.brId=node.treeId;
                    }
                };
                updateScope.confirm_onClick = function(){
                    if($('input[id="treeName"]')[1].value==''){
                        updateScope.otherform.brId=null;
                    }
                    if($.doValidate("otherform")){
                        var primise = $common.get_asyncData('bsysQueryLimitsService/saveQueryLimits',{bSysQueryLimitsVO:updateScope.otherform});
                        primise.then(function(res){
                            if (res.errorCode =="SUC"){
                                $common.get_tipDialog('更新成功！','showSuccess');
                                queryTable($scope.roleInfoVO);
                                $scope.selected.select=[];
                                updateScope.closeThisDialog();
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        })
                    }
                };
                updateScope.cancel_onClick = function(){
                    updateScope.closeThisDialog();
                };
            }],"查询权限设置")
        }
    };

    //查看
    $scope.view_onClick = function()
    {
        if($scope.selected.select.length <= 0||$scope.selected.select.length > 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('querylimits/query_limits_edit.html',$scope,["$scope",function(updateScope){
                updateScope.disableBrId=true;
                updateScope.hide = true;
                updateScope.otherform=$common.copy($scope.selected.select[0]);
                updateScope.otherform.treeName=$scope.selected.select[0].brName;
                if($scope.selected.select[0].roleType=='超级管理员'){
                    updateScope.otherform.roleType='1';
                }else if($scope.selected.select[0].roleType=='管理员'){
                    updateScope.otherform.roleType='2';
                }else if($scope.selected.select[0].roleType=='非管理员'){
                    updateScope.otherform.roleType='3';
                }
                //树==上级机构
                updateScope.content = {
                    type:"autoTree",//展示类型table  tree
                    url:"orgService/selectBctlTree",//请求url
                    param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
                    split:"",//分隔符
                    extentColumn:"",
                    column:['brName'],//展示内容
                    func: function (node) {
                        updateScope.otherform.treeName=node.treeName;
                        updateScope.otherform.brId=node.treeId;
                    }
                };
                updateScope.cancel_onClick = function(){
                    updateScope.closeThisDialog();
                };
            }],"查询权限设置")
        }
    }
};
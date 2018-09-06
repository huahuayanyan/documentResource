/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var billNormaleditlistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.conditionForm={};//初始化查询条件对象
    $scope.row = dataDeliver.getter();//初始化传值参数
    $scope.datasource={//初始化表格对象
        ds: []
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}

    /**
     * 新增
     */
    $scope.add_onClick = function(){
        if($.doValidate("row")) {
            $common.get_ngDialog('billnormal/bill_normal_addedit.html', $scope,["$scope",function(dialogScope){
            	dialogScope.billnormaladd = {};
                dialogScope.billnormaladd.registrationNum = $scope.row.registrationNum;
                dialogScope.save_onClick = function(){
                    if($.doValidate("billnormaladd")) {
                    	  var dd = {};
                          $scope.datasource.ds.push(dd);
                          $scope.conf.totalRecord++;
                          $scope.datasource.ds[$scope.datasource.ds.length-1] = dialogScope.billnormaladd;
                        dialogScope.closeThisDialog();
                        $scope.selected.select = [];
                    };
                };
                dialogScope.close_onClick = function()
                {
                    dialogScope.closeThisDialog();
                }
            }],"仓单信息")
        }
    };
    //修改
    $scope.update_onClick = function()
    {
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条仓单信息！','showInform');
        }else{
            $common.get_ngDialog("billnormal/bill_normal_addedit.html", $scope
                ,["$scope",function(dialogScope){
                    dialogScope.billnormaladd = $scope.selected.select[0];
                    dialogScope.save_onClick = function(){
                        if($.doValidate("billnormaladd")) {
                            dialogScope.closeThisDialog();
                            $scope.selected.select = [];
                        };
                    };
                    dialogScope.close_onClick = function()
                    {
                        dialogScope.closeThisDialog();
                    }
                }],"仓单信息",{showClose:false});
        }
    }
    //删除
    $scope.delete_onClick = function()
    {
        if($scope.selected.select.length == 0){
            $common.get_tipDialog('请选择一条仓单信息！','showInform');
        }else{
            var listAdd = $scope.datasource.ds;
            var list = $scope.selected.select;//页面选中的现金等价物
            for(var i=0;i<listAdd.length;i++)
            {
                var oldcash = listAdd[i];
                for(var j=0;j<list.length;j++)
                {
                    var cache = list[j];
                    if(oldcash==cache)
                    {
                        $scope.$apply(
                            $scope.datasource.ds.splice(i,1),//从第i个开始删除一个
                            $scope.conf.totalRecord--
                        )
                    }
                }
            }
        }
    }
    $scope.save_onClick = function()
    {
        if($.doValidate("row")) {
            var data = {
                billNormal:$scope.row,
                insertList:$scope.datasource.ds
            }
            if($scope.datasource.ds == 0){
            	  $common.get_tipDialog('请添加仓单信息','showInform');
            	  return;
            }
            $common.get_asyncData("sBcpMortBillNormalService/BillNormalSaveUpdate",data).then(function(res){
                if (res.errorCode =="SUC"){
                    $common.get_tipDialog("保存成功",'showSuccess');
                    $state.go("list");
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        }
    }
    $scope.back_onClick = function(){
        $state.go("list");
    };
    //表格--------结束-------------------------
};

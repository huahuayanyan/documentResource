/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var warnParamlistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.conditionForm={
       //packageId :"1"
    };//初始化查询条件对象
    $scope.$watch("",function() {
        $scope.queryTree();
    });
    //
    $scope.treeParentId;
    $scope.treeName;
    var treeData = {
       // value:{id:"1"}
    };
    $scope.queryTree = function(paramData)
    {
        $scope.conditionForm.packageId="1";
        $scope.treeParentId="0";
        var autoTPromise = $common.get_asyncData('warnParamMngService/getWarnParamPackageList',treeData);
        autoTPromise.then(function(res) {
            $scope.autotree.allChildNode =  res.contextData;
        })
    };
    $scope.autotree = {
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
            $scope.conditionForm.packageId=node.treeId;
            $scope.treeParentId = node.treeParentId;
            $scope.treeName =node.treeName;
            $scope.queryTable();
            $scope.selected.select=[];//清空选项
            //$scope.conditionForm.treeName=node.treeName;
            //$scope.conditionForm.treeLevel = node.treeLevel;
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
    //监听分页
    /*$scope.$watch("conf.pageNo+conf.pageSize",$scope.queryTable)*/
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm.warnNo = "";
            $scope.conditionForm.warnType = "";
            $scope.selected.select=[];//清空选项s
        })
    };
    //搜索查询
    $scope.submit_onClick =function(){
        $scope.queryTable();
    };
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            value:$scope.conditionForm
        };
        var promise = $common.get_asyncData("warnParamMngService/findWarnParamListByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };
    /****预警参数设置分类 begin****/

    $scope.addPackage_onClick = function() {
        var data={
            superId :$scope.conditionForm.packageId
        };
        dataDeliver.setter(data);
        $common.get_ngDialog('warnParam/warnParamPackage.html', $scope
            ,["$scope",function(dialogScope){
                warnParampackageController(dialogScope,$scope,$common,dataDeliver,"add");
            }],"",{showClose:true},700);
    };
    //修改
    $scope.updatePackage_onClick = function() {
        var data={
            id :$scope.conditionForm.packageId
        };
        dataDeliver.setter(data);
        $common.get_ngDialog('warnParam/warnParamPackage.html', $scope
            ,["$scope",function(dialogScope){
                warnParampackageController(dialogScope,$scope,$common,dataDeliver,"update");
            }],"",{showClose:true},700);
    };

    $scope.deletePackage_onClick = function(){
        if($scope.treeParentId == "0"){
            $common.get_tipDialog('基础分类不允许删除！','showInform');
            return false;
        }
        var data = {
            key:$scope.conditionForm.packageId
        };

        $common.get_tipDialog("确定删除["+ $scope.treeName+"]分类吗?", 'showTip').then(
            function() {
                var primise = $common.get_asyncData('warnParamMngService/deleteBBrpPageParamPackage', data);
                primise.then(function(res) {
                    if (res.errorCode == "SUC") {
                        $scope.queryTree();
                        $scope.queryTable();
                        $common.get_tipDialog('删除成功！', 'showSuccess');
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                })
            })
    };
    /****预警参数设置分类 end****/

        //预警参数新增
    $scope.add_onClick = function(){
        var data={
            packageId :$scope.conditionForm.packageId
        };
        dataDeliver.setter(data);
            $common.get_ngDialog('warnParam/warnParam_edit.html', $scope
                ,["$scope",function(dialogScope){
                    warnParamEditController(dialogScope,$scope,$common,dataDeliver,"add");
                    //warnParamEditController(dialogScope,$scope,$common,"add");
                }],"预警参数新增",{showClose:true},700);

    };
    //修改按钮
    $scope.update_onClick = function(){
        var data={
            packageId :$scope.conditionForm.packageId
        };
        dataDeliver.setter(data);
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('warnParam/warnParam_edit.html',$scope
                ,["$scope",function(dialogScope){
                    warnParamEditController(dialogScope,$scope,$common,dataDeliver,"update");

                }],"预警参数修改",{showClose:true},700);
        }
    };


    $scope.delete_onClick = function(){
        if($scope.selected.select.length == 0){
            $common.get_tipDialog('请选择至少一条记录！','showInform');
            return false;
        }
        var data = {
            list:$scope.selected.select
        };

        $common.get_tipDialog("确定删除选中的记录吗?", 'showTip').then(
            function() {
                var primise = $common.get_asyncData('warnParamMngService/deleteWarnParam', data);
                primise.then(function(res) {
                    if (res.errorCode == "SUC") {
                        $scope.queryTable();
                        $scope.selected.select = [];
                        $common.get_tipDialog('删除成功！', 'showSuccess');
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                })
            })
    };
    //
    $scope.column = function(row){
        $common.get_ngDialog('warnParam/warnParam_edit.html',$scope
            ,["$scope",function(dialogScope){
                warnParamEditController(dialogScope,$scope,$common,dataDeliver,"view");

            }],"预警参数修改",{showClose:true},700);
    };
    //表格--------结束-------------------------
};

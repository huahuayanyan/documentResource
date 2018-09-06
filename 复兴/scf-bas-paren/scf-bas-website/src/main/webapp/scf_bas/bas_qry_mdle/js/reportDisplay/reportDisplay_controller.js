/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var reportDisplayController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.conditionForm={
        //noticeType:"1000"
    };//初始化查询条件对象
    $scope.$watch("",function() {
        $scope.queryTree();
    });
    var treeData = {
        value:{id:"0"}
    };
    $scope.queryTree = function(paramData)
    {
        var autoTPromise = $common.get_asyncData('reportDisplayService/ReportDisplayTreeGetter',treeData);
        autoTPromise.then(function(res) {
            $scope.autotree.allChildNode =  res.contextData;
        })
    };
    $scope.autotree = {
        isCheckBox:false,       // 是否加入CheckBox复选框
        isClickRow: true,  	 // 是否点击行触发事件
        isAutoSelect: false,   // 是否自动勾选父子级关系
        isAllShow: false,      // 是否打开全部节点（异步树，此值不能随意修改）
        headNode: {treeId: 0,treeName: '报表展现'},  // 自定义首目录节点
        allChildNode: [],  // 首目录下所有的子节点
        //树必须包含的字段"treeId  treeName  treeParentId  hasChilds  isChecked"
        //allChildNode:[{"treeId": "1003", "treeName": "文本", "treeLevel":"1", "treeParentId":"0",hasChilds:true,isChecked:true},]
        //dPicUrl: '../../images/',  // 默认图片路径
        customFun: function(node){
           // $scope.conditionForm.parentCode=node.treeId;
            //$scope.queryTable();
            //$scope.conditionForm.treeName=node.treeName;
            //$scope.conditionForm.treeLevel = node.treeLevel;
        	//node.treeUrl="display";
            var param={id:node.treeId,noticeType:"1000"};
            // var param={id:"1B630NHDS0009BC7FCAA000076A81F7C",noticeType:"78",appno:"SKQRT2017011000135"};
            //$state.go(node.treeUrl);//跳转
            toReport(param);
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
    $scope.$watch("conf.pageNo+conf.pageSize",$scope.queryTable)
      $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    });
    //重置
  $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm={
                noticeType:"1000"
            };
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
        var promise = $common.get_asyncData("reportDisplayService/findBBrpNoticeModelByPage",data);
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
    $scope.view_onClick = function(){

        if($scope.selected.select.length == 1){
            var id = $scope.selected.select[0].id;//定义选中参数id
            var noticeType = $scope.selected.select[0].noticeType;
           // var appno = $scope.selected.select[0].appno;
            // var param={id:"1B63J91TS007A2C7FCAA0000939BE0E9",noticeType:"71",appno:"CETKT2017011000020"};
            var param={id:id,noticeType:noticeType};
            //弹出的实现方式 begin
            //toReport(param);
           //弹出的实现方式 end
            dataDeliver.setter($scope.selected.select[0]);
            window.reportParam =param;
            $state.go("display");
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
    //表格--------结束-------------------------
};

/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var reportDisplayDtlController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    var dataD = dataDeliver.getter();
    var id = dataD.id;
    //系统当前日期
    var date=new Date();
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    var d = date.getDate();
    if(m < 10){
        m = "0" + m;
    }
    if(d < 10){
        d = "0" + d;
    }
    var currDate = "" + y + m + d;
	$scope.conditionForm={
			id:id
        //noticeType:"1000"
    };//初始化查询条件对象

    $scope.conditionForm.p_inputdate = currDate;
    $scope.$watch("",function() {
        $scope.submit_onClick();
    });
 /*   $scope.$watch("",function() {
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
        	node.treeUrl="display";
            var param={id:node.treeId,noticeType:"1000"};
            // var param={id:"1B630NHDS0009BC7FCAA000076A81F7C",noticeType:"78",appno:"SKQRT2017011000135"};
            $state.go(node.treeUrl);//跳转
            //toReport(param);
        },  // 自定义文字点击函数,isClickRow=true生效
        boxEventFun: function(node,isSelect){
        },  // 自定义checkbox点击函数，isCheckBox=true生效
        showBoxFun: function(node){
            //alert("showBoxFun: "+JSON.stringify(node));
            return true
        },   // 自定义是否展示checkbox复选框，isCheckBox=true生效

         async: true,          //是否异步查询树
         url:'/autoTree',  //父节点点击异步查询树地址,后台接口接受固定参数格式 key:fId  {fId:"1000"}
         dataFilter: function(treeDataList){   // 过滤callback数据
         return treeDataList
         }
    };*/
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
  
    //重置
  $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm={
            		id:id
            };
            $scope.selected.select=[];//清空选项s
        })
    };
    //搜索查询
    $scope.submit_onClick =function(){
   
    	 var param=$scope.conditionForm;
    	 window.reportParam =param;
    	// toReport(param);
        //$scope.queryTable();
     	 //$state.go("display");
     	 $("#report").load("../../../scf_bas/report/htReport.html");
    };
  //返回
    $scope.back_onClick =function(){
    	$state.go("list");
     	
    };
    //表格--------结束-------------------------
};

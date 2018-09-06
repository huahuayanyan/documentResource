/**
 * Created by htrad0017 on 2016/9/29.
 */
var treeController = function($scope,$common,$state){

    var  autoTPromise = $common.get_asyncData('/autoTree',{})
    autoTPromise.then(function(res) {
        $scope.autotree.allChildNode =  res.contextData;
    })
    $scope.autotree = {
        isCheckBox:false,       // 是否加入CheckBox复选框
        isClickRow: true,  	 // 是否点击行触发事件
        isAutoSelect: false,   // 是否自动勾选父子级关系
        isAllShow: false,      // 是否打开全部节点（异步树，此值不能随意修改）
        headNode: {treeId: 0,treeName: '首节点'},  // 自定义首目录节点
        allChildNode: [],  // 首目录下所有的子节点
        //树必须包含的字段"treeId  treeName  treeParentId  hasChilds  isChecked"
        //allChildNode:[{"treeId": "1003", "treeName": "文本", "treeLevel":"1", "treeParentId":"0",hasChilds:true,isChecked:true},]
        //dPicUrl: '../../images/',  // 默认图片路径
        customFun: function(node){
            //alert("customFun: "+JSON.stringify(node))
        },  // 自定义文字点击函数,isClickRow=true生效
        boxEventFun: function(node,isSelect){
            //alert("boxEventFun: "+isSelect+" "+JSON.stringify(node)+"选中的值"+$scope.autotree.selectCBox)
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
    };

    //树--------开始-------------------------
    $scope.selectedNodes=[
        {
            "treeId": "1000",
            "treeName": "一级菜单A",
            "treeLevel":"1",
            "treeParentId":"0"
        },
        {
            "treeId": "10001",
            "treeName": "二级菜单A",
            "treeLevel":"2",
            "treeParentId":"1000"
        }
    ];
    $scope.selectedNode={
        "treeId": "10001",
        "treeName": "二级菜单A",
        "treeLevel":"2",
        "treeParentId":"1000"
    };
    $scope.treeOptions={
        "multiSelection": true,//允许多选
        "dirSelectable": true//允许选择目录
    };
    $scope.showSelected = function (selectedNode) {
        console.log("选中的记录node1："+JSON.stringify(selectedNode));
        console.log("选中的记录node2："+JSON.stringify($scope.selectedNode));
        console.log("选中的记录nodes："+JSON.stringify($scope.selectedNodes));
    }
    $scope.save_onClick = function(){
        $state.go('mx.guide.bbb')
        console.log("选中的记录nodes："+JSON.stringify($scope.selectedNodes));
    };
    $scope.addTree_onClick = function(){
        $scope.selectedNodes=[
            {
                "treeId": "1003",
                "treeName": "文本",
                "treeLevel":"1",
                "treeParentId":"0"

            },
            {
                "treeId": "1004",
                "treeName": "文本",
                "treeLevel":"1",
                "treeParentId":"0"

            }
        ];
        $scope.dataForTheTree =treedata;
    };
    //var treedata;
    //function shallowCopy(src, dst) {
    //    if (angular.isArray(src)) {
    //        dst = dst || [];
    //        for ( var i = 0; i < src.length; i++) {
    //            dst[i] = src[i];
    //        }
    //        return dst;
    //    }
    //}
    $common.get_asyncData('tree',{}).then(function(res) {
        $scope.dataForTheTree = res.contextData;
    })
};

/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var appTreeController = function($scope, $common, $location, dataDeliver,
		$state, $eventCommunicationChannel) {	
	$state.go("updateindex");//跳转
	$scope.autotree = {
		isCheckBox : false, // 是否加入CheckBox复选框
		isClickRow : true, // 是否点击行触发事件
		isAutoSelect : false, // 是否自动勾选父子级关系
		isAllShow : true, // 是否打开全部节点（异步树，此值不能随意修改）
		headNode : {
			treeId : 0,
			treeName : '授信额度信息'
		}, // 自定义首目录节点
		allChildNode : [

		{
			"treeId" : "1000",
			"treeName" : "基本信息",
			"treeLevel" : "1",
			"treeParentId" : "0",
			"hasChilds" : false,
			"isChecked" : false,
			"treeUrl" : "updateindex"
		}, {
			"treeId" : "2000",
			"treeName" : "额度分配",
			"treeLevel" : "1",
			"treeParentId" : "0",
			"hasChilds" : false,
			"isChecked" : false,
			"treeUrl" : "updateline"
		}

		], // 首目录下所有的子节点
		//树必须包含的字段"treeId  treeName  treeParentId  hasChilds  isChecked"
		//allChildNode:[{"treeId": "1003", "treeName": "文本", "treeLevel":"1", "treeParentId":"0",hasChilds:true,isChecked:true},]
		//dPicUrl: '../../images/',  // 默认图片路径
		customFun : function(node) {
			$state.go(node.treeUrl);//跳转
		}, // 自定义文字点击函数,isClickRow=true生效
		boxEventFun : function(node, isSelect) {
			//alert("boxEventFun: "+isSelect+" "+JSON.stringify(node)+"选中的值"+$scope.autotree.selectCBox)
		}, // 自定义checkbox点击函数，isCheckBox=true生效
		showBoxFun : function(node) {
			//alert("showBoxFun: "+JSON.stringify(node));
			return true
		}, // 自定义是否展示checkbox复选框，isCheckBox=true生效

		async : false, //是否异步查询树
		//  url:'/autoTree',  //父节点点击异步查询树地址,后台接口接受固定参数格式 key:fId  {fId:"1000"}
		dataFilter : function(treeDataList) { // 过滤callback数据
			return treeDataList
		}
	};

};
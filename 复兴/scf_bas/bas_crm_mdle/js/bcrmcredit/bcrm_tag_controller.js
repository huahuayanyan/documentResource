/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      doujun
 * @version     1.0
 * Create at:   2017/7/5
 */

var BcrmTagController = function($scope,$common,$state,dataDeliver) {
	
	var dataTrasfer = dataDeliver.getter();
	$scope.hideId = true;
    $scope.conditionForm={
    
    };
    var bCrmBaseInfo={
            orgCode:dataTrasfer.orgCode,
            moniFlag:"1"
        }
    var primise = $common.get_asyncData("bCrmBaseInfoService/findBCrmBaseInfoByKey",{bCrmBaseInfo:bCrmBaseInfo});
    primise.then(function(res1) {
        if (res1.errorCode == "SUC") {
            var data2 = res1.contextData;
            if (data2 != null && data2.orgCode == dataTrasfer.orgCode) {//说明之前客户信息保存成功

            }else{
                $state.go("tree.add");
                $scope.$parent.panes.forEach(function(pane){
                    if (pane.uiSref == "tree.add"){
                        $scope.$parent.select(pane);
                    };
                });
                $common.get_tipDialog("请先完成客户基本信息保存！", 'showInform');
                return false;
            }
        }});
    
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
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //搜索
    $scope.searchTab_onClick =function(){
    	$scope.queryTable();
    };
    //客户标签下拉查询
    $scope.areaContent = {
            type:"table",//展示类型table  tree
            url:"bCrmBaseInfoService/findBCrmTabByPage",//请求url
            param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查
            split:"",//分隔符*/
            extentColumn:"dataTrsVal",
            column:["dataTrsVal"]//展示内容
        };
    $scope.dooextent = function(ds){
    	$scope.conditionForm.dataTrsVal=ds.dataTrsVal;
    	$scope.conditionForm.dataVal=ds.dataVal;
      
    }; 
    $scope.$watch("conditionForm.dataTrsVal",function(){
    	$scope.areaContent.param ={
        		dataTrsVal:$scope.conditionForm.dataTrsVal,
        }
    });
 
    //查询操作
    $scope.queryTable = function(paramData){
    	if($.trim($scope.conditionForm.dataTrsVal)==""){
    		$scope.conditionForm.dataVal="";
    	}
    	var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bCrmTagCloudRel:$scope.conditionForm
        };
        data.bCrmTagCloudRel.custcd = dataTrasfer.bCrmBaseInfo ? dataTrasfer.bCrmBaseInfo.custcd : "null" ;
        var promise = $common.get_asyncData("bCrmTagCloudRelService/findBCrmTagCloudInfoByPage",data);
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
    
    //新增客户标签
    $scope.add_onClick = function(){
    	if(!dataTrasfer.bCrmBaseInfo){
    		$common.get_tipDialog('请先完成客户信息保存操作！', 'showInform');
    		return false;
    	}
        $common.get_ngDialog('bcrmcredit/bcrm_tag_add.html', $scope
            ,["$scope",function(dialogScope){
            	TagAddController(dialogScope,$scope,$common,$state,dataDeliver);
            }],"新增客户标签",{showClose:false});
    };
    
    //删除客户标签
    $scope.delete_onClick = function(){
        if($scope.selected.select.length == 1){
            $common.get_tipDialog('确定删除吗！','showTip').then(function() {
                var bCrmTagCloudRel = $scope.selected.select[0];
                //删除客户标签
                var primise = $common.get_asyncData('bCrmTagCloudRelService/delete', {id: bCrmTagCloudRel.id});
                primise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        $scope.queryTable();
                        $scope.selected.select = [];
                        $common.get_tipDialog('删除成功！', 'showSuccess');
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }
                });
            });
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    }
    
    //修改客户标签
    $scope.update_onClick = function(){
        if($scope.selected.select.length == 1){
            $common.get_ngDialog('bcrmcredit/bcrm_tag_update.html', $scope
                    ,["$scope",function(dialogScope){
                    	TagUpdateController(dialogScope,$scope,$common,$state,dataDeliver);
                    }],"修改客户标签",{showClose:false});
            
        }else{
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
    };
    
    //刷新操作
    $scope.refresh_onClick = function(){
    	if(!dataTrasfer.bCrmBaseInfo){
    		$common.get_tipDialog('请先完成客户信息保存操作！', 'showInform');
    		return false;
    	}
         var promise = $common.get_asyncData("bCrmTagCloudRelService/refresh",{bCrmBaseInfo:dataTrasfer.bCrmBaseInfo});
         promise.then(function(res){
             var data;
             if (res.errorCode =="SUC"){
            	 $scope.queryTable();
                 $scope.selected.select = [];
                 $common.get_tipDialog('载入成功！', 'showSuccess');
             }else{
                 $common.get_tipDialog(res.errorMsg,'showError');
             }
         });
    };
    
    //返回操作
    $scope.confuse_onClick = function(){
    	 $state.go("base");
    };
    
    //重置按钮
    $scope.rebort_onClick =function(){
        $scope.conditionForm.dataTrsVal = "";
        $scope.conditionForm.dataVal="";
        $scope.$apply();
    }
}

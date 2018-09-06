/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      gongzhao
 * @version     1.0
 * Create at:   2017/04/18
 */
var stockAdjustListController = function($scope,$common,$state,dataDeliver,$eventCommunicationChannel) {
    $scope.conditionForm={
        vidPrdId:"1210020",//业务品种默认值
    };//初始化查询条件对象
    $scope.selectSource = {
        ds:[{key:"1210020",value:'先票/款后货'},]
    };
    $scope.datasource={//初始化表格对象
        ds:[]
    };
    $scope.selected={//初始化对象
        select: []
    };
    $scope.conf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0};
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });
    //重置
    $scope.rebort_onClick = function(){
        $scope.conditionForm={
            vidPrdId:"1210020",//业务品种默认值
        };
        $scope.selected.select=[];//清空选项
        $scope.$apply();
    };
    //搜索
    $scope.submit_onClick =function(){
        $scope.queryTable();
        $scope.selected.select=[];
    };
    
    //树==上级机构
    $scope.content = {
        type:"tree",//展示类型table  tree
        url:"orgService/selectBctlTree",//请求url
        param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split:"",//分隔符
        extentColumn:"",
        column:['brName']//展示内容
    };
    $scope.dooextent = function(ds){
        $scope.conditionForm.treeName=ds.brName;
        $scope.conditionForm.brCd=ds.brNo;
    };
    //查询
    $scope.queryTable = function(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bCrrGntyCon:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bCrrGntyConService/getSlaveContList",data);
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
    //新增库存
    $scope.doAdd_onClick = function(){
    	 if($scope.selected.select.length != 1){
             $common.get_tipDialog('请选择一条记录！','showInform');
         }else{
	        var data= {
	            flag:"add",
	            slaveContno: $scope.selected.select[0].conId	
	        };
	        dataDeliver.setter(data);
	        $state.go("edit");
         }
     };
    //调整库存
    $scope.doChange_onClick = function(){
    	 if($scope.selected.select.length != 1){
             $common.get_tipDialog('请选择一条记录！','showInform');
         }else{
             var data= {
            	 conId:$scope.selected.select[0].conId,
            	 gutNm:$scope.selected.select[0].gutNm,
            	 strtDt:$scope.selected.select[0].strtDt,
            	 endDt:$scope.selected.select[0].endDt,
            	 gutVal:$scope.selected.select[0].gutVal
             };
             dataDeliver.setter(data);
             $state.go("change");
         }
    };
    //删除协议按钮
    $scope.doDelete_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
        	var conInfo=$scope.selected.select[0];
            var conId=conInfo.conId;//抵质押合同号
            var msg='确认删除抵/质押合同号为[' + conId + "]的合同吗？"
            $common.get_tipDialog(msg,'showTip').then(function(){
                if(conInfo.prtclNo && conInfo.prtclNo !=""){
                    $common.get_tipDialog("该质押合同已关联监管合同，不可删除!",'showInform');
                }else{
                    var primise = $common.get_asyncData('bCrrGntyConService/deleteGntyConAndMortAndInsu',{conId:conId});
                    primise.then(function(res){
                        if (res.errorCode =="SUC"){
                            $scope.queryTable();
                            $scope.selected.select=[];
                            $common.get_tipDialog('删除成功！','showSuccess');
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                }
            });
        }
    };

    //查看对应信息
    $scope.column = function(data1){
        var data= {
            protocol:data1,
            flag:"view"
        };
        dataDeliver.setter(data);
        $state.go("mortgageContAdd");
    }
};

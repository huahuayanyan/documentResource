/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Qinwei
 * @version     1.0
 * Create at:   2016/11/10
 */
var listController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    //console.log("userInfo信息："+JSON.stringify(userInfo));//用户信息，全局变量
    $scope.conf={};//初始化查询条件对象
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

    $scope.conditionForm={};

    $scope.bCrmBaseInfo = {
        ds:[
        ]
    };

    $scope.thisbCrgEvalRec={

    };
    $scope.evalMdls = {
        ds:[
            {mdlId:'1001',mdlNm:'评估模型1',salary:25000},
            {mdlId:'1002',mdlNm:'评估模型2',salary:18000},
            {mdlId:'1003',mdlNm:'评估模型3',salary:12000},
            {mdlId:'1004',mdlNm:'评估模型4',salary:9000},
            {mdlId:'1005',mdlNm:'评估模型5',salary:7000},
            {mdlId:'1006',mdlNm:'评估模型6',salary:5000}
        ]
    };
    
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize",function(){$scope.queryTable()});

    //搜索
    $scope.searchTab_onClick =function(){
        $scope.queryTable();
    };

    $scope.queryTable = function(paramData){

        var data= {
                pageNo: $scope.conf.pageNo,
                pageSize: $scope.conf.pageSize,
                bCrgEvalRec:$scope.conditionForm
          };

         var promise = $common.get_asyncData("iBCrgEvalRecService/findCrgEvalRecByPage",data);
         promise.then(
             function(res){
                 var data;
                 if (res.errorCode =="SUC"){
                     data = res.contextData;
                     $scope.datasource.ds = data.records;
                     $scope.conf.totalRecord = data.totalRecord;
                 }else{
                     $common.get_tipDialog(res.errorMsg,'showError');
                 }
             }
         );
    };
    $scope.userInfo ={brNo:'',tlrName:''};
    
/*    $scope.view_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
                var row = $scope.selected.select[0];
                $common.get_asyncData('iBCrgEvalRecService/findExtBcrgEvalInfo',{extBCrgEval:row}).then(function(res){
                    if (res.errorCode =="SUC"){
                        var extBCrgEval = res.contextData;
                        data = {
                        	extBCrgEval : extBCrgEval
                        };
                        dataDeliver.setter(data);
                        $state.go("tabview");
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
        }
};*/
    //评估记录详情
    $scope.column = function(row){
                //var row = $scope.selected.select[0];
                $common.get_asyncData('iBCrgEvalRecService/findExtBcrgEvalInfo',{extBCrgEval:row}).then(function(res){
                    if (res.errorCode =="SUC"){
                        var extBCrgEval = res.contextData;
                        data = {
                        	extBCrgEval : extBCrgEval
                        };
                        dataDeliver.setter(data);
                        $state.go("tabview");
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
    };
    
    $scope.update_onClick = function(){
            if($scope.selected.select.length != 1){
                $common.get_tipDialog('请选择一条记录！','showInform');
            }else{
                if($scope.selected.select[0].stat =='004'||$scope.selected.select[0].stat =='000'){
                    var row = $scope.selected.select[0];
                    $common.get_asyncData('iBCrgEvalRecService/findExtBcrgEvalInfo',{extBCrgEval:row}).then(function(res){
                        if (res.errorCode =="SUC"){
                            var extBCrgEval = res.contextData;
//                            $common.get_ngDialog('eval/crgeval_add.html',$scope
//                                ,["$scope",function(dialogScope){
//                                    //updtController(dialogScope,$scope,$common,"update",row);
//                                    addController(dialogScope,$scope,$common,dataDeliver,"update",extBCrgEval);
//                                }],"修改操作",{showClose:true});
                            data = {
                            	extBCrgEval : extBCrgEval
                            };
                            dataDeliver.setter(data);
                            $state.go("tabupdate");
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    })
                }else{
                	 var row = $scope.selected.select[0];
                	 if (row.stat == '001') {
            			 $common.get_tipDialog('此记录已经提交，不能修改！','showInform');
            		 } else if (row.stat == '002') {
            			 $common.get_tipDialog('此记录已经通过，不能修改！','showInform');
            		 } else if (row.stat == '003') {
            			 $common.get_tipDialog('此记录已经拒绝，不能修改！','showInform');
            		 } else {
            			 $common.get_tipDialog('此记录已经提交，不能修改！','showInform');
            		 }
                }
            }
    };



    $scope.delete_onClick = function(){
            if($scope.selected.select.length != 1){
                $common.get_tipDialog('请选择一条记录！','showInform');
            }else{
                $common.get_tipDialog('确定删除吗！','showTip').then(function(){
                    var record = $scope.selected.select[0];
                    var stat = record.stat;
                    if(stat =='000'){
                    	var primise = $common.get_asyncData('iBCrgEvalRecService/delete',{key:record.evalId})
                        primise.then(function(res){
                            if (res.errorCode =="SUC"){
                                $scope.queryTable();
                                $scope.selected.select=[];
                                $common.get_tipDialog('删除成功！','showSuccess');
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        })
                    }else{
                    	if (stat == '001') {
	   	           			 $common.get_tipDialog('此记录已经提交，不能删除！','showInform');
	   	           			 return;
	   	           		} else if (stat == '002') {
	   	           			 $common.get_tipDialog('此记录已经通过，不能删除！','showInform');
	   	           			 return;
	   	           		} else if (stat == '003') {
	   	           			 $common.get_tipDialog('此记录已经拒绝，不能删除！','showInform');
	   	           			 return;
	   	           		} else if (stat == '004') {
	   	           			 $common.get_tipDialog('此记录已经退回，不能删除！','showInform');
	   	           			 return;
	   	           		} else {
	   	           			 $common.get_tipDialog('此记录已经提交，不能删除！','showInform');
	   	           			 return;
	   	           		}
                    }
                })
            }
    };


    $scope.rebort_onClick = function(){
        $scope.$apply(function(){
            $scope.conditionForm.evalId="";
            $scope.conditionForm.mdlNm="";
            $scope.conditionForm.mdlId ="";
            $scope.selected.select=[];//清空选项s
            $scope.queryTable();

        })
    };


/*    $scope.column_click = function(row) {
    	
    	 if(row.stat =='004'||row.stat =='000'){
    		 $common.get_asyncData('iBCrgEvalRecService/findExtBcrgEvalInfo',{extBCrgEval:row}).then(function(res){
    			 if (res.errorCode =="SUC"){
    				 var extBCrgEval = res.contextData;
//                $common.get_ngDialog('eval/crgeval_add.html', $scope
//                    , ["$scope", function (evalScope) {
//                        addController(evalScope, $scope, $common, dataDeliver, "view",extBCrgEval)
//                    }], "查看评估记录详情", {showClose: true});
    				 data = {
    						 extBCrgEval : extBCrgEval
    				 };
    				 dataDeliver.setter(data);
    				 $state.go("tabupdate");
    			 }else{
    				 $common.get_tipDialog(res.errorMsg,'showError');
    			 }
    		 })
    	 }else{
    		 if (row.stat == '001') {
    			 $common.get_tipDialog('此记录已经提交，不能修改！','showInform');
    		 } else if (row.stat == '002') {
    			 $common.get_tipDialog('此记录已经通过，不能修改！','showInform');
    		 } else if (row.stat == '003') {
    			 $common.get_tipDialog('此记录已经拒绝，不能修改！','showInform');
    		 } else {
    			 $common.get_tipDialog('此记录已经提交，不能修改！','showInform');
    		 }
    	 }
    };
*/

    $scope.submit_onClick = function(){

        if($scope.selected.select.length <= 0){
                $common.get_tipDialog('请选择一项记录提交！','showInform');
            }else {
                $scope.thisbCrgEvalRec = $scope.selected.select[0];
                if($scope.thisbCrgEvalRec.stat == "000"){

                    $scope.thisbCrgEvalRec = $scope.selected.select[0];
                    var id = $scope.thisbCrgEvalRec.evalId;
                    var custId = $scope.thisbCrgEvalRec.rltId;
                    var custNm =$scope.thisbCrgEvalRec.cname;

                    var params = {
                        processModel:{
                            modelId: 'creditEvalPrcssCreate',
                            ProcessName: '信用评估流程创建',
                            NodeId: 'credictEvalNode1',
                            startedUserId: userInfo.tlrNo,
                            bizId: id,
                            bizData: [
                                id,
                                custId,
                                custNm,
                                'creditEvalPrcssCreate'
                            ]
                        },
                        bCrgEvalRec: $scope.thisbCrgEvalRec
                    };

                    var primise = $common.get_asyncData('iBCrgEvalRecService/submit', params);
                    primise.then(function(res){
                        if (res.errorCode == "SUC") {
                            $common.get_tipDialog('发起成功！', 'showSuccess');
                            $scope.queryTable();
                        } else {
                            $common.get_tipDialog('发起失败!' + res.errorMsg, 'showError');
                        }
                    });
                }else{
                	 var row = $scope.selected.select[0];
                	 if (row.stat == '001') {
	           			 $common.get_tipDialog('此记录已经提交，不能提交！','showInform');
	           		 } else if (row.stat == '002') {
	           			 $common.get_tipDialog('此记录已经通过，不能提交！','showInform');
	           		 } else if (row.stat == '003') {
	           			 $common.get_tipDialog('此记录已经拒绝，不能提交！','showInform');
	           		 } else {
	           			 $common.get_tipDialog('此记录已经提交，不能提交！','showInform');
	           		 }
                    return;
             }
        }
    };


    $scope.add_onClick= function(){

        //$common.get_ngDialog('eval/crgeval_aply.html', $scope
        //    , ["$scope", function (dialogScope) {
        //        //alert(JSON.stringify($scope.bCrmBaseInfo.ds));
        //        aplyController(dialogScope, $scope, $common,dataDeliver,"aply");
        //    }], "客户信息", {showClose: true});

       /* $common.get_ngDialog('eval/crgeval_add.html', $scope
            , ["$scope", function (evalScope) {
                addController(evalScope, $scope, $common, dataDeliver, "add",null)
            }], "添加客户信息", {showClose: true});*/
    	
    	
    	 $state.go("tabadd");
    };

    $scope.cclAppr_onClick= function(){

        var data={
            processId:''
        };
        $scope.thisbCrgEvalRec = $scope.selected.select[0];

        var evalId = $scope.thisbCrgEvalRec.evalId;
        var premise = $common.get_asyncData('iBCrgEvalRecService/findCrgEvalRecByKey',{key:evalId});
        premise.then = function(res){
            $scope.thisbCrgEvalRec = res.contextData
        };
        data.processId = $scope.thisbCrgEvalRec.processId;
        $common.get_asyncData('iBCrgEvalRecService/cancelProcess',{processId:data.processId});
        $scope.thisbCrgEvalRec.processId = null;
        $scope.thisbCrgEvalRec.stat = null;
        var updatePremise = $common.get_asyncData('iBCrgEvalRecService/update',{bCrgEvalRec:$scope.thisbCrgEvalRec});
        updatePremise.then(function(updateRes){
            if (updateRes.errorCode =="SUC"){
                //$state.go("bsystask");
                $common.get_tipDialog('取消该条申请！','showInform');

            }
        });
    };

    $scope.search_onClick = function(){

        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请选择一项记录查询！','showInform');
        }else{
            $scope.thisbCrgEvalRec = $scope.selected.select[0];
            var arg = {bCrgEvalRec: $scope.thisbCrgEvalRec};
            var premise = $common.get_asyncData('iBCrgEvalRecService/selectByBCrgEvalRec',arg);
            premise.then = function(res){
                if(res.errorCode =="SUC"){
                    alert(res.contextData);
                }
            }
        }

    };



    //表格--------结束-------------------------
};

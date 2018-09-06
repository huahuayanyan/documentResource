/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/10
 */
var subjlistController = function($scope,$common,dataDeliver,$eventCommunicationChannel) {
    /*console.log("bFinCnfgSubj信息："+JSON.stringify(userInfo));//用户信息，全局变量*/
    $scope.conditionForm={};//初始化查询条件对象
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
    /*$scope.$watch("conf.pageNo+conf.pageSize",$scope.queryTable)*/
    $scope.$watch("conf.pageNo+conf.pageSize",function() {
        $scope.queryTable();
    })
    //重置
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm = {};
            $scope.selected.select=[];//清空选项s
        })
    };
    //搜索查询
    $scope.submit_onClick =function(){
        $scope.queryTable();
        //$scope.selected.select=[];
    };
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bFinCnfgSubj:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bFinCnfgSubjService/findBFinCnfgSubjByPage",data);
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
    //新增
    $scope.add_onClick = function(){
        $common.get_ngDialog('subj/subj_edit.html', $scope
            ,["$scope",function(dialogScope){
            	subjeditController(dialogScope,$scope,$common,"add");
            }],"新增财报科目信息",{showClose:false},600);
    };
    //编辑
    $scope.update_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('subj/subj_edit.html',$scope
                ,["$scope",function(dialogScope){
                    subjeditController(dialogScope,$scope,$common,"update");
                }],"修改财报科目信息",{showClose:true},600);
        }
    };
    //删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
        	var arrs = $common.copy($scope.selected.select);
        	var subjIds = "";
            for(var i=0 ; i<arrs.length ; i++)
            {
                subjIds += (arrs[i].subjId)+",";
            }
            var primiseif = $common.get_asyncData('bFinCnfgDefService/findBFinCnfgDefBySubjId',{subjIds:subjIds})
            primiseif.then(function(res){
            	var data;
            	if (res.errorCode =="SUC"){
            		data = res.contextData.value;
            		if(data=="false")
            		{
            			$common.get_tipDialog('科目信息正在使用，请重新选择……！','showSuccess');
            		}
            		else
            		{
            			$common.get_tipDialog('确定删除吗！','showTip').then(function(){
                            var primise = $common.get_asyncData('bFinCnfgSubjService/batchDelete',{subjIds:subjIds})
                            primise.then(function(res){
                                if (res.errorCode =="SUC"){
                                    $scope.queryTable();
                                    $scope.selected.select=[];
                                    $common.get_tipDialog('删除成功！','showSuccess');
                                }else{
                                    $common.get_tipDialog(res.errorMsg,'showError');
                                }
                            })
                        })
            		}
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            })
        }
    }
    //刷新
    $scope.fresh_onClick = function(){
        $scope.queryTable();
        $scope.selected.select=[];
    }
    $scope.row = {};
    $scope.column = function(row){
    	$scope.row = row;
            $common.get_ngDialog('subj/subj_edit.html',$scope
                ,["$scope",function(dialogScope){
                	subjeditController(dialogScope,$scope,$common,"view");
                }],"查看财报科目信息",{showClose:true},600);
       // console.log(JSON.stringify(row))
    }
    //表格--------结束-------------------------
};

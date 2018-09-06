/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/10
 */
var cllistController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
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
        $scope.$apply(function() {
            $scope.conditionForm = {};
            $scope.selected.select=[];//清空选项s
        })
    }
    //搜索查询
    $scope.submit_onClick =function(){
        $scope.queryTable();
        //$scope.selected.select=[];
    }
    $scope.queryTable = function(paramData){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            bFinCnfgCl:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bFinCnfgClService/findBFinCnfgClByPage",data);
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
        $common.get_ngDialog('cl/cl_add.html', $scope
            ,["$scope",function(dialogScope){
                claddController(dialogScope,$scope,$common,"add");
            }],"新增财报模型分类",{showClose:false},700);
    };
    //编辑
    $scope.update_onClick = function(){
        if($scope.selected.select.length <= 0){
            $common.get_tipDialog('请至少选择一条记录！','showInform');
        }else{
            $common.get_ngDialog('cl/cl_add.html',$scope
                ,["$scope",function(dialogScope){
                    claddController(dialogScope,$scope,$common,"update");
                }],"修改财报模型分类",{showClose:true},700);
        };
    };
    //删除
    $scope.delete_onClick = function(){
        if($scope.selected.select.length != 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }
        else
        {
        	var arrs = $common.copy($scope.selected.select);
            var mdlIds = "";
            for(var i=0 ; i<arrs.length ; i++)
            {
                mdlIds += (arrs[i].mdlId)+",";
            }
        	var primiseif = $common.get_asyncData('bFinCustDirService/findBFinCustDirByMdlId',{mdlIds:mdlIds})
            primiseif.then(function(res){
            	var data;
            	if (res.errorCode =="SUC"){
            		data = res.contextData.value;
            		if(data=="false")
            		{
            			$common.get_tipDialog('模型信息正在使用，请重新选择……！','showSuccess');
            		}
            		else
            		{
            			$common.get_tipDialog('确定删除吗！','showTip').then(function(){
                            var primise = $common.get_asyncData('bFinCnfgClService/batchDelete',{mdlIds:mdlIds})
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
    $scope.column = function(row){
        $state.go("view");//跳转
        dataDeliver.setter(row);//传值[可选]
       // console.log(JSON.stringify(row))
    }
    //表格--------结束-------------------------
};

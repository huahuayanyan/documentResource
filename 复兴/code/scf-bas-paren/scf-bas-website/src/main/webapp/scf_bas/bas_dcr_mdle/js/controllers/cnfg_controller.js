/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var cnfgController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel){

    console.log("userInfo信息："+JSON.stringify(userInfo));//用户信息，全局变量

    $scope.conditionForm={};//初始化查询条件对象
    $scope.addForm={};//初始化对象
    $scope.selected={select: []};//初始化对象
    $scope.datasource={ds: []};//初始化表格对象
    $scope.conf= {pageNo: 1, pageSize: 10};//初始化分页对象
    //监听分页
    $scope.$watch("conf.pageNo+conf.pageSize", function () {
        queryTable();
    });
    //搜索查询
    $scope.submit_onClick =function(){
        queryTable();
    };
    //新增
    $scope.add_onClick = function(){
        add();
    };
    $scope.update_onClick = function(){
      update();
    };
    $scope.delete_onClick = function(){
    	del();
    };
    $scope.reset_onClick = function(){      
        $scope.$apply(function(){
        	$scope.conditionForm = {};
            $scope.selected.select=[];//清空选项
        })
    };
    $scope.column = function(row){
       // $state.go("view");//跳转
    	doView(row);
    };
    
    function doView(paramDate){
        $common.get_ngDialog('cnfg/view.html',$scope,["$scope",function(viewScope){
     	   viewScope.viewForm=$common.copy(paramDate);
            viewScope.cancel_onClick = function(){
                $scope.selected.select=[];
                viewScope.closeThisDialog();
            };
        }],'详情');
     	
     }
     
    function queryTable(){
        var data= {
            pageNo: $scope.conf.pageNo,
            pageSize: $scope.conf.pageSize,
            vbDcrLinCnfg:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bDcrLinCnfgService/findObjectConditionByPage",data);
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

    function add(){
        $common.get_ngDialog('cnfg/add.html',$scope,["$scope",function(addScope){
        	addScope.addForm={};//清除历史       	
            addScope.confirm_onClick = function(){
                if($.doValidate("addForm")){
                    var realIdLen = 0;
                    var typId = addScope.addForm.typId;
                    var idlen = typId.length;
                    var idCharCode = -1;
                    for(var i=0;i<idlen;i++)
                    {
                        idCharCode = typId.charCodeAt(i);
                        if(idCharCode>=0&&idCharCode<=128)
                        {
                            realIdLen += 1;
                        }
                        else
                        {
                            realIdLen += 3;
                        }
                    }
                    if(realIdLen>32)
                    {
                        $common.get_tipDialog('检查类型ID长度大于32，请重新输入','showInform');
                        return;
                    }
                    var realNmLen = 0;
                    var typNm = addScope.addForm.typNm;
                    var nmlen = typNm.length;
                    var nmCharCode = -1;
                    for(var i=0;i<nmlen;i++)
                    {
                        nmCharCode = typNm.charCodeAt(i);
                        if(nmCharCode>=0&&nmCharCode<=128)
                        {
                            realNmLen += 1;
                        }
                        else
                        {
                            realNmLen += 3;
                        }
                    }
                    if(realNmLen>80)
                    {
                        $common.get_tipDialog('检查类型说明长度大于80，请重新输入','showInform');
                        return;
                    }

                    var data={
                    		vbDcrLinCnfg:addScope.addForm
                    };
                    var primise = $common.get_asyncData("bDcrLinCnfgService/add",data);
                    primise.then(function(res){
                        if (res.errorCode =="SUC"){
                            $common.get_tipDialog('新增成功！','showSuccess');
                            queryTable();
                            addScope.closeThisDialog();
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    })
                };
            };
            addScope.cancel_onClick = function(){
                addScope.closeThisDialog();
            };
        }],'新增')
    };
  
    
    

    
    function update(){
        if($scope.selected.select.length <= 0||$scope.selected.select.length > 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{ 
            $common.get_ngDialog('cnfg/update.html',$scope,["$scope",function(updateScope){
                updateScope.updateForm=$common.copy($scope.selected.select[0]);
                updateScope.confirm_onClick = function(){
                    if($.doValidate("updateForm")){
                        var realIdLen = 0;
                        var typId = updateScope.updateForm.typId;
                        var idlen = typId.length;
                        var idCharCode = -1;
                        for(var i=0;i<idlen;i++)
                        {
                            idCharCode = typId.charCodeAt(i);
                            if(idCharCode>=0&&idCharCode<=128)
                            {
                                realIdLen += 1;
                            }
                            else
                            {
                                realIdLen += 3;
                            }
                        }
                        if(realIdLen>32)
                        {
                            $common.get_tipDialog('检查类型ID长度大于32，请重新输入','showInform');
                            return;
                        }
                        var realNmLen = 0;
                        var typNm = updateScope.updateForm.typNm;
                        var nmlen = typNm.length;
                        var nmCharCode = -1;
                        for(var i=0;i<nmlen;i++)
                        {
                            nmCharCode = typNm.charCodeAt(i);
                            if(nmCharCode>=0&&nmCharCode<=128)
                            {
                                realNmLen += 1;
                            }
                            else
                            {
                                realNmLen += 3;
                            }
                        }
                        if(realNmLen>80)
                        {
                            $common.get_tipDialog('检查类型说明长度大于80，请重新输入','showInform');
                            return;
                        }

                        var primise = $common.get_asyncData("bDcrLinCnfgService/update",{vbDcrLinCnfg:updateScope.updateForm});
                        primise.then(function(res){
                            if (res.errorCode =="SUC"){
                                $common.get_tipDialog('修改成功！','showSuccess');
                                queryTable();
                                $scope.selected.select=[];
                                updateScope.closeThisDialog();
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showError');
                            }
                        })
                    };
                };
                updateScope.cancel_onClick = function(){
                    $scope.selected.select=[];
                    updateScope.closeThisDialog();
                };
            }],'修改');
               }

    };
    function del(){
        if($scope.selected.select.length <= 0||$scope.selected.select.length > 1){
            $common.get_tipDialog('请选择一条记录！','showInform');
        }else{
            $scope.deleteObject=$common.copy($scope.selected.select[0]);
            $common.get_tipDialog('确定删除吗！', 'showTip').then(function () {
                var primise = $common.get_asyncData("bDcrLinCnfgService/delete",{key:$scope.deleteObject.typId});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $common.get_tipDialog('删除成功！','showSuccess');
                        queryTable();
                        $scope.selected.select=[];
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                })
            });
        }
    }
};
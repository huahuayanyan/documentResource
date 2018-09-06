/**
 * Created by htrad0001 on 2016/12/13.
 */
var bcntMortgageEnteringAddController = function($scope,$common,$state,dataDeliver) {
    $scope.mortgageAdd = {
        productId:"1220010"
    };
    $scope.datasource = {};
    $scope.selected = {select:[]};
    $scope.conf = {
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };
    //业务品种
   /* $scope.selectSource = {
        ds:[{key:"1210020",value:'先票/款后货'}]
    };*/
    //出质人名称下拉框
    $scope.cnameList ={
        type: "table",//展示类型table  tree
        url: "monitorProtocolService/getSecNamebyProtocol",//请求url
        //param:{},//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split: "",//分隔符
        extentColumn: "codeName",
        column: ["codeName"]//展示内容
    }
    $scope.cname = function (ds) {
        //当出质人发生改变的时候，抵/质押合同号等字段都要清空
        $scope.mortgageAdd={productId:"1220010"};
        $scope.mortgageAdd.secName = ds.codeName;
        $scope.mortgageAdd.custcd = ds.code;
        $scope.slaveContcodeList.param ={
            secName:$scope.mortgageAdd.secName,
            custcd:$scope.mortgageAdd.custcd,
            productId:"1220010"
        }
    }
    $scope.$watch("mortgageAdd.secName",function(){
         $scope.cnameList.param ={
            secName:$scope.mortgageAdd.secName
        }
    });
    //抵/质押合同号
    $scope.slaveContcodeList ={
        type: "table",//展示类型table  tree
        url: "mortgageEnteringService/getSlaveContcode",//请求url
        //param:$scope.mortgageAdd,
        //secCd:"001",//请求参数,如果不写该属性或者param:{},则以输入当前字段查询
        split: "",//分隔符
        extentColumn: "conId",
        column: ["conId"]//展示内容
    }
    $scope.slaveContcode = function (ds) {
        $scope.mortgageAdd.slaveContcode = ds.conId;
        var conId = ds.conId;
        var data = {conId:conId}
        var promise = $common.get_asyncData("mortgageEnteringService/getMonitorProtocolInfoByConId",data);
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                //$scope.productSource.ds = res.contextData;
                //$scope.protocol.productId="1220020";
                $scope.mortgageAdd.thrName = res.contextData.thrName;
                $scope.mortgageAdd.moniOfCustcd = res.contextData.thrCode;
                $scope.mortgageAdd.protocolCode = res.contextData.protocolCode;
                $scope.mortgageAdd.gutId=res.contextData.secCd;
                //$scope.mortgageAdd.productId = res.contextData.productId;
                $scope.mortgageAdd.moniModel = res.contextData.moniType;
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    }
    $scope.$watch("mortgageAdd.slaveContcode",function(){
        $scope.slaveContcodeList.param ={
            secName:$scope.mortgageAdd.secName,
            productId:"1220010",
            custcd:$scope.mortgageAdd.custcd,
            slaveContcode:$scope.mortgageAdd.slaveContcode
        }
    });
    //查询业务品种
  /*  productSource();
    function productSource(){
        //业务品种下拉框
        var dataItemsDO = {};
        var data = {dataItemsDO:dataItemsDO}
        var promise = $common.get_asyncData("monitorProtocolService/getProductId",data);
        $scope.productSource = {};
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $scope.productSource.ds = res.contextData;
                //$scope.protocol.productId="1220020";
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    }*/
    $scope.productSource = {
        ds:[
            {productId:"1220010",productName:'现货静态质押'},
            {productId:"1220020",productName:'现货动态质押'},
        ]
    };

    //查看
    $scope.column= function(){
        $common.get_ngDialog('mortgageEntering/bcnt_mortgageEnteringInfo.html', $scope,["$scope",function(dialogScope) {
            dialogScope.confirm = true;
            dialogScope.disable = true;
            dialogScope.mortgageInfo = {};
            dialogScope.mortgageInfo = $scope.selected.select[0];
            //查询押品一级
            mortgageLevelOneSource();
            function mortgageLevelOneSource(){
                //业务品种下拉框
                var dataItemsDO = {levels:"1"};
                var data = {dataItemsDO:dataItemsDO}
                var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                dialogScope.mortgageLevelOneSource = {};
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.mortgageLevelOneSource.ds = res.contextData;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
            }
            //押品二级
            mortgageLevelTwoSource();
            function mortgageLevelTwoSource(){
                //业务品种下拉框
                var dataItemsDO = {levels:"2"};
                var data = {dataItemsDO:dataItemsDO}
                var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                dialogScope.mortgageLevelTwoSource = {};
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
            }
            //押品三级
            mortgageLevelThreeSource();
            function mortgageLevelThreeSource(){
                //业务品种下拉框
                var dataItemsDO = {levels:"3"};
                var data = {dataItemsDO:dataItemsDO}
                var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                dialogScope.mortgageLevelThreeSource = {};
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                        dialogScope.mortgageLevelThreeSource.ds = res.contextData;
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showInform');
                    }
                });
            }
            dialogScope.cancel_onClick = function () {
                dialogScope.closeThisDialog();
                $scope.selected.select = [];
            };
        }],"入库押品详情录入",{showClose:true});
    }

    //新增
    $scope.add_onClick = function(){
        if($scope.mortgageAdd.slaveContcode){
            $common.get_ngDialog('mortgageEntering/bcnt_mortgageEnteringInfo.html', $scope,["$scope",function(dialogScope) {
                dialogScope.mortgageInfo = {curcd:"CNY"};
                //查询押品一级
                mortgageLevelOneSource(1);
                
                var mortgageCodeOneList = new Array();//拼装押品一级Code
                var mortgageCodeTwoList = new Array();//拼装押品二级Code
                
                function mortgageLevelOneSource(level){
                	
                	//查询一级押品前，先查询该抵质押合同录入的押品信息
                	
                    var dataMtg= {
                        pageNo: 1,
                        pageSize: 10000,
                        bCntSlaveMtgRel:{slaveContno:$scope.mortgageAdd.slaveContcode},
                        cache:0
                    };
                    var promiseMtg = $common.get_asyncData("bCntSlaveMtgRelService/findBCntSlaveMtgRelByPage",dataMtg);
                    dialogScope.mortgageLevelOneSource = {};
                    promiseMtg.then(function(res){
                        var data;
                        if (res.errorCode =="SUC"){
                            data = res.contextData;
                            
                            for(var i=0;i<data.records.length;i++){
                            	var mtgModel = data.records[i];
                            	mortgageCodeOneList.push(mtgModel.mortgageLevelOne);
                            	mortgageCodeTwoList.push(mtgModel.mortgageLevelTwo);
                            } 
		                    //业务品种下拉框
		                    var dataItemsDO = {levels:level,mortgageCodeList:mortgageCodeOneList};
		                    var data = {dataItemsDO:dataItemsDO}
		                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
		                    promise.then(function(res){
		                        if (res.errorCode =="SUC"){
		                            dialogScope.mortgageLevelOneSource.ds = res.contextData;
		                        }else{
		                            $common.get_tipDialog(res.errorMsg,'showInform');
		                        }
		                    });
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });   
                }
                //押品二级
                dialogScope.mortgageLevelTwoSource = {};
                dialogScope.mortgageLevelOneName = function (val){
                    dialogScope.mortgageInfo.mortgageLevelTwo = "";
                    //var mortgageCode = {mortgageCode:val}
                    //dialogScope.mortgageInfo.mortgageLevelOneName = "fds";
                    if(null != val){
                        var dataItemsDO = {mortgageCode:val,mortgageCodeList:mortgageCodeTwoList}
                        var data = {dataItemsDO:dataItemsDO};
                        var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
                        mortgageName.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageInfo.mortgageLevelOneName = res.contextData.mortgageName;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }else{
                        dialogScope.mortgageLevelTwoSource.ds = [];
                    }
                }
                //押品三级
                dialogScope.mortgageLevelThreeSource = {};
                dialogScope.mortgageLevelTwoName = function (val){
                    dialogScope.mortgageInfo.mortgageLevelThreeSource = "";
                    if(null != val){
                        var dataItemsDO = {mortgageCode:val}
                        var data = {dataItemsDO:dataItemsDO};
                        var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
                        mortgageName.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageInfo.mortgageLevelTwoName = res.contextData.mortgageName;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageLevelThreeSource.ds = res.contextData;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }else{
                        dialogScope.mortgageLevelThreeSource.ds = [];
                    }
                }
                dialogScope.confirm_onClick = function(){
                    if($.doValidate("mortgageInfo")&&AddCheck(dialogScope.mortgageInfo)==true){
                        var price = parseFloat(dialogScope.mortgageInfo.price);
                        var invQuantity = parseFloat(dialogScope.mortgageInfo.invQuantity);
                        var originalTotPrice = price * invQuantity;
                        dialogScope.mortgageInfo.originalTotPrice = originalTotPrice;
                        $scope.datasource.ds.push(dialogScope.mortgageInfo);
                        $scope.conf.totalRecord=$scope.datasource.ds.length;
                        dialogScope.closeThisDialog();
                        $scope.selected.select = [];
                    }
                };
                dialogScope.cancel_onClick = function () {
                    dialogScope.closeThisDialog();
                    $scope.selected.select = [];
                };
            }],"入库押品详情录入",{showClose:true});
        }else{
            $common.get_tipDialog('请先选择抵/质押合同号！','showInform');
        }
    }

    //修改
    $scope.update_onClick = function(){
        if ($scope.selected.select.length != 1) {
            $common.get_tipDialog('只能选择一条记录！', 'showInform');
        }else{
            $common.get_ngDialog('mortgageEntering/bcnt_mortgageEnteringInfo.html', $scope,["$scope",function(dialogScope) {
                dialogScope.mortgageInfo = {};
                dialogScope.mortgageInfo = $scope.selected.select[0];
                //查询押品一级
                mortgageLevelOneSource();
                
                var mortgageCodeOneList = new Array();//拼装押品一级Code
                var mortgageCodeTwoList = new Array();//拼装押品二级Code
                
                function mortgageLevelOneSource(){
                	
               //查询一级押品前，先查询该抵质押合同录入的押品信息
                	
                    var dataMtg= {
                        pageNo: 1,
                        pageSize: 10000,
                        bCntSlaveMtgRel:{slaveContno:$scope.mortgageAdd.slaveContcode},
                        cache:0
                    };
                    var promiseMtg = $common.get_asyncData("bCntSlaveMtgRelService/findBCntSlaveMtgRelByPage",dataMtg);
                    dialogScope.mortgageLevelOneSource = {};
                    promiseMtg.then(function(res){
                        var data;
                        if (res.errorCode =="SUC"){
                            data = res.contextData;
                            
                            for(var i=0;i<data.records.length;i++){
                            	var mtgModel = data.records[i];
                            	mortgageCodeOneList.push(mtgModel.mortgageLevelOne);
                            	mortgageCodeTwoList.push(mtgModel.mortgageLevelTwo);
                         } 
		                    //业务品种下拉框
		                    var dataItemsDO = {levels:"1",mortgageCodeList:mortgageCodeOneList};
		                    var data = {dataItemsDO:dataItemsDO}
		                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
		                    promise.then(function(res){
		                        if (res.errorCode =="SUC"){
		                            dialogScope.mortgageLevelOneSource.ds = res.contextData;
		                        }else{
		                            $common.get_tipDialog(res.errorMsg,'showInform');
		                        }
		                    });
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                      }
                   });      
                }
                //押品二级
                dialogScope.mortgageLevelTwoSource = {};
                mortgageLevelTwoSource();
                function mortgageLevelTwoSource(){
                    //业务品种下拉框
                    var dataItemsDO = {mortgageCode:$scope.selected.select[0].mortgageLevelOne,levels:"2",mortgageCodeList:mortgageCodeTwoList};
                    var data = {dataItemsDO:dataItemsDO}
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                }
                dialogScope.mortgageLevelOneName = function (val){
                    if(null != val){
                        var dataItemsDO = {mortgageCode:val,mortgageCodeList:mortgageCodeTwoList}
                        var data = {dataItemsDO:dataItemsDO};
                        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageLevelTwoSource.ds = res.contextData;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }else{
                        dialogScope.mortgageLevelTwoSource.ds = [];
                    }
                }
                //押品三级
                dialogScope.mortgageLevelThreeSource = {};
                mortgageLevelThreeSource();
                function mortgageLevelThreeSource(){
                    //业务品种下拉框
                    var dataItemsDO = {mortgageCode:$scope.selected.select[0].mortgageLevelTwo,levels:"3"};
                    var data = {dataItemsDO:dataItemsDO}
                    var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                    promise.then(function(res){
                        if (res.errorCode =="SUC"){
                            dialogScope.mortgageLevelThreeSource.ds = res.contextData;
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showInform');
                        }
                    });
                }
                dialogScope.mortgageLevelTwoName = function (val){
                    if(null != val){
                        var dataItemsDO = {mortgageCode:val}
                        var data = {dataItemsDO:dataItemsDO};
                        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
                        primise.then(function(res){
                            if(res.errorCode =="SUC"){
                                dialogScope.mortgageLevelThreeSource.ds = res.contextData;
                            }else{
                                $common.get_tipDialog(res.errorMsg,'showInform');
                            }
                        });
                    }else{
                        dialogScope.mortgageLevelThreeSource.ds = [];
                    }
                }
                dialogScope.confirm_onClick = function(){
                    if($.doValidate("mortgageInfo")&&AddCheck(dialogScope.mortgageInfo)==true){
                        //$scope.datasource.ds.push(dialogScope.billForm);
                        
                        var price = parseFloat(dialogScope.mortgageInfo.price) ;
                        var invQuantity = parseFloat(dialogScope.mortgageInfo.invQuantity);
                        var originalTotPrice = price * invQuantity;
                        dialogScope.mortgageInfo.originalTotPrice = originalTotPrice;
                        for(var x in $scope.datasource.ds ){
                            if($scope.datasource.ds[x].mortgageName == $scope.selected.select[0].mortgageName){
                                $scope.datasource.ds[x]=dialogScope.mortgageInfo;
                            }
                        }
                        dialogScope.closeThisDialog();
                        $scope.selected.select = [];
                    }
                };
                dialogScope.cancel_onClick = function () {
                    dialogScope.closeThisDialog();
                    $scope.selected.select = [];
                };
            }],"入库押品详情录入",{showClose:true});
        }
    }

    //删除(支持批量删除)
    $scope.delete_onClick = function(){
        if($scope.selected.select.length < 1){
            $common.get_tipDialog('请至少选择一条记录!','showInform');
        }else{
            $common.get_tipDialog('确定删除吗？','showTip').then(function(){
                for(var i = 0;i<$scope.datasource.ds.length;i++){
                    for(var x=0;x<$scope.selected.select.length;x++){
                        if($scope.datasource.ds[i].mortgageName == $scope.selected.select[x].mortgageName){
                            $scope.datasource.ds.splice(i, 1);
                        }
                    }
                }
                $scope.selected.select=[];
                $scope.conf.totalRecord=$scope.datasource.ds.length;
            })
        }
    }

    //保存
    $scope.save_onClick = function(){
        if($.doValidate("mortgageAdd")){
            if($scope.datasource.ds.length>0){
                var data = {
                    mortgageInfo:$scope.mortgageAdd,
                    mortgageInfoList: $scope.datasource.ds
                };
                var promise = $common.get_asyncData("mortgageEnteringService/mortgageEnteringQryAdd", data);
                promise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        $common.get_tipDialog('保存成功！', 'showSuccess');
                        $state.go("bcntMortgageEntering");//跳转
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                })
            }else{
                $common.get_tipDialog('请输入押品信息!', 'showInform');
            }
        }
    }

    //保存并出质申请
    $scope.saveApply_onClick = function(){
        if($.doValidate("mortgageAdd")){
            if($scope.datasource.ds.length>0){
                var data = {
                    mortgageInfo:$scope.mortgageAdd,
                    mortgageInfoList: $scope.datasource.ds
                };
                var promise = $common.get_asyncData("mortgageEnteringService/mortgageEnteringQryAdd", data);
                promise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        $common.get_tipDialog('保存成功！', 'showSuccess');
                        var data = {
                            conId:$scope.mortgageAdd.slaveContcode,
                            gutId:$scope.mortgageAdd.gutId,
                            mortgageInfoList: res.contextData
                        };
                        dataDeliver.setter(data);
                        $state.go("fourPledgeApply");//跳转
                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showInform');
                    }
                })
            }else{
                $common.get_tipDialog('请输入押品信息!', 'showInform');
            }
        }
    }

    //返回
    $scope.cancel_onClick = function(){
        $state.go("bcntMortgageEntering");//跳转
    }

    function AddCheck(data){
        var invQuantity = data.invQuantity;
        var price = data.price;
        //var priceDropRate = data.priceDropRate;
        if(!(/^[0-9]{0,}$/.test(invQuantity))){
            $common.get_tipDialog('数量/重量不符合标准!', 'showInform');
            return false;
        }else{
            return true;
        }
    }
}
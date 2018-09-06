/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2017/1/13
 */

var MarPricInfoListController = function($scope,$common,$state,dataDeliver) {

    $scope.datasource={ds:[]};

    $scope.selected={select:[]};

    $scope.conf={
        pageNo:1,
        pageSize:10,
        totalRecord:0
    }

    $scope.conditionForm={}
//=================押品一级筛选开始=================//
    $scope.levelOneContent = {
        type:"table",//展示类型table  tree
        url:"bPbcMtgClassService/findBPbcMtgClassForThreeLevelSelect",
        //param:{levels:"1"},    //应收账款融资
        //split:",",//分隔符
        extentColumn:"mortgageCode",
        column:["mortgageName"]//展示内容
    };
    $scope.levelOneDoExtent = function(ds){
        $scope.conditionForm.mortgageLevelOne_Q=ds.mortgageCode;
        $scope.conditionForm.mortgageLevelOneName=ds.mortgageName;
        //需要清空所有的二级三级押品的名称和数据
        if($scope.conditionForm.mortgageLevelTwo_Q){
            $scope.conditionForm.mortgageLevelTwo_Q=null;
            $scope.conditionForm.mortgageLevelTwoName="";
            $scope.conditionForm.mortgageLevelThree_Q=null;
            $scope.conditionForm.mortgageThreeName="";
        }
        $scope.levelTwoContent.param = {
            levels:"2",
            parentCode:$scope.conditionForm.mortgageLevelOne_Q
        }
    };
    $scope.$watch("conditionForm.mortgageLevelOneName",function(newVal,oldVal){
        $scope.levelOneContent.param ={
            levels:"1",
            mortgageName:$scope.conditionForm.mortgageLevelOneName
        };
    });
    //=================押品一级筛选结束=================//

    //=============押品二级筛选开始================//
    $scope.levelTwoContent = {
        type:"table",//展示类型table  tree
        url:"bPbcMtgClassService/findBPbcMtgClassForThreeLevelSelect",
        //param:{levels:"2",parentCode:$scope.conditionForm.mortgageLevelOne},
        //split:",",//分隔符
        extentColumn:"mortgageCode",
        column:["mortgageName"]//展示内容
    };
    $scope.levelTwoDoExtend = function(ds){
        $scope.conditionForm.mortgageLevelTwo_Q=ds.mortgageCode;
        $scope.conditionForm.mortgageLevelTwoName=ds.mortgageName;
        if($scope.conditionForm.mortgageLevelThree_Q){
            $scope.conditionForm.mortgageLevelThree_Q=null;
            $scope.conditionForm.mortgageThreeName="";
        }
        $scope.levelThreeContent.param = {
            levels:"3",
            ext1:ds.mortgageCode
        }
    };
    $scope.$watch("conditionForm.mortgageLevelTwoName",function(newVal,oldVal){
        $scope.levelTwoContent.param ={
            levels:"2",
            parentCode:$scope.conditionForm.mortgageLevelOne_Q,
            mortgageName:$scope.conditionForm.mortgageLevelTwoName
        };
    });
    //===============押品二级筛选结束=================//

    //==============押品三级筛选开始=================//
    $scope.levelThreeContent ={
        type:"table",//展示类型table  tree
        url:"bPbcMtgClassService/findBPbcMtgClassForThreeLevelSelect",
        //param:{levels:"3",parentCode:$scope.conditionForm.mortgageLevelTwo},
        //split:",",//分隔符
        extentColumn:"mortgageCode",
        column:["mortgageName"]//展示内容
    }

    $scope.levelThreeDoExtend = function(ds){
        $scope.conditionForm.mortgageLevelThree_Q=ds.mortgageCode;
        $scope.conditionForm.mortgageThreeName=ds.mortgageName;
    };

    $scope.$watch("conditionForm.mortgageThreeName",function(newVal,oldVal){
        $scope.levelThreeContent.param ={
            levels:"3",
            ext1:$scope.conditionForm.mortgageLevelTwo_Q,
            mortgageName:$scope.conditionForm.mortgageThreeName
        };
    });
    /*//=================押品一级筛选开始=================//
    $scope.levelOneContent = {
        type:"table",//展示类型table  tree
        url:"bPbcMtgMktPriceService/findMortgageLevelByPage",
        param:{levels:"1"},    //应收账款融资
        //split:",",//分隔符
        extentColumn:"mortgageCode",
        column:["mortgageName"]//展示内容
    };
    $scope.levelOneDoExtent = function(ds){
        $scope.conditionForm.mortgageLevelOne_Q=ds.mortgageCode;//监管合同号
        $scope.conditionForm.mortgageLevelOneName=ds.mortgageName; //监管公司名称
        //需要清空所有的二级三级押品的名称和数据
        if($scope.conditionForm.mortgageLevelTwo_Q){
            $scope.conditionForm.mortgageLevelTwo_Q=null;
            $scope.conditionForm.mortgageLevelTwoName="";
            $scope.conditionForm.mortgageLevelThree_Q=null;
            $scope.conditionForm.mortgageThreeName="";
        }
        $scope.levelTwoContent.param = {
            levels:"2",
            parentCode:$scope.conditionForm.mortgageLevelOne_Q
        }
    };
    $scope.$watch("conditionForm.mortgageLevelOneName",function(newVal,oldVal){
        $scope.levelOneContent.param ={
            levels:"1",
            mortgageName:$scope.conditionForm.mortgageLevelOneName,
        };

    });
    //=================押品一级筛选结束=================//

    //=============押品二级筛选开始================//
    $scope.levelTwoContent = {
        type:"table",//展示类型table  tree
        url:"bPbcMtgMktPriceService/findMortgageLevelByPage",
        param:{levels:"2",parentCode:$scope.conditionForm.mortgageLevelOne},
        //split:",",//分隔符
        extentColumn:"mortgageCode",
        column:["mortgageName"]//展示内容
    };
    $scope.levelTwoDoExtend = function(ds){
        $scope.conditionForm.mortgageLevelTwo_Q=ds.mortgageCode;//监管合同号
        $scope.conditionForm.mortgageLevelTwoName=ds.mortgageName; //监管公司名称
        if($scope.conditionForm.mortgageLevelThree_Q){
            $scope.conditionForm.mortgageLevelThree_Q=null;
            $scope.conditionForm.mortgageThreeName="";
        }
        $scope.levelThreeContent.param = {
            levels:"3",
            parentCode:$scope.conditionForm.mortgageLevelTwo_Q
        }
    };
    $scope.$watch("conditionForm.mortgageLevelTwoName",function(newVal,oldVal){
        $scope.levelOneContent.param ={
            levels:"2",
            parentCode:$scope.conditionForm.mortgageLevelOne,
            mortgageName:$scope.conditionForm.mortgageLevelTwoName,
        };

    });
    //===============押品二级筛选结束=================//

    //==============押品三级筛选开始=================//
    $scope.levelThreeContent ={
        type:"table",//展示类型table  tree
        url:"bPbcMtgMktPriceService/findMortgageLevelByPage",
        param:{levels:"3",parentCode:$scope.conditionForm.mortgageLevelTwo_Q},
        split:",",//分隔符
        extentColumn:"mortgageCode",
        column:["mortgageName"]//展示内容
    }

    $scope.levelThreeDoExtend = function(ds){
        $scope.conditionForm.mortgageLevelThree_Q=ds.mortgageCode;//监管合同号
        $scope.conditionForm.mortgageThreeName=ds.mortgageName; //监管公司名称
    };

    $scope.$watch("conditionForm.mortgageThreeName",function(newVal,oldVal){
        $scope.levelOneContent.param ={
            levels:"3",
            parentCode:$scope.conditionForm.mortgageLevelTwo_Q,
            mortgageName:$scope.conditionForm.mortgageThreeName,
        };

    });
    //=============押品三级筛选结束===================//
*/
    $scope.$watch("conf.pageNo+conf.pageSize",function(){
        $scope.queryTable();
    });

    $scope.queryTable = function(){
        var data={
            pageNo:$scope.conf.pageNo,
            pageSize:$scope.conf.pageSize,
            commonQueryVO:$scope.conditionForm
        };

        var url ="bPbcMtgMktPriceService/getTblMortMarPriPage"
        $common.get_asyncData(url,data).then(function(res){
            if(res.errorCode=="SUC"){
                data= res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,"showError");
            }
        });

    }

    $scope.add_onClick = function(){
        var template ="marPriAlter/marPri_add.html";
        var row ='';
        $common.get_ngDialog(template,$scope,["$scope",function($scope){
            MarPriAddController($scope,$scope,$common,$state,dataDeliver,"add",row);
        }],"新增操作",{showClose:true});
    }

    $scope.update_onClick = function(){
        if($scope.selected.select.length==1){
            var template ="marPriAlter/marPri_add.html";
            var row =$scope.selected.select[0];
            $common.get_ngDialog(template,$scope,["$scope",function($scope){
                MarPriAddController($scope,$scope,$common,$state,dataDeliver,"update",row);
            }],"修改操作",{showClose:true});
        }else{
            $common.get_tipDialog("请选择一条记录",'showInform');
        }

    }

    $scope.column = function(row){
        $common.get_ngDialog(template,$scope,["$scope",function($scope){
            MarPriAddController($scope,$scope,$common,$state,dataDeliver,"update",row);
        }],{showClose:false});
    }

    $scope.history_onClick = function(){
        if($scope.selected.select.length==1){
            var row =$scope.selected.select[0];
            $state.go("history");
            dataDeliver.setter(row);
        }else{
            $common.get_tipDialog("请选择一条记录",'showInform');
        }
    }

    $scope.submit_onClick = function(){
        $scope.queryTable();
        $scope.selected.select =[];
        $scope.$apply();
    }

    $scope.rebort_onClick = function(){
        $scope.conditionForm={};
        $scope.selected.select =[];
        $scope.$apply();
    }

};

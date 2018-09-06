/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      liph
 * @version     1.0
 * Create at:   2017/1/13
 */

var MarPriAddController = function(dialogScope,$parentScope,$common,$state,dataDeliver,flag,row) {

    dialogScope.otherForm={};

    if(flag=="update"){
        dialogScope.disable = true;
        dialogScope.disable1 = false;
        dialogScope.otherForm =row;
    }else if(flag =="add"){
        dialogScope.disable = false;
        dialogScope.disable1 = false;
    }

    //=================押品一级筛选开始=================//
    dialogScope.levelOneContent = {
        type:"table",//展示类型table  tree
        url:"bPbcMtgClassService/findBPbcMtgClassForThreeLevelSelect",
        //param:{levels:"1"},    //应收账款融资
        //split:",",//分隔符
        extentColumn:"mortgageCode",
        column:["mortgageName"]//展示内容
    };
    dialogScope.levelOneDoExtent = function(ds){
        dialogScope.otherForm.mortgageLevelOne=ds.mortgageCode;
        dialogScope.otherForm.mortgageLevelOneName=ds.mortgageName;
        //需要清空所有的二级三级押品的名称和数据
        if(dialogScope.otherForm.mortgageLevelTwo){
           dialogScope.otherForm.mortgageLevelTwo=null;
           dialogScope.otherForm.mortgageLevelTwoName="";
           dialogScope.otherForm.mortgageLevelThree=null;
           dialogScope.otherForm.mortgageThreeName="";
        }
        dialogScope.levelTwoContent.param = {
            levels:"2",
            parentCode:dialogScope.otherForm.mortgageLevelOne
        }
    };
    dialogScope.$watch("otherForm.mortgageLevelOneName",function(newVal,oldVal){
        dialogScope.levelOneContent.param ={
            levels:"1",
            mortgageName:dialogScope.otherForm.mortgageLevelOneName
        };
    });
    //=================押品一级筛选结束=================//

    //=============押品二级筛选开始================//
    dialogScope.levelTwoContent = {
        type:"table",//展示类型table  tree
        url:"bPbcMtgClassService/findBPbcMtgClassForThreeLevelSelect",
        //param:{levels:"2",parentCode:dialogScope.otherForm.mortgageLevelOne},
        //split:",",//分隔符
        extentColumn:"mortgageCode",
        column:["mortgageName"]//展示内容
    };
    dialogScope.levelTwoDoExtend = function(ds){
        dialogScope.otherForm.mortgageLevelTwo=ds.mortgageCode;
        dialogScope.otherForm.mortgageLevelTwoName=ds.mortgageName;
        if(dialogScope.otherForm.mortgageLevelThree){
            dialogScope.otherForm.mortgageLevelThree=null;
            dialogScope.otherForm.mortgageThreeName="";
        }
        dialogScope.levelThreeContent.param = {
            levels:"3",
            ext1:ds.mortgageCode
        }
    };
    dialogScope.$watch("otherForm.mortgageLevelTwoName",function(newVal,oldVal){
        dialogScope.levelTwoContent.param ={
            levels:"2",
            parentCode:dialogScope.otherForm.mortgageLevelOne,
            mortgageName:dialogScope.otherForm.mortgageLevelTwoName
        };
    });
    //===============押品二级筛选结束=================//

    //==============押品三级筛选开始=================//
    dialogScope.levelThreeContent ={
        type:"table",//展示类型table  tree
        url:"bPbcMtgClassService/findBPbcMtgClassForThreeLevelSelect",
        //param:{levels:"3",parentCode:dialogScope.otherForm.mortgageLevelTwo},
        //split:",",//分隔符
        extentColumn:"mortgageCode",
        column:["mortgageName"]//展示内容
    }

    dialogScope.levelThreeDoExtend = function(ds){
        dialogScope.otherForm.mortgageLevelThree=ds.mortgageCode;
        dialogScope.otherForm.mortgageThreeName=ds.mortgageName;
    };

    dialogScope.$watch("otherForm.mortgageThreeName",function(newVal,oldVal){
        dialogScope.levelThreeContent.param ={
            levels:"3",
            ext1:dialogScope.otherForm.mortgageLevelTwo,
            mortgageName:dialogScope.otherForm.mortgageThreeName
        };
    });
    //=============押品三级筛选结束===================//
    //页面字段校验
    function checkFormRules(){
        //一级押品
        if(!dialogScope.otherForm.mortgageLevelOne || dialogScope.otherForm.mortgageLevelOneName==""){
            $common.get_tipDialog('请通过查询按钮选择押品一级！','showInform')
            return false;
        }
        //二级押品
        if(!dialogScope.otherForm.mortgageLevelTwo || dialogScope.otherForm.mortgageLevelTwoName==""){
            $common.get_tipDialog('请通过查询按钮选择押品二级！','showInform');
            return false;
        }
        //三级押品
        if(!dialogScope.otherForm.mortgageLevelThree || dialogScope.otherForm.mortgageThreeName==""){
            $common.get_tipDialog('请通过查询按钮选择押品三级！','showInform');
            return false;
        }
    }
    dialogScope.save_onClick = function(){
        if($.doValidate("otherForm")){
            if(checkFormRules()!=false){
                var data={
                    bPbcMtgMktPrice:dialogScope.otherForm
                };
                $common.get_asyncData("bPbcMtgMktPriceService/addOrUpdate",data).then(function(res){
                    if(res.errorCode =="SUC"){
                        $parentScope.queryTable();
                        dialogScope.closeThisDialog();
                        $parentScope.selected.select=[];
                        if(flag =="add"){
                            $common.get_tipDialog("新增成功","showInform");
                        }else if(flag =="update"){
                            $common.get_tipDialog("修改成功","showInform");
                        }
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
            }
        }
    }

    dialogScope.closeDialog_onClick = function(){
        dialogScope.closeThisDialog();
    }
};

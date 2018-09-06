/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Qinwei
 * @version     1.0
 * Create at:   2016/11/10
 */
var addController = function(evalScope, parentScope, $common, dataDeliver, flag,row) {

    //var data = dataDeliver.getter();
    //var appNo = data.appNo;
    //var conId = data.conId;
    //var gutId = data.gutId;
    //var processId =data.processId;
    //var modelId = data.modelId;

    evalScope.evalMdls =[];

    evalScope.selectMdlNms ={
        ds:[
        ]
    }

    evalScope.userInfo = {
    }

    evalScope.thisBrNo='';

    inti();

    function inti(){

        evalScope.evalMdls = [
            {mdlId:'1001',mdlNm:'评估模型1',salary:25000},
            {mdlId:'1002',mdlNm:'评估模型2',salary:18000},
            {mdlId:'1003',mdlNm:'评估模型3',salary:12000},
            {mdlId:'1004',mdlNm:'评估模型4',salary:9000},
            {mdlId:'1005',mdlNm:'评估模型5',salary:7000},
            {mdlId:'1006',mdlNm:'评估模型6',salary:5000}
        ];

        for(var i = 0;i<evalScope.evalMdls.length;i++){
            evalScope.selectMdlNms.ds[i] = {key:JSON.stringify(i),value:evalScope.evalMdls[i].mdlNm};
        }
    }


    if(flag=="add"){

        var myDate = new Date();
        var curDateStr = myDate.toISOString().split("T")[0];
        var curDateStrArray =  curDateStr.split("-");
        var curDateStrCombine ="";
        for(var i = 0;i<curDateStrArray.length;i++){
            curDateStrCombine =curDateStrCombine+ (curDateStrArray[i]);
        }

        var tlrNoPrimise = $common.get_asyncData('iBCrgEvalRecService/getBrNo');
        tlrNoPrimise.then(function(res){
            if (res.errorCode =="SUC"){
                evalScope.evalform = res.contextData;

                evalScope.evalform.isVld = '0';
                evalScope.evalform.stat = '000';
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });

        evalScope.evalform={
            rltTyp:'',
            custcd:'',
            isVld:'',
            stat:''
        };

        evalScope.disable=false;
        evalScope.disable1= false;
        evalScope.disable2 = false;
        evalScope.hide = false;
        evalScope.orgEval = {evalScr:'80',evalRslt:'B'}

    }

    if(flag =="view"){
        evalScope.disable=true;
        evalScope.disable1= true;
        evalScope.hide = true;
        evalScope.evalform=$common.copy(row);
    }

    if(flag =="update"){
        evalScope.disable=true;
        evalScope.disable1= false;
        evalScope.hide = false;
        evalScope.disable2 = false;
        evalScope.evalform=$common.copy(row);
        //init();
    }


    evalScope.theCrmBaseInfo={
        custType:'',
        custcd:'',
        rltId:'',
        cname:''
    };


    evalScope.cnameContent ={
        url:"bCrmBaseInfoService/selectBCrmBaseInfoByPage",
        type:"table",
        split:"-",
        extentColumn:["custcd","custType"],
        column:["cname"]
    }

    evalScope.doExtent =function(ds){
        evalScope.evalform.cname = ds.cname;
        evalScope.evalform.rltId = ds.custcd;
        evalScope.evalform.rltTyp = ds.custType;
    }

    evalScope.$watch("evalform.cname",function(){
        evalScope.cnameContent.params ={
            custcd:evalScope.evalform.rltId
        };
    });


    //*****************初始化结束********************//


    evalScope.chooseMdlNm = function(){
        var index = evalform.mdlNm.value;
        var  theMdlId = evalScope.evalMdls[index].mdlId;
        evalScope.evalform.mdlId = theMdlId;
    };



    //****开始其他函数逻辑******
    evalScope.confirmEval_onClick = function(){
        var index = evalform.mdlNm.value;
        var salary = evalScope.evalMdls[index].salary;
        //alert(salary);
        var primise = $common.get_asyncData('iBCrgEvalRecService/executeRules',{salary:salary});
        primise.then(function(res){
            if (res.errorCode =="SUC"){
                //alert(JSON.stringify(res.contextData));
                var evalResult = res.contextData;
                evalScope.evalform.evalScr = evalResult[1];
                evalScope.evalform.evalRslt = evalResult[0];
                $common.get_tipDialog('调用规则引擎，执行成功！','showInform');
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });

    }

    evalScope.closeThisDialog_onClick = function(){
        evalScope.closeThisDialog();
    };

    evalScope.confirmSave_onClick = function(){
        if($.doValidate("evalform")) {
            if(evalScope.evalform.evalId){
                var primise = $common.get_asyncData('iBCrgEvalRecService/update',{bCrgEvalRec:evalScope.evalform});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        if(evalScope.evalform.stat=="004"){
                            evalScope.evalform.stat="005";
                        }
                        parentScope.queryTable();
                        parentScope.selected.select=[];
                        $common.get_tipDialog('更新成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });

            }else{

                var primise = $common.get_asyncData("iBCrgEvalRecService/add", {bCrgEvalRec: evalScope.evalform});
                primise.then(function (res) {
                    if (res.errorCode == "SUC") {
                        evalScope.evalform.evalId = res.contextData.value;
                        parentScope.queryTable();
                        parentScope.selected.select = [];
                        $common.get_tipDialog('新增成功！', 'showSuccess');

                        evalScope.disable3 = true;

                    } else {
                        $common.get_tipDialog(res.errorMsg, 'showError');
                    }

                });

            }
        }else{
            $common.get_tipDialog('页面数据格式有误！','showError');
        }


    }

    evalScope.confirmSbmt_onClick = function(){
        if($.doValidate("evalform")) {
            if(evalScope.evalform.stat =="000"||!evalScope.evalform.stat){
                var params ={
                    processModel:{
                        modelId: 'creditEvalPrcssCreate',
                        ProcessName: '信用评估流程创建',
                        NodeId: 'credictEvalNode1',
                        startedUserId: userInfo.tlrNo,
                        bizId: evalScope.evalform.evalId,
                        bizData: [
                            evalScope.evalform.evalId,
                            evalScope.evalform.rltId,
                            evalScope.evalform.cname,
                            'creditEvalPrcssCreate'
                        ]
                    },
                    bCrgEvalRec:evalScope.evalform
                }
                var primise = $common.get_asyncData('iBCrgEvalRecService/submit', params);
                primise.then(function(res){
                    if (res.errorCode == "SUC") {
                        $common.get_tipDialog('发起成功！', 'showSuccess');
                        parentScope.queryTable();
                        evalScope.evalform.stat ="001"
                        evalScope.disable2 = true;
                        evalScope.closeThisDialog();
                    } else {
                        $common.get_tipDialog('发起失败!' + res.errorMsg, 'showError');
                    }
                });
            }else{
                $common.get_tipDialog("已经提交该记录",'showInform');
            }



        }
    }


};

/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Qinwei
 * @version     1.0
 * Create at:   2016/11/10
 */
var updtController = function(dialogScope, parentScope, $common, flag,row) {

    dialogScope.updateform={};
    dialogScope.evalMdls=[];

    dialogScope.userInfo={}
    dialogScope.selectClientNms = {ds:[]};
    dialogScope.bCrmBaseInfo={ds:[]};
    dialogScope.selectUpdtMdlNms ={
        ds:[
        ]
    }

    dialogScope.thisBrNo ='';

    init();
    ////*****************初始化结束********************////

    function init(){
        dialogScope.evalMdls =
            [
                {mdlId:'1001',mdlNm:'评估模型1',salary:25000},
                {mdlId:'1002',mdlNm:'评估模型2',salary:18000},
                {mdlId:'1003',mdlNm:'评估模型3',salary:12000},
                {mdlId:'1004',mdlNm:'评估模型4',salary:9000},
                {mdlId:'1005',mdlNm:'评估模型5',salary:7000}
            ];


        for(var i = 0;i<dialogScope.evalMdls.length;i++){
            dialogScope.selectUpdtMdlNms.ds[i] = {key:JSON.stringify(i),value:dialogScope.evalMdls[i].mdlNm};
        }


        //dialogScope.updateform=$common.copy(parentScope.selected.select[0]);

        dialogScope.updateform=$common.copy(parentScope.selected.select[0]);

        dialogScope.userInfo = userInfo;

        var myDate = new Date();
        var curDateStr = myDate.toISOString().split("T")[0];
        var curDateStrArray =  curDateStr.split("-");
        var curDateStrCombine ="";
        for(var i = 0;i<curDateStrArray.length;i++){
            curDateStrCombine =curDateStrCombine+ (curDateStrArray[i]);
        }


        //var tlrNoPrimise = $common.get_asyncData('iBCrgEvalRecService/getBrNo');
        //tlrNoPrimise.then(function(res){
        //    if (res.errorCode =="SUC"){
        //        //alert(JSON.stringify(res.contextData));
        //        dialogScope.thisBrNo = res.contextData.value;
        //
        //        dialogScope.updateform.lastUpdTlr = userInfo.tlrName;
        //        dialogScope.updateform.lstUpdBrCd = dialogScope.thisBrNo;
        //        dialogScope.updateform.lstUpdDt = curDateStrCombine;
        //        dialogScope.bCrmBaseInfo = parentScope.bCrmBaseInfo;
        //    }else{
        //        $common.get_tipDialog(res.errorMsg,'showError');
        //    }
        //});


        for(var i=0;i<dialogScope.bCrmBaseInfo.ds.length;i++){
            dialogScope.selectClientNms.ds[i] = {value:dialogScope.bCrmBaseInfo.ds[i].cname,key:JSON.stringify(i+1)};
        }

    }

    //*************初始化结束**************//

    dialogScope.confirmUpdt_onClick = function(){

        if($.doValidate("updateform")) {
            if(dialogScope.updateform.stat=="004"){
                dialogScope.updateform.stat="005";
            }

            if (flag == "update"){
                var primise = $common.get_asyncData('iBCrgEvalRecService/update',{"bCrgEvalRec":dialogScope.updateform});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){

                        parentScope.queryTable();
                        parentScope.selected.select=[];
                        dialogScope.closeThisDialog();

                        $common.get_tipDialog('更新成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            };
        };
    };

    //****开始其他函数逻辑******
    dialogScope.chooseMdlNm = function(){
        var index = updateform.mdlNm.value;
        var  theMdlId = dialogScope.evalMdls[index].mdlId;
        dialogScope.updateform.mdlId = theMdlId;
    };


    dialogScope.updtEval_onClick = function(){

        var index = updateform.mdlNm.value;
        var salary = dialogScope.evalMdls[index].salary;
        var primise = $common.get_asyncData('iBCrgEvalRecService/executeRules',{salary:salary});
        primise.then(function(res){
            if (res.errorCode =="SUC"){
                var evalResult = res.contextData;
                dialogScope.updateform.evalScr = evalResult[1];
                dialogScope.updateform.evalRslt = evalResult[0];
                $common.get_tipDialog('调用规则引擎，执行成功！','showInform');
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });

    }


    dialogScope.selectCname =function(){
        var index =otherform.cname.value;
        var cnameVal = dialogScope.bCrmBaseInfo.ds[index].cname;
        var custcd = dialogScope.bCrmBaseInfo.ds[index].custcd;
        dialogScope.otherform.orgCode = cnameVal;
        dialogScope.otherform.custcd = custcd;
    };

    //dialogScope.submitdisable = true;
    dialogScope.updtSbmt_onClick = function(){
        if(dialogScope.updateform.isVld == "1"){
            $common.get_tipDialog('已经提交该项记录！','showInform');
            return;
        }else{
            //dialogScope.otherform = parentScope.selected.select[0];
            var primise = $common.get_asyncData('iBCrgEvalRecService/submit', {bCrgEvalRec: dialogScope.updateform});
            primise.then(function (res) {
                if (res.errorCode == "SUC") {
                    var bCrgEvalRec = res.contextData;
                    var id = bCrgEvalRec.evalId;
                    var custId = bCrgEvalRec.rltId;
                    var custNm =dialogScope.otherform.orgCode;
                    var data = {
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
                    };
                    var primise = $common.get_asyncData("processService/startProcess", data);
                    primise.then(function (res) {
                        if (res.errorCode == "SUC") {
                            $common.get_tipDialog('发起流程成功！', 'showSuccess');
                            //document.execCommand("Refresh");
                            location.reload();
                            $scope.disable2 =true;
                            //$scope.flowsubmitdisable = false;
                        } else {
                            $common.get_tipDialog('发起失败!' + res.errorMsg, 'showError');
                            //$scope.flowsubmitdisable = false;
                        }
                    });
                }

            });

        }
    }

    dialogScope.closeUpdtDialog_onClick = function(){
        dialogScope.closeThisDialog();
        parentScope.selected.select = [];
    };


};

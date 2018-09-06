/**
 * Created by htrad0055 on 2016/12/7.
 */

var mptDlgUpdcntController = function($mprotDialogScope,parentScope,$common,$state,dataDeliver,flag) {

    $mprotDialogScope.bCntMprotform={};

    //svar getter =dataDeliver.getter();
    //console.log(getter);

    $mprotDialogScope.selectMortLevelOnes={
        ds:[]
    };
    
    $mprotDialogScope.mortgageLevelTwoSource= {
        ds: []
    };

    if(flag =="update"){
        //$mprotDialogScope.bCntMprotform = getter;
    	$mprotDialogScope.bCntMprotform=$common.copy(parentScope.mprotselected.select[0]);
    }
    
    mortgageLevelOneSource();

    mortgageLevelTwoSource();

    //初始化--------结束------------------------

    $mprotDialogScope.mortgageLevelTwoSource = {};


    function mortgageLevelOneSource(){
        //业务品种下拉框
        var dataItemsDO = {levels:"1"};
        var data = {dataItemsDO:dataItemsDO}
        var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
        $mprotDialogScope.mortgageLevelOneSource = {};
        promise.then(function(res){
            if (res.errorCode =="SUC"){
                $mprotDialogScope.mortgageLevelOneSource.ds = res.contextData;
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    }




    function mortgageLevelTwoSource(){
        //业务品种下拉框
        var levelOne = $mprotDialogScope.bCntMprotform.mortgageLevelOne;
        var dataItemsDO = {mortgageCode:levelOne}
        var data = {dataItemsDO:dataItemsDO};
        //var promise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
        $mprotDialogScope.mortgageLevelTwoSource = {};
        var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
        primise.then(function(res){
            if(res.errorCode =="SUC"){
                $mprotDialogScope.mortgageLevelTwoSource.ds = res.contextData;
            }else{
                $common.get_tipDialog(res.errorMsg,'showInform');
            }
        });
    }


    $mprotDialogScope.mortgageLevelOneName = function (val){
        $mprotDialogScope.bCntMprotform.mortgageLevelTwo = "";
        if(null != val){
            var dataItemsDO = {mortgageCode:val}
            var data = {dataItemsDO:dataItemsDO};
            var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
            mortgageName.then(function(res){
                if(res.errorCode =="SUC"){
                    $mprotDialogScope.bCntMprotform.mortgageLevelOneName = res.contextData.mortgageName;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
            var primise = $common.get_asyncData("mortgageEnteringService/getMortgageLevel",data);
            primise.then(function(res){
                if(res.errorCode =="SUC"){
                    $mprotDialogScope.mortgageLevelTwoSource.ds = res.contextData;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
        }else{
            $mprotDialogScope.mortgageLevelTwoSource.ds = [];
        }
    }


    $mprotDialogScope.mortgageLevelTwoName = function (val){
        $mprotDialogScope.bCntMprotform.mortgageLevelThreeSource = "";
        if(null != val){
            var dataItemsDO = {mortgageCode:val}
            var data = {dataItemsDO:dataItemsDO};
            var mortgageName = $common.get_asyncData("mortgageEnteringService/getMortgageName",dataItemsDO);
            mortgageName.then(function(res){
                if(res.errorCode =="SUC"){
                    $mprotDialogScope.bCntMprotform.mortgageLevelTwoName = res.contextData.mortgageName;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showInform');
                }
            });
        }else{
            $mprotDialogScope.mortgageLevelThreeSource.ds = [];
        }
    }

    $mprotDialogScope.mprotConfirm_onClick =function(){
        if($.doValidate("bCntMprotform")){
            var quantity =$mprotDialogScope.bCntMprotform.quantity;
            if(quantity<=0){
                $common.get_tipDialog("采购商品信息的【数量/重量】不能小于等于0！",'showError');
                return false;
            }
            var price =$mprotDialogScope.bCntMprotform.price;
            if(price<=0){
                $common.get_tipDialog("采购商品信息的【单价】不能小于等于0！",'showError');
                return false;
            }
            if(flag=="add"){


                    var i = parentScope.inserListMprots.length;
                    parentScope.inserListMprots.push($mprotDialogScope.bCntMprotform);

                    //parentScope.mprotdatasource.ds.push($mprotDialogScope.bCntMprotform);

                    //parentScope.queryMprotTable();
                    parentScope.$apply(function(){
                        parentScope.mprotselected.select=[];
                        parentScope.mprotdatasource.ds =parentScope.inserListMprots;
                    });

                    $mprotDialogScope.closeThisDialog();

            }

            if(flag=="update"){
             /*   parentScope.mprotselected.select[0] =  $mprotDialogScope.bCntMprotform;
                parentScope.$apply(function(){
                    parentScope.mprotselected.select=[];
                });*/
                //遍历已增加记录，修改相应的记录
               var dsArray =  parentScope.mprotdatasource.ds;
                var selected = parentScope.mprotselected.select[0];
                for (var i = 0; i < dsArray.length; i++) {
                    if (dsArray[i].mortgageName == selected.mortgageName) {
                        parentScope.mprotdatasource.ds[i] =$common.copy( $mprotDialogScope.bCntMprotform);
                        parentScope.mprotselected.select=[]; //清空选中记录
                    }
                }

                /* //遍历已增加记录，修改相应的记录
                var dsArray =  parentScope.mprotdatasource.ds;
                for (var i = 0; i < dsArray.length; i++) {
                    if (dsArray[i].mortgageName ==$mprotDialogScope.bCntMprotform.mortgageName) {
                        $common.get_tipDialog("货物已存在，请修改相应的记录！",'showError');
                        return false;
                    }
                }*/
                $mprotDialogScope.closeThisDialog();
            }

        }/*else{
            $common.get_tipDialog("页面数据格式错误！",'showError');
        }*/

    }




    $mprotDialogScope.price_onBlur = function(){
        var prc =$mprotDialogScope.bCntMprotform.price;
        var qty = $mprotDialogScope.bCntMprotform.quantity;
        var totprc=0;
        if((!isNaN(prc))&&(!isNaN(qty))){
            totprc = prc*qty;
        }

        parentScope.$apply(function(){
            $mprotDialogScope.bCntMprotform.totPrice = totprc;
        });

    }

    $mprotDialogScope.quantity_onBlur= function(){
        var prc =$mprotDialogScope.bCntMprotform.price;
        var qty = $mprotDialogScope.bCntMprotform.quantity;
        var totprc=0;
        if((!isNaN(prc))&&(!isNaN(qty))){
            totprc = parseFloat(prc)*parseFloat(qty);
        }
        parentScope.$apply(function(){
            $mprotDialogScope.bCntMprotform.totPrice = totprc;
        });
    }

    $mprotDialogScope.mprotCloseDialog_onClick =function(){
        $mprotDialogScope.closeThisDialog();
    }

    //表格--------结束-------------------------
};
/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Qinwei
 * @version     1.0
 * Create at:   2016/11/10
 */
var aplyController = function($thisScope,parentScope,$common,dataDeliver,flag) {
    //$thisScope.otherform=dataDeliver.getter();

    /*$thisScope.otherform=$common.copy(row);*/
    $thisScope.otherform = {};

    $thisScope.selectClientNms = {ds:[]};
    $thisScope.bCrmBaseInfo={ds:[]};
    $thisScope.bCrmBaseInfo = parentScope.bCrmBaseInfo;

    //alert(JSON.stringify(parentScope.bCrmBaseInfo));
    $thisScope.theCrmBaseInfo = {};
    $thisScope.datasource = {
        ds:[]
    };

    for(var i=0;i<$thisScope.bCrmBaseInfo.ds.length;i++){
        $thisScope.selectClientNms.ds[i] = {value:$thisScope.bCrmBaseInfo.ds[i].cname,key:JSON.stringify(i+1)};
    }

    $thisScope.userInfo = {
        tlrName:'',brNo:''
    }

    //var primise = $common.get_asyncData("iBCrgEvalRecService/getUserInfo");
    //primise.then(
    //    function(res){
    //        if (res.errorCode =="SUC"){
    //            $thisScope.userInfo.brNo = res.contextData.brNo;
    //            $thisScope.userInfo.tlrName = res.contextData.tlrName;
    //            //alert(userId+" / "+brNo);
    //
    //        }
    //    });

    //alert(JSON.stringify($thisScope.selectClientNms.ds));

    $thisScope.selectCname =function(){
        var index =otherform.cname.value;
        //alert(index);
        var cnameVal = $thisScope.bCrmBaseInfo.ds[index].cname;
        var custcd = $thisScope.bCrmBaseInfo.ds[index].custcd;

        $thisScope.otherform.orgCode = cnameVal;
        $thisScope.otherform.custcd = custcd;

    };



    $thisScope.apply_onClick = function(){
        var index =otherform.cname.value;
        $thisScope.theCrmBaseInfo = $thisScope.bCrmBaseInfo.ds[index];
        $common.get_ngDialog('eval/crgeval_add.html', parentScope
            ,["$scope",function(dialogScope){
                addController(dialogScope,$thisScope,$common,dataDeliver,"add");
            }],"信用评估",{showClose:false});
    };



    $thisScope.closeThisDialog_onClick = function(){
        $thisScope.closeThisDialog();
    };

};

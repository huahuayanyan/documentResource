/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var gntyconaddController = function(dialogScope,parentScope,dataDeliver,$state,$common,flag) {
    dialogScope.otherform = parentScope.otherform;
    dialogScope.row = {};
    dialogScope.confirm_onClick = function()
    {
        if($.doValidate("row")) {
            dialogScope.flowsubmitdisable = true;
            if(flag=="add")
            {
                var url;
                var gutyTyp = dialogScope.row.gutyTyp;
                if(gutyTyp=="03")
                {//保证
                    url = "bail"
                }
                else if(gutyTyp=="04")
                {//保证金
                    url="bailcash"
                }
                else if(gutyTyp=="01")
                {//抵押
                    url="mortgage"
                }
                else if(gutyTyp=="02")
                {//质押
                    url="pledge"
                }
                dialogScope.closeThisDialog();
                $state.go("lnapp."+url);
                dialogScope.otherform.flg = flag;
                dialogScope.otherform.row = dialogScope.row;
                dataDeliver.setter(dialogScope.otherform);
                //$common.get_ngDialog("gntycon/"+url+"_edit.html", parentScope
                //    ,["$scope",function(secondScope){
                //        secondScope.otherform = dialogScope.otherform;
                //        secondScope.row = secondScope.otherform.row;
                //        secondScope.hideCon = true;
                //        secondScope.number = {};
                //        var flg = secondScope.otherform.flg;
                //        var flag = secondScope.otherform.flag;
                //        var appId = secondScope.otherform.appId;
                //        secondScope.disable = true;
                //        if(!secondScope.otherform.flag)
                //        {
                //            secondScope.disableview = true;
                //            secondScope.hide = true;
                //        }
                //        else
                //        {
                //            secondScope.hide = true;
                //            if(flag=="lnconview"||flag=="lnconedit")
                //            {
                //                if(flag=="lnconedit")
                //                {
                //                    secondScope.disable = false;
                //                    secondScope.hide = false;
                //                    if(flg=="view")
                //                    {
                //                        secondScope.disable = true;
                //                        secondScope.hide = true;
                //                    }
                //                }
                //                secondScope.disableview = true;
                //            }
                //            else
                //            {
                //                if(flg=="add")
                //                {
                //                    secondScope.hide = false;
                //                }
                //                else
                //                {
                //                    if(flg=="update")
                //                    {
                //                        secondScope.hide = false;
                //                    }
                //                    else if(flg=="view")
                //                    {
                //                        secondScope.hide = true;
                //                        secondScope.disableview = true;
                //                    }
                //                }
                //            }
                //        }
                //
                //        /**
                //         * 担保人名称查询加载开始
                //         */
                //        secondScope.gutcontent = {
                //            type:"table",//展示类型table  tree
                //            url:"bCrrLnAppService/queryCustSource",
                //            param:{},
                //            split:",",//分隔符
                //            extentColumn:"custNm",
                //            column:["custNm","custId"]//展示内容
                //        };
                //        secondScope.gutextend = function(ds){
                //            secondScope.row.gutNm = ds.custNm;
                //            secondScope.row.gutId = ds.custId;
                //            secondScope.row.gcrtId = ds.idno;
                //            secondScope.row.gcrtTyp = ds.idtype;
                //            secondScope.number = ds;
                //        };
                //        secondScope.$watch("row.gutNm",function(){
                //            if(secondScope.row.gutNm!=null) secondScope.gutcontent.param ={custId:secondScope.row.gutNm,custNm:secondScope.row.gutNm};
                //        });
                //        /**
                //         * 担保人名称查询加载结束
                //         */
                //        secondScope.confirm_onClick = function(){
                //            if($.doValidate("row")) {
                //                if(flg=="add")
                //                {
                //                    secondScope.row.conStat = "0";
                //                    var primise = $common.get_asyncData('bCrrGntyConService/add',{bCrrGntyCon:secondScope.row});
                //                    primise.then(function(res){
                //                        var data;
                //                        if (res.errorCode =="SUC"){
                //                            data = res.contextData;
                //                            secondScope.relaform = {};
                //                            secondScope.relaform.rltNo = data.conId;
                //                            secondScope.relaform.serialno = appId;
                //                            secondScope.relaform.rltTyp = "01";
                //                            secondScope.relaform.isRelate = "01";
                //                            var primise = $common.get_asyncData("bCrrLnAppRelaService/add",{bCrrLnAppRela:secondScope.relaform});
                //                            primise.then(function(res){
                //                                if (res.errorCode =="SUC"){
                //                                    secondScope.closeThisDialog();
                //                                    parentScope.queryTable();
                //                                    $common.get_tipDialog('新增成功！','showSuccess');
                //                                }else{
                //                                    $common.get_tipDialog(res.errorMsg,'showError');
                //                                };
                //                            });
                //                        }else{
                //                            $common.get_tipDialog(res.errorMsg,'showError');
                //                        };
                //                    });
                //                }
                //                else if(flg=="update"||flg=="lnconedit")
                //                {
                //                    var primise = $common.get_asyncData('bCrrGntyConService/update',{bCrrGntyCon:secondScope.row});
                //                    primise.then(function(res){
                //                        if (res.errorCode =="SUC"){
                //                            secondScope.closeThisDialog();
                //                            parentScope.queryTable();
                //                            $common.get_tipDialog('更新成功！','showSuccess');
                //                        }else{
                //                            $common.get_tipDialog(res.errorMsg,'showError');
                //                        };
                //                    });
                //                }
                //            };
                //        };
                //        secondScope.closeThisDialog_onClick = function(){
                //            secondScope.closeThisDialog();
                //        };
                //    }],"担保合同",{showClose:false});
            }
        };
    }
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
};

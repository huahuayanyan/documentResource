/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */

var IndustryChooseController = function(dialogScope,parentScope,$common,$state,dataDeliver) {
    //console.log("userInfo信息："+JSON.stringify(userInfo));//用户信息，全局变量
    /*alert("userInfo信息："+JSON.stringify(userInfo));*/
    var data1=dataDeliver.getter();
    var flag1=data1.flag;
    var productId=data1.productId;//如果没有产品号，直接报错，提示产品号丢失，请重新操作！
    if(productId != ""){
        dialogScope.conditionForm={
            industryLevel:"2",//只查询大类的行业代码
        };//初始化条件查询框
        dialogScope.datasource={//初始化表格对象
            ds: []
        };
        dialogScope.selected={//初始化对象 todo!!!!!!!!!!!!!!这里应该要将前一个页面的数据赋值过来。
            select: []
        };
        dialogScope.conf= {//初始化分页对象
            pageNo: 1,
            pageSize: 10,
            totalRecord: 0}
        //监听分页
        dialogScope.$watch("conf.pageNo+conf.pageSize",function(){
            dialogScope.queryTable();
        });
        //重置按钮 industryCode,industryName
        dialogScope.rebort_onClick =function(){
            dialogScope.conditionForm.industryCode = "";
            dialogScope.conditionForm.industryName = "";
            dialogScope.queryTable();
        }
        //点击查询之后的搜索
        dialogScope.submit_onClick =function(){
            dialogScope.queryTable();
            dialogScope.selected.select=[];
        };
        //查询操作
        dialogScope.queryTable = function(paramData){
            var data= {
                pageNo: dialogScope.conf.pageNo,
                pageSize: dialogScope.conf.pageSize,
                bBrpIndustryTypes:dialogScope.conditionForm
            };
            var promiseQ = $common.get_asyncData("bBrpIndustryTypesService/findBBrpIndustryTypesByPage",data);
            promiseQ.then(function(res){
                var data;
                if (res.errorCode =="SUC"){
                    data = res.contextData;
                    dialogScope.datasource.ds = data.records;
                    dialogScope.conf.totalRecord = data.totalRecord;
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
        };

        //保存按钮
        dialogScope.save_onClick = function(){
            if(dialogScope.selected.select.length == 0){
                $common.get_tipDialog('请至少选择一条记录！','showInform');
            }else{//先将这个表中选中的记录转化数据格式传给后台和前一个页面。
                var arrs =$common.copy(dialogScope.selected.select);
                //新增或者修改操作向后台传递的参数 bPrdIndustryType,后台要的数据是 industryCode，industryCode,....
                var industryCodeList="";
                for(var k in arrs){
                    industryCodeList=arrs[k].industryCode+","+industryCodeList;
                }
                industryCodeList=industryCodeList.substring(0, industryCodeList.length - 1);
                var bPrdIndustryType={
                    productId:productId,
                    industryType:industryCodeList
                }

                //给行业基础信息的准入行业显示的 induestryTypeName
                var industryTypeName="";//操作成功，则将对应的值直接赋值给页面,前台要的数据是industryCode-industryName，industryCode-industryName，
                for(var x in arrs){
                    industryTypeName=arrs[x].industryCode+"-"+arrs[x].industryName+","+industryTypeName;
                }
                industryTypeName=industryTypeName.substring(0, industryTypeName.length - 1);
                if(flag1 == "add"){//新增页面跳转过来的
                    var primiseS = $common.get_asyncData('bPrdIndustryTypeService/add',{bPrdIndustryType:bPrdIndustryType})
                    primiseS.then(function(res){
                        if (res.errorCode =="SUC"){//要将对应的数据赋值给页面induestryTypeName，induestryForm
                            parentScope.industryForm.industryTypeName=industryTypeName;
                            dialogScope.closeThisDialog();
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                }else{//修改页面跳转过来的
                    var primiseS = $common.get_asyncData('bPrdIndustryTypeService/update',{bPrdIndustryType:bPrdIndustryType})
                    primiseS.then(function(res){
                        if (res.errorCode =="SUC"){//要将对应的数据赋值给页面induestryTypeName，induestryForm
                            parentScope.induestryForm.induestryTypeName=induestryTypeName
                            dialogScope.closeThisDialog();
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                }
            }
        };
        //返回按钮
        dialogScope.back_onClick = function(){
            dialogScope.closeThisDialog();
        }
    }else{
        $common.get_tipDialog('产品号丢失，请重新进入产品工厂！','showError');
    }
};

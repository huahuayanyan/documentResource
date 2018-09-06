/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var ftDialogController = function(dialogScope,parentScope,$common,flag) {

    dialogScope.datasourceDialog={//初始化表格对象
        ds: []
    };
    dialogScope.selectedDialog={//初始化对象
        select: [
            {
            "jghth":"JGFJ45645643213",
            "jggsmc":"一级菜单A",
            "ywpz":"acd",
            "treeId": "1000",
            "treeName": "一级菜单A",
            "treeLevel":"1",
            "treeParentId":"0"
           },
            {
                "jghth":"JGFhrthgf",
                "jggsmc":"二级菜单B",
                "ywpz":"dfhdfg",
                "treeId": "10011",
                "treeName": "二级菜单B",
                "treeLevel":"2",
                "treeParentId":"1001"
            }
        ]
    };
    dialogScope.confDialog= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0}
    //监听分页
    dialogScope.$watch("confDialog.pageNo+confDialog.pageSize",function(){
        //alert("我是分页监听器");
        var promise = $common.get_asyncData("displayTableOrTree/jquery","");
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                dialogScope.datasourceDialog.ds = data.records;
                dialogScope.confDialog.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    });


    if(flag == "add"){
        dialogScope.otherform={};//定义form对象
    }else if (flag == "update"){
        dialogScope.otherform=$common.copy(parentScope.selected.select[0]);
    };
    dialogScope.confirm_onClick = function(){
        //alert(JSON.stringify(dialogScope.selectedDialog.select));
        if($.doValidate("otherform")) {
            if(flag == "add"){
                var primise = $common.get_asyncData("orgUserService/findOrgUserByPage2",dialogScope.otherform);
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        parentScope.queryTable();
                        parentScope.selected.select=[];
                        dialogScope.closeThisDialog();
                        $common.get_tipDialog('新增成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            }else if (flag == "update"){
                var primise = $common.get_asyncData('orgUserService/findOrgUserByPage2',dialogScope.otherform);
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
    dialogScope.closeThisDialog_onClick = function(){
        dialogScope.closeThisDialog();
    };
    //$(window).scroll(function(){
    //    console.debug("1");
    //});
};

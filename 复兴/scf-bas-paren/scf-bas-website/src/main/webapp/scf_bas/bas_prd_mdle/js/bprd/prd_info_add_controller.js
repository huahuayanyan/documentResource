/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/4/21
 */
var PrdInfoAddController = function($scope,$common,$state,dataDeliver) {
    //console.log("userInfo信息："+JSON.stringify(userInfo));//用户信息，全局变量
    //1.如果是新增跳转过来的，则不能点击完成按钮。点击跳转到下一页面。保存数据，如果保存失败，则不能跳转。
    //2.如果是修改跳转过来的，点击完成按钮则直接跳转到最后的产品报告页，再点击完成则会跳转到首页面。next,compliate
    //3.如果是新增跳转过来的，点击下一步等于新增操作，如果是修改跳转过来的，则下一步等于修改操作
    //产品大类下拉（这里只需要那三个其他的都不需要）
    $scope.otherform={
        productType:"002",
        productId:""
    };
    $scope.parentId={
        ds:[]
    };
    var bPrdInfo1={//选择产品大类
        productType:"000"
    };
    var promise1 = $common.get_asyncData("bPrdInfoService/findBPrdInfoByBPrd",{bPrdInfo:bPrdInfo1});
    promise1.then(function(res){
        if (res.errorCode =="SUC"){
            $scope.parentId.ds = res.contextData;
        }else{
            $common.get_tipDialog(res.errorMsg,'showError');
        }
    });
    var data1 = dataDeliver.getter();
    var flag=data1.flag;
    if(flag == "add") {//新增跳转过来的,仍然需要根据产品ID去后台查询对应数据，赋值到页面。
        $scope.hide = true;//隐藏完成按钮
    }else if(flag == "update"){//修改的时候，不可修改产品代码 disable1
        $scope.disable1=true;
    }
    if(data1.productId != ""){//只要dataDeliver里面bPrdInfo不为"",就去根据产品号去查询.
        var bPrdInfo = {
            productId:data1.productId
        };
        var primise = $common.get_asyncData("bPrdInfoService/findBPrdInfoByKey", {bPrdInfo: bPrdInfo});
        primise.then(function (res) {
            if (res.errorCode == "SUC") {
                if (res.contextData != "" && res.contextData != null) {
                    $scope.otherform=res.contextData;
                }
            } else {
                $common.get_tipDialog(res.errorMsg, 'showError');
            }
        });
    }
        //------------------------下一步点击事件-------------------------
        $scope.next_onClick = function(){
            if($.doValidate("otherform")){//校验前台数据
                if(flag == "add"){
                    var primise = $common.get_asyncData("bPrdInfoService/add",{bPrdInfo:$scope.otherform});
                    primise.then(function(res){
                        if (res.errorCode =="SUC"){//如果新增成功，则需要将对应的产品号传递到下一个页面。
                            var data2= {
                                flag: "add",
                                productId:$scope.otherform.productId,
                                productName:$scope.otherform.productName,
                            };
                            dataDeliver.setter(data2);
                            $state.go("tree.prdBaseInfo");
                            $scope.$parent.panes.forEach(function(pane){
                                if (pane.uiSref == "tree.prdBaseInfo"){
                                    $scope.$parent.select(pane);
                                };
                            });
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                }else if(flag == "update"){
                    var primise = $common.get_asyncData("bPrdInfoService/update",{bPrdInfo:$scope.otherform});
                    primise.then(function(res){
                        if (res.errorCode =="SUC"){
                            $state.go("tree.prdBaseInfo");
                            $scope.$parent.panes.forEach(function(pane){
                                if (pane.uiSref == "tree.prdBaseInfo"){
                                    $scope.$parent.select(pane);
                                };
                            });
                        }else{
                            $common.get_tipDialog(res.errorMsg,'showError');
                        }
                    });
                }
            }else{
                $common.get_tipDialog("页面数据有误！",'showError');
            }
        };

        //-----------------------完成按钮点击事件-------------------------
        $scope.complete_onClick = function(){
            var primise = $common.get_asyncData("bPrdInfoService/update",{bPrdInfo:$scope.otherform});
            primise.then(function(res){
                if (res.errorCode =="SUC"){
                    $state.go("tree.prdReportInfo");
                    $scope.$parent.panes.forEach(function(pane){
                        if (pane.uiSref == "tree.prdReportInfo"){
                            $scope.$parent.select(pane);
                        };
                    });
                }else{
                    $common.get_tipDialog(res.errorMsg,'showError');
                }
            });
}

}

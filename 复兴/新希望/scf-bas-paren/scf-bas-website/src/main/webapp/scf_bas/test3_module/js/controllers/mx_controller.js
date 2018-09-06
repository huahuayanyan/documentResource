/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/18
 */
var mxController = function($scope,$timeout,$common,$state,dataDeliver){
    $scope.param = {aaa:534345,bbb:34534};
    $scope.param2 = {aaa2:534345};
    $scope.param3 = {aaa3:534345};
    $scope.param4 = {aaa4:534345};
    $scope.param5 = {aaa5:534345};
    $state.go("mx.fkxx",{aaa:222,bbb:11111});//跳转
    //dataDeliver.setter({data:"我是父页面传过来的值"})//传值[可选]
    //todo
}
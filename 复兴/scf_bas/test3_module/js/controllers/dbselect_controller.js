/**
 * Created by htrad0017 on 2016/9/29.
 */
var dbselectController = function($scope,$common){
    //双选
    $common.get_asyncData('select',{}).then(function(res){
        $scope.doubleSelect=res.contextData;
    });
};
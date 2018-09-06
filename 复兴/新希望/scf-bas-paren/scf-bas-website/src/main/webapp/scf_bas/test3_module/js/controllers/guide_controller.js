/**
 * Created by htrad0017 on 2016/9/29.
 */
var guideController = function($scope,$common,$state){
    //导航
    //$common.get_asyncData('guide',{}).then(function(res){
    //    $scope.guide= res.contextData;
    //})
    $common.get_asyncData('/getEcharts',{}).then(function(res){
        $scope.chardata1= res.contextData;
    })

    $common.get_asyncData('/getEcharts',{}).then(function(res){
        $scope.chardata= res.contextData;
    })
};

/**
 * Created by htrad0017 on 2016/9/29.
 */
var uploadController = function($scope,$timeout,$common){
    $scope.uploadoption = {
        inputHidden:[
            {name:'callback',value: 'respText...'}
        ],
        callbackFun: function(res,status){
            console.log("res: "+res+"  status: "+status);
        }
    };
    $scope.downloadoption = {
        inputHidden:[
            {name:'callback',value: 'fileServiceSupport_download'},
            {name:'Authorization',value: window.authorization||sessionStorage.getItem("authorization")},
            {name:'genFileName',value: '吴彬.txt'}
        ]
    };
    var t =0;
    var myInterval =function (){
        t +=10;
        $scope.percent =t;
        console.log($scope.percent)
    }
    var timer = $timeout(myInterval,500);
    $scope.$watch('percent',function(newval,oldval){
        if(newval!==oldval &&newval!==100){
            timer=$timeout(myInterval,500);
        }
    })
};

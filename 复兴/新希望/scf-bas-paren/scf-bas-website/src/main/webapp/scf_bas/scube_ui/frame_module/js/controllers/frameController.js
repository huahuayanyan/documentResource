/**
 * Created by wubin on 2016/4/25.
 */
var frameController = function($scope,$common,$cookieStore){
    $scope.sidebarList = JSON.parse(localStorage.getItem('loginRtnData'));;
    $scope.visible = false;
    $scope.tabArry = [];
    $scope.cacheArry = [];
    $scope.login = function () {
        var promise_login = $common.get_asyncData('/login',$scope.loginForm);
        promise_login.then(
            function (res) {
                if(res.errorCode=='SUC'){
                    $cookieStore.put('sessionToken',res.sessionToken);
                    sessionStorage.setItem('sessionToken',res.sessionToken);
                    location.href = '../../frame_module/html/frame.html';
                    $scope.sidebarList =res.contextData;
                    localStorage.setItem('loginRtnData',JSON.stringify(res.contextData));
                }else {
                    $common.get_tipDialog(res.errorMsg,'showError')
                }
            },function (res) {
                $common.get_tipDialog(JSON.stringify(res),'showError')
            }
        );
    }
}

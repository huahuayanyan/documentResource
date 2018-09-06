/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var gntyinfoeditController = function($scope,$common,dataDeliver,$state,$rootScope) {
    $scope.otherform = dataDeliver.getter();
    $scope.row = $scope.otherform.row;
    var flg = $scope.otherform.flg;
    var flag = $scope.otherform.flag;
    if(!$scope.otherform.flag)
    {
        $scope.disable = true;
        $scope.hide = true;
        $scope.disableview = true;
    }
    else
    {
        if(flag=="lnconview"||flag=="lnconedit")
        {
            $scope.disable = true;
            $scope.hide = true;
            $scope.disableview = true;
        }
        else
        {
            if(flg=="add")
            {
                $scope.disableclose = true;
                $scope.hideno = true;
                $scope.disable = false;
                $scope.hide = false;
            }
            else if(flg=="update")
            {
                $scope.disable = true;
                $scope.hide = false;
            }
            else if(flg=="view")
            {
                $scope.disableview = true;
                $scope.disable = true;
                $scope.hide = true;
            }
        }
    }
    $scope.confirm_onClick = function(){
        if($.doValidate("row")) {
            $scope.disableconfirm = true;
            if(flg=="add")
            {
                var primise = $common.get_asyncData('bCrrGntyInfoService/add',{bCrrGntyInfo:$scope.row});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $state.go("lnapp.gnty");
                        $common.get_tipDialog('新增成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            }
            else if(flg=="update")
            {
                var primise = $common.get_asyncData('bCrrGntyInfoService/update',{bCrrGntyInfo:$scope.row});
                primise.then(function(res){
                    if (res.errorCode =="SUC"){
                        $state.go("lnapp.gnty");
                        $common.get_tipDialog('更新成功！','showSuccess');
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    };
                });
            }
            $scope.$parent.panes.forEach(function(pane){
                if (pane.uiSref == "lnapp.gnty"){
                    $scope.$parent.select(pane);
                }
            });
            return;
        };
    };
    $scope.closeThisDialog_onClick = function(){
        if(!$scope.otherform.flag)
        {
            $state.go("gnty");
            $scope.$parent.panes.forEach(function(pane){
                if (pane.uiSref == "gnty"){
                    $scope.$parent.select(pane);
                }
            });
        }
        else
        {
            if(flag == "lnconview"||flag=="lnconedit")
            {
                $state.go("lncon.gnty");
                $scope.$parent.panes.forEach(function(pane){
                    if (pane.uiSref == "lncon.gnty"){
                        $scope.$parent.select(pane);
                    }
                });
            }
            else
            {
                $state.go("lnapp.gnty");
                $scope.$parent.panes.forEach(function(pane){
                    if (pane.uiSref == "lnapp.gnty"){
                        $scope.$parent.select(pane);
                    }
                });
            }
        }
    };
};

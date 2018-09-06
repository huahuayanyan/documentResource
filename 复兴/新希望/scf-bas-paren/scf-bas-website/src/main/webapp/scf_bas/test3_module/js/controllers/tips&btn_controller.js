/**
 * Created by htrad0017 on 2016/9/29.
 */
var tipsbtnController = function($scope,$common){

    //按钮--------开始-------------------------
    $scope.button_onClick =function(){
        $common.get_tipDialog('根据唯一ID响应点击事件。','showInform');
    }
    $scope.button2_onClick =function(){
        $common.get_tipDialog('恭喜，成功了。','showSuccess');
    }
    $scope.button3_onClick =function(){
        $common.get_tipDialog('哎呀，失败了。','showError');
    }
    $scope.button4_onClick =function(){
        $common.get_tipDialog('注意，这是警告。','showWarning');
    }
    $scope.button5_onClick =function(){
        $common.get_tipDialog('这是提示信息。','showInform');
    }
    $scope.button6_onClick =function(){
        $common.get_tipDialog('请确认。','showTip').then(function () {
            $common.get_tipDialog('谢谢。','showInform');
        });
    }
    //按钮--------结束-------------------------

    //----------------------按钮式菜单------开始--------------------
    $scope.menu = [
        {name:'java',code:'_java'},
        {name:'c',code:'_java'},
        {name:'oracle',code:'_java'},
        {name:'javascript',code:'_java'}
    ]
    $scope.selectedMenu = function(item){
        $common.get_tipDialog("选择的是 "+JSON.stringify(item),'showInform');
    }
    //----------------------按钮式菜单------结束--------------------
};

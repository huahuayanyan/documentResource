/**
 * Created by Administrator on 2016/4/18.
 *
 */
(function(){
    window.loginModule.
    directive('loginBox',function ($common) {
        return {
            restrict : 'AE',
            templateUrl : 'login/login-box.html',
            link:function (scope,elem,attrs) {
                //复选
                $('.remember-pwd').click(function () {
                    var checkboxId = $(this).attr('class');
                    $(this).toggleClass('checked');
                    $('#' + checkboxId).toggleClass('checked');
                })

                //判断是否支持placeholder属性
                var supportPlaceholder='placeholder'in document.createElement('input');
                placeholder= function (input) {
                    var text=input.attr('placeholder');
                    var type=input.attr('type');


                };

                //当浏览器不支持placeholder属性时，调用placeholder函数
                if(!supportPlaceholder){
                    scope.loginForm={
                        tlrNo:"请输入用户名",
                        password:"请输入密码"
                    }
                    scope.checkLogin= function(){
                        if(scope.loginForm.tlrNo=="请输入用户名" ||scope.loginForm.password=="请输入密码")
                        {
                            if(scope.loginForm.tlrNo=="请输入用户名"){
                                $common.get_tipDialog('请输入用户名','showError')
                                return true;
                            }
                            if(scope.loginForm.password=="请输入密码"){
                                $common.get_tipDialog('请输入密码','showError')
                            }
                            return true;
                        }
                    }
                    $("#pass_tex").focus(function () {
                        $(this).hide();
                        $("#pass").show().focus();
                    });
                    $("#pass").focus(function () {
                        if($(this).val()=='请输入密码'){
                            $(this).val("");
                        }
                    });

                    $("#pass").blur(function () {
                        if($(this).val()==''){
                            $(this).hide();
                            $("#pass_tex").val("请输入密码").show().addClass('phColor');
                        }
                    });
                    $('input').each(function () {
                        var text=$(this).attr("placeholder");
                        if($(this).attr("type")=="text"){
                            //placeholder($(this));
                            var defaultValue=$(this).defaultValue;
                            if(!defaultValue){
                                $(this).val(text).addClass("phColor");
                            }

                            $(this).focus(function () {
                                if($(this).val()==text){
                                    $(this).val("");
                                }
                            });

                            $(this).blur(function () {
                                if($(this).val()==''){
                                    $(this).val(text).addClass('phColor');
                                }
                            });

                            //输入字符不为灰色
                            $(this).keydown(function () {
                                $(this).removeClass('phColor');
                            });
                        }
                    });
                }
                else{
                    $("#pass_tex").remove();
                    $("#pass").show();
                }
            }
        }
    }).
    directive('forgotBox',function () {
        return {
            restrict : 'AE',
            templateUrl : 'login/forgot-box.html',
            // replace :true
        }
    }).
    directive('signupBox',function () {
        return {
            restrict : 'AE',
            templateUrl : 'login/signup-box.html',
            // replace :true
        }
    })
}())
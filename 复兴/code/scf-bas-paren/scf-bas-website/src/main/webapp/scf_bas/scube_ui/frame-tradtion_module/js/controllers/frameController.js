/**
 * Created by wubin on 2016/4/25.
 */
var frameController = function($scope,$common,$cookieStore,$cookies,$interval){
    $("#insidebar").height($(window).height()-$("#navbar").height());
    var userInfo = $scope.userInfo = JSON.parse(sessionStorage.getItem('userInfo'));
    $scope.toSideBar = function(menu,index){
        $common.get_asyncData('funcService/getLowerFunc',{funcInfoVO:menu}).then(function (res) {
            if(res.errorCode=='SUC'){
                window._sidebarTopitem_ = menu;
                $scope._index = index;
                $scope.sidebarList = res.contextData;
                if(!$scope.sidebarList || $scope.sidebarList.length==0){
                    $common.get_tipDialog("没获取到菜单数据！","showInform");
                }else {
                    $scope.creatSidebar(menu.menuCode);
                }
            }
        });
        $scope.breadcrumb=[];

    }
    Custom_tabpanel2 = function () {

        var timer = null;
        var temp = this;
        /**
         * table多标签head对象（必填）
         */
        this.headDiv = null;

        /**页签数据设置
         this.liData = [
         {title : '介绍' , content : $('#tabpanelAreaDiv1') , closeable : false },
         {title : '用法' , content : $('#tabpanelAreaDiv2') , closeable : true },
         {title : '特点及性能' , content : $('#tabpanelAreaDiv3') , closeable : true },
         {title : '历史版本及问题' , content : $('#tabpanelAreaDiv4') , closeable : true }
         ];
         */
        this.liData = new Array();

        /**
         * table多标签标题参数集合
         */
        this.defaultConfig = {
            // 页签是否支持关闭功能(低级别)
            closeable : false,
            // 页签的方位设置,目前提供2种['top', 'bottom']（暂时不支持）
            position : 'top',
            // 滚动按钮的布局[true:右侧显示(默认) | false:两边显示]（暂时无滚动条）
            layout : true,
            // 默认div模式，[iframe,div]
            panelType : 'div',
            // 页签是否为异步处理(针对url的功能是否做异步处理，如果panelType=div则只能同步处理)
            // 如果false则加载速度很慢，建议异步加载
            asyn : true,
            // 默认显示的页签数[0开始]
            showNum : 0
        };

        /**
         * 初始化ul样式
         */
        this.initHeadDiv = function() {
            // STEP-1 初始化tabs的栏目
            var hDiv = '<ul style="margin: 0 0 10px;">';
            for(var i = 0 ; i < this.liData.length ; i ++) {
                var tLi = this.liData[i];
                var closeEventHtml = '';
                if(this.defaultConfig.closeable && tLi.closeable) {
                    closeEventHtml = '<span target="' +i+ '" class="tabpanel_close" ></span>';
                }
                if(this.defaultConfig.showNum == i) {
                    hDiv += '<li target="' +i+ '" ><a target="' +i+ '" class="hover" title="'+tLi.title+'" >' +tLi.title+closeEventHtml+ '</a></li>';
                    tLi.content.show();
                    // 如果是iframe，需要显示加载
                    if(this.defaultConfig.panelType == 'iframe' ) {
                        tLi.content.prop('src', tLi.url);
                    }
                } else {
                    hDiv += '<li target="' +i+ '" ><a target="' +i+ '"  title="'+tLi.title+'">' +tLi.title+closeEventHtml+ '</a></li>';
                    tLi.content.hide();
                    // 如果是iframe，且又是要求所有panel同步设置，需要隐藏加载
                    if(this.defaultConfig.panelType == 'iframe' && this.defaultConfig.asyn == false) {
                        tLi.content.prop('src', tLi.url);
                    }
                }
            }
            hDiv += '</ul>';
            this.headDiv.html(hDiv);
            // STEP-2 初始化栏目的事件
            var thisObj = this;
            this.headDiv.find('li').mouseenter(function() {
                $(this).find('span').show();
            }).mouseleave(function() {
                $(this).find('span').hide();
            });
            this.headDiv.find('li span').click(function() {
                thisObj.selectCloseEvent($(this));
            });
            this.headDiv.find('li a').click(function() {
                thisObj.selectLiEvent($(this),'lia');
            });
            //libo update
            this.headDiv.find('li a').mousedown(function (ev) {
                ev.preventDefault();
                if(ev.which==3){
                    //alert(3333333333)
                }
            })
        }

        /**
         * 选择删除栏目的触发的事件
         */
        this.selectCloseEvent = function(spanObj) {
            var index = spanObj.attr('target');
            //alert('selectClose' +index);
            var tArea = this.liData[index];
            // STEP-1 删除页面的中的tabpanel
            tArea.content.hide();
            tArea.content.attr('src','');
            // STEP-2 删除liData的中的tabpanel数据
            this.liData[index] = null;
            // STEP-3 如果删除的panel正好是当前打开的tabpanel，
            // 需要调整展示到相邻的左边tabpanel，如果是首个需要展示到第二个tabpanel
            if(index == this.defaultConfig.showNum) {

                var nextLi = spanObj.parent().parent().next();
                if(nextLi.length > 0 ) {
                    if(arguments[1]=='noLia'){
                        this.selectLiEvent(nextLi.find('a'));
                    }else {
                        this.selectLiEvent(nextLi.find('a'),'lia');
                    }
                } else {
                    var prevLi = spanObj.parent().parent().prev();
                    if(prevLi.length > 0) {
                        if(arguments[1]=='noLia'){
                            this.selectLiEvent(prevLi.find('a'));
                        }else {
                            this.selectLiEvent(prevLi.find('a'),'lia');
                        }
                    }else{
                        //////////////////////响应面包屑breadcrumb  add by wubin 2016.10.11
                        $scope.breadcrumb=[];
                        if(arguments[1]!=='noLia'){
                            $scope.$apply();
                        }
                    }
                }
            }

            //设置headDiv的隐藏显示
            var aaa;
            for (var j=0;j<this.liData.length;j++){
                if(this.liData[j]){aaa=true}
            }
            if(!aaa){
                this.headDiv.height(0);
            }
            // STEP-4 删除页面元素li
            spanObj.parent().parent().remove();
            this.resetLiWidth("menus");
        }

        /**
         * 选择栏目的触发的事件
         */
        this.selectLiEvent = function(liA) {
            var index = liA.attr('target');
            //alert('selectLi' +index);
            if(this.liData[index]) {

                //////////////////////响应面包屑breadcrumb  add by wubin 2016.10.11
                if(typeof $scope.bread =='function'){
                    $scope.breadcrumb=[];
                    $scope.bread(this.liData[index].item);
                    $scope.breadcrumb.reverse();
                    //$scope.refreshBreadcrum(this.liData[index].item);
                    if(arguments[1]!=undefined && arguments[1]=='lia'){
                        //console.log('lia')
                        $scope.$apply();
                    }
                }

                this.headDiv.find('li a').removeClass("hover");
                liA.addClass("hover");
                // STEP-1 隐藏页面的tabpanel
                for(var i = 0 ; i < this.liData.length ; i ++) {
                    if(this.liData[i]) {
                        this.liData[i].content.hide();
                    }
                }
                // STEP-2 显示页面的tabpanel
                this.liData[index].content.show();
                if(this.defaultConfig.panelType == 'iframe' && this.defaultConfig.asyn == true) {
                    var liUrl = this.liData[index].content.attr('src');
                    if(null == liUrl || '' == liUrl || !liUrl) {
                        var _url = this.liData[index].url;
                        this.liData[index].content.prop('src',_url);
                    }
                }
                this.defaultConfig.showNum = parseInt(index);
            }
        }

        /**
         * 动态打开一个tabpanel，按照从0开始的序列展示
         */
        this.showLiFun = function(showNum) {
            // 选择栏目的触发的事件
            this.selectLiEvent(this.headDiv.find('li a[target=' +showNum+ ']') );
        }

        this.showLiFunByUrl = function(url) {
            var showNum;
            for(var i = 0 ; i < this.liData.length ; i ++) {
                var tLi = this.liData[i];
                if(null != tLi && tLi.url == url) {
                    showNum = i;
                }
            }
            if( typeof showNum !== "undefined"){
                this.selectLiEvent(this.headDiv.find('li a[target=' +showNum+ ']') );
            }
        }

        /**
         * 根据title名称找到Li所在的index
         */
        this.getFrameNumFun = function(title) {
            // 选择栏目的触发的事件
            for(var i = 0 ; i < this.liData.length ; i ++) {
                var tLi = this.liData[i];
                if(null != tLi && tLi.title == title) {
                    return i;
                }
            }
            return null;
        }

        /**
         * 刷新Iframe（根据iframe的序列，从0开始）
         */
        this.reloadIframePage = function(num) {
            if(null == num) {
                for(var i = 0 ; i < this.liData.length ; i ++) {
                    var tLi = this.liData[i];
                    tLi.content.prop('src', tLi.url);
                }
            } else {
                for(var i = 0 ; i < this.liData.length ; i ++) {
                    var tLi = this.liData[i];
                    if(null != tLi && i == num) {
                        tLi.content.prop('src', tLi.url);
                        return;
                    }
                }
            }
        }

        /**
         * 动态添加一个tabpanel
         */
        this.addLiFun = function(liObj) {
            // STEP-1 添加页面的中的tabpanel
            liObj.content.hide();
            // 如果是iframe，且又是要求所有panel同步设置，需要隐藏加载
            //if(this.defaultConfig.panelType == 'iframe' && this.defaultConfig.asyn == false ) {
            //    liObj.content.prop('src', liObj.url);
            //}
            //判断是否存在tab li
            var arrayIndex=-1;
            for (var i=0;i<this.liData.length;i++){
                if(this.liData[i] && this.liData[i].url == liObj.url){
                    arrayIndex = i;
                    break;
                }
            }

            if(arrayIndex!==-1){
                this.selectCloseEvent(this.headDiv.find('li span[target=' +arrayIndex+ ']'),'noLia');
                this.liData[arrayIndex] = liObj;
                //return arrayIndex;
            }else{
                // STEP-2 添加liData的中的tabpanel数据
                arrayIndex = this.liData.push(liObj) - 1;	// 从0开始计算
            }

            // STEP-3 添加页面元素li
            var closeEventHtml = '';
            if(this.defaultConfig.closeable && liObj.closeable) {
                if(liObj.item.menuCode=="default_main"){//主页禁止关闭
                    closeEventHtml = '<div class="seperate"></div>';
                }else {
                    closeEventHtml = '<span target="' +arrayIndex+ '" class="tabpanel_close" ></span><div class="seperate"></div>';
                }
            }
            this.headDiv.find('ul').prepend('<li target="' +arrayIndex+ '"  name="'+liObj.item.menuCode+'"><a target="' +arrayIndex+ '" title="'+liObj.title+'" >' +liObj.title+closeEventHtml+ '</a></li>');
            var main  =this.headDiv.find('ul li[name=default_main]');
            if(main.length==1){//主页置顶
                this.headDiv.find('ul').prepend(main)
            }
            // STEP-4 添加页面元素li事件
            var thisObj = this;
            this.headDiv.find('li[target=' +arrayIndex+ ']').mouseenter(function() {
                $(this).find('span').show();
            }).mouseleave(function() {
                $(this).find('span').hide();
            });
            this.headDiv.find('li span[target=' +arrayIndex+ ']').click(function() {
                thisObj.selectCloseEvent($(this));
            });
            this.headDiv.find('li a[target=' +arrayIndex+ ']').click(function() {
                var liThis = this;
                clearTimeout(timer);
                timer = setTimeout(function(){
                    thisObj.selectLiEvent($(liThis),'lia');
                },300);
            });
            this.headDiv.find('li a[target=' +arrayIndex+ ']').dblclick(function(event) {
                event.stopPropagation();
                clearTimeout(timer);//在双击事件中，先清除前面单击事件的时间处理
                var spanElem = temp.headDiv.find('li span[target=' +arrayIndex+ ']');
                thisObj.selectCloseEvent(spanElem);
            });
            //libo update tabpanel右击
            this.headDiv.find('li a[target=' +arrayIndex+ ']').mousedown(function (event) {
                var liObject=this;
                if(event.which=='3'){
                    var kyoPopMenu={};
                    kyoPopMenu=(function () {
                        return{
                            sys: function (obj) {
                                $('.popup_menu').remove();
                                popupMenuApp=$('<div class="popup_menu app-menu"><ul>' +
                                    '<li><a meun="menu1">关闭所有</a></li>' +
                                    '<li><a meun="menu2">关闭其他</a></li>' +
                                    '</ul></div>')
                                    .find('a').attr('herf','javascript:;')
                                    .end().appendTo(liObject.parentElement);
                                //绑定事件
                                var spanArrObj=thisObj.headDiv.find('li span[target]');
                                var deleteSpan=thisObj.headDiv.find('li span[target=' +arrayIndex+ ']');
                                $('.app-menu a[meun="menu1"]').on('click', function () {
                                    for(var i=0;i<spanArrObj.length;i++){
                                        thisObj.selectCloseEvent($(spanArrObj[i]));
                                    }
                                });
                                $('.app-menu a[meun="menu2"]').on('click', function () {
                                    var spanArr=jQuery.makeArray(spanArrObj);//jquery对象转数组
                                    if(spanArr.length==1){
                                        thisObj.selectCloseEvent(deleteSpan);
                                    }
                                    var index=spanArr.indexOf(deleteSpan[0]);
                                    spanArrObj.splice(index,1);//剔除当前项
                                    for(var i=0;i<spanArrObj.length;i++){
                                        thisObj.selectCloseEvent($(spanArrObj[i]));
                                    }
                                });
                                return popupMenuApp;
                            }
                        }
                    })();
                    var liObj=temp.headDiv.find('li a[target=' +arrayIndex+ ']');
                    //取消右击事件
                    $('html').click(function () {
                        $('.popup_menu').hide();
                    });
                    //重新定义右击事件
                    liObj.on('contextmenu', function (e) {
                        var popupmenu=kyoPopMenu.sys();
                        I=($(document).width()- e.clientX)<popupmenu.width()?(e.clientX-popupmenu.width()): e.clientX;
                        T=($(document).height()- e.clientY)<popupmenu.height()?(e.clientY-popupmenu.height()): e.clientY;
                        popupmenu.css({left:I,top:T}).show();
                        return false;
                    })
                }
            });


            //设置headDiv的隐藏显示
            var aaa;
            for (var j=0;j<this.liData.length;j++){
                if(this.liData[j]){aaa=true}
            }
            if(aaa){
                this.headDiv.height(40);
            }
            this.resetLiWidth("plus");
            return arrayIndex;
        }

        /**
         * 动态改变tabpanel的width长度
         */
        this.resetLiWidth = function(type){
            var liDataLength = this.getLiLength();
            var liWidth = this.headDiv.find('li').width();
            var headDiv = this.headDiv.width();
            if(type=="menus"){
                if(liWidth < 100){
                    liWidth = parseInt(headDiv)/parseInt(liDataLength);
                    this.headDiv.find('li').width(liWidth);
                }
            }
            else if(type=="plus"){
                var compare = parseInt(headDiv)-parseInt(liDataLength*liWidth);
                if(compare < 0 ){
                    liWidth = parseInt(headDiv)/parseInt(liDataLength);
                    this.headDiv.find('li').width(liWidth);
                }
            }
            //alert(liDataLength+"+++"+liWidth+"+++"+headDiv)
        }

        /**
         * 动态删除一个tabpanel
         */
        this.deleteLiFun = function(title) {
            // STEP-1 liData中遍历出的tabpanel
            for(var i = 0 ; i < this.liData.length ; i ++) {
                if(this.liData[i] && this.liData[i].title == title) {
                    // 选择删除栏目的触发的事件
                    this.selectCloseEvent(this.headDiv.find('li span[target=' +i+ ']') );
                    return;
                }
            }
        }

        /**
         * pannel page
         */
        this.getLiLength = function() {
            return this.headDiv.find('li').length;
        }

        /**
         * get LiData Length
         */
        this.getLiDataLength = function() {
            return this.liData.length;
        }

        /**
         * 参数配置
         */
        this.init = function(tParam) {
            this.headDiv = tParam['headDiv'];

            jQuery.extend(this.defaultConfig, tParam['config']);

            if(tParam['data']) {
                this.liData = tParam['data'];
            }
            //设置headDiv的隐藏显示
            var aaa;
            for (var j=0;j<this.liData.length;j++){
                if(this.liData[j]){aaa=true}
            }
            if(aaa){
                this.headDiv.height(40);
            }else {
                this.headDiv.height(0);
            }
            // 初始化ul样式
            this.initHeadDiv();
        }
    }

    $scope.cTabpanelFrame = new Custom_tabpanel2();
    $scope.cTabpanelFrame.init({
        headDiv: $('#iframeHeadDiv'), // 每次加载必填
        config: {
            closeable: true,
            panelType: 'iframe',
            //默认显示的页签数[0开始]
            showNum: 0
        },
        data: [ // 每次加载必填
            //{title: '我的主页', content: $('#mainIframe'),closeable: false}
        ]
    });
    //退出登陆
    $scope.loginOut= function () {
        promise = $common.get_asyncData('loginService/logout',{funcInfoVO:{}});
        promise.then(function (res) {
            if(res.errorCode=='SUC'){
                sessionStorage.clear();
                $common.get_asyncData('loginService/logout',{funcInfoVO:{}}).then(function(res){
                    location.href= '../../index.html';
                });//再次调用走401状态
            }
        });
    };
    //登陆名
    $scope.userName =userInfo.tlrName;
    //获取系统时间
    var mytimeInt;
    var getSystime = function(){
        $common.get_asyncData("sysTimeService/selectSystemTime").then(function(res){
            if(res.errorCode=="SUC"){
                var timestamp = parseInt(res.contextData.value);
                //立即设置系统时间
                //$scope.myTime = new Date(timestamp).toLocaleString().replace(/\//g,"-")
                $scope.myTime = new Date(timestamp).toLocaleDateString();
                //每隔1秒循环系统时间(label)
                //mytimeInt = $interval(function () {
                //    timestamp+=1000;
                //    $scope.myTime = new Date(timestamp).toLocaleString().replace(/\//g,"-")
                //},1000);

            }
            //else {
            //    //本地时间
            //    //$scope.myTime=new Date().toLocaleString();
            //    $common.get_tipDialog(res.errorMsg||'获取系统时间失败！','showError')
            //}
        })
    }
    getSystime();
    //每隔5分钟更新系统时间
    $interval(function () {
        //取消label
        //$interval.cancel(mytimeInt)
        getSystime();
    },7200000);
};

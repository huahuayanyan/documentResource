/**
 * Created by wubin on 2016/10/27.
 */
(function(){
    angular.module('autoTree',['common']).
    filter('autotreeFilt',function(){
        return function (input,tdObj,dicArr){
            var tdVal;
            if(tdObj.dictionary && dicArr.length==1){
                input = dicArr[0].dataTrsVal
            }
            switch(tdObj.type){
                case 'date':date();break;
            }
            function date(){
                if(typeof input == 'string' && input.length==8 && input.indexOf('-')==-1)
                {input = input.substr(0,4)+"-"+input.substr(4,2)+"-"+input.substr(6,2);}
                else if(input ==null||input ==undefined||input =="null"||input =="undefined")
                {input = "";}
                else {throw Error("date:"+input+":格式有误  正确格式char8:yyyymmdd");}
            }
            tdVal = input;
            return tdVal;
        }
    }).
    directive('htAutotree', function($common,$compile){
        var linkFunc = function (scope, element, attrs) {

            /**
             * Row的点击样式公共方法
             */
            scope.initChooseColor = function(rowDiv) {
                element.find('div[tR]').removeClass('cFC').addClass("dFC");
                rowDiv.addClass("cFC");	// 行选择后字体变样式
            }
            /**
             * Row的点击事件
             */
            scope.initChooseEvent = function(rowDiv) {
                if(scope.option.customFun) {
                    var vId = rowDiv.attr("value");
                    if(vId == scope.option.headNode['treeId'] ) {
                        scope.option.customFun(scope.option.headNode );
                    } else {
                        for (var i = 0 ; i < scope._allChildNode.length ; i++ ) {
                            var everyChild = scope._allChildNode[i];
                            if(vId == everyChild['treeId']) {
                                scope.option.customFun(everyChild );
                                break;
                            }
                        }
                    }
                }
            }
            /**
             * 判断是否展示checkbox的框
             */
            scope.isShowCheckBox = function(node) {
                if(scope.option.isCheckBox) {
                    if(scope.option.showBoxFun) {
                        return scope.option.showBoxFun(node);
                    }
                    return true;
                } else {
                    return false;
                }
            }

            /**
             * 自定义树
             */
            var CustomAsynchTree = function() {

                /**
                 * 添加一个节点
                 */
                this.addNode = function(node) {
                    // STEP-1 新的节点数据保存在页面的队列中
                    this.allChildNode.push(node);
                    var fId = node['fId'];
                    // STEP-2 更新父节点的图片样式
                    var tempDiv = this.cTreeDiv.find('div[tR=' +fId+ ']');
                    var tImgs = tempDiv.find('img');
                    var nextDiv = tempDiv.next();
                    tImgs[0].src = this.openNPic;
                    tImgs[1].src = this.openPic;
                    nextDiv.show();
                    // STEP-3 更新父节点的下的子节点页面显示
                    var nDiv = this.cTreeDiv.find('div[tR=tD' +fId+ ']');
                    nDiv.children().remove();
                    var tHtml = this.getNodeHtml(fId);
                    if('' != tHtml) {
                        nDiv.append(tHtml);
                        this.initCustomEvent(nDiv);	//初始化添加的事件
                    }
                }

                /**
                 * 删除一个节点
                 */
                this.deleteNode = function(node) {
                    var nId = node['nId'];
                    // STEP-1 在队列中中删除的节点数据
                    for (var i = 0 ; i < this.allChildNode.length ; i ++ ) {
                        var tempNode = this.allChildNode[i];
                        if(nId == tempNode['nId']) {
                            this.allChildNode.splice(i,1);
                            break;
                        }
                    }
                    // STEP-2 页面删除该节点
                    var tempDiv = this.cTreeDiv.find('div[tR=' +nId+ ']');
                    tempDiv.remove();
                    tempDiv.next().remove();
                }

                /**
                 * 修改一个节点
                 */
                this.updateNodeName = function(node) {
                    var nId = node['nId'];
                    // STEP-1 在队列中修改的节点名称
                    for (var i = 0 ; i < this.allChildNode.length ; i ++ ) {
                        var tempNode = this.allChildNode[i];
                        if(nId == tempNode['nId']) {
                            tempNode['name'] = node['name'];
                            break;
                        }
                    }
                    // STEP-2 修改页面节点名称
                    this.cTreeDiv.find('span[value=' +nId+ ']').text(node['name']);
                }

            }

            /**
             * 初始化CheckBox勾选的事件
             */
            scope.initCheckBoxEvent = function(cBox) {
                var cBoxVal = cBox.attr('value');
                //var isChoose = cBox.attr('checked');几种判断选中的方法
                //var isChoose = cBox[0].checked;
                //var isChoose = cBox.is(':checked');
                var isChoose = cBox.prop('checked');
                if(scope.option.isAutoSelect) {
                    if(isChoose) {
                        // 1-父节点全部勾选
                        //element.find('input[value=' +cBoxVal+ ']').prop('checked',true);
                        cBox.prop('checked',true);
                        var fId = cBox.parent().attr('ftR');
                        while(fId) {
                            var fCBox = element.find('input[value=' +fId+ ']');
                            fCBox.prop('checked',true);
                            fId = fCBox.parent().attr('ftR');
                        }
                        // 2-子节点全部勾选
                        //element.find('div[tR=tD' +cBoxVal+ ']').find('input[name=treeBox]').prop('checked',true);
                        cBox.parent().next().find('input[name=treeBox]').prop('checked',true);
                        initSelectNodeData(cBoxVal);	// 勾选节点的数据集
                    } else {
                        // 1-子节点全部取消勾选
                        element.find('div[tR=tD' +cBoxVal+ ']').find('input[name=treeBox]').removeAttr('checked');
                        initCancelNodeData(cBoxVal);	// 取消勾选节点的数据集
                    }
                }
                getSelectedArrayWithId();
                boxEventByOut(cBoxVal,isChoose);
            }
            /**
             * checkbox勾选和取消的事件（外部扩展）
             * vId:checkbox的value值
             * isSelect:true勾选false取消
             */
            var boxEventByOut = function(vId,isSelect) {
                if(scope.option.boxEventFun) {
                    if(vId == scope.option.headNode['treeId'] ) {
                        scope.option.boxEventFun(scope.option.headNode, isSelect);
                    } else {
                        for (var i = 0 ; i < scope._allChildNode.length ; i++ ) {
                            var everyChild = scope._allChildNode[i];
                            if(vId == everyChild['treeId']) {
                                scope.option.boxEventFun(everyChild ,isSelect);
                                break;
                            }
                        }
                    }
                }
            }
            /**
             * 勾选节点的数据集
             * 待扩展
             */
            var initSelectNodeData = function(cBoxVal){

            }
            /**
             * 取消勾选节点的数据集
             * 待扩展
             */
            var initCancelNodeData = function(cBoxVal){

            }
            /**
             * 获取选择的复选框的值
             */
            var getSelectString = function() {
                scope.option.selectCBox = '';
                var selectedArray = element.find("input[name=treeBox]:checked");
                for(var i = 0 ; i < selectedArray.length ; i ++ ) {
                    if(scope.option.headNode.treeId != selectedArray[i].value){
                        scope.option.selectCBox += selectedArray[i].value + ',';
                    }
                }
                //scope.option.selectCBox = scope.option.selectCBox.replace(scope.option.headNode.treeId+"," , "");	// 去除首节点
                if(scope.option.selectCBox.length > 0) {
                    scope.option.selectCBox = scope.option.selectCBox.substring(0,scope.option.selectCBox.length - 1);
                }
                return scope.option.selectCBox;
            }
            /**根据ID获取选择字符串*/
            var getSelectedArrayWithId = function(){
                getSelectString();
                scope.option.selectCBoxArrWithId = scope.option.selectCBox.split(",")
                return scope.option.selectCBoxArr;
            };
            /**
             * 获取选择的复选框对象
             */
            var getSelectedArrayWithNode = function() {
                getSelectString();
                var selArray = new Array();
                var fSelCBox = ',' +scope.option.selectCBox+ ',';
                for (var i = 0 ; i < scope._allChildNode.length ; i++ ) {
                    var everyChild = scope._allChildNode[i];
                    if( fSelCBox.indexOf(','+everyChild['treeId']+',') != -1) {
                        selArray.push(everyChild);
                    }
                }
                scope.option.selectCBoxArrWithNode = selArray;
                return selArray;
            }


            /**
             * 初始化RowImg事件
             */
            scope.initRowNodeEvent = function(imgObj) {
                var fDiv = imgObj.parent();
                var tImgs = fDiv.find('img');
                var nextDiv = fDiv.next();
                var tLPic = scope.option.lastPic.replace(scope.option.dPicUrl,'');
                if (tImgs[1].src.indexOf(tLPic) == -1) {	//目录节点不是最后一级
                    if(nextDiv.css('display') == 'none' ) {	// 子节点没有显示,需要显示
                        if(buildChildNode(nextDiv)){
                            tImgs[0].src = scope.option.openNPic;
                            tImgs[1].src = scope.option.openPic;
                            nextDiv.show();
                        }else {
                            tImgs[0].src = scope.option.openNPic;
                            tImgs[1].src = scope.option.lastPic;
                        }
                    } else {	// 子节点已显示,需要隐藏
                        tImgs[0].src = scope.option.closedNPic;
                        tImgs[1].src = scope.option.closedPic;
                        nextDiv.hide();
                    }
                }
                //this.initChooseColor(fDiv);
            }
            /**
             * 修建子节点的层级，根据父节点fId
             * 返回值：是否最后节点
             */
            var buildChildNode = function(nDiv) {
                if(nDiv.children().length < 2) {	// 如果没有子节点需要加载子节点
                    var fId = nDiv.attr('tR').replace('tD','');
                    if(scope.option.async){
                        // STEP-1 根据fId删除容器中子节点
                        //removeNode(fId);
                        // STEP-2 异步查询子节点
                        var url = scope.option.url ||'';
                        var param ={fId:fId};
                        //if(typeof $scope.option.queryObj =='object'){
                        //    $scope.option.queryObj.fId=fId;
                        //    param = $scope.option.queryObj;
                        //}
                        $common.get_asyncData(url,param).then(function(resp){
                            if(resp.contextData.length>0){
                                var nodes;
                                if(scope.option.dataFilter){
                                    nodes =scope.option.dataFilter(resp.contextData);
                                }else{
                                    nodes =resp.contextData;
                                };
                                // STEP-3 子节点保存在容器中
                                scope._allChildNode = scope._allChildNode.concat(nodes);
                                //pushNode(fId,nodes);
                                buildAllChildNode(fId,nodes);
                                return true;
                            }else {
                                return false;
                            }
                        });
                    }else{
                        return true;
                    }
                }else {
                    return true;
                }
            }
            /**
             * 写树的html信息
             */
            var buildAllChildNode = function(fatherId ,nodes) {
                // STEP-1 写树下所有节点的html
                var everyChild = '';
                var tempHtml = '';
                if(null != nodes) {
                    for (var i = 0 ; i < nodes.length ; i++ ) {
                        everyChild = nodes[i];
                        tempHtml += '<div tR="' +everyChild['treeId']+ '" ftR="' +everyChild['treeParentId']+ '" class="commonRow dFC">'
                        //是否异步
                        if(!scope.option.isAllShow){
                            if(!scope.option.async){
                                if(everyChild.hasChilds){
                                    tempHtml += '<img src="' +scope.option.closedNPic+ '"/><img src="' +scope.option.closedPic+ '"/>';
                                }else {
                                    tempHtml += '<img src="' +scope.option.openNPic+ '"/><img src="' +scope.option.lastPic+ '"/>';
                                }
                            }
                            else {
                                tempHtml += '<img src="' +scope.option.closedNPic+ '"/><img src="' +scope.option.closedPic+ '"/>';
                            }
                        }else {
                            if(!scope.option.async){
                                if(everyChild.hasChilds){
                                    tempHtml += '<img src="' +scope.option.openNPic+ '"/><img src="' +scope.option.openPic+ '"/>';
                                }else {
                                    tempHtml += '<img src="' +scope.option.openNPic+ '"/><img src="' +scope.option.lastPic+ '"/>';
                                }
                            }
                            else {
                                if(everyChild.hasChilds){
                                    tempHtml += '<img src="' +scope.option.openNPic+ '"/><img src="' +scope.option.openPic+ '"/>';
                                }else {
                                    tempHtml += '<img src="' +scope.option.closedNPic+ '"/><img src="' +scope.option.closedPic+ '"/>';
                                }
                            }
                        }
                        //是否展示复选框
                        if(scope.isShowCheckBox(everyChild) ){
                            if(everyChild.isChecked) {
                                scope.option.selectCBox += everyChild.treeId + ',';
                                tempHtml += '<input type="checkbox" name="treeBox" value="' +everyChild['treeId']+ '" checked="checked" /><span value="' +everyChild['treeId']+ '">' +everyChild['treeName'];
                            } else {
                                tempHtml += '<input type="checkbox" name="treeBox" value="' +everyChild['treeId']+ '"/><span value="' +everyChild['treeId']+ '">' +everyChild['treeName'];
                            }
                        }
                        else {
                            tempHtml += '<span value="' +everyChild['treeId']+ '">' +everyChild['treeName'];
                        }
                        tempHtml += '</span></div><div tR="tD' +everyChild['treeId']+ '" ftR="' +everyChild['treeParentId']+ '" class="pl10" ng-style="tDStyle"></div>';
                    }
                    if(tempHtml != ''){
                        if(scope.option.selectCBox.length > 0) {//控制selectCBox的值
                            scope.option.selectCBox = scope.option.selectCBox.substring(0,scope.option.selectCBox.length - 1);
                        }
                        var firstNodeTD = element.find('div[tR=tD' + fatherId + ']');
                        firstNodeTD.empty().append($compile(tempHtml)(scope));
                        firstNodeTD.show();
                        getSelectedArrayWithNode();
                        // STEP-2 修建所有节点的层级
                        var everyChild = '';
                        for (var i = 0 ; i < nodes.length ; i++ ) {
                            everyChild = nodes[i];
                            if('' != everyChild['treeParentId']) {
                                element.find('div[ftR=' +everyChild['treeParentId']+ ']').appendTo(element.find('div[tR=tD' +everyChild['treeParentId']+ ']'));	// node节点按层级移位
                            }
                        }
                    }
                }
            }
            /**
             * 初始化事件
             */
            var initEvent = function() {
                //this.removeAllSelectBox();
                element.on('click','img',function() {
                    scope.initRowNodeEvent($(this));
                });
                element.on('click','div[class^=commonRow]',function() {
                    scope.initChooseColor($(this));
                });
                if(scope.option.isClickRow) {
                    element.on('click','div span',function() {	// 加入点击文字事件
                        scope.initChooseEvent($(this));
                    });
                }
                if(scope.option.isCheckBox || scope.option.isAutoSelect) {	// 加入CheckBox复选框后，自动勾选才有效
                    element.on('click','input[name=treeBox]',function() {
                        scope.initCheckBoxEvent($(this));
                    });
                }
            }

            var init = function(){
                initEvent();
                scope.$watchCollection('option.allChildNode', function(newValue, oldValue){
                    scope._allChildNode =  scope.option.allChildNode.filter(function(){
                        return true;
                    });
                    if(!scope.option.async || scope.option.isAllShow){
                        hasChildsFlag(scope._allChildNode);
                    }
                    //第一层节点树
                    buildAllChildNode(scope.option.headNode.treeId,scope._allChildNode);
                });
            };
            var hasChildsFlag = function(childNodes){
                for(var i=0;i<childNodes.length;i++){
                    for(var j=0;j<childNodes.length;j++){
                        if(childNodes[i].treeId==childNodes[j].treeParentId){
                            childNodes[i].hasChilds = true;
                            break;
                        }
                    }
                }
            }
            init();
        }
        return {
            restrict: 'E',
            scope: {
                option:"="
            },
            controller:["$scope","$compile",function($scope,$compile){
                /**
                 * 初始化树对象数据
                 * 主入口方向（START）
                 */
                $scope.option = $scope.option?$scope.option:{};
                $scope.option.isCheckBox = $scope.option.isCheckBox || false;	// 是否加入CheckBox复选框
                $scope.option.isClickRow = $scope.option.isClickRow || false;	// 是否点击行触发事件
                $scope.option.isAllShow = $scope.option.isAllShow  || false;	// 是否打开全部节点（异步树，此值不能随意修改）
                $scope.option.async = $scope.option.async || false;//是否异步查询树
                //$scope.option.queryObj = $scope.option.queryObj || {};//是否异步查询树
                $scope.option.selectCBox = $scope.option.selectCBox?$scope.option.selectCBox:'';	// 选中的值，以逗号隔开
                $scope.option.isAutoSelect = $scope.option.isAutoSelect || false;	// 是否自动勾选父子级关系
                $scope.option.headNode = $scope.option.headNode || {treeId: 0,treeName: '首节点'};	// 首目录节点
                $scope.option.allChildNode = $scope.option.allChildNode ||[];	// 首目录下所有的子节点
                //$scope.option.firstNodeId = $scope.option.firstNodeId || '0';	// 首节点的nodeId(默认-1，可以不是-1)
                $scope.option.customFun = $scope.option.customFun || null; // 自定义文字点击函数
                $scope.option.boxEventFun = $scope.option.boxEventFun || null; // 自定义checkbox点击函数
                $scope.option.queryNodeFun = $scope.option.queryNodeFun || null;	// 查询子节点的函数（必须实现）
                $scope.option.showBoxFun = $scope.option.showBoxFun || null; // 自定义是否展示checkbox复选框
                $scope.option.dPicUrl = $scope.option.dPicUrl || '../../scube_ui/lib/plugins/tree/images/';	// 默认图片路径$scope.option.openNPic = 'Minus.gif';
                $scope.option.openNPic = $scope.option.dPicUrl + 'Minus.gif';
                $scope.option.openPic = $scope.option.dPicUrl+ 'K.gif';
                $scope.option.closedNPic = $scope.option.dPicUrl+'Plus.gif';
                $scope.option.closedPic = $scope.option.dPicUrl+'J.gif';
                $scope.option.lastPic = $scope.option.dPicUrl+'Y.gif';
                $scope.tDStyle = $scope.option.isAllShow ? '' : {"display": "none"};
            }],
            template:
            '<div>'+
            //'<div tR="{{option.headNode.treeId}}" class="commonRow dFC">'+
            //'<img ng-src="{{option.openNPic}}"/><img ng-src="{{option.openPic}}"/>'+
            //'<input ng-if="option.isCheckBox" type="checkbox" name="treeBox" value="{{option.headNode.treeId}}"/>' +
            //'<span value="{{option.headNode.treeId}}" ng-bind="option.headNode.treeName"></span>'+
            //'</div>' +
            '<div tR="{{\'tD\'+option.headNode.treeId}}" class="pl10" ng-style="tDStyle"></div>' +
            '</div>',
            link:linkFunc,
            replace:true
        };
    })
}());
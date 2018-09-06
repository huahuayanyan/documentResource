/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/5/13
 */
(function () {
	angular.module('components',[]).
		config(function ($compileProvider,$provide) {
			$compileProvider.
				directive("myTransclude", function() {
					return {
						restrict :"A",
						link: function(scope, element, attrs, controller) {
							// create a scope for the transclusion,
							scope.transcludeScope = scope.parentScope.$new();
							scope.transcludeScope.$index = scope.$index;
							scope.transcludeScope.$first = scope.$first;
							scope.transcludeScope.$middle = scope.$middle;
							scope.transcludeScope.$last = scope.$last;
							scope.transcludeScope.$odd = scope.$odd;
							scope.transcludeScope.$even = scope.$even;
							scope.$on('$destroy', function() {
								scope.transcludeScope.$destroy();
							});

							scope.$mytransclude(scope.transcludeScope, function(clone) {
								element.empty();
								element.append(clone);
							});
						}
					};
				}).
				directive('htLegend',function(){
				return {
					restrict :"EA",
					scope:{},
					transclude:true,
					template :'<div class="legend"></div>',
					controller:function($scope,$compile,$interpolate){
						var html =
							'<div class="legendSpan" ng-class={"borderBottomOrangered":orangered,"borderBottomLawngreen":lawngreen}>' +
							'<div class="legendText" my-transclude></div>' +
							'<div class="legendPlot" ng-class={"borderOrangered":orangered,"borderLawngreen":lawngreen}></div>' +
							'</div>';
						$scope.parentScope = $scope.$parent;
						this.template = $compile(html);
					},
					compile:function(elem, attrs){
						return function(scope,elem,attrs,mycontroller,childTranscludeFn){
							scope.orangered = false;
							scope.lawngreen = false;
							if(attrs.colorid=='orangered'){
								scope.orangered = true;
							}else if(attrs.colorid=='lawngreen'){
								scope.lawngreen = true;
							}

							//Rendering template for a root node
							mycontroller.template( scope, function(clone) {
								elem.html('').append( clone );
								scope.$mytransclude = childTranscludeFn;
							});
						}
					},
					replace :true
				}
			}).
				directive('htForm',function(){
					return {
						restrict:'E',
						scope:{
							columns :"@"
						},
						transclude:true,
						template:
                        '<form class="myForm clearfix" ' +
						'ng-class="{\'myForm1\':column1,\'myForm3\':column3}">' +
				        '<div ng-transclude style="font-size: 0;"></div>' +
				        '</form>',
                        controller :function($scope){
							$scope.column1=false;
							$scope.column3=false;
							if ($scope.columns){
								if($scope.columns=="1"){
									$scope.column1=true;
								}else if($scope.columns=="3"){
									$scope.column3=true;
								}
							}
                        },
						replace:true
					}
				}).
			    directive('htInput',function($common,$timeout){
				return {
					restrict:'E',
					require:'?ngModel',
					scope:{
						name :"@",
						htId :"@",
						regExp :"@",
						hide :"@",
						editType:'@',
						disable:'@'
					},
					template:
					'<label ng-class={"input-date":date,"input-time":time}  ng-show="!hide || hide==\'false\'">' +
					'<span class="span"><b ng-if="_regExp" style="color: red;">*</b>{{name}}</span>' +

					//兼容ie8 不可直接改变input type属性
					'<input ng-if="!editType||editType==\'text\'||editType==\'date\'||editType==\'time\'||editType==\'datetime\'||editType==\'currency\'" class="input" id="{{htId}}" type="text" ng-disabled="disable&&disable!==\'false\'"' +
					' ht-event-listence placeholder="{{expMsg}}" ng-model="input.tempModel" reg-string="{{regExp}}"/>' +

					'<input ng-if="editType==\'password\'" autocomplete="new-password" class="input" id="{{htId}}" type="password" ng-disabled="disable&&disable!==\'false\'"' +
					' ht-event-listence placeholder="{{expMsg}}" ng-model="input.tempModel" reg-string="{{regExp}}"/>' +

					'<input ng-if="editType==\'number\'" class="input" id="{{htId}}" type="number" ng-disabled="disable&&disable!==\'false\'"' +
					' ht-event-listence placeholder="{{expMsg}}" ng-model="input.tempModel" reg-string="{{regExp}}"/>' +
					'</label>',
					controller:function($scope){
						$scope.parentScope = $scope.$parent;
						$scope.input = {};
					},
					compile:function(elem, attrs, childTranscludeFn){
						return function(scope,elem,attrs,ngModelController){
							scope.$watch('regExp',function(newVal){
								if(newVal && newVal.indexOf( 'common.require')>-1){
									scope._regExp = true;
								}else {
									scope._regExp = false;
								}
								elem.find('input').attr('reg-string',newVal);
								var msg=[];
								if(newVal&&window.validate && window.zValidate) {
									var ruleName=newVal.split(",");
									for (var j = 0; j < ruleName.length; j++) {
										if (ruleName[j].indexOf("common.")>-1) {
											var aliasName = ruleName[j].split(".")[1];
											if(window.zValidate.ruleName.indexOf(aliasName)>-1){
												if (window.zValidate[aliasName].rule != null) {
													msg.push(window.zValidate[aliasName].errMsg);
												}
											}
										}else {
											for (var i = 0; i < window.validate.length; i++) {
												var newArr = window.validate[i];
												if (newArr.ruleName == ruleName[j]) {
													if (newArr.rule != null) {
														msg.push(newArr.errMsg);
													}
												}
											}
										}
									}
								}
								elem.find('input').attr('placeholder',msg.join(","));
							})
							scope.$watch('input.tempModel',function(newVal){
								if(attrs.editType=="date" && newVal){
									if(/^(\d{8})|-/.test(newVal)){
										var newVal = newVal.split('-').join('');
									}else {
										newVal = undefined;
									}
								}
								if(attrs.editType=="time" && newVal){
									//todo
								}
								if(attrs.editType=="currency" && newVal){
									if(newVal.indexOf(',')>-1){
										if(newVal.indexOf('.')>-1){
											var modelValueArr = newVal.split('.');
											var modelValueArr2 = modelValueArr[0].split(',');
											newVal = modelValueArr2.join('')+'.'+modelValueArr[1];
										}else {
											var modelValueArr = newVal.split(',');
											newVal = modelValueArr.join('');
										}
									}
								}
								ngModelController.$setViewValue(newVal);
							});
							ngModelController.$parsers.unshift(function (viewVal) {
								var modelVal = viewVal;
								return modelVal;
							});
							ngModelController.$formatters.unshift(function (modelVal) {
								var viewVal = modelVal;
								return viewVal;
							});
							ngModelController.$render = function(){
								if(attrs.editType=="currency" && ngModelController.$viewValue){
									if(!/^[0-9]+\.[0-9]+$/.test(ngModelController.$viewValue) && !/^\d+$/.test(ngModelController.$viewValue)){
										throw Error("currency:格式有误");
									}
									scope.input.tempModel = $common.get_currFormat(ngModelController.$viewValue);
									return;
								}
								if(attrs.editType=="date" && ngModelController.$viewValue){
									var  date = ngModelController.$viewValue;
									scope.input.tempModel =  date.substr(0,4)+"-"+date.substr(4,2)+"-"+date.substr(6,2);
									return;
								}
								if(attrs.editType=="time" && ngModelController.$viewValue){
									//var  time = ngModelController.$viewValue;
									//scope.input.tempModel =  date.substr(0,4)+"-"+date.substr(4,2)+"-"+date.substr(6,2);
									//return;
								}
								scope.input.tempModel = ngModelController.$viewValue;
							};

							scope.$watch('hide',function(newVal){
								if(newVal && newVal!=="false")scope.input.tempModel=undefined;
							});
							angular.element(elem).on('blur','input',function(){
								if(attrs.editType=="date"||attrs.editType=="time"||attrs.editType=="datetime"){
									scope.input.tempModel = elem.find('input').val();
									scope.$apply();
								}
							})
							if(attrs.editType=="date"){
								scope.date = true;
								var minDate = attrs.minDate?attrs.minDate:"1000-01-01";
								var maxDate = attrs.maxDate?attrs.maxDate:"9999-12-31";
								var changeed = function(){
									$timeout(function(){
										var M = $dp.cal.newdate.M,
											d = $dp.cal.newdate.d,
											y = ""+$dp.cal.newdate.y;
										if(M<10){
											M = "0"+$dp.cal.newdate.M;
										};
										if(d<10){
											d = "0"+$dp.cal.newdate.d;
										};
										scope.$apply(function(){
											scope.input.tempModel = y+'-'+M+'-'+d;
										})
										if(typeof scope.parentScope[attrs.htId+'_onChange'] =="function"){
											scope.parentScope[attrs.htId+'_onChange'](y+M+d);
										};
									},100);
								};
								angular.element(elem).on('focus','input',function(){
									WdatePicker({
										dateFmt:'yyyy-MM-dd',
										skin:'twoer',
										minDate:attrs.lowerDateId ? '#F{$dp.$D(\''+attrs.lowerDateId+'\')||\''+minDate+'\'}':minDate,
										maxDate:attrs.highDateId ? '#F{$dp.$D(\''+attrs.highDateId+'\')||\''+maxDate+'\'}':maxDate,
										onpicked:function(Wdate){
											scope.$apply(function(){
												scope.input.tempModel = Wdate.el.value;
											})
										},
										dchanged:changeed,
										ychanged:changeed,
										Mchanged:changeed
									})
								});
							}
							else if(attrs.editType=="time"||attrs.editType=="datetime"){
								var dateFmt = 'HH:mm:ss';
								if(attrs.editType=="datetime"){
									dateFmt = 'yyyy-MM-dd HH:mm:ss';
								}
								scope.time = true;
								//var minDate = attrs.minDate?attrs.minDate:"1000-01-01";
								//var maxDate = attrs.maxDate?attrs.maxDate:"9999-12-31";
								var changeed = function(){
									$timeout(function(){

										var M = $dp.cal.newdate.M,
											d = $dp.cal.newdate.d,
											y = ""+$dp.cal.newdate.y,
											H = $dp.cal.newdate.H,
											m = $dp.cal.newdate.m,
											s = ""+$dp.cal.newdate.s;
										if(M<10){
											M = "0"+$dp.cal.newdate.M;
										};
										if(d<10){
											d = "0"+$dp.cal.newdate.d;
										};
										if(H<10){
											H = "0"+$dp.cal.newdate.H;
										};
										if(m<10){
											m = "0"+$dp.cal.newdate.m;
										};
										if(s<10){
											s = "0"+$dp.cal.newdate.s;
										};
										var curDate = H+':'+m+':'+s;
										if(attrs.editType=="datetime"){
											curDate =y+'-'+M+'-'+d+' '+H+':'+m+':'+s;
										}
										scope.$apply(function(){
											scope.input.tempModel = curDate;
										})
										if(typeof scope.parentScope[attrs.htId+'_onChange'] =="function"){
											scope.parentScope[attrs.htId+'_onChange'](curDate);
										};
									},100);
								};
								angular.element(elem).on('focus','input',function(){
									WdatePicker({
										dateFmt:dateFmt,
										skin:'twoer',
										//minDate:attrs.lowerDateId ? '#F{$dp.$D(\''+attrs.lowerDateId+'\')||\''+minDate+'\'}':minDate,
										//maxDate:attrs.highDateId ? '#F{$dp.$D(\''+attrs.highDateId+'\')||\''+maxDate+'\'}':maxDate,
										onpicked:function(Wdate){
											scope.$apply(function(){
												scope.input.tempModel = Wdate.el.value;
											})
										},
										dchanged:changeed,
										ychanged:changeed,
										Mchanged:changeed,
										Hchanged:changeed,
										mchanged:changeed,
										schanged:changeed
									})
								});
							}
							else if(attrs.editType=="currency"){
								angular.element(elem).on('blur','input',function(){
									var modelValue =scope.input.tempModel;
									if(modelValue!==undefined&&modelValue!==null&&modelValue!==''){
										if(modelValue.indexOf(',')>-1){
											if(modelValue.indexOf('.')>-1){
												var modelValueArr = modelValue.split('.');
												var modelValueArr2 = modelValueArr[0].split(',');
												modelValue = modelValueArr2.join('')+'.'+modelValueArr[1];
											}else {
												var modelValueArr = modelValue.split(',');
												modelValue = modelValueArr.join('');
											}
										}
										if(!/^[0-9]+\.[0-9]+$/.test(modelValue) && !/^\d+$/.test(modelValue)){
											scope.$apply(function(){
												scope.input.tempModel = undefined;
											})
										}else{
											scope.$apply(function(){
												scope.input.tempModel = $common.get_currFormat(modelValue);
											})
										}
									}
								})
							}
						}
					},
					replace:true
				}
			}).
			    directive('htTextArea',function($common){
				return {
					restrict:'E',
					require:'?ngModel',
					scope:{
						name :"@",
						htId :"@",
						regExp :"@",
						hide :"@",
						height:"@",
						disable:'@'
					},
					template:
					'<label ng-show="!hide || hide==\'false\'" style="width:100%;">' +
					'<div name="leftP" style="position: absolute; top: calc(50% - 10px); width: 19.5%; padding-left: 5%;">'+
					'<span style="text-align:left, font-size: 12px">'+
					'<b ng-if="_regExp" style="color: red;">*</b>{{name}}</span></div>' +
					'<div name="rightP" style="margin-left: 19.5%;"><textarea class="input"  ng-style="textarea" id="{{htId}}" ng-disabled="disable&&disable!==\'false\'"' +
					' ht-event-listence placeholder="{{expMsg}}" reg-string="{{regExp}}"' +
					' ng-model="tempModel"></textarea></div>' +
					'</label>',
					//'<label style="width: 100%" ng-show="!hide || hide==\'false\'">' +
					//	'<span class="span" style="width:19%;padding-left:5%"><b ng-if="regExp" style="color: red;">*</b>{{name}}</span>' +
					//'<textarea class="input" style="width: 79%;resize: none;vertical-align: middle;" ng-style="heightw" id="{{htId}}" ng-disabled="disable&&disable!==\'false\'"' +
					//' ht-event-listence placeholder="{{expMsg}}" reg-string="{{regExp}}"' +
					//' ng-model="tempModel"></textarea>' +
					//'</label>',
					controller:function($scope){
						$scope.parentScope = $scope.$parent;
					},
					compile:function(elem, attrs, childTranscludeFn){
						return function(scope,elem,attrs,ngModelController){
							scope.textarea = {
								"verticalAlign":"middle",
								"height": "52",
								"width": "100%"
							}
							var resize = function(){
								var labelWidth=0.39,labelPadding=0.1;
								if($(window).width()>=768){
									labelWidth = 0.5 * 0.39;
									labelPadding = 0.5 * 0.1;
								}
								if($(window).width()>=1200){
									labelWidth = 0.33 * 0.39;
									labelPadding = 0.33 * 0.1;
								}
								labelWidth = (labelWidth * 100) + '%';
								labelPadding = (labelPadding * 100) + '%';
								angular.element(document).find('div[name=leftP]').css({
									width: labelWidth, 
									'padding-left': labelPadding
								});
								angular.element(document).find('div[name=rightP]').css('margin-left',labelWidth);
							}
							resize();
							window.onresize = function(){
								resize();
							}
							scope.$watch('regExp',function(newVal){
								if(newVal && newVal.indexOf( 'common.require')>-1){
									scope._regExp = true;
								}else {
									scope._regExp = false;
								}
								elem.find('textarea').attr('reg-string',newVal);
								var msg=[];
								if(newVal&&window.validate && window.zValidate) {
									var ruleName=newVal.split(",");
									for (var j = 0; j < ruleName.length; j++) {
										if (ruleName[j].indexOf("common.")>-1) {
											var aliasName = ruleName[j].split(".")[1];
											if(window.zValidate.ruleName.indexOf(aliasName)>-1){
												if (window.zValidate[aliasName].rule != null) {
													msg.push(window.zValidate[aliasName].errMsg);
												}
											}
										}else {
											for (var i = 0; i < window.validate.length; i++) {
												var newArr = window.validate[i];
												if (newArr.ruleName == ruleName[j]) {
													if (newArr.rule != null) {
														msg.push(newArr.errMsg);
													}
												}
											}
										}
									}
								}
								elem.find('textarea').attr('placeholder',msg.join(","));
							})
							scope.$watch('tempModel',function(newVal){
								ngModelController.$setViewValue(newVal);
							});
							ngModelController.$parsers.unshift(function (viewVal) {
								var modelVal = viewVal;
								return modelVal;
							});
							ngModelController.$formatters.unshift(function (modelVal) {
								var viewVal = modelVal;
								return viewVal;
							});
							ngModelController.$render = function(){
								scope.tempModel = ngModelController.$viewValue;
							};
							scope.$watch('hide',function(newVal){
								if(newVal && newVal!=="false")scope.tempModel=undefined;
							});
						}
					},
					replace:true
				}
			}).
			    directive('htInputExtent',function($common){
				return {
					restrict:'E',
					require:'?ngModel',
					scope:{
						extent:'=',
						onChange:'&',
						name :"@",
						htId :"@",
						regExp :"@",
						hide :"@",
						disable:'@',
						checkedhiden:'@',
						readonly:'@'
					},
					template:
					'<label  ng-show="!hide || hide==\'false\'">' +
					'<span class="span"><b ng-if="_regExp" style="color: red;">*</b>{{name}}</span>' +
					'<div style="width: 60%;display: inline-block">' +
					'<input class="input" style="width: -webkit-calc(98% - 50px);width:calc(98% - 50px);" id="{{htId}}" type="text"' +
					' ng-disabled="disable&&disable!==\'false\'" ng-readonly="readonly&&readonly!==\'false\'" placeholder="{{expMsg}}"' +
					' reg-string="{{regExp}}" ng-model="tempModel" poppositon="htInputExtent">' +
					'<button class="btn btn-primary btn-sm" ng-disabled="disable&&disable!==\'false\'"' +
					'ng-click="button()" style="margin:0 0 2px 2%;height: 25px;width: 50px;"><span>查询</span></button></div>'+

					'<div ng-if="extentDiv" ng-switch="extent.type" class="inputContent">' +
					'<span class="content-close" ng-click="contentClose()"></span>' +

					'<div ng-switch-when="table">' +
					'<ul class="extentDiv">' +
					'<li ng-repeat="ds in datasource" ng-class="defaultEquality(selected,ds)" ng-click="selectLi(ds)">' +
					'<span ng-repeat="col in extent.column">{{ds[col]}}<span ng-hide="$last">{{extent.split}}</span></span>' +
					'</li></ul>' +
					'<div class="button"><ht-page conf="conf" noselectpage="true"></ht-page></div>'+
					'</div>'+

					'<div ng-switch-when="tree">' +
					'<treecontrol class="tree-classic" tree-model="datasource" options="treeOptions"' +
					'on-selection="selectLi(node)"selected-node="node">' +
					'<span ng-repeat="col in extent.column">{{node[col]}}<span ng-hide="$last">{{extent.split}}</span></span>' +
					'</treecontrol>'+
					'</div>'+

					'<div ng-switch-when="autoTree">' +
					'<ht-autotree option="autoTree"></ht-autotree>'+
					'</div>'+

					'</div>' +
					'</label>',
					controller:function($scope){
						$scope.treeOptions = {checkedhiden:$scope.checkedhiden};
					},
					compile:function(elem, attrs, childTranscludeFn){
						return function(scope,elem,attrs,ngModelController){
							scope.$watch('regExp',function(newVal){
								if(newVal && newVal.indexOf( 'common.require')>-1){
									scope._regExp = true;
								}else {
									scope._regExp = false;
								}
								elem.find('input[class=input]').attr('reg-string',newVal);
								var msg=[];
								if(newVal&&window.validate && window.zValidate) {
									var ruleName=newVal.split(",");
									for (var j = 0; j < ruleName.length; j++) {
										if (ruleName[j].indexOf("common.")>-1) {
											var aliasName = ruleName[j].split(".")[1];
											if(window.zValidate.ruleName.indexOf(aliasName)>-1){
												if (window.zValidate[aliasName].rule != null) {
													msg.push(window.zValidate[aliasName].errMsg);
												}
											}
										}else {
											for (var i = 0; i < window.validate.length; i++) {
												var newArr = window.validate[i];
												if (newArr.ruleName == ruleName[j]) {
													if (newArr.rule != null) {
														msg.push(newArr.errMsg);
													}
												}
											}
										}
									}
								}
								elem.find('input[class=input]').attr('placeholder',msg.join(","));
							})
							var key = attrs.ngModel.split(".")
							scope.extentDiv =false;
							scope.selected ={};
							scope.datasource = [];
							scope.autoTree = {
									isCheckBox:false,       // 是否加入CheckBox复选框
									isClickRow: true,  	 // 是否点击行触发事件
									isAutoSelect: true,   // 是否自动勾选父子级关系
									isAllShow: false,      // 是否打开全部节点（异步树，此值不能随意修改）
									//headNode: {treeId: 0,treeName: '首节点'},  // 自定义首目录节点
									allChildNode: [],  // 首目录下所有的子节点
									//树必须包含的字段"treeId  treeName  treeParentId  hasChilds  isChecked"
									//allChildNode:[{"treeId": "1003", "treeName": "文本", "treeLevel":"1", "treeParentId":"0",hasChilds:true,isChecked:true},]
									//dPicUrl: '../../images/',  // 默认图片路径
									customFun: function(node){
										//alert("customFun: "+JSON.stringify(node))
										scope.extent.func(node);
										autoTreeSelectRow(node);
									},  // 自定义文字点击函数,isClickRow=true生效
									boxEventFun: function(node,isSelect){
										//alert("boxEventFun: "+isSelect+" "+JSON.stringify(node)+"选中的值"+$scope.autotree.selectCBox)
									},  // 自定义checkbox点击函数，isCheckBox=true生效
									showBoxFun: function(node){
										//alert("showBoxFun: "+JSON.stringify(node));
										return true
									},   // 自定义是否展示checkbox复选框，isCheckBox=true生效

									//async: true,          //是否异步查询树
									//url:'/autoTree1',  //父节点点击异步查询树地址,后台接口接受固定参数格式 key:fId  {fId:"1000"}
									//dataFilter: function(treeDataList){   // 过滤callback数据
									//    return treeDataList
									//}
								};
							function autoTreeSelectRow(node){
								scope.extentDiv =false;
								scope.tempModel =node.treeName;
								scope.$apply();
							};
							scope.conf= { pageNo: 1, pageSize:10,pagesLength:5};
							if(scope.extent.type=="table"){
								scope.$watch("conf.pageNo+conf.pageSize",function(newVal,oldVal){
									if(newVal !== oldVal)queryTable();
								})
							}
							function queryTable(){
								//if(!searchKey)return;
								var data = {
									pageNo: scope.conf.pageNo,
									pageSize: scope.conf.pageSize
								};
								if(scope.extent.param){
									data.value = scope.extent.param;}
								else {
									data.value = {};
									data.value[key[1]] = searchKey;
								}
								var promise = $common.get_asyncData(scope.extent.url,data);
								promise.then(function(res){
									if (res.errorCode =="SUC"){
										if(scope.extent.type=="autoTree"){
											scope.autoTree.allChildNode =  res.contextData.records;
										}else {
											scope.conf.totalRecord = parseInt(res.contextData.totalRecord);
											if(scope.extent.type=="tree"){
												if(scope.conf.totalRecord>scope.conf.pageSize){
													scope.conf.pageSize=scope.conf.totalRecord+1;
													queryTable();
													return;
												}
											}
											scope.datasource = res.contextData.records;
										}
									}else{
										$common.get_tipDialog(res.errorMsg,'showError');
									}
								});
							}
							scope.button = function(){
								if (scope.extent){
									scope.extentDiv = true;
									queryTable()
								}
							};
							scope.selectLi = function(ds){
								scope.extentDiv = false;
								scope.selected =ds;
								if(scope.extent.extentColumn){
									scope.tempModel = ds[scope.extent.extentColumn];
								}else{
									scope.tempModel = ds[key[1]];
								}
								var doextent = scope.onChange();
								if(doextent)doextent(ds)
							}
							scope.contentClose = function(){
								scope.extentDiv = false;
								scope.tempModel='';
							}
							scope.$watch('hide',function(newVal){
								if(newVal && newVal!=="false")scope.tempModel=undefined;
							});
							var searchKey;
							scope.$watch('tempModel',function(newVal){
								searchKey = newVal;
								ngModelController.$setViewValue(newVal);
							});
							ngModelController.$parsers.unshift(function (viewVal) {
								var modelVal = viewVal;
								return modelVal;
							});
							ngModelController.$formatters.unshift(function (modelVal) {
								var viewVal = modelVal;
								return viewVal;
							});
							ngModelController.$render = function(){
								scope.tempModel = ngModelController.$viewValue;
							};

							function shallowCopy(src, dst) {
								if (angular.isArray(src)) {
									dst = dst || [];

									for ( var i = 0; i < src.length; i++) {
										dst[i] = src[i];
									}
								} else if (angular.isObject(src)) {
									dst = dst || {};

									for (var key in src) {
										if (src.hasOwnProperty( key) && !(key.charAt(0) === '$' && key.charAt(1) === '$')) {
											dst[key] = src[key];
										}
									}
								}

								return dst || src;
							}
							scope.defaultEquality = function (a, b) {
								if (a === undefined || b === undefined)
									return false;
								a = shallowCopy(a);
								b = shallowCopy(b);
								if(angular.equals(a, b))return "active";
								else return "";
								//return angular.equals(a, b);
							}
						}
					},
					replace:true
				}
			}).
			    directive('htRadio',function(){
				return {
					restrict:'E',
					require:'?ngModel',
					scope:{
						datasource:'=',//数据来源，存在时替代dictionary值，
						dataTrsOption:'@datatrsoption',
						dataOption:'@dataoption',
						name :"@",
						regExp :"@",
						lWidth :"@",
						dictionary:'@',
						disable:'@',
						hide :"@",
						onChange:'&',
						htId :"@"
					},
					template:
					'<label ng-show="!hide || hide==\'false\'" style="width:100%"><div ng-style="radio" class="radio">' +
					'<div name="leftP" style="top: -webkit-calc(50% - 10px);top: calc(50% - 10px);position: absolute;">' +
					'<span ng-style="span"><b ng-if="_regExp" style="color: red;">*</b>{{name}}</span></div>' +
					'<div name="rightP">' +
					'<ul style="display: inline-block;margin: 0" ht-dictionary="{{dictionary}}" ng-init="radio={tempModel:null}">' +
					'<li style="display: inline-block;padding-right: 10px" ng-repeat="option in dicArr">'+
					'<input style="margin-left: 0px;margin-top: 5px" name="{{htId}}" type="radio" id="{{$index+htId}}"' +
					'ng-change="changeradio(option.dataVal)" reg-string="{{regExp}}"'+
					'ng-model="radio.tempModel" value="{{option.dataVal}}" ng-disabled="disable&&disable!==\'false\'">' +
					'<label style="width: 100%; font-size: 12px;" for="{{$index+htId}}" ng-bind="option.dataTrsVal"></label>' +
					'</li></ul></div>' +
					'</div></label>',
					compile:function(elem, attrs){
						return function(scope,elem,attrs,ngModelController){
							var lWidth=0.39;
							scope.$watch('lWidth',function(newVal){
								if(newVal && newVal > 0){
									lWidth = newVal;
								}
								resize();
							})
							scope.$watch('regExp',function(newVal){
								if(newVal && newVal.indexOf( 'common.require')>-1){
									scope._regExp = true;
								}else {
									scope._regExp = false;
								}
							})
							var resize = function(){
								var labelPadding=0.1;
								if($(window).width()>=768){
									labelWidth = 0.5 * lWidth;
									labelPadding = 0.5 * 0.1;
								}
								if($(window).width()>=1200){
									labelWidth = 0.33 * lWidth;
									labelPadding = 0.33 * 0.1;
								}
								labelWidth = (labelWidth * 100) + '%';
								labelPadding = (labelPadding * 100) + '%';
								angular.element(document).find('div[name=leftP]').css({
									width: labelWidth, 
									'padding-left': labelPadding
								});
								angular.element(document).find('div[name=rightP]').css('margin-left',labelWidth);
							}
							resize();
							window.onresize = function(){
								resize();
							}
							scope.radio = {
								color:"#393939",fontWeight: "normal", margin: "5px 0px"};
							scope.span = {textAlign: "left", fontSize: "12px"};

							scope.changeradio = function (row) {
								var onchange = scope.onChange();
								if(onchange)onchange(row);
							};
							if(scope.datasource){
								scope.datasource = scope.datasource||{};
								scope.datasource.ds = scope.datasource.ds|| [];//记录的数据源
								scope.$watchCollection("datasource",function (){
									scope.dicArr = scope.datasource.ds.map(function(itemm){
										itemm.dataVal = itemm[scope.dataOption];
										itemm.dataTrsVal = itemm[scope.dataTrsOption];
										return itemm;
									})
								});
							}
							scope.$watch('radio.tempModel',function(newVal){
								ngModelController.$setViewValue(newVal);
							});
							ngModelController.$parsers.unshift(function (viewVal) {
								var modelVal = viewVal;
								return modelVal;
							});
							ngModelController.$formatters.unshift(function (modelVal) {
								var viewVal = modelVal;
								return viewVal;
							});
							ngModelController.$render = function(){
								scope.radio.tempModel = ngModelController.$viewValue;
							};

						}
					},
					replace:true
				}
			}).
			    directive('htCheckbox',function(){
				return {
					restrict:'E',
					require:'?ngModel',
					scope:{
						datasource:'=',//数据来源，存在时替代dictionary值，
						dataTrsOption:'@datatrsoption',
						dataOption:'@dataoption',
						name :"@",
						dictionary:'@',
						disable:'@',
						hide :"@",
						onClick:'&',
						htId :"@"
					},
					template:
					'<label ng-show="!hide || hide==\'false\'" style="width:100%;"><div ng-style="checkbox" class="checkbox">' +
					'<div name="leftP" style="top: calc(50% - 10px); position: absolute; width: 19.5%; padding-left: 5%;">' +
					'<span ng-style="span" ng-bind="name"></span></div>' +
					'<div name="rightP" style="margin-left: 19.5%;"><ul style="display: inline-block;margin: 0" ht-dictionary="{{dictionary}}">' +
					'<li style="display: inline-block;padding-right: 10px" ng-repeat="option in dicArr">'+
					'<input style="margin-left: 0px;margin-top: 5px" name="{{htId}}" id="{{$index+htId}}" type="checkbox" ng-checked="isSelected(option.dataVal)" ' +
					'ng-click="updateSelection($event,option.dataVal)" ng-disabled="disable&&disable!==\'false\'">' +
					'<label style="width: 100%; font-size: 12px;" for="{{$index+htId}}" ng-bind="option.dataTrsVal"></label>' +
					'</li></ul></div>' +
					'</div></label>',
					compile:function(elem, attrs){
						return function(scope,elem,attrs,ngModelController){
							var resize = function(){
								var labelWidth=0.39,labelPadding=0.1;
								if($(window).width()>=768){
									labelWidth = 0.5 * 0.39;
									labelPadding = 0.5 * 0.1;
								}
								if($(window).width()>=1200){
									labelWidth = 0.33 * 0.39;
									labelPadding = 0.33 * 0.1;
								}
								labelWidth = (labelWidth * 100) + '%';
								labelPadding = (labelPadding * 100) + '%';
								angular.element(document).find('div[name=leftP]').css({
									width: labelWidth, 
									'padding-left': labelPadding
								});
								angular.element(document).find('div[name=rightP]').css('margin-left',labelWidth);
							}
							resize();
							window.onresize = function(){
								resize();
							}
							scope.checkbox = {
								color:"#393939",fontWeight: "normal", margin: "5px 0px"};
							scope.span = {textAlign: "left", fontSize: "12px"};

							scope.selected = [];
							if(scope.datasource){
								scope.datasource = scope.datasource||{};
								scope.datasource.ds = scope.datasource.ds|| [];//记录的数据源
								scope.$watchCollection("datasource",function (){
									scope.dicArr = scope.datasource.ds.map(function(itemm){
										itemm.dataVal = itemm[scope.dataOption];
										itemm.dataTrsVal = itemm[scope.dataTrsOption];
										return itemm;
									})
								});
							}
							var updateSelected = function (action, row) {
								if (action == 'add' && scope.selected.indexOf(row) == -1) scope.selected.push(row);
								if (action == 'remove' && scope.selected.indexOf(row) != -1) scope.selected.splice(scope.selected.indexOf(row), 1);
							}
							scope.updateSelection = function ($event, row) {
								var checkbox = $event.target;
								var action = (checkbox.checked ? 'add' : 'remove');
								updateSelected(action, row);

								var oonclick = scope.onClick();
								if(oonclick)oonclick(row);
							};
							scope.isSelected = function (row) {
								return scope.selected.indexOf(row) >= 0;
							};
							scope.$watchCollection('selected',function(newVal){
								ngModelController.$setViewValue(newVal);
							});
							ngModelController.$parsers.unshift(function (viewVal) {
								var modelVal = viewVal;
								return modelVal;
							});
							ngModelController.$formatters.unshift(function (modelVal) {
								var viewVal = modelVal;
								return viewVal;
							});
							ngModelController.$render = function(){
								scope.selected = ngModelController.$viewValue;
								if(!angular.isArray(scope.selected))scope.selected=[];
							};

						}
					},
					replace:true
				}
			}).
			    directive('htQuerySelect',function($common){
				return {
					restrict:'E',
					require:'?ngModel',
					scope:{
						extent:'=',
						name :"@",
						htId :"@",
						regExp :"@",
						hide :"@",
						disable:'@'
					},
					template:
					'<label  ng-show="!hide || hide==\'false\'">' +
					'<span class="span"><b ng-if="_regExp" style="color: red;">*</b>{{name}}</span>' +
					'<input class="input" id="{{htId}}" type="text" ng-focus="inputFocus()"' +
					' ng-disabled="disable&&disable!==\'false\'" placeholder="{{expMsg}}"' +
					' reg-string="{{regExp}}" ng-model="tempModel">' +

					'<div class="inputContent" ng-if="extentDiv.show">' +

					'<div style="padding: 10px">' +
					'<input class="queryinput" ng-model="extentDiv.tempQuery" />&nbsp;&nbsp;&nbsp;&nbsp;'+
					'<button class="btn btn-primary btn-sm" ng-click="button()">查询</button>'+
					'</div><span class="content-close" ng-click="contentClose()"></span>' +
					'<div ng-show="extentDiv.displayBegin"><ht-autotree option="autotree"></ht-autotree></div>'+

					'</div>' +
					'</label>',
					controller:function($scope){
						$scope.extentDiv ={
							show:false,
							displayBegin: $scope.extent.displayBegin
						};
						$scope.autotree = {
							isCheckBox:false,       // 是否加入CheckBox复选框
							isClickRow: true,  	 // 是否点击行触发事件
							isAutoSelect: false,   // 是否自动勾选父子级关系
							isAllShow: false,      // 是否打开全部节点（异步树，此值不能随意修改）
							//headNode: {treeId: 0,treeName: '首节点'},  // 自定义首目录节点
							allChildNode: [],  // 首目录下所有的子节点
							//树必须包含的字段"treeId  treeName  treeParentId  hasChilds  isChecked"
							//allChildNode:[{"treeId": "1003", "treeName": "文本", "treeLevel":"1", "treeParentId":"0",hasChilds:true,isChecked:true},]
							//dPicUrl: '../../images/',  // 默认图片路径
							customFun: function(node){
								//$scope.extentDiv.show = false;
								//$scope.extent.displayBegin = false;
								//$scope.tempQuery = '';
								$scope.extent.dochange(node);
								//alert("customFun: "+JSON.stringify(node))
							},  // 自定义文字点击函数,isClickRow=true生效
							boxEventFun: function(node,isSelect){
								//alert("boxEventFun: "+isSelect+" "+JSON.stringify(node)+"选中的值"+$scope.autotree.selectCBox)
							},  // 自定义checkbox点击函数，isCheckBox=true生效
							showBoxFun: function(node){
								//alert("showBoxFun: "+JSON.stringify(node));
								return true
							},   // 自定义是否展示checkbox复选框，isCheckBox=true生效

							//queryObj:{},
							async: true,          //是否异步查询树
							url:$scope.extent.url,  //父节点点击异步查询树地址,后台接口接受固定参数格式 key:fId  {fId:"1000"}
							dataFilter: function(treeDataList){   // 过滤callback数据
								return $scope.extent.dataFilter(treeDataList);
							}
						};
					},
					compile:function(elem, attrs, childTranscludeFn){
						return function(scope,elem,attrs,ngModelController){
							scope.$watch('regExp',function(newVal){
								if(newVal && newVal.indexOf( 'common.require')>-1){
									scope._regExp = true;
								}else {
									scope._regExp = false;
								}
								elem.find('input[class=input]').attr('reg-string',newVal);
								var msg=[];
								if(newVal&&window.validate && window.zValidate) {
									var ruleName=newVal.split(",");
									for (var j = 0; j < ruleName.length; j++) {
										if (ruleName[j].indexOf("common.")>-1) {
											var aliasName = ruleName[j].split(".")[1];
											if(window.zValidate.ruleName.indexOf(aliasName)>-1){
												if (window.zValidate[aliasName].rule != null) {
													msg.push(window.zValidate[aliasName].errMsg);
												}
											}
										}else {
											for (var i = 0; i < window.validate.length; i++) {
												var newArr = window.validate[i];
												if (newArr.ruleName == ruleName[j]) {
													if (newArr.rule != null) {
														msg.push(newArr.errMsg);
													}
												}
											}
										}
									}
								}
								elem.find('input[class=input]').attr('placeholder',msg.join(","));
							})
							scope.inputFocus = function(){
								if (scope.extent){
									scope.extentDiv.show = true;
									if(scope.extent.displayBegin){
										scope.button();
									}
									//queryTable()
								}
							};
							var data ={};
							scope.button = function(){
								scope.extentDiv.displayBegin=true;
								data[scope.extent.queryKey] = scope.extentDiv.tempQuery;
								var  autoTPromise = $common.get_asyncData(scope.extent.url,data)
								autoTPromise.then(function(res) {
									var allChildNode = scope.extent.dataFilter(res.contextData);
									scope.autotree.allChildNode = allChildNode;
								})
							};
							scope.contentClose = function(){
								scope.extentDiv.displayBegin = false;
								scope.extentDiv.show = false;
								scope.extentDiv.tempQuery = '';
							}
							scope.$watch('hide',function(newVal){
								if(newVal && newVal!=="false")scope.tempModel=undefined;
							});
							var searchKey;
							scope.$watch('tempModel',function(newVal){
								searchKey = newVal;
								ngModelController.$setViewValue(newVal);
							});
							ngModelController.$parsers.unshift(function (viewVal) {
								var modelVal = viewVal;
								return modelVal;
							});
							ngModelController.$formatters.unshift(function (modelVal) {
								var viewVal = modelVal;
								return viewVal;
							});
							ngModelController.$render = function(){
								scope.tempModel = ngModelController.$viewValue;
							};
						}
					},
					replace:true
				}
			}).
			    directive('htSelect',function($timeout){
				return{
					restrict:'E',
					require:'?ngModel',
					scope:{
						datasource:'=',//数据来源，存在时替代dictionary值，
						dataTrsOption:'@datatrsoption',
						dataOption:'@dataoption',
						dictionary:'@',
						name:'@',
						htId:'@',
						hide :"@",
						regExp :"@",
						disable:'@',
						onChange:'&'
					},
					template:
					'<label class="input--select"  ng-show="!hide || hide==\'false\'">' +
					'<span class="span"><b ng-if="_regExp" style="color: red;">*</b>{{name}}</span>' +
					'<div style="display: inline;" ng-click="showOption(disable)"' +
					'ng-disabled="disable&&disable!==\'false\'">' +
					'<input class="input" id="{{htId}}" type="text" ng-model="s.select" ' +
					'_input_select_="htSelect" ng-focus="noFocus($event)" reg-string="{{regExp}}" /></div>' +
					'<div ng-if="showSelOption" class="inputContent">' +
					'<ul class="extentDiv" style="max-height:198px;">' +
					'<li ng-click="changeOption()">' +
					'<span dataVal="null">••请选择••</span>' +
					'</li>'+
					'<li ng-repeat="option in dicArr" ' +
					'ng-class="defaultEquality(option,dicArr)" ng-click="changeOption(option)">' +
					'<span dataVal="option.dataVal">{{option.dataTrsVal}}</span>' +
					'</li></ul>' +
					'</div>' +

					'</label>',
					controller:function($scope){
						$scope.s={};
						$scope.modelVal = null;
						$scope.showSelOption = false;
						$scope.parentScope = $scope.$parent;
						$scope.noFocus = function($event){
							$($event.srcElement||$event.target).blur();
						};
						function _datasource (){
							$scope.dicArr = $scope.datasource.ds.map(function(itemm){
								itemm.dataVal = itemm[$scope.dataOption];
								itemm.dataTrsVal = itemm[$scope.dataTrsOption];
								return itemm;
							})
						}
						function _dictionary (newVal){
							if(dictionary !==''&& dictionary !==undefined){
								if(Object.prototype.toString.call(dictionary)=='[object Object]'){
									if(dictionary[newVal]){
										$scope.dicArr = dictionary[newVal].dataItems;
									}
								}
								else {
									for (var i = 0;i<dictionary.length;i++){
										if(dictionary[i].dictCode==newVal){
											$scope.dicArr = dictionary[i].dataItems;
											break;
										}
									}
								}
							}else{
								alert("dictionary不存在");
							}
						}
						if($scope.dictionary){
							_dictionary($scope.dictionary);
						}
						$scope.$watch('dictionary',function(newVal){
							_dictionary(newVal);
							if($scope.dicArr){
								for(var i=0;i<$scope.dicArr.length;i++){
									if($scope.dicArr[i].dataVal == $scope.modelVal){
										$scope.s.select = $scope.dicArr[i].dataTrsVal;
										return;
									}
								}
							}
							$scope.s.select = "••请选择••";
						});
						$scope.$watch('regExp',function(newVal){
							if(newVal && newVal.indexOf( 'common.require')>-1){
								$scope._regExp = true;
							}else {
								$scope._regExp = false;
							}
						});
						if($scope.datasource){
							$scope.datasource = $scope.datasource||{};
							$scope.datasource.ds = $scope.datasource.ds|| [];//记录的数据源
							if($scope.datasource.ds.length>0){
								_datasource();
							}
							$scope.$watchCollection("datasource",function (){
								_datasource();
								if($scope.dicArr){
									for(var i=0;i<$scope.dicArr.length;i++){
										if($scope.dicArr[i].dataVal == $scope.modelVal){
											$scope.s.select = $scope.dicArr[i].dataTrsVal;
											$scope.validVal($scope.dicArr[i].dataVal);
											return;
										}
									}
								}
								$scope.s.select = "••请选择••";
							});
						}
					},
					link:function(scope,elem,attrs,ngModelController){
						scope.validVal = function(validval){
							angular.element(elem).find("input").attr("dataVal",validval);
						}
						scope.$watch('hide',function(newVal){
							if(newVal && newVal!=="false")scope.s.select=undefined;
						});
						scope.$watch('s.select',function(newVal){
							ngModelController.$setViewValue(newVal);
						});
						ngModelController.$parsers.unshift(function (viewVal) {
							var modelVal = viewVal;
							if(scope.dicArr){
								for(var i=0;i<scope.dicArr.length;i++){
									if(scope.dicArr[i].dataTrsVal == modelVal){
										modelVal = scope.dicArr[i].dataVal;
										break;
									}
								}
							}
							if (modelVal=="••请选择••"){
								modelVal = undefined;
							}
							return modelVal;
						});
						ngModelController.$formatters.unshift(function (modelVal) {
							var viewVal = modelVal;
							return viewVal;
						});
						ngModelController.$render = function(){
							scope.modelVal = ngModelController.$viewValue;
							if(scope.dicArr){
								for(var i=0;i<scope.dicArr.length;i++){
									if(scope.dicArr[i].dataVal == ngModelController.$viewValue){
										scope.s.select = scope.dicArr[i].dataTrsVal;
										angular.element(elem).find("input").attr("dataVal",scope.dicArr[i].dataVal);
										return;
									}
								}
							}
							scope.s.select = "••请选择••";
							angular.element(elem).find("input").attr("dataVal","");
						};
						scope.defaultEquality = function(option){
							if(scope.s.select == option.dataTrsVal){
								return 'active';
							}
							return '';
						}
						scope.showOption = function(disabled){
							if(!disabled || disabled=='false'){
								if(window.event.stopPropagation){
									window.event.stopPropagation();
									window.event.preventDefault();
								}else {
									window.event.cancelBubble = true;
								}
								scope.showSelOption = true;
								angular.element(document).one('click',function(){
									scope.showSelOption = false;
									scope.$apply();
								})
							}
						}
						scope.changeOption = function(option){
							if(window.event.stopPropagation){
								window.event.stopPropagation();
								window.event.preventDefault();
							}else {
								window.event.cancelBubble = true;
							}
							scope.showSelOption = false;
							var change = scope.onChange();
							if(!option){
								scope.s.select = "••请选择••";
								scope.modelVal = undefined;
								angular.element(elem).find("input").attr("dataVal","");
								if(change)change(null);
								angular.element(elem).find("input").trigger('blur');
								return;
							}
							scope.s.select = option.dataTrsVal;
							scope.modelVal = option.dataVal;
							angular.element(elem).find("input").attr("dataVal",option.dataVal);
							if(change)change(option.dataVal);
							angular.element(elem).find("input").trigger('blur');
						}
					},
					replace:true
				}
			}).
				/*directive('htSelect',function($compile){
					return{
						restrict:'E',
						require:'?ngModel',
						scope:{
							datasource:'=',//数据来源，存在时替代dictionary值，
							dataTrsOption:'@datatrsoption',
							dataOption:'@dataoption',
							dictionary:'@',
							name:'@',
							htId:'@',
							hide :"@",
							regExp :"@",
							disable:'@',
							onChange:'&'
						},
						template:
						'<label  ng-show="!hide || hide==\'false\'">' +
						'<span class="span"><b ng-if="regExp" style="color: red;">*</b>{{name}}</span>' +
						'<select class="input" id="{{htId}}" ng-disabled="disable&&disable!==\'false\'"' +
						'reg-string="{{regExp}}" ' +
						'ng-model="s.select" ng-change="changeOption(s.select)" ' +
						'ng-options="option.dataVal as option.dataTrsVal for option in dicArr">' +
						//'>' + ht-dictionary="{{dictionary}}"
						'<option value="">••请选择••</option>'+
						//'<option ng-repeat="option in dicArrr" ' +
						//'value="{{option.dataVal}}" ng-selected="option.dataVal==s.select">' +
						//	'{{option.dataTrsVal}}'+
						//'</option>'+
						'</select>'+
						'</label>',
						controller:function($scope){
							$scope.s={};
							$scope.parentScope = $scope.$parent;
							$scope.selectHtml ='';

						},
						link:function(scope,elem,attrs,ngModelController){
							scope.aa = function(ccc){
								setTimeout(function(){
									//	var option ='';
									//	option ='<option value=null>••请选择••</option>';
									//	for(var i=0;i<ccc.length;i++){
									//		if(scope.s.select!=null&&ccc[i].dataVal!=null&&ccc[i].dataVal==scope.s.select){
									//			option +='<option selected value="'+ccc[i].dataVal+'">'+ccc[i].dataTrsVal+'</option>'
									//		}else {
									//			option +='<option value="'+ccc[i].dataVal+'">'+ccc[i].dataTrsVal+'</option>';
									//		}
									//	}
									//	elem.find('select').empty().append(option).focus();
									elem.find('select').focus();
									elem.find('select').blur();
								})
							}
							scope.$watch('dictionary',function(newVal){
								debugger
								if(dictionary !==''&& dictionary !==undefined){
									if(Object.prototype.toString.call(dictionary)=='[object Object]'){
										if(dictionary[newVal]){
											scope.dicArr = dictionary[newVal].dataItems;
										}
									}
									else {
										for (var i = 0;i<dictionary.length;i++){
											if(dictionary[i].dictCode==newVal){
												scope.dicArr = dictionary[i].dataItems;
												break;
											}
										}
									}
								}else{
									alert("dictionary不存在");
								}
								scope.aa(scope.dicArr);
							});
							// $scope.aa(scope.dicArr);
							if(scope.datasource){
								scope.datasource = scope.datasource||{};
								scope.datasource.ds = scope.datasource.ds|| [];//记录的数据源
								scope.$watchCollection("datasource",function (){
									debugger
									scope.dicArr = scope.datasource.ds.map(function(itemm){
										itemm.dataVal = itemm[scope.dataOption];
										itemm.dataTrsVal = itemm[scope.dataTrsOption];
										return itemm;
									})
									scope.aa(scope.dicArr);
								});
							}
							scope.$watch('hide',function(newVal){
								if(newVal && newVal!=="false")scope.s.select=undefined;
							});
							scope.$watch('s.select',function(newVal){
								ngModelController.$setViewValue(newVal);
							});
							ngModelController.$parsers.unshift(function (viewVal) {
								var modelVal = viewVal;
								if(modelVal==undefined|| modelVal==''|| modelVal=='null'){
									modelVal = null;
								}
								return modelVal;
							});
							ngModelController.$formatters.unshift(function (modelVal) {
								var viewVal = modelVal;
								return viewVal;
							});
							ngModelController.$render = function(){
								scope.s.select = ngModelController.$viewValue;
							};
							scope.changeOption = function(select){
								var change = scope.onChange();
								if(change)change(select);
							}
						},
						replace:true
					}
				}).*/
			    directive('htButton',function($rootScope){
				return {
					restrict:'E',
					scope:{
						option:"=",
						htId:"@",
						hide :"@",
						disable:'@',
						className:'@'
					},
					transclude:true,
					template:
					'<button class="btn btn-sm" ng-class="classNameArr" ng-show="!hide || hide==\'false\'" ' +
					'id="{{htId}}" ng-disabled="disable&&disable!==\'false\'" ht-event-listence>' +
					'<span ng-transclude></span>{{descName}}</button>',
					controller:function($scope){
						$scope.parentScope = $scope.$parent;
					},
					link:function(scope,elem,attrs){
						scope.classNameArr=scope.className?scope.className.split(' '):[];
						scope.descName = attrs.descName;
						if(scope.option!==undefined &&scope.option!==null &&typeof scope.option=='object'){
							elem.on('click',function(){
								var tableHeaders=$rootScope[scope.option.tableId];
								var title=[],tableHeader;
								for (var i=0;i<tableHeaders.length;i++){
									tableHeader={
										egName:tableHeaders[i].egName,
										zhName:tableHeaders[i].zhName
									};
									title.push(tableHeader);
								}
								//var data ={
								//	transcode:scope.option.transcode,
								//	queryCondition:scope.option.form(),
								//    title:title
								//}

								var input = [
									{name:'transCode',value:scope.option.transcode},
									{name:'genFileName',value:scope.option.genFileName},
									{name:'queryCondition',value:JSON.stringify(scope.option.form())},
									{name:'title',value:encodeURIComponent(JSON.stringify(title))}//JSON.stringify(title)
								];
								var form = angular.element('<form style="display: none;" />');
								//var iframe = angular.element('<iframe name="iframeTransport' + Date.now() + '">');
								var authorization ={name:'Authorization',value: window.authorization||sessionStorage.getItem("authorization")};
								input.push(authorization);
								input.forEach(function(e){
									var inputHidden = angular.element('<input type="hidden" name="' + e.name + '" />');
									inputHidden.val(e.value);
									form.append(inputHidden);
								})
								form.prop({
									action: _HTTP_IP_PORT+'export/excel.htm',
									method: 'POST'
									//target: iframe.prop('name')
									//enctype: 'multipart/form-data',
									//encoding: 'multipart/form-data' // old IE
								});
								//iframe.appendTo(form);
								$('body').append(form);
								form.submit();
								form.remove();
								//alert(JSON.stringify(data))
							});
						}
						if(attrs.progressbar!==undefined &&attrs.progressbar=="true"){
							Progressbar.init({});
							angular.element(elem).on('click',function(){
								var show = {
									barId : scope.htId	// 进度条编号（删除时区分唯一），可以为空，默认0；
									//controlObj : $('#testDiv') ,  // 进度条作用域jquery对象，可以为空，默认document.body；
									//showMessage : '测试1测试1测试1' ,	// 进度条上面的消息文字，可以为空，默认数据加载中，请耐心等待……；
									//waitTime : 5 ,	// 进度条的加载时间，单位秒，可以为空，默认超时60秒；
									//barClosedFun :  // 进度条超时关闭时回调函数，默认空，自定义
								}
								Progressbar.show(show)
							})
						}
					},
					replace:true
				}
			}).
			    directive('htButtonGroup',function(){
				return {
					restrict:'E',
					scope:true,
					transclude:true,
					template:'<div class="ht-button-group" ng-transclude></div>',
					replace:true
				}
			}).
				directive('htDoubleSelects',function () {
					return{
						restrict:'E',
						scope:{
							data:'='
						},
						template:
						'<div class="double-selects">'+
						'<div class="double-selects-left">'+
						'<div class="double-selects-left-top clearfix">'+ '<h3>合同模版选择</h3>'+
						'<div class="double-selects-left-top-search pull-left">'+
						'<input type="text"/></div>'+ '<label class="pull-right">'+
						'<span ng-click="allSelect()">全选</span><input type="checkbox"/></label></div>'+
						'<ul class="double-selects-left-bottom" style="margin: 0;">'+
						'<li ng-repeat="item in data" ng-click="addSelect(item)">{{item.options}}'+
						'<label class="pull-right clearfix" name="options">'+
						'<input type="checkbox" name="options"/>'+
						'</label></li></ul></div>'+
						'<div class="double-selects-right">'+
						'<h3>已选择了{{newSelect.length}}个模版</h3>'+
						'<ul class="double-selects-right-bottom" style="margin: 0;">'+
						'<li ng-repeat="item in newSelect" class="clearfix">{{item.options}}'+
						'<span class="pull-right" ng-click="reduceSelect(item)">'+
						'<img src="../../scube_ui/images/delete_01.png"></span></li></ul></div></div>',
						controller:function ($scope) {
							$scope.newSelect=[];
							//选中添加
							$scope.addSelect=function (item) {
								//选中同时checkbox勾选
								var ev = event||window.event;
								var tagName = event.srcElement.tagName;
								var srcElement=null;
								if(tagName=='LI'){
									srcElement = $(event.srcElement).find('label');
								}else if(tagName=='LABEL'){
									srcElement =$(event.srcElement);
								}
								srcElement.toggleClass('checked');
								//判断勾选且数组中没有此项时，新数组添加，否侧删除
								if((srcElement[0].className.indexOf('checked'))!=-1){
									var flag = false;
									//先判断数组中是否有该项
									for (var index = 0; index < $scope.newSelect.length; index++) {
										if ($scope.newSelect[index].options == item.options) {
											flag = true;
											//如果有，标记为true
										}
									}
									//如果没有，创造一个item对象，然后将该item添加到left数组中
									if (!flag) {
										var items = {};
										items.options = item.options;
										$scope.newSelect.push(items);
									}
								}else {
									for (var i = 0; i < $scope.newSelect.length; i++) {
										if ($scope.newSelect[i].options == item.options) {
											$scope.newSelect.splice(i, 1);
											break;
										}
									}
								}
							};
							//删除
							$scope.reduceSelect=function (item) {
								for (var i = 0; i < $scope.newSelect.length; i++) {
									if ($scope.newSelect[i].options == item.options) {
										$scope.newSelect.splice(i, 1);
										break;
									}
								}
							};
							//全选/取消全选
							$scope.allSelect=function () {
								var item={};
								if($scope.newSelect.length==0){
									$("label[name='options']").addClass('checked');
									for(var i=0;i<$scope.data.length;i++) {
										item = $scope.data[i];
										$scope.newSelect.push(item);
									}
								}else {
									$("label[name='options']").removeClass('checked');
									$scope.newSelect.length=0;
								}
							};
						},
						replace :true
					}
				}).
			    directive('htGuide',function ($state,$common,$timeout) {
				return{
					restrict:'E',
					transclude:true,
					scope:{
						func:"&"
					},
					controller: [ "$scope", function($scope) {
						$scope.ul={};
						var guides = $scope.guides = [];
						this.addGuide = function(guide) {
							guides.push(guide);
						}
					}],
					template:
					'<div class="myGuide"><div ng-transclude></div>'+
					'<ul class="myGuide-timeLine  row">'+
					'<li ng-repeat="guide in guides"'+
					'ng-style="{width:($index==0||$index==guides.length-1)?ul.liWidth.width2:ul.liWidth.width,'+
					'marginLeft:($index==0)?ul.liWidth.width2:0,marginRight:($index==guides.length-1)?ul.liWidth.width2:0}"'+
					'ng-class="{firstGuideLi:$index==0,lastGuideLi:$index==guides.length-1}">' +
					'<div class="back"><a ng-class="{firstGuideA:guide.selected}"' +
					//' ng-click="select(guide,$index)"' +  
					'ng-bind="$index+1"></a></div>' +
					'<div class="title"><span ng-bind="guide.title"></span></div>'+
					'</li></ul>' +
					'<div ui-view></div>' +
					'<div class="button">' +
					'<button class="btn btn-primary" ng-click="pre()" ng-disabled="showPre">上一步</button>&nbsp;&nbsp;' +
					'&nbsp;&nbsp;<button class="btn btn-primary" ng-click="next()" ng-disabled="showNext">下一步</button></div>' +
					'</div>',
					link:function(scope,elem,attrs){
						scope.ul.liWidth = {
							"width": 100/scope.guides.length+"%",
							"width2": 50/scope.guides.length+"%"
						}
						var flag=-1;
						function load (guide){
							if(guide && (typeof guide.uiSref !== 'undefined')){
								$state.go(guide.uiSref);
							}
						}
						//load(scope.guides[0]);
						//scope.select = function(guide,index) {
						//	if(flag==index){
						//		load(guide);
						//	}
						//}
						scope.pre = function() {
							if(scope.guides[flag-1].uiSref){
								scope.guides[flag].selected = false;
								flag--;
								scope.showNext=false;
								if(flag==0){
									scope.showPre=true;
								}
							}else {
								$common.get_tipDialog("找不到导航条路径","showInform")
							}
							load(scope.guides[flag]);
						}
						scope.next = function(init) {
							var flag1 = !scope.func() || scope.func()();
							if(init){
								flag1 = true;
							}
							if(flag1){
								if(scope.guides[flag+1].uiSref){
									flag++;
									scope.showPre=false;
									if(flag==scope.guides.length){
										scope.showNext=true;
									}
									if(flag==0){
										scope.showPre=true;
									}
									scope.guides[flag].selected = true;
								}else {
									$common.get_tipDialog("找不到导航条路径","showInform")
								}
								load(scope.guides[flag]);
							}

						}
						scope.next(true);
					},
					replace:true
				}
			}).
			    directive('htGuideDot', function() {
				return {
					require: '^htGuide',
					restrict: 'E',
					scope: {
						title: '@',
						uiSref:'@'
					},
					link: function(scope, element, attrs, guideCtrl) {
						guideCtrl.addGuide(scope);
					},
					replace: true
				};
			}).
			    directive('htMenu',function(){
				return {
					restrict:'E',
					scope:{
						datasource :'=',
						name :'@',
						id :'@',
						selectedMenu :'&'
					},
					template:'<div class="btn-group">' +
					'<button type="button" class="btn btn-default btn-sm" style="background-color: #fff !important;color: #585858 !important;border: 1px solid #bbb;border-radius: 3px 0 0 3px !important;outline: none;margin-right:0;border-right: 0;text-shadow: none !important;">{{name}}</button>'+
					'<button type="button" class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown" style="background-color: transparent !important;border: 1px solid #aaa;border-radius: 0 3px 3px 0 !important;border-left: 0;outline: none;">'+
					'<span class="caret" style="border-top-color: #585858;margin: 0;"></span>'+
					'</button>' +
					'<ul class="dropdown-menu" id="{{id}}_id" role="menu">' +
					'<li ng-repeat="item in datasource"><a ng-click="selected(item)">{{item.name}}</a></li>'+
					'</ul>'+
					'</div>',
					link:function(scope,elem,attrs){
						scope.selected = function(item){
							var selected = scope.selectedMenu();
							selected(item);
						}
					},
					replace:true
				}
			}).
			    directive('htSelect2way',function(){
				var tpl = '' +
					'<div style="width:370px;height:auto;margin:10px;">' +
					'<table cellpadding="0" cellspacing="8">' +
					'<tbody>' +
					'<tr>' +
					'<td>' +
					'<select ng-options="option for option in  leftOptionsVariable" id="s1" style="width:150px; height:220px;" ng-model="leftSelected" multiple="multiple">' +
					'</select>' +
					'</td>' +
					'<td>' +
					'<p><input type="button" ng-click="moveRight()" style="width:60px;margin:0px 5px;" value="-->"></p>' +
						//'<p><input type="button" ng-click="moveRightAll()" style="width:60px;margin:0px 5px;" value="-->>"></p>' +
					'<p><input type="button" ng-click="moveLeft()" style="width:60px;margin:0px 5px;" value="<--"></p>' +
						//'<p><input type="button" ng-click="moveLeftAll()" style="width:60px;margin:0px 5px;" value="<<--"></p>' +
					'</td>' +
					'<td>' +
					'<select ng-options="option for option in  rightOptions" style="width:150px;height:220px;" ng-model="rightSelected" multiple="multiple">' +
					'</select>' +
					'</td>' +
					'</tr>' +
					'</tbody></table>' +
					'</div>';
				return {
					restrict:'E',
					template:tpl,
					replace:true,
					scope:{
						leftOptionsVariable:'='
					},
					link:function(scope,elem,attrs){
						scope.rightOptions=[];
						scope.leftSelected=[];
						scope.rightSelected=[];
						scope.moveRight = function(){
							if(scope.leftSelected.length==0){
								alert("请选择一条记录")
								return
							}
							scope.leftSelected.forEach(function(item,index){
								var index = scope.leftOptionsVariable.indexOf(item);
								if (index > -1) {
									scope.leftOptionsVariable.splice(index, 1);
									scope.rightOptions.unshift(item);
								}
							})
							scope.leftSelected=[];
						}
						scope.moveLeft = function(){
							if(scope.rightSelected.length==0){
								alert("请选择一条记录")
								return
							}
							scope.rightSelected.forEach(function(item,index){
								var index = scope.rightOptions.indexOf(item);
								if (index > -1) {
									scope.rightOptions.splice(index, 1);
									scope.leftOptionsVariable.unshift(item);
								}
							})
							scope.rightSelected=[];
						}
						angular.element(elem).on('dblclick','option',function(){
							var flag = angular.element(this).parent().attr('id');
							if(flag == "s1"){
								scope.$apply(function(){
									scope.moveRight();
								})
							} else {
								scope.$apply(function(){
									scope.moveLeft();
								})
							}
						});
					}
				}
			}).
				directive('htTabs', function() {
					return {
						restrict: 'E',
						transclude: true,
						scope: {
							position:'@'
						},
						controller: [ "$scope", function($scope) {
							if($scope.position=='left'){
								$scope._position = true;
							}else if($scope.position=='right'){
								$scope._position = false;
							}else {
								var tabheight = $(".tabbable").height();
								$scope.minHeight = {
									//"minHeight": tabheight-36
								};
							}
							var panes = $scope.panes = [];
							$scope.select = function(pane) {
								angular.forEach(panes, function(pane) {
									pane.selected = false;
								});
								pane.selected = true;
							}
							this.addPane = function(pane) {
								if (panes.length == 0) $scope.select(pane);
								panes.push(pane);
							}
							this.menuPane = function(pane) {
								//for(var i=0;i<panes.length;i++){
								//
								//}
								var ind =panes.indexOf(pane);
								if(ind>-1){
									panes.splice(ind,1);
								}
							}
						}],
						template:
						'<div class="tabbable" ng-class="{true:\'tabs-left\',false:\'tabs-right\'}[_position]" ' +
						'style="background-color: #F7F7F7;height:100%;">' +
						'<div style="overflow-x: auto;overflow-y: hidden;"><ul class="nav nav-tabs" style="display: table;">' +
						'<li ng-repeat="pane in panes" style="display: table-cell;float: none;white-space: nowrap;" ng-class="{active:pane.selected}">'+
						//'<a ui-sref="{{pane.uiSref}}" ng-click="select(pane)">{{pane.title}}</a>' +
						'<a ng-if="pane.uiSref && pane.params" ui-sref="{{pane.uiSref}}({{pane.params}})" ng-click="select(pane)">{{pane.title}}</a>' +
						'<a ng-if="pane.uiSref && !pane.params" ui-sref="{{pane.uiSref}}" ng-click="select(pane)">{{pane.title}}</a>' +
						'<a ng-if="!pane.uiSref" ng-click="select(pane)">{{pane.title}}</a>' +
						'</li>' +
						'</ul></div>' +
						'<div class="tab-content" style="background-color: #fff;border-top:none ;min-height: 90%;" ui-view></div><div ng-transclude></div>' +
						'</div>',//min-height: 100%;" ng-style="minHeight"
						replace: true
					};
				}).
				directive('htPane', function() {
					return {
						require: '^htTabs',
						restrict: 'E',
						//transclude: true,
						scope: {
							title: '@',
							hide: '@',
							params:'=',
							uiSref:'@'
						},
						link: function(scope, element, attrs, tabsCtrl) {
							if(!scope.hide || scope.hide=='false'){
								tabsCtrl.addPane(scope);
							}
							scope.$watch('hide',function(newVal,oldVal){
								if(newVal!==oldVal){
									if(!newVal || newVal=='false'){
										tabsCtrl.addPane(scope);
									}else{
										tabsCtrl.menuPane(scope);
									}
								}
							});
						},
						//template:
						//'<div class="tab-pane" ng-class="{active: selected}" ng-transclude>' +
						//'</div>',
						replace: true
					};
				}).
				directive('htPanel', function() {
					return {
						restrict: 'E',
						transclude: true,
						scope: {
							htId:'@',
							title:'@',
							type:'@',
							footer:'@'
						},
						link: function(scope, element, attrs) {
							scope.toggleClass = function(e){
								var ev=e||event;
								$(ev.srcElement).toggleClass("glyphicon-chevron-down glyphicon-chevron-right");
							}
						},
						template:
						'<div class="panel panel-default {{type}}">' +
						'<div class="panel-heading" ng-if="title!==undefined">' +
						'<h3 class="panel-title">{{title}}' +
						'<span class="glyphicon glyphicon-chevron-down" ng-click="toggleClass()" style="float: right;cursor: pointer" data-toggle="collapse" data-target="#{{htId}}"></span>' +
						'</h3></div>'+
						'<div id="{{htId}}" class="panel-collapse collapse in">'+
						'<div class="panel-body" ng-transclude></div>'+
						'<div class="panel-footer" ng-if="footer!==undefined">{{footer}}</div>'+
						'</div></div>',
						replace: true
					};
				}).
				directive('htBadge',function(){
					return {
						restrict:'E',
						scope:{
							htId:'@',
							badgeData:'@'
						},
						template:'<span id="{{htId}}" class="badge">{{badgeData}}</span>',
						replace:true
					}
				}).
				directive('htNav',function(){
					return {
						restrict:'E',
						scope:{
							htId:'@',
							dictionary:'@',
							selectedNav :'&'
						},
						template:'<div ht-dictionary="{{dictionary}}">' +
						'<ul class="nav nav-pills	" id="{{htId}}">' +
						'<li ng-repeat="option in dicArr"><a ng-click="selected(option)">{{option.dataTrsVal}}</a></li>' +
						'</ul></div>',
						link:function(scope,elem,attrs){
							scope.selected = function(item){
								var selected = scope.selectedNav();
								selected(item);
							}
						},
						replace:true
					}
				}).
				directive('htProgress',function(){
					return {
						restrict:'E',
						scope:{
							percent:'='
						},
						template:'<div class="progress progress-striped active">' +
						'<div class="progress-bar" ng-style="percentage">' +
						'</div></div>',
						link:function(scope,elem,attrs){
							scope.$watch('percent',function(newval,oldval){
								if(newval!==oldval){
									scope.percentage = {
										"width":scope.percent+"%"
									}
								}
								//if(newval==100){
								//	angular.element(elem).parent().empty();
								//}
							})
						},
						replace:true
					}
				}).
				directive('htChart',function(){
					return {
						restrict:'E',
						scope:{
							chartType:'@',
							chardata:'='
						},
						template:'<div style="height: 350px;width: 100%"></div>',
						link:function(scope,elem,attrs) {
							//var size = scope.$eval(attrs.size);
							//var height = size.height||300;
							//var width = size.width||600;
							//scope.sise = {
							//	"height":height+"px",
							//	"width":width+"px"
							//}
							var setBarDataOption = function (myChart,data) {
								var obj = data[0];
//    var obj = data[0];
								myChart.setOption({
									title: {
										text: ''
									},
									toolbox: {
										feature: {
											dataView: {show: true, readOnly: false},
											magicType: {show: true, type: ['bar', 'line']},
											restore: {show: true},
											saveAsImage: {show: true}
										}
									},
									tooltip: {},
									legend: {
										data: eval(obj.legend_data[0])
									},
									xAxis: {
										data: eval(obj.xAxis_data[0])
									},
									yAxis: {},
									series: eval(obj.series)

								},true);
							}

							var setLineDataOption = function (myChart,data) {
								var obj = data[0];
								myChart.setOption({
									title: {
										text: ''
									},
									toolbox: {
										feature: {
											dataView: {show: true, readOnly: false},
											magicType: {show: true, type: ['bar', 'line']},
											restore: {show: true},
											saveAsImage: {show: true}
										}
									},
									tooltip: {},
									legend: {
										data: eval(obj.legend_data[0])
									},
									xAxis: {
										data: eval(obj.xAxis_data[0])
									},
									yAxis: {
										type: 'value'
									},
									series: eval(obj.series)
								},true);
							}

							var setPieDataOption = function (myChart,data){
								var obj = data[0];
								myChart.setOption({
									title : {
										text: '',
										x:'center'
									},
									toolbox: {
										feature: {
											saveAsImage: {show: true}
										}
									},
									tooltip : {
										trigger: 'item',
										formatter: "{a} <br/>{b} : {c} ({d}%)"
									},
									legend: {
										orient: 'vertical',
										left: 'left',
										data: eval(obj.xAxis_data[0])
									},
									series: eval(obj.series),
									itemStyle: {
										emphasis: {
											shadowBlur: 10,
											shadowOffsetX: 0,
											shadowColor: 'rgba(0, 0, 0, 0.5)'
										}
									}
								},true);
							}

							var handlerJson = function (chartType,data){
								//获取series里的所有数据
//    var obj = data[0].series;
								var obj = data.series;
								var xAxis = [];//横坐标标题
								var legend = [];//统计维度
								//获取obj中name 和value的数据
								var name = '';
								var xAisxLit = '';
								var valueList;//value数组
								var convertata;//转换后的JSON
								var series = [];
								var bb = [];
								for(var i in obj){
									var value = [];
									name = name == ''? '\'' + obj[i].name + '\'' : name +',' + '\'' + obj[i].name + '\''; //legend 数据
									valueList = obj[i].value;
									var aa = [];
									for(var k in valueList){
										aa = {
											"name": valueList[k].name,
											"value": valueList[k].value
										}
										if(chartType != 'pie')
											value.push(valueList[k].value);
										else
											value.push(aa)
										if(i==0){
											xAisxLit = xAisxLit == '' ? '\'' + valueList[k].name +'\'' : xAisxLit + ',' + '\'' + valueList[k].name + '\'' ;
										}
									}

									bb = {
										"name": obj[i].name,
										"data": value,
										"type": chartType
									}
									series.push(bb);
								}
								legend.push('[' + name + ']');
								xAxis.push('[' + xAisxLit + ']')

								//拼装echarts可以识别的Json字符串
								var convertata = [
									{
										"xAxis_data": xAxis,
										"legend_data": legend,
										"series": series
									}
								]
								return convertata;

							}
							var chartType = scope.chartType||'line';
							var myChart = echarts.init(elem[0]);
							var option;
							if(scope.chardata == undefined || scope.chardata == '' || scope.chardata == null){
								scope.chardata = {};
							}
							var convertata = handlerJson(chartType,scope.chardata);
							//处理后台返回的JSON
							var render = function(){
								convertata = handlerJson(chartType,scope.chardata);
								switch(chartType) {
									case 'bar' ://柱形图
										setBarDataOption(myChart,convertata);
										break;
									case 'line'://折线图
										setLineDataOption(myChart,convertata);
										break;
									case 'pie' ://饼形图
										setPieDataOption(myChart,convertata);
										break;
									default:alert( "目前只支持柱形图、折线图、饼形图三种" );
								}
							}
							scope.$watchCollection('chardata.series',render)

						},
						replace:true
					}
				}).
			    directive('htFile',function($timeout,$common,$compile)	{
				return {
					restrict:'E',
					scope:{
						option: "=",
						type: "@",
						hide: "@",
				        name: "@"
					},
					template:
						'<div class="file-img" ng-show="!hide || hide==\'false\'" >' +
						'<div class="fileUpload">{{name||"上传"}}</div>'+
					    '<form enctype="multipart/form-data">'+
					    '<input name="file" type="file" multiple/></form>'+
						'<div class="progress1" ng-show="progress1Show">' +
						'<div ng-style="percentage" class="progress1bar"></div>' +
						'</div>'+
						'</div>',
					link :function($scope,element,attrs){
						$scope.progress1Show=false;
						if($scope.type=="download"){
							var _name = $scope.name||"下载";
							var div =angular.element('<div id="unload" class="file-img"><div class="fileUpload">'+_name+'</div></div>');
							element.after(div);
							element.remove();
							if($scope.hide && $scope.hide!='false'){
								div.hide();
							}
							$scope.$watch('hide',function(newVal,oldVal){
								if(newVal && newVal !='false'){
									div.hide();
								}else{
									div.show();
								}
							})
							var sendUrl = $scope.option.fileServerUrl?_FILE_SERVER_URL+"file/downloadFile.htm":_HTTP_IP_PORT+"file/download.htm";
							div.on('click',function (){
								var isSubmit = false;
								$scope.option.inputHidden.forEach(function(e){
									var val = e.value;
									if(typeof e.value =='function'){
										val = e.value();
									}
									if(val || val === 0){isSubmit = true;}
								})
								if(!isSubmit){
									$common.get_tipDialog('请选择一条文件信息！','showInform');
									return;
								}
								var form = angular.element('<form style="display: none;" />');
								//var iframe = angular.element('<iframe name="iframeTransport' + Date.now() + '">');
								var authorization ={name:'Authorization',value: window.authorization||sessionStorage.getItem("authorization")};
								$scope.option.inputHidden.push(authorization);
								$scope.option.inputHidden.forEach(function(e){
									var val = e.value;
									if(typeof e.value =='function'){
										val = e.value();
									}
									var inputHidden = angular.element('<input type="hidden" name="' + e.name + '" />');
									inputHidden.val(val);
									form.append(inputHidden);
								})
								$scope.option.inputHidden.pop();
								form.prop({
									action:sendUrl,
									method: 'POST'
									//target: iframe.prop('name')
									//enctype: 'multipart/form-data',
									//encoding: 'multipart/form-data' // old IE
								});
								form.appendTo(div);
								form.submit();
								form.remove();
							})
						}
						else if($scope.type==undefined || $scope.type=="upload"){
							var changeed = function(){
								var _that = this;
								var isSubmit = false;
								$scope.option.inputHidden.forEach(function(e){
									var val = e.value;
									if(typeof e.value =='function'){
										val = e.value();
									}
									if(val || val === 0){isSubmit = true;}
								})
								if(!isSubmit){
									$common.get_tipDialog('请传入数据项！','showInform');
									return;
								}
								$scope.$apply(function(){
										$scope.progress1Show=true;
										var xhr;
										var sendUrl = $scope.option.fileServerUrl?_FILE_SERVER_URL+"file/uploadNoPicId.htm":_HTTP_IP_PORT+"file/upload.htm";
										if(window.ActiveXObject){
											//xhr= new XDomainRequest();
											$scope.progress1Show=false;
											var form = element.find('form');
											var iframe = angular.element('<iframe name="iframeTransport' + Date.now() + '" style="display: none;">');
											//var authorization ={name:'Authorization',value: window.authorization||sessionStorage.getItem("authorization")};
											var authorization = window.authorization||sessionStorage.getItem("authorization");
											//$scope.option.inputHidden.push(authorization);
											$scope.option.inputHidden.forEach(function(e){
												var val = e.value;
												if(typeof e.value =='function'){
													val = e.value();
												}
												var inputHidden = angular.element('<input type="hidden" name="' + e.name + '" />');
												inputHidden.val(val);
												form.append(inputHidden);
											})
											form.prop({
												action:sendUrl+'?Authorization='+authorization,
												method: 'POST',
												target: iframe.prop('name'),
												enctype: 'multipart/form-data',
												encoding: 'multipart/form-data' // old IE
											});
											iframe.bind('load', function () {
												$(_that).parent().append('<input name="file" type="file" multiple/>')
												$(_that).remove();
												element.find('input').on('change',changeed);

												var html = '';
												var data,resData;
												var status = 200;
												try {
													// html='{"scubeBody":{"contextData":{"data":"%5B%22%5C%5Capps%5C%5Cscube%5C%5C20170118%5C%5C%E5%8A%9F%E8%83%BD%E9%9C%80%E6%B1%82.txt%22%2C%22%5C%5Capps%5C%5Cscube%5C%5C20170118%5C%5C%E8%B4%AD%E6%88%BF%E8%B4%B7%E6%AC%BE%E4%BA%86%E5%85%B3.png%22%2C%22%5C%5Capps%5C%5Cscube%5C%5C20170118%5C%5C%E8%B7%AF%E7%94%B1%E4%BC%A0%E5%8F%82%E6%95%B0%E9%85%8D%E7%BD%AE.docx%22%2C%22%5C%5Capps%5C%5Cscube%5C%5C20170118%5C%5C%E7%BB%9F%E4%B8%80%E5%AE%A2%E6%88%B7%E7%AB%AF-%E5%B7%A5%E4%BD%9C%E5%AE%89%E6%8E%92.xlsx%22%5D","domainVilidate":"domainVilidate"}},"scubeHeader":{"errorCode":"SUC","errorMsg":"","transCode":"","x-session-token":"x-session-token"}}'

													html = iframe[0].contentDocument.body.innerHTML;
												} catch (e) {
													status = 500;
												}
												try {
													resData = JSON.parse(html);
												}catch (e){
													if($scope.option.callbackFun){
														resData = {
															data:resData,
															errorCode:''
														};
														$scope.option.callbackFun(resData,status);
													}
													element.find('input[type=hidden]').remove();
													element.find('iframe').remove();
													return;
												}
												try {
													data = JSON.parse(decodeURI(resData.scubeBody.contextData.data).replace(/\%2C/g,','))
												}catch (e){
													data =decodeURI(resData.scubeBody.contextData.data).replace(/\%2C/g,',')
												}
												resData = {
													data:data,
													errorCode:resData.scubeHeader.errorCode
												};
												if($scope.option.callbackFun){
													$scope.option.callbackFun(resData,status);
												}
												element.find('input[type=hidden]').remove();
												element.find('iframe').remove();
											});
											iframe.appendTo(form);
											form.submit();
										}
										else if (window.XMLHttpRequest) {
											xhr= new XMLHttpRequest();

											var formdata = new FormData(element.find('form')[0]);
											$scope.option.inputHidden.forEach(function(e){
												var val = e.value;
												if(typeof e.value =='function'){
													val = e.value();
												}
												formdata.append(e.name,val);
											})
											xhr.onload = function(){
												//添加
												$(_that).parent().append('<input name="file" type="file" multiple/>')
												$(_that).remove();
												element.find('input').on('change',changeed);

												var data,resData;
												try {
													resData = JSON.parse(xhr.response);
												}catch (e){
													if($scope.option.callbackFun){
														resData = {
															data:resData,
															errorCode:''
														};
														$scope.option.callbackFun(resData,xhr.status);
													}
													return;
												}
												try {
													data = JSON.parse(decodeURI(resData.scubeBody.contextData.data).replace(/\%2C/g,','));
												}catch (e){
													data =decodeURI(resData.scubeBody.contextData.data).replace(/\%2C/g,',')
												}
												resData = {
													data:data,
													errorCode:resData.scubeHeader.errorCode
												};
												//function _isSuccessCode(status) {
												//	return status >= 200 && status < 300 || status === 304;
												//};
												if($scope.option.callbackFun){
													$scope.option.callbackFun(resData,xhr.status);
												}
											};
											xhr.upload.onprogress = function (event) {
												var progress = Math.round(event.lengthComputable ? event.loaded * 100 / event.total : 0);
												$scope.$apply(function(){
													$scope.percentage = {
														"width":progress+"%"
													}
													if(progress==100){
														$scope.progress1Show=false;
														$scope.percentage = {
															"width":"0%"
														}
													}
												});
											};
											var authorization = window.authorization||sessionStorage.getItem("authorization");
											sendUrl = sendUrl+'?Authorization='+authorization;
											xhr.open('post',sendUrl);
											xhr.setRequestHeader("authorization",window.authorization||sessionStorage.getItem("authorization"));
											xhr.send(formdata);
										}
								})
							}
							element.find('input').on('change',changeed);
						}
					},
					replace:true
				}
			});
		});
	angular.module('common',['components','ngDialog']).
		config(function ($provide,$compileProvider,$httpProvider) {
			$httpProvider.interceptors.push('httpInterceptor');
			//http拦截器服务
			$provide.factory('httpInterceptor', [ '$q', '$injector',function($q, $injector)
			{
				var httpInterceptor = {
					'request': function(config) {
						var tempConfigUrl;
						config.tempConfigUrl=config.url;
						config.headers.authorization=window.authorization||sessionStorage.getItem("authorization");
						if(config.url.indexOf('.html') ==-1){
							tempConfigUrl = config.url;
							if( (typeof _REQUEST_DSSIGN !=='undefined')&& _REQUEST_DSSIGN =='mock'){
								if(window._REQUEST_DSSIGN_LOGIN !==undefined && _REQUEST_DSSIGN_LOGIN.indexOf(config.url)!==-1){
									config.url = _HTTP_IP_PORT+config.url+".htm";
								}else {
									config.url = _JSON_URL;
									//config.url ="http://170.252.200.63:18081/authority-app/"+config.url+".htm";
								}
							}else if((typeof _REQUEST_DSSIGN !=='undefined')&& _REQUEST_DSSIGN =='common'){
								if(config.url.indexOf("http")==-1){
									config.url = _HTTP_IP_PORT+config.url+".htm";
								}
							} else{
								if(config.url.indexOf("http")==-1){
									config.url = _HTTP_IP_PORT+config.url+".htm";
								}
							}
							var data = {};
							data.scubeHeader = {
								'transCode' :tempConfigUrl,
								'errorCode' :'',
								'errorMsg' :''
							};
							if(config.data.headers !=undefined && typeof config.data.headers =='object'){
								angular.extend(data.scubeHeader,config.data.headers);
								delete config.data.headers;
							}
							data.scubeBody = {
								'contextData' :{
									'domainVilidate' :'',
									'data' :config.data
								}
							};
							//config.data = data;
							config.data = {
								'queryTable' :data
							};
							//console.log("Request数据 :"+JSON.stringify(config));
						}else {
							var timestamp = new Date().getTime();
							config.url = config.url+'?_='+timestamp;
						}
						config.requestTimestamp = new Date().toLocaleTimeString();//时间戳
						return config || $q.when(config);
					},
					'response' : function(response) {
						response.config.responseTimestamp = new Date().toLocaleTimeString();
						//var time = response.config.responseTimestamp - response.config.requestTimestamp;
						if(response.config.url.indexOf('.html') ==-1) {
							var errorCode = "";
							var errorMsg = "";
							var contextData = "";
							var sessionToken = "";
							if ((typeof _REQUEST_DSSIGN !=='undefined')&& _REQUEST_DSSIGN == "common") {
								errorCode = response.data.scubeHeader.errorCode;
								errorMsg = response.data.scubeHeader.errorMsg;
								sessionToken = response.data.scubeHeader.sessionToken;
								try {
									contextData = JSON.parse(response.data.scubeBody.contextData.data);
								}catch (e){
									contextData ="";
								}
							} else
							if ((typeof _REQUEST_DSSIGN !=='undefined')&& _REQUEST_DSSIGN == "mock") {
								if(window._REQUEST_DSSIGN_LOGIN !==undefined && _REQUEST_DSSIGN_LOGIN.indexOf(response.config.tempConfigUrl)!==-1){
									errorCode = response.data.scubeHeader.errorCode;
									errorMsg = response.data.scubeHeader.errorMsg;
									sessionToken = response.data.scubeHeader.sessionToken;
									try {
										contextData = JSON.parse(response.data.scubeBody.contextData.data);
									}catch (e){
										contextData ="";
									}
								}else{
									errorCode = response.data[response.config.tempConfigUrl].scubeHeader.errorCode;
									errorMsg = response.data[response.config.tempConfigUrl].scubeHeader.errorMsg;
									sessionToken = response.data[response.config.tempConfigUrl].scubeHeader.sessionToken;
									contextData = response.data[response.config.tempConfigUrl].scubeBody.contextData.data;
								}
							}
							else {
								errorCode = response.data.scubeHeader.errorCode;
								errorMsg = response.data.scubeHeader.errorMsg;
								sessionToken = response.data.scubeHeader.sessionToken;
								try {
									contextData = JSON.parse(response.data.scubeBody.contextData.data);
								}catch (e){
									contextData ="";
								}
							}
							response.data.errorCode = errorCode;
							try{
								if(errorCode=='UNA'){
									var _href = window.top.location.href.split('/');
									window.top.location.href = _href[0]+"//"+_href[2]+"/"+_href[3]+"/"+_href[4];
									return
								};
								response.data.errorMsg = JSON.parse(errorMsg).error_message;
								//response.data.r = JSON.parse(errorMsg).r;
								response.data.errorCD = JSON.parse(errorMsg).error_code;
							}catch (e){
								response.data.errorMsg = errorMsg;
							}
							if (sessionToken){response.data.sessionToken = sessionToken;}
							response.data.contextData = contextData;
						}
						else{
							var common_autowired_reg=/<ht\-position[^>]+[\/>,</ht\-position>]/ig;
							var common_autowired_flag=true;
							var common_autowired_begin;
							var renderName;
							var dom;
							var data=null;
							while(common_autowired_flag){
								rootname=null;
								common_autowired_begin = common_autowired_reg.exec(response.data);
								if(common_autowired_begin==null||common_autowired_begin.length==0){
									common_autowired_flag=false;
								}else{
									dom = $(common_autowired_begin[0]);
									renderName=dom.attr("batchNo");
									if(data==null){
										var batchno=dom.attr("batchNo");
										var batchid=dom.attr("id");
										try {
											if(batchid != ''){
												//batchno=eval("common_returnBatchNo").call(this);
												batchno = batchTagsMap[batchid];
												renderName = batchno;
												response.data=response.data.replace("batchNo=\""+dom.attr("batchNo")+"\"","batchNo=\""+batchno+"\"");
											}

										var dataParam = {
											"queryTable":{
												"scubeHeader":{"transCode":"dynamicFormService/queryHtmlPattern", "errorCode":"", "errorMsg":""},
												"scubeBody":{"contextData":{"domainVilidate":"",
													"data":{
														"batchNo":batchno
													}}}}};
										$.ajax({
											url:window.httpIpPort+'dynamicFormService/queryHtmlPattern.htm',
											type:'post',
											data:JSON.stringify(dataParam),
											async:false,
											headers:{
												"authorization" :window.authorization||localStorage.getItem("authorization")
											},
											dataType:'html',
											success:function(res){
												if(!res){
													return;
												}
												res = JSON.parse(res);
												data = eval("("+res.scubeBody.contextData.data+")");
												//console.log("我的模板："+data);
											},
											error:function(res){
												throw new Error("请求模板错误");
											}
										});
										}catch (e){

										}
									}
									var bindName=dom.attr("bindName");
									if(data!= null&&data[renderName]!=null) {
										data[renderName] = data[renderName].replace(new RegExp("ng-model=\"", "gm"), "ng-model=\"" + bindName + ".")
										response.data = response.data.substring(0,common_autowired_begin.index)+data[renderName]+
											response.data.substring(common_autowired_begin.index+common_autowired_begin[0].length);
									}else{
										response.data = response.data.substring(0,common_autowired_begin.index)+
											response.data.substring(common_autowired_begin.index+common_autowired_begin[0].length);									}
								}
							}

					}
					return response;
				},
					'requestError':function(config){
						//alert("requestError!");
						return $q.reject("requestError!");
					},
					'responseError' : function(response) {
						if (response.status == 401) {
							var data=''
							try {
								if(response.data.message){
									data =encodeURIComponent(response.data.message);
									alert(response.data.message);
								}
							}catch (e){
								alert("错误401,点击确定跳转至登录界面。");
							}
							if(response.data.redirectLoginUrl && response.data.redirectLoginUrl.indexOf("http")!=-1){
								window.top.location.href =response.data.redirectLoginUrl+"?msg="+data;
							}else {
								var _href = window.top.location.href;
								if(_REQUEST_DSSIGN =='common'){
									_href =_href.split('/');
									window.top.location.href = _href[0]+"//"+_href[2]+"/"+_href[3]+"/";
								}else {
									_href = _href.substring(0,_href.indexOf("scube_ui"));
									window.top.location.href = _href+"scube_ui/login_module/html/login.html?msg="+data;
								}
								//window.top.location.href = _href[0]+"//"+_href[2]+"/"+_href[3]+"/"+_href[4]+"/login_module/html/login.html?msg="+data;
							}
							return $q.reject(response);
						} else if (response.status === 404) {
							return $q.reject(response);
						}
					}
			}
			return httpInterceptor;
		}]);
			//事件监听服务
			$provide.factory('$eventCommunicationChannel',['$rootScope',function ($rootScope) {
				var _EDIT_DATA_ = '_EDIT_DATA_';//表示我们需要编辑跟随信息传过来的数据
				var _DATA_UPDATED_ = '_DATA_UPDATED_';//表示我们的数据已经被改变

				var editData = function (item) {
					$rootScope.$broadcast(_EDIT_DATA_, {item: item});
				};
				var onEditData = function($scope, handler) {
					$scope.$on(_EDIT_DATA_, function(event, args) {
						handler(args.item);
					});
				};
				var createEvent = function (evName,item) {
					$rootScope.$broadcast(evName, {item: item});
				};
				var onEvent = function(evName,$scope,handler) {
					if(evName!==undefined &&evName!==null && evName!==""){
						$scope.$on(evName, function(event, args) {
							handler(args.item);
						});
					}else{
						throw Error("事件名："+evName+",不能为空");
						return
					}
				};
				var dataUpdated = function () {
					$rootScope.$broadcast(_DATA_UPDATED_);
				};
				var onDataUpdated = function ($scope, handler) {
					$scope.$on(_DATA_UPDATED_, function (event) {
						handler();
					});
				};
				return {
					editData: editData,
					onEditData: onEditData,
					createEvent: createEvent,
					onEvent: onEvent,
					dataUpdated: dataUpdated,
					onDataUpdated: onDataUpdated
				};
			}]);
			//切换视图传递数据服务
			$provide.factory('dataDeliver', function () {
				//定义参数对象
				var deliverObject = {};
				/**
				 * @private
				 */
				var _setter = function (data) {
					deliverObject = data;
				};
				/**
				 * @private
				 */
				var _getter = function () {
					return deliverObject;
				};
				// Public APIs
				// 在controller中通过调setter()和getter()方法可实现提交或获取参数的功能
				return {
					setter: _setter,
					getter: _getter
				};
			});
			//通用服务
			$provide.factory('$common',function ($http,$q,ngDialog) {
				var common = {
					//暂未提供
					get_commDialog:function(content){
						var _content= {
							temp: '',
							title:'标题',
							data:{},
							ok: true,
							cancel: true,
							okFun: function(){},
							cancelFun: function(){},
							width:"300px",
							height:"80px"
						};
						var regUrl = /^http[s]?:\/\/[\\w\\.\\-]+$/;
						var _commDialogId= 'commDialog'+Math.random().toString().slice(2);
						content||(content={});
						angular.extend(_content,content);
						try {
						    var winName = JSON.parse(window.name);
						    winName.parantData = _content.data;
						    window.name= JSON.stringify(winName);
						}catch (e){
						    console.log(e);
						    window.name= JSON.stringify({parantData: _content.data});
						}
						var _commDialog =$(
							'<div id="'+_commDialogId+'" class="ngdialog ngdialog-theme-plain" role="alertdialog">' +
							'<div class="ngdialog-overlay"></div>' +
							'<div class="ngdialog-content" style="width: '+_content.width+';" role="document">' +
							'<div class="ngdialog-title">' +
							'<span tabindex="-1" style="outline: 0px;"> '+_content.title+' </span>' +
							'</div>' +
							'<div>' +
							'<iframe src="'+_content.temp+'" width="100%" height="100%" frameborder="0" scrolling="yes"></iframe>' +
							'</div>'+
							'<div class="center ht-button-group">' +
							'<button name="ok" class="btn-primary btn btn-sm" ng-class="classNameArr">' +
							'<span>确定</span></button>' +
							'<button name="cancel" class="btn btn-sm" ng-class="classNameArr">' +
							'<span>取消</span></button>' +
							'</div></div></div>'
						);
						document.body.appendChild(_commDialog[0]);
						//if(!regUrl.test(_content.temp)){
						//	$("#"+_commDialogId).find("iframe").append(_content.temp);
						//}
						if(!_content.ok){
							$("#"+_commDialogId).find("button[name=ok]").hide();
						}
						if(!_content.cancel){
							$("#"+_commDialogId).find("button[name=cancel]").hide();
						}
						$("#"+_commDialogId).find("button[name=ok]").on('click',function(){
							_content.okFun();
						})
						$("#"+_commDialogId).find("button[name=cancel]").on('click',function(){
							_content.cancelFun();
							dialog.closeDialog();
						})
						var Dialog = function (){
							this.closeDialog = function (){
								$("#"+_commDialogId).remove();
							}
						}
						var dialog = new Dialog();
						return dialog;
					},
					//摸态框
					get_ngDialog:function(template,scope,controller,title,showClose,width,draggable){
						var _option = arguments[0];
						if(Object.prototype.toString.call(_option)!=='[object Object]'){
							var showClose = arguments[4]||{};
							var _option={
								template: template,//模式对话框内容 或指定的.html
								width: width||900,
								title:title,
								controller:controller,
								showClose: showClose.showClose||false,
								draggable:draggable?true:false,
								scope:scope //将scope传给template,以便判断类型
							}
						}
						var defaults={
							template: '',//模式对话框内容 或指定的.html
							className: 'ngdialog-theme-plain',
							width: 900,
							title: '',
							plain: false,//判断是否使用html页作为模板，默认为false使用html页面模板
							controller: '',
							showClose: true,
							draggable: false,
                            noTip:true,
							scope: '' //将scope传给template,以便判断类型
						}
						angular.extend(defaults,_option);
						if(!defaults.title){
							defaults.showTitle = false;
						};
						var ret = ngDialog.openConfirm(defaults);
						return ret;
					},
					//提示框
					get_tipDialog:function(content,type){
						if(content!==""&&content!==null&&content!==undefined){
							var ret;
							var map = {
								template: content,//模式对话框内容 或指定的.html
								className: 'ngdialog-theme-plain',
								width:400,
								showTitle:false,
								plain:true//判断是否使用html页作为模板，默认为false使用html页面模板
							};
							type=type?type:'showSuccess';
							map[type]=true
							if(type == 'showTip'){
								ret = ngDialog.openConfirm(map)
							}else {
								ret = ngDialog.open(map);
							}
							return ret;
						};
					},
					//http请求
					get_asyncData:function(url,data,ajaxfun,hraders){
						if(!url) {alert("url不能为空");return;}
						var _hraders = {
							'Content-Type': 'application/x-www-form-urlencoded'
						};
						//_hraders = angular.extend(_hraders,hraders);
						ajaxfun=(null == ajaxfun||"" == ajaxfun)?{}:ajaxfun;
						ajaxfun.type = (ajaxfun.type == null || ajaxfun.type == "" || typeof (ajaxfun.type) == "undefined") ? "post" : ajaxfun.type;
						var deferred = $q.defer();
						$http({
							url:url,
							method:ajaxfun.type,
							headers: _hraders,
							data:data?data:{},
							responseType:'json'
						}).then(function(res){
							deferred.resolve(res.data);
						},function(res){
							//var errorMsg =res.data?res.data.errorMsg:"";
							//common.get_tipDialog(res.status+"错误<br>"+errorMsg,'showError')
							deferred.reject(res);
						})
						return deferred.promise;
					},
					//金额格式化
					get_currFormat:function(modelValue){
						//if(modelValue.indexOf("$")>-1){
						//	modelValue = modelValue.substr(1,modelValue.length-1);
						//}
						var f = parseFloat(modelValue);
						if (isNaN(f)) {
							return false;
						}
						f = Math.round(f*100)/100;
						var s = f.toString();
						var rs = s.indexOf('.');
						var t = 0;
						if (rs < 0) {
							s= s.split("");
							rs = s.length;
							var j =rs%3;
							if(j){
								j = Math.ceil(rs/3);
							}else{
								j = rs/3;
							}
							for(var i=1;i<j;i++){
								s.splice(s.length-i*3-(i-1),0,',');
								t++;
							}
							s = s.join("");
							s += '.';
						}else{
							var _s = s.substr(rs);
							s = s.substr(0,rs);
							s= s.split("");
							var j =rs%3;
							if(j){
								j = Math.ceil(rs/3);
							}else{
								j = rs/3;
							}
							for(var i=1;i<j;i++){
								s.splice(s.length-i*3-(i-1),0,',');
								t++;
							}
							s = s.join("");
							s = s+_s;
						}
						while (s.length-t <= rs + 2) {
							s += '0';
						}
						return s;
					},
					copy:function (src, dst) {
						if (angular.isArray(src)) {
							dst = dst || [];

							for ( var i = 0; i < src.length; i++) {
								dst[i] = src[i];
							}
						}
						else if (angular.isObject(src)) {
							dst = dst || {};

							for (var key in src) {
								if (src.hasOwnProperty(key) && !(key.charAt(0) === '$' && key.charAt(1) === '$')) {
									dst[key] = src[key];
								}
							}
						}
						return dst || src;
					}
				};
				return common;
			});
			$compileProvider.
			    //监听input标签事件
			    directive('htEventListence',function($rootScope){
				return{
					link:function(scope,elem,attrs){
						function addEvent(obj,trigger,fun) {
							if(obj.addEventListener){
								obj.addEventListener(trigger,fun,false);
							}else if (obj.attachEvent){
								obj.attachEvent('on'+trigger,fun);
							}else{
								obj['on'+trigger] = fun;
							}
						}
						if(attrs.id !=="" && attrs.id !==undefined){
							try {
								addEvent(elem[0],'click',scope.parentScope[attrs.id+'_onClick']);
							}catch (e){}
							try {
								addEvent(elem[0],'keyup',scope.parentScope[attrs.id+'_onKeyup']);
							}catch (e){}
							try {
								addEvent(elem[0],'focus',scope.parentScope[attrs.id+'_onFocus']);
							}catch (e){}
							try {
								addEvent(elem[0],'blur',scope.parentScope[attrs.id+'_onBlur']);
							}catch (e){}
							try {
								addEvent(elem[0],'change',scope.parentScope[attrs.id+'_onChange']);
							}catch (e){}

						}
					}
				}

			}).
				//数据字典
				directive('htDictionary',function(){
					return {
						restrict:'A',
						link:function(scope,element,attrs){
							scope.dicArr=[];
							var dictCode = attrs.htDictionary;
							if(!dictCode) return;
							var dicVal ='';
							if(attrs.dicVal && attrs.dicVal !=='none'){
								//dicVal = scope.$eval(attrs.dicVal);
								dicVal = attrs.dicVal;
							}
							if(dictionary !==''&& dictionary !==undefined){
								if(typeof dictionary =='object'&&dictionary.length==null){
									if(dictionary[dictCode]){
										if(!dicVal && dicVal!==0){
											scope.dicArr = dictionary[dictCode].dataItems;
										}else{
											for (var j = 0;j<dictionary[dictCode].dataItems.length;j++) {
												if(dictionary[dictCode].dataItems[j].dataVal == dicVal){
													scope.dicArr.push(dictionary[dictCode].dataItems[j]);
													break;
												}
											}
										}
									}
								}
								else {
									for (var i = 0;i<dictionary.length;i++){
										if(dictionary[i].dictCode==dictCode){
											if(!dicVal && dicVal!==0){
												scope.dicArr = dictionary[i].dataItems;
											}else{
												for (var j = 0;j<dictionary[i].dataItems.length;j++) {
													if(dictionary[i].dataItems[j].dataVal == dicVal){
														scope.dicArr.push(dictionary[i].dataItems[j]);
														break;
													}
												}
											}
											break;
										}
									}
								}
							}else{
								alert("dictionary不存在");
							}
						}
					}
				}).
				//校验属性
			    directive('regString',function(){
				return {
					restrict:'A',
					priority:101,
					link:function(scope,element,attrs){
						//判断是否有自定义msg
						var msg=[];
						scope.expMsg='';
						if(msg.length<=0){
							if(window.validate && window.zValidate) {
								var ruleName=attrs.regString.split(",");
								for (var j = 0; j < ruleName.length; j++) {
									if (ruleName[j].indexOf("common.")>-1) {
										var aliasName = ruleName[j].split(".")[1];
										if(window.zValidate.ruleName.indexOf(aliasName)>-1){
											if (window.zValidate[aliasName].rule != null) {
												msg.push(window.zValidate[aliasName].errMsg);
											}
										}
									}else {
										for (var i = 0; i < window.validate.length; i++) {
											var newArr = window.validate[i];
											if (newArr.ruleName == ruleName[j]) {
												if (newArr.rule != null) {
													msg.push(newArr.errMsg);
												}
											}
										}
									}
								}
							}
						}
						scope.expMsg=msg.join(",");
						if(element[0].tagName== "SELECT"){
							angular.element(element).on('change',validateBefore)
						}else {
							angular.element(element).on('blur',validateBefore);
						}
					}
				}
			}).
				//上传图片
				directive('htThumb', ['$window','$compile', function($window,$compile) {
					var helper = {
						support: !!($window.FileReader && $window.CanvasRenderingContext2D),
						isFile: function(item) {
							return angular.isObject(item) && item instanceof $window.File;
						},
						isImage: function(file) {
							var type =  '|' + file.type.slice(file.type.lastIndexOf('/') + 1) + '|';
							return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
						}
					};
					return {
						restrict: 'A',
						template: '<canvas ng-style="canvasStyle"/>',
						link: function(scope, element, attributes) {
							if (!helper.support) return;

							var params = scope.$eval(attributes.htThumb);
							params.size = params.size?params.size:100;
							scope.canvasStyle = {
								'border-radius':params.size/2
							}
							if (!helper.isFile(params.file)) return;
							if (!helper.isImage(params.file)) {
								angular.element(element).empty();
								return
							};
							var canvas = element.find('canvas');
							var reader = new FileReader();
							reader.onload = onLoadFile;
							reader.readAsDataURL(params.file);

							var imgSrc = '';
							function onLoadFile(event) {
								var img = new Image();
								img.onload = onLoadImage;
								imgSrc = event.target.result;
								img.src = imgSrc;
								var _a =$compile('<a ng-click="showLoading()"></a>')(scope);
								canvas.wrap(_a)
							}

							function onLoadImage() {
								var width =params.size;//params.width || this.width / this.height * params.height;
								var height =params.size;//params.height || this.height / this.width * params.width;
								canvas.attr({ width: width, height: height});
								canvas[0].getContext('2d').drawImage(this, 0, 0, width, height);
								var oUl=$('.list');
								var aLi = '<li></li>';
								var count=0;
								function progress() {
									oUl.append(aLi);
									count++;
									//console.log(count);
									if(count==24){
										clearInterval(start);
									}
								}
								var start=setInterval(progress,100);
								$('.pic-del').click(function () {
									$(this).parent().hide();
								})
							}

							scope.showLoading = function(){
								var $loading = $('<div class="loading-modal" style="background: rgba(0,0,0,0.6);;width:100%;height:100%;position:fixed;top: 0;left: 0;z-index: 12;">'+
									'<div class="loading" style="position: absolute;top:50%;left: 50%;transform: translate(-50%,-50%)">'+
									'<img class="img-responsive" src="'+imgSrc+'">'+
									'</div>'+
									'<div class="loading-close" style="cursor:pointer;font-size: larger;position:absolute;top:10px;right:10px;"><i class="glyphicon glyphicon-remove"></i></div>' +
									'</div>');
								$loading.appendTo("body");
								$loading.find(".loading-close").hover(function(){
									$(this).css("color", "red");
								}, function(){
									$(this).css("color", "black");
								}).click(function(){
									$(".loading-modal").remove();
								});
							};
						}
					};
				}])
		});
}())

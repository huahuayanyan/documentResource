/**
 * Created by wubin on 2016/5/9.
 */
(function(){
    angular.module('services.getFormElem',[]).
    factory('getFormElem',function($injector){
        //实现Map功能
        function HashMap() {
            var entry = new Object();
            var size = 0;
            // 存储
            this.put = function (key, value) {
                if (!this.containsKey(key)) {
                    size++;
                }
                entry[key] = value;
            };
            // 根据Key获取值
            this.get = function (key) {
                if (this.containsKey(key)) {
                    return entry[key];
                }
                return null;
            };
            // 根据Key删除值
            this.remove = function (key) {
                if (delete entry[key]) {
                    size--;
                }
            };

            // Key 在是否存在
            this.containsKey = function (key) {
                return (key in entry);
            };

            // Value 是否存在
            this.containsValue = function (value) {
                for (var prop in entry) {
                    if (entry[prop] == value) {
                        return true;
                    }
                }
                return false;
            };
            // Value 转换成数组
            this.values = function () {
                var values = new Array();
                for (var prop in entry) {
                    values.push(entry[prop]);
                }
                return values;
            };
            // key 转换成数组
            this.keys = function () {
                var keys = new Array();
                for (var prop in entry) {
                    keys.push(prop);
                }
                return keys;
            };
            // 大小
            this.size = function () {
                return size;
            };

            this.removeAll = function() {
                for (var prop in entry) {
                    delete entry[prop];
                    size--;
                }
            };
        };
        return angular.extend({},
            {
                findRootForm : function (scope, rootFormId) {
                    return this.addFormAttr(scope, rootFormId);
                },
                addFormAttr : function (scope, formId) {
                    debugger;
                    var obj = {};
                    var vid = "#"+formId;
                    var lastFieldName = "";
                    var arr = [];
                    angular.forEach($(vid),function (val,key) {
                        var elems = angular.element(val).find("input,select,textarea");
                        var keepGoing = true;
                        angular.forEach(elems,function (_val,key) {
                            if(keepGoing){
                                var el = angular.element(_val);
                                if (el.attr("type") == "button" ||el.attr("type") == "submit") {
                                    //过滤button/submit
                                }else {
                                    var fieldName = el.attr("ng-model") == undefined ? el.attr("id") || el.attr("name") :el.attr("ng-model");
                                    if (fieldName == null || fieldName == "" || fieldName == undefined) {
                                        alert('控件没有ng-model绑定数据');
                                        keepGoing = false;
                                        obj = {};
                                        return
                                    }
                                    if (el.attr("type") == "radio" || el.attr("type") == "checkbox") {
                                        if (el[0].checked) {
                                            obj[fieldName] = scope[fieldName];
                                        }
                                    } else {
                                        var fieldValue;
                                        fieldValue = scope.form[$injector.invoke(function () {
                                            return fieldName.slice(5,fieldName.length+1);
                                        })];
                                        if(typeof fieldValue == "object"){
                                            fieldValue = fieldValue.key;
                                        }
                                        obj[fieldName.slice(5,fieldName.length+1)] = fieldValue;
                                    }
                                }
                            }
                        });
                    })
                    return obj;
                }
        })
    });
}());

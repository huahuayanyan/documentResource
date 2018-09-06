/* commonjs package manager support (eg componentjs) */
if (typeof module !== "undefined" && typeof exports !== "undefined" && module.exports === exports){
  module.exports = 'treeControl';
}
(function ( angular ) {
    'use strict';
    
    angular.module( 'treeControl', [] )
        .constant('treeConfig', {
            templateUrl: null
        })
        .directive( 'treecontrol', ['$compile', function( $compile ) {
            /**
             * @param cssClass - the css class
             * @param addClassProperty - should we wrap the class name with class=""
             */
            function classIfDefined(cssClass, addClassProperty) {
                if (cssClass) {
                    if (addClassProperty)
                        return 'class="' + cssClass + '"';
                    else
                        return cssClass;
                }
                else
                    return "";
            }
            
            function ensureDefault(obj, prop, value) {
                if (!obj.hasOwnProperty(prop))
                    obj[prop] = value;
            }
            
            return {
                restrict: 'EA',
                require: "treecontrol",
                transclude: true,
                scope: {
                    treeModel: "=",
                    selectedNode: "=?",
                    selectedNodes: "=?",
                    expandedNodes: "=?",
                    onSelection: "&",
                    onNodeToggle: "&",
                    options: "=?",
                    orderBy: "@",
                    reverseOrder: "@",
                    filterExpression: "=?",
                    filterComparator: "=?"
                },
                template:'<div class="treecontrol"></div>',
                controller: ['$scope', '$templateCache', '$interpolate', 'treeConfig', function( $scope, $templateCache, $interpolate, treeConfig ) {
                    function defaultIsLeaf(node) {
                        return !node[$scope.options.nodeChildren] || node[$scope.options.nodeChildren].length === 0;
                    }
                    function shallowCopy(src, dst) {
                        if (angular.isArray(src)) {
                            dst = dst || [];

                            for ( var i = 0; i < src.length; i++) {
                                dst[i] = src[i];
                            }
                        } else if (angular.isObject(src)) {
                            dst = dst || {};

                            for (var key in src) {//hasOwnProperty.call(src, key)
                                if (src.hasOwnProperty( key) && !(key.charAt(0) === '$' && key.charAt(1) === '$')) {
                                    dst[key] = src[key];
                                }
                            }
                        }

                        return dst || src;
                    }
                    function defaultEquality(a, b) {
                        if (a === undefined || b === undefined)
                            return false;
                        a = shallowCopy(a);
                        a[$scope.options.nodeChildren] = [];
                        b = shallowCopy(b);
                        b[$scope.options.nodeChildren] = [];
                        return angular.equals(a, b);
                    }
                    function defaultIsSelectable(node) {
                        //return $scope.options.isLeaf(node);
                        return true;
                    }

                    $scope.options = $scope.options || {};
                    ensureDefault($scope.options, "multiSelection", true);
                    ensureDefault($scope.options, "nodeChildren", "children");
                    ensureDefault($scope.options, "dirSelectable", true);
                    ensureDefault($scope.options, "injectClasses", {});
                    ensureDefault($scope.options.injectClasses, "ul", "");
                    ensureDefault($scope.options.injectClasses, "li", "");
                    ensureDefault($scope.options.injectClasses, "liSelected", "");
                    ensureDefault($scope.options.injectClasses, "iExpanded", "");
                    ensureDefault($scope.options.injectClasses, "iCollapsed", "");
                    ensureDefault($scope.options.injectClasses, "iLeaf", "");
                    ensureDefault($scope.options.injectClasses, "label", "");
                    ensureDefault($scope.options.injectClasses, "labelSelected", "");
                    ensureDefault($scope.options, "equality", defaultEquality);
                    ensureDefault($scope.options, "isLeaf", defaultIsLeaf);
                    ensureDefault($scope.options, "allowDeselect", true);
                    ensureDefault($scope.options, "isSelectable", defaultIsSelectable);
                  
                    $scope.selectedNodes = $scope.selectedNodes || [];
                    $scope.expandedNodes = $scope.expandedNodes || [];
                    $scope.expandedNodesMap = {};
                    for (var i=0; i < $scope.expandedNodes.length; i++) {
                        $scope.expandedNodesMap[""+i] = $scope.expandedNodes[i];
                    }
                    $scope.parentScopeOfTree = $scope.$parent;


                    function isSelectedNode(node) {
                        if (!$scope.options.multiSelection && ($scope.options.equality(node, $scope.selectedNode)))
                            return true;
                        else if ($scope.options.multiSelection && $scope.selectedNodes) {
                            for (var i = 0; (i < $scope.selectedNodes.length); i++) {
                                if ($scope.options.equality(node, $scope.selectedNodes[i])) {
                                    return true;
                                }
                            }
                            return false;
                        }else {
                            return false;
                        }
                    }

                    $scope.headClass = function(node) {
                        var liSelectionClass = classIfDefined($scope.options.injectClasses.liSelected, false);
                        var injectSelectionClass = "";
                        if (liSelectionClass && isSelectedNode(node))
                            injectSelectionClass = " " + liSelectionClass;
                        if ($scope.options.isLeaf(node))
                            return "tree-leaf" + injectSelectionClass;
                        if ($scope.expandedNodesMap[this.$id])
                            return "tree-expanded" + injectSelectionClass;
                        else
                            return "tree-collapsed" + injectSelectionClass;
                    };

                    $scope.iBranchClass = function() {
                        if ($scope.expandedNodesMap[this.$id])
                            return classIfDefined($scope.options.injectClasses.iExpanded);
                        else
                            return classIfDefined($scope.options.injectClasses.iCollapsed);
                    };

                    $scope.nodeExpanded = function() {
                        return !!$scope.expandedNodesMap[this.$id];
                    };

                    $scope.selectNodeHead = function() {

                        var transcludedScope = this;
                        var expanding = $scope.expandedNodesMap[transcludedScope.$id] === undefined;
                        $scope.expandedNodesMap[transcludedScope.$id] = (expanding ? transcludedScope.node : undefined);
                        if (expanding) {
                            $scope.expandedNodes.push(transcludedScope.node);
                        }
                        else {
                            var index;
                            for (var i=0; (i < $scope.expandedNodes.length) && !index; i++) {
                                if ($scope.options.equality($scope.expandedNodes[i], transcludedScope.node)) {
                                    index = i;
                                }
                            }
                            if (index !== undefined)
                                $scope.expandedNodes.splice(index, 1);
                        }
                        if ($scope.onNodeToggle) {
                            var parentNode = (transcludedScope.$parent.node === transcludedScope.synteticRoot)?null:transcludedScope.$parent.node;
                            $scope.onNodeToggle({node: transcludedScope.node, $parentNode: parentNode,
                              $index: transcludedScope.$index, $first: transcludedScope.$first, $middle: transcludedScope.$middle,
                              $last: transcludedScope.$last, $odd: transcludedScope.$odd, $even: transcludedScope.$even, expanded: expanding});

                        }
                    };

                    $scope.selectNodeLabel = function( selectedNode){
                        var transcludedScope = this;
                        if(!$scope.options.isLeaf(selectedNode) && (!$scope.options.dirSelectable || !$scope.options.isSelectable(selectedNode))) {
                            // Branch node is not selectable, expand
                            this.selectNodeHead();
                        }
                        else if($scope.options.isLeaf(selectedNode) && (!$scope.options.isSelectable(selectedNode))) {
                            // Leaf node is not selectable
                            return;
                        }
                        else {
                            var selected =false;
                            if(selectedNode.$$checkedFlag){
                                selectedNode.$$checkedFlag = false;
                            }else {
                                selected = selectedNode.$$checkedFlag = true;
                            }
                            updateSelected(selectedNode)
                            //if ($scope.options.multiSelection) {
                            //    var pos = -1;
                            //    for (var i=0; i < $scope.selectedNodes.length; i++) {
                            //        if($scope.options.equality(selectedNode, $scope.selectedNodes[i])) {
                            //            pos = i;
                            //            break;
                            //        }
                            //    }
                            //    if (pos === -1) {
                            //        selectedNode.$$checkedFlag=true;
                            //        //$scope.selectedNodes.push(selectedNode);
                            //        updateSelected(selectedNode)
                            //        selected = true;
                            //    } else {
                            //        selectedNode.$$checkedFlag=false;
                            //        //$scope.selectedNodes.splice(pos, 1);
                            //        updateSelected(selectedNode)
                            //    }
                            //} else {
                            //    if (!$scope.options.equality(selectedNode, $scope.selectedNode)) {
                            //        //$scope.selectedNode = selectedNode;
                            //        selectedNode.$$checkedFlag=true;
                            //        updateSelected(selectedNode)
                            //        selected = true;
                            //    }
                            //    else {
                            //        if ($scope.options.allowDeselect) {
                            //            //$scope.selectedNode = undefined;
                            //            selectedNode.$$checkedFlag=false;
                            //            updateSelected(selectedNode)
                            //        } else {
                            //            //$scope.selectedNode = selectedNode;
                            //            selectedNode.$$checkedFlag=true;
                            //            updateSelected(selectedNode)
                            //            selected = true;
                            //        }
                            //    }
                            //}
                            if ($scope.onSelection) {
                                var parentNode = (transcludedScope.$parent.node === transcludedScope.synteticRoot)?null:transcludedScope.$parent.node;
                                $scope.onSelection({node: selectedNode, selected: selected, $parentNode: parentNode,
                                  $index: transcludedScope.$index, $first: transcludedScope.$first, $middle: transcludedScope.$middle,
                                  $last: transcludedScope.$last, $odd: transcludedScope.$odd, $even: transcludedScope.$even});
                            }
                        }
                    };

                    $scope.selectedClass = function() {
                        var isThisNodeSelected = isSelectedNode(this.node);
                        var labelSelectionClass = classIfDefined($scope.options.injectClasses.labelSelected, false);
                        var injectSelectionClass = "";
                        if (labelSelectionClass && isThisNodeSelected)
                            injectSelectionClass = " " + labelSelectionClass;

                        return isThisNodeSelected ? "tree-selected" + injectSelectionClass : "";
                    };
                    //
                    //$scope.unselectableClass = function() {
                    //    var isThisNodeUnselectable = !$scope.options.isSelectable(this.node);
                    //    var labelUnselectableClass = classIfDefined($scope.options.injectClasses.labelUnselectable, false);
                    //    return isThisNodeUnselectable ? "tree-unselectable " + labelUnselectableClass : "";
                    //};

                    //tree template
                    $scope.isReverse = function() {
                      return !($scope.reverseOrder === 'false' || $scope.reverseOrder === 'False' || $scope.reverseOrder === '' || $scope.reverseOrder === false);
                    };

                    $scope.orderByFunc = function() {
                      return "'" + $scope.orderBy + "'";
                    };

                    var updateSelected = function (node,flag) {
                        if ($scope.options.multiSelection) {

                            if(typeof flag=="undefined"){
                                var up = function(upNode){
                                    if(upNode.treeParentId!=="0"){
                                        for(var m=0;m<$scope.treeModel.length;m++){
                                            if($scope.treeModel[m].treeId==upNode.treeParentId){
                                                $scope.treeModel[m].$$checkedFlag = true;

                                                var posi = -1;
                                                for (var i=0; i < $scope.selectedNodes.length; i++) {
                                                    if($scope.options.equality($scope.treeModel[m], $scope.selectedNodes[i])) {
                                                        posi = i;
                                                        break;
                                                    }
                                                }
                                                if(posi==-1){
                                                    if($scope.treeModel[m].$$checkedFlag){
                                                        $scope.selectedNodes.push($scope.treeModel[m]);
                                                    } else {
                                                        //return;
                                                    }
                                                }else{
                                                    if($scope.treeModel[m].$$checkedFlag){
                                                        //return;
                                                    } else {
                                                        $scope.selectedNodes.splice(posi, 1);
                                                    }
                                                }

                                                up($scope.treeModel[m]);
                                            };
                                        };
                                    };
                                };
                                up(node);
                            };

                            var pos = -1;
                            for (var i=0; i < $scope.selectedNodes.length; i++) {
                                if($scope.options.equality(node, $scope.selectedNodes[i])) {
                                    pos = i;
                                    break;
                                }
                            }
                            if(pos==-1){
                                if(node.$$checkedFlag){
                                    $scope.selectedNodes.push(node);
                                } else {
                                    //return;
                                }
                            }else{
                                if(node.$$checkedFlag){
                                    //return;
                                } else {
                                    $scope.selectedNodes.splice(pos, 1);
                                }
                            }
                            if(!$scope.options.isLeaf(node)){
                                angular.forEach(node.children,function(nodeChild){
                                    nodeChild.$$checkedFlag = node.$$checkedFlag;
                                    updateSelected(nodeChild,"upFlag");
                                });
                            };

                        }
                        else{
                            if(node.$$checkedFlag){
                                $scope.selectedNode = node;
                            }else{
                                //$scope.options.allowDeselect
                                $scope.selectedNode = undefined;
                            }
                        }
                    }
                    $scope.updateSelection = function ($event, node) {
                        var checkbox = $event.target;
                        node.$$checkedFlag = checkbox.checked;
                        updateSelected(node)
                    };
                    $scope.isSelected = function (node) {
                        if (!$scope.options.multiSelection) {
                            node.$$checkedFlag = isSelectedNode(node);
                        }else if(!node.hasOwnProperty("$$checkedFlag")){
                            //hasOwnProperty.call(node, "$$checkedFlag")
                            node.$$checkedFlag = isSelectedNode(node);
                        }
                        return node.$$checkedFlag||false;
                    };

                    var templateOptions = {
                        orderBy: $scope.orderBy ? " | orderBy:orderByFunc():isReverse()" : '',
                        ulClass: classIfDefined($scope.options.injectClasses.ul, true),
                        nodeChildren:  $scope.options.nodeChildren,
                        checkedhiden:$scope.options.checkedhiden,
                        liClass: classIfDefined($scope.options.injectClasses.li, true),
                        iLeafClass: classIfDefined($scope.options.injectClasses.iLeaf, false),
                        labelClass: classIfDefined($scope.options.injectClasses.label, false)
                    };

                    var template;
                    var templateUrl = $scope.options.templateUrl || treeConfig.templateUrl;

                    if(templateUrl) {
                        template = $templateCache.get(templateUrl);
                    }
                    if(!template) {
                        template =
                            '<ul {{options.ulClass}} >' +
                            '<li ng-repeat="node in node.{{options.nodeChildren}} | filter:filterExpression:filterComparator {{options.orderBy}}" ng-class="headClass(node)" {{options.liClass}}' +
                            'set-node-to-data>' +
                            '<i class="tree-branch-head" ng-class="iBranchClass()" ng-click="selectNodeHead(node)"></i>' +
                                //'<i class="tree-branch-head2"></i>'+
                            '<i class="tree-leaf-head {{options.iLeafClass}}"></i>' +
                            '<input type="checkbox" ng-show="!{{options.checkedhiden}}" ng-checked="isSelected(node)" ng-click="updateSelection($event,node)"/>' +
                            '<div class="tree-label {{options.labelClass}}" ng-click="selectNodeLabel(node)" ng-class="[selectedClass(), unselectableClass()]" tree-transclude></div>' +
                            '<treeitem ng-if="nodeExpanded()"></treeitem>' +
                            '</li>' +
                            '</ul>';
                    }

                    this.template = $compile($interpolate(template)({options: templateOptions}));
                }],
                compile: function(element, attrs, childTranscludeFn) {
                    return function ( scope, element, attrs, treemodelCntr ) {

                        scope.$watch("treeModel", function updateNodeOnRootScope(newValue) {
                            /*  从组treeModel结构
                            从组前：[{"menuId": "1005", "menuName": "预警提示", "menuPath": "", "menuUrl":"",
                               "iconName":"icon-file-alt", "menuLevel":"1", "menuParentId":""}]
                            从组后：
                            [
                             { "name" : "Joe", "age" : "21", "children" : [
                             { "name" : "Smith", "age" : "42", "children" : [] },
                             { "name" : "Gary", "age" : "21", "children" : [
                             { "name" : "Jenifer", "age" : "23", "children" : [
                             { "name" : "Dani", "age" : "32", "children" : [] },
                             { "name" : "Max", "age" : "34", "children" : [] }
                             ]}
                             ]}
                             ]}];*/
                            var maxLevel = 1;//定义菜单数量级
                            var treeStructor = function (treeModel,level,parentTreeNode){
                                var arr =[];
                                if(!parentTreeNode){
                                    parentTreeNode={treeId:"0"};
                                }
                                arr = treeModel.filter(function (element,index,_newValue) {
                                    return (element.treeLevel == level && element.treeParentId ==parentTreeNode.treeId)
                                })
                                arr = arr.map(function (elem) {
                                    var childNodes=[];
                                    var treeLevel = elem.treeLevel;
                                    if(treeLevel<maxLevel){
                                        treeLevel++;
                                        childNodes = treeStructor(newValue,treeLevel,elem)
                                    }
                                    elem.children = childNodes;
                                    return elem;
                                })
                                return arr;
                            }
                            if(newValue !== undefined){
                                for(var i = 0; i<newValue.length;i++){
                                    var _maxLevel = parseInt(newValue[i].treeLevel);
                                    if(maxLevel<_maxLevel) maxLevel = _maxLevel;
                                }
                                newValue= treeStructor(newValue,1);
                            }//从组treeModel结构结束

                            if (angular.isArray(newValue)) {
                                //if (angular.isDefined(scope.node) && angular.equals(scope.node[scope.options.nodeChildren], newValue))
                                //    return;
                                scope.node = {};
                                scope.synteticRoot = scope.node;
                                scope.node[scope.options.nodeChildren] = newValue;
                            }
                            else {
                                if (angular.equals(scope.node, newValue))
                                    return;
                                scope.node = newValue;
                            }
                        });

                        scope.$watchCollection('expandedNodes', function(newValue, oldValue) {
                            var notFoundIds = 0;
                            var newExpandedNodesMap = {};
                            var $liElements = element.find('li');
                            var existingScopes = [];
                            // find all nodes visible on the tree and the scope $id of the scopes including them
                            angular.forEach($liElements, function(liElement) {
                                var $liElement = angular.element(liElement);
                                var liScope = {
                                    $id: $liElement.data('scope-id'),
                                    node: $liElement.data('node')
                                };
                                existingScopes.push(liScope);
                            });
                            // iterate over the newValue, the new expanded nodes, and for each find it in the existingNodesAndScopes
                            // if found, add the mapping $id -> node into newExpandedNodesMap
                            // if not found, add the mapping num -> node into newExpandedNodesMap
                            angular.forEach(newValue, function(newExNode) {
                                var found = false;
                                for (var i=0; (i < existingScopes.length) && !found; i++) {
                                    var existingScope = existingScopes[i];
                                    if (scope.options.equality(newExNode, existingScope.node)) {
                                        newExpandedNodesMap[existingScope.$id] = existingScope.node;
                                        found = true;
                                    }
                                }
                                if (!found)
                                    newExpandedNodesMap[notFoundIds++] = newExNode;
                            });
                            scope.expandedNodesMap = newExpandedNodesMap;
                        });

//                        scope.$watch('expandedNodesMap', function(newValue) {
//
//                        });

                        //Rendering template for a root node
                        treemodelCntr.template( scope, function(clone) {
                            angular.element(element).html('').append( clone );
                        });
                        // save the transclude function from compile (which is not bound to a scope as apposed to the one from link)
                        // we can fix this to work with the link transclude function with angular 1.2.6. as for angular 1.2.0 we need
                        // to keep using the compile function
                        scope.$treeTransclude = childTranscludeFn;
                    };
                }
                ,replace:true
            };
        }])
        .directive("setNodeToData", ['$parse', function($parse) {
            return {
                restrict: 'A',
                link: function($scope, $element, $attrs) {
                    $element.data('node', $scope.node);
                    $element.data('scope-id', $scope.$id);
                }
            };
        }])
        .directive("treeitem", function() {
            return {
                restrict: 'E',
                require: "^treecontrol",
                template:'<div></div>',
                link: function( scope, element, attrs, treemodelCntr) {
                    // Rendering template for the current node
                    treemodelCntr.template(scope, function(clone) {
                        element.html('').append(clone);
                    });
                },
                replace:true
            };
        })
        .directive("treeTransclude", function() {
            return {
                link: function(scope, element, attrs, controller) {
                    if (!scope.options.isLeaf(scope.node)) {
                        angular.forEach(scope.expandedNodesMap, function (node, id) {
                            if (scope.options.equality(node, scope.node)) {
                                scope.expandedNodesMap[scope.$id] = scope.node;
                                scope.expandedNodesMap[id] = undefined;
                            }
                        });
                    }
                    if (!scope.options.multiSelection && scope.options.equality(scope.node, scope.selectedNode)) {
                        scope.selectedNode = scope.node;
                    } else if (scope.options.multiSelection) {
                        var newSelectedNodes = [];
                        for (var i = 0; (i < scope.selectedNodes.length); i++) {
                            if (scope.options.equality(scope.node, scope.selectedNodes[i])) {
                                newSelectedNodes.push(scope.node);
                            }
                        }
                        scope.selectedNodes = newSelectedNodes;
                    }

                    // create a scope for the transclusion, whos parent is the parent of the tree control
                    scope.transcludeScope = scope.parentScopeOfTree.$new();
                    scope.transcludeScope.node = scope.node;
                    scope.transcludeScope.$parentNode = (scope.$parent.node === scope.synteticRoot)?null:scope.$parent.node;
                    scope.transcludeScope.$index = scope.$index;
                    scope.transcludeScope.$first = scope.$first;
                    scope.transcludeScope.$middle = scope.$middle;
                    scope.transcludeScope.$last = scope.$last;
                    scope.transcludeScope.$odd = scope.$odd;
                    scope.transcludeScope.$even = scope.$even;
                    scope.$on('$destroy', function() {
                        scope.transcludeScope.$destroy();
                    });

                    scope.$treeTransclude(scope.transcludeScope, function(clone) {
                        element.empty();
                        element.append(clone);
                    });
                }
            };
        });
})( angular );

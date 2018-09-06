/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/10
 */
var custFinTargetController = function($scope,$common,$stateParams,dataDeliver,$state,$eventCommunicationChannel) {
    var deliverData = dataDeliver.getter();
    $scope.otherform={
    };
    $scope.conditionForm={
        custNm:deliverData.bCrmBaseInfo.cname,
        custId: deliverData.bCrmBaseInfo.custcd,
        mdlId:'CWZB'
    };

    //重置
    $scope.rebort_onClick =function(){
        $scope.$apply(function(){
            $scope.conditionForm={
                custNm:deliverData.bCrmBaseInfo.cname,
                custId: deliverData.bCrmBaseInfo.custcd,
                mdlId:'CWZB'
            };
        })
    };
    //搜索查询
    $scope.submit_onClick =function(){
        if($.doValidate("conditionForm")){
            $scope.queryTable();
        }

    };
 /*   $scope.queryTable = function(){
        var data= {
            bFinCust:$scope.conditionForm
        };
        var promise = $common.get_asyncData("bFinCustService/findBFinCustByPage",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                $scope.datasource.ds = data.records;
                $scope.conf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };*/

    $scope.queryBFinCnfgCl = function(){
        var data= {
        		mdlId:$scope.conditionForm.mdlId
        };
        var promise = $common.get_asyncData("bFinCnfgClService/findBFinCnfgClByMdlId",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
            	$scope.rheads=eval(data.rem);
            	$scope.otherform.cotes=data.cotes;
            	$scope.otherform.col=data.col;	
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };

    $scope.queryTable = function(){
       var data={
           bFinCustDs :$scope.conditionForm
       };
                    promise = $common.get_asyncData("bFinCustDsService/queryFinTargetAnaly",data);
                promise.then(function(res){
                    if (res.errorCode =="SUC"){
                    	$scope.bFinCustDsList = res.contextData || [];
                        for(var i=0;i<$scope.bFinCustDsList.length;i++)
                        {
                            var custds = $scope.bFinCustDsList[i];
                            var val1 = custds.colVal1;
                            var val2 = custds.colVal2;
                            custds.colVal1 = checkVal(val1);
                            custds.colVal2 = checkVal(val2);
                            if(custds.child)
                            {
                                var childVal1 = custds.child.colVal1;
                                var childVal2 = custds.child.colVal2;
                                custds.child.colVal1 = checkVal(childVal1);
                                custds.child.colVal2 = checkVal(childVal2);
                            }
                        }
                    }else{
                        $common.get_tipDialog(res.errorMsg,'showError');
                    }
                });
        //    }else{
        //        $common.get_tipDialog(res.errorMsg,'showError');
        //    };
        //});
    };

    function checkVal(val)
    {
        if(val == undefined)
        {
            return val;
        }
        if(val!=0)
        {
            var str = val.toString();
            if(str.indexOf('.') == -1)
            {
                str += ".00";
            }
            else
            {
                var index = str.substring(str.lastIndexOf(".")+1);
                if(index.length<2)
                {
                    str = str+"0";
                }
            }
            return str;
        }
        else
        {
            val += ".00";
            return val;
        }
    }
    //初始化表头
   $scope.queryBFinCnfgCl();
   // $scope.queryTable();


};

/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/10
 */
var clviewController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.otherform=dataDeliver.getter();
	$scope.rheads=eval($scope.otherform.rem);
	
	 $scope.addbFinCnfgDef=function(i){
		    var obj={"cotes":1,"child":{}};
			if($scope.otherform.cotes>=2){
				 obj.cotes=1;
				 obj.child.cotes=2;
			}else {
				 obj.cotes=1;
			}

        $scope.bFinCnfgDefList.splice(i+1,0,obj);		 
        
        var data= {
        		bFinCnfgDefList:$scope.bFinCnfgDefList,
        		bFinCnfgCl:$scope.otherform    
        };
        var promise = $common.get_asyncData("bFinCnfgDefService/saveBFinCnfgDefList",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
            	//  $common.get_tipDialog('保存成功！','showSuccess');
            }else{
                 $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
	 }

	$scope.queryFinRePort = function(){
		var data= {
			bFinCnfgCl:$scope.otherform
		};
		var promise = $common.get_asyncData("bFinCnfgDefService/findBFinCnfgDefByBFinCnfgCl",data);
		promise.then(function(res){
			var data;
			if (res.errorCode =="SUC"){
				$scope.bFinCnfgDefList = res.contextData;
				for(var i=0;i<$scope.bFinCnfgDefList.length;i++)
				{
					var custdef = $scope.bFinCnfgDefList[i];
					var val1 = custdef.colVal1;
					var val2 = custdef.colVal2;
					custdef.colVal1 = checkVal(val1);
					custdef.colVal2 = checkVal(val2);
					if(custdef.child)
					{
						var childVal1 = custdef.child.colVal1;
						var childVal2 = custdef.child.colVal2;
						custdef.child.colVal1 = checkVal(childVal1);
						custdef.child.colVal2 = checkVal(childVal2);
					}
				}
				console.log("bFinCnfgDefList："+JSON.stringify(res.contextData));

			}else{
				$common.get_tipDialog(res.errorMsg,'showError');
			}
		});
	};

	$scope.queryFinRePort();

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

	 $scope.deletebFinCnfgDef=function(i){	 
		 $scope.bFinCnfgDefList.splice(i,1);
	        var data= {
	        		bFinCnfgDefList:$scope.bFinCnfgDefList,
	        		bFinCnfgCl:$scope.otherform    
	        };
	        var promise = $common.get_asyncData("bFinCnfgDefService/saveBFinCnfgDefList",data);
	        promise.then(function(res){
	            var data;
	            if (res.errorCode =="SUC"){
	            	 // $common.get_tipDialog('保存成功！','showSuccess');
	            }else{
	                 $common.get_tipDialog(res.errorMsg,'showError');
	            }
	        });
	 }
	 
	 $scope.savebFinCnfgDef=function(i,obj){
		   obj.$edit=false;
	 }


    $scope.back_onClick = function () {
        $state.go("cl");
    };


    $scope.updatebFinCnfgDef = function(obj){
		if(!obj.mdlId)
		{
			obj.mdlId = $scope.otherform.mdlId;
		}
            $common.get_ngDialog('cl/def_add.html',$scope
                ,["$scope",function(dialogScope){
                    defaddController(dialogScope,$scope,$common,"update",obj);
                }],"修改财报模型信息",{showClose:true},700);
  
    };

};

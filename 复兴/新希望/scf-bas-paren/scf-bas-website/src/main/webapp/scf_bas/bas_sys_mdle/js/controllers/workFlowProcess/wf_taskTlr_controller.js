/**
 * Created by htrad0036 on 2017/3/15.
 */
var wfTaskTlrController = function(dialogScope, parentScope, $common, row) {

    dialogScope.tlrdatasource={//初始化表格对象
        ds:[]
    };
    dialogScope.selected={//初始化对象
        select: []
    };
    dialogScope.tlrConf= {//初始化分页对象
        pageNo: 1,
        pageSize: 10,
        totalRecord: 0
    };
    //监听分页
    dialogScope.$watch("tlrConf.pageNo+tlrConf.pageSize",function(){
        dialogScope.queryTable();
    });
    dialogScope.closeThisDialog_onClick = function () {
        dialogScope.closeThisDialog();
    };

    //查询
    dialogScope.queryTable = function(){
        var data= {
            pageNo: dialogScope.tlrConf.pageNo,
            pageSize: dialogScope.tlrConf.pageSize,
            conditionForm:row
        };
        var promise = $common.get_asyncData("bSysTaskService/queryWFProcessTlrList",data);
        promise.then(function(res){
            var data;
            if (res.errorCode =="SUC"){
                data = res.contextData;
                dialogScope.tlrdatasource.ds = data;
                //dialogScope.tlrConf.totalRecord = data.totalRecord;
            }else{
                $common.get_tipDialog(res.errorMsg,'showError');
            }
        });
    };




};

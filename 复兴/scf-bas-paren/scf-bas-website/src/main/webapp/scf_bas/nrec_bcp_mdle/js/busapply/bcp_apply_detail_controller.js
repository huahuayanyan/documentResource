/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var nrBcpApplyDetailController = function($scope,$timeout,$common,$location,dataDeliver,$stateParams,$state,$eventCommunicationChannel,$q) {
    $scope.source = window.source;
    if(window.appNo)
    {
        $scope.hideButton = true;
    }
    $scope.baseinfo = dataDeliver.getter();
    if(!$scope.baseinfo.appno)
    {
        $scope.baseinfo = $scope.source.baseinfo;
    }
    if(!$scope.baseinfo.appno)
    {
        $common.get_tipDialog("请先保存后查看尽职调查！",'showInform');
        var url = "bcpApply.baseinfo";
        $state.go(url);
        $scope.$parent.panes.forEach(function(pane){
            if (pane.uiSref == url){
                $scope.$parent.select(pane);
            }
        });
        return;
    }

    /**
     * 递归判断页面元素是否加载完成
     * 加载完成，调用业务方法
     * 未加载完成，继续递归至渠道对应的标签对象后，调用业务方法
     * @param html_eleId
     */
    function checkLoad(html_eleId)
    {
        var obj = document.getElementById(html_eleId);
        if(obj==null)
        {
            var deferred = $q.defer();
            var timer = $timeout(function(){
                deferred.resolve();
            },100,true);
            deferred.promise.then(function(){
                $timeout.cancel(timer);
                if(obj!=null)
                {
                    //已经找到指定的html标签
                    //执行业务操作，可以考虑eval动态执行业务方法，展示没有继续封装
                    queryTable();
                }
                else
                {
                    checkLoad(html_eleId);
                }
            });
        }
        else
        {
            //已经找到指定的html标签
            //执行业务操作
            queryTable();
        }
    }

    $scope.$watch("baseinfo.appno",function() {
        $scope.queryTable();
    });
    $scope.queryTable = function(paramData)
    {
        var param = {
            id:"1BI0QUK1V002A3C7FCAA0000F4BC95D3",
            noticeType:"134",
            appno:$scope.baseinfo.appno,
            custcd:$scope.baseinfo.custcd,
            invokPhase:"01"
        };
        //toFactoringPrint(param);
        window.reportParam =param;
        $("#report").load("../../../scf_bas/report/factoringReport.html");
    };

    function queryTable()
    {
        var param = {
            id:"1BI0QUK1V002A3C7FCAA0000F4BC95D3",
            noticeType:"134",
            appno:$scope.baseinfo.appno,
            custcd:$scope.baseinfo.custcd,
            invokPhase:"01"
        };
        //toFactoringPrint(param);
        window.reportParam =param;
        $("#htReportFrame").load("../../../scf_bas/report/factoringReport.html");
    }
    //var t =0;
    //var myInterval =function (){
    //    t +=10;
    //    $scope.percent =t;
    //    console.log($scope.percent)
    //};
    //var timer = $timeout(myInterval,500);
    //$scope.$watch('percent',function(newval,oldval){
    //    if(newval!==oldval &&newval!==100){
    //        timer=$timeout(myInterval,500);
    //    }
    //});
};

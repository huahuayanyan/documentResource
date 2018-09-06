 
(function(){
   
    var routeArry=[
        {
            'state':'impairConList',
            'url':'/impairConList',
            'default':'true',
            'templateUrl':'impairment/impairConList.html',
            'controller':'DebtPoolConListController'
        },
        {
            'state':'impairAdd',
            'url':'/impairAdd',
            'templateUrl':'impairment/impairAdd.html',
            'controller':'impairAddController'
        }

    ];
    var dependency=[
        //todo
    ];
    scubeUI.module('rbcp_impairment_mdle',dependency,routeArry)
}());
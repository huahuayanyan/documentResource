 
(function(){
   
    var routeArry=[
        {
            'state':'impairPoolConList',
            'url':'/impairPoolConList',
            'default':'true',
            'templateUrl':'poolImpairment/impairPoolConList.html',
            'controller':'DebtPoolConListController'
        },
        {
            'state':'poolimpairAdd',
            'url':'/poolimpairAdd',
            'templateUrl':'poolImpairment/poolimpairAdd.html',
            'controller':'dsptRemAddController'
        },
        {
            'state':'modifyRBcpDebtBase',
            'url':'/modifyRBcpDebtBase',
            'templateUrl':'impairment/modifyRBcpDebtBase.html',
            'controller':'modifyPoolImpairControl'
        },
        {
            'state':'DebtBaseListForPoorImpair',
            'url':'/DebtBaseListForPoorImpair',
            'templateUrl':'debtPoolTransfer/bcp_base_info_list.html',
            'controller':'getDebtBaseListForPoorImpair'
        },

    ];
    var dependency=[
        //todo
    ];
    scubeUI.module('rbcpinfoimpairmentmdle',dependency,routeArry)
}());
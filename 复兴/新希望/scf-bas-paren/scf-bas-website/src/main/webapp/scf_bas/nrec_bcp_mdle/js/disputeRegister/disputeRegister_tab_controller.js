/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var disputeRegisterTabController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    if(window.appNo){
        dataDeliver.setter({appno:window.appNo});
        $state.go("apply");
    }else{
        $state.go("tab.apply");
    }
};

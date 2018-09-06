/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var duebillappprdinfoController = function(forthScope,thirdScope,dataDeliver,$state,$common,flag) {
    var obj = thirdScope.otherform.prdmd.obj;
    var addUrl = thirdScope.otherform.prdmd.addUrl;
    var updUrl = thirdScope.otherform.prdmd.updUrl;
    forthScope[obj] = $common.copy(thirdScope.row);
    forthScope.disableview = true;
    forthScope.disable = true;
    forthScope.hide = true;
    forthScope.close_onClick = function(){
        forthScope.closeThisDialog();
    };
};

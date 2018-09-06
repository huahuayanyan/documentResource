/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
var duebillappgntyinfoController = function(forthScope,thirdScope,dataDeliver,$state,$common,flag) {
    forthScope.row = thirdScope.row;
    forthScope.disable = true;
    forthScope.hide = true;
    forthScope.disableview = true;
    forthScope.closeThisDialog_onClick = function(){
        forthScope.closeThisDialog();
    };
};

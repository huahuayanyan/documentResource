/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Qinwei
 * @version     1.0
 * Create at:   2016/11/10
 */
var viewController = function($thisScope,parentScope,$common,flag,row) {
    //$thisScope.otherform=dataDeliver.getter();

    $thisScope.mdfyform=$common.copy(row);

    $thisScope.datasource = {
        ds:[]
    };

    $thisScope.closeThisDialog_onClick = function(){
        $thisScope.closeThisDialog();
    };

};

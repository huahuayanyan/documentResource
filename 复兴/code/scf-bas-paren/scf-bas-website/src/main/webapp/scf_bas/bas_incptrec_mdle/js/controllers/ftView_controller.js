/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/9/29
 */
var viewController = function($thisScope,parentScope,$common,flag,row) {
    //$thisScope.otherform=dataDeliver.getter();

    $thisScope.otherform=$common.copy(row);
    $thisScope.datasource = {
        ds:[]
    };

    $thisScope.closeThisDialog_onClick = function(){
        $thisScope.closeThisDialog();
    };

};

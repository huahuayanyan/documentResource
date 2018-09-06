/**
 * Filename:
 * Description:
 * Copyright:   Copyright (c) 2013
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * @author      Wubin
 * @version     1.0
 * Create at:   2016/6/7
 */
function checkLenght(obj)
{
    var realLen = 0;
    var strlen = obj.length;
    var charCode = -1;
    for(var i=0;i<strlen;i++)
    {
        charCode = obj.charCodeAt(i);
        if(charCode>=0&&charCode<=128)
        {
            realLen += 1;
        }
        else
        {
            realLen += 3;
        }
    }
    return realLen;
}
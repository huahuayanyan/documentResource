package com.huateng.scf.bas.mrn.service;

import java.util.HashMap;

import com.huateng.base.common.beans.Page;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>现金等价物流水接口</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月16日下午6:34:19
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月16日下午6:34:19	     新增
 *
 * </pre>
 */
public interface ICashEqualValueQueryService {

	public Page CashEqualValueQueryGetter(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") HashMap<String, String> value) throws ScubeBizException;

}

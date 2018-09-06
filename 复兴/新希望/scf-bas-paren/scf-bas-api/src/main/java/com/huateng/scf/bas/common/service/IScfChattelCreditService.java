package com.huateng.scf.bas.common.service;

import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p></p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月25日下午3:11:38
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月25日下午3:11:38	     新增
 *
 * </pre>
 */
public interface IScfChattelCreditService {

	/**
	 * 动产申请获取信息
	 * @param appno
	 * @param businessState
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月25日下午3:14:36
	 */
	public void chattelAppliCreditProcess(@ScubeParam("appno") String appno,@ScubeParam("businessState") String businessState) throws ScubeBizException;

}

package com.huateng.scf.bas.common.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.model.CreditQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface ICreditServiceService {

	/**
	 * 连表查询额度信息 
	 * @param creditQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月30日下午1:44:14
	 */
	public Page getTblCreditInfoByCreditQryVO(@ScubeParam("creditQryVO") CreditQryVO creditQryVO) throws ScubeBizException;

}

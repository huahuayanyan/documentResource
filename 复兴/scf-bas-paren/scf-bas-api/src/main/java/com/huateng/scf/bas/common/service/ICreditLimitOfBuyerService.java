package com.huateng.scf.bas.common.service;

import com.huateng.scf.bas.icr.model.CreditLimitOfBuyerDealVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface ICreditLimitOfBuyerService {

	/**
	 * 新增或修改买方信用限额接口
	 * @param creditLimitOfBuyerDealVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月30日下午3:30:38
	 */
	public void addOrModifyCreditLimitInfoOfBuyer(@ScubeParam("creditLimitOfBuyerDealVO") CreditLimitOfBuyerDealVO creditLimitOfBuyerDealVO) throws ScubeBizException;

}

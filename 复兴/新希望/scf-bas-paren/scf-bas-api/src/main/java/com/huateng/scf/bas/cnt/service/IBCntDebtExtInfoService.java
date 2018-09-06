package com.huateng.scf.bas.cnt.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BCntDebtExtInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCntDebtExtInfoService {
	public static final String BEAN_ID = "bCntDebtExtInfoService";

	// 通过业务合同号查询对应数据。
	public BCntDebtExtInfo findBCntDebtExtInfoByKey(@ScubeParam("bCntDebtExtInfo") BCntDebtExtInfo bCntDebtExtInfo);

	// 用于下拉菜单分页条件查询应收账款融资交易对手信息（根据业务合同号，买方客户名称，id）
	public Page selectBCntDebtExtInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BCntDebtExtInfo bCntDebtExtInfo);

	String selectBCntDebtExtInfoByBuyerNameBusinessNo(@ScubeParam("businessNo") String businessNo,@ScubeParam("buyerName") String buyerName);
	/**
	 * 
	 * @param mastContno
	 * @param custcd
	 * @return
	 * @throws ScubeBizException
	 */
	public BCntDebtExtInfo queryContDebtExInfoByMastContno(@ScubeParam("mastContno") String mastContno,@ScubeParam("custcd") String custcd) throws ScubeBizException;
}

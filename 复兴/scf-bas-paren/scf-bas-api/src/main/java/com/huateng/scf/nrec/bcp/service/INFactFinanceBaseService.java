package com.huateng.scf.nrec.bcp.service;

import java.math.BigDecimal;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface INFactFinanceBaseService {

	public Page queryAppliBussDetailByAppnoDebt(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 修改关联查询表-mengjiajia
	 * @param mastContno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月6日上午9:32:26
	 */
	BigDecimal calculatePoolRiskAvailableAmtByBusinessNo(@ScubeParam("mastContno") String mastContno) throws ScubeBizException;
	
	/**
	 * 应收账款转让根据合同编号查询合同信息和业务品种信息
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月31日下午4:56:56
	 */
	public DebtBussInfoVO getContDebtInfoByMastContno(@ScubeParam("commonQueryVO") DebtCommonQryVO commonQueryVO) throws ScubeBizException;

}

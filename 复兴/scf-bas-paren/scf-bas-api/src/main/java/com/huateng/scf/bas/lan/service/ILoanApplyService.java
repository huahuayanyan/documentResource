package com.huateng.scf.bas.lan.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.lan.model.LoanApplyQryVO;
import com.huateng.scf.bas.lan.model.MortgageLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface ILoanApplyService {
	/**
	 * 
	 * @param loanApplyQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月20日下午3:27:56
	 */
	public Page getLoanApplyList(@ScubeParam("loanApplyQryVO") LoanApplyQryVO loanApplyQryVO) throws ScubeBizException;

	/**
	 * 得到动产、汽车货物的贷款的详细信息。
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月15日下午2:50:47
	 */
	public MortgageLnciBaseInfoVO getMortgageLoanApplyInfo(@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO) throws ScubeBizException;

}

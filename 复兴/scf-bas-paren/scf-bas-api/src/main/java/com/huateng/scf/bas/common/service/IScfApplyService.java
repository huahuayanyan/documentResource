/**
 * 
 */
package com.huateng.scf.bas.common.service;

import java.math.BigDecimal;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.FourWareLoanVO;
import com.huateng.scf.bas.icr.model.CreditQryVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 供应链业务申请
 * </p>
 *
 * @author huangshuidan
 * @date 2016年12月29日 下午3:53:08
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月29日下午3:53:08             新增
 *
 *            </pre>
 */
public interface IScfApplyService {
	public static final String BEAN_ID = "scfApplyService";
	/**
	 * 国内保理业务申请基本信息表
	 * @param debtVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 */
	public String saveFactoringAppBasicInfo(@ScubeParam("debtVO") DebtBussInfoVO debtVO,
			@ScubeParam("businessnoType") String businessnoType, @ScubeParam("workApplyType") String workApplyType)
					throws ScubeBizException;
	
	/**
	 * 先票/款后货差额退款申请保存
	 * @param fourWareLoanVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 */
	public String saveFourBalanceAppBasicInfo(@ScubeParam("fourWareLoanVO") FourWareLoanVO fourWareLoanVO,
			@ScubeParam("businessnoType") String businessnoType, @ScubeParam("workApplyType") String workApplyType)
					throws ScubeBizException;
	
	void updateTblAppBaseInfo(@ScubeParam("tlrno") String tlrno, @ScubeParam("brcode") String brcode,  @ScubeParam("processStatus") Integer processStatus,
			@ScubeParam("bussAppno") String bussAppno, @ScubeParam("status") String status, @ScubeParam("appliStatusDtl") String appliStatusDtl);
	/**
	 * 
	 * @param insertDebtList
	 * @param debtVO
	 * @throws ScubeBizException
	 */
	public void factoringDebtBackAddApply(@ScubeParam("insertDebtList") List<RBcpDebtBaseInfo> insertDebtList,@ScubeParam("debtVO") DebtBussInfoVO debtVO)
			throws ScubeBizException;
	/**
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 */
	public void releaseAppliDebtBaseInfo(@ScubeParam("appno") String appno) throws ScubeBizException;
	/**
	 * 
	 * @param debtVO
	 * @throws ScubeBizException
	 */
	public void updatePoolRemainAmount(@ScubeParam("debtVO") DebtBussInfoVO debtVO) throws ScubeBizException;
	/**
	 * 
	 * @param mastContno
	 * @param custcdBuyer
	 * @return
	 * @throws ScubeBizException
	 */
	public String getDebtContRecoverType(@ScubeParam("mastContno") String mastContno,@ScubeParam("custcdBuyer") String custcdBuyer) throws ScubeBizException;
	/**
	 * 
	 * @param appno
	 * @param operType
	 * @param amt
	 * @throws CommonException
	 */
	public void creditLimitOfBuyerAppliCommonProcess(@ScubeParam("appno") String appno,@ScubeParam("operType") String operType,@ScubeParam("amt") BigDecimal amt) throws ScubeBizException;
	/**
	 * 
	 * @param creditQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getTblCreditInfoByCreditQryVO(@ScubeParam("creditQryVO") CreditQryVO creditQryVO) throws ScubeBizException;
}

package com.huateng.scf.bas.lan.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.model.CommonApplyDtlInfoVO;
import com.huateng.scf.bas.lan.model.LoanApplyQryVO;
import com.huateng.scf.bas.lan.model.MortgageLnciBaseInfoVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>现货质押放款	接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月15日下午2:28:14
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月15日下午2:28:14	     新增
 *
 * </pre>
 */
public interface IMtgLoanApplyService {

	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(@ScubeParam("appno") String appno);

	Page findMtgLoanApplyListByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize, @ScubeParam("loanApplyQryVO")LoanApplyQryVO loanApplyQryVO);
	/**
	 * 得到动产、汽车货物的贷款的详细信息
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月15日下午2:42:11
	 */
	@SuppressWarnings("rawtypes")
	public List LoanApplyBaseInfo(@ScubeParam("debtCommonQryVO") DebtCommonQryVO debtCommonQryVO) throws ScubeBizException;

	/**
	 * 放款申请的公用的保存方法
	 * @param mortgageLnciBaseInfoVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月15日下午4:58:13
	 */
	public void MortgageLoanApplySaveUpdate(@ScubeParam("mortgageLnciBaseInfoVO") MortgageLnciBaseInfoVO mortgageLnciBaseInfoVO) throws ScubeBizException;

	/**
	 * 动产融资放款申请填写岗信息录入提交
	 * @param mortgageLnciBaseInfoVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月15日下午5:26:02
	 */
	public void MortgageLoanApplyWriteSubmitUpdater(@ScubeParam("mortgageLnciBaseInfoVO") MortgageLnciBaseInfoVO mortgageLnciBaseInfoVO) throws ScubeBizException;

	/**
	 * 动产融资放款申请退回
	 * @param applyDtlInfoVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月16日上午9:23:16
	 */
	public void LoanApplyBackSubmitUpdater(@ScubeParam("applyDtlInfoVO") CommonApplyDtlInfoVO applyDtlInfoVO) throws ScubeBizException;
}

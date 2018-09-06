/**
 * 
 */
package com.huateng.scf.bas.lan.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.lan.model.ApplyBuyContVO;
import com.huateng.scf.bas.lan.model.LoanApplyQryVO;
import com.huateng.scf.bas.lan.model.MortgageLnciBaseInfoLDVO;
import com.huateng.scf.bas.lan.model.MortgageLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年4月10日下午1:34:26
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月10日下午1:34:26              新增
 *
 * </pre>
 */
public interface IBLanLoanApplyService {
	public static final String BEAN_ID = "bLanLoanApplyService";
	
	/**
	 * 放款审批查询列表
	 * 先票/款后货
	 * @param pageNo
	 * @param pageSize
	 * @param loanApplyQryVO
	 * @return
	 */
	public Page queryLoanApplyList(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("loanApplyQryVO") LoanApplyQryVO loanApplyQryVO);
	
	/**
	 * 贷款的详细信息
	 * 先票/款后货  、动产、汽车货物
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public MortgageLnciBaseInfoVO getMortgageLoanApplyInfo(@ScubeParam("debtCommonQryVO")DebtCommonQryVO debtCommonQryVO) throws ScubeBizException;
	
	/**
	 * 放款供应链补录保存
	 * 先票/款后货
	 * @param mortgageLnciBaseInfoVO
	 * @param list
	 * @return 
	 */
	public String LoanApplySaveUpdate(@ScubeParam("mortgageLnciBaseInfoVO") MortgageLnciBaseInfoVO mortgageLnciBaseInfoVO,@ScubeParam("list") List<ApplyBuyContVO> list) throws ScubeBizException;
	
	/**
	 * 放款供应链补录提交
	 * 先票/款后货
	 * @param mortgageLnciBaseInfoVO
	 * @param list
	 * @return 
	 */
	public void LoanApplyWriteSubmit(@ScubeParam("mortgageLnciBaseInfoVO") MortgageLnciBaseInfoVO mortgageLnciBaseInfoVO,@ScubeParam("list") List<ApplyBuyContVO> list)throws ScubeBizException;

	public void saveLoanApplyInfo(@ScubeParam("appliLnciInfo") MortgageLnciBaseInfoVO appliLnciInfo) throws ScubeBizException;
	
	/**
	 * 
	 * 先票/款后货 流贷出账申请页面信息
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public MortgageLnciBaseInfoLDVO getMortgageLoanApplyInfoLD(@ScubeParam("debtCommonQryVO")DebtCommonQryVO debtCommonQryVO) throws ScubeBizException;
}

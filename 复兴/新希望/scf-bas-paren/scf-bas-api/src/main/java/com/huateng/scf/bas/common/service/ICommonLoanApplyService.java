package com.huateng.scf.bas.common.service;

import java.math.BigDecimal;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.lan.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.model.LoanApplyQryVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>放款申请公共类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月20日下午3:12:27
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月20日下午3:12:27	     新增
 *
 * </pre>
 */
public interface ICommonLoanApplyService {

	/**
	 * 获得放款申请列表
	 * @param loanApplyQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月20日下午3:14:43
	 */
	public Page getLoanApplyList(@ScubeParam("loanApplyQryVO") LoanApplyQryVO loanApplyQryVO) throws ScubeBizException;

	/**
	 * 保存借据申请信息
	 * @param appno
	 * @param bLanAppliLnciBase
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月23日下午8:27:19
	 */
	public String saveBLanAppliLnciBase(@ScubeParam("appno") String appno,@ScubeParam("bLanAppliLnciBase") BLanAppliLnciBase bLanAppliLnciBase) throws ScubeBizException;

	/**
	 * 放款保存更新appliBussInfo
	 * @param lnciVO
	 * @param factFlag
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月24日上午9:45:17
	 */
	public void updateAppliBussInfoWithLnciVO(@ScubeParam("lnciVO") DebtLnciBaseInfoVO lnciVO,@ScubeParam("factFlag") String factFlag) throws ScubeBizException;

	/**
	 * 发票发放  添加融资发票 【业务申请业务明细表】
	 * @param insertList
	 * @param appno
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月24日上午10:17:27
	 */
	public void saveAppliBussDetall(@ScubeParam("insertList") List<RBcpAppliBussDtl> insertList,@ScubeParam("appno") String appno,@ScubeParam("financingType") String financingType) throws ScubeBizException;

	/**
	 * 放款更新appli_lnci_base
	 * @param lnciVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月24日上午10:19:05
	 */
	public void updateAppliLnciBaseInfo(@ScubeParam("lnciVO") DebtLnciBaseInfoVO lnciVO) throws ScubeBizException;

	/**
	 * 放款更新申请状态
	 * @param appno
	 * @param appliStatusDtlWaitcms
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月24日下午3:12:51
	 */
	public void updateAppliBaseInfoWithParam(@ScubeParam("appno") String appno,@ScubeParam("appliStatusDtlWaitcms") String appliStatusDtlWaitcms) throws ScubeBizException;

	/**
	 * 放款金额校验
	 * @param debtLnciBaseInfoVO
	 * @param factType
	 * @author 	mengjiajia
	 * @date 	2017年6月6日上午10:52:34
	 */
	public void checkFinanceApplyInfo(@ScubeParam("debtLnciBaseInfoVO") DebtLnciBaseInfoVO debtLnciBaseInfoVO,@ScubeParam("factType") String factType);

	/**
	 * 获取敞口余额
	 * 根据合同类型，计算敞口余额。
	 * 循环合同：  敞口余额 = 信贷合同项下所有已经出账成功的敞口余额之和+供应链已经提交给信贷的借据的敞口余额之和（未 出账）
	 * 非循环合同： 敞口余额 = ∑（借据金额-初始保证金金额-初始现金等价物金额）【含出账已经成功和已经提交给信贷的】
	 * 该方法仅适合放款时的校验使用！！！
	 * @param mastContno
	 * @param cycle
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月13日下午4:18:25
	 */
	public BigDecimal getContRiskAmtByCycle(@ScubeParam("mastContno") String mastContno,@ScubeParam("cycle") String cycle) throws ScubeBizException;
}

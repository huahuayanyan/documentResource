package com.huateng.scf.nrec.bcp.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.model.DebtLnciQryVO;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.model.BCrmBrInfo;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.nrec.bcp.model.BCntBcpExtInfoVO;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.model.NPaymentBussInfo;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.PayMentLanInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

public interface INRBcpPaymentService {

	public static final String BeanId = "NRBcpPaymentServiceImpl";

	/**
	 * 
	 * 按照核销规则分配核销金额， 自动分配单据以及借据的本次还款金额
	 * 
	 * @param @return
	 * @author lihao
	 * @date 2017年5月27日 下午5:39:09
	 */
	List<RBcpAppliBussDtl> sequenceDebtAndReturnAmount(@ScubeParam("returnAmount") BigDecimal returnAmount,
			@ScubeParam("assignRule") String assignRule, @ScubeParam("list") List<RBcpAppliBussDtl> list) throws ScubeBizException;

	/**
	 * 
	 * 按照到期日正序排列借据（融资信息）
	 * 
	 * @param @return
	 * @author lihao
	 * @date 2017年5月27日 下午5:39:09
	 */
	List<DebtLnciBaseInfoVO> sequenceLoanInfo(@ScubeParam("list") List<DebtLnciBaseInfoVO> list) throws ScubeBizException;

	/**
	 * 现金回款，自动分配，将借据信息按照到期日排序，按照借据余额核销借据
	 * 
	 * @param returnAmount
	 * @param list
	 * @return
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月29日下午2:55:39
	 */
	List<DebtLnciBaseInfoVO> repayLoanInfoAuto(@ScubeParam("returnAmount") BigDecimal returnAmount,@ScubeParam("assignRule") String assignRule,
			@ScubeParam("list") List<DebtLnciBaseInfoVO> list) throws ScubeBizException;
	
	/**
	 *  通过申请号查找回款锁定借据信息
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 * @author 	lihao
	 * @date 	2017年7月20日下午4:25:41
	 */
	List<DebtLnciBaseInfoVO> getDebtLnciBaseListByAppno(@ScubeParam("key") String appno) throws ScubeBizException;

	/**
	 * 现金回款，主申请页面保存按钮
	 * 
	 * @param value
	 * @param debtList
	 * @param loanList
	 * @return
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月15日 上午11:30:17
	 */
	public String saveCashPaymentInfoApply(@ScubeParam("value") RBcpAppliBussInfo rBcpAppliBussInfo,
			@ScubeParam("debtList") List<RBcpAppliBussDtl> debtList, @ScubeParam("loanList") List<BLanLnciBase> loanList) throws ScubeBizException;

	/**
	 * 现金回款，当有申请号时，保存页面修改
	 * 
	 * @param value
	 * @param debtList
	 * @param loanList
	 * @return
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月15日 上午11:30:17
	 */
	public void updateCashPaymentInfoApply(@ScubeParam("value") RBcpAppliBussInfo rBcpAppliBussInfo,
			@ScubeParam("debtList") List<RBcpAppliBussDtl> debtList, @ScubeParam("loanList") List<BLanLnciBase> loanList) throws ScubeBizException;

	/**
	 * 现金回款，主申请页面提交按钮
	 * 
	 * @param value
	 * @param debtList
	 * @param loanList
	 * @return
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月15日 上午11:30:17
	 */
	public void submitCashPaymentInfoApplyInfo(@ScubeParam("value") RBcpAppliBussInfo rBcpAppliBussInfo,
			@ScubeParam("debtList") List<RBcpAppliBussDtl> debtList, @ScubeParam("loanList") List<BLanLnciBase> loanList) throws ScubeBizException;

	/**
	 * 现金回款，申请明细信息表提交按钮
	 * 
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月15日 上午11:30:17
	 */
	public void submitCashPaymentInfo(@ScubeParam("key") String appno) throws ScubeBizException;

	/**
	 * 现金回款，申请明细信息表删除按钮
	 * 
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月15日 上午11:30:17
	 */
	public void deleteCashPaymentInfo(@ScubeParam("key") String appno) throws ScubeBizException;

	/**
	 * 
	 * @param @param
	 *            infoVO
	 * @param @return
	 * @author Qinwei
	 * @date 2017年5月27日 下午5:39:09
	 */
	List<BPrdInfo> queryPrdInfoByVO(@ScubeParam("prdVO") Map<String, Object> infoVO);

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @author Qinwei
	 * @date 2017年5月27日 下午5:40:21
	 */
	Page queryBPbcAppliBaseInfoList(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") Map<String, Object> value);

	/**
	 * 用于页面下拉搜索框的分页查询客户信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @author Qinwei
	 * @date 2017年5月31日 上午10:49:19
	 */
	public Page queryBCrmBaseInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BCrmBaseInfo value);

	/**
	 * 页面下拉菜单查询保理合同基本信息（根据卖方客户号和业务合同号，业务品种翻译成业务品种名称）
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bCntDebtInfo
	 * @return
	 * @throws ScubeBizException
	 * @author Qinwei
	 * @date 2017年5月31日 上午11:30:17
	 */
	Page queryBCntBcpInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BCntBcpInfoVO bCntBcpInfoVO) throws ScubeBizException;

	/**
	 * 分页条件查询应收账款融资交易对手信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bCntBcpExtInfo
	 * @return
	 * @author Qinwei
	 * @date 2017年5月31日 下午5:33:43
	 */
	Page queryBCntDebtExtInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BCntBcpExtInfoVO bCntBcpExtInfo);

	/**
	 * 添加现金回款申请信息
	 * 
	 * @param rBcpAppliBussInfo
	 * @return
	 * @author Qinwei
	 * @date 2017年6月1日 上午10:26:37
	 */
	String addPaymentApply(@ScubeParam("rBcpAppliBussInfo") RBcpAppliBussInfo rBcpAppliBussInfo);

	/**
	 * 
	 * @param rBcpAppliBussInfo
	 * @return
	 * @author Qinwei
	 * @date 2017年6月1日 下午1:57:26
	 */
	NPaymentBussInfo getInvoicePaymentInfo(@ScubeParam("rBcpAppliBussInfo") RBcpAppliBussInfo rBcpAppliBussInfo);

	/**
	 * 
	 * @param custcd
	 * @return
	 * @author Qinwei
	 * @date 2017年6月1日 下午2:04:38
	 */
	BCrmBaseInfo findBCrmBaseInfoByKey(@ScubeParam("custcd") String custcd);

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param appno
	 * @return
	 * @author Qinwei
	 * @date 2017年6月1日 下午7:42:09
	 */
	Page findPoolLoanByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("appno") String appno);

	/**
	 * 
	 * @param appno
	 * @author Qinwei
	 * @date 2017年6月1日 下午7:42:05
	 */
	void delPaymentApply(@ScubeParam("appno") String appno);

	/**
	 * 
	 * @param paymentBussInfo
	 * @return
	 * @author Qinwei
	 * @date 2017年6月1日 下午7:42:01
	 */
	String updatePaymentApply(@ScubeParam("paymentBussInfo") NPaymentBussInfo paymentBussInfo);

	/**
	 * 
	 * @param rBcpAppliBussDtl
	 * @author Qinwei
	 * @date 2017年6月1日 下午7:54:00
	 */
	void updateRBcpAppliBussDtl(@ScubeParam("rBcpAppliBussDtl") RBcpAppliBussDtl rBcpAppliBussDtl);

	/**
	 * 分配额度
	 * 
	 * @param appno
	 * @param payMentLanInfo
	 * @throws ScubeBizException
	 * @author Qinwei
	 * @date 2017年6月1日 下午8:04:21
	 */
	void updatePayMentLanInfo(@ScubeParam("appno") String appno, @ScubeParam("payMentLanInfo") PayMentLanInfo payMentLanInfo)
			throws ScubeBizException;

	/**
	 * 
	 * @param paymentBussInfo
	 * @author Qinwei
	 * @date 2017年6月1日 下午8:09:52
	 */
	void assignAmount(@ScubeParam("paymentBussInfo") NPaymentBussInfo paymentBussInfo);

	/**
	 * 删除还款申请信息
	 * 
	 * @param rBcpAppliBussDtl
	 * @author Qinwei
	 * @date 2017年6月2日 上午11:14:08
	 */
	void deleteRBcpAppliBussDtl(@ScubeParam("rBcpAppliBussDtl") RBcpAppliBussDtl rBcpAppliBussDtl);

	/**
	 * 
	 * @param appno
	 * @param rBcpAppliBussDtl
	 * @author Qinwei
	 * @date 2017年6月2日 上午11:21:56
	 */
	void addRBcpAppliBussDtl(@ScubeParam("appno") String appno, @ScubeParam("rBcpAppliBussDtl") RBcpAppliBussDtl rBcpAppliBussDtl);

	/**
	 * 查询池合同下对应还款核销单据
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param rBcpDebtBaseInfo
	 * @param list
	 * @return
	 * @author lihao
	 * @date 2017年6月2日 下午2:11:52
	 */
	public Page findCancelRBcpDebtBaseInfoPageByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtInfoVO rBcpDebtInfoVO, @ScubeParam("list") List<RBcpDebtInfoVO> list) throws ScubeBizException;

	/**
	 * 查询非池（单笔）合同下对应还款核销单据
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param rBcpDebtInfoVO
	 * @param list
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年6月19日下午2:21:32
	 */
	public Page findCancelRBcpDebtBaseInfoPageByPage2(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") RBcpDebtInfoVO rBcpDebtInfoVO, @ScubeParam("list") List<RBcpDebtInfoVO> list) throws ScubeBizException;

	void addLoanInfoDtl(@ScubeParam("debtBussInfoVO") DebtBussInfoVO debtBussInfoVO,
			@ScubeParam("debtLnciBaseInfoVOList") List<DebtLnciBaseInfoVO> lnciList) throws ScubeBizException;

	/**
	 * 应收账款池融资 融资列表查询
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param debtLnciQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author Qinwei
	 * @date 2017年6月2日 下午4:46:59
	 */
	public Page findloanAddListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") DebtLnciQryVO debtLnciQryVO, @ScubeParam("list") List<BLanLnciBase> list) throws ScubeBizException;

	/**
	 * 应收账款池融资 融资列表查询
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param debtLnciQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月2日 下午4:46:59
	 */
	public Page queryLoanByPageForPay(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") DebtLnciQryVO debtLnciQryVO, @ScubeParam("list") List<BLanLnciBase> list) throws ScubeBizException;

	/**
	 * 首页提交按钮
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 * @author Qinwei
	 * @date 2017年6月3日 下午7:41:13
	 */
	void submitCashPaymentInfoApply(@ScubeParam("key") String appno) throws ScubeBizException;

	/**
	 * 页面经办人，经办机构，客户经理转译
	 * 
	 * @param bCrmBrInfo
	 * @return
	 * @author Qinwei
	 * @date 2017年6月5日 上午10:27:49
	 */
	public BCrmBrInfo findBCrmBrInfo(@ScubeParam("bCrmBrInfo") BCrmBrInfo bCrmBrInfo);

	/**
	 * 任务基本信息
	 * 
	 * @param appno
	 * @param factType
	 * @return
	 * @author mengjiajia
	 * @date 2017年6月28日下午3:19:17
	 */
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(@ScubeParam("appno") String appno, @ScubeParam("factType") String factType);

}

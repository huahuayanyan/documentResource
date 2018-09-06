/**
 * 
 */
package com.huateng.scf.bas.com.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.BComErrorConstant;
import com.huateng.scf.bas.common.constant.IndirectCreditConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.CommonCreditProcessBussAmtVO;
import com.huateng.scf.bas.common.model.CreditInterParamVO;
import com.huateng.scf.bas.common.model.CreditOptFieldMap;
import com.huateng.scf.bas.common.service.IScfIndirectCreditService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.icr.constant.BIcrErrorConstant;
import com.huateng.scf.bas.icr.model.BIcrInfo;
import com.huateng.scf.bas.icr.model.BIcrType;
import com.huateng.scf.bas.icr.model.CreditInterParamBean;
import com.huateng.scf.bas.icr.model.CreditQryVO;
import com.huateng.scf.bas.icr.model.CreditTypeQryVO;
import com.huateng.scf.bas.icr.service.IBIcrDtlService;
import com.huateng.scf.bas.icr.service.IBIcrInfoService;
import com.huateng.scf.bas.icr.service.IBIcrTypeService;
import com.huateng.scf.bas.lan.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanAppliLnciBaseService;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.pbc.constant.BPbcErrorConstant;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.constant.BPrdErrorConstant;
import com.huateng.scf.bas.prd.model.BPrdCreditBind;
import com.huateng.scf.bas.prd.service.IBPrdCreditBindService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliRepayment;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliRepaymentService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 间接额度处理实现类
 * </p>
 *
 * @author huangshuidan
 * @date 2017年1月17日下午1:49:07
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年1月17日下午1:49:07             新增
 *
 *            </pre>
 */
@ScubeService
@Service(IScfIndirectCreditService.BEAN_ID)
public class ScfIndirectCreditServiceImpl implements IScfIndirectCreditService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = IBPbcAppliBaseInfoService.BEAN_ID)
	private IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;// 业务申请表
	@Resource(name = IBLanLnciBaseService.BEAN_ID)
	private IBLanLnciBaseService bLanLnciBaseService; // 借据基本信息
	@Resource(name = IBLanAppliLnciBaseService.BEAN_ID)
	private IBLanAppliLnciBaseService bLanAppliLnciBaseService; // 借据申请信息
	@Resource(name = "RBcpAppliBussInfoServiceImpl")
	private IRBcpAppliBussInfoService rbcpapplibussinfoservice;// 应收账款业务申请流水信息
	@Resource(name = "bMrnAppliAcctInfoService")
	private IBMrnAppliAcctInfoService bMrnAppliAcctInfoService; // 保证金及现金等价物业务申请信息
	@Resource(name = "RBcpAppliRepaymentServiceImpl")
	private IRBcpAppliRepaymentService rbcpapplirepaymentservice;// 还款/回款申请流水信息表
	@Resource(name = "BPrdCreditBindServiceImpl")
	private IBPrdCreditBindService bPrdCreditBindService;// 产品额度绑定表
	@Resource(name = "BIcrTypeServiceImpl")
	private IBIcrTypeService bicrtypeservice;// 额度种类信息表
	@Resource(name = "BIcrInfoServiceImpl")
	IBIcrInfoService bIcrInfoService; // 额度信息
	@Resource(name = "BIcrDtlServiceImpl")
	IBIcrDtlService bIcrDtlService; // 额度详情信息

	@Resource(name = "BCntMprotPartInfoServiceImpl")
	IBCntMprotPartInfoService bcntmprotpartinfoservice;// 三方协议

	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;// 抵质押合同信息

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.common.service.IScfIndirectCreditService#
	 * indCreditAppliCommonProcess(java.util.Map, java.math.BigDecimal)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@Transactional
	public void indCreditAppliCommonProcess(Map indirectMap, BigDecimal openAmt) throws ScubeBizException {
		String appNo = null == indirectMap.get(IndirectCreditConstant.APP_NO) ? "" : indirectMap.get(IndirectCreditConstant.APP_NO).toString();// 业务申请号
		String debitNo = null == indirectMap.get(IndirectCreditConstant.DEBIT_NO) ? "" : indirectMap.get(IndirectCreditConstant.DEBIT_NO).toString();// 供应链借据号
		String operType = null == indirectMap.get(IndirectCreditConstant.OPER_TYPE) ? ""
				: indirectMap.get(IndirectCreditConstant.OPER_TYPE).toString();// 操作类型
		boolean breakFlag = false;
		// 校验appNo是否为空
		if (StringUtil.isStrEmpty(appNo)) {
			log.info("===================>>IScfIndirectCreditService.indCreditAppliCommonProcess:申请号丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10005), BPbcErrorConstant.SCF_BAS_PBC_10005);
		}
		// 根据申请号查询业务申请基本信息
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		if (null == bPbcAppliBaseInfo) {
			log.info("===================>>IScfIndirectCreditService.indCreditAppliCommonProcess:业务申请信息不存在！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10004), BPbcErrorConstant.SCF_BAS_PBC_10004);
		}
		String appliType = bPbcAppliBaseInfo.getAppliType();// 申请业务类型
		String productId = bPbcAppliBaseInfo.getSupplyChainPdId();// 产品编号
		// 校验产品ID是否为空
		if (StringUtil.isStrEmpty(productId)) {
			log.info("===================>>IScfIndirectCreditService.indCreditAppliCommonProcess:产品编号丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20001), BComErrorConstant.SCF_BAS_COM_20001);
		}
		String businessno = "";// 关联业务号
		String relaType = ScfBasConstant.CREDIT_RELA_TYPE_LNCI;// 额度业务关联类型:借据
		String custcd = "";// 客户号
		String otherCustcd = "";// 交易对手,额度占用方
		String creditPhase = "";// 额度阶段
		String creditOprType = "";// 额度操作
		String releaseFlag = ScfBasConstant.FLAG_OFF;// 是否放款退回：默认：否
		BLanLnciBase bLanLnciBase = null;
		List creditOpList = null;
		// 现金等价物新增
		if (WorkflowConstant.APPLI_TYPE_CASHEQUALVALUE.equalsIgnoreCase(appliType)
				|| WorkflowConstant.APPLI_TYPE_CASHEQUALREG_APPLY.equalsIgnoreCase(appliType)) {
			if (StringUtil.isStrEmpty(debitNo)) {
				log.info("===================>>IScfIndirectCreditService.indCreditAppliCommonProcess:借据编号丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20002),
						BComErrorConstant.SCF_BAS_COM_20002);
			}
			bLanLnciBase = bLanLnciBaseService.findBLanLnciBaseByKey(debitNo);
			if (null == bLanLnciBase) {
				log.info("===================>>IScfIndirectCreditService.indCreditAppliCommonProcess:[" + debitNo + "]借据不存在！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKeyParams(BComErrorConstant.SCF_BAS_COM_20003, new Object[] { debitNo }),
						BComErrorConstant.SCF_BAS_COM_20003);
			}
			businessno = bLanLnciBase.getDebetId();
			creditPhase = ScfBasConstant.CREDIT_PHASE_CASH_QYL;// 现金等价物新增阶段
			creditOprType = ScfBasConstant.CREDIT_OPR_TYPE_RELEASE; // 额度释放
			custcd = bLanLnciBase.getCreditCustcd();// 客户号
			otherCustcd = bLanLnciBase.getCustcd();// 交易对手,额度占用方
			productId = bLanLnciBase.getProductId();// 产品ID
		} // 应收账款融资--放款
		else if (WorkflowConstant.APPLI_TYPE_INCOICEFINANCINGAPPLY.equalsIgnoreCase(appliType)// 应收账款融资发放-流贷
				|| WorkflowConstant.APPLI_TYPE_INCOICEFINANCINGBILLAPPLY.equalsIgnoreCase(appliType)// 应收账款融资发放-银承
				|| WorkflowConstant.APPLI_TYPE_INCOICE_FINANCING_LETTER_GUARANTEE_APPLY.equalsIgnoreCase(appliType)// 应收账款融资发放-融资性保函
				|| WorkflowConstant.APPLI_TYPE_INCOICE_FINANCING_LETTER_GUARANTEE_NO_APPLY.equalsIgnoreCase(appliType)// 应收账款融资发放-非融资性保函
				|| WorkflowConstant.APPLI_TYPE_INCOICE_FINANCING_GUARANTEE_DISCOUNT_APPLY.equalsIgnoreCase(appliType)// 应收账款融资发放-保贴函
				|| WorkflowConstant.APPLI_TYPE_INCOICE_FINANCING_CREDIT_APPLY.equalsIgnoreCase(appliType)) {// 应收账款融资发放-信用证
			bLanLnciBase = bLanLnciBaseService.findBLanLnciBaseByKey(debitNo);
			// 根据业务申请号查询借据申请信息
			BLanAppliLnciBase bLanAppliLnciBase = bLanAppliLnciBaseService.queryBLanAppliLnciBaseByAppno(appNo);
			businessno = bLanAppliLnciBase.getDebetId();
			if (StringUtil.isStrEmpty(businessno)) {
				log.info("===================>>IScfIndirectCreditService.indCreditAppliCommonProcess:借据编号丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20002),
						BComErrorConstant.SCF_BAS_COM_20002);
			}
			creditPhase = ScfBasConstant.CREDIT_PHASE_DEBT_FINANCING;// [额度阶段]-应收账款-应收账款融资
			relaType = ScfBasConstant.CREDIT_RELA_TYPE_LNCI;// 额度业务关联类型:借据
			// 放款通过
			if (ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equalsIgnoreCase(operType)) {
				creditOprType = ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY;
			}
			// 放款退回
			if (ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equalsIgnoreCase(operType)) {
				creditOprType = ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
				releaseFlag = ScfBasConstant.FLAG_ON;// 放款退回
			}
			custcd = bLanAppliLnciBase.getCreditCustcd();// 买方
			otherCustcd = bLanAppliLnciBase.getCustcd();// 卖方
		} // 应收账款融资 回款
		else if (WorkflowConstant.APPLI_TYPE_CASHPAYMENTAPPLY.equalsIgnoreCase(appliType)) {// 应收账款融资
																							// 回款
			creditPhase = ScfBasConstant.CREDIT_PHASE_DEBT_PAYMENT;// [额度阶段]-应收账款回款
			creditOprType = ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;// 占用恢复（释放）
			creditOpList = new ArrayList();
			CreditInterParamVO creditInterParam = new CreditInterParamVO();
			creditInterParam.setProductId(productId);
			creditInterParam.setRelaType(relaType);
			creditInterParam.setCreditPhase(creditPhase);
			creditInterParam.setCreditOperType(creditOprType);
			List<RBcpAppliBussInfo> appliList = rbcpapplibussinfoservice.queryAppliBussInfoBillsNo(appNo);
			RBcpAppliBussInfo rBcpAppliBussInfo = new RBcpAppliBussInfo();
			if (null != appliList && appliList.size() > 0) {
				rBcpAppliBussInfo = (RBcpAppliBussInfo) appliList.get(0);
			}
			String returnUsage = rBcpAppliBussInfo.getReason();// 回款用途
			// 入保证金-额度处理
			if (ScfBasConstant.BILL_FINANCING_RETURN_USAGE_BAIL.equalsIgnoreCase(returnUsage)) {// 入保证金
				List<BMrnAppliAcctInfo> accountList = bMrnAppliAcctInfoService.findBMrnAppliAcctInfoByAppno(appNo);
				if (null != accountList && accountList.size() > 0) {
					for (int k = 0; k < accountList.size(); k++) {
						BMrnAppliAcctInfo bMrnAppliAcctInfo = (BMrnAppliAcctInfo) accountList.get(k);
						String debetNo = bMrnAppliAcctInfo.getDebetNo();
						BigDecimal amount = bMrnAppliAcctInfo.getAmount();// 还款金额
						bLanLnciBase = bLanLnciBaseService.findBLanLnciBaseByKey(debetNo);
						String hasIndirectCredit = bLanLnciBase.getHasIndirectCredit();
						if (ScfBasConstant.HAS_INDIRECT_CREDIT_TRUE.equals(hasIndirectCredit)) {
							businessno = bLanLnciBase.getDebetNo();
							custcd = bLanLnciBase.getCreditCustcd();// 买方
							otherCustcd = bLanLnciBase.getCustcd();// 卖方
							// TODO 可抽取独立方法
							creditInterParam.setAmount(amount);
							creditInterParam.setBusinessno(businessno);
							creditInterParam.setCustcd(custcd);
							creditInterParam.setOtherCustcd(otherCustcd);
							creditOpList.add(creditInterParam);
						} else {
							breakFlag = true;
						}
					}
				}
			}
			// 还贷-额度处理
			if (ScfBasConstant.BILL_FINANCING_RETURN_USAGE_RAYMENT.equalsIgnoreCase(returnUsage)) {// 还贷
				List<RBcpAppliRepayment> repaymentList = rbcpapplirepaymentservice.queryTblAppliRepaymentInfoByAppno(appNo); // 还款信息--流贷还本息信息
				if (null != repaymentList && repaymentList.size() > 0) {
					for (int k = 0; k < repaymentList.size(); k++) {
						RBcpAppliRepayment tblAppliRepaymentInfo = (RBcpAppliRepayment) repaymentList.get(k);
						String debetNo = tblAppliRepaymentInfo.getDebetNo();
						BigDecimal amount = tblAppliRepaymentInfo.getRepayAmount();// 还款金额
						// debetNo借据号对应的借据信息中的debetId字段，不是debetNo
						bLanLnciBase = bLanLnciBaseService.findBLanLnciBaseByDebtId(debetNo);
						String hasIndirectCredit = bLanLnciBase.getHasIndirectCredit();
						if (ScfBasConstant.HAS_INDIRECT_CREDIT_TRUE.equals(hasIndirectCredit)) {
							businessno = bLanLnciBase.getDebetNo();// 存的是借据信息表的主键Id不是在其他表中的借据号
							custcd = bLanLnciBase.getCreditCustcd();// 买方
							otherCustcd = bLanLnciBase.getCustcd();// 卖方
							// TODO 可抽取独立方法
							creditInterParam.setAmount(amount);
							creditInterParam.setBusinessno(businessno);
							creditInterParam.setCustcd(custcd);
							creditInterParam.setOtherCustcd(otherCustcd);
							creditOpList.add(creditInterParam);
						} else {
							breakFlag = true;
						}
					}
				}
			}
		}
		// 普通仓单放款 add by huangshuidan 2014-02-14 begin
		else if (WorkflowConstant.APPLI_TYPE_BILL_NORMAL_CASH_LOAN_APPLY.equalsIgnoreCase(appliType)// 普通仓单放款申请--流贷
				|| WorkflowConstant.APPLI_TYPE_BILL_NORMAL_BILL_LOAN_APPLY.equalsIgnoreCase(appliType)
				|| WorkflowConstant.APPLI_TYPE_NORMAL_LETTER_GUARANTEE_APPLY.equalsIgnoreCase(appliType)
				|| WorkflowConstant.APPLI_TYPE_NORMAL_PHASE_LETTER_GUARANTEE_NO_APPLY.equalsIgnoreCase(appliType)
				|| WorkflowConstant.APPLI_TYPE_NORMAL_PHASE_GUARANTEE_DISCOUNT_APPLY.equalsIgnoreCase(appliType)
				|| WorkflowConstant.APPLI_TYPE_NORMAL_PHASE_CREDIT_APPLY.equalsIgnoreCase(appliType)) {// 普通仓单放款申请--银承
			BLanAppliLnciBase bLanAppliLnciBase = bLanAppliLnciBaseService.queryBLanAppliLnciBaseByAppno(appNo);
			businessno = bLanAppliLnciBase.getDebetId();

			if (StringUtil.isEmpty(businessno)) {
				log.info("===================>>IScfIndirectCreditService.indCreditAppliCommonProcess:借据编号丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20002),
						BComErrorConstant.SCF_BAS_COM_20002);
			}
			creditPhase = ScfBasConstant.CREDIT_PHASE_STANDARD_WAREHOUSE_RECEIPT_FINANCING;

			relaType = ScfBasConstant.CREDIT_RELA_TYPE_LNCI;
			// 放款通过
			if (ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equalsIgnoreCase(operType)) {
				creditOprType = ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY;
			}
			// 放款退回
			if (ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equalsIgnoreCase(operType)) {
				creditOprType = ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
				releaseFlag = ScfBasConstant.FLAG_ON;// 放款退回
			}
			// 仓单放款中其间接额度客户为监管公司客户号
			BCrrGntyCon bCrrGntyCon = bcrrgntycondao.selectByPrimaryKey(bLanAppliLnciBase.getSlaveContno());
			custcd = bcntmprotpartinfoservice.findCnameByProAndRole(bCrrGntyCon.getPrtclNo(), ScfBasConstant.PROTOCOL_PART_ROLE_MONI,
					ScfBasConstant.RETURN_FLAG_CUSTCD);// 卖方--监管商客户号
			otherCustcd = bLanAppliLnciBase.getCustcd();// 买方

		}
		// 普通仓单放款 end by huangshuidan 2014-02-14
		else if (WorkflowConstant.APPLI_TYPE_BILL_NORMAL_DELIVERY_APPLY.equalsIgnoreCase(appliType)) {// 非标仓单提货申请
			creditPhase = ScfBasConstant.CREDIT_PHASE_BILLNORMAL_DELIVERY;
			creditOprType = ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
			creditOpList = new ArrayList();
			CreditInterParamBean creditInterParam = new CreditInterParamBean();
			creditInterParam.setProductId(productId);
			creditInterParam.setRelaType(relaType);
			creditInterParam.setCreditPhase(creditPhase);
			creditInterParam.setCreditOperType(creditOprType);
			List<BMrnAppliAcctInfo> list = bMrnAppliAcctInfoService.findBMrnAppliAcctInfoByAppno(appNo);
			if (list != null && list.size() > 0) {
				for (int k = 0; k < list.size(); k++) {
					BMrnAppliAcctInfo tblAppliCustAccountInfo = (BMrnAppliAcctInfo) list.get(k);
					String debetNo = tblAppliCustAccountInfo.getDebetNo();
					BigDecimal amount = tblAppliCustAccountInfo.getBailAmount();
					BLanLnciBase bLanAppliLnciBase = bLanLnciBaseService.findBLanLnciBaseByKey(debetNo);
					String hasIndirectCredit = bLanAppliLnciBase.getHasIndirectCredit();
					if (ScfBasConstant.HAS_INDIRECT_CREDIT_TRUE.equals(hasIndirectCredit)) {
						businessno = bLanAppliLnciBase.getDebetId();
						BCrrGntyCon bCrrGntyCon = bcrrgntycondao.selectByPrimaryKey(bLanAppliLnciBase.getSlaveContno());
						// 仓单放款中其间接额度客户为监管公司客户号
						custcd = bcntmprotpartinfoservice.findCnameByProAndRole(bCrrGntyCon.getPrtclNo(), ScfBasConstant.PROTOCOL_PART_ROLE_MONI,
								ScfBasConstant.RETURN_FLAG_CUSTCD);// 卖方--监管商客户号
						otherCustcd = bLanAppliLnciBase.getCustcd();// 买方

						creditInterParam.setAmount(amount);
						creditInterParam.setBusinessno(businessno);
						creditInterParam.setCustcd(custcd);
						creditInterParam.setOtherCustcd(otherCustcd);
						creditOpList.add(creditInterParam);
					} else {
						breakFlag = true;
					}
				}
			}
		}
		// 先票款后货 放款
		else if (WorkflowConstant.APPLI_TYPE_FOUR_LOAN_APPLY.equalsIgnoreCase(appliType)// 先票后货放款申请--流贷
				|| WorkflowConstant.APPLI_TYPE_FOUR_BILL_APPLY.equalsIgnoreCase(appliType)// 先票后货放款申请--银承
				|| WorkflowConstant.APPLI_TYPE_FOUR_LETTER_GUARANTEE_APPLY.equalsIgnoreCase(appliType)// 先票/款后货-出账申请-融资性保函
				|| WorkflowConstant.APPLI_TYPE_FOUR_LETTER_GUARANTEE_NO_APPLY.equalsIgnoreCase(appliType)// 先票/款后货-出账申请-非融资性保函
				|| WorkflowConstant.APPLI_TYPE_FOUR_GUARANTEE_DISCOUNT_APPLY.equalsIgnoreCase(appliType)// 先票/款后货-出账申请-保贴函
				|| WorkflowConstant.APPLI_TYPE_FOUR_CREDIT_APPLY.equalsIgnoreCase(appliType)) {// 先票/款后货-出账申请-信用证
			BLanAppliLnciBase bLanAppliLnciBase = bLanAppliLnciBaseService.queryBLanAppliLnciBaseByAppno(appNo);
			businessno = bLanAppliLnciBase.getDebetId();

			if (StringUtil.isEmpty(businessno)) {
				log.info("===================>>IScfIndirectCreditService.indCreditAppliCommonProcess:借据编号丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20002),
						BComErrorConstant.SCF_BAS_COM_20002);
			}
			creditPhase = ScfBasConstant.CREDIT_PHASE_FOUR_WAREHOUSE_ACCOUNT;
			relaType = ScfBasConstant.CREDIT_RELA_TYPE_LNCI;
			// 放款通过
			if (ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equalsIgnoreCase(operType)) {
				creditOprType = ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY;
			}
			// 放款退回
			if (ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equalsIgnoreCase(operType)) {
				creditOprType = ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
				releaseFlag = ScfBasConstant.FLAG_ON;// 放款退回
			}
			custcd = bLanAppliLnciBase.getCreditCustcd();// 卖方
			otherCustcd = bLanAppliLnciBase.getCustcd();// 买方
		}
		// 先票款后货提货
		else if (WorkflowConstant.APPLI_TYPE_FOURHOUSEDELIVERYAPPLY.equalsIgnoreCase(appliType)) {// 先票后货提货申请
			creditPhase = ScfBasConstant.CREDIT_PHASE_FOUR_WAREHOUSE_DELIVERYAPPLI;
			creditOprType = ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
			// relaType=ScfBasConstant.CREDIT_RELA_TYPE_CONT;
			creditOpList = new ArrayList();
			CreditInterParamBean creditInterParam = new CreditInterParamBean();
			creditInterParam.setProductId(productId);
			creditInterParam.setRelaType(relaType);
			creditInterParam.setCreditPhase(creditPhase);
			creditInterParam.setCreditOperType(creditOprType);
			List<BMrnAppliAcctInfo> list = bMrnAppliAcctInfoService.findBMrnAppliAcctInfoByAppno(appNo);
			if (list != null && list.size() > 0) {
				for (int k = 0; k < list.size(); k++) {
					BMrnAppliAcctInfo tblAppliCustAccountInfo = (BMrnAppliAcctInfo) list.get(k);
					String debetNo = tblAppliCustAccountInfo.getDebetNo();
					BigDecimal amount = tblAppliCustAccountInfo.getBailAmount();
					BLanLnciBase lnciBase = bLanLnciBaseService.findBLanLnciBaseByKey(debetNo);
					String hasIndirectCredit = lnciBase.getHasIndirectCredit();
					if (ScfBasConstant.HAS_INDIRECT_CREDIT_TRUE.equals(hasIndirectCredit)) {
						businessno = lnciBase.getDebetId();
						custcd = lnciBase.getCreditCustcd();// 卖方
						otherCustcd = lnciBase.getCustcd();// 买方

						creditInterParam.setAmount(amount);
						creditInterParam.setBusinessno(businessno);
						creditInterParam.setCustcd(custcd);
						creditInterParam.setOtherCustcd(otherCustcd);
						creditOpList.add(creditInterParam);
					} else {
						breakFlag = true;
					}
				}
			}
		}
		// 现货质押放款 add by huangshuidan 2014-02-12 begin
		else if (WorkflowConstant.APPLI_TYPE_MORTGAGE_CASH_LOAN_APPLY.equalsIgnoreCase(appliType)// 现货质押放款申请--流贷
				|| WorkflowConstant.APPLI_TYPE_MORTGAGE_BILL_LOAN_APPLY.equalsIgnoreCase(appliType)// 现货质押放款申请--银承
				|| WorkflowConstant.APPLI_TYPE_MORTGAGE_LETTER_GUARANTEE_APPLY.equalsIgnoreCase(appliType)// 动产-放款申请-融资性保函
				|| WorkflowConstant.APPLI_TYPE_MORTGAGE_LETTER_GUARANTEE_NO_APPLY.equalsIgnoreCase(appliType)// 动产-放款申请-非融资性保函
				|| WorkflowConstant.APPLI_TYPE_MORTGAGE_GUARANTEE_DISCOUNT_APPLY.equalsIgnoreCase(appliType)// 动产-放款申请-保贴函
				|| WorkflowConstant.APPLI_TYPE_MORTGAGE_CREDIT_APPLY.equalsIgnoreCase(appliType)) {// 动产-放款申请-信用证
			BLanAppliLnciBase bLanAppliLnciBase = bLanAppliLnciBaseService.queryBLanAppliLnciBaseByAppno(appNo);
			businessno = bLanAppliLnciBase.getDebetId();

			if (StringUtil.isEmpty(businessno)) {
				throw new ScubeBizException("借据编号丢失！", RBcpErrorConstant.RECORD_NOT_EXIST);
			}
			// 判断产品类型productId
			if (null != productId && ScfBasConstant.PRODUCT_TYPE_PLDY.equals(productId)) {
				// 现货动态抵/质押
				creditPhase = ScfBasConstant.CREDIT_PHASE_CASH_PLEDGE_DYNSTATE_FINANCING;
			} else if (ScfBasConstant.PRODUCT_TYPE_PLSY.equals(productId)) {
				// 现货静态抵/质押
				creditPhase = ScfBasConstant.CREDIT_PHASE_CASH_PLEDGE_STATICSTATE_FINANCING;
			}

			relaType = ScfBasConstant.CREDIT_RELA_TYPE_LNCI;
			// 放款通过
			if (ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equalsIgnoreCase(operType)) {
				creditOprType = ScfBasConstant.CREDIT_OPR_TYPE_OCCUPY;
			}
			// 放款退回
			if (ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equalsIgnoreCase(operType)) {
				creditOprType = ScfBasConstant.CREDIT_OPR_TYPE_RELEASE;
				releaseFlag = ScfBasConstant.FLAG_ON;// 放款退回
			}
			custcd = bLanAppliLnciBase.getCreditCustcd();// 卖方
			otherCustcd = bLanAppliLnciBase.getCustcd();// 买方

		} // 现货质押放款 end by huangshuidan 2014-02-12
			// 额度处理
		if (creditOpList != null && creditOpList.size() > 0) {
			for (int k = 0; k < creditOpList.size(); k++) {
				CreditInterParamVO creditInterParamTemp = (CreditInterParamVO) creditOpList.get(k);
				String creditProductId = creditInterParamTemp.getProductId();
				BigDecimal creditAmt = creditInterParamTemp.getAmount();
				String creditBusinessno = creditInterParamTemp.getBusinessno();
				String creditCustcd = creditInterParamTemp.getCustcd();
				String creditOtherCustcd = creditInterParamTemp.getOtherCustcd();

				// 设置查询条件
				BPrdCreditBind productCreditBind = new BPrdCreditBind();
				productCreditBind.setProductId(creditProductId); // 产品Id
				productCreditBind.setCreditPhase(creditPhase);
				productCreditBind.setOprType(creditOprType);
				// 根据产品Id及操作类型 获取当前业务阶段的额度设定列表
				List<BPrdCreditBind> creditBindList = bPrdCreditBindService.findBPrdCreditBindBPrd(productCreditBind);

				if (creditBindList == null || creditBindList.size() == 0) {
					log.info("===================>>IScfIndirectCreditService.indCreditAppliCommonProcess:产品与额度类型关联信息丢失！");
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPrdErrorConstant.SCF_BAS_PRD_10000),
							BPrdErrorConstant.SCF_BAS_PRD_10000);
				}

				CommonCreditProcessBussAmtVO bussAmtVO = new CommonCreditProcessBussAmtVO();
				bussAmtVO.setRiskAmount(creditAmt);

				// 循环当前业务阶段的额度设定列表,依次处理额度列表中的各种额度
				for (int i = 0; i < creditBindList.size(); i++) {
					BigDecimal amount = null; // 操作金额

					// 获取产品额度绑定信息
					BPrdCreditBind creditBind = creditBindList.get(i);
					String creditType = creditBind.getCreditType(); // 额度类型
					String oprField = creditBind.getOprField(); // 额度操作金额

					CreditTypeQryVO creditTypeQryVO = new CreditTypeQryVO();
					creditTypeQryVO.setPageIndex(1);
					creditTypeQryVO.setPageSize(Integer.MAX_VALUE);
					creditTypeQryVO.setCreditClass_Q(ScfBasConstant.CREDIT_CLASS_INDIRECT);
					creditTypeQryVO.setCreditType_Q(creditType);
					List<BIcrType> listresult = bicrtypeservice.getCreditTypeInfoByCreditTypeQryVO(creditTypeQryVO);
					if (null != listresult && listresult.size() > 0) {
						// 获取额度操作的金额
						String oprFieldName = CreditOptFieldMap.fieldMap.get(oprField);
						try {
							String amountStr = BeanUtils.getProperty(bussAmtVO, oprFieldName);
							if (StringUtil.isStrEmpty(amountStr)) {
								log.info("===================>>IScfIndirectCreditService.indCreditAppliCommonProcess:额度操作金额配置错误！");
								throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPrdErrorConstant.SCF_BAS_PRD_10001),
										BPrdErrorConstant.SCF_BAS_PRD_10001);
							}
							amount = new BigDecimal(amountStr);
							if (amount.compareTo(new BigDecimal("0")) == 0) { // 如果操作金额为等于0则不进行处理
								continue;
							}
						} catch (Throwable te) {
							te.printStackTrace();
							log.error("===================>>IScfIndirectCreditService.indCreditAppliCommonProcess:额度操作金额配置错误！" + te.getMessage());
							throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPrdErrorConstant.SCF_BAS_PRD_10001),
									BPrdErrorConstant.SCF_BAS_PRD_10001);
						}

						// 设置额度处理参数
						CreditInterParamVO creditInterParam = new CreditInterParamVO();
						creditInterParam.setApplyType(appliType);
						creditInterParam.setBusinessno(creditBusinessno);
						creditInterParam.setRelaType(relaType);
						creditInterParam.setAppno(appNo);

						indirectCreditDealWith(creditInterParam, creditCustcd, creditOtherCustcd, creditType, operType, amount, releaseFlag);
					}
				}
			}
		} else if (!breakFlag && StringUtil.isStrNotEmpty(productId) && StringUtil.isStrNotEmpty(creditPhase)
				&& StringUtil.isStrNotEmpty(creditOprType)) {
			// 根据产品Id及操作类型 获取当前业务阶段的额度设定列表
			// 设置查询条件
			BPrdCreditBind productCreditBind = new BPrdCreditBind();
			productCreditBind.setProductId(productId); // 产品Id
			productCreditBind.setCreditPhase(creditPhase);
			productCreditBind.setOprType(creditOprType);
			// 依据产品Id和操作类型查询
			List<BPrdCreditBind> creditBindList = bPrdCreditBindService.findBPrdCreditBindBPrd(productCreditBind);
			if (creditBindList == null || creditBindList.size() == 0) {
				log.info("===================>>IScfIndirectCreditService.indCreditAppliCommonProcess:产品与额度类型关联信息丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPrdErrorConstant.SCF_BAS_PRD_10000),
						BPrdErrorConstant.SCF_BAS_PRD_10000);
			}
			CommonCreditProcessBussAmtVO bussAmtVO = new CommonCreditProcessBussAmtVO();
			bussAmtVO.setRiskAmount(openAmt);

			// 循环当前业务阶段的额度设定列表,依次处理额度列表中的各种额度
			for (int i = 0; i < creditBindList.size(); i++) {
				BigDecimal amount = null; // 操作金额

				// 获取产品额度绑定信息
				BPrdCreditBind creditBind = creditBindList.get(i);
				String creditType = creditBind.getCreditType(); // 额度类型
				String oprField = creditBind.getOprField(); // 额度操作金额

				CreditTypeQryVO creditTypeQryVO = new CreditTypeQryVO();
				// creditTypeQryVO.setPageIndex(1);
				// creditTypeQryVO.setPageSize(Integer.MAX_VALUE);
				creditTypeQryVO.setCreditClass_Q(ScfBasConstant.CREDIT_CLASS_INDIRECT);
				creditTypeQryVO.setCreditType_Q(creditType);
				List<BIcrType> listresult = bicrtypeservice.getCreditTypeInfoByCreditTypeQryVO(creditTypeQryVO);

				if (null != listresult && listresult.size() > 0) {
					// 获取额度操作的金额
					String oprFieldName = CreditOptFieldMap.fieldMap.get(oprField);
					try {
						String amountStr = BeanUtils.getProperty(bussAmtVO, oprFieldName);
						if (StringUtil.isStrEmpty(amountStr)) {
							log.info("===================>>IScfIndirectCreditService.indCreditAppliCommonProcess:额度操作金额配置错误！");
							throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPrdErrorConstant.SCF_BAS_PRD_10001),
									BPrdErrorConstant.SCF_BAS_PRD_10001);
						}
						amount = new BigDecimal(amountStr);
						if (amount.compareTo(new BigDecimal("0")) == 0) { // 如果操作金额为等于0则不进行处理
							continue;
						}
					} catch (Throwable te) {
						te.printStackTrace();
						log.error("===================>>IScfIndirectCreditService.indCreditAppliCommonProcess:额度操作金额配置错误！" + te.getMessage());
						throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPrdErrorConstant.SCF_BAS_PRD_10001),
								BPrdErrorConstant.SCF_BAS_PRD_10001);
					}

					// 设置额度处理参数
					CreditInterParamVO creditInterParam = new CreditInterParamVO();
					creditInterParam.setApplyType(appliType);
					creditInterParam.setBusinessno(businessno);
					creditInterParam.setRelaType(relaType);
					creditInterParam.setAppno(appNo);

					indirectCreditDealWith(creditInterParam, custcd, otherCustcd, creditType, operType, amount, releaseFlag);
				}
			}
		} else if (breakFlag) {
			// 间接额度不处理
		} else {
			log.info("===================>>IScfIndirectCreditService.indCreditAppliCommonProcess:额度阶段或操作类型操作类型未配置，请配置后再操作！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10004), BIcrErrorConstant.SCF_BAS_ICR_10004);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.common.service.IScfIndirectCreditService#
	 * indirectCreditDealWith(com.huateng.scf.bas.common.model.
	 * CreditInterParamVO, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.math.BigDecimal, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void indirectCreditDealWith(CreditInterParamVO creditInterParam, String custcd, String otherCustcd, String creditType, String operType,
			BigDecimal amt, String releaseFlag) throws ScubeBizException {

		if (StringUtil.isStrEmpty(custcd)) {
			log.info("===================>>IScfIndirectCreditService.indirectCreditDealWith:客户信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10005), BIcrErrorConstant.SCF_BAS_ICR_10005);
		}
		if (StringUtil.isStrEmpty(otherCustcd)) {
			log.info("===================>>IScfIndirectCreditService.indirectCreditDealWith:交易对手信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10006), BIcrErrorConstant.SCF_BAS_ICR_10006);
		}
		if (StringUtil.isStrEmpty(creditType)) {
			log.info("===================>>IScfIndirectCreditService.indirectCreditDealWith:间接额度种类信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10007), BIcrErrorConstant.SCF_BAS_ICR_10007);
		}
		if (StringUtil.isStrEmpty(operType)) {
			log.info("===================>>IScfIndirectCreditService.indirectCreditDealWith:间接额度操作类型丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10013), BIcrErrorConstant.SCF_BAS_ICR_10013);
		}
		if (StringUtil.isEmpty(amt)) {
			log.info("===================>>IScfIndirectCreditService.indirectCreditDealWith:间接额度操作金额信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10008), BIcrErrorConstant.SCF_BAS_ICR_10008);
		}

		CreditQryVO creditQryVO = new CreditQryVO();
		creditQryVO.setCreditClass_Q(ScfBasConstant.CREDIT_CLASS_INDIRECT);
		creditQryVO.setNodeType_Q(ScfBasConstant.CREDIT_NODE_TYPE_SUB_LEAF);
		creditQryVO.setCustcd(custcd);
		creditQryVO.setOtherCustcd_Q(otherCustcd);
		creditQryVO.setCreditType_Q(creditType);
		// 直接占用
		if (ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equalsIgnoreCase(operType)) {
			creditQryVO.setStatus_Q(ScfBasConstant.CREDIT_STATUS_NORMAL);
			BIcrInfo bIcrInfo = new BIcrInfo();
			bIcrInfo.setCreditClass(ScfBasConstant.CREDIT_CLASS_INDIRECT);
			bIcrInfo.setNodeType(ScfBasConstant.CREDIT_NODE_TYPE_SUB_LEAF);
			bIcrInfo.setCustcd(custcd);
			// bIcrInfo.setOtherCustcd(otherCustcd);
			bIcrInfo.setCreditType(creditType);
			Page page = bIcrInfoService.findBIcrInfoByPage(1, 10000, bIcrInfo);
			List<com.huateng.scf.bas.icr.dao.model.BIcrInfo> subLeafCreditInfoList = null;
			if (null != page) {
				subLeafCreditInfoList = page.getRecords();
			}
			// 检查额度是否存在 条件：额度种类，客户号，交易对手 记录不存在则异常抛出错误
			if (subLeafCreditInfoList == null || subLeafCreditInfoList.size() == 0) {
				log.info("===================>>IScfIndirectCreditService.indirectCreditDealWith:间接领用额度信息丢失,不可占用额度！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10009),
						BIcrErrorConstant.SCF_BAS_ICR_10009);
			}

			// 获取领用额度B_ICR_INFO[额度信息表] B_ICR_DTL[额度使用流水表]
			// JSON.parseObject(subLeafCreditInfoList.get(0).toString(), new
			// TypeReference<BSysTask>(){});
			com.huateng.scf.bas.icr.dao.model.BIcrInfo BIcrInfoDao = (com.huateng.scf.bas.icr.dao.model.BIcrInfo) subLeafCreditInfoList.get(0);
			BIcrInfo subLeafCreditInfo = new BIcrInfo();
			// BeanUtils.copyProperties(subLeafCreditInfo, BIcrInfoDao);
			org.springframework.beans.BeanUtils.copyProperties(BIcrInfoDao, subLeafCreditInfo);

			// BIcrInfo subLeafCreditInfo
			// =(BIcrInfo)subLeafCreditInfoList.get(0);
			// 操作金额必须小于领用额度可用余额
			if (amt.compareTo(subLeafCreditInfo.getCreditUsableAmount()) > 0) {
				log.info("===================>>IScfIndirectCreditService.indirectCreditDealWith:占用额度必须小于等于当前领用额度的可用余额！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10010),
						BIcrErrorConstant.SCF_BAS_ICR_10010);
			}
			bIcrDtlService.addCreditDetail(creditInterParam, custcd, otherCustcd, creditType, operType, amt, subLeafCreditInfo);
			// 更新额度信息
			BigDecimal creditUsableAmount = subLeafCreditInfo.getCreditUsableAmount();
			BigDecimal usedAmount = subLeafCreditInfo.getUsedAmount();
			// 额度余额 = 前额度余额 – 交易金额
			subLeafCreditInfo.setCreditUsableAmount(creditUsableAmount.subtract(amt));
			// 实占用额度 = 前实占用额度 + 交易金额
			subLeafCreditInfo.setUsedAmount(usedAmount.add(amt));
			bIcrInfoService.updateBIcrInfo(subLeafCreditInfo);

			// begin 占用额度时，把占用的额度编号记录到借据申请表中
			BLanAppliLnciBase bLanAppliLnciBase = bLanAppliLnciBaseService.queryBLanAppliLnciBaseByAppno(creditInterParam.getAppno());
			if (null != bLanAppliLnciBase) {
				bLanAppliLnciBase.setCreditNo(subLeafCreditInfo.getCreditNo());
				bLanAppliLnciBaseService.updateBLanAppliLnciBase(bLanAppliLnciBase);
			} else { // 商票贴现、商票质押 没有申请表，只有正式表findBLanLnciBaseByDebtId
				String debtId = null == creditInterParam.getBusinessno() ? "" : creditInterParam.getBusinessno().trim();
				BLanLnciBase bLanLnciBase = bLanLnciBaseService.findBLanLnciBaseByDebtId(debtId);
				if (null != bLanLnciBase) {
					bLanLnciBase.setCreditNo(subLeafCreditInfo.getCreditNo());
					bLanLnciBaseService.updateBLanLnciBase(bLanLnciBase);
				}
			}
			// end 占用额度时，把占用的额度编号记录到借据申请表中
		}
		// 占用恢复
		if (ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equalsIgnoreCase(operType)) {
			// PageQueryResult
			// pageQueryResult=tblCreditInfoDAO.getCurrenyEffectiveTblCreditInfoByCreditQryVO(creditQryVO);
			// List subLeafCreditInfoList=pageQueryResult.getQueryResult();
			// // 检查额度是否存在 条件：额度种类，客户号，交易对手 记录不存在则异常抛出错误
			// if (subLeafCreditInfoList==null||subLeafCreditInfoList.size()==0)
			// {
			// ExceptionUtil.throwCommonException("间接领用额度信息丢失,不可释放额度！",SCFErrorCode.RECORD_NOT_EXIST);
			// }
			// //获取领用额度
			// TblCreditInfo subLeafCreditInfo
			// =(TblCreditInfo)subLeafCreditInfoList.get(0);
			// begin 恢复占用额度时，根据借据表的额度编号查询到相关的额度信息，进行恢复

			String debetNo = null == creditInterParam.getBusinessno() ? "" : creditInterParam.getBusinessno().trim();
			BLanAppliLnciBase bLanAppliLnciBase = bLanAppliLnciBaseService.queryBLanAppliLnciBaseByDebtNo(debetNo);

			if (null == bLanAppliLnciBase) {
				log.info("===================>>IScfIndirectCreditService.indCreditAppliCommonProcess:借据信息丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20003),
						BComErrorConstant.SCF_BAS_COM_20003);
			}
			// 获取领用额度
			BIcrInfo subLeafCreditInfo = bIcrInfoService.findBIcrInfoByCreditNo(bLanAppliLnciBase.getCreditNo());
			// TblCreditInfo subLeafCreditInfo =
			// tblCreditInfoDAO.get(StringUtil.trim(tblLnciBaseInfo.getCreditNo()));
			// BIcrInfo subLeafCreditInfo=null;
			if (subLeafCreditInfo == null) {
				log.info("===================>>IScfIndirectCreditService.indirectCreditDealWith:间接领用额度信息丢失,不可释放额度！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10012),
						BIcrErrorConstant.SCF_BAS_ICR_10012);
			}
			// end 恢复占用额度时，根据借据表的额度编号查询到相关的额度信息，进行恢复
			String controlType = subLeafCreditInfo.getControlType();
			// 循环时恢复释放额度 非循环时不作处理
			if (ScfBasConstant.CREDIT_CLASS_CYCLE.equalsIgnoreCase(controlType) || ScfBasConstant.FLAG_ON.equalsIgnoreCase(releaseFlag)) {
				// 恢复(释放)额度不可大于占用额度 当大于恢复额度大于占用额度的时候 直接恢复已占用额度
				if (amt.compareTo(subLeafCreditInfo.getUsedAmount()) > 0) {
					amt = subLeafCreditInfo.getUsedAmount();
				}
				// 记录流水
				bIcrDtlService.addCreditDetail(creditInterParam, custcd, otherCustcd, creditType, operType, amt, subLeafCreditInfo);

				// 更新额度信息
				BigDecimal creditUsableAmount = subLeafCreditInfo.getCreditUsableAmount();
				BigDecimal usedAmount = subLeafCreditInfo.getUsedAmount();
				// 额度余额 = 前额度余额 + 交易金额
				subLeafCreditInfo.setCreditUsableAmount(creditUsableAmount.add(amt));
				// 实占用额度 = 前实占用额度 - 交易金额
				subLeafCreditInfo.setUsedAmount(usedAmount.subtract(amt));
				bIcrInfoService.updateBIcrInfo(subLeafCreditInfo);
			}
		}

	}

	/**
	 * 应收账款放款是调用
	 * 
	 * @param operType
	 * @param creditNo
	 * @param amt
	 * @param appno
	 * @author mengjiajia
	 * @date 2017年6月20日下午4:42:34
	 */
	@Override
	public void indirectCreditDealWithByCreditNo(CreditInterParamVO creditInterParam, String operType) {
		if (StringUtil.isEmpty(creditInterParam.getCreditNo())) {
			throw new ScubeBizException("额度编号丢失！");
		}
		String creditNo = creditInterParam.getCreditNo();
		// 获取领用额度B_ICR_INFO[额度信息表] B_ICR_DTL[额度使用流水表]
		BIcrInfo subLeafCreditInfo = bIcrInfoService.findBIcrInfoByCreditNo(creditNo);
		if (StringUtil.isEmpty(creditInterParam.getAppno())) {
			throw new ScubeBizException("业务申请编号丢失！");
		}
		String appno = creditInterParam.getAppno();
		if (StringUtil.isEmpty(creditInterParam.getAmount())) {
			throw new ScubeBizException("申请金额丢失！");
		}
		BigDecimal amt = creditInterParam.getAmount();
		BLanAppliLnciBase bLanAppliLnciBase = bLanAppliLnciBaseService.queryBLanAppliLnciBaseByAppno(appno);
		// 直接占用
		if (ScfBasConstant.CREDIT_TRADE_TYPE_DIRECT_OCCUPY.equalsIgnoreCase(operType)) {
			// 操作金额必须小于领用额度可用余额
			if (amt.compareTo(subLeafCreditInfo.getCreditUsableAmount()) > 0) {
				log.info("===================>>IScfIndirectCreditService.indirectCreditDealWithByCreditNo:占用额度必须小于等于当前领用额度的可用余额！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BIcrErrorConstant.SCF_BAS_ICR_10010),
						BIcrErrorConstant.SCF_BAS_ICR_10010);
			}
			
			// 更新额度信息
			BigDecimal creditUsableAmount = subLeafCreditInfo.getCreditUsableAmount();
			BigDecimal usedAmount = subLeafCreditInfo.getUsedAmount();
			// 额度余额 = 前额度余额 – 交易金额
			subLeafCreditInfo.setCreditUsableAmount(creditUsableAmount.subtract(amt));
			// 实占用额度 = 前实占用额度 + 交易金额
			subLeafCreditInfo.setUsedAmount(usedAmount.add(amt));
			BIcrInfo bIcrInfo = new BIcrInfo();
			bIcrInfo.setCreditNo(creditNo);
			bIcrInfo.setCreditUsableAmount(creditUsableAmount.subtract(amt));
			bIcrInfo.setUsedAmount(usedAmount.add(amt));
			bIcrInfoService.updateBIcrInfo(bIcrInfo);
			
			try {
				BeanUtils.copyProperties(subLeafCreditInfo, creditInterParam);
//				bIcrDtlService.addCreditDetailForDuebill(creditInterParam, bLanAppliLnciBase.getCreditCustcd(), bLanAppliLnciBase.getCustcd(), subLeafCreditInfo.getCreditType(),
//						operType, amt, subLeafCreditInfo);
				bIcrDtlService.addCreditDetail(creditInterParam, bLanAppliLnciBase.getCreditCustcd(), bLanAppliLnciBase.getCustcd(), subLeafCreditInfo.getCreditType(),
						operType, amt, subLeafCreditInfo);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// 占用恢复
		if (ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE.equalsIgnoreCase(operType)) {
			if (null == bLanAppliLnciBase) {
				log.info("===================>>IScfIndirectCreditService.indirectCreditDealWithByCreditNo:借据信息丢失！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20003),
						BComErrorConstant.SCF_BAS_COM_20003);
			}
			
			// 获取领用额度
			String controlType = subLeafCreditInfo.getControlType();
			// 循环时恢复释放额度 非循环时不作处理
			if (ScfBasConstant.CREDIT_CLASS_CYCLE.equalsIgnoreCase(controlType)) {
				// 恢复(释放)额度不可大于占用额度 当大于恢复额度大于占用额度的时候 直接恢复已占用额度
				if (amt.compareTo(subLeafCreditInfo.getUsedAmount()) > 0) {
					amt = subLeafCreditInfo.getUsedAmount();
				}

				// 更新额度信息
				BigDecimal creditUsableAmount = subLeafCreditInfo.getCreditUsableAmount();
				BigDecimal usedAmount = subLeafCreditInfo.getUsedAmount();
				// 额度余额 = 前额度余额 + 交易金额
				subLeafCreditInfo.setCreditUsableAmount(creditUsableAmount.add(amt));
				// 实占用额度 = 前实占用额度 - 交易金额
				subLeafCreditInfo.setUsedAmount(usedAmount.subtract(amt));
				BIcrInfo bIcrInfo = new BIcrInfo();
				bIcrInfo.setCreditNo(creditNo);
				bIcrInfo.setCreditUsableAmount(creditUsableAmount.add(amt));
				bIcrInfo.setUsedAmount(usedAmount.subtract(amt));
				bIcrInfoService.updateBIcrInfo(bIcrInfo);
				
				// 记录流水
				try {
					BeanUtils.copyProperties(subLeafCreditInfo, creditInterParam);
//					bIcrDtlService.addCreditDetailForDuebill(creditInterParam, bLanAppliLnciBase.getCreditCustcd(), bLanAppliLnciBase.getCustcd(), subLeafCreditInfo.getCreditType(),
//							operType, amt, subLeafCreditInfo);
					bIcrDtlService.addCreditDetail(creditInterParam, bLanAppliLnciBase.getCreditCustcd(), bLanAppliLnciBase.getCustcd(), subLeafCreditInfo.getCreditType(),
							operType, amt, subLeafCreditInfo);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}

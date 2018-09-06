package com.huateng.scf.bas.lan.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.scf.bas.brp.dao.IBBrpPrdFactoringDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpPrdFactoring;
import com.huateng.scf.bas.cnt.dao.IBCntDebtInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.IBCrrPrdMdDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.crr.dao.model.BCrrPrdMd;
import com.huateng.scf.bas.crr.model.BCrrDueBillDetail;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanRepayFlowCreditSaveService;
import com.huateng.scf.bas.pbc.constant.BPbcErrorConstant;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author liph
 * @date 2016年12月24日下午1:39:20
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * liph		2016年12月24日下午1:39:20	      供应链补录保存业务逻辑处理
 *
 *            </pre>
 */
@ScubeService
@Service("BLanRepayFlowCreditSaveServiceImpl")
public class BLanRepayFlowCreditSaveServiceImpl implements IBLanRepayFlowCreditSaveService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO ibCrrLnConDAO;
	@Resource(name = "BBrpPrdFactoringDAO")
	IBBrpPrdFactoringDAO ibBrpPrdFactoringDAO;
	@Resource(name = "IBCrrPrdMdDAO")
	IBCrrPrdMdDAO bcrrprdmddao;
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO ibPbcAppliBaseInfoDAO;
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO ibLanAppliLnciBaseDAO;
	@Resource(name = "BCntDebtInfoDAO")
	IBCntDebtInfoDAO ibCntDebtInfoDAO;
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO ibLanLnciBaseDAO;
	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO irBcpAppliBussInfoDAO;
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO irBcpAppliBussDtlDAO;
	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO irBcpDebtBaseInfoDAO;

	@Override
	@Transactional
	public void flowCreditSave(BCrrDueBillDetail bCrrDueBillDetail, List<com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl> bussDtlList) {
		String appno = bCrrDueBillDetail.getId();
		if (!StringUtil.isEmpty(appno)) {
			String factType = "";
			String businessnoType = "";
			String workApplyType = "";
			String prdid = "";
			String loanWay = "";
			if (bCrrDueBillDetail != null) {
				BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(bCrrDueBillDetail.getAppId());// 获取信贷合同号
				BBrpPrdFactoring bBrpPrdFactoring = ibBrpPrdFactoringDAO.selectByPrimaryKey(bCrrLnCon.getVidBusiTyp());// 根据业务品种获取保里
				factType = bBrpPrdFactoring.getFactType();
				prdid = bCrrLnCon.getPrdId();
			}
			BCrrPrdMd bCrrPrdMd = bcrrprdmddao.selectByPrimaryKey(prdid);
			if (bCrrPrdMd != null) {
				loanWay = bCrrPrdMd.getLoanWay();
			}
			if (ScfBasConstant.FACT_TYPE_INLAND.equals(factType) || ScfBasConstant.FACT_TYPE_REVERSE.equals(factType)
					|| ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType)) {// 应收账款
				if (ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(loanWay)) {// 流贷
					businessnoType = WorkflowConstant.APPLI_TYPE_INCOICEFINANCINGAPPLY;
					workApplyType = WorkflowConstant.PROCNAME_INCOICE_FINANCING_APPLY;
				}
			} else if ((ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE + "','" + ScfBasConstant.FACT_TYPE_DEBT_POOL + "','"
					+ ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE).indexOf(factType) != -1) {// 应收账款池
				if (ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(loanWay)) {// 流贷
					businessnoType = WorkflowConstant.APPLI_TYPE_FINANCINGPOOLAPPLY;
					workApplyType = WorkflowConstant.PROCNAME_FINANCING_POOL_APPLY;
				}
			}
			// 更新业务主表
			BPbcAppliBaseInfo baseInfo = ibPbcAppliBaseInfoDAO.selectByPrimaryKey(appno);
			baseInfo.setProcessTemplateName(workApplyType);
			baseInfo.setAppliType(businessnoType);
			try {
				ibPbcAppliBaseInfoDAO.updateByPrimaryKey(baseInfo);
			} catch (Exception e) {
				log.info("业务主表更新异常");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10002),
						BPbcErrorConstant.SCF_BAS_PBC_10002);
			}
			// 放款金额校验
			this.checkFinanceApplyInfo(bCrrDueBillDetail, factType);
			// 更新R_BCP_APPLI_BUSS_INFO
			try {
				this.updateAppliBussInfo(bCrrDueBillDetail, ScfBasConstant.T_FINANCING_TYPE_INVOICE);
			} catch (Exception e) {
				log.info("更新R_BCP_APPLI_BUSS_INFO异常");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10020),
						RBcpErrorConstant.SCF_REC_BCP_10020);
			}
			// 保存到 R_BCP_APPLI_BUSS_DTL【业务申请业务明细表】
			try {
				this.saveAppliBussDtl(bussDtlList, bCrrDueBillDetail.getId());
			} catch (Exception e) {
				log.info("保存R_BCP_APPLI_BUSS_DTL异常");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10021),
						RBcpErrorConstant.SCF_REC_BCP_10021);
			}
			// 更新B_LAN_APPLI_LNCI_BASE
			try {
				this.updateAppliLnciBaseInfo(bCrrDueBillDetail);
			} catch (Exception e) {
				log.info("更新B_LAN_APPLI_LNCI_BASE异常");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10002),
						BLanErrorConstant.SCF_BAS_LAN_10002);
			}
		}

	}

	/**
	 * @author liph 保里放款金额校验
	 */
	@SuppressWarnings("rawtypes")
	@Transactional
	public void checkFinanceApplyInfo(BCrrDueBillDetail bCrrDueBillDetail, String factType) {
		String appno = bCrrDueBillDetail.getId();
		BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
		String mastContno = "";
		if (bLanAppliLnciBase != null) {
			mastContno = bLanAppliLnciBase.getMastContno();
		}
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(mastContno);
		if (bCrrLnCon == null) {
			log.info("信贷合同未获取到");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20018), BLanErrorConstant.SCF_BAS_LAN_20018);
		}
		BCntDebtInfo bCntDebtInfo = ibCntDebtInfoDAO.selectByPrimaryKey(bCrrLnCon.getVidNo());
		String cycle = bCrrLnCon.getControlType();// 是否循环
		String protocolNo = bCntDebtInfo.getDebtContno();// 关联业务协议/合同号
		List list = ibLanLnciBaseDAO.selectByCondition(protocolNo);// 记录状态，是否结清，协议号
		BigDecimal totalLnciamt = BigDecimal.ZERO; // 合同项下的借据总金额
		BigDecimal totalContRist = BigDecimal.ZERO; // 业务合同下的的借据敞口余额
		BigDecimal tempRistAmt = BigDecimal.ZERO;
		BigDecimal contAmount = bCrrLnCon.getLnAmt(); // 信贷合同金额
		//BigDecimal riskAmt = bCrrLnCon.getLnSum();// 信贷合同可用金额
		BigDecimal riskAmt = BigDecimal.ZERO;// 信贷合同可用敞口
		if (bLanAppliLnciBase.getBailAmount() == null) {
			bLanAppliLnciBase.setBailAmount(BigDecimal.ZERO);
		}
		tempRistAmt = bLanAppliLnciBase.getLnciAmt().subtract(bLanAppliLnciBase.getBailAmount()).subtract(bCrrDueBillDetail.getCsxjdjwbl());
		if (ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType) || ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
				|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType)) {
			if (!StringUtil.isEmpty(bCrrDueBillDetail.getIndrctCrdt()) && "1".equals(bCrrDueBillDetail.getIndrctCrdt())) {
				if (tempRistAmt.compareTo(bCrrDueBillDetail.getCreditBalAmt()) > 0) {
					log.info("保理买方间接额度可用余额不足！");
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20007),
							BLanErrorConstant.SCF_BAS_LAN_20007);
				}
			}
		}
		if (list != null && list.size() > 0) {
			BLanLnciBase bLanLnciBase = null;
			BigDecimal addBailAmount;
			BigDecimal bailAmount;
			BigDecimal initCashEqtAmt;
			BigDecimal addCashEqtAmt;
			BigDecimal lnciBal;
			for (int i = 0; i < list.size(); i++) {
				bLanLnciBase = (BLanLnciBase) list.get(i);
				// 借据敞口余额 = 借据余额 – 冻结保证金 – 现金等价物金额
				addBailAmount = (bLanLnciBase.getAddBailAmount() == null ? BigDecimal.ZERO : bLanLnciBase.getAddBailAmount());
				bailAmount = (bLanLnciBase.getBailAmount() == null ? BigDecimal.ZERO : bLanLnciBase.getBailAmount());
				initCashEqtAmt = (bLanLnciBase.getInitCashEqtAmt() == null ? BigDecimal.ZERO : bLanLnciBase.getInitCashEqtAmt());//初始现金等价物金额
				addCashEqtAmt = (bLanLnciBase.getAddCashEqtAmt() == null ? BigDecimal.ZERO : bLanLnciBase.getAddCashEqtAmt());//追加现金等价物金额
				lnciBal = bLanLnciBase.getLnciBal();
				totalContRist = totalContRist
						.add(lnciBal.subtract(addBailAmount).subtract(bailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt));
			}
		}
		// 增加流程中业务合同的出账金额
		List<Map> flowList = ibLanAppliLnciBaseDAO.getFlowRiskAmtByVidno(protocolNo);
		if (flowList.size() > 0 && flowList != null) {
			Map map = flowList.get(0);
			BigDecimal bb = BigDecimal.ZERO;
			if (map.get("AMT") != null) {
				bb = (BigDecimal) map.get("AMT");
			}
			BigDecimal fowBigAmt = flowList.get(0) == null ? BigDecimal.ZERO : bb;
			totalContRist = totalContRist.add(fowBigAmt);
		}
		// 获得所有的出账金额
		totalLnciamt = ibLanLnciBaseDAO.getTotalLoanAmtInContInfo(bCrrLnCon.getAppId());
		// 获取合同下的敞口余额
		BigDecimal contRistAmtTemp = this.getContRiskAmtByCycle(bCrrLnCon.getAppId(), cycle);
		riskAmt = bCrrLnCon.getLnAmt() == null ? BigDecimal.ZERO : bCrrLnCon.getLnAmt().subtract(contRistAmtTemp);
		// 1-校验合同的可用额度是否足够
		// 1.1 不可循环额度合同。
		// 规则：信贷合同项下所有借据金额 + 本次放款金额 <= 信贷合同金额
		if (ScfBasConstant.CONT_CREDIT_NOCYCLE.equals(cycle)) {
			List<Map> listTemp = ibLanAppliLnciBaseDAO.getFlowKindsOfSumByMastContno(bCrrLnCon.getAppId());
			if (listTemp.size() > 0) {
				Map map = listTemp.get(0);
				BigDecimal flowLnciRiskAmt = BigDecimal.ZERO;
				if (map.get("LNCIAMT") != null) {
					flowLnciRiskAmt = (BigDecimal) map.get("LNCIAMT");
				}
				totalLnciamt = totalLnciamt.add(flowLnciRiskAmt);
			}
			if (totalLnciamt.add(bLanAppliLnciBase.getLnciAmt() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getLnciAmt())
					.compareTo(contAmount) > 0) {
				log.info("(信贷合同项下所有放款的借据金额 + 本次放款金额)必须小于等于信贷合同金额!");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20008),
						BLanErrorConstant.SCF_BAS_LAN_20008);
			}
			// 非循环合同，还需要在添加一个校验规则。
			// 检查规则2是否满足
			if (contRistAmtTemp.add(tempRistAmt).compareTo(riskAmt) > 0) {
				log.info("信贷合同可用敞口不足！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20009),
						BLanErrorConstant.SCF_BAS_LAN_20009);
			}
		}
		// 1.2 可循环额度合同
		// 规则：借据敞口余额 = 借据余额 – 冻结保证金 – 现金等价物金额
		// 规则：信贷合同项下所有生效的借据敞口余额 + 本笔风险敞口〈=信贷合同总敞口
		// 规则：本笔风险敞口 = 出账金额 – 初始保证金 – 初始现金等价物金额
		if (ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle)) {
			if (contRistAmtTemp.add(tempRistAmt).compareTo(riskAmt) > 0) {
				log.info("(信贷合同项下所有生效的借据敞口余额 + 本次风险敞口)必须小于等于信贷合同总敞口");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20010),
						BLanErrorConstant.SCF_BAS_LAN_20010);
			}
		}
		if ((ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType) || ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
				|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType))) {// 池不校验买方额度
			// 本笔风险敞口 <= 池应收账款余额 * 融资比例 + 池保证金余额 - 敞口余额
			BigDecimal compareAmt = new BigDecimal(0);// 应收账款总额
			compareAmt = (bCrrDueBillDetail.getTotalBillsAmount().multiply(bCrrDueBillDetail.getRzbl()).divide(new BigDecimal(100)))
					.add(bCrrDueBillDetail.getPoolRiskAmt()).subtract(totalContRist);// 池敞口余额（核心）
			if (tempRistAmt.compareTo(compareAmt) > 0) {
				log.info("应收账款池可融资金额不足！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20033),
						BLanErrorConstant.SCF_BAS_LAN_20033);
			}
		} else {
			// 本笔风险敞口 <= 应收账款余额 * 融资比例
			if (tempRistAmt.compareTo(bCrrDueBillDetail.getYsTotalAmt()) > 0) {
				log.info("应收账款可融资金额不足！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20011),
						BLanErrorConstant.SCF_BAS_LAN_20011);
			}
		}
	}

	/**
	 * @author liph
	 */
	public BigDecimal getContRiskAmtByCycle(String mastContno, String cycle) {
		BigDecimal avalibalRiskAmt = BigDecimal.ZERO;
		if (StringUtil.isEmpty(cycle)) {
			cycle = ScfBasConstant.CONT_CREDIT_NOCYCLE;
		}
		List<Map> list = ibLanAppliLnciBaseDAO.getFlowRiskAmtByMastContno(mastContno);
		BigDecimal flowRiskAmt = BigDecimal.ZERO;
		Map map = new HashMap();
		if (list != null && list.size() > 0) {
			map = list.get(0);
			if (map.get("RISKAMT") != null) {
				flowRiskAmt = (BigDecimal) map.get("RISKAMT");
			}
		}
		// 非循环合同
		if (ScfBasConstant.CONT_CREDIT_NOCYCLE.equals(cycle)) {
			avalibalRiskAmt = getContRiskAmt(mastContno, cycle);
		}
		// 循环合同
		if (ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle)) {
			avalibalRiskAmt = getContRiskAmt(mastContno, cycle);
		}
		// 增加流程审批中的借据（仅仅包括已经提交给信贷，但是未审批通过）
		avalibalRiskAmt = avalibalRiskAmt.add(flowRiskAmt);
		return avalibalRiskAmt;
	}

	/**
	 * @author liph
	 */
	public BigDecimal getContRiskAmt(String mastContno, String cycle) {
		BigDecimal riskAmt = BigDecimal.ZERO;
		BigDecimal totRiskAmt = BigDecimal.ZERO;
		List list = new ArrayList();
		// 循环合同，已经结清的借据不需要要计算的。
		BLanLnciBase bLanLnciBase = new BLanLnciBase();
		bLanLnciBase.setMastContno(mastContno);
		bLanLnciBase.setState(ScfBasConstant.FLAG_ON);
		if (ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle)) {
			bLanLnciBase.setIsSettle(ScfBasConstant.FLAG_OFF);
		}
		List<BLanLnciBase> lncilist = ibLanLnciBaseDAO.queryByCondition(bLanLnciBase);
		if (lncilist!=null&&lncilist.size() > 0) {
			for (int i = 0; i < lncilist.size(); i++) {
				riskAmt = this.getLnciRiskAmt((BLanLnciBase) list.get(i), cycle);
				if (riskAmt == null) {
					riskAmt = BigDecimal.ZERO;
				}
				totRiskAmt = totRiskAmt.add(riskAmt);
			}
		}
		return totRiskAmt;
	}

	/**
	 * @author liph
	 */
	public BigDecimal getLnciRiskAmt(BLanLnciBase bLanLnciBase, String cycle) {

		BigDecimal bailAmount = null;
		BigDecimal initCashEqtAmt = null;
		BigDecimal addBailAmount = null;
		BigDecimal addCashEqtAmt = null;
		BigDecimal riskAmt = null;
		bailAmount = (bLanLnciBase.getBailAmount() == null ? new BigDecimal(0) : bLanLnciBase.getBailAmount());
		addBailAmount = (bLanLnciBase.getAddBailAmount() == null ? new BigDecimal(0) : bLanLnciBase.getAddBailAmount());
		initCashEqtAmt = (bLanLnciBase.getInitCashEqtAmt() == null ? new BigDecimal(0) : bLanLnciBase.getInitCashEqtAmt());
		addCashEqtAmt = (bLanLnciBase.getAddCashEqtAmt() == null ? new BigDecimal(0) : bLanLnciBase.getAddCashEqtAmt());
		if (ScfBasConstant.CONT_CREDIT_NOCYCLE.equals(cycle)) {
			riskAmt = bLanLnciBase.getLnciAmt().subtract(bailAmount).subtract(initCashEqtAmt);
		}
		if (ScfBasConstant.CONT_CREDIT_CYCLE.equals(cycle)) {
			riskAmt = bLanLnciBase.getLnciBal().subtract(bailAmount).subtract(addBailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt);
		}
		return riskAmt;
	}

	/**
	 * @author liph 更新R_BCP_APPLI_BUSS_INFO表
	 */
	public void updateAppliBussInfo(BCrrDueBillDetail bCrrDueBillDetail, String factFlag) {
		RBcpAppliBussInfo bussInfo = irBcpAppliBussInfoDAO.selectByAppno(bCrrDueBillDetail.getId());
		if (bussInfo != null) {
			if (ScfBasConstant.T_FINANCING_TYPE_INVOICE.equals(factFlag)) {
				setBPbcAppliBaseInfo(bCrrDueBillDetail, bussInfo);
			}
		} else {
			bussInfo = new RBcpAppliBussInfo();
			if (ScfBasConstant.T_FINANCING_TYPE_INVOICE.equals(factFlag)) {
				setBPbcAppliBaseInfo(bCrrDueBillDetail, bussInfo);
			}
			bussInfo.setAppno(bCrrDueBillDetail.getId());
			bussInfo.setTlrcd(ContextHolder.getUserInfo().getTlrNo());// 登记人
			bussInfo.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 登记机构
			if (StringUtil.isEmpty(bussInfo.getId())) {
				bussInfo.setId(UUIDGeneratorUtil.generate());
			}
			irBcpAppliBussInfoDAO.insert(bussInfo);
		}
		irBcpAppliBussInfoDAO.updateByPrimaryKey(bussInfo);
	}

	/**
	 * @author liph pbcapplibussinfo--set方法
	 */
	private RBcpAppliBussInfo setBPbcAppliBaseInfo(BCrrDueBillDetail bCrrDueBillDetail, RBcpAppliBussInfo bussInfo) {
		String mastContno = bCrrDueBillDetail.getAppId();
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(mastContno);
		BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(bCrrDueBillDetail.getId());
		bussInfo.setCustcdSaller(bCrrDueBillDetail.getCustCd());// 卖方客户号
		bussInfo.setCustcdBuyer(bCrrDueBillDetail.getCrdtCustCd());// 买方客户号--间接额度占用客户号
		bussInfo.setMastContno(mastContno);// 合同号
		bussInfo.setBussType(bCrrLnCon.getVidBusiTyp());// 业务品种
		bussInfo.setCurcd(bCrrDueBillDetail.getCurcd());// 合同币别
		bussInfo.setBillDate(bCrrLnCon.getLnStrtDt());// 合同生效日期
		bussInfo.setBillEndDate(bCrrLnCon.getLnEndDt());// 合同到期日期
		bussInfo.setAppDate(BSysConstant.WORKDATE); // 融资申请日期
		bussInfo.setRateType(bLanAppliLnciBase.getRateType());// 利率类型
		bussInfo.setBaseRate(bLanAppliLnciBase.getBaseYearRate() != null ? bLanAppliLnciBase.getBaseYearRate().toString() : "");// 年基准利率
		bussInfo.setUpDown(bLanAppliLnciBase.getRateFloatType());// 浮动类型
		bussInfo.setUpDownPercent(bLanAppliLnciBase.getRateFloatValue() != null ? bLanAppliLnciBase.getRateFloatValue().toString() : "");// 浮动值
		bussInfo.setExecuteRate(bLanAppliLnciBase.getRate() != null ? bLanAppliLnciBase.getRate().toString() : "");// 执行利率

		bussInfo.setLoanType(bLanAppliLnciBase.getLoanType());// 贷款种类
		bussInfo.setAccountNo(bLanAppliLnciBase.getAccountNo());// 入账账号
		bussInfo.setDebtNum(bLanAppliLnciBase.getBillNum() == null ? null : bLanAppliLnciBase.getBillNum().intValue());// 应收总份数
		bussInfo.setTotalDebtAmount(bCrrDueBillDetail.getYsTotalAmt() == null ? BigDecimal.ZERO : bCrrDueBillDetail.getYsTotalAmt());// 应收总额
		bussInfo.setAmount(bLanAppliLnciBase.getAvaliableAmt() == null ? BigDecimal.ZERO : bLanAppliLnciBase.getAvaliableAmt());// 可融资金额
		bussInfo.setAppLoanDate(bLanAppliLnciBase.getStartDate());// 融资发放日期
		bussInfo.setLoanDueDate(bLanAppliLnciBase.getEndDate());// 融资到期日期
		return bussInfo;
	}

	/**
	 * 保存buss detail--dtl
	 */
	public void saveAppliBussDtl(List insertList, String appno) {
		com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl apiBuss = null;
		RBcpAppliBussDtl rAppliBussDtl = new RBcpAppliBussDtl();
		if (insertList != null && insertList.size() > 0) {
			// 保存前先清掉之前数据
			List<RBcpAppliBussDtl> list = irBcpAppliBussDtlDAO.selectByAppno(appno);
			for (int i = 0; i < list.size(); i++) {
				rAppliBussDtl = list.get(i);
				if (!StringUtil.isEmpty(rAppliBussDtl.getDebtId())) {
					RBcpDebtBaseInfo rBaseInfo = irBcpDebtBaseInfoDAO.selectByPrimaryKey(rAppliBussDtl.getDebtId());
					if (rBaseInfo != null) {
						rBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
						rBaseInfo.setLockAppno(null);
						irBcpDebtBaseInfoDAO.updateByPrimaryKey(rBaseInfo);
					}
				}
				irBcpAppliBussDtlDAO.deleteByPrimaryKey(rAppliBussDtl.getId());
			}
			for (int j = 0; j < insertList.size(); j++) {
				apiBuss = (com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl) insertList.get(j);
				BeanUtils.copyProperties(apiBuss, rAppliBussDtl);
				rAppliBussDtl.setMoney(apiBuss.getLoanAmount());// 融资金额
				rAppliBussDtl.setAppno(appno);
				rAppliBussDtl.setDebetNo(apiBuss.getDebetNo());
				if(StringUtil.isEmpty(apiBuss.getDebtId()))
				{
					rAppliBussDtl.setDebtId(apiBuss.getId());// 这里应该直接取值ID
				}
				rAppliBussDtl.setId(UUIDGeneratorUtil.generate());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				String date = sdf.format(new Date());
				rAppliBussDtl.setInsertDate(date);
				rAppliBussDtl.setLastUpdTime(new Date());
				irBcpAppliBussDtlDAO.insert(rAppliBussDtl);

				if (!StringUtil.isEmpty(rAppliBussDtl.getDebtId())) {
					String detid = rAppliBussDtl.getDebtId();
					RBcpDebtBaseInfo rBaseInfo = irBcpDebtBaseInfoDAO.selectByPrimaryKey(detid);
					if (rBaseInfo != null) {
						rBaseInfo.setIsLocked(ScfBasConstant.LOCKED);
						rBaseInfo.setLockAppno(appno);
						irBcpDebtBaseInfoDAO.updateByPrimaryKey(rBaseInfo);
					}
				}
			}
		}
	}

	/**
	 * @author LIPH 更新借据申请表
	 */
	public void updateAppliLnciBaseInfo(BCrrDueBillDetail bCrrDueBillDetail) {
		BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(bCrrDueBillDetail.getId());
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(bCrrDueBillDetail.getAppId());
		if (bLanAppliLnciBase != null) {
			bLanAppliLnciBase.setCreditCustcd(bCrrDueBillDetail.getCustCd());
			bLanAppliLnciBase.setOtherCustcd(bCrrDueBillDetail.getCrdtCustCd());// 买方客户号
			bLanAppliLnciBase.setInitCashEqtAmt(bCrrDueBillDetail.getCsxjdjwbl());// 初始现金等价物比例
			bLanAppliLnciBase.setProtocolNo(bCrrLnCon.getVidNo());// 业务合同号
			ibLanAppliLnciBaseDAO.updateByPrimaryKey(bLanAppliLnciBase);
		} else {
			log.info("放款申请信息获取失败");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000), BLanErrorConstant.SCF_BAS_LAN_20000);
		}
	}

}
package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.brp.model.BBrpPrdFactoring;
import com.huateng.scf.bas.brp.service.IBBrpPrdFactoringService;
import com.huateng.scf.bas.cnt.service.IBCntCostInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.nte.constant.BNteConstant;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBaseExample;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.nrec.bcp.dao.IRBcpDebtInfoDAO;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliCostOutService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtPoolService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scf.nrec.bcp.service.ITransferApplyService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliCostOutDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpCostOutDAO;
import com.huateng.scf.rec.bcp.dao.model.CostOutModel;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfoExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOutExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpCostOut;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliCostOut;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2017年5月23日下午9:20:26
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2017年5月23日下午9:20:26	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("TransferApplyServiceImpl")
public class TransferApplyServiceImpl implements ITransferApplyService, DealEndFlowService, DealInFlowService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "bSysSerialNoService")
	private IBSysSerialNoService bSysSerialNoService;
	@Resource(name = "scfWorkFlowService")
	private IScfWorkFlowService scfWorkFlowService;
	// 申请基本信息
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService iBPbcAppliBaseInfoService;

	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bPbcAppliBaseInfoDAO;

	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bCntBcpInfoService;

	// 客户信息
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bcrmbaseinfoservice;

	// 应收类业务申请信息
	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO rBcpAppliBussInfoDAO;
	// 费用信息
	@Resource(name = "IRBcpAppliCostOutDAO")
	IRBcpAppliCostOutDAO rBcpAppliCostOutDAO;

	@Resource(name = "NRBcpAppliCostOutServiceImpl")
	INRBcpAppliCostOutService nRBcpAppliCostOutService;

	@Resource(name = "NRBcpAppliBussDtlServiceImpl")
	INRBcpAppliBussDtlService nRBcpAppliBussDtlService;
	// 费用流水号
	@Resource(name = "IRBcpCostOutDAO")
	IRBcpCostOutDAO iRBcpCostOutDAO;
	// 单据信息
	@Resource(name = "IRBcpDebtInfoDAO")
	IRBcpDebtInfoDAO rBcpDebtInfoDAO;
	// 通知书
	@Resource(name = "BNteNoticeBaseDAO")
	IBNteNoticeBaseDAO bNteNoticeBaseDAO;

	// 费用基本信息
	@Resource(name = "BCntCostInfoServiceImpl")
	IBCntCostInfoService iBCntCostInfoService;

	// 单据明细信息
	@Resource(name = "NRBcpDebtBussDtlServiceImpl")
	INRBcpDebtBussDtlService nRBcpDebtBussDtlService;

	@Resource(name = "NRBcpDebtPoolServiceImpl")
	INRBcpDebtPoolService nRBcpDebtPoolService;

	@Resource(name = "NRBcpAppliBussInfoServiceImpl")
	INRBcpAppliBussInfoService nRBcpAppliBussInfoService;

	@Resource(name = "RBcpDebtInfoServiceImpl")
	IRBcpDebtInfoService rBcpDebtInfoService;

	// 转让明细信息
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rBcpAppliBussDtlDAO;

	@Resource(name = "BBrpPrdFactoringServiceImpl")
	IBBrpPrdFactoringService bBrpPrdFactoringService;

	@Resource(name = "RBcpDebtPoolServiceImpl")
	IRBcpDebtPoolService rBcpDebtPoolService;

	// 单据唯一性校验
	@Override
	public void checkDebtRule(List<RBcpAppliBussDtl> rBcpAppliBussDtlList) {
		for (RBcpAppliBussDtl rBcpAppliBussDtl : rBcpAppliBussDtlList) {
			RBcpDebtInfoVO debtInfoVO = new com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO();
			debtInfoVO.setBillsNo(rBcpAppliBussDtl.getBillsNo());
			debtInfoVO.setCustcdSaller(rBcpAppliBussDtl.getCustcdSaller());
			debtInfoVO.setCustcdBuyer(rBcpAppliBussDtl.getCustcdBuyer());
			debtInfoVO.setMastContno(rBcpAppliBussDtl.getMastContno());
			RBcpDebtInfoVO debtInfoVO2 = rBcpDebtInfoService.findRBcpDebtInfoByKey(debtInfoVO);
			if (debtInfoVO2 != null) {// 去重！
				throw new ScubeBizException("凭证编号为" + debtInfoVO2.getBillsNo() + "的单据信息已存在，请重新填写凭证信息！");
			}
		}
	}

	@Override
	@Transactional
	public String saveOrUpdateTransferInfo(RBcpAppliBussInfo rBcpAppliBussInfo, List<RBcpAppliBussDtl> ds) {
		// 1.前台数据校验
		if (rBcpAppliBussInfo == null || ds == null || ds.size() == 0) {// SCF_REC_BCP_10005,前台所传数据无效
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 判断是否有申请号
		String appno;
		if (StringUtils.isEmpty(rBcpAppliBussInfo.getAppno())) {

			String businessnoType = "";// 申请类型
			String workApplyType = "";// 流程名称
			BBrpPrdFactoring factoring = bBrpPrdFactoringService.findBBrpPrdFactoringByKey(rBcpAppliBussInfo.getBussType());
			String factType = factoring.getFactType();// 保理类型
			if (ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(factType)) {
				businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_AANWINST_APPLY;
				workApplyType = WorkflowConstant.PROCNAME_FACTORING_CREDIT_AANWINST_APPLY;
			} else if (ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(factType)) {
				businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_AANWINST_APPLY;
				workApplyType = WorkflowConstant.PROCNAME_FACTORING_DOUBLE_AANWINST_APPLY;
			} else if (ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType)) {
				businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_LEASE_AANWINST_APPLY;
				workApplyType = WorkflowConstant.PROCNAME_FACTORING_LEASE_AANWINST_APPLY;
			} else if (ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)) {
				businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_POOL_AANWINST_APPLY;
				workApplyType = WorkflowConstant.PROCNAME_FACTORING_POOL_AANWINST_APPLY;
			} else {
				businessnoType = WorkflowConstant.APPLI_TYPE_FACTORINGAANWINSTAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_FACTORING_AANWINST_APPLY;
			}
			workApplyType = "N-" + workApplyType;
			appno = bSysSerialNoService.genSerialNo("YSZR_APP_NO");// 申请流水号
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String insertDate = simpleDateFormat.format(new Date());// 新增插入日期
			String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
			String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
			String processId = "";
			// 2.新增申请基本信息、
			com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo bPbcAppliBaseInfo = new com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo();
			bPbcAppliBaseInfo.setProcessTemplateName(workApplyType);// 流程名称
			bPbcAppliBaseInfo.setAppliType(businessnoType);// 申请类型
			bPbcAppliBaseInfo.setAppDate(insertDate);// 申请日期
			bPbcAppliBaseInfo.setAppno(appno);// 申请号
			bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);// 选择主合同号
			bPbcAppliBaseInfo.setBusinessno(rBcpAppliBussInfo.getMastContno());// 具体的主合同号
			bPbcAppliBaseInfo.setChannelFlag(ScfBasConstant.CHANNEL_FLAG_SCF);// 供应链
			bPbcAppliBaseInfo.setSupplyChainPdId(rBcpAppliBussInfo.getBussType());// 产品类型
			bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_OFF);// 默认为流程未结束
			bPbcAppliBaseInfo.setCustcd(rBcpAppliBussInfo.getCustcdSaller());// 卖方客户号
			bPbcAppliBaseInfo.setMoniCustcd(rBcpAppliBussInfo.getCustcdBuyer());// 买方客户号
			bPbcAppliBaseInfo.setCurcd(rBcpAppliBussInfo.getCurcd());// 币种
			bPbcAppliBaseInfo.setSupplyChainPdId(rBcpAppliBussInfo.getBussType());// 业务品种
			bPbcAppliBaseInfo.setMastContno(rBcpAppliBussInfo.getMastContno()); // 主合同号
			bPbcAppliBaseInfo.setAmt(rBcpAppliBussInfo.getTotalDebtAmount());// 转让总金额
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT);// 申请状态为未提交（未提交）
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING);// 申请状态明细（未提交）
			bPbcAppliBaseInfo.setPiid(processId);// 设置流程ID
			bPbcAppliBaseInfo.setStratDate(insertDate);// 开始日期
			bPbcAppliBaseInfo.setAppBrcode(brcode);// 申请机构
			try {
				iBPbcAppliBaseInfoService.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);
			} catch (Exception e) {// SCF_REC_BCP_10023 申请信息新增失败！
				log.error("" + e);
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10023),
						RBcpErrorConstant.SCF_REC_BCP_10023);
			}

			// 3.应收类业务申请信息
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfo2 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
			BeanUtils.copyProperties(rBcpAppliBussInfo, rBcpAppliBussInfo2);
			rBcpAppliBussInfo2.setAppno(appno);// 申请号
			rBcpAppliBussInfo2.setInsertDate(insertDate);// 登记时间
			rBcpAppliBussInfo2.setCrtTime(new Date());// 创建时间
			rBcpAppliBussInfo2.setLastUptTime(new Date());// 最后更新时间
			rBcpAppliBussInfo2.setId(UUIDGeneratorUtil.generate());// id
			rBcpAppliBussInfo2.setApplyType(RBcpDebtConstant.APPLY_TYPE_ENTRY);// 申请状态为录入00
			rBcpAppliBussInfo2.setTlrcd(tlrcd);// 创建人，操作员
			rBcpAppliBussInfo2.setBrcode(brcode);// 设置经办机构信息
			try {
				rBcpAppliBussInfoDAO.insertSelective(rBcpAppliBussInfo2);
			} catch (Exception e) {// SCF_REC_BCP_10024 ，新增应收账款业务流水信息失败！
				log.error("" + e);
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10024),
						RBcpErrorConstant.SCF_REC_BCP_10024);
			}
			// 4.费用信息
			com.huateng.scf.rec.bcp.model.RBcpAppliCostOut rBcpAppliCostOut2 = new com.huateng.scf.rec.bcp.model.RBcpAppliCostOut();
			// 减免金额,reduceAmt，费用利率 ，costRate，总费用，totalAmt，实收费用
			// ，receiveAmount，costAccount扣费账号
			rBcpAppliCostOut2.setAppno(appno);// 申请号
			rBcpAppliCostOut2.setApplyType(businessnoType);
			rBcpAppliCostOut2.setStatus(RBcpDebtConstant.CHARGE_STATUS_UNCHARGED);// 费用收取状态为未收
			rBcpAppliCostOut2.setBussType(rBcpAppliBussInfo2.getBussType());// 设置业务品种
			rBcpAppliCostOut2.setCurcd(rBcpAppliBussInfo.getCurcd());// 币种
			rBcpAppliCostOut2.setReduceAmt(rBcpAppliBussInfo.getReduceAmount());// 减免金额
			if (StringUtils.isNotEmpty(rBcpAppliBussInfo.getFeeRate())) {
				rBcpAppliCostOut2.setCostRate(new BigDecimal(rBcpAppliBussInfo.getFeeRate()));// 费用利率
			}
			rBcpAppliCostOut2.setTotalAmt(rBcpAppliBussInfo.getTotalFee());// 费用小计
			rBcpAppliCostOut2.setReceiveAmount(rBcpAppliBussInfo.getReceiveAmount());// 实收费用
			try {
				nRBcpAppliCostOutService.addRBcpAppliCostOut(rBcpAppliCostOut2);
			} catch (Exception e) {// SCF_REC_BCP_10036 ,应收账款业务费用信息新增失败！
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10036),
						RBcpErrorConstant.SCF_REC_BCP_10036);
			}
			// 5.应收类申请明细信息（在这里是不需要锁定的，但是需要校验对应的单据信息。现有的单据信息里面有没有与之相同的单据号）
			nRBcpAppliBussDtlService.addRBcpAppliBussDtlForTransfer(appno, ds);
		} else {
			appno = rBcpAppliBussInfo.getAppno();
			updateTransferInfo(rBcpAppliBussInfo, ds);
		}
		return appno;

	}

	@Override
	@Transactional
	public void updateTransferInfo(RBcpAppliBussInfo rBcpAppliBussInfo, List<RBcpAppliBussDtl> ds) {
		// 1.申请基本信息
		BPbcAppliBaseInfo bPbcAppliBaseInfo1 = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(rBcpAppliBussInfo.getAppno());
		if (bPbcAppliBaseInfo1 == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}
		bPbcAppliBaseInfo1.setAmt(rBcpAppliBussInfo.getTotalDebtAmount());// 转让总金额
		try {
			iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo1);
		} catch (Exception e) {// 修改应收账款申请转让信息，修改申请基本信息的转让总金额失败！
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}

		// 2.业务申请信息
		RBcpAppliBussInfoExample rBcpAppliBussInfoExample = new RBcpAppliBussInfoExample();
		RBcpAppliBussInfoExample.Criteria criteria = rBcpAppliBussInfoExample.createCriteria();
		criteria.andAppnoEqualTo(rBcpAppliBussInfo.getAppno());
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo> rBcpAppliBussInfoList = rBcpAppliBussInfoDAO
				.selectByExample(rBcpAppliBussInfoExample);
		if (rBcpAppliBussInfoList == null || rBcpAppliBussInfoList.size() != 1) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10007), RBcpErrorConstant.SCF_REC_BCP_10007);
		} else {
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfo2 = rBcpAppliBussInfoList.get(0);
			rBcpAppliBussInfo2.setDebtNum(rBcpAppliBussInfo.getDebtNum());
			rBcpAppliBussInfo2.setTotalDebtAmount(rBcpAppliBussInfo.getTotalDebtAmount());
			rBcpAppliBussInfo2.setAmount(rBcpAppliBussInfo.getAmount());
			rBcpAppliBussInfo2.setTotalFee(rBcpAppliBussInfo.getTotalFee());
			rBcpAppliBussInfo2.setReduceAmount(rBcpAppliBussInfo.getReduceAmount());
			rBcpAppliBussInfo2.setReceiveAmount(rBcpAppliBussInfo.getReceiveAmount());
			rBcpAppliBussInfo2.setLastUptTime(new Date());
			try {
				rBcpAppliBussInfoDAO.updateByPrimaryKeySelective(rBcpAppliBussInfo2);
			} catch (Exception e) {
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10007),
						RBcpErrorConstant.SCF_REC_BCP_10007);
			}
		}
		// 3.费用信息
		try {
			com.huateng.scf.rec.bcp.model.RBcpAppliCostOut rBcpAppliCostOut = new com.huateng.scf.rec.bcp.model.RBcpAppliCostOut();
			rBcpAppliCostOut.setAppno(rBcpAppliBussInfo.getAppno());
			RBcpAppliCostOut rBcpAppliCostOut2 = nRBcpAppliCostOutService.findRBcpAppliCostOutByKey(rBcpAppliCostOut);
			rBcpAppliCostOut2.setReduceAmt(rBcpAppliBussInfo.getReduceAmount());// 减免金额
			rBcpAppliCostOut2.setTotalAmt(rBcpAppliBussInfo.getTotalFee());// 费用小计
			rBcpAppliCostOut2.setReceiveAmount(rBcpAppliBussInfo.getReceiveAmount());// 实收费用
			nRBcpAppliCostOutService.updateRBcpAppliCostOut(rBcpAppliCostOut2);
		} catch (Exception e) {// "修改应收账款申请转让信息，修改申请费用信息失败！"
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10029), RBcpErrorConstant.SCF_REC_BCP_10029);
		}

		// 4.申请明细 信息(先删除原有的明细信息,再新增新的申请明细信息)
		checkDebtRule(ds);// 先校验单据是否已经有了
		nRBcpAppliBussDtlService.deleteRBcpAppliBussDtlAndReleaseDebt(rBcpAppliBussInfo.getAppno());
		nRBcpAppliBussDtlService.addRBcpAppliBussDtlForTransfer(rBcpAppliBussInfo.getAppno(), ds);
	}

	@Override
	@Transactional
	public void submitTransferInfo(RBcpAppliBussInfo rBcpAppliBussInfo, List<RBcpAppliBussDtl> ds) {
		if (rBcpAppliBussInfo == null || StringUtils.isEmpty(rBcpAppliBussInfo.getAppno()) || ds == null || ds.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 1.先保存基本信息
		updateTransferInfo(rBcpAppliBussInfo, ds);
		String appno = rBcpAppliBussInfo.getAppno();
		// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		// String insertDate = simpleDateFormat.format(new Date());// 新增插入日期

		// 2.判断是退回提交还是正常提交
		BPbcAppliBaseInfo bPbcAppliBaseInfo1 = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		if (bPbcAppliBaseInfo1 == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}
		// 3.如果未发起流程。此时需要发起流程，新增对应通知书，修改申请基本信息的申请状态
		if (StringUtils.isEmpty(bPbcAppliBaseInfo1.getPiid())) {
			// 3.2发起流程
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", bPbcAppliBaseInfo1.getProcessTemplateName());
			paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				scfWorkFlowService.NstartWorkFlow(rBcpAppliBussInfo.getAppno(), bPbcAppliBaseInfo1.getProcessTemplateName(), paramMap);
			} catch (FlowsharpException e) {
				log.debug(e.getMessage());
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10022),
						RBcpErrorConstant.SCF_REC_BCP_10022);
			}
			// 3.3修改对应的申请基本信息申请状态
			bPbcAppliBaseInfo1.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);// 申请状态为//已提交
			bPbcAppliBaseInfo1.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);// 申请状态明细
			try {
				iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo1);
			} catch (Exception e) {
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10040),
						RBcpErrorConstant.SCF_REC_BCP_10040);
			}
		}
		// 4. 如果是退回提交
		else {
			try {
				scfWorkFlowService.backSubmitCommon(bPbcAppliBaseInfo1);
			} catch (ScubeBizException e) {
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10034),
						RBcpErrorConstant.SCF_REC_BCP_10034);
			} catch (FlowsharpException e) {
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10034),
						RBcpErrorConstant.SCF_REC_BCP_10034);
			}
		}
	}

	@Override
	@Transactional
	public void doWorkForPass(String appNo) {
		// 判断是否存在特殊调用路劲，存在则执行特殊路径，不存在则继续执行下列方法
		String invokPhase = ScfBasConstant.INVOKE_PHASE_TRANSFER;// 转让nag申请阶段
		String callerpath = "TransferApplyServiceImpl";
		boolean flag = scfWorkFlowService.invokAnotherClasspath(appNo, invokPhase, callerpath);
		if (flag) {
			return;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String transferDate = simpleDateFormat.format(new Date());// 转让日期
		/**
		 * mengjiajia	start
		 */
		//业务申请信息
		BPbcAppliBaseInfo appliBaseInfo = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		//合同信息
		BCntBcpInfoVO bcpInfoVO = bCntBcpInfoService.queryBCntBcpInfoByMastContno(appliBaseInfo.getMastContno());
		
		String financingType = bcpInfoVO.getFinancingType();// 融资模式
		String factType = bcpInfoVO.getFactType();// 保理类型
		/**
		 * mengjiajia	end
		 */
		
		// 1.更新应收账款申请基本信息 RBcpAppliBussInfo
		RBcpAppliBussInfo rBcpAppliBussInfoVO = new RBcpAppliBussInfo();
		RBcpAppliBussInfoExample rBcpAppliBussInfoExample = new RBcpAppliBussInfoExample();
		RBcpAppliBussInfoExample.Criteria criteria = rBcpAppliBussInfoExample.createCriteria();
		criteria.andAppnoEqualTo(appNo);
		try {
			List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo> rBcpAppliBussInfoList = rBcpAppliBussInfoDAO
					.selectByExample(rBcpAppliBussInfoExample);
			if (rBcpAppliBussInfoList != null && rBcpAppliBussInfoList.size() == 1) {
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfoX = rBcpAppliBussInfoList.get(0);
				BeanUtils.copyProperties(rBcpAppliBussInfoX, rBcpAppliBussInfoVO);// 底下要用到这里的数据（业务合同号）
				// 融资模式
				rBcpAppliBussInfoVO.setFactType(factType);
				if (DebtConstants.FINANCING_TYPE_POOL.equals(financingType)) {//池融资
					rBcpAppliBussInfoX.setApplyType(RBcpDebtConstant.APPLY_TYPE_IN_POOL);// 申请状态为入池
				} else {//单笔融资
					rBcpAppliBussInfoX.setApplyType(RBcpDebtConstant.APPLY_TYPE_PURCHASE);// 申请状态为承购
				}
				rBcpAppliBussInfoX.setPurchaseDate(transferDate);// 转让日期
				if (rBcpAppliBussInfoX.getTotalDebtAmount() != null) {
					rBcpAppliBussInfoX.setAmount(rBcpAppliBussInfoList.get(0).getTotalDebtAmount());
				}
				rBcpAppliBussInfoDAO.updateByPrimaryKeySelective(rBcpAppliBussInfoX);

			} else {// SCF_REC_BCP_10030，查询具体应收账款失败，实际上是数据丢失了。
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10030),
						RBcpErrorConstant.SCF_REC_BCP_10030);
			}
		} catch (Exception e) {// SCF_REC_BCP_10035 修改应收账款业务流水信息失败！
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10035), RBcpErrorConstant.SCF_REC_BCP_10035);
		}
		// 2.新增费用流水信息，修改申请转让费用信息 RBcpAppliCostOut,BCntCostInfo
		RBcpAppliCostOutExample rBcpAppliCostOutExample = new RBcpAppliCostOutExample();
		rBcpAppliCostOutExample.createCriteria().andAppnoEqualTo(appNo);
		try {
			List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut> rBcpAppliCostOutList = rBcpAppliCostOutDAO
					.selectByExample(rBcpAppliCostOutExample);
			if (rBcpAppliCostOutList != null && rBcpAppliCostOutList.size() == 1) {
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut rBcpAppliCostOut = rBcpAppliCostOutList.get(0);

				if (DebtConstants.FINANCING_TYPE_POOL.equals(financingType)) {
					rBcpAppliCostOut.setApplyType(RBcpDebtConstant.APPLY_TYPE_IN_POOL);// 申请状态为入池
				} else {
					rBcpAppliCostOut.setApplyType(RBcpDebtConstant.APPLY_TYPE_PURCHASE);// 申请状态为承购
				}
				rBcpAppliCostOutDAO.updateByPrimaryKeySelective(rBcpAppliCostOut);
				RBcpCostOut rBcpCostOut = new RBcpCostOut();
				CostOutModel costOutModel = new CostOutModel();
				// 因为这里的通用日期不同类型，直接copy会报错，所以这里要转换下。
				BeanUtils.copyProperties(rBcpAppliCostOut, costOutModel);
				BeanUtils.copyProperties(costOutModel, rBcpCostOut);
				/*
				 * if (rBcpAppliCostOut.getCommonDate() != null) {// commonDate
				 * SimpleDateFormat simpleDateFormat2 = new
				 * SimpleDateFormat("yyyyMMddHHmmss");
				 * rBcpCostOut.setCommonDate(simpleDateFormat2.parse(
				 * rBcpAppliCostOut.getCommonDate())); }
				 */
				rBcpCostOut.setChargeClass(ScfBasConstant.CHARGE_TYPE_ONLINE);// 系统收取
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				String flowNo = sdf.format(new Date());
				rBcpCostOut.setTxFlowNo("F" + flowNo);// 交易流水号
				rBcpCostOut.setId(UUIDGeneratorUtil.generate());// ID
				rBcpCostOut.setBussContno(rBcpAppliBussInfoVO.getMastContno());// 业务合同号
				// 这里需要通过业务合同号去查询费用基本信息，得到对应的ID赋值给这里的费用基本信息ID字段
				// com.huateng.scf.bas.cnt.model.BCntCostInfo bCntCostInfo = new
				// com.huateng.scf.bas.cnt.model.BCntCostInfo();
				// bCntCostInfo.setRelaNo(rBcpAppliBussInfoVO.getMastContno());
				// com.huateng.scf.bas.cnt.model.BCntCostInfo bCntCostInfo2 =
				// iBCntCostInfoService.findBCntCostInfoByKey(bCntCostInfo);
				// rBcpCostOut.setCostInfoId(bCntCostInfo2.getId());// 费用基本信息ID
				rBcpCostOut.setCostInfoId(rBcpCostOut.getId());
				iRBcpCostOutDAO.insertSelective(rBcpCostOut);
			}
		} catch (Exception e) {// 回执确认,费用相关信息修改失败！ SCF_REC_BCP_10037
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10037), RBcpErrorConstant.SCF_REC_BCP_10037);
		}

		// 3.更新应收账款申请明细表信息。 RBcpAppliBussDtl,并且这里新增对应的单据信息和对应的单据明细信息
		RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
		rBcpAppliBussDtlExample.createCriteria().andAppnoEqualTo(appNo);
		// 下面会用到 RBcpAppliBussDtlList 应收账款申请明细信息
//		ArrayList<RBcpAppliBussDtl> RBcpAppliBussDtlList = new ArrayList<RBcpAppliBussDtl>();

		try {
			List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> rBcpAppliBussDtlList = rBcpAppliBussDtlDAO
					.selectByExample(rBcpAppliBussDtlExample);
			if (rBcpAppliBussDtlList != null && rBcpAppliBussDtlList.size() > 0) {
				for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl1 : rBcpAppliBussDtlList) {
					RBcpDebtInfoVO debtInfoVO = new RBcpDebtInfoVO();
					debtInfoVO.setBillsNo(rBcpAppliBussDtl1.getBillsNo());
					debtInfoVO.setCustcdSaller(rBcpAppliBussDtl1.getCustcdSaller());
					debtInfoVO.setCustcdBuyer(rBcpAppliBussDtl1.getCustcdBuyer());
					debtInfoVO.setMastContno(rBcpAppliBussDtl1.getMastContno());
					RBcpDebtInfoVO debtInfoVO2 = rBcpDebtInfoService.findRBcpDebtInfoByKey(debtInfoVO);
					if (debtInfoVO2 != null) {// 去重！
						throw new ScubeBizException("凭证编号为" + debtInfoVO2.getBillsNo() + "的单据信息已存在，请重新填写凭证信息！");
					}
					// 发票余额=发票票面金额
					rBcpAppliBussDtl1.setRemainingAmount(rBcpAppliBussDtl1.getBillsAmount());
					// 可融资余额 = 发票余额 * 融资比例
					BigDecimal remainingUseableAmount = null;
					if (rBcpAppliBussDtl1.getLoanPercent() == null || rBcpAppliBussDtl1.getLoanPercent().equals(new BigDecimal(0))) {
						remainingUseableAmount = rBcpAppliBussDtl1.getBillsAmount();
					} else {
						remainingUseableAmount = rBcpAppliBussDtl1.getBillsAmount()
								.multiply(rBcpAppliBussDtl1.getLoanPercent().divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP));
					}
					rBcpAppliBussDtl1.setRemainingUseableAmount(remainingUseableAmount);
					BigDecimal billsAmountView = rBcpAppliBussDtl1.getBillsAmountView() == null ? new BigDecimal("0")
							: rBcpAppliBussDtl1.getBillsAmountView();
					BigDecimal billsAmount = rBcpAppliBussDtl1.getBillsAmount() == null ? new BigDecimal("0") : rBcpAppliBussDtl1.getBillsAmount();
					BigDecimal assurePercent = rBcpAppliBussDtl1.getAssurePercent() == null ? new BigDecimal("0")
							: rBcpAppliBussDtl1.getAssurePercent();
					rBcpAppliBussDtl1.setBillsAmountView(billsAmountView);
					rBcpAppliBussDtl1.setBillsAmount(billsAmount);
					rBcpAppliBussDtl1.setMoney(billsAmount);
					rBcpAppliBussDtl1.setAssurePercent(assurePercent);
					rBcpAppliBussDtl1.setStatus(ScfBasConstant.BILLS_STATUS_PURCHASED);// 已转让/出质
					if (DebtConstants.FINANCING_TYPE_POOL.equals(financingType)) {
						rBcpAppliBussDtl1.setApplyType(RBcpDebtConstant.APPLY_TYPE_IN_POOL);// 申请状态为入池
					} else {
						rBcpAppliBussDtl1.setApplyType(RBcpDebtConstant.APPLY_TYPE_PURCHASE);// 申请状态为承购
					}

					rBcpAppliBussDtl1.setPurchaseDate(transferDate);// 转让日期
					RBcpAppliBussDtl rBcpAppliBussDtl = new RBcpAppliBussDtl();
					BeanUtils.copyProperties(rBcpAppliBussDtl1, rBcpAppliBussDtl);
//					RBcpAppliBussDtlList.add(rBcpAppliBussDtl);
					rBcpAppliBussDtlDAO.updateByPrimaryKeySelective(rBcpAppliBussDtl1);
					RBcpDebtInfoVO rBcpDebtInfoVO = new RBcpDebtInfoVO();
					// 新增单据信息
					// 这里已经知道的，缺少了最迟付款日，宽限期两个字段
					BeanUtils.copyProperties(rBcpAppliBussDtl1, rBcpDebtInfoVO);
					rBcpDebtInfoVO.setConfirmDate(transferDate);// 回执确认日期
					rBcpDebtInfoVO.setDeadline(rBcpAppliBussDtl1.getUnpledgeActiveDate());// 之前的最迟付款日是存在这个字段
					rBcpDebtInfoVO.setUnpledgeActiveDate("");
					rBcpDebtInfoVO.setGracePeriod(new BigDecimal(rBcpAppliBussDtl1.getBadReason()));// 之前宽限期是存在这个字段里的
					rBcpDebtInfoVO.setBadReason("");
					rBcpDebtInfoVO.setContStatus(ScfBasConstant.FLAG_VALID);
					if (DebtConstants.FINANCING_TYPE_POOL.equals(financingType)) {
						rBcpDebtInfoVO.setPoolFlag("1");// 入池
					} // 如果是单笔的，需要赋值字段loanRemainingAmount为有效金额
						// 这里已经改成无论单笔还是池的都需要对loanRemainingAmount设置，并设值为remainingUseableAmount
					rBcpDebtInfoVO.setLockAppno(appNo);
					String debtId = rBcpDebtInfoService.addRBcpDebtInfo(rBcpDebtInfoVO);

					// 如果是池融资再新增对应的入池明细信息
					if (DebtConstants.FINANCING_TYPE_POOL.equals(financingType)) {
						com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl bussDtl = new com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl();
						BeanUtils.copyProperties(rBcpAppliBussDtl1, bussDtl);
						bussDtl.setApplyType(RBcpDebtConstant.APPLY_TYPE_IN_POOL);// 申请状态为入池
						bussDtl.setPoolFlag("1");
						bussDtl.setDebtId(debtId);
						nRBcpDebtBussDtlService.addRBcpDebtBussDtl(bussDtl);
					}

				}
			} else {// 修改应收账款业务明细信息失败！ SCF_REC_BCP_10038
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10038),
						RBcpErrorConstant.SCF_REC_BCP_10038);
			}
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10038), RBcpErrorConstant.SCF_REC_BCP_10038);
		}

		// 5.更新通知书状态 BNteNoticeBase
		// 现在是这里才生成对应的通知书
		// 3.1生成对应通知书
		String num = "";
		String brcode = appliBaseInfo.getStartBrcode();// 经办机构
		String tlrcd = appliBaseInfo.getAppTlrcd();// 操作员
		// 合同有追/无追 (老代码 RepaymentApplyOperation
		// AcquisitionWriteSubmitUpdater)
		// 调用应收账款管理公共方法
		if (ScfBasConstant.FACT_TYPE_INLAND.equals(factType) // 国内保理
				|| ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)// 保理池融资
				|| ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(factType) // 行内双保理
				|| ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType)// 租赁保理
				|| ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(factType)// 信保保理
				|| ScfBasConstant.FACT_TYPE_REVERSE.equals(factType)// 反向保理
				|| ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType)// 应收账款质押
				|| ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType)// 应收账款质押池
				|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType))// 出口退税池
		{

			BNteNoticeBase bNteNoticeBase = new BNteNoticeBase();
			if (ScfBasConstant.FACT_TYPE_INLAND.equals(factType) || ScfBasConstant.FACT_TYPE_REVERSE.equals(factType)) {// 国内保理，反向保理，应收账款质押
				num = bSysSerialNoService.genSerialNo(BNteConstant.B_NTE_NOTICE_NUM_13);// 通知书编号
				bNteNoticeBase.setNoticeType(BNteConstant.NOTICE_TYPE_13);// 通知书类型
			} else if (ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType) || ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType)
					|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType)) {// 保理池融资，应收账款质押池，出口退税池
				num = bSysSerialNoService.genSerialNo(BNteConstant.B_NTE_NOTICE_NUM_101);// 通知书编号
				bNteNoticeBase.setNoticeType(BNteConstant.NOTICE_TYPE_101);// 通知书类型
			} else if (ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(factType)) {// 行内双保理
				num = bSysSerialNoService.genSerialNo(BNteConstant.B_NTE_NOTICE_NUM_13);// 通知书编号
				bNteNoticeBase.setNoticeType(BNteConstant.NOTICE_TYPE_103);// 通知书类型
			} else if (ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType)) {// 租赁保理
				num = bSysSerialNoService.genSerialNo(BNteConstant.B_NTE_NOTICE_NUM_13);// 通知书编号
				bNteNoticeBase.setNoticeType(BNteConstant.NOTICE_TYPE_107);// 通知书类型
			} else if (ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(factType)) {// 信保保理
				num = bSysSerialNoService.genSerialNo(BNteConstant.B_NTE_NOTICE_NUM_13);// 通知书编号
				bNteNoticeBase.setNoticeType(BNteConstant.NOTICE_TYPE_105);// 通知书类型
			} else if (ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType)) {// 应收账款质押
				num = bSysSerialNoService.genSerialNo(BNteConstant.B_NTE_NOTICE_NUM_13);// 通知书编号
				bNteNoticeBase.setNoticeType(BNteConstant.NOTICE_TYPE_114);// 通知书类型
			}
			bNteNoticeBase.setId(UUIDGeneratorUtil.generate());// id
			if (rBcpAppliBussInfoVO.getAmount() != null) {// 这个数据可能为空
				bNteNoticeBase.setCommonAmt(rBcpAppliBussInfoVO.getAmount());
			}
			bNteNoticeBase.setCommonNum(rBcpAppliBussInfoVO.getDebtNum().toString());// 单据总份数
			bNteNoticeBase.setBussType(rBcpAppliBussInfoVO.getBussType());// 业务品种（实质是产品ID）
			bNteNoticeBase.setCustName(rBcpAppliBussInfoVO.getCnameSeller());// 卖方客户名称
			bNteNoticeBase.setCustcd(rBcpAppliBussInfoVO.getCustcdSaller());// 卖方客户号
			bNteNoticeBase.setOtherCustName(rBcpAppliBussInfoVO.getCnameBuyer());// 买方客户名称
			bNteNoticeBase.setOtherCustcd(rBcpAppliBussInfoVO.getCustcdBuyer());// 买方客户号
			bNteNoticeBase.setMastContno(rBcpAppliBussInfoVO.getMastContno());// 主合同号
			bNteNoticeBase.setBrcode(brcode);// 经办机构
			bNteNoticeBase.setTlrn(tlrcd);// 客户经理
			bNteNoticeBase.setAppliDate(transferDate);// 申请日期
			bNteNoticeBase.setSignDate(transferDate);// 签发日期
			bNteNoticeBase.setCommonDate(transferDate);// 回执日期
			bNteNoticeBase.setStatus(BNteConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
			bNteNoticeBase.setNum(num);// 通知书编号
			bNteNoticeBase.setAppno(appNo);// 申请编号
			try {
				bNteNoticeBaseDAO.insertSelective(bNteNoticeBase);// 通知书新增
			} catch (Exception e) {// 新增通知书信息失败！ SCF_REC_BCP_10032
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10032),
						RBcpErrorConstant.SCF_REC_BCP_10032);
			}
		} else {// 无对应通知书类型！SCF_REC_BCP_10033
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10033), RBcpErrorConstant.SCF_REC_BCP_10033);
		}
		// 7.入池（应收账款池转让） rBcpAppliBussInfoVO,RBcpAppliBussDtlList
		if (DebtConstants.FINANCING_TYPE_POOL.equals(financingType)) {
			DebtBussInfoVO debtBussInfoVO = new DebtBussInfoVO();
			BeanUtils.copyProperties(rBcpAppliBussInfoVO, debtBussInfoVO);
			debtBussInfoVO.setFinancingType(financingType);// 池融资
			try {
				//此处重新统计池合同信息-mengjiajia
				RBcpDebtPool rBcpDebtPool = rBcpDebtPoolService.findRBcpDebtPoolByMastContno(appliBaseInfo.getMastContno());
				if (rBcpDebtPool == null) {
					throw new ScubeBizException("回款对应合同池信息丢失！");
				}
				nRBcpDebtPoolService.updatePoolRemainAmount(rBcpDebtPool,bcpInfoVO,ScfBasConstant.INVOKE_PHASE_REPAYMENT);

//				nRBcpAppliBussInfoService.inPool(RBcpAppliBussDtlList, debtBussInfoVO);// 入池
			} catch (Exception e) {// SCF_REC_BCP_10041
				log.error(e.getMessage());
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10041),
						RBcpErrorConstant.SCF_REC_BCP_10041);
			}
		}
		// 6.更新申请基本信息(流程结束) isFlowEnd字段 BPbcAppliBaseInfo
		try {
			iBPbcAppliBaseInfoService.editAppliBaseStatusByFlag(appNo, "pass");
		} catch (Exception e) {// SCF_REC_BCP_10040 //修改申请基本信息失败！
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10040), RBcpErrorConstant.SCF_REC_BCP_10040);
		}
	}

	// 复核拒绝
	@Override
	@Transactional
	public void doWorkForReject(String appNo) {
		iBPbcAppliBaseInfoService.editAppliBaseStatusByFlag(appNo, "reject");
	}

	// 退回
	@Override
	@Transactional
	public void doWorkForBack(String appNo) {
		iBPbcAppliBaseInfoService.editAppliBaseStatusByFlag(appNo, "back");
	}

	/*
	 * 代办任务中提交按钮
	 */
	@Override
	@Transactional
	public void doWorkForSubmit(String appNo) throws ScubeBizException {
		// 1.修改通知书的时间
		BNteNoticeBaseExample bNteNoticeBaseExample = new BNteNoticeBaseExample();
		BNteNoticeBaseExample.Criteria createCriteria = bNteNoticeBaseExample.createCriteria();
		createCriteria.andAppnoEqualTo(appNo);
		List<BNteNoticeBase> bNteNoticeBaseList = bNteNoticeBaseDAO.selectByExample(bNteNoticeBaseExample);
		if (bNteNoticeBaseList != null && bNteNoticeBaseList.size() == 1) {
			bNteNoticeBaseList.get(0).setSignDate(ScfBaseData.getScfGlobalInfoData().getTxnDate());
			bNteNoticeBaseDAO.updateByPrimaryKeySelective(bNteNoticeBaseList.get(0));
		}
		// 2.修改申请基本信息申请状态
		iBPbcAppliBaseInfoService.editAppliBaseStatusByFlag(appNo, "next");
	}

	// 转让申请首页提交按钮
	@Override
	@Transactional
	public void submitTransferApply(String appno) {
		// 1.数据校验
		if (StringUtils.isEmpty(appno)) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10031), RBcpErrorConstant.SCF_REC_BCP_10031);
		}
		RBcpAppliBussInfo rBcpAppliBussInfo = nRBcpAppliBussInfoService.findBcpAppliBussInfoByAppno(appno);
		if (rBcpAppliBussInfo == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10031), RBcpErrorConstant.SCF_REC_BCP_10031);
		}
		List<RBcpAppliBussDtl> rBcpAppliBussDtlList = nRBcpAppliBussDtlService.queryRBcpAppliBussDtlByAppno(appno);
		if (rBcpAppliBussDtlList == null || rBcpAppliBussDtlList.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10031), RBcpErrorConstant.SCF_REC_BCP_10031);
		}
		// 校验单据唯一性
		checkDebtRule(rBcpAppliBussDtlList);
		// 2.判断是退回提交还是正常提交
		BPbcAppliBaseInfo bPbcAppliBaseInfo1 = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(rBcpAppliBussInfo.getAppno());
		if (bPbcAppliBaseInfo1 == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}

		// 3.如果未发起流程。此饿时需要发起流程，新增对应通知书，修改申请基本信息的申请状态
		if (StringUtils.isEmpty(bPbcAppliBaseInfo1.getPiid())) {
			// 3.2发起流程
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", bPbcAppliBaseInfo1.getProcessTemplateName());
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				scfWorkFlowService.NstartWorkFlow(rBcpAppliBussInfo.getAppno(), bPbcAppliBaseInfo1.getProcessTemplateName(), paramMap);
			} catch (FlowsharpException e) {
				log.debug(e.getMessage());
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10022),
						RBcpErrorConstant.SCF_REC_BCP_10022);
			}
			// 3.3修改对应的申请基本信息申请状态
			bPbcAppliBaseInfo1.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);// 申请状态为//已提交
			bPbcAppliBaseInfo1.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);// 申请状态明细
			try {
				iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo1);
			} catch (Exception e) {
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10040),
						RBcpErrorConstant.SCF_REC_BCP_10040);
			}
		}
		// 4. 如果是退回提交
		else {
			try {
				scfWorkFlowService.backSubmitCommon(bPbcAppliBaseInfo1);
			} catch (ScubeBizException e) {
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10034),
						RBcpErrorConstant.SCF_REC_BCP_10034);
			} catch (FlowsharpException e) {
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10034),
						RBcpErrorConstant.SCF_REC_BCP_10034);
			}
		}

	}

	@Override
	public Object checkUploadDebtListRule(List<RBcpDebtInfoVO> list, String mastContno) {
		String errorMessage = "";
		// 1.首先校验在合同下有没有相同单据号的单据存在（这里将所有的重复的单据都一次性的写出，省得有多次的提示。）
		for (RBcpDebtInfoVO rBcpDebtInfoVO : list) {
			RBcpDebtInfoVO debtInfoVO = new com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO();
			debtInfoVO.setBillsNo(rBcpDebtInfoVO.getBillsNo());
			debtInfoVO.setMastContno(mastContno);
			RBcpDebtInfoVO debtInfoVO2 = rBcpDebtInfoService.findRBcpDebtInfoByKey(debtInfoVO);
			if (debtInfoVO2 != null) {// 单据已存在
				errorMessage = errorMessage + debtInfoVO2.getBillsNo() + ",";
			}
		}
		if (StringUtils.isNotEmpty(errorMessage)) {
			//去掉最后一个逗号
			String errorMessage2 = errorMessage.substring(0, errorMessage.length()-1);
			errorMessage = "凭证编号为" + errorMessage2 + "的单据信息已存在，请修改后重新上传文件！";
			return errorMessage;
		}
		// 2.查询合同信息
		BCntBcpInfoVO bCntBcpInfo = bCntBcpInfoService.queryBCntBcpInfoByMastContno(mastContno);
		if (bCntBcpInfo == null) {
			errorMessage = "合同号为" + mastContno + "的合同信息丢失！";
			return errorMessage;
		}
		String sysDate = ScfDateUtil.formatDate(new java.util.Date());// 当期日期
		int sysDateInt = Integer.parseInt(sysDate);// 当前日期
		String startDate = bCntBcpInfo.getStartDate();// 合同生效日
		String endDate = bCntBcpInfo.getEndDate();// 合同到期日
		int contStartDate = Integer.parseInt(startDate);// 合同生效日
		int contEndDate = Integer.parseInt(endDate);// 合同到期日
		boolean errorFlag=false;
		String errorMessageDetail="";
		// 3.循环加载数据，并且校验
		for (RBcpDebtInfoVO rBcpDebtInfoVO1 : list) {
			String billsNo = rBcpDebtInfoVO1.getBillsNo();
			// 3.1应收账款日期格式调整(从 日-月-年改写为正常格式)
			String billsDate = rBcpDebtInfoVO1.getBillsDate();
			int billsDateInt = Integer.parseInt(billsDate);
			// 3.2日期校验     
			// 应收账款日期须在合同到期日之前
			if (billsDateInt >= contEndDate) {
				errorMessage = "[应收账款日期]须在[合同到期日]之前，请将[应收账款日期]提前。";
				errorFlag=true;
			}
			// 应收账款 日期 须 在当前日期之前！
			if (billsDateInt > sysDateInt) {
				errorMessage = errorMessage+"[应收账款日期]不能在[当前日期]之后，请将[应收账款日期]提前。";
				errorFlag=true;
			}
			// 计算应收账款到期日
			String aging = rBcpDebtInfoVO1.getAging();
			int agingInt = Integer.parseInt(aging);// 账期
			String debtEnd = ScfDateUtil.getEndDateByAddDays(billsDate, agingInt);
			int debtEndInt = Integer.parseInt(debtEnd);// 到期日
			// 应收账款 到期日不能在 合同生效日 之前!
			if (debtEndInt < contStartDate) {
				errorMessage = errorMessage+"[应收账款到期日]不能在[合同生效日]之前，请将[应收账款日期]滞后或者增大[账期]。";
				errorFlag=true;
			}
			//应收账款到期日须小于合同到期日
			if(debtEndInt >= contEndDate){
				errorMessage = errorMessage+"[应收账款到期日]须在[合同到期日]之前，请将[应收账款日期]提前或者减小[账期]。";
				errorFlag=true;
			}
			rBcpDebtInfoVO1.setDebtEnd(debtEnd);// 到期日设置
			// 3.3最迟付款日计算
			BigDecimal gracePeriod = rBcpDebtInfoVO1.getGracePeriod();
			int gracePeriodInt = Integer.parseInt(gracePeriod.toString());
			String deadline = ScfDateUtil.getEndDateByAddDays(debtEnd, gracePeriodInt);
			int deadlineInt = Integer.parseInt(deadline);// 最迟付款日
			//最迟付款日须小于合同到期日
			if(deadlineInt >= contEndDate){
				errorMessage = errorMessage+"[最迟付款日]须在[合同到期日]之前，请将[应收账款日期]提前或者减小[账期]或者减少[宽限期]。";
				errorFlag=true;
			}
			rBcpDebtInfoVO1.setDeadline(deadline);
			// 3.4设置买方
			rBcpDebtInfoVO1.setCustcdBuyer(bCntBcpInfo.getBusinessCustcd());
			rBcpDebtInfoVO1.setCnameBuyer(bCntBcpInfo.getCnameBuyer());
			// 3.5设置卖方
			rBcpDebtInfoVO1.setCustcdSaller(bCntBcpInfo.getCustcd());
			rBcpDebtInfoVO1.setCnameSeller(bCntBcpInfo.getCname());
			// 3.6设置合同号
			rBcpDebtInfoVO1.setMastContno(mastContno);
			// 3.7业务品种
			rBcpDebtInfoVO1.setBussType(bCntBcpInfo.getSupplyChainPdId());
			// 3.8应收账款余额
			rBcpDebtInfoVO1.setRemainingAmount(rBcpDebtInfoVO1.getBillsAmount());
			// 3.9货币
			rBcpDebtInfoVO1.setCurcd("CNY");
			// 3.10，融资比例
			rBcpDebtInfoVO1.setLoanPercent(bCntBcpInfo.getLoanPercent());
			// 3.11factType
			rBcpDebtInfoVO1.setFactType(bCntBcpInfo.getFactType());
			if(errorFlag){
				errorMessage="凭证编号为" + billsNo +"单据信息,"+ errorMessage;
				errorMessageDetail=errorMessageDetail+errorMessage;
				errorMessage="";
				errorFlag=false;
			}
		}
		if(StringUtils.isNotEmpty(errorMessageDetail)){
			if(errorMessageDetail.length() > 300){
				errorMessageDetail=errorMessageDetail.substring(0,300)+"...";
			}
			return errorMessageDetail;
		}
		return list;
	}

	/**
	 * 任务基本信息
	 * 
	 * @param appno
	 * @return
	 * @author mengjiajia
	 * @date 2017年6月28日上午11:09:18
	 */
	@Override
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(String appno, String factType) {
		String process = "";
		if (ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(factType)) {
			process = WorkflowConstant.PROCNAME_FACTORING_CREDIT_AANWINST_APPLY;
		} else if (ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(factType)) {
			process = WorkflowConstant.PROCNAME_FACTORING_DOUBLE_AANWINST_APPLY;
		} else if (ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType)) {
			process = WorkflowConstant.PROCNAME_FACTORING_LEASE_AANWINST_APPLY;
		} else if (ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)) {
			process = WorkflowConstant.PROCNAME_FACTORING_POOL_AANWINST_APPLY;
		} else {
			process = WorkflowConstant.PROCNAME_FACTORING_AANWINST_APPLY;
		}
		process = "N-" + process;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}
}

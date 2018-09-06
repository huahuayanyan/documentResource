/**
 * 
 */
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
import com.huateng.scf.bas.brp.service.IBBrpPrdFactoringService;
import com.huateng.scf.bas.cnt.service.IBCntCostInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.nrec.bcp.dao.IRBcpDebtInfoDAO;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.IDebtInPoolService;
import com.huateng.scf.nrec.bcp.service.IDebtOutPoolService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliCostOutService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtPoolService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliCostOutDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpCostOutDAO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2017年6月20日下午4:01:05
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2017年6月20日下午4:01:05	      新增
 *
 *            </pre>
 */
@ScubeService
@Service(IDebtOutPoolService.BeanId)
public class DebtOutPoolServiceImpl implements IDebtOutPoolService, DealEndFlowService {
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

	@Resource(name = "IRBcpDebtInfoDAO")
	IRBcpDebtInfoDAO rbcpdebtinfodao;

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

	@Resource(name = IDebtInPoolService.BeanId)
	IDebtInPoolService debtInPoolService;

	@Override
	@Transactional
	public String saveOrUpdateOutPoolInfo(RBcpAppliBussInfo rBcpAppliBussInfo, List<RBcpAppliBussDtl> ds) {
		// 1.前台数据校验
		if (rBcpAppliBussInfo == null || ds == null || ds.size() == 0) {// SCF_REC_BCP_10005,前台所传数据无效
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 判断是否有申请号
		String appno;
		if (StringUtils.isEmpty(rBcpAppliBussInfo.getAppno())) {
			String businessnoType = WorkflowConstant.APPLI_TYPE_ACCOUNTS_RECEIVABLE_OUTPOOL_APPLY;// 3267
			String workApplyType = "N-AccountsReceivableOutPool";

			appno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSCC_T_APP_NO);// 申请流水号
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
			bPbcAppliBaseInfo.setAmt(rBcpAppliBussInfo.getAmount());// 入池总金额
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT);// 申请状态为未提交（未提交）
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING);// 申请状态明细（未提交）
			bPbcAppliBaseInfo.setPiid(processId);// 设置流程ID
			bPbcAppliBaseInfo.setStratDate(insertDate);// 开始日期
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
				rBcpAppliBussInfoDAO.insert(rBcpAppliBussInfo2);
			} catch (Exception e) {// SCF_REC_BCP_10024 ，新增应收账款业务流水信息失败！
				log.error("" + e);
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10024),
						RBcpErrorConstant.SCF_REC_BCP_10024);
			}
			// 5.应收类申请明细信息（在这里是不需要锁定的，但是需要校验对应的单据信息。现有的单据信息里面有没有与之相同的单据号）
			nRBcpAppliBussDtlService.addRBcpAppliBussDtlAndLockedDebt(appno, ds);
		} else {
			appno = rBcpAppliBussInfo.getAppno();
			debtInPoolService.updatePoolInfo(rBcpAppliBussInfo, ds);
		}
		return appno;
	}

	@Override
	@Transactional
	public void submitOutPoolInfo(RBcpAppliBussInfo rBcpAppliBussInfo, List<RBcpAppliBussDtl> ds) {
		if (rBcpAppliBussInfo == null || StringUtils.isEmpty(rBcpAppliBussInfo.getAppno()) || ds == null || ds.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 1.先保存基本信息
		debtInPoolService.updatePoolInfo(rBcpAppliBussInfo, ds);
		String appno = rBcpAppliBussInfo.getAppno();
		// 2.判断是退回提交还是正常提交
		BPbcAppliBaseInfo bPbcAppliBaseInfo1 = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		if (bPbcAppliBaseInfo1 == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}
		// 3.如果未发起流程。此时需要发起流程，新增对应通知书，修改申请基本信息的申请状态
		if (StringUtils.isEmpty(bPbcAppliBaseInfo1.getPiid())) {
			// 3.2发起流程
			String workApplyType = "N-AccountsReceivableOutPool";
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", workApplyType);
			paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				scfWorkFlowService.NstartWorkFlow(rBcpAppliBussInfo.getAppno(), workApplyType, paramMap);
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
	public void submitOutPoolInfoApply(String appno) {
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
		// 2.判断是退回提交还是正常提交
		BPbcAppliBaseInfo bPbcAppliBaseInfo1 = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		if (bPbcAppliBaseInfo1 == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}
		// 3.如果未发起流程。此时需要发起流程，新增对应通知书，修改申请基本信息的申请状态
		if (StringUtils.isEmpty(bPbcAppliBaseInfo1.getPiid())) {
			// 3.2发起流程
			String workApplyType = "N-AccountsReceivableOutPool";
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", workApplyType);
			paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				scfWorkFlowService.NstartWorkFlow(rBcpAppliBussInfo.getAppno(), workApplyType, paramMap);
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
	public void checkOutpoolDebtRulses(List<RBcpDebtInfoVO> ds) {
		for (RBcpDebtInfoVO rBcpDebtInfoVO : ds) {
			// 1.单据状态必须为已转让
			if (!rBcpDebtInfoVO.getStatus().equals(DebtConstants.INVOICE_STATUS_PURCHASED)) {
				throw new ScubeBizException("凭证编号为" + rBcpDebtInfoVO.getBillsNo() + "单据信息单据状态不为已转让，不可申请出池！");
			}
			// 2.单据不可为已商纠
			if (rBcpDebtInfoVO.getIssueFlag() != null && rBcpDebtInfoVO.getIssueFlag().equals("1")) {
				throw new ScubeBizException("凭证编号为" + rBcpDebtInfoVO.getBillsNo() + "单据有商业纠纷，不可申请出池！");
			}
			// 3.单据的融资余额只能为0
			BigDecimal loanRemainingAmount = rBcpDebtInfoVO.getLoanRemainingAmount() == null ? new BigDecimal("0")
					: rBcpDebtInfoVO.getLoanRemainingAmount();
			int compareTo = loanRemainingAmount.compareTo(BigDecimal.ZERO);
			if (compareTo == 0) {
				throw new ScubeBizException("凭证编号为" + rBcpDebtInfoVO.getBillsNo() + "单据已参与放款业务，不可申请入池！");
			}
			// 4.单据不可为已入池
			if (rBcpDebtInfoVO.getPoolFlag() != null && rBcpDebtInfoVO.getPoolFlag().equals("0")) {
				throw new ScubeBizException("凭证编号为" + rBcpDebtInfoVO.getBillsNo() + "单据已出池，不可再申请出池！");
			}
			// 5.需要为未被锁定
			if (rBcpDebtInfoVO.getIsLocked().equals("1")) {
				throw new ScubeBizException("凭证编号为" + rBcpDebtInfoVO.getBillsNo() + "单据已被锁定，不可申请出池！");
			}
		}
		return;
	}

	@Override
	@Transactional
	public void doWorkForPass(String appNo) {
		// 判断是否存在特殊调用路劲，存在则执行特殊路径，不存在则继续执行下列方法
		String invokPhase = ScfBasConstant.INVOKE_PHASE_OUT_POOL;// 转让nag申请阶段
		String callerpath = "DebtOutPoolServiceImpl";
		boolean flag = scfWorkFlowService.invokAnotherClasspath(appNo, invokPhase, callerpath);
		if (flag) {
			return;
		}

		// 2.这里我自己动手算了，不用别人的方法，计算入池信息(入池信息计算)
		List<RBcpDebtInfoVO> rBcpDebtInfoVOList = rBcpDebtInfoService.findRBcpDebtInfoListByAppno(appNo);
		if (rBcpDebtInfoVOList == null || rBcpDebtInfoVOList.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10031), RBcpErrorConstant.SCF_REC_BCP_10031);
		}
		// nRBcpDebtPoolService.NUpdateOutpoolInfo(rBcpDebtInfoVOList);
		BigDecimal OutPoolAmount=BigDecimal.ZERO;//入池金额
		// 3.解锁单据,新增对应单据明细信息（历程信息）
		try {
			for (RBcpDebtInfoVO rBcpDebtInfo : rBcpDebtInfoVOList) {
				rBcpDebtInfo.setIsLocked(RBcpDebtConstant.IS_LOCKED_FALSE);
				rBcpDebtInfo.setLockAppno("");
				rBcpDebtInfo.setPoolFlag("0");
				rBcpDebtInfoService.updateRBcpDebtInfo(rBcpDebtInfo);
				com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl rBcpDebtBussDtl = new com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl();
				BeanUtils.copyProperties(rBcpDebtInfo, rBcpDebtBussDtl);
				rBcpDebtBussDtl.setApplyType(RBcpDebtConstant.APPLY_TYPE_OUT_POOL);// 申请状态为入池
				rBcpDebtBussDtl.setDebtId(rBcpDebtInfo.getId());
				rBcpDebtBussDtl.setMoney(rBcpDebtInfo.getRemainingAmount());// 出池的金额是单据的应收账款余额
				rBcpDebtBussDtl.setAppno(appNo);
				nRBcpDebtBussDtlService.addRBcpDebtBussDtl(rBcpDebtBussDtl);
				OutPoolAmount=OutPoolAmount.add(rBcpDebtInfo.getRemainingAmount());
			}
		} catch (Exception e) {
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10026),
					RBcpErrorConstant.SCF_REC_BCP_10026);
		}
		// 4.池信息修改
		BPbcAppliBaseInfo appliBaseInfo = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		String mastContno = appliBaseInfo.getMastContno();
		if(StringUtils.isEmpty(mastContno)){
			log.debug("出池时，合同号丢失！");
			throw new ScubeBizException("应收账款出池操作失败！");
		}
		BCntBcpInfoVO baseInfo = bCntBcpInfoService.queryBCntBcpInfoByMastContno(mastContno);
		List<RBcpDebtPool> tblDebtPoolList = nRBcpDebtPoolService.queryDebtPollByMastContno(mastContno, null);
		RBcpDebtPool debtPool = new RBcpDebtPool(); 
		if (tblDebtPoolList != null && tblDebtPoolList.size() == 1) {
			debtPool = tblDebtPoolList.get(0);
		}else{
			log.debug("通过对应合同号查询合同池信息失败，未能找到唯一信息！");
			throw new ScubeBizException("应收账款出池操作失败！");
		}
		try {
			nRBcpDebtPoolService.updatePoolRemainAmount(debtPool,baseInfo,ScfBasConstant.INVOKE_PHASE_OUT_POOL);
		} catch (Exception e) {
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_00002),
				RBcpErrorConstant.SCF_REC_BCP_00002);
		}
		// 1.申请基本信息修改
		iBPbcAppliBaseInfoService.editAppliBaseStatusByFlag(appNo, "pass");
	}

	@Override
	@Transactional
	public void doWorkForReject(String appNo) {
		iBPbcAppliBaseInfoService.editAppliBaseStatusByFlag(appNo, "reject");

	}

	@Override
	@Transactional
	public void doWorkForBack(String appNo) {
		iBPbcAppliBaseInfoService.editAppliBaseStatusByFlag(appNo, "back");

	}

}

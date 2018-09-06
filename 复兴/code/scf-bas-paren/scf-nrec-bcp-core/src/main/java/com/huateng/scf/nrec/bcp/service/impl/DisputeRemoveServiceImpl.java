/**
 * 
 */
package com.huateng.scf.nrec.bcp.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.nrec.bcp.dao.IRBcpDebtInfoDAO;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfo;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfoExample;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.IDisputeRegisterService;
import com.huateng.scf.nrec.bcp.service.IDisputeRemoveService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtBussDtlService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBussDtlDAO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2017年6月5日下午3:39:17
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2017年6月5日下午3:39:17	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("DisputeRemoveServiceImpl")
public class DisputeRemoveServiceImpl implements IDisputeRemoveService, DealEndFlowService, DealInFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	// 流程申请基本信息
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService iBPbcAppliBaseInfoService;

	@Resource(name = "scfWorkFlowService")
	private IScfWorkFlowService scfWorkFlowService;

	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bCntBcpInfoService;

	// 应收类申请基本信息
	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO rBcpAppliBussInfoDAO;

	@Resource(name = "IRBcpDebtInfoDAO")
	IRBcpDebtInfoDAO rBcpDebtInfoDAO;

	@Resource(name = "NRBcpAppliBussDtlServiceImpl")
	INRBcpAppliBussDtlService nRBcpAppliBussDtlService;

	@Resource(name = "DisputeRegisterServiceImpl")
	IDisputeRegisterService disputeRegisterService;

	@Resource(name = "BBrpPrdFactoringServiceImpl")
	IBBrpPrdFactoringService bBrpPrdFactoringService;

	@Resource(name = "NRBcpAppliBussInfoServiceImpl")
	INRBcpAppliBussInfoService nRBcpAppliBussInfoService;

	@Resource(name = "IRBcpDebtBussDtlDAO")
	IRBcpDebtBussDtlDAO rbcpdebtbussdtldao;

	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bPbcAppliBaseInfoDAO;

	@Resource(name = "NRBcpDebtBussDtlServiceImpl")
	INRBcpDebtBussDtlService nrbcpdebtbussdtlservice;

	// 解除对应商纠标识
	@Override
	@Transactional
	public void doWorkForPass(String appNo) {
		// 判断是否存在特殊调用路劲，存在则执行特殊路径，不存在则继续执行下列方法
		String invokPhase = ScfBasConstant.INVOKE_PHASE_DISPUTE_REMOVE;// 商纠解除阶段
		String callerpath = "DisputeRemoveServiceImpl";
		boolean flag = scfWorkFlowService.invokAnotherClasspath(appNo, invokPhase, callerpath);
		if (flag) {
			return;
		}
		// 1. 解锁应收账款基本信息(新增对应明细信息)
		try {
			RBcpDebtInfoExample rBcpDebtInfoExample = new RBcpDebtInfoExample();
			RBcpDebtInfoExample.Criteria criteria = rBcpDebtInfoExample.createCriteria();
			criteria.andLockAppnoEqualTo(appNo);
			List<RBcpDebtInfo> rBcpDebtInfoList = rBcpDebtInfoDAO.selectByExample(rBcpDebtInfoExample);
			if (rBcpDebtInfoList != null && rBcpDebtInfoList.size() > 0) {
				for (RBcpDebtInfo rBcpDebtInfo1 : rBcpDebtInfoList) {
					//应收账款单据信息修改
					rBcpDebtInfo1.setIssueFlag(DebtConstants.ISSUE_FLAG_FALSE);// 无商纠
					rBcpDebtInfo1.setIssueReason(null);// 争议原因为空
					rBcpDebtInfo1.setOtherReason(null);// 当争议原因为其他的时候会设置其他争议原因。
					rBcpDebtInfo1.setIsLocked(ScfBasConstant.UNLOCKED);// 解锁
					rBcpDebtInfo1.setLockAppno(null);
					rBcpDebtInfoDAO.updateByPrimaryKey(rBcpDebtInfo1);
					//新增对应历程明细信息
					RBcpAppliBussDtl rBcpAppliBussDtl = nRBcpAppliBussDtlService.getAppliBussDtilByAppnoAndDebtId(appNo,rBcpDebtInfo1.getId());
					if(rBcpAppliBussDtl == null){
						throw new ScubeBizException("新增解锁应收账款明细信息失败！");
					}
					com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl rBcpDebtBussDtl = new com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl();
					BeanUtils.copyProperties(rBcpAppliBussDtl, rBcpDebtBussDtl);
					rBcpDebtBussDtl.setApplyType(DebtConstants.APPLY_TYPE_ISSUE_REMOVE);
					nrbcpdebtbussdtlservice.addRBcpDebtBussDtl(rBcpDebtBussDtl);
				}
			} else {
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10026),
						RBcpErrorConstant.SCF_REC_BCP_10026);
			}
		} catch (Exception e) {// SCF_REC_BCP_10026 解锁失败
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10026), RBcpErrorConstant.SCF_REC_BCP_10026);
		}
		// 2.申请基本信息修改状态
		iBPbcAppliBaseInfoService.editAppliBaseStatusByFlag(appNo, "pass");
	}

	// 拒绝
	@Override
	@Transactional
	public void doWorkForReject(String appNo) {
		iBPbcAppliBaseInfoService.editAppliBaseStatusByFlag(appNo, "reject");

	}

	// 退回
	@Override
	@Transactional
	public void doWorkForBack(String appNo) throws ScubeBizException {
		iBPbcAppliBaseInfoService.editAppliBaseStatusByFlag(appNo, "back");
	}

	// 解除申请页面保存按钮
	@Override
	@Transactional
	public String saveOrUpdateDisputeRemoveInfo(RBcpAppliBussInfo rBcpAppliBussInfo, ArrayList<RBcpAppliBussDtl> list) throws ScubeBizException {
		// 1.前台数据校验
		if (rBcpAppliBussInfo == null) {// SCF_REC_BCP_10005,前台所传数据无效
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		if (list == null || list.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		String appno = "";
		if (StringUtil.isEmpty(rBcpAppliBussInfo.getAppno())) {
			String businessnoType = "";
			String workApplyType = "";
			businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEINVOICREMOVEAPPLY;
			workApplyType = WorkflowConstant.PROCNAME_DISPUTE_INVOIC_REMOVE_APPLY;
			if (ScfBasConstant.FACT_TYPE_REVERSE.equals(rBcpAppliBussInfo.getFactType())
					|| ScfBasConstant.FACT_TYPE_INLAND.equals(rBcpAppliBussInfo.getFactType())
					|| ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(rBcpAppliBussInfo.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEINVOICREMOVEAPPLY;// 3218
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_INVOIC_REMOVE_APPLY;// DisputeInvoicRemoveApply

			} else if (ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(rBcpAppliBussInfo.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEDOUBLEINVOICREMOVEAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_DOUBLE_INVOIC_REMOVE_APPLY;// DisputeDoubleInvoicRemoveApply

			} else if (ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(rBcpAppliBussInfo.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTECREDITINVOICREMOVEAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_CREDIT_INVOIC_REMOVE_APPLY;// DisputeCreditInvoicRemoveApply

			} else if (ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(rBcpAppliBussInfo.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTELEASEINVOICREMOVEAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_LEASE_INVOIC_REMOVE_APPLY;// DisputeLeaseInvoicRemoveApply

			} else if (ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(rBcpAppliBussInfo.getFactType())
					|| ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(rBcpAppliBussInfo.getFactType())
					|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(rBcpAppliBussInfo.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEPOOLINVOICREMOVEAPPLY;// 3237
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_POOL_INVOIC_REMOVE_APPLY;// DisputePoolInvoicRemoveApply
			}
			workApplyType = "N-" + workApplyType;
			// 2.保存申请基本信息 B_PBC_APPLI_BASE_INFO
			rBcpAppliBussInfo.setMastContcode(rBcpAppliBussInfo.getMastContno());
			com.huateng.scf.rec.bcp.model.DebtBussInfoVO debtBussInfoVO = new com.huateng.scf.rec.bcp.model.DebtBussInfoVO();
			BeanUtils.copyProperties(rBcpAppliBussInfo, debtBussInfoVO);
			appno = iBPbcAppliBaseInfoService.saveDisputeRegisterAppliBaseInfo(debtBussInfoVO, businessnoType, workApplyType);
			// 3.申请业务信息RBcpAppliBussInfo
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String insertDate = simpleDateFormat.format(new Date());// 新增插入日期
			String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
			String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
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

			// 4.锁定对应单据信息，新增对应申请明细信息
			nRBcpAppliBussDtlService.addRBcpAppliBussDtlAndLockedDebt(appno, list);
		} else {// 这里保存的方法可以直接通用（因为保存的页面字段是一致的。而申请明细信息则直接copy了，所以也不影响。）
			disputeRegisterService.updateDisputeRegisterInfo(rBcpAppliBussInfo, list);
			appno = rBcpAppliBussInfo.getAppno();
		}

		return appno;
	}

	// 申请页面提交按钮
	@Override
	@Transactional
	public void submitDisputeRemoveInfo(RBcpAppliBussInfo rBcpAppliBussInfo, ArrayList<RBcpAppliBussDtl> ds) throws ScubeBizException {
		if (rBcpAppliBussInfo == null) {// SCF_REC_BCP_10005,前台所传数据无效
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		if (ds == null || ds.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 1.保存页面数据
		disputeRegisterService.updateDisputeRegisterInfo(rBcpAppliBussInfo, ds);
		// 2.申请基本信息修改状态为已提交
		BPbcAppliBaseInfo bPbcAppliBaseInfo1 = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(rBcpAppliBussInfo.getAppno());
		if (bPbcAppliBaseInfo1 == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}
		//
		if (StringUtils.isEmpty(bPbcAppliBaseInfo1.getPiid())) {
			bPbcAppliBaseInfo1.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);// 申请状态为//已提交
			bPbcAppliBaseInfo1.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);// 申请状态明细
			try {
				iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo1);
			} catch (Exception e) {// 修改应收账款申请转让信息，修改申请基本信息的转让总金额失败！
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028),
						RBcpErrorConstant.SCF_REC_BCP_10028);
			}

			// 3.发起流程
			String workApplyType = bPbcAppliBaseInfo1.getProcessTemplateName();
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", workApplyType);
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				scfWorkFlowService.NstartWorkFlow(rBcpAppliBussInfo.getAppno(), workApplyType, paramMap);
			} catch (FlowsharpException e) {
				log.debug(e.getMessage());
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10022),
						RBcpErrorConstant.SCF_REC_BCP_10022);
			}
		} else {
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

	// 商纠解除首页提交按钮
	@Override
	@Transactional
	public void submitDisputeRemoveInfoApply(String appno) throws ScubeBizException {
		if (StringUtils.isEmpty(appno)) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10031), RBcpErrorConstant.SCF_REC_BCP_10031);
		}
		RBcpAppliBussInfo rBcpAppliBussInfo = nRBcpAppliBussInfoService.findBcpAppliBussInfoByAppno(appno);
		if (rBcpAppliBussInfo == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10031), RBcpErrorConstant.SCF_REC_BCP_10031);
		}

		BPbcAppliBaseInfo bPbcAppliBaseInfo1 = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(rBcpAppliBussInfo.getAppno());
		if (bPbcAppliBaseInfo1 == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}
		// 区分状态
		if (StringUtils.isEmpty(bPbcAppliBaseInfo1.getPiid())) {
			bPbcAppliBaseInfo1.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);// 申请状态为//已提交
			bPbcAppliBaseInfo1.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);// 申请状态明细
			try {
				iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo1);
			} catch (Exception e) {// 修改应收账款申请转让信息，修改申请基本信息的转让总金额失败！
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028),
						RBcpErrorConstant.SCF_REC_BCP_10028);
			}

			// 3.发起流程
			String workApplyType = bPbcAppliBaseInfo1.getProcessTemplateName();
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", workApplyType);
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				scfWorkFlowService.NstartWorkFlow(rBcpAppliBussInfo.getAppno(), workApplyType, paramMap);
			} catch (FlowsharpException e) {
				log.debug(e.getMessage());
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10022),
						RBcpErrorConstant.SCF_REC_BCP_10022);
			}
		} else {
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
	public void doWorkForSubmit(String appNo) throws ScubeBizException {
		// TODO Auto-generated method stub

	}

	/**
	 * 任务基本信息
	 * 
	 * @param appno
	 * @param factType
	 * @return
	 * @author mengjiajia
	 * @date 2017年6月29日上午11:07:11
	 */
	@Override
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(String appno, String factType) {
		String process = "";
		if (ScfBasConstant.FACT_TYPE_REVERSE.equals(factType) || ScfBasConstant.FACT_TYPE_INLAND.equals(factType)
				|| ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType)) {
			process = WorkflowConstant.PROCNAME_DISPUTE_INVOIC_REMOVE_APPLY;

		} else if (ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(factType)) {
			process = WorkflowConstant.PROCNAME_DISPUTE_DOUBLE_INVOIC_REMOVE_APPLY;

		} else if (ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(factType)) {
			process = WorkflowConstant.PROCNAME_DISPUTE_CREDIT_INVOIC_REMOVE_APPLY;

		} else if (ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType)) {
			process = WorkflowConstant.PROCNAME_DISPUTE_LEASE_INVOIC_REMOVE_APPLY;

		} else if (ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType) || ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
				|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType)) {
			process = WorkflowConstant.PROCNAME_DISPUTE_POOL_INVOIC_REMOVE_APPLY;
		}
		process = "N-" + process;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}
}

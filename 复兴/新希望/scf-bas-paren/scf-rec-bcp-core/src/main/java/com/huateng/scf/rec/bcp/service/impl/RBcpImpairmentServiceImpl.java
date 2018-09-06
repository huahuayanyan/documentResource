package com.huateng.scf.rec.bcp.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.api.ITaskService;
import com.huateng.flowsharp.entity.ProcessEntity;
import com.huateng.scf.bas.cnt.constant.BCntBizConstant;
import com.huateng.scf.bas.cnt.dao.IBCntDebtExtInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntDebtInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfoExample;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.DebtLnciQryVO;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.nte.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfoExample;
import com.huateng.scf.rec.bcp.model.BLanLnciBaseExt;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.ImpairmentInfo;
import com.huateng.scf.rec.bcp.model.ProcessModel;
import com.huateng.scf.rec.bcp.model.RBCntDebtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBCntDebtExtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfoV;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scf.rec.bcp.model.TaskBaseInfo;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliRepaymentService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scf.rec.bcp.service.IRBcpImpairmentService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("RBcpImpairmentServiceImpl")
public class RBcpImpairmentServiceImpl implements IRBcpImpairmentService, DealEndFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

	@Resource(name = "BCntDebtInfoDAO")
	IBCntDebtInfoDAO iBCntDebtInfoDAO;

	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO iBCrmBaseInfoDAO;

	@Resource(name = "BPrdInfoDAO")
	private IBPrdInfoDAO bPrdInfoDAO;

	@Resource(name = "BCntDebtExtInfoDAO")
	IBCntDebtExtInfoDAO iBCntDebtExtInfoDAO;

	@Resource(name = "bSysSerialNoService")
	private IBSysSerialNoService bSysSerialNoService;

	@Resource(name = "processService")
	IProcessService iProcessService;
	// 任务服务
	@Autowired
	private ITaskService taskService;

	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;

	// 业务申请基本信息表
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService iBPbcAppliBaseInfoService;

	// 应收账款业务申请流水基本信息
	@Resource(name = "rBcpAppliBussInfoService")
	IRBcpAppliBussInfoService iRBcpAppliBussInfoService;

	// 应收账款基本信息
	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO iRBcpDebtBaseInfoDAO;

	// 应收账款融资业务申请流水明细表
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rBcpAppliBussDtlDAO;

	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO iBPbcAppliBaseInfoDAO;

	// 转让基本信息
	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO rBcpAppliBussInfoDAO;

	@Resource(name = "RBcpDebtBaseInfoServiceImpl")
	IRBcpDebtBaseInfoService rBcpDebtBaseInfoService;

	// 产品工厂转译业务品种名称
	@Resource(name = "bPrdInfoService")
	IBPrdInfoService iBPrdInfoService;
	// 供应链借据表
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO bLanLnciBaseDAO;

	@Resource(name = "RBcpAppliRepaymentServiceImpl")
	IRBcpAppliRepaymentService rbcpapplirepaymentservice;

	@Resource(name = "BMrnAppliAcctInfoServiceImpl")
	IBMrnAppliAcctInfoService mrnacctinfoservice;

	@Resource(name = "bNteNoticeBaseService")
	private IBNteNoticeBaseService bNteNoticeBaseService;

	@Resource(name = "RBcpDebtPoolServiceImpl")
	IRBcpDebtPoolService rbcpdebtpoolservice;

	// 供应链借据基本信息
	@Resource(name = "BLanLnciBaseServiceImpl")
	IBLanLnciBaseService blanlncibaseservice;

	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;

	// 应收账款明细信息
	@Resource(name = "RBcpDebtBussDtlServiceImpl")
	IRBcpDebtBussDtlService rBcpDebtBussDtlService;
	// 单据信息
	@Resource(name = "RBcpDebtBussInfoServiceImpl")
	IRBcpDebtBussInfoService rBcpDebtBussInfoService;

	public TaskBaseInfo queryTaskBaseInfo(String debtContno) throws Exception {
		UserInfo user = ContextHolder.getUserInfo();
		TaskBaseInfo taskBaseInfo = new TaskBaseInfo();

		com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo bCntDebtInfo = iBCntDebtInfoDAO.selectByPrimaryKey(debtContno);
		if (BCntBizConstant.FACT_TYPE_INLAND.equals(bCntDebtInfo.getFactType())
				|| BCntBizConstant.FACT_TYPE_REVERSE.equals(bCntDebtInfo.getFactType())
				|| BCntBizConstant.FACT_TYPE_DEBT_PLEDGE.equals(bCntDebtInfo.getFactType())) {// 应收账款
			taskBaseInfo.setFlowName(RBcpDebtConstant.R_BCP_IMPAIRMENT_NAME);
		} else if (BCntBizConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(bCntDebtInfo.getFactType())
				|| BCntBizConstant.FACT_TYPE_DEBT_POOL.equals(bCntDebtInfo.getFactType())
				|| BCntBizConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(bCntDebtInfo.getFactType())) {// 应收账款池
			taskBaseInfo.setFlowName(RBcpDebtConstant.R_BCP_IMPAIRMENT_POOL_NAME);
		} else {

		}
		taskBaseInfo.setRequestTime(simpleDateFormat.format(new Date()));
		taskBaseInfo.setOpStaff(user.getTlrName());
		taskBaseInfo.setOpOrg(ContextHolder.getOrgInfo().getBrName());
		return taskBaseInfo;
	}

	public RBCntDebtBaseInfo queryBaseInfo(String debtContno) throws Exception {
		RBCntDebtBaseInfo rbbaeinfo = new RBCntDebtBaseInfo();
		com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo bCntDebtInfo = iBCntDebtInfoDAO.selectByPrimaryKey(debtContno);
		BCrmBaseInfo bCrmBaseInfo = iBCrmBaseInfoDAO.selectById(bCntDebtInfo.getCustcd());
		rbbaeinfo.setDebtContno(bCntDebtInfo.getDebtContno());
		rbbaeinfo.setCurcd(bCntDebtInfo.getCurcd());
		rbbaeinfo.setStartDate(bCntDebtInfo.getStartDate());
		rbbaeinfo.setEndDate(bCntDebtInfo.getEndDate());
		if (StringUtils.isNotEmpty(bCntDebtInfo.getSupplyChainPdId())) {
			BPrdInfo dBPrdInfo = bPrdInfoDAO.selectByPrimaryKey(bCntDebtInfo.getSupplyChainPdId());
			rbbaeinfo.setSupplyChainPdId(dBPrdInfo.getProductName());
		}
		rbbaeinfo.setCustName(bCrmBaseInfo.getCname());
		return rbbaeinfo;
	}

	public List selectBuyerName(String debtContno) throws Exception {

		BCntDebtExtInfoExample example = new BCntDebtExtInfoExample();
		if (StringUtils.isNotEmpty(debtContno)) {
			example.createCriteria().andBusinessNoEqualTo(debtContno);
		}
		return iBCntDebtExtInfoDAO.selectByExample(example);
	}

	@Override
	@Transactional
	public String saveImpairmentRequestInfo(TaskBaseInfo taskBaseInfo, RBCntDebtBaseInfo baseInfo, ImpairmentInfo impairmentInfo,
			List<RBcpDebtBaseInfoV> bBcpDebtBaseInfoList) throws Exception {
		com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo bCntDebtInfo = iBCntDebtInfoDAO.selectByPrimaryKey(baseInfo.getDebtContno());

		String processName = taskBaseInfo.getFlowName();
		String appno = bSysSerialNoService.genSerialNo(RBcpDebtConstant.R_BCP_BUSS_APP_NO);// 申请流水号
		UserInfo user = ContextHolder.getUserInfo();

		String modelId = "";
		if (BCntBizConstant.FACT_TYPE_INLAND.equals(bCntDebtInfo.getFactType())
				|| BCntBizConstant.FACT_TYPE_REVERSE.equals(bCntDebtInfo.getFactType())
				|| BCntBizConstant.FACT_TYPE_DEBT_PLEDGE.equals(bCntDebtInfo.getFactType())) {// 应收账款
			modelId = RBcpDebtConstant.R_BCP_IMPAIRMENT;
		} else if (BCntBizConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(bCntDebtInfo.getFactType())
				|| BCntBizConstant.FACT_TYPE_DEBT_POOL.equals(bCntDebtInfo.getFactType())
				|| BCntBizConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(bCntDebtInfo.getFactType())) {// 应收账款池
			modelId = RBcpDebtConstant.R_BCP_IMPAIRMENT_POOL;
		} else {

		}
		String nodeId = RBcpDebtConstant.R_BCP_IMPAIRMENT_REQUEST;
		String startedUserId = user.getTlrNo();
		String custCd = bCntDebtInfo.getCustcd();
		String custName = baseInfo.getCustName();
		String processId = "";
		String bizId = appno;
		try {// 2.发起流程

			ProcessEntity processEntity = iProcessService.startProcess(modelId, processName, nodeId, startedUserId, bizId,
					new String[] { bizId, custCd, custName, modelId });
			processId = processEntity.getProcessId();
		} catch (Exception e) {
			log.error("" + e);
			throw new ScubeBizException("应收账款减值申请,发起流程失败！");
		}

		// 保存申请信息
		BPbcAppliBaseInfo bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
		bPbcAppliBaseInfo.setProcessTemplateName(processName);
		bPbcAppliBaseInfo.setAppliType(taskBaseInfo.getBusinessnoType());
		bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);// 选择主合同号
		bPbcAppliBaseInfo.setBusinessno(baseInfo.getDebtContno());// 具体的主合同号
		bPbcAppliBaseInfo.setCustcd(bCntDebtInfo.getCustcd());// 卖方客户号
		bPbcAppliBaseInfo.setMoniCustcd(baseInfo.getBuyerName());//// 买方客户号
		bPbcAppliBaseInfo.setCurcd(baseInfo.getCurcd());// 币种

		bPbcAppliBaseInfo.setSupplyChainPdId(bCntDebtInfo.getSupplyChainPdId());// 业务品种
		bPbcAppliBaseInfo.setMastContno(baseInfo.getDebtContno()); // 主合同号
		bPbcAppliBaseInfo.setAmt(impairmentInfo.getImpairmentAmount());// 转让总金额
		bPbcAppliBaseInfo.setStratDate(simpleDateFormat.format(new Date()));// 开始日期
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT);// 申请状态为未提交
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING);// 申请状态明细未提交
		bPbcAppliBaseInfo.setAppno(appno);
		bPbcAppliBaseInfo.setPiid(processId);// 设置流程ID
		iBPbcAppliBaseInfoService.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);

		// 应收账款业务申请流水基本信息
		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		debtVO.setAppno(appno);
		debtVO.setDebtContno(baseInfo.getDebtContno());
		debtVO.setTotalNum(impairmentInfo.getImpairmentCount());
		// debtVO.setTotalAmount(new
		// BigDecimal(WriteoffInfo.getWriteoffAmount()));
		debtVO.setStartDate(baseInfo.getStartDate());
		debtVO.setEndDate(baseInfo.getEndDate());
		debtVO.setAppDate(taskBaseInfo.getRequestTime());
		debtVO.setCnameBuyer(baseInfo.getBuyerName());
		debtVO.setCnameSeller(baseInfo.getCustName());
		// debtVO.setCustcd(bCntDebtInfo.getCustcd());
		debtVO.setCurcd(baseInfo.getCurcd());

		debtVO.setAppDate(taskBaseInfo.getRequestTime());
		debtVO.setCustcdBuyer(baseInfo.getBuyerName());
		debtVO.setCustcdSaller(bCntDebtInfo.getCustcd());
		debtVO.setDisputeCount(impairmentInfo.getImpairmentCount());
		debtVO.setTotalAmount(impairmentInfo.getImpairmentAmount());
		debtVO.setRebateAmount(impairmentInfo.getImpairmentAmount());
		debtVO.setBussType(bCntDebtInfo.getFactType());
		debtVO.setReason(impairmentInfo.getImpairmentReason());
		debtVO.setOtherReason(impairmentInfo.getRemark());
		debtVO.setMastContno(baseInfo.getDebtContno());
		debtVO.setTlrcd(taskBaseInfo.getOpStaff());
		debtVO.setBrcode(ContextHolder.getOrgInfo().getBrNo());
		// debtVO.setFactType(bCntDebtInfo.getFactType());
		debtVO.setInsertDate(simpleDateFormat.format(new Date()));
		iRBcpAppliBussInfoService.saveOrUpdateDebtAppliBussInfo(debtVO);
		// 应收账款融资业务申请流水明细表

		if (bBcpDebtBaseInfoList != null && bBcpDebtBaseInfoList.size() > 0) {
			for (int i = 0; i < bBcpDebtBaseInfoList.size(); i++) {
				com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBDao = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
				RBcpDebtBaseInfo rBcpDebtBaseInfo = bBcpDebtBaseInfoList.get(i);
				BigDecimal rebateAmounts = bBcpDebtBaseInfoList.get(i).getRebateAmounts();
				rBcpDebtBaseInfo.setIsLocked(RBcpDebtConstant.IS_LOCKED_TRUE);// 设置对应的票据为锁定状态。
				rBcpDebtBaseInfo.setLockAppno(appno);// 设置对应的锁定的申请号
				if (rBcpDebtBaseInfo.getRebateAmount() == null) {
					rBcpDebtBaseInfo.setRebateAmount(new BigDecimal("0"));
				}
				if (rBcpDebtBaseInfo.getRemainingAmount() == null) {
					rBcpDebtBaseInfo.setRemainingAmount(new BigDecimal("0"));
				}
				// rBcpDebtBaseInfo.setRebateAmount(rBcpDebtBaseInfo.getRebateAmount().add(rebateAmounts));
				// rBcpDebtBaseInfo.setRemainingAmount(rBcpDebtBaseInfo.getRemainingAmount().subtract(rebateAmounts));
				BeanUtils.copyProperties(rBcpDebtBaseInfo, rBDao);
				iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBDao);
				//
				RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
				if (StringUtils.isNotEmpty(appno)) {
					rBcpAppliBussDtlExample.createCriteria().andAppnoEqualTo(appno);
				}
				RBcpAppliBussDtl rBcpAppliBussDtl = new RBcpAppliBussDtl();
				rBcpAppliBussDtl.setAppno(appno);
				rBcpAppliBussDtl.setDebtId(rBcpDebtBaseInfo.getId());// 对应的应收账款基本信息的ID
				rBcpAppliBussDtl.setId(UUIDGeneratorUtil.generate());// id
				rBcpAppliBussDtl.setInsertDate(simpleDateFormat.format(new Date()));// 登记时间
				rBcpAppliBussDtl.setBillsDate(rBcpDebtBaseInfo.getBillsDate());// 应收账款日期（从应收账款基本信息表中查出来的）
				rBcpAppliBussDtl.setDebtEnd(rBcpDebtBaseInfo.getDebtEnd());// 应收账款到期日
				rBcpAppliBussDtl.setApplyType(RBcpDebtConstant.APPLY_TYPE_ENTRY);// 申请状态为录入00
				rBcpAppliBussDtl.setCustcdSaller(bCntDebtInfo.getCustcd());
				rBcpAppliBussDtl.setCnameSeller(baseInfo.getCustName());
				rBcpAppliBussDtl.setCustcdBuyer(baseInfo.getBuyerName());
				rBcpAppliBussDtl.setCnameBuyer(baseInfo.getBuyerName());
				rBcpAppliBussDtl.setMastContno(baseInfo.getDebtContno());
				rBcpAppliBussDtl.setBillsAmount(rBcpDebtBaseInfo.getBillsAmount());
				rBcpAppliBussDtl.setBillsAmountView(rBcpDebtBaseInfo.getBillsAmountView());
				rBcpAppliBussDtl.setRemainingAmount(rBcpDebtBaseInfo.getRemainingAmount());
				rBcpAppliBussDtl.setRebateAmount(rebateAmounts);
				rBcpAppliBussDtl.setCurcd(rBcpDebtBaseInfo.getCurcd());
				rBcpAppliBussDtl.setBillsNo(rBcpDebtBaseInfo.getBillsNo());
				rBcpAppliBussDtl.setBillsType(rBcpDebtBaseInfo.getBillsType());
				rBcpAppliBussDtl.setBussContcode(rBcpDebtBaseInfo.getBussContcode());
				rBcpAppliBussDtl.setBussType(rBcpDebtBaseInfo.getBussType());
				rBcpAppliBussDtl.setCommonDate(rBcpDebtBaseInfo.getDeadline());// 最迟付款日
				rBcpAppliBussDtl.setStatus(rBcpDebtBaseInfo.getStatus());
				rBcpAppliBussDtl.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 设置经办机构信息
				rBcpAppliBussDtl.setTlrcd(user.getTlrNo());
				rBcpAppliBussDtl.setLastUpdTlrcd(user.getTlrNo());
				rBcpAppliBussDtl.setCrtTime(new Date());
				rBcpAppliBussDtl.setLastUpdTime(new Date());
				rBcpAppliBussDtlDAO.insert(rBcpAppliBussDtl);
			}
			//// todo
		}
		return appno;
	}

	@Transactional
	public void submitImpairmentRequestInfo(TaskBaseInfo taskBaseInfo, RBCntDebtBaseInfo baseInfo, ImpairmentInfo impairmentInfo,
			List<RBcpDebtBaseInfoV> bBcpDebtBaseInfoList) throws Exception {
		//
		String processId = "";
		String appno = saveImpairmentRequestInfo(taskBaseInfo, baseInfo, impairmentInfo, bBcpDebtBaseInfoList);
		BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);

		// UserInfo user = ContextHolder.getUserInfo();
		// String taskId = WorkflowConstant.WORKFLOW_WRITEOFF_REQUESTTASK;
		// taskService.takeTask(taskId, processId, user.getTlrNo());
		// String comment = "申请提交";
		// taskService.completeTask(taskId, processId, user.getTlrNo(),
		// comment);
		// 节点转移
		// iProcessService.signal(processId,
		// WorkflowConstant.WORKFLOW_WRITEOFF_RECEIPT);

		// bPbcAppliBaseInfo.setApprover(user.getTlrNo()); // 当前已审批人员
		// bPbcAppliBaseInfo.setApproveBrcode(user.getBrNo()); // 当前已审批机构
		// bPbcAppliBaseInfo.setApproveDate(ScfDateUtil.getStringDate(new
		// Date())); // 当前已审批日期
		// bPbcAppliBaseInfo.setApproveTime(new Date()); // 当前已审批时间
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
		// com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo appliBaseInfo = new
		// com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo();
		// iBPbcAppliBaseInfoDAO.updateByPrimaryKey(daoBPbcAppliBaseInfo);
		iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
	}

	public String getBPbcAppliBaseInfoStateByAppno(String appno) throws Exception {
		String flag = "N";
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo daoBPbcAppliBaseInfo = iBPbcAppliBaseInfoDAO.selectByPrimaryKey(appno);
		if (daoBPbcAppliBaseInfo != null) {
			if (daoBPbcAppliBaseInfo.getAppliStatus().equals(WorkflowConstant.APPLI_STATUS_UNSUBMIT)
					&& daoBPbcAppliBaseInfo.getAppliStatusDtl().equals(WorkflowConstant.APPLI_STATUS_DTL_WRITING)) {
				flag = "Y";
			}
		}

		return flag;
	}

	public RBCntDebtBaseInfo queryBaseInfoTask(String key) throws Exception {
		RBCntDebtBaseInfo rbbaeinfo = new RBCntDebtBaseInfo();
		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo base = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(key);

		if (base != null && StringUtils.isNotEmpty(base.getMastContno())) {

			com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo bCntDebtInfo = iBCntDebtInfoDAO.selectByPrimaryKey(base.getMastContno());
			if (BCntBizConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(bCntDebtInfo.getFactType())
					|| BCntBizConstant.FACT_TYPE_DEBT_POOL.equals(bCntDebtInfo.getFactType())
					|| BCntBizConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(bCntDebtInfo.getFactType())) {// 应收账款池
				rbbaeinfo.setAppno(key);
				rbbaeinfo.setIsPool("2");
			}
			BCrmBaseInfo bCrmBaseInfo = iBCrmBaseInfoDAO.selectById(bCntDebtInfo.getCustcd());
			rbbaeinfo.setDebtContno(bCntDebtInfo.getDebtContno());
			rbbaeinfo.setCurcd(bCntDebtInfo.getCurcd());
			rbbaeinfo.setStartDate(bCntDebtInfo.getStartDate());
			rbbaeinfo.setEndDate(bCntDebtInfo.getEndDate());
			rbbaeinfo.setSupplyChainPdId(bCntDebtInfo.getSupplyChainPdId());
			rbbaeinfo.setCustName(bCrmBaseInfo.getCname());
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfo = rBcpAppliBussInfoDAO.selectByAppno(key);
			rbbaeinfo.setBuyerCd(rBcpAppliBussInfo.getCustcdBuyer());

			if (StringUtils.isNotEmpty(rBcpAppliBussInfo.getCustcdBuyer())) {
				try {
					com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBase = iBCrmBaseInfoDAO.selectById(rBcpAppliBussInfo.getCustcdBuyer());
					rbbaeinfo.setBuyerName(bCrmBase.getCname());
				} catch (Exception e) {
					log.error("" + e);
					// throw new ScubeBizException("买方名称转换失败！");
				}
			}

		}
		return rbbaeinfo;
	}

	public List selectBuyerNameTask(String key) throws Exception {
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo daoBPbcAppliBaseInfo = iBPbcAppliBaseInfoDAO.selectByPrimaryKey(key);
		return selectBuyerName(daoBPbcAppliBaseInfo.getMastContno());
	}

	public ImpairmentInfo getImpairmentInfoByAppno(String key) throws Exception {
		RBcpAppliBussInfo binfo = iRBcpAppliBussInfoService.findByAppno(key);
		ImpairmentInfo impinfo = new ImpairmentInfo();
		impinfo.setImpairmentAmount(binfo.getRebateAmount());
		impinfo.setImpairmentCount(binfo.getDebtNum());
		impinfo.setImpairmentDate(binfo.getAppDate());
		impinfo.setImpairmentReason(binfo.getReason());
		impinfo.setRemark(binfo.getOtherReason());

		return impinfo;

	}

	public Page findRBcpDebtBaseInfoPageByPage(int pageNo, int pageSize, String key) throws Exception {
		Page p = new Page(pageSize, pageNo, 0);

		try {
			List<RBcpAppliBussDtl> rBcpAppliBussDtlList = rBcpAppliBussDtlDAO.selectByAppno(key);
			List<RBcpDebtBaseInfoV> rBcpDebtBaseInfoListV = new ArrayList();

			for (RBcpAppliBussDtl val : rBcpAppliBussDtlList) {
				// 查询对应的业务产品名称 bussTypeName iBPrdInfoService
				RBcpDebtBaseInfoV bv = new RBcpDebtBaseInfoV();
				BeanUtils.copyProperties(val, bv);
				com.huateng.scf.bas.prd.model.BPrdInfo bPrdInfo = new com.huateng.scf.bas.prd.model.BPrdInfo();
				bPrdInfo.setProductId(val.getBussType());
				com.huateng.scf.bas.prd.model.BPrdInfo bPrdInfo2 = iBPrdInfoService.findBPrdInfoByKey(bPrdInfo);
				bv.setBussTypeName(bPrdInfo2.getProductName());
				bv.setRebateAmounts(val.getRebateAmount());
				bv.setRebatebalance(val.getRemainingAmount().subtract(val.getRebateAmount()));

				com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo tblDebtBaseInfo = rBcpDebtBaseInfoService.get(val.getDebtId());
				bv.setDeadline(tblDebtBaseInfo.getDeadline());

				rBcpDebtBaseInfoListV.add(bv);

			}
			p.setRecords(rBcpDebtBaseInfoListV);
			return p;
		} catch (Exception e) {// 10009- 条件分页查询条件分页查询应收账款信息失败
			e.printStackTrace();
			log.error("查询失败！");
			// throw new
			// ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil
			// .transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10009),
			// RBcpErrorConstant.SCF_REC_BCP_10009);
		}
		return null;
	}

	@Transactional
	public void saveImpairmentRequestInfoTask(String key, TaskBaseInfo taskBaseInfo, RBCntDebtBaseInfo baseInfo, ImpairmentInfo impairmentInfo,
			List<RBcpDebtBaseInfoV> bBcpDebtBaseInfoList) throws Exception {
		UserInfo user = ContextHolder.getUserInfo();
		com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo daoBPbcAppliBaseInfo = iBPbcAppliBaseInfoDAO.selectByPrimaryKey(key);
		if (daoBPbcAppliBaseInfo != null) {
			if (daoBPbcAppliBaseInfo.getAppliStatus().equals(WorkflowConstant.APPLI_STATUS_UNSUBMIT)) {
				BPbcAppliBaseInfo bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
				bPbcAppliBaseInfo.setAmt(impairmentInfo.getImpairmentAmount());// 转让总金额
				bPbcAppliBaseInfo.setCustcd(baseInfo.getCustName());// 卖方客户号
				bPbcAppliBaseInfo.setMoniCustcd(baseInfo.getBuyerCd());//// 买方客户号
				BeanUtils.copyProperties(daoBPbcAppliBaseInfo, bPbcAppliBaseInfo);
				iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);

			} else {
				throw new ScubeBizException("应收账款核销申请保存失败！");
			}

			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo dRBcpAppliBussInfo = rBcpAppliBussInfoDAO.selectByAppno(key);
			dRBcpAppliBussInfo.setRebateAmount(impairmentInfo.getImpairmentAmount());
			dRBcpAppliBussInfo.setReason(impairmentInfo.getImpairmentReason());
			dRBcpAppliBussInfo.setOtherReason(impairmentInfo.getRemark());
			rBcpAppliBussInfoDAO.updateByPrimaryKey(dRBcpAppliBussInfo);

			if (bBcpDebtBaseInfoList != null && bBcpDebtBaseInfoList.size() > 0) {

				List<RBcpAppliBussDtl> rBcpAppliBussDtlList = rBcpAppliBussDtlDAO.selectByAppno(key);
				// delete
				for (RBcpAppliBussDtl dtl : rBcpAppliBussDtlList) {
					rBcpAppliBussDtlDAO.deleteByPrimaryKey(dtl.getId());
				}
				for (int i = 0; i < bBcpDebtBaseInfoList.size(); i++) {
					// com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBDao
					// = new
					// com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
					RBcpDebtBaseInfo rBcpDebtBaseInfo = bBcpDebtBaseInfoList.get(i);
					BigDecimal rebateAmounts = bBcpDebtBaseInfoList.get(i).getRebateAmounts();
					// rBcpDebtBaseInfo.setRebateAmount(rBcpDebtBaseInfo.getRebateAmount().add(rebateAmounts));
					// rBcpDebtBaseInfo.setRemainingAmount(rBcpDebtBaseInfo.getRemainingAmount().subtract(rebateAmounts));
					// BeanUtils.copyProperties(rBcpDebtBaseInfo, rBDao);
					// iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBDao);
					//

					RBcpAppliBussDtl rBcpAppliBussDtl = new RBcpAppliBussDtl();
					rBcpAppliBussDtl.setAppno(key);
					rBcpAppliBussDtl.setDebtId(rBcpDebtBaseInfo.getId());// 对应的应收账款基本信息的ID
					rBcpAppliBussDtl.setId(UUIDGeneratorUtil.generate());// id
					rBcpAppliBussDtl.setInsertDate(simpleDateFormat.format(new Date()));// 登记时间
					rBcpAppliBussDtl.setBillsDate(rBcpDebtBaseInfo.getBillsDate());// 应收账款日期（从应收账款基本信息表中查出来的）
					rBcpAppliBussDtl.setDebtEnd(rBcpDebtBaseInfo.getDebtEnd());// 应收账款到期日
					rBcpAppliBussDtl.setApplyType(RBcpDebtConstant.APPLY_TYPE_ENTRY);// 申请状态为录入00
					rBcpAppliBussDtl.setCustcdSaller(baseInfo.getCustCd());
					rBcpAppliBussDtl.setCnameSeller(baseInfo.getCustName());
					rBcpAppliBussDtl.setCustcdBuyer(baseInfo.getBuyerName());
					rBcpAppliBussDtl.setCnameBuyer(baseInfo.getBuyerName());
					rBcpAppliBussDtl.setMastContno(baseInfo.getDebtContno());
					rBcpAppliBussDtl.setBillsAmount(rBcpDebtBaseInfo.getBillsAmount());
					rBcpAppliBussDtl.setBillsAmountView(rBcpDebtBaseInfo.getBillsAmountView());
					rBcpAppliBussDtl.setRemainingAmount(rBcpDebtBaseInfo.getRemainingAmount());
					rBcpAppliBussDtl.setRebateAmount(rebateAmounts);
					rBcpAppliBussDtl.setCurcd(rBcpDebtBaseInfo.getCurcd());

					rBcpAppliBussDtl.setBillsNo(rBcpDebtBaseInfo.getBillsNo());
					rBcpAppliBussDtl.setBillsType(rBcpDebtBaseInfo.getBillsType());
					rBcpAppliBussDtl.setBussContcode(rBcpDebtBaseInfo.getBussContcode());
					rBcpAppliBussDtl.setBussType(rBcpDebtBaseInfo.getBussType());
					rBcpAppliBussDtl.setCommonDate(rBcpDebtBaseInfo.getDeadline());// 最迟付款日
					rBcpAppliBussDtl.setStatus(rBcpDebtBaseInfo.getStatus());

					rBcpAppliBussDtl.setBrcode(taskBaseInfo.getOpOrg());// 设置经办机构信息
					rBcpAppliBussDtl.setTlrcd(user.getTlrNo());
					rBcpAppliBussDtl.setLastUpdTlrcd(user.getTlrNo());
					rBcpAppliBussDtl.setCrtTime(new Date());
					rBcpAppliBussDtl.setLastUpdTime(new Date());
					rBcpAppliBussDtlDAO.insert(rBcpAppliBussDtl);
				}

			}

		} else {
			throw new ScubeBizException("应收账款核销申请保存失败！");
		}

	}

	@Transactional
	public void submitImpairmentRequestInfoTask(String key, TaskBaseInfo taskBaseInfo, RBCntDebtBaseInfo baseInfo, ImpairmentInfo impairmentInfo,
			List<RBcpDebtBaseInfoV> bBcpDebtBaseInfoList) throws Exception {
		saveImpairmentRequestInfoTask(key, taskBaseInfo, baseInfo, impairmentInfo, bBcpDebtBaseInfoList);
		BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(key);
		// UserInfo user = ContextHolder.getUserInfo();
		// String taskId = WorkflowConstant.WORKFLOW_WRITEOFF_REQUESTTASK;
		// taskService.takeTask(taskId, processId, user.getTlrNo());
		// String comment = "申请提交";
		// taskService.completeTask(taskId, processId, user.getTlrNo(),
		// comment);
		// 节点转移
		// iProcessService.signal(processId,
		// WorkflowConstant.WORKFLOW_WRITEOFF_RECEIPT);

		// bPbcAppliBaseInfo.setApprover(user.getTlrNo()); // 当前已审批人员
		// bPbcAppliBaseInfo.setApproveBrcode(user.getBrNo()); // 当前已审批机构
		// bPbcAppliBaseInfo.setApproveDate(ScfDateUtil.getStringDate(new
		// Date())); // 当前已审批日期
		// bPbcAppliBaseInfo.setApproveTime(new Date()); // 当前已审批时间
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
		// com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo appliBaseInfo = new
		// com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo();
		// iBPbcAppliBaseInfoDAO.updateByPrimaryKey(daoBPbcAppliBaseInfo);
		iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);

	}

	@Transactional
	public void doWorkForPass(String appNo) {
		// 1.申请基本信息
		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo base = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		base.setAppliStatus(WorkflowConstant.APPLI_STATUS_APPROVED);// 申请状态为已通过审核
		base.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);// 申请状态明细已通过审核
		iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(base);
		// 2.单据信息（折让金额）
		RBcpDebtBaseInfoExample rBcpDebtBaseInfoExample = new RBcpDebtBaseInfoExample();
		rBcpDebtBaseInfoExample.createCriteria().andLockAppnoEqualTo(appNo);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> listRBcpDebtBaseInfo = iRBcpDebtBaseInfoDAO.selectByExample(rBcpDebtBaseInfoExample);
		List<RBcpAppliBussDtl> RBcpAppliBussDtlList = rBcpAppliBussDtlDAO.selectByAppno(appNo);
		for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo : listRBcpDebtBaseInfo) {
			for (RBcpAppliBussDtl dtlVal : RBcpAppliBussDtlList) {
				if (rBcpDebtBaseInfo.getId().equals(dtlVal.getDebtId())) {
					// 随着减值成功有三个金额变化
					// RemainingAmount，RebateAmount，RemainingUseableAmount
					rBcpDebtBaseInfo.setIsLocked(RBcpDebtConstant.IS_LOCKED_FALSE);
					rBcpDebtBaseInfo.setLockAppno("");
					rBcpDebtBaseInfo.setConfirmDate(simpleDateFormat.format(new Date()));

					rBcpDebtBaseInfo.setRemainingAmount(dtlVal.getRemainingAmount().subtract(dtlVal.getRebateAmount()));
					BigDecimal rebateAmount = rBcpDebtBaseInfo.getRebateAmount() == null ? new BigDecimal("0") : rBcpDebtBaseInfo.getRebateAmount();
					rBcpDebtBaseInfo.setRebateAmount(rebateAmount.add(dtlVal.getRebateAmount()));

					BigDecimal remainingUseableAmount = rBcpDebtBaseInfo.getRemainingUseableAmount() == null ? new BigDecimal("0")
							: rBcpDebtBaseInfo.getRemainingUseableAmount();
					BigDecimal loanPercent = rBcpDebtBaseInfo.getLoanPercent() == null ? new BigDecimal("0") : rBcpDebtBaseInfo.getLoanPercent();

					rBcpDebtBaseInfo.setRemainingUseableAmount(remainingUseableAmount.subtract(
							rBcpDebtBaseInfo.getRebateAmount().multiply(loanPercent).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP)));// 发票可融资余额

					if ("0".equals(rBcpDebtBaseInfo.getRemainingAmount().toString())) {
						rBcpDebtBaseInfo.setStatus(DebtConstants.INVOICE_STATUS_VERIFIED);
					}

					rBcpDebtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);// 解锁
					rBcpDebtBaseInfo.setLockAppno(null);
					iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo);

					com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl rBcpDebtBussDtl = new com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl();
					BeanUtils.copyProperties(rBcpDebtBaseInfo, rBcpDebtBussDtl);
					rBcpDebtBussDtl.setApplyType(RBcpDebtConstant.APPLY_TYPE_DISCOUNT);
					rBcpDebtBussDtl.setDebtId(rBcpDebtBaseInfo.getId());// 对应ID
					rBcpDebtBussDtl.setRebateAmount(dtlVal.getRebateAmount());
					rBcpDebtBussDtlService.addRBcpDebtBussDtl(rBcpDebtBussDtl);
				}
			}

		}
		// 3.debtBussInfoAdd 新增debtBussInfo
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo debtVOList = rBcpAppliBussInfoDAO.selectByAppno(appNo);
		DebtBussInfoVO debtBussInfoVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(debtVOList, debtBussInfoVO);
		rBcpDebtBussInfoService.debtBussInfoAdd(debtBussInfoVO);

		// 4.通知书
		String factType = "";
		String cont_noticeType = "";
		String noticeType = "";
		BCntDebtExtInfo bCntDebtExtInfo = null;
		RBcpAppliBussInfo busiinfo = iRBcpAppliBussInfoService.findByAppno(appNo);
		com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo bCntDebtInfo = iBCntDebtInfoDAO.selectByPrimaryKey(base.getMastContno());
		BCntDebtExtInfoExample iext = new BCntDebtExtInfoExample();
		iext.createCriteria().andBusinessNoEqualTo(base.getMastContno()).andBuyerCustcdEqualTo(busiinfo.getCustcdBuyer());
		List<BCntDebtExtInfo> bCntDebtExtInfolist = iBCntDebtExtInfoDAO.selectByExample(iext);
		if (bCntDebtExtInfolist != null && bCntDebtExtInfolist.size() > 0) {
			bCntDebtExtInfo = bCntDebtExtInfolist.get(0);
			if (bCntDebtExtInfo != null && StringUtils.isNotEmpty(bCntDebtExtInfo.getNoticeType())) {
				cont_noticeType = bCntDebtExtInfo.getNoticeType();
			}
		}

		BCrmBaseInfo bCrmBaseInfo = iBCrmBaseInfoDAO.selectById(bCntDebtInfo.getCustcd());
		// 发通知书

		if (bCntDebtInfo != null && StringUtils.isNotEmpty(bCntDebtInfo.getFactType())) {
			factType = bCntDebtInfo.getFactType();
			if (ScfBasConstant.FACT_TYPE_INLAND.equals(factType) || ScfBasConstant.FACT_TYPE_REVERSE.equals(factType)) {
				if (!StringUtils.isEmpty(cont_noticeType) && RBcpDebtConstant.FACTORY_NOTICE_TYPE.equals(cont_noticeType)) {
					noticeType = NoticeConstant.NOTICE_TYPE_100;
				} else if (RBcpDebtConstant.FACTORY_ONLY_NOTICE_TYPE.equals(cont_noticeType)) {
					noticeType = NoticeConstant.NOTICE_TYPE_125;
				} else {
					noticeType = NoticeConstant.NOTICE_TYPE_13;
				}
			} else if (ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType) || ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
					|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType)) {
				if (!StringUtils.isEmpty(cont_noticeType) && RBcpDebtConstant.FACTORY_NOTICE_TYPE.equals(cont_noticeType)) {
					noticeType = NoticeConstant.NOTICE_TYPE_102;
				} else if (RBcpDebtConstant.FACTORY_ONLY_NOTICE_TYPE.equals(cont_noticeType)) {
					noticeType = NoticeConstant.NOTICE_TYPE_125;
				} else {
					noticeType = NoticeConstant.NOTICE_TYPE_101;
				}
			} else if (ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(factType)) {
				if (!StringUtils.isEmpty(cont_noticeType) && RBcpDebtConstant.FACTORY_NOTICE_TYPE.equals(cont_noticeType)) {
					noticeType = NoticeConstant.NOTICE_TYPE_104;
				} else if (RBcpDebtConstant.FACTORY_ONLY_NOTICE_TYPE.equals(cont_noticeType)) {
					noticeType = NoticeConstant.NOTICE_TYPE_125;
				} else {
					noticeType = NoticeConstant.NOTICE_TYPE_103;
				}
			} else if (ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(factType)) {
				if (!StringUtils.isEmpty(cont_noticeType) && RBcpDebtConstant.FACTORY_NOTICE_TYPE.equals(cont_noticeType)) {
					noticeType = NoticeConstant.NOTICE_TYPE_106;
				} else if (RBcpDebtConstant.FACTORY_ONLY_NOTICE_TYPE.equals(cont_noticeType)) {
					noticeType = NoticeConstant.NOTICE_TYPE_125;
				} else {
					noticeType = NoticeConstant.NOTICE_TYPE_105;
				}
			} else if (ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType)) {
				noticeType = NoticeConstant.NOTICE_TYPE_107;
			} else if (ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType)) {
				noticeType = NoticeConstant.NOTICE_TYPE_114;
			}

		}
		// 这里NOTICE_TYPE 就应该是 NOTICE_TYPE_17 上面的东西实际上都可以省略掉
		BNteNoticeBase bNteNoticeBase = new BNteNoticeBase();
		String noticeNo = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSZR_T_NOTICE_NO);
		bNteNoticeBase.setNum(noticeNo);
		bNteNoticeBase.setAppno(appNo);
		bNteNoticeBase.setCustcd(bCntDebtInfo.getCustcd());
		bNteNoticeBase.setCustName(bCrmBaseInfo.getCname());
		if (bCntDebtExtInfo != null) {
			bNteNoticeBase.setOtherCustcd(bCntDebtExtInfo.getBuyerCustcd());
			bNteNoticeBase.setOtherCustName(bCntDebtExtInfo.getBuyerName());
		}
		bNteNoticeBase.setMastContno(base.getMastContno());
		bNteNoticeBase.setBussType(base.getSupplyChainPdId());
		bNteNoticeBase.setCommonAmt(busiinfo.getAmount());// 这里就是减值总金额
		bNteNoticeBase.setCommonNum(String.valueOf(busiinfo.getDebtNum()));
		bNteNoticeBase.setStatus(NoticeConstant.NOTICE_BASE_STATUS_UNCONFIRM);
		bNteNoticeBase.setNoticeType(NoticeConstant.NOTICE_TYPE_17);// 通知书类型
		bNteNoticeBase.setBrcode(base.getAppBrcode());
		bNteNoticeBase.setTlrn(base.getAppTlrcd());
		bNteNoticeBase.setAppliDate(base.getAppDate());
		bNteNoticeBaseService.addBNteNoticeBase(bNteNoticeBase);
		// 老代码在这里是直接一步到已阅已确认
		bNteNoticeBaseService.modifyNoticeBaseInfo(appNo, NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		// 5.池信息修改
		if (factType.equals(ScfBasConstant.FACT_TYPE_DEBT_POOL)) {
			updateDebtPoolInfo(debtBussInfoVO);
		}
	}

	public void doWorkForReject(String appNo) {

	}

	public void doWorkForBack(String appNo) {

	}

	public Page getLanLnciInfoByContno(int pageNo, int pageSize, String debtContno, List debtno) throws Exception {
		Page lnciInfoResult = new Page();
		// 借据基本信息
		List<BLanLnciBaseExt> listBLanLnciBaseExt = new ArrayList();
		BLanLnciBaseExample bLanLnciBaseExample = new BLanLnciBaseExample();
		bLanLnciBaseExample.createCriteria().andDebetNoIn(debtno).andMastContnoEqualTo(debtContno);
		List<BLanLnciBase> listBLanLnciBase = bLanLnciBaseDAO.selectByExample(bLanLnciBaseExample);
		for (int i = 0; i < listBLanLnciBase.size(); i++) {
			BLanLnciBaseExt ext = new BLanLnciBaseExt();
			BLanLnciBase blb = listBLanLnciBase.get(i);
			// ext.setTotalRateRemainAmount(null);
			if (blb.getLnciBal() == null) {
				blb.setLnciBal(new BigDecimal("0"));
			}
			if (blb.getBailAmount() == null) {
				blb.setBailAmount(new BigDecimal("0"));
			}
			if (blb.getAddBailAmount() == null) {
				blb.setAddBailAmount(new BigDecimal("0"));
			}
			if (blb.getInitCashEqtAmt() == null) {
				blb.setInitCashEqtAmt(new BigDecimal("0"));
			}
			if (blb.getAddCashEqtAmt() == null) {
				blb.setAddCashEqtAmt(new BigDecimal("0"));
			}
			ext.setAvaliableRiskAmt(blb.getLnciBal().subtract(blb.getBailAmount()).subtract(blb.getAddBailAmount())
					.subtract(blb.getInitCashEqtAmt().subtract(blb.getAddCashEqtAmt())));// 敞口余额
			BeanUtils.copyProperties(blb, ext);
			listBLanLnciBaseExt.add(ext);

		}
		lnciInfoResult.setRecords(listBLanLnciBaseExt);
		lnciInfoResult.setPageNo(pageNo);
		lnciInfoResult.setPageSize(pageSize);
		lnciInfoResult.setTotalRecord(listBLanLnciBase.size());
		return lnciInfoResult;
	}

	@Transactional
	public void deleterBcpDebtBasebyId(String id, String appNo, String impairmentCount, String impairmentAmount) throws Exception {
		//
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(appNo)) {

			//
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo dRBcpAppliBussInfo = rBcpAppliBussInfoDAO.selectByAppno(appNo);
			dRBcpAppliBussInfo.setDebtNum(Integer.parseInt(impairmentCount));
			dRBcpAppliBussInfo.setTotalDebtAmount(new BigDecimal(impairmentAmount));
			dRBcpAppliBussInfo.setRebateAmount(new BigDecimal(impairmentAmount));
			rBcpAppliBussInfoDAO.updateByPrimaryKey(dRBcpAppliBussInfo);

			RBcpAppliBussDtl dtlValue = rBcpAppliBussDtlDAO.selectByPrimaryKey(id);
			com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo dRBcpDebtBaseInfo = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(dtlValue.getDebtId());
			dRBcpDebtBaseInfo.setIsLocked(RBcpDebtConstant.IS_LOCKED_FALSE);
			dRBcpDebtBaseInfo.setLockAppno("");
			iRBcpDebtBaseInfoDAO.updateByPrimaryKey(dRBcpDebtBaseInfo);

			rBcpAppliBussDtlDAO.deleteByPrimaryKey(id);

		}

	}

	public Page queryBCntDebtInfoListByPage(int pageNo, int pageSize, String factType, MastContQryVO mastContQryVO) throws ScubeBizException {
		Page p = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();

		if (null != mastContQryVO) {
			String cname = mastContQryVO.getCname();// 卖方名称
			String buyerName = mastContQryVO.getBuyerName();// 买方名称
			String debtContno = mastContQryVO.getMastContCode();// 主合同号
			String conStatus = mastContQryVO.getConStatus();// 合同状态
			// String factType = mastContQryVO.getFactType();
			String financingType = mastContQryVO.getFinancingType();
			String roleType = mastContQryVO.getFlag();// 客户类型
			String mgrno = "";
			List<String> factTypes = new ArrayList<String>();// 应收账款融资
			if (factType.equals(BCntBizConstant.T_FINANCING_TYPE_INVOICE)) {
				factTypes.add(BCntBizConstant.FACT_TYPE_INLAND);
				factTypes.add(BCntBizConstant.FACT_TYPE_REVERSE);
				factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_PLEDGE);
			} else if (factType.equals(BCntBizConstant.T_FINANCING_TYPE_POOL)) {
				factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL_PLEDGE);// 应收账款质押池融资
				factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL);// 保理池融资
				factTypes.add(BCntBizConstant.FACT_TYPE_EXPORT_POOL_PLEDGE);// 出口退税池质押融资
			} else {

			}
			map.put("factTypes", factTypes);
			UserInfo user = ContextHolder.getUserInfo();
			if (StringUtil.isStrEmpty(roleType)) {
				String roleFlag = "0"; // 岗位标志位

				List<String> roleList = user.getRoleList();
				for (int i = 0; i < roleList.size(); i++) {
					Object role = roleList.get(i);
					// 判断方式：当前角色当中包含有除客户经理外的其它岗位，Flag为1
					if (!ScfBasConstant.ROLE_ID_MANAGER.equals(String.valueOf(role))) {
						roleFlag = "1";
						break;
					} else {
						roleFlag = "0";
					}
				}

				if ("0".equals(roleFlag)) {
					mastContQryVO.setFlag(ScfBasConstant.CUST_QUERY_TYPE_BY_MANAGER);
				} else {
					mastContQryVO.setFlag(ScfBasConstant.CUST_QUERY_TYPE_BY_BCTL);
				}
			}
			if (ScfBasConstant.CUST_QUERY_TYPE_BY_MANAGER.equals(mastContQryVO.getFlag())) {
				mgrno = user.getTlrNo();
			}
			if (StringUtil.isStrNotEmpty(mgrno)) {
				map.put("mgrno", mgrno);
			}
			if (StringUtil.isStrNotEmpty(cname)) {
				map.put("cname", cname);
			}

			if (StringUtil.isStrNotEmpty(conStatus)) {
				map.put("conStatus", conStatus);
			}
			if (StringUtil.isStrNotEmpty(debtContno)) {
				map.put("debtContno", debtContno);
			}
			if (StringUtil.isStrNotEmpty(buyerName)) {
				map.put("buyerName", buyerName);
			}
			if (StringUtil.isStrNotEmpty(financingType)) {
				map.put("financingType", financingType);
			}

		}
		p.setRecords(iBCntDebtInfoDAO.selectBCntDebtInfoList(map, p));
		// List<com.huateng.scf.bas.cnt.dao.model.DebtContVO> listDebtContVO
		// =iBCntDebtInfoDAO.selectBCntDebtInfoList(map, p);
		/*
		 * List list = new ArrayList(); Iterator iter =
		 * listDebtContVO.iterator(); DebtContVO vo = null;
		 * while(iter.hasNext()){ Object[] obj = (Object[]) iter.next(); vo =
		 * new DebtContVO();
		 * 
		 * if(debtMngService.checkDealInvoiceIsExist(vo.getDebtContno())){
		 * vo.setDealFlag(SCFConstants.FLAG_ON); } list.add(vo); }
		 */
		return p;
	}

	@Override
	public RBCntDebtExtBaseInfo queryPoolBaseInfo(String debtContno) throws Exception {
		RBCntDebtExtBaseInfo extBaseInfo = new RBCntDebtExtBaseInfo();
		com.huateng.scf.bas.cnt.dao.model.BCntDebtInfo bCntDebtInfo = iBCntDebtInfoDAO.selectByPrimaryKey(debtContno);
		BCrmBaseInfo bCrmBaseInfo = iBCrmBaseInfoDAO.selectById(bCntDebtInfo.getCustcd());

		extBaseInfo.setDebtContno(debtContno);
		extBaseInfo.setStartDate(bCntDebtInfo.getStartDate());
		extBaseInfo.setEndDate(bCntDebtInfo.getEndDate());
		if (StringUtils.isNotEmpty(bCntDebtInfo.getSupplyChainPdId())) {
			BPrdInfo dBPrdInfo = bPrdInfoDAO.selectByPrimaryKey(bCntDebtInfo.getSupplyChainPdId());
			extBaseInfo.setSupplyChainPdId(dBPrdInfo.getProductName());
		}
		extBaseInfo.setCustName(bCrmBaseInfo.getCname());
		extBaseInfo.setBailAccount(bCntDebtInfo.getBailAcctNo());
		extBaseInfo.setTotalBillsAmount(new BigDecimal(0));
		extBaseInfo.setPoolRiskAmt(new BigDecimal(0));
		List list = rbcpdebtpoolservice.queryDebtPollByMastContno(debtContno, bCntDebtInfo.getCustcd());
		if (list.size() > 0) {
			RBcpDebtPool tblDebtPool = (RBcpDebtPool) list.get(0);
			BigDecimal tdr = tblDebtPool.getTotalDebtRemainAmount();
			extBaseInfo.setTotalBillsAmount((tdr != null && tdr.compareTo(new BigDecimal(0)) == 1) ? tdr : new BigDecimal(0));
			BigDecimal bgp = calculatePoolRiskAvailableAmtByBusinessNo(debtContno);
			extBaseInfo.setPoolRiskAmt((bgp != null && bgp.compareTo(new BigDecimal(0)) == 1) ? bgp : new BigDecimal(0));// 池敞口余额

		}
		return extBaseInfo;
	}

	private BigDecimal calculatePoolRiskAvailableAmtByBusinessNo(String businessNo) throws ScubeBizException {
		log.debug("businessNo=" + businessNo);
		DebtLnciQryVO lnciQryVO = new DebtLnciQryVO();
		lnciQryVO.setPageIndex(1);
		lnciQryVO.setPageSize(Integer.MAX_VALUE);
		lnciQryVO.setBussContno(businessNo);
		lnciQryVO.setFlag(ScfBasConstant.FLAG_ON);// 是否应收账款池敞口查询
		Page result = blanlncibaseservice.queryLnciInfoByBusinessNo(lnciQryVO);
		List flowList = bpbcapplibaseinfoservice.getFlowRiskAmtByBusinessNo(businessNo);
		List list = result.getRecords();
		BigDecimal totalContRist = new BigDecimal(0);
		if (list != null && list.size() > 0) {
			BLanLnciBase tblLnciBaseInfoTmp = null;
			int count = list.size();
			BigDecimal addBailAmount;
			BigDecimal bailAmount;
			BigDecimal initCashEqtAmt;
			BigDecimal addCashEqtAmt;
			BigDecimal lnciBal;

			for (int i = 0; i < count; i++) {
				tblLnciBaseInfoTmp = (BLanLnciBase) list.get(i);
				// 借据敞口余额 = 借据余额 – 冻结保证金 – 现金等价物金额
				addBailAmount = (tblLnciBaseInfoTmp.getAddBailAmount() == null ? new BigDecimal(0) : tblLnciBaseInfoTmp.getAddBailAmount());
				bailAmount = (tblLnciBaseInfoTmp.getBailAmount() == null ? new BigDecimal(0) : tblLnciBaseInfoTmp.getBailAmount());
				initCashEqtAmt = (tblLnciBaseInfoTmp.getInitCashEqtAmt() == null ? new BigDecimal(0) : tblLnciBaseInfoTmp.getInitCashEqtAmt());
				addCashEqtAmt = (tblLnciBaseInfoTmp.getAddCashEqtAmt() == null ? new BigDecimal(0) : tblLnciBaseInfoTmp.getAddCashEqtAmt());
				lnciBal = tblLnciBaseInfoTmp.getLnciBal();
				totalContRist = totalContRist
						.add(lnciBal.subtract(addBailAmount).subtract(bailAmount).subtract(initCashEqtAmt).subtract(addCashEqtAmt));
			}
		}
		// 流程中借据敞口余额也要统计 add by xiaolong.xiong 2013-09-29
		if (flowList != null && flowList.size() > 0) {
			HashMap<String, Object> map = (HashMap<String, Object>) flowList.get(0);
			BigDecimal amt = (BigDecimal) (map.get("riskAmount") == null ? BigDecimal.ZERO : map.get("riskAmount"));
			totalContRist = totalContRist.add(amt);
		}
		return totalContRist;
	}

	/*
	 * 减值页面保存按钮
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IRBcpImpairmentService#
	 * mpairApplySaveUpdate(com.huateng.scf.rec.bcp.model.DebtBussInfoVO,
	 * java.util.ArrayList, com.huateng.scf.rec.bcp.model.ProcessModel)
	 */
	@Override
	@Transactional
	public RBcpAppliBussInfo ImpairApplySaveUpdate(DebtBussInfoVO debtVO, ArrayList<com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl> ds,
			ProcessModel processModel) throws ScubeBizException {
		// 1.前台数据校验
		if (debtVO == null || "".equals(debtVO)) {// SCF_REC_BCP_10005,前台所传数据无效
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		if (ds == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		RBcpAppliBussInfo rBcpAppliBussInfo = new RBcpAppliBussInfo();
		if (StringUtil.isEmpty(debtVO.getAppno())) {
			String businessnoType = "";
			String workApplyType = "";
			if (ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(debtVO.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_ALLOWANCECREDITAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_ALLOWANCE_CREDIT_APPLY;
			} else if (ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(debtVO.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_ALLOWANCEDOUBLEAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_ALLOWANCE_DOUBLE_APPLY;
			} else if (ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(debtVO.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_ALLOWANCELEASEAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_ALLOWANCE_LEASE_APPLY;
			} else if (ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(debtVO.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_ALLOWANCEPOOLAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_ALLOWANCE_POOL_APPLY;
			} else {
				businessnoType = WorkflowConstant.APPLI_TYPE_ALLOWANCEAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_ALLOWANCE_APPLY;
			}
			// 2.保存申请基本信息 B_PBC_APPLI_BASE_INFO
			debtVO.setMastContcode(debtVO.getMastContno());
			String appno = iBPbcAppliBaseInfoService.saveBillsVendorAppliBaseInfo(debtVO, businessnoType, workApplyType);
			rBcpAppliBussInfo.setAppno(appno);// 用于返回页面的
			// 3.新增B_PBC_APPLI_BUSS_INFO 和B_PBC_APPLI_BUSS_DTL，锁定对应的单据信息
			addImpairBussInfo(debtVO, ds, appno);
			// 4.发起流程
			String processId = "";
			try {
				processModel.setBizId(appno);
				processModel.getBizData()[0] = appno;
				processModel.getBizData()[4] = ContextHolder.getUserInfo().getTlrName();
				ProcessEntity processEntity = iProcessService.startProcess(processModel.getModelId(), processModel.getProcessName(),
						processModel.getNodeId(), processModel.getStartedUserId(), processModel.getBizId(), processModel.getBizData());
				processId = processEntity.getProcessId();
			} catch (Exception e) {// SCF_REC_BCP_10022,发起流程失败
				log.error("" + e);
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10022),
						RBcpErrorConstant.SCF_REC_BCP_10022);
			}
			BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			bPbcAppliBaseInfo.setPiid(processId);
			iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}
		// 有申请号就保存修改操作
		if (StringUtils.isNotEmpty(debtVO.getAppno())) {
			this.updateImpairBussInfo(debtVO, ds, debtVO.getAppno());
		}
		return rBcpAppliBussInfo;
	}

	/*
	 * 新增B_PBC_APPLI_BUSS_INFO 和B_PBC_APPLI_BUSS_DTL，锁定对应的单据信息
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IRBcpImpairmentService#
	 * addDisputInvoiceRemoveBussInfo(com.huateng.scf.rec.bcp.model.
	 * DebtBussInfoVO, java.util.ArrayList, java.lang.String)
	 */
	@Override
	@Transactional
	public void addImpairBussInfo(DebtBussInfoVO debtVO, ArrayList<com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl> ds, String appno)
			throws ScubeBizException {
		// 1.新增对应申请信息
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String insertDate = simpleDateFormat.format(new Date());// 新增插入日期
		String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
		String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfo2 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
		BeanUtils.copyProperties(debtVO, rBcpAppliBussInfo2);
		rBcpAppliBussInfo2.setAppno(appno);// 申请号
		rBcpAppliBussInfo2.setInsertDate(insertDate);// 登记时间
		rBcpAppliBussInfo2.setCrtTime(new Date());// 创建时间
		rBcpAppliBussInfo2.setLastUptTime(new Date());// 最后更新时间
		rBcpAppliBussInfo2.setId(UUIDGeneratorUtil.generate());// id
		rBcpAppliBussInfo2.setApplyType(RBcpDebtConstant.APPLY_TYPE_DISCOUNT);// 申请状态为减值
		rBcpAppliBussInfo2.setTlrcd(tlrcd);// 创建人，操作员
		rBcpAppliBussInfo2.setBrcode(brcode);// 设置经办机构信息
		try {
			rBcpAppliBussInfoDAO.insert(rBcpAppliBussInfo2);
		} catch (Exception e) {// SCF_REC_BCP_10024 ，新增应收账款业务流水信息失败！
			log.error("" + e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10024), RBcpErrorConstant.SCF_REC_BCP_10024);
		}
		// 2.生成对应申请明细信息（此时页面传值应该传的是）
		for (com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl rBcpAppliBussDtl1 : ds) {
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
			BeanUtils.copyProperties(rBcpAppliBussDtl1, rBcpAppliBussDtl);
			// 3.锁定单据
			rBcpDebtBaseInfoService.lockDebtBaseInfo(rBcpAppliBussDtl.getId(), appno);
			rBcpAppliBussDtl.setDebtId(rBcpAppliBussDtl.getId());
			rBcpAppliBussDtl.setAppno(appno);
			rBcpAppliBussDtl.setId(UUIDGeneratorUtil.generate());
			rBcpAppliBussDtl.setRebateAmount(rBcpAppliBussDtl1.getRebateAmounts());// 页面具体的减值金额
			rBcpAppliBussDtlDAO.insert(rBcpAppliBussDtl);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IRBcpImpairmentService#
	 * updateImpairBussInfo(com.huateng.scf.rec.bcp.model.DebtBussInfoVO,
	 * java.util.ArrayList, java.lang.String)
	 */
	@Override
	@Transactional
	public void updateImpairBussInfo(DebtBussInfoVO debtVO, ArrayList<com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl> ds, String appno)
			throws ScubeBizException {
		// 1.保存 应收账款业务申请流水基本信息表 R_BCP_APPLI_BUSS_INFO
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfo3 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo();
		BeanUtils.copyProperties(debtVO, rBcpAppliBussInfo3);
		rBcpAppliBussInfo3.setLastUptTime(new Date());// 最后更新时间
		rBcpAppliBussInfoDAO.updateByPrimaryKeySelective(rBcpAppliBussInfo3);
		// 2.调整锁定的应收账款基本信息
		// 解锁原有的
		RBcpDebtBaseInfoExample rBcpDebtBaseInfoExample = new RBcpDebtBaseInfoExample();
		rBcpDebtBaseInfoExample.createCriteria().andLockAppnoEqualTo(debtVO.getAppno());
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> bcpDebtBaseInfoList = iRBcpDebtBaseInfoDAO.selectByExample(rBcpDebtBaseInfoExample);
		if (bcpDebtBaseInfoList != null && bcpDebtBaseInfoList.size() > 0) {
			for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo1 : bcpDebtBaseInfoList) {
				rBcpDebtBaseInfoService.releaseDebtBaseInfo(rBcpDebtBaseInfo1.getId());
			}
		}
		// 删除对应的明细信息
		RBcpAppliBussDtlExample rBcpAppliBussDtlExample = new RBcpAppliBussDtlExample();
		rBcpAppliBussDtlExample.createCriteria().andAppnoEqualTo(appno);
		rBcpAppliBussDtlDAO.deleteByExample(rBcpAppliBussDtlExample);
		// 锁定现有的
		for (com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl rBcpAppliBussDtl1 : ds) {
			String id = "";
			if (rBcpAppliBussDtl1.getAppno() != null && !"".equals(rBcpAppliBussDtl1.getAppno())) {
				id = rBcpAppliBussDtl1.getDebtId();
			} else {
				id = rBcpAppliBussDtl1.getId();
			}
			com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo1 = iRBcpDebtBaseInfoDAO.selectByPrimaryKey(id);
			if (rBcpDebtBaseInfo1 != null && !"".equals(rBcpDebtBaseInfo1)) {
				// 防止在选择数据到确定保存的过程中，对应的单据信息被其他人锁定，所以这里要验证下。
				if (rBcpDebtBaseInfo1.getIsLocked().equals(RBcpDebtConstant.IS_LOCKED_TRUE)) {
					throw new ScubeBizException("凭证编号为" + rBcpDebtBaseInfo1.getBillsNo() + "的应收账款基本信息已经被锁定，无法使用！");
				}
				rBcpDebtBaseInfoService.lockDebtBaseInfo(id, appno);

			} else {// SCF_REC_BCP_10025 ,锁定应收账款基本信息失败！
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10025),
						RBcpErrorConstant.SCF_REC_BCP_10025);
			}
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl rBcpAppliBussDtl = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
			BeanUtils.copyProperties(rBcpAppliBussDtl1, rBcpAppliBussDtl);
			rBcpAppliBussDtl.setDebtId(id);
			rBcpAppliBussDtl.setAppno(appno);
			rBcpAppliBussDtl.setId(UUIDGeneratorUtil.generate());
			rBcpAppliBussDtl.setRebateAmount(rBcpAppliBussDtl1.getRebateAmounts());// 页面具体的减值金额
			rBcpAppliBussDtlDAO.insert(rBcpAppliBussDtl);
		}

	}

	/*
	 * 减值页面提交按钮
	 * 
	 * @see
	 * com.huateng.scf.rec.bcp.service.IRBcpImpairmentService#impairApplySubmit(
	 * com.huateng.scf.rec.bcp.model.DebtBussInfoVO, java.util.ArrayList,
	 * com.huateng.scf.rec.bcp.model.ProcessModel)
	 */
	@Override
	@Transactional
	public void impairApplySubmit(DebtBussInfoVO debtVO, ArrayList<com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl> ds, ProcessModel processModel)
			throws ScubeBizException {
		// 1.先保存页面信息
		this.updateImpairBussInfo(debtVO, ds, debtVO.getAppno());
		// 2.申请基本信息
		BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(debtVO.getAppno());
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
		iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		String factType = debtVO.getFactType();
		// 2.流程跳转
		String userId = ContextHolder.getUserInfo().getTlrNo();// 操作员
		if (debtVO.getAppno() != null && !"".equals(debtVO.getAppno())) {
			scfWorkFlowService.takeTaskAndRelated(debtVO.getAppno());
		} else {// 前台业务数据无效
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
	}

	/*
	 * 池融资减值涉及池信息修改
	 * 
	 * @see
	 * com.huateng.scf.rec.bcp.service.IRBcpImpairmentService#updateDebtPoolInfo
	 * (com.huateng.scf.rec.bcp.model.DebtBussInfoVO)
	 */
	@Override
	@Transactional
	public void updateDebtPoolInfo(DebtBussInfoVO debtVO) throws ScubeBizException {
		List list = rbcpdebtpoolservice.queryDebtPollByMastContno(debtVO.getMastContno(), debtVO.getCustcdSaller());
		if (list != null && list.size() > 0) {
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				RBcpDebtPool poolDebtVo = (RBcpDebtPool) iter.next();
				BigDecimal loanPercent = debtVO.getLoanPercent() == null ? new BigDecimal("0") : debtVO.getLoanPercent();
				BigDecimal totalAmount = debtVO.getAmount() == null ? new BigDecimal("0") : debtVO.getAmount();// 折让总金额
				BigDecimal totalDebtRemainAmount = poolDebtVo.getTotalDebtRemainAmount() == null ? new BigDecimal("0")
						: poolDebtVo.getTotalDebtRemainAmount();// 【发票总余额】
				poolDebtVo.setTotalDebtRemainAmount(totalDebtRemainAmount.subtract(totalAmount));
				// poolDebtVo.setTotalDebtAmount(totalDebtAmount.subtract(totalAmount));
				// poolDebtVo.setTotalRemainAmount((totalDebtAmount.subtract(totalAmount)).multiply(loanPercent).divide(new
				// BigDecimal("100"),2,BigDecimal.ROUND_HALF_UP));
				BigDecimal poolUseableAmount = poolDebtVo.getPoolUseableAmount().toString() == null ? new BigDecimal("0")
						: poolDebtVo.getPoolUseableAmount();
				BigDecimal poolUseableAmounts = poolUseableAmount
						.subtract(totalAmount.multiply(loanPercent).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP));
				/*
				 * if(poolUseableAmounts.compareTo(new BigDecimal("0"))<0){
				 * ExceptionUtil.throwAppException("本次折让后客户融资池出现溢拨”"+
				 * poolUseableAmounts.toString()+"“，" +
				 * "提示客户需发票补入池、融资还款、补充现金余额入池融资内部户!",
				 * SCFErrorCode.ERROR_CODE_DATA_INPUT_ERR); }
				 */
				poolDebtVo.setPoolUseableAmount(poolUseableAmounts);
				RBcpDebtPool tblDebtPool = rbcpdebtpoolservice.findRBcpDebtPoolByKey(poolDebtVo.getId());
				// TblDebtPool tblDebtPool = this.get(poolDebtVo.getId());

				BeanUtils.copyProperties(poolDebtVo, tblDebtPool);

				rbcpdebtpoolservice.updateRBcpDebtPool(tblDebtPool);
			}
		}
	}
}

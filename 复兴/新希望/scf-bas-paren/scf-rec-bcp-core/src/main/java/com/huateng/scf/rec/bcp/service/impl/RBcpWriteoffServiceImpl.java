package com.huateng.scf.rec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.api.ITaskService;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.cnt.constant.BCntBizConstant;
import com.huateng.scf.bas.cnt.dao.IBCntDebtExtInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntDebtInfoDAO;
import com.huateng.scf.bas.cnt.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfApplyService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.nte.constant.BNteConstant;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.ext.ExtIRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scf.rec.bcp.service.IRBcpWriteoffService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("RBcpWriteoffServiceImpl")
public class RBcpWriteoffServiceImpl implements IRBcpWriteoffService, DealEndFlowService, DealInFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BCntDebtInfoDAO")
	IBCntDebtInfoDAO iBCntDebtInfoDAO;

	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO iBCrmBaseInfoDAO;

	@Resource(name = "BCntDebtExtInfoDAO")
	IBCntDebtExtInfoDAO iBCntDebtExtInfoDAO;

	@Resource(name = "processService")
	IProcessService iProcessService;

	@Resource(name = "taskService")
	private ITaskService taskService;

	// 业务申请基本信息表
	@Resource(name = "bPbcAppliBaseInfoService")
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;

	// 应收账款业务申请流水基本信息
	@Resource(name = "rBcpAppliBussInfoService")
	IRBcpAppliBussInfoService rBcpAppliBussInfoService;

	// 转让基本信息
	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO rBcpAppliBussInfoDAO;

	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO iBPbcAppliBaseInfoDAO;

	// 应收账款融资业务申请流水明细表
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rBcpAppliBussDtlDAO;

	@Resource(name = "bSysSerialNoService")
	private IBSysSerialNoService bSysSerialNoService;

	// 应收账款基本信息
	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO iRBcpDebtBaseInfoDAO;
	
	@Resource(name = "ExtIRBcpDebtBaseInfoDAO")
	ExtIRBcpDebtBaseInfoDAO extIRBcpDebtBaseInfoDAO;
	
	@Resource(name = "BPrdInfoDAO")
	private IBPrdInfoDAO bPrdInfoDAO;

	// 产品工厂信息
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bPrdInfoService;

	// 客户信息
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bCrmBaseInfoService;

	@Resource(name = "bNteNoticeBaseService")
	private IBNteNoticeBaseService bNteNoticeBaseService;

	@Resource(name = "rBcpDebtPoolService")
	private IRBcpDebtPoolService rBcpDebtPoolService;

	// 应收账款明细信息
	@Resource(name = "RBcpDebtBussDtlServiceImpl")
	IRBcpDebtBussDtlService rBcpDebtBussDtlService;

	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	@Resource(name = IScfApplyService.BEAN_ID)
	IScfApplyService scfApplyService;
	@Resource(name = "RBcpAppliBussDtlServiceImpl")
	IRBcpAppliBussDtlService rBcpAppliBussDtlService;

	// 应收账款单据基本信息 rBcpDebtBussInfo
	@Resource(name = "RBcpDebtBussInfoServiceImpl")
	IRBcpDebtBussInfoService rBcpDebtBussInfoService;
	// 应收账款基本信息
	@Resource(name = "RBcpDebtBaseInfoServiceImpl")
	IRBcpDebtBaseInfoService rBcpDebtBaseInfoService;

	@Resource(name = IBCntDebtInfoService.BEAN_ID)
	IBCntDebtInfoService bCntDebtInfoService; // 保理合同基本信息

	/**
	 * 查询核销的信息
	 */
	public DebtBussInfoVO queryBaseInfo(DebtBussInfoVO debtBussInfoVO) throws ScubeBizException {
		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		String appno = debtBussInfoVO.getAppno();
		String mastContno = debtBussInfoVO.getMastContno();
		String custcdBuyer = debtBussInfoVO.getCustcdBuyer();
		String custcdSaller = debtBussInfoVO.getCustcdSaller();

		if (!StringUtil.isEmpty(appno)) {
			RBcpAppliBussInfo tabi = rBcpAppliBussInfoService.findByAppno(appno);
			mastContno = tabi.getMastContno();
			custcdBuyer = tabi.getCustcdBuyer();
			custcdSaller = tabi.getCustcdSaller();
		}

		DebtCommonQryVO commonQueryVO = new DebtCommonQryVO();
		commonQueryVO.setMastContno(mastContno);
		commonQueryVO.setCustcdBuyer_Q(custcdBuyer);
		commonQueryVO.setCustcdSaller_Q(custcdSaller);
		commonQueryVO.setAppno_Q(appno);

		BCntDebtInfo contDebtInfo = bCntDebtInfoService.queryContInfoByMastContno(mastContno);
		BeanUtils.copyProperties(contDebtInfo, debtVO);
		BigDecimal loanpercent = new BigDecimal(0);
		debtVO.setCustcdBuyer(custcdBuyer);
		debtVO.setCustcdSaller(debtVO.getCustcd());
		debtVO.setAppno(appno);

		if (contDebtInfo.getLoanPercent() != null) {
			loanpercent = contDebtInfo.getLoanPercent();
		}
		if (StringUtil.isEmpty(debtBussInfoVO.getAppno())) {
			// 业务品种名称
			BPrdInfo bPrdInfo = new BPrdInfo();
			bPrdInfo.setProductId(contDebtInfo.getSupplyChainPdId());
			String bussTypeName = bPrdInfoService.findBPrdInfoByKey(bPrdInfo).getProductName();
			debtVO.setBussType(contDebtInfo.getSupplyChainPdId());
			debtVO.setBussTypeName(bussTypeName);
			// 买家名称
			// BCrmBaseInfo buyer = new BCrmBaseInfo();
			// buyer.setCustcd(contVO.getCustcdBuyer());
			// BCrmBaseInfo buyerinfo=
			// bcrmbaseinfoservice.findBCrmBaseInfoByKey(buyer);
			// contVO.setCnameBuyer(buyerinfo.getCname());
			// 卖家名称
			BCrmBaseInfo seller = new BCrmBaseInfo();
			seller.setCustcd(debtVO.getCustcdSaller());
			BCrmBaseInfo sellerinfo = bCrmBaseInfoService.findBCrmBaseInfoByKey(seller);
			debtVO.setCnameSeller(sellerinfo.getCname());
			// 出账方式
			debtVO.setLoanWay("");
			// 核销日期
			debtVO.setInsertDate(ScfDateUtil.getStringDate(new Date()));

		} else {
			RBcpAppliBussInfo appliVO = rBcpAppliBussInfoService.findByAppno(appno);
			BeanUtils.copyProperties(appliVO, debtVO);
			debtVO.setDebtContno(appliVO.getMastContno());
			debtVO.setBussType(appliVO.getBussType());// 业务品种
			debtVO.setStartDate(appliVO.getBillDate());// 合同生效日期
			debtVO.setEndDate(appliVO.getBillEndDate());// 合同到期日期
			debtVO.setRebateReason(appliVO.getReason());// 回购原因
			debtVO.setLoanPercent(loanpercent);// 融资比例
			debtVO.setTotalAmount(debtVO.getTotalDebtAmount());// 总核销金额
			// 业务品种名称
			BPrdInfo bPrdInfo = new BPrdInfo();
			// bPrdInfo.setProductId(debtVO.getSupplyChainPdId());
			String bussTypeName = bPrdInfoService.findBPrdInfoByKey(bPrdInfo).getProductName();
			debtVO.setBussTypeName(bussTypeName);
			// 买家名称
			BCrmBaseInfo buyer = new BCrmBaseInfo();
			buyer.setCustcd(appliVO.getCustcdBuyer());
			BCrmBaseInfo buyerinfo = bCrmBaseInfoService.findBCrmBaseInfoByKey(buyer);
			debtVO.setCnameBuyer(buyerinfo.getCname());
			// 卖家名称
			BCrmBaseInfo seller = new BCrmBaseInfo();
			seller.setCustcd(appliVO.getCustcdSaller());
			BCrmBaseInfo sellerinfo = bCrmBaseInfoService.findBCrmBaseInfoByKey(seller);
			debtVO.setCnameSeller(sellerinfo.getCname());
		}
		return debtVO;
	}

	/**
	 * 核销申请发票添加查询
	 */
	@Override
	public Page getInvoiceChargeOffAddQry(int pageNo, int pageSize,@ScubeParam("value")Map rBcpDebtBaseInfo)
			throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		extIRBcpDebtBaseInfoDAO.getInvoiceChargeOffAddQry(rBcpDebtBaseInfo, page);
		return page;

	}
	
	/**
	 * 核销信息保存
	 */
	@Transactional
	@Override
	public String saveWriteoffRequestInfo(DebtBussInfoVO debtBussInfoVO, List<RBcpDebtBaseInfo> list) throws ScubeBizException {
		//
		// 根据申请类型获取流程名称
		String businessnoType = "";// 申请类型
		String workApplyType = ""; // 申请业务类型
		String appno = debtBussInfoVO.getAppno();
		// 核销原因
		debtBussInfoVO.setReason(debtBussInfoVO.getRebateReason()); // 核销原因存入到业务申请业务主表
																	// 取的是debtBussInfoVO.getReason()
		if (StringUtil.isEmpty(appno)) {
			if (StringUtil.isStrNotEmpty(debtBussInfoVO.getFactType())) {
				if (ScfBasConstant.T_FINANCING_TYPE_INVOICE.equals(debtBussInfoVO.getFactType())) {// 应收账款
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORINGACCOUNTCANCELAPPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_ACCOUNTCANCEL_APPLY;
				} else if (ScfBasConstant.T_FINANCING_TYPE_POOL.equals(debtBussInfoVO.getFactType())) {// 应收账款池
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_POOL_CHARGEOFF;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_POOL_CHARGEOFF_APPLY;
				} else if (ScfBasConstant.T_FINANCING_TYPE_LEASE.equals(debtBussInfoVO.getFactType())) {// 租赁保理
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_DEBT_LEASE_CHARGE_OFF_APPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_DEBT_LEASE_CHARGE_OFF_APPLY;
				} else if (ScfBasConstant.T_FINANCING_TYPE_DOUBLE.equals(debtBussInfoVO.getFactType())) {// 双保理
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_DEBT_DOUBLE_CHARGE_OFF_APPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_DEBT_DOUBLE_CHARGE_OFF_APPLY;
				} else if (ScfBasConstant.T_FINANCING_TYPE_CREDIT.equals(debtBussInfoVO.getFactType())) {// 信保保理
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_DEBT_CREDIT_CHARGE_OFF_APPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_DEBT_CREDIT_CHARGE_OFF_APPLY;
				} else {
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORINGACCOUNTCANCELAPPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_ACCOUNTCANCEL_APPLY;
				}
			}
			// 保存信息到申请基本信息表，生成appno并返回
			appno = scfApplyService.saveFactoringAppBasicInfo(debtBussInfoVO, businessnoType, workApplyType);
			String custCd = debtBussInfoVO.getCustcdSaller();
			String custName = debtBussInfoVO.getCnameSeller(); // 卖方名称
			// 发起工作流
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", workApplyType);
			paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			paramMap.put(WorkflowConstant.CUST_CD, custCd);
			paramMap.put(WorkflowConstant.CUST_NAME, custName);
			try {
				scfWorkFlowService.startWorkFlow(appno, workApplyType, workApplyType, paramMap);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtil.isStrNotEmpty(appno)) {
			debtBussInfoVO.setAppno(appno);
			// 保存到R_BCP_APPLI_BUSS_INFO【业务申请业务主表】
			String debtId = rBcpAppliBussInfoService.saveDebtBackAppliBussInfo(debtBussInfoVO);
			// // 保存到 R_BCP_APPLI_BUSS_DTL【业务申请业务明细表】
			rBcpAppliBussDtlService.saveDebtBackApplyBussDetail(list, debtBussInfoVO.getAppno(), debtId);

		}
		return appno;
	}

	/***
	 * 核销信息提交
	 */
	@Transactional
	@Override
	public void submitWriteoffRequestInfo(DebtBussInfoVO debtBussInfoVO, List<RBcpDebtBaseInfo> list) throws ScubeBizException {
		//
		// 核销原因
		debtBussInfoVO.setReason(debtBussInfoVO.getRebateReason()); // 核销原因存入到业务申请业务主表
																	// 取的是debtBussInfoVO.getReason()
		String appno = debtBussInfoVO.getAppno();
		if (StringUtil.isEmpty(appno)) {
			throw new ScubeBizException("申请号丢失！", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		// 保存到R_BCP_APPLI_BUSS_INFO【业务申请业务主表】
		String debtId = rBcpAppliBussInfoService.saveDebtBackAppliBussInfo(debtBussInfoVO);
		// // 保存到 R_BCP_APPLI_BUSS_DTL【业务申请业务明细表】
		rBcpAppliBussDtlService.saveDebtBackApplyBussDetail(list, debtBussInfoVO.getAppno(), debtId);
		// 流程流转
		BPbcAppliBaseInfo appliinfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
		try {
			scfWorkFlowService.processTasks(appliinfo, status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 流程审批通过
	 */
	@Transactional
	@Override
	public void doWorkForPass(String appNo) {
		// 根据申请编号获得业务申请信息
		RBcpAppliBussInfo bcpAppliBussInfo = rBcpAppliBussInfoService.findByAppno(appNo);

		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(bcpAppliBussInfo, debtVO);
		debtVO.setTotalAmount(debtVO.getTotalDebtAmount());// 本次核销金额存入数据库totalDebtAmout字段，调用方法前将该字段值赋给totalAmout
		// 根据申请编号获得本次的发票list
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> dtllist = rBcpAppliBussDtlDAO.selectByAppno(appNo);
		List<RBcpDebtBaseInfo> insertDebtList;
		try {
			insertDebtList = new ArrayList<RBcpDebtBaseInfo>();
			if (dtllist != null && dtllist.size() > 0) {
				for (RBcpAppliBussDtl dtl : dtllist) {
					RBcpDebtBaseInfo baseInfo = new RBcpDebtBaseInfo();
					BeanUtils.copyProperties(dtl, baseInfo);
					baseInfo.setId(dtl.getDebtId());
					insertDebtList.add(baseInfo);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			e.printStackTrace();
			throw new ScubeBizException("根据申请编号获得业务申请明细失败！");
		}
		this.factoringChargeOffAddSave(insertDebtList, debtVO);
		// 核销更新池的发票总余额和可融资余额
		scfApplyService.updatePoolRemainAmount(debtVO);

		bNteNoticeBaseService.addDebtCancelNoticeByAppno(debtVO.getAppno());// 通知书回执
		// 由于这里是在回执确认才生成通知书，故多加一步更新通知书状态 add by huangshuidan
		bNteNoticeBaseService.modifyNoticeBaseInfo(debtVO.getAppno(), BNteConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);

		// TODO
		if (StringUtil.isEmpty(debtVO.getFactType())) {
			// 获取合同信息
			BCntDebtInfo tblContDebtInfo = bCntDebtInfoService.findBCntDebtInfoByKey(debtVO.getMastContno());
			if (tblContDebtInfo != null) {
				debtVO.setFactType(tblContDebtInfo.getFactType());
			}

		}
		// 合同有追/无追
		/*
		 * String recoverType =
		 * debtCURDService.getDebtContRecoverType(debtVOCommon.getMastContno(),
		 * debtVOCommon.getCustcdBuyer());
		 * 
		 * if
		 * (SCFConstants.FACT_TYPE_CREDIT_FACT.equals(debtVOCommon.getFactType()
		 * ) // 信保保理 ||
		 * SCFConstants.FACT_TYPE_DOUBLE_FACT.equals(debtVOCommon.getFactType())
		 * // 行内双保理 ||
		 * (SCFConstants.FACT_TYPE_LEASE_FACT.equals(debtVOCommon.getFactType())
		 * && SCFConstants.CREDIT_TYPE_WITHOUT_RECOURSE.equals(recoverType)) //
		 * 租赁保理无追模式 ||
		 * (SCFConstants.FACT_TYPE_INLAND.equals(debtVOCommon.getFactType()) &&
		 * SCFConstants.CREDIT_TYPE_WITHOUT_RECOURSE.equals(recoverType)) //
		 * 国内保理无追模式 ||
		 * (SCFConstants.FACT_TYPE_REVERSE.equals(debtVOCommon.getFactType()) &&
		 * SCFConstants.CREDIT_TYPE_WITHOUT_RECOURSE.equals(recoverType)) //
		 * 反向保理无追模式 ) { // 买方信用限额额度额度处理-释放
		 * CreditLimitOfBuyerService.getInstance().
		 * creditLimitOfBuyerAppliCommonProcess(debtVOCommon.getAppno(),
		 * SCFConstants.CREDIT_TRADE_TYPE_RELEASE,
		 * debtVOCommon.getTotalAmount());
		 * 
		 * }
		 */
		// 已通过审核
		BPbcAppliBaseInfo base = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);

		base.setAppliStatus(WorkflowConstant.APPLI_STATUS_APPROVED);// 申请状态为已通过审核
		base.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);// 申请状态明细已通过审核
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(base);

	}

	public void doWorkForReject(String appNo) {
		// 解锁应收账款单据
		scfApplyService.releaseAppliDebtBaseInfo(appNo);
		// 回退
		BPbcAppliBaseInfo base = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);

		base.setAppliStatus(WorkflowConstant.APPLI_STATUS_GOBACK);// 申请状态为已通过审核
		base.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_GOBACK);// 申请状态明细已通过审核
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(base);

	}

	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub

	}

	/**
	 * 核销列表查询
	 */
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
				map.put("contStatus", conStatus);
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

	/**
	 * 获得应收账款列表
	 */
	public Page findRBcpDebtBaseInfoPageByPage(int pageNo, int pageSize, String key) throws Exception {
		Page p = new Page(pageSize, pageNo, 0);
		List<AppliBussDetailVO> list = new ArrayList<AppliBussDetailVO>();
		List<AppliBussDetailVO> dtlList = new ArrayList<AppliBussDetailVO>();
		try {
			dtlList = rBcpAppliBussDtlService.getTblAppliBussDetail(key, "");
			if (dtlList != null && dtlList.size() > 0) {// //获得付款日期
				Iterator iter = dtlList.iterator();
				while (iter.hasNext()) {
					AppliBussDetailVO applVO = (AppliBussDetailVO) iter.next();
					RBcpDebtBaseInfo debtInfo = new RBcpDebtBaseInfo();
					applVO.setId(applVO.getDebtId());
					if (StringUtil.isStrNotEmpty(applVO.getDebtId())) {
						debtInfo = rBcpDebtBaseInfoService.findRBcpDebtBaseInfoByPrimaryKey(applVO.getDebtId());
					}
					if (debtInfo.getDeadline() != null) { // 付款日期
						applVO.setDeadline(debtInfo.getDeadline());
					}

					list.add(applVO);// bussDetail中的ID与正式表中的ID不一致，DebetNo才是一致
				}
			}

		} catch (Exception e) {// 10009- 条件分页查询条件分页查询应收账款信息失败
			e.printStackTrace();
			log.error("查询失败！");
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10009),
					RBcpErrorConstant.SCF_REC_BCP_10009);
		}
		p.setRecords(list);
		p.setTotalRecord(list.size());
		return p;
	}

	// 任务基本信息
	@Override
	public com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo findBPbcAppliBaseInfoByAppno(String appno, String factType) {
		String process = "";
		if (factType.equals("1")) {
			process = WorkflowConstant.PROCNAME_FACTORING_ACCOUNTCANCEL_APPLY;
		} else {
			process = WorkflowConstant.PROCNAME_FACTORING_POOL_CHARGEOFF_APPLY;
		}
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}

	/**
	 * 核销审批通过
	 * 
	 * @param insertDebtList
	 * @param debtVO
	 * @throws ScubeBizException
	 */
	@Transactional
	public void factoringChargeOffAddSave(List insertDebtList, DebtBussInfoVO debtVO) throws ScubeBizException {
		debtVO.setApplyType(RBcpDebtConstant.APPLY_TYPE_VERIFY);
		debtVO.setAmount(debtVO.getTotalAmount());// 核销金额
		// 归还卖买方关联额度
		debtVO.setReason(debtVO.getRebateReason());
		RBcpDebtBussInfo tblDebtBussInfo = rBcpDebtBussInfoService.debtBussInfoAdd(debtVO);
		tblDebtBussInfo.setAmount(debtVO.getAmount());// 核销金额
		rBcpDebtBaseInfoService.factoringChargeOffAddSave(insertDebtList, tblDebtBussInfo);
	}

	@Override
	public void doWorkForSubmit(String appNo) throws ScubeBizException {
		DebtBussInfoVO debtBussInfoVO = new DebtBussInfoVO();
		debtBussInfoVO.setAppno(appNo);
		DebtBussInfoVO debtVO = queryBaseInfo(debtBussInfoVO);
		List<RBcpDebtBaseInfo> list = new ArrayList<RBcpDebtBaseInfo>();
		try {
			Page page = this.findRBcpDebtBaseInfoPageByPage(1, 10, appNo);
			list = page.getRecords();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.submitWriteoffRequestInfo(debtVO, list);
	}
}

/**
 * 
 */
package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
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
import com.huateng.scf.bas.brp.model.BBrpPrdFactoring;
import com.huateng.scf.bas.brp.service.IBBrpPrdFactoringService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.nrec.bcp.dao.IRBcpDebtInfoDAO;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfo;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.IDisputeRegisterService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtBussInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtPoolService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfoExample;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2017年5月31日下午1:47:12
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2017年5月31日下午1:47:12	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("DisputeRegisterServiceImpl")
public class DisputeRegisterServiceImpl implements IDisputeRegisterService, DealEndFlowService, DealInFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	// 流程申请基本信息
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService iBPbcAppliBaseInfoService;

	// 应收类申请基本信息
	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO rBcpAppliBussInfoDAO;

	@Resource(name = "IRBcpDebtInfoDAO")
	IRBcpDebtInfoDAO rBcpDebtInfoDAO;

	@Resource(name = "NRBcpAppliBussDtlServiceImpl")
	INRBcpAppliBussDtlService nRBcpAppliBussDtlService;

	@Resource(name = "scfWorkFlowService")
	private IScfWorkFlowService scfWorkFlowService;

	@Resource(name = "NRBcpAppliBussInfoServiceImpl")
	INRBcpAppliBussInfoService nRBcpAppliBussInfoService;

	@Resource(name = "BBrpPrdFactoringServiceImpl")
	IBBrpPrdFactoringService bBrpPrdFactoringService;

	@Resource(name = "RBcpDebtInfoServiceImpl")
	IRBcpDebtInfoService rBcpDebtInfoService;

	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bCntBcpInfoService;

	@Resource(name = "NRBcpDebtPoolServiceImpl")
	INRBcpDebtPoolService nRBcpDebtPoolService;

	@Resource(name = "NRBcpDebtBussInfoServiceImpl")
	INRBcpDebtBussInfoService nRBcpDebtBussInfoService;

	@Resource(name = "NRBcpDebtBussDtlServiceImpl")
	INRBcpDebtBussDtlService nRBcpDebtBussDtlService;

	/*
	 * 
	 */
	@Override
	@Transactional
	public void doWorkForSubmit(String appNo) throws ScubeBizException {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void doWorkForPass(String appNo) {
		// 判断是否存在特殊调用路劲，存在则执行特殊路径，不存在则继续执行下列方法
		String invokPhase = ScfBasConstant.INVOKE_PHASE_DISPUTE_REGISTER;// 商纠登记阶段
		String callerpath = "DisputeRegisterServiceImpl";
		boolean flag = scfWorkFlowService.invokAnotherClasspath(appNo, invokPhase, callerpath);
		if (flag) {
			return;
		}
		// 1.申请基本信息修改（数据准备）
		RBcpAppliBussInfo rBcpAppliBussInfo1 = nRBcpAppliBussInfoService.findBcpAppliBussInfoByAppno(appNo);
		DebtBussInfoVO debtVODal = new DebtBussInfoVO();
		com.huateng.authority.entity.BctlVO globalInfo = ContextHolder.getOrgInfo();
		debtVODal.setInpoolDate(ScfDateUtil.formatDate(new Date()));
		debtVODal.setTotalBillsAmount(rBcpAppliBussInfo1.getAmount());
		debtVODal.setTotalNum(rBcpAppliBussInfo1.getDebtNum());
		debtVODal.setAppno(appNo);
		debtVODal.setEndDate(rBcpAppliBussInfo1.getEndDate());
		debtVODal.setDisputeCount(rBcpAppliBussInfo1.getDebtNum());// 争议份数
		debtVODal.setDisputeAmount(rBcpAppliBussInfo1.getAmount());// 争议总金额
		debtVODal.setAmount(rBcpAppliBussInfo1.getAmount());// 争议总金额
		debtVODal.setInsertDate(ScfDateUtil.formatDate(new Date()));
		debtVODal.setFactType(rBcpAppliBussInfo1.getFactType());
		debtVODal.setMastContno(rBcpAppliBussInfo1.getMastContno());
		debtVODal.setCustcdSaller(rBcpAppliBussInfo1.getCustcdSaller());
		debtVODal.setCustcdBuyer(rBcpAppliBussInfo1.getCustcdBuyer());
		debtVODal.setCurcd(rBcpAppliBussInfo1.getCurcd());
		debtVODal.setBrcode(globalInfo.getBrNo());
		debtVODal.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
		debtVODal.setStartDate(ScfDateUtil.formatDate(new Date()));
		debtVODal.setProductId(rBcpAppliBussInfo1.getBussType());
		debtVODal.setBussType(rBcpAppliBussInfo1.getBussType());
		debtVODal.setDebtContno(rBcpAppliBussInfo1.getMastContno());
		//BBrpPrdFactoring tblProductFactoring = bBrpPrdFactoringService.findBBrpPrdFactoringByKey(debtVODal.getBussType());

		// 2.单据操作（入池的单据出池，商纠，对应明细。）
		List<RBcpAppliBussDtl> rBcpAppliBussDtlList = nRBcpAppliBussDtlService.queryRBcpAppliBussDtlByAppno(appNo);
		if (rBcpAppliBussDtlList == null || rBcpAppliBussDtlList.size() == 0) {
			log.debug("根据申请号查询对应商纠登记单据，没查到对应申请明细信息数据！");
			throw new ScubeBizException("商纠登记失败！");
		}
		for (RBcpAppliBussDtl rBcpAppliBussDtl : rBcpAppliBussDtlList) {
			// 2.1单据明细信息新增
			RBcpDebtInfoVO tblDebtBaseInfo = rBcpDebtInfoService.queryRBcpDebtInfoById(rBcpAppliBussDtl.getDebtId());
			RBcpDebtBussDtl tblDebtBussDetail = new RBcpDebtBussDtl();
			BeanUtils.copyProperties(tblDebtBaseInfo, tblDebtBussDetail);
			tblDebtBussDetail.setDebtId(tblDebtBaseInfo.getId());
			tblDebtBussDetail.setAppno(appNo);
			tblDebtBussDetail.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
			tblDebtBussDetail.setBrcode(ContextHolder.getOrgInfo().getBrNo());
			tblDebtBussDetail.setIssueFlag(DebtConstants.ISSUE_FLAG_TPYE_TRUE);// 有
			tblDebtBussDetail.setIssueReason(rBcpAppliBussDtl.getIssueReason());
			tblDebtBussDetail.setReason(null);// 清空之前可能存在的争议解决方式
			tblDebtBussDetail.setMemo(null);
			tblDebtBussDetail.setOtherReason(rBcpAppliBussDtl.getOtherReason());
			tblDebtBussDetail.setInsertDate(ScfDateUtil.formatDate(new Date()));
			tblDebtBussDetail.setCommonDate(ScfDateUtil.formatDate(new Date()));
			tblDebtBussDetail.setApplyType(RBcpDebtConstant.APPLY_TYPE_ISSUE_SET);// 商纠登记申请
			tblDebtBussDetail.setMoney(rBcpAppliBussDtl.getMoney());// 争议金额
			nRBcpDebtBussDtlService.addRBcpDebtBussDtl(tblDebtBussDetail);
			// 如果是入池的单据，则需要新增对应的出池历程明细
			if (StringUtils.isNotEmpty(tblDebtBaseInfo.getPoolFlag()) && tblDebtBaseInfo.getPoolFlag().equals(DebtConstants.POOL_FLAG_IN_POOL)) {
				tblDebtBussDetail.setApplyType(RBcpDebtConstant.APPLY_TYPE_OUT_POOL);// 出池申请
				tblDebtBussDetail.setMoney(tblDebtBaseInfo.getRemainingAmount());// 出池金额
				nRBcpDebtBussDtlService.addRBcpDebtBussDtl(tblDebtBussDetail);

				tblDebtBaseInfo.setPoolFlag(DebtConstants.POOL_FLAG_OUT_POOL);// 出池标识，用于下面的单据修改。
			}
			// 2.2单据信息修改
			tblDebtBaseInfo.setIssueFlag(DebtConstants.ISSUE_FLAG_TRUE);// DebtConstants.ISSUE_FLAG_TRUE
			tblDebtBaseInfo.setIssueReason(rBcpAppliBussDtl.getIssueReason());
			tblDebtBaseInfo.setReason(null);// 防止存在这个单据中存在之前的争议解决方式，这里应该清空
			tblDebtBaseInfo.setOtherReason(rBcpAppliBussDtl.getOtherReason());
			tblDebtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);// SCFConstants.UNLOCKED
			tblDebtBaseInfo.setLockAppno("");
			// 商纠次数加一
			BigDecimal oldIssueTimes = tblDebtBaseInfo.getIssueTimes() == null ? new BigDecimal(0) : tblDebtBaseInfo.getIssueTimes();
			tblDebtBaseInfo.setIssueTimes(oldIssueTimes.add(new BigDecimal(1)));
			rBcpDebtInfoService.updateRBcpDebtInfo(tblDebtBaseInfo);
		}
		// 3.业务主表流水号新增（有出池，新增出池业务信息。）
		// 3.1新增对应商纠登记信息
		debtVODal.setApplyType(DebtConstants.APPLY_TYPE_ISSUE_SET);//商纠设定
		nRBcpDebtBussInfoService.debtBussInfoAdd(debtVODal);
		
		//只要发起业务申请并为池融资，必须对池信息实时动态统计-mengjiajia
		//此处不需新增业务信息-mengjiajia
		BCntBcpInfoVO baseInfo = bCntBcpInfoService.queryBCntBcpInfoByMastContno(rBcpAppliBussInfo1.getMastContno());
		if(DebtConstants.FINANCING_TYPE_POOL.equals(baseInfo.getFinancingType()))
		{//是池融资
			List<RBcpDebtPool> tblDebtPoolList = nRBcpDebtPoolService.queryDebtPollByMastContno(rBcpAppliBussInfo1.getMastContno(), null);
			RBcpDebtPool debtPool = new RBcpDebtPool(); 
			if (tblDebtPoolList != null && tblDebtPoolList.size() == 1) {
				debtPool = tblDebtPoolList.get(0);
				nRBcpDebtPoolService.updatePoolRemainAmount(debtPool,baseInfo,ScfBasConstant.INVOKE_PHASE_DISPUTE_REGISTER);
			}else{
				throw new ScubeBizException("商纠登记，应收账款出池操作失败！");
			}
		}
		
		/*RBcpAppliBussInfo rBcpAppliBussInfo2 = nRBcpAppliBussInfoService.findBcpAppliBussInfoByAppno(appNo);

		RBcpDebtInfoExample rBcpDebtInfoExample = new RBcpDebtInfoExample();
		RBcpDebtInfoExample.Criteria criteria = rBcpDebtInfoExample.createCriteria();
		criteria.andLockAppnoEqualTo(appNo);
		List<RBcpDebtInfo> rBcpDebtInfoList = rBcpDebtInfoDAO.selectByExample(rBcpDebtInfoExample);

		this.disputeInvoiceSetSubmitApp(rBcpDebtInfoList, debtVODal);// 最关键的一步
*/
		//全部业务逻辑成功后，业务申请信息状态更新
		iBPbcAppliBaseInfoService.editAppliBaseStatusByFlag(appNo, "pass");
	}

	@Transactional
	public void disputeInvoiceSetSubmitApp(List<RBcpDebtInfo> insertDebtList, DebtBussInfoVO debtVO) throws ScubeBizException {
		BBrpPrdFactoring tblProductFactoring = null;
		if (debtVO.getBussType() != null) {
			tblProductFactoring = bBrpPrdFactoringService.findBBrpPrdFactoringByKey(debtVO.getBussType());
		}
		// 单据操作（入池的单据出池，商纠，对应明细。）
		// 业务流水表（池的需要有对应的出池业务信息）
		// 池信息对应金额修改

		// 1.出池操作
		if (tblProductFactoring != null) {
			if (com.huateng.scf.bas.sys.constant.DebtConstants.FINANCING_TYPE_POOL.equals(tblProductFactoring.getFinancingType())) {// 池融资
				debtVO.setApplyType(DebtConstants.APPLY_TYPE_OUT_POOL);// 出池
				// 这里要筛选出在池中的数据进行出池操作，有些已经出池的单据就不能再做出池操作。
				// 池信息修改，添加出池流水信息--主表
				updateOutpoolInfo(insertDebtList, debtVO);
				// 明细表修改
				debtVO.setPoolFlag(com.huateng.scf.bas.sys.constant.DebtConstants.POOL_FLAG_OUT_POOL);// 出池
				// 添加出池流水信息--详细信息表（里面已经对未入池的单据做了剔除工作。）
				nRBcpDebtBussDtlService.saveDebtOutPoolInfoDtl(insertDebtList, debtVO);
			}
			// 2.商纠设定操作
			debtVO.setApplyType(DebtConstants.APPLY_TYPE_ISSUE_SET);// 商纠设定
			List<RBcpAppliBussDtl> insertDebtList2 = nRBcpAppliBussDtlService.queryRBcpAppliBussDtlByAppno(debtVO.getAppno());
			// 添加业务流水表主表(争议金额已在前面添加了)
			RBcpDebtBussInfo tblDebtBussInfo = nRBcpDebtBussInfoService.debtBussInfoAdd(debtVO);
			// 添加流水详细信息表//更新发票表
			nRBcpDebtBussDtlService.disputeInvoiceSetSubmit(insertDebtList2, tblDebtBussInfo, tblProductFactoring.getFinancingType());
		}
	}

	/**
	 * 保存此次商纠登记出池信息
	 * 
	 * @param insertDebtList
	 * @param debtVO
	 * @author lihao
	 * @date 2017年6月30日下午2:21:06
	 */
	@Transactional
	public void updateOutpoolInfo(List<RBcpDebtInfo> insertDebtList, DebtBussInfoVO debtVO) {
		// 合同信息
		BCntBcpInfoVO debtContVO = bCntBcpInfoService.queryBCntBcpInfoByMastContno(debtVO.getMastContno());
		if (debtContVO == null || debtContVO.getLoanPercent() == null) {
			throw new ScubeBizException("合同信息丢失，出池操作失败！");
		}
		BigDecimal loanPercent = debtContVO.getLoanPercent();
		// 出池信息准备
		BigDecimal totalOutPoolDebtAmount = BigDecimal.ZERO;// 本次出池的单据有效金额总和
		BigDecimal outPoolAmount = BigDecimal.ZERO;// 本次出池单据应收账款总额
		Integer outPoolNum = 0;// 本次出池单据数量
		for (RBcpDebtInfo rBcpDebtInfo : insertDebtList) {
			// 只有为入池状态的单据才能参加出池操作,而且这里的出池操作也是应该是计算应收账款余额，不是单据的有效金额
			if (rBcpDebtInfo.getPoolFlag().equals("1")) {
				totalOutPoolDebtAmount = totalOutPoolDebtAmount.add(rBcpDebtInfo.getBillsAmount());
				outPoolAmount = outPoolAmount.add(rBcpDebtInfo.getRemainingAmount());
				outPoolNum = outPoolNum + 1;
			}
		}
		// 出池操作
		List<RBcpDebtPool> tblDebtPoolList = nRBcpDebtPoolService.queryDebtPollByMastContno(debtVO.getMastContno(), debtVO.getCustcdSaller());
		if (tblDebtPoolList != null && tblDebtPoolList.size() == 1) {
			RBcpDebtPool tblDebtPool = tblDebtPoolList.get(0);
			// 发票池金额
			BigDecimal totalDebtAmount_P = tblDebtPool.getTotalDebtAmount() == null ? new BigDecimal("0") : tblDebtPool.getTotalDebtAmount();
			// 池发票余额
			BigDecimal totalDebtRemainAmount_p = tblDebtPool.getTotalDebtRemainAmount() == null ? new BigDecimal("0")
					: tblDebtPool.getTotalDebtRemainAmount();
			// 发票池份数
			BigDecimal debtNum_P = tblDebtPool.getDebtNum() == null ? BigDecimal.ZERO : tblDebtPool.getDebtNum();
			// 池可融资余额
			BigDecimal poolUseableAmount_p = tblDebtPool.getPoolUseableAmount() == null ? new BigDecimal("0") : tblDebtPool.getPoolUseableAmount();
			tblDebtPool.setTotalDebtAmount(totalDebtAmount_P.subtract(totalOutPoolDebtAmount));
			totalDebtRemainAmount_p = totalDebtRemainAmount_p.subtract(outPoolAmount);
			tblDebtPool.setTotalDebtRemainAmount(totalDebtRemainAmount_p);
			tblDebtPool.setDebtNum(debtNum_P.subtract(new BigDecimal(outPoolNum)));
			// 最重要的池可融资余额
			loanPercent = loanPercent == null ? new BigDecimal("0") : loanPercent;
			tblDebtPool.setPoolUseableAmount(
					poolUseableAmount_p.subtract(outPoolAmount.multiply(loanPercent).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP)));
			// 插入日期
			tblDebtPool.setInsertDate(ScfDateUtil.formatDate(new Date()));
			try {
				nRBcpDebtPoolService.updateRBcpDebtPool(tblDebtPool);
			} catch (Exception e) {
				throw new ScubeBizException("商纠登记，应收账款出池操作失败！");
			}

		}
		// 出池业务信息保存
		DebtBussInfoVO debtBussInfoVO2 = new DebtBussInfoVO();
		BeanUtils.copyProperties(debtVO, debtBussInfoVO2);
		debtBussInfoVO2.setTotalBillsAmount(outPoolAmount);
		debtBussInfoVO2.setTotalNum(outPoolNum);
		nRBcpDebtBussInfoService.saveDebtOutPoolInfo(debtBussInfoVO2, DebtConstants.APPLY_TYPE_OUT_POOL);// 出池
	}

	// 审批否决
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

	/*
	 * 页面保存按钮
	 */
	@Override
	@Transactional
	public String saveOrUpdateDisputeRegisterInfo(RBcpAppliBussInfo rBcpAppliBussInfo, ArrayList<RBcpAppliBussDtl> ds) throws ScubeBizException {
		// 1.前台数据校验
		if (rBcpAppliBussInfo == null) {// SCF_REC_BCP_10005,前台所传数据无效
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		if (ds == null || ds.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		String appno;
		if (StringUtil.isEmpty(rBcpAppliBussInfo.getAppno())) {
			String businessnoType = "";
			String workApplyType = "";
			if (ScfBasConstant.FACT_TYPE_REVERSE.equals(rBcpAppliBussInfo.getFactType())
					|| ScfBasConstant.FACT_TYPE_INLAND.equals(rBcpAppliBussInfo.getFactType())
					|| ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(rBcpAppliBussInfo.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEINVOICESETAPPLY;// 3217
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_INVOICE_SET_APPLY;

			} else if (ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(rBcpAppliBussInfo.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEDOUBLEINVOICESETAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_DOUBLE_INVOICE_SET_APPLY;

			} else if (ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(rBcpAppliBussInfo.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTECREDITINVOICESETAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_CREDIT_INVOICE_SET_APPLY;

			} else if (ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(rBcpAppliBussInfo.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTELEASEINVOICESETAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_LEASE_INVOICE_SET_APPLY;

			} else if (ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(rBcpAppliBussInfo.getFactType())
					|| ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(rBcpAppliBussInfo.getFactType())
					|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(rBcpAppliBussInfo.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEPOOLINVOICESETAPPLY;// 3233
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_POOL_INVOICE_SET_APPLY;
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
			nRBcpAppliBussDtlService.addRBcpAppliBussDtlAndLockedDebt(appno, ds);

		} else {
			appno = rBcpAppliBussInfo.getAppno();
			updateDisputeRegisterInfo(rBcpAppliBussInfo, ds);
		}
		return appno;
	}

	/*
	 * 保存修改方法
	 */
	@Override
	@Transactional
	public void updateDisputeRegisterInfo(RBcpAppliBussInfo rBcpAppliBussInfo, ArrayList<RBcpAppliBussDtl> ds) throws ScubeBizException {
		if (rBcpAppliBussInfo == null || StringUtils.isEmpty(rBcpAppliBussInfo.getAppno()) || ds == null || ds.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 1.保存 应收账款业务申请流水基本信息表 R_BCP_APPLI_BUSS_INFO(这里实际就保存了几个页面上可能修改的字段。)
		RBcpAppliBussInfoExample rBcpAppliBussInfoExample = new RBcpAppliBussInfoExample();
		RBcpAppliBussInfoExample.Criteria criteria = rBcpAppliBussInfoExample.createCriteria();
		criteria.andAppnoEqualTo(rBcpAppliBussInfo.getAppno());
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo> rBcpAppliBussInfoList = rBcpAppliBussInfoDAO
				.selectByExample(rBcpAppliBussInfoExample);
		if (rBcpAppliBussInfoList == null || rBcpAppliBussInfoList.size() != 1) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo rBcpAppliBussInfo2 = rBcpAppliBussInfoList.get(0);
		rBcpAppliBussInfo2.setDebtNum(rBcpAppliBussInfo.getDebtNum());
		rBcpAppliBussInfo2.setAmount(rBcpAppliBussInfo.getAmount());
		rBcpAppliBussInfo2.setMemo(rBcpAppliBussInfo.getMemo());
		rBcpAppliBussInfo2.setLastUptTime(new Date());// 最后更新时间
		try {
			rBcpAppliBussInfoDAO.updateByExample(rBcpAppliBussInfo2, rBcpAppliBussInfoExample);
		} catch (Exception e) {// 申请基本信息修改失败
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}
		// 2.先删除原有申请明细信息，解锁单据，再新增明细信息，锁定单据信息
		nRBcpAppliBussDtlService.deleteRBcpAppliBussDtlAndReleaseDebt(rBcpAppliBussInfo.getAppno());
		nRBcpAppliBussDtlService.addRBcpAppliBussDtlAndLockedDebt(rBcpAppliBussInfo.getAppno(), ds);
		// 3.申请基本信息修改
		BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(rBcpAppliBussInfo.getAppno());
		if (bPbcAppliBaseInfo != null) {
			bPbcAppliBaseInfo.setAmt(rBcpAppliBussInfo.getAmount());
			iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		} else {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10007), RBcpErrorConstant.SCF_REC_BCP_10007);

		}
	}

	/*
	 * 申请页面提交按钮(发起流程)
	 */
	@Override
	@Transactional
	public void submitDisputeRegisterInfo(RBcpAppliBussInfo rBcpAppliBussInfo, ArrayList<RBcpAppliBussDtl> ds) throws ScubeBizException {
		if (rBcpAppliBussInfo == null) {// SCF_REC_BCP_10005,前台所传数据无效
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		if (ds == null || ds.size() == 0) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}

		// 1.保存页面数据
		updateDisputeRegisterInfo(rBcpAppliBussInfo, ds);

		BPbcAppliBaseInfo bPbcAppliBaseInfo1 = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(rBcpAppliBussInfo.getAppno());
		if (bPbcAppliBaseInfo1 == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10028), RBcpErrorConstant.SCF_REC_BCP_10028);
		}

		// 2.如果是正常提交
		if (StringUtils.isEmpty(bPbcAppliBaseInfo1.getPiid())) {
			// 2.1申请基本信息修改状态为已提交
			bPbcAppliBaseInfo1.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);// 已提交(未审批)
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
		}
		// 3.如果是退回提交
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

	/*
	 * 首页提交按钮
	 */
	@Override
	@Transactional
	public void submitDisputeRegisterInfoApply(String appno) throws ScubeBizException {
		// 1.数据准备
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
		// 2.如果是正常提交
		if (StringUtils.isEmpty(bPbcAppliBaseInfo1.getPiid())) {
			// 2.1申请基本信息修改状态为已提交
			bPbcAppliBaseInfo1.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);// 已提交(未审批)
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
		}
		// 3.如果是退回提交
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
				|| ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType)) {// 应收账款
			process = WorkflowConstant.PROCNAME_DISPUTE_INVOICE_SET_APPLY;
		} else if (ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(factType)) {// 国内双保理
			process = WorkflowConstant.PROCNAME_DISPUTE_DOUBLE_INVOICE_SET_APPLY;
		} else if (ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(factType)) {// 信保保理
			process = WorkflowConstant.PROCNAME_DISPUTE_CREDIT_INVOICE_SET_APPLY;
		} else if (ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType)) {// 租赁保理
			process = WorkflowConstant.PROCNAME_DISPUTE_LEASE_INVOICE_SET_APPLY;
		} else if (ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType) || ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
				|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType)) {// 应收账款池
			process = WorkflowConstant.PROCNAME_DISPUTE_POOL_INVOICE_SET_APPLY;
		}
		process = "N-" + process;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}
}

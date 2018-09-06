package com.huateng.scf.rec.bcp.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
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
import com.huateng.scf.bas.brp.model.BBrpPrdFactoring;
import com.huateng.scf.bas.brp.service.IBBrpPrdFactoringService;
import com.huateng.scf.bas.cnt.constant.BCntBizConstant;
import com.huateng.scf.bas.cnt.dao.model.DebtContVO;
import com.huateng.scf.bas.cnt.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.model.BCntDebtInfoVO;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.bas.cnt.service.IBCntDebtExtInfoService;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfGlobalInfo;
import com.huateng.scf.bas.common.startup.ScfGlobalInfoUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtPoolDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfoExample;
import com.huateng.scf.rec.bcp.model.AppliBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.FactoringContVO;
import com.huateng.scf.rec.bcp.model.ProcessModel;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scf.rec.bcp.model.RBcpDebtQueryVO;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliRepaymentService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtDisputRegService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("RBcpDebtDisputRegServiceImpl")
public class RBcpDebtDisputRegServiceImpl implements IRBcpDebtDisputRegService, DealEndFlowService, DealInFlowService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "RBcpDebtBaseInfoServiceImpl")
	IRBcpDebtBaseInfoService RBcpDebtBaseInfo;

	@Resource(name = "RBcpAppliBussInfoServiceImpl")
	IRBcpAppliBussInfoService rBcpAppliBussInfoService;

	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService iBPbcAppliBaseInfoService;

	@Autowired
	IProcessService processService;

	@Resource(name = "RBcpDebtBussInfoServiceImpl")
	IRBcpDebtBussInfoService rBcpDebtBussInfoService;

	@Resource(name = "BCntDebtInfoServiceImpl")
	IBCntDebtInfoService bCntDebtInfoService;

	@Resource(name = "BBrpPrdFactoringServiceImpl")
	IBBrpPrdFactoringService bBrpPrdFactoringService;

	@Resource(name = "RBcpDebtBussDtlServiceImpl")
	IRBcpDebtBussDtlService rBcpDebtBussDtlService;

	@Resource(name = "RBcpAppliBussDtlServiceImpl")
	IRBcpAppliBussDtlService irbcpAppliBussDtlService;

	@Resource(name = "BCntDebtExtInfoServiceImpl")
	IBCntDebtExtInfoService bCntDebtExtInfoService;

	@Resource(name = "RBcpDebtBaseInfoServiceImpl")
	IRBcpDebtBaseInfoService iRBcpDebtBaseInfoService;

	@Resource(name = "RBcpAppliRepaymentServiceImpl")
	IRBcpAppliRepaymentService rBcpAppliRepaymentService;

	@Resource(name = "rBcpDebtPoolService")
	IRBcpDebtPoolService rBcpDebtPoolService;

	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	// 转让明细信息
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rBcpAppliBussDtlDAO;
	@Autowired
	ITaskService taskService;

	@Resource(name = "RBcpDebtPoolDAO")
	IRBcpDebtPoolDAO poolDao;

	@Resource(name = "AmountServiceImpl")
	com.huateng.scf.bas.pbc.service.IAmountService factService;

	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO rBcpAppliBussInfoDAO;

	// 应收账款基本信息
	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO iRBcpDebtBaseInfoDAO;

	@Override
	public Page queryBCntDebtInfoListByPage(int pageNo, int pageSize, MastContQryVO mastContQryVO) throws ScubeBizException {
		Page p = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();

		if (null != mastContQryVO) {
			String cname = mastContQryVO.getCname();// 卖方名称
			String buyerName = mastContQryVO.getBuyerName();// 买方名称
			String debtContno = mastContQryVO.getMastContCode();// 主合同号
			String conStatus = mastContQryVO.getConStatus();// 合同状态
			String factType = mastContQryVO.getFactType();// 融资模式
			// String financingType = mastContQryVO.getFinancingType();
			String roleType = mastContQryVO.getFlag();// 客户类型
			String mgrno = "";
			List<String> factTypes = new ArrayList<String>();
			// 应收账款融资
			if (factType.equals(BCntBizConstant.T_FINANCING_TYPE_INVOICE)) {
				factTypes.add(BCntBizConstant.FACT_TYPE_INLAND); //// 国内保理
				factTypes.add(BCntBizConstant.FACT_TYPE_REVERSE); //// 反向保理
				factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_PLEDGE); //// 应收账款质押
			}

			map.put("factTypes", factTypes);

			ScfGlobalInfo gb = ScfGlobalInfoUtil.getScfGlobalInfo();
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
				mgrno = gb.getTlrNo();
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

		}
		p.setRecords(bCntDebtInfoService.findBCntDebtInfoByPage(map, p));

		return p;
	}

	/*
	 * (non-Javadoc) 查询关联的发票信息 通过R_BCP_DEBT_BASE_INFO -- rBcpDebtBaseInfo
	 */
	@Override
	public Page getInvoiceListBySallerBuyerAndContno(RBcpDebtQueryVO commonQueryVO) {
		RBcpDebtBaseInfo rBcpDebtBaseInfo = new RBcpDebtBaseInfo();
		BeanUtils.copyProperties(commonQueryVO, rBcpDebtBaseInfo);

		int pageNo = 1;
		int pageSize = 10;
		Page page = iRBcpDebtBaseInfoService.findInovListByCommonQueryVO(pageNo, pageSize, rBcpDebtBaseInfo);
		return page;
	}

	/**
	 * 保存操作 保存此合同项下指定买家的相关应收账款发票
	 * 
	 * @param debtVO
	 * @param insertList
	 * @param in_appno
	 */
	@Transactional
	@Override
	public String disputeInvoiceSetApplySaveUpdate(DebtBussInfoVO debtVO, List<DebtBillsInfoVO> insertList, ProcessModel processModel) {
		String appno = debtVO.getAppno();
		// 商纠申请保存
		if (StringUtils.isEmpty(appno)) {
			String businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEINVOICESETAPPLY;

			// PROCNAME_DISPUTE_INVOICE_SET_APPLY = "DisputeInvoiceSetApply"
			// FACT_TYPE_INLAND 国内保理
			String workApplyType = processModel.getModelId();
			// if
			// (BCntBizConstant.FACT_TYPE_REVERSE.equals(debtVO.getFactType())
			// || BCntBizConstant.FACT_TYPE_INLAND.equals(debtVO.getFactType())
			// ||
			// BCntBizConstant.FACT_TYPE_DEBT_PLEDGE.equals(debtVO.getFactType()))
			// {
			// businessnoType =
			// WorkflowConstant.APPLI_TYPE_DISPUTEINVOICESETAPPLY;
			// workApplyType =
			// WorkflowConstant.PROCNAME_DISPUTE_INVOICE_SET_APPLY;
			//
			// } else if
			// (BCntBizConstant.FACT_TYPE_DOUBLE_FACT.equals(debtVO.getFactType()))
			// {
			// businessnoType =
			// WorkflowConstant.APPLI_TYPE_DISPUTEDOUBLEINVOICESETAPPLY;
			// workApplyType =
			// WorkflowConstant.PROCNAME_DISPUTE_DOUBLE_INVOICE_SET_APPLY;
			//
			// } else if
			// (BCntBizConstant.FACT_TYPE_CREDIT_FACT.equals(debtVO.getFactType()))
			// {
			// businessnoType =
			// WorkflowConstant.APPLI_TYPE_DISPUTECREDITINVOICESETAPPLY;
			// workApplyType =
			// WorkflowConstant.PROCNAME_DISPUTE_CREDIT_INVOICE_SET_APPLY;
			//
			// } else if
			// (BCntBizConstant.FACT_TYPE_LEASE_FACT.equals(debtVO.getFactType()))
			// {
			// businessnoType =
			// WorkflowConstant.APPLI_TYPE_DISPUTELEASEINVOICESETAPPLY;
			// workApplyType =
			// WorkflowConstant.PROCNAME_DISPUTE_LEASE_INVOICE_SET_APPLY;
			//
			// } else if
			// (BCntBizConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(debtVO.getFactType())
			// ||
			// BCntBizConstant.FACT_TYPE_DEBT_POOL.equals(debtVO.getFactType())
			// ||
			// BCntBizConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(debtVO.getFactType()))
			// {
			// businessnoType =
			// WorkflowConstant.APPLI_TYPE_DISPUTEPOOLINVOICESETAPPLY;
			// workApplyType =
			// WorkflowConstant.PROCNAME_DISPUTE_POOL_INVOICE_SET_APPLY;
			// }

			// 保存申请基本信息 B_PBC_APPLI_BASE_INFO
			appno = iBPbcAppliBaseInfoService.saveBillsVendorAppliBaseInfo(debtVO, businessnoType, workApplyType);

			String processId = "";
			debtVO.setAppno(appno);
			try {// 2.发起流程
					// processModel.setBizId(appno);
					// processModel.getBizData()[0] = appno;
					// ProcessEntity processEntity =
					// processService.startProcess(processModel.getModelId(),
					// processModel.getProcessName(), processModel.getNodeId(),
					// processModel.getStartedUserId(),
					// processModel.getBizId(), processModel.getBizData());
					// processId = processEntity.getProcessId();
					// String custCd=debtVO.getCustcd();
					// String custName=debtVO.getCnameBuyer(); //买方名称

				String[] bizData = processModel.getBizData();
				String custCd = bizData[1];
				String custName = bizData[2]; // 买方名称

				String modelId = processModel.getModelId();
				String NodeId = processModel.getNodeId();
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("modelId", modelId);
				map.put("NodeId", NodeId);
				map.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
				map.put(WorkflowConstant.CUST_CD, custCd);
				map.put(WorkflowConstant.CUST_NAME, custName);
				// ProcessEntity processEntity =
				// scfWorkFlowService.commonStartFlow(appno, workApplyType,
				// workApplyType,map);
				ProcessEntity processEntity = scfWorkFlowService.startWorkFlow(appno, workApplyType, workApplyType, map);
				processId = processEntity.getProcessId();

			} catch (Exception e) {
				log.error("" + e);
				throw new ScubeBizException("新增应收账款申请转让信息,发起流程失败！");
			}

			BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			bPbcAppliBaseInfo.setPiid(processId);
			iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}

		if (StringUtils.isNotEmpty(appno)) {
			debtVO.setAppno(appno);
			// 保存 应收账款业务申请流水基本信息表 R_BCP_APPLI_BUSS_INFO
			rBcpAppliBussInfoService.saveOrUpdateDebtAppliBussInfo(debtVO);// 更新申请业务信息表
			// 保存 应收账款融资业务申请流水明细表 R_BCP_APPLI_BUSS_DTL
			irbcpAppliBussDtlService.saveDebtPressingBackToModifyBussDetails(insertList, debtVO.getAppno());
		}

		return appno;

	}

	/**
	 * DisputeInvoiceSetApplyWriteSubmitUpdate 商业纠纷提交
	 * 
	 * @param debtVO
	 * @param insertList
	 * @param in_appno
	 */
	@Transactional
	@Override
	public void disputeInvoiceSetApplyWriteSubmitUpdate(DebtBussInfoVO debtVO, List<DebtBillsInfoVO> insertList) throws ScubeBizException {
		// 保存业务申请表
		rBcpAppliBussInfoService.saveOrUpdateDebtAppliBussInfo(debtVO);// 保存申请业务信息表
		// 保存详细信息表
		irbcpAppliBussDtlService.saveDebtPressingBackToModifyBussDetails(insertList, debtVO.getAppno());

		try {
			submitSignal(debtVO, "成功提交");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 商业纠纷审批通过，提交
	 * 
	 * @param debtVO
	 * @param insertList
	 * @param in_appno
	 */
	@Transactional
	@Override
	public void disputeInvoiceSetApplyReceiptUpdate(DebtBussInfoVO debtVO, List<RBcpAppliBussDtl> insertList, String in_appno) {

		// 更新到正式数据表中
		List<RBcpAppliBussDtl> insertDebtList = new ArrayList<RBcpAppliBussDtl>();

		Iterator<RBcpAppliBussDtl> iter = insertList.iterator();
		while (iter.hasNext()) {
			RBcpAppliBussDtl invoiceVO = (RBcpAppliBussDtl) iter.next();
			RBcpAppliBussDtl invoiceVODal = new RBcpAppliBussDtl();
			BeanUtils.copyProperties(invoiceVO, invoiceVODal);
			invoiceVODal.setId(invoiceVODal.getDebtId());
			insertDebtList.add(invoiceVODal);
		}
		// 商纠设定

		BBrpPrdFactoring tblProductFactoring = null;
		if (debtVO.getBussType() != null) {
			tblProductFactoring = bBrpPrdFactoringService.findBBrpPrdFactoringByKey(debtVO.getBussType());
		}

		if (tblProductFactoring != null) {
			// 添加业务流水表主表
			BigDecimal amount = new BigDecimal(0);
			BigDecimal totAmount = new BigDecimal(0);
			if (insertList != null && insertList.size() > 0) {
				Iterator ite = insertList.iterator();
				while (ite.hasNext()) {
					// DebtBillsInfoVO disVO =(DebtBillsInfoVO)ite.next();
					RBcpAppliBussDtl disVO = (RBcpAppliBussDtl) ite.next();
					if (disVO.getMoney() != null) {
						amount = amount.add(disVO.getMoney());
					}
					if (disVO.getBillsAmountView() != null) {
						totAmount = totAmount.add(disVO.getBillsAmountView());
					}
				}
				debtVO.setAmount(amount);// 争议总金额
				debtVO.setTotalBillsAmount(totAmount);// 票面总金额
			}
			debtVO.setAppno(in_appno);
			RBcpDebtBussInfo tblDebtBussInfo = rBcpDebtBussInfoService.debtBussInfoAdd(debtVO);
			// 添加流水详细信息表//更新发票表
			rBcpDebtBussDtlService.disputeInvoiceSetSubmit(insertList, tblDebtBussInfo, tblProductFactoring.getFinancingType());
		}
		this.disputeInvoiceSetSubmitApp(insertDebtList, debtVO);
	}

	@Override
	public DebtBussInfoVO convertToDebtBussInfoVO(BCntDebtInfo bCntDebtInfo) {
		DebtBussInfoVO debtBussInfoVO = new DebtBussInfoVO();
		RBcpDebtBussInfo rBcpDebtBussInfo = new RBcpDebtBussInfo();
		rBcpDebtBussInfo.setMastContno(bCntDebtInfo.getDebtContno());
		RBcpDebtBussInfo rBcpDebtBussInfoNew = rBcpDebtBussInfoService.findRBcpDebtBussInfoByKey(rBcpDebtBussInfo);
		BeanUtils.copyProperties(rBcpDebtBussInfoNew, debtBussInfoVO);
		return debtBussInfoVO;
	}

	public BCntDebtInfoVO queuyUnTakeTaskDetailPage(String appno, String buyerCustcd) {
		String mastContno_Q = ""; // 内部合同号
		String custcdSaller_Q = ""; // 卖方客户号
		String custcdBuyer_Q = ""; // 买方客户号

		BCntDebtInfoVO bCntDebtInfoVO = iBPbcAppliBaseInfoService.queuyBCntDebtInfoVOByAppno(appno, buyerCustcd);
		return bCntDebtInfoVO;

	}

	/**
	 * DESCRIPTION:商业纠纷设定申请提交 disputeInvoiceSetSubmitApp 方法
	 * 
	 * @param insertDebtList
	 * @param debtVO
	 * @throws ScubeBizException
	 * @return
	 */
	@Transactional
	public void disputeInvoiceSetSubmitApp(List insertDebtList, DebtBussInfoVO debtVO) throws ScubeBizException {
		debtVO.setApplyType(com.huateng.scf.bas.sys.constant.DebtConstants.APPLY_TYPE_ISSUE_SET);

		BBrpPrdFactoring tblProductFactoring = null;
		if (debtVO.getBussType() != null) {
			tblProductFactoring = bBrpPrdFactoringService.findBBrpPrdFactoringByKey(debtVO.getBussType());
		}
		// 1.出池操作
		if (tblProductFactoring != null) {
			if (com.huateng.scf.bas.sys.constant.DebtConstants.FINANCING_TYPE_POOL.equals(tblProductFactoring.getFinancingType())) {// 池融资
				debtVO.setApplyType(DebtConstants.APPLY_TYPE_OUT_POOL);// 出池
				// 发票出池(对应明细信息也要出池)
				com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo billVO = null;
				for (int i = 0; i < insertDebtList.size(); i++) {
					billVO = (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo) insertDebtList.get(i);
					RBcpDebtBaseInfo debtBaseInfo = iRBcpDebtBaseInfoService.get(billVO.getId());
					debtBaseInfo.setPoolFlag(DebtConstants.POOL_FLAG_OUT_POOL);
					debtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
					debtBaseInfo.setLockAppno(null);
					if (!StringUtils.isEmpty(billVO.getIssueReason())) {
						debtBaseInfo.setIssueReason(billVO.getIssueReason());
					}
					if (!StringUtils.isEmpty(billVO.getOtherReason())) {
						debtBaseInfo.setOtherReason(billVO.getOtherReason());
					}
					com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo2 = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
					BeanUtils.copyProperties(debtBaseInfo, rBcpDebtBaseInfo2);
					iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo2);

				}
				// iRBcpDebtBaseInfoService.invoiceOutpoolAddSave(insertDebtList,
				// debtVO);使用原来的不行

				// 池信息修改
				BCntDebtInfo debtContVO = bCntDebtInfoService.queryContInfoByMastContno(debtVO.getMastContno());
				DebtContVO debtContVO2 = new com.huateng.scf.bas.cnt.dao.model.DebtContVO();
				debtContVO2.setLoanPercent(debtContVO.getLoanPercent());
				List<DebtContVO> list = new ArrayList<DebtContVO>();
				list.add(debtContVO2);
				com.huateng.scf.rec.bcp.dao.model.DebtBussInfoVO debtBussInfoVO = new com.huateng.scf.rec.bcp.dao.model.DebtBussInfoVO();
				debtBussInfoVO.setMastContno(debtVO.getMastContno());// 合同号
				debtBussInfoVO.setCustcdSaller(debtVO.getCustcdSaller());// 卖方客户号
				debtBussInfoVO.setTotalBillsAmount(debtVO.getTotalBillsAmount());// 可用金额
				debtBussInfoVO.setTotalNum(debtVO.getTotalNum());// 票据数
				debtBussInfoVO.setInpoolDate(ScfDateUtil.formatDate(new Date()));
				poolDao.updateOutpoolInfo(debtBussInfoVO, list);
				// 明细表修改
				debtVO.setPoolFlag(com.huateng.scf.bas.sys.constant.DebtConstants.POOL_FLAG_OUT_POOL);// 出池

				// 添加出池流水信息--主表
				RBcpDebtBussInfo bean = rBcpDebtBussInfoService.saveDebtOutPoolInfo(debtVO, DebtConstants.APPLY_TYPE_OUT_POOL);// 出池
				// 添加出池流水信息--详细信息表
				rBcpDebtBussDtlService.saveDebtOutPoolInfoDtl2(insertDebtList, debtVO);
			}
			// 2.商纠设定操作
			debtVO.setApplyType(DebtConstants.APPLY_TYPE_ISSUE_SET);// 商纠设定
			RBcpAppliBussDtl rBcpAppliBussDtl = new RBcpAppliBussDtl();
			rBcpAppliBussDtl.setAppno(debtVO.getAppno());
			List<RBcpAppliBussDtl> insertDebtList2 = irbcpAppliBussDtlService.findRBcpAppliBussDtlByAppno(rBcpAppliBussDtl);
			// 添加业务流水表主表(争议金额已在前面添加了)
			RBcpDebtBussInfo tblDebtBussInfo = rBcpDebtBussInfoService.debtBussInfoAdd(debtVO);
			// 添加流水详细信息表//更新发票表
			rBcpDebtBussDtlService.disputeInvoiceSetSubmit2(insertDebtList2, tblDebtBussInfo, tblProductFactoring.getFinancingType());
		}
	}

	@Override
	public Page getDisputeInvoiceSetApplyAdd(String appno, String flag, int pageNo, int pageSize, String mastContno, String custcdSaller) {

		String mastContno_Q = mastContno;
		String custcdSaller_Q = custcdSaller;
		String custcdBuyer_Q = "";
		String flag2 = flag;
		List resultList = new ArrayList();
		if ("1".equals(flag2)) {// 从业务申请表中读取数据
			List list = rBcpAppliBussInfoService.queryAppliBussInfoBillsNo(appno);
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				AppliBussInfoVO debtVO = (AppliBussInfoVO) iter.next();
				debtVO.setStartDate(debtVO.getBillDate());// 合同有效日
				debtVO.setEndDate(debtVO.getBillEndDate());// 合同到期日
				debtVO.setBussType(debtVO.getBussType());// 业务品种
				debtVO.setTotalNum(debtVO.getDebtNum());// 发票份数
				debtVO.setTotalAmount(debtVO.getTotalDebtAmount());// 发票金额
				debtVO.setAmount(debtVO.getAmount());
				debtVO.setPressMode(debtVO.getReturnType());// 催收方式
				debtVO.setAppno(appno);
				FactoringContVO contDetail = this.getFactContDetailByMastContno(debtVO.getMastContno());
				DebtBussInfoVO contVO = new DebtBussInfoVO();
				BeanUtils.copyProperties(contDetail, contVO);
				List poolList = rBcpDebtPoolService.queryDebtPollByMastContno(debtVO.getMastContno(), debtVO.getCustcdSaller());
				if (poolList != null && poolList.size() > 0) {
					RBcpDebtPool tblDebtPool = (RBcpDebtPool) poolList.get(0);
					contVO.setTotalDebtRemainAmount(tblDebtPool.getTotalDebtRemainAmount());
					contVO.setPoolRiskAmt(factService.calculatePoolRiskAvailableAmtByBusinessNo(debtVO.getMastContno()));// 池敞口余额
				}
				debtVO.setTotalDebtRemainAmount(contVO.getTotalDebtRemainAmount());// 池应收账款余额
				debtVO.setPoolRiskAmt(contVO.getPoolRiskAmt());// 池敞口
				debtVO.setLoanPercent(contVO.getLoanPercent());
				debtVO.setBailAcctNo(contVO.getBailAcctNo());
				resultList.add(debtVO);
			}

		} else {
			if (!"".equals(appno) && appno != null) {// 若申请号不为空，获取申请的合同号和卖方id
				BPbcAppliBaseInfo tabi = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
				mastContno_Q = tabi.getMastContno();
				custcdBuyer_Q = tabi.getMoniCustcd();
				custcdSaller_Q = tabi.getCustcd();
			}
			DebtCommonQryVO debtCommonQryVO = new DebtCommonQryVO();
			debtCommonQryVO.setMastContno(mastContno_Q);
			debtCommonQryVO.setCustcdBuyer_Q(custcdBuyer_Q);
			debtCommonQryVO.setCustcdSaller_Q(custcdSaller_Q);

			FactoringContVO contDetail = this.getFactContDetailByMastContno(mastContno_Q);
			DebtBussInfoVO contVO = new DebtBussInfoVO();
			BeanUtils.copyProperties(contDetail, contVO);
			List poolList = rBcpDebtPoolService.queryDebtPollByMastContno(mastContno_Q, custcdSaller_Q);
			if (poolList != null && poolList.size() > 0) {
				RBcpDebtPool tblDebtPool = (RBcpDebtPool) poolList.get(0);
				contVO.setTotalDebtRemainAmount(tblDebtPool.getTotalDebtRemainAmount());
				contVO.setPoolRiskAmt(factService.calculatePoolRiskAvailableAmtByBusinessNo(mastContno_Q));// 池敞口余额
			}
			if (StringUtils.isEmpty(appno)) {
				Page pageQueryResult = new Page();
				List queryResult = new ArrayList();
				queryResult.add(contVO);
				Iterator iter = queryResult.iterator();
				while (iter.hasNext()) {
					DebtBussInfoVO debtVO = (DebtBussInfoVO) iter.next();
					debtVO.setMastContno(debtVO.getDebtContno());
					debtVO.setCustcdBuyer(debtCommonQryVO.getCustcdBuyer_Q());
					debtVO.setCustcdSaller(debtCommonQryVO.getCustcdSaller_Q());
					debtVO.setBussType(debtVO.getProductId());
					debtVO.setPressMode(debtVO.getReturnType());// 催收方式
					if (StringUtils.isNotEmpty(debtVO.getAccountNo())) {
						debtVO.setBalanceAccount(debtVO.getAccountNo());
					}
					debtVO.setLoanPercent(contVO.getLoanPercent());
					debtVO.setAppno(appno);
					resultList.add(debtVO);
				}
			}
			if (StringUtils.isNotEmpty(appno)) {
				List<RBcpAppliBussInfo> tempList = rBcpAppliBussInfoService.queryAppliBussInfoBillsNo(appno);
				// Iterator ite = tempList.iterator();
				for (RBcpAppliBussInfo debtVO : tempList) {
					AppliBussInfoVO e = new AppliBussInfoVO();
					e.setCustcdSaller(custcdSaller_Q);
					e.setStartDate(debtVO.getBillDate());// 合同有效日
					e.setCustcdBuyer(debtVO.getCustcdBuyer());
					e.setMastContcode(debtVO.getMastContcode());
					// poolBailAmount
					e.setInsertDate(debtVO.getInsertDate());
					e.setAmount(debtVO.getAmount());
					e.setMemo(debtVO.getMemo());
					e.setEndDate(debtVO.getBillEndDate());// 合同到期日
					e.setBailAcctNo(contVO.getBailAcctNo());// 保证金账号
					e.setTotalDebtRemainAmount(contVO.getTotalDebtRemainAmount());// 池应收账款余额
					e.setPoolRiskAmt(contVO.getPoolRiskAmt());// 池敞口
					e.setBussType(debtVO.getBussType());// 业务品种
					e.setTotalNum(debtVO.getDebtNum());// 发票份数
					e.setTotalAmount(debtVO.getTotalDebtAmount());// 发票金额
					e.setPressMode(debtVO.getReturnType());// 催收方式
					e.setAppno(appno);
					e.setLoanPercent(contVO.getLoanPercent());
					resultList.add(e);
				}
				// while (ite.hasNext()) {
				// AppliBussInfoVO debtVO = (AppliBussInfoVO) ite.next();
				// debtVO.setStartDate(debtVO.getBillDate());// 合同有效日
				// debtVO.setEndDate(debtVO.getBillEndDate());// 合同到期日
				// debtVO.setBailAcctNo(contVO.getBailAcctNo());// 保证金账号
				// debtVO.setTotalDebtRemainAmount(contVO.getTotalDebtRemainAmount());//
				// 池应收账款余额
				// debtVO.setPoolRiskAmt(contVO.getPoolRiskAmt());// 池敞口
				// debtVO.setBussType(debtVO.getBussType());// 业务品种
				// debtVO.setTotalNum(debtVO.getDebtNum());// 发票份数
				// debtVO.setTotalAmount(debtVO.getTotalDebtAmount());// 发票金额
				// debtVO.setPressMode(debtVO.getReturnType());// 催收方式
				// debtVO.setAppno(appno);
				// debtVO.setLoanPercent(contVO.getLoanPercent());
				// resultList.add(debtVO);
				// }
			}
		}

		int recordNumber = resultList.size();
		Page page = new Page(pageSize, pageNo, recordNumber);
		page.setRecords(resultList);

		return page;

	}

	/**
	 * appno不为空
	 */
	public com.huateng.scf.rec.bcp.model.AppliBussInfoVO queuySavedPageResult(String appno) {
		String mastContno_Q = ""; // 内部合同号
		String custcdSaller_Q = ""; // 卖方客户号
		String custcdBuyer_Q = ""; // 买方客户号

		if (StringUtils.isNotBlank(appno)) {// 若申请号不为空，获取申请的合同号和卖方id
			BPbcAppliBaseInfo tabi = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			mastContno_Q = tabi.getMastContno();
			custcdBuyer_Q = tabi.getMoniCustcd();
			custcdSaller_Q = tabi.getCustcd();
		}

		FactoringContVO contDetail = getFactContDetailByMastContno(mastContno_Q);
		DebtBussInfoVO contVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(contVO, contDetail);
		// 根据appno从应收账款业务申请流水基本信息表中查询出相应记录
		com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo bcpAppliBussInfo = rBcpAppliBussInfoService.findByAppno(appno);
		com.huateng.scf.rec.bcp.model.AppliBussInfoVO debtVO = new com.huateng.scf.rec.bcp.model.AppliBussInfoVO();
		BeanUtils.copyProperties(bcpAppliBussInfo, debtVO);

		if (StringUtils.isNotBlank(appno)) {
			Date startDate;
			try {
				startDate = ScfDateUtil.toDate(debtVO.getBillDate(), ScfDateUtil.DATE_FORMAT_YYYYMMDD);
				debtVO.setStartDate(String.valueOf(startDate));// 合同有效日
			} catch (ParseException e) {
				e.printStackTrace();
			}

			try {
				Date endDate = ScfDateUtil.toDate(debtVO.getBillEndDate(), ScfDateUtil.DATE_FORMAT_YYYYMMDD);
				debtVO.setEndDate(String.valueOf(endDate));// 合同到期日
			} catch (ParseException e) {
				e.printStackTrace();
			}

			debtVO.setBussType(contVO.getBussType());// 业务品种
			debtVO.setTotalNum(contVO.getDebtNum());// 发票份数
			debtVO.setTotalAmount(debtVO.getTotalDebtAmount());// 发票金额
			debtVO.setAmount(contVO.getAmount());
			debtVO.setPressMode(debtVO.getReturnType());// 催收方式
			debtVO.setAppno(appno);

		}

		return debtVO;

	}

	/**
	 * 根据待办任务查询详情页面
	 * 
	 * @param task
	 * @return
	 */
	public com.huateng.scf.rec.bcp.model.AppliBussInfoVO queryVOFromAppliBaseInfo(String appno) {
		com.huateng.scf.rec.bcp.model.AppliBussInfoVO debtVO = new com.huateng.scf.rec.bcp.model.AppliBussInfoVO();

		// String appno =task.getAppNo();
		com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo rBcpAppliBussInfo = rBcpAppliBussInfoService.findByAppno(appno);// 获取申请基本信息

		BeanUtils.copyProperties(rBcpAppliBussInfo, debtVO);
		try {
			Date startDate = ScfDateUtil.toDate(debtVO.getBillDate(), ScfDateUtil.DATE_FORMAT_YYYYMMDD);
			debtVO.setStartDate(String.valueOf(startDate));// 合同有效日
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			Date endDate = ScfDateUtil.toDate(debtVO.getBillEndDate(), ScfDateUtil.DATE_FORMAT_YYYYMMDD);
			debtVO.setEndDate(String.valueOf(endDate));// 合同到期日
		} catch (ParseException e) {
			e.printStackTrace();
		}

		debtVO.setBussType(debtVO.getBussType());// 业务品种
		debtVO.setTotalNum(debtVO.getDebtNum());// 发票份数
		debtVO.setTotalAmount(debtVO.getTotalDebtAmount());// 发票金额
		debtVO.setAmount(debtVO.getAmount());
		debtVO.setPressMode(debtVO.getReturnType());// 催收方式
		debtVO.setAppno(appno);
		FactoringContVO contDetail = getFactContDetailByMastContno(debtVO.getMastContno());
		DebtBussInfoVO contVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(contDetail, contVO);

		/*
		 * TODO
		 * debtVO.setTotalDebtRemainAmount(contVO.getTotalDebtRemainAmount());//
		 * 池应收账款余额 debtVO.setPoolRiskAmt(contVO.getPoolRiskAmt());//池敞口
		 */
		debtVO.setLoanPercent(contVO.getLoanPercent());
		debtVO.setBailAcctNo(contVO.getBailAcctNo());

		return debtVO;

	}

	public FactoringContVO getFactContDetailByMastContno(String mastContno) {
		com.huateng.scf.rec.bcp.model.FactoringContVO factContVO = new FactoringContVO();
		// String productId = "";

		BCntDebtInfo contDebtInfo = bCntDebtInfoService.queryContInfoByMastContno(mastContno);
		if (contDebtInfo != null) {
			// productId = contDebtInfo.getSupplyChainPdId();
			// BBrpPrdFactoring productFactoring =
			// bBrpPrdFactoringService.findBBrpPrdFactoringByKey(productId);
			// factContVO = new FactoringContVO();
			// BeanUtils.copyProperties(productFactoring, factContVO);
			BeanUtils.copyProperties(contDebtInfo, factContVO);
		}
		return factContVO;
	}

	@Override
	public List getInvoiceList(String appno, String bussType) {

		DebtCommonQryVO commonQryVO = new DebtCommonQryVO();
		String mastContno = "";
		if (StringUtils.isNotEmpty(mastContno)) {
			commonQryVO.setMastContno(mastContno);
		}
		String custcdSaller = "";
		if (StringUtils.isNotEmpty(custcdSaller)) {
			commonQryVO.setCustcdSaller_Q(custcdSaller);
		}
		String custcdBuyer = "";
		if (StringUtils.isNotEmpty(custcdBuyer)) {
			commonQryVO.setCustcdBuyer_Q(custcdBuyer);
		}
		String id_Q = "";
		if (StringUtils.isNotEmpty(id_Q)) {
			commonQryVO.setId_Q(id_Q);
		}

		List<RBcpAppliBussDtl> list = irbcpAppliBussDtlService.queryAppliBussDetailByAppno(appno, bussType);

		Iterator<RBcpAppliBussDtl> iter = list.iterator();

		List<RBcpAppliBussDtl> resultList = new ArrayList<RBcpAppliBussDtl>();
		String money = "";
		String issueReason = "";
		String otherReason = "";

		int pageNo = 1;
		int pageSize = 10;
		RBcpDebtBaseInfo rBcpDebtBaseInfo = new RBcpDebtBaseInfo();
		rBcpDebtBaseInfo.setId(id_Q);

		Page page = iRBcpDebtBaseInfoService.findRBcpDebtBaseInfoPageByPage(pageNo, pageSize, rBcpDebtBaseInfo);
		List list1 = page.getRecords();
		if (list1 != null && list1.size() > 0) {
			Iterator iters = list1.iterator();
			while (iters.hasNext()) {
				RBcpAppliBussDtl debtVO = (RBcpAppliBussDtl) iters.next();
				debtVO.setDebtId(debtVO.getId());
				if (StringUtils.isNotEmpty(money) && !(money.equals("NaN"))) {
					debtVO.setMoney(new BigDecimal(money));
				} else {
					debtVO.setMoney(new BigDecimal("0"));
				}
				debtVO.setIssueReason(issueReason);
				debtVO.setOtherReason(otherReason);

				for (int i = 0; i < list.size(); i++) {
					RBcpAppliBussDtl applyDebtVO = (RBcpAppliBussDtl) list.get(i);
					if (debtVO.getId().equals(applyDebtVO.getDebtId())) {
						debtVO.setId(applyDebtVO.getDebtId());
						debtVO.setDebtId(applyDebtVO.getDebtId());
						list.remove(i);
						break;

					}
				}
				resultList.add(debtVO);// bussDetail中的ID与正式表中的ID不一致，DebtID才是一致
			}
		}
		return resultList;

	}

	public void submitSignal(DebtBussInfoVO rBcpAppliBussInfo, String comment) throws Exception {

		String taskId = WorkflowConstant.POOLDISPUTEINVOICESUBMITTASK;
		BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(rBcpAppliBussInfo.getAppno());
		String processId = bPbcAppliBaseInfo.getPiid();
		String userId = ContextHolder.getUserInfo().getTlrNo();
		taskService.takeTask(taskId, processId, userId);
		// 任务提交d
		taskService.completeTask(taskId, processId, userId, comment);
		// 节点转移(自己要再设置一下)
		processService.autoSignal(processId);// 通知书回执节点(下一节点)

		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);// 已提交(未审批)
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);// 已提交

		iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);

	}

	@SuppressWarnings("unused")
	@Transactional
	@Override
	public void doWorkForPass(String appNo) {

		DebtBussInfoVO debtVODal = new DebtBussInfoVO();
		RBcpDebtBaseInfoExample rBcpDebtBaseInfoExample = new RBcpDebtBaseInfoExample();
		rBcpDebtBaseInfoExample.createCriteria().andLockAppnoEqualTo(appNo);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> insertList = iRBcpDebtBaseInfoDAO.selectByExample(rBcpDebtBaseInfoExample);
		BigDecimal totalBillsAmount = new BigDecimal(0);// 准备出池金额
		Integer totalNum = new Integer(0);
		for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo : insertList) {
			totalBillsAmount = totalBillsAmount.add(rBcpDebtBaseInfo.getRemainingAmount());
			totalNum = totalNum + 1;

		}
		debtVODal.setTotalBillsAmount(totalBillsAmount);// 出池总金额
		debtVODal.setTotalNum(totalNum);// 出池总份数
		debtVODal.setInpoolDate(ScfDateUtil.formatDate(new Date()));

		com.huateng.authority.entity.BctlVO globalInfo = ContextHolder.getOrgInfo();
		BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		BCntDebtInfo tblContBaseInfo = bCntDebtInfoService.findBCntDebtInfoByKey(bPbcAppliBaseInfo.getMastContno());
		RBcpAppliBussInfo rBcpAppliBussInfo = new RBcpAppliBussInfo();
		rBcpAppliBussInfo.setAppno(appNo);
		RBcpAppliBussInfo rBcpAppliBussInfo2 = rBcpAppliBussInfoService.findBcpAppliBussInfoByKey(rBcpAppliBussInfo);
		debtVODal.setAppno(appNo);
		debtVODal.setEndDate(rBcpAppliBussInfo2.getEndDate());
		debtVODal.setDisputeCount(rBcpAppliBussInfo2.getDebtNum());// 争议份数
		debtVODal.setDisputeAmount(rBcpAppliBussInfo2.getAmount());// 争议总金额
		debtVODal.setAmount(rBcpAppliBussInfo2.getAmount());// 争议总金额
		debtVODal.setInsertDate(ScfDateUtil.formatDate(new Date()));
		debtVODal.setFactType(rBcpAppliBussInfo2.getFactType());
		debtVODal.setMastContno(rBcpAppliBussInfo2.getMastContno());
		debtVODal.setCustcdSaller(rBcpAppliBussInfo2.getCustcdSaller());
		debtVODal.setCustcdBuyer(rBcpAppliBussInfo2.getCustcdBuyer());
		debtVODal.setCurcd(rBcpAppliBussInfo2.getCurcd());
		debtVODal.setBrcode(globalInfo.getBrNo());
		debtVODal.setTlrcd(ContextHolder.getUserInfo().getTlrNo());
		debtVODal.setStartDate(ScfDateUtil.formatDate(new Date()));
		debtVODal.setProductId(rBcpAppliBussInfo2.getBussType());
		// 如果是单笔的就不给BussType，后面就不给池信息计算
		debtVODal.setBussType(rBcpAppliBussInfo2.getBussType());
		debtVODal.setDebtContno(rBcpAppliBussInfo2.getMastContno());
		// debtVODal.setLoanWay(bPbcAppliBaseInfo.getProtocolNo());出账方式
		// debtVODal.setTotalAmount(rBcpAppliBussInfo2.getAmount());
		// debtVODal.setBusinessNo(rBcpAppliBussInfo2.get); 业务合同号
		// disputeInvoiceSetApplyReceiptUpdate(debtVODal, insertList, appNo);

		this.disputeInvoiceSetSubmitApp(insertList, debtVODal);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_APPROVED);// 已通过(审批通过)
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);// 已通过
		bPbcAppliBaseInfo.setIsFlowEnd(ScfBasConstant.FLAG_ON);// 设置流程结束了
		iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);

	}

	@Override
	public void doWorkForReject(String appNo) {

		BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);

		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_REFUSED);// 已通过(审批通过)
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);// 已通过
		iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);

		//解锁借据信息
		RBcpDebtBaseInfoExample rBcpDebtBaseInfoExample = new RBcpDebtBaseInfoExample();
		rBcpDebtBaseInfoExample.createCriteria().andLockAppnoEqualTo(appNo);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> insertList = iRBcpDebtBaseInfoDAO.selectByExample(rBcpDebtBaseInfoExample);
		for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo : insertList) {
			rBcpDebtBaseInfo.setIsLocked(ScfBasConstant.UNLOCKED);
			rBcpDebtBaseInfo.setLockAppno(null);
			iRBcpDebtBaseInfoDAO.updateByPrimaryKey(rBcpDebtBaseInfo);
		}
		
	}

	@Override
	public Page queryInvoiceRelatedFinancing() {
		String appno = "";
		List<com.huateng.scf.rec.bcp.model.RBcpAppliRepayment> loanList = rBcpAppliRepaymentService.queryTblAppliRepaymentInfoByAppno(appno);

		List billsList = null;

		Page page = new Page();

		return null;
	}

	@Override
	public void doWorkForSubmit(java.lang.String appNo) throws ScubeBizException {

		List<RBcpAppliBussDtl> list = irbcpAppliBussDtlService.queryAppliBussDetailByAppno(appNo, "");

		List<DebtBillsInfoVO> voList = new ArrayList<DebtBillsInfoVO>();

		for (RBcpAppliBussDtl detail : list) {
			DebtBillsInfoVO debetVo = new DebtBillsInfoVO();
			BeanUtils.copyProperties(detail, debetVo);
			voList.add(debetVo);
		}

		String buyerCustcd = list.get(0).getCustcdSaller();

		BCntDebtInfoVO bCntDebtInfoVO = this.queuyUnTakeTaskDetailPage(appNo, buyerCustcd);
		DebtBussInfoVO bussInfoVO = new DebtBussInfoVO();
		bussInfoVO.setCustcdSaller(bCntDebtInfoVO.getCustcd());
		bussInfoVO.setCustcdSaller(bCntDebtInfoVO.getBuyerCustcd());
		bussInfoVO.setDebtContno(bCntDebtInfoVO.getDebtContno());
		bussInfoVO.setStartDate(bCntDebtInfoVO.getStartDate());
		bussInfoVO.setEndDate(bCntDebtInfoVO.getEndDate());
		bussInfoVO.setDisputeCount(bCntDebtInfoVO.getDisputeCount());
		bussInfoVO.setDisputeAmount(bCntDebtInfoVO.getDisputeAmount());
		bussInfoVO.setInsertDate(ScfDateUtil.formatDate(bCntDebtInfoVO.getCrtTime()));
		bussInfoVO.setProductId(bCntDebtInfoVO.getSupplyChainPdId());
		bussInfoVO.setCurcd(bCntDebtInfoVO.getCurcd());
		bussInfoVO.setFactType(ScfBasConstant.FACT_TYPE_INLAND);
		bussInfoVO.setAppno(appNo);
		this.disputeInvoiceSetApplyWriteSubmitUpdate(bussInfoVO, voList);
	}

	// public Page invoiceRelatedFinancingQueryGetter(){
	//
	// String custcdSaller_Q = "";// 卖方客户名称
	// String custcdBuyer_Q = "";// 买方客户名称
	// String mastContno = ""; // 合同号
	// String appno = ""; // 申请编号
	// String debetNo_Q = ""; //借据号 DEBET_NO
	// String billId_Q = "";
	// String flag1 ="";//有appno时添加
	// DebtCommonQryVO commonQueryVO = new DebtCommonQryVO();
	//
	// HashMap<String,RBcpAppliRepayment> payLoanInfoMap = new
	// HashMap<String,RBcpAppliRepayment>();
	// HashMap<String,BMrnAppliAcctInfo> payBillsInfoMap = new
	// HashMap<String,BMrnAppliAcctInfo>();
	// List<RBcpAppliRepayment> loanList =
	// debtCURDService.queryTblAppliRepaymentInfoByAppno(appno); //
	// 还款信息--流贷还本息信息
	// List<TblAppliCustAccountInfo> billsList =
	// debtCURDService.getTblAppliCustAccountInfoByAppno(appno); //
	// 还款信息--银承入保证金信息
	// if(loanList != null && loanList.size() > 0 ){
	// for(int i = 0; i < loanList.size() ; i++){
	// TblAppliRepaymentInfo payInfo = loanList.get(i);
	// if(!DataFormat.isEmpty(flag1)){
	// if(debetNo_Q.indexOf(payInfo.getDebetNo())!=-1){
	// debetNo_Q = debetNo_Q + "/f"+payInfo.getDebetNo();
	// }
	// }else{
	// debetNo_Q = debetNo_Q + "/f"+payInfo.getDebetNo();
	// }
	// payLoanInfoMap.put(payInfo.getDebetNo(), payInfo);
	// }
	// }
	// if(billsList != null && billsList.size() > 0 ){
	// for(int i = 0; i < billsList.size() ; i++){
	// TblAppliCustAccountInfo payBillsInfo = billsList.get(i);
	// if(!DataFormat.isEmpty(flag1)){
	// if(debetNo_Q.indexOf(payBillsInfo.getDebetNo())!=-1){
	// debetNo_Q = debetNo_Q + "/f"+payBillsInfo.getDebetNo();
	// }
	// }else{
	// debetNo_Q = debetNo_Q + "/f"+payBillsInfo.getDebetNo();
	// }
	// payBillsInfoMap.put(payBillsInfo.getDebetNo(), payBillsInfo);
	// }
	// }
	//
	// //当前页
	// int pageIndex = getResult().getPage().getCurrentPage();
	// //每页显示个数
	// int pageSize = getResult().getPage().getEveryPage();
	// if(!SCFDataFormat.isEmpty(debetNo_Q)){
	// if(debetNo_Q.startsWith("/f")){
	// debetNo_Q = debetNo_Q.replaceFirst("/f", "");
	// }
	// if(debetNo_Q.split("/f").length==0){
	// debetNo_Q="";
	// }
	// }
	//
	// pageSize = Integer.MAX_VALUE;
	// commonQueryVO.setCustcdSaller_Q(custcdSaller_Q);
	// commonQueryVO.setCustcdBuyer_Q(custcdBuyer_Q);
	// //commonQueryVO.setMastContno_Q(mastContno);//台账查询需要业务合同号
	// commonQueryVO.setProtocolNo_Q(mastContno);
	// commonQueryVO.setAppno_Q(appno);
	// commonQueryVO.setDebetNo_Q(debetNo_Q==null?"":debetNo_Q);
	// commonQueryVO.setPageIndex(pageIndex);
	// commonQueryVO.setPageSize(pageSize);
	// Page pageQueryResult =
	// debtCURDService.getLnciBaseInfoByDebetNosAndMap(commonQueryVO,
	// payLoanInfoMap, payBillsInfoMap,null);
	//
	// return pageQueryResult;
	//
	// }

	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub

	}

}

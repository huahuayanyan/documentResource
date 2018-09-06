/**
 * 
 */
package com.huateng.scf.rec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.cnt.constant.BCntErrorConstant;
import com.huateng.scf.bas.cnt.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.model.DebtContVO;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfApplyService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.prd.service.IBPrdWkflowCopService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfoExample;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.AppliBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliRepayment;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scf.rec.bcp.service.IFactFinanceBaseService;
import com.huateng.scf.rec.bcp.service.IFactoringDebtBackService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliRepaymentService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 应收账款反转让实现类
 * </p>
 *
 * @author huangshuidan
 * @date 2016年12月28日下午4:58:53
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月28日下午4:58:53              新增
 *
 *            </pre>
 */
@ScubeService
@Service("FactoringDebtBackServiceImpl")
public class FactoringDebtBackServiceImpl implements IFactoringDebtBackService, DealEndFlowService, DealInFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	private final static List<RBcpAppliBussDtl> listdtl = new ArrayList<RBcpAppliBussDtl>();

	@Resource(name = "BCntDebtInfoServiceImpl")
	IBCntDebtInfoService bCntDebtInfoService;

	@Resource(name = IScfApplyService.BEAN_ID)
	IScfApplyService scfApplyService;

	@Resource(name = "BPrdWkflowCopServiceImpl")
	IBPrdWkflowCopService bPrdWkflowCopService;

	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;

	@Resource(name = "RBcpAppliBussInfoServiceImpl")
	IRBcpAppliBussInfoService rBcpAppliBussInfoService;

	@Resource(name = "RBcpAppliBussDtlServiceImpl")
	IRBcpAppliBussDtlService rBcpAppliBussDtlService;

	// 应收账款基本信息
	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO iRBcpDebtBaseInfoDAO;

	@Autowired
	ScubeUserService scubeUserService;

	// 应收账款单据信息表
	@Resource(name = "rBcpDebtBaseInfoService")
	IRBcpDebtBaseInfoService rBcpDebtBaseInfoService;

	// 供应链借据表
	@Resource(name = "BLanLnciBaseServiceImpl")
	IBLanLnciBaseService blanlncibaseservice;

	@Resource(name = "IRBcpDebtBussDtlDAO")
	IRBcpDebtBussDtlDAO iRBcpDebtBussDtlDAO;

	@Resource(name = "BMrnAppliAcctInfoServiceImpl")
	IBMrnAppliAcctInfoService mrnacctinfoservice;

	@Resource(name = "RBcpAppliRepaymentServiceImpl")
	IRBcpAppliRepaymentService rbcpapplirepaymentservice;

	// 产品工厂信息
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bprdinfoservice;

	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;

	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rbcpapplibussdtldao;

	// 客户信息
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bcrmbaseinfoservice;

	@Resource(name = "FactFinanceBaseServiceImpl")
	IFactFinanceBaseService factfinancebaseservice;

	@Resource(name = "RBcpDebtPoolServiceImpl")
	IRBcpDebtPoolService rbcpdebtpoolservice;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IFactoringDebtBackService#
	 * queryContDebtListByPage(int, int,
	 * com.huateng.scf.rec.bcp.model.DebtBussInfoVO)
	 */
	public Page queryContDebtListByPage(int pageNo, int pageSize, DebtBussInfoVO debtBussInfoVO) throws ScubeBizException {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.rec.bcp.service.IFactoringDebtBackService#
	 * debtBackApplySave(com.huateng.scf.rec.bcp.model.DebtBussInfoVO)
	 */
	/**
	 * 应收账款反转让申请保存
	 */
	@Override
	@Transactional
	public String debtBackApplySave(AppliBussInfoVO appliBussInfoVO, List<RBcpDebtBaseInfo> insertDebtList) throws ScubeBizException {
		String in_appno = appliBussInfoVO.getAppno();
		DebtBussInfoVO debtBussInfoVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(appliBussInfoVO, debtBussInfoVO);
		// 根据申请类型获取流程名称
		String businessnoType = "";// 申请类型
		String workApplyType = ""; // 申请业务类型
		if (StringUtil.isEmpty(in_appno)) {
			if (!StringUtil.isEmpty(debtBussInfoVO.getFactType())) {
				if (ScfBasConstant.T_FINANCING_TYPE_POOL.equals(debtBussInfoVO.getFactType())) {// 应收账款池
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_POOL_BUYBACK;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_POOL_BUYBACK_APPLY;
				} else if (ScfBasConstant.T_FINANCING_TYPE_CREDIT.equals(debtBussInfoVO.getFactType())) {// 信保保理
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_BUY_BACK_APPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_CREDIT_BUY_BACK_APPLY;
				} else if (ScfBasConstant.T_FINANCING_TYPE_DOUBLE.equals(debtBussInfoVO.getFactType())) {// 双保理
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_BUY_BACK_APPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_DOUBLE_BUY_BACK_APPLY;
				} else if (ScfBasConstant.T_FINANCING_TYPE_LEASE.equals(debtBussInfoVO.getFactType())) {// 租赁保理
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_LEASE_BUY_BACK_APPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_LEASE_BUY_BACK_APPLY;
				} else {
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORINGACCOUNTREPURAPPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_ACCOUNTREPUR_APPLY;
				}
			} else {
				log.error("没有匹配到对应的申请类型！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10018),
						RBcpErrorConstant.SCF_REC_BCP_10018);
			}
			debtBussInfoVO.setApplyType(businessnoType);
			in_appno = scfApplyService.saveFactoringAppBasicInfo(debtBussInfoVO, businessnoType, workApplyType);
			// 发起工作流
			if (StringUtil.isEmpty(appliBussInfoVO.getAppno())) {
				HashMap<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("modelId", workApplyType);
				paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
				paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
				try {
					scfWorkFlowService.commonStartFlow(in_appno, workApplyType, workApplyType, paramMap);
				} catch (FlowsharpException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		if (!StringUtil.isEmpty(in_appno)) {
			debtBussInfoVO.setAppno(in_appno);
			// List insertDebtList = new ArrayList();
			// 应收账款单据list数据
			// 保存到R_BCP_APPLI_BUSS_INFO【业务申请业务主表】
			String debtId = rBcpAppliBussInfoService.saveDebtBackAppliBussInfo(debtBussInfoVO);
			// // 保存到 R_BCP_APPLI_BUSS_DTL【业务申请业务明细表】
			rBcpAppliBussDtlService.saveDebtBackApplyBussDetail(insertDebtList, debtBussInfoVO.getAppno(), debtId);
			listdtl.clear();
		}
		return in_appno;
	}

	/**
	 * 应收账款反转让申请提交
	 */
	@Override
	@Transactional
	public void debtBackApplySubmit(AppliBussInfoVO appliBussInfoVO, List<RBcpDebtBaseInfo> insertDebtList, boolean isProcess)
			throws ScubeBizException {
		DebtBussInfoVO debtBussInfoVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(appliBussInfoVO, debtBussInfoVO);
		// 应收账款单据list数据
		// 保存到R_BCP_APPLI_BUSS_INFO【业务申请业务主表】
		String debtId = rBcpAppliBussInfoService.saveDebtBackAppliBussInfo(debtBussInfoVO);
		// // 保存到 R_BCP_APPLI_BUSS_DTL【业务申请业务明细表】
		rBcpAppliBussDtlService.saveDebtBackApplyBussDetail(insertDebtList, debtBussInfoVO.getAppno(), debtId);
		BPbcAppliBaseInfo appliinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(debtBussInfoVO.getAppno());
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
		try {
			scfWorkFlowService.processTasks(appliinfo, status);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 应收账款回购申请流程回执
	 * 
	 * @param appliBussInfoVO
	 * @param insertDebtList
	 * @throws ScubeBizException
	 */
	@Override
	@Transactional
	public void debtBackApplyPassSubmit(AppliBussInfoVO appliBussInfoVO, List<RBcpDebtBaseInfo> insertDebtList, boolean isProcess)
			throws ScubeBizException {
		DebtBussInfoVO debtBussInfoVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(appliBussInfoVO, debtBussInfoVO);
		scfApplyService.factoringDebtBackAddApply(insertDebtList, debtBussInfoVO);
		scfApplyService.releaseAppliDebtBaseInfo(debtBussInfoVO.getAppno()); // 解锁应收账款
		if (!StringUtil.isEmpty(debtBussInfoVO.getFactType()) && ScfBasConstant.T_FINANCING_TYPE_POOL.equals(debtBussInfoVO.getFactType())) {
			scfApplyService.updatePoolRemainAmount(debtBussInfoVO);// 更新池信息（发票余额、可融资余额）
		}
		// noticeService.addDebtBackNoticeByAppno(debtVOCommon.getAppno(),factType);//通知书回执
		// 额度操作
		if (StringUtil.isEmpty(debtBussInfoVO.getFactType())) {
			BCntDebtInfo tblContDebtInfo = bCntDebtInfoService.findBCntDebtInfoByKey(debtBussInfoVO.getMastContno());
			debtBussInfoVO.setFactType(tblContDebtInfo.getFactType());
		}
		// 合同有追/无追
		String recoverType = scfApplyService.getDebtContRecoverType(debtBussInfoVO.getMastContno(), debtBussInfoVO.getCustcdBuyer());

		if (ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(debtBussInfoVO.getFactType()) // 信保保理
				|| ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(debtBussInfoVO.getFactType()) // 行内双保理
				|| (ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(debtBussInfoVO.getFactType())
						&& ScfBasConstant.CREDIT_TYPE_WITHOUT_RECOURSE.equals(recoverType)) // 租赁保理无追模式
				|| (ScfBasConstant.FACT_TYPE_INLAND.equals(debtBussInfoVO.getFactType())
						&& ScfBasConstant.CREDIT_TYPE_WITHOUT_RECOURSE.equals(recoverType)) // 国内保理无追模式
				|| (ScfBasConstant.FACT_TYPE_REVERSE.equals(debtBussInfoVO.getFactType())
						&& ScfBasConstant.CREDIT_TYPE_WITHOUT_RECOURSE.equals(recoverType)) // 反向保理无追模式
		) {// 买方信用限额额度额度处理-释放
			scfApplyService.creditLimitOfBuyerAppliCommonProcess(debtBussInfoVO.getAppno(), ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE,
					debtBussInfoVO.getTotalAmount());
		}
		if (isProcess) {
			// 流程流转
			BPbcAppliBaseInfo appliinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(debtBussInfoVO.getAppno());
			String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
			try {
				scfWorkFlowService.processTasks(appliinfo, status);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 保理应收账款回购申请流程审批
	 * 
	 * @param appliBussInfoVO
	 * @param insertDebtList
	 * @throws ScubeBizException
	 */
	@Override
	@Transactional
	public void debtBackApplyBackToModify(String appno, boolean isProcess) throws ScubeBizException {
		String status = WorkflowConstant.WORKFLOW_TRANS_GOBACK;
		// 如果是审批拒绝则需要 对流程锁定的应收账款进行解锁
		if (isProcess) {
			// 流程流转
			BPbcAppliBaseInfo appliinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			try {
				scfWorkFlowService.processTasks(appliinfo, status);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 任务基本信息
	@Override
	public com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(String appno, String factType) {
		String process = "";
		if (factType == "1") {
			process = WorkflowConstant.PROCNAME_FACTORING_ACCOUNTREPUR_APPLY;
		} else {
			process = WorkflowConstant.PROCNAME_FACTORING_POOL_BUYBACK_APPLY;
		}
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}

	/**
	 * 点击申请反转让按钮，根据已有信息查询基本信息及反转让信息
	 * 
	 * @param debtBussInfoVO
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public DebtBussInfoVO getDebtBussInfo(DebtBussInfoVO debtBussInfoVO) throws ScubeBizException {
		log.debug("合同编号：" + debtBussInfoVO.getMastContno());
		String appno = debtBussInfoVO.getAppno();
		String mastContno = debtBussInfoVO.getMastContno();
		String custcdBuyer = debtBussInfoVO.getCustcdBuyer();
		String custcdSaller = debtBussInfoVO.getCustcdSaller();

		// //反转让份数
		// int totalNum = 0;
		// //反转让金额
		// double totalAmount = 0;
		//
		DebtCommonQryVO commonQueryVO = new DebtCommonQryVO();
		commonQueryVO.setMastContno(mastContno);
		commonQueryVO.setCustcdBuyer_Q(custcdBuyer);
		commonQueryVO.setCustcdSaller_Q(custcdSaller);
		commonQueryVO.setAppno_Q(appno);

		// 应收账款反转让列表
		// List listinfo = new ArrayList();
		// 业务详情信息
		DebtBussInfoVO debtContVO = new DebtBussInfoVO();
		BigDecimal loanpercent = new BigDecimal(0);
		if (StringUtil.isEmpty(appno)) {
			debtContVO = getContDebtInfoByMastContno(commonQueryVO);
		} else {
			// listinfo = getTblAppliBussDetail(appno, null);
			RBcpAppliBussInfo tabi = rBcpAppliBussInfoService.findByAppno(appno);
			mastContno = tabi.getMastContno();
			custcdBuyer = tabi.getCustcdBuyer();
			// 买家名称
			BCrmBaseInfo buyer = new BCrmBaseInfo();
			buyer.setCustcd(tabi.getCustcdBuyer());
			BCrmBaseInfo buyerinfo = bcrmbaseinfoservice.findBCrmBaseInfoByKey(buyer);
			tabi.setCnameBuyer(buyerinfo.getCname());
			// 卖家名称
			BCrmBaseInfo seller = new BCrmBaseInfo();
			seller.setCustcd(tabi.getCustcdSaller());
			BCrmBaseInfo sellerinfo = bcrmbaseinfoservice.findBCrmBaseInfoByKey(seller);
			tabi.setCnameSeller(sellerinfo.getCname());
			BeanUtils.copyProperties(tabi, debtContVO);
			debtContVO.setStartDate(tabi.getBillDate());// 合同生效日期
			debtContVO.setEndDate(tabi.getBillEndDate());// 合同到期日期
			debtContVO.setDebtContno(debtContVO.getMastContno());
			debtContVO.setLoanPercent(debtContVO.getLoanPercent() != null ? debtContVO.getLoanPercent() : loanpercent);// 融资比例
		}
		BPrdInfo bPrdInfo = new BPrdInfo();
		bPrdInfo.setProductId(debtContVO.getBussType());
		String bussTypeName = bprdinfoservice.findBPrdInfoByKey(bPrdInfo).getProductName();
		debtContVO.setBussTypeName(bussTypeName);
		// 池融资
		List list = new ArrayList();
		if (!StringUtil.isEmpty(commonQueryVO.getCustcdSaller_Q())) {
			list = rbcpdebtpoolservice.queryDebtPollByMastContno(mastContno, custcdSaller);
		} else {
			list = rbcpdebtpoolservice.queryDebtPollByMastContno(mastContno, debtContVO.getCustcdSaller());
		}
		if (list != null && list.size() > 0) {
			RBcpDebtPool tblDebtPool = (RBcpDebtPool) list.get(0);
			debtContVO.setTotalDebtRemainAmount(tblDebtPool.getTotalDebtRemainAmount());
			debtContVO.setPoolRiskAmt(factfinancebaseservice.calculatePoolRiskAvailableAmtByBusinessNo(mastContno));// 池敞口余额
		}

		// if(cache=="1"||cache.equals("1"))
		// {
		// if(listdtl.size()>0)
		// {
		// listinfo.addAll(listdtl);
		// }
		// if(listinfo.size()>0)
		// {
		// for(int i=0;i<listinfo.size();i++)
		// {
		// RBcpAppliBussDtl bussdtl = (RBcpAppliBussDtl) listinfo.get(i);
		// totalAmount += bussdtl.getBillsAmount().doubleValue();
		// }
		// }
		// }
		// totalNum = listinfo.size();
		// debtContVO.setTotalNum(totalNum);
		// debtContVO.setTotalAmount(new BigDecimal(totalAmount));
		debtContVO.setLoanPercent(debtContVO.getLoanPercent() != null ? debtContVO.getLoanPercent() : loanpercent);// 融资比例
		return debtContVO;
	}

	/**
	 *
	 * @Description: 应收账款转让根据合同编号查询合同信息和业务品种信息
	 * @author jialei.zhang
	 * @Created 2013-5-9下午02:38:35
	 * @param commonQueryVO
	 * @return
	 * @throws CommonException
	 */
	@Override
	public DebtBussInfoVO getContDebtInfoByMastContno(DebtCommonQryVO commonQueryVO) throws ScubeBizException {
		DebtContVO bCntDebtInfo = null;
		if (null != commonQueryVO && StringUtil.isStrNotEmpty(commonQueryVO.getMastContno())) {
			bCntDebtInfo = bCntDebtInfoService.queryContInfoByMastContno(commonQueryVO.getMastContno());
		} else {
			log.error("合同号丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_30000), BCntErrorConstant.SCF_BAS_CNT_30000);
		}
		if (bCntDebtInfo == null) {
			log.error("保理合同信息丢失！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_30002), BCntErrorConstant.SCF_BAS_CNT_30002);
		}
		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(bCntDebtInfo, debtVO);
		debtVO.setCustcdBuyer(commonQueryVO.getCustcdBuyer_Q());
		debtVO.setCustcdSaller(bCntDebtInfo.getCustcd());
		debtVO.setCnameSeller(bCntDebtInfo.getCname());
		debtVO.setBussType(bCntDebtInfo.getSupplyChainPdId());
		if (StringUtil.isEmpty(debtVO.getBalanceAccount())) {
			debtVO.setBalanceAccount(debtVO.getAccountNo());
		} else if (StringUtil.isEmpty(debtVO.getAccountNo())) {
			debtVO.setAccountNo(debtVO.getBalanceAccount());
		}
		debtVO.setAppno(commonQueryVO.getAppno_Q());
		BigDecimal loanpercent = new BigDecimal(0);
		if (bCntDebtInfo.getLoanPercent() == null) {
			debtVO.setLoanPercent(loanpercent);
		}
		return debtVO;
	}

	/**
	 *
	 * @Description: 应收账款反转让使用 获得业务申请业务明细表
	 * @author mengjiajia
	 * @Created 2012-7-26下午02:41:38
	 * @param appno
	 * @param bussType
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page getRBcpDebtBussDtl(int pageNo, int pageSize, RBcpAppliBussInfo rBcpAppliBussInfo, String cache) throws ScubeBizException {
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);

		List resultList = new ArrayList();
		if (rBcpAppliBussInfo == null) {
			page.setRecords(resultList);
			page.setTotalRecord(0);
			return page;
		}
		String appno = rBcpAppliBussInfo.getAppno();
		String bussType = "";
		String flag3 = "";
		List list = new ArrayList();
		if (StringUtil.isStrNotEmpty(appno)) {
			list = getTblAppliBussDetail(appno, bussType);
		}
		String id = "";
		if (StringUtil.isStrNotEmpty(rBcpAppliBussInfo.getId())) {
			id = rBcpAppliBussInfo.getId();
		}
		if (flag3 != null && flag3.equals("1")) {
			for (int i = 0; i < list.size(); i++) {// 获取流程业务中读取数据
				RBcpAppliBussDtl appliVO = (RBcpAppliBussDtl) list.get(i);
				if (id != null) {
					if (appliVO.getDebtId().equals(id)) {
						DebtBillsInfoVO billvo = new DebtBillsInfoVO();
						BeanUtils.copyProperties(billvo, appliVO);
						billvo.setId(appliVO.getDebtId());
						billvo.setRebateAmounts(appliVO.getBuyBackAmount());
						billvo.setRebatebalance(appliVO.getRemainingAmount().subtract(billvo.getRebateAmounts()));
						resultList.add(billvo);// bussDetail中的ID与正式表中的ID不一致，DebtID才是一致
					}
				}
			}
		} else if (flag3 != null && flag3.equals("2")) {
			// 应收账款查询列表
			// PageQueryResult pageQueryResult =
			// financingService.getInvoiceFinancingQuery(debtCommonQryVO);
			// List list1=pageQueryResult.getQueryResult();//正式表读取发票
			// if(list1!=null && list1.size()>0){
			// Iterator iters = list1.iterator();
			// while(iters.hasNext()){
			// DebtBillsInfoVO debtVO = (DebtBillsInfoVO)iters.next();
			// debtVO.setDebtId(debtVO.getId());
			// if(!DataFormat.isEmpty(rebateAmount_Q)){
			// debtVO.setRebateAmounts(new BigDecimal(rebateAmount_Q));
			// }else{
			// debtVO.setRebateAmounts(new BigDecimal("0"));
			// }
			// debtVO.setRebatebalance(debtVO.getRemainingAmount().subtract(debtVO.getRebateAmounts()));
			// for(int i = 0; i < list.size() ; i++){
			// AppliBussDetailVO applyDebtVO = (AppliBussDetailVO) list.get(i);
			// if(debtVO.getId().equals(applyDebtVO.getDebtId())){
			// debtVO.setId(applyDebtVO.getDebtId());
			// debtVO.setDebtId(applyDebtVO.getDebtId());
			// list.remove(i);
			// break;
			// }
			// }
			// resultList.add(debtVO);//bussDetail中的ID与正式表中的ID不一致，DebtID才是一致
			// }
			// }
		} else {
			if (cache.equals("0") || cache == "0") {
				listdtl.clear();
			}

			if (listdtl.size() > 0) {
				list.addAll(listdtl);
			}
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					RBcpAppliBussDtl bussdtl = (RBcpAppliBussDtl) list.get(i);
					AppliBussDetailVO applVO = new AppliBussDetailVO();
					BeanUtils.copyProperties(bussdtl, applVO);
					applVO.setId(applVO.getDebtId());
					applVO.setRebateAmounts(applVO.getBuyBackAmount());
					// applVO.setRebatebalance(applVO.getRemainingAmount().subtract(applVO.getRebateAmounts()));
					resultList.add(applVO);// bussDetail中的ID与正式表中的ID不一致，DebetNo才是一致
				}
			}
		}
		page.setRecords(resultList);
		page.setTotalRecord(resultList.size());
		return page;
	}

	/**
	 *
	 * @Description: 获得业务申请业务明细表
	 * @author Administrator
	 * @Created 2012-7-26下午02:41:38
	 * @param appno
	 * @param bussType
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getTblAppliBussDetail(String appno, String bussType) throws ScubeBizException {
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> list = rbcpapplibussdtldao.queryAppliBussDetailByAppno(appno, bussType);
		List returnList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl bussdtl = (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl) list.get(i);
			RBcpAppliBussDtl bussdtlVO = new RBcpAppliBussDtl();
			BeanUtils.copyProperties(bussdtl, bussdtlVO);
			String debtId = bussdtlVO.getDebtId();// 主表ID
			RBcpDebtBaseInfo baseinfo = new RBcpDebtBaseInfo();
			baseinfo.setId(debtId);
			RBcpDebtBaseInfo bcpDebtBaseInfo = rBcpDebtBaseInfoService.findRBcpDebtBaseInfoByKey(baseinfo);
			bussdtlVO.setBussContcode(bcpDebtBaseInfo.getBussContcode());
			bussdtlVO.setDeadline(bcpDebtBaseInfo.getDeadline());
			bussdtlVO.setBillsAmountView(bcpDebtBaseInfo.getBillsAmountView());
			bussdtlVO.setClaimStatus(bcpDebtBaseInfo.getClaimStatus());
			bussdtlVO.setGracePeriod(bcpDebtBaseInfo.getGracePeriod());
			if (!StringUtils.isEmpty(bcpDebtBaseInfo.getDebetNo())) {
				BLanLnciBase lnciInfo = blanlncibaseservice.findBLanLnciBaseByDebtId(bcpDebtBaseInfo.getDebetNo());
				if (lnciInfo != null) {
					bussdtlVO.setDebetId(lnciInfo.getDebetId());
				}
			}
			returnList.add(bussdtlVO);
		}
		return returnList;
	}

	/**
	 * 获取该合同下的所有的融资信息
	 * 
	 * @return
	 * @throws CommonException
	 */
	@Override
	public Page getLanLnciInfoByContno(int pageNo, int pageSize, RBcpAppliBussInfo appliBussInfo) throws ScubeBizException {
		String custcdSaller_Q = appliBussInfo.getCustcdSaller();// 卖方客户名称
		String custcdBuyer_Q = appliBussInfo.getCustcdBuyer();// 买方客户名称
		String mastContno = appliBussInfo.getMastContno(); // 合同号
		String appno = appliBussInfo.getAppno(); // 申请编号
		String debetNo_Q = appliBussInfo.getDebetNo(); // 借据号 DEBET_NO
		// String billId_Q = "";
		String flag1 = "";// 有appno时添加
		DebtCommonQryVO commonQueryVO = new DebtCommonQryVO();
		HashMap<String, RBcpAppliRepayment> payLoanInfoMap = new HashMap<String, RBcpAppliRepayment>();
		HashMap<String, BMrnAppliAcctInfo> payBillsInfoMap = new HashMap<String, BMrnAppliAcctInfo>();
		List<RBcpAppliRepayment> loanList = rbcpapplirepaymentservice.queryTblAppliRepaymentInfoByAppno(appno); // 还款信息--流贷还本息信息
		List<BMrnAppliAcctInfo> billsList = mrnacctinfoservice.findBMrnAppliAcctInfoByAppno(appno); // 还款信息--银承入保证金信息
		if (loanList != null && loanList.size() > 0) {
			for (int i = 0; i < loanList.size(); i++) {
				RBcpAppliRepayment payInfo = loanList.get(i);
				if (!StringUtil.isEmpty(flag1)) {
					if (debetNo_Q.indexOf(payInfo.getDebetNo()) != -1) {
						debetNo_Q = debetNo_Q + "/f" + payInfo.getDebetNo();
					}
				} else {
					debetNo_Q = debetNo_Q + "/f" + payInfo.getDebetNo();
				}
				payLoanInfoMap.put(payInfo.getDebetNo(), payInfo);
			}
		}
		if (billsList != null && billsList.size() > 0) {
			for (int i = 0; i < billsList.size(); i++) {
				BMrnAppliAcctInfo payBillsInfo = billsList.get(i);
				if (!StringUtil.isEmpty(flag1)) {
					if (debetNo_Q.indexOf(payBillsInfo.getDebetNo()) != -1) {
						debetNo_Q = debetNo_Q + "/f" + payBillsInfo.getDebetNo();
					}
				} else {
					debetNo_Q = debetNo_Q + "/f" + payBillsInfo.getDebetNo();
				}
				payBillsInfoMap.put(payBillsInfo.getDebetNo(), payBillsInfo);
			}
		}

		if (!StringUtil.isEmpty(debetNo_Q)) {
			if (debetNo_Q.startsWith("/f")) {
				debetNo_Q = debetNo_Q.replaceFirst("/f", "");
			}
			if (debetNo_Q.split("/f").length == 0) {
				debetNo_Q = "";
			}
		}

		pageSize = Integer.MAX_VALUE;
		commonQueryVO.setCustcdSaller_Q(custcdSaller_Q);
		commonQueryVO.setCustcdBuyer_Q(custcdBuyer_Q);
		// commonQueryVO.setMastContno_Q(mastContno);//台账查询需要业务合同号
		commonQueryVO.setMastContno(mastContno);
		commonQueryVO.setAppno_Q(appno);
		commonQueryVO.setDebetNo_Q(debetNo_Q == null ? "" : debetNo_Q);
		commonQueryVO.setPageIndex(pageNo);
		commonQueryVO.setPageSize(pageSize);

		Page pageQueryResult = getLnciBaseInfoByDebetNosAndMap(commonQueryVO, payLoanInfoMap, payBillsInfoMap, null);

		return pageQueryResult;
	}

	/**
	 * 点击新增按钮查询列表
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param commonQueryVO
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page queryRBcpDebtBaseInfo(int pageNo, int pageSize, DebtCommonQryVO commonQueryVO, List<RBcpAppliBussDtl> list) throws ScubeBizException {
		String relation_v = "";// this.getCommQueryServletRequest().getParameter("relation_v");//组装后的发票Id
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> listqry = getInvoiceDebtBackAddQry(commonQueryVO, list);
		// id判断
		List resultList = new ArrayList();
		if (listqry != null && listqry.size() > 0) {
			for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo debtbaseinfo : listqry) {
				DebtBillsInfoVO debtVO = new DebtBillsInfoVO();
				BeanUtils.copyProperties(debtbaseinfo, debtVO);
				if (!StringUtil.isEmpty(relation_v)) {
					if (relation_v.indexOf(String.valueOf(debtVO.getId())) != -1) {
						debtVO.setSelect(true);
					}
				}
				resultList.add(debtVO);
			}

		}
		Page queryResult = new Page();
		queryResult.setRecords(resultList);
		queryResult.setPageNo(pageNo);
		queryResult.setPageSize(pageSize);
		queryResult.setTotalRecord(resultList.size());

		return queryResult;
	}

	/**
	 * 回购申请发票添加
	 * 
	 * @author zhuujun.hou
	 * @date 2011-10-12
	 * @param commonQueryVO
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> getInvoiceDebtBackAddQry(DebtCommonQryVO commonQueryVO, List list) {
		log.info("回购发票添加 method:getInvoiceDebtBackAddQry begin");

		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("status1", DebtConstants.INVOICE_STATUS_PURCHASED);
		omap.put("status2", DebtConstants.INVOICE_STATUS_FINANCED);
		omap.put("issueFlag", DebtConstants.ISSUE_FLAG_FALSE);
		omap.put("poolFlag", DebtConstants.POOL_FLAG_OUT_POOL);
		omap.put("isLocked", ScfBasConstant.LOCKED);
		if (StringUtil.isStrNotEmpty(commonQueryVO.getAppno_Q())) {
			omap.put("lockAppno", commonQueryVO.getAppno_Q());
		}
		omap.put("state", ScfBasConstant.FLAG_ON);
		if (!StringUtil.isEmpty(commonQueryVO.getMastContno())) {
			omap.put("mastContno", commonQueryVO.getMastContno());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getCustcdBuyer_Q())) {
			omap.put("custcdBuyer", commonQueryVO.getCustcdBuyer_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getInsertDate_from_Q())) { // 发票登记日期
			omap.put("insertDate1", commonQueryVO.getInsertDate_from_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getInsertDate_to_Q())) { // 发票登记日期
			omap.put("insertDate2", commonQueryVO.getInsertDate_to_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getPurchaseDate_from_Q())) { // 承购日期起
			omap.put("purchaseDate1", commonQueryVO.getPurchaseDate_from_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getPurchaseDate_to_Q())) { // 承购日期止
			omap.put("purchaseDate2", commonQueryVO.getPurchaseDate_to_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getBillsDate_from_Q())) { // 发票日期
			omap.put("billsDate1", commonQueryVO.getBillsDate_from_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getBillsDate_to_Q())) { // 发票日期
			omap.put("billsDate2", commonQueryVO.getBillsDate_to_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getEndDate_from_Q())) { // 到期日
			omap.put("debtEnd1", commonQueryVO.getEndDate_from_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getEndDate_to_Q())) { // 到期日
			omap.put("debtEnd2", commonQueryVO.getEndDate_to_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getBillsNo_Q())) {// 凭证编号
			omap.put("billsNo", commonQueryVO.getBillsNo_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getBillsType_Q())) {// 凭证类型
			omap.put("billsType", commonQueryVO.getBillsType_Q());
		}
		log.info("回购发票添加method:getInvoiceDebtBackAddQry end");
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> listdebt = iRBcpDebtBaseInfoDAO.getInvoiceDebtBackAddQry(omap).getRecords();
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> result = listdebt;
		if (listdebt.size() > 0 && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				RBcpAppliBussDtl bussdtl = (RBcpAppliBussDtl) list.get(i);
				RBcpDebtBaseInfo baseinfo = new RBcpDebtBaseInfo();
				BeanUtils.copyProperties(bussdtl, baseinfo);
				String billsNo = baseinfo.getBillsNo();
				for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo baseInfo2 : listdebt) {
					String billsNo2 = baseInfo2.getBillsNo();
					if (billsNo.equals(billsNo2) || billsNo == billsNo2) {
						result.remove(baseInfo2);
						break;
					}
				}
			}
		}
		return result;
	}

	/**
	 * 缓存应收账款列表信息
	 */
	@Override
	public void cacheAdd(List<RBcpAppliBussDtl> list) {
		log.debug("开始缓存=============");
		if (list.size() > 0) {
			for (RBcpAppliBussDtl dtl : list) {
				dtl.setDebtId(dtl.getId());
				listdtl.add(dtl);
			}
		}
	}

	@Override
	@Transactional
	public int batchDeleteRBcpDebtBaseInfo(List<RBcpAppliBussDtl> list, String appno) {
		int rows = 0;
		if (list.size() > 0) {
			for (RBcpAppliBussDtl rBcpAppliBussDtl : list) {
				String mrnid = rBcpAppliBussDtl.getId();
				if (StringUtil.isEmpty(appno)) {
					for (RBcpAppliBussDtl cachemrn : listdtl) {
						String cacheid = cachemrn.getId();
						if (mrnid.equals(cacheid)) {
							listdtl.remove(cachemrn);
							rows++;
							break;
						}
					}
				} else {
					RBcpAppliBussDtlExample exampledtl = new RBcpAppliBussDtlExample();
					RBcpAppliBussDtlExample.Criteria cridtl = exampledtl.createCriteria();
					cridtl.andDebtIdEqualTo(mrnid);
					cridtl.andAppnoEqualTo(appno);
					List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> flagdtl = rbcpapplibussdtldao.selectByExample(exampledtl);
					if (flagdtl.size() > 0) {
						String debtId = flagdtl.get(0).getDebtId();
						RBcpDebtBaseInfoExample example = new RBcpDebtBaseInfoExample();
						RBcpDebtBaseInfoExample.Criteria cri = example.createCriteria();
						cri.andIdEqualTo(debtId);
						com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo record = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
						record.setIsLocked("0");
						record.setLockAppno(null);
						iRBcpDebtBaseInfoDAO.updateByExampleSelective(record, example);
						rows += rbcpapplibussdtldao.deleteByExample(exampledtl);
					} else {
						if (listdtl.size() > 0) {
							for (RBcpAppliBussDtl cachemrn : listdtl) {
								String cacheid = cachemrn.getId();
								if (mrnid.equals(cacheid)) {
									listdtl.remove(cachemrn);
									rows++;
									break;
								}
							}
						}
					}
				}
			}
		}
		return rows;
	}

	/**
	 *
	 * @Description:应收账款回款关联融资列表查询
	 * @param commonQueryVO
	 * @param payLoanInfoMap
	 * @param payBillsInfoMap
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page getLnciBaseInfoByDebetNosAndMap(DebtCommonQryVO commonQueryVO, Map payLoanInfoMap, Map payBillsInfoMap, String factType)
			throws ScubeBizException {
		Page lnciInfoResult = new Page();
		lnciInfoResult = blanlncibaseservice.getLnciBaseInfoByDebetNo(commonQueryVO);// 借据基本信息
		List<Object> lnciInfoList = lnciInfoResult.getRecords();
		List<Object> resultList = new ArrayList<Object>();
		for (int i = 0; i < lnciInfoList.size(); i++) {
			DebtLnciBaseInfoVO lnciInfo = new DebtLnciBaseInfoVO();
			BeanUtils.copyProperties(lnciInfoList.get(i), lnciInfo);
			BigDecimal zero = new BigDecimal("0");
			if (!StringUtil.isEmpty(lnciInfo.getLnciType())) {
				if (ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(lnciInfo.getLnciType())) { // 出账方式
					// lnciInfo.setBailAccount(null);
					// lnciInfo.setAddBailAmount(null);
					// lnciInfo.setBailAmount(null);
					lnciInfo.setRepayIntamt(zero);
					lnciInfo.setRepayBalamt(zero);
				} else if (ScfBasConstant.LOAN_WAY_BANK_ACCEPTENCE.equals(lnciInfo.getLnciType())) {
					if (null != lnciInfo.getBailAmount()) {
						lnciInfo.setBailAmount(zero);
					}
					if (null != lnciInfo.getAddBailAmount()) {
						lnciInfo.setBailAmount(lnciInfo.getBailAmount().add(lnciInfo.getAddBailAmount()));
						lnciInfo.setAddBailAmount(zero);
					}
					// lnciInfo.setTotalRateAmount(null);
					// lnciInfo.setTotalRateRemainAmount(null);
					lnciInfo.setRepayIntamt(null);
					lnciInfo.setRepayBalamt(null);
				}
				lnciInfo.setAvaliableRiskAmt(lnciInfo.getLnciBal().subtract(lnciInfo.getBailAmount()==null?zero:lnciInfo.getBailAmount()).subtract(lnciInfo.getAddBailAmount()==null?zero:lnciInfo.getAddBailAmount())
						.subtract((lnciInfo.getInitCashEqtAmt()==null?zero:lnciInfo.getInitCashEqtAmt()).subtract(lnciInfo.getAddCashEqtAmt()==null?zero:lnciInfo.getAddCashEqtAmt())));// 敞口余额
				lnciInfo.setPayAmount(zero);
				lnciInfo.setRepayAmount(zero);
				lnciInfo.setAmountOver(zero);
				BigDecimal receInt = lnciInfo.getReceivableInt() != null ? lnciInfo.getReceivableInt() : new BigDecimal(0);
				BigDecimal recePunInt = lnciInfo.getReceivablePunishInt() != null ? lnciInfo.getReceivablePunishInt() : new BigDecimal(0);
				lnciInfo.setInTableInt(receInt.add(recePunInt));// 表内欠息 = 应收欠息 +
																// 应收罚息
			}
			RBcpAppliRepayment payLoanInfo = (RBcpAppliRepayment) payLoanInfoMap.get(lnciInfo.getDebetNo());
			if (payLoanInfo != null) {
				lnciInfo.setRepayAmount(payLoanInfo.getRepayAmount());// 还款金额
				// lnciInfo.setMastContno(payLoanInfo.getMastContno());//主合同号
				lnciInfo.setPayAmount(payLoanInfo.getPayAmount());// 入账金额
				lnciInfo.setAmountOver(payLoanInfo.getAmountOver());// 尾款金额
				lnciInfo.setRepayIntamt(payLoanInfo.getRepayIntamt());// 实际还息金额
				lnciInfo.setRepayBalamt(payLoanInfo.getRepayBalamt());// 实际还本金额
				lnciInfo.setBailAccount(payLoanInfo.getAccountNo());// 保证金账号
			}
			BMrnAppliAcctInfo payBillsInfo = (BMrnAppliAcctInfo) payBillsInfoMap.get(lnciInfo.getDebetNo());
			if (payBillsInfo != null) {
				lnciInfo.setRepayAmount(payBillsInfo.getAmount());// 还款金额
				lnciInfo.setAddBailAmount(payBillsInfo.getAmount());// 还款金额
				lnciInfo.setPayAmount(payBillsInfo.getPayAmount());// 入账金额
				lnciInfo.setAmountOver(payBillsInfo.getPayAmount().subtract(payBillsInfo.getAmount()));// 尾款金额
				lnciInfo.setBailAccount(payBillsInfo.getBailAccountno());// 保证金账户
			}
			resultList.add(lnciInfo);
		}
		lnciInfoResult.setRecords(resultList);
		lnciInfoResult.setPageNo(commonQueryVO.getPageIndex());
		lnciInfoResult.setPageSize(commonQueryVO.getPageSize());
		lnciInfoResult.setTotalRecord(resultList.size());
		return lnciInfoResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doWorkForPass(String appNo) {
		// 审批通过，业务申请业务明细表数据来源相应信息更改锁定状态未锁定
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> dtlinfo = rbcpapplibussdtldao.selectByAppno(appNo);
		List<String> debtIds = new ArrayList<String>();
		for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl dtl : dtlinfo) {
			debtIds.add(dtl.getDebtId());
		}
		// 修改记录来源状态
		RBcpDebtBaseInfoExample example2 = new RBcpDebtBaseInfoExample();
		RBcpDebtBaseInfoExample.Criteria crri = example2.createCriteria();
		if (debtIds.size() > 0) {
			crri.andIdIn(debtIds);
			com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo record = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
			record.setIsLocked("0");
			iRBcpDebtBaseInfoDAO.updateByExampleSelective(record, example2);
		}
		List<RBcpAppliBussDtl> dtllist = getTblAppliBussDetail(appNo, null);
		List<RBcpDebtBaseInfo> listinfo = new ArrayList<RBcpDebtBaseInfo>();
		if (dtllist.size() > 0) {
			for (RBcpAppliBussDtl dtl : dtllist) {
				RBcpDebtBaseInfo baseInfo = new RBcpDebtBaseInfo();
				BeanUtils.copyProperties(dtl, baseInfo);
				baseInfo.setId(dtl.getDebtId());
				listinfo.add(baseInfo);
			}
		}
		RBcpAppliBussInfo tabi = rBcpAppliBussInfoService.findByAppno(appNo);
		AppliBussInfoVO appliBussInfoVO = new AppliBussInfoVO();
		BeanUtils.copyProperties(tabi, appliBussInfoVO);
		appliBussInfoVO.setTotalAmount(appliBussInfoVO.getTotalDebtAmount());// 本次回购金额存入数据库totalDebtAmout字段，调用方法前将该字段值赋给totalAmout
		debtBackApplyPassSubmit(appliBussInfoVO, listinfo, false);
	}

	@Override
	public void doWorkForReject(String appNo) {
		scfApplyService.releaseAppliDebtBaseInfo(appNo);
		// debtBackApplyBackToModify(appNo, false);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doWorkForSubmit(String appNo) throws ScubeBizException {
		List<RBcpAppliBussDtl> dtllist = getTblAppliBussDetail(appNo, null);
		List<RBcpDebtBaseInfo> listinfo = new ArrayList<RBcpDebtBaseInfo>();
		if (dtllist.size() > 0) {
			for (RBcpAppliBussDtl dtl : dtllist) {
				RBcpDebtBaseInfo baseInfo = new RBcpDebtBaseInfo();
				BeanUtils.copyProperties(dtl, baseInfo);
				baseInfo.setId(dtl.getDebtId());
				listinfo.add(baseInfo);
			}
		}
		RBcpAppliBussInfo tabi = rBcpAppliBussInfoService.findByAppno(appNo);
		AppliBussInfoVO appliBussInfoVO = new AppliBussInfoVO();
		BeanUtils.copyProperties(tabi, appliBussInfoVO);
		debtBackApplySubmit(appliBussInfoVO, listinfo, false);
	}

	@Override
	public void doWorkForBack(String appNo) {
		debtBackApplyBackToModify(appNo, false);
	}

}

/**
 * 
 */
package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IDebtFinancingService;
import com.huateng.scf.bas.common.service.IScfApplyService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.prd.service.IBPrdWkflowCopService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.nrec.bcp.dao.IRBcpDebtInfoDAO;
import com.huateng.scf.nrec.bcp.dao.ext.ExtNrecBcpDAO;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfo;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.INBLanLnciBaseService;
import com.huateng.scf.nrec.bcp.service.INFactFinanceBaseService;
import com.huateng.scf.nrec.bcp.service.INFactoringDebtBackService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtPoolService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scf.nrec.bcp.vo.NDebtBillsInfoVO;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBussDtlDAO;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.DebtLnciBaseInfoVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpAppliRepayment;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scf.rec.bcp.service.IRBcpAppliRepaymentService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>应收账款反转让实现类</p>
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
@Service("NFactoringDebtBackServiceImpl")
public class NFactoringDebtBackServiceImpl implements INFactoringDebtBackService, DealEndFlowService, DealInFlowService
{
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "ExtNrecBcpDAO")
	ExtNrecBcpDAO extnrecbcpdao;

	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bcntbcpinfoservice;

	@Resource(name = "BPrdWkflowCopServiceImpl")
	IBPrdWkflowCopService bPrdWkflowCopService;

	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;

	@Resource(name = "NRBcpAppliBussInfoServiceImpl")
	INRBcpAppliBussInfoService nrbcpapplibussinfoservice;

	@Resource(name = "NRBcpAppliBussDtlServiceImpl")
	INRBcpAppliBussDtlService nrbcpapplibussdtlservice;

	// 应收账款基本信息
	@Resource(name = "IRBcpDebtInfoDAO")
	IRBcpDebtInfoDAO irbcpdebtinfodao;

	@Autowired
	ScubeUserService scubeUserService;

	// 应收账款单据信息表
	@Resource(name = "RBcpDebtInfoServiceImpl")
	IRBcpDebtInfoService rbcpdebtinfoservice;

	// 供应链借据表
	@Resource(name = "NBLanLnciBaseServiceImpl")
	INBLanLnciBaseService nblanlncibaseservice;

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
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;

	@Resource(name = "NRBcpDebtPoolServiceImpl")
	INRBcpDebtPoolService nrbcpdebtpoolservice;

	@Resource(name = "DebtFinancingServiceImpl")
	IDebtFinancingService debtfinancingservice;

	@Resource(name = IScfApplyService.BEAN_ID)
	IScfApplyService scfApplyService;

	@Resource(name = "NFactFinanceBaseServiceImpl")
	INFactFinanceBaseService nfactfinancebaseservice;

	// 通知书信息
//	@Resource(name = "NBNteNoticeBaseServiceImpl")
//	INBNteNoticeBaseService nbntenoticebaseservice;
	/**
	 * 应收账款反转让申请保存
	 */
	@Override
	public String DebtBackApplySaveUpdate(DebtBussInfoVO debtBussInfoVO, List<NDebtBillsInfoVO> insertDebtList)
			throws ScubeBizException
	{
		String in_appno = debtBussInfoVO.getAppno();
		// 根据申请类型获取流程名称
		String businessnoType = "";// 申请类型
		String workApplyType = ""; // 申请业务类型
		if(StringUtil.isEmpty(in_appno))
		{
			if(!StringUtil.isEmpty(debtBussInfoVO.getFactType()))
			{
				String factType = debtBussInfoVO.getFactType();
				if(ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
						|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType)
						|| ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType))
				{// 应收账款池
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_POOL_BUYBACK;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_POOL_BUYBACK_APPLY;
				}
				else if(ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(factType))
				{// 信保保理
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_BUY_BACK_APPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_CREDIT_BUY_BACK_APPLY;
				}
				else if(ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(factType))
				{// 双保理
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_BUY_BACK_APPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_DOUBLE_BUY_BACK_APPLY;
				}
				else if(ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType))
				{// 租赁保理
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_LEASE_BUY_BACK_APPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_LEASE_BUY_BACK_APPLY;
				}
				else if(ScfBasConstant.FACT_TYPE_INLAND.equals(factType)
						|| ScfBasConstant.FACT_TYPE_REVERSE.equals(factType)
						|| ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType))
				{// 应收账款
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORINGACCOUNTREPURAPPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_ACCOUNTREPUR_APPLY;
				}
			}
			else
			{
				log.error("没有匹配到对应的申请类型！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10018),
						RBcpErrorConstant.SCF_REC_BCP_10018);
			}
			workApplyType = "N-" + workApplyType;
			debtBussInfoVO.setApplyType(businessnoType);
			in_appno = debtfinancingservice.saveFactoringAppBasicInfo(debtBussInfoVO, businessnoType, workApplyType);
		}
		else
		{
			debtfinancingservice.saveFactoringAppBasicInfo(debtBussInfoVO, "", "");
		}

		if(!StringUtil.isEmpty(in_appno))
		{
			debtBussInfoVO.setAppno(in_appno);
			// 应收账款单据list数据
			// 保存到R_BCP_APPLI_BUSS_INFO【业务申请业务主表】
			debtBussInfoVO.setApplyType(RBcpDebtConstant.APPLY_TYPE_REPURCHASE);
			String debtId = nrbcpapplibussinfoservice.saveDebtBackAppliBussInfo(debtBussInfoVO);
			// // 保存到 R_BCP_APPLI_BUSS_DTL【业务申请业务明细表】
			nrbcpapplibussdtlservice.saveDebtBackApplyBussDetail(insertDebtList, debtBussInfoVO.getAppno(), debtId);
		}
		return in_appno;
	}

	/**
	 * 应收账款反转让申请提交并发起流程
	 */
	@Override
	public void DebtBackWriteSubmitUpdate(DebtBussInfoVO debtBussInfoVO, List<NDebtBillsInfoVO> insertDebtList)
			throws ScubeBizException
	{
		// 应收账款单据list数据
		// 保存到R_BCP_APPLI_BUSS_INFO【业务申请业务主表】
		String debtId = nrbcpapplibussinfoservice.saveDebtBackAppliBussInfo(debtBussInfoVO);
		// // 保存到 R_BCP_APPLI_BUSS_DTL【业务申请业务明细表】
		nrbcpapplibussdtlservice.saveDebtBackApplyBussDetail(insertDebtList, debtBussInfoVO.getAppno(), debtId);

		// 流程操作
		BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice
				.findBPbcAppliBaseInfoByKey(debtBussInfoVO.getAppno());
		scfWorkFlowService.FactoringProcessDone(appliBaseInfo);
	}

	/**
	 * 应收账款回购申请流程回执
	 * 
	 * @param appliBussInfoVO
	 * @param insertDebtList
	 * @throws ScubeBizException
	 */
	@Override
	public void DebtBackApplyReceiptUpdate(DebtBussInfoVO debtBussInfoVO, List<NDebtBillsInfoVO> insertDebtList)
			throws ScubeBizException
	{
		BCntBcpInfoVO bCntBcpInfoVO = bcntbcpinfoservice
				.queryBCntBcpInfoByMastContno(debtBussInfoVO.getMastContno());
		debtBussInfoVO.setFactType(bCntBcpInfoVO.getFactType());
		debtBussInfoVO.setFinancingType(bCntBcpInfoVO.getFinancingType());
		
		debtfinancingservice.factoringDebtBackAddApply(insertDebtList, debtBussInfoVO);
		debtfinancingservice.releaseAppliDebtBaseInfo(debtBussInfoVO.getAppno()); // 解锁应收账款
		
		if(!StringUtil.isEmpty(debtBussInfoVO.getFinancingType())
				&& ScfBasConstant.T_FINANCING_TYPE_POOL.equals(debtBussInfoVO.getFinancingType()))
		{
			debtBussInfoVO.setFlag(ScfBasConstant.INVOKE_PHASE_BACK_TRANSFER);
			debtfinancingservice.updatePoolRemainAmount(debtBussInfoVO);// 更新池信息（发票余额、可融资余额）
		}
		// 额度操作
		// 合同有追/无追
		String recoverType = debtfinancingservice.getDebtContRecoverType(debtBussInfoVO.getMastContno(),
				debtBussInfoVO.getCustcdBuyer());

		if(ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(debtBussInfoVO.getFactType()) // 信保保理
				|| ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(debtBussInfoVO.getFactType()) // 行内双保理
				|| (ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(debtBussInfoVO.getFactType())
						&& ScfBasConstant.CREDIT_TYPE_WITHOUT_RECOURSE.equals(recoverType)) // 租赁保理无追模式
				|| (ScfBasConstant.FACT_TYPE_INLAND.equals(debtBussInfoVO.getFactType())
						&& ScfBasConstant.CREDIT_TYPE_WITHOUT_RECOURSE.equals(recoverType)) // 国内保理无追模式
				|| (ScfBasConstant.FACT_TYPE_REVERSE.equals(debtBussInfoVO.getFactType())
						&& ScfBasConstant.CREDIT_TYPE_WITHOUT_RECOURSE.equals(recoverType)) // 反向保理无追模式
		)
		{// 买方信用限额额度额度处理-释放
			scfApplyService.creditLimitOfBuyerAppliCommonProcess(debtBussInfoVO.getAppno(),
					ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE, debtBussInfoVO.getTotalAmount());
		}
	}

	// 任务基本信息
	@Override
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(String appno, String factType)
	{
		String process = "";
		if(ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
				|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType)
				|| ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType))
		{// 应收账款池
			process = WorkflowConstant.PROCNAME_FACTORING_POOL_BUYBACK_APPLY;
		}
		else if(ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(factType))
		{// 信保保理
			process = WorkflowConstant.PROCNAME_FACTORING_CREDIT_BUY_BACK_APPLY;
		}
		else if(ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(factType))
		{// 双保理
			process = WorkflowConstant.PROCNAME_FACTORING_DOUBLE_BUY_BACK_APPLY;
		}
		else if(ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType))
		{// 租赁保理
			process = WorkflowConstant.PROCNAME_FACTORING_LEASE_BUY_BACK_APPLY;
		}
		else if(ScfBasConstant.FACT_TYPE_INLAND.equals(factType)
				|| ScfBasConstant.FACT_TYPE_REVERSE.equals(factType)
				|| ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType))
		{// 应收账款
			process = WorkflowConstant.PROCNAME_FACTORING_ACCOUNTREPUR_APPLY;
		}
		process = "N-" + process;
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
	public DebtBussInfoVO getDebtBussInfo(DebtBussInfoVO debtBussInfoVO) throws ScubeBizException
	{
		log.debug("合同编号：" + debtBussInfoVO.getMastContno());
		String appno = debtBussInfoVO.getAppno();
		String mastContno = debtBussInfoVO.getMastContno();
		String custcdBuyer = debtBussInfoVO.getCustcdBuyer();
		String custcdSaller = debtBussInfoVO.getCustcdSaller();

		DebtCommonQryVO commonQueryVO = new DebtCommonQryVO();
		commonQueryVO.setMastContno(mastContno);
		commonQueryVO.setCustcdBuyer_Q(custcdBuyer);
		commonQueryVO.setCustcdSaller_Q(custcdSaller);
		commonQueryVO.setAppno_Q(appno);

		// 业务详情信息
		DebtBussInfoVO debtContVO = new DebtBussInfoVO();
		BigDecimal loanpercent = new BigDecimal(0);
		if(StringUtil.isEmpty(appno))
		{
			debtContVO = nfactfinancebaseservice.getContDebtInfoByMastContno(commonQueryVO);
		}
		else
		{
			RBcpAppliBussInfo tabi = nrbcpapplibussinfoservice.findBcpAppliBussInfoByAppno(appno);
			mastContno = tabi.getMastContno();
			custcdBuyer = tabi.getCustcdBuyer();
			// 贸易对手
			tabi.setCnameBuyer(bcrmbaseinfodao.selectById(tabi.getCustcdBuyer()).getCname());
			// 融资企业
			tabi.setCnameSeller(bcrmbaseinfodao.selectById(tabi.getCustcdSaller()).getCname());
			BeanUtils.copyProperties(tabi, debtContVO);
			debtContVO.setStartDate(tabi.getBillDate());// 合同生效日期
			debtContVO.setEndDate(tabi.getBillEndDate());// 合同到期日期
			BCntBcpInfoVO bCntBcpInfoVO = bcntbcpinfoservice.queryBCntBcpInfoByMastContno(mastContno);
			debtContVO.setLoanPercent(bCntBcpInfoVO.getLoanPercent());// 融资比例
			debtContVO.setFactType(bCntBcpInfoVO.getFactType());
			debtContVO.setFinancingType(bCntBcpInfoVO.getFinancingType());
		}
		// 池融资
		List list = new ArrayList();
		if(!StringUtil.isEmpty(commonQueryVO.getCustcdSaller_Q()))
		{
			list = nrbcpdebtpoolservice.queryDebtPollByMastContno(mastContno, custcdSaller);
		}
		else
		{
			list = nrbcpdebtpoolservice.queryDebtPollByMastContno(mastContno, debtContVO.getCustcdSaller());
		}
		if(list != null && list.size() > 0)
		{
			RBcpDebtPool tblDebtPool = (RBcpDebtPool) list.get(0);
			debtContVO.setTotalDebtRemainAmount(tblDebtPool.getTotalDebtRemainAmount());
			debtContVO.setPoolRiskAmt(nfactfinancebaseservice.calculatePoolRiskAvailableAmtByBusinessNo(mastContno));// 池敞口余额
		}
		debtContVO.setLoanPercent(debtContVO.getLoanPercent() != null ? debtContVO.getLoanPercent() : loanpercent);// 融资比例
		return debtContVO;
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
	public Page getRBcpDebtBussDtl(int pageNo, int pageSize, RBcpAppliBussInfo rBcpAppliBussInfo)
			throws ScubeBizException
	{
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);

		List resultList = new ArrayList();
		if(rBcpAppliBussInfo == null)
		{
			page.setRecords(resultList);
			page.setTotalRecord(0);
			return page;
		}
		String appno = rBcpAppliBussInfo.getAppno();
		String flag3 = "";
		String bussType = "";
		List list = new ArrayList();
		if(StringUtil.isStrNotEmpty(appno))
		{
			list = nrbcpapplibussdtlservice.getTblAppliBussDetail(appno, bussType);
		}
		String id = "";
		if(StringUtil.isStrNotEmpty(rBcpAppliBussInfo.getId()))
		{
			id = rBcpAppliBussInfo.getId();
		}
		if(flag3 != null && flag3.equals("1"))
		{
			for(int i = 0; i < list.size(); i++)
			{// 获取流程业务中读取数据
				RBcpAppliBussDtl appliVO = (RBcpAppliBussDtl) list.get(i);
				if(id != null)
				{
					if(appliVO.getDebtId().equals(id))
					{
						NDebtBillsInfoVO billvo = new NDebtBillsInfoVO();
						BeanUtils.copyProperties(billvo, appliVO);
						billvo.setId(appliVO.getDebtId());
						billvo.setRebateAmounts(appliVO.getBuyBackAmount());
						billvo.setRebatebalance(appliVO.getRemainingAmount().subtract(billvo.getRebateAmounts()));
						resultList.add(billvo);// bussDetail中的ID与正式表中的ID不一致，DebtID才是一致
					}
				}
			}
		}
		else if(flag3 != null && flag3.equals("2"))
		{
			// 应收账款查询列表
//			PageQueryResult pageQueryResult = financingService.getInvoiceFinancingQuery(debtCommonQryVO);
//			List list1 = pageQueryResult.getQueryResult();// 正式表读取发票
//			if (list1 != null && list1.size() > 0)
//			{
//				Iterator iters = list1.iterator();
//				while (iters.hasNext())
//				{
//					NDebtBillsInfoVO debtVO = (NDebtBillsInfoVO) iters.next();
//					debtVO.setDebtId(debtVO.getId());
//					if (!DataFormat.isEmpty(rebateAmount_Q))
//					{
//						debtVO.setRebateAmounts(new BigDecimal(rebateAmount_Q));
//					}
//					else
//					{
//						debtVO.setRebateAmounts(new BigDecimal("0"));
//					}
//					debtVO.setRebatebalance(debtVO.getRemainingAmount()
//							.subtract(debtVO.getRebateAmounts()));
//					for (int i = 0; i < list.size(); i++)
//					{
//						AppliBussDetailVO applyDebtVO = (AppliBussDetailVO) list
//								.get(i);
//						if (debtVO.getId().equals(applyDebtVO.getDebtId()))
//						{
//							debtVO.setId(applyDebtVO.getDebtId());
//							debtVO.setDebtId(applyDebtVO.getDebtId());
//							list.remove(i);
//							break;
//						}
//					}
//					resultList.add(debtVO);// bussDetail中的ID与正式表中的ID不一致，DebtID才是一致
//				}
//			}
		}
		else
		{
			if(list.size() > 0)
			{
				for(int i = 0; i < list.size(); i++)
				{
					RBcpAppliBussDtl bussdtl = (RBcpAppliBussDtl) list.get(i);
					AppliBussDetailVO applVO = new AppliBussDetailVO();
					BeanUtils.copyProperties(bussdtl, applVO);
					applVO.setId(applVO.getDebtId());
//					applVO.setRebateAmounts(applVO.getBuyBackAmount());
					resultList.add(applVO);// bussDetail中的ID与正式表中的ID不一致，DebetNo才是一致
				}
			}
		}
		page.setRecords(resultList);
		page.setTotalRecord(resultList.size());
		return page;
	}

	/**
	 * 获取该合同下的所有的融资信息
	 * @param pageNo
	 * @param pageSize
	 * @param appliBussInfo
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月1日上午9:12:23
	 */
	@Override
	public Page getLanLnciInfoByContno(int pageNo, int pageSize, RBcpAppliBussInfo appliBussInfo)
			throws ScubeBizException
	{
		String custcdSaller_Q = appliBussInfo.getCustcdSaller();// 卖方客户名称
		String custcdBuyer_Q = appliBussInfo.getCustcdBuyer();// 买方客户名称
		String mastContno = appliBussInfo.getMastContno(); // 合同号
		String appno = appliBussInfo.getAppno(); // 申请编号
		String debetNo_Q = appliBussInfo.getDebetNo(); // 应收账款ID
		// String billId_Q = "";
		String flag1 = "";// 有appno时添加
		DebtCommonQryVO commonQueryVO = new DebtCommonQryVO();
		HashMap<String, RBcpAppliRepayment> payLoanInfoMap = new HashMap<String, RBcpAppliRepayment>();
		HashMap<String, BMrnAppliAcctInfo> payBillsInfoMap = new HashMap<String, BMrnAppliAcctInfo>();
		List<RBcpAppliRepayment> loanList = rbcpapplirepaymentservice.queryTblAppliRepaymentInfoByAppno(appno); // 还款信息--流贷还本息信息
		List<BMrnAppliAcctInfo> billsList = mrnacctinfoservice.findBMrnAppliAcctInfoByAppno(appno); // 还款信息--银承入保证金信息
		if(loanList != null && loanList.size() > 0)
		{
			for(int i = 0; i < loanList.size(); i++)
			{
				RBcpAppliRepayment payInfo = loanList.get(i);
				if(!StringUtil.isEmpty(flag1))
				{
					if(debetNo_Q.indexOf(payInfo.getDebetNo()) != -1)
					{
						debetNo_Q = debetNo_Q + "/f" + payInfo.getDebetNo();
					}
				}
				else
				{
					debetNo_Q = debetNo_Q + "/f" + payInfo.getDebetNo();
				}
				payLoanInfoMap.put(payInfo.getDebetNo(), payInfo);
			}
		}
		if(billsList != null && billsList.size() > 0)
		{
			for(int i = 0; i < billsList.size(); i++)
			{
				BMrnAppliAcctInfo payBillsInfo = billsList.get(i);
				if(!StringUtil.isEmpty(flag1))
				{
					if(debetNo_Q.indexOf(payBillsInfo.getDebetNo()) != -1)
					{
						debetNo_Q = debetNo_Q + "/f" + payBillsInfo.getDebetNo();
					}
				}
				else
				{
					debetNo_Q = debetNo_Q + "/f" + payBillsInfo.getDebetNo();
				}
				payBillsInfoMap.put(payBillsInfo.getDebetNo(), payBillsInfo);
			}
		}

		if(!StringUtil.isEmpty(debetNo_Q))
		{
			if(debetNo_Q.startsWith("/f"))
			{
				debetNo_Q = debetNo_Q.replaceFirst("/f", "");
			}
			if(debetNo_Q.split("/f").length == 0)
			{
				debetNo_Q = "";
			}
		}

		commonQueryVO.setCustcdSaller_Q(custcdSaller_Q);
		commonQueryVO.setCustcdBuyer_Q(custcdBuyer_Q);
		commonQueryVO.setMastContno(mastContno);
		commonQueryVO.setAppno_Q(appno);
		commonQueryVO.setDebetNo_Q(debetNo_Q == null ? "" : debetNo_Q);
		commonQueryVO.setPageIndex(pageNo);
		commonQueryVO.setPageSize(pageSize);

		Page pageQueryResult = this.getLnciBaseInfoByDebetNosAndMap(commonQueryVO, payLoanInfoMap, payBillsInfoMap,
				null);

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
	@SuppressWarnings("unchecked")
	@Override
	public Page InvoiceDebtBackAddQryGetter(int pageNo, int pageSize, 
			DebtCommonQryVO debtCommonQryVO, List<RBcpAppliBussDtl> list)
			throws ScubeBizException
	{
		List<String> debtIds = new ArrayList<String>();
		if(list!=null&&list.size()>0)
		{
			for(RBcpAppliBussDtl bussDtl:list)
			{
				debtIds.add(bussDtl.getDebtId());
			}
		}
		if(debtIds!=null&&debtIds.size()>0)
		{
			debtCommonQryVO.setBussTypeList_Q(debtIds);
		}
		debtCommonQryVO.setPageIndex(pageNo);
		debtCommonQryVO.setPageSize(pageSize);
		debtCommonQryVO.setPageFlag(true);
		Page page = rbcpdebtinfoservice.getInvoiceDebtBackAddQry(debtCommonQryVO);
		List<RBcpDebtInfo> listqry = page.getRecords();
		List<NDebtBillsInfoVO> resultList = new ArrayList<NDebtBillsInfoVO>();
		if(listqry != null && listqry.size() > 0)
		{
			for(RBcpDebtInfo bcpDebtInfo : listqry)
			{
				NDebtBillsInfoVO debtVO = new NDebtBillsInfoVO();
				BeanUtils.copyProperties(bcpDebtInfo, debtVO);
				debtVO.setDebtId(debtVO.getId());
				debtVO.setBuyBackAmount(debtVO.getRemainingAmount());
				resultList.add(debtVO);
			}
		}
		page.setRecords(resultList);
		return page;
	}

	/**
	 * 应收账款回款关联融资列表查询
	 * @param commonQueryVO
	 * @param payLoanInfoMap
	 * @param payBillsInfoMap
	 * @param factType
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月1日上午9:13:20
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page getLnciBaseInfoByDebetNosAndMap(DebtCommonQryVO commonQueryVO, Map payLoanInfoMap, Map payBillsInfoMap,
			String factType) throws ScubeBizException
	{
		Page lnciInfoResult = new Page();
		lnciInfoResult = nblanlncibaseservice.getLnciBaseInfoByDebtId(commonQueryVO);// 借据基本信息
		List<Object> lnciInfoList = lnciInfoResult.getRecords();
		List<Object> resultList = new ArrayList<Object>();
		for(int i = 0; i < lnciInfoList.size(); i++)
		{
			DebtLnciBaseInfoVO lnciInfo = new DebtLnciBaseInfoVO();
			BeanUtils.copyProperties(lnciInfoList.get(i), lnciInfo);
			BigDecimal zero = new BigDecimal("0");
			if(!StringUtil.isEmpty(lnciInfo.getLnciType()))
			{
				if(ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(lnciInfo.getLnciType()))
				{ // 出账方式
					lnciInfo.setRepayIntamt(zero);
					lnciInfo.setRepayBalamt(zero);
				}
				else if(ScfBasConstant.LOAN_WAY_BANK_ACCEPTENCE.equals(lnciInfo.getLnciType()))
				{
					if(null != lnciInfo.getBailAmount())
					{
						lnciInfo.setBailAmount(zero);
					}
					if(null != lnciInfo.getAddBailAmount())
					{
						lnciInfo.setBailAmount(lnciInfo.getBailAmount().add(lnciInfo.getAddBailAmount()));
						lnciInfo.setAddBailAmount(zero);
					}
					lnciInfo.setRepayIntamt(null);
					lnciInfo.setRepayBalamt(null);
				}
				lnciInfo.setAvaliableRiskAmt(lnciInfo.getLnciBal()
						.subtract(lnciInfo.getBailAmount() == null ? zero : lnciInfo.getBailAmount())
						.subtract(lnciInfo.getAddBailAmount() == null ? zero : lnciInfo.getAddBailAmount())
						.subtract((lnciInfo.getInitCashEqtAmt() == null ? zero : lnciInfo.getInitCashEqtAmt())
								.subtract(lnciInfo.getAddCashEqtAmt() == null ? zero : lnciInfo.getAddCashEqtAmt())));// 敞口余额
				lnciInfo.setPayAmount(zero);
				lnciInfo.setRepayAmount(zero);
				lnciInfo.setAmountOver(zero);
				BigDecimal receInt = lnciInfo.getReceivableInt() != null ? lnciInfo.getReceivableInt()
						: new BigDecimal(0);
				BigDecimal recePunInt = lnciInfo.getReceivablePunishInt() != null ? lnciInfo.getReceivablePunishInt()
						: new BigDecimal(0);
				lnciInfo.setInTableInt(receInt.add(recePunInt));// 表内欠息 = 应收欠息 +
																// 应收罚息
			}
			RBcpAppliRepayment payLoanInfo = (RBcpAppliRepayment) payLoanInfoMap.get(lnciInfo.getDebetNo());
			if(payLoanInfo != null)
			{
				lnciInfo.setRepayAmount(payLoanInfo.getRepayAmount());// 还款金额
				// lnciInfo.setMastContno(payLoanInfo.getMastContno());//主合同号
				lnciInfo.setPayAmount(payLoanInfo.getPayAmount());// 入账金额
				lnciInfo.setAmountOver(payLoanInfo.getAmountOver());// 尾款金额
				lnciInfo.setRepayIntamt(payLoanInfo.getRepayIntamt());// 实际还息金额
				lnciInfo.setRepayBalamt(payLoanInfo.getRepayBalamt());// 实际还本金额
				lnciInfo.setBailAccount(payLoanInfo.getAccountNo());// 保证金账号
			}
			BMrnAppliAcctInfo payBillsInfo = (BMrnAppliAcctInfo) payBillsInfoMap.get(lnciInfo.getDebetNo());
			if(payBillsInfo != null)
			{
				lnciInfo.setRepayAmount(payBillsInfo.getAmount());// 还款金额
				lnciInfo.setAddBailAmount(payBillsInfo.getAmount());// 还款金额
				lnciInfo.setPayAmount(payBillsInfo.getPayAmount());// 入账金额
				lnciInfo.setAmountOver(payBillsInfo.getPayAmount().subtract(payBillsInfo.getAmount()));// 尾款金额
				lnciInfo.setBailAccount(payBillsInfo.getBailAccountno());// 保证金账户
			}
			//欠息总额
			lnciInfo.setInTableInt(StringUtil.isEmpty(lnciInfo.getReceivableInt())?BigDecimal.ZERO:lnciInfo.getReceivableInt().add(StringUtil.isEmpty(lnciInfo.getCollectionInt())?BigDecimal.ZERO:lnciInfo.getCollectionInt()));
			resultList.add(lnciInfo);
		}
		lnciInfoResult.setRecords(resultList);
		return lnciInfoResult;
	}

	@Override
	public void doWorkForPass(String appNo)
	{
		// 判断是否存在特殊调用路劲，存在则执行特殊路径，不存在则继续执行下列方法
		String invokPhase = ScfBasConstant.INVOKE_PHASE_BACK_TRANSFER;// 反转让申请阶段
		String callerpath = "NFactoringDebtBackServiceImpl";
		boolean flag = scfWorkFlowService.invokAnotherClasspath(appNo, invokPhase, callerpath);
		if(flag)
		{
			return;
		}
		// 审批通过，业务申请业务明细表数据来源相应信息更改锁定状态未锁定
		List<RBcpAppliBussDtl> dtllist = nrbcpapplibussdtlservice.queryRBcpAppliBussDtlByAppno(appNo);
		List<NDebtBillsInfoVO> listinfo = new ArrayList<NDebtBillsInfoVO>();
		if(dtllist.size() > 0)
		{
			for(RBcpAppliBussDtl dtl : dtllist)
			{
				NDebtBillsInfoVO baseInfo = new NDebtBillsInfoVO();
				BeanUtils.copyProperties(dtl, baseInfo);
				baseInfo.setId(dtl.getDebtId());
				listinfo.add(baseInfo);
			}
		}
		RBcpAppliBussInfo tabi = nrbcpapplibussinfoservice.findBcpAppliBussInfoByAppno(appNo);
		DebtBussInfoVO debtBussInfoVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(tabi, debtBussInfoVO);
		debtBussInfoVO.setTotalAmount(debtBussInfoVO.getTotalDebtAmount());// 本次回购金额存入数据库totalDebtAmout字段，调用方法前将该字段值赋给totalAmout
		debtBussInfoVO.setTotalNum(debtBussInfoVO.getDebtNum());
//		nbntenoticebaseservice.addDebtBackNoticeByAppno(debtBussInfoVO.getAppno(),debtBussInfoVO.getFactType());//通知书回执
		this.DebtBackApplyReceiptUpdate(debtBussInfoVO, listinfo);
		// 更新业务申请表状态
		bpbcapplibaseinfoservice.editAppliBaseStatusByFlag(appNo, "pass");
	}

	@Override
	public void doWorkForReject(String appNo)
	{
		debtfinancingservice.releaseAppliDebtBaseInfo(appNo);
		// 更新业务申请表状态
		bpbcapplibaseinfoservice.editAppliBaseStatusByFlag(appNo, "reject");
	}

	@Override
	public void doWorkForSubmit(String appNo) throws ScubeBizException
	{

	}

	@Override
	public void doWorkForBack(String appNo)
	{
		// 更新业务申请表状态
		bpbcapplibaseinfoservice.editAppliBaseStatusByFlag(appNo, "back");
	}

	/**
	 * 列表提交按钮提交，需通过appNo获取业务申请基本信息及明细信息
	 * @param appNo
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月15日上午9:28:43
	 */
	@Override
	public void submit(String appNo) throws ScubeBizException
	{
		List<RBcpAppliBussDtl> dtllist = nrbcpapplibussdtlservice.queryRBcpAppliBussDtlByAppno(appNo);
		List<NDebtBillsInfoVO> listinfo = new ArrayList<NDebtBillsInfoVO>();
		if(dtllist.size() > 0)
		{
			for(RBcpAppliBussDtl dtl : dtllist)
			{
				NDebtBillsInfoVO baseInfo = new NDebtBillsInfoVO();
				BeanUtils.copyProperties(dtl, baseInfo);
				baseInfo.setId(dtl.getDebtId());
				listinfo.add(baseInfo);
			}
		}
		RBcpAppliBussInfo tabi = nrbcpapplibussinfoservice.findBcpAppliBussInfoByAppno(appNo);
		DebtBussInfoVO debtBussInfoVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(tabi, debtBussInfoVO);
		debtBussInfoVO.setTotalAmount(debtBussInfoVO.getTotalDebtAmount());// 本次回购金额存入数据库totalDebtAmout字段，调用方法前将该字段值赋给totalAmout
		debtBussInfoVO.setTotalNum(debtBussInfoVO.getDebtNum());
		this.DebtBackWriteSubmitUpdate(debtBussInfoVO, listinfo);
	}
}

package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IDebtFinancingService;
import com.huateng.scf.bas.common.service.IScfApplyService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.IFactoringChargeOffService;
import com.huateng.scf.nrec.bcp.service.INBNteNoticeBaseService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussInfoService;
import com.huateng.scf.nrec.bcp.vo.NDebtBillsInfoVO;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>应收类核销	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月2日上午11:25:38
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月2日上午11:25:38	     新增
 *
 * </pre>
 */
@ScubeService
@Service("FactoringChargeOffServiceImpl")
public class FactoringChargeOffServiceImpl implements IFactoringChargeOffService, DealEndFlowService, DealInFlowService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "NRBcpAppliBussInfoServiceImpl")
	INRBcpAppliBussInfoService nrbcpapplibussinfoservice;
	
	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bcntbcpinfoservice;

	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;

	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	
	@Resource(name = "NRBcpAppliBussDtlServiceImpl")
	INRBcpAppliBussDtlService nrbcpapplibussdtlservice;
	
	@Resource(name = "DebtFinancingServiceImpl")
	IDebtFinancingService debtfinancingservice;
	
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name = IScfApplyService.BEAN_ID)
	IScfApplyService scfApplyService;
	
	@Resource(name = "NBNteNoticeBaseServiceImpl")
	INBNteNoticeBaseService nbntenoticebaseservice;
	
	/**
	 * 应收账款核销申请信息查询
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月2日下午1:50:46
	 */
	@Override
	public DebtBussInfoVO RecievableChargeOffApplyBaseInfoGetter(DebtBussInfoVO debtBussInfoVO) throws ScubeBizException
	{
		log.debug("核销基本信息查询=======================");
		String appno = debtBussInfoVO.getAppno();
		String mastContno = debtBussInfoVO.getMastContno();  // 内部合同号
		
		RBcpAppliBussInfo appliVO = new RBcpAppliBussInfo();
		if (!StringUtil.isEmpty(appno))
		{
			appliVO = nrbcpapplibussinfoservice.findBcpAppliBussInfoByAppno(appno);
			mastContno = appliVO.getMastContno();
		}
		
		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		
		BCntBcpInfoVO bcpInfoVO = bcntbcpinfoservice.queryBCntBcpInfoByMastContno(mastContno);
		String loanDays = bcpInfoVO.getLoanDays().toString();
		bcpInfoVO.setLoanDays(null);
		BeanUtils.copyProperties(bcpInfoVO, debtVO);
		debtVO.setLoanDays(loanDays);
		debtVO.setCustcdBuyer(debtBussInfoVO.getCustcdBuyer());
		debtVO.setCnameBuyer(debtBussInfoVO.getCnameBuyer());
		debtVO.setCustcdSaller(debtVO.getCustcd());
		debtVO.setCnameSeller(bcpInfoVO.getCname());
		debtVO.setBussType(debtVO.getSupplyChainPdId());
		if(StringUtil.isEmpty(debtVO.getBalanceAccount()))
		{
			debtVO.setBalanceAccount(debtVO.getAccountNo());
		}
		else if(StringUtil.isEmpty(debtVO.getAccountNo()))
		{
			debtVO.setAccountNo(debtVO.getBalanceAccount());
		}
		debtVO.setAppno(appno);
		
		BigDecimal loanpercent = new BigDecimal(0);
		if (bcpInfoVO.getLoanPercent() != null)
		{
			loanpercent = bcpInfoVO.getLoanPercent();
		}
		if(!StringUtil.isEmpty(appno))
		{
			debtVO = new DebtBussInfoVO();
			BeanUtils.copyProperties(appliVO, debtVO);
			debtVO.setBussType(appliVO.getBussType());// 业务品种
			debtVO.setStartDate(appliVO.getBillDate());// 合同生效日期
			debtVO.setEndDate(appliVO.getBillEndDate());// 合同到期日期
			debtVO.setRebateReason(appliVO.getReason());// 回购原因
			debtVO.setLoanPercent(loanpercent);// 融资比例
			debtVO.setTotalAmount(debtVO.getTotalDebtAmount());// 总核销金额
			debtVO.setTotalNum(debtVO.getDebtNum());
			debtVO.setFactType(bcpInfoVO.getFactType());
			// 买家名称
			debtVO.setCnameBuyer(bcrmbaseinfodao.selectById(debtVO.getCustcdBuyer()).getCname());
			// 卖家名称
			debtVO.setCnameSeller(bcrmbaseinfodao.selectById(debtVO.getCustcdSaller()).getCname());
		}
		return debtVO;
	}
	
	// 任务基本信息
	@Override
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(String appno, String factType)
	{
		String process = "";
		if(ScfBasConstant.FACT_TYPE_INLAND.equals(factType)
				||ScfBasConstant.FACT_TYPE_REVERSE.equals(factType)
				||ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType))
		{//应收账款
			process = WorkflowConstant.PROCNAME_FACTORING_ACCOUNTCANCEL_APPLY;
		}
		else if(ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
				||ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType)
				||ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType))
		{//应收账款池
			process = WorkflowConstant.PROCNAME_FACTORING_POOL_CANCEL_APPLY;
		}
		else if(ScfBasConstant.T_FINANCING_TYPE_LEASE.equals(factType))
		{//租赁保理
			process = WorkflowConstant.PROCNAME_FACTORING_LEASE_CHARGE_OFF_APPLY;
		}
		else if(ScfBasConstant.T_FINANCING_TYPE_DOUBLE.equals(factType))
		{//双保理
			process = WorkflowConstant.PROCNAME_FACTORING_DOUBLE_CHARGE_OFF_APPLY;
		}
		else if(ScfBasConstant.T_FINANCING_TYPE_CREDIT.equals(factType))
		{//信保保理
			process = WorkflowConstant.PROCNAME_FACTORING_CREDIT_CHARGE_OFF_APPLY;
		}
		process = "N-"+process;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}
	
	/**
	 * 应收账款列表查询
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月2日下午2:05:26
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Page InvoiceChargeOffRecievableListGetter(int pageNo, int pageSize, DebtCommonQryVO debtCommonQryVO)
	{
		String appno = debtCommonQryVO.getAppno();
		String flag3 = debtCommonQryVO.getFlag();
		String id_Q = debtCommonQryVO.getId_Q();
		BigDecimal rebateAmount_Q = debtCommonQryVO.getRebateAmount_Q();
		debtCommonQryVO.setPageIndex(pageNo);
		debtCommonQryVO.setPageSize(pageSize);
		Page pageResult = new Page();
		String bussType="";
		List<AppliBussDetailVO> list = new ArrayList<AppliBussDetailVO>();
		if(!StringUtil.isEmpty(appno))
		{
			list = nrbcpapplibussdtlservice.getTblAppliBussDetail(appno, bussType);
		}
		List resultList =new ArrayList();
		String[] str = null;
		if(!StringUtil.isEmpty(id_Q))
		{
			str=id_Q.split("/f");
		}
		if(flag3!=null&&flag3.equals("1"))
		{
			for (int i = 0; i < list.size(); i++) {// 获取流程业务中读取数据
				AppliBussDetailVO appliVO = (AppliBussDetailVO) list.get(i);
				if (str != null)
				{
					for(int j=0;j<str.length;j++)
					{
						if (appliVO.getDebtId().equals(str[j])) {
							appliVO.setId(appliVO.getDebtId());
							appliVO.setRebateAmounts(appliVO.getBuyBackAmount());
							appliVO.setRebatebalance(appliVO.getRemainingAmount().subtract(appliVO.getRebateAmounts()));
							resultList.add(appliVO);// bussDetail中的ID与正式表中的ID不一致，DebtID才是一致
						}
					}
				}
			}
		}
		else if(flag3!=null&&flag3.equals("2"))
		{
			Page pageQueryResult = debtfinancingservice.getInvoiceFinancingQuery(debtCommonQryVO);
			List<NDebtBillsInfoVO> list1 = pageQueryResult.getRecords();//正式表读取发票
			if(list1!=null && list1.size()>0)
			{
				for(NDebtBillsInfoVO debtVO:list1)
				{
					debtVO.setDebtId(debtVO.getId());
					if(!StringUtil.isEmpty(rebateAmount_Q))
					{
						debtVO.setRebateAmounts(rebateAmount_Q);
					}
					else
					{
						if(!StringUtil.isEmpty(debtVO.getRemainingAmount()))
						{
							debtVO.setRebateAmounts(debtVO.getRemainingAmount());
						}
					}
					debtVO.setRebatebalance(debtVO.getRemainingAmount().subtract(debtVO.getRebateAmounts()));
					if(list!=null&&list.size()>0)
					{
						for(int i = 0; i < list.size() ; i++)
						{
							AppliBussDetailVO applyDebtVO = (AppliBussDetailVO) list.get(i);
							if(debtVO.getId().equals(applyDebtVO.getDebtId()))
							{
								debtVO.setId(applyDebtVO.getDebtId());
								debtVO.setDebtId(applyDebtVO.getDebtId());
								list.remove(i);
								break;
							}
						}
					}
					resultList.add(debtVO);//bussDetail中的ID与正式表中的ID不一致，DebtID才是一致
				}
			}
		}
		else
		{
			if(list!=null&&list.size()>0)
			{
				for(AppliBussDetailVO applVO:list)
				{
					applVO.setId(applVO.getDebtId());
					applVO.setRebateAmounts(applVO.getRemoveAmount());
					applVO.setRebatebalance(applVO.getRemainingAmount().subtract(StringUtil.isEmpty(applVO.getRebateAmounts())?BigDecimal.ZERO:applVO.getRebateAmount()));
					resultList.add(applVO);//bussDetail中的ID与正式表中的ID不一致，DebetNo才是一致
				}
			}
			pageResult.setTotalRecord(list.size());
		}	
		pageResult.setRecords(resultList);
		return pageResult;
	}
	
	/**
	 * 核销待选择应收账款列表
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月2日下午3:04:59
	 */
	@Override
	public Page InvoiceChargeOffAddQryGetter(int pageNo, int pageSize, 
			DebtCommonQryVO debtCommonQryVO, List<RBcpAppliBussDtl> list) throws ScubeBizException
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
		Page page = debtfinancingservice.getInvoiceChargeOffAddQry(debtCommonQryVO);
		return page;
	}
	
	/**
	 * 应收账款核销申请保存
	 * @param debtBussInfoVO
	 * @param insertDebtList
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月2日下午3:42:11
	 */
	@Override
	public String DebtCancelApplyApplySaveUpdate(DebtBussInfoVO debtBussInfoVO, List<NDebtBillsInfoVO> insertDebtList) throws ScubeBizException {
		String in_appno = debtBussInfoVO.getAppno();
		// 根据申请类型获取流程名称
		String businessnoType = "";// 申请类型
		String workApplyType = ""; // 申请业务类型
		debtBussInfoVO.setReason(debtBussInfoVO.getRebateReason()); // 核销原因存入到业务申请业务主表
		if(StringUtil.isEmpty(in_appno))
		{
			if (!StringUtil.isEmpty(debtBussInfoVO.getFactType()))
			{
				if(ScfBasConstant.FACT_TYPE_INLAND.equals(debtBussInfoVO.getFactType())
						||ScfBasConstant.FACT_TYPE_REVERSE.equals(debtBussInfoVO.getFactType())
						||ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(debtBussInfoVO.getFactType()))
				{//应收账款
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORINGACCOUNTCANCELAPPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_ACCOUNTCANCEL_APPLY;
				}
				else if(ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(debtBussInfoVO.getFactType())
						||ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(debtBussInfoVO.getFactType())
						||ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(debtBussInfoVO.getFactType()))
				{//应收账款池
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_POOL_CHARGEOFF;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_POOL_CANCEL_APPLY;
				}
				else if(ScfBasConstant.T_FINANCING_TYPE_LEASE.equals(debtBussInfoVO.getFactType()))
				{//租赁保理
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_DEBT_LEASE_CHARGE_OFF_APPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_LEASE_CHARGE_OFF_APPLY;
				}
				else if(ScfBasConstant.T_FINANCING_TYPE_DOUBLE.equals(debtBussInfoVO.getFactType()))
				{//双保理
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_DEBT_DOUBLE_CHARGE_OFF_APPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_DOUBLE_CHARGE_OFF_APPLY;
				}
				else if(ScfBasConstant.T_FINANCING_TYPE_CREDIT.equals(debtBussInfoVO.getFactType()))
				{//信保保理
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_DEBT_CREDIT_CHARGE_OFF_APPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_CREDIT_CHARGE_OFF_APPLY;
				}
				else
				{
					businessnoType = WorkflowConstant.APPLI_TYPE_FACTORINGACCOUNTCANCELAPPLY;
					workApplyType = WorkflowConstant.PROCNAME_FACTORING_ACCOUNTCANCEL_APPLY;
				}
			}
			else
			{
				log.error("没有匹配到对应的申请类型！");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10018),
						RBcpErrorConstant.SCF_REC_BCP_10018);
			}
			workApplyType = "N-"+workApplyType;
			debtBussInfoVO.setApplyType(businessnoType);
			in_appno = debtfinancingservice.saveFactoringAppBasicInfo(debtBussInfoVO, businessnoType, workApplyType);
		}
		else
		{
			debtfinancingservice.saveFactoringAppBasicInfo(debtBussInfoVO, "", "");
		}

		if (!StringUtil.isEmpty(in_appno))
		{
			debtBussInfoVO.setAppno(in_appno);
			// 应收账款单据list数据
			// 保存到R_BCP_APPLI_BUSS_INFO【业务申请业务主表】
		  	debtBussInfoVO.setApplyType(RBcpDebtConstant.APPLY_TYPE_VERIFY);
			String debtId = nrbcpapplibussinfoservice.saveDebtBackAppliBussInfo(debtBussInfoVO);
			// // 保存到 R_BCP_APPLI_BUSS_DTL【业务申请业务明细表】
			nrbcpapplibussdtlservice.saveDebtBackApplyBussDetail(insertDebtList, debtBussInfoVO.getAppno(), debtId);
		}
		return in_appno;
	}
	
	/**
	 * 保理应收账款核销申请流程录入（发起流程）
	 * @param debtBussInfoVO
	 * @param insertDebtList
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月2日下午3:48:45
	 */
	@Override
	public void DebtCancelApplyWriteSubmitUpdate(DebtBussInfoVO debtBussInfoVO, List<NDebtBillsInfoVO> insertDebtList) 
			throws ScubeBizException
	{
		debtBussInfoVO.setReason(debtBussInfoVO.getRebateReason()); // 核销原因存入到业务申请业务主表
		// 应收账款单据list数据
		// 保存到R_BCP_APPLI_BUSS_INFO【业务申请业务主表】
		String debtId = nrbcpapplibussinfoservice.saveDebtBackAppliBussInfo(debtBussInfoVO);
		// // 保存到 R_BCP_APPLI_BUSS_DTL【业务申请业务明细表】
		nrbcpapplibussdtlservice.saveDebtBackApplyBussDetail(insertDebtList, debtBussInfoVO.getAppno(), debtId);

		//流程操作
		BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(debtBussInfoVO.getAppno());
		scfWorkFlowService.FactoringProcessDone(appliBaseInfo);
	}

	/**
	 * 核销回执确认
	 * @param debtBussInfoVO
	 * @param insertDebtList
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月2日下午5:02:47
	 */
	@Override
	public void DebtCancelApplyReceiptUpdate(DebtBussInfoVO debtBussInfoVO, List<NDebtBillsInfoVO> insertDebtList)
			throws ScubeBizException
	{
		debtfinancingservice.factoringChargeOffAddSave(insertDebtList, debtBussInfoVO);
		debtfinancingservice.releaseAppliDebtBaseInfo(debtBussInfoVO.getAppno()); // 解锁应收账款
		
		BCntBcpInfoVO bCntBcpInfoVO = bcntbcpinfoservice.queryBCntBcpInfoByMastContno(debtBussInfoVO.getMastContno());
		debtBussInfoVO.setFactType(bCntBcpInfoVO.getFactType());
		debtBussInfoVO.setFinancingType(bCntBcpInfoVO.getFinancingType());
		if (!StringUtil.isEmpty(debtBussInfoVO.getFinancingType()) 
				&& ScfBasConstant.T_FINANCING_TYPE_POOL.equals(debtBussInfoVO.getFinancingType()))
		{
			debtBussInfoVO.setFlag(ScfBasConstant.INVOKE_PHASE_CHARGE_OFF);
			debtfinancingservice.updatePoolRemainAmount(debtBussInfoVO);// 更新池信息（发票余额、可融资余额）
		}
		nbntenoticebaseservice.addDebtCancelNoticeByAppno(debtBussInfoVO.getAppno());//通知书回执
		//由于这里是在回执确认才生成通知书，故多加一步更新通知书状态
        nbntenoticebaseservice.modifyNoticeBaseInfo(debtBussInfoVO.getAppno(), NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		// 额度操作
		// 合同有追/无追
		String recoverType = debtfinancingservice.getDebtContRecoverType(debtBussInfoVO.getMastContno(), debtBussInfoVO.getCustcdBuyer());

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
	}
	
	@Override
	public void doWorkForPass(String appNo)
	{
		//判断是否存在特殊调用路劲，存在则执行特殊路径，不存在则继续执行下列方法
		String invokPhase = ScfBasConstant.INVOKE_PHASE_CHARGE_OFF;//核销阶段
		String callerpath = "FactoringChargeOffServiceImpl";
		boolean flag = scfWorkFlowService.invokAnotherClasspath(appNo, invokPhase, callerpath);
		if(flag)
		{
			return;
		}
		// 审批通过，业务申请业务明细表数据来源相应信息更改锁定状态未锁定
		List<RBcpAppliBussDtl> dtllist = nrbcpapplibussdtlservice.queryRBcpAppliBussDtlByAppno(appNo);
		List<NDebtBillsInfoVO> listinfo = new ArrayList<NDebtBillsInfoVO>();
		if (dtllist.size() > 0) {
			for (RBcpAppliBussDtl dtl : dtllist) {
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
		this.DebtCancelApplyReceiptUpdate(debtBussInfoVO, listinfo);
		// 更新业务申请表状态
		bpbcapplibaseinfoservice.editAppliBaseStatusByFlag(appNo, "pass");
	}

	@Override
	public void doWorkForReject(String appNo) {
		debtfinancingservice.releaseAppliDebtBaseInfo(appNo);//对流程锁定的应收账款进行解锁
		// 更新业务申请表状态
		bpbcapplibaseinfoservice.editAppliBaseStatusByFlag(appNo, "reject");
	}

	@Override
	public void doWorkForBack(String appNo) {
		// 更新业务申请表状态
		bpbcapplibaseinfoservice.editAppliBaseStatusByFlag(appNo, "back");
	}

	@Override
	public void doWorkForSubmit(String appNo) throws ScubeBizException {
		// TODO Auto-generated method stub
		
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
		if (dtllist.size() > 0) {
			for (RBcpAppliBussDtl dtl : dtllist) {
				NDebtBillsInfoVO baseInfo = new NDebtBillsInfoVO();
				BeanUtils.copyProperties(dtl, baseInfo);
				baseInfo.setId(dtl.getDebtId());
				listinfo.add(baseInfo);
			}
		}
		RBcpAppliBussInfo tabi = nrbcpapplibussinfoservice.findBcpAppliBussInfoByAppno(appNo);
		DebtBussInfoVO debtBussInfoVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(tabi, debtBussInfoVO);
		debtBussInfoVO.setStartDate(tabi.getBillDate());// 合同生效日期
		debtBussInfoVO.setEndDate(tabi.getBillEndDate());// 合同到期日期
		debtBussInfoVO.setRebateReason(tabi.getReason());// 回购原因
		debtBussInfoVO.setTotalAmount(debtBussInfoVO.getTotalDebtAmount());// 本次回购金额存入数据库totalDebtAmout字段，调用方法前将该字段值赋给totalAmout
		debtBussInfoVO.setTotalNum(debtBussInfoVO.getDebtNum());
		this.DebtCancelApplyWriteSubmitUpdate(debtBussInfoVO, listinfo);
	}
}

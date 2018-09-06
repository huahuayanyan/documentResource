package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
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
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDebtInfo;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.INBNteNoticeBaseService;
import com.huateng.scf.nrec.bcp.service.INDebtImpairmentService;
import com.huateng.scf.nrec.bcp.service.INFactFinanceBaseService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtPoolService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scf.nrec.bcp.vo.NDebtBillsInfoVO;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>应收类配置版	减值申请接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月5日上午9:42:43
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月5日上午9:42:43	     新增
 *
 * </pre>
 */
@ScubeService
@Service("NDebtImpairmentServiceImpl")
public class NDebtImpairmentServiceImpl implements INDebtImpairmentService,DealEndFlowService,DealInFlowService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name = "NFactFinanceBaseServiceImpl")
	INFactFinanceBaseService nfactfinancebaseservice;

	@Resource(name = "NRBcpDebtPoolServiceImpl")
	INRBcpDebtPoolService nrbcpdebtpoolservice;
	
	@Resource(name = "NRBcpAppliBussInfoServiceImpl")
	INRBcpAppliBussInfoService nrbcpapplibussinfoservice;

	@Resource(name = "NRBcpAppliBussDtlServiceImpl")
	INRBcpAppliBussDtlService nrbcpapplibussdtlservice;

	@Resource(name = "DebtFinancingServiceImpl")
	IDebtFinancingService debtfinancingservice;

	@Resource(name="BLanLnciBaseServiceImpl")
	IBLanLnciBaseService blanlncibaseservice;

	@Resource(name = "NBNteNoticeBaseServiceImpl")
	INBNteNoticeBaseService nbntenoticebaseservice;
	
	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bcntbcpinfoservice;
	
	@Resource(name = IScfApplyService.BEAN_ID)
	IScfApplyService scfApplyService;

	// 客户信息
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;
	
	@Resource(name = "RBcpDebtInfoServiceImpl")
	IRBcpDebtInfoService rbcpdebtinfoservice;
	
	// 任务基本信息
	@Override
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(String appno, String factType)
	{
		log.debug("获取任务信息============================");
		String process = "";
		if(ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(factType))
		{//信保保理
			process =WorkflowConstant.PROCNAME_ALLOWANCE_CREDIT_APPLY;
		}
		else if(ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(factType))
		{//国内双保理
			process =WorkflowConstant.PROCNAME_ALLOWANCE_DOUBLE_APPLY;
		}
		else if(ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType))
		{//租赁保理
			process =WorkflowConstant.PROCNAME_ALLOWANCE_LEASE_APPLY;
		}
		else if(ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
				||ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType)
				||ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType))
		{//应收账款池融资
			process =WorkflowConstant.PROCNAME_ALLOWANCE_POOL_APPLY;
	  	}
		else if(ScfBasConstant.FACT_TYPE_INLAND.equals(factType)
				||ScfBasConstant.FACT_TYPE_REVERSE.equals(factType)
				||ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType))
		{//应收账款
			process=WorkflowConstant.PROCNAME_ALLOWANCE_APPLY;
	 	}
		process = "N-"+process;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}

	/**
	 * 查询减值申请基本信息
	 * @param debtBussInfoVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日上午10:10:25
	 */
	@Override
	public DebtBussInfoVO FactoringAllowanceApplyAddGetter(DebtBussInfoVO debtBussInfoVO) throws ScubeBizException
	{
		log.debug("合同编号：" + debtBussInfoVO.getMastContno());
		String appno = debtBussInfoVO.getAppno();
		String mastContno = debtBussInfoVO.getMastContno();
		String custcdBuyer = debtBussInfoVO.getCustcdBuyer();
		String custcdSaller = debtBussInfoVO.getCustcdSaller();

		if(!StringUtil.isEmpty(appno))
		{
			BPbcAppliBaseInfo tabi = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			mastContno = tabi.getMastContno();
			custcdBuyer=tabi.getMoniCustcd();
		}
		
		DebtCommonQryVO commonQueryVO = new DebtCommonQryVO();
		commonQueryVO.setMastContno(mastContno);
		commonQueryVO.setCustcdBuyer_Q(custcdBuyer);
		commonQueryVO.setCustcdSaller_Q(custcdSaller);
		commonQueryVO.setAppno_Q(appno);
		
		DebtBussInfoVO debtContVO = new DebtBussInfoVO();
		
		if(StringUtil.isEmpty(appno))
		{
			debtContVO = nfactfinancebaseservice.getContDebtInfoByMastContno(commonQueryVO);
		}
		if(!StringUtil.isEmpty(appno))
		{
			RBcpAppliBussInfo appliBussInfo = nrbcpapplibussinfoservice.findBcpAppliBussInfoByAppno(appno);
			debtContVO =new DebtBussInfoVO();
			BeanUtils.copyProperties(appliBussInfo, debtContVO);
			debtContVO.setBussType(appliBussInfo.getBussType());//业务品种
			debtContVO.setBailAcctNo(debtContVO.getBailAcctNo());//保证金账号				
			debtContVO.setTotalDebtRemainAmount(debtContVO.getTotalDebtRemainAmount());//池应收账款余额
			debtContVO.setPoolRiskAmt(debtContVO.getPoolRiskAmt());//池敞口				
			debtContVO.setStartDate(appliBussInfo.getBillDate());//合同生效日期
			debtContVO.setEndDate(appliBussInfo.getBillEndDate());//合同到期日期
			debtContVO.setRebateReason(appliBussInfo.getReason());//回购原因
			// 贸易对手
			debtContVO.setCnameBuyer(bcrmbaseinfodao.selectById(debtContVO.getCustcdBuyer()).getCname());
			// 融资企业
			debtContVO.setCnameSeller(bcrmbaseinfodao.selectById(debtContVO.getCustcdSaller()).getCname());
		}
		List<RBcpDebtPool> list = new ArrayList<RBcpDebtPool>();
		if(!StringUtil.isEmpty(commonQueryVO.getCustcdSaller_Q()))
		{
			list = nrbcpdebtpoolservice.queryDebtPollByMastContno(mastContno, custcdSaller);
		}
		else
		{
			list = nrbcpdebtpoolservice.queryDebtPollByMastContno(mastContno, debtContVO.getCustcdSaller());
		}
		if(list != null && list.size()>0)
		{
			RBcpDebtPool tblDebtPool = list.get(0);
			debtContVO.setTotalDebtRemainAmount(tblDebtPool.getTotalDebtRemainAmount());
			debtContVO.setPoolRiskAmt(nfactfinancebaseservice.calculatePoolRiskAvailableAmtByBusinessNo(mastContno));//池敞口余额
		}
		BCntBcpInfoVO bCntBcpInfoVO = bcntbcpinfoservice.queryBCntBcpInfoByMastContno(mastContno);
		debtContVO.setFactType(bCntBcpInfoVO.getFactType());
		debtContVO.setFinancingType(bCntBcpInfoVO.getFinancingType());
		debtContVO.setLoanPercent(bCntBcpInfoVO.getLoanPercent());
		return debtContVO;
	}

	/**
	 * 应收账款减值业务申请应收账款列表
	 * 关联融资信息与反转让关联融资相同
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月5日上午10:20:18
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page InvoiceAllowanceQuryHandleGetter(int pageNo, int pageSize, DebtCommonQryVO debtCommonQryVO)
	{
		String appno = debtCommonQryVO.getAppno();
		String flag3 = debtCommonQryVO.getFlag();
		String id_Q = debtCommonQryVO.getId_Q();
		debtCommonQryVO.setBillsNo_Q(id_Q);
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
			Page pageQueryResult = debtfinancingservice.getAcquisitionsInformation(debtCommonQryVO);
			List<RBcpDebtInfo> list1 = pageQueryResult.getRecords();//正式表读取发票
			if(list1!=null && list1.size()>0)
			{
				for(RBcpDebtInfo bcpDebtInfo:list1)
				{
					AppliBussDetailVO debtVO = new AppliBussDetailVO();
					BeanUtils.copyProperties(bcpDebtInfo, debtVO);
					debtVO.setDebtId(debtVO.getId());
					debtVO.setRebateAmounts(new BigDecimal("0"));
					debtVO.setRebatebalance(debtVO.getRemainingAmount());
					if(!StringUtil.isEmpty(debtVO.getDebetNo()))
					{
					    BLanLnciBase lnciInfo = blanlncibaseservice.findBLanLnciBaseByDebtId(debtVO.getDebetNo());
					    if(lnciInfo != null){
					    	debtVO.setDebetId(lnciInfo.getDebetId());
					    }
					}
					if(list!=null&&list.size()>0)
					{
						for(int i = 0; i < list.size() ; i++)
						{
							AppliBussDetailVO applyDebtVO = (AppliBussDetailVO) list.get(i);
							if(debtVO.getId().equals(applyDebtVO.getDebtId()))
							{
								debtVO.setId(applyDebtVO.getDebtId());
								debtVO.setDebtId(applyDebtVO.getDebtId());
								debtVO.setRebateAmounts(applyDebtVO.getRebateAmount());
								debtVO.setRebatebalance(applyDebtVO.getRemainingAmount().subtract(applyDebtVO.getRebateAmount()));//减值后发票余额
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
					RBcpDebtInfoVO debtInfoVO = rbcpdebtinfoservice.queryRBcpDebtInfoById(applVO.getDebtId());
					applVO.setRebateAmounts(applVO.getRebateAmount());
					applVO.setRebateAmount(StringUtil.isEmpty(debtInfoVO.getRebateAmount())?new BigDecimal("0.00"):debtInfoVO.getRebateAmount());//已减值金额
					applVO.setRebatebalance(applVO.getRemainingAmount().subtract(StringUtil.isEmpty(applVO.getRebateAmounts())?BigDecimal.ZERO:applVO.getRebateAmounts()));
					resultList.add(applVO);//bussDetail中的ID与正式表中的ID不一致，DebetNo才是一致
				}
			}
			pageResult.setTotalRecord(list.size());
		}	
		pageResult.setRecords(resultList);
		return pageResult;
	}
	
	/**
	 * 减值申请发票添加
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日上午10:58:47
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page InvoiceAllowanceAddQryGetter(int pageNo, int pageSize, 
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
		Page page = debtfinancingservice.getInvoiceAllowanceAddQry(debtCommonQryVO);
		List<RBcpDebtInfo> debtlist = page.getRecords();
		List<NDebtBillsInfoVO> result = new ArrayList<NDebtBillsInfoVO>();
		if(debtlist!=null&&debtlist.size()>0)
		{
			NDebtBillsInfoVO billsInfoVO = null;
			for(RBcpDebtInfo debtInfo:debtlist)
			{
				billsInfoVO = new NDebtBillsInfoVO();
				BeanUtils.copyProperties(debtInfo, billsInfoVO);
				billsInfoVO.setDebtId(debtInfo.getId());
				result.add(billsInfoVO);
			}
		}
		page.setRecords(result);
		return page;
	}
	
	/**
	 * 应收账款折让 保存(减值申请保存)
	 * @param debtBussInfoVO
	 * @param insertDebtList
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日下午2:19:14
	 */
	@Override
	public String FactoringAllowanceSaveUpdate(DebtBussInfoVO debtBussInfoVO,List<NDebtBillsInfoVO> insertDebtList) throws ScubeBizException
	{
		String in_appno = debtBussInfoVO.getAppno();
		// 根据申请类型获取流程名称
		if(StringUtil.isEmpty(in_appno))
		{
			String businessnoType = "";// 申请类型
			String workApplyType = ""; // 申请业务类型
			if(ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(debtBussInfoVO.getFactType()))
			{
				businessnoType = WorkflowConstant.APPLI_TYPE_ALLOWANCECREDITAPPLY;
				workApplyType =WorkflowConstant.PROCNAME_ALLOWANCE_CREDIT_APPLY;
			}
			else if(ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(debtBussInfoVO.getFactType()))
			{
				businessnoType = WorkflowConstant.APPLI_TYPE_ALLOWANCEDOUBLEAPPLY;
				workApplyType =WorkflowConstant.PROCNAME_ALLOWANCE_DOUBLE_APPLY;
			}
			else if(ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(debtBussInfoVO.getFactType()))
			{
				businessnoType = WorkflowConstant.APPLI_TYPE_ALLOWANCELEASEAPPLY;
				workApplyType =WorkflowConstant.PROCNAME_ALLOWANCE_LEASE_APPLY;
			}
			else if(ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(debtBussInfoVO.getFactType())||
					ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(debtBussInfoVO.getFactType())||
					ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(debtBussInfoVO.getFactType()))
			{
				businessnoType = WorkflowConstant.APPLI_TYPE_ALLOWANCEPOOLAPPLY;
				workApplyType =WorkflowConstant.PROCNAME_ALLOWANCE_POOL_APPLY;
			}
			else if(ScfBasConstant.FACT_TYPE_REVERSE.equals(debtBussInfoVO.getFactType())
					||ScfBasConstant.FACT_TYPE_INLAND.equals(debtBussInfoVO.getFactType())
					||ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(debtBussInfoVO.getFactType()))
			{
				businessnoType=WorkflowConstant.APPLI_TYPE_ALLOWANCEAPPLY;
				workApplyType=WorkflowConstant.PROCNAME_ALLOWANCE_APPLY;
			}
			
			workApplyType = "N-"+workApplyType;
			//保存信息到申请基本信息表，生成appno并返回
			in_appno = debtfinancingservice.saveFactoringAppBasicInfo(debtBussInfoVO,businessnoType,workApplyType);//变更
		}
		else
		{
			debtfinancingservice.saveFactoringAppBasicInfo(debtBussInfoVO,"","");//更新保存业务申请信息
		}
	  	debtBussInfoVO.setAppno(in_appno);
	  	debtBussInfoVO.setDebtNum(debtBussInfoVO.getTotalNum());//发票总份数
	  	debtBussInfoVO.setTotalDebtAmount(debtBussInfoVO.getTotalAmount());  //发票总折让金额
	  	debtBussInfoVO.setAmount(debtBussInfoVO.getTotalAmount());  //发票总折让金额
	  	debtBussInfoVO.setPurchaseDate(debtBussInfoVO.getInsertDate()); //折让日期
	  	if(insertDebtList!=null && insertDebtList.size()>0){
			Iterator<NDebtBillsInfoVO> iter= insertDebtList.iterator();
			while(iter.hasNext()){
				NDebtBillsInfoVO debtVO_ = iter.next();
				debtVO_.setAppno(in_appno);
				debtVO_.setRebateAmount(debtVO_.getRebateAmounts());//折让金额
			}
		}
	  	//保存到TBL_APPLI_BUSS_INFO【业务申请业务主表】
	  	debtBussInfoVO.setApplyType(RBcpDebtConstant.APPLY_TYPE_DISCOUNT);
	  	nrbcpapplibussinfoservice.saveOrUpdateDebtAppliBussInfo(debtBussInfoVO);
		//保存到 TBL_APPLI_BUSS_DETAIL【业务申请业务明细表】
	  	nrbcpapplibussdtlservice.updateAppliBussDetall(insertDebtList,in_appno);//添加发票
		return in_appno;
	}
	
	/**
	 * 应收账款折让提交并发起流程 应收账款折让申请任务提交
	 * @param debtBussInfoVO
	 * @param insertDebtList
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日下午2:27:26
	 */
	@Override
	public void FactoringAllowanceAddSave(DebtBussInfoVO debtBussInfoVO,List<NDebtBillsInfoVO> insertDebtList) throws ScubeBizException
	{
		debtfinancingservice.saveFactoringAppBasicInfo(debtBussInfoVO,"","");//更新保存业务申请信息
		debtBussInfoVO.setDebtNum(debtBussInfoVO.getTotalNum());//发票总份数
	  	debtBussInfoVO.setTotalDebtAmount(debtBussInfoVO.getTotalAmount());  //发票总折让金额
	  	debtBussInfoVO.setAmount(debtBussInfoVO.getTotalAmount());  //发票总折让金额
	  	debtBussInfoVO.setPurchaseDate(debtBussInfoVO.getInsertDate()); //折让日期
	  	if(insertDebtList!=null && insertDebtList.size()>0){
			Iterator<NDebtBillsInfoVO> iter= insertDebtList.iterator();
			while(iter.hasNext()){
				NDebtBillsInfoVO debtVO_ = iter.next();
				debtVO_.setAppno(debtBussInfoVO.getAppno());
				debtVO_.setRebateAmount(debtVO_.getRebateAmounts());//折让金额
			}
		}
	  	//保存到TBL_APPLI_BUSS_INFO【业务申请业务主表】
	  	nrbcpapplibussinfoservice.saveOrUpdateDebtAppliBussInfo(debtBussInfoVO);
		//保存到 TBL_APPLI_BUSS_DETAIL【业务申请业务明细表】
	  	nrbcpapplibussdtlservice.updateAppliBussDetall(insertDebtList,debtBussInfoVO.getAppno());//添加发票
	  	
	  	//流程操作
	  	BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(debtBussInfoVO.getAppno());
		scfWorkFlowService.FactoringProcessDone(appliBaseInfo);
	}
	
	/**
	 * 应收账款折让审批通过
	 * @param debtBussInfoVO
	 * @param insertDebtList
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月5日下午3:26:12
	 */
	@Override
	public void AllowanceReviewSubmitUpdater(DebtBussInfoVO debtBussInfoVO,List<NDebtBillsInfoVO> insertDebtList) throws ScubeBizException
	{
		String factType = debtBussInfoVO.getFactType();
		String appno = debtBussInfoVO.getAppno();
  	  	//记录正式表
		debtBussInfoVO.setFlag(ScfBasConstant.INVOKE_PHASE_IMPAIRMENT);
		debtfinancingservice.factoringAllowanceAddApply(insertDebtList,debtBussInfoVO);
		//生成折让通知书
		nbntenoticebaseservice.addNoticeAllowanceByAppno(appno,factType);//通知书回执
        //由于这里是在回执确认才生成通知书，故多加一步更新通知书状态 
		nbntenoticebaseservice.modifyNoticeBaseInfo(appno, NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);

		// 合同有追/无追
		String recoverType = debtfinancingservice.getDebtContRecoverType(debtBussInfoVO.getMastContno(),debtBussInfoVO.getCustcdBuyer());

	  	if (ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(debtBussInfoVO.getFactType()) // 信保保理
				|| ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(debtBussInfoVO.getFactType()) // 行内双保理
				|| (ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(debtBussInfoVO.getFactType())
						&& ScfBasConstant.CREDIT_TYPE_WITHOUT_RECOURSE.equals(recoverType)) // 租赁保理无追模式
				|| (ScfBasConstant.FACT_TYPE_INLAND.equals(debtBussInfoVO.getFactType())
						&& ScfBasConstant.CREDIT_TYPE_WITHOUT_RECOURSE.equals(recoverType)) // 国内保理无追模式
				|| (ScfBasConstant.FACT_TYPE_REVERSE.equals(debtBussInfoVO.getFactType())
						&& ScfBasConstant.CREDIT_TYPE_WITHOUT_RECOURSE.equals(recoverType)) // 反向保理无追模式
		)
		{// 买方信用限额额度额度处理-释放
			scfApplyService.creditLimitOfBuyerAppliCommonProcess(debtBussInfoVO.getAppno(), ScfBasConstant.CREDIT_TRADE_TYPE_RELEASE,
					debtBussInfoVO.getTotalAmount());
		}
	}

	@Override
	public void doWorkForPass(String appNo) {
		//判断是否存在特殊调用路劲，存在则执行特殊路径，不存在则继续执行下列方法
		String invokPhase = ScfBasConstant.INVOKE_PHASE_IMPAIRMENT;//减值申请阶段
		String callerpath = "NDebtImpairmentServiceImpl";
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
		debtBussInfoVO.setTotalNum(debtBussInfoVO.getDebtNum());
		debtBussInfoVO.setTotalAmount(debtBussInfoVO.getTotalDebtAmount());// 本次回购金额存入数据库totalDebtAmout字段，调用方法前将该字段值赋给totalAmout
		BCntBcpInfoVO bCntBcpInfoVO = bcntbcpinfoservice.queryBCntBcpInfoByMastContno(debtBussInfoVO.getMastContno());
		debtBussInfoVO.setFactType(bCntBcpInfoVO.getFactType());
		debtBussInfoVO.setFinancingType(bCntBcpInfoVO.getFinancingType());
		debtBussInfoVO.setLoanPercent(bCntBcpInfoVO.getLoanPercent());
		this.AllowanceReviewSubmitUpdater(debtBussInfoVO, listinfo);
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
				RBcpDebtInfoVO debtInfoVO = rbcpdebtinfoservice.queryRBcpDebtInfoById(baseInfo.getDebtId());
				baseInfo.setRebateAmounts(baseInfo.getRebateAmount());
				baseInfo.setRebateAmount(StringUtil.isEmpty(debtInfoVO.getRebateAmount())?new BigDecimal("0.00"):debtInfoVO.getRebateAmount());//已减值金额
				baseInfo.setRebatebalance(baseInfo.getRemainingAmount().subtract(StringUtil.isEmpty(baseInfo.getRebateAmounts())?BigDecimal.ZERO:baseInfo.getRebateAmounts()));
				listinfo.add(baseInfo);
			}
		}
		RBcpAppliBussInfo tabi = nrbcpapplibussinfoservice.findBcpAppliBussInfoByAppno(appNo);
		DebtBussInfoVO debtBussInfoVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(tabi, debtBussInfoVO);
		debtBussInfoVO.setTotalNum(debtBussInfoVO.getDebtNum());
		debtBussInfoVO.setTotalAmount(debtBussInfoVO.getTotalDebtAmount());// 本次回购金额存入数据库totalDebtAmout字段，调用方法前将该字段值赋给totalAmout
		BCntBcpInfoVO bCntBcpInfoVO = bcntbcpinfoservice.queryBCntBcpInfoByMastContno(debtBussInfoVO.getMastContno());
		debtBussInfoVO.setFactType(bCntBcpInfoVO.getFactType());
		debtBussInfoVO.setFinancingType(bCntBcpInfoVO.getFinancingType());
		debtBussInfoVO.setLoanPercent(bCntBcpInfoVO.getLoanPercent());
		this.FactoringAllowanceAddSave(debtBussInfoVO, listinfo);
	}
	
	/**
	 * 应收账款减值业务申请明细信息（重新赋值减值金额，已减值金额，减值后余额）
	 * @param appno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月21日上午9:41:32
	 */
	@Override
	public List<AppliBussDetailVO> queryRBcpAppliBussDtlByAppno(String appno)
	{
		List<RBcpAppliBussDtl> list = nrbcpapplibussdtlservice.queryRBcpAppliBussDtlByAppno(appno);
		List<AppliBussDetailVO> resultList =new ArrayList<AppliBussDetailVO>();
		if(list!=null&&list.size()>0)
		{
			AppliBussDetailVO applVO = null;
			for(RBcpAppliBussDtl bussDtl:list)
			{
				applVO = new AppliBussDetailVO();
				BeanUtils.copyProperties(bussDtl, applVO);
				applVO.setId(applVO.getDebtId());
				RBcpDebtInfoVO debtInfoVO = rbcpdebtinfoservice.queryRBcpDebtInfoById(applVO.getDebtId());
				applVO.setRebateAmounts(applVO.getRebateAmount());
				applVO.setRebateAmount(StringUtil.isEmpty(debtInfoVO.getRebateAmount())?new BigDecimal("0.00"):debtInfoVO.getRebateAmount());//已减值金额
				applVO.setRebatebalance(applVO.getRemainingAmount().subtract(StringUtil.isEmpty(applVO.getRebateAmounts())?BigDecimal.ZERO:applVO.getRebateAmounts()));
				resultList.add(applVO);//bussDetail中的ID与正式表中的ID不一致，DebetNo才是一致
			}
		}
		return resultList;
	}
}

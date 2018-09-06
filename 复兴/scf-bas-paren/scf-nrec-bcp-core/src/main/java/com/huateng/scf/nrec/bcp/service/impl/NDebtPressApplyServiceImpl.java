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
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IDebtFinancingService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoBussQryService;
import com.huateng.scf.nrec.bcp.service.IBCntBcpInfoService;
import com.huateng.scf.nrec.bcp.service.INBNteNoticeBaseService;
import com.huateng.scf.nrec.bcp.service.INDebtPressApplyService;
import com.huateng.scf.nrec.bcp.service.INFactFinanceBaseService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliBussInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtBussDtlService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtBussInfoService;
import com.huateng.scf.nrec.bcp.service.INRBcpDebtPoolService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scf.nrec.bcp.vo.NDebtBillsInfoVO;
import com.huateng.scf.nrec.bcp.vo.NFactoringContVO;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.AppliBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>应收账款催收	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月27日下午2:49:53
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月27日下午2:49:53	     新增
 *
 * </pre>
 */
@ScubeService
@Service("NDebtPressApplyServiceImpl")
public class NDebtPressApplyServiceImpl implements INDebtPressApplyService,DealEndFlowService,DealInFlowService
{
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "DebtFinancingServiceImpl")
	IDebtFinancingService debtfinancingservice;
	
	//业务申请表
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	//自定义流程公共类
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	
	@Resource(name = IBCntBcpInfoBussQryService.BeanId)
	IBCntBcpInfoBussQryService bcntbcpinfobussqryservice;
	
	@Resource(name = "NRBcpDebtPoolServiceImpl")
	INRBcpDebtPoolService nrbcpdebtpoolservice;
	
	@Resource(name = "NFactFinanceBaseServiceImpl")
	INFactFinanceBaseService nfactfinancebaseservice;
	
	@Resource(name = "NRBcpAppliBussInfoServiceImpl")
	INRBcpAppliBussInfoService nrbcpapplibussinfoservice;
	
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;
	
	@Resource(name = "BCntBcpInfoServiceImpl")
	IBCntBcpInfoService bcntbcpinfoservice;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;//业务编号生成器
	
	//通知书信息
	@Resource(name = "NBNteNoticeBaseServiceImpl")
	INBNteNoticeBaseService nbntenoticebaseservice;
	
	@Resource(name = "NRBcpAppliBussDtlServiceImpl")
	INRBcpAppliBussDtlService nrbcpapplibussdtlservice;
	
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rbcpapplibussdtldao;
	
	@Resource(name = "RBcpDebtInfoServiceImpl")
	IRBcpDebtInfoService rbcpdebtinfoservice;
	
	@Resource(name = "NRBcpDebtBussDtlServiceImpl")
	INRBcpDebtBussDtlService nrbcpdebtbussdtlservice;

	@Resource(name = "NRBcpDebtBussInfoServiceImpl")
	INRBcpDebtBussInfoService nrbcpdebtbussinfoservice;
	
	/**
	 * 获取业务申请基本信息
	 * @param debtBussInfoVO
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月27日下午4:34:31
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<?> DisputeInvoiceSetApplyAddGetter(DebtBussInfoVO debtBussInfoVO)
	{
		String mastContno_Q = debtBussInfoVO.getMastContno();  // 内部合同号
		String custcdSaller_Q = debtBussInfoVO.getCustcd();  // 卖方客户号
		String custcdBuyer_Q = debtBussInfoVO.getCustcdBuyer();  // 买方客户号
		String appno = debtBussInfoVO.getAppno();
		String flag2 = debtBussInfoVO.getFlag();
		String taskName= debtBussInfoVO.getTaskName();
		List resultList = new ArrayList();
		if("1".equals(flag2)||(taskName != null && !"".equals(taskName) && !"Write".equals(taskName)))
		{
			//从业务申请表中读取数据
			RBcpAppliBussInfo appliBussInfo = nrbcpapplibussinfoservice.findBcpAppliBussInfoByAppno(appno);//获取申请基本信息
			AppliBussInfoVO debtVO = new AppliBussInfoVO();
			BeanUtils.copyProperties(appliBussInfo, debtVO);
			debtVO.setStartDate(debtVO.getBillDate());//合同有效日
			debtVO.setEndDate(debtVO.getBillEndDate());//合同到期日
			debtVO.setBussType(debtVO.getBussType());//业务品种
			debtVO.setTotalNum(debtVO.getDebtNum());//发票份数
			debtVO.setTotalAmount(debtVO.getTotalDebtAmount());//发票金额
			debtVO.setAmount(debtVO.getAmount());
			debtVO.setPressMode(debtVO.getReturnType());//催收方式
			debtVO.setAppno(appno);
			NFactoringContVO contDetail = bcntbcpinfobussqryservice.getFactContDetailByMastContno(debtVO.getMastContno());
			String loanDays = "";
			if(!StringUtil.isEmpty(contDetail.getLoanDays()))
			{
				loanDays = contDetail.getLoanDays().toString();
				contDetail.setLoanDays(null);
			}
			DebtBussInfoVO contVO = new DebtBussInfoVO();
			BeanUtils.copyProperties(contDetail, contVO);
			contVO.setLoanDays(loanDays);
			List<RBcpDebtPool> poolList = nrbcpdebtpoolservice.queryDebtPollByMastContno(debtVO.getMastContno(), debtVO.getCustcdSaller());
			if(poolList != null && poolList.size()>0)
			{
				RBcpDebtPool bcpDebtPool = poolList.get(0);		
				contVO.setTotalDebtRemainAmount(bcpDebtPool.getTotalDebtRemainAmount());
				contVO.setPoolRiskAmt(nfactfinancebaseservice.calculatePoolRiskAvailableAmtByBusinessNo(debtVO.getMastContno()));//池敞口余额
			}
			debtVO.setTotalDebtRemainAmount(contVO.getTotalDebtRemainAmount());//池应收账款余额
			debtVO.setPoolRiskAmt(contVO.getPoolRiskAmt());//池敞口
			debtVO.setLoanPercent(contVO.getLoanPercent());
			debtVO.setBailAcctNo(contVO.getBailAcctNo());
			
			debtVO.setCnameBuyer(bcrmbaseinfodao.selectById(debtVO.getCustcdBuyer()).getCname());
			debtVO.setCnameSeller(bcrmbaseinfodao.selectById(debtVO.getCustcdSaller()).getCname());
			
			resultList.add(debtVO);
		}else{//从正式数据表中读取申请需要的基本信息
			if(!StringUtil.isEmpty(appno))
			{
				//若申请号不为空，获取申请的合同号和卖方id
				BPbcAppliBaseInfo tabi = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
				mastContno_Q = tabi.getMastContno();
				custcdBuyer_Q = tabi.getMoniCustcd();
				custcdSaller_Q= tabi.getCustcd();
			}
			DebtCommonQryVO debtCommonQryVO = new DebtCommonQryVO();
			debtCommonQryVO.setMastContno(mastContno_Q);
			debtCommonQryVO.setCustcdBuyer_Q(custcdBuyer_Q);
			debtCommonQryVO.setCustcdSaller_Q(custcdSaller_Q);
			
			NFactoringContVO contDetail = bcntbcpinfobussqryservice.getFactContDetailByMastContno(mastContno_Q);
			DebtBussInfoVO contVO = new DebtBussInfoVO();
			BeanUtils.copyProperties(contDetail, contVO);
			List<RBcpDebtPool> poolList = nrbcpdebtpoolservice.queryDebtPollByMastContno(mastContno_Q, custcdSaller_Q);
			if(poolList != null && poolList.size()>0){
				RBcpDebtPool tblDebtPool = poolList.get(0);	
				contVO.setTotalDebtRemainAmount(tblDebtPool.getTotalDebtRemainAmount());
				contVO.setPoolRiskAmt(nfactfinancebaseservice.calculatePoolRiskAvailableAmtByBusinessNo(mastContno_Q));//池敞口余额
			}
			if(StringUtil.isEmpty(appno))
			{
				DebtBussInfoVO debtVO = contVO;
				debtVO.setMastContno(debtVO.getMastContno());
				debtVO.setCustcdBuyer(debtCommonQryVO.getCustcdBuyer_Q());
				debtVO.setCustcdSaller(debtCommonQryVO.getCustcdSaller_Q());
				debtVO.setBussType(debtVO.getProductId());
				debtVO.setPressMode(null);//催收方式
				if(!StringUtil.isEmpty(debtVO.getAccountNo())){
					debtVO.setBalanceAccount(debtVO.getAccountNo());
				}
				debtVO.setLoanPercent(contVO.getLoanPercent());
				debtVO.setAppno(appno);

				debtVO.setCnameBuyer(bcrmbaseinfodao.selectById(debtVO.getCustcdBuyer()).getCname());
				debtVO.setCnameSeller(bcrmbaseinfodao.selectById(debtVO.getCustcdSaller()).getCname());
				
				resultList.add(debtVO);
			}
			if(!StringUtil.isEmpty(appno)){
				RBcpAppliBussInfo appliBussInfo = nrbcpapplibussinfoservice.findBcpAppliBussInfoByAppno(appno);//获取申请基本信息
				AppliBussInfoVO debtVO = new AppliBussInfoVO();
				BeanUtils.copyProperties(appliBussInfo, debtVO);
				debtVO.setStartDate(debtVO.getBillDate());//合同有效日
				debtVO.setEndDate(debtVO.getBillEndDate());//合同到期日
				debtVO.setBailAcctNo(contVO.getBailAcctNo());//保证金账号
				debtVO.setTotalDebtRemainAmount(contVO.getTotalDebtRemainAmount());//池应收账款余额
				debtVO.setPoolRiskAmt(contVO.getPoolRiskAmt());//池敞口			
				debtVO.setBussType(debtVO.getBussType());//业务品种
				debtVO.setTotalNum(debtVO.getDebtNum());//发票份数
				debtVO.setTotalAmount(debtVO.getTotalDebtAmount());//发票金额
				debtVO.setPressMode(debtVO.getReturnType());//催收方式
				debtVO.setAppno(appno);
				debtVO.setLoanPercent(contVO.getLoanPercent());
				debtVO.setFactType(contVO.getFactType());
				debtVO.setFinancingType(contVO.getFinancingType());
				

				debtVO.setCnameBuyer(bcrmbaseinfodao.selectById(debtVO.getCustcdBuyer()).getCname());
				debtVO.setCnameSeller(bcrmbaseinfodao.selectById(debtVO.getCustcdSaller()).getCname());
				
				resultList.add(debtVO);
			}
		}
		return resultList;
	}

	/**
	 *  任务基本信息
	 */
	@Override
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(String appno,String factType)
	{
		String process = "";
		if(ScfBasConstant.FACT_TYPE_REVERSE.equals(factType)
				||ScfBasConstant.FACT_TYPE_INLAND.equals(factType)
				||ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType)){
			process = WorkflowConstant.PROCNAME_DEBT_PRESSING_APPLY;

		}else if(ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(factType)){
			process = WorkflowConstant.PROCNAME_DEBT_DOUBLE_PRESSING_APPLY;

		}else if(ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(factType)){
			process = WorkflowConstant.PROCNAME_DEBT_CREDIT_PRESSING_APPLY;

		}else if(ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType)){
			process = WorkflowConstant.PROCNAME_DEBT_LEASE_PRESSING_APPLY;

		}else if(ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType)||
				ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)||
				ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType)){
			process = WorkflowConstant.PROCNAME_DEBT_POOL_PRESSING_APPLY;
		}
		process = "N-" + process;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno, process);
	}
	
	/**
	 * 催收发票列表
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月31日上午11:16:56
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Page DebtPressInvoicesInfoGetter(int pageNo, int pageSize, DebtCommonQryVO debtCommonQryVO) throws ScubeBizException
	{
		String appno = debtCommonQryVO.getAppno();
		String flag3 = debtCommonQryVO.getFlag();
		debtCommonQryVO.setPageIndex(pageNo);
		debtCommonQryVO.setPageSize(pageSize);
		if(!StringUtil.isEmpty(appno))
		{//查申请表
			String bussType="";
			List<RBcpAppliBussDtl> list = new ArrayList<RBcpAppliBussDtl>();
			Page page = nrbcpapplibussdtlservice.queryAppliBussDetailByAppnoPage(pageNo, pageSize, appno, bussType);
			if(!StringUtil.isEmpty(appno)){
				list = page.getRecords(); //TBL_APPLI_BUSS_DETAIL【业务申请业务明细表】
			}
			Iterator<RBcpAppliBussDtl> iter = list.iterator();
			List resultList = new ArrayList();
			if(flag3!=null&&flag3.equals("1"))
			{
				while(iter.hasNext()){//获取流程业务中读取数据
					AppliBussDetailVO debtVO = new AppliBussDetailVO();
					BeanUtils.copyProperties(iter.next(), debtVO);
//					if(str!=null){
//						for(int j=0;j<str.length;j++){
//							if(debtVO.getDebtId().equals(str[j])){
//								debtVO.setId(debtVO.getDebtId());
//								debtVO.setOtherWay(debtVO.getOtherReason());
//								debtVO.setWarnCount(debtVO.getWarnCount());
//								debtVO.setPressCount(debtVO.getPressCount());
//								resultList.add(debtVO);//bussDetail中的ID与正式表中的ID不一致，DebtID才是一致
//							}
//						}
//					}
					resultList.add(debtVO);
				}
			}
			else if(flag3!=null&&flag3.equals("2"))
			{
				Page result = rbcpdebtinfoservice.getDebtPressInvoicesInfo(debtCommonQryVO);
				List<NDebtBillsInfoVO> list1=result.getRecords();//正式表读取发票
				if(list1!=null && list1.size()>0)
				{
					Iterator<NDebtBillsInfoVO> iters = list1.iterator();
					while(iters.hasNext())
					{
						NDebtBillsInfoVO debtVO = iters.next();
						debtVO.setDebtId(debtVO.getId());
						resultList.add(debtVO);//bussDetail中的ID与正式表中的ID不一致，DebtID才是一致
					}
					result.setRecords(resultList);
					return result;
				}
			}
			else
			{
				while(iter.hasNext())
				{
					RBcpAppliBussDtl appliBussDtl = iter.next();
					AppliBussDetailVO applVO = new AppliBussDetailVO();
					BeanUtils.copyProperties(appliBussDtl, applVO);
					applVO.setId(applVO.getDebtId());
					applVO.setOtherWay(applVO.getOtherReason());
					applVO.setWarnCount(applVO.getWarnCount());
					applVO.setPressCount(applVO.getPressCount());
				    resultList.add(applVO);//bussDetail中的ID与正式表中的ID不一致，DebetNo才是一致
				}
			}
			page.setRecords(resultList);
			return page;
		}
		Page pageQueryResult = rbcpdebtinfoservice.getDebtPressInvoicesInfo(debtCommonQryVO);
		return pageQueryResult;
	}
	
	/**
	 * 催收添加发票--发票查询
	 * @param pageNo
	 * @param pageSize
	 * @param debtCommonQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月27日下午3:05:26
	 */
	@Override
	public Page DebtInvoiceInfoAddQueryGetter(int pageNo, int pageSize, 
			DebtCommonQryVO debtCommonQryVO, List<RBcpAppliBussDtl> list) throws ScubeBizException
	{
		log.debug("催收添加发票--发票查询===========================");
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
		Page page = debtfinancingservice.getDebtInvoiceInfoPressing(debtCommonQryVO);
		return page;
	}
	
	/**
	 * 保存催收申请信息
	 * @param debtBussInfoVO
	 * @param list
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月31日上午9:39:00
	 */
	@Transactional
	@Override
	public String DebtPressingApplySaveUpdate(DebtBussInfoVO debtBussInfoVO, List<NDebtBillsInfoVO> list) throws ScubeBizException {
		// 根据申请类型获取流程名称
		String businessnoType = "";// 申请类型
		String workApplyType = ""; // 申请业务类型
		String appno = "";
		appno = debtBussInfoVO.getAppno();
		if (StringUtil.isEmpty(debtBussInfoVO.getAppno()))
		{
			businessnoType = WorkflowConstant.APPLI_TYPE_DEBTPRESSINGAPPLY;
			workApplyType = WorkflowConstant.PROCNAME_DEBT_PRESSING_APPLY;
			
			if(ScfBasConstant.FACT_TYPE_REVERSE.equals(debtBussInfoVO.getFactType())
					||ScfBasConstant.FACT_TYPE_INLAND.equals(debtBussInfoVO.getFactType())
					||ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(debtBussInfoVO.getFactType()))
			{//应收账款
				businessnoType = WorkflowConstant.APPLI_TYPE_DEBTPRESSINGAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DEBT_PRESSING_APPLY;

			}
			else if(ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(debtBussInfoVO.getFactType()))
			{//国内双保理
				businessnoType = WorkflowConstant.APPLI_TYPE_DEBTDOUBLEPRESSINGAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DEBT_DOUBLE_PRESSING_APPLY;

			}
			else if(ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(debtBussInfoVO.getFactType()))
			{//信保保理
				businessnoType = WorkflowConstant.APPLI_TYPE_DEBTCREDITPRESSINGAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DEBT_CREDIT_PRESSING_APPLY;

			}
			else if(ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(debtBussInfoVO.getFactType()))
			{//租赁保理
				businessnoType = WorkflowConstant.APPLI_TYPE_DEBTLEASEPRESSINGAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DEBT_LEASE_PRESSING_APPLY;

			}
			else if(ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(debtBussInfoVO.getFactType())||
					ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(debtBussInfoVO.getFactType())||
					ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(debtBussInfoVO.getFactType()))
			{//应收账款池
				businessnoType = WorkflowConstant.APPLI_TYPE_DEBTPOOLPRESSINGAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DEBT_POOL_PRESSING_APPLY;
			}
			workApplyType = "N-"+workApplyType;
			// 保存申请基本信息
			appno = this.saveBillsVendorAppliBaseInfo(debtBussInfoVO, businessnoType, workApplyType);
			debtBussInfoVO.setAppno(appno);
		}
		else
		{
			this.saveBillsVendorAppliBaseInfo(debtBussInfoVO, "", "");
		}
		if (StringUtil.isStrNotEmpty(appno)) {
			// List list=(List)context.getAttribute("INSERT_LIST");
			// context.setAttribute(OUT_APPNO, in_appno);
			debtBussInfoVO.setAppno(appno);
			// 保存业务申请表
			debtBussInfoVO.setApplyType(RBcpDebtConstant.APPLY_TYPE_COLLECTION);
			nrbcpapplibussinfoservice.saveOrUpdateDebtAppliBussInfo(debtBussInfoVO);// 保存申请业务信息表
			// 保存详细信息表
			nrbcpapplibussdtlservice.saveDebtPressingBussDetails(list, debtBussInfoVO.getAppno());
		}
		// TODO Auto-generated method stub
		return appno;
	}

	/**
	 * 催收管理申请提交并发起流程
	 * @param debtBussInfoVO
	 * @param list
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月31日上午9:50:23
	 */
	@Transactional
	@Override
	public void DebtPressingApplyWriteSubmitUpdate(DebtBussInfoVO debtBussInfoVO, List<NDebtBillsInfoVO> list) throws ScubeBizException {
		// 保存业务申请表
		nrbcpapplibussinfoservice.saveOrUpdateDebtAppliBussInfo(debtBussInfoVO);// 保存申请业务信息表
		// 保存详细信息表
		nrbcpapplibussdtlservice.saveDebtPressingBussDetails(list, debtBussInfoVO.getAppno());

		//流程操作
		BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(debtBussInfoVO.getAppno());
		scfWorkFlowService.FactoringProcessDone(appliBaseInfo);
	}
	
	/**
	 * 保存到B_PBC_APPLI_BASE_INFO[业务申请基本信息表]
	 * 国内保理业务 saveBillsVendorAppliBaseInfo方法
	 * @param debtVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月31日上午10:36:45
	 */
	@Transactional
	public String saveBillsVendorAppliBaseInfo(DebtBussInfoVO debtVO, String businessnoType, String workApplyType) throws ScubeBizException {

		BCntBcpInfoVO bcpInfoVO = bcntbcpinfoservice.queryBCntBcpInfoByMastContno(debtVO.getMastContno());
		BPbcAppliBaseInfo bPbcAppliBaseInfo = null;
		if (StringUtil.isEmpty(debtVO.getAppno())) { // 保存新增
			bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
			BeanUtils.copyProperties(debtVO, bPbcAppliBaseInfo);
			bPbcAppliBaseInfo.setCustcd(debtVO.getCustcdSaller());
			bPbcAppliBaseInfo.setMoniCustcd(debtVO.getCustcdBuyer());
			bPbcAppliBaseInfo.setCurcd(bcpInfoVO.getCurcd()); // 币种
			bPbcAppliBaseInfo.setProcessTemplateName(workApplyType); // 流程名称
			bPbcAppliBaseInfo.setAppliType(businessnoType);
			bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
			// 产品ID
			bPbcAppliBaseInfo.setSupplyChainPdId(debtVO.getBussType()); // 业务品种
			bPbcAppliBaseInfo.setMastContno(bcpInfoVO.getMastContno()); // 主合同号
			bPbcAppliBaseInfo.setMemo(debtVO.getMemo());
			bPbcAppliBaseInfo.setProtocolNo(debtVO.getLoanWay()); // 出账方式 ?
			bPbcAppliBaseInfo.setAmt(debtVO.getTotalAmount());
			// bPbcAppliBaseInfo.setAmt(debtVO.getTotalDebtAmount());
			// 融资模式
			String financingType = debtVO.getFinancingType();
			// 获得appno
			String appno = "";
			if (financingType.equals(ScfBasConstant.T_FINANCING_TYPE_INVOICE)) {// 应收账款催收
				appno = ibSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSCS_T_APP_NO);
			} else if (financingType.equals(ScfBasConstant.T_FINANCING_TYPE_POOL)) {// 应收账款池催收
				appno = ibSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSCS_F_APP_NO);
			}
			;

			bPbcAppliBaseInfo.setAppno(appno);
			bPbcAppliBaseInfo.setWorkflowAppno(appno);

			bpbcapplibaseinfoservice.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		} else {// 更新
			bPbcAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(debtVO.getAppno());
			bPbcAppliBaseInfo.setMemo(debtVO.getMemo());
			bPbcAppliBaseInfo.setAmt(debtVO.getTotalAmount());// 老
			// bPbcAppliBaseInfo.setAmt(debtVO.getTotalDebtAmount());
			bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}
		return bPbcAppliBaseInfo.getAppno();
	}

	@Override
	public void doWorkForPass(String appNo) {
		//判断是否存在特殊调用路劲，存在则执行特殊路径，不存在则继续执行下列方法
		String invokPhase = ScfBasConstant.INVOKE_PHASE_PRESS;//催收申请阶段
		String callerpath = "NDebtPressApplyServiceImpl";
		boolean flag = scfWorkFlowService.invokAnotherClasspath(appNo, invokPhase, callerpath);
		if(flag)
		{
			return;
		}
		RBcpAppliBussInfo appliBussInfo = nrbcpapplibussinfoservice.findBcpAppliBussInfoByAppno(appNo);
		int warnCount = 0;
		int pressCount = 0;
		if (appliBussInfo.getReturnType().equals("1")) {
			warnCount++;
		}
		if (appliBussInfo.getReturnType().equals("2")) {
			pressCount++;
		}
		
		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(appliBussInfo, debtVO);
		debtVO.setPressMode(appliBussInfo.getReturnType());
		
		List<RBcpAppliBussDtl> list = nrbcpapplibussdtlservice.queryRBcpAppliBussDtlByAppno(appNo);
		// 更新到正式数据表中
		List<NDebtBillsInfoVO> list2 = new ArrayList<NDebtBillsInfoVO>();
		RBcpAppliBussDtl dtl = new RBcpAppliBussDtl();
		NDebtBillsInfoVO invoiceVO = null;
		Iterator<RBcpAppliBussDtl> iter = list.iterator();
		while (iter.hasNext())
		{
			dtl = iter.next();
			invoiceVO = new NDebtBillsInfoVO();
			BeanUtils.copyProperties(dtl, invoiceVO);
			invoiceVO.setId(invoiceVO.getDebtId());
			invoiceVO.setWarnCount(
					new BigDecimal(Integer.valueOf((dtl.getWarnCount() == null ? new BigDecimal(0) : dtl.getWarnCount()).toString()) + warnCount));
			invoiceVO.setPressCount(
					new BigDecimal(Integer.valueOf((dtl.getPressCount() == null ? new BigDecimal(0) : dtl.getPressCount()).toString()) + pressCount));
			list2.add(invoiceVO);
			// 更新应收账款信息
			RBcpDebtInfoVO bcpDebtInfoVO = rbcpdebtinfoservice.queryRBcpDebtInfoById(invoiceVO.getId());
			// 催收提示次数
			bcpDebtInfoVO.setWarnCount(
					new BigDecimal(Integer.valueOf((dtl.getWarnCount() == null ? new BigDecimal(0) : dtl.getWarnCount()).toString()) + warnCount));
//			dtl.setWarnCount(bcpDebtInfoVO.getWarnCount());
			// 催收次数
			bcpDebtInfoVO.setPressCount(
					new BigDecimal(Integer.valueOf((dtl.getPressCount() == null ? new BigDecimal(0) : dtl.getPressCount()).toString()) + pressCount));
//			dtl.setPressCount(bcpDebtInfoVO.getPressCount());
//			com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl appliBussDtl = 
//					new com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl();
//			BeanUtils.copyProperties(dtl, appliBussDtl);
//			rbcpapplibussdtldao.updateByPrimaryKeySelective(appliBussDtl);
			rbcpdebtinfoservice.updateRBcpDebtInfo(bcpDebtInfoVO);
		}
		this.debtPressingSubmitApp(list2,debtVO);
		
		// 单岗操作，生成通知书
		if (RBcpDebtConstant.DEBT_PRESS_MODE_PROMPT_PAYMENT.equals(debtVO.getPressMode()))
		{//提示付款
			nbntenoticebaseservice.savePromptPaymentNoticeInfo(appNo);
		}
		else if (RBcpDebtConstant.DEBT_PRESS_MODE_COLLECTION.equals(debtVO.getPressMode()))
		{//催收
			nbntenoticebaseservice.dealWithNoticeInfo(appNo);
		}
		nbntenoticebaseservice.modifyNoticeBaseInfo(appNo, NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		
		debtfinancingservice.releaseAppliDebtBaseInfo(appNo);//对流程锁定的应收账款进行解锁
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
	

	/**
	 * 催收申请 debtPressingSubmitApp 方法(审批通过时调用)
	 * @param insertDebtList
	 * @param debtVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月31日下午3:45:51
	 */
	public void debtPressingSubmitApp(List<NDebtBillsInfoVO> insertDebtList, DebtBussInfoVO debtVO) throws ScubeBizException {
		debtVO.setApplyType(RBcpDebtConstant.APPLY_TYPE_COLLECTION);
		debtVO.setReason(debtVO.getOtherReason());
		debtVO.setAmount(debtVO.getTotalDebtAmount());
		debtVO.setTotalNum(debtVO.getDebtNum());
		// 添加业务流水表主表
		RBcpDebtBussInfo rBcpDebtBussInfo = nrbcpdebtbussinfoservice.debtBussInfoAdd(debtVO);
		// 添加流水详细信息表
		nrbcpdebtbussdtlservice.debtPressingSubmit(insertDebtList, rBcpDebtBussInfo);
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
		RBcpAppliBussInfo appliBussInfo = nrbcpapplibussinfoservice.findBcpAppliBussInfoByAppno(appNo);
		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(appliBussInfo, debtVO);

		List<RBcpAppliBussDtl> list = nrbcpapplibussdtlservice.queryRBcpAppliBussDtlByAppno(appNo);
		// 更新到正式数据表中
		List<NDebtBillsInfoVO> list2 = new ArrayList<NDebtBillsInfoVO>();
		RBcpAppliBussDtl dtl = new RBcpAppliBussDtl();
		NDebtBillsInfoVO invoiceVO = null;
		Iterator<RBcpAppliBussDtl> iter = list.iterator();
		while (iter.hasNext())
		{
			dtl = iter.next();
			invoiceVO = new NDebtBillsInfoVO();
			BeanUtils.copyProperties(dtl, invoiceVO);
			invoiceVO.setId(invoiceVO.getDebtId());
			list2.add(invoiceVO);
		}
		this.DebtPressingApplyWriteSubmitUpdate(debtVO, list2);
	}
}

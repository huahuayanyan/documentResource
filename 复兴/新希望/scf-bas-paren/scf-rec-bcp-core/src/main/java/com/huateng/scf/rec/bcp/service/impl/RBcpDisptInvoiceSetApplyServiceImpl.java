package com.huateng.scf.rec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.flowsharp.entity.NodeEntity;
import com.huateng.scf.bas.brp.model.BBrpPrdFactoring;
import com.huateng.scf.bas.brp.service.IBBrpPrdFactoringService;
import com.huateng.scf.bas.cnt.constant.BCntBizConstant;
import com.huateng.scf.bas.cnt.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.model.BCntDebtInfoVO;
import com.huateng.scf.bas.cnt.model.DebtContVO;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.bas.cnt.service.IBCntDebtExtInfoService;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.AppliBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.FactoringContVO;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtPool;
import com.huateng.scf.rec.bcp.model.RBcpDebtQueryVO;
import com.huateng.scf.rec.bcp.service.IFactFinanceBaseService;
import com.huateng.scf.rec.bcp.service.IFactoringDebtBackService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtPoolService;
import com.huateng.scf.rec.bcp.service.IRBcpDisptInvoiceSetApplyService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("RBcpDisptInvoiceSetApplyServiceImpl")
public class RBcpDisptInvoiceSetApplyServiceImpl implements IRBcpDisptInvoiceSetApplyService,DealEndFlowService,DealInFlowService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private static final String String = null;

	@Resource(name="RBcpDebtBaseInfoServiceImpl")
	IRBcpDebtBaseInfoService RBcpDebtBaseInfo;
	
	@Resource(name="RBcpAppliBussInfoServiceImpl")
	IRBcpAppliBussInfoService rBcpAppliBussInfoService;
	
	@Resource(name ="BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService iBPbcAppliBaseInfoService;
	
	@Resource(name="RBcpDebtBussInfoServiceImpl")
	IRBcpDebtBussInfoService rBcpDebtBussInfoService;
	
	@Resource(name="BCntDebtInfoServiceImpl")
	IBCntDebtInfoService bCntDebtInfoService;
	
	@Resource(name="BBrpPrdFactoringServiceImpl")
	IBBrpPrdFactoringService bBrpPrdFactoringService;
	
	@Resource(name="RBcpDebtBussDtlServiceImpl")
	IRBcpDebtBussDtlService rBcpDebtBussDtlService;
	
	@Resource(name="RBcpAppliBussDtlServiceImpl")
	IRBcpAppliBussDtlService iRbcpAppliBussDtlService;
	
	@Resource(name="BCntDebtExtInfoServiceImpl")
	IBCntDebtExtInfoService bCntDebtExtInfoService;
	
	@Resource(name="RBcpDebtBaseInfoServiceImpl")
	IRBcpDebtBaseInfoService  iRBcpDebtBaseInfoService;
	
	@Resource(name="FactoringDebtBackServiceImpl")
	IFactoringDebtBackService factoringDebtBackService;
	
	@Autowired
	IProcessService processService;
	
	@Autowired
	ITaskService taskService;
	
	@Resource(name=IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name="RBcpDebtPoolServiceImpl")
	IRBcpDebtPoolService rBcpDebtPoolService;
	
	@Resource(name="AmountServiceImpl")
	IAmountService amountService;
	
	@Resource(name = "FactFinanceBaseServiceImpl")
	IFactFinanceBaseService factfinancebaseservice;
	
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bcrmbaseinfoservice;
	
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bprdinfoservice;
	
	// 应收账款基本信息
	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO rBcpDebtBaseInfoDAO;
	
	//任务基本信息
	@Override
	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(String appno)
	{
		String process = WorkflowConstant.PROCNAME_DISPUTE_INVOICE_SET_APPLY;
		return scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appno,process);
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	@Override
	public Page queryBCntDebtInfoListByPage(int pageNo, int pageSize, MastContQryVO mastContQryVO)
			throws ScubeBizException {
		Page resultPage = new Page(pageSize, pageNo, 0);
		Map<String, Object> parameters = new HashMap<String, Object>();

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
			if (StringUtil.isEmpty(factType)) {
				factTypes.add(BCntBizConstant.FACT_TYPE_INLAND);// 国内保理
				factTypes.add(BCntBizConstant.FACT_TYPE_REVERSE);// 反向保理
				factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_PLEDGE);// 应收账款质押
				factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL_PLEDGE);// 应收账款质押池融资
				factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL);// 保理池融资
				factTypes.add(BCntBizConstant.FACT_TYPE_EXPORT_POOL_PLEDGE);// 出口退税池质押融资
			}
			else if (factType.equals(BCntBizConstant.T_FINANCING_TYPE_INVOICE)) {
				factTypes.add(BCntBizConstant.FACT_TYPE_INLAND); //// 国内保理
				factTypes.add(BCntBizConstant.FACT_TYPE_REVERSE); //// 反向保理
				factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_PLEDGE); //// 应收账款质押
			}

			parameters.put("factTypes", factTypes);

//			ScfGlobalInfo gb = ScfGlobalInfoUtil.getScfGlobalInfo();
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
				parameters.put("mgrno", mgrno);
			}
			if (StringUtil.isStrNotEmpty(cname)) {
				parameters.put("cname", cname);
			}

			if (StringUtil.isStrNotEmpty(conStatus)) {
				parameters.put("conStatus", conStatus);
			}
			if (StringUtil.isStrNotEmpty(debtContno)) {
				parameters.put("debtContno", debtContno);
			}
			if (StringUtil.isStrNotEmpty(buyerName)) {
				parameters.put("buyerName", buyerName);
			}
		}
		
		List<DebtContVO> records = bCntDebtInfoService.findBCntDebtInfoByPage(parameters, resultPage);
		resultPage.setRecords(records);

		return resultPage;
	}
	
	
	/**
	 *  查找待添加发票
	 * @param commonQueryVO
	 */
	@Override
	public Page getInvoiceListBySallerBuyerAndContno(int pageNo,int pageSize,DebtCommonQryVO commonQueryVO) {
		RBcpDebtBaseInfo rBcpDebtBaseInfo = new RBcpDebtBaseInfo();
		BeanUtils.copyProperties(commonQueryVO, rBcpDebtBaseInfo);	
		
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("status1", DebtConstants.INVOICE_STATUS_PURCHASED);
		omap.put("status2", DebtConstants.INVOICE_STATUS_FINANCED);
		omap.put("issueFlag",  DebtConstants.ISSUE_FLAG_FALSE);
		omap.put("isLocked", ScfBasConstant.LOCKED);
		if (!StringUtil.isEmpty(commonQueryVO.getMastContno())) {
			omap.put("mastContno", commonQueryVO.getMastContno());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getCustcdBuyer_Q())) {
			omap.put("custcdBuyer", commonQueryVO.getCustcdBuyer_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getCustcdSaller_Q())) {
			omap.put("custcdSaller", commonQueryVO.getCustcdSaller_Q());
		}
		if(StringUtil.isStrNotEmpty(commonQueryVO.getAppno_Q()))
		{
			omap.put("lockAppno", commonQueryVO.getAppno_Q());
		}
		if(StringUtil.isStrNotEmpty(commonQueryVO.getBillsDate_from_Q()))
		{
			omap.put("billsDate1", commonQueryVO.getBillsDate_from_Q());
		}
		
		if(StringUtils.isNotEmpty(commonQueryVO.getBillsDate_to_Q())){
			omap.put("billsDate2", commonQueryVO.getBillsDate_to_Q());
		}
		
		if(StringUtils.isNotEmpty(commonQueryVO.getEndDate_from_Q())){
			omap.put("debtEnd1", commonQueryVO.getEndDate_from_Q());
		}
		if(StringUtils.isNotEmpty(commonQueryVO.getEndDate_to_Q())){
			omap.put("debtEnd2", commonQueryVO.getEndDate_to_Q());
		}
		
		if(!StringUtil.isEmpty(commonQueryVO.getBillsNo_Q())){//凭证编号
			omap.put("billsNo", commonQueryVO.getBillsNo_Q());
		}
		if(!StringUtil.isEmpty(commonQueryVO.getBillsType_Q())){//凭证类型
			omap.put("billsType", commonQueryVO.getBillsType_Q());
		}
		
		Page page = new Page(pageSize, pageNo, 0);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> listdebt = rBcpDebtBaseInfoDAO.selectDisputeInvoiceForAdding(omap,page);
		int count = rBcpDebtBaseInfoDAO.selectDisputeInvoiceForAddingCount(omap);
		page.setRecords(listdebt);
		page.setTotalRecord(count);
//		int pageNo = 1;
//		int pageSize = 10;
//		Page page = iRBcpDebtBaseInfoService.findInovListByCommonQueryVO(pageNo, pageSize, rBcpDebtBaseInfo);
		return page;
	}

/**========================================================================================================**/
	/**
	 * 保存操作 保存此合同项下指定买家的相关应收账款发票
	 * @param debtVO
	 * @param insertList
	 * @param in_appno
	 */
	@Transactional
	@Override
	public String disputeInvoiceSetApplySaveUpdate(DebtBussInfoVO debtVO, List<DebtBillsInfoVO> insertList)
	{
		String appno =debtVO.getAppno();
		//商纠申请保存
		if(StringUtils.isEmpty(appno))
		{
			String businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEINVOICESETAPPLY;
			
			//PROCNAME_DISPUTE_INVOICE_SET_APPLY = "DisputeInvoiceSetApply"
			//FACT_TYPE_INLAND 国内保理
			String workApplyType = WorkflowConstant.PROCNAME_DISPUTE_INVOICE_SET_APPLY;
			if(BCntBizConstant.FACT_TYPE_REVERSE.equals(debtVO.getFactType())
					||BCntBizConstant.FACT_TYPE_INLAND.equals(debtVO.getFactType())
					||BCntBizConstant.FACT_TYPE_DEBT_PLEDGE.equals(debtVO.getFactType())){
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEINVOICESETAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_INVOICE_SET_APPLY;

			}else if(BCntBizConstant.FACT_TYPE_DOUBLE_FACT.equals(debtVO.getFactType())){
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEDOUBLEINVOICESETAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_DOUBLE_INVOICE_SET_APPLY;

			}else if(BCntBizConstant.FACT_TYPE_CREDIT_FACT.equals(debtVO.getFactType())){
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTECREDITINVOICESETAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_CREDIT_INVOICE_SET_APPLY;

			}else if(BCntBizConstant.FACT_TYPE_LEASE_FACT.equals(debtVO.getFactType())){
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTELEASEINVOICESETAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_LEASE_INVOICE_SET_APPLY;

			}else if(BCntBizConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(debtVO.getFactType())||
					BCntBizConstant.FACT_TYPE_DEBT_POOL.equals(debtVO.getFactType())||
					BCntBizConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(debtVO.getFactType())){
				businessnoType = WorkflowConstant.APPLI_TYPE_DISPUTEPOOLINVOICESETAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DISPUTE_POOL_INVOICE_SET_APPLY;
			}
			
			debtVO.setMastContcode(debtVO.getMastContno());
			
			//保存申请基本信息 B_PBC_APPLI_BASE_INFO
			appno = iBPbcAppliBaseInfoService.saveBillsVendorAppliBaseInfo(debtVO, businessnoType,
					workApplyType);	
			
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", workApplyType);
			paramMap.put("NodeId", "DisputeInvoiceSetSave");
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				scfWorkFlowService.commonStartFlow(appno, workApplyType, workApplyType, paramMap);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(StringUtils.isNotEmpty(appno)){
			debtVO.setAppno(appno);
			//保存  应收账款业务申请流水基本信息表 R_BCP_APPLI_BUSS_INFO
			rBcpAppliBussInfoService.saveOrUpdateDebtAppliBussInfo(debtVO);// 更新申请业务信息表
			//保存  应收账款融资业务申请流水明细表 R_BCP_APPLI_BUSS_DTL
			iRbcpAppliBussDtlService.saveDebtPressingBackToModifyBussDetails(insertList,debtVO.getAppno());
		}
		
		return appno;
	}
	
	
	/**
	 * DisputeInvoiceSetApplyWriteSubmitUpdate 商业纠纷提交
	 * @param debtVO
	 * @param insertList
	 * @param in_appno
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	@Override
	public void disputeInvoiceSetApplyWriteSubmitUpdate(DebtBussInfoVO debtVO, List insertList, boolean isProcess)throws ScubeBizException{
		if (debtVO.getAppno() == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		log.debug("appno:"+debtVO.getAppno());
		//保存业务申请表
		rBcpAppliBussInfoService.saveOrUpdateDebtAppliBussInfo(debtVO);// 保存申请业务信息表
		//保存详细信息表
		iRbcpAppliBussDtlService.saveDebtPressingBackToModifyBussDetails(insertList,debtVO.getAppno());
		
		if(isProcess)
		{
			BPbcAppliBaseInfo appliinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(debtVO.getAppno());
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
	 * 商业纠纷回执确认
	 * @param debtVO
	 * @param insertList
	 * @param in_appno
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	@Override
	public void disputeInvoiceSetApplyReceiptUpdate(DebtBussInfoVO debtVO, List<RBcpAppliBussDtl> insertList,String in_appno){

		//更新到正式数据表中
		List list2 = new ArrayList();
		RBcpAppliBussDtl invoiceVO = null;
		Iterator iter= insertList.iterator();
		while(iter.hasNext()){
			invoiceVO = (RBcpAppliBussDtl) iter.next();
			invoiceVO.setId(invoiceVO.getDebtId());
			list2.add(invoiceVO);
		}
		rBcpDebtBussDtlService.disputeInvoiceSetSubmitApp(list2, debtVO);
	}





//	@Override
//	public DebtBussInfoVO convertToDebtBussInfoVO(BCntDebtInfo bCntDebtInfo) {
//		DebtBussInfoVO debtBussInfoVO = new DebtBussInfoVO();
//		RBcpDebtBussInfo rBcpDebtBussInfo = new RBcpDebtBussInfo();
//		rBcpDebtBussInfo.setMastContno(bCntDebtInfo.getDebtContno());
//		RBcpDebtBussInfo rBcpDebtBussInfoNew = rBcpDebtBussInfoService.findRBcpDebtBussInfoByKey(rBcpDebtBussInfo);
//		BeanUtils.copyProperties(rBcpDebtBussInfoNew,debtBussInfoVO);
//		return debtBussInfoVO;
//	}
	
	/**
	 */
	public BCntDebtInfoVO queuyUnTakeTaskDetailPage(String appno,String buyerCustcd){
		
		BCntDebtInfoVO bCntDebtInfoVO =iBPbcAppliBaseInfoService.queuyBCntDebtInfoVOByAppno( appno, buyerCustcd);
		return bCntDebtInfoVO;
		
	}
	
	/**
	 * 通过appno,在代办任务中获取商纠申请的详情信息
	 */
	/*public com.huateng.scf.rec.bcp.model.AppliBussInfoVO queuySavedPageResult(String appno){
		String mastContno_Q = "";  // 内部合同号
		String custcdSaller_Q = "";  // 卖方客户号
		String custcdBuyer_Q = "";  // 买方客户号

//		String flag2="";
//		String taskName="";
		
		if(StringUtils.isNotBlank(appno)){//若申请号不为空，获取申请的合同号和卖方id
			BPbcAppliBaseInfo tabi = iBPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			mastContno_Q = tabi.getMastContno();
			custcdBuyer_Q = tabi.getMoniCustcd();
			custcdSaller_Q= tabi.getCustcd();
		}
		

		FactoringContVO contDetail = getFactContDetailByMastContno(mastContno_Q);
		DebtBussInfoVO contVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(contVO, contDetail);
		//根据appno从应收账款业务申请流水基本信息表中查询出相应记录
		com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo  bcpAppliBussInfo =rBcpAppliBussInfoService.findByAppno(appno);
		com.huateng.scf.rec.bcp.model.AppliBussInfoVO debtVO = new com.huateng.scf.rec.bcp.model.AppliBussInfoVO();
		BeanUtils.copyProperties(bcpAppliBussInfo, debtVO);
		
		if(StringUtils.isNotBlank(appno)){
			Date startDate;
			try {
				startDate = ScfDateUtil.toDate(debtVO.getBillDate(), ScfDateUtil.DATE_FORMAT_YYYYMMDD);
				debtVO.setStartDate(String.valueOf(startDate));//合同有效日
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			try {
				Date endDate  = ScfDateUtil.toDate(debtVO.getBillEndDate(), ScfDateUtil.DATE_FORMAT_YYYYMMDD);
				debtVO.setEndDate(String.valueOf(endDate));//合同到期日
			} catch (ParseException e) {
				e.printStackTrace();
			}

			debtVO.setBussType(contVO.getBussType());//业务品种
			debtVO.setTotalNum(contVO.getDebtNum());//发票份数
			debtVO.setTotalAmount(debtVO.getTotalDebtAmount());//发票金额
			debtVO.setAmount(contVO.getAmount());
			debtVO.setPressMode(debtVO.getReturnType());//催收方式
			debtVO.setAppno(appno);

		}
		
		return debtVO;
		
	}*/

	
	/**
	 * 获取该合同下的所有的关联融资信息
	 * @return
	 * @throws CommonException
	 */
	@Override
	public Page queryInvoiceRelatedFinancing(RBcpDebtQueryVO debtQueryVO,int pageSize,int pageNo) {
		RBcpAppliBussInfo appliBussInfo = new RBcpAppliBussInfo(); 
		appliBussInfo.setCustcdSaller(debtQueryVO.getCustcdSaller());
		appliBussInfo.setCustcdBuyer(debtQueryVO.getCustcdBuyer());
		appliBussInfo.setMastContno(debtQueryVO.getMastContno());
		appliBussInfo.setDebetNo(debtQueryVO.getDebetNo());
		Page page =factoringDebtBackService.getLanLnciInfoByContno(pageNo, pageSize, appliBussInfo);
		return page;
	}
	
	/**
	 * 根据待办任务查询详情页面
	 * @param task
	 * @return
	 */
	/*public com.huateng.scf.rec.bcp.model.AppliBussInfoVO queryVOFromAppliBaseInfo(String appno){
		com.huateng.scf.rec.bcp.model.AppliBussInfoVO debtVO = new com.huateng.scf.rec.bcp.model.AppliBussInfoVO();

			com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo rBcpAppliBussInfo= rBcpAppliBussInfoService.findByAppno(appno);//获取申请基本信息			
			BeanUtils.copyProperties(rBcpAppliBussInfo, debtVO);
				try {
					Date startDate = ScfDateUtil.toDate(debtVO.getBillDate(), ScfDateUtil.DATE_FORMAT_YYYYMMDD);
					debtVO.setStartDate(String.valueOf(startDate));//合同有效日
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				try {
					Date endDate  = ScfDateUtil.toDate(debtVO.getBillEndDate(), ScfDateUtil.DATE_FORMAT_YYYYMMDD);
					debtVO.setEndDate(String.valueOf(endDate));//合同到期日
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				debtVO.setBussType(debtVO.getBussType());//业务品种
				debtVO.setTotalNum(debtVO.getDebtNum());//发票份数
				debtVO.setTotalAmount(debtVO.getTotalDebtAmount());//发票金额
				debtVO.setAmount(debtVO.getAmount());
				debtVO.setPressMode(debtVO.getReturnType());//催收方式
				debtVO.setAppno(appno);
				FactoringContVO contDetail = getFactContDetailByMastContno(debtVO.getMastContno());
				DebtBussInfoVO contVO = new DebtBussInfoVO();
				BeanUtils.copyProperties(contDetail,contVO);
				
				debtVO.setLoanPercent(contVO.getLoanPercent());
				debtVO.setBailAcctNo(contVO.getBailAcctNo());

		return debtVO;
		
	}*/
	
	
	
	public FactoringContVO getFactContDetailByMastContno(String mastContno) {
		FactoringContVO factContVO = new FactoringContVO();
		String productId = "";
		
		BCntDebtInfo contDebtInfo =bCntDebtInfoService.queryContInfoByMastContno(mastContno);
		if(contDebtInfo!=null){
			productId = contDebtInfo.getSupplyChainPdId();
			BBrpPrdFactoring productFactoring  = bBrpPrdFactoringService.findBBrpPrdFactoringByKey(productId);
			BigDecimal graceDays = productFactoring.getGraceDays();
			BigDecimal debtGraceDays = productFactoring.getDebtGraceDays();
			productFactoring.setGraceDays(null);
			productFactoring.setDebtGraceDays(null);
			factContVO = new FactoringContVO();
			BeanUtils.copyProperties(productFactoring,factContVO);
			BeanUtils.copyProperties(contDebtInfo,factContVO);		
			factContVO.setGraceDays(Integer.valueOf(graceDays.toString()));
			factContVO.setDebtGraceDays(Integer.valueOf(debtGraceDays.toString()));
		}
		return factContVO;
	}
	

	
	/**
	 * 根据待办任务查询详情页面
	 * @param task
	 * @return
	 */
//	@Override
//	public List getInvoiceListInWrkPrcsPage(String appno,String bussType){
//		
//		DebtCommonQryVO commonQryVO = new DebtCommonQryVO();
//		String mastContno="";
//		if(StringUtils.isNotEmpty(mastContno)){
//			commonQryVO.setMastContno(mastContno);
//		}
//		String custcdSaller="";
//		if(StringUtils.isNotEmpty(custcdSaller)){
//			commonQryVO.setCustcdSaller_Q(custcdSaller);
//		}
//		String custcdBuyer="";
//		if(StringUtils.isNotEmpty(custcdBuyer)){
//			commonQryVO.setCustcdBuyer_Q(custcdBuyer);
//		}
//		String id_Q="";
//		if(StringUtils.isNotEmpty(id_Q)){
//			commonQryVO.setId_Q(id_Q);
//		}
//		
//		List<RBcpAppliBussDtl> list =iRbcpAppliBussDtlService.queryAppliBussDetailByAppno(appno,bussType);	
//		
//		Iterator<RBcpAppliBussDtl> iter = list.iterator();
//		
//		List<RBcpAppliBussDtl> resultList = new ArrayList<RBcpAppliBussDtl>();
//		String money ="";
//		String issueReason="";
//		String otherReason="";
//	
//		int pageNo = 1;
//		int pageSize = 10;
//		RBcpDebtBaseInfo rBcpDebtBaseInfo = new RBcpDebtBaseInfo();
//		rBcpDebtBaseInfo.setId(id_Q);
//		
//		Page page = iRBcpDebtBaseInfoService.findRBcpDebtBaseInfoPageByPage(pageNo, pageSize, rBcpDebtBaseInfo);
//		List  list1 = page.getRecords();
//		if(list1!=null&&list1.size()>0){
//			Iterator iters = list1.iterator();
//			while(iters.hasNext()){
//				RBcpAppliBussDtl debtVO = (RBcpAppliBussDtl)iters.next();
//				debtVO.setDebtId(debtVO.getId());
//				if(StringUtils.isNotEmpty(money)&&!(money.equals("NaN"))){
//					debtVO.setMoney(new BigDecimal(money));
//				}else{
//					debtVO.setMoney(new BigDecimal("0"));
//				}
//				debtVO.setIssueReason(issueReason);
//				debtVO.setOtherReason(otherReason);
//
//				for(int i = 0; i < list.size() ; i++){
//					RBcpAppliBussDtl applyDebtVO = (RBcpAppliBussDtl) list.get(i);
//					if(debtVO.getId().equals(applyDebtVO.getDebtId())){
//						debtVO.setId(applyDebtVO.getDebtId());
//						debtVO.setDebtId(applyDebtVO.getDebtId());
//						list.remove(i);
//						break;
//
//					}
//				}
//				resultList.add(debtVO);//bussDetail中的ID与正式表中的ID不一致，DebtID才是一致
//			}
//		}
//		return resultList;
//		
//	}


	
	/**
	 * 根据待办任务查询详情页面
	 * @param task
	 * @return
	 */
//	public void submitSignal(DebtBussInfoVO rBcpAppliBussInfo,String comment) throws Exception{
//		
//		String taskId = WorkflowConstant.DISPUTEINVOICE_SAVE;
//		BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoService
//				.findBPbcAppliBaseInfoByKey(rBcpAppliBussInfo.getAppno());
//		String processId = bPbcAppliBaseInfo.getPiid();
//		String userId = ContextHolder.getUserInfo().getTlrNo();
//		taskService.takeTask(taskId, processId, userId);
//		// 任务提交d
//		taskService.completeTask(taskId, processId, userId, comment);
//		// 节点转移(自己要再设置一下)
//		processService.autoSignal(processId);// 通知书回执节点(下一节点)
//
//		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);// 已提交(未审批)
//		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);// 已提交
//		
//		iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
//
//	}
	
	@Transactional
	@Override
	public void doWorkForPass(String appNo) {
		List<RBcpAppliBussDtl> insertList = iRbcpAppliBussDtlService.queryAppliBussDetailByAppno(appNo, "");
		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		RBcpAppliBussInfo appliBussInfo = rBcpAppliBussInfoService.findByAppno(appNo);
		BeanUtils.copyProperties(appliBussInfo, debtVO);
		disputeInvoiceSetApplyReceiptUpdate(debtVO, insertList, appNo);
	}



	@Override
	public void doWorkForReject(String appNo) {
		
		BPbcAppliBaseInfo bPbcAppliBaseInfo = iBPbcAppliBaseInfoService
				.findBPbcAppliBaseInfoByKey(appNo);
		
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_REFUSED);// 已通过(审批通过)
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);// 已通过
		iBPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		
	}


	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub
		
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void doWorkForSubmit(String appNo) throws ScubeBizException {
		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		RBcpAppliBussInfo appliBussInfo = rBcpAppliBussInfoService.findByAppno(appNo);
		BeanUtils.copyProperties(appliBussInfo, debtVO);
		List<RBcpAppliBussDtl> insertList = iRbcpAppliBussDtlService.queryAppliBussDetailByAppno(appNo, "");
		List list = new ArrayList();
		if(insertList.size()>0)
		{
			for(RBcpAppliBussDtl appliBussDtl:insertList)
			{
				DebtBillsInfoVO baseInfo = new DebtBillsInfoVO();
				BeanUtils.copyProperties(appliBussDtl, baseInfo);
				baseInfo.setId(appliBussDtl.getDebtId());
				list.add(baseInfo);
			}
		}
		String process = WorkflowConstant.PROCNAME_DISPUTE_INVOICE_SET_APPLY;
		BPbcAppliBaseInfo pbcinfo = scfWorkFlowService.findBPbcAppliBaseInfoByAppno(appNo,process);
		String processId = pbcinfo.getPiid();
		NodeEntity nodeEntity = new NodeEntity();
		try {
			nodeEntity = processService.getCurrentNodeEntity(processId);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nodeId = nodeEntity.getId();
		if(nodeId.equals("DisputeInvoiceSetSave"))
		{//商纠申请提交
			disputeInvoiceSetApplyWriteSubmitUpdate(debtVO, list, false);
		}
		if(nodeId.equals("DisputeInvoiceSetSubmit"))
		{//商业纠纷设立回执确认
			disputeInvoiceSetApplyReceiptUpdate(debtVO, insertList, appNo);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DebtBussInfoVO DisputeInvoiceSetApplyAdd(DebtBussInfoVO debtBussInfoVO) {
		String mastContno = debtBussInfoVO.getMastContno();
		String custcdSaller = debtBussInfoVO.getCustcdSaller();
		String appno = debtBussInfoVO.getAppno();
		String custcdBuyer = debtBussInfoVO.getCustcdBuyer();
		if(!"".equals(appno) && appno!=null){//若申请号不为空，获取申请的合同号和卖方id
			BPbcAppliBaseInfo tabi = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			mastContno = tabi.getMastContno();
			custcdBuyer = tabi.getMoniCustcd();
			custcdSaller= tabi.getCustcd();
		}
		DebtCommonQryVO debtCommonQryVO = new DebtCommonQryVO();
		debtCommonQryVO.setMastContno(mastContno);
		debtCommonQryVO.setCustcdBuyer_Q(custcdBuyer);
		debtCommonQryVO.setCustcdSaller_Q(custcdSaller);
		
		FactoringContVO contDetail = getFactContDetailByMastContno(mastContno);
		DebtBussInfoVO contVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(contDetail, contVO);
		List poolList = rBcpDebtPoolService.queryDebtPollByMastContno(mastContno, custcdSaller);
		if(poolList != null && poolList.size()>0){
			RBcpDebtPool tblDebtPool = rBcpDebtPoolService.findRBcpDebtPoolByKey(((RBcpDebtPool)poolList.get(0)).getId());		
			contVO.setTotalDebtRemainAmount(tblDebtPool.getTotalDebtRemainAmount());
			contVO.setPoolRiskAmt(factfinancebaseservice.calculatePoolRiskAvailableAmtByBusinessNo(mastContno));//池敞口余额
		}
		if(StringUtil.isEmpty(appno))
		{
			contVO.setMastContno(contVO.getDebtContno());
			contVO.setCustcdBuyer(debtCommonQryVO.getCustcdBuyer_Q());
			contVO.setCustcdSaller(debtCommonQryVO.getCustcdSaller_Q());
			if(!StringUtil.isEmpty(debtCommonQryVO.getCustcdBuyer_Q()))
			{
				BCrmBaseInfo baseInfo1 = new BCrmBaseInfo();
				baseInfo1.setCustcd(debtCommonQryVO.getCustcdBuyer_Q());
				BCrmBaseInfo user1 = bcrmbaseinfoservice.findBCrmBaseInfoByKey(baseInfo1);
				contVO.setCnameBuyer(user1.getCname());
			}
			if(!StringUtil.isEmpty(debtCommonQryVO.getCustcdSaller_Q()))
			{
				BCrmBaseInfo baseInfo2 = new BCrmBaseInfo();
				baseInfo2.setCustcd(debtCommonQryVO.getCustcdSaller_Q());
				BCrmBaseInfo user2 = bcrmbaseinfoservice.findBCrmBaseInfoByKey(baseInfo2);
				contVO.setCnameSeller(user2.getCname());
			}
			contVO.setBussType(contVO.getSupplyChainPdId());
			contVO.setPressMode(contVO.getReturnType());//催收方式
			if(!StringUtil.isEmpty(contVO.getAccountNo())){
				contVO.setBalanceAccount(contVO.getAccountNo());
			}
			contVO.setLoanPercent(contVO.getLoanPercent());
			contVO.setAppno(appno);
			BPrdInfo bPrdInfo = new BPrdInfo();
			bPrdInfo.setProductId(contVO.getBussType());
			BPrdInfo info = bprdinfoservice.findBPrdInfoByKey(bPrdInfo);
			contVO.setBussTypeName(info.getProductName());
		}
		if(!StringUtil.isEmpty(appno)){
			List tempList = rBcpAppliBussInfoService.getTblAppliBussInfo(appno);//获取申请基本信息
			for(int i=0;i<tempList.size();i++)
			{
				com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo appliBussInfo = 
						(com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo) tempList.get(i);
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
				if(!StringUtil.isEmpty(debtVO.getCustcdBuyer()))
				{
					BCrmBaseInfo baseInfo1 = new BCrmBaseInfo();
					baseInfo1.setCustcd(debtVO.getCustcdBuyer());
					BCrmBaseInfo user1 = bcrmbaseinfoservice.findBCrmBaseInfoByKey(baseInfo1);
					debtVO.setCnameBuyer(user1.getCname());
				}
				if(!StringUtil.isEmpty(debtVO.getCustcdSaller()))
				{
					BCrmBaseInfo baseInfo2 = new BCrmBaseInfo();
					baseInfo2.setCustcd(debtVO.getCustcdSaller());
					BCrmBaseInfo user2 = bcrmbaseinfoservice.findBCrmBaseInfoByKey(baseInfo2);
					debtVO.setCnameSeller(user2.getCname());
				}
				BPrdInfo bPrdInfo = new BPrdInfo();
				bPrdInfo.setProductId(debtVO.getBussType());
				BPrdInfo info = bprdinfoservice.findBPrdInfoByKey(bPrdInfo);
				debtVO.setBussTypeName(info.getProductName());
				BeanUtils.copyProperties(debtVO, contVO);
			}
		}
		
		return contVO;
	}
	
	/**
	 * 争议应收账款列表
	 * @param pageNo
	 * @param pageSize
	 * @param debtVO
	 * @return
	 * @author mengjiajia
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page DisputeInvoiceSetQueryGetter(int pageNo, int pageSize, DebtBussInfoVO debtBussInfoVO)
	{
		String id_Q = debtBussInfoVO.getId();
		String mastContno = debtBussInfoVO.getMastContno();  // 内部合同号
		String custcdSaller= debtBussInfoVO.getCustcdSaller();  // 卖方客户号
		String custcdBuyer= debtBussInfoVO.getCustcdBuyer();  // 买方客户号
		String money= "";
		String otherReason= debtBussInfoVO.getOtherReason();
		String issueReason= "";
		String appno = debtBussInfoVO.getAppno();
		String flag3 = "";
		String[] str = null;
		DebtCommonQryVO commonQryVO = new DebtCommonQryVO();
		if(!StringUtil.isEmpty(mastContno)){
			commonQryVO.setMastContno(mastContno);
		}
		if(!StringUtil.isEmpty(custcdSaller)){
			commonQryVO.setCustcdSaller_Q(custcdSaller);
		}
		if(!StringUtil.isEmpty(custcdBuyer)){
			commonQryVO.setCustcdBuyer_Q(custcdBuyer);
		}
		if(!StringUtil.isEmpty(id_Q)){
			commonQryVO.setId_Q(id_Q);
		}

		commonQryVO.setPageSize(Integer.MAX_VALUE);
		if(!StringUtil.isEmpty(appno))
		{//查申请表
			String bussType="";
			List list = new ArrayList();
			if(!StringUtil.isEmpty(appno)){
				list = iRbcpAppliBussDtlService.getTblAppliBussDetail(appno,bussType); //TBL_APPLI_BUSS_DETAIL【业务申请业务明细表】
			}
			Iterator iter = list.iterator();
			List resultList = new ArrayList();
			if(flag3!=null&&flag3.equals("1")){
				while(iter.hasNext()){//获取流程业务中读取数据
					AppliBussDetailVO debtVO = (AppliBussDetailVO)iter.next();
					if(str!=null){
						for(int j=0;j<str.length;j++){
							if(debtVO.getDebtId().equals(str[j])){
								debtVO.setId(debtVO.getDebtId());
								resultList.add(debtVO);//bussDetail中的ID与正式表中的ID不一致，DebtID才是一致
							}
						}
					}
				}
			}else if(flag3!=null&&flag3.equals("2")){
				Page result = factfinancebaseservice.invoiceBuyerPayList(commonQryVO);
				List list1=result.getRecords();//正式表读取发票
				if(list1!=null && list1.size()>0)
				{
					Iterator iters = list1.iterator();
					while(iters.hasNext())
					{
						DebtBillsInfoVO debtVO = (DebtBillsInfoVO)iters.next();
						debtVO.setDebtId(debtVO.getId());
						if(!StringUtil.isEmpty(money)&&!(money.equals("NaN")))
						{
							debtVO.setMoney(new BigDecimal(money));
						}else
						{
							debtVO.setMoney(new BigDecimal("0"));
						}
						debtVO.setIssueReason(issueReason);
						debtVO.setOtherReason(otherReason);
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
						resultList.add(debtVO);//bussDetail中的ID与正式表中的ID不一致，DebtID才是一致
					}	
				}
			}
			else{
				while(iter.hasNext()){
					AppliBussDetailVO debtVO = (AppliBussDetailVO)iter.next();
					debtVO.setId(debtVO.getDebtId());
//					if("14".equals(debtVO.getIssueReason())){
//						debtVO.setIssueReason(debtVO.getOtherReason());
//					}
				    resultList.add(debtVO);//bussDetail中的ID与正式表中的ID不一致，DebetNo才是一致
				}
			}
			Page pageQueryResult=new Page();
			pageQueryResult.setRecords(resultList);
			return pageQueryResult;
		}

		Page pageQueryResult = factfinancebaseservice.invoiceBuyerPayList(commonQryVO);
		if(null!=pageQueryResult)
		{
			List list = pageQueryResult.getRecords();
			List resultList = new ArrayList();
			if(list!=null && list.size()>0){
				Iterator iter = list.iterator();
				while(iter.hasNext()){
					DebtBillsInfoVO debtVO = (DebtBillsInfoVO)iter.next();
					if(!StringUtil.isEmpty(money)&&!(money.equals("NaN"))){
						debtVO.setMoney(new BigDecimal(money));
					}else{
						debtVO.setMoney(new BigDecimal("0"));
					}
					debtVO.setIssueReason(issueReason);
					debtVO.setOtherReason(otherReason);
					resultList.add(debtVO);
				}

			}
			Page queryResult = new Page(pageSize, pageNo, 0);
			queryResult.setRecords(resultList);
		}
		else
		{
			pageQueryResult = new Page(pageSize, pageNo, 0);
		}
		return pageQueryResult;
	}
	
}

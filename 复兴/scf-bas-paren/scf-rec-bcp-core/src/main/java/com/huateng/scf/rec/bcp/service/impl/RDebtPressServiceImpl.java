/**
 * 
 */
package com.huateng.scf.rec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.cnt.model.BCntDebtInfo;
import com.huateng.scf.bas.cnt.service.IBCntDebtInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfApplyService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.nte.constant.BNteConstant;
import com.huateng.scf.bas.nte.service.IBNteNoticeBaseService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussDtlDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliBussInfoDAO;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo;
import com.huateng.scf.rec.bcp.model.AppliBussDetailVO;
import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtBussInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.model.RBcpDebtBussInfo;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpAppliBussInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussDtlService;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussInfoService;
import com.huateng.scf.rec.bcp.service.IRDebtPressService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 催收
 * </p>
 *
 * @author shangxiujuan
 * @date 2017年1月12日下午4:42:32
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年1月12日下午4:42:32              新增
 *
 *            </pre>
 */
@ScubeService
@Service("RDebtPressServiceImpl")
public class RDebtPressServiceImpl implements IRDebtPressService, DealEndFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = IBCntDebtInfoService.BEAN_ID)
	IBCntDebtInfoService bCntDebtInfoService;
	@Resource(name = IBPbcAppliBaseInfoService.BEAN_ID)
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;// 业务申请表
	@Resource(name = IRBcpAppliBussInfoService.BEAN_ID)
	IRBcpAppliBussInfoService rBcpAppliBussInfoService;// 应收账款业务申请流水基本信息
	@Resource(name = IRBcpAppliBussDtlService.BEAN_ID)
	IRBcpAppliBussDtlService rBcpAppliBussDtlService;// 应收账款融资业务申请流水明细
	@Resource(name = IRBcpDebtBaseInfoService.BEAN_ID)
	IRBcpDebtBaseInfoService rBcpDebtBaseInfoService;// 应收账款单据信息
	@Resource(name = IBNteNoticeBaseService.BEAN_ID)
	IBNteNoticeBaseService bNteNoticeBaseService;// 通知书
	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;
	@Resource(name = IRBcpDebtBussInfoService.BEAN_ID)
	IRBcpDebtBussInfoService rBcpDebtBussInfoService;// 应收业务
	@Resource(name = IRBcpDebtBussDtlService.BEAN_ID)
	IRBcpDebtBussDtlService rBcpDebtBussDtlService;// 应收账款单据明细
	@Resource(name = IScfApplyService.BEAN_ID)
	IScfApplyService scfApplyService;

	// 应收账款业务申请流水基本信息
	@Resource(name = "RBcpAppliBussInfoDAO")
	IRBcpAppliBussInfoDAO rBcpAppliBussInfoDAO;
	// 应收账款融资业务申请流水明细
	@Resource(name = "RBcpAppliBussDtlDAO")
	IRBcpAppliBussDtlDAO rBcpAppliBussDtlDAO;
	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO rBcpDebtBaseInfoDAO; // 应收账款单据信息

	@Resource(name = "bSysSerialNoService")
	private IBSysSerialNoService bSysSerialNoService;
	// private static final String STATUS = "status";
	// private static final String ISSUEFLAG="issueFlag";
	// private static final String ISLOCKED = "isLocked";
	private static final String LOCKAPPNO = "lockAppno";
	private static final String DEBTEND = "debtEnd";
	private static final String PRESSMODE = "pressMode";
	private static final String MASTCONTNO = "mastContno";
	private static final String CUSTCDBUYER = "custcdBuyer";
	private static final String CUSTCDSALLER = "custcdSaller";
	private static final String INSERTDATEFROM = "insertDateFrom";
	private static final String INSERTDATETO = "insertDateTo";
	private static final String BILLSDATEFROM = "billsDateFrom";
	private static final String BILLSDATETO = "billsDateTo";
	private static final String DEBTENDFROM = "debtEndFrom";
	private static final String DEBTENDTO = "debtEndTo";
	private static final String BILLSNO = "billsNo";
	private static final String BILLSTYPE = "billsType";

	/**
	 * 催收待添加发票查询
	 */
	@Override
	public Page getDebtInvoiceInfoPressing(int pageNo, int pageSize, DebtCommonQryVO debtCommonQryVO)
			throws ScubeBizException {
		Page page = new Page(pageSize,pageNo,0);
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (null != debtCommonQryVO) {
			String lockAppno = debtCommonQryVO.getAppno_Q();
			String pressMode = debtCommonQryVO.getFlag();
			String mastContno = debtCommonQryVO.getMastContno();
			String custcdBuyer = debtCommonQryVO.getCustcdBuyer_Q();
			String custcdSaller = debtCommonQryVO.getCustcdSaller_Q();
			String insertDateFrom = debtCommonQryVO.getInsertDate_from_Q();
			String insertDateTo = debtCommonQryVO.getInsertDate_to_Q();
			String billsDateFrom = debtCommonQryVO.getBillsDate_from_Q();// 发票日期
			String billsDateTo = debtCommonQryVO.getBillsDate_to_Q();
			String debtEndFrom = debtCommonQryVO.getDebtEnd_from_Q();// 到期日
			String debtEndTo = debtCommonQryVO.getDebtEnd_to_Q();
			String billsNo = debtCommonQryVO.getBillsNo_Q(); // 凭证编号

			String billsType = debtCommonQryVO.getBillsType_Q(); // 凭证类型
			map.put(LOCKAPPNO, lockAppno);
			map.put(PRESSMODE, pressMode);
			map.put(MASTCONTNO, mastContno);
			map.put(CUSTCDBUYER, custcdBuyer);
			map.put(CUSTCDSALLER, custcdSaller);

			map.put(INSERTDATEFROM, insertDateFrom);
			map.put(INSERTDATETO, insertDateTo);
			map.put(BILLSDATEFROM, billsDateFrom);
			map.put(BILLSDATETO, billsDateTo);
			map.put(DEBTENDFROM, debtEndFrom);
			map.put(DEBTENDTO, debtEndTo);

			map.put(BILLSNO, billsNo);
			map.put(BILLSTYPE, billsType);
		}
		map.put(DEBTEND, BSysConstant.WORKDATE);
		/*
		 * List<String> status=new ArrayList<String>();
		 * status.add(RBcpDebtConstant.INVOICE_STATUS_PURCHASED);
		 * status.add(RBcpDebtConstant.INVOICE_STATUS_FINANCED); map.put(STATUS,
		 * status); map.put(ISSUEFLAG,RBcpDebtConstant.ISSUE_FLAG_FALSE);
		 * map.put(ISLOCKED,ScfBasConstant.LOCKED);
		 */
		rBcpDebtBaseInfoDAO.getDebtInvoiceInfoPressing(map, page);
		return page;
	}

	/**
	 * 根据申请编号获得出账应收账款列表
	 */
	@Override
	public Page getInvoiceAppList(int pageNo, int pageSize, DebtCommonQryVO debtCommonQryVO) throws ScubeBizException {
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		List<AppliBussDetailVO> resultList = new ArrayList<AppliBussDetailVO>();
		List<AppliBussDetailVO> list = new ArrayList<AppliBussDetailVO>();
		if (null != debtCommonQryVO) {
			String appno = debtCommonQryVO.getAppno();
			if (StringUtil.isStrNotEmpty(appno)) {
				list = rBcpAppliBussDtlService.getTblAppliBussDetail(appno, "");
			}
		}
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				AppliBussDetailVO applVO = (AppliBussDetailVO) list.get(i);
				applVO.setId(applVO.getDebtId());
				com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo debtInfo = new com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo();
				if (!StringUtil.isEmpty(applVO.getDebtId())) {
					debtInfo = rBcpDebtBaseInfoDAO.selectByPrimaryKey(applVO.getDebtId());
				}
				if (debtInfo.getPoolFlag() != null && applVO.getPoolFlag() != null && !debtInfo.getPoolFlag().equals(applVO.getPoolFlag())) {
					applVO.setPoolFlag(debtInfo.getPoolFlag());
				}
				resultList.add(applVO);// bussDetail中的ID与正式表中的ID不一致，DebetNo才是一致
			}
			page.setTotalRecord(list.size());
		} else {
			page.setTotalRecord(0);
		}
		page.setRecords(resultList);
		return page;
	}

	/**
	 * 应收账款催收申请保存
	 */
	@Transactional
	@Override
	public String saveDebtPressWriteApply(DebtBussInfoVO debtBussInfoVO, List<DebtBillsInfoVO> list) throws ScubeBizException {
		// 根据申请类型获取流程名称
		String businessnoType = "";// 申请类型
		String workApplyType = ""; // 申请业务类型
		String appno = "";
		appno = debtBussInfoVO.getAppno();
		if (StringUtil.isEmpty(debtBussInfoVO.getAppno())) {
			businessnoType = WorkflowConstant.APPLI_TYPE_DEBTPRESSINGAPPLY;
			workApplyType = WorkflowConstant.PROCNAME_DEBT_PRESSING_APPLY;
			if (ScfBasConstant.FACT_TYPE_REVERSE.equals(debtBussInfoVO.getFactType())
					|| ScfBasConstant.FACT_TYPE_INLAND.equals(debtBussInfoVO.getFactType())
					|| ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(debtBussInfoVO.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DEBTPRESSINGAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DEBT_PRESSING_APPLY;

			} /*
				 * else
				 * if(ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(debtBussInfoVO
				 * .getFactType())){ businessnoType =
				 * WorkflowConstant.APPLI_TYPE_DEBTDOUBLEPRESSINGAPPLY;
				 * workApplyType =
				 * WorkflowConstant.PROCNAME_DEBT_DOUBLE_PRESSING_APPLY;
				 * 
				 * }else
				 * if(ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(debtBussInfoVO
				 * .getFactType())){ businessnoType =
				 * WorkflowConstant.APPLI_TYPE_DEBTCREDITPRESSINGAPPLY;
				 * workApplyType =
				 * WorkflowConstant.PROCNAME_DEBT_CREDIT_PRESSING_APPLY;
				 * 
				 * }else
				 * if(ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(debtBussInfoVO.
				 * getFactType())){ businessnoType =
				 * WorkflowConstant.APPLI_TYPE_DEBTLEASEPRESSINGAPPLY;
				 * workApplyType =
				 * WorkflowConstant.PROCNAME_DEBT_LEASE_PRESSING_APPLY;
				 * 
				 * }
				 */else if (ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(debtBussInfoVO.getFactType())
					|| ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(debtBussInfoVO.getFactType())
					|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(debtBussInfoVO.getFactType())) {
				businessnoType = WorkflowConstant.APPLI_TYPE_DEBTPOOLPRESSINGAPPLY;
				workApplyType = WorkflowConstant.PROCNAME_DEBT_POOL_PRESSING_APPLY;
			}

			// 保存申请基本信息
			appno = this.saveBillsVendorAppliBaseInfo(debtBussInfoVO, businessnoType, workApplyType);

			debtBussInfoVO.setAppno(appno);
			String custCd = debtBussInfoVO.getCustcdSaller();
			String custName = debtBussInfoVO.getCnameSeller(); // 买方名称
																// 待办任务客户的显示修改为卖方
																// 20170224
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
			// scfWorkFlowService.commonStartFlow(appno, workApplyType,
			// workApplyType, paramMap);
			/*
			 * // 获取当前用户 UserInfo user = ContextHolder.getUserInfo(); String
			 * startedUserId=user.getTlrNo(); //扩展业务信息 String bizId=appno;
			 * String custCd=debtBussInfoVO.getCustcd(); String
			 * custName=debtBussInfoVO.getCnameBuyer(); //买方名称 //流程发起
			 * ProcessEntity processEntity =
			 * processService.startProcess(workApplyType, ProcessName, NodeId,
			 * startedUserId, bizId, new
			 * String[]{bizId,custCd,custName,workApplyType}); //更新业务申请表工作流实例号
			 * BPbcAppliBaseInfo bPbcAppliBaseInfo =
			 * bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appno);
			 * String processId =processEntity.getProcessId();
			 * bPbcAppliBaseInfo.setPiid(processId);
			 * bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(
			 * bPbcAppliBaseInfo)
			 */;

			// 工作流开始
			// WorkFlowService.getInstance().commonStartFlow(appno,
			// businessnoType, workApplyType,null);
			// 工作流开始
			/*
			 * WorkFlowService.getInstance().commonStartFlow(in_appno,
			 * businessnoType, workApplyType, null);
			 * context.setAttribute(OUT_APPNO, in_appno);
			 */
		}
		if (StringUtil.isStrNotEmpty(appno)) {
			// List list=(List)context.getAttribute("INSERT_LIST");
			// context.setAttribute(OUT_APPNO, in_appno);
			debtBussInfoVO.setAppno(appno);
			// 保存业务申请表
			rBcpAppliBussInfoService.saveOrUpdateDebtAppliBussInfo(debtBussInfoVO);// 保存申请业务信息表
			// 保存详细信息表
			this.saveDebtPressingBussDetails(list, debtBussInfoVO.getAppno());
		}
		// TODO Auto-generated method stub
		return appno;
	}

	/**
	 * 应收账款催收申请提交
	 */
	@Transactional
	@Override
	public void saveDebtPressWriteSubmit(DebtBussInfoVO debtBussInfoVO, List<DebtBillsInfoVO> list) throws ScubeBizException {
		// 保存业务申请表
		rBcpAppliBussInfoService.saveOrUpdateDebtAppliBussInfo(debtBussInfoVO);// 保存申请业务信息表
		// 保存详细信息表
		this.saveDebtPressingBussDetails(list, debtBussInfoVO.getAppno());

		// 单岗操作，生成通知书
		if (RBcpDebtConstant.DEBT_PRESS_MODE_PROMPT_PAYMENT.equals(debtBussInfoVO.getPressMode())) {
			bNteNoticeBaseService.savePromptPaymentNoticeInfo(debtBussInfoVO.getAppno());
		} else if (RBcpDebtConstant.DEBT_PRESS_MODE_COLLECTION.equals(debtBussInfoVO.getPressMode())) {
			bNteNoticeBaseService.dealWithNoticeInfo(debtBussInfoVO.getAppno());
		}
		// 流程流转
		BPbcAppliBaseInfo appliinfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(debtBussInfoVO.getAppno());
		/*
		 * String processId = bPbcAppliBaseInfo.getPiid(); UserInfo user =
		 * ContextHolder.getUserInfo(); String userId = user.getTlrNo(); // 领取任务
		 * String taskId = WorkflowConstant.TASKNODE_APPLY;
		 * taskService.takeTask(taskId, processId, userId); // 任务提交 String
		 * comment = "申请提交"; taskService.completeTask(taskId, processId, userId,
		 * comment); // 节点转移 processService.signal(processId,
		 * WorkflowConstant.PROCNODE_APPROVE); // 更新业务申请信息状态
		 * bPbcAppliBaseInfo.setApprover(userId); // 当前已审批人员
		 * bPbcAppliBaseInfo.setApproveBrcode(user.getBrNo()); // 当前已审批机构
		 * bPbcAppliBaseInfo.setApproveDate(ScfDateUtil.getStringDate(new
		 * Date())); // 当前已审批日期 bPbcAppliBaseInfo.setApproveTime(new Date()); //
		 * 当前已审批时间 bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.
		 * APPLI_STATUS_DTL_APPROVING);
		 * bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.
		 * APPLI_STATUS_SUBMITUNAPPROVE);
		 * bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		 */
		String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
		// scfWorkFlowService.processTasks(appliinfo, status);
		String custCd = debtBussInfoVO.getCustcdSaller();
		String custName = debtBussInfoVO.getCnameSeller(); // 买方名称
															// 待办任务客户的显示修改为卖方
															// 20170224
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(WorkflowConstant.CUST_CD, custCd);
		paramMap.put(WorkflowConstant.CUST_NAME, custName);
		try {
			scfWorkFlowService.processTask(appliinfo, status, paramMap);
		} catch (FlowsharpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 保存到TBL_APPLI_BASE_INFO[业务申请基本信息表]---国内保理业务 saveBillsVendorAppliBaseInfo
	 * 方法
	 * 
	 * @param debtVO
	 * @param businessnoType
	 * @param workApplyType
	 * @return
	 * @throws ScubeBizException
	 */
	@Transactional
	public String saveBillsVendorAppliBaseInfo(DebtBussInfoVO debtVO, String businessnoType, String workApplyType) throws ScubeBizException {

		BCntDebtInfo bCntDebtInfo = bCntDebtInfoService.findBCntDebtInfoByKey(debtVO.getMastContno());
		BPbcAppliBaseInfo bPbcAppliBaseInfo = null;
		if (StringUtil.isEmpty(debtVO.getAppno())) { // 保存新增
			bPbcAppliBaseInfo = new BPbcAppliBaseInfo();
			BeanUtils.copyProperties(debtVO, bPbcAppliBaseInfo);
			bPbcAppliBaseInfo.setCustcd(debtVO.getCustcdSaller());
			bPbcAppliBaseInfo.setMoniCustcd(debtVO.getCustcdBuyer());
			bPbcAppliBaseInfo.setCurcd(bCntDebtInfo.getCurcd()); // 币种
			bPbcAppliBaseInfo.setProcessTemplateName(workApplyType); // 流程名称
			bPbcAppliBaseInfo.setAppliType(businessnoType);
			bPbcAppliBaseInfo.setBusinessnoType(ScfBasConstant.BUSINESSNO_TYPE_CONTNO);
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_UNSUBMIT); // 申请状态:未提交（默认）
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING); // 申请状态明细:未提交（默认）
			/*
			 * bPbcAppliBaseInfo.setApproveTime(DateUtil.getCurrentDate());
			 * bPbcAppliBaseInfo.setAppDate(DateUtil.getCurrentDate()); // 登记时间
			 * bPbcAppliBaseInfo.setStartTime(DateUtil.getCurrentDate());
			 * bPbcAppliBaseInfo.setStratDate(DateUtil.getCurrentDate());
			 * bPbcAppliBaseInfo.setAppTlrcd(globalInfo.getTlrno());
			 */ // 登记人
			// tblAppliBaseInfo.setMortgageName(debtVO.getPayType());//还款类别
			// tblAppliBaseInfo.setSupplyChainPdId(debtVO.getProductId()); //
			// 产品ID
			bPbcAppliBaseInfo.setSupplyChainPdId(debtVO.getBussType()); // 业务品种
			bPbcAppliBaseInfo.setMastContno(bCntDebtInfo.getDebtContno()); // 主合同号
			bPbcAppliBaseInfo.setMemo(debtVO.getMemo());
			bPbcAppliBaseInfo.setProtocolNo(debtVO.getLoanWay()); // 出账方式 ?
			bPbcAppliBaseInfo.setAmt(debtVO.getTotalAmount());
			// bPbcAppliBaseInfo.setAmt(debtVO.getTotalDebtAmount());
			// 融资模式
			String financingType = debtVO.getFinancingType();
			// 获得appno
			String appno = "";
			if (financingType.equals(ScfBasConstant.T_FINANCING_TYPE_INVOICE)) {// 应收账款催收
				appno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSCS_T_APP_NO);
			} else if (financingType.equals(ScfBasConstant.T_FINANCING_TYPE_POOL)) {// 应收账款池催收
				appno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_YSCS_F_APP_NO);
			}
			;

			bPbcAppliBaseInfo.setAppno(appno);
			bPbcAppliBaseInfo.setWorkflowAppno(appno);

			bPbcAppliBaseInfoService.addBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		} else {// 更新
			bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(debtVO.getAppno());
			bPbcAppliBaseInfo.setMemo(debtVO.getMemo());
			bPbcAppliBaseInfo.setAmt(debtVO.getTotalAmount());// 老
			// bPbcAppliBaseInfo.setAmt(debtVO.getTotalDebtAmount());
			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		}
		return bPbcAppliBaseInfo.getAppno();
	}

	/**
	 * (应收账款业务)保存或新增应业务申请信息表 saveOrUpdateDebtAppliBussInfo 方法
	 * 
	 * @param debtVO
	 * @throws ScubeBizException
	 */
	/*
	 * @Transactional public void saveOrUpdateDebtAppliBussInfo(DebtBussInfoVO
	 * debtVO) throws ScubeBizException { UserInfo user =
	 * ContextHolder.getUserInfo(); String tlrNo = user.getTlrNo(); String
	 * brCode = user.getBrNo(); //RBcpAppliBussInfo rBcpAppliBussInfo = new
	 * RBcpAppliBussInfo(); RBcpAppliBussInfo rBcpAppliBussInfo = new
	 * RBcpAppliBussInfo();;
	 * List<com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo>
	 * list=rBcpAppliBussInfoService.queryAppliBussInfoBillsNo(debtVO.getAppno()
	 * );//获取票据 if(list!=null&&list.size()>0){//存在票据 Iterator iter=
	 * list.iterator(); while(iter.hasNext()){
	 * com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo debtVO_
	 * =(com.huateng.scf.rec.bcp.model.RBcpAppliBussInfo)iter.next();
	 * rBcpAppliBussInfo=rBcpAppliBussInfoDAO.selectByPrimaryKey(debtVO_.getId()
	 * ); //rBcpAppliBussInfo.setDebtNum(debtVO.getTotalNum());//发票个数原
	 * rBcpAppliBussInfo.setDebtNum(debtVO.getDebtNum());//发票个数
	 * rBcpAppliBussInfo.setBillDate(debtVO.getStartDate());//合同生效日
	 * rBcpAppliBussInfo.setBillEndDate(debtVO.getEndDate());//合同到期日
	 * //rBcpAppliBussInfo.setTotalDebtAmount(debtVO.getTotalAmount());//发票余额总额
	 * 原 rBcpAppliBussInfo.setTotalDebtAmount(debtVO.getTotalDebtAmount());//
	 * 发票余额总额 rBcpAppliBussInfo.setTlrcd(tlrNo);
	 * rBcpAppliBussInfo.setBrcode(brCode);
	 * rBcpAppliBussInfo.setAmount(debtVO.getAmount());
	 * rBcpAppliBussInfo.setInsertDate(debtVO.getInsertDate());
	 * rBcpAppliBussInfo.setPurchaseDate(debtVO.getInsertDate());//折让
	 * //rBcpAppliBussInfodal.setAppDate(debtVO.getPurchaseDate()); //承购日期
	 * rBcpAppliBussInfo.setAppDate(ScfDateUtil.getStringDate(new
	 * Date()));//申请日期 rBcpAppliBussInfo.setMemo(debtVO.getMemo()); //备注
	 * if(StringUtil.isStrNotEmpty(debtVO.getPressMode())){ //催收方式
	 * rBcpAppliBussInfo.setReturnType(debtVO.getPressMode()); } //TODO try {
	 * rBcpAppliBussInfoDAO.updateByPrimaryKey(rBcpAppliBussInfo); } catch
	 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace();
	 * log.error("应收账款业务申请流水基本信息更新异常！"); throw new
	 * ScubeBizException(ScfMessageUtil
	 * .transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10020),
	 * RBcpErrorConstant.SCF_REC_BCP_10020); }
	 * //tblAppliBussInfoDAO.update(rBcpAppliBussInfo); } } else {
	 * BeanUtils.copyProperties(debtVO, rBcpAppliBussInfo); if
	 * (StringUtil.isEmpty(rBcpAppliBussInfo.getBussType()) &&
	 * !StringUtil.isStrNotEmpty(debtVO.getProductId())) {
	 * rBcpAppliBussInfo.setBussType(debtVO.getProductId());// 业务品种 }
	 * //rBcpAppliBussInfo.setDebtNum(debtVO.getTotalNum());//发票个数原
	 * rBcpAppliBussInfo.setDebtNum(debtVO.getDebtNum());//发票个数
	 * rBcpAppliBussInfo.setBillDate(debtVO.getStartDate());// 合同生效日
	 * rBcpAppliBussInfo.setBillEndDate(debtVO.getEndDate());// 合同到期日
	 * rBcpAppliBussInfo.setTotalDebtAmount(debtVO.getTotalDebtAmount());//
	 * 发票余额总额 rBcpAppliBussInfo.setAmount(debtVO.getAmount());// 发票总争议金额
	 * rBcpAppliBussInfo.setInsertDate(debtVO.getInsertDate());// 争议日期
	 * rBcpAppliBussInfo.setTlrcd(tlrNo); rBcpAppliBussInfo.setBrcode(brCode);
	 * if (StringUtil.isStrNotEmpty(debtVO.getPressMode())) { // 催收方式
	 * rBcpAppliBussInfo.setReturnType(debtVO.getPressMode()); }
	 * 
	 * rBcpAppliBussInfo.setId(UUIDGeneratorUtil.generate()); try {
	 * rBcpAppliBussInfoDAO.insert(rBcpAppliBussInfo); } catch (Exception e) {
	 * // TODO Auto-generated catch block e.printStackTrace();
	 * log.error("应收账款业务申请流水基本信息插入异常！"); throw new
	 * ScubeBizException(ScfMessageUtil
	 * .transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10019),
	 * RBcpErrorConstant.SCF_REC_BCP_10019); }
	 * //tblAppliBussInfoDAO.save(rBcpAppliBussInfo); } }
	 */
	/**
	 * 保存催收管理申请流程发票信息
	 * 
	 * @author lu.chen
	 * @date 2011-12-25 saveDebtPressingBussDetails 方法
	 * @param billlist
	 * @param appno
	 * @throws ScubeBizException
	 */
	@Transactional
	public void saveDebtPressingBussDetails(List<DebtBillsInfoVO> billlist, String appno) throws ScubeBizException {
		DebtBillsInfoVO debtVo = null;

		// 保存前先清掉APPNO查询到记录
		rBcpAppliBussDtlService.appliBussDetailUpdate(appno);
		if (billlist != null) {
			Iterator iter = billlist.iterator();
			while (iter.hasNext()) {
				debtVo = (DebtBillsInfoVO) iter.next();
				RBcpAppliBussDtl rBcpAppliBussDtl = new RBcpAppliBussDtl();
				BeanUtils.copyProperties(debtVo, rBcpAppliBussDtl);
				rBcpAppliBussDtl.setId(UUIDGeneratorUtil.generate());
				rBcpAppliBussDtl.setAppno(appno);
				rBcpAppliBussDtl.setDebtId(debtVo.getId());
				rBcpAppliBussDtl.setWarnCount(debtVo.getWarnCount());// 提示次数
				rBcpAppliBussDtl.setPressCount(debtVo.getPressCount());// 催收次数
				try {
					rBcpAppliBussDtlDAO.insert(rBcpAppliBussDtl);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.error("应收账款业务申请流水流水明细插入异常！");
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10021),
							RBcpErrorConstant.SCF_REC_BCP_10021);
				}
				// tblAppliBussDetailDAO.save(tblAppliBussDetail);
				if (StringUtil.isStrNotEmpty(rBcpAppliBussDtl.getDebtId())) {
					rBcpDebtBaseInfoService.lockDebtBaseInfo(rBcpAppliBussDtl.getDebtId(), rBcpAppliBussDtl.getAppno());
				}
			}
		}
	}

	/**
	 * 催收回执审批通过
	 */
	@Override
	public void doWorkForPass(String appNo) {
		// TODO Auto-generated method stub
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		RBcpAppliBussInfo appliBussInfo = rBcpAppliBussInfoDAO.selectByAppno(appNo);
		int warnCount = 0;
		int pressCount = 0;
		if (appliBussInfo.getReturnType().equals("1")) {
			warnCount++;
		}
		if (appliBussInfo.getReturnType().equals("2")) {
			pressCount++;
		}
		// TODO DebtBussInfoVO
		DebtBussInfoVO debtVO = new DebtBussInfoVO();
		BeanUtils.copyProperties(appliBussInfo, debtVO);

		List<RBcpAppliBussDtl> list = rBcpAppliBussDtlDAO.selectByAppno(appNo);
		// 更新到正式数据表中
		List<String> debtIds = new ArrayList<String>();
		for (RBcpAppliBussDtl dtl : list) {
			debtIds.add(dtl.getDebtId());
		}
		List<DebtBillsInfoVO> list2 = new ArrayList<DebtBillsInfoVO>();
		RBcpAppliBussDtl dtl = new RBcpAppliBussDtl();
		DebtBillsInfoVO invoiceVO = null;
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			dtl = (RBcpAppliBussDtl) iter.next();
			invoiceVO = new DebtBillsInfoVO();
			BeanUtils.copyProperties(dtl, invoiceVO);
			invoiceVO.setId(invoiceVO.getDebtId());
			invoiceVO.setWarnCount(
					new BigDecimal(Integer.valueOf((dtl.getWarnCount() == null ? new BigDecimal(0) : dtl.getWarnCount()).toString()) + warnCount));
			invoiceVO.setPressCount(
					new BigDecimal(Integer.valueOf((dtl.getPressCount() == null ? new BigDecimal(0) : dtl.getPressCount()).toString()) + pressCount));
			list2.add(invoiceVO);
			// 更新应收账款信息
			com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo = rBcpDebtBaseInfoDAO.selectByPrimaryKey(invoiceVO.getId());
			// 催收提示次数
			rBcpDebtBaseInfo.setWarnCount(
					new BigDecimal(Integer.valueOf((dtl.getWarnCount() == null ? new BigDecimal(0) : dtl.getWarnCount()).toString()) + warnCount));
			// 催收次数
			rBcpDebtBaseInfo.setPressCount(
					new BigDecimal(Integer.valueOf((dtl.getPressCount() == null ? new BigDecimal(0) : dtl.getPressCount()).toString()) + pressCount));
			RBcpDebtBaseInfo bcpDebtBaseInfo = new RBcpDebtBaseInfo();
			BeanUtils.copyProperties(rBcpDebtBaseInfo, bcpDebtBaseInfo);
			rBcpDebtBaseInfoService.updateRBcpDebtBaseInfo(bcpDebtBaseInfo);
		}
		this.debtPressingSubmitApp(list2, debtVO);
		bNteNoticeBaseService.modifyNoticeBaseInfo(debtVO.getAppno(), BNteConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		scfApplyService.releaseAppliDebtBaseInfo(bPbcAppliBaseInfo.getAppno());// 对流程锁定的应收账款进行解锁
		// 流程流转
		/*
		 * String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
		 * scfWorkFlowService.processTasks(bPbcAppliBaseInfo, status);
		 */
		// 更新业务申请表状态
		bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
	}

	/**
	 * 催收审批拒绝
	 */
	@Override
	public void doWorkForReject(String appNo) {
		// TODO Auto-generated method stub

	}

	/**
	 * DESCRIPTION:催收申请 debtPressingSubmitApp 方法
	 * 
	 * @param insertDebtList
	 * @param debtVO
	 * @throws ScubeBizException
	 * @return
	 */
	public void debtPressingSubmitApp(List<DebtBillsInfoVO> insertDebtList, DebtBussInfoVO debtVO) throws ScubeBizException {
		debtVO.setApplyType(RBcpDebtConstant.APPLY_TYPE_COLLECTION);
		debtVO.setReason(debtVO.getOtherReason());
		debtVO.setAmount(debtVO.getTotalAmount()); // 老
		// debtVO.setAmount(debtVO.getTotalDebtAmount());
		debtVO.setTotalNum(debtVO.getTotalNum()); // 老
		// debtVO.setTotalNum(debtVO.getDebtNum());
		// 添加业务流水表主表
		RBcpDebtBussInfo rBcpDebtBussInfo = rBcpDebtBussInfoService.debtBussInfoAdd(debtVO);
		// 添加流水详细信息表

		rBcpDebtBussDtlService.debtPressingSubmit(insertDebtList, rBcpDebtBussInfo);
	}

	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub

	}
}

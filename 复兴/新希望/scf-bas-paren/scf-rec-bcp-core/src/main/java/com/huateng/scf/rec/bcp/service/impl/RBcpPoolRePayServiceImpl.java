package com.huateng.scf.rec.bcp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.acc.model.BAccAccountInfo;
import com.huateng.scf.bas.acc.service.IBAccAccountInfoService;
import com.huateng.scf.bas.cnt.dao.IBCntDebtInfoDAO;
import com.huateng.scf.bas.cnt.model.DataItemsVO;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.model.RBcpPoolRePayVO;
import com.huateng.scf.rec.bcp.service.IRBcpPoolRePayService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("RBcpPoolRePayServiceImpl")
public class RBcpPoolRePayServiceImpl implements IRBcpPoolRePayService, DealEndFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());

//	private static final String CUSTCD = "custCd";
//	private static final String CUSTNAME = "custName";

	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bCrmBaseInfoService;

	@Resource(name = "IBAccAccountInfoServiceImpl")
	IBAccAccountInfoService bAccAccountInfoService;

	@Resource(name = "BSysSerialNoServiceImpl")
	private IBSysSerialNoService bSysSerialNoService;// 流水号生成服务

	@Resource(name = IBPbcAppliBaseInfoService.BEAN_ID)
	IBPbcAppliBaseInfoService bPbcAppliBaseInfoService;// 业务申请表

	@Resource(name = IScfWorkFlowService.BEAN_ID)
	IScfWorkFlowService scfWorkFlowService;

//	@Autowired
//	private IProcessService processService;
	// 流程发起
	@Resource(name = "processService")
	IProcessService iProcessService;
//	@Autowired
//	private ITaskService taskService;
	// 应收类合同
	@Resource(name = "BCntDebtInfoDAO")
	IBCntDebtInfoDAO iBCntDebtInfoDAO;

	@Override
	@Transactional
	public Page getCustNameBycd(int pageNo, int pageSize, BCrmBaseInfo value) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		String financingType = value.getFinancingType();
		String cname = value.getCname();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		if (cname != null && !"".equals(cname)) {
			hashMap.put("cname", cname);
		}
		if (financingType != null && !"".equals(financingType)) {
			hashMap.put("financingType", financingType);
			List<com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo> BCrmBaseInfoList = iBCntDebtInfoDAO
					.findBCrmByFactType(page, hashMap);
			page.setRecords(BCrmBaseInfoList);
			return page;
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public List<DataItemsVO> getReturnAccountbyCustcd(BAccAccountInfo bAccAccountInfo) {
		List<DataItemsVO> list = new ArrayList<DataItemsVO>();
		List<BAccAccountInfo> aai = bAccAccountInfoService.findBAccAccountInfoByBAcc(bAccAccountInfo);
		for (BAccAccountInfo info : aai) {
			DataItemsVO e = new DataItemsVO();
			e.setCode(info.getAccountNo());
			e.setCodeName(info.getAccountNo());
			list.add(e);
		}
		return list;
	}

	@Override
	@Transactional
	public String savePoolRePay(RBcpPoolRePayVO bcpPoolRePayVO) throws ScubeBizException {
		String factType = bcpPoolRePayVO.getFactType();
		String businessnoType = "";
		String workApplyType = "";
		if (!StringUtils.isEmpty(factType)) {
			if (ScfBasConstant.T_FINANCING_TYPE_INVOICE.equals(factType)) {// 应收账款融资
				businessnoType = WorkflowConstant.APPLI_TYPE_DEBT_REPAY_ACC_TRANSFER_APPLY;
				workApplyType = WorkflowConstant.PROCNAME_DEBT_REPAY_ACC_TRANSFER_APPLY;
			}
			if (ScfBasConstant.T_FINANCING_TYPE_POOL.equals(factType)) {// 应收账款池
				// businessnoType =
				// WorkflowConstant.APPLI_TYPE_POOL_REPAY_ACC_TRANSFER_APPLY;
				// workApplyType =
				// WorkflowConstant.PROCNAME_DEBT_POOL_RETURN_ACC_TRANSFER_APPLY;
				// 注释的是老代码，下面的是qichengcheng的
				businessnoType = WorkflowConstant.APPLI_TYPE_POOL_REPAY_ACC_TRANSFER_APPLY;// 申请类型
				workApplyType = WorkflowConstant.PROCNAME_DEBT_POOL_RETURN_ACC_TRANSFER_APPLY;// 申请业务类型

			}
			if (ScfBasConstant.T_FINANCING_TYPE_CREDIT.equals(factType)) {// 信保
				businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_CREDIT_REPAY_ACC_TRANSFER_APPLY;
				workApplyType = WorkflowConstant.PROCNAME_FACTORING_CREDIT_RETURN_ACC_TRANSFER_APPLY;
			}
			if (ScfBasConstant.T_FINANCING_TYPE_DOUBLE.equals(factType)) {// 国内双
				businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_DOUBLE_REPAY_ACC_TRANSFER_APPLY;
				workApplyType = WorkflowConstant.PROCNAME_FACTORING_DOUBLE_RETURN_ACC_TRANSFER_APPLY;
			}
			if (ScfBasConstant.T_FINANCING_TYPE_LEASE.equals(factType)) {// 租赁
				businessnoType = WorkflowConstant.APPLI_TYPE_FACTORING_LEASE_REPAY_ACC_TRANSFER_APPLY;
				workApplyType = WorkflowConstant.PROCNAME_FACTORING_LEASE_RETURN_ACC_TRANSFER_APPLY;
			}
		} else {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005),
					RBcpErrorConstant.SCF_REC_BCP_10005);
		}

		String appNo = bSysSerialNoService.genSerialNo(ScfBasConstant.HHZZ_APP_NO);// 回款专户转账
		// 保存出质入库申请基本信息
		BPbcAppliBaseInfo info = new BPbcAppliBaseInfo();
		info.setAppno(appNo);
		info.setCustcd(bcpPoolRePayVO.getCustcd());// 客户号
		info.setProcessTemplateName(workApplyType);// 流程名称
		info.setAppliType(businessnoType);// 申请类型
		info.setAmt(bcpPoolRePayVO.getAmount());// 业务发生额
		info.setAppBrcode(ContextHolder.getOrgInfo().getBrNo());// 登记机构
		info.setAppTlrcd(ContextHolder.getUserInfo().getTlrNo());// 登记人
		info.setAppDate(ScfDateUtil.getStringDate(new Date()));// 登记时间
		info.setStartBrcode(ContextHolder.getOrgInfo().getBrNo());// 发起申请行
		info.setStartTlrcd(ContextHolder.getOrgInfo().getBrNo());// 发起操作员号
		info.setStratDate(ScfDateUtil.getStringDate(new Date()));// 发起日期
		info.setStartTime(new Date());// 申请发起时间
		info.setMemo(bcpPoolRePayVO.getReason());// 转账原因
		try {
			bPbcAppliBaseInfoService.addBPbcAppliBaseInfo(info);
		} catch (Exception e) { // 新增申请信息失败
			log.error(e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10023),
					RBcpErrorConstant.SCF_REC_BCP_10023);
		}
		//发起工作流
		if(!StringUtil.isEmpty(appNo))
		{
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", workApplyType);
			paramMap.put("NodeId", WorkflowConstant.PROCNODE_APPLY);
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				scfWorkFlowService.commonStartFlow(appNo, workApplyType, workApplyType, paramMap);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		String processId = "";
//		String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
//		// 发起流程
//		if (ScfBasConstant.T_FINANCING_TYPE_INVOICE.equals(factType)) {
//			String bizId = "";
//			try {
//				ProcessEntity processEntity = iProcessService.startProcess(workApplyType, "应收账款融资回款专户转账申请", "Write",
//						tlrcd, appNo,
//						new String[] { bizId, bcpPoolRePayVO.getCustcd(), bcpPoolRePayVO.getCname(), workApplyType });
//				processId = processEntity.getProcessId();
//			} catch (Exception e) {// SCF_REC_BCP_10022,发起流程失败
//				log.error("发起流程失败！" + e.getMessage());
//				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10022),
//						RBcpErrorConstant.SCF_REC_BCP_10022);
//			}
//		} else if (ScfBasConstant.T_FINANCING_TYPE_POOL.equals(factType)) {
//			String modelId = WorkflowConstant.POOLREPAY;
//			// String ProcessName = WorkflowConstant.DEFOULT_ATTITUDE;
//			String NodeId = WorkflowConstant.POOLREPAY_WRITE;
//			String custCd = bcpPoolRePayVO.getCustcd();
//			String custName = bcpPoolRePayVO.getCname(); // 买方名称
//			HashMap<String, Object> map = new HashMap<String, Object>();
//			map.put("modelId", modelId);
//			map.put("NodeId", NodeId);
//			map.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
//			map.put(WorkflowConstant.CUST_CD, custCd);
//			map.put(WorkflowConstant.CUST_NAME, custName);
//			try {
//				ProcessEntity processEntity = iProcessService.startProcess(workApplyType, "回款专户转账申请", NodeId, tlrcd,
//						appNo, new String[] { "", custCd, custName, workApplyType });
//				processId = processEntity.getProcessId();
//			} catch (Exception e) {
//				log.error("发起流程失败！" + e.getMessage());
//				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10022),
//						RBcpErrorConstant.SCF_REC_BCP_10022);
//			}
//		}
		// 设置流程ID
//		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
//		bPbcAppliBaseInfo.setPiid(processId);
//		try {
//			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
//		} catch (Exception e) {
//			log.error("保存回款专户信息失败" + e.getMessage());
//			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10023),
//					RBcpErrorConstant.SCF_REC_BCP_10023);
//		}

		// 获取当前用户
		// UserInfo user = ContextHolder.getUserInfo();
		// String startedUserId=user.getTlrNo();
		// 发起流程并保存业务信息
		// 扩展业务信息
		// String bizId = appNo;
		// String cname = bcpPoolRePayVO.getCname();
		// String custCd = bcpPoolRePayVO.getCustcd();
		// 流程发起
		// ProcessEntity processEntity = processService.startProcess(modelId,
		// ProcessName, NodeId, startedUserId, bizId, new
		// String[]{appNo,custCd,cname,modelId});
		// BPbcAppliBaseInfo bPbcAppliBaseInfo =
		// bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		// String processId =processEntity.getProcessId();
		// bPbcAppliBaseInfo.setPiid(processId);
		// bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		// scfWorkFlowService.startWorkFlow(appNo, modelId, flowName,map);
		return appNo;
	}

	@Override
	public RBcpPoolRePayVO findPoolRePay(String appNo) throws ScubeBizException {
		RBcpPoolRePayVO bBcpPoolRePayVO = new RBcpPoolRePayVO();
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
		String custcd = bPbcAppliBaseInfo.getCustcd();
		BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
		bCrmBaseInfo.setCustcd(custcd);
		BCrmBaseInfo info = bCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo);
		bBcpPoolRePayVO.setAmount(bPbcAppliBaseInfo.getAmt());
		BAccAccountInfo bAccAccountInfo = new BAccAccountInfo();
		bAccAccountInfo.setCustcd(custcd);
		bAccAccountInfo.setAccountType("2");// 回款专户
		BAccAccountInfo info1 = bAccAccountInfoService.findBAccAccountInfoByKey(bAccAccountInfo);
		bAccAccountInfo.setAccountType("1");// 客户结算帐号
		BAccAccountInfo info2 = bAccAccountInfoService.findBAccAccountInfoByKey(bAccAccountInfo);
		bBcpPoolRePayVO.setCustcd(custcd);
		bBcpPoolRePayVO.setCname(info.getCname());
		bBcpPoolRePayVO.setReturnAccount(info1.getAccountNo());
		bBcpPoolRePayVO.setBalanceAccount(info2.getAccountNo());
		bBcpPoolRePayVO.setReason(bPbcAppliBaseInfo.getMemo());
		return bBcpPoolRePayVO;
	}

	@Override
	@Transactional
	public String updatePoolRePay(String appNo, RBcpPoolRePayVO bcpPoolRePayVO) {
		// 保存回款专户转出申请基本信息
		BPbcAppliBaseInfo info = new BPbcAppliBaseInfo();
		info.setAppno(appNo);
		info.setCustcd(bcpPoolRePayVO.getCustcd());// 客户号
		info.setAmt(bcpPoolRePayVO.getAmount());// 业务发生额
		info.setAppBrcode(ContextHolder.getOrgInfo().getBrNo());// 登记机构
		info.setAppTlrcd(ContextHolder.getUserInfo().getTlrNo());// 登记人
		info.setAppDate(ScfDateUtil.getStringDate(new Date()));// 登记时间
		info.setStartBrcode(ContextHolder.getOrgInfo().getBrNo());// 发起申请行
		info.setStartTlrcd(ContextHolder.getOrgInfo().getBrNo());// 发起操作员号
		info.setStratDate(ScfDateUtil.getStringDate(new Date()));// 发起日期
		info.setStartTime(new Date());// 申请发起时间
		info.setMemo(bcpPoolRePayVO.getReason());// 转账原因
		bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(info);
		return appNo;
	}

	@Override
	@Transactional
	public void submitPoolRePay(String appNo, RBcpPoolRePayVO bcpPoolRePayVO) throws ScubeBizException {
		updatePoolRePay(appNo, bcpPoolRePayVO);
		// 流程开始
//		String userId = ContextHolder.getUserInfo().getTlrNo();// 操作员
		try {
			BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoService.findBPbcAppliBaseInfoByKey(appNo);
//			String processId = bPbcAppliBaseInfo.getPiid();
//
//			// 领取任务
//			NodeEntity nodeEntity = iProcessService.getCurrentNodeEntity(processId);// 根据processId取出节点ID
//			String taskId = "";
//			if (null != nodeEntity) {
//				taskId = nodeEntity.getCurrentTaskId();// 取当前任务ID
//			}
//			taskService.takeTask(taskId, processId, userId);
//			// 任务提交
//			String comment = "发起流程";
//			taskService.completeTask(taskId, processId, userId, comment);
//			// 节点转移(自己要再设置一下)
//			processService.autoSignal(processId);// 通知书回执节点(下一节点)
			//流程流转
			String status = WorkflowConstant.WORKFLOW_TRANS_AGREE;
			scfWorkFlowService.processTasks(bPbcAppliBaseInfo, status);
//			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);// 已提交(未审批)
//			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);// 已提交
//			bPbcAppliBaseInfoService.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		} catch (Exception e) {
			log.error("回款专户转账申请提交失败,流程申请基本信息更改失败！" + e.getMessage());
			e.printStackTrace();
			throw new ScubeBizException("回款专户转账申请提交失败,流程申请基本信息更改失败！");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.sys.service.DealEndFlowService#doWorkForPass(java.
	 * lang.String)
	 */
	@Override
	public void doWorkForPass(String appNo) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.sys.service.DealEndFlowService#doWorkForReject(java.
	 * lang.String)
	 */
	@Override
	public void doWorkForReject(String appNo) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.sys.service.DealEndFlowService#doWorkForBack(java.
	 * lang.String)
	 */
	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub

	}
}

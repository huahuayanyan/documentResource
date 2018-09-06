/**
 * 
 */
package com.huateng.scf.bas.com.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.ApproveRoute.pojo.BusinessField;
import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.api.ITaskService;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.flowsharp.entity.NodeDes;
import com.huateng.flowsharp.entity.NodeEntity;
import com.huateng.flowsharp.entity.ProcessEntity;
import com.huateng.flowsharp.entity.Task;
import com.huateng.scf.bas.brp.model.BBrpPrdFactoring;
import com.huateng.scf.bas.brp.service.IBBrpPrdFactoringService;
import com.huateng.scf.bas.common.constant.BComErrorConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfApplyService;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfGlobalInfo;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.pbc.constant.BPbcErrorConstant;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.prd.constant.BPrdErrorConstant;
import com.huateng.scf.bas.prd.model.BPrdBranchAuth;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.model.BPrdWkflowCop;
import com.huateng.scf.bas.prd.service.IBPrdBranchAuthService;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.prd.service.IBPrdWkflowCopService;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.dao.model.BSysApplyDtl;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.IBSysApplyDtlService;
import com.huateng.scf.bas.sys.service.IBSysTaskService;
import com.huateng.scf.nbas.prd.model.BPrdFlowVO;
import com.huateng.scf.nbas.prd.service.IBPrdFlowService;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpInfoDAO;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpInfo;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 供应链工作流业务调用接口实现：<br>
 * 1.调用工作流接口（发起、任务领取、任务完成、任务转移）；<br>
 * 2.供应链流程公共处理（如：审批意见保存等）；<br>
 * </p>
 *
 * @author huangshuidan
 * @date 2016年12月29日下午7:34:00
 * @version 1.0
 * @param <E>
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月29日下午7:34:00             新增
 *
 *            </pre>
 */
@ScubeService
@Service(IScfWorkFlowService.BEAN_ID)
public class ScfWorkFlowServiceImpl implements IScfWorkFlowService
{
	private final Logger log = LoggerFactory.getLogger(getClass());

	private ApplicationContext applicationContext;
	
	@Resource(name = "BPrdWkflowCopServiceImpl")
	IBPrdWkflowCopService bPrdWkflowCopService;
	
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bPbcAppliBaseInfoDAO;
	
	@Autowired
	private IProcessService processService;
	
	@Autowired
	ITaskService taskService;// 流程任务

	// 客户信息
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bcrmbaseinfoservice;

	// 工作流任务
	@Resource(name = "BSysTaskServiceImpl")
	IBSysTaskService bSysTaskService;

	// 审批意见
	@Resource(name = "BSysApplyDtlServiceImpl")
	IBSysApplyDtlService bsysapplydtlservice;

	// 业务申请信息
	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;

	// 产品工厂信息
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bprdinfoservice;

	// 产品工厂分支
	@Resource(name = "BPrdBranchAuthServiceImpl")
	IBPrdBranchAuthService bprdbranchauthservice;

	@Resource(name = IScfApplyService.BEAN_ID)
	IScfApplyService scfapplyservice;

	@Resource(name = "BBrpPrdFactoringServiceImpl")
	IBBrpPrdFactoringService bBrpPrdFactoringService;

	// 应收账款配置版合同信息
	@Resource(name = "IBCntBcpInfoDAO")
	IBCntBcpInfoDAO bcntbcpinfodao;

	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bPrdInfoService;

	@Autowired
	ScubeUserService scubeUserService;

	//产品流程绑定
	@Resource(name = "BPrdFlowServiceImpl")
	IBPrdFlowService bprdflowservice;
	
	private static final String TRANSNO = "transno";//
	private static final String APPNO = "appno";
	private static final String ATTITUDE = "attitude";
	private static final String TASKNAME = "taskName";
	private static final String REASON = "reason";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.common.service.IScfWorkFlowService#startWorkFlow(java
	 * .lang.String, java.lang.String, java.lang.String, java.util.Map)
	 */
	@Transactional
	@Override
	public ProcessEntity startWorkFlow(String appNo, String workApplyType, String flowName, Map<String, Object> paramMap)
			throws ScubeBizException, FlowsharpException {
		BPbcAppliBaseInfo bPbcAppliBaseInfo = bPbcAppliBaseInfoDAO.selectByPrimaryKey(appNo);
		if (null == bPbcAppliBaseInfo) {
			log.error("业务申请主表记录不存在！" + appNo);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20000), BComErrorConstant.SCF_BAS_COM_20000);
		}
		// 获取当前用户
		UserInfo user = ContextHolder.getUserInfo();
		String startedUserId = user.getTlrNo();
		BPrdWkflowCop bPrdWkflowCop = new BPrdWkflowCop();
		bPrdWkflowCop.setFlowCopId(workApplyType);
		BPrdWkflowCop bPrdWkflow = bPrdWkflowCopService.queryBPrdWkflowCopByBPrd(bPrdWkflowCop);
		// 流程信息
		String processName = null == bPrdWkflow ? "" : bPrdWkflow.getFlowName();
		String nodeId = WorkflowConstant.PROCNODE_APPLY;
		String modelId = workApplyType;
		// 扩展业务信息
		String bizId = appNo; // 业务流程号
		String custCd = null == paramMap.get(WorkflowConstant.CUST_CD) ? "" : paramMap.get(WorkflowConstant.CUST_CD).toString(); // 客户号
		String custName = null == paramMap.get(WorkflowConstant.CUST_NAME) ? "" : paramMap.get(WorkflowConstant.CUST_NAME).toString(); // 客户名称
		ProcessEntity processEntity = processService.startProcess(modelId, processName, nodeId, startedUserId, bizId,
				new String[] { bizId, custCd, custName, modelId });
		// 2.保存发起人“提交申请”及时间等相关信息（B_SYS_APPLY_DTL[审批意见明细表]）
		Map<String, Object> applyMap = new HashMap<String, Object>();
		applyMap.put(TRANSNO, appNo);
		applyMap.put(APPNO, appNo);//
		applyMap.put(ATTITUDE, WorkflowConstant.WORKFLOW_TRANS_AGREE);
		applyMap.put(TASKNAME, WorkflowConstant.DEFOULT_ATTITUDE);
		applyMap.put(REASON, WorkflowConstant.DEFOULT_ATTITUDE);
		this.saveApplydtl(applyMap);
		// 3.更新申请表申请状态，工作流申请号（更新B_PBC_APPLI_BASE_INFO【主申请表】，插入在新增时插入）
		bPbcAppliBaseInfo.setPiid(processEntity.getProcessId());// 保存工作流实例ID
		bPbcAppliBaseInfo.setWorkflowAppno(appNo);
		// bPbcAppliBaseInfo.setProcessTemplateName(processName);
		bPbcAppliBaseInfo.setStartTlrcd(ContextHolder.getUserInfo().getTlrNo()); // 发起人
		bPbcAppliBaseInfo.setStartBrcode(ContextHolder.getOrgInfo().getBrNo()); // 发起机构
		bPbcAppliBaseInfo.setStratDate(ScfDateUtil.getStringDate(new Date())); // 发起日期
		bPbcAppliBaseInfo.setStartTime(new Date());// 发起时间
		try {
			bPbcAppliBaseInfoDAO.updateByPrimaryKey(bPbcAppliBaseInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("业务申请基本信息更新异常！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10002), BPbcErrorConstant.SCF_BAS_PBC_10002);
		}
		return processEntity;
	}

	/**
	 * 保存审批意见
	 * 
	 * @param paramMap
	 *            Map<String, Object>
	 * @throws ScubeBizException
	 */
	@Transactional
	public void saveApplydtl(Map<String, Object> paramMap) throws ScubeBizException {
		BSysApplyDtl bSysApplyDtl = new BSysApplyDtl();
		String transno = null == paramMap.get(TRANSNO) ? "" : paramMap.get(TRANSNO).toString();
		String appno = null == paramMap.get(APPNO) ? "" : paramMap.get(APPNO).toString();
		String attitude = null == paramMap.get(ATTITUDE) ? "" : paramMap.get(ATTITUDE).toString();
		String taskName = null == paramMap.get(TASKNAME) ? "" : paramMap.get(TASKNAME).toString();
		String reason = null == paramMap.get(REASON) ? "" : paramMap.get(REASON).toString();
		ScfGlobalInfo scfGlobalInfo = ScfBaseData.getScfGlobalInfoData();// 全局信息
		bSysApplyDtl.setId(UUIDGeneratorUtil.generate());
		bSysApplyDtl.setTlsrno(ContextHolder.getUserInfo().getTlrNo());
		bSysApplyDtl.setBrhno(ContextHolder.getOrgInfo().getBrNo());
		if (null != scfGlobalInfo) {
			bSysApplyDtl.setTxtime(ScfDateUtil.getStringTime(new Date()));
		}
		bSysApplyDtl.setTransno(transno);
		bSysApplyDtl.setAppno(appno);
		bSysApplyDtl.setTxdate(ScfDateUtil.getStringDate(new Date()));
		bSysApplyDtl.setAttitude(attitude);
		bSysApplyDtl.setMisc(taskName);
		bSysApplyDtl.setReason(reason);
		bsysapplydtlservice.saveBSysApplyDtl(bSysApplyDtl);
	}

	/**
	 * @author jimmy.peng
	 * @date 2010-11-29 commonStartFlow 流程启动公共工具类( 1.startFlow 2.保存审批意见
	 *       3.更新主申请表信息 )
	 * @param bussAppno
	 * @param workflowBussType
	 * @param packageId
	 * @param templeteId
	 * @throws FlowsharpException
	 * @throws CommonException
	 */
	@Override
	public ProcessEntity commonStartFlow(String bussAppno, String workflowBussType, String flowName, HashMap<String, Object> paramMap)
			throws FlowsharpException {
		String modelId = paramMap.get("modelId").toString();
		String NodeId = paramMap.get("NodeId").toString();
		String startedUserId = paramMap.get("startedUserId").toString();
		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(bussAppno); // 业务主表
		if (null == appliBaseInfo) {
			log.error("业务申请主表记录不存在！" + bussAppno);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20000), BComErrorConstant.SCF_BAS_COM_20000);
		}
		BPrdWkflowCop bPrdWkflowCop = new BPrdWkflowCop();
		bPrdWkflowCop.setFlowCopId(workflowBussType);
		BPrdWkflowCop bPrdWkflow = bPrdWkflowCopService.queryBPrdWkflowCopByBPrd(bPrdWkflowCop);
		// 流程信息
		String processName = null == bPrdWkflow ? "" : bPrdWkflow.getFlowName();
		// 取客户信息
		String cname = "";
		if (!StringUtil.isEmpty(appliBaseInfo.getCustcd())) {
			BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
			bCrmBaseInfo.setCustcd(appliBaseInfo.getCustcd());
			BCrmBaseInfo crminfo = bcrmbaseinfoservice.findBCrmBaseInfoByKey(bCrmBaseInfo);
			cname = crminfo.getCname();
		}

		// 校验分支行产品授权
		checkSupplyChainId(appliBaseInfo);

		// 1.启动工作流[调用工作流服务]
		String[] bizData1 = { bussAppno, appliBaseInfo.getCustcd(), cname, modelId };
		ProcessEntity processVO = processService.startProcess(modelId, processName, NodeId, startedUserId, bussAppno, bizData1);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (processVO == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20003), BSysErrorConstant.SCF_BAS_SYS_20003);
		}
		String processId = processVO.getProcessId();
		System.out.println("===============" + processId + "==============");

		// 2.保存发起人“提交申请”及时间等相关信息（保存到APPLY_DTL【意见表】）
		Map<String, Object> applyMap = new HashMap<String, Object>();
		applyMap.put(TRANSNO, bussAppno);
		applyMap.put(APPNO, bussAppno);//
		applyMap.put(ATTITUDE, WorkflowConstant.WORKFLOW_TRANS_AGREE);
		applyMap.put(TASKNAME, WorkflowConstant.DEFOULT_ATTITUDE);
		applyMap.put(REASON, WorkflowConstant.DEFOULT_ATTITUDE);
		this.saveApplydtl(applyMap);
		// 3.更新申请表申请状态，工作流申请号（更新TBL_APPLI_BASE_INFO【主申请表】，插入在新增时插入）
		appliBaseInfo.setPiid(processId);// 保存工作流实例ID
		// appliBaseInfo.setAppliStatus(ScfBasConstant.APPLI_STATUS_SUBMITUNAPPROVE);
		// // 01-已提交未审批
		// appliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WRITING);
		// // 009-填写未提交
		appliBaseInfo.setWorkflowAppno(bussAppno);
		appliBaseInfo.setProcessTemplateName(workflowBussType);
		appliBaseInfo.setStartTlrcd(ContextHolder.getUserInfo().getTlrNo()); // 发起人
		appliBaseInfo.setStartBrcode(ContextHolder.getOrgInfo().getBrNo()); // 发起机构
		appliBaseInfo.setStratDate(ScfDateUtil.formatDate(new Date())); // 发起日期
		appliBaseInfo.setStartTime(new Date()); // 发起时间
		bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(appliBaseInfo);

		// 对申请表中的piid校验，确认是否更新成功，如果未成功则再次更新
		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo baseinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(bussAppno);
		if (StringUtil.isEmpty(baseinfo.getPiid())) {
			baseinfo.setPiid(processId);
			bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(baseinfo);
		}
		return processVO;
	}

	/**
	 * @Description: 校验分支行是否有产品授权
	 * @author mingliang.wang
	 * @Created 2013-3-27下午03:58:45
	 * @param tblAppliBaseInfo
	 * @return
	 * @throws CommonException
	 */
	public void checkSupplyChainId(com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo appliBaseInfo) throws ScubeBizException {
		if (appliBaseInfo == null) {
			return;
		}
		// 排除与供应链产品无关的流程
		if (StringUtil.isEmpty(appliBaseInfo.getSupplyChainPdId())) {
			return;
		}
		BPrdInfo bPrdInfo = new BPrdInfo();
		bPrdInfo.setProductId(appliBaseInfo.getSupplyChainPdId());
		BPrdInfo tblProductInfo = bprdinfoservice.findBPrdInfoByKey(bPrdInfo);
		if (tblProductInfo == null) {
			return;
		}
		String startBrcode = null;
		if (StringUtil.isEmpty(appliBaseInfo.getStartBrcode())) {
			startBrcode = ContextHolder.getOrgInfo().getBrNo();
		} else {
			startBrcode = appliBaseInfo.getStartBrcode();
		}
		// 校验机构是否有供应链产品授权 TODO
		// String productAuthFlag =
		// SysParamUnit.get(SysParamUnit.PARAM_ID_SYSINFO,SysParamUnit.PARAM_INDEX_SYSINFO_PRODUCT_AUTH_FLAG);
		// 默认
		String productAuthFlag = ScfBasConstant.FLAG_OFF;
		if (ScfBasConstant.FLAG_ON.equals(productAuthFlag)) {
			List<BPrdBranchAuth> bplist = bprdbranchauthservice.findBPrdBranchAuthByProductIdAndBrcode(appliBaseInfo.getSupplyChainPdId(),
					startBrcode);
			if (bplist == null || bplist.size() == 0) {
				BctlVO bctlVO = scubeUserService.selectBctlByBrNo(startBrcode, ScfCommonUtil.getBrManagerNo(scubeUserService));
				throw new ScubeBizException("" + bctlVO.getBrName() + "没有" + tblProductInfo.getProductName() + "产品授权！");
			}
		}

	}

	/**
	 * 流程跳转
	 * 
	 * @param applibaseinfo
	 * @param attitude
	 * @throws FlowsharpException
	 */
	@Override
	@Transactional
	public void processTasks(com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo applibaseinfo, String attitude) throws FlowsharpException {
		log.debug("processId=" + applibaseinfo.getPiid());
		ProcessEntity processEntity = processService.getProcessEntityById(applibaseinfo.getPiid());
		String modelId = processEntity.getModelId();
		int processStatus = 0;
		// 流程跳转
		String processId = applibaseinfo.getPiid();// processId
		NodeEntity nodeEntity = processService.getCurrentNodeEntity(processId);// 当前节点nodeEntity
		List<NodeDes> nodelist = processService.getNodeDesByModelId(modelId);// 节点列表信息
		if (nodeEntity == null || nodelist == null) {
			// throw new
			// ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20003),
			// BSysErrorConstant.SCF_BAS_SYS_20003);
			throw new ScubeBizException("流程节点信息丢失，请重新配置对应流程节点信息！");
		}
		String taskId = nodeEntity.getCurrentTaskId(); // 获取当前任务节点ID
		if (StringUtil.isEmpty(taskId)) {
			throw new ScubeBizException("任务还没有生成,请稍等一下再提交!");
		}
		String comment = "";// 执行任务留言
		// String reasonIn = "";//审批留言

		// 领用任务
		taskService.takeTask(taskId, processId, ContextHolder.getUserInfo().getTlrNo());
		// 判断当前是否为最后一个节点,true不是最后节点，false是最后节点
		boolean flag = false;
		for (NodeDes nodedes : nodelist) {
			if (nodedes.getNodeId().equals(nodeEntity.getId())) {
				if (nodedes.getNodeSeq() < nodelist.size()) {
					flag = true;
				} else {
					processStatus = 16;
					flag = false;
				}
				break;
			}
		}
		BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
		bCrmBaseInfo.setCustcd(applibaseinfo.getCustcd());
		BCrmBaseInfo crminfo = bcrmbaseinfoservice.findBCrmBaseInfoByKey(bCrmBaseInfo);
		String cname = crminfo.getCname();
		String[] bizData = { applibaseinfo.getAppno(), applibaseinfo.getCustcd(), cname, modelId, ContextHolder.getUserInfo().getTlrName() };
		// 根据不同的意见走不同的分支
		if (WorkflowConstant.WORKFLOW_TRANS_AGREE.equals(attitude)) {
			if (StringUtil.isEmpty(applibaseinfo.getComment())) {
				comment = "同意";
			} else {
				comment = applibaseinfo.getComment();
			}
			try {
				// 完成当前任务,保存审批意见
				taskService.completeTask(taskId, processId, ContextHolder.getUserInfo().getTlrNo(), comment, bizData);// 提交任务
				if (flag) {
					NodeEntity nextNode = processService.getNextNode(processId);
					if (nextNode == null) {
						processStatus = 16;
						processService.cancelProcess(processId);
						return;
					} else if (nextNode.getNodeType() == 2) {// 是最后一个节点，进入审批节点
						processStatus = 16;
						String overnodeId = "pass";
						processService.signal(processId, overnodeId, bizData);
						// bSysTaskService.bizProcess("pass",
						// applibaseinfo.getAppno(), processId, modelId);
					} else {// 不是最后节点，进入下一节点
						processService.autoSignal(processId);
					}
				}
				if (!flag) {// 当前节点是最后一个节点并且不是结束节点
					processService.cancelProcess(processId);
					return;
				}
			} catch (FlowsharpException e) {// 如果流程抛异常
				throw new ScubeBizException("流程跳转异常，请重新提交！");
			}

		} else if (WorkflowConstant.WORKFLOW_TRANS_BACKTOLAST.equals(attitude)) {
			if (StringUtil.isEmpty(applibaseinfo.getComment())) {
				comment = "退回";
			} else {
				comment = applibaseinfo.getComment();
			}
			taskService.completeTask(taskId, processId, ContextHolder.getUserInfo().getTlrNo(), comment, bizData);// 提交任务
			String firstNode = "";
			for (NodeDes node : nodelist) {
				int nodeSeq = node.getNodeSeq();
				if (nodeSeq == 1) {
					firstNode = node.getNodeId();
					break;
				}
			}
			processService.signal(processId, firstNode, bizData);// 进入第二个节点
		} else if (WorkflowConstant.WORKFLOW_TRANS_GOBACK.equals(attitude)) { // 退回到上一节点
			if (StringUtil.isEmpty(applibaseinfo.getComment())) {
				comment = "退回";
			} else {
				comment = applibaseinfo.getComment();
			}
			// 完成当前任务,保存审批意见
			taskService.completeTask(taskId, processId, ContextHolder.getUserInfo().getTlrNo(), comment, bizData);// 提交任务
			// 跳转到上一个节点
//			processService.signalPrevious(processId);
			String backNode = "";
			String currencyNode = nodeEntity.getId();
			int seq = 0;
			for (NodeDes node : nodelist) {
				String nodeId = node.getNodeId();
				if(nodeId.equals(currencyNode))
				{
					seq = node.getNodeSeq();
					break;
				}
			}
			for (NodeDes node : nodelist) {
				int nodeSeq = node.getNodeSeq();
				if (nodeSeq == seq-1) {
					backNode = node.getNodeId();
					break;
				}
			}
			processService.signal(processId, backNode, bizData);// 进入第二个节点
		} else if (WorkflowConstant.WORKFLOW_TRANS_REFUSE.equals(attitude)) {// 拒绝,跳转到结束节点
			if (StringUtil.isEmpty(applibaseinfo.getComment())) {
				comment = "拒绝";
			} else {
				comment = applibaseinfo.getComment();
			}
			// 完成当前任务,保存审批意见
			taskService.completeTask(taskId, processId, ContextHolder.getUserInfo().getTlrNo(), comment, bizData);// 提交任务
			String overnodeId = "reject";
			processService.signal(processId, overnodeId, bizData);
			// bSysTaskService.bizProcess("reject", applibaseinfo.getAppno(),
			// processId, modelId);
		} else {
			taskService.completeTask(taskId, processId, ContextHolder.getUserInfo().getTlrNo(), comment, bizData);// 提交任务
		}

		// 2. 插入审批明细表 Applydtl表
		Map<String, Object> applyMap = new HashMap<String, Object>();
		applyMap.put(TRANSNO, applibaseinfo.getAppno());
		applyMap.put(APPNO, applibaseinfo.getAppno());//
		applyMap.put(ATTITUDE, WorkflowConstant.WORKFLOW_TRANS_AGREE);
		applyMap.put(TASKNAME, nodeEntity.getName());
		applyMap.put(REASON, nodeEntity.getName());
		this.saveApplydtl(applyMap);

		// 4. 更新主申请表 当前已审批信息
		scfapplyservice.updateTblAppBaseInfo(ContextHolder.getUserInfo().getTlrNo(), ContextHolder.getOrgInfo().getBrNo(), processStatus,
				applibaseinfo.getAppno(), attitude, null);
	}

	// 任务基本信息
	@Override
	public com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo findBPbcAppliBaseInfoByAppno(String appno, String process) {
		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo pbcinfo = new com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo();
		if (StringUtil.isStrNotEmpty(appno)) {
			pbcinfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			UserInfo userInfo = scubeUserService.selectUserByTlrNo(pbcinfo.getStartTlrcd(), ScfCommonUtil.getBrManagerNo(scubeUserService));
			pbcinfo.setStartTlrcdName(userInfo.getTlrName());
			if (StringUtil.isStrNotEmpty(pbcinfo.getStartBrcode())) {
				BctlVO brcode = scubeUserService.selectBctlByBrNo(pbcinfo.getStartBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
				pbcinfo.setStartBrcodeName(brcode.getBrName());
			}
			pbcinfo.setStartTaskDate(pbcinfo.getAppDate());
		} else {
			BctlVO BctlVO = ContextHolder.getOrgInfo();
			UserInfo UserInfo = ContextHolder.getUserInfo();
			pbcinfo.setStartTlrcd(UserInfo.getTlrNo());
			pbcinfo.setStartTlrcdName(UserInfo.getTlrName());
			pbcinfo.setStartBrcode(BctlVO.getBrNo());
			pbcinfo.setStartBrcodeName(BctlVO.getBrName());
			pbcinfo.setStartTaskDate(ScfDateUtil.formatDate(new java.util.Date()));
		}
		// 根据modelId查询流程名称
		BPrdWkflowCop bPrdWkflowCop = new BPrdWkflowCop();
		bPrdWkflowCop.setFlowCopId(process);
		BPrdWkflowCop bPrdWkflow = bPrdWkflowCopService.queryBPrdWkflowCopByBPrd(bPrdWkflowCop);
		// 流程信息
		if(bPrdWkflow==null)
		{
			throw new ScubeBizException("流程组件信息缺失");
		}
		String processName = null == bPrdWkflow ? "" : bPrdWkflow.getFlowName();
		pbcinfo.setProcessTemplateName(processName);
		return pbcinfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.common.service.IScfWorkFlowService#submitTaskRelated(
	 * java.lang.String)
	 */
	@Override
	public void takeTaskAndRelated(String appno) {
		if (appno == null || "".equals(appno)) {// 所传数据无效
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		try {
			String userId = ContextHolder.getUserInfo().getTlrNo();
			com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo bPbcAppliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			String processId = bPbcAppliBaseInfo.getPiid();
			if (processId == null || "".equals(processId)) {
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10042),
						RBcpErrorConstant.SCF_REC_BCP_10042);
			}
			// 领取任务
			NodeEntity nodeEntity = processService.getCurrentNodeEntity(processId);// 根据processId取出节点ID
			String taskId = "";
			if (null != nodeEntity) {
				taskId = nodeEntity.getCurrentTaskId();// 取当前任务ID
			}
			taskService.takeTask(taskId, processId, userId);
			// 任务提交d
			String comment = "发起流程";
			taskService.completeTask(taskId, processId, userId, comment);
			// 节点转移(自己要再设置一下)
			processService.autoSignal(processId);// 通知书回执节点(下一节点)
			bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);// 已提交(未审批)
			bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);// 已提交
			bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		} catch (Exception e) {
			log.error("流程跳转失败！" + e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10034), RBcpErrorConstant.SCF_REC_BCP_10034);
		}
	}

	/***
	 * 流程的跳转
	 * 
	 * @throws FlowsharpException
	 */
	@Transactional
	@Override
	public void processTask(com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo applibaseinfo, String attitude, Map<String, Object> paramMap)
			throws ScubeBizException, FlowsharpException {
		log.debug("processId=" + applibaseinfo.getPiid());
		ProcessEntity processEntity = processService.getProcessEntityById(applibaseinfo.getPiid());
		String modelId = processEntity.getModelId();
		int processStatus = 0;
		// 流程跳转
		String processId = applibaseinfo.getPiid();// processId
		NodeEntity nodeEntity = processService.getCurrentNodeEntity(processId);// 当前节点nodeEntity
		List<NodeDes> nodelist = processService.getNodeDesByModelId(modelId);// 节点列表信息
		if (nodeEntity == null || nodelist == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20003), BSysErrorConstant.SCF_BAS_SYS_20003);
		}
		String taskId = nodeEntity.getCurrentTaskId(); // 获取当前任务节点ID
		if (StringUtil.isEmpty(taskId)) {
			throw new ScubeBizException("任务还没有生成,请稍等一下再提交!");
		}
		String comment = "";// 执行任务留言
		// String reasonIn = "";//审批留言

		// 领用任务
		taskService.takeTask(taskId, processId, ContextHolder.getUserInfo().getTlrNo());
		// 判断当前是否为最后一个节点,true不是最后节点，false是最后节点
		boolean flag = false;
		for (NodeDes nodedes : nodelist) {
			if (nodedes.getNodeId().equals(nodeEntity.getId())) {
				if (nodedes.getNodeSeq() < nodelist.size()) {
					flag = true;
				} else {
					processStatus = 16;
					flag = false;
				}
				break;
			}
		}
		// 扩展业务信息
		String bizId = applibaseinfo.getAppno(); // 业务流程号
		String custCd = null == paramMap.get(WorkflowConstant.CUST_CD) ? "" : paramMap.get(WorkflowConstant.CUST_CD).toString(); // 客户号
		String cname = null == paramMap.get(WorkflowConstant.CUST_NAME) ? "" : paramMap.get(WorkflowConstant.CUST_NAME).toString(); // 客户名称
		/*
		 * BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
		 * bCrmBaseInfo.setCustcd(custCd); BCrmBaseInfo crminfo =
		 * bcrmbaseinfoservice.findBCrmBaseInfoByKey(bCrmBaseInfo); String cname
		 * = crminfo.getCname();
		 */
		String[] bizData = { bizId, custCd, cname, modelId, ContextHolder.getUserInfo().getTlrName() };
		// 根据不同的意见走不同的分支
		if (WorkflowConstant.WORKFLOW_TRANS_AGREE.equals(attitude)) {
			if (StringUtil.isEmpty(applibaseinfo.getComment())) {
				comment = "同意";
			} else {
				comment = applibaseinfo.getComment();
			}
			// 完成当前任务,保存审批意见
			taskService.completeTask(taskId, processId, ContextHolder.getUserInfo().getTlrNo(), comment, bizData);// 提交任务
			if (flag) {
				NodeEntity nextNode = processService.getNextNode(processId);
				if (nextNode == null) {
					processStatus = 16;
					processService.cancelProcess(processId);
					return;
				} else if (nextNode.getNodeType() == 2) {// 是最后一个节点，进入审批节点
					processStatus = 16;
					String overnodeId = "pass";
					processService.signal(processId, overnodeId, bizData);
					// bSysTaskService.bizProcess("pass",
					// applibaseinfo.getAppno(), processId, modelId);
				} else {// 不是最后节点
						// 进入下一节点
					processService.autoSignal(processId);
				}
			}
			if (!flag) {// 当前节点是最后一个节点并且不是结束节点
				processService.cancelProcess(processId);
				return;
			}
		} else if (WorkflowConstant.WORKFLOW_TRANS_BACKTOLAST.equals(attitude)) { // 退回到首个节点(第二个节点)
			if (StringUtil.isEmpty(applibaseinfo.getComment())) {
				comment = "退回";
			} else {
				comment = applibaseinfo.getComment();
			}
			taskService.completeTask(taskId, processId, ContextHolder.getUserInfo().getTlrNo(), comment, bizData);// 提交任务
			String firstNode = "";
			for (NodeDes node : nodelist) {
				int nodeSeq = node.getNodeSeq();
				if (nodeSeq == 2) {
					firstNode = node.getNodeId();
				}
			}
			processService.signal(processId, firstNode, bizData);// 进入第二个节点
		} else if (WorkflowConstant.WORKFLOW_TRANS_GOBACK.equals(attitude)) { // 退回到上一节点
			if (StringUtil.isEmpty(applibaseinfo.getComment())) {
				comment = "退回";
			} else {
				comment = applibaseinfo.getComment();
			}
			// 完成当前任务,保存审批意见
			taskService.completeTask(taskId, processId, ContextHolder.getUserInfo().getTlrNo(), comment, bizData);// 提交任务
			// 跳转到上一个节点
			processService.signalPrevious(processId);
		} else if (WorkflowConstant.WORKFLOW_TRANS_REFUSE.equals(attitude)) {// 拒绝,跳转到结束节点
			if (StringUtil.isEmpty(applibaseinfo.getComment())) {
				comment = "拒绝";
			} else {
				comment = applibaseinfo.getComment();
			}
			// 完成当前任务,保存审批意见
			taskService.completeTask(taskId, processId, ContextHolder.getUserInfo().getTlrNo(), comment, bizData);// 提交任务
			String overnodeId = "reject";
			processService.signal(processId, overnodeId, bizData);
			// bSysTaskService.bizProcess("reject", applibaseinfo.getAppno(),
			// processId, modelId);
		} else {
			taskService.completeTask(taskId, processId, ContextHolder.getUserInfo().getTlrNo(), comment, bizData);// 提交任务
		}

		// 2. 插入审批明细表 Applydtl表
		Map<String, Object> applyMap = new HashMap<String, Object>();
		applyMap.put(TRANSNO, applibaseinfo.getAppno());
		applyMap.put(APPNO, applibaseinfo.getAppno());//
		applyMap.put(ATTITUDE, WorkflowConstant.WORKFLOW_TRANS_AGREE);
		applyMap.put(TASKNAME, nodeEntity.getName());
		applyMap.put(REASON, nodeEntity.getName());
		this.saveApplydtl(applyMap);

		// 4. 更新主申请表 当前已审批信息
		scfapplyservice.updateTblAppBaseInfo(ContextHolder.getUserInfo().getTlrNo(), ContextHolder.getOrgInfo().getBrNo(), processStatus,
				applibaseinfo.getAppno(), attitude, null);
	}

	/**
	 * 供应链放款业务 获取工作流信息
	 * 
	 * @param mastContno
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月23日上午10:14:53
	 */
	@Override
	public HashMap<String, String> getWkflowMode(String mastContno) throws ScubeBizException {
		// TODO Auto-generated method stub
		BCntBcpInfo bcpInfo = bcntbcpinfodao.selectByPrimaryKey(mastContno);
		if (bcpInfo == null) {
			log.info("业务合同信息不存在");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPrdErrorConstant.SCF_BAS_PRD_10002), BPrdErrorConstant.SCF_BAS_PRD_10002);
		}
		HashMap<String, String> map = new HashMap<String, String>();
		String loanWay = bcpInfo.getExt1();// 出账方式
		String bussType = bcpInfo.getSupplyChainPdId();// //业务品种--产品
		String modelId = "";// 流程Id
		String appliType = "";// 申请类型
		BPrdInfo bPrdInfo = bPrdInfoService.findBPrdInfoObjectByKey(bussType);

		if (bPrdInfo == null) {
			log.info("业务品种不存在");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPrdErrorConstant.SCF_BAS_PRD_10002), BPrdErrorConstant.SCF_BAS_PRD_10002);
		}
		String bigProductId = bPrdInfo.getParentId();// 产品种类--产品大类：预付类

		// 出账方式为流贷
		if (ScfBasConstant.LOAN_WAY_WORKING_CAPITAL.equals(loanWay)) {// 流贷
			if (ScfBasConstant.PRODUCT_TYPE_ACCR.equals(bigProductId))
			{
				BBrpPrdFactoring bBrpPrdFactoring = bBrpPrdFactoringService.findBBrpPrdFactoringByKey(bussType);
				String factType = bBrpPrdFactoring.getFactType();
				if (ScfBasConstant.FACT_TYPE_INLAND.equals(factType)
						|| ScfBasConstant.FACT_TYPE_REVERSE.equals(factType)
						|| ScfBasConstant.FACT_TYPE_DEBT_PLEDGE.equals(factType))
				{// 应收账款
					//国内保理,反向保理,应收账款质押
					modelId = WorkflowConstant.PROCNAME_INCOICE_FINANCING_APPLY;
					appliType = WorkflowConstant.APPLI_TYPE_INCOICEFINANCINGAPPLY;
				}
				else if(ScfBasConstant.FACT_TYPE_DEBT_POOL_PLEDGE.equals(factType)
						|| ScfBasConstant.FACT_TYPE_DEBT_POOL.equals(factType)
						|| ScfBasConstant.FACT_TYPE_EXPORT_POOL_PLEDGE.equals(factType))
				{// 应收账款池融资
					//应收账款质押池融资,保理池融资,出口退税池质押融资
					modelId = WorkflowConstant.PROCNAME_FINANCING_POOL_APPLY;
					appliType = WorkflowConstant.APPLI_TYPE_FINANCINGPOOLAPPLY;
				}
				else if(ScfBasConstant.FACT_TYPE_DOUBLE_FACT.equals(factType))
				{//国内双保理
					modelId = WorkflowConstant.PROCNAME_DOUBLE_FACT_FINANCING_APPLY;
					appliType = WorkflowConstant.APPLI_TYPE_DOUBLE_FACT_FINANCING_APPLY;
				}
				else if(ScfBasConstant.FACT_TYPE_LEASE_FACT.equals(factType))
				{//租赁保理
					modelId = WorkflowConstant.PROCNAME_LEASE_FACT_FINANCING_APPLY;
					appliType = WorkflowConstant.APPLI_TYPE_LEASE_FACT_FINANCING_APPLY;
				}
				else if(ScfBasConstant.FACT_TYPE_CREDIT_FACT.equals(factType))
				{//信保保理
					modelId = WorkflowConstant.PROCNAME_CREDIT_FACT_FINANCING_APPLY;
					appliType = WorkflowConstant.APPLI_TYPE_CREDIT_FACT_FINANCING_APPLY;
				}
			} else if (ScfBasConstant.PRODUCT_TYPE_MORT.equals(bigProductId)) {// 现货质押
				if (ScfBasConstant.PRODUCT_TYPE_PLDY.equals(bussType) || ScfBasConstant.PRODUCT_TYPE_PLSY.equals(bussType)) {// 现货动态质押、现货静态质押
					modelId = WorkflowConstant.PROCNAME_MORTGAGECASHLOANAPPLY;
					appliType = WorkflowConstant.APPLI_TYPE_MORTGAGE_CASH_LOAN_APPLY;
				}
				if (ScfBasConstant.PRODUCT_TYPE_BILL_NORMAL.equals(bussType)) {// 非标仓单
					modelId = WorkflowConstant.PROCNAME_NORMAL_CASH_LOAN_APPLY;
					appliType = WorkflowConstant.APPLI_TYPE_BILL_NORMAL_CASH_LOAN_APPLY;
				}
			}
		}
		// 出账方式为银承
		else if (ScfBasConstant.LOAN_WAY_BANK_ACCEPTENCE.equals(loanWay)) {
			if (ScfBasConstant.PRODUCT_TYPE_PREP.equals(bigProductId)) {// 预付类
				if (ScfBasConstant.PRODUCT_TYPE_SMALL_WH.equals(bussType)) {// 担保提货
					modelId = WorkflowConstant.PROCNAME_THREE_BILL_APPLY;
					appliType = WorkflowConstant.APPLI_TYPE_THREE_BILLPPLI;
				} else if (ScfBasConstant.PRODUCT_TYPE_XPHH.equals(bussType)) {// 先票款后货
					modelId = WorkflowConstant.PROCNAME_FOUR_LOAN_BILL_APPLY;
					appliType = WorkflowConstant.APPLI_TYPE_FOUR_BILL_APPLY;
				}
			}
			if (ScfBasConstant.PRODUCT_TYPE_PLDY.equals(bussType) || ScfBasConstant.PRODUCT_TYPE_PLSY.equals(bussType)) {// 现货动态质押、现货静态质押
				modelId = WorkflowConstant.PROCNAME_MORTGAGEBILLLOANAPPLY;
				appliType = WorkflowConstant.APPLI_TYPE_MORTGAGE_BILL_LOAN_APPLY;
			} else if (ScfBasConstant.PRODUCT_TYPE_MORT.equals(bigProductId)) {// 现货类
				if (ScfBasConstant.PRODUCT_TYPE_BILL_NORMAL.equals(bussType)) {// 非标仓单
					modelId = WorkflowConstant.PROCNAME_NORMAL_BILL_LOAN_APPLY;
					appliType = WorkflowConstant.APPLI_TYPE_BILL_NORMAL_BILL_LOAN_APPLY;
				}
			}
		}
		// 根据流程ID获得流程名称
		// 根据modelId查询流程名称
		BPrdWkflowCop bPrdWkflowCop = new BPrdWkflowCop();
		bPrdWkflowCop.setFlowCopId("N-" + modelId);
		BPrdWkflowCop bPrdWkflow = bPrdWkflowCopService.queryBPrdWkflowCopByBPrd(bPrdWkflowCop);
		// 流程信息
		String processName = null == bPrdWkflow ? "" : bPrdWkflow.getFlowName();
		if (StringUtil.isEmpty(processName)) {
			log.error("缺少对应的流程组件配置，或是流程名称为空！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPrdErrorConstant.SCF_BAS_PRD_20001), BPrdErrorConstant.SCF_BAS_PRD_20001);
		}
		map.put("modelId", "N-" + modelId);
		map.put("processName", processName);
		map.put("appliType", appliType);
		return map;
	}

	// 新应收类流程开始公用方法(本方法已包含基本节点跳转至任务节点方法，第一节点必须是基本节点。)
	@Override
	@Transactional
	public ProcessEntity NstartWorkFlow(String bussAppno, String workflowBussType, HashMap<String, Object> paramMap)
			throws ScubeBizException, FlowsharpException {
		String modelId = paramMap.get("modelId").toString();
		// String NodeId = paramMap.get("NodeId").toString();
		String startedUserId = paramMap.get("startedUserId").toString();

		// 自动查询首节点
		List<NodeDes> nodeDesList = processService.getNodeDesByModelId(modelId);
		if (nodeDesList == null || nodeDesList.size() == 0) {
			throw new ScubeBizException("流程" + modelId + "节点信息丢失，请重新配置对应流程节点信息！");
		}
		int x = 0;
		int y = 0;
		String firstNode = "";
		for (NodeDes nodeDes1 : nodeDesList) {
			if (nodeDes1.getNodeType() == 0) {// 基本节点
				x = x + 1;
			}
			if (nodeDes1.getNodeSeq() == 1) {// 查询第一个节点用于返回
				firstNode = nodeDes1.getNodeId();
				y = y + 1;
			}
		}

		if (x != 1) {// 基本节点唯一性校验
			throw new ScubeBizException("请重新配置节点信息，保证流程有且仅有一个基本节点！");
		}

		if (y != 1) {
			throw new ScubeBizException("请重新配置节点信息，保证流程有且仅有一个第一节点！");
		}

		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(bussAppno); // 业务主表
		if (null == appliBaseInfo) {
			log.error("业务申请主表记录不存在！" + bussAppno);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BComErrorConstant.SCF_BAS_COM_20000), BComErrorConstant.SCF_BAS_COM_20000);
		}

		BPrdWkflowCop bPrdWkflowCop = new BPrdWkflowCop();
		bPrdWkflowCop.setFlowCopId(workflowBussType);
		BPrdWkflowCop bPrdWkflow = bPrdWkflowCopService.queryBPrdWkflowCopByBPrd(bPrdWkflowCop);
		// 流程信息
		String processName = null == bPrdWkflow ? "" : bPrdWkflow.getFlowName();
		// 取客户信息
		String cname = "";
		if (!StringUtil.isEmpty(appliBaseInfo.getCustcd())) {
			BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
			bCrmBaseInfo.setCustcd(appliBaseInfo.getCustcd());
			BCrmBaseInfo crminfo = bcrmbaseinfoservice.findBCrmBaseInfoByKey(bCrmBaseInfo);
			cname = crminfo.getCname();
		}

		// 校验分支行产品授权
		checkSupplyChainId(appliBaseInfo);

		// 1.启动工作流[调用工作流服务]
		String[] bizData1 = { bussAppno, appliBaseInfo.getCustcd(), cname, modelId };
		ProcessEntity processVO = processService.startProcess(modelId, processName, firstNode, startedUserId, bussAppno, bizData1);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (processVO == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20003), BSysErrorConstant.SCF_BAS_SYS_20003);
		}
		String processId = processVO.getProcessId();
		System.out.println("===============" + processId + "==============");

		// 2.保存发起人“提交申请”及时间等相关信息（保存到APPLY_DTL【意见表】）
		Map<String, Object> applyMap = new HashMap<String, Object>();
		applyMap.put(TRANSNO, bussAppno);
		applyMap.put(APPNO, bussAppno);//
		applyMap.put(ATTITUDE, WorkflowConstant.WORKFLOW_TRANS_AGREE);
		applyMap.put(TASKNAME, WorkflowConstant.DEFOULT_ATTITUDE);
		applyMap.put(REASON, WorkflowConstant.DEFOULT_ATTITUDE);
		this.saveApplydtl(applyMap);
		// 3.更新申请表申请状态，工作流申请号（更新TBL_APPLI_BASE_INFO【主申请表】，插入在新增时插入）
		appliBaseInfo.setPiid(processId);// 保存工作流实例ID
		appliBaseInfo.setWorkflowAppno(bussAppno);
		appliBaseInfo.setProcessTemplateName(workflowBussType);
		appliBaseInfo.setStartTlrcd(ContextHolder.getUserInfo().getTlrNo()); // 发起人
		appliBaseInfo.setStartBrcode(ContextHolder.getOrgInfo().getBrNo()); // 发起机构
		appliBaseInfo.setStratDate(ScfDateUtil.formatDate(new Date())); // 发起日期
		appliBaseInfo.setStartTime(new Date()); // 发起时间
		bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(appliBaseInfo);

		// 4.这里直接跳转节点（只运用于第一节点是基本节点的状态）
		this.basicNodeJump(appliBaseInfo);

		return processVO;
	}

	// 根据流程ID查询第一个节点并且校验基本节点唯一性
	@Override
	public String getFirstNodeByModelId(String modelId) throws ScubeBizException, FlowsharpException {
		List<NodeDes> nodeDesList = processService.getNodeDesByModelId(modelId);
		if (nodeDesList == null || nodeDesList.size() == 0) {
			throw new ScubeBizException("流程" + modelId + "节点信息丢失，请重新配置对应流程节点信息！");
		}
		// int x = 0;
		int y = 0;
		String firstNode = "";
		for (NodeDes nodeDes1 : nodeDesList) {

			/*
			 * if (nodeDes1.getNodeType() == 0) {// 基本节点 x = x + 1; }
			 */

			if (nodeDes1.getNodeSeq() == 1) {// 查询第一个节点用于返回
				firstNode = nodeDes1.getNodeId();
				y = y + 1;
			}
		}

		/*
		 * if (x != 1) {// 基本节点唯一性校验 throw new
		 * ScubeBizException("请重新配置节点信息，保证流程有且仅有一个基本节点！"); }
		 */

		if (y != 1) {
			throw new ScubeBizException("请重新配置节点信息，保证流程有且仅有一个第一节点！");
		}
		// 节点列表信息
		return firstNode;
	}

	// 基本节点跳转
	@Override
	@Transactional
	public void basicNodeJump(com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo bPbcAppliBaseInfo) throws ScubeBizException, FlowsharpException {
		if (bPbcAppliBaseInfo == null || StringUtils.isEmpty(bPbcAppliBaseInfo.getPiid())) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.ERROR_CODE_APPINFO_ERROR),
					RBcpErrorConstant.ERROR_CODE_APPINFO_ERROR);
		}
		// 取客户信息
		String cname = "";
		if (!StringUtil.isEmpty(bPbcAppliBaseInfo.getCustcd())) {
			BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
			bCrmBaseInfo.setCustcd(bPbcAppliBaseInfo.getCustcd());
			BCrmBaseInfo crminfo = bcrmbaseinfoservice.findBCrmBaseInfoByKey(bCrmBaseInfo);
			cname = crminfo.getCname();
		}
		String modelId = bPbcAppliBaseInfo.getProcessTemplateName();
		String[] bizData = { bPbcAppliBaseInfo.getAppno(), bPbcAppliBaseInfo.getCustcd(), cname, modelId, ContextHolder.getUserInfo().getTlrName() };
		try {
			//1.按机构级别方式分配-获取分配对象
			List<TlrInfoVO> userlist = processService.getNextCandidates(bPbcAppliBaseInfo.getPiid(), ContextHolder.getOrgInfo().getBrNo(), new ArrayList<BusinessField>());
			//2.推进至任务节点
			processService.autoSignal(bPbcAppliBaseInfo.getPiid(), bizData);
			if(userlist!=null&&userlist.size()>0)
			{
				//3.获取任务信息
				NodeEntity node = processService.getCurrentNodeEntity(bPbcAppliBaseInfo.getPiid());
				String taskId = node.getCurrentTaskId();
				Task task = taskService.getTaskById(taskId, bPbcAppliBaseInfo.getPiid());
				//4.根据任务候选人列表的选择结果，重新分配任务
				taskService.assignTask(task, userlist);
			}
		} catch (FlowsharpException e) {
			log.debug(e.getMessage());
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10034), RBcpErrorConstant.SCF_REC_BCP_10034);
		}

	}

	// 退回提交公用方法（修改申请基本信息状态，使用基本节点跳转方法）
	@Override
	@Transactional
	public void backSubmitCommon(com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo bPbcAppliBaseInfo) throws ScubeBizException, FlowsharpException {
		// 1. 校验信息
		if (bPbcAppliBaseInfo == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10040), RBcpErrorConstant.SCF_REC_BCP_10040);
		}
		// 2. 修改申请基本信息修改状态为已提交
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);// 已提交(审批中)
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_BACKSUBMIT);// 修改已提交
		try {
			bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(bPbcAppliBaseInfo);
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10040), RBcpErrorConstant.SCF_REC_BCP_10040);
		}
		// 3.流程跳转（基本流程跳转方法） SCF_REC_BCP_10034
		this.basicNodeJump(bPbcAppliBaseInfo);
	}

	/**
	 * 添加基本节点后，考虑到退回操作流程跳转及发起流程判断方法
	 * 
	 * @param appliBaseInfo
	 * @author mengjiajia
	 * @date 2017年6月12日下午4:23:43
	 */
	@Override
	public void FactoringProcessDone(com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo appliBaseInfo) {
		if (appliBaseInfo != null && !StringUtil.isEmpty(appliBaseInfo.getPiid())) {
			try {
				this.basicNodeJump(appliBaseInfo);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			appliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);// 已提交(审批中)
			appliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_BACKSUBMIT);// 修改已提交
		} else {
			// 发起工作流
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("modelId", appliBaseInfo.getProcessTemplateName());
			paramMap.put("startedUserId", ContextHolder.getUserInfo().getTlrNo());
			try {
				this.NstartWorkFlow(appliBaseInfo.getAppno(), appliBaseInfo.getProcessTemplateName(), paramMap);
			} catch (FlowsharpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			appliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
			appliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_APPROVING);
		}
		// 更新业务申请信息
		bpbcapplibaseinfoservice.updateBPbcAppliBaseInfo(appliBaseInfo);
	}
	
	/**
	 * 特殊路径调用
	 * @param appNo
	 * @param invokPhase
	 * @param callerpath
	 * @return	false:继续执行，true:已执行成功
	 * @author 	mengjiajia
	 * @date 	2017年6月19日下午4:13:10
	 */
	@Override
	public boolean invokAnotherClasspath(String appNo, String invokPhase, String callerpath)
	{
		com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo appliBaseInfo = 
				bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appNo);
		String productId = appliBaseInfo.getSupplyChainPdId();
		BPrdFlowVO flowVO = bprdflowservice.findBPrdFlowVOByParam(productId, invokPhase);
		if(flowVO!=null)
		{//存在该业务品种及该调用阶段的流程配置信息
			if(!StringUtil.isEmpty(flowVO.getModelId())&&!StringUtil.isEmpty(flowVO.getCallerClasspath()))
			{//判断modelId及调用路径是否存在
				if(flowVO.getCallerClasspath().trim().equals(callerpath))
				{//如果特殊调用路劲与原路径相同，则返回false;
					return false;
				}
				if(flowVO.getModelId().equals(appliBaseInfo.getProcessTemplateName()))
				{//若存在且modelId相同，则获得其跳转路径并调用
					String beanId = flowVO.getCallerClasspath().trim();
					DealEndFlowService dealEndFlowService = 
							(DealEndFlowService) applicationContext.getBean(beanId);
					dealEndFlowService.doWorkForPass(appNo);
					return true;
				}
			}
		}
		return false;
	}
}

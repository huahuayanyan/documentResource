/**
 * 
 */
package com.huateng.scf.bas.sys.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.huateng.ApproveRoute.pojo.BusinessField;
import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.api.ITaskService;
import com.huateng.flowsharp.api.IWebsiteService;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.flowsharp.entity.NodeDes;
import com.huateng.flowsharp.entity.NodeEntity;
import com.huateng.flowsharp.entity.ProcessEntity;
import com.huateng.flowsharp.entity.Task;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IScfWorkFlowService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliBaseInfoService;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.dao.IBSysApplyDtlDAO;
import com.huateng.scf.bas.sys.dao.IBSysFlowUrlRelDAO;
import com.huateng.scf.bas.sys.dao.model.BSysApplyDtl;
import com.huateng.scf.bas.sys.dao.model.BSysApplyDtlExample;
import com.huateng.scf.bas.sys.dao.model.BSysFlowUrlRel;
import com.huateng.scf.bas.sys.dao.model.BSysFlowUrlRelExample;
import com.huateng.scf.bas.sys.dao.model.BSysFlowUrlRelExample.Criteria;
import com.huateng.scf.bas.sys.dao.model.BSysTask;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.bas.sys.service.IBSysTaskService;
import com.huateng.scf.nrec.bcp.service.IRBcpDebtInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 待办任务实现类
 * </p>
 *
 * @author huangshuidan
 * @date 2016年11月12日上午11:47:58
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月12日上午11:47:58	                                 新增
 *
 *            </pre>
 */
@ScubeService
@Service("BSysTaskServiceImpl")
public class BSysTaskServiceImpl implements IBSysTaskService, ApplicationContextAware {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private ITaskService taskService;
	@Autowired
	private IProcessService processService;
	@Autowired
	private IWebsiteService websiteService;

	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;

	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bCrmBaseInfoService;

	@Resource(name = "scfWorkFlowService")
	IScfWorkFlowService scfWorkFlowService;

	@Resource(name = "RBcpDebtInfoServiceImpl")
	IRBcpDebtInfoService rBcpDebtInfoService;

	@Resource(name = "BSysFlowUrlRelDAO")
	IBSysFlowUrlRelDAO BSysFlowUrlRelDAO;

	private ApplicationContext applicationContext;

	@Resource(name = "BPbcAppliBaseInfoServiceImpl")
	IBPbcAppliBaseInfoService bpbcapplibaseinfoservice;
	
	@Resource(name = "BSysApplyDtlDAO")
	IBSysApplyDtlDAO bsysapplydtldao;
	
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bPbcAppliBaseInfoDAO;
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.sys.service.IBSysTaskService#queryTaskListByPage(int,
	 * int, com.huateng.scf.bas.sys.dao.model.BSysTask)
	 */
	@Override
	public Page queryTaskListByPage(int pageNo, int pageSize, BSysTask bSysTask) throws ScubeBizException, FlowsharpException {
		// 获取当前用户
		UserInfo user = ContextHolder.getUserInfo();
		String userId = null;
		String processId = "";
		String appNo = "";// 业务申请号
		String custName = "";// 客户名称
		String modelId = "";// 流程模板ID
		if (null != user) {
			userId = user.getTlrNo();
		}
		if (null != bSysTask) {
			appNo = bSysTask.getAppNo();
			custName = bSysTask.getCustName();
		}
		Page taskPage = taskService.getUnTakeTask(userId, processId, pageNo, pageSize, new String[] { appNo, "", custName, modelId });
		if(taskPage==null){
			  return  new  Page(0,0,0);
		}
		List taskList = taskPage.getRecords();
		List takList = new ArrayList();
		if (null != taskList && taskList.size() > 0) {
			// 获取机构信息
			BctlVO BctlVO = ContextHolder.getOrgInfo();
			for (int i = 0; i < taskList.size(); i++) {
				BSysTask bSysTask1 = JSON.parseObject(taskList.get(i).toString(), new TypeReference<BSysTask>() {
				});
				if (null != BctlVO) {
					bSysTask1.setOrgName(BctlVO.getBrName());// 发起机构
				}
				// log.info("=========================申请编号:"+bSysTask1.getProcessId());//申请编号
				// log.info("=========================任务名称:"+bSysTask1.getTaskName());//任务名称
				// log.info("=========================客户名称:"+bSysTask1.getCustName());//客户名称
				// log.info("=========================发起机构:"+bSysTask1.getOrgName());//发起机构
				// log.info("=========================发起时间:"+bSysTask1.getCreateTime());//发起时间
				bSysTask1.setCustName(bSysTask1.getName3());// 客户名称
				bSysTask1.setCustcd(bSysTask1.getCustcd());// 客户编号
				// String modelId=null;//流程模板ID
				ProcessEntity processEntity = processService.getProcessEntityById(bSysTask1.getProcessId());// 根据processId取出流程实例
				if (null != processEntity) {
					// modelId=processEntity.getModelId();//流程模板ID
					bSysTask1.setAppNo(processEntity.getBizId());// 业务申请号
					bSysTask1.setModelId(processEntity.getModelId());// 流程模板ID
					bSysTask1.setProcessName(processEntity.getProcessName());// 流程名称
					BSysFlowUrlRel bSysFlowUrlRel = new BSysFlowUrlRel();
					bSysFlowUrlRel.setFlowId(processEntity.getModelId());// 流程模板ID
					bSysFlowUrlRel.setNodeId(bSysTask1.getNodeId());// 节点ID
					BSysFlowUrlRel flowUrlRel = BSysFlowUrlRelDAO.selectByFlowAndNodeId(bSysFlowUrlRel);

					if (null != flowUrlRel) {
						bSysTask1.setPageUrl(flowUrlRel.getPgUrl());// 待办任务处理的跳转URL
						bSysTask1.setNodeButton(flowUrlRel.getNodeButton());// 任务节点按钮属性
					}

					BSysFlowUrlRel lastFlowUrlRel = null;
					// 流程对应节点找不到,就默认取最早记录
					if (flowUrlRel == null) {
						lastFlowUrlRel = getLastBSysFlowUrlRel(processEntity.getModelId());
						if (null != lastFlowUrlRel) {
							bSysTask1.setPageUrl(lastFlowUrlRel.getPgUrl());// 待办任务处理的跳转URL
						}
					}

				}
				// String nodeId=null;//流程节点ID
				// NodeEntity
				// nodeEntity=processService.getCurrentNodeEntity(bSysTask1.getProcessId());//根据processId取出节点ID
				// if(null!=nodeEntity){
				// nodeId=nodeEntity.getId();
				// }
				takList.add(bSysTask1);
			}
			taskPage.setRecords(takList);
		}
		return taskPage;
	}
	/**
	 * 统计审批通过，已驳回，已拒绝的笔数
	 * 
	 */
	@Override
	public Map<String, Object> queryTaskDtlCount(Map<String, Object> value) throws ScubeBizException, FlowsharpException {
		 Map<String, Object> map = new HashMap<String, Object>();
		 List<HashMap<String, Object>> list = bPbcAppliBaseInfoDAO.countAppliStatusList(value);
		//授信额度申请，业务申请出账申请(信贷)的相关记录不在B_PBC_APPLI_BASE_INFO
		 //授信额度申请 状态保存的是申请的明细状态
		 BigDecimal approvedNum = BigDecimal.ZERO;
		 BigDecimal refusedNum = BigDecimal.ZERO;
		 BigDecimal gobackNum = BigDecimal.ZERO;
		 if(null!=list&&list.size()>0){
			 for(HashMap<String, Object> omap: list){
				 BigDecimal countnum = (BigDecimal) omap.get("countNum");
				 String appliStatus = (String) omap.get("appliStatus");
				 if(WorkflowConstant.APPLI_STATUS_APPROVED.equals(appliStatus)
						|| WorkflowConstant.APPLI_STATUS_DTL_APPROVED.equals(appliStatus) ){ //已通过(审批通过)
					 //map.put("approvedNum", countnum);
					 approvedNum  = approvedNum.add(countnum);
				 }else if(WorkflowConstant.APPLI_STATUS_REFUSED.equals(appliStatus)
						 || WorkflowConstant.APPLI_STATUS_DTL_REFUSED.equals(appliStatus) ){ //已拒绝(审批不通过)
					 refusedNum  = refusedNum.add(countnum);
				 }else if(WorkflowConstant.APPLI_STATUS_GOBACK.equals(appliStatus)
						 || WorkflowConstant.APPLI_STATUS_DTL_GOBACK.equals(appliStatus)){ //已退回(审批被退回)
					 gobackNum  = gobackNum.add(countnum);
				 }
			 }
		 }
		 map.put("approvedNum", approvedNum);
		 map.put("refusedNum", refusedNum);
		 map.put("gobackNum", gobackNum);
		return map;
	}

	/*
	 * 取出最早流程模型对应url的记录
	 */
	public BSysFlowUrlRel getLastBSysFlowUrlRel(String modelId) throws ScubeBizException {

		BSysFlowUrlRelExample example = new BSysFlowUrlRelExample();
		example.setOrderByClause("ID");
		Criteria cri = example.createCriteria();
		cri.andFlowIdEqualTo(modelId);
		BSysFlowUrlRel bSysFlowUrlRel = null;
		List<BSysFlowUrlRel> bSysFlowUrlRelList = BSysFlowUrlRelDAO.selectByExample(example);
		if (bSysFlowUrlRelList != null && bSysFlowUrlRelList.size() > 0) {
			bSysFlowUrlRel = bSysFlowUrlRelList.get(0);

		}

		return bSysFlowUrlRel;

	}

	// 页面任务撤销按钮（终止任务，并且解锁对应单据信息。）
	// 实际上，对应的申请基本信息，也是应该被干掉的。 询问下再做。 TODO
	@Override
	@Transactional
	public void cancelTask(String processId, String appno) throws ScubeBizException {
		// 1.校验数据
		if (StringUtils.isEmpty(processId) || StringUtils.isEmpty(appno)) {// SCF_BAS_SYS_20005
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20005), BSysErrorConstant.SCF_BAS_SYS_20005);
		}
		// 2.如果有对应单据，则解锁单据。
		rBcpDebtInfoService.releaseDebtInfoByAppno(appno);
		try {
			processService.cancelProcess(processId);
		} catch (FlowsharpException e) {
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_50008), BSysErrorConstant.SCF_BAS_SYS_50008);
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}

	@Override
	@Transactional
	public void bizProcess(String comment, String appNo, String processId, String modelId, String flag, String[] bizData)
			throws ScubeBizException, FlowsharpException {
		// 1.参数校验与准备
		log.debug("bizProcess传递参数,comment=" + comment + ",appNo=" + appNo + ",processId=" + processId + ",modelId=" + modelId + ",flag" + flag);
		if (StringUtils.isBlank(flag) || StringUtils.isBlank(appNo) || StringUtils.isBlank(processId) || StringUtils.isBlank(modelId)) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50004), BSysErrorConstant.SCF_BAS_DCR_50004);
		}
		// 取出当前节点信息
		NodeEntity nodeEntity = processService.getCurrentNodeEntity(processId);
		String taskId = nodeEntity.getCurrentTaskId();
		if (StringUtils.isEmpty(taskId)) {
			throw new ScubeBizException("任务还没有生成,请稍等一下再提交!");
		}
		// 取出当前节点描述
		List<NodeDes> nodeDesList = processService.getNodeDesByModelId(modelId);

		if (nodeEntity == null || nodeDesList == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20003), BSysErrorConstant.SCF_BAS_SYS_20003);
		}
		// 2.取出业务名（如果没有业务名，默认提交下一节点，如果下一节点是结束节点，则取出节点）
		String beanId = null;
		// 只有back退回是需要取出pass节点的服务，通过和否决是调用对应的pass和reject节点的方法
		if ("back".equals(flag)) {
			for (NodeDes nodeDes : nodeDesList) {
				if (nodeDes.getNodeId().equals("pass")) {// 通用pass中的退回业务逻辑
					// 取出服务bean名
					if (StringUtils.isNotEmpty(nodeDes.getCallerClasspath())) {
						beanId = nodeDes.getCallerClasspath().trim();
					}
					break;
				}
			}
		} else {
			for (NodeDes nodeDes : nodeDesList) {
				if (nodeDes.getNodeId().equals(flag)) {
					// 取出服务bean名
					if (StringUtils.isNotEmpty(nodeDes.getCallerClasspath())) {
						beanId = nodeDes.getCallerClasspath().trim();
					}
					break;
				}
			}
		}

		DealEndFlowService dealEndFlowService = null;
		if (!StringUtil.isEmpty(beanId)) {
			dealEndFlowService = (DealEndFlowService) applicationContext.getBean(beanId);
		}
		// 5.先执行业务逻辑，再领取完成任务，再流程跳转
		if ("reject".equals(flag)) {
			// 否决
			if (dealEndFlowService != null) {
				dealEndFlowService.doWorkForReject(appNo);
			}
			this.takeTaskAndJumpNode(taskId, processId, "reject", comment, bizData);
		} else if ("pass".equals(flag)) {
			if (dealEndFlowService == null) {
				throw new ScubeBizException("审批通过调用服务缺失，请检查流程配置！");
			}
			// 审批通过
			dealEndFlowService.doWorkForPass(appNo);
			this.takeTaskAndJumpNode(taskId, processId, "pass", comment, bizData);
		} else if ("back".equals(flag)) {// 退回，跳转第一节点。按理说，退回是应该要有对应的处理业务服务调用的。但是这里还是不强求了,之前功能有退回按钮。
			if (dealEndFlowService != null) {
				dealEndFlowService.doWorkForBack(appNo);
			}
			String firstNode = scfWorkFlowService.getFirstNodeByModelId(modelId);
			if (StringUtils.isEmpty(firstNode)) {
				throw new ScubeBizException("流程第一节点丢失，无法退回，请修改流程节点信息！");
			}
			this.takeTaskAndJumpNode(taskId, processId, firstNode, comment, bizData);
		}
		return;
	}

	@Override
	@Transactional
	public void flowSumbitProcess(String comment, String appNo, String processId, String modelId, String[] bizData)
			throws ScubeBizException, FlowsharpException {
		// 1.参数校验与准备
		log.debug("bizProcess传递参数,comment=" + comment + ",appNo=" + appNo + ",processId=" + processId + ",modelId=" + modelId);
		if (StringUtils.isBlank(appNo) || StringUtils.isBlank(processId) || StringUtils.isBlank(modelId)) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50004), BSysErrorConstant.SCF_BAS_DCR_50004);
		}
		// 取出当前节点信息
		NodeEntity nodeEntity = processService.getCurrentNodeEntity(processId);
		String taskId = nodeEntity.getCurrentTaskId();
		if (StringUtils.isEmpty(taskId)) {
			throw new ScubeBizException("任务还没有生成,请稍等一下再提交!");
		}
		// 取出当前节点描述
		List<NodeDes> nodeDesList = processService.getNodeDesByModelId(modelId);
		if (nodeEntity == null || nodeDesList == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20003), BSysErrorConstant.SCF_BAS_SYS_20003);
		}

		// 2.取出业务名（如果没有业务名，默认提交下一节点，如果下一节点是结束节点，则取出节点）
		String beanId = null;
		for (NodeDes nodeDes : nodeDesList) {
			if (nodeDes.getNodeId().equals(nodeEntity.getId())) {
				// 取出服务bean名
				if (StringUtil.isStrNotEmpty(nodeDes.getCallerClasspath())) {
					beanId = nodeDes.getCallerClasspath().trim();
					break;
				}
			}
		}

		if (StringUtil.isStrNotEmpty(beanId)) {
			DealInFlowService dealInFlowService = (DealInFlowService) applicationContext.getBean(beanId);
			dealInFlowService.doWorkForSubmit(appNo);
		}
		NodeEntity nextNode = processService.getNextNode(processId);// 下一节点
		if (nextNode == null) {// 下一节点为空，这里就终止流程，默认结束。

			this.takeTaskAndJumpNode(taskId, processId, "", comment, bizData);
		} else {
			String userId = ContextHolder.getUserInfo().getTlrNo();
			taskService.takeTask(taskId, processId, userId, bizData);// 领取任务
			taskService.completeTask(taskId, processId, userId, comment, bizData);// 提交任务
			//1.按机构级别方式分配-获取分配对象
			List<TlrInfoVO> userlist = processService.getNextCandidates(processId, ContextHolder.getOrgInfo().getBrNo(), new ArrayList<BusinessField>());
			//2.推进至任务节点
			processService.autoSignal(processId);
			if(userlist!=null&&userlist.size()>0)
			{
				//3.获取任务信息
				NodeEntity node = processService.getCurrentNodeEntity(processId);
				taskId = node.getCurrentTaskId();
				Task task = taskService.getTaskById(taskId, processId);
				//4.根据任务候选人列表的选择结果，重新分配任务
				taskService.assignTask(task, userlist);
			}
		}
	}

	// 领取任务，完成任务，跳转节点
	@Override
	@Transactional
	public void takeTaskAndJumpNode(String taskId, String processId, String node, String comment, String[] bizData)
			throws ScubeBizException, FlowsharpException {
		String userId = ContextHolder.getUserInfo().getTlrNo();
		try {
			taskService.takeTask(taskId, processId, userId, bizData);// 领取任务
			taskService.completeTask(taskId, processId, userId, comment, bizData);// 提交任务
			if (StringUtils.isNotEmpty(node)) {// 如果是空，则终止流程。
				processService.signal(processId, node, bizData);
			} else {
				processService.cancelProcess(processId);
			}
		} catch (FlowsharpException e) {// 服务器繁忙，请稍后再审批。
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_50006), BSysErrorConstant.SCF_BAS_SYS_50006);
		}

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page queryWFProcessByPage(int pageNo, int pageSize, Map<String, String> conditionForm) throws ScubeBizException, FlowsharpException {
		String appNo = conditionForm.get("appNo");// 业务申请号
		String custName = conditionForm.get("custName");// 客户名称
		String modelId = conditionForm.get("flowCopId");// 流程模板ID
		// 查询全部流程
		Page page = processService.getProcessByNames(pageNo, pageSize, false, new String[] { appNo, "", custName, modelId });
		if (null != page) {
			List list = page.getRecords();
			List<Map<String, Object>> response = new ArrayList<Map<String, Object>>();
			if (null != list && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Map processMap = (Map) list.get(i);
					Map<String, Object> tempMap = new HashMap<String, Object>();
					// log.info("=========================客户名称:"+processMap.get("NAME3"));//客户名称
					// log.info("=========================申请编号:"+processMap.get("BIZ_ID"));//申请编号
					// log.info("=========================流程编号:"+processMap.get("PROCESS_ID"));//流程编号
					// log.info("=========================流程名称名称:"+processMap.get("PROCESS_NAME"));//流程名称
					// log.info("=========================流程状态:"+processMap.get("END_DATE"));//流程状态
					// log.info("=========================发起时间:"+processMap.get("START_DATE"));//发起时间
					// log.info("=========================发起人:"+processMap.get("STARTED_USER"));//发起人
					// log.info("=========================发起机构:");//发起机构
					String processId = null != processMap.get("PROCESS_ID") ? processMap.get("PROCESS_ID").toString() : "";
					List<Task> taskList = taskService.getTaskByProcessId(processId);
					if (null != taskList && null != taskList.get(0)) {
						tempMap.put("custName", taskList.get(0).getName3());
					}
					tempMap.put("processId", processId);
					tempMap.put("appNo", processMap.get("BIZ_ID"));
					tempMap.put("processName", processMap.get("PROCESS_NAME"));
					tempMap.put("createTime", processMap.get("START_DATE"));
					if (null != (processMap.get("STARTED_USER"))) {
						UserInfo userInfo = scubeUserService.selectUserByTlrNo(processMap.get("STARTED_USER").toString(),
								ScfCommonUtil.getBrManagerNo(scubeUserService));
						if(null!=userInfo){
							tempMap.put("tlrName", userInfo.getTlrName());	
						}
					}
					if (null != (processMap.get("END_DATE"))) {
						tempMap.put("status", "已结束");
					} else {
						tempMap.put("status", "进行中");
					}
					response.add(tempMap);
				}
			}
			page.setRecords(response);
		}
		return page;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> queryWFProcessTlrList(int pageNo, int pageSize, Map<String, String> conditionForm)
			throws ScubeBizException, FlowsharpException {
		String processId = conditionForm.get("processId");
		if (StringUtils.isEmpty(processId)) {
			throw new ScubeBizException("缺少参数processId");
		}
		List<Map<String, Object>> response = new ArrayList<Map<String, Object>>();
		Page taskPage = taskService.getUnTakeTask("", processId, pageNo, pageSize);
		if (null != taskPage && taskPage.getRecords().size() > 0) {
			BSysTask bSysTask = JSON.parseObject(taskPage.getRecords().get(0).toString(), new TypeReference<BSysTask>() {
			});
			if (null != bSysTask) {
				String taskDesId = bSysTask.getTaskId();
				// log.info("=========================>>>当前任务taskDesId:"+taskDesId);
				String taskName = "";
				String modelId = "";
				String nodeId = "";
				NodeEntity nodeEntity = processService.getCurrentNodeEntity(bSysTask.getProcessId());// 根据processId取出节点ID
				if (null != nodeEntity) {
					nodeId = nodeEntity.getId();
					// log.info("=========================>>>当前节点nodeId:"+nodeId);
				}
				Map<String, Object> taskDesMap = websiteService.getTaskDes(pageNo, pageSize, taskDesId, taskName, modelId, nodeId);
				if (null != taskDesMap && taskDesMap.size() > 0) {
					List<Map<String, String>> taskDesList = (List<Map<String, String>>) taskDesMap.get("records");
					if (null != taskDesList && taskDesList.size() > 0) {
						String users = taskDesList.get(0).get("userIds");
						String[] userArray = users.split(",");
						for (int i = 0; i < userArray.length; i++) {
							Map<String, Object> tempMap = new HashMap<String, Object>();
							String userNo = userArray[i];
							tempMap.put("userNo", userNo);
							UserInfo userInfo = scubeUserService.selectUserByTlrNo(userNo, ScfCommonUtil.getBrManagerNo(scubeUserService));
							if (null != userInfo) {
								tempMap.put("userName", userInfo.getTlrName());
							}
							BctlVO bctl = scubeUserService.selectBctlByTlrNo(userNo, ScfCommonUtil.getBrManagerNo(scubeUserService));
							if (null != bctl) {
								tempMap.put("brNo", bctl.getBrNo());
								tempMap.put("brName", bctl.getBrName());
							}
							response.add(tempMap);
						}
					}
				}
			}

		}
		return response;
	}

	/**
	 * 根据appno获取基本节点审批意见
	 * @param pageNo
	 * @param pageSize
	 * @param appno
	 * @param flag 排序方式（1：正序排列，2：倒序排列）
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月10日下午3:23:08
	 */
	@SuppressWarnings({ "rawtypes" })
	@Override
	public Page getBaseNodeAttitudeByAppno(int pageNo, int pageSize, String appno, String processId, String flag)
	{
		if(StringUtil.isEmpty(flag))
		{
			throw new ScubeBizException("排序方式丢失！");
		}
		if(StringUtil.isEmpty(appno))
		{
			throw new ScubeBizException("业务申请编号丢失！");
		}
		Page page = new Page(pageSize, pageNo, 0);
		if(StringUtil.isEmpty(processId))
		{
			BPbcAppliBaseInfo appliBaseInfo = bpbcapplibaseinfoservice.findBPbcAppliBaseInfoByKey(appno);
			processId = appliBaseInfo.getPiid();
		}
		Map<String, Object> omap = new HashMap<String, Object>();
		BSysApplyDtlExample example = new BSysApplyDtlExample();
		BSysApplyDtlExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(appno);
		List<BSysApplyDtl> list = bsysapplydtldao.selectByExample(example);
		if(list!=null&&list.size()>0)
		{
			BSysApplyDtl applyDtl = list.get(0);
			String taskName = applyDtl.getMisc();//任务名称
			String taskComment = applyDtl.getReason();//审批意见
			String name5 = "";//处理人
			String assignId = applyDtl.getTlsrno();//处理人编号
			UserInfo info = scubeUserService.selectUserByTlrNo(assignId, ScfCommonUtil.getBrManagerNo(scubeUserService));
			if(info!=null)
			{
				name5 = info.getTlrName();
			}
			String txdate = applyDtl.getTxdate();
			String usedate = txdate.substring(0, 4)+"-"+txdate.substring(4, 6)+"-"+txdate.substring(6,8);
			String dealTime = usedate + " " + applyDtl.getTxtime();//处理时间
			
			omap.put("taskName", taskName);
			omap.put("taskComment", taskComment);
			omap.put("name5", name5);
			omap.put("assignId", assignId);
			omap.put("dealTime", dealTime);
		}
		List tasklist = new ArrayList();
		List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
		try
		{
			tasklist = taskService.getTaskByProcessId(processId);
		}catch (FlowsharpException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(omap!=null&&omap.size()>0)
		{
			dataList.add(omap);
		}
		if(tasklist!=null&&tasklist.size()>0)
		{
			for(int i=0;i<tasklist.size();i++)
			{
				Task task = (Task) tasklist.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("taskName", task.getTaskName());
				map.put("taskComment", task.getTaskComment());
				map.put("name5", task.getName5());
				map.put("assignId", task.getAssignId());
				map.put("dealTime", task.getDealTime());
				if(!StringUtil.isEmpty(task.getDealTime()))
				{
					dataList.add(map);
				}
			}
		}
		List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
		resultList = this.getComparedMap(dataList,resultList,flag);
		// 根据返回的list 分页
		int totalRecord = resultList.size(); // 总条数
		int t = totalRecord / pageSize;
		int totalPage = totalRecord % pageSize != 0 ? ++t : t; // 总页数
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		if(totalRecord > 0)
		{
			if(pageNo <= totalPage)
			{
				if(pageNo == 1)
				{
					if(totalRecord <= pageSize)
					{
						result = resultList.subList(0, totalRecord);
					}
					else
					{
						result = resultList.subList(0, pageSize);
					}
				}
				else
				{
					int start = (pageNo - 1) * pageSize;
					int end = pageNo * pageSize;
					if((totalRecord - end) % pageSize >= 0)
					{
						end = pageNo * pageSize;
					}
					else
					{
						end = (pageNo - 1) * pageSize + totalRecord % pageSize;
					}
					if(totalRecord >= end)
					{
						result = resultList.subList(start, end);
					}
					else
					{
						result = null;
					}

				}

			}
		}
		page.setRecords(result);
		page.setTotal(totalRecord);
		page.setTotalPage(totalPage);
		
		return page;
	}
	
	/**
	 * 获取排序后结果（时间倒叙排列）
	 * @param dataList
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月10日下午2:42:34
	 */
	public List<Map<String, Object>> getComparedMap(List<Map<String, Object>> dataList, List<Map<String, Object>> resultList, String flag)
	{
		if(dataList!=null&&dataList.size()>0)
		{
			Map<String, Object> index = new HashMap<String, Object>();
			Map<String, Object> maps = new HashMap<String, Object>();
			if(dataList.size()==1)
			{
				index = dataList.get(0);
			}
			else if(dataList.size()==2)
			{
				index = dataList.get(0);//初始值（集合第一个）
				maps = dataList.get(1);
				index = compare(index, maps, flag);
			}
			else
			{
				for(int i=0;i<dataList.size()-1;i++)
				{
					int m = i;
					if(i==0)
					{
						index = dataList.get(m);//初始值（集合第一个）
						maps = dataList.get(m+1);
					}
					else
					{
						m = i+1;
						maps = dataList.get(m);
					}
					if(m<=dataList.size()-1)
					{
						index = compare(index, maps, flag);
					}
				}
			}
			dataList.remove(index);    
			resultList.add(index);
			resultList = getComparedMap(dataList, resultList, flag);
		}
		return resultList;
	}
	
	/**
	 * 时间先后比较
	 * @param mapf
	 * @param maps
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年7月10日下午2:42:55
	 */
	public Map<String, Object> compare(Map<String, Object> mapf, Map<String, Object> maps, String flag)
	{
		String dealTimef = mapf.get("dealTime").toString();
		String dealTimes = maps.get("dealTime").toString();
		int result = dealTimef.compareToIgnoreCase(dealTimes);
		if(ScfBasConstant.ORACLE_ASC.equals(flag))
		{//正序排列，时间从早到晚
			if(result>=0)
			{
				return maps;
			}
			else
			{
				return mapf;
			}
		}
		else if(ScfBasConstant.ORACLE_DESC.equals(flag))
		{//倒叙排泄，时间从晚到早
			if(result>=0)
			{
				return mapf;
			}
			else
			{
				return maps;
			}
		}
		return null;
	}
}

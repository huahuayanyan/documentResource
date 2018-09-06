/**
 * 
 */
package com.huateng.scf.bas.common.service;

import java.util.HashMap;
import java.util.Map;

import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.flowsharp.entity.ProcessEntity;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 供应链工作流业务接口
 * </p>
 *
 * @author huangshuidan
 * @date 2016年12月29日 下午7:26:50
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月29日下午7:26:50             新增
 *
 *            </pre>
 */
public interface IScfWorkFlowService {
	public static final String BEAN_ID = "scfWorkFlowService";

	/**
	 * 发起工作流<br>
	 * 1.调用工作流发起接口；<br>
	 * 2.供应链发起工作流公共处理；<br>
	 * 
	 * @param appNo
	 * @param workApplyType
	 * @param flowName
	 * @param paramMap
	 * @return
	 * @throws ScubeBizException
	 */
	public ProcessEntity startWorkFlow(@ScubeParam("appNo") String appNo, @ScubeParam("workApplyType") String workApplyType,
			@ScubeParam("flowName") String flowName, @ScubeParam("paramMap") Map<String, Object> paramMap)
					throws ScubeBizException, FlowsharpException;

	/**
	 * 发起流程
	 * 
	 * @param bussAppno
	 * @param workflowBussType
	 * @param flowName
	 * @param paramMap
	 * @return
	 */
	public ProcessEntity commonStartFlow(@ScubeParam("bussAppno") String bussAppno, @ScubeParam("workflowBussType") String workflowBussType,
			@ScubeParam("flowName") String flowName, @ScubeParam("paramMap") HashMap<String, Object> paramMap) throws FlowsharpException;

	/**
	 * 流程跳转
	 * 
	 * @param applibaseinfo
	 * @param attitude
	 */
	public void processTasks(@ScubeParam("applibaseinfo") BPbcAppliBaseInfo applibaseinfo, @ScubeParam("attitude") String attitude)
			throws FlowsharpException;

	/**
	 * 
	 * @param appno
	 * @param vidPrdId
	 * @return
	 */
	public BPbcAppliBaseInfo findBPbcAppliBaseInfoByAppno(@ScubeParam("appno") String appno, @ScubeParam("process") String process);

	/**
	 * 用于页面提交按钮中的领取任务节点，跳转下一任务节点， 书写 “发起流程”审批意见，修改申请基本信息申请状态等
	 * 
	 * @param appno
	 * @param vidPrdId
	 * @return
	 */
	public void takeTaskAndRelated(@ScubeParam("appno") String appno);

	/**
	 * 流程跳转
	 * 
	 * @param applibaseinfo
	 * @param attitude
	 */
	public void processTask(@ScubeParam("applibaseinfo") BPbcAppliBaseInfo applibaseinfo, @ScubeParam("attitude") String attitude,
			@ScubeParam("paramMap") Map<String, Object> paramMap) throws FlowsharpException;

	/**
	 * 供应链放款业务 获取工作流信息
	 * 
	 * @param mastContno
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月23日上午10:15:06
	 */
	public HashMap<String, String> getWkflowMode(@ScubeParam("mastContno") String mastContno) throws ScubeBizException;

	/**
	 * 新应收类发起工作流<br>
	 * 1.调用工作流发起接口；<br>
	 * 2.供应链发起工作流公共处理；<br>
	 * 
	 * @param appNo
	 * @param workApplyType
	 * @param paramMap
	 * @return
	 * @throws ScubeBizException
	 */
	public ProcessEntity NstartWorkFlow(@ScubeParam("bussAppno") String bussAppno, @ScubeParam("workflowBussType") String workflowBussType,
			@ScubeParam("paramMap") HashMap<String, Object> paramMap) throws ScubeBizException, FlowsharpException;

	/**
	 * 根据modeleId查询第一个节点 并校验基本节点
	 */
	public String getFirstNodeByModelId(@ScubeParam("key") String modelId) throws ScubeBizException, FlowsharpException;

	/**
	 * 基本节点跳转（用于第一个节点的跳转）
	 */
	public void basicNodeJump(@ScubeParam("value") BPbcAppliBaseInfo bPbcAppliBaseInfo) throws ScubeBizException, FlowsharpException;

	/**
	 * 退回提交公用方法（修改申请基本信息状态，并且使用基本节点提交方法。）
	 */
	public void backSubmitCommon(@ScubeParam("value") BPbcAppliBaseInfo bPbcAppliBaseInfo) throws ScubeBizException, FlowsharpException;
	
	/**
	 * 添加基本节点后，考虑到退回操作流程跳转及发起流程判断方法
	 * @param appliBaseInfo
	 * @author 	mengjiajia
	 * @date 	2017年6月12日下午4:24:47
	 */
	public void FactoringProcessDone(@ScubeParam("appliBaseInfo") BPbcAppliBaseInfo appliBaseInfo);

	/**
	 * 特殊路径调用
	 * @param appNo
	 * @param invokPhase
	 * @param callerpath
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月19日下午4:13:10
	 */
	public boolean invokAnotherClasspath(@ScubeParam("appNo") String appNo,@ScubeParam("invokPhase") String invokPhase,@ScubeParam("callerpath") String callerpath);

}

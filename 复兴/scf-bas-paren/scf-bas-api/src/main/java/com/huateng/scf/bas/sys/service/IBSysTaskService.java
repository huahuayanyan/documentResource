/**
 * 
 */
package com.huateng.scf.bas.sys.service;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.sys.dao.model.BSysTask;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 待办任务接口
 * </p>
 *
 * @author huangshuidan
 * @date 2016年11月12日上午11:26:13
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月12日上午11:26:13	                                 新增
 *
 *            </pre>
 */
public interface IBSysTaskService {
	/**
	 * 分页查询待办任务
	 * 
	 * @param pageNo
	 *            int-当前页码
	 * @param pageSize
	 *            int-每页大小
	 * @param bSysTask
	 *            BSysTask对象
	 * @return Page对象
	 */
	public Page queryTaskListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("bSysTask") BSysTask bSysTask)
			throws ScubeBizException, FlowsharpException;
	
	/**
	 * 统计审批通过，已驳回，已拒绝的笔数
	 * @param value
	 * @return
	 * @throws ScubeBizException
	 * @throws FlowsharpException
	 * @return Map<String,Object>
	 */
	public Map<String, Object> queryTaskDtlCount(@ScubeParam("value") Map<String, Object> value)
			throws ScubeBizException, FlowsharpException;	

	/**
	 * 取消任务
	 * 
	 * @param processId
	 *            String-流程实例ID
	 * @throws ScubeBizException
	 */
	public void cancelTask(@ScubeParam("processId") String processId, @ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 流程结束处理
	 * 
	 * @param comment
	 *            String-审批结果
	 * @param appNo
	 *            String-业务流水号
	 * @param processId
	 *            String-流程实例ID
	 * @throws ScubeBizException
	 */
	public void bizProcess(@ScubeParam("comment") String comment, @ScubeParam("appNo") String appNo, @ScubeParam("processId") String processId,
			@ScubeParam("modelId") String modelId, @ScubeParam("flag") String flag, @ScubeParam("bizData") String[] bizData)
					throws ScubeBizException, FlowsharpException;

	/**
	 * 领取任务，完成任务，跳转节点
	 * 
	 * @param comment
	 *            String-审批结果
	 * @param appNo
	 *            String-业务流水号
	 * @param processId
	 *            String-流程实例ID
	 * @throws ScubeBizException
	 *             taskId, processId, userId, comment, bizData
	 */
	public void takeTaskAndJumpNode(@ScubeParam("taskId") String taskId, @ScubeParam("processId") String processId, @ScubeParam("node") String node,
			@ScubeParam("comment") String comment, @ScubeParam("bizData") String[] bizData) throws ScubeBizException, FlowsharpException;

	/**
	 * 流程中的审批提交处理
	 * 
	 * @param comment
	 *            String-审批结果
	 * @param appNo
	 *            String-业务流水号
	 * @param processId
	 *            String-流程实例ID
	 * @throws ScubeBizException
	 */
	public void flowSumbitProcess(@ScubeParam("comment") String comment, @ScubeParam("appNo") String appNo, @ScubeParam("processId") String processId,
			@ScubeParam("modelId") String modelId, @ScubeParam("bizData") String[] bizData) throws ScubeBizException, FlowsharpException;

	/**
	 * 分页查询 流程进度查询
	 */
	public Page queryWFProcessByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("conditionForm") Map<String, String> conditionForm) throws ScubeBizException, FlowsharpException;

	/**
	 * 流程进度查询——查看待办人员
	 */
	public List<Map<String, Object>> queryWFProcessTlrList(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("conditionForm") Map<String, String> conditionForm) throws ScubeBizException, FlowsharpException;

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
	public Page getBaseNodeAttitudeByAppno(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("appno") String appno,@ScubeParam("processId") String processId,@ScubeParam("flag") String flag);

}

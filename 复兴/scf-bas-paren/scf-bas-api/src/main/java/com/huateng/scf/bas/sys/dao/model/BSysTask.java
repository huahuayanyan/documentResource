/**
 * 
 */
package com.huateng.scf.bas.sys.dao.model;

import java.io.Serializable;

/**
 * <p>待办任务</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月12日上午10:43:14
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月12日上午10:43:14	                                 新增
 *
 * </pre>
 */
public class BSysTask implements Serializable{
	private static final long serialVersionUID = -1029190482683628208L;
	private String taskId;
	private String taskName;
	private int taskFlag;
	private String assignId;
	private String taskDescription;
	private String taskComment;
	private int isSkiped;
	private String processId;
	private String nodeId;
	private String takedTime;
	private String dealTime;
	private String createTime;
	
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	private String name5;
	private String name6;
	private String name7;
	private String name8;
	
	private String custcd;//客户号
	private String orgName;//发起机构
	private String custName;//客户名称
	private String appNo;//申请编号
	private String modelId;//流程模板ID
	private String pageUrl;//页面URL地址
	private String processName;//流程名称
    private String nodeButton;//任务节点按钮
	
	public BSysTask() {
		
	}
	public BSysTask(String taskId, String taskName, int taskFlag, String assignId, String taskDescription,
			String taskComment, int isSkiped, String processId, String nodeId, String takedTime, String dealTime,
			String createTime, String name1, String name2, String name3, String name4, String name5, String name6,
			String name7, String name8) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskFlag = taskFlag;
		this.assignId = assignId;
		this.taskDescription = taskDescription;
		this.taskComment = taskComment;
		this.isSkiped = isSkiped;
		this.processId = processId;
		this.nodeId = nodeId;
		this.takedTime = takedTime;
		this.dealTime = dealTime;
		this.createTime = createTime;
		this.name1 = name1;
		this.name2 = name2;
		this.name3 = name3;
		this.name4 = name4;
		this.name5 = name5;
		this.name6 = name6;
		this.name7 = name7;
		this.name8 = name8;
	}
	/**
	 * @return the taskId
	 */
	public String getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * @return the taskFlag
	 */
	public int getTaskFlag() {
		return taskFlag;
	}
	/**
	 * @param taskFlag the taskFlag to set
	 */
	public void setTaskFlag(int taskFlag) {
		this.taskFlag = taskFlag;
	}
	/**
	 * @return the assignId
	 */
	public String getAssignId() {
		return assignId;
	}
	/**
	 * @param assignId the assignId to set
	 */
	public void setAssignId(String assignId) {
		this.assignId = assignId;
	}
	/**
	 * @return the taskDescription
	 */
	public String getTaskDescription() {
		return taskDescription;
	}
	/**
	 * @param taskDescription the taskDescription to set
	 */
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	/**
	 * @return the taskComment
	 */
	public String getTaskComment() {
		return taskComment;
	}
	/**
	 * @param taskComment the taskComment to set
	 */
	public void setTaskComment(String taskComment) {
		this.taskComment = taskComment;
	}
	/**
	 * @return the isSkiped
	 */
	public int getIsSkiped() {
		return isSkiped;
	}
	/**
	 * @param isSkiped the isSkiped to set
	 */
	public void setIsSkiped(int isSkiped) {
		this.isSkiped = isSkiped;
	}
	/**
	 * @return the processId
	 */
	public String getProcessId() {
		return processId;
	}
	/**
	 * @param processId the processId to set
	 */
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	/**
	 * @return the nodeId
	 */
	public String getNodeId() {
		return nodeId;
	}
	/**
	 * @param nodeId the nodeId to set
	 */
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	/**
	 * @return the takedTime
	 */
	public String getTakedTime() {
		return takedTime;
	}
	/**
	 * @param takedTime the takedTime to set
	 */
	public void setTakedTime(String takedTime) {
		this.takedTime = takedTime;
	}
	/**
	 * @return the dealTime
	 */
	public String getDealTime() {
		return dealTime;
	}
	/**
	 * @param dealTime the dealTime to set
	 */
	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the name1
	 */
	public String getName1() {
		return name1;
	}
	/**
	 * @param name1 the name1 to set
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}
	/**
	 * @return the name2
	 */
	public String getName2() {
		return name2;
	}
	/**
	 * @param name2 the name2 to set
	 */
	public void setName2(String name2) {
		this.name2 = name2;
	}
	/**
	 * @return the name3
	 */
	public String getName3() {
		return name3;
	}
	/**
	 * @param name3 the name3 to set
	 */
	public void setName3(String name3) {
		this.name3 = name3;
	}
	/**
	 * @return the name4
	 */
	public String getName4() {
		return name4;
	}
	/**
	 * @param name4 the name4 to set
	 */
	public void setName4(String name4) {
		this.name4 = name4;
	}
	/**
	 * @return the name5
	 */
	public String getName5() {
		return name5;
	}
	/**
	 * @param name5 the name5 to set
	 */
	public void setName5(String name5) {
		this.name5 = name5;
	}
	/**
	 * @return the name6
	 */
	public String getName6() {
		return name6;
	}
	/**
	 * @param name6 the name6 to set
	 */
	public void setName6(String name6) {
		this.name6 = name6;
	}
	/**
	 * @return the name7
	 */
	public String getName7() {
		return name7;
	}
	/**
	 * @param name7 the name7 to set
	 */
	public void setName7(String name7) {
		this.name7 = name7;
	}
	/**
	 * @return the name8
	 */
	public String getName8() {
		return name8;
	}
	/**
	 * @param name8 the name8 to set
	 */
	public void setName8(String name8) {
		this.name8 = name8;
	}
	/**
	 * @return the custcd
	 */
	public String getCustcd() {
		return custcd;
	}
	/**
	 * @param custcd the custcd to set
	 */
	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}
	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}
	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	/**
	 * @return the appNo
	 */
	public String getAppNo() {
		return appNo;
	}
	/**
	 * @param appNo the appNo to set
	 */
	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}
	/**
	 * @return the modelId
	 */
	public String getModelId() {
		return modelId;
	}
	/**
	 * @param modelId the modelId to set
	 */
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	/**
	 * @return the pageUrl
	 */
	public String getPageUrl() {
		return pageUrl;
	}
	/**
	 * @param pageUrl the pageUrl to set
	 */
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	/**
	 * @return the processName
	 */
	public String getProcessName() {
		return processName;
	}
	/**
	 * @param processName the processName to set
	 */
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getNodeButton() {
		return nodeButton;
	}
	public void setNodeButton(String nodeButton) {
		this.nodeButton = nodeButton;
	}
	
	
	
	
}

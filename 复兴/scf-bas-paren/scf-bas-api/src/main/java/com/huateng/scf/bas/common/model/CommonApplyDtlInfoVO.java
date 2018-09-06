/*
 * 功  能：简单说明该类的功能
 * 文件名：CommonApplyDtlInfoVO.java
 * 描  述：
 * Version   变更日         部署              作者           变更内容
 * -----------------------------------------------------------------------------
 * V1.00     2010-11-17    huateng        jimmy.peng          create
 * -----------------------------------------------------------------------------
 * Copyright (c) 2010 huateng  All Rights Reserved.
 */

package com.huateng.scf.bas.common.model;

/**
 * 流程审批意见VO
 * <p>
 * <a href="CommonApplyDtlInfoVO.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:jimmy.peng@huateng.com">jimmy.peng</a>
 * @version Revision: 1.0 Date: 2010-11-17 下午02:37:52
 * 
 */

public class CommonApplyDtlInfoVO {

	private String appno;
	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}

	private String attitude;// 审批结果
	private String attitudeIn;// 审批结果输入,LIST:Agree,同意;GoBack,退回
	private String reason;// 审批意见
	private String reasonIn;// 审批意见输入
	private String attitudeInNew;// 审批结果输入,LIST:Agree,同意;Refuse,否决;GoBack,退回
	private String workflowAppno;// 工作流申请号
	private int roleId;// 岗位
	private String procInsId; // 流程实例ID
	private String taskId; // 岗位ID
	private String bussAppno; // 业务申请ID
	private String comment; // 岗位留言
	private String appliStatusDtl;// 流程明细状态

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the procInsId
	 */
	public String getProcInsId() {
		return procInsId;
	}

	/**
	 * @param procInsId
	 *            the procInsId to set
	 */
	public void setProcInsId(String procInsId) {
		this.procInsId = procInsId;
	}

	/**
	 * @return the taskId
	 */
	public String getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId
	 *            the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getAttitude() {
		return attitude;
	}

	public void setAttitude(String attitude) {
		this.attitude = attitude;
	}

	public String getAttitudeIn() {
		return attitudeIn;
	}

	public void setAttitudeIn(String attitudeIn) {
		this.attitudeIn = attitudeIn;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReasonIn() {
		return reasonIn;
	}

	public void setReasonIn(String reasonIn) {
		this.reasonIn = reasonIn;
	}

	/**
	 * @return the workflowAppno
	 */
	public String getWorkflowAppno() {
		return workflowAppno;
	}

	/**
	 * @param workflowAppno
	 *            the workflowAppno to set
	 */
	public void setWorkflowAppno(String workflowAppno) {
		this.workflowAppno = workflowAppno;
	}

	/**
	 * @return the bussAppno
	 */
	public String getBussAppno() {
		return bussAppno;
	}

	/**
	 * @param bussAppno
	 *            the bussAppno to set
	 */
	public void setBussAppno(String bussAppno) {
		this.bussAppno = bussAppno;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getAttitudeInNew() {
		return attitudeInNew;
	}

	public void setAttitudeInNew(String attitudeInNew) {
		this.attitudeInNew = attitudeInNew;
	}

	public String getAppliStatusDtl() {
		return appliStatusDtl;
	}

	public void setAppliStatusDtl(String appliStatusDtl) {
		this.appliStatusDtl = appliStatusDtl;
	}

}

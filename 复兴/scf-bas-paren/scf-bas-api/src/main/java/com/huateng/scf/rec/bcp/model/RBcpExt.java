package com.huateng.scf.rec.bcp.model;

import java.math.BigDecimal;

import com.huateng.scf.bas.common.model.ScfBaseModel;

public class RBcpExt extends ScfBaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String startTaskDate;
	private String startTlrcdName;
	private String startBrcodeName;
	
	public String getStartTaskDate() {
		return startTaskDate;
	}
	public void setStartTaskDate(String startTaskDate) {
		this.startTaskDate = startTaskDate;
	}
	public String getStartTlrcdName() {
		return startTlrcdName;
	}
	public void setStartTlrcdName(String startTlrcdName) {
		this.startTlrcdName = startTlrcdName;
	}
	public String getStartBrcodeName() {
		return startBrcodeName;
	}
	public void setStartBrcodeName(String startBrcodeName) {
		this.startBrcodeName = startBrcodeName;
	}
	
	/**
	 * CHAR(8)<br>
	 * 最迟付款日
	 */
	private String deadline;
	
	/**
	 * DECIMAL(22)<br>
	 * 宽限期
	 */
	private BigDecimal gracePeriod;

	/**
	 * CHAR(1)<br>
	 * 理赔状态
	 */
	private String claimStatus;
	
	/**
     * VARCHAR(250)<br>
     * 模板名
     */
    private String processTemplateName;
	
	/**
     * VARCHAR(100) 必填<br>
     * 借据号/承兑协议号
     */
    private String debetId;

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public BigDecimal getGracePeriod() {
		return gracePeriod;
	}

	public void setGracePeriod(BigDecimal gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getDebetId() {
		return debetId;
	}

	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}

	public String getProcessTemplateName() {
		return processTemplateName;
	}

	public void setProcessTemplateName(String processTemplateName) {
		this.processTemplateName = processTemplateName;
	}
	
}

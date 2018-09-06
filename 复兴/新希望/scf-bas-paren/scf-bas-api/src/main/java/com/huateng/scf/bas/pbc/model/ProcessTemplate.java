package com.huateng.scf.bas.pbc.model;

import java.util.Date;

public class ProcessTemplate {
	private String processTemplateName;//流程名称
	
	private String startTime;//申请发起时间
	
	private String startTlrNm;//经办人
	
	private String startBrName;//startBrName

	public String getProcessTemplateName() {
		return processTemplateName;
	}

	public void setProcessTemplateName(String processTemplateName) {
		this.processTemplateName = processTemplateName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStartTlrNm() {
		return startTlrNm;
	}

	public void setStartTlrNm(String startTlrNm) {
		this.startTlrNm = startTlrNm;
	}

	public String getStartBrName() {
		return startBrName;
	}

	public void setStartBrName(String startBrName) {
		this.startBrName = startBrName;
	}

	@Override
	public String toString() {
		return "ProcessTemplate [processTemplateName=" + processTemplateName + ", startTime=" + startTime
				+ ", startTlrNm=" + startTlrNm + ", startBrName=" + startBrName + "]";
	}

}

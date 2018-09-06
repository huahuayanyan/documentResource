package com.huateng.scf.bas.pbc.model;

public class QualityApplyDO {
	
	private String prtclNo;//监管合同号
	
	private String conId;//抵质押合同号
	
	private String gutId;//担保人号
	
	private String appNo;//申请编号

	public String getPrtclNo() {
		return prtclNo;
	}

	public void setPrtclNo(String prtclNo) {
		this.prtclNo = prtclNo;
	}

	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}

	public String getGutId() {
		return gutId;
	}

	public void setGutId(String gutId) {
		this.gutId = gutId;
	}

	public String getAppNo() {
		return appNo;
	}

	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}

	@Override
	public String toString() {
		return "QualityApplyDO [prtclNo=" + prtclNo + ", conId=" + conId + ", gutId=" + gutId + ", appNo=" + appNo
				+ "]";
	}

}

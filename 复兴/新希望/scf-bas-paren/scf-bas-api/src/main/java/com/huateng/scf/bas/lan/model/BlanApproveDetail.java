package com.huateng.scf.bas.lan.model;

import java.math.BigDecimal;

public class BlanApproveDetail {
	private String appno;
	private String debetId;
	private String mastContno;
	private String vidNo;
	private String vidBusTyp;
	private String custName;
	private BigDecimal lnAmt;
	private BigDecimal lnSum;
	private String ext1;
	private BigDecimal amt;
	private String status;
	private String piid;
	
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public String getDebetId() {
		return debetId;
	}
	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}
	public String getMastContno() {
		return mastContno;
	}
	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}
	public String getVidNo() {
		return vidNo;
	}
	public void setVidNo(String vidNo) {
		this.vidNo = vidNo;
	}
	public String getVidBusTyp() {
		return vidBusTyp;
	}
	public void setVidBusTyp(String vidBusTyp) {
		this.vidBusTyp = vidBusTyp;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public BigDecimal getLnAmt() {
		return lnAmt;
	}
	public void setLnAmt(BigDecimal lnAmt) {
		this.lnAmt = lnAmt;
	}
	public BigDecimal getLnSum() {
		return lnSum;
	}
	public void setLnSum(BigDecimal lnSum) {
		this.lnSum = lnSum;
	}
	public String getExt1() {
		return ext1;
	}
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	public BigDecimal getAmt() {
		return amt;
	}
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPiid() {
		return piid;
	}
	public void setPiid(String piid) {
		this.piid = piid;
	}
	
}

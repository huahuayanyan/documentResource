package com.huateng.scf.bas.pbc.dao.model;

public class BPbcHkDetail {
	private String conId;//质押合同号
	private String prtclBrNm;//监管公司名称
	private String cname;//出质人名称
	private String vidPrdId;//业务品种
	private String moniWarehouseType;//监管模式
	private String appDate;//核库日期
	private String results;//核库结果
	private String tlrcd;//核库负责人--代码
	private String brname;//核库机构
	private String status;//处理状态
	
	public String getConId() {
		return conId;
	}
	public void setConId(String conId) {
		this.conId = conId;
	}
	public String getPrtclBrNm() {
		return prtclBrNm;
	}
	public void setPrtclBrNm(String prtclBrNm) {
		this.prtclBrNm = prtclBrNm;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getVidPrdId() {
		return vidPrdId;
	}
	public void setVidPrdId(String vidPrdId) {
		this.vidPrdId = vidPrdId;
	}
	public String getMoniWarehouseType() {
		return moniWarehouseType;
	}
	public void setMoniWarehouseType(String moniWarehouseType) {
		this.moniWarehouseType = moniWarehouseType;
	}
	public String getAppDate() {
		return appDate;
	}
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	public String getResults() {
		return results;
	}
	public void setResults(String results) {
		this.results = results;
	}
	public String getTlrcd() {
		return tlrcd;
	}
	public void setTlrcd(String tlrcd) {
		this.tlrcd = tlrcd;
	}
	public String getBrname() {
		return brname;
	}
	public void setBrname(String brname) {
		this.brname = brname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

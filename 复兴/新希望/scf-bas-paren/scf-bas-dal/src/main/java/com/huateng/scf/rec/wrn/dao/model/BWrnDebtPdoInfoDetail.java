package com.huateng.scf.rec.wrn.dao.model;


public class BWrnDebtPdoInfoDetail extends BWrnDebtPdoInfo{
	private static final long serialVersionUID = 1L;
	private String khjl;//客户经理
	private String jbjg;//经办机构
	private String startYj;
	private String endYj;
	private String billsNo;
	private String bussContcode;
	private String brcode;
	private String custManager;
	public String getKhjl() {
		return khjl;
	}
	public void setKhjl(String khjl) {
		this.khjl = khjl;
	}
	public String getJbjg() {
		return jbjg;
	}
	public void setJbjg(String jbjg) {
		this.jbjg = jbjg;
	}
	public String getStartYj() {
		return startYj;
	}
	public void setStartYj(String startYj) {
		this.startYj = startYj;
	}
	public String getEndYj() {
		return endYj;
	}
	public void setEndYj(String endYj) {
		this.endYj = endYj;
	}
	public String getBillsNo() {
		return billsNo;
	}
	public void setBillsNo(String billsNo) {
		this.billsNo = billsNo;
	}
	public String getBussContcode() {
		return bussContcode;
	}
	public void setBussContcode(String bussContcode) {
		this.bussContcode = bussContcode;
	}
	public String getBrcode() {
		return brcode;
	}
	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}
	public String getCustManager() {
		return custManager;
	}
	public void setCustManager(String custManager) {
		this.custManager = custManager;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

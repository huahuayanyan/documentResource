package com.huateng.scf.rec.wrn.model;

public class BWrnRiskOfInfoDetail extends BWrnRiskOfInfo{
	private static final long serialVersionUID = 1L;
	private String warnDate;//预警日期
	private String khjl;//客户经理
	private String jbjg;//经办机构
	private String startYj;//预警日期从
	private String endYj;//预警日期到
	
	public String getWarnDate() {
		return warnDate;
	}
	public void setWarnDate(String warnDate) {
		this.warnDate = warnDate;
	}
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

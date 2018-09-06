package com.huateng.scf.rec.nte.dao.model;

import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;

public class BNteNoticeBaseCon extends BNteNoticeBase{
	
	private String sallerName;//卖方名称
	private String startQf;//签发日期开始
	private String endQf;//签发日期结束
	private String startHz;//回执日期开始
	private String endHz;//回执日期结束
	private String khjl;
	private String jbjg;
	public String getSallerName() {
		return sallerName;
	}
	public void setSallerName(String sallerName) {
		this.sallerName = sallerName;
	}
	public String getStartQf() {
		return startQf;
	}
	public void setStartQf(String startQf) {
		this.startQf = startQf;
	}
	public String getEndQf() {
		return endQf;
	}
	public void setEndQf(String endQf) {
		this.endQf = endQf;
	}
	public String getStartHz() {
		return startHz;
	}
	public void setStartHz(String startHz) {
		this.startHz = startHz;
	}
	public String getEndHz() {
		return endHz;
	}
	public void setEndHz(String endHz) {
		this.endHz = endHz;
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
	
}

package com.huateng.scf.bas.crg.model;

import com.huateng.scf.bas.crg.dao.model.BCrgEvalRec;

public class ExtBCrgEval extends BCrgEvalRec {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tlrNm;
	
	private String brNm;
	
	private String lastUpdTlrNm;
	
	private String lstUpdBrNm;

	/**
	 * 客户名称
	 */
	private String cname;
	
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getTlrNm() {
		return tlrNm;
	}

	public void setTlrNm(String tlrNm) {
		this.tlrNm = tlrNm;
	}

	public String getBrNm() {
		return brNm;
	}

	public void setBrNm(String brNm) {
		this.brNm = brNm;
	}

	public String getLastUpdTlrNm() {
		return lastUpdTlrNm;
	}

	public void setLastUpdTlrNm(String lastUpdTlrNm) {
		this.lastUpdTlrNm = lastUpdTlrNm;
	}

	public String getLstUpdBrNm() {
		return lstUpdBrNm;
	}

	public void setLstUpdBrNm(String lstUpdBrNm) {
		this.lstUpdBrNm = lstUpdBrNm;
	}
}

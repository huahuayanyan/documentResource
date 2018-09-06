package com.huateng.scf.bas.crr.model;

public class BCrrGntyConDetail extends BCrrGntyCon {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String czr;
	private String khjl;
	private String jbjg;
	private String vidPrdIdNm;// 业务品种名称

	public String getCzr() {
		return czr;
	}

	public void setCzr(String czr) {
		this.czr = czr;
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

	public String getVidPrdIdNm() {
		return vidPrdIdNm;
	}

	public void setVidPrdIdNm(String vidPrdIdNm) {
		this.vidPrdIdNm = vidPrdIdNm;
	}

}

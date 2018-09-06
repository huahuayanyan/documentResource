package com.huateng.scf.ods.dao.model;

import java.math.BigDecimal;

public class CooperPartnerInfo extends OCooperPartner {

	private static final long serialVersionUID = 1L;

	
    
    private String title;
    private BigDecimal value;
    
    private String cname;
    private String coopNm;


  
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the value
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * @return the coopNm
	 */
	public String getCoopNm() {
		return coopNm;
	}

	/**
	 * @param coopNm the coopNm to set
	 */
	public void setCoopNm(String coopNm) {
		this.coopNm = coopNm;
	}

}
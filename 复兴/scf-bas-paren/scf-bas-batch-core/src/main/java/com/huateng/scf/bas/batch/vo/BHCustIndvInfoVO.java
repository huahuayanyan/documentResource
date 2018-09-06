/*
 * 创建日期 2007-9-29
 * <p>Title: 交通银行个人贷款管理系统</p>
 * <p>Description: 批量模板</p>
 * @author pei
 * @version :2007-9-29 17:08:06
 */
package com.huateng.scf.bas.batch.vo;

import java.io.Serializable;
import java.util.Date;

public class BHCustIndvInfoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BHCustIndvInfoVO() {
		super();
	}

	private String custCd;

	private String sex;

	private String marrageType;

	private String technicalTitle;
	
	private String duty;
	
	private String companyOwnerType;
	
	private String occupation;
	
	private String education;

	/** persistent field */
	private String folk;

	/** nullable persistent field */
	private String hukouType;

	/** nullable persistent field */
	private String hukou;

	/** nullable persistent field */
	private String socialSecurityid;

	/** nullable persistent field */
	private String lncardno;

	/** nullable persistent field */
	private String peopleNm;

	/** nullable persistent field */
	private double indvIncomeMonth;

	/** nullable persistent field */
	private double homeIncomeYear;

	/** nullable persistent field */
	private String employeeType;

	/** nullable persistent field */
	private String custClass;

	/** nullable persistent field */
	private String creditClass;

	/** nullable persistent field */
	private int creditNm;

	/** nullable persistent field */
	private String payActno;

	/** nullable persistent field */
	private String payActnoOpbranch;

	/** nullable persistent field */
	private String denizen;

	/** nullable persistent field */
	private Date ltxdate;
	
	private String inCreditClass;

	/**
	 * @return
	 */
	public String getCreditClass() {
		return creditClass;
	}

	/**
	 * @return
	 */
	public int getCreditNm() {
		return creditNm;
	}

	/**
	 * @return
	 */
	public String getCustCd() {
		return custCd;
	}

	/**
	 * @return
	 */
	public String getCustClass() {
		return custClass;
	}

	/**
	 * @return
	 */
	public String getDenizen() {
		return denizen;
	}

	/**
	 * @return
	 */
	public String getEmployeeType() {
		return employeeType;
	}

	/**
	 * @return
	 */
	public String getFolk() {
		return folk;
	}

	/**
	 * @return
	 */
	public double getHomeIncomeYear() {
		return homeIncomeYear;
	}

	/**
	 * @return
	 */
	public String getHukou() {
		return hukou;
	}

	/**
	 * @return
	 */
	public String getHukouType() {
		return hukouType;
	}

	/**
	 * @return
	 */
	public double getIndvIncomeMonth() {
		return indvIncomeMonth;
	}

	/**
	 * @return
	 */
	public String getLncardno() {
		return lncardno;
	}

	/**
	 * @return
	 */
	public Date getLtxdate() {
		return ltxdate;
	}

	/**
	 * @return
	 */
	public String getPayActno() {
		return payActno;
	}

	/**
	 * @return
	 */
	public String getPayActnoOpbranch() {
		return payActnoOpbranch;
	}

	/**
	 * @return
	 */
	public String getPeopleNm() {
		return peopleNm;
	}

	/**
	 * @return
	 */
	public String getSocialSecurityid() {
		return socialSecurityid;
	}

	/**
	 * @param string
	 */
	public void setCreditClass(String string) {
		creditClass = string;
	}

	/**
	 * @param i
	 */
	public void setCreditNm(int i) {
		creditNm = i;
	}

	/**
	 * @param string
	 */
	public void setCustCd(String string) {
		custCd = string;
	}

	/**
	 * @param string
	 */
	public void setCustClass(String string) {
		custClass = string;
	}

	/**
	 * @param string
	 */
	public void setDenizen(String string) {
		denizen = string;
	}

	/**
	 * @param string
	 */
	public void setEmployeeType(String string) {
		employeeType = string;
	}

	/**
	 * @param string
	 */
	public void setFolk(String string) {
		folk = string;
	}

	/**
	 * @param d
	 */
	public void setHomeIncomeYear(double d) {
		homeIncomeYear = d;
	}

	/**
	 * @param string
	 */
	public void setHukou(String string) {
		hukou = string;
	}

	/**
	 * @param string
	 */
	public void setHukouType(String string) {
		hukouType = string;
	}

	/**
	 * @param d
	 */
	public void setIndvIncomeMonth(double d) {
		indvIncomeMonth = d;
	}

	/**
	 * @param string
	 */
	public void setLncardno(String string) {
		lncardno = string;
	}

	/**
	 * @param date
	 */
	public void setLtxdate(Date date) {
		ltxdate = date;
	}

	/**
	 * @param string
	 */
	public void setPayActno(String string) {
		payActno = string;
	}

	/**
	 * @param string
	 */
	public void setPayActnoOpbranch(String string) {
		payActnoOpbranch = string;
	}

	/**
	 * @param string
	 */
	public void setPeopleNm(String string) {
		peopleNm = string;
	}

	/**
	 * @param string
	 */
	public void setSocialSecurityid(String string) {
		socialSecurityid = string;
	}

	/**
	 * @return
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param string
	 */
	public void setSex(String string) {
		sex = string;
	}

	/**
	 * @return
	 */
	public String getMarrageType() {
		return marrageType;
	}

	/**
	 * @param string
	 */
	public void setMarrageType(String string) {
		marrageType = string;
	}

	/**
	 * @return
	 */
	public String getTechnicalTitle() {
		return technicalTitle;
	}

	/**
	 * @param string
	 */
	public void setTechnicalTitle(String string) {
		technicalTitle = string;
	}

	/**
	 * @return
	 */
	public String getDuty() {
		return duty;
	}

	/**
	 * @param string
	 */
	public void setDuty(String string) {
		duty = string;
	}

	/**
	 * @return
	 */
	public String getCompanyOwnerType() {
		return companyOwnerType;
	}

	/**
	 * @param string
	 */
	public void setCompanyOwnerType(String string) {
		companyOwnerType = string;
	}

	/**
	 * @return
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * @param string
	 */
	public void setOccupation(String string) {
		occupation = string;
	}

	/**
	 * @return
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * @param string
	 */
	public void setEducation(String string) {
		education = string;
	}

	/**
	 * @return
	 */
	public String getInCreditClass() {
		return inCreditClass;
	}

	/**
	 * @param string
	 */
	public void setInCreditClass(String string) {
		inCreditClass = string;
	}

}

/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.common.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 应收类借据通用查询条件VO
 *
 * @author <a href="mailto:zhangwu@topscf.com">zhangwu</a>
 *
 * @version Revision: 1.0 Date: 2013-5-7 下午03:31:28
 *
 */

public class DebtLnciQryVO extends CommonQryVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String debetNo;
	private String debetId;
	private String level;
	private Date startDate;
	private String beginDate;
	private Date startDate_from;
	private Date startDate_to;
	private Date endDate;
	private Date endDate_from;
	private Date endDate_to;
	private String appliStatusDtl; // 审批状态
	private String productType; // 业务中类
	private String factType; // 业务标志位
	private String supplyChainPdId;// 业务编号
	private String lnciType; // 出账方式
	private BigDecimal lnciBalFrom; // 借据余额 从
	private BigDecimal lnciBalTo; // 借据余额 到
	private String mgrno; // 客户经理
	private String blnUpBrcode;// 一级机构
	private String payBrcode;// 放款机构
	private String loanAppno;// 出账流水号
	private String bussinessno;// 业务合同号
	private String endDateFrom;
	private String endDateTo;
	/**
	 * CHAR(1)<br>
	 * 锁定标识：0-未锁定;1-锁定
	 */
	private String isLocked;

	/**
	 * @return the bussinessno
	 */
	public String getBussinessno() {
		return bussinessno;
	}

	/**
	 * @param bussinessno
	 *            the bussinessno to set
	 */
	public void setBussinessno(String bussinessno) {
		this.bussinessno = bussinessno;
	}

	public String getLoanAppno() {
		return loanAppno;
	}

	public void setLoanAppno(String loanAppno) {
		this.loanAppno = loanAppno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDebetNo() {
		return debetNo;
	}

	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}

	public String getDebetId() {
		return debetId;
	}

	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStartDate_from() {
		return startDate_from;
	}

	public void setStartDate_from(Date startDate_from) {
		this.startDate_from = startDate_from;
	}

	public Date getStartDate_to() {
		return startDate_to;
	}

	public void setStartDate_to(Date startDate_to) {
		this.startDate_to = startDate_to;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndDate_from() {
		return endDate_from;
	}

	public void setEndDate_from(Date endDate_from) {
		this.endDate_from = endDate_from;
	}

	public Date getEndDate_to() {
		return endDate_to;
	}

	public void setEndDate_to(Date endDate_to) {
		this.endDate_to = endDate_to;
	}

	public String getAppliStatusDtl() {
		return appliStatusDtl;
	}

	public void setAppliStatusDtl(String appliStatusDtl) {
		this.appliStatusDtl = appliStatusDtl;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getFactType() {
		return factType;
	}

	public void setFactType(String factType) {
		this.factType = factType;
	}

	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}

	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}

	public String getLnciType() {
		return lnciType;
	}

	public void setLnciType(String lnciType) {
		this.lnciType = lnciType;
	}

	public BigDecimal getLnciBalFrom() {
		return lnciBalFrom;
	}

	public void setLnciBalFrom(BigDecimal lnciBalFrom) {
		this.lnciBalFrom = lnciBalFrom;
	}

	public BigDecimal getLnciBalTo() {
		return lnciBalTo;
	}

	public void setLnciBalTo(BigDecimal lnciBalTo) {
		this.lnciBalTo = lnciBalTo;
	}

	public String getMgrno() {
		return mgrno;
	}

	public void setMgrno(String mgrno) {
		this.mgrno = mgrno;
	}

	public String getBlnUpBrcode() {
		return blnUpBrcode;
	}

	public void setBlnUpBrcode(String blnUpBrcode) {
		this.blnUpBrcode = blnUpBrcode;
	}

	public String getPayBrcode() {
		return payBrcode;
	}

	public void setPayBrcode(String payBrcode) {
		this.payBrcode = payBrcode;
	}

	public String getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(String isLocked) {
		this.isLocked = isLocked;
	}

	public String getEndDateFrom() {
		return endDateFrom;
	}

	public void setEndDateFrom(String endDateFrom) {
		this.endDateFrom = endDateFrom;
	}

	public String getEndDateTo() {
		return endDateTo;
	}

	public void setEndDateTo(String endDateTo) {
		this.endDateTo = endDateTo;
	}

}
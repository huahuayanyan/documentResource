/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.sto.pcb.model;

import java.math.BigDecimal;
import java.util.Date;

public class MortgageAdjustPriceVO {
	private String id;
	private String appno;
	private String businessno;
	private String adviceid;
	private String protocolNo;
	private String protocolCode;
	private String slaveContno;
	private String slaveContcode;
	private String custcd;
	private String orgCode;
	private String idtype;
	private String pledgeMode;
	private BigDecimal lowPriceNew;
	private Date stratDate;
	private String description;
	private String custno;
	private String cname;
	private BigDecimal originalTotPrice;
	private BigDecimal totPrice;
	private Date appDate;
	private BigDecimal ration;
	private BigDecimal bailAmount;
	private BigDecimal debtAmount;
	private String moniType;
	private String coreNm;
	private String appliType;
	private String processTemplateName;
	private String gutNm;//出质人名称
	private String memo;//备注
	private String productId;//业务品种
	/**
	 * VARCHAR(100)<br>
	 * 押品一级
	 */
	private String mortgageLevelOne;

	/**
	 * VARCHAR(100)<br>
	 * 押品一级名称
	 */
	private String mortgageLevelOneNm;

	/**
	 * VARCHAR(100)<br>
	 * 押品二级
	 */
	private String mortgageLevelTwo;

	/**
	 * VARCHAR(100)<br>
	 * 押品二级名称
	 */
	private String mortgageLevelTwoNm;

	/**
	 * VARCHAR(100)<br>
	 * 押品三级
	 */
	private String mortgageLevelThree;

	/**
	 * VARCHAR(100)<br>
	 * 押品三级名称
	 */
	private String mortgageLevelThreeNm;

	/**
	 * VARCHAR(100)<br>
	 * 押品四级
	 */
	private String mortgageLevelFour;

	/**
	 * VARCHAR(100)<br>
	 * 押品五级
	 */
	private String mortgageLevelFive;

	/**
	 * VARCHAR(100)<br>
	 * 押品六级
	 */
	private String mortgageLevelSix;


	public String getMortgageLevelOne() {
		return mortgageLevelOne;
	}

	public void setMortgageLevelOne(String mortgageLevelOne) {
		this.mortgageLevelOne = mortgageLevelOne;
	}

	public String getMortgageLevelOneNm() {
		return mortgageLevelOneNm;
	}

	public void setMortgageLevelOneNm(String mortgageLevelOneNm) {
		this.mortgageLevelOneNm = mortgageLevelOneNm;
	}

	public String getMortgageLevelTwo() {
		return mortgageLevelTwo;
	}

	public void setMortgageLevelTwo(String mortgageLevelTwo) {
		this.mortgageLevelTwo = mortgageLevelTwo;
	}

	public String getMortgageLevelTwoNm() {
		return mortgageLevelTwoNm;
	}

	public void setMortgageLevelTwoNm(String mortgageLevelTwoNm) {
		this.mortgageLevelTwoNm = mortgageLevelTwoNm;
	}

	public String getMortgageLevelThree() {
		return mortgageLevelThree;
	}

	public void setMortgageLevelThree(String mortgageLevelThree) {
		this.mortgageLevelThree = mortgageLevelThree;
	}

	public String getMortgageLevelThreeNm() {
		return mortgageLevelThreeNm;
	}

	public void setMortgageLevelThreeNm(String mortgageLevelThreeNm) {
		this.mortgageLevelThreeNm = mortgageLevelThreeNm;
	}

	public String getMortgageLevelFour() {
		return mortgageLevelFour;
	}

	public void setMortgageLevelFour(String mortgageLevelFour) {
		this.mortgageLevelFour = mortgageLevelFour;
	}

	public String getMortgageLevelFive() {
		return mortgageLevelFive;
	}

	public void setMortgageLevelFive(String mortgageLevelFive) {
		this.mortgageLevelFive = mortgageLevelFive;
	}

	public String getMortgageLevelSix() {
		return mortgageLevelSix;
	}

	public void setMortgageLevelSix(String mortgageLevelSix) {
		this.mortgageLevelSix = mortgageLevelSix;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}

	public String getBusinessno() {
		return businessno;
	}

	public void setBusinessno(String businessno) {
		this.businessno = businessno;
	}

	public String getAdviceid() {
		return adviceid;
	}

	public void setAdviceid(String adviceid) {
		this.adviceid = adviceid;
	}

	public String getProtocolNo() {
		return protocolNo;
	}

	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}

	public String getProtocolCode() {
		return protocolCode;
	}

	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}

	public String getSlaveContno() {
		return slaveContno;
	}

	public void setSlaveContno(String slaveContno) {
		this.slaveContno = slaveContno;
	}

	public String getSlaveContcode() {
		return slaveContcode;
	}

	public void setSlaveContcode(String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}

	public String getCustcd() {
		return custcd;
	}

	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	public String getPledgeMode() {
		return pledgeMode;
	}

	public void setPledgeMode(String pledgeMode) {
		this.pledgeMode = pledgeMode;
	}

	public BigDecimal getLowPriceNew() {
		return lowPriceNew;
	}

	public void setLowPriceNew(BigDecimal lowPriceNew) {
		this.lowPriceNew = lowPriceNew;
	}

	public Date getStratDate() {
		return stratDate;
	}

	public void setStratDate(Date stratDate) {
		this.stratDate = stratDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCustno() {
		return custno;
	}

	public void setCustno(String custno) {
		this.custno = custno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public BigDecimal getOriginalTotPrice() {
		return originalTotPrice;
	}

	public void setOriginalTotPrice(BigDecimal originalTotPrice) {
		this.originalTotPrice = originalTotPrice;
	}

	public BigDecimal getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(BigDecimal totPrice) {
		this.totPrice = totPrice;
	}

	public Date getAppDate() {
		return appDate;
	}

	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}

	public BigDecimal getRation() {
		return ration;
	}

	public void setRation(BigDecimal ration) {
		this.ration = ration;
	}

	public BigDecimal getBailAmount() {
		return bailAmount;
	}

	public void setBailAmount(BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}

	public BigDecimal getDebtAmount() {
		return debtAmount;
	}

	public void setDebtAmount(BigDecimal debtAmount) {
		this.debtAmount = debtAmount;
	}

	public String getMoniType() {
		return moniType;
	}

	public void setMoniType(String moniType) {
		this.moniType = moniType;
	}

	public String getCoreNm() {
		return coreNm;
	}

	public void setCoreNm(String coreNm) {
		this.coreNm = coreNm;
	}

	public String getAppliType() {
		return appliType;
	}

	public void setAppliType(String appliType) {
		this.appliType = appliType;
	}

	public String getProcessTemplateName() {
		return processTemplateName;
	}

	public void setProcessTemplateName(String processTemplateName) {
		this.processTemplateName = processTemplateName;
	}

	public String getGutNm() {
		return gutNm;
	}

	public void setGutNm(String gutNm) {
		this.gutNm = gutNm;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}

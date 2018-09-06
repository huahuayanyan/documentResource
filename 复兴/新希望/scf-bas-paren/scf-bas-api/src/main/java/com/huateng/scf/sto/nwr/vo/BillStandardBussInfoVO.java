/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.sto.nwr.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;

/**
 *  标准仓单和质押合同信息VO
 *
 * @author <a href="mailto:huangshan@topscf.com">huangshan</a>
 *
 * @version Revision: 1.0  Date: 2013-9-12 上午09:55:39
 *
 */

public class BillStandardBussInfoVO extends BPbcAppliBaseInfo {

	/**
	 * 
	 */
	private String prtclBrNm;
	private String taskComment;//审批意见
	
	public String getTaskComment() {
		return taskComment;
	}

	public void setTaskComment(String taskComment) {
		this.taskComment = taskComment;
	}

	public String getPrtclBrNm() {
		return prtclBrNm;
	}

	public void setPrtclBrNm(String prtclNm) {
		this.prtclBrNm = prtclNm;
	}

	private static final long serialVersionUID = 1L;
	private String slaveContcode;
	private String mastContcode;
	private String applyType;
	private String workApplyType;
	private String bussType;
	private java.math.BigDecimal theRPAmount;
	private java.math.BigDecimal riskAmount;
	private java.math.BigDecimal removePledgeAmount;
	private java.math.BigDecimal removePledgeHighestAmount;
	private java.math.BigDecimal receiptPledgeAmount;
	private java.math.BigDecimal ration;
	private BigDecimal amount;
	private String slaveContType;
	public String getSlaveContType() {
		return slaveContType;
	}

	public void setSlaveContType(String slaveContType) {
		this.slaveContType = slaveContType;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCurcd() {
		return curcd;
	}

	public void setCurcd(String curcd) {
		this.curcd = curcd;
	}

	public String getSlaveContAmt() {
		return slaveContAmt;
	}

	public void setSlaveContAmt(String slaveContAmt) {
		this.slaveContAmt = slaveContAmt;
	}

	private String cname;
	private String idtype;
	private String idno;
	private Date startDate;
	private Date endDate;
	private String curcd;
	private String slaveContAmt;
//slaveContcode,slaveContType,cname,idtype,idno,startDate,endDate,curcd,slaveContAmt

	public BillStandardBussInfoVO() {
		super();
	}

	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	public String getWorkApplyType() {
		return workApplyType;
	}
	public void setWorkApplyType(String workApplyType) {
		this.workApplyType = workApplyType;
	}

	public String getBussType() {
		return bussType;
	}

	public void setBussType(String bussType) {
		this.bussType = bussType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getSlaveContcode() {
		return slaveContcode;
	}

	public void setSlaveContcode(String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}

	public String getMastContcode() {
		return mastContcode;
	}

	public void setMastContcode(String mastContcode) {
		this.mastContcode = mastContcode;
	}

	public java.math.BigDecimal getTheRPAmount() {
		return theRPAmount;
	}

	public void setTheRPAmount(java.math.BigDecimal theRPAmount) {
		this.theRPAmount = theRPAmount;
	}

	public java.math.BigDecimal getRiskAmount() {
		return riskAmount;
	}

	public void setRiskAmount(java.math.BigDecimal riskAmount) {
		this.riskAmount = riskAmount;
	}

	public java.math.BigDecimal getRemovePledgeAmount() {
		return removePledgeAmount;
	}

	public void setRemovePledgeAmount(java.math.BigDecimal removePledgeAmount) {
		this.removePledgeAmount = removePledgeAmount;
	}

	public java.math.BigDecimal getRemovePledgeHighestAmount() {
		return removePledgeHighestAmount;
	}

	public void setRemovePledgeHighestAmount(
			java.math.BigDecimal removePledgeHighestAmount) {
		this.removePledgeHighestAmount = removePledgeHighestAmount;
	}

	public java.math.BigDecimal getRation() {
		return ration;
	}

	public void setRation(java.math.BigDecimal ration) {
		this.ration = ration;
	}

	public java.math.BigDecimal getReceiptPledgeAmount() {
		return receiptPledgeAmount;
	}

	public void setReceiptPledgeAmount(java.math.BigDecimal receiptPledgeAmount) {
		this.receiptPledgeAmount = receiptPledgeAmount;
	}



}

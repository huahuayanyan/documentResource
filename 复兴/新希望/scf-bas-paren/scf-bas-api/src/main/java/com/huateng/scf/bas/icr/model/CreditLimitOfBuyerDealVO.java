/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2013 TOPSCF  All rights reserved.
 * ==================================================================
 */


package com.huateng.scf.bas.icr.model;

import java.math.BigDecimal;


/**
 *
 * 买方信用限额操作VO
 *
 * @author <a href="mailto:wenkui.xu@huateng.com">michael</a>
 *
 * @version Revision: 1.0  Date: 2013-7-16 下午02:31:30
 *
 */
public class CreditLimitOfBuyerDealVO {
	//TBL_CREDIT_INFO
	private String creditNo;//额度编号
	private String creditType;//额度种类
	private String custcd;//卖方客户号
	private String otherCustcd;//买方客户号

	//TBL_CREDIT_BUSI_REL
	private String businessNo;//业务合同号

	//TBL_CREDIT_DETAIL
	private BigDecimal amount;//操作额度
	private String operType;//操作类型
	private String applyType;//申请类型

	//TBL_APPLI_BASE_INFO
	private String appno;

	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public String getCustcd() {
		return custcd;
	}
	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}
	public String getOtherCustcd() {
		return otherCustcd;
	}
	public void setOtherCustcd(String otherCustcd) {
		this.otherCustcd = otherCustcd;
	}

	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getOperType() {
		return operType;
	}
	public void setOperType(String operType) {
		this.operType = operType;
	}
	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	public String getCreditType() {
		return creditType;
	}
	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}
	public String getCreditNo() {
		return creditNo;
	}
	public void setCreditNo(String creditNo) {
		this.creditNo = creditNo;
	}

}

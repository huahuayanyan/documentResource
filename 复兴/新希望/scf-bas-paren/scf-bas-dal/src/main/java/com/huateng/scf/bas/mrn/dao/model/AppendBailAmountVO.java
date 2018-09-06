/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.mrn.dao.model;

import java.math.BigDecimal;
/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年2月9日上午10:17:23
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年2月7日上午10:17:23              新增
 *
 * </pre>
 */

public class AppendBailAmountVO {
	private String slaveContno;
	private String custcd;
	private String supplyChainPdId;
	private String protocolNo;
	private String appno;
	private String debetNo;
	private BigDecimal addBailAmount;// 追加保证金
	private String cname;
	private String debetId;
	private String custno;// 核心客户号

	public String getSlaveContno() {
		return slaveContno;
	}

	public void setSlaveContno(String slaveContno) {
		this.slaveContno = slaveContno;
	}

	public String getCustcd() {
		return custcd;
	}

	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}

	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}

	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}

	public String getProtocolNo() {
		return protocolNo;
	}

	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}

	public String getDebetNo() {
		return debetNo;
	}

	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}

	public BigDecimal getAddBailAmount() {
		return addBailAmount;
	}

	public void setAddBailAmount(BigDecimal addBailAmount) {
		this.addBailAmount = addBailAmount;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDebetId() {
		return debetId;
	}

	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}

	public String getCustno() {
		return custno;
	}

	public void setCustno(String custno) {
		this.custno = custno;
	}
}

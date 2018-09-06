/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.sto.dmp.vo;

import java.math.BigDecimal;

/**
 *  在这里添加类的文档注释
 * 
 * @author <a href="mailto:jianfeng.huang@topscf.com">jianfeng.huang</a>
 *
 * @version Revision: 1.0  Date: 2013-6-29 上午11:36:19 
 *
 */

public class StockListImportInfoVO {
	private String appno;
	private String protocolNo;
	private String slaveContno;
	private String custcd;
	/**
	 * 出质人名称
	 */
	private String cname;
	private String orgCode;
	private String	idtype;
	private String pledgeMode;
	private BigDecimal lowPrice;
	private String description;
	private BigDecimal mortAmount;
	private String moniModel;
	private BigDecimal lowPriceNew;
	private String moniCustcd;
	private String moniCname;
	private String supplyChainPdId;
	/**
	 * 业务品种
	 */
	private String productName;
	
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public String getProtocolNo() {
		return protocolNo;
	}
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}
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
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
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
	public BigDecimal getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getMortAmount() {
		return mortAmount;
	}
	public void setMortAmount(BigDecimal mortAmount) {
		this.mortAmount = mortAmount;
	}
	public String getMoniModel() {
		return moniModel;
	}
	public void setMoniModel(String moniModel) {
		this.moniModel = moniModel;
	}
	public BigDecimal getLowPriceNew() {
		return lowPriceNew;
	}
	public void setLowPriceNew(BigDecimal lowPriceNew) {
		this.lowPriceNew = lowPriceNew;
	}
	public String getMoniCustcd() {
		return moniCustcd;
	}
	public String getMoniCname() {
		return moniCname;
	}
	public void setMoniCustcd(String moniCustcd) {
		this.moniCustcd = moniCustcd;
	}
	public void setMoniCname(String moniCname) {
		this.moniCname = moniCname;
	}
	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}
	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

}

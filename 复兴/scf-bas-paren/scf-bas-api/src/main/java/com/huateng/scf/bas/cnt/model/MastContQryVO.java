/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2013 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.cnt.model;

import java.util.Date;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 * <p>
 * 主合同查询条件VO
 * </p>
 *
 * @author shangxiujuan
 * @date 2016年12月05日.下午4:51:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月05日.下午4:51:24	     新增
 *
 *            </pre>
 */

public class MastContQryVO extends CommonQryVO {

	private static final long serialVersionUID = -4423023579280557915L;
	private String supplyChainPdId;// 供应链产品类型
	private String value;// 输入的查询条件值
	private String conStatus;// 合同状态
	private String state;
	private String coreCustcd;// 核心厂商客户号
	private String bussType;// 业务类型
	private String contType;// 合同类型
	private String buyerCustcd; // 买方
	private String buyerName;// 买方名称
	private String financingType;// 融资类型
	private String creditProtNo; // 额度协议流水号
	private String factType;// 融资模式
	private Date startDate;// 起始日
	private Date endDate;// 到期日
	private String moniModel;// 动态静态标志
	private String mastContStatus;
	private String procName;
	private String productId;
	private String loanWay;
	private String leaseContno;
	private String businessNo;
	private String protocolType;
	private String creditFlag; // 授信客户标识

	public String getBuyerCustcd() {
		return buyerCustcd;
	}

	public void setBuyerCustcd(String buyerCustcd) {
		this.buyerCustcd = buyerCustcd;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getLeaseContno() {
		return leaseContno;
	}

	public void setLeaseContno(String leaseContno) {
		this.leaseContno = leaseContno;
	}

	public MastContQryVO() {

	}

	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}

	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the conStatus
	 */
	public String getConStatus() {
		return conStatus;
	}

	/**
	 * @param conStatus
	 *            the conStatus to set
	 */
	public void setConStatus(String conStatus) {
		this.conStatus = conStatus;
	}

	public String getCoreCustcd() {
		return coreCustcd;
	}

	public void setCoreCustcd(String coreCustcd) {
		this.coreCustcd = coreCustcd;
	}

	public String getBussType() {
		return bussType;
	}

	public void setBussType(String bussType) {
		this.bussType = bussType;
	}

	public String getContType() {
		return contType;
	}

	public void setContType(String contType) {
		this.contType = contType;
	}

	public String getFinancingType() {
		return financingType;
	}

	public void setFinancingType(String financingType) {
		this.financingType = financingType;
	}

	public String getCreditProtNo() {
		return creditProtNo;
	}

	public void setCreditProtNo(String creditProtNo) {
		this.creditProtNo = creditProtNo;
	}

	public String getFactType() {
		return factType;
	}

	public void setFactType(String factType) {
		this.factType = factType;
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

	public String getMoniModel() {
		return moniModel;
	}

	public void setMoniModel(String moniModel) {
		this.moniModel = moniModel;
	}

	public String getMastContStatus() {
		return mastContStatus;
	}

	public void setMastContStatus(String mastContStatus) {
		this.mastContStatus = mastContStatus;
	}

	public String getProcName() {
		return procName;
	}

	public void setProcName(String procName) {
		this.procName = procName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getLoanWay() {
		return loanWay;
	}

	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	}

	public String getProtocolType() {
		return protocolType;
	}

	public void setProtocolType(String protocolType) {
		this.protocolType = protocolType;
	}

	public String getCreditFlag() {
		return creditFlag;
	}

	public void setCreditFlag(String creditFlag) {
		this.creditFlag = creditFlag;
	}

}

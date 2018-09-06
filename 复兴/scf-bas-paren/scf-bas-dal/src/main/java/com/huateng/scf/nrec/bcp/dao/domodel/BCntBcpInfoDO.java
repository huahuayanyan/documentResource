package com.huateng.scf.nrec.bcp.dao.domodel;

import java.math.BigDecimal;

import com.huateng.scf.nrec.bcp.dao.model.BCntBcpInfo;

public class BCntBcpInfoDO extends BCntBcpInfo{
    private static final long serialVersionUID = 1L;
    
    /**
     * VARCHAR(20) 必填<br>
     * 业务合同号
     */
    private String businessNo;

    /**
     * VARCHAR(15) 必填<br>
     * 买方客户号/承租人客户号
     */
    private String businessCustcd;

    /**
     * DECIMAL(22)<br>
     * 账期(天)
     */
    private BigDecimal loanDays;

    /**
     * DECIMAL(22)<br>
     * 宽限期(天)
     */
    private BigDecimal debtGraceDays;

    /**
     * VARCHAR(100)<br>
     * 买方名称/承租人名称
     */
    private String businessName;

    /**
     * VARCHAR(50)<br>
     * 批单号码
     */
    private String batchNumber;

    /**
     * DECIMAL(22)<br>
     * 信用期限
     */
    private BigDecimal creditTerm;

    /**
     * DECIMAL(16,2)<br>
     * 信用限额
     */
    private BigDecimal creditAmt;

    /**
     * DECIMAL(22)<br>
     * 拖欠风险宽限期/信险宽限期(天)
     */
    private BigDecimal riskTerm;

    /**
     * VARCHAR(1)<br>
     * 有无追索权：1-有追索;2-无追索
     */
    private String recoverType;

    /**
     * VARCHAR(2)<br>
     * 保理方式：1-明保理;2-暗保理
     */
    private String factPattern;

    /**
     * CHAR(2)<br>
     * 通知方式：01-一次性通知;02-逐笔通知;03-取得发票收妥回执;04-仅签收发票
     */
    private String noticeType;
    
    /**
     * 业务品种
     */
    private String bussType;
    
    private String productName;
    
    public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	public BigDecimal getLoanDays() {
		return loanDays;
	}
	public void setLoanDays(BigDecimal loanDays) {
		this.loanDays = loanDays;
	}
	public BigDecimal getDebtGraceDays() {
		return debtGraceDays;
	}
	public void setDebtGraceDays(BigDecimal debtGraceDays) {
		this.debtGraceDays = debtGraceDays;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public BigDecimal getCreditTerm() {
		return creditTerm;
	}
	public void setCreditTerm(BigDecimal creditTerm) {
		this.creditTerm = creditTerm;
	}
	public BigDecimal getCreditAmt() {
		return creditAmt;
	}
	public void setCreditAmt(BigDecimal creditAmt) {
		this.creditAmt = creditAmt;
	}
	public BigDecimal getRiskTerm() {
		return riskTerm;
	}
	public void setRiskTerm(BigDecimal riskTerm) {
		this.riskTerm = riskTerm;
	}
	public String getRecoverType() {
		return recoverType;
	}
	public void setRecoverType(String recoverType) {
		this.recoverType = recoverType;
	}
	public String getFactPattern() {
		return factPattern;
	}
	public void setFactPattern(String factPattern) {
		this.factPattern = factPattern;
	}
	public String getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	private String cname;
    private String tlrnm;
    private String brname;
    private String inpDt;
    private String appno;
    private String id;
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
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getBusinessCustcd() {
		return businessCustcd;
	}
	public void setBusinessCustcd(String businessCustcd) {
		this.businessCustcd = businessCustcd;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getTlrnm() {
		return tlrnm;
	}
	public void setTlrnm(String tlrnm) {
		this.tlrnm = tlrnm;
	}
	public String getBrname() {
		return brname;
	}
	public void setBrname(String brname) {
		this.brname = brname;
	}
	public String getInpDt() {
		return inpDt;
	}
	public void setInpDt(String inpDt) {
		this.inpDt = inpDt;
	}
	public String getBussType() {
		return bussType;
	}
	public void setBussType(String bussType) {
		this.bussType = bussType;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
}
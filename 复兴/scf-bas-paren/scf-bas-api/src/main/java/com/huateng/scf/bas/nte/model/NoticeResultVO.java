package com.huateng.scf.bas.nte.model;

import java.math.BigDecimal;


/**
 * @author htrad0055
 *
 * 通知书查询返回VO
 * 
 *
 */
public class NoticeResultVO extends BNteNoticeBase{
	
	private String num;
	private String custcd;
	private String mastContno;
	private String brcode;
	private String brName;
	private String money;
	private String custcdBuyer;
	private String custcdSaller;
	private String chargeTypeNm;
	private BigDecimal cost;
	private BigDecimal handlingFee;
	private BigDecimal totalFee;
	private BigDecimal totalReduce;
	private String balanceAccount;
	private BigDecimal receiveAmount;
	private String chargeType;
	private String supplyChainPdId;
	private BigDecimal mortAmount;
	private BigDecimal ext1Amount;
	private String tlrName;
	
	/**
	 * 数量
	 */
	private java.lang.String quantityStr;
	
	/**
	 * 单价
	 */
	private java.lang.String confirmPriceStr;
	
	/**
	 * 价格
	 */
	private java.lang.String totPriceStr;
	
	/**
	 * 核心厂商客户号
	 */
	private java.lang.String coreCustcd;
	
	/**
	 * 核心厂商名称
	 */
	private java.lang.String coreName;
	
	/**
	 * 押品名称
	 */
	private java.lang.String mortgageName;
	
	/**
	 * 押品一级名称
	 */
	private java.lang.String mortLevelOneName;
	
	/**
	 * 押品二级名称
	 */
	private java.lang.String mortLevelTwoName;
	
	/**
	 * 规格型号
	 */
	private java.lang.String mortgageModel;
	
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCustcd() {
		return custcd;
	}
	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}
	public String getMastContno() {
		return mastContno;
	}
	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}
	public String getBrcode() {
		return brcode;
	}
	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getCustcdBuyer() {
		return custcdBuyer;
	}
	public void setCustcdBuyer(String custcdBuyer) {
		this.custcdBuyer = custcdBuyer;
	}
	public String getCustcdSaller() {
		return custcdSaller;
	}
	public void setCustcdSaller(String custcdSaller) {
		this.custcdSaller = custcdSaller;
	}
	public String getChargeTypeNm() {
		return chargeTypeNm;
	}
	public void setChargeTypeNm(String chargeTypeNm) {
		this.chargeTypeNm = chargeTypeNm;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public BigDecimal getHandlingFee() {
		return handlingFee;
	}
	public void setHandlingFee(BigDecimal handlingFee) {
		this.handlingFee = handlingFee;
	}
	public BigDecimal getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}
	public BigDecimal getTotalReduce() {
		return totalReduce;
	}
	public void setTotalReduce(BigDecimal totalReduce) {
		this.totalReduce = totalReduce;
	}
	public String getBalanceAccount() {
		return balanceAccount;
	}
	public void setBalanceAccount(String balanceAccount) {
		this.balanceAccount = balanceAccount;
	}
	public BigDecimal getReceiveAmount() {
		return receiveAmount;
	}
	public void setReceiveAmount(BigDecimal receiveAmount) {
		this.receiveAmount = receiveAmount;
	}
	public String getChargeType() {
		return chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}
	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}
	public BigDecimal getMortAmount() {
		return mortAmount;
	}
	public void setMortAmount(BigDecimal mortAmount) {
		this.mortAmount = mortAmount;
	}
	public BigDecimal getExt1Amount() {
		return ext1Amount;
	}
	public void setExt1Amount(BigDecimal ext1Amount) {
		this.ext1Amount = ext1Amount;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getTlrName() {
		return tlrName;
	}
	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}
	public java.lang.String getQuantityStr() {
		return quantityStr;
	}
	public void setQuantityStr(java.lang.String quantityStr) {
		this.quantityStr = quantityStr;
	}
	public java.lang.String getConfirmPriceStr() {
		return confirmPriceStr;
	}
	public void setConfirmPriceStr(java.lang.String confirmPriceStr) {
		this.confirmPriceStr = confirmPriceStr;
	}
	public java.lang.String getTotPriceStr() {
		return totPriceStr;
	}
	public void setTotPriceStr(java.lang.String totPriceStr) {
		this.totPriceStr = totPriceStr;
	}
	public java.lang.String getCoreCustcd() {
		return coreCustcd;
	}
	public void setCoreCustcd(java.lang.String coreCustcd) {
		this.coreCustcd = coreCustcd;
	}
	public java.lang.String getCoreName() {
		return coreName;
	}
	public void setCoreName(java.lang.String coreName) {
		this.coreName = coreName;
	}
	public java.lang.String getMortgageName() {
		return mortgageName;
	}
	public void setMortgageName(java.lang.String mortgageName) {
		this.mortgageName = mortgageName;
	}
	public java.lang.String getMortLevelOneName() {
		return mortLevelOneName;
	}
	public void setMortLevelOneName(java.lang.String mortLevelOneName) {
		this.mortLevelOneName = mortLevelOneName;
	}
	public java.lang.String getMortLevelTwoName() {
		return mortLevelTwoName;
	}
	public void setMortLevelTwoName(java.lang.String mortLevelTwoName) {
		this.mortLevelTwoName = mortLevelTwoName;
	}
	public java.lang.String getMortgageModel() {
		return mortgageModel;
	}
	public void setMortgageModel(java.lang.String mortgageModel) {
		this.mortgageModel = mortgageModel;
	}
	
	
}

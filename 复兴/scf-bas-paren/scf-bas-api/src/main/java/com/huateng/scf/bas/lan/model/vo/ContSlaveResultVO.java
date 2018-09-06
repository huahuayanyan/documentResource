package com.huateng.scf.bas.lan.model.vo;

import java.math.BigDecimal;

import com.huateng.scf.bas.crr.model.BCrrGntyCon;

/**
 * 担保合同多方协议关联返回VO
 *
 * @author <a href="mailto:wenkui.xu@huateng.com">wenkui.xu</a>
 *
 * @version Revision: 1.0 Date: 2013-5-16 下午07:58:20
 *
 */

public class ContSlaveResultVO extends BCrrGntyCon {

	private String custcd;
	private String supplyChainPdId;
	private String curcd;
	private String startDate;
	private String endDate;
	private String assureType;
	private String mgrno;
	private String mgrnoNm;
	private String brcode;
	private String brcodeName;
	public String getMgrnoNm() {
		return mgrnoNm;
	}

	public void setMgrnoNm(String mgrnoNm) {
		this.mgrnoNm = mgrnoNm;
	}

	public String getBrcodeName() {
		return brcodeName;
	}

	public void setBrcodeName(String brcodeName) {
		this.brcodeName = brcodeName;
	}

	private String moniModel;
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

	public String getCurcd() {
		return curcd;
	}

	public void setCurcd(String curcd) {
		this.curcd = curcd;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAssureType() {
		return assureType;
	}

	public void setAssureType(String assureType) {
		this.assureType = assureType;
	}

	public String getMgrno() {
		return mgrno;
	}

	public void setMgrno(String mgrno) {
		this.mgrno = mgrno;
	}

	public String getBrcode() {
		return brcode;
	}

	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}

	public String getMoniModel() {
		return moniModel;
	}

	public void setMoniModel(String moniModel) {
		this.moniModel = moniModel;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String thrCd;
	private String thrName;
	private String moniType;
	private String productId;
	private BigDecimal mortgageAmount;
	private BigDecimal amount;
	private BigDecimal openAmount;
	private String tlrno;
	private String mastContno;
	private String moniWarehouseType;  //监管模式
	private String moniCustcd;
	private String moniNm;
	private BigDecimal totalLnciAmt;

	private String slaveContno;
	private String slaveContcode;
	private String protocolNo;
	private String slaveContType;
	private java.math.BigDecimal slaveContAmt;
	private String description;
	private String firCd;
	private String firName;
	private String secCd;
	private String secName;
	private String bailaccount;
	private String insuranceFlag;
	private String insuranceNo;
	private String insuranceBuyer;
	private String insuranceBenefiter;
	private java.math.BigDecimal insuranceAmt;
	private String insuranceStartDate;
	private String insuranceEndDate;
	private String mortgageLevelOne;
	private String mortgageLevelTwo;
	private String priceMaxDecline;
	private String offsetDeadline;
	private String breachDeadline;
	private String isexchange;
	private String insure;
	private String slaveCurcd;
	private java.math.BigDecimal deliveryAmt;
	private String checkFlag;  //控制监管合同号、质押率、市值警戒线（%）是否可修改    
	private String appno;   //申请号

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}

	public String getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}

	public String getMoniWarehouseType() {
		return moniWarehouseType;
	}

	public void setMoniWarehouseType(String moniWarehouseType) {
		this.moniWarehouseType = moniWarehouseType;
	}

	public BigDecimal getMortgageAmount() {
		return mortgageAmount;
	}

	public void setMortgageAmount(BigDecimal mortgageAmount) {
		this.mortgageAmount = mortgageAmount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getOpenAmount() {
		return openAmount;
	}

	public void setOpenAmount(BigDecimal openAmount) {
		this.openAmount = openAmount;
	}

	public String getThrCd() {
		return thrCd;
	}

	public void setThrCd(String thrCd) {
		this.thrCd = thrCd;
	}

	public String getThrName() {
		return thrName;
	}

	public void setThrName(String thrName) {
		this.thrName = thrName;
	}

	public String getMoniType() {
		return moniType;
	}

	public void setMoniType(String moniType) {
		this.moniType = moniType;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTlrno() {
		return tlrno;
	}

	public void setTlrno(String tlrno) {
		this.tlrno = tlrno;
	}

	public String getMastContno() {
		return mastContno;
	}

	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}

	public String getMoniCustcd() {
		return moniCustcd;
	}

	public void setMoniCustcd(String moniCustcd) {
		this.moniCustcd = moniCustcd;
	}

	public String getMoniNm() {
		return moniNm;
	}

	public void setMoniNm(String moniNm) {
		this.moniNm = moniNm;
	}

	public BigDecimal getTotalLnciAmt() {
		return totalLnciAmt;
	}

	public void setTotalLnciAmt(BigDecimal totalLnciAmt) {
		this.totalLnciAmt = totalLnciAmt;
	}

	public String getSlaveContno()
	{
		return slaveContno;
	}

	public void setSlaveContno(String slaveContno)
	{
		this.slaveContno = slaveContno;
	}

	public String getSlaveContcode()
	{
		return slaveContcode;
	}

	public void setSlaveContcode(String slaveContcode)
	{
		this.slaveContcode = slaveContcode;
	}

	public String getProtocolNo()
	{
		return protocolNo;
	}

	public void setProtocolNo(String protocolNo)
	{
		this.protocolNo = protocolNo;
	}

	public String getSlaveContType()
	{
		return slaveContType;
	}

	public void setSlaveContType(String slaveContType)
	{
		this.slaveContType = slaveContType;
	}

	public java.math.BigDecimal getSlaveContAmt()
	{
		return slaveContAmt;
	}

	public void setSlaveContAmt(java.math.BigDecimal slaveContAmt)
	{
		this.slaveContAmt = slaveContAmt;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getFirCd()
	{
		return firCd;
	}

	public void setFirCd(String firCd)
	{
		this.firCd = firCd;
	}

	public String getFirName()
	{
		return firName;
	}

	public void setFirName(String firName)
	{
		this.firName = firName;
	}

	public String getSecCd()
	{
		return secCd;
	}

	public void setSecCd(String secCd)
	{
		this.secCd = secCd;
	}

	public String getSecName()
	{
		return secName;
	}

	public void setSecName(String secName)
	{
		this.secName = secName;
	}

	public String getBailaccount()
	{
		return bailaccount;
	}

	public void setBailaccount(String bailaccount)
	{
		this.bailaccount = bailaccount;
	}

	public String getInsuranceFlag()
	{
		return insuranceFlag;
	}

	public void setInsuranceFlag(String insuranceFlag)
	{
		this.insuranceFlag = insuranceFlag;
	}

	public String getInsuranceNo()
	{
		return insuranceNo;
	}

	public void setInsuranceNo(String insuranceNo)
	{
		this.insuranceNo = insuranceNo;
	}

	public String getInsuranceBuyer()
	{
		return insuranceBuyer;
	}

	public void setInsuranceBuyer(String insuranceBuyer)
	{
		this.insuranceBuyer = insuranceBuyer;
	}

	public String getInsuranceBenefiter()
	{
		return insuranceBenefiter;
	}

	public void setInsuranceBenefiter(String insuranceBenefiter)
	{
		this.insuranceBenefiter = insuranceBenefiter;
	}

	public java.math.BigDecimal getInsuranceAmt()
	{
		return insuranceAmt;
	}

	public void setInsuranceAmt(java.math.BigDecimal insuranceAmt)
	{
		this.insuranceAmt = insuranceAmt;
	}

	public String getInsuranceStartDate()
	{
		return insuranceStartDate;
	}

	public void setInsuranceStartDate(String insuranceStartDate)
	{
		this.insuranceStartDate = insuranceStartDate;
	}

	public String getInsuranceEndDate()
	{
		return insuranceEndDate;
	}

	public void setInsuranceEndDate(String insuranceEndDate)
	{
		this.insuranceEndDate = insuranceEndDate;
	}

	public String getMortgageLevelOne()
	{
		return mortgageLevelOne;
	}

	public void setMortgageLevelOne(String mortgageLevelOne)
	{
		this.mortgageLevelOne = mortgageLevelOne;
	}

	public String getMortgageLevelTwo()
	{
		return mortgageLevelTwo;
	}

	public void setMortgageLevelTwo(String mortgageLevelTwo)
	{
		this.mortgageLevelTwo = mortgageLevelTwo;
	}

	public String getPriceMaxDecline()
	{
		return priceMaxDecline;
	}

	public void setPriceMaxDecline(String priceMaxDecline)
	{
		this.priceMaxDecline = priceMaxDecline;
	}

	public String getOffsetDeadline()
	{
		return offsetDeadline;
	}

	public void setOffsetDeadline(String offsetDeadline)
	{
		this.offsetDeadline = offsetDeadline;
	}

	public String getBreachDeadline()
	{
		return breachDeadline;
	}

	public void setBreachDeadline(String breachDeadline)
	{
		this.breachDeadline = breachDeadline;
	}

	public String getIsexchange()
	{
		return isexchange;
	}

	public void setIsexchange(String isexchange)
	{
		this.isexchange = isexchange;
	}

	public String getInsure()
	{
		return insure;
	}

	public void setInsure(String insure)
	{
		this.insure = insure;
	}

	public String getSlaveCurcd()
	{
		return slaveCurcd;
	}

	public void setSlaveCurcd(String slaveCurcd)
	{
		this.slaveCurcd = slaveCurcd;
	}

	public java.math.BigDecimal getDeliveryAmt() {
		return deliveryAmt;
	}

	public void setDeliveryAmt(java.math.BigDecimal deliveryAmt) {
		this.deliveryAmt = deliveryAmt;
	}

}

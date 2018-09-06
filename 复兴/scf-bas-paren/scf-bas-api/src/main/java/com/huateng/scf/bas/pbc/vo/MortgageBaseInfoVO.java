package com.huateng.scf.bas.pbc.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo;


/**
 *  在这里添加类的文档注释
 *
 * @author <a href="mailto:jianfeng.huang@topscf.com">jianfeng.huang</a>
 *
 * @version Revision: 1.0  Date: 2013-5-14 下午1:58:28
 *
 */

public class MortgageBaseInfoVO extends BPbcMtgBaseInfo{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private java.lang.String slaveContno;
		private java.lang.String slaveContcode;
		private java.lang.String mastContno;
		private java.lang.String slaveContType;
		private java.lang.String custcd;
		private java.lang.String curcd;
		private java.math.BigDecimal slaveContAmt;
		private java.util.Date signDate;
		private java.lang.String description;
		private java.lang.String planMoniEnt;
		private java.lang.String supplyChainPdId;
		private java.lang.String protocolNo;
		private java.lang.String firCd;
		private java.lang.String firName;

		private java.lang.String secCd;
		private java.lang.String secName;

		private java.lang.String signIn;
		private java.lang.String bailaccount;
		private java.math.BigDecimal ration;
		private java.lang.String insure;
		private java.lang.String slaveCurcd;
		private java.lang.String insuranceFlag;
		private java.lang.String insuranceNo;
		private java.lang.String insuranceBuyer;
		private java.lang.String insuranceBenefiter;
		private java.math.BigDecimal insuranceAmt;
		private java.util.Date insuranceStartDate;
		private java.util.Date insuranceEndDate;
		private java.lang.String mortgageLevelOne;
		private java.lang.String mortgageLevelTwo;
		private java.math.BigDecimal lowPriceNew;
		private java.math.BigDecimal lowPrice;
		private java.lang.String moniModel;
		private java.math.BigDecimal credit;
		private java.lang.String status;
		private String mgrno;
		private String brcode;
		private java.lang.String flag;
		private java.lang.String id;
		private java.lang.String tlrcd;
		private java.lang.String type;
		private java.math.BigDecimal sumPrice;

		private Date lastUpdate;

		private java.math.BigDecimal totalPrice;

		private String mortgageLevelOneName;
		private String mortgageLevelTwoName;
		private String mortgageLevelThreeName;
		private String memo;

		private String batchId;
		private BigDecimal entityQuantity;
		private String checkStockResults;
		private Date checkStockDate;
		private String reason;

		private String productId;
		private String marketPriceSrc;
		private Boolean select;
		private String productName;

	
		private BigDecimal upDownPrice;
		private Date  addDate;
		private String mortUnitsName;
		private String mortgageThreeName;
		private BigDecimal allQuantity;  //总数量（出质数量+未出质的数量）


		public BigDecimal getAllQuantity() {
			return allQuantity;
		}
		public void setAllQuantity(BigDecimal allQuantity) {
			this.allQuantity = allQuantity;
		}
		
		public String getMortgageThreeName() {
			return mortgageThreeName;
		}
		public void setMortgageThreeName(String mortgageThreeName) {
			this.mortgageThreeName = mortgageThreeName;
		}
		public BigDecimal getUpDownPrice() {
			return upDownPrice;
		}
		public void setUpDownPrice(BigDecimal upDownPrice) {
			this.upDownPrice = upDownPrice;
		}
		public Date getAddDate() {
			return addDate;
		}
		public void setAddDate(Date addDate) {
			this.addDate = addDate;
		}
		public String getMortUnitsName() {
			return mortUnitsName;
		}
		public void setMortUnitsName(String mortUnitsName) {
			this.mortUnitsName = mortUnitsName;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getMarketPriceSrc() {
			return marketPriceSrc;
		}
		public void setMarketPriceSrc(String marketPriceSrc) {
			this.marketPriceSrc = marketPriceSrc;
		}
		public String getSrcDescription() {
			return srcDescription;
		}
		public void setSrcDescription(String srcDescription) {
			this.srcDescription = srcDescription;
		}
		private String srcDescription;

		public java.lang.String getSlaveContno() {
			return slaveContno;
		}
		public void setSlaveContno(java.lang.String slaveContno) {
			this.slaveContno = slaveContno;
		}
		public java.lang.String getSlaveContcode() {
			return slaveContcode;
		}
		public void setSlaveContcode(java.lang.String slaveContcode) {
			this.slaveContcode = slaveContcode;
		}
		public java.lang.String getMastContno() {
			return mastContno;
		}
		public void setMastContno(java.lang.String mastContno) {
			this.mastContno = mastContno;
		}
		public java.lang.String getSlaveContType() {
			return slaveContType;
		}
		public void setSlaveContType(java.lang.String slaveContType) {
			this.slaveContType = slaveContType;
		}
		public java.lang.String getCustcd() {
			return custcd;
		}
		public void setCustcd(java.lang.String custcd) {
			this.custcd = custcd;
		}
		public java.lang.String getCurcd() {
			return curcd;
		}
		public void setCurcd(java.lang.String curcd) {
			this.curcd = curcd;
		}
		public java.math.BigDecimal getSlaveContAmt() {
			return slaveContAmt;
		}
		public void setSlaveContAmt(java.math.BigDecimal slaveContAmt) {
			this.slaveContAmt = slaveContAmt;
		}
		public java.util.Date getSignDate() {
			return signDate;
		}
		public void setSignDate(java.util.Date signDate) {
			this.signDate = signDate;
		}
		public java.lang.String getDescription() {
			return description;
		}
		public void setDescription(java.lang.String description) {
			this.description = description;
		}
		public java.lang.String getPlanMoniEnt() {
			return planMoniEnt;
		}
		public void setPlanMoniEnt(java.lang.String planMoniEnt) {
			this.planMoniEnt = planMoniEnt;
		}
		public java.lang.String getSupplyChainPdId() {
			return supplyChainPdId;
		}
		public void setSupplyChainPdId(java.lang.String supplyChainPdId) {
			this.supplyChainPdId = supplyChainPdId;
		}
		public java.lang.String getProtocolNo() {
			return protocolNo;
		}
		public void setProtocolNo(java.lang.String protocolNo) {
			this.protocolNo = protocolNo;
		}
		public java.lang.String getFirCd() {
			return firCd;
		}
		public void setFirCd(java.lang.String firCd) {
			this.firCd = firCd;
		}
		public java.lang.String getFirName() {
			return firName;
		}
		public void setFirName(java.lang.String firName) {
			this.firName = firName;
		}
		public java.lang.String getSecCd() {
			return secCd;
		}
		public void setSecCd(java.lang.String secCd) {
			this.secCd = secCd;
		}
		public java.lang.String getSecName() {
			return secName;
		}
		public void setSecName(java.lang.String secName) {
			this.secName = secName;
		}
		public java.lang.String getSignIn() {
			return signIn;
		}
		public void setSignIn(java.lang.String signIn) {
			this.signIn = signIn;
		}
		public java.lang.String getBailaccount() {
			return bailaccount;
		}
		public void setBailaccount(java.lang.String bailaccount) {
			this.bailaccount = bailaccount;
		}
		public java.math.BigDecimal getRation() {
			return ration;
		}
		public void setRation(java.math.BigDecimal ration) {
			this.ration = ration;
		}
		public java.lang.String getInsure() {
			return insure;
		}
		public void setInsure(java.lang.String insure) {
			this.insure = insure;
		}
		public java.lang.String getSlaveCurcd() {
			return slaveCurcd;
		}
		public void setSlaveCurcd(java.lang.String slaveCurcd) {
			this.slaveCurcd = slaveCurcd;
		}
		public java.lang.String getInsuranceFlag() {
			return insuranceFlag;
		}
		public void setInsuranceFlag(java.lang.String insuranceFlag) {
			this.insuranceFlag = insuranceFlag;
		}
		public java.lang.String getInsuranceNo() {
			return insuranceNo;
		}
		public void setInsuranceNo(java.lang.String insuranceNo) {
			this.insuranceNo = insuranceNo;
		}
		public java.lang.String getInsuranceBuyer() {
			return insuranceBuyer;
		}
		public void setInsuranceBuyer(java.lang.String insuranceBuyer) {
			this.insuranceBuyer = insuranceBuyer;
		}
		public java.lang.String getInsuranceBenefiter() {
			return insuranceBenefiter;
		}
		public void setInsuranceBenefiter(java.lang.String insuranceBenefiter) {
			this.insuranceBenefiter = insuranceBenefiter;
		}
		public java.math.BigDecimal getInsuranceAmt() {
			return insuranceAmt;
		}
		public void setInsuranceAmt(java.math.BigDecimal insuranceAmt) {
			this.insuranceAmt = insuranceAmt;
		}
		public java.util.Date getInsuranceStartDate() {
			return insuranceStartDate;
		}
		public void setInsuranceStartDate(java.util.Date insuranceStartDate) {
			this.insuranceStartDate = insuranceStartDate;
		}
		public java.util.Date getInsuranceEndDate() {
			return insuranceEndDate;
		}
		public void setInsuranceEndDate(java.util.Date insuranceEndDate) {
			this.insuranceEndDate = insuranceEndDate;
		}
		public java.lang.String getMortgageLevelOne() {
			return mortgageLevelOne;
		}
		public void setMortgageLevelOne(java.lang.String mortgageLevelOne) {
			this.mortgageLevelOne = mortgageLevelOne;
		}
		public java.lang.String getMortgageLevelTwo() {
			return mortgageLevelTwo;
		}
		public void setMortgageLevelTwo(java.lang.String mortgageLevelTwo) {
			this.mortgageLevelTwo = mortgageLevelTwo;
		}
		public java.math.BigDecimal getLowPriceNew() {
			return lowPriceNew;
		}
		public void setLowPriceNew(java.math.BigDecimal lowPriceNew) {
			this.lowPriceNew = lowPriceNew;
		}
		public java.math.BigDecimal getLowPrice() {
			return lowPrice;
		}
		public void setLowPrice(java.math.BigDecimal lowPrice) {
			this.lowPrice = lowPrice;
		}
		public java.lang.String getMoniModel() {
			return moniModel;
		}
		public void setMoniModel(java.lang.String moniModel) {
			this.moniModel = moniModel;
		}
		public java.math.BigDecimal getCredit() {
			return credit;
		}
		public void setCredit(java.math.BigDecimal credit) {
			this.credit = credit;
		}
		public java.lang.String getStatus() {
			return status;
		}
		public void setStatus(java.lang.String status) {
			this.status = status;
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
		public java.lang.String getFlag() {
			return flag;
		}
		public void setFlag(java.lang.String flag) {
			this.flag = flag;
		}
		public java.lang.String getId() {
			return id;
		}
		public void setId(java.lang.String id) {
			this.id = id;
		}
		public java.lang.String getTlrcd() {
			return tlrcd;
		}
		public void setTlrcd(java.lang.String tlrcd) {
			this.tlrcd = tlrcd;
		}
		public java.lang.String getType() {
			return type;
		}
		public void setType(java.lang.String type) {
			this.type = type;
		}
		public Date getLastUpdate() {
			return lastUpdate;
		}
		public void setLastUpdate(Date lastUpdate) {
			this.lastUpdate = lastUpdate;
		}
		public java.math.BigDecimal getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(java.math.BigDecimal totalPrice) {
			this.totalPrice = totalPrice;
		}
		public String getMortgageLevelOneName() {
			return mortgageLevelOneName;
		}
		public void setMortgageLevelOneName(String mortgageLevelOneName) {
			this.mortgageLevelOneName = mortgageLevelOneName;
		}
		public String getMortgageLevelTwoName() {
			return mortgageLevelTwoName;
		}
		public void setMortgageLevelTwoName(String mortgageLevelTwoName) {
			this.mortgageLevelTwoName = mortgageLevelTwoName;
		}
		public String getMortgageLevelThreeName() {
			return mortgageLevelThreeName;
		}
		public void setMortgageLevelThreeName(String mortgageLevelThreeName) {
			this.mortgageLevelThreeName = mortgageLevelThreeName;
		}
		public String getMemo() {
			return memo;
		}
		public void setMemo(String memo) {
			this.memo = memo;
		}
		public String getBatchId() {
			return batchId;
		}
		public void setBatchId(String batchId) {
			this.batchId = batchId;
		}
		public String getCheckStockResults() {
			return checkStockResults;
		}
		public void setCheckStockResults(String checkStockResults) {
			this.checkStockResults = checkStockResults;
		}
		public String getReason() {
			return reason;
		}
		public void setReason(String reason) {
			this.reason = reason;
		}
		public BigDecimal getEntityQuantity() {
			return entityQuantity;
		}
		public void setEntityQuantity(BigDecimal entityQuantity) {
			this.entityQuantity = entityQuantity;
		}
		public Date getCheckStockDate() {
			return checkStockDate;
		}
		public void setCheckStockDate(Date checkStockDate) {
			this.checkStockDate = checkStockDate;
		}
		public String getProductId() {
			return productId;
		}
		public void setProductId(String productId) {
			this.productId = productId;
		}
		public Boolean getSelect() {
			return select;
		}
		public void setSelect(Boolean select) {
			this.select = select;
		}
		public java.math.BigDecimal getSumPrice() {
			return sumPrice;
		}
		public void setSumPrice(java.math.BigDecimal sumPrice) {
			this.sumPrice = sumPrice;
		}

}

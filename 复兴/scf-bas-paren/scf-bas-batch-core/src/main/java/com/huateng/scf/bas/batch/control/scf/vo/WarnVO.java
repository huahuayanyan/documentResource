/*
 * 功  能：预警VO
 *
 * 文件名：WarnVO.java
 *
 * 描  述：
 *
 * [变更履历]
 * Version   变更日         部署              作者           变更内容
 * -----------------------------------------------------------------------------
 * V1.00     2011-9-1   huateng   hui.liu      create
 * -----------------------------------------------------------------------------
 *
 *
 * Copyright (c) 2011 huateng All Rights Reserved.
 *┌─────────────────────────────────────────────────—────┐
 *│ 版权声明                               topcheer      │
 *└──────────────────────────────—————————————————————───┘
 */

package com.huateng.scf.bas.batch.control.scf.vo;

import java.util.Date;

/**
 *  预警VO
 *
 * <p>
 * <a href="WarnVO.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:liu_hui@huateng.com">hui.liu</a>
 *
 * @version Revision: 1.0  Date: 2011-9-1 上午10:08:26
 *
 */

public class WarnVO {

	private java.lang.Boolean  selected;

	private java.lang.String mortgageClass;
	private java.lang.String mortgageClassName;
	private java.lang.String mortgageSubClassName;
	private java.lang.String mortgageModelName;

	// TblWarnMortMiniPrice
	private java.lang.String id;
	private java.util.Date txdate;
	private java.lang.String mastContno;
	private java.lang.String protocolNo;
	private java.math.BigDecimal financingAmount;
	private java.math.BigDecimal bailAmount;
	private java.math.BigDecimal protLowPric;
	private java.math.BigDecimal realAmount;
	private java.lang.String status;
	private java.util.Date signDate;
	private java.util.Date dueDate;
	private java.math.BigDecimal bailAmt;
	private java.math.BigDecimal totPrice;

	// TblWarnDueInfo
	// private java.lang.Integer id;
	private java.lang.String warnDueType;
	// private java.util.Date txdate;
	private java.lang.String businessnoType;
	private java.lang.String custcd;
	private java.util.Date endDate;
	private java.util.Date startDate;
	private java.lang.String warnStatus;
	private java.lang.String businessNo;
	private java.lang.String firName;
	private java.lang.String firActUbankno;
	private java.lang.String firActno;
	private java.math.BigDecimal rate;
	private java.math.BigDecimal rateType;
	private java.lang.String businessno;
	private java.lang.String billno;
	// TblWarnMortFlucPrice
	// private java.lang.Integer id;
	// private java.lang.String mastContno;
	private java.lang.String cname;
	private java.lang.String mortgagelass;
	private java.lang.String mortgageSubClass;
	private java.lang.String mortgageModel;
	private java.lang.String mortgageUnits;
	private java.math.BigDecimal originalPrice;
	private java.math.BigDecimal price;
	private java.lang.Integer fluctuation;

	// TblWarnMortRepayFreq
	// private java.lang.Integer id;
	// private java.lang.String mastContno;
	private java.lang.String debetId;
	private java.lang.String lnciName;
	private java.math.BigDecimal lnciAmt;
	private java.lang.Integer lnciBal;
	private java.lang.Integer unrepayTime;
	private java.util.Date repaymentDate;
	// private java.util.Date endDate;

	// TblWarnMortMiniPrice
	// private java.util.Date txdate;
	// private java.lang.String mastContno;
	// private java.lang.String protocolNo;
	// private java.math.BigDecimal financingAmount;
	// private java.math.BigDecimal bailAmount;
	// private java.math.BigDecimal protLowPric;
	// private java.math.BigDecimal realAmount;
	// private java.lang.String status;
	private java.lang.String slaveContno;
	private java.lang.String warnLine;
	private java.math.BigDecimal warnValue;
	private java.math.BigDecimal originalTotPrice;
	// private java.lang.String custcd;
	private java.math.BigDecimal portAmt;
	private java.math.BigDecimal slaveContAmt;

	// TblMortgagePriceHis
	private java.lang.String mortgageNo;
	// private java.util.Date txdate;
	private java.lang.String priceWay;
	private java.lang.String evalOrg;
	private java.util.Date evalTime;
	private java.lang.String curcd;
	// private java.math.BigDecimal price;
	private java.lang.String tlrcd;
	private java.lang.String priceBasis;
	private java.lang.String priceSource;
	private java.lang.String description;
	private java.math.BigDecimal priceOld;
	private java.math.BigDecimal priceNew;
	private java.lang.String ext1;
	private java.lang.String ext2;
	private java.lang.String ext3;
	private java.lang.String appno;
	private java.lang.String thrName;
	private java.lang.String ruleName;
	private java.lang.String monitoryType;
	private java.lang.String moniType;
	private java.lang.String levels;
	private java.lang.String saleLine;
	private java.lang.String MoniOfCustCd;
	private java.lang.String ChkStockStart;
	private java.lang.String ChkStockCfTlr;
	private java.util.Date ChkStockStartDate;
	private java.util.Date ChkStockCfDate;
	private java.math.BigDecimal ChkStockAmt;
	private java.lang.String ChkStockType;
	private java.lang.String WarnStatue;

	private java.lang.String monitorProtocolNo;
	private java.lang.String moniOfCustcd;
	private java.lang.String goodsName;
	private java.lang.String mortgageLevelFour;
	private java.lang.String warehouseAddress;
	private java.math.BigDecimal quantity;
	private java.math.BigDecimal confirmPrice;
	private java.lang.String sn;
	private java.util.Date firstStorageDate;
	private java.lang.String lastUpdTime;
	private java.lang.Long lastUpdOperId;

	//TblWarnParam
	private java.lang.String warnNo;  //预警编号
	private java.lang.String warnName; //预警名称
	private java.lang.String warnType; //预警类型
	private java.lang.String suspendFlag;  //是否可忽略
	private java.lang.Integer suspendDay;  //可忽略天数
	private java.lang.String targetType;  //预警目标类型
	private java.lang.String targetBrclass;   //目标机构级别
	private java.lang.Integer targetRoleid;  //目标岗位
	private java.lang.String packageId;  //所属包id
	private java.lang.String warnProcess;  // 预警程序
	private java.lang.String warnLevelLow; // 低级阀值
	private java.lang.String warnLevelMidi; // 中级阀值
	private java.lang.String warnLevelHigh; // 高级阀值
	private java.lang.String warnBussType; // 预警归属业务种类【动产/预付款/应收账款】
	private java.lang.String tlrno; // 最后更新操作员
	private java.lang.String url;
	//TblContDebtBaseInfo
	private java.lang.String mastContcode;
	private java.lang.String debtBussType;
	private java.math.BigDecimal loanPercent;
	private java.lang.String mastContStatus;
	//TblWarnDebtBaseInfo
	private java.lang.String billsNo;//发票号码
	private java.math.BigDecimal billsAmount;//发票总额
	private java.lang.String isRecourse;//是否追索
	private java.lang.String billsStatus;//发票状态
	private java.util.Date debtEnd;//发票到期日期

	//TblWarnDebtLoanDueInfo
	private java.lang.Integer warnId;
	private java.util.Date billsDate;
	private java.util.Date warnDate;
	private java.lang.String cnameBuyer;
	private java.lang.String cnameSeller;
	private java.lang.String custcdBuyer;
	private java.lang.String custcdSeller;
	private java.lang.String debtBussName;
	private java.lang.Integer loanAmount;
	//TblWarnBaseInfo
	private java.lang.String custManager;
	private java.lang.String brcode;
	private java.lang.String warnLevel;

	private java.math.BigDecimal  volatility;//波动率
	private java.math.BigDecimal lowPrice;//最低价值

	private java.math.BigDecimal poolUseableAmount;//池可融资余额
	private java.math.BigDecimal totalDebtAmount;//发票总金额

	private java.math.BigDecimal money;//争议金额
	private java.lang.String topProductId;//业务品种大类
	private java.lang.String productId;//业务品种小类
	
	//TblWarnCreditInfo
	private java.lang.String otherCustcd;
	private java.lang.String otherCname;
	private java.math.BigDecimal creditUsedAmount;
	private java.math.BigDecimal creditBusiUsedAmount;
	private java.lang.String creditType;
	private java.util.Date validDate;
	private java.math.BigDecimal creditAmount;
	private java.math.BigDecimal creditUsableAmount;
	private java.math.BigDecimal preUsedAmount;

	//TblWarnCheckStock
	private java.lang.String slaveContcode;
	private java.lang.String moniCustcd;
	private java.lang.String moniCname ;
	private java.math.BigDecimal mortAmt ;
	private java.math.BigDecimal checkAmt ;
	private java.util.Date confirmDate ;
	private java.lang.String checkType ;
	private java.lang.String checkResult;
	private java.lang.String checkStatus;
	 
	
	
	public java.lang.String getTopProductId() {
		return topProductId;
	}

	public void setTopProductId(java.lang.String topProductId) {
		this.topProductId = topProductId;
	}

	public java.lang.String getProductId() {
		return productId;
	}

	public void setProductId(java.lang.String productId) {
		this.productId = productId;
	}

	public java.lang.String getSlaveContcode() {
		return slaveContcode;
	}

	public void setSlaveContcode(java.lang.String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}

	public java.lang.String getMoniCustcd() {
		return moniCustcd;
	}

	public void setMoniCustcd(java.lang.String moniCustcd) {
		this.moniCustcd = moniCustcd;
	}

	public java.lang.String getMoniCname() {
		return moniCname;
	}

	public void setMoniCname(java.lang.String moniCname) {
		this.moniCname = moniCname;
	}

	public java.math.BigDecimal getMortAmt() {
		return mortAmt;
	}

	public void setMortAmt(java.math.BigDecimal mortAmt) {
		this.mortAmt = mortAmt;
	}

	public java.math.BigDecimal getCheckAmt() {
		return checkAmt;
	}

	public void setCheckAmt(java.math.BigDecimal checkAmt) {
		this.checkAmt = checkAmt;
	}

	public java.util.Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(java.util.Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	public java.lang.String getCheckType() {
		return checkType;
	}

	public void setCheckType(java.lang.String checkType) {
		this.checkType = checkType;
	}

	public java.lang.String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(java.lang.String checkResult) {
		this.checkResult = checkResult;
	}

	public java.lang.String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(java.lang.String checkStatus) {
		this.checkStatus = checkStatus;
	}

	public java.lang.String getCreditType() {
		return creditType;
	}

	public void setCreditType(java.lang.String creditType) {
		this.creditType = creditType;
	}

	public java.util.Date getValidDate() {
		return validDate;
	}

	public void setValidDate(java.util.Date validDate) {
		this.validDate = validDate;
	}

	public java.math.BigDecimal getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(java.math.BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	public java.math.BigDecimal getCreditUsableAmount() {
		return creditUsableAmount;
	}

	public void setCreditUsableAmount(java.math.BigDecimal creditUsableAmount) {
		this.creditUsableAmount = creditUsableAmount;
	}

	public java.math.BigDecimal getPreUsedAmount() {
		return preUsedAmount;
	}

	public void setPreUsedAmount(java.math.BigDecimal preUsedAmount) {
		this.preUsedAmount = preUsedAmount;
	}

	public java.lang.String getOtherCustcd() {
		return otherCustcd;
	}

	public void setOtherCustcd(java.lang.String otherCustcd) {
		this.otherCustcd = otherCustcd;
	}

	public java.lang.String getOtherCname() {
		return otherCname;
	}

	public void setOtherCname(java.lang.String otherCname) {
		this.otherCname = otherCname;
	}

	public java.math.BigDecimal getCreditUsedAmount() {
		return creditUsedAmount;
	}

	public void setCreditUsedAmount(java.math.BigDecimal creditUsedAmount) {
		this.creditUsedAmount = creditUsedAmount;
	}

	public java.math.BigDecimal getCreditBusiUsedAmount() {
		return creditBusiUsedAmount;
	}

	public void setCreditBusiUsedAmount(java.math.BigDecimal creditBusiUsedAmount) {
		this.creditBusiUsedAmount = creditBusiUsedAmount;
	}

	public java.lang.String getBillsNo() {
		return billsNo;
	}

	public void setBillsNo(java.lang.String billsNo) {
		this.billsNo = billsNo;
	}

	public java.math.BigDecimal getBillsAmount() {
		return billsAmount;
	}

	public void setBillsAmount(java.math.BigDecimal billsAmount) {
		this.billsAmount = billsAmount;
	}

	public java.lang.String getIsRecourse() {
		return isRecourse;
	}

	public void setIsRecourse(java.lang.String isRecourse) {
		this.isRecourse = isRecourse;
	}

	public java.lang.String getBillsStatus() {
		return billsStatus;
	}

	public void setBillsStatus(java.lang.String billsStatus) {
		this.billsStatus = billsStatus;
	}

	public java.util.Date getDebtEnd() {
		return debtEnd;
	}

	public void setDebtEnd(java.util.Date debtEnd) {
		this.debtEnd = debtEnd;
	}

	public WarnVO(){
	}

	public WarnVO(java.lang.String id,String custcd,String billno,java.util.Date txdate,java.util.Date endDate,java.math.BigDecimal price,String businessno){
		this.id = id;
		this.custcd = custcd;
		this.billno = billno;
		this.txdate = txdate;
		this.endDate = endDate;
		this.price =price;
		this.businessno = businessno;
	}
	public WarnVO(java.lang.String id,String custcd,String billno,java.util.Date txdate,java.util.Date endDate,String ruleName,String ext1){
		this.id = id;
		this.custcd = custcd;
		this.billno = billno;
		this.txdate = txdate;
		this.endDate = endDate;
		this.ruleName = ruleName;
		this.ext1 = ext1;
	}

	public java.math.BigDecimal getSlaveContAmt() {
		return slaveContAmt;
	}

	public void setSlaveContAmt(java.math.BigDecimal slaveContAmt) {
		this.slaveContAmt = slaveContAmt;
	}

	public java.lang.String getWarnLine() {
		return warnLine;
	}

	public void setWarnLine(java.lang.String warnLine) {
		this.warnLine = warnLine;
	}

	public java.math.BigDecimal getWarnValue() {
		return warnValue;
	}

	public void setWarnValue(java.math.BigDecimal warnValue) {
		this.warnValue = warnValue;
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.util.Date getTxdate() {
		return txdate;
	}

	public void setTxdate(java.util.Date txdate) {
		this.txdate = txdate;
	}

	public java.lang.String getMastContno() {
		return mastContno;
	}

	public void setMastContno(java.lang.String mastContno) {
		this.mastContno = mastContno;
	}

	public java.lang.String getProtocolNo() {
		return protocolNo;
	}

	public void setProtocolNo(java.lang.String protocolNo) {
		this.protocolNo = protocolNo;
	}

	public java.math.BigDecimal getFinancingAmount() {
		return financingAmount;
	}

	public void setFinancingAmount(java.math.BigDecimal financingAmount) {
		this.financingAmount = financingAmount;
	}

	public java.math.BigDecimal getBailAmount() {
		return bailAmount;
	}

	public void setBailAmount(java.math.BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}

	public java.math.BigDecimal getProtLowPric() {
		return protLowPric;
	}

	public void setProtLowPric(java.math.BigDecimal protLowPric) {
		this.protLowPric = protLowPric;
	}

	public java.math.BigDecimal getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(java.math.BigDecimal realAmount) {
		this.realAmount = realAmount;
	}

	public java.lang.String getStatus() {
		return status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public java.lang.String getWarnDueType() {
		return warnDueType;
	}

	public void setWarnDueType(java.lang.String warnDueType) {
		this.warnDueType = warnDueType;
	}

	public java.lang.String getBusinessnoType() {
		return businessnoType;
	}

	public void setBusinessnoType(java.lang.String businessnoType) {
		this.businessnoType = businessnoType;
	}

	public java.lang.String getCustcd() {
		return custcd;
	}

	public void setCustcd(java.lang.String custcd) {
		this.custcd = custcd;
	}

	public java.util.Date getEndDate() {
		return endDate;
	}

	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}

	public java.lang.String getWarnStatus() {
		return warnStatus;
	}

	public void setWarnStatus(java.lang.String warnStatus) {
		this.warnStatus = warnStatus;
	}

	public java.lang.String getCname() {
		return cname;
	}

	public void setCname(java.lang.String cname) {
		this.cname = cname;
	}

	public java.lang.String getMortgagelass() {
		return mortgagelass;
	}

	public void setMortgagelass(java.lang.String mortgagelass) {
		this.mortgagelass = mortgagelass;
	}

	public java.lang.String getMortgageSubClass() {
		return mortgageSubClass;
	}

	public void setMortgageSubClass(java.lang.String mortgageSubClass) {
		this.mortgageSubClass = mortgageSubClass;
	}

	public java.lang.String getMortgageModel() {
		return mortgageModel;
	}

	public void setMortgageModel(java.lang.String mortgageModel) {
		this.mortgageModel = mortgageModel;
	}

	public java.lang.String getMortgageUnits() {
		return mortgageUnits;
	}

	public void setMortgageUnits(java.lang.String mortgageUnits) {
		this.mortgageUnits = mortgageUnits;
	}

	public java.math.BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(java.math.BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public java.math.BigDecimal getPrice() {
		return price;
	}

	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}

	public java.lang.Integer getFluctuation() {
		return fluctuation;
	}

	public void setFluctuation(java.lang.Integer fluctuation) {
		this.fluctuation = fluctuation;
	}

	public java.lang.String getDebetId() {
		return debetId;
	}

	public void setDebetId(java.lang.String debetId) {
		this.debetId = debetId;
	}

	public java.lang.String getLnciName() {
		return lnciName;
	}

	public void setLnciName(java.lang.String lnciName) {
		this.lnciName = lnciName;
	}

	public java.math.BigDecimal getLnciAmt() {
		return lnciAmt;
	}

	public void setLnciAmt(java.math.BigDecimal lnciAmt) {
		this.lnciAmt = lnciAmt;
	}

	public java.lang.Integer getLnciBal() {
		return lnciBal;
	}

	public void setLnciBal(java.lang.Integer lnciBal) {
		this.lnciBal = lnciBal;
	}

	public java.lang.Integer getUnrepayTime() {
		return unrepayTime;
	}

	public void setUnrepayTime(java.lang.Integer unrepayTime) {
		this.unrepayTime = unrepayTime;
	}

	public java.util.Date getRepaymentDate() {
		return repaymentDate;
	}

	public void setRepaymentDate(java.util.Date repaymentDate) {
		this.repaymentDate = repaymentDate;
	}

	public java.lang.String getBusinessNo() {
		return businessNo;
	}

	public java.lang.String getBillno() {
		return billno;
	}

	public void setBillno(java.lang.String billno) {
		this.billno = billno;
	}

	public void setBusinessNo(java.lang.String businessNo) {
		this.businessNo = businessNo;
	}

	public java.lang.String getSlaveContno() {
		return slaveContno;
	}

	public void setSlaveContno(java.lang.String slaveContno) {
		this.slaveContno = slaveContno;
	}

	public java.math.BigDecimal getOriginalTotPrice() {
		return originalTotPrice;
	}

	public void setOriginalTotPrice(java.math.BigDecimal originalTotPrice) {
		this.originalTotPrice = originalTotPrice;
	}

	public java.math.BigDecimal getPortAmt() {
		return portAmt;
	}

	public void setPortAmt(java.math.BigDecimal portAmt) {
		this.portAmt = portAmt;
	}

	public java.util.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	public java.lang.String getFirName() {
		return firName;
	}

	public void setFirName(java.lang.String firName) {
		this.firName = firName;
	}

	public java.lang.String getFirActUbankno() {
		return firActUbankno;
	}

	public void setFirActUbankno(java.lang.String firActUbankno) {
		this.firActUbankno = firActUbankno;
	}

	public java.lang.String getFirActno() {
		return firActno;
	}

	public void setFirActno(java.lang.String firActno) {
		this.firActno = firActno;
	}

	public java.math.BigDecimal getRate() {
		return rate;
	}

	public void setRate(java.math.BigDecimal rate) {
		this.rate = rate;
	}

	public java.math.BigDecimal getRateType() {
		return rateType;
	}

	public void setRateType(java.math.BigDecimal rateType) {
		this.rateType = rateType;
	}

	public java.lang.String getMortgageClass() {
		return mortgageClass;
	}

	public void setMortgageClass(java.lang.String mortgageClass) {
		this.mortgageClass = mortgageClass;
	}

	public java.lang.String getMortgageClassName() {
		return mortgageClassName;
	}

	public void setMortgageClassName(java.lang.String mortgageClassName) {
		this.mortgageClassName = mortgageClassName;
	}

	public java.lang.String getMortgageSubClassName() {
		return mortgageSubClassName;
	}

	public void setMortgageSubClassName(java.lang.String mortgageSubClassName) {
		this.mortgageSubClassName = mortgageSubClassName;
	}

	public java.lang.String getMortgageModelName() {
		return mortgageModelName;
	}

	public void setMortgageModelName(java.lang.String mortgageModelName) {
		this.mortgageModelName = mortgageModelName;
	}

	public java.lang.String getMortgageNo() {
		return mortgageNo;
	}

	public void setMortgageNo(java.lang.String mortgageNo) {
		this.mortgageNo = mortgageNo;
	}

	public java.lang.String getPriceWay() {
		return priceWay;
	}

	public void setPriceWay(java.lang.String priceWay) {
		this.priceWay = priceWay;
	}

	public java.lang.String getEvalOrg() {
		return evalOrg;
	}

	public void setEvalOrg(java.lang.String evalOrg) {
		this.evalOrg = evalOrg;
	}

	public Date getEvalTime() {
		return evalTime;
	}

	public void setEvalTime(Date evalTime) {
		this.evalTime = evalTime;
	}

	public java.lang.String getCurcd() {
		return curcd;
	}

	public void setCurcd(java.lang.String curcd) {
		this.curcd = curcd;
	}

	public java.lang.String getTlrcd() {
		return tlrcd;
	}

	public void setTlrcd(java.lang.String tlrcd) {
		this.tlrcd = tlrcd;
	}

	public java.lang.String getPriceBasis() {
		return priceBasis;
	}

	public void setPriceBasis(java.lang.String priceBasis) {
		this.priceBasis = priceBasis;
	}

	public java.lang.String getPriceSource() {
		return priceSource;
	}

	public void setPriceSource(java.lang.String priceSource) {
		this.priceSource = priceSource;
	}

	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public java.math.BigDecimal getPriceOld() {
		return priceOld;
	}

	public void setPriceOld(java.math.BigDecimal priceOld) {
		this.priceOld = priceOld;
	}

	public java.math.BigDecimal getPriceNew() {
		return priceNew;
	}

	public void setPriceNew(java.math.BigDecimal priceNew) {
		this.priceNew = priceNew;
	}

	public java.lang.String getExt1() {
		return ext1;
	}

	public void setExt1(java.lang.String ext1) {
		this.ext1 = ext1;
	}

	public java.lang.String getExt2() {
		return ext2;
	}

	public void setExt2(java.lang.String ext2) {
		this.ext2 = ext2;
	}

	public java.lang.String getExt3() {
		return ext3;
	}

	public void setExt3(java.lang.String ext3) {
		this.ext3 = ext3;
	}

	public java.lang.String getAppno() {
		return appno;
	}

	public void setAppno(java.lang.String appno) {
		this.appno = appno;
	}

	public java.lang.String getBusinessno() {
		return businessno;
	}

	public void setBusinessno(java.lang.String businessno) {
		this.businessno = businessno;
	}

	public java.lang.Boolean getSelected() {
		return selected;
	}

	public void setSelected(java.lang.Boolean selected) {
		this.selected = selected;
	}

	public java.lang.String getThrName() {
		return thrName;
	}

	public void setThrName(java.lang.String thrName) {
		this.thrName = thrName;
	}

	public java.lang.String getMonitoryType() {
		return monitoryType;
	}

	public void setMonitoryType(java.lang.String monitoryType) {
		this.monitoryType = monitoryType;
	}

	public java.lang.String getLevels() {
		return levels;
	}

	public void setLevels(java.lang.String levels) {
		this.levels = levels;
	}

	public java.lang.String getRuleName() {
		return ruleName;
	}

	public void setRuleName(java.lang.String ruleName) {
		this.ruleName = ruleName;
	}

	public java.lang.String getSaleLine() {
		return saleLine;
	}

	public void setSaleLine(java.lang.String saleLine) {
		this.saleLine = saleLine;
	}

	public java.lang.String getMoniType() {
		return moniType;
	}

	public void setMoniType(java.lang.String moniType) {
		this.moniType = moniType;
	}

	public java.util.Date getSignDate() {
		return signDate;
	}

	public void setSignDate(java.util.Date signDate) {
		this.signDate = signDate;
	}

	public java.util.Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(java.util.Date dueDate) {
		this.dueDate = dueDate;
	}

	public java.math.BigDecimal getBailAmt() {
		return bailAmt;
	}

	public void setBailAmt(java.math.BigDecimal bailAmt) {
		this.bailAmt = bailAmt;
	}

	public java.math.BigDecimal getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(java.math.BigDecimal totPrice) {
		this.totPrice = totPrice;
	}

	public java.lang.String getMoniOfCustCd() {
		return MoniOfCustCd;
	}

	public void setMoniOfCustCd(java.lang.String moniOfCustCd) {
		MoniOfCustCd = moniOfCustCd;
	}

	public java.lang.String getChkStockStart() {
		return ChkStockStart;
	}

	public void setChkStockStart(java.lang.String chkStockStart) {
		ChkStockStart = chkStockStart;
	}

	public java.lang.String getChkStockCfTlr() {
		return ChkStockCfTlr;
	}

	public void setChkStockCfTlr(java.lang.String chkStockCfTlr) {
		ChkStockCfTlr = chkStockCfTlr;
	}

	public java.util.Date getChkStockStartDate() {
		return ChkStockStartDate;
	}

	public void setChkStockStartDate(java.util.Date chkStockStartDate) {
		ChkStockStartDate = chkStockStartDate;
	}

	public java.util.Date getChkStockCfDate() {
		return ChkStockCfDate;
	}

	public void setChkStockCfDate(java.util.Date chkStockCfDate) {
		ChkStockCfDate = chkStockCfDate;
	}

	public java.math.BigDecimal getChkStockAmt() {
		return ChkStockAmt;
	}

	public void setChkStockAmt(java.math.BigDecimal chkStockAmt) {
		ChkStockAmt = chkStockAmt;
	}

	public java.lang.String getChkStockType() {
		return ChkStockType;
	}

	public void setChkStockType(java.lang.String chkStockType) {
		ChkStockType = chkStockType;
	}

	public java.lang.String getWarnStatue() {
		return WarnStatue;
	}

	public void setWarnStatue(java.lang.String warnStatue) {
		WarnStatue = warnStatue;
	}

	public java.lang.String getMonitorProtocolNo() {
		return monitorProtocolNo;
	}

	public void setMonitorProtocolNo(java.lang.String monitorProtocolNo) {
		this.monitorProtocolNo = monitorProtocolNo;
	}

	public java.lang.String getMoniOfCustcd() {
		return moniOfCustcd;
	}

	public void setMoniOfCustcd(java.lang.String moniOfCustcd) {
		this.moniOfCustcd = moniOfCustcd;
	}

	public java.lang.String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(java.lang.String goodsName) {
		this.goodsName = goodsName;
	}

	public java.lang.String getMortgageLevelFour() {
		return mortgageLevelFour;
	}

	public void setMortgageLevelFour(java.lang.String mortgageLevelFour) {
		this.mortgageLevelFour = mortgageLevelFour;
	}

	public java.lang.String getWarehouseAddress() {
		return warehouseAddress;
	}

	public void setWarehouseAddress(java.lang.String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	public java.math.BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(java.math.BigDecimal quantity) {
		this.quantity = quantity;
	}

	public java.math.BigDecimal getConfirmPrice() {
		return confirmPrice;
	}

	public void setConfirmPrice(java.math.BigDecimal confirmPrice) {
		this.confirmPrice = confirmPrice;
	}

	public java.lang.String getSn() {
		return sn;
	}

	public void setSn(java.lang.String sn) {
		this.sn = sn;
	}

	public java.util.Date getFirstStorageDate() {
		return firstStorageDate;
	}

	public void setFirstStorageDate(java.util.Date firstStorageDate) {
		this.firstStorageDate = firstStorageDate;
	}

	public java.lang.String getLastUpdTime() {
		return lastUpdTime;
	}

	public void setLastUpdTime(java.lang.String lastUpdTime) {
		this.lastUpdTime = lastUpdTime;
	}

	public java.lang.Long getLastUpdOperId() {
		return lastUpdOperId;
	}

	public void setLastUpdOperId(java.lang.Long lastUpdOperId) {
		this.lastUpdOperId = lastUpdOperId;
	}

	public java.lang.String getWarnNo() {
		return warnNo;
	}

	public void setWarnNo(java.lang.String warnNo) {
		this.warnNo = warnNo;
	}

	public java.lang.String getWarnName() {
		return warnName;
	}

	public void setWarnName(java.lang.String warnName) {
		this.warnName = warnName;
	}

	public java.lang.String getWarnType() {
		return warnType;
	}

	public void setWarnType(java.lang.String warnType) {
		this.warnType = warnType;
	}

	public java.lang.String getSuspendFlag() {
		return suspendFlag;
	}

	public void setSuspendFlag(java.lang.String suspendFlag) {
		this.suspendFlag = suspendFlag;
	}

	public java.lang.Integer getSuspendDay() {
		return suspendDay;
	}

	public void setSuspendDay(java.lang.Integer suspendDay) {
		this.suspendDay = suspendDay;
	}

	public java.lang.String getTargetType() {
		return targetType;
	}

	public void setTargetType(java.lang.String targetType) {
		this.targetType = targetType;
	}

	public java.lang.String getTargetBrclass() {
		return targetBrclass;
	}

	public void setTargetBrclass(java.lang.String targetBrclass) {
		this.targetBrclass = targetBrclass;
	}

	public java.lang.Integer getTargetRoleid() {
		return targetRoleid;
	}

	public void setTargetRoleid(java.lang.Integer targetRoleid) {
		this.targetRoleid = targetRoleid;
	}

	public java.lang.String getPackageId() {
		return packageId;
	}

	public void setPackageId(java.lang.String packageId) {
		this.packageId = packageId;
	}

	public java.lang.String getWarnProcess() {
		return warnProcess;
	}

	public void setWarnProcess(java.lang.String warnProcess) {
		this.warnProcess = warnProcess;
	}

	public java.lang.String getWarnLevelLow() {
		return warnLevelLow;
	}

	public void setWarnLevelLow(java.lang.String warnLevelLow) {
		this.warnLevelLow = warnLevelLow;
	}

	public java.lang.String getWarnLevelMidi() {
		return warnLevelMidi;
	}

	public void setWarnLevelMidi(java.lang.String warnLevelMidi) {
		this.warnLevelMidi = warnLevelMidi;
	}

	public java.lang.String getWarnLevelHigh() {
		return warnLevelHigh;
	}

	public void setWarnLevelHigh(java.lang.String warnLevelHigh) {
		this.warnLevelHigh = warnLevelHigh;
	}

	public java.lang.String getWarnBussType() {
		return warnBussType;
	}

	public void setWarnBussType(java.lang.String warnBussType) {
		this.warnBussType = warnBussType;
	}

	public java.lang.String getTlrno() {
		return tlrno;
	}

	public void setTlrno(java.lang.String tlrno) {
		this.tlrno = tlrno;
	}

	public java.lang.String getMastContcode() {
		return mastContcode;
	}

	public void setMastContcode(java.lang.String mastContcode) {
		this.mastContcode = mastContcode;
	}

	public java.lang.String getDebtBussType() {
		return debtBussType;
	}

	public void setDebtBussType(java.lang.String debtBussType) {
		this.debtBussType = debtBussType;
	}

	public java.math.BigDecimal getLoanPercent() {
		return loanPercent;
	}

	public void setLoanPercent(java.math.BigDecimal loanPercent) {
		this.loanPercent = loanPercent;
	}

	public java.lang.String getMastContStatus() {
		return mastContStatus;
	}

	public void setMastContStatus(java.lang.String mastContStatus) {
		this.mastContStatus = mastContStatus;
	}

	public java.lang.Integer getWarnId() {
		return warnId;
	}

	public void setWarnId(java.lang.Integer warnId) {
		this.warnId = warnId;
	}

	public java.util.Date getBillsDate() {
		return billsDate;
	}

	public void setBillsDate(java.util.Date billsDate) {
		this.billsDate = billsDate;
	}

	public java.util.Date getWarnDate() {
		return warnDate;
	}

	public void setWarnDate(java.util.Date warnDate) {
		this.warnDate = warnDate;
	}

	public java.lang.String getCnameBuyer() {
		return cnameBuyer;
	}

	public void setCnameBuyer(java.lang.String cnameBuyer) {
		this.cnameBuyer = cnameBuyer;
	}

	public java.lang.String getCnameSeller() {
		return cnameSeller;
	}

	public void setCnameSeller(java.lang.String cnameSeller) {
		this.cnameSeller = cnameSeller;
	}

	public java.lang.String getCustcdBuyer() {
		return custcdBuyer;
	}

	public void setCustcdBuyer(java.lang.String custcdBuyer) {
		this.custcdBuyer = custcdBuyer;
	}

	public java.lang.String getCustcdSeller() {
		return custcdSeller;
	}

	public void setCustcdSeller(java.lang.String custcdSeller) {
		this.custcdSeller = custcdSeller;
	}

	public java.lang.String getDebtBussName() {
		return debtBussName;
	}

	public void setDebtBussName(java.lang.String debtBussName) {
		this.debtBussName = debtBussName;
	}

	public java.lang.Integer getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(java.lang.Integer loanAmount) {
		this.loanAmount = loanAmount;
	}

	public java.lang.String getUrl() {
		return url;
	}

	public void setUrl(java.lang.String url) {
		this.url = url;
	}

	public java.lang.String getCustManager() {
		return custManager;
	}

	public void setCustManager(java.lang.String custManager) {
		this.custManager = custManager;
	}

	public java.lang.String getBrcode() {
		return brcode;
	}

	public void setBrcode(java.lang.String brcode) {
		this.brcode = brcode;
	}

	public java.lang.String getWarnLevel() {
		return warnLevel;
	}

	public void setWarnLevel(java.lang.String warnLevel) {
		this.warnLevel = warnLevel;
	}

	public java.math.BigDecimal getVolatility() {
		return volatility;
	}

	public void setVolatility(java.math.BigDecimal volatility) {
		this.volatility = volatility;
	}

	public java.math.BigDecimal getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(java.math.BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}

	public java.math.BigDecimal getPoolUseableAmount() {
		return poolUseableAmount;
	}

	public void setPoolUseableAmount(java.math.BigDecimal poolUseableAmount) {
		this.poolUseableAmount = poolUseableAmount;
	}

	public java.math.BigDecimal getTotalDebtAmount() {
		return totalDebtAmount;
	}

	public void setTotalDebtAmount(java.math.BigDecimal totalDebtAmount) {
		this.totalDebtAmount = totalDebtAmount;
	}

	public java.math.BigDecimal getMoney() {
		return money;
	}

	public void setMoney(java.math.BigDecimal money) {
		this.money = money;
	}
}

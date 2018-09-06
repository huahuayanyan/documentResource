package com.huateng.scf.nrec.bcp.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class RBcpDuebillAppVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private BigDecimal avaliableRiskAmt;//信贷合同可用敞口
    private BigDecimal totalBillsAmount;//应收账款总额
    private BigDecimal poolUseableAmount;//TBL_DEBT_POOL中可融资金额
    public BigDecimal getPoolUseableAmount() {
		return poolUseableAmount;
	}

	public void setPoolUseableAmount(BigDecimal poolUseableAmount) {
		this.poolUseableAmount = poolUseableAmount;
	}

	public BigDecimal getTotalBillsAmount() {
		return totalBillsAmount;
	}

	public void setTotalBillsAmount(BigDecimal totalBillsAmount) {
		this.totalBillsAmount = totalBillsAmount;
	}

	public BigDecimal getAvaliableRiskAmt() {
		return avaliableRiskAmt;
	}

	public void setAvaliableRiskAmt(BigDecimal avaliableRiskAmt) {
		this.avaliableRiskAmt = avaliableRiskAmt;
	}

	private BigDecimal poolRiskAmt;//池敞口余额（核心）
    
    public BigDecimal getPoolRiskAmt() {
		return poolRiskAmt;
	}

	public void setPoolRiskAmt(BigDecimal poolRiskAmt) {
		this.poolRiskAmt = poolRiskAmt;
	}

	private BigDecimal loanRemainingAmount;
    public BigDecimal getLoanRemainingAmount() {
		return loanRemainingAmount;
	}

	public void setLoanRemainingAmount(BigDecimal loanRemainingAmount) {
		this.loanRemainingAmount = loanRemainingAmount;
	}

	private String factType;
    private String financingType;
    public String getFactType() {
		return factType;
	}

	public void setFactType(String factType) {
		this.factType = factType;
	}

	public String getFinancingType() {
		return financingType;
	}

	public void setFinancingType(String financingType) {
		this.financingType = financingType;
	}

	/**
	 * DECIMAL(9,6) 必填<br>
	 * 融资比例(%)
	 */
	private BigDecimal loanPercent;
    public BigDecimal getLoanPercent() {
		return loanPercent;
	}

	public void setLoanPercent(BigDecimal loanPercent) {
		this.loanPercent = loanPercent;
	}

	private String appliType;
    private String processName;
    private BigDecimal billNum;
    private BigDecimal totalPrice;
    private BigDecimal ableNum;
    public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getAbleNum() {
		return ableNum;
	}

	public void setAbleNum(BigDecimal ableNum) {
		this.ableNum = ableNum;
	}

	public BigDecimal getBillNum() {
		return billNum;
	}

	public void setBillNum(BigDecimal billNum) {
		this.billNum = billNum;
	}

	public String getAppliType() {
		return appliType;
	}

	public void setAppliType(String appliType) {
		this.appliType = appliType;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	private String businessName;//贸易对手名称
    private String cname;//融资企业
    private String returnAccountName;//回款帐号名称
    private String returnAccountBank;//回款帐号开户行
    private String accountName;//收款账户名称
    private String accountBank;//收款账户开户行
    private String actBrNm;//资金提供方客户名
    private String payActName;//资金提供方账户名称
    private String payActBank;//资金提供方开户行
    public String getReturnAccountName() {
		return returnAccountName;
	}

	public void setReturnAccountName(String returnAccountName) {
		this.returnAccountName = returnAccountName;
	}

	public String getReturnAccountBank() {
		return returnAccountBank;
	}

	public void setReturnAccountBank(String returnAccountBank) {
		this.returnAccountBank = returnAccountBank;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}

	public String getActBrNm() {
		return actBrNm;
	}

	public void setActBrNm(String actBrNm) {
		this.actBrNm = actBrNm;
	}

	public String getPayActName() {
		return payActName;
	}

	public void setPayActName(String payActName) {
		this.payActName = payActName;
	}

	public String getPayActBank() {
		return payActBank;
	}

	public void setPayActBank(String payActBank) {
		this.payActBank = payActBank;
	}

    public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
     * VARCHAR(32) 必填<br>
     * 放款编号
     */
    private String appno;

    /**
     * VARCHAR(40)<br>
     * 合同流水号
     */
    private String mastContno;

    /**
     * VARCHAR(3)<br>
     * 申请状态
     */
    private String appStat;

    /**
     * VARCHAR(15) 必填<br>
     * 融资企业
     */
    private String custcd;

    /**
     * VARCHAR(15) 必填<br>
     * 买方客户号/承租人客户号
     */
    private String businessCustcd;

    /**
     * VARCHAR(10) 必填<br>
     * 业务种类：国内保理;反向保理;应收账款质押;国内双保理;信保保理;租赁保理
     */
    private String supplyChainPdId;

    /**
     * VARCHAR(50)<br>
     * 结算账号/收款账号
     */
    private String accountNo;

    /**
     * CHAR(8)<br>
     * 合同生效日期
     */
    private String startDate;

    /**
     * CHAR(8)<br>
     * 合同到期日期
     */
    private String endDate;

    /**
     * DECIMAL(22)<br>
     * 期限月
     */
    private BigDecimal trmMon;

    /**
     * DECIMAL(22)<br>
     * 期限日
     */
    private BigDecimal trmDay;

    /**
     * DECIMAL(22,2) 默认值[0]<br>
     * 出账金额
     */
    private BigDecimal lnAmt;

    /**
     * DECIMAL(22,2)<br>
     * 出账余额
     */
    private BigDecimal lnSum;

    /**
     * VARCHAR(50)<br>
     * 回款专户
     */
    private String returnAccount;

    /**
     * DECIMAL(10,6) 默认值[0]<br>
     * 执行利率
     */
    private BigDecimal actInt;

    /**
     * DECIMAL(11,7)<br>
     * 手续费/管理费率
     */
    private BigDecimal feeRate;

    /**
     * DECIMAL(11,7)<br>
     * 保理费率
     */
    private BigDecimal blFeeRate;

    /**
     * VARCHAR(10)<br>
     * 计息周期
     */
    private String jxPeriod;

    /**
     * DECIMAL(2)<br>
     * 结息日
     */
    private Short jxDay;

    /**
     * VARCHAR(10)<br>
     * 收费/还款方式
     */
    private String returnType;

    /**
     * DECIMAL(2)<br>
     * 
     */
    private Short yqDay;

    /**
     * DECIMAL(11,7)<br>
     * 
     */
    private BigDecimal yqRate;

    /**
     * VARCHAR(20)<br>
     * 账务机构
     */
    private String actBrCd;

    /**
     * VARCHAR(20)<br>
     * 放款账号/资金提供方帐号
     */
    private String payActNo;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * VARCHAR(32)<br>
     * 占用额度编号
     */
    private String crNo;

    /**
     * VARCHAR(32)<br>
     * 登记人
     */
    private String tlrNo;

    /**
     * VARCHAR(60)<br>
     * 登记人姓名
     */
    private String tlrNm;

    /**
     * VARCHAR(20)<br>
     * 机构号
     */
    private String brCd;

    /**
     * VARCHAR(60)<br>
     * 登记机构名称
     */
    private String brNm;

    /**
     * VARCHAR(20)<br>
     * 登记时间
     */
    private String inpDt;

    /**
     * VARCHAR(20)<br>
     * 最后更新操作员号
     */
    private String lstUpdTlr;

    /**
     * VARCHAR(60)<br>
     * 更新人名称
     */
    private String lstUpdTlrNm;

    /**
     * VARCHAR(32)<br>
     * 更新机构
     */
    private String lstUpdBrCd;

    /**
     * VARCHAR(60)<br>
     * 更新机构名称
     */
    private String lstUpdBrNm;

    /**
     * VARCHAR(20)<br>
     * 最后更新时间
     */
    private String lstUpdDt;

    /**
     * VARCHAR(10)<br>
     * 间接额度类型
     */
    private String indrctCrdt;

    /**
     * VARCHAR(60)<br>
     * 间接额度占用客户号
     */
    private String crdtCustCd;

    /**
     * VARCHAR(60)<br>
     * 间接额度占用客户名
     */
    private String crdtCustNm;

    /**
     * VARCHAR(32)<br>
     * 额度编号
     */
    private String crdtCrNo;

    /**
     * VARCHAR(20)<br>
     * 备注1
     */
    private String ext1;

    /**
     * VARCHAR(20)<br>
     * 备注2
     */
    private String ext2;

    /**
     * VARCHAR(20)<br>
     * 备注3
     */
    private String ext3;

    /**
     * VARCHAR(20)<br>
     * 备注4
     */
    private String ext4;

    /**
     * VARCHAR(20)<br>
     * 备注5
     */
    private String ext5;
    
	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}

	public String getMastContno() {
		return mastContno;
	}

	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}

	public String getAppStat() {
		return appStat;
	}

	public void setAppStat(String appStat) {
		this.appStat = appStat;
	}

	public String getCustcd() {
		return custcd;
	}

	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}

	public String getBusinessCustcd() {
		return businessCustcd;
	}

	public void setBusinessCustcd(String businessCustcd) {
		this.businessCustcd = businessCustcd;
	}

	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}

	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
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

	public BigDecimal getTrmMon() {
		return trmMon;
	}

	public void setTrmMon(BigDecimal trmMon) {
		this.trmMon = trmMon;
	}

	public BigDecimal getTrmDay() {
		return trmDay;
	}

	public void setTrmDay(BigDecimal trmDay) {
		this.trmDay = trmDay;
	}

	public BigDecimal getLnAmt() {
		return lnAmt;
	}

	public void setLnAmt(BigDecimal lnAmt) {
		this.lnAmt = lnAmt;
	}

	public BigDecimal getLnSum() {
		return lnSum;
	}

	public void setLnSum(BigDecimal lnSum) {
		this.lnSum = lnSum;
	}

	public String getReturnAccount() {
		return returnAccount;
	}

	public void setReturnAccount(String returnAccount) {
		this.returnAccount = returnAccount;
	}

	public BigDecimal getActInt() {
		return actInt;
	}

	public void setActInt(BigDecimal actInt) {
		this.actInt = actInt;
	}

	public BigDecimal getFeeRate() {
		return feeRate;
	}

	public void setFeeRate(BigDecimal feeRate) {
		this.feeRate = feeRate;
	}

	public BigDecimal getBlFeeRate() {
		return blFeeRate;
	}

	public void setBlFeeRate(BigDecimal blFeeRate) {
		this.blFeeRate = blFeeRate;
	}

	public String getJxPeriod() {
		return jxPeriod;
	}

	public void setJxPeriod(String jxPeriod) {
		this.jxPeriod = jxPeriod;
	}

	public Short getJxDay() {
		return jxDay;
	}

	public void setJxDay(Short jxDay) {
		this.jxDay = jxDay;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public Short getYqDay() {
		return yqDay;
	}

	public void setYqDay(Short yqDay) {
		this.yqDay = yqDay;
	}

	public BigDecimal getYqRate() {
		return yqRate;
	}

	public void setYqRate(BigDecimal yqRate) {
		this.yqRate = yqRate;
	}

	public String getActBrCd() {
		return actBrCd;
	}

	public void setActBrCd(String actBrCd) {
		this.actBrCd = actBrCd;
	}

	public String getPayActNo() {
		return payActNo;
	}

	public void setPayActNo(String payActNo) {
		this.payActNo = payActNo;
	}

	public String getCurcd() {
		return curcd;
	}

	public void setCurcd(String curcd) {
		this.curcd = curcd;
	}

	public String getCrNo() {
		return crNo;
	}

	public void setCrNo(String crNo) {
		this.crNo = crNo;
	}

	public String getTlrNo() {
		return tlrNo;
	}

	public void setTlrNo(String tlrNo) {
		this.tlrNo = tlrNo;
	}

	public String getTlrNm() {
		return tlrNm;
	}

	public void setTlrNm(String tlrNm) {
		this.tlrNm = tlrNm;
	}

	public String getBrCd() {
		return brCd;
	}

	public void setBrCd(String brCd) {
		this.brCd = brCd;
	}

	public String getBrNm() {
		return brNm;
	}

	public void setBrNm(String brNm) {
		this.brNm = brNm;
	}

	public String getInpDt() {
		return inpDt;
	}

	public void setInpDt(String inpDt) {
		this.inpDt = inpDt;
	}

	public String getLstUpdTlr() {
		return lstUpdTlr;
	}

	public void setLstUpdTlr(String lstUpdTlr) {
		this.lstUpdTlr = lstUpdTlr;
	}

	public String getLstUpdTlrNm() {
		return lstUpdTlrNm;
	}

	public void setLstUpdTlrNm(String lstUpdTlrNm) {
		this.lstUpdTlrNm = lstUpdTlrNm;
	}

	public String getLstUpdBrCd() {
		return lstUpdBrCd;
	}

	public void setLstUpdBrCd(String lstUpdBrCd) {
		this.lstUpdBrCd = lstUpdBrCd;
	}

	public String getLstUpdBrNm() {
		return lstUpdBrNm;
	}

	public void setLstUpdBrNm(String lstUpdBrNm) {
		this.lstUpdBrNm = lstUpdBrNm;
	}

	public String getLstUpdDt() {
		return lstUpdDt;
	}

	public void setLstUpdDt(String lstUpdDt) {
		this.lstUpdDt = lstUpdDt;
	}

	public String getIndrctCrdt() {
		return indrctCrdt;
	}

	public void setIndrctCrdt(String indrctCrdt) {
		this.indrctCrdt = indrctCrdt;
	}

	public String getCrdtCustCd() {
		return crdtCustCd;
	}

	public void setCrdtCustCd(String crdtCustCd) {
		this.crdtCustCd = crdtCustCd;
	}

	public String getCrdtCustNm() {
		return crdtCustNm;
	}

	public void setCrdtCustNm(String crdtCustNm) {
		this.crdtCustNm = crdtCustNm;
	}

	public String getCrdtCrNo() {
		return crdtCrNo;
	}

	public void setCrdtCrNo(String crdtCrNo) {
		this.crdtCrNo = crdtCrNo;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public String getExt4() {
		return ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}

	public String getExt5() {
		return ext5;
	}

	public void setExt5(String ext5) {
		this.ext5 = ext5;
	}
}
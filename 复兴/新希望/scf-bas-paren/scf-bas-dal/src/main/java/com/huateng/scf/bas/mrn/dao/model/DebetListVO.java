/**
 * 
 */
package com.huateng.scf.bas.mrn.dao.model;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年2月7日上午10:17:23
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
public class DebetListVO {
	private boolean select;
	private String appno;
	private String debetNo;
	private String debetId;
	private String mastContno;
	private String mastContcode;
	private String lnciType;
	private String startDate;
	private String endDate;
	private BigDecimal lnciAmt;
	private BigDecimal lnciBal;
	private BigDecimal totalRateRemainAmount;
	private String lnciStatus;
	private BigDecimal bailAmount;
	private String bailAccount;
	private BigDecimal addBailAmount;
	private BigDecimal addCashEqtAmt;     // 追加现金等价物金额
	private BigDecimal initCashEqtAmt;    // 初始现金等价物金额
	private BigDecimal riskAmt;           //敞口余额
	private BigDecimal addNewBailAmount;  //本次新追加的保证金冻结金额
	private String incomeAppno;  //出账流水号
	private String loanAppno;//融资出账流水号
	private BigDecimal receivableInt;//欠息金额
	public String getIncomeAppno() {
		return incomeAppno;
	}
	public void setIncomeAppno(String incomeAppno) {
		this.incomeAppno = incomeAppno;
	}
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
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
	public String getDebetId() {
		return debetId;
	}
	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}
	public String getMastContno() {
		return mastContno;
	}
	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}
	public String getMastContcode() {
		return mastContcode;
	}
	public void setMastContcode(String mastContcode) {
		this.mastContcode = mastContcode;
	}
	public String getLnciType() {
		return lnciType;
	}
	public void setLnciType(String lnciType) {
		this.lnciType = lnciType;
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
	public BigDecimal getLnciAmt() {
		return lnciAmt;
	}
	public void setLnciAmt(BigDecimal lnciAmt) {
		this.lnciAmt = lnciAmt;
	}
	public BigDecimal getLnciBal() {
		return lnciBal;
	}
	public void setLnciBal(BigDecimal lnciBal) {
		this.lnciBal = lnciBal;
	}
	public BigDecimal getTotalRateRemainAmount() {
		return totalRateRemainAmount;
	}
	public void setTotalRateRemainAmount(BigDecimal totalRateRemainAmount) {
		this.totalRateRemainAmount = totalRateRemainAmount;
	}
	public String getLnciStatus() {
		return lnciStatus;
	}
	public void setLnciStatus(String lnciStatus) {
		this.lnciStatus = lnciStatus;
	}
	public BigDecimal getBailAmount() {
		return bailAmount;
	}
	public void setBailAmount(BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}
	public String getBailAccount() {
		return bailAccount;
	}
	public void setBailAccount(String bailAccount) {
		this.bailAccount = bailAccount;
	}
	public BigDecimal getAddBailAmount() {
		return addBailAmount;
	}
	public void setAddBailAmount(BigDecimal addBailAmount) {
		this.addBailAmount = addBailAmount;
	}
	public BigDecimal getAddCashEqtAmt() {
		return addCashEqtAmt;
	}
	public void setAddCashEqtAmt(BigDecimal addCashEqtAmt) {
		this.addCashEqtAmt = addCashEqtAmt;
	}

	public BigDecimal getInitCashEqtAmt() {
		return initCashEqtAmt;
	}
	public void setInitCashEqtAmt(BigDecimal initCashEqtAmt) {
		this.initCashEqtAmt = initCashEqtAmt;
	}
	public BigDecimal getRiskAmt() {
		return riskAmt;
	}
	public void setRiskAmt(BigDecimal riskAmt) {
		this.riskAmt = riskAmt;
	}
	public BigDecimal getAddNewBailAmount() {
		return addNewBailAmount;
	}
	public void setAddNewBailAmount(BigDecimal addNewBailAmount) {
		this.addNewBailAmount = addNewBailAmount;
	}
	public String getLoanAppno() {
		return loanAppno;
	}
	public void setLoanAppno(String loanAppno) {
		this.loanAppno = loanAppno;
	}
	public BigDecimal getReceivableInt() {
		return receivableInt;
	}
	public void setReceivableInt(BigDecimal receivableInt) {
		this.receivableInt = receivableInt;
	}

}

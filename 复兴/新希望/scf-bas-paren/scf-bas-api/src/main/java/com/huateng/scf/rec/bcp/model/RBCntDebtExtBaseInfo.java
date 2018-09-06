package com.huateng.scf.rec.bcp.model;

import java.math.BigDecimal;

public class RBCntDebtExtBaseInfo {
	private static final long serialVersionUID = 1L;
	private String custCd;// 卖方编号
	private String buyerCd;// 买方编号
	private String custName;// 卖方名称
	private String buyerName;// 买方名称
	private String debtContno;// 池合同号
	private String supplyChainPdId;// 业务品种
	private BigDecimal totalBillsAmount;// 池应收账款余额
	private BigDecimal poolRiskAmt;// 池敞口余额
	private String bailAccount;// 池保证金账号
	private BigDecimal bailAmount;// 池保证金余额
    private String startDate;//合同生效日
    private String endDate;//合同到期日
	public String getCustCd() {
		return custCd;
	}
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	public String getBuyerCd() {
		return buyerCd;
	}
	public void setBuyerCd(String buyerCd) {
		this.buyerCd = buyerCd;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getDebtContno() {
		return debtContno;
	}
	public void setDebtContno(String debtContno) {
		this.debtContno = debtContno;
	}
	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}
	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}
	public BigDecimal getTotalBillsAmount() {
		return totalBillsAmount;
	}
	public void setTotalBillsAmount(BigDecimal totalBillsAmount) {
		this.totalBillsAmount = totalBillsAmount;
	}
	public BigDecimal getPoolRiskAmt() {
		return poolRiskAmt;
	}
	public void setPoolRiskAmt(BigDecimal poolRiskAmt) {
		this.poolRiskAmt = poolRiskAmt;
	}
	public String getBailAccount() {
		return bailAccount;
	}
	public void setBailAccount(String bailAccount) {
		this.bailAccount = bailAccount;
	}
	public BigDecimal getBailAmount() {
		return bailAmount;
	}
	public void setBailAmount(BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
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
	

}

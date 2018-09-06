package com.huateng.scf.bas.pbc.model;

import java.math.BigDecimal;

import com.huateng.base.common.beans.Page;

public class SlaveProtoContInfo {

	private String appno;// 申请号

	private String conId;// 抵/质押合同号

	private String secName;// 出质人名称

	private String prtclNo;// 监管合同编号

	private String thrName;// 监管公司名称

	private String productId;// 业务品种

	private String moniType;// 货押模式

	private BigDecimal ration;// 质押率(%)

	private BigDecimal mortgageAmount;// 已入库押品总价值

	private BigDecimal amount;// 本次申请入库押品总价值

	private BigDecimal openAmount;// 敞口余额

	private BigDecimal lowPriceNew;// 最低控货价值

	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}

	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}

	public String getSecName() {
		return secName;
	}

	public void setSecName(String secName) {
		this.secName = secName;
	}

	public String getPrtclNo() {
		return prtclNo;
	}

	public void setPrtclNo(String prtclNo) {
		this.prtclNo = prtclNo;
	}

	public String getThrName() {
		return thrName;
	}

	public void setThrName(String thrName) {
		this.thrName = thrName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getMoniType() {
		return moniType;
	}

	public void setMoniType(String moniType) {
		this.moniType = moniType;
	}

	public BigDecimal getRation() {
		return ration;
	}

	public void setRation(BigDecimal ration) {
		this.ration = ration;
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

	public BigDecimal getLowPriceNew() {
		return lowPriceNew;
	}

	public void setLowPriceNew(BigDecimal lowPriceNew) {
		this.lowPriceNew = lowPriceNew;
	}

	@Override
	public String toString() {
		return "SlaveProtoContInfo [conId=" + conId + ", secName=" + secName + ", prtclNo=" + prtclNo + ", thrName=" + thrName + ", productId="
				+ productId + ", moniType=" + moniType + ", ration=" + ration + ", mortgageAmount=" + mortgageAmount + ", amount=" + amount
				+ ", openAmount=" + openAmount + ", lowPriceNew=" + lowPriceNew + "]";
	}

}

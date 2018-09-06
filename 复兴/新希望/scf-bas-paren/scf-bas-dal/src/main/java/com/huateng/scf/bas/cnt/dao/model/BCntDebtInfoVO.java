package com.huateng.scf.bas.cnt.dao.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * @author htrad0055
 *
 */
public class BCntDebtInfoVO extends BCntDebtInfo {
	
	private String cname;
	
	private String buyerName;
	
	private String productName;
	
	private String mgrno;
	
	private String buyerCustcd;
	
	private BigDecimal amount;
	private Integer debtNum;
	private Date insertDate;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getDebtNum() {
		return debtNum;
	}

	public void setDebtNum(Integer debtNum) {
		this.debtNum = debtNum;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMgrno() {
		return mgrno;
	}

	public void setMgrno(String mgrno) {
		this.mgrno = mgrno;
	}

	public String getBuyerCustcd() {
		return buyerCustcd;
	}

	public void setBuyerCustcd(String buyerCustcd) {
		this.buyerCustcd = buyerCustcd;
	}
	
	

}

package com.huateng.scf.bas.cnt.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author htrad0055
 *
 */
public class BCntDebtInfoVO extends BCntDebtInfo {

	private Date disputeDate;

	private Integer disputeCount;

	private BigDecimal disputeAmount;
	
	private String cname;
	
	private String buyerName;
	
	private String productName;
	
	private String mgrno;
	
	private String buyerCustcd;
	private List<BCntDebtExtInfo> voList=new ArrayList();

	public Date getDisputeDate() {
		return disputeDate;
	}

	public void setDisputeDate(Date disputeDate) {
		this.disputeDate = disputeDate;
	}

	public Integer getDisputeCount() {
		return disputeCount;
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

	public void setDisputeCount(Integer disputeCount) {
		this.disputeCount = disputeCount;
	}

	public BigDecimal getDisputeAmount() {
		return disputeAmount;
	}

	public void setDisputeAmount(BigDecimal disputeAmount) {
		this.disputeAmount = disputeAmount;
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

	public List<BCntDebtExtInfo> getVoList() {
		return voList;
	}

	public void setVoList(List<BCntDebtExtInfo> voList) {
		this.voList = voList;
	}
	
	

}

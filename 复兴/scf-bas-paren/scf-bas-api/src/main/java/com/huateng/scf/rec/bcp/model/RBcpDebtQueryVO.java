package com.huateng.scf.rec.bcp.model;

import java.math.BigDecimal;
import java.util.Date;

import com.huateng.scf.bas.cnt.model.BCntDebtExtInfo;

public class RBcpDebtQueryVO extends RBcpDebtBaseInfo {
	
	/**
	 * 争议金额
	 */
	private BigDecimal issueAmt;
	
	/**
	 * 争议原因
	 */
	private String issueReason;
	
	
	public BigDecimal getIssueAmt() {
		return issueAmt;
	}

	public void setIssueAmt(BigDecimal issueAmt) {
		this.issueAmt = issueAmt;
	}

	public String getIssueReason() {
		return issueReason;
	}

	public void setIssueReason(String issueReason) {
		this.issueReason = issueReason;
	}
	
	

}

package com.huateng.scf.bas.pbc.model;

import java.math.BigDecimal;

public class BPbcAppliExt {
	
	private BigDecimal deliverValue;
	public BigDecimal getDeliverValue() {
		return deliverValue;
	}
	public void setDeliverValue(BigDecimal deliverValue) {
		this.deliverValue = deliverValue;
	}
	
	private String startTaskDate;
	private String startTlrcdName;
	private String startBrcodeName;
	private String comment;
	
	public String getStartTaskDate() {
		return startTaskDate;
	}
	public void setStartTaskDate(String startTaskDate) {
		this.startTaskDate = startTaskDate;
	}
	public String getStartTlrcdName() {
		return startTlrcdName;
	}
	public void setStartTlrcdName(String startTlrcdName) {
		this.startTlrcdName = startTlrcdName;
	}
	public String getStartBrcodeName() {
		return startBrcodeName;
	}
	public void setStartBrcodeName(String startBrcodeName) {
		this.startBrcodeName = startBrcodeName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}

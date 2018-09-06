package com.huateng.scf.rec.bcp.model;

import java.io.Serializable;

public class WriteoffInfo  implements Serializable{
	private static final long serialVersionUID = 1L;

	private String writeoffDate;//核销日期
	private String writeoffReason;//核销原因
	private String otherReason;//其它原因
	private String writeoffCount;//核销总份数
	private String writeoffAmount;//核销总金额
	public String getWriteoffDate() {
		return writeoffDate;
	}
	public void setWriteoffDate(String writeoffDate) {
		this.writeoffDate = writeoffDate;
	}
	public String getWriteoffReason() {
		return writeoffReason;
	}
	public void setWriteoffReason(String writeoffReason) {
		this.writeoffReason = writeoffReason;
	}
	public String getOtherReason() {
		return otherReason;
	}
	public void setOtherReason(String otherReason) {
		this.otherReason = otherReason;
	}
	public String getWriteoffCount() {
		return writeoffCount;
	}
	public void setWriteoffCount(String writeoffCount) {
		this.writeoffCount = writeoffCount;
	}
	public String getWriteoffAmount() {
		return writeoffAmount;
	}
	public void setWriteoffAmount(String writeoffAmount) {
		this.writeoffAmount = writeoffAmount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

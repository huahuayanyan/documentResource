package com.huateng.scf.rec.bcp.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImpairmentInfo  implements Serializable{
	private static final long serialVersionUID = 1L;

	private String impairmentDate;//减值日期
	private Integer impairmentCount;//减值总份数
	private BigDecimal impairmentAmount;//减值总金额
	private String impairmentReason;//减值原因
	private String remark;//备注
	public String getImpairmentDate() {
		return impairmentDate;
	}
	public void setImpairmentDate(String impairmentDate) {
		this.impairmentDate = impairmentDate;
	}
	public Integer getImpairmentCount() {
		return impairmentCount;
	}
	public void setImpairmentCount(Integer impairmentCount) {
		this.impairmentCount = impairmentCount;
	}
	public BigDecimal getImpairmentAmount() {
		return impairmentAmount;
	}
	public void setImpairmentAmount(BigDecimal impairmentAmount) {
		this.impairmentAmount = impairmentAmount;
	}
	public String getImpairmentReason() {
		return impairmentReason;
	}
	public void setImpairmentReason(String impairmentReason) {
		this.impairmentReason = impairmentReason;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}

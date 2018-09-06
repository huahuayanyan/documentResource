
package com.huateng.scf.bas.cnt.model;

import java.math.BigDecimal;

public class ContSelectVO {
	private String protocolNo;
	private String protocolCode;
	private BigDecimal firstBailRatio;
	private String firstBailType;
	private String arrivedManageMode ;
	private String loanWay;
	private String coreCustcd; //核心客戶
	private String coreNm;
	private String Custcd;
	private String Cname;
	public String getArrivedManageMode() {
		return arrivedManageMode;
	}
	public void setArrivedManageMode(String arrivedManageMode) {
		this.arrivedManageMode = arrivedManageMode;
	}
	public String getLoanWay() {
		return loanWay;
	}
	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	}
	public String getProtocolNo() {
		return protocolNo;
	}
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}
	public String getProtocolCode() {
		return protocolCode;
	}
	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}
	public BigDecimal getFirstBailRatio() {
		return firstBailRatio;
	}
	public void setFirstBailRatio(BigDecimal firstBailRatio) {
		this.firstBailRatio = firstBailRatio;
	}
	public String getFirstBailType() {
		return firstBailType;
	}
	public void setFirstBailType(String firstBailType) {
		this.firstBailType = firstBailType;
	}

	public String getCoreNm() {
		return coreNm;
	}
	public void setCoreNm(String coreNm) {
		this.coreNm = coreNm;
	}
	public String getCoreCustcd() {
		return coreCustcd;
	}
	public void setCoreCustcd(String coreCustcd) {
		this.coreCustcd = coreCustcd;
	}
	/**
	 * @return the custcd
	 */
	public String getCustcd() {
		return Custcd;
	}
	/**
	 * @param custcd the custcd to set
	 */
	public void setCustcd(String custcd) {
		Custcd = custcd;
	}
	/**
	 * @return the cname
	 */
	public String getCname() {
		return Cname;
	}
	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		Cname = cname;
	}
	

}

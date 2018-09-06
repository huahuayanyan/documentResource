package com.huateng.scf.bas.pbc.model;

import java.math.BigDecimal;

public class GntyconInfo {
	
    private String prtclNo;//监管合同编号
    
    private String conId;//抵/质押合同号
    
    private String productId;//业务品种
    
    private BigDecimal ration;//质押率(%)
    
    private BigDecimal guardRat;//市值质押率警戒线(%)
    
	private String secName;//出质人名称
    
    private String gutyTyp;//担保类型
    
    private String conStat;//合同状态

    private String gutCurcd;//担保币种
    
    private String thrName;//监管公司名称
   
    private BigDecimal gutVal;//合同金额
	
    private String startDate;//合同生效日
	
    private String endDate;//合同到期日
	
    private String tlrName;//客户经理
	
    private String brcodeNm;//经办机构

	public String getPrtclNo() {
		return prtclNo;
	}

	public void setPrtclNo(String prtclNo) {
		this.prtclNo = prtclNo;
	}

	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public BigDecimal getRation() {
		return ration;
	}

	public void setRation(BigDecimal ration) {
		this.ration = ration;
	}

	public BigDecimal getGuardRat() {
		return guardRat;
	}

	public void setGuardRat(BigDecimal guardRat) {
		this.guardRat = guardRat;
	}

	public String getSecName() {
		return secName;
	}

	public void setSecName(String secName) {
		this.secName = secName;
	}

	public String getGutyTyp() {
		return gutyTyp;
	}

	public void setGutyTyp(String gutyTyp) {
		this.gutyTyp = gutyTyp;
	}

	public String getConStat() {
		return conStat;
	}

	public void setConStat(String conStat) {
		this.conStat = conStat;
	}

	public String getGutCurcd() {
		return gutCurcd;
	}

	public void setGutCurcd(String gutCurcd) {
		this.gutCurcd = gutCurcd;
	}

	public String getThrName() {
		return thrName;
	}

	public void setThrName(String thrName) {
		this.thrName = thrName;
	}

	public BigDecimal getGutVal() {
		return gutVal;
	}

	public void setGutVal(BigDecimal gutVal) {
		this.gutVal = gutVal;
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

	public String getTlrName() {
		return tlrName;
	}

	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}

	public String getBrcodeNm() {
		return brcodeNm;
	}

	public void setBrcodeNm(String brcodeNm) {
		this.brcodeNm = brcodeNm;
	}

	@Override
	public String toString() {
		return "GntyconInfo [prtclNo=" + prtclNo + ", conId=" + conId + ", productId=" + productId + ", ration="
				+ ration + ", guardRat=" + guardRat + ", secName=" + secName + ", gutyTyp=" + gutyTyp + ", conStat="
				+ conStat + ", gutCurcd=" + gutCurcd + ", thrName=" + thrName + ", gutVal=" + gutVal + ", startDate="
				+ startDate + ", endDate=" + endDate + ", tlrName=" + tlrName + ", brcodeNm=" + brcodeNm + "]";
	}

}

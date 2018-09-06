package com.huateng.scf.sto.pcb.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 价格调整申请内容MODEL
 * 
 * @author GONGZHAO
 *
 */
public class PriceAdjustVO {

	private String prtclBrNm;// 监管公司名称
	private String appno;//申请编号
	private String protocolCode;//监管合同号
	private String prtclNo;//监管协议编号
	private String conId;//抵/质押合同编号
	private String gutId;//出质人编号
	private String gutNm;//出质人名称
	private String pledgeMode;//发起模式
	private String moniMd;//货押模式
	private BigDecimal lowPriceNew;//最低控货价值
	private BigDecimal ration;//抵/质押率(%)
	private Date stratDate;//调整日期
	private BigDecimal bailAmount;//保证金及现金等价物总价值
	private BigDecimal openAmount;//敞口余额
	public String getPrtclBrNm() {
		return prtclBrNm;
	}
	public void setPrtclBrNm(String prtclBrNm) {
		this.prtclBrNm = prtclBrNm;
	}
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public String getProtocolCode() {
		return protocolCode;
	}
	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}
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
	public String getGutId() {
		return gutId;
	}
	public void setGutId(String gutId) {
		this.gutId = gutId;
	}
	public String getGutNm() {
		return gutNm;
	}
	public void setGutNm(String gutNm) {
		this.gutNm = gutNm;
	}
	public String getPledgeMode() {
		return pledgeMode;
	}
	public void setPledgeMode(String pledgeMode) {
		this.pledgeMode = pledgeMode;
	}
	public String getMoniMd() {
		return moniMd;
	}
	public void setMoniMd(String moniMd) {
		this.moniMd = moniMd;
	}
	public BigDecimal getLowPriceNew() {
		return lowPriceNew;
	}
	public void setLowPriceNew(BigDecimal lowPriceNew) {
		this.lowPriceNew = lowPriceNew;
	}
	public BigDecimal getRation() {
		return ration;
	}
	public void setRation(BigDecimal ration) {
		this.ration = ration;
	}
	public Date getStratDate() {
		return stratDate;
	}
	public void setStratDate(Date stratDate) {
		this.stratDate = stratDate;
	}
	public BigDecimal getBailAmount() {
		return bailAmount;
	}
	public void setBailAmount(BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}
	public BigDecimal getOpenAmount() {
		return openAmount;
	}
	public void setOpenAmount(BigDecimal openAmount) {
		this.openAmount = openAmount;
	}
	public BigDecimal getOriginalTotPrice() {
		return originalTotPrice;
	}
	public void setOriginalTotPrice(BigDecimal originalTotPrice) {
		this.originalTotPrice = originalTotPrice;
	}
	public BigDecimal getTotPrice() {
		return totPrice;
	}
	public void setTotPrice(BigDecimal totPrice) {
		this.totPrice = totPrice;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	private BigDecimal originalTotPrice;//调整前押品总价值
	private BigDecimal totPrice;//调整后押品总价值
	private String memo;//备注

}

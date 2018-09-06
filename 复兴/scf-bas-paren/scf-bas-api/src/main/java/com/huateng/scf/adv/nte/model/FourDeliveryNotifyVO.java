package com.huateng.scf.adv.nte.model;

import java.math.BigDecimal;

/**
 * @author htrad0055
 *	
 *  先票/款后货发货通知VO
 */

public class FourDeliveryNotifyVO {
	private String appno; //申请编号
	private String custName; //买方名称
	private String otherCustName; //卖方名称
	private String num; //收款确认函编号
	private String commonDate; //收款确认日
	private BigDecimal lnciAmt; //收款金额
	private String debetId; //借据号/承兑协议号
	private String deliveryNo; //发货通知编号
	private String deliveryDate; //发货日期
	private BigDecimal currentQuantity; //本次发货数量
	private BigDecimal currentAmt; //本次发货金额
	private BigDecimal remainAmt;  //剩余发货金额
	private String status; //状态
	private String signDate; //签发日期
	private String confirmStatus; //确认状态
	private String protocolCode; //先票/款后货协议号
	private String loanWay; //出账方式
	private BigDecimal balSendAmt; //剩余发货金额
	private String submitFlag; //提交标识
	private String deliveryAppno; // 发货通知申请编号
	private String custcd; //买方客户ID
	private String otherCustcd; //卖方客户ID
	private String debetNo; //借据号主键
	private String moniProtocolCode; //监管协议号
	private String noticeType;//通知书类型
	private String moniCname;
	private String brcode;
	private String sendMortgageNo;//发货通知ID（系统自动生成）
	private String protocolNo;//协议ID
	private String mastContno;//主合同iD
	private String moniProtocolNo;//监管协议号
	private String moniCustcd;
	private String brName;
	private String tlrn;
	private String tlrName;
	
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getOtherCustName() {
		return otherCustName;
	}
	public void setOtherCustName(String otherCustName) {
		this.otherCustName = otherCustName;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}

	public String getCommonDate() {
		return commonDate;
	}
	public void setCommonDate(String commonDate) {
		this.commonDate = commonDate;
	}

	public BigDecimal getLnciAmt() {
		return lnciAmt;
	}
	public void setLnciAmt(BigDecimal lnciAmt) {
		this.lnciAmt = lnciAmt;
	}
	public String getDebetId() {
		return debetId;
	}
	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}
	public String getDeliveryNo() {
		return deliveryNo;
	}
	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public BigDecimal getCurrentQuantity() {
		return currentQuantity;
	}
	public void setCurrentQuantity(BigDecimal currentQuantity) {
		this.currentQuantity = currentQuantity;
	}
	public BigDecimal getCurrentAmt() {
		return currentAmt;
	}
	public void setCurrentAmt(BigDecimal currentAmt) {
		this.currentAmt = currentAmt;
	}
	public BigDecimal getRemainAmt() {
		return remainAmt;
	}
	public void setRemainAmt(BigDecimal remainAmt) {
		this.remainAmt = remainAmt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSignDate() {
		return signDate;
	}
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
	public String getConfirmStatus() {
		return confirmStatus;
	}
	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}
	public String getProtocolCode() {
		return protocolCode;
	}
	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}
	public String getLoanWay() {
		return loanWay;
	}
	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	}
	public BigDecimal getBalSendAmt() {
		return balSendAmt;
	}
	public void setBalSendAmt(BigDecimal balSendAmt) {
		this.balSendAmt = balSendAmt;
	}
	public String getSubmitFlag() {
		return submitFlag;
	}
	public void setSubmitFlag(String submitFlag) {
		this.submitFlag = submitFlag;
	}
	public String getDeliveryAppno() {
		return deliveryAppno;
	}
	public void setDeliveryAppno(String deliveryAppno) {
		this.deliveryAppno = deliveryAppno;
	}
	public String getCustcd() {
		return custcd;
	}
	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}
	public String getOtherCustcd() {
		return otherCustcd;
	}
	public void setOtherCustcd(String otherCustcd) {
		this.otherCustcd = otherCustcd;
	}
	public String getDebetNo() {
		return debetNo;
	}
	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}
	public String getMoniProtocolCode() {
		return moniProtocolCode;
	}
	public void setMoniProtocolCode(String moniProtocolCode) {
		this.moniProtocolCode = moniProtocolCode;
	}
	public String getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	public String getMoniCname() {
		return moniCname;
	}
	public void setMoniCname(String moniCname) {
		this.moniCname = moniCname;
	}
	public String getBrcode() {
		return brcode;
	}
	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}
	/**
	 * @return the sendMortgageNo
	 */
	public String getSendMortgageNo() {
		return sendMortgageNo;
	}
	/**
	 * @param sendMortgageNo the sendMortgageNo to set
	 */
	public void setSendMortgageNo(String sendMortgageNo) {
		this.sendMortgageNo = sendMortgageNo;
	}
	/**
	 * @return the protocolNo
	 */
	public String getProtocolNo() {
		return protocolNo;
	}
	/**
	 * @param protocolNo the protocolNo to set
	 */
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}
	/**
	 * @return the mastContno
	 */
	public String getMastContno() {
		return mastContno;
	}
	/**
	 * @param mastContno the mastContno to set
	 */
	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}
	/**
	 * @return the moniProtocolNo
	 */
	public String getMoniProtocolNo() {
		return moniProtocolNo;
	}
	/**
	 * @param moniProtocolNo the moniProtocolNo to set
	 */
	public void setMoniProtocolNo(String moniProtocolNo) {
		this.moniProtocolNo = moniProtocolNo;
	}
	
	public String getMoniCustcd() {
		return moniCustcd;
	}
	
	public void setMoniCustcd(String moniCustcd) {
		this.moniCustcd = moniCustcd;
	}
	
	public String getBrName() {
		return brName;
	}
	
	public void setBrName(String brName) {
		this.brName = brName;
	}
	
	public String getTlrn() {
		return tlrn;
	}
	
	public void setTlrn(String tlrn) {
		this.tlrn = tlrn;
	}
	
	public String getTlrName() {
		return tlrName;
	}

	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}
	

}

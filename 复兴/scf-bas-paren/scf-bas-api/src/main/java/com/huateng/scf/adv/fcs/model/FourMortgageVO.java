/**
 * 
 */
package com.huateng.scf.adv.fcs.model;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年4月21日上午10:34:27
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月21日上午10:34:27              新增
 *
 * </pre>
 */


import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo;

public class FourMortgageVO extends BPbcMtgBaseInfo {

	private static final long serialVersionUID = 468400379452466460L;
	private String custcd;// 经销商ID
	private String custName;// 经销商名称
	private String coreCustcd;// 核心厂商ID
	private String coreCustName;// 核心厂商名称
	private String slaveContcode;// 核心厂商名称
	private String appno;// 业务申请编号
	private String id;// 业务申请id
	private String debetNo;// 借据号
	private BigDecimal number;// 提货数量
	private Boolean select = false;
	private String flag;
	private String protocolNo;// 协议号
	private BigDecimal totConfirmPrice;
	private BigDecimal balQuantity;
	private String documentNo;
	private String reason;
	private BigDecimal withdrawAmt;// 提货金额
	private String tradeContcode; //购销合同文本协议编号
	private BigDecimal totPrice; //发货金额
	private String transportMode ; //运输方式
	private String deliveryNo; //凭证号（发货通知编号）
	private String deliveryDate; //发货日期
	private String num; //收款确认编号
	private String debetId;//借据号
	private String moniType; //监管模式
	private String nid; //发货通知押品ID
	private String srcMortgageNo; //购销合同关联押品号
	private String mortgageLevelOneName; //押品一级名称
	private String mortgageLevelTwoName;//押品二级名称
	public String getCustcd() {
		return custcd;
	}

	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCoreCustcd() {
		return coreCustcd;
	}

	public void setCoreCustcd(String coreCustcd) {
		this.coreCustcd = coreCustcd;
	}

	public String getCoreCustName() {
		return coreCustName;
	}

	public void setCoreCustName(String coreCustName) {
		this.coreCustName = coreCustName;
	}

	public String getSlaveContcode() {
		return slaveContcode;
	}

	public void setSlaveContcode(String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDebetNo() {
		return debetNo;
	}

	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}

	public BigDecimal getNumber() {
		return number;
	}

	public void setNumber(BigDecimal number) {
		this.number = number;
	}

	public Boolean getSelect() {
		return select;
	}

	public void setSelect(Boolean select) {
		this.select = select;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getProtocolNo() {
		return protocolNo;
	}

	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}

	public BigDecimal getTotConfirmPrice() {
		return totConfirmPrice;
	}

	public void setTotConfirmPrice(BigDecimal totConfirmPrice) {
		this.totConfirmPrice = totConfirmPrice;
	}

	public BigDecimal getBalQuantity() {
		return balQuantity;
	}

	public void setBalQuantity(BigDecimal balQuantity) {
		this.balQuantity = balQuantity;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public BigDecimal getWithdrawAmt() {
		return withdrawAmt;
	}

	public void setWithdrawAmt(BigDecimal withdrawAmt) {
		this.withdrawAmt = withdrawAmt;
	}

	public String getTradeContcode() {
		return tradeContcode;
	}

	public void setTradeContcode(String tradeContcode) {
		this.tradeContcode = tradeContcode;
	}

	public BigDecimal getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(BigDecimal totPrice) {
		this.totPrice = totPrice;
	}

	public String getTransportMode() {
		return transportMode;
	}

	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getDebetId() {
		return debetId;
	}

	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}

	public String getMoniType() {
		return moniType;
	}

	public void setMoniType(String moniType) {
		this.moniType = moniType;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getSrcMortgageNo() {
		return srcMortgageNo;
	}

	public void setSrcMortgageNo(String srcMortgageNo) {
		this.srcMortgageNo = srcMortgageNo;
	}

	/**
	 * @return the mortgageLevelOneName
	 */
	public String getMortgageLevelOneName() {
		return mortgageLevelOneName;
	}

	/**
	 * @param mortgageLevelOneName the mortgageLevelOneName to set
	 */
	public void setMortgageLevelOneName(String mortgageLevelOneName) {
		this.mortgageLevelOneName = mortgageLevelOneName;
	}

	/**
	 * @return the mortgageLevelTwoName
	 */
	public String getMortgageLevelTwoName() {
		return mortgageLevelTwoName;
	}

	/**
	 * @param mortgageLevelTwoName the mortgageLevelTwoName to set
	 */
	public void setMortgageLevelTwoName(String mortgageLevelTwoName) {
		this.mortgageLevelTwoName = mortgageLevelTwoName;
	}
	
}

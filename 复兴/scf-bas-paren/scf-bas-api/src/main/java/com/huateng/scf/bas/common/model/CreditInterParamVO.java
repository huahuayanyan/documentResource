/**
 * 
 */
package com.huateng.scf.bas.common.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 额度接口VO
 * </p>
 *
 * @author huangshuidan
 * @date 2017年1月17日 下午3:27:14
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年1月17日下午3:27:14             新增
 *
 * </pre>
 */
public class CreditInterParamVO implements Serializable{
	private static final long serialVersionUID = 3623311540063411497L;
	private java.lang.String curcd;
	private java.lang.String  controlType;
	private java.util.Date  startDate;
	private java.util.Date  endDate;
	private java.lang.String  relaType;
	private java.lang.String  businessno;
	private java.lang.String  applyType;
	private java.lang.String  appno;
	private java.lang.String creditNo;
	private java.lang.String custcd;
	private java.lang.String otherCustcd;
	private java.lang.String creditType;
	private java.lang.String operType;
	private java.lang.String creditOperType;
	private java.math.BigDecimal amount;
	private java.lang.String releaseFlag;
	private java.lang.String creditPhase;
	private java.lang.String productId;
	
	
	
	
	public CreditInterParamVO() {
		
	}
	public CreditInterParamVO(String curcd, String controlType, Date startDate, Date endDate, String relaType,
			String businessno, String applyType, String appno, String creditNo, String custcd, String otherCustcd,
			String creditType, String operType, String creditOperType, BigDecimal amount, String releaseFlag,
			String creditPhase, String productId) {
		this.curcd = curcd;
		this.controlType = controlType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.relaType = relaType;
		this.businessno = businessno;
		this.applyType = applyType;
		this.appno = appno;
		this.creditNo = creditNo;
		this.custcd = custcd;
		this.otherCustcd = otherCustcd;
		this.creditType = creditType;
		this.operType = operType;
		this.creditOperType = creditOperType;
		this.amount = amount;
		this.releaseFlag = releaseFlag;
		this.creditPhase = creditPhase;
		this.productId = productId;
	}
	/**
	 * @return the curcd
	 */
	public java.lang.String getCurcd() {
		return curcd;
	}
	/**
	 * @param curcd the curcd to set
	 */
	public void setCurcd(java.lang.String curcd) {
		this.curcd = curcd;
	}
	/**
	 * @return the controlType
	 */
	public java.lang.String getControlType() {
		return controlType;
	}
	/**
	 * @param controlType the controlType to set
	 */
	public void setControlType(java.lang.String controlType) {
		this.controlType = controlType;
	}
	/**
	 * @return the startDate
	 */
	public java.util.Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public java.util.Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the relaType
	 */
	public java.lang.String getRelaType() {
		return relaType;
	}
	/**
	 * @param relaType the relaType to set
	 */
	public void setRelaType(java.lang.String relaType) {
		this.relaType = relaType;
	}
	/**
	 * @return the businessno
	 */
	public java.lang.String getBusinessno() {
		return businessno;
	}
	/**
	 * @param businessno the businessno to set
	 */
	public void setBusinessno(java.lang.String businessno) {
		this.businessno = businessno;
	}
	/**
	 * @return the applyType
	 */
	public java.lang.String getApplyType() {
		return applyType;
	}
	/**
	 * @param applyType the applyType to set
	 */
	public void setApplyType(java.lang.String applyType) {
		this.applyType = applyType;
	}
	/**
	 * @return the appno
	 */
	public java.lang.String getAppno() {
		return appno;
	}
	/**
	 * @param appno the appno to set
	 */
	public void setAppno(java.lang.String appno) {
		this.appno = appno;
	}
	/**
	 * @return the creditNo
	 */
	public java.lang.String getCreditNo() {
		return creditNo;
	}
	/**
	 * @param creditNo the creditNo to set
	 */
	public void setCreditNo(java.lang.String creditNo) {
		this.creditNo = creditNo;
	}
	/**
	 * @return the custcd
	 */
	public java.lang.String getCustcd() {
		return custcd;
	}
	/**
	 * @param custcd the custcd to set
	 */
	public void setCustcd(java.lang.String custcd) {
		this.custcd = custcd;
	}
	/**
	 * @return the otherCustcd
	 */
	public java.lang.String getOtherCustcd() {
		return otherCustcd;
	}
	/**
	 * @param otherCustcd the otherCustcd to set
	 */
	public void setOtherCustcd(java.lang.String otherCustcd) {
		this.otherCustcd = otherCustcd;
	}
	/**
	 * @return the creditType
	 */
	public java.lang.String getCreditType() {
		return creditType;
	}
	/**
	 * @param creditType the creditType to set
	 */
	public void setCreditType(java.lang.String creditType) {
		this.creditType = creditType;
	}
	/**
	 * @return the operType
	 */
	public java.lang.String getOperType() {
		return operType;
	}
	/**
	 * @param operType the operType to set
	 */
	public void setOperType(java.lang.String operType) {
		this.operType = operType;
	}
	/**
	 * @return the creditOperType
	 */
	public java.lang.String getCreditOperType() {
		return creditOperType;
	}
	/**
	 * @param creditOperType the creditOperType to set
	 */
	public void setCreditOperType(java.lang.String creditOperType) {
		this.creditOperType = creditOperType;
	}
	/**
	 * @return the amount
	 */
	public java.math.BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * @return the releaseFlag
	 */
	public java.lang.String getReleaseFlag() {
		return releaseFlag;
	}
	/**
	 * @param releaseFlag the releaseFlag to set
	 */
	public void setReleaseFlag(java.lang.String releaseFlag) {
		this.releaseFlag = releaseFlag;
	}
	/**
	 * @return the creditPhase
	 */
	public java.lang.String getCreditPhase() {
		return creditPhase;
	}
	/**
	 * @param creditPhase the creditPhase to set
	 */
	public void setCreditPhase(java.lang.String creditPhase) {
		this.creditPhase = creditPhase;
	}
	/**
	 * @return the productId
	 */
	public java.lang.String getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(java.lang.String productId) {
		this.productId = productId;
	}
	
	
}

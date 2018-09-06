/**
 * 
 */
package com.huateng.scf.bas.qry.dao.model;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年6月19日下午1:44:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年6月19日下午1:44:51              新增
 *
 * </pre>
 */
public class PostLoanWarnVO  {
	private String custcd;// 客户
	private String cname;// 客户名称
	private String postLoanWarnType;// 预警类型 1：业务预警，2财务指标预警
	private BigDecimal warnNum;// 预警总数
	

	//业务预警
	private String warnLevel; //预警级别
	private String warnDate; //预警日期
    private String warnNo; //预警编号
    private String warnName; //预警名称
	private String productId; //预警产品
	private String productName;
	
	//财务指标预警

	private String subjId; //科目编号
    private String subjNm; //科目名称

    private BigDecimal colVal1; //列值1
    private BigDecimal colVal2;//列值2
    private String rpSource;  //财报周期
    private String rptNo;//财报期次
    private String result; //财务指标分析结果
    private String remark;
    
	/**
	 * @return the custcd
	 */
	public String getCustcd() {
		return custcd;
	}
	/**
	 * @param custcd the custcd to set
	 */
	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}
	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * @return the postLoanWarnType
	 */
	public String getPostLoanWarnType() {
		return postLoanWarnType;
	}
	/**
	 * @param postLoanWarnType the postLoanWarnType to set
	 */
	public void setPostLoanWarnType(String postLoanWarnType) {
		this.postLoanWarnType = postLoanWarnType;
	}
	/**
	 * @return the warnNum
	 */
	public BigDecimal getWarnNum() {
		return warnNum;
	}
	/**
	 * @param warnNum the warnNum to set
	 */
	public void setWarnNum(BigDecimal warnNum) {
		this.warnNum = warnNum;
	}
	
	
	/**
	 * @return the warnLevel
	 */
	public String getWarnLevel() {
		return warnLevel;
	}
	/**
	 * @param warnLevel the warnLevel to set
	 */
	public void setWarnLevel(String warnLevel) {
		this.warnLevel = warnLevel;
	}
	/**
	 * @return the warnDate
	 */
	public String getWarnDate() {
		return warnDate;
	}
	/**
	 * @param warnDate the warnDate to set
	 */
	public void setWarnDate(String warnDate) {
		this.warnDate = warnDate;
	}
	/**
	 * @return the warnNo
	 */
	public String getWarnNo() {
		return warnNo;
	}
	/**
	 * @param warnNo the warnNo to set
	 */
	public void setWarnNo(String warnNo) {
		this.warnNo = warnNo;
	}
	/**
	 * @return the warnName
	 */
	public String getWarnName() {
		return warnName;
	}
	/**
	 * @param warnName the warnName to set
	 */
	public void setWarnName(String warnName) {
		this.warnName = warnName;
	}
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the subjId
	 */
	public String getSubjId() {
		return subjId;
	}
	/**
	 * @param subjId the subjId to set
	 */
	public void setSubjId(String subjId) {
		this.subjId = subjId;
	}
	/**
	 * @return the subjNm
	 */
	public String getSubjNm() {
		return subjNm;
	}
	/**
	 * @param subjNm the subjNm to set
	 */
	public void setSubjNm(String subjNm) {
		this.subjNm = subjNm;
	}
	/**
	 * @return the colVal1
	 */
	public BigDecimal getColVal1() {
		return colVal1;
	}
	/**
	 * @param colVal1 the colVal1 to set
	 */
	public void setColVal1(BigDecimal colVal1) {
		this.colVal1 = colVal1;
	}
	/**
	 * @return the colVal2
	 */
	public BigDecimal getColVal2() {
		return colVal2;
	}
	/**
	 * @param colVal2 the colVal2 to set
	 */
	public void setColVal2(BigDecimal colVal2) {
		this.colVal2 = colVal2;
	}
	/**
	 * @return the rpSource
	 */
	public String getRpSource() {
		return rpSource;
	}
	/**
	 * @param rpSource the rpSource to set
	 */
	public void setRpSource(String rpSource) {
		this.rpSource = rpSource;
	}
	/**
	 * @return the rptNo
	 */
	public String getRptNo() {
		return rptNo;
	}
	/**
	 * @param rptNo the rptNo to set
	 */
	public void setRptNo(String rptNo) {
		this.rptNo = rptNo;
	}
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
    
    
	
}

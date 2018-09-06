/**
 * 
 */
package com.huateng.scf.bas.qry.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author huangshuidan
 * @date 2017年6月22日下午8:05:49
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年6月22日下午8:05:49             新增
 *
 * </pre>
 */
public class FinAmtDistrib implements Serializable{

	private static final long serialVersionUID = 1565687813350248246L;
	private String area;//省份代码
	private String regionName;//省份名称
	private String productId;//产品ID
	private String productName;//产品名称
	private BigDecimal lnciAmt;//融资金额
	private String lnciAmtStr;//融资金额，格式化后
	
	public FinAmtDistrib() {
		
	}
	public FinAmtDistrib(String area, String regionName, String productId, String productName, BigDecimal lnciAmt) {
		this.area = area;
		this.regionName = regionName;
		this.productId = productId;
		this.productName = productName;
		this.lnciAmt = lnciAmt;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * @return the regionName
	 */
	public String getRegionName() {
		return regionName;
	}
	/**
	 * @param regionName the regionName to set
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
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
	 * @return the lnciAmt
	 */
	public BigDecimal getLnciAmt() {
		return lnciAmt;
	}
	/**
	 * @param lnciAmt the lnciAmt to set
	 */
	public void setLnciAmt(BigDecimal lnciAmt) {
		this.lnciAmt = lnciAmt;
	}
	/**
	 * @return the lnciAmtStr
	 */
	public String getLnciAmtStr() {
		return lnciAmtStr;
	}
	/**
	 * @param lnciAmtStr the lnciAmtStr to set
	 */
	public void setLnciAmtStr(String lnciAmtStr) {
		this.lnciAmtStr = lnciAmtStr;
	}
	
	

}

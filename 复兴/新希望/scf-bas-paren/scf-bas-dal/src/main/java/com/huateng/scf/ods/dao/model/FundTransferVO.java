/**
 * 
 */
package com.huateng.scf.ods.dao.model;

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
public class FundTransferVO implements Serializable{

	private static final long serialVersionUID = 1565687813350248246L;
	private String startArea;//省份代码
	private String startAreaNm;//省份名称
	private String endArea;//省份代码
	private String endAreaNm;//省份名称
	private BigDecimal amt;//融资金额
	private String amtStr;//融资金额，格式化后
	/**
	 * @return the startArea
	 */
	public String getStartArea() {
		return startArea;
	}
	/**
	 * @param startArea the startArea to set
	 */
	public void setStartArea(String startArea) {
		this.startArea = startArea;
	}
	/**
	 * @return the startAreaNm
	 */
	public String getStartAreaNm() {
		return startAreaNm;
	}
	/**
	 * @param startAreaNm the startAreaNm to set
	 */
	public void setStartAreaNm(String startAreaNm) {
		this.startAreaNm = startAreaNm;
	}
	/**
	 * @return the endArea
	 */
	public String getEndArea() {
		return endArea;
	}
	/**
	 * @param endArea the endArea to set
	 */
	public void setEndArea(String endArea) {
		this.endArea = endArea;
	}
	/**
	 * @return the endAreaNm
	 */
	public String getEndAreaNm() {
		return endAreaNm;
	}
	/**
	 * @param endAreaNm the endAreaNm to set
	 */
	public void setEndAreaNm(String endAreaNm) {
		this.endAreaNm = endAreaNm;
	}

	/**
	 * @return the amt
	 */
	public BigDecimal getAmt() {
		return amt;
	}
	/**
	 * @param amt the amt to set
	 */
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}
	/**
	 * @return the amtStr
	 */
	public String getAmtStr() {
		return amtStr;
	}
	/**
	 * @param amtStr the amtStr to set
	 */
	public void setAmtStr(String amtStr) {
		this.amtStr = amtStr;
	}
	

	
	

}

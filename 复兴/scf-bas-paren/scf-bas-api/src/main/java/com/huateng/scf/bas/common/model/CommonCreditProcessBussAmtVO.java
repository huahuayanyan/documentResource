/**
 * 
 */
package com.huateng.scf.bas.common.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 	业务处理额度金额
 * </p>
 *
 * @author huangshuidan
 * @date 2017年1月17日 下午4:49:56
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年1月17日下午4:49:56             新增
 *
 * </pre>
 */
public class CommonCreditProcessBussAmtVO implements Serializable{
	private static final long serialVersionUID = -3310479277359156879L;
	private BigDecimal riskAmount;//敞口金额
	private BigDecimal bussAmount;//业务金额
	
	public CommonCreditProcessBussAmtVO() {
		
	}
	public CommonCreditProcessBussAmtVO(BigDecimal riskAmount, BigDecimal bussAmount) {
		this.riskAmount = riskAmount;
		this.bussAmount = bussAmount;
	}
	/**
	 * @return the riskAmount
	 */
	public BigDecimal getRiskAmount() {
		return riskAmount;
	}
	/**
	 * @param riskAmount the riskAmount to set
	 */
	public void setRiskAmount(BigDecimal riskAmount) {
		this.riskAmount = riskAmount;
	}
	/**
	 * @return the bussAmount
	 */
	public BigDecimal getBussAmount() {
		return bussAmount;
	}
	/**
	 * @param bussAmount the bussAmount to set
	 */
	public void setBussAmount(BigDecimal bussAmount) {
		this.bussAmount = bussAmount;
	}
	
	
}

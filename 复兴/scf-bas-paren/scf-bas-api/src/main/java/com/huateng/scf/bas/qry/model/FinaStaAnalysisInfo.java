/**
 * 
 */
package com.huateng.scf.bas.qry.model;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年6月12日下午2:12:00
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年6月12日下午2:12:00              新增
 *
 * </pre>
 */
public class FinaStaAnalysisInfo  extends OFinaStaAnalysis{
	
	private static final long serialVersionUID = -4815819318208780186L;
	private BigDecimal totalIncome; //总收入
	 private BigDecimal totalOutcome; //总支出
	 
	 private BigDecimal totalLossAmt; //总损失金
	 
	 private BigDecimal totalProfit; //总利润
	 
	private String amountStr;  //金额,格式化后
	private String totalIncomeStr;//总收入，格式化后
	private String totalOutcomeStr;//总支出，格式化后
	private String totalLossAmtStr;//总损失金，格式化后
	private String totalProfitStr;//总利润，格式化后

	/**
	 * @return the totalIncome
	 */
	public BigDecimal getTotalIncome() {
		return totalIncome;
	}

	/**
	 * @param totalIncome the totalIncome to set
	 */
	public void setTotalIncome(BigDecimal totalIncome) {
		this.totalIncome = totalIncome;
	}

	/**
	 * @return the totalOutcome
	 */
	public BigDecimal getTotalOutcome() {
		return totalOutcome;
	}

	/**
	 * @param totalOutcome the totalOutcome to set
	 */
	public void setTotalOutcome(BigDecimal totalOutcome) {
		this.totalOutcome = totalOutcome;
	}

	/**
	 * @return the totalLossAmt
	 */
	public BigDecimal getTotalLossAmt() {
		return totalLossAmt;
	}

	/**
	 * @param totalLossAmt the totalLossAmt to set
	 */
	public void setTotalLossAmt(BigDecimal totalLossAmt) {
		this.totalLossAmt = totalLossAmt;
	}

	/**
	 * @return the totalProfit
	 */
	public BigDecimal getTotalProfit() {
		return totalProfit;
	}

	/**
	 * @param totalProfit the totalProfit to set
	 */
	public void setTotalProfit(BigDecimal totalProfit) {
		this.totalProfit = totalProfit;
	}

	/**
	 * @return the amountStr
	 */
	public String getAmountStr() {
		return amountStr;
	}

	/**
	 * @param amountStr the amountStr to set
	 */
	public void setAmountStr(String amountStr) {
		this.amountStr = amountStr;
	}

	/**
	 * @return the totalIncomeStr
	 */
	public String getTotalIncomeStr() {
		return totalIncomeStr;
	}

	/**
	 * @param totalIncomeStr the totalIncomeStr to set
	 */
	public void setTotalIncomeStr(String totalIncomeStr) {
		this.totalIncomeStr = totalIncomeStr;
	}

	/**
	 * @return the totalOutcomeStr
	 */
	public String getTotalOutcomeStr() {
		return totalOutcomeStr;
	}

	/**
	 * @param totalOutcomeStr the totalOutcomeStr to set
	 */
	public void setTotalOutcomeStr(String totalOutcomeStr) {
		this.totalOutcomeStr = totalOutcomeStr;
	}

	/**
	 * @return the totalLossAmtStr
	 */
	public String getTotalLossAmtStr() {
		return totalLossAmtStr;
	}

	/**
	 * @param totalLossAmtStr the totalLossAmtStr to set
	 */
	public void setTotalLossAmtStr(String totalLossAmtStr) {
		this.totalLossAmtStr = totalLossAmtStr;
	}

	/**
	 * @return the totalProfitStr
	 */
	public String getTotalProfitStr() {
		return totalProfitStr;
	}

	/**
	 * @param totalProfitStr the totalProfitStr to set
	 */
	public void setTotalProfitStr(String totalProfitStr) {
		this.totalProfitStr = totalProfitStr;
	}

	 

}

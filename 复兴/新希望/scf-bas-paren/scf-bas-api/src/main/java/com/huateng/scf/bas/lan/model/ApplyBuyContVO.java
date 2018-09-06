/**
 * 
 */
package com.huateng.scf.bas.lan.model;

import java.math.BigDecimal;

/**
 * <p>购销合同申请表VO</p>
 *
 * @author 	shangxiujuan
 * @date 2017年4月11日下午4:16:53
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月11日下午4:16:53              新增
 *
 * </pre>
 */
public class ApplyBuyContVO {
	//少 debetNo insertDate  accuWithdrawAmt  多amt remainAmt
	private String id; //主键
	private String appno;//业务编号
	private String tradeContno;//购销合同表主键
	private String tradeContcode;//购销合同号
	private String startDate;//合同生效日
	private String endDate;//合同到期日
	private BigDecimal contAmt;//合同金额
	private BigDecimal accuLoanAmt;//累计出账金额
	private BigDecimal loanAmt;//本次出账金额
	private Boolean select = false;
	private BigDecimal amt;
	private BigDecimal totAmt;
	private BigDecimal remainAmt;//审批中的出账金额
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public String getTradeContno() {
		return tradeContno;
	}
	public void setTradeContno(String tradeContno) {
		this.tradeContno = tradeContno;
	}
	public String getTradeContcode() {
		return tradeContcode;
	}
	public void setTradeContcode(String tradeContcode) {
		this.tradeContcode = tradeContcode;
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
	public BigDecimal getContAmt() {
		return contAmt;
	}
	public void setContAmt(BigDecimal contAmt) {
		this.contAmt = contAmt;
	}
	public BigDecimal getAccuLoanAmt() {
		return accuLoanAmt;
	}
	public void setAccuLoanAmt(BigDecimal accuLoanAmt) {
		this.accuLoanAmt = accuLoanAmt;
	}
	public BigDecimal getLoanAmt() {
		return loanAmt;
	}
	public void setLoanAmt(BigDecimal loanAmt) {
		this.loanAmt = loanAmt;
	}
	public Boolean getSelect() {
		return select;
	}
	public void setSelect(Boolean select) {
		this.select = select;
	}
	public BigDecimal getAmt() {
		return amt;
	}
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}
	public BigDecimal getTotAmt() {
		return totAmt;
	}
	public void setTotAmt(BigDecimal totAmt) {
		this.totAmt = totAmt;
	}
	public BigDecimal getRemainAmt() {
		return remainAmt;
	}
	public void setRemainAmt(BigDecimal remainAmt) {
		this.remainAmt = remainAmt;
	}
}

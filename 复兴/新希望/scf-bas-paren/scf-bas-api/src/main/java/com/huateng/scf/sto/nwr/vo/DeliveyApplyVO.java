package com.huateng.scf.sto.nwr.vo;

import java.math.BigDecimal;

import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;


/**
 *  在这里添加类的文档注释
 * 
 * @author <a href="mailto:jianfeng.huang@topscf.com">jianfeng.huang</a>
 *
 * @version Revision: 1.0  Date: 2013-7-12 下午4:42:42 
 *
 */

public class DeliveyApplyVO extends BPbcAppliBaseInfo{
	/**
	 * 
	 */
	private String moniCname;
	private String cname;
	public String getMoniCname() {
		return moniCname;
	}
	public void setMoniCname(String moniCname) {
		this.moniCname = moniCname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	private BigDecimal lowPriceNew;
	private String mortgageNo;
	public String getMortgageNo() {
		return mortgageNo;
	}
	public void setMortgageNo(String mortgageNo) {
		this.mortgageNo = mortgageNo;
	}
	public BigDecimal getLowPriceNew() {
		return lowPriceNew;
	}
	public void setLowPriceNew(BigDecimal lowPriceNew) {
		this.lowPriceNew = lowPriceNew;
	}
	private BigDecimal riskamt;
	private String taskComment;
	public BigDecimal getRiskamt() {
		return riskamt;
	}
	public void setRiskamt(BigDecimal riskamt) {
		this.riskamt = riskamt;
	}
	public String getTaskComment() {
		return taskComment;
	}
	public void setTaskComment(String taskComment) {
		this.taskComment = taskComment;
	}
	private static final long serialVersionUID = 1L;
	private String adviceid;
	private String slaveContcode;
	private BigDecimal totalPrice;
	private BigDecimal ration;
	private String processTemplate;
	private String taskName;
	private String taskId;
	private String monitorProtocolNo;
	private BigDecimal mortAmount;
	private BigDecimal debtAmount;
	private BigDecimal maxDeliverValue;  //可提货金额
	private BigDecimal addBailAmount;//冻结保证金额
	
	public BigDecimal getAddBailAmount() {
		return addBailAmount;
	}
	public void setAddBailAmount(BigDecimal addBailAmount) {
		this.addBailAmount = addBailAmount;
	}
	public BigDecimal getMaxDeliverValue() {
		return maxDeliverValue;
	}
	public void setMaxDeliverValue(BigDecimal maxDeliverValue) {
		this.maxDeliverValue = maxDeliverValue;
	}
	public String getAdviceid() {
		return adviceid;
	}
	public void setAdviceid(String adviceid) {
		this.adviceid = adviceid;
	}
	public String getSlaveContcode() {
		return slaveContcode;
	}
	public void setSlaveContcode(String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public BigDecimal getRation() {
		return ration;
	}
	public void setRation(BigDecimal ration) {
		this.ration = ration;
	}
	public String getProcessTemplate() {
		return processTemplate;
	}
	public void setProcessTemplate(String processTemplate) {
		this.processTemplate = processTemplate;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getMonitorProtocolNo() {
		return monitorProtocolNo;
	}
	public void setMonitorProtocolNo(String monitorProtocolNo) {
		this.monitorProtocolNo = monitorProtocolNo;
	}
	public BigDecimal getMortAmount() {
		return mortAmount;
	}
	public void setMortAmount(BigDecimal mortAmount) {
		this.mortAmount = mortAmount;
	}
	public BigDecimal getDebtAmount() {
		return debtAmount;
	}
	public void setDebtAmount(BigDecimal debtAmount) {
		this.debtAmount = debtAmount;
	}
	
}

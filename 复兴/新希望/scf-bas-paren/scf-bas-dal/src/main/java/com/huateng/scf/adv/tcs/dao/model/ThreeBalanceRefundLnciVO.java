/*
 * 功  能：简单说明该类的功能
 * 
 * 文件名：ThreeBalanceRefundLnciVO.java
 * 
 * 描  述：
 * 
 * [变更履历]
 * Version   变更日         部署              作者           变更内容
 * -----------------------------------------------------------------------------
 * V1.00     2013-7-2   Hu@teng    zhoujun.hou      CREATE
 * -----------------------------------------------------------------------------
 *
 *
 * Copyright (c) 2013 Hu@teng All Rights Reserved.
 *┌─────────────────────────────────────────────────—────┐
 *│ 版权声明                               Hu@teng       │
 *└──────────────────────────────—————————————————————───┘
 */

package com.huateng.scf.adv.tcs.dao.model;

import java.math.BigDecimal;
/**
 * <p>差额退款借据列表VO</p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月19日下午7:22:39	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月19日下午7:22:39              新增
 *
 * </pre>
 */

public class ThreeBalanceRefundLnciVO {
	private String appno; //申请编号
	private String debetNo; //借据主键
	private String num; //通知书编号
	private String debetId; //借据号/承兑协议号
	private String commonDate; //通用日期，如收款确认日期
	private String lnciType;//借据类型：01-流动资金贷款、02-银行承兑汇票
	private BigDecimal lnciAmt;// 借据金额
	private String startDate;//起息日期
	private String endDate;//到期日期
	private String curcd; // 币种
	private BigDecimal businessOpenAmount; //敞口金额
	private BigDecimal amountOut;// 累计提货金额
	private BigDecimal amountIn;//剩余提货金额


	private java.lang.String mastContno; //主合同号
	private java.lang.String lnciStatus; //借据状态：0-正常、1-逾期、2-呆滞、3-呆账
	private java.math.BigDecimal lnciBal; //借据余额
	private java.lang.String fivelevel; //贷款五级分类
	private java.lang.String creditLoanFlag; //?
	private java.lang.String loanType; //贷款形态：0-正常、1-逾期、2-呆滞、3-呆账
	private java.lang.String dept;//?
	private java.lang.String mgrno; //mgrno?mgno
	private java.math.BigDecimal refundAmount;//?
	private java.math.BigDecimal rate; //执行利率
	private java.lang.String confirmStatus; //收款确认状态：1-已收到、0-未收到
	private java.math.BigDecimal bailAmount;//初始保证金金额
	private java.math.BigDecimal amountUpOut;//累计提货金额(向核心企业)
	private java.math.BigDecimal firstBailRatio;//初始保证金比例
	private java.lang.String protocolNo;//关联业务协议/合同号
	private java.math.BigDecimal addBailAmount;//追加保证金金额
	private String slaveContno;//抵质押合同号
	private String slaveLimit;//填平敞口期限(天)
	private String isLocked; //锁定标识：0-未锁定;1-锁定
	private String lockAppno; //加锁业务编号
	private java.math.BigDecimal addCashEqtAmt;//追加现金等价物金额
	private java.math.BigDecimal initCashEqtAmt;//初始现金等价物金额
	private String loanOverdueFlag;//?
	private String tradeContno; //购销合同号
	private BigDecimal loanAmt;//?
	private BigDecimal totQuantity;//?
	private BigDecimal accuSendAmt; //累计发货金额
	private BigDecimal balSendAmt; //剩余发货金额
	
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public String getDebetNo() {
		return debetNo;
	}
	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
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
	public String getCommonDate() {
		return commonDate;
	}
	public void setCommonDate(String commonDate) {
		this.commonDate = commonDate;
	}
	public String getLnciType() {
		return lnciType;
	}
	public void setLnciType(String lnciType) {
		this.lnciType = lnciType;
	}
	public BigDecimal getLnciAmt() {
		return lnciAmt;
	}
	public void setLnciAmt(BigDecimal lnciAmt) {
		this.lnciAmt = lnciAmt;
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
	public String getCurcd() {
		return curcd;
	}
	public void setCurcd(String curcd) {
		this.curcd = curcd;
	}
	public BigDecimal getBusinessOpenAmount() {
		return businessOpenAmount;
	}
	public void setBusinessOpenAmount(BigDecimal businessOpenAmount) {
		this.businessOpenAmount = businessOpenAmount;
	}
	public BigDecimal getAmountOut() {
		return amountOut;
	}
	public void setAmountOut(BigDecimal amountOut) {
		this.amountOut = amountOut;
	}
	public BigDecimal getAmountIn() {
		return amountIn;
	}
	public void setAmountIn(BigDecimal amountIn) {
		this.amountIn = amountIn;
	}
	public java.lang.String getMastContno() {
		return mastContno;
	}
	public void setMastContno(java.lang.String mastContno) {
		this.mastContno = mastContno;
	}
	public java.lang.String getLnciStatus() {
		return lnciStatus;
	}
	public void setLnciStatus(java.lang.String lnciStatus) {
		this.lnciStatus = lnciStatus;
	}
	public java.math.BigDecimal getLnciBal() {
		return lnciBal;
	}
	public void setLnciBal(java.math.BigDecimal lnciBal) {
		this.lnciBal = lnciBal;
	}
	public java.lang.String getFivelevel() {
		return fivelevel;
	}
	public void setFivelevel(java.lang.String fivelevel) {
		this.fivelevel = fivelevel;
	}
	public java.lang.String getCreditLoanFlag() {
		return creditLoanFlag;
	}
	public void setCreditLoanFlag(java.lang.String creditLoanFlag) {
		this.creditLoanFlag = creditLoanFlag;
	}
	public java.lang.String getLoanType() {
		return loanType;
	}
	public void setLoanType(java.lang.String loanType) {
		this.loanType = loanType;
	}
	public java.lang.String getDept() {
		return dept;
	}
	public void setDept(java.lang.String dept) {
		this.dept = dept;
	}

	public java.lang.String getMgrno() {
		return mgrno;
	}
	public void setMgrno(java.lang.String mgrno) {
		this.mgrno = mgrno;
	}
	public java.math.BigDecimal getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(java.math.BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}
	public java.math.BigDecimal getRate() {
		return rate;
	}
	public void setRate(java.math.BigDecimal rate) {
		this.rate = rate;
	}
	public java.lang.String getConfirmStatus() {
		return confirmStatus;
	}
	public void setConfirmStatus(java.lang.String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}
	public java.math.BigDecimal getBailAmount() {
		return bailAmount;
	}
	public void setBailAmount(java.math.BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}
	public java.math.BigDecimal getAmountUpOut() {
		return amountUpOut;
	}
	public void setAmountUpOut(java.math.BigDecimal amountUpOut) {
		this.amountUpOut = amountUpOut;
	}
	public java.math.BigDecimal getFirstBailRatio() {
		return firstBailRatio;
	}
	public void setFirstBailRatio(java.math.BigDecimal firstBailRatio) {
		this.firstBailRatio = firstBailRatio;
	}
	public java.lang.String getProtocolNo() {
		return protocolNo;
	}
	public void setProtocolNo(java.lang.String protocolNo) {
		this.protocolNo = protocolNo;
	}
	public java.math.BigDecimal getAddBailAmount() {
		return addBailAmount;
	}
	public void setAddBailAmount(java.math.BigDecimal addBailAmount) {
		this.addBailAmount = addBailAmount;
	}
	public String getSlaveContno() {
		return slaveContno;
	}
	public void setSlaveContno(String slaveContno) {
		this.slaveContno = slaveContno;
	}
	public String getSlaveLimit() {
		return slaveLimit;
	}
	public void setSlaveLimit(String slaveLimit) {
		this.slaveLimit = slaveLimit;
	}
	public String getIsLocked() {
		return isLocked;
	}
	public void setIsLocked(String isLocked) {
		this.isLocked = isLocked;
	}
	public String getLockAppno() {
		return lockAppno;
	}
	public void setLockAppno(String lockAppno) {
		this.lockAppno = lockAppno;
	}
	public java.math.BigDecimal getAddCashEqtAmt() {
		return addCashEqtAmt;
	}
	public void setAddCashEqtAmt(java.math.BigDecimal addCashEqtAmt) {
		this.addCashEqtAmt = addCashEqtAmt;
	}
	public java.math.BigDecimal getInitCashEqtAmt() {
		return initCashEqtAmt;
	}
	public void setInitCashEqtAmt(java.math.BigDecimal initCashEqtAmt) {
		this.initCashEqtAmt = initCashEqtAmt;
	}
	public String getLoanOverdueFlag() {
		return loanOverdueFlag;
	}
	public void setLoanOverdueFlag(String loanOverdueFlag) {
		this.loanOverdueFlag = loanOverdueFlag;
	}
	public String getTradeContno() {
		return tradeContno;
	}
	public void setTradeContno(String tradeContno) {
		this.tradeContno = tradeContno;
	}
	public BigDecimal getLoanAmt() {
		return loanAmt;
	}
	public void setLoanAmt(BigDecimal loanAmt) {
		this.loanAmt = loanAmt;
	}
	public BigDecimal getTotQuantity() {
		return totQuantity;
	}
	public void setTotQuantity(BigDecimal totQuantity) {
		this.totQuantity = totQuantity;
	}
	public BigDecimal getAccuSendAmt() {
		return accuSendAmt;
	}
	public void setAccuSendAmt(BigDecimal accuSendAmt) {
		this.accuSendAmt = accuSendAmt;
	}
	public BigDecimal getBalSendAmt() {
		return balSendAmt;
	}
	public void setBalSendAmt(BigDecimal balSendAmt) {
		this.balSendAmt = balSendAmt;
	}
	
}

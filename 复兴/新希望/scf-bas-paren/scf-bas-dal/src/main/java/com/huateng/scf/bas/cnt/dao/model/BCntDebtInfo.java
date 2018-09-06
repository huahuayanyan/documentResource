package com.huateng.scf.bas.cnt.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BCntDebtInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(20) 必填<br>
	 * 业务合同号
	 */
	private String debtContno;

	/**
	 * DECIMAL(9,6) 必填<br>
	 * 融资比例(%)
	 */
	private BigDecimal loanPercent;

	/**
	 * VARCHAR(2)<br>
	 * 保理业务类别
	 */
	private String factType;

	/**
	 * CHAR(2)<br>
	 * 融资模式：1-发票融资;2-池融资
	 */
	private String financingType;

	/**
	 * CHAR(2)<br>
	 * 费用收取方式：01-按年，02-单笔
	 */
	private String chargeType;

	/**
	 * CHAR(2)<br>
	 * 通知方式：01-一次性通知;02-逐笔通知;03-取得发票收妥回执;04-仅签收发票
	 */
	private String noticeType;

	/**
	 * VARCHAR(500)<br>
	 * 其他信息备注
	 */
	private String remark;

	/**
	 * VARCHAR(10)<br>
	 * 是否自动还款：00-否、01-是
	 */
	private String isAutoPay;

	/**
	 * DECIMAL(22)<br>
	 * 自动提前还款天数
	 */
	private BigDecimal autoPayDays;

	/**
	 * VARCHAR(10)<br>
	 * 服务内容：保理融资;账款管理;应收租金催收;坏账担保
	 */
	private String serviceContent;

	/**
	 * VARCHAR(10) 必填<br>
	 * 业务种类：国内保理;反向保理;应收账款质押;国内双保理;信保保理;租赁保理
	 */
	private String supplyChainPdId;

	/**
	 * VARCHAR(15) 必填<br>
	 * 客户号(卖方)
	 */
	private String custcd;

	/**
	 * CHAR(3) 必填<br>
	 * 合同币种
	 */
	private String curcd;

	/**
	 * DECIMAL(16,2)<br>
	 * 额度金额
	 */
	private BigDecimal contAmount;

	/**
	 * CHAR(8) 必填<br>
	 * 合同生效日期
	 */
	private String startDate;

	/**
	 * CHAR(8) 必填<br>
	 * 合同到期日期
	 */
	private String endDate;

	/**
	 * VARCHAR(20)<br>
	 * 出账方式：01-流贷；02-承兑；03-预支价金
	 */
	private String loanWay;

	/**
	 * VARCHAR(20) 必填<br>
	 * 合同状态
	 */
	private String contStatus;

	/**
	 * VARCHAR(50)<br>
	 * 结算账号
	 */
	private String accountNo;

	/**
	 * VARCHAR(32) 必填<br>
	 * 客户经理
	 */
	private String mgrno;

	/**
	 * VARCHAR(50)<br>
	 * 池保证金账号
	 */
	private String bailAcctNo;

	/**
	 * VARCHAR(50)<br>
	 * 回款专户
	 */
	private String returnAccount;

	/**
	 * VARCHAR(1)<br>
	 * 有无追索权：1-有追索;2-无追索
	 */
	private String recoverType;

	/**
	 * VARCHAR(10) 必填<br>
	 * 回款用途:01-入借据保证金;02-还贷
	 */
	private String repayPurpose;

	/**
	 * VARCHAR(10) 必填<br>
	 * 尾款规则:01-入结算账户;02-留存回款专户
	 */
	private String dueBalanceRule;

	/**
	 * VARCHAR(10) 必填<br>
	 * 回款核销规则:01-先到期先核销;02-平均分配核销
	 */
	private String paymentVerifyRule;

	/**
	 * VARCHAR(100)<br>
	 * 赔款转让协议号
	 */
	private String reparationProtNo;

	/**
	 * VARCHAR(10)<br>
	 * 租赁方式:01-普通租赁;02-售后回租;03-融资租赁
	 */
	private String lease;

	/**
	 * VARCHAR(100)<br>
	 * 反转让方
	 */
	private String repurchaser;

	/**
	 * VARCHAR(100)<br>
	 * 反转让协议号
	 */
	private String repurchaseProtNo;

	/**
	 * VARCHAR(15)<br>
	 * 买方保理商客户号
	 */
	private String factoringBrcode;

	/**
	 * DECIMAL(22)<br>
	 * 赔款期限(天)
	 */
	private BigDecimal reparationTerm;

	/**
	 * DECIMAL(10,6)<br>
	 * 赔付比例(%)
	 */
	private BigDecimal reparationPercent;

	/**
	 * DECIMAL(16,2)<br>
	 * 累计赔款金额
	 */
	private BigDecimal cumulativeReparationAmt;

	/**
	 * VARCHAR(2)<br>
	 * 保理方式：1-明保理;2-暗保理
	 */
	private String factPattern;

	/**
	 * VARCHAR(20)<br>
	 * 合作机构（村镇银行）
	 */
	private String cooperationBrcode;

	/**
	 * CHAR(1)<br>
	 * 租金处理方式：1-质押、2-转让
	 */
	private String rentSettleWay;

	/**
	 * DECIMAL(16,2)<br>
	 * 池保证金余额
	 */
	private BigDecimal poolBailAmt;

	/**
	 * VARCHAR(32) 必填<br>
	 * 创建人
	 */
	private String tlrcd;

	/**
	 * TIMESTAMP(11,6) 必填<br>
	 * 创建时间
	 */
	private Date crtTime;

	/**
	 * VARCHAR(20) 必填<br>
	 * 经办机构
	 */
	private String brcode;

	/**
	 * VARCHAR(32)<br>
	 * 最后更新操作员
	 */
	private String lastUpdTlrcd;

	/**
	 * TIMESTAMP(11,6)<br>
	 * 最后更新时间
	 */
	private Date lastUpdTime;

	/**
	 * VARCHAR(20)<br>
	 * 最后更新机构
	 */
	private String lastUpdBrcode;
	/**
	 * VARCHAR(10) 必填<br>
	 * 业务种类名称：国内保理;反向保理;应收账款质押;国内双保理;信保保理;租赁保理
	 */
	private String bussTypeName;

	public synchronized String getBussTypeName() {
		return bussTypeName;
	}

	public synchronized void setBussTypeName(String bussTypeName) {
		this.bussTypeName = bussTypeName;
	}

	/**
	 * VARCHAR(20) 必填<br>
	 * 获得 业务合同号
	 */
	public String getDebtContno() {
		return debtContno;
	}

	/**
	 * VARCHAR(20) 必填<br>
	 * 设置 业务合同号
	 */
	public void setDebtContno(String debtContno) {
		this.debtContno = debtContno == null ? null : debtContno.trim();
	}

	/**
	 * DECIMAL(9,6) 必填<br>
	 * 获得 融资比例(%)
	 */
	public BigDecimal getLoanPercent() {
		return loanPercent;
	}

	/**
	 * DECIMAL(9,6) 必填<br>
	 * 设置 融资比例(%)
	 */
	public void setLoanPercent(BigDecimal loanPercent) {
		this.loanPercent = loanPercent;
	}

	/**
	 * VARCHAR(2)<br>
	 * 获得 保理业务类别
	 */
	public String getFactType() {
		return factType;
	}

	/**
	 * VARCHAR(2)<br>
	 * 设置 保理业务类别
	 */
	public void setFactType(String factType) {
		this.factType = factType == null ? null : factType.trim();
	}

	/**
	 * CHAR(2)<br>
	 * 获得 融资模式：1-发票融资;2-池融资
	 */
	public String getFinancingType() {
		return financingType;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 融资模式：1-发票融资;2-池融资
	 */
	public void setFinancingType(String financingType) {
		this.financingType = financingType == null ? null : financingType.trim();
	}

	/**
	 * CHAR(2)<br>
	 * 获得 费用收取方式：01-按年，02-单笔
	 */
	public String getChargeType() {
		return chargeType;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 费用收取方式：01-按年，02-单笔
	 */
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType == null ? null : chargeType.trim();
	}

	/**
	 * CHAR(2)<br>
	 * 获得 通知方式：01-一次性通知;02-逐笔通知;03-取得发票收妥回执;04-仅签收发票
	 */
	public String getNoticeType() {
		return noticeType;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 通知方式：01-一次性通知;02-逐笔通知;03-取得发票收妥回执;04-仅签收发票
	 */
	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType == null ? null : noticeType.trim();
	}

	/**
	 * VARCHAR(500)<br>
	 * 获得 其他信息备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * VARCHAR(500)<br>
	 * 设置 其他信息备注
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 是否自动还款：00-否、01-是
	 */
	public String getIsAutoPay() {
		return isAutoPay;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 是否自动还款：00-否、01-是
	 */
	public void setIsAutoPay(String isAutoPay) {
		this.isAutoPay = isAutoPay == null ? null : isAutoPay.trim();
	}

	/**
	 * DECIMAL(22)<br>
	 * 获得 自动提前还款天数
	 */
	public BigDecimal getAutoPayDays() {
		return autoPayDays;
	}

	/**
	 * DECIMAL(22)<br>
	 * 设置 自动提前还款天数
	 */
	public void setAutoPayDays(BigDecimal autoPayDays) {
		this.autoPayDays = autoPayDays;
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 服务内容：保理融资;账款管理;应收租金催收;坏账担保
	 */
	public String getServiceContent() {
		return serviceContent;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 服务内容：保理融资;账款管理;应收租金催收;坏账担保
	 */
	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent == null ? null : serviceContent.trim();
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 获得 业务种类：国内保理;反向保理;应收账款质押;国内双保理;信保保理;租赁保理
	 */
	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 设置 业务种类：国内保理;反向保理;应收账款质押;国内双保理;信保保理;租赁保理
	 */
	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId == null ? null : supplyChainPdId.trim();
	}

	/**
	 * VARCHAR(15) 必填<br>
	 * 获得 客户号(卖方)
	 */
	public String getCustcd() {
		return custcd;
	}

	/**
	 * VARCHAR(15) 必填<br>
	 * 设置 客户号(卖方)
	 */
	public void setCustcd(String custcd) {
		this.custcd = custcd == null ? null : custcd.trim();
	}

	/**
	 * CHAR(3) 必填<br>
	 * 获得 合同币种
	 */
	public String getCurcd() {
		return curcd;
	}

	/**
	 * CHAR(3) 必填<br>
	 * 设置 合同币种
	 */
	public void setCurcd(String curcd) {
		this.curcd = curcd == null ? null : curcd.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 额度金额
	 */
	public BigDecimal getContAmount() {
		return contAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 额度金额
	 */
	public void setContAmount(BigDecimal contAmount) {
		this.contAmount = contAmount;
	}

	/**
	 * CHAR(8) 必填<br>
	 * 获得 合同生效日期
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * CHAR(8) 必填<br>
	 * 设置 合同生效日期
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate == null ? null : startDate.trim();
	}

	/**
	 * CHAR(8) 必填<br>
	 * 获得 合同到期日期
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * CHAR(8) 必填<br>
	 * 设置 合同到期日期
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate == null ? null : endDate.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 出账方式：01-流贷；02-承兑；03-预支价金
	 */
	public String getLoanWay() {
		return loanWay;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 出账方式：01-流贷；02-承兑；03-预支价金
	 */
	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay == null ? null : loanWay.trim();
	}

	/**
	 * VARCHAR(20) 必填<br>
	 * 获得 合同状态
	 */
	public String getContStatus() {
		return contStatus;
	}

	/**
	 * VARCHAR(20) 必填<br>
	 * 设置 合同状态
	 */
	public void setContStatus(String contStatus) {
		this.contStatus = contStatus == null ? null : contStatus.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 结算账号
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 结算账号
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo == null ? null : accountNo.trim();
	}

	/**
	 * VARCHAR(32) 必填<br>
	 * 获得 客户经理
	 */
	public String getMgrno() {
		return mgrno;
	}

	/**
	 * VARCHAR(32) 必填<br>
	 * 设置 客户经理
	 */
	public void setMgrno(String mgrno) {
		this.mgrno = mgrno == null ? null : mgrno.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 池保证金账号
	 */
	public String getBailAcctNo() {
		return bailAcctNo;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 池保证金账号
	 */
	public void setBailAcctNo(String bailAcctNo) {
		this.bailAcctNo = bailAcctNo == null ? null : bailAcctNo.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 回款专户
	 */
	public String getReturnAccount() {
		return returnAccount;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 回款专户
	 */
	public void setReturnAccount(String returnAccount) {
		this.returnAccount = returnAccount == null ? null : returnAccount.trim();
	}

	/**
	 * VARCHAR(1)<br>
	 * 获得 有无追索权：1-有追索;2-无追索
	 */
	public String getRecoverType() {
		return recoverType;
	}

	/**
	 * VARCHAR(1)<br>
	 * 设置 有无追索权：1-有追索;2-无追索
	 */
	public void setRecoverType(String recoverType) {
		this.recoverType = recoverType == null ? null : recoverType.trim();
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 获得 回款用途:01-入借据保证金;02-还贷
	 */
	public String getRepayPurpose() {
		return repayPurpose;
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 设置 回款用途:01-入借据保证金;02-还贷
	 */
	public void setRepayPurpose(String repayPurpose) {
		this.repayPurpose = repayPurpose == null ? null : repayPurpose.trim();
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 获得 尾款规则:01-入结算账户;02-留存回款专户
	 */
	public String getDueBalanceRule() {
		return dueBalanceRule;
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 设置 尾款规则:01-入结算账户;02-留存回款专户
	 */
	public void setDueBalanceRule(String dueBalanceRule) {
		this.dueBalanceRule = dueBalanceRule == null ? null : dueBalanceRule.trim();
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 获得 回款核销规则:01-先到期先核销;02-平均分配核销
	 */
	public String getPaymentVerifyRule() {
		return paymentVerifyRule;
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 设置 回款核销规则:01-先到期先核销;02-平均分配核销
	 */
	public void setPaymentVerifyRule(String paymentVerifyRule) {
		this.paymentVerifyRule = paymentVerifyRule == null ? null : paymentVerifyRule.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 赔款转让协议号
	 */
	public String getReparationProtNo() {
		return reparationProtNo;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 赔款转让协议号
	 */
	public void setReparationProtNo(String reparationProtNo) {
		this.reparationProtNo = reparationProtNo == null ? null : reparationProtNo.trim();
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 租赁方式:01-普通租赁;02-售后回租;03-融资租赁
	 */
	public String getLease() {
		return lease;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 租赁方式:01-普通租赁;02-售后回租;03-融资租赁
	 */
	public void setLease(String lease) {
		this.lease = lease == null ? null : lease.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 反转让方
	 */
	public String getRepurchaser() {
		return repurchaser;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 反转让方
	 */
	public void setRepurchaser(String repurchaser) {
		this.repurchaser = repurchaser == null ? null : repurchaser.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 反转让协议号
	 */
	public String getRepurchaseProtNo() {
		return repurchaseProtNo;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 反转让协议号
	 */
	public void setRepurchaseProtNo(String repurchaseProtNo) {
		this.repurchaseProtNo = repurchaseProtNo == null ? null : repurchaseProtNo.trim();
	}

	/**
	 * VARCHAR(15)<br>
	 * 获得 买方保理商客户号
	 */
	public String getFactoringBrcode() {
		return factoringBrcode;
	}

	/**
	 * VARCHAR(15)<br>
	 * 设置 买方保理商客户号
	 */
	public void setFactoringBrcode(String factoringBrcode) {
		this.factoringBrcode = factoringBrcode == null ? null : factoringBrcode.trim();
	}

	/**
	 * DECIMAL(22)<br>
	 * 获得 赔款期限(天)
	 */
	public BigDecimal getReparationTerm() {
		return reparationTerm;
	}

	/**
	 * DECIMAL(22)<br>
	 * 设置 赔款期限(天)
	 */
	public void setReparationTerm(BigDecimal reparationTerm) {
		this.reparationTerm = reparationTerm;
	}

	/**
	 * DECIMAL(10,6)<br>
	 * 获得 赔付比例(%)
	 */
	public BigDecimal getReparationPercent() {
		return reparationPercent;
	}

	/**
	 * DECIMAL(10,6)<br>
	 * 设置 赔付比例(%)
	 */
	public void setReparationPercent(BigDecimal reparationPercent) {
		this.reparationPercent = reparationPercent;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 累计赔款金额
	 */
	public BigDecimal getCumulativeReparationAmt() {
		return cumulativeReparationAmt;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 累计赔款金额
	 */
	public void setCumulativeReparationAmt(BigDecimal cumulativeReparationAmt) {
		this.cumulativeReparationAmt = cumulativeReparationAmt;
	}

	/**
	 * VARCHAR(2)<br>
	 * 获得 保理方式：1-明保理;2-暗保理
	 */
	public String getFactPattern() {
		return factPattern;
	}

	/**
	 * VARCHAR(2)<br>
	 * 设置 保理方式：1-明保理;2-暗保理
	 */
	public void setFactPattern(String factPattern) {
		this.factPattern = factPattern == null ? null : factPattern.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 合作机构（村镇银行）
	 */
	public String getCooperationBrcode() {
		return cooperationBrcode;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 合作机构（村镇银行）
	 */
	public void setCooperationBrcode(String cooperationBrcode) {
		this.cooperationBrcode = cooperationBrcode == null ? null : cooperationBrcode.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 租金处理方式：1-质押、2-转让
	 */
	public String getRentSettleWay() {
		return rentSettleWay;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 租金处理方式：1-质押、2-转让
	 */
	public void setRentSettleWay(String rentSettleWay) {
		this.rentSettleWay = rentSettleWay == null ? null : rentSettleWay.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 池保证金余额
	 */
	public BigDecimal getPoolBailAmt() {
		return poolBailAmt;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 池保证金余额
	 */
	public void setPoolBailAmt(BigDecimal poolBailAmt) {
		this.poolBailAmt = poolBailAmt;
	}

	/**
	 * VARCHAR(32) 必填<br>
	 * 获得 创建人
	 */
	public String getTlrcd() {
		return tlrcd;
	}

	/**
	 * VARCHAR(32) 必填<br>
	 * 设置 创建人
	 */
	public void setTlrcd(String tlrcd) {
		this.tlrcd = tlrcd == null ? null : tlrcd.trim();
	}

	/**
	 * TIMESTAMP(11,6) 必填<br>
	 * 获得 创建时间
	 */
	public Date getCrtTime() {
		return crtTime;
	}

	/**
	 * TIMESTAMP(11,6) 必填<br>
	 * 设置 创建时间
	 */
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	/**
	 * VARCHAR(20) 必填<br>
	 * 获得 经办机构
	 */
	public String getBrcode() {
		return brcode;
	}

	/**
	 * VARCHAR(20) 必填<br>
	 * 设置 经办机构
	 */
	public void setBrcode(String brcode) {
		this.brcode = brcode == null ? null : brcode.trim();
	}

	/**
	 * VARCHAR(32)<br>
	 * 获得 最后更新操作员
	 */
	public String getLastUpdTlrcd() {
		return lastUpdTlrcd;
	}

	/**
	 * VARCHAR(32)<br>
	 * 设置 最后更新操作员
	 */
	public void setLastUpdTlrcd(String lastUpdTlrcd) {
		this.lastUpdTlrcd = lastUpdTlrcd == null ? null : lastUpdTlrcd.trim();
	}

	/**
	 * TIMESTAMP(11,6)<br>
	 * 获得 最后更新时间
	 */
	public Date getLastUpdTime() {
		return lastUpdTime;
	}

	/**
	 * TIMESTAMP(11,6)<br>
	 * 设置 最后更新时间
	 */
	public void setLastUpdTime(Date lastUpdTime) {
		this.lastUpdTime = lastUpdTime;
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 最后更新机构
	 */
	public String getLastUpdBrcode() {
		return lastUpdBrcode;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 最后更新机构
	 */
	public void setLastUpdBrcode(String lastUpdBrcode) {
		this.lastUpdBrcode = lastUpdBrcode == null ? null : lastUpdBrcode.trim();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", debtContno=").append(debtContno);
		sb.append(", loanPercent=").append(loanPercent);
		sb.append(", factType=").append(factType);
		sb.append(", financingType=").append(financingType);
		sb.append(", chargeType=").append(chargeType);
		sb.append(", noticeType=").append(noticeType);
		sb.append(", remark=").append(remark);
		sb.append(", isAutoPay=").append(isAutoPay);
		sb.append(", autoPayDays=").append(autoPayDays);
		sb.append(", serviceContent=").append(serviceContent);
		sb.append(", supplyChainPdId=").append(supplyChainPdId);
		sb.append(", custcd=").append(custcd);
		sb.append(", curcd=").append(curcd);
		sb.append(", contAmount=").append(contAmount);
		sb.append(", startDate=").append(startDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", loanWay=").append(loanWay);
		sb.append(", contStatus=").append(contStatus);
		sb.append(", accountNo=").append(accountNo);
		sb.append(", mgrno=").append(mgrno);
		sb.append(", bailAcctNo=").append(bailAcctNo);
		sb.append(", returnAccount=").append(returnAccount);
		sb.append(", recoverType=").append(recoverType);
		sb.append(", repayPurpose=").append(repayPurpose);
		sb.append(", dueBalanceRule=").append(dueBalanceRule);
		sb.append(", paymentVerifyRule=").append(paymentVerifyRule);
		sb.append(", reparationProtNo=").append(reparationProtNo);
		sb.append(", lease=").append(lease);
		sb.append(", repurchaser=").append(repurchaser);
		sb.append(", repurchaseProtNo=").append(repurchaseProtNo);
		sb.append(", factoringBrcode=").append(factoringBrcode);
		sb.append(", reparationTerm=").append(reparationTerm);
		sb.append(", reparationPercent=").append(reparationPercent);
		sb.append(", cumulativeReparationAmt=").append(cumulativeReparationAmt);
		sb.append(", factPattern=").append(factPattern);
		sb.append(", cooperationBrcode=").append(cooperationBrcode);
		sb.append(", rentSettleWay=").append(rentSettleWay);
		sb.append(", poolBailAmt=").append(poolBailAmt);
		sb.append(", tlrcd=").append(tlrcd);
		sb.append(", crtTime=").append(crtTime);
		sb.append(", brcode=").append(brcode);
		sb.append(", lastUpdTlrcd=").append(lastUpdTlrcd);
		sb.append(", lastUpdTime=").append(lastUpdTime);
		sb.append(", lastUpdBrcode=").append(lastUpdBrcode);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		BCntDebtInfo other = (BCntDebtInfo) that;
		return (this.getDebtContno() == null ? other.getDebtContno() == null
				: this.getDebtContno().equals(other.getDebtContno()))
				&& (this.getLoanPercent() == null ? other.getLoanPercent() == null
						: this.getLoanPercent().equals(other.getLoanPercent()))
				&& (this.getFactType() == null ? other.getFactType() == null
						: this.getFactType().equals(other.getFactType()))
				&& (this.getFinancingType() == null ? other.getFinancingType() == null
						: this.getFinancingType().equals(other.getFinancingType()))
				&& (this.getChargeType() == null ? other.getChargeType() == null
						: this.getChargeType().equals(other.getChargeType()))
				&& (this.getNoticeType() == null ? other.getNoticeType() == null
						: this.getNoticeType().equals(other.getNoticeType()))
				&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
				&& (this.getIsAutoPay() == null ? other.getIsAutoPay() == null
						: this.getIsAutoPay().equals(other.getIsAutoPay()))
				&& (this.getAutoPayDays() == null ? other.getAutoPayDays() == null
						: this.getAutoPayDays().equals(other.getAutoPayDays()))
				&& (this.getServiceContent() == null ? other.getServiceContent() == null
						: this.getServiceContent().equals(other.getServiceContent()))
				&& (this.getSupplyChainPdId() == null ? other.getSupplyChainPdId() == null
						: this.getSupplyChainPdId().equals(other.getSupplyChainPdId()))
				&& (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
				&& (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
				&& (this.getContAmount() == null ? other.getContAmount() == null
						: this.getContAmount().equals(other.getContAmount()))
				&& (this.getStartDate() == null ? other.getStartDate() == null
						: this.getStartDate().equals(other.getStartDate()))
				&& (this.getEndDate() == null ? other.getEndDate() == null
						: this.getEndDate().equals(other.getEndDate()))
				&& (this.getLoanWay() == null ? other.getLoanWay() == null
						: this.getLoanWay().equals(other.getLoanWay()))
				&& (this.getContStatus() == null ? other.getContStatus() == null
						: this.getContStatus().equals(other.getContStatus()))
				&& (this.getAccountNo() == null ? other.getAccountNo() == null
						: this.getAccountNo().equals(other.getAccountNo()))
				&& (this.getMgrno() == null ? other.getMgrno() == null : this.getMgrno().equals(other.getMgrno()))
				&& (this.getBailAcctNo() == null ? other.getBailAcctNo() == null
						: this.getBailAcctNo().equals(other.getBailAcctNo()))
				&& (this.getReturnAccount() == null ? other.getReturnAccount() == null
						: this.getReturnAccount().equals(other.getReturnAccount()))
				&& (this.getRecoverType() == null ? other.getRecoverType() == null
						: this.getRecoverType().equals(other.getRecoverType()))
				&& (this.getRepayPurpose() == null ? other.getRepayPurpose() == null
						: this.getRepayPurpose().equals(other.getRepayPurpose()))
				&& (this.getDueBalanceRule() == null ? other.getDueBalanceRule() == null
						: this.getDueBalanceRule().equals(other.getDueBalanceRule()))
				&& (this.getPaymentVerifyRule() == null ? other.getPaymentVerifyRule() == null
						: this.getPaymentVerifyRule().equals(other.getPaymentVerifyRule()))
				&& (this.getReparationProtNo() == null ? other.getReparationProtNo() == null
						: this.getReparationProtNo().equals(other.getReparationProtNo()))
				&& (this.getLease() == null ? other.getLease() == null : this.getLease().equals(other.getLease()))
				&& (this.getRepurchaser() == null ? other.getRepurchaser() == null
						: this.getRepurchaser().equals(other.getRepurchaser()))
				&& (this.getRepurchaseProtNo() == null ? other.getRepurchaseProtNo() == null
						: this.getRepurchaseProtNo().equals(other.getRepurchaseProtNo()))
				&& (this.getFactoringBrcode() == null ? other.getFactoringBrcode() == null
						: this.getFactoringBrcode().equals(other.getFactoringBrcode()))
				&& (this.getReparationTerm() == null ? other.getReparationTerm() == null
						: this.getReparationTerm().equals(other.getReparationTerm()))
				&& (this.getReparationPercent() == null ? other.getReparationPercent() == null
						: this.getReparationPercent().equals(other.getReparationPercent()))
				&& (this.getCumulativeReparationAmt() == null ? other.getCumulativeReparationAmt() == null
						: this.getCumulativeReparationAmt().equals(other.getCumulativeReparationAmt()))
				&& (this.getFactPattern() == null ? other.getFactPattern() == null
						: this.getFactPattern().equals(other.getFactPattern()))
				&& (this.getCooperationBrcode() == null ? other.getCooperationBrcode() == null
						: this.getCooperationBrcode().equals(other.getCooperationBrcode()))
				&& (this.getRentSettleWay() == null ? other.getRentSettleWay() == null
						: this.getRentSettleWay().equals(other.getRentSettleWay()))
				&& (this.getPoolBailAmt() == null ? other.getPoolBailAmt() == null
						: this.getPoolBailAmt().equals(other.getPoolBailAmt()))
				&& (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
				&& (this.getCrtTime() == null ? other.getCrtTime() == null
						: this.getCrtTime().equals(other.getCrtTime()))
				&& (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
				&& (this.getLastUpdTlrcd() == null ? other.getLastUpdTlrcd() == null
						: this.getLastUpdTlrcd().equals(other.getLastUpdTlrcd()))
				&& (this.getLastUpdTime() == null ? other.getLastUpdTime() == null
						: this.getLastUpdTime().equals(other.getLastUpdTime()))
				&& (this.getLastUpdBrcode() == null ? other.getLastUpdBrcode() == null
						: this.getLastUpdBrcode().equals(other.getLastUpdBrcode()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getDebtContno() == null) ? 0 : getDebtContno().hashCode());
		result = prime * result + ((getLoanPercent() == null) ? 0 : getLoanPercent().hashCode());
		result = prime * result + ((getFactType() == null) ? 0 : getFactType().hashCode());
		result = prime * result + ((getFinancingType() == null) ? 0 : getFinancingType().hashCode());
		result = prime * result + ((getChargeType() == null) ? 0 : getChargeType().hashCode());
		result = prime * result + ((getNoticeType() == null) ? 0 : getNoticeType().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getIsAutoPay() == null) ? 0 : getIsAutoPay().hashCode());
		result = prime * result + ((getAutoPayDays() == null) ? 0 : getAutoPayDays().hashCode());
		result = prime * result + ((getServiceContent() == null) ? 0 : getServiceContent().hashCode());
		result = prime * result + ((getSupplyChainPdId() == null) ? 0 : getSupplyChainPdId().hashCode());
		result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
		result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
		result = prime * result + ((getContAmount() == null) ? 0 : getContAmount().hashCode());
		result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
		result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
		result = prime * result + ((getLoanWay() == null) ? 0 : getLoanWay().hashCode());
		result = prime * result + ((getContStatus() == null) ? 0 : getContStatus().hashCode());
		result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
		result = prime * result + ((getMgrno() == null) ? 0 : getMgrno().hashCode());
		result = prime * result + ((getBailAcctNo() == null) ? 0 : getBailAcctNo().hashCode());
		result = prime * result + ((getReturnAccount() == null) ? 0 : getReturnAccount().hashCode());
		result = prime * result + ((getRecoverType() == null) ? 0 : getRecoverType().hashCode());
		result = prime * result + ((getRepayPurpose() == null) ? 0 : getRepayPurpose().hashCode());
		result = prime * result + ((getDueBalanceRule() == null) ? 0 : getDueBalanceRule().hashCode());
		result = prime * result + ((getPaymentVerifyRule() == null) ? 0 : getPaymentVerifyRule().hashCode());
		result = prime * result + ((getReparationProtNo() == null) ? 0 : getReparationProtNo().hashCode());
		result = prime * result + ((getLease() == null) ? 0 : getLease().hashCode());
		result = prime * result + ((getRepurchaser() == null) ? 0 : getRepurchaser().hashCode());
		result = prime * result + ((getRepurchaseProtNo() == null) ? 0 : getRepurchaseProtNo().hashCode());
		result = prime * result + ((getFactoringBrcode() == null) ? 0 : getFactoringBrcode().hashCode());
		result = prime * result + ((getReparationTerm() == null) ? 0 : getReparationTerm().hashCode());
		result = prime * result + ((getReparationPercent() == null) ? 0 : getReparationPercent().hashCode());
		result = prime * result
				+ ((getCumulativeReparationAmt() == null) ? 0 : getCumulativeReparationAmt().hashCode());
		result = prime * result + ((getFactPattern() == null) ? 0 : getFactPattern().hashCode());
		result = prime * result + ((getCooperationBrcode() == null) ? 0 : getCooperationBrcode().hashCode());
		result = prime * result + ((getRentSettleWay() == null) ? 0 : getRentSettleWay().hashCode());
		result = prime * result + ((getPoolBailAmt() == null) ? 0 : getPoolBailAmt().hashCode());
		result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
		result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
		result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
		result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
		result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
		result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
		return result;
	}
}
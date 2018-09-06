package com.huateng.scf.nrec.bcp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BCntBcpInfoVO extends BCntBcpExtInfoVO implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * DECIMAL(16,2)<br>
	 * 可融资总余额：发票余额*比率+现金余额-融资余额
	 */
	private BigDecimal poolUseableAmount;
	// 创建时间转型
	private String inpDt;

	public String getInpDt() {
		return inpDt;
	}

	public void setInpDt(String inpDt) {
		this.inpDt = inpDt;
	}

	// 保险公司名称
	private String insuranceName;

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	// 贸易对手保理商客户名称
	private String factoringBrcodeName;

	public String getFactoringBrcodeName() {
		return factoringBrcodeName;
	}

	public void setFactoringBrcodeName(String factoringBrcodeName) {
		this.factoringBrcodeName = factoringBrcodeName;
	}

	// 融资客户名称
	private String cname;
	// 交易对手名称
	private String cnameBuyer;
	/**
	 * VARCHAR(10) 必填<br>
	 * 业务种类名称：国内保理;反向保理;应收账款质押;国内双保理;信保保理;租赁保理
	 */
	private String supplyChainPdName;
	/**
	 * DECIMAL(22)<br>
	 * 账期(天)
	 */
	private BigDecimal loanDays;
	/**
	 * DECIMAL(22)<br>
	 * 宽限期(天)
	 */
	private BigDecimal debtGraceDays;
	/**
	 * DECIMAL(22)<br>
	 * 该合同下对应的应收账款余额（池合同）
	 */
	private BigDecimal totalDebtRemainAmount;
	/**
	 * DECIMAL(22)<br>
	 * 池敞口余额（池合同）
	 */
	private BigDecimal poolRiskAmt;

	public String getCnameBuyer() {
		return cnameBuyer;
	}

	public void setCnameBuyer(String cnameBuyer) {
		this.cnameBuyer = cnameBuyer;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getSupplyChainPdName() {
		return supplyChainPdName;
	}

	public void setSupplyChainPdName(String supplyChainPdName) {
		this.supplyChainPdName = supplyChainPdName;
	}

	public BigDecimal getLoanDays() {
		return loanDays;
	}

	public void setLoanDays(BigDecimal loanDays) {
		this.loanDays = loanDays;
	}

	public BigDecimal getDebtGraceDays() {
		return debtGraceDays;
	}

	public void setDebtGraceDays(BigDecimal debtGraceDays) {
		this.debtGraceDays = debtGraceDays;
	}

	public BigDecimal getTotalDebtRemainAmount() {
		return totalDebtRemainAmount;
	}

	public void setTotalDebtRemainAmount(BigDecimal totalDebtRemainAmount) {
		this.totalDebtRemainAmount = totalDebtRemainAmount;
	}

	public BigDecimal getPoolRiskAmt() {
		return poolRiskAmt;
	}

	public void setPoolRiskAmt(BigDecimal poolRiskAmt) {
		this.poolRiskAmt = poolRiskAmt;
	}

	/**
	 * VARCHAR(20) 必填<br>
	 * 业务合同号
	 */
	private String mastContno;

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
	 * CHAR(1)<br>
	 * 融资模式：1-发票融资;2-池融资
	 */
	private String financingType;

	/**
	 * VARCHAR(500)<br>
	 * 其他信息备注
	 */
	private String remark;

	/**
	 * VARCHAR(10) 必填<br>
	 * 业务种类：国内保理;反向保理;应收账款质押;国内双保理;信保保理;租赁保理
	 */
	private String supplyChainPdId;

	/**
	 * VARCHAR(15) 必填<br>
	 * 融资企业
	 */
	private String custcd;
	/**
	 * VARCHAR(15) 必填<br>
	 * 交易对手客户号
	 */
	private String businessCustcd;

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
	 * VARCHAR(50)<br>
	 * 回款专户
	 */
	private String returnAccount;

	/**
	 * VARCHAR(100)<br>
	 * 赔款转让协议号
	 */
	private String reparationProtNo;

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
	 * 贸易对手保理商客户号
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

	public BigDecimal getPoolUseableAmount() {
		return poolUseableAmount;
	}

	public void setPoolUseableAmount(BigDecimal poolUseableAmount) {
		this.poolUseableAmount = poolUseableAmount;
	}

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
	 * VARCHAR(10)<br>
	 * 租赁方式:01-普通租赁;02-售后回租;03-融资租赁
	 */
	private String lease;

	/**
	 * CHAR(1)<br>
	 * 租金处理方式：1-质押、2-转让
	 */
	private String rentSettleWay;

	/**
	 * DECIMAL(11,7)<br>
	 * 手续费/管理费率
	 */
	private BigDecimal feeRate;

	/**
	 * DECIMAL(11,7)<br>
	 * 保理费率
	 */
	private BigDecimal blFeeRate;

	/**
	 * VARCHAR(10)<br>
	 * 计息周期
	 */
	private String jxPeriod;

	/**
	 * DECIMAL(2)<br>
	 * 结息日
	 */
	private Short jxDay;

	/**
	 * VARCHAR(10)<br>
	 * 收费/还款方式
	 */
	private String returnType;

	/**
	 * DECIMAL(2)<br>
	 * 逾期限期
	 */
	private Short yqDay;

	/**
	 * DECIMAL(11,7)<br>
	 * 逾期罚息费率
	 */
	private BigDecimal yqRate;

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
	 * VARCHAR(20)<br>
	 * 备注1
	 */
	private String ext1;

	/**
	 * VARCHAR(20)<br>
	 * 备注2
	 */
	private String ext2;

	/**
	 * VARCHAR(20)<br>
	 * 备注3
	 */
	private String ext3;

	/**
	 * VARCHAR(20)<br>
	 * 备注4
	 */
	private String ext4;

	/**
	 * VARCHAR(20)<br>
	 * 备注5
	 */
	private String ext5;

	/**
	 * VARCHAR(20) 必填<br>
	 * 获得 业务合同号
	 */
	public String getMastContno() {
		return mastContno;
	}

	/**
	 * VARCHAR(20) 必填<br>
	 * 设置 业务合同号
	 */
	public void setMastContno(String mastContno) {
		this.mastContno = mastContno == null ? null : mastContno.trim();
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

	public String getFactType() {
		return factType;
	}

	public void setFactType(String factType) {
		this.factType = factType;
	}

	/**
	 * CHAR(1)<br>
	 * 获得 融资模式：1-发票融资;2-池融资
	 */
	public String getFinancingType() {
		return financingType;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 融资模式：1-发票融资;2-池融资
	 */
	public void setFinancingType(String financingType) {
		this.financingType = financingType == null ? null : financingType.trim();
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
	 * 获得 融资企业
	 */
	public String getCustcd() {
		return custcd;
	}

	/**
	 * VARCHAR(15) 必填<br>
	 * 设置 融资企业
	 */
	public void setCustcd(String custcd) {
		this.custcd = custcd == null ? null : custcd.trim();
	}

	public String getBusinessCustcd() {
		return businessCustcd;
	}

	public void setBusinessCustcd(String businessCustcd) {
		this.businessCustcd = businessCustcd;
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
	 * 获得 贸易对手保理商客户号
	 */
	public String getFactoringBrcode() {
		return factoringBrcode;
	}

	/**
	 * VARCHAR(15)<br>
	 * 设置 贸易对手保理商客户号
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
	 * DECIMAL(11,7)<br>
	 * 获得 手续费/管理费率
	 */
	public BigDecimal getFeeRate() {
		return feeRate;
	}

	/**
	 * DECIMAL(11,7)<br>
	 * 设置 手续费/管理费率
	 */
	public void setFeeRate(BigDecimal feeRate) {
		this.feeRate = feeRate;
	}

	/**
	 * DECIMAL(11,7)<br>
	 * 获得 保理费率
	 */
	public BigDecimal getBlFeeRate() {
		return blFeeRate;
	}

	/**
	 * DECIMAL(11,7)<br>
	 * 设置 保理费率
	 */
	public void setBlFeeRate(BigDecimal blFeeRate) {
		this.blFeeRate = blFeeRate;
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 计息周期
	 */
	public String getJxPeriod() {
		return jxPeriod;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 计息周期
	 */
	public void setJxPeriod(String jxPeriod) {
		this.jxPeriod = jxPeriod == null ? null : jxPeriod.trim();
	}

	/**
	 * DECIMAL(2)<br>
	 * 获得 结息日
	 */
	public Short getJxDay() {
		return jxDay;
	}

	/**
	 * DECIMAL(2)<br>
	 * 设置 结息日
	 */
	public void setJxDay(Short jxDay) {
		this.jxDay = jxDay;
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 收费/还款方式
	 */
	public String getReturnType() {
		return returnType;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 收费/还款方式
	 */
	public void setReturnType(String returnType) {
		this.returnType = returnType == null ? null : returnType.trim();
	}

	/**
	 * DECIMAL(2)<br>
	 * 获得 逾期限期
	 */
	public Short getYqDay() {
		return yqDay;
	}

	/**
	 * DECIMAL(2)<br>
	 * 设置 逾期限期
	 */
	public void setYqDay(Short yqDay) {
		this.yqDay = yqDay;
	}

	/**
	 * DECIMAL(11,7)<br>
	 * 获得 逾期罚息费率
	 */
	public BigDecimal getYqRate() {
		return yqRate;
	}

	/**
	 * DECIMAL(11,7)<br>
	 * 设置 逾期罚息费率
	 */
	public void setYqRate(BigDecimal yqRate) {
		this.yqRate = yqRate;
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

	/**
	 * VARCHAR(20)<br>
	 * 获得 备注1
	 */
	public String getExt1() {
		return ext1;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 备注1
	 */
	public void setExt1(String ext1) {
		this.ext1 = ext1 == null ? null : ext1.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 备注2
	 */
	public String getExt2() {
		return ext2;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 备注2
	 */
	public void setExt2(String ext2) {
		this.ext2 = ext2 == null ? null : ext2.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 备注3
	 */
	public String getExt3() {
		return ext3;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 备注3
	 */
	public void setExt3(String ext3) {
		this.ext3 = ext3 == null ? null : ext3.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 备注4
	 */
	public String getExt4() {
		return ext4;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 备注4
	 */
	public void setExt4(String ext4) {
		this.ext4 = ext4 == null ? null : ext4.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 备注5
	 */
	public String getExt5() {
		return ext5;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 备注5
	 */
	public void setExt5(String ext5) {
		this.ext5 = ext5 == null ? null : ext5.trim();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", mastContno=").append(mastContno);
		sb.append(", loanPercent=").append(loanPercent);
		sb.append(", financingType=").append(financingType);
		sb.append(", remark=").append(remark);
		sb.append(", supplyChainPdId=").append(supplyChainPdId);
		sb.append(", custcd=").append(custcd);
		sb.append(", curcd=").append(curcd);
		sb.append(", contAmount=").append(contAmount);
		sb.append(", startDate=").append(startDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", contStatus=").append(contStatus);
		sb.append(", accountNo=").append(accountNo);
		sb.append(", returnAccount=").append(returnAccount);
		sb.append(", reparationProtNo=").append(reparationProtNo);
		sb.append(", repurchaser=").append(repurchaser);
		sb.append(", repurchaseProtNo=").append(repurchaseProtNo);
		sb.append(", factoringBrcode=").append(factoringBrcode);
		sb.append(", reparationTerm=").append(reparationTerm);
		sb.append(", reparationPercent=").append(reparationPercent);
		sb.append(", cumulativeReparationAmt=").append(cumulativeReparationAmt);
		sb.append(", factPattern=").append(factPattern);
		sb.append(", cooperationBrcode=").append(cooperationBrcode);
		sb.append(", lease=").append(lease);
		sb.append(", rentSettleWay=").append(rentSettleWay);
		sb.append(", feeRate=").append(feeRate);
		sb.append(", blFeeRate=").append(blFeeRate);
		sb.append(", jxPeriod=").append(jxPeriod);
		sb.append(", jxDay=").append(jxDay);
		sb.append(", returnType=").append(returnType);
		sb.append(", yqDay=").append(yqDay);
		sb.append(", yqRate=").append(yqRate);
		sb.append(", tlrcd=").append(tlrcd);
		sb.append(", crtTime=").append(crtTime);
		sb.append(", brcode=").append(brcode);
		sb.append(", lastUpdTlrcd=").append(lastUpdTlrcd);
		sb.append(", lastUpdTime=").append(lastUpdTime);
		sb.append(", lastUpdBrcode=").append(lastUpdBrcode);
		sb.append(", ext1=").append(ext1);
		sb.append(", ext2=").append(ext2);
		sb.append(", ext3=").append(ext3);
		sb.append(", ext4=").append(ext4);
		sb.append(", ext5=").append(ext5);
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
		BCntBcpInfoVO other = (BCntBcpInfoVO) that;
		return (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
				&& (this.getLoanPercent() == null ? other.getLoanPercent() == null : this.getLoanPercent().equals(other.getLoanPercent()))
				&& (this.getFinancingType() == null ? other.getFinancingType() == null : this.getFinancingType().equals(other.getFinancingType()))
				&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
				&& (this.getSupplyChainPdId() == null ? other.getSupplyChainPdId() == null
						: this.getSupplyChainPdId().equals(other.getSupplyChainPdId()))
				&& (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
				&& (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
				&& (this.getContAmount() == null ? other.getContAmount() == null : this.getContAmount().equals(other.getContAmount()))
				&& (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
				&& (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
				&& (this.getContStatus() == null ? other.getContStatus() == null : this.getContStatus().equals(other.getContStatus()))
				&& (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
				&& (this.getReturnAccount() == null ? other.getReturnAccount() == null : this.getReturnAccount().equals(other.getReturnAccount()))
				&& (this.getReparationProtNo() == null ? other.getReparationProtNo() == null
						: this.getReparationProtNo().equals(other.getReparationProtNo()))
				&& (this.getRepurchaser() == null ? other.getRepurchaser() == null : this.getRepurchaser().equals(other.getRepurchaser()))
				&& (this.getRepurchaseProtNo() == null ? other.getRepurchaseProtNo() == null
						: this.getRepurchaseProtNo().equals(other.getRepurchaseProtNo()))
				&& (this.getFactoringBrcode() == null ? other.getFactoringBrcode() == null
						: this.getFactoringBrcode().equals(other.getFactoringBrcode()))
				&& (this.getReparationTerm() == null ? other.getReparationTerm() == null : this.getReparationTerm().equals(other.getReparationTerm()))
				&& (this.getReparationPercent() == null ? other.getReparationPercent() == null
						: this.getReparationPercent().equals(other.getReparationPercent()))
				&& (this.getCumulativeReparationAmt() == null ? other.getCumulativeReparationAmt() == null
						: this.getCumulativeReparationAmt().equals(other.getCumulativeReparationAmt()))
				&& (this.getFactPattern() == null ? other.getFactPattern() == null : this.getFactPattern().equals(other.getFactPattern()))
				&& (this.getCooperationBrcode() == null ? other.getCooperationBrcode() == null
						: this.getCooperationBrcode().equals(other.getCooperationBrcode()))
				&& (this.getLease() == null ? other.getLease() == null : this.getLease().equals(other.getLease()))
				&& (this.getRentSettleWay() == null ? other.getRentSettleWay() == null : this.getRentSettleWay().equals(other.getRentSettleWay()))
				&& (this.getFeeRate() == null ? other.getFeeRate() == null : this.getFeeRate().equals(other.getFeeRate()))
				&& (this.getBlFeeRate() == null ? other.getBlFeeRate() == null : this.getBlFeeRate().equals(other.getBlFeeRate()))
				&& (this.getJxPeriod() == null ? other.getJxPeriod() == null : this.getJxPeriod().equals(other.getJxPeriod()))
				&& (this.getJxDay() == null ? other.getJxDay() == null : this.getJxDay().equals(other.getJxDay()))
				&& (this.getReturnType() == null ? other.getReturnType() == null : this.getReturnType().equals(other.getReturnType()))
				&& (this.getYqDay() == null ? other.getYqDay() == null : this.getYqDay().equals(other.getYqDay()))
				&& (this.getYqRate() == null ? other.getYqRate() == null : this.getYqRate().equals(other.getYqRate()))
				&& (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
				&& (this.getCrtTime() == null ? other.getCrtTime() == null : this.getCrtTime().equals(other.getCrtTime()))
				&& (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
				&& (this.getLastUpdTlrcd() == null ? other.getLastUpdTlrcd() == null : this.getLastUpdTlrcd().equals(other.getLastUpdTlrcd()))
				&& (this.getLastUpdTime() == null ? other.getLastUpdTime() == null : this.getLastUpdTime().equals(other.getLastUpdTime()))
				&& (this.getLastUpdBrcode() == null ? other.getLastUpdBrcode() == null : this.getLastUpdBrcode().equals(other.getLastUpdBrcode()))
				&& (this.getExt1() == null ? other.getExt1() == null : this.getExt1().equals(other.getExt1()))
				&& (this.getExt2() == null ? other.getExt2() == null : this.getExt2().equals(other.getExt2()))
				&& (this.getExt3() == null ? other.getExt3() == null : this.getExt3().equals(other.getExt3()))
				&& (this.getExt4() == null ? other.getExt4() == null : this.getExt4().equals(other.getExt4()))
				&& (this.getExt5() == null ? other.getExt5() == null : this.getExt5().equals(other.getExt5()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
		result = prime * result + ((getLoanPercent() == null) ? 0 : getLoanPercent().hashCode());
		result = prime * result + ((getFinancingType() == null) ? 0 : getFinancingType().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getSupplyChainPdId() == null) ? 0 : getSupplyChainPdId().hashCode());
		result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
		result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
		result = prime * result + ((getContAmount() == null) ? 0 : getContAmount().hashCode());
		result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
		result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
		result = prime * result + ((getContStatus() == null) ? 0 : getContStatus().hashCode());
		result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
		result = prime * result + ((getReturnAccount() == null) ? 0 : getReturnAccount().hashCode());
		result = prime * result + ((getReparationProtNo() == null) ? 0 : getReparationProtNo().hashCode());
		result = prime * result + ((getRepurchaser() == null) ? 0 : getRepurchaser().hashCode());
		result = prime * result + ((getRepurchaseProtNo() == null) ? 0 : getRepurchaseProtNo().hashCode());
		result = prime * result + ((getFactoringBrcode() == null) ? 0 : getFactoringBrcode().hashCode());
		result = prime * result + ((getReparationTerm() == null) ? 0 : getReparationTerm().hashCode());
		result = prime * result + ((getReparationPercent() == null) ? 0 : getReparationPercent().hashCode());
		result = prime * result + ((getCumulativeReparationAmt() == null) ? 0 : getCumulativeReparationAmt().hashCode());
		result = prime * result + ((getFactPattern() == null) ? 0 : getFactPattern().hashCode());
		result = prime * result + ((getCooperationBrcode() == null) ? 0 : getCooperationBrcode().hashCode());
		result = prime * result + ((getLease() == null) ? 0 : getLease().hashCode());
		result = prime * result + ((getRentSettleWay() == null) ? 0 : getRentSettleWay().hashCode());
		result = prime * result + ((getFeeRate() == null) ? 0 : getFeeRate().hashCode());
		result = prime * result + ((getBlFeeRate() == null) ? 0 : getBlFeeRate().hashCode());
		result = prime * result + ((getJxPeriod() == null) ? 0 : getJxPeriod().hashCode());
		result = prime * result + ((getJxDay() == null) ? 0 : getJxDay().hashCode());
		result = prime * result + ((getReturnType() == null) ? 0 : getReturnType().hashCode());
		result = prime * result + ((getYqDay() == null) ? 0 : getYqDay().hashCode());
		result = prime * result + ((getYqRate() == null) ? 0 : getYqRate().hashCode());
		result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
		result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
		result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
		result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
		result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
		result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
		result = prime * result + ((getExt1() == null) ? 0 : getExt1().hashCode());
		result = prime * result + ((getExt2() == null) ? 0 : getExt2().hashCode());
		result = prime * result + ((getExt3() == null) ? 0 : getExt3().hashCode());
		result = prime * result + ((getExt4() == null) ? 0 : getExt4().hashCode());
		result = prime * result + ((getExt5() == null) ? 0 : getExt5().hashCode());
		return result;
	}
}
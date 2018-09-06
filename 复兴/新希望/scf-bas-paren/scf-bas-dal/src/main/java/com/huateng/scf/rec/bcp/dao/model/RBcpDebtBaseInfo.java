package com.huateng.scf.rec.bcp.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class RBcpDebtBaseInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(32) 必填<br>
	 * 主键UUID
	 */
	private String id;

	/**
	 * VARCHAR(15)<br>
	 * 卖方客户号
	 */
	private String custcdSaller;

	/**
	 * VARCHAR(80)<br>
	 * 买方客户名称
	 */
	private String cnameBuyer;

	/**
	 * VARCHAR(15)<br>
	 * 买方客户号
	 */
	private String custcdBuyer;

	/**
	 * VARCHAR(80)<br>
	 * 卖方客户名称
	 */
	private String cnameSeller;

	/**
	 * VARCHAR(20)<br>
	 * 业务合同编号
	 */
	private String mastContno;

	/**
	 * CHAR(8)<br>
	 * 应收账款登记日期
	 */
	private String insertDate;

	/**
	 * DECIMAL(22)<br>
	 * 账期
	 */
	private String aging;

	/**
	 * VARCHAR(10)<br>
	 * 业务品种
	 */
	private String bussType;
	/**
	 * VARCHAR(10)<br>
	 * 业务品种
	 */
	private String bussTypeName;

	/**
	 * VARCHAR(100)<br>
	 * 凭证编号
	 */
	private String billsNo;

	/**
	 * CHAR(2)<br>
	 * 凭证类型(DATA_DIC.4204)
	 */
	private String billsType;

	/**
	 * CHAR(8)<br>
	 * 应收账款日期
	 */
	private String billsDate;

	/**
	 * CHAR(8)<br>
	 * 应收账款到期日
	 */
	private String debtEnd;

	/**
	 * DECIMAL(16,2)<br>
	 * 有效金额
	 */
	private BigDecimal billsAmount;

	/**
	 * DECIMAL(16,2)<br>
	 * 票面金额
	 */
	private BigDecimal billsAmountView;

	/**
	 * DECIMAL(16,2)<br>
	 * 应收账款余额
	 */
	private BigDecimal remainingAmount;

	/**
	 * CHAR(3)<br>
	 * 币别
	 */
	private String curcd;

	/**
	 * DECIMAL(5,2)<br>
	 * 融资比例(%)
	 */
	private BigDecimal loanPercent;

	/**
	 * DECIMAL(16,2)<br>
	 * 融资金额
	 */
	private BigDecimal loanAmount;

	/**
	 * CHAR(8)<br>
	 * 应收账款转让日期
	 */
	private String purchaseDate;

	/**
	 * DECIMAL(16,2)<br>
	 * 融资余额
	 */
	private BigDecimal loanRemainingAmount;

	/**
	 * DECIMAL(16,2)<br>
	 * 可用融资余额
	 */
	private BigDecimal remainingUseableAmount;

	/**
	 * DECIMAL(16,2)<br>
	 * 应收利息总额
	 */
	private BigDecimal rateCollectAmount;

	/**
	 * DECIMAL(16,2)<br>
	 * 欠利息总额
	 */
	private BigDecimal ownRateCollectAmount;

	/**
	 * CHAR(8)<br>
	 * 融资到期日
	 */
	private String loanEndDate;

	/**
	 * DECIMAL(5,2)<br>
	 * 担保比例
	 */
	private BigDecimal assurePercent;

	/**
	 * CHAR(8)<br>
	 * 担保付款日
	 */
	private String assurePayDate;

	/**
	 * DECIMAL(16,2)<br>
	 * 折让金额
	 */
	private BigDecimal rebateAmount;

	/**
	 * DECIMAL(16,2)<br>
	 * 回购金额
	 */
	private BigDecimal buyBackAmount;

	/**
	 * DECIMAL(16,2)<br>
	 * 付款金额
	 */
	private BigDecimal payAmount;

	/**
	 * DECIMAL(16,2)<br>
	 * 入账金额
	 */
	private BigDecimal removeAmount;

	/**
	 * DECIMAL(16,2)<br>
	 * 现金余额
	 */
	private BigDecimal cashRemainingAmount;

	/**
	 * CHAR(1)<br>
	 * 瑕疵标记：1-有瑕疵、0-无瑕疵
	 */
	private String flawFlag;

	/**
	 * VARCHAR(100)<br>
	 * 瑕疵原因
	 */
	private String flawReason;

	/**
	 * CHAR(1)<br>
	 * 商纠状态：1-有商纠、0-无商纠
	 */
	private String issueFlag;

	/**
	 * VARCHAR(100)<br>
	 * 商纠原因
	 */
	private String issueReason;

	/**
	 * CHAR(1)<br>
	 * 逾期状态：1-有、0-无
	 */
	private String overdueFlag;

	/**
	 * VARCHAR(100)<br>
	 * 逾期原因
	 */
	private String overdueReason;

	/**
	 * CHAR(1)<br>
	 * 是否呆账：1-有、0-无
	 */
	private String badFlag;

	/**
	 * VARCHAR(100)<br>
	 * 呆账原因
	 */
	private String badReason;

	/**
	 * VARCHAR(100)<br>
	 * 应收账款池状态：1-池内、0-池外
	 */
	private String poolFlag;

	/**
	 * DECIMAL(16,2)<br>
	 * 应收账款逾期余额
	 */
	private BigDecimal overdueAmount;

	/**
	 * VARCHAR(2)<br>
	 * 应收账款质押状态：01-已质押、02-已解除质押
	 */
	private String pledgeStatus;

	/**
	 * VARCHAR(2)<br>
	 * 应收账款逾期状态：01-未逾期、02-已逾期
	 */
	private String overdueStatus;

	/**
	 * CHAR(2)<br>
	 * 应收账款单据状态：01-已录入、02-已转让/出质、03-已核销、04-已融资
	 */
	private String status;

	/**
	 * CHAR(2)<br>
	 * 还款状态：01-未还款、02-部分还款、03-已还款
	 */
	private String returnStatus;

	/**
	 * CHAR(8)<br>
	 * 质押生效日期
	 */
	private String pledgeActiveDate;

	/**
	 * CHAR(8)<br>
	 * 解押生效日期
	 */
	private String unpledgeActiveDate;

	/**
	 * VARCHAR(500)<br>
	 * 备注
	 */
	private String memo;

	/**
	 * DECIMAL(22)<br>
	 * 催收次数
	 */
	private BigDecimal pressCount;

	/**
	 * DECIMAL(22)<br>
	 * 催收提示次数
	 */
	private BigDecimal warnCount;

	/**
	 * CHAR(2)<br>
	 * 结算单账期
	 */
	private String billsPeriod;

	/**
	 * CHAR(8)<br>
	 * 结算单开始日期
	 */
	private String beginDate;

	/**
	 * CHAR(8)<br>
	 * 结算单结束日期
	 */
	private String endDate;

	/**
	 * CHAR(8)<br>
	 * 支付日期
	 */
	private String paydate;

	/**
	 * VARCHAR(100)<br>
	 * 删除原因
	 */
	private String deleteReason;

	/**
	 * VARCHAR(100)<br>
	 * 其它原因
	 */
	private String otherReason;

	/**
	 * VARCHAR(100)<br>
	 * 原因
	 */
	private String reason;

	/**
	 * CHAR(1)<br>
	 * 融资逾期标记：1-融资逾期、2-正常
	 */
	private String loanOverdueFlag;

	/**
	 * VARCHAR(20)<br>
	 * 放款借据号
	 */
	private String debetNo;

	/**
	 * DECIMAL(16,2)<br>
	 * 首次保证金金额
	 */
	private BigDecimal bailAmount;

	/**
	 * DECIMAL(16,2)<br>
	 * 追加保证金金额
	 */
	private BigDecimal addBailAmount;

	/**
	 * CHAR(1)<br>
	 * 是否锁定：0-未锁定、1-锁定
	 */
	private String isLocked;

	/**
	 * VARCHAR(20)<br>
	 * 加锁业务申请编号
	 */
	private String lockAppno;

	/**
	 * CHAR(1)<br>
	 * 保理业务类别(DATA_DIC.50042)
	 */
	private String factType;

	/**
	 * VARCHAR(2)<br>
	 * 出账方式：01-流贷、02-银承
	 */
	private String loanWay;

	/**
	 * CHAR(8)<br>
	 * 最迟付款日
	 */
	private String deadline;

	/**
	 * VARCHAR(50)<br>
	 * 商务合同号
	 */
	private String bussContcode;

	/**
	 * DECIMAL(22)<br>
	 * 宽限期
	 */
	private BigDecimal gracePeriod;

	/**
	 * CHAR(1)<br>
	 * 理赔状态
	 */
	private String claimStatus;

	/**
	 * CHAR(8)<br>
	 * 转让回执确认日期
	 */
	private String confirmDate;

	/**
	 * VARCHAR(50)<br>
	 * 网银流水号
	 */
	private String ebankAppno;

	/**
	 * CHAR(1)<br>
	 * 渠道标识：1-供应链、2-企业网银
	 */
	private String channelFlag;

	/**
	 * DECIMAL(22)<br>
	 * 商纠次数
	 */
	private Integer issueTimes;

	/**
	 * CHAR(1)<br>
	 * 是否已付款：0-否、1-是
	 */
	private String isPay;

	public String getBussTypeName() {
		return bussTypeName;
	}

	public void setBussTypeName(String bussTypeName) {
		this.bussTypeName = bussTypeName;
	}

	/**
	 * VARCHAR(32) 必填<br>
	 * 获得 主键UUID
	 */
	public String getId() {
		return id;
	}

	/**
	 * VARCHAR(32) 必填<br>
	 * 设置 主键UUID
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * VARCHAR(15)<br>
	 * 获得 卖方客户号
	 */
	public String getCustcdSaller() {
		return custcdSaller;
	}

	/**
	 * VARCHAR(15)<br>
	 * 设置 卖方客户号
	 */
	public void setCustcdSaller(String custcdSaller) {
		this.custcdSaller = custcdSaller == null ? null : custcdSaller.trim();
	}

	/**
	 * VARCHAR(80)<br>
	 * 获得 买方客户名称
	 */
	public String getCnameBuyer() {
		return cnameBuyer;
	}

	/**
	 * VARCHAR(80)<br>
	 * 设置 买方客户名称
	 */
	public void setCnameBuyer(String cnameBuyer) {
		this.cnameBuyer = cnameBuyer == null ? null : cnameBuyer.trim();
	}

	/**
	 * VARCHAR(15)<br>
	 * 获得 买方客户号
	 */
	public String getCustcdBuyer() {
		return custcdBuyer;
	}

	/**
	 * VARCHAR(15)<br>
	 * 设置 买方客户号
	 */
	public void setCustcdBuyer(String custcdBuyer) {
		this.custcdBuyer = custcdBuyer == null ? null : custcdBuyer.trim();
	}

	/**
	 * VARCHAR(80)<br>
	 * 获得 卖方客户名称
	 */
	public String getCnameSeller() {
		return cnameSeller;
	}

	/**
	 * VARCHAR(80)<br>
	 * 设置 卖方客户名称
	 */
	public void setCnameSeller(String cnameSeller) {
		this.cnameSeller = cnameSeller == null ? null : cnameSeller.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 业务合同编号
	 */
	public String getMastContno() {
		return mastContno;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 业务合同编号
	 */
	public void setMastContno(String mastContno) {
		this.mastContno = mastContno == null ? null : mastContno.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 应收账款登记日期
	 */
	public String getInsertDate() {
		return insertDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 应收账款登记日期
	 */
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate == null ? null : insertDate.trim();
	}

	/**
	 * DECIMAL(22)<br>
	 * 获得 账期
	 */
	public String getAging() {
		return aging;
	}

	/**
	 * DECIMAL(22)<br>
	 * 设置 账期
	 */
	public void setAging(String aging) {
		this.aging = aging;
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 业务品种
	 */
	public String getBussType() {
		return bussType;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 业务品种
	 */
	public void setBussType(String bussType) {
		this.bussType = bussType == null ? null : bussType.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 凭证编号
	 */
	public String getBillsNo() {
		return billsNo;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 凭证编号
	 */
	public void setBillsNo(String billsNo) {
		this.billsNo = billsNo == null ? null : billsNo.trim();
	}

	/**
	 * CHAR(2)<br>
	 * 获得 凭证类型(DATA_DIC.4204)
	 */
	public String getBillsType() {
		return billsType;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 凭证类型(DATA_DIC.4204)
	 */
	public void setBillsType(String billsType) {
		this.billsType = billsType == null ? null : billsType.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 应收账款日期
	 */
	public String getBillsDate() {
		return billsDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 应收账款日期
	 */
	public void setBillsDate(String billsDate) {
		this.billsDate = billsDate == null ? null : billsDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 应收账款到期日
	 */
	public String getDebtEnd() {
		return debtEnd;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 应收账款到期日
	 */
	public void setDebtEnd(String debtEnd) {
		this.debtEnd = debtEnd == null ? null : debtEnd.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 有效金额
	 */
	public BigDecimal getBillsAmount() {
		return billsAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 有效金额
	 */
	public void setBillsAmount(BigDecimal billsAmount) {
		this.billsAmount = billsAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 票面金额
	 */
	public BigDecimal getBillsAmountView() {
		return billsAmountView;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 票面金额
	 */
	public void setBillsAmountView(BigDecimal billsAmountView) {
		this.billsAmountView = billsAmountView;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 应收账款余额
	 */
	public BigDecimal getRemainingAmount() {
		return remainingAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 应收账款余额
	 */
	public void setRemainingAmount(BigDecimal remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	/**
	 * CHAR(3)<br>
	 * 获得 币别
	 */
	public String getCurcd() {
		return curcd;
	}

	/**
	 * CHAR(3)<br>
	 * 设置 币别
	 */
	public void setCurcd(String curcd) {
		this.curcd = curcd == null ? null : curcd.trim();
	}

	/**
	 * DECIMAL(5,2)<br>
	 * 获得 融资比例(%)
	 */
	public BigDecimal getLoanPercent() {
		return loanPercent;
	}

	/**
	 * DECIMAL(5,2)<br>
	 * 设置 融资比例(%)
	 */
	public void setLoanPercent(BigDecimal loanPercent) {
		this.loanPercent = loanPercent;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 融资金额
	 */
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 融资金额
	 */
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * CHAR(8)<br>
	 * 获得 应收账款转让日期
	 */
	public String getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 应收账款转让日期
	 */
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate == null ? null : purchaseDate.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 融资余额
	 */
	public BigDecimal getLoanRemainingAmount() {
		return loanRemainingAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 融资余额
	 */
	public void setLoanRemainingAmount(BigDecimal loanRemainingAmount) {
		this.loanRemainingAmount = loanRemainingAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 可用融资余额
	 */
	public BigDecimal getRemainingUseableAmount() {
		return remainingUseableAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 可用融资余额
	 */
	public void setRemainingUseableAmount(BigDecimal remainingUseableAmount) {
		this.remainingUseableAmount = remainingUseableAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 应收利息总额
	 */
	public BigDecimal getRateCollectAmount() {
		return rateCollectAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 应收利息总额
	 */
	public void setRateCollectAmount(BigDecimal rateCollectAmount) {
		this.rateCollectAmount = rateCollectAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 欠利息总额
	 */
	public BigDecimal getOwnRateCollectAmount() {
		return ownRateCollectAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 欠利息总额
	 */
	public void setOwnRateCollectAmount(BigDecimal ownRateCollectAmount) {
		this.ownRateCollectAmount = ownRateCollectAmount;
	}

	/**
	 * CHAR(8)<br>
	 * 获得 融资到期日
	 */
	public String getLoanEndDate() {
		return loanEndDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 融资到期日
	 */
	public void setLoanEndDate(String loanEndDate) {
		this.loanEndDate = loanEndDate == null ? null : loanEndDate.trim();
	}

	/**
	 * DECIMAL(5,2)<br>
	 * 获得 担保比例
	 */
	public BigDecimal getAssurePercent() {
		return assurePercent;
	}

	/**
	 * DECIMAL(5,2)<br>
	 * 设置 担保比例
	 */
	public void setAssurePercent(BigDecimal assurePercent) {
		this.assurePercent = assurePercent;
	}

	/**
	 * CHAR(8)<br>
	 * 获得 担保付款日
	 */
	public String getAssurePayDate() {
		return assurePayDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 担保付款日
	 */
	public void setAssurePayDate(String assurePayDate) {
		this.assurePayDate = assurePayDate == null ? null : assurePayDate.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 折让金额
	 */
	public BigDecimal getRebateAmount() {
		return rebateAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 折让金额
	 */
	public void setRebateAmount(BigDecimal rebateAmount) {
		this.rebateAmount = rebateAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 回购金额
	 */
	public BigDecimal getBuyBackAmount() {
		return buyBackAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 回购金额
	 */
	public void setBuyBackAmount(BigDecimal buyBackAmount) {
		this.buyBackAmount = buyBackAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 付款金额
	 */
	public BigDecimal getPayAmount() {
		return payAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 付款金额
	 */
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 入账金额
	 */
	public BigDecimal getRemoveAmount() {
		return removeAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 入账金额
	 */
	public void setRemoveAmount(BigDecimal removeAmount) {
		this.removeAmount = removeAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 现金余额
	 */
	public BigDecimal getCashRemainingAmount() {
		return cashRemainingAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 现金余额
	 */
	public void setCashRemainingAmount(BigDecimal cashRemainingAmount) {
		this.cashRemainingAmount = cashRemainingAmount;
	}

	/**
	 * CHAR(1)<br>
	 * 获得 瑕疵标记：1-有瑕疵、0-无瑕疵
	 */
	public String getFlawFlag() {
		return flawFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 瑕疵标记：1-有瑕疵、0-无瑕疵
	 */
	public void setFlawFlag(String flawFlag) {
		this.flawFlag = flawFlag == null ? null : flawFlag.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 瑕疵原因
	 */
	public String getFlawReason() {
		return flawReason;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 瑕疵原因
	 */
	public void setFlawReason(String flawReason) {
		this.flawReason = flawReason == null ? null : flawReason.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 商纠状态：1-有商纠、0-无商纠
	 */
	public String getIssueFlag() {
		return issueFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 商纠状态：1-有商纠、0-无商纠
	 */
	public void setIssueFlag(String issueFlag) {
		this.issueFlag = issueFlag == null ? null : issueFlag.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 商纠原因
	 */
	public String getIssueReason() {
		return issueReason;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 商纠原因
	 */
	public void setIssueReason(String issueReason) {
		this.issueReason = issueReason == null ? null : issueReason.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 逾期状态：1-有、0-无
	 */
	public String getOverdueFlag() {
		return overdueFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 逾期状态：1-有、0-无
	 */
	public void setOverdueFlag(String overdueFlag) {
		this.overdueFlag = overdueFlag == null ? null : overdueFlag.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 逾期原因
	 */
	public String getOverdueReason() {
		return overdueReason;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 逾期原因
	 */
	public void setOverdueReason(String overdueReason) {
		this.overdueReason = overdueReason == null ? null : overdueReason.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否呆账：1-有、0-无
	 */
	public String getBadFlag() {
		return badFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否呆账：1-有、0-无
	 */
	public void setBadFlag(String badFlag) {
		this.badFlag = badFlag == null ? null : badFlag.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 呆账原因
	 */
	public String getBadReason() {
		return badReason;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 呆账原因
	 */
	public void setBadReason(String badReason) {
		this.badReason = badReason == null ? null : badReason.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 应收账款池状态：1-池内、0-池外
	 */
	public String getPoolFlag() {
		return poolFlag;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 应收账款池状态：1-池内、0-池外
	 */
	public void setPoolFlag(String poolFlag) {
		this.poolFlag = poolFlag == null ? null : poolFlag.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 应收账款逾期余额
	 */
	public BigDecimal getOverdueAmount() {
		return overdueAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 应收账款逾期余额
	 */
	public void setOverdueAmount(BigDecimal overdueAmount) {
		this.overdueAmount = overdueAmount;
	}

	/**
	 * VARCHAR(2)<br>
	 * 获得 应收账款质押状态：01-已质押、02-已解除质押
	 */
	public String getPledgeStatus() {
		return pledgeStatus;
	}

	/**
	 * VARCHAR(2)<br>
	 * 设置 应收账款质押状态：01-已质押、02-已解除质押
	 */
	public void setPledgeStatus(String pledgeStatus) {
		this.pledgeStatus = pledgeStatus == null ? null : pledgeStatus.trim();
	}

	/**
	 * VARCHAR(2)<br>
	 * 获得 应收账款逾期状态：01-未逾期、02-已逾期
	 */
	public String getOverdueStatus() {
		return overdueStatus;
	}

	/**
	 * VARCHAR(2)<br>
	 * 设置 应收账款逾期状态：01-未逾期、02-已逾期
	 */
	public void setOverdueStatus(String overdueStatus) {
		this.overdueStatus = overdueStatus == null ? null : overdueStatus.trim();
	}

	/**
	 * CHAR(2)<br>
	 * 获得 应收账款单据状态：01-已录入、02-已转让/出质、03-已核销、04-已融资
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 应收账款单据状态：01-已录入、02-已转让/出质、03-已核销、04-已融资
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	/**
	 * CHAR(2)<br>
	 * 获得 还款状态：01-未还款、02-部分还款、03-已还款
	 */
	public String getReturnStatus() {
		return returnStatus;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 还款状态：01-未还款、02-部分还款、03-已还款
	 */
	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus == null ? null : returnStatus.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 质押生效日期
	 */
	public String getPledgeActiveDate() {
		return pledgeActiveDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 质押生效日期
	 */
	public void setPledgeActiveDate(String pledgeActiveDate) {
		this.pledgeActiveDate = pledgeActiveDate == null ? null : pledgeActiveDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 解押生效日期
	 */
	public String getUnpledgeActiveDate() {
		return unpledgeActiveDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 解押生效日期
	 */
	public void setUnpledgeActiveDate(String unpledgeActiveDate) {
		this.unpledgeActiveDate = unpledgeActiveDate == null ? null : unpledgeActiveDate.trim();
	}

	/**
	 * VARCHAR(500)<br>
	 * 获得 备注
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * VARCHAR(500)<br>
	 * 设置 备注
	 */
	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}

	/**
	 * DECIMAL(22)<br>
	 * 获得 催收次数
	 */
	public BigDecimal getPressCount() {
		return pressCount;
	}

	/**
	 * DECIMAL(22)<br>
	 * 设置 催收次数
	 */
	public void setPressCount(BigDecimal pressCount) {
		this.pressCount = pressCount;
	}

	/**
	 * DECIMAL(22)<br>
	 * 获得 催收提示次数
	 */
	public BigDecimal getWarnCount() {
		return warnCount;
	}

	/**
	 * DECIMAL(22)<br>
	 * 设置 催收提示次数
	 */
	public void setWarnCount(BigDecimal warnCount) {
		this.warnCount = warnCount;
	}

	/**
	 * CHAR(2)<br>
	 * 获得 结算单账期
	 */
	public String getBillsPeriod() {
		return billsPeriod;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 结算单账期
	 */
	public void setBillsPeriod(String billsPeriod) {
		this.billsPeriod = billsPeriod == null ? null : billsPeriod.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 结算单开始日期
	 */
	public String getBeginDate() {
		return beginDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 结算单开始日期
	 */
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate == null ? null : beginDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 结算单结束日期
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 结算单结束日期
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate == null ? null : endDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 支付日期
	 */
	public String getPaydate() {
		return paydate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 支付日期
	 */
	public void setPaydate(String paydate) {
		this.paydate = paydate == null ? null : paydate.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 删除原因
	 */
	public String getDeleteReason() {
		return deleteReason;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 删除原因
	 */
	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason == null ? null : deleteReason.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 其它原因
	 */
	public String getOtherReason() {
		return otherReason;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 其它原因
	 */
	public void setOtherReason(String otherReason) {
		this.otherReason = otherReason == null ? null : otherReason.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 原因
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 原因
	 */
	public void setReason(String reason) {
		this.reason = reason == null ? null : reason.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 融资逾期标记：1-融资逾期、2-正常
	 */
	public String getLoanOverdueFlag() {
		return loanOverdueFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 融资逾期标记：1-融资逾期、2-正常
	 */
	public void setLoanOverdueFlag(String loanOverdueFlag) {
		this.loanOverdueFlag = loanOverdueFlag == null ? null : loanOverdueFlag.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 放款借据号
	 */
	public String getDebetNo() {
		return debetNo;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 放款借据号
	 */
	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo == null ? null : debetNo.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 首次保证金金额
	 */
	public BigDecimal getBailAmount() {
		return bailAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 首次保证金金额
	 */
	public void setBailAmount(BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 追加保证金金额
	 */
	public BigDecimal getAddBailAmount() {
		return addBailAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 追加保证金金额
	 */
	public void setAddBailAmount(BigDecimal addBailAmount) {
		this.addBailAmount = addBailAmount;
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否锁定：0-未锁定、1-锁定
	 */
	public String getIsLocked() {
		return isLocked;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否锁定：0-未锁定、1-锁定
	 */
	public void setIsLocked(String isLocked) {
		this.isLocked = isLocked == null ? null : isLocked.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 加锁业务申请编号
	 */
	public String getLockAppno() {
		return lockAppno;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 加锁业务申请编号
	 */
	public void setLockAppno(String lockAppno) {
		this.lockAppno = lockAppno == null ? null : lockAppno.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 保理业务类别(DATA_DIC.50042)
	 */
	public String getFactType() {
		return factType;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 保理业务类别(DATA_DIC.50042)
	 */
	public void setFactType(String factType) {
		this.factType = factType == null ? null : factType.trim();
	}

	/**
	 * VARCHAR(2)<br>
	 * 获得 出账方式：01-流贷、02-银承
	 */
	public String getLoanWay() {
		return loanWay;
	}

	/**
	 * VARCHAR(2)<br>
	 * 设置 出账方式：01-流贷、02-银承
	 */
	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay == null ? null : loanWay.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 最迟付款日
	 */
	public String getDeadline() {
		return deadline;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 最迟付款日
	 */
	public void setDeadline(String deadline) {
		this.deadline = deadline == null ? null : deadline.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 商务合同号
	 */
	public String getBussContcode() {
		return bussContcode;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 商务合同号
	 */
	public void setBussContcode(String bussContcode) {
		this.bussContcode = bussContcode == null ? null : bussContcode.trim();
	}

	/**
	 * DECIMAL(22)<br>
	 * 获得 宽限期
	 */
	public BigDecimal getGracePeriod() {
		return gracePeriod;
	}

	/**
	 * DECIMAL(22)<br>
	 * 设置 宽限期
	 */
	public void setGracePeriod(BigDecimal gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	/**
	 * CHAR(1)<br>
	 * 获得 理赔状态
	 */
	public String getClaimStatus() {
		return claimStatus;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 理赔状态
	 */
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus == null ? null : claimStatus.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 转让回执确认日期
	 */
	public String getConfirmDate() {
		return confirmDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 转让回执确认日期
	 */
	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate == null ? null : confirmDate.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 网银流水号
	 */
	public String getEbankAppno() {
		return ebankAppno;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 网银流水号
	 */
	public void setEbankAppno(String ebankAppno) {
		this.ebankAppno = ebankAppno == null ? null : ebankAppno.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 渠道标识：1-供应链、2-企业网银
	 */
	public String getChannelFlag() {
		return channelFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 渠道标识：1-供应链、2-企业网银
	 */
	public void setChannelFlag(String channelFlag) {
		this.channelFlag = channelFlag == null ? null : channelFlag.trim();
	}

	/**
	 * DECIMAL(22)<br>
	 * 获得 商纠次数
	 */
	public Integer getIssueTimes() {
		return issueTimes;
	}

	/**
	 * DECIMAL(22)<br>
	 * 设置 商纠次数
	 */
	public void setIssueTimes(Integer issueTimes) {
		this.issueTimes = issueTimes;
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否已付款：0-否、1-是
	 */
	public String getIsPay() {
		return isPay;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否已付款：0-否、1-是
	 */
	public void setIsPay(String isPay) {
		this.isPay = isPay == null ? null : isPay.trim();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", custcdSaller=").append(custcdSaller);
		sb.append(", cnameBuyer=").append(cnameBuyer);
		sb.append(", custcdBuyer=").append(custcdBuyer);
		sb.append(", cnameSeller=").append(cnameSeller);
		sb.append(", mastContno=").append(mastContno);
		sb.append(", insertDate=").append(insertDate);
		sb.append(", aging=").append(aging);
		sb.append(", bussType=").append(bussType);
		sb.append(", billsNo=").append(billsNo);
		sb.append(", billsType=").append(billsType);
		sb.append(", billsDate=").append(billsDate);
		sb.append(", debtEnd=").append(debtEnd);
		sb.append(", billsAmount=").append(billsAmount);
		sb.append(", billsAmountView=").append(billsAmountView);
		sb.append(", remainingAmount=").append(remainingAmount);
		sb.append(", curcd=").append(curcd);
		sb.append(", loanPercent=").append(loanPercent);
		sb.append(", loanAmount=").append(loanAmount);
		sb.append(", purchaseDate=").append(purchaseDate);
		sb.append(", loanRemainingAmount=").append(loanRemainingAmount);
		sb.append(", remainingUseableAmount=").append(remainingUseableAmount);
		sb.append(", rateCollectAmount=").append(rateCollectAmount);
		sb.append(", ownRateCollectAmount=").append(ownRateCollectAmount);
		sb.append(", loanEndDate=").append(loanEndDate);
		sb.append(", assurePercent=").append(assurePercent);
		sb.append(", assurePayDate=").append(assurePayDate);
		sb.append(", rebateAmount=").append(rebateAmount);
		sb.append(", buyBackAmount=").append(buyBackAmount);
		sb.append(", payAmount=").append(payAmount);
		sb.append(", removeAmount=").append(removeAmount);
		sb.append(", cashRemainingAmount=").append(cashRemainingAmount);
		sb.append(", flawFlag=").append(flawFlag);
		sb.append(", flawReason=").append(flawReason);
		sb.append(", issueFlag=").append(issueFlag);
		sb.append(", issueReason=").append(issueReason);
		sb.append(", overdueFlag=").append(overdueFlag);
		sb.append(", overdueReason=").append(overdueReason);
		sb.append(", badFlag=").append(badFlag);
		sb.append(", badReason=").append(badReason);
		sb.append(", poolFlag=").append(poolFlag);
		sb.append(", overdueAmount=").append(overdueAmount);
		sb.append(", pledgeStatus=").append(pledgeStatus);
		sb.append(", overdueStatus=").append(overdueStatus);
		sb.append(", status=").append(status);
		sb.append(", returnStatus=").append(returnStatus);
		sb.append(", pledgeActiveDate=").append(pledgeActiveDate);
		sb.append(", unpledgeActiveDate=").append(unpledgeActiveDate);
		sb.append(", memo=").append(memo);
		sb.append(", pressCount=").append(pressCount);
		sb.append(", warnCount=").append(warnCount);
		sb.append(", billsPeriod=").append(billsPeriod);
		sb.append(", beginDate=").append(beginDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", paydate=").append(paydate);
		sb.append(", deleteReason=").append(deleteReason);
		sb.append(", otherReason=").append(otherReason);
		sb.append(", reason=").append(reason);
		sb.append(", loanOverdueFlag=").append(loanOverdueFlag);
		sb.append(", debetNo=").append(debetNo);
		sb.append(", bailAmount=").append(bailAmount);
		sb.append(", addBailAmount=").append(addBailAmount);
		sb.append(", isLocked=").append(isLocked);
		sb.append(", lockAppno=").append(lockAppno);
		sb.append(", factType=").append(factType);
		sb.append(", loanWay=").append(loanWay);
		sb.append(", deadline=").append(deadline);
		sb.append(", bussContcode=").append(bussContcode);
		sb.append(", gracePeriod=").append(gracePeriod);
		sb.append(", claimStatus=").append(claimStatus);
		sb.append(", confirmDate=").append(confirmDate);
		sb.append(", ebankAppno=").append(ebankAppno);
		sb.append(", channelFlag=").append(channelFlag);
		sb.append(", issueTimes=").append(issueTimes);
		sb.append(", isPay=").append(isPay);
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
		RBcpDebtBaseInfo other = (RBcpDebtBaseInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getCustcdSaller() == null ? other.getCustcdSaller() == null : this.getCustcdSaller().equals(other.getCustcdSaller()))
				&& (this.getCnameBuyer() == null ? other.getCnameBuyer() == null : this.getCnameBuyer().equals(other.getCnameBuyer()))
				&& (this.getCustcdBuyer() == null ? other.getCustcdBuyer() == null : this.getCustcdBuyer().equals(other.getCustcdBuyer()))
				&& (this.getCnameSeller() == null ? other.getCnameSeller() == null : this.getCnameSeller().equals(other.getCnameSeller()))
				&& (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
				&& (this.getInsertDate() == null ? other.getInsertDate() == null : this.getInsertDate().equals(other.getInsertDate()))
				&& (this.getAging() == null ? other.getAging() == null : this.getAging().equals(other.getAging()))
				&& (this.getBussType() == null ? other.getBussType() == null : this.getBussType().equals(other.getBussType()))
				&& (this.getBillsNo() == null ? other.getBillsNo() == null : this.getBillsNo().equals(other.getBillsNo()))
				&& (this.getBillsType() == null ? other.getBillsType() == null : this.getBillsType().equals(other.getBillsType()))
				&& (this.getBillsDate() == null ? other.getBillsDate() == null : this.getBillsDate().equals(other.getBillsDate()))
				&& (this.getDebtEnd() == null ? other.getDebtEnd() == null : this.getDebtEnd().equals(other.getDebtEnd()))
				&& (this.getBillsAmount() == null ? other.getBillsAmount() == null : this.getBillsAmount().equals(other.getBillsAmount()))
				&& (this.getBillsAmountView() == null ? other.getBillsAmountView() == null
						: this.getBillsAmountView().equals(other.getBillsAmountView()))
				&& (this.getRemainingAmount() == null ? other.getRemainingAmount() == null
						: this.getRemainingAmount().equals(other.getRemainingAmount()))
				&& (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
				&& (this.getLoanPercent() == null ? other.getLoanPercent() == null : this.getLoanPercent().equals(other.getLoanPercent()))
				&& (this.getLoanAmount() == null ? other.getLoanAmount() == null : this.getLoanAmount().equals(other.getLoanAmount()))
				&& (this.getPurchaseDate() == null ? other.getPurchaseDate() == null : this.getPurchaseDate().equals(other.getPurchaseDate()))
				&& (this.getLoanRemainingAmount() == null ? other.getLoanRemainingAmount() == null
						: this.getLoanRemainingAmount().equals(other.getLoanRemainingAmount()))
				&& (this.getRemainingUseableAmount() == null ? other.getRemainingUseableAmount() == null
						: this.getRemainingUseableAmount().equals(other.getRemainingUseableAmount()))
				&& (this.getRateCollectAmount() == null ? other.getRateCollectAmount() == null
						: this.getRateCollectAmount().equals(other.getRateCollectAmount()))
				&& (this.getOwnRateCollectAmount() == null ? other.getOwnRateCollectAmount() == null
						: this.getOwnRateCollectAmount().equals(other.getOwnRateCollectAmount()))
				&& (this.getLoanEndDate() == null ? other.getLoanEndDate() == null : this.getLoanEndDate().equals(other.getLoanEndDate()))
				&& (this.getAssurePercent() == null ? other.getAssurePercent() == null : this.getAssurePercent().equals(other.getAssurePercent()))
				&& (this.getAssurePayDate() == null ? other.getAssurePayDate() == null : this.getAssurePayDate().equals(other.getAssurePayDate()))
				&& (this.getRebateAmount() == null ? other.getRebateAmount() == null : this.getRebateAmount().equals(other.getRebateAmount()))
				&& (this.getBuyBackAmount() == null ? other.getBuyBackAmount() == null : this.getBuyBackAmount().equals(other.getBuyBackAmount()))
				&& (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
				&& (this.getRemoveAmount() == null ? other.getRemoveAmount() == null : this.getRemoveAmount().equals(other.getRemoveAmount()))
				&& (this.getCashRemainingAmount() == null ? other.getCashRemainingAmount() == null
						: this.getCashRemainingAmount().equals(other.getCashRemainingAmount()))
				&& (this.getFlawFlag() == null ? other.getFlawFlag() == null : this.getFlawFlag().equals(other.getFlawFlag()))
				&& (this.getFlawReason() == null ? other.getFlawReason() == null : this.getFlawReason().equals(other.getFlawReason()))
				&& (this.getIssueFlag() == null ? other.getIssueFlag() == null : this.getIssueFlag().equals(other.getIssueFlag()))
				&& (this.getIssueReason() == null ? other.getIssueReason() == null : this.getIssueReason().equals(other.getIssueReason()))
				&& (this.getOverdueFlag() == null ? other.getOverdueFlag() == null : this.getOverdueFlag().equals(other.getOverdueFlag()))
				&& (this.getOverdueReason() == null ? other.getOverdueReason() == null : this.getOverdueReason().equals(other.getOverdueReason()))
				&& (this.getBadFlag() == null ? other.getBadFlag() == null : this.getBadFlag().equals(other.getBadFlag()))
				&& (this.getBadReason() == null ? other.getBadReason() == null : this.getBadReason().equals(other.getBadReason()))
				&& (this.getPoolFlag() == null ? other.getPoolFlag() == null : this.getPoolFlag().equals(other.getPoolFlag()))
				&& (this.getOverdueAmount() == null ? other.getOverdueAmount() == null : this.getOverdueAmount().equals(other.getOverdueAmount()))
				&& (this.getPledgeStatus() == null ? other.getPledgeStatus() == null : this.getPledgeStatus().equals(other.getPledgeStatus()))
				&& (this.getOverdueStatus() == null ? other.getOverdueStatus() == null : this.getOverdueStatus().equals(other.getOverdueStatus()))
				&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
				&& (this.getReturnStatus() == null ? other.getReturnStatus() == null : this.getReturnStatus().equals(other.getReturnStatus()))
				&& (this.getPledgeActiveDate() == null ? other.getPledgeActiveDate() == null
						: this.getPledgeActiveDate().equals(other.getPledgeActiveDate()))
				&& (this.getUnpledgeActiveDate() == null ? other.getUnpledgeActiveDate() == null
						: this.getUnpledgeActiveDate().equals(other.getUnpledgeActiveDate()))
				&& (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
				&& (this.getPressCount() == null ? other.getPressCount() == null : this.getPressCount().equals(other.getPressCount()))
				&& (this.getWarnCount() == null ? other.getWarnCount() == null : this.getWarnCount().equals(other.getWarnCount()))
				&& (this.getBillsPeriod() == null ? other.getBillsPeriod() == null : this.getBillsPeriod().equals(other.getBillsPeriod()))
				&& (this.getBeginDate() == null ? other.getBeginDate() == null : this.getBeginDate().equals(other.getBeginDate()))
				&& (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
				&& (this.getPaydate() == null ? other.getPaydate() == null : this.getPaydate().equals(other.getPaydate()))
				&& (this.getDeleteReason() == null ? other.getDeleteReason() == null : this.getDeleteReason().equals(other.getDeleteReason()))
				&& (this.getOtherReason() == null ? other.getOtherReason() == null : this.getOtherReason().equals(other.getOtherReason()))
				&& (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
				&& (this.getLoanOverdueFlag() == null ? other.getLoanOverdueFlag() == null
						: this.getLoanOverdueFlag().equals(other.getLoanOverdueFlag()))
				&& (this.getDebetNo() == null ? other.getDebetNo() == null : this.getDebetNo().equals(other.getDebetNo()))
				&& (this.getBailAmount() == null ? other.getBailAmount() == null : this.getBailAmount().equals(other.getBailAmount()))
				&& (this.getAddBailAmount() == null ? other.getAddBailAmount() == null : this.getAddBailAmount().equals(other.getAddBailAmount()))
				&& (this.getIsLocked() == null ? other.getIsLocked() == null : this.getIsLocked().equals(other.getIsLocked()))
				&& (this.getLockAppno() == null ? other.getLockAppno() == null : this.getLockAppno().equals(other.getLockAppno()))
				&& (this.getFactType() == null ? other.getFactType() == null : this.getFactType().equals(other.getFactType()))
				&& (this.getLoanWay() == null ? other.getLoanWay() == null : this.getLoanWay().equals(other.getLoanWay()))
				&& (this.getDeadline() == null ? other.getDeadline() == null : this.getDeadline().equals(other.getDeadline()))
				&& (this.getBussContcode() == null ? other.getBussContcode() == null : this.getBussContcode().equals(other.getBussContcode()))
				&& (this.getGracePeriod() == null ? other.getGracePeriod() == null : this.getGracePeriod().equals(other.getGracePeriod()))
				&& (this.getClaimStatus() == null ? other.getClaimStatus() == null : this.getClaimStatus().equals(other.getClaimStatus()))
				&& (this.getConfirmDate() == null ? other.getConfirmDate() == null : this.getConfirmDate().equals(other.getConfirmDate()))
				&& (this.getEbankAppno() == null ? other.getEbankAppno() == null : this.getEbankAppno().equals(other.getEbankAppno()))
				&& (this.getChannelFlag() == null ? other.getChannelFlag() == null : this.getChannelFlag().equals(other.getChannelFlag()))
				&& (this.getIssueTimes() == null ? other.getIssueTimes() == null : this.getIssueTimes().equals(other.getIssueTimes()))
				&& (this.getIsPay() == null ? other.getIsPay() == null : this.getIsPay().equals(other.getIsPay()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getCustcdSaller() == null) ? 0 : getCustcdSaller().hashCode());
		result = prime * result + ((getCnameBuyer() == null) ? 0 : getCnameBuyer().hashCode());
		result = prime * result + ((getCustcdBuyer() == null) ? 0 : getCustcdBuyer().hashCode());
		result = prime * result + ((getCnameSeller() == null) ? 0 : getCnameSeller().hashCode());
		result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
		result = prime * result + ((getInsertDate() == null) ? 0 : getInsertDate().hashCode());
		result = prime * result + ((getAging() == null) ? 0 : getAging().hashCode());
		result = prime * result + ((getBussType() == null) ? 0 : getBussType().hashCode());
		result = prime * result + ((getBillsNo() == null) ? 0 : getBillsNo().hashCode());
		result = prime * result + ((getBillsType() == null) ? 0 : getBillsType().hashCode());
		result = prime * result + ((getBillsDate() == null) ? 0 : getBillsDate().hashCode());
		result = prime * result + ((getDebtEnd() == null) ? 0 : getDebtEnd().hashCode());
		result = prime * result + ((getBillsAmount() == null) ? 0 : getBillsAmount().hashCode());
		result = prime * result + ((getBillsAmountView() == null) ? 0 : getBillsAmountView().hashCode());
		result = prime * result + ((getRemainingAmount() == null) ? 0 : getRemainingAmount().hashCode());
		result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
		result = prime * result + ((getLoanPercent() == null) ? 0 : getLoanPercent().hashCode());
		result = prime * result + ((getLoanAmount() == null) ? 0 : getLoanAmount().hashCode());
		result = prime * result + ((getPurchaseDate() == null) ? 0 : getPurchaseDate().hashCode());
		result = prime * result + ((getLoanRemainingAmount() == null) ? 0 : getLoanRemainingAmount().hashCode());
		result = prime * result + ((getRemainingUseableAmount() == null) ? 0 : getRemainingUseableAmount().hashCode());
		result = prime * result + ((getRateCollectAmount() == null) ? 0 : getRateCollectAmount().hashCode());
		result = prime * result + ((getOwnRateCollectAmount() == null) ? 0 : getOwnRateCollectAmount().hashCode());
		result = prime * result + ((getLoanEndDate() == null) ? 0 : getLoanEndDate().hashCode());
		result = prime * result + ((getAssurePercent() == null) ? 0 : getAssurePercent().hashCode());
		result = prime * result + ((getAssurePayDate() == null) ? 0 : getAssurePayDate().hashCode());
		result = prime * result + ((getRebateAmount() == null) ? 0 : getRebateAmount().hashCode());
		result = prime * result + ((getBuyBackAmount() == null) ? 0 : getBuyBackAmount().hashCode());
		result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
		result = prime * result + ((getRemoveAmount() == null) ? 0 : getRemoveAmount().hashCode());
		result = prime * result + ((getCashRemainingAmount() == null) ? 0 : getCashRemainingAmount().hashCode());
		result = prime * result + ((getFlawFlag() == null) ? 0 : getFlawFlag().hashCode());
		result = prime * result + ((getFlawReason() == null) ? 0 : getFlawReason().hashCode());
		result = prime * result + ((getIssueFlag() == null) ? 0 : getIssueFlag().hashCode());
		result = prime * result + ((getIssueReason() == null) ? 0 : getIssueReason().hashCode());
		result = prime * result + ((getOverdueFlag() == null) ? 0 : getOverdueFlag().hashCode());
		result = prime * result + ((getOverdueReason() == null) ? 0 : getOverdueReason().hashCode());
		result = prime * result + ((getBadFlag() == null) ? 0 : getBadFlag().hashCode());
		result = prime * result + ((getBadReason() == null) ? 0 : getBadReason().hashCode());
		result = prime * result + ((getPoolFlag() == null) ? 0 : getPoolFlag().hashCode());
		result = prime * result + ((getOverdueAmount() == null) ? 0 : getOverdueAmount().hashCode());
		result = prime * result + ((getPledgeStatus() == null) ? 0 : getPledgeStatus().hashCode());
		result = prime * result + ((getOverdueStatus() == null) ? 0 : getOverdueStatus().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getReturnStatus() == null) ? 0 : getReturnStatus().hashCode());
		result = prime * result + ((getPledgeActiveDate() == null) ? 0 : getPledgeActiveDate().hashCode());
		result = prime * result + ((getUnpledgeActiveDate() == null) ? 0 : getUnpledgeActiveDate().hashCode());
		result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
		result = prime * result + ((getPressCount() == null) ? 0 : getPressCount().hashCode());
		result = prime * result + ((getWarnCount() == null) ? 0 : getWarnCount().hashCode());
		result = prime * result + ((getBillsPeriod() == null) ? 0 : getBillsPeriod().hashCode());
		result = prime * result + ((getBeginDate() == null) ? 0 : getBeginDate().hashCode());
		result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
		result = prime * result + ((getPaydate() == null) ? 0 : getPaydate().hashCode());
		result = prime * result + ((getDeleteReason() == null) ? 0 : getDeleteReason().hashCode());
		result = prime * result + ((getOtherReason() == null) ? 0 : getOtherReason().hashCode());
		result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
		result = prime * result + ((getLoanOverdueFlag() == null) ? 0 : getLoanOverdueFlag().hashCode());
		result = prime * result + ((getDebetNo() == null) ? 0 : getDebetNo().hashCode());
		result = prime * result + ((getBailAmount() == null) ? 0 : getBailAmount().hashCode());
		result = prime * result + ((getAddBailAmount() == null) ? 0 : getAddBailAmount().hashCode());
		result = prime * result + ((getIsLocked() == null) ? 0 : getIsLocked().hashCode());
		result = prime * result + ((getLockAppno() == null) ? 0 : getLockAppno().hashCode());
		result = prime * result + ((getFactType() == null) ? 0 : getFactType().hashCode());
		result = prime * result + ((getLoanWay() == null) ? 0 : getLoanWay().hashCode());
		result = prime * result + ((getDeadline() == null) ? 0 : getDeadline().hashCode());
		result = prime * result + ((getBussContcode() == null) ? 0 : getBussContcode().hashCode());
		result = prime * result + ((getGracePeriod() == null) ? 0 : getGracePeriod().hashCode());
		result = prime * result + ((getClaimStatus() == null) ? 0 : getClaimStatus().hashCode());
		result = prime * result + ((getConfirmDate() == null) ? 0 : getConfirmDate().hashCode());
		result = prime * result + ((getEbankAppno() == null) ? 0 : getEbankAppno().hashCode());
		result = prime * result + ((getChannelFlag() == null) ? 0 : getChannelFlag().hashCode());
		result = prime * result + ((getIssueTimes() == null) ? 0 : getIssueTimes().hashCode());
		result = prime * result + ((getIsPay() == null) ? 0 : getIsPay().hashCode());
		return result;
	}
}
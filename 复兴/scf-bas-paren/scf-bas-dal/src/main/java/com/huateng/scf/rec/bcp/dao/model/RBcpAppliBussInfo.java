package com.huateng.scf.rec.bcp.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RBcpAppliBussInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(32) 必填<br>
	 * 主键
	 */
	private String id;

	/**
	 * VARCHAR(20)<br>
	 * 申请号
	 */
	private String appno;

	/**
	 * VARCHAR(15)<br>
	 * 买方客户号
	 */
	private String custcdBuyer;

	/**
	 * VARCHAR(15)<br>
	 * 卖方客户号
	 */
	private String custcdSaller;

	/**
	 * CHAR(4)<br>
	 * 业务申请类型：00：录入；01：承购；02：入池；03：出池；04:折让；05：回购；06：核销；07：发票账龄变更；08：还款;
	 * 09：瑕疵；10:商纠；11：逾期；12：呆账；
	 */
	private String applyType;

	/**
	 * VARCHAR(20)<br>
	 * 主合同号
	 */
	private String mastContno;

	/**
	 * CHAR(8)<br>
	 * 登记日期
	 */
	private String insertDate;

	/**
	 * CHAR(8)<br>
	 * 转让日期
	 */
	private String purchaseDate;

	/**
	 * DECIMAL(22)<br>
	 * 应收账款单据总数
	 */
	private Integer debtNum;

	/**
	 * DECIMAL(16,2)<br>
	 * 应收账款单据总金额
	 */
	private BigDecimal totalDebtAmount;

	/**
	 * CHAR(2)<br>
	 * 费用收取方式：1-先收、2-后收、3-免收
	 */
	private String chargeType;

	/**
	 * CHAR(1)<br>
	 * 费用扣取方式：1-外扣、2-内收
	 */
	private String finacingDiscountType;

	/**
	 * DECIMAL(16,2)<br>
	 * 
	 */
	private BigDecimal finacingCost;

	/**
	 * DECIMAL(16,2)<br>
	 * 
	 */
	private BigDecimal cost;

	/**
	 * DECIMAL(16,2)<br>
	 * 
	 */
	private BigDecimal handlingFee;

	/**
	 * DECIMAL(16,2)<br>
	 * 减免金额
	 */
	private BigDecimal reduceAmount;

	/**
	 * DECIMAL(16,2)<br>
	 * 费用总额
	 */
	private BigDecimal totalFee;

	/**
	 * DECIMAL(16,2)<br>
	 * 减免总额
	 */
	private BigDecimal totalReduce;

	/**
	 * DECIMAL(16,2)<br>
	 * 
	 */
	private BigDecimal receiveAmount;

	/**
	 * VARCHAR(50)<br>
	 * 扣费账号
	 */
	private String costAccount;

	/**
	 * VARCHAR(50)<br>
	 * 
	 */
	private String accountNo;

	/**
	 * VARCHAR(50)<br>
	 * 
	 */
	private String payDayMonth;

	/**
	 * CHAR(1)<br>
	 * 1-到期收息；2-按月收息；3-预收利息
	 */
	private String rateCollectType;

	/**
	 * VARCHAR(50)<br>
	 * 逾期利率
	 */
	private String overDueRate;

	/**
	 * VARCHAR(50)<br>
	 * 执行利率
	 */
	private String executeRate;

	/**
	 * VARCHAR(50)<br>
	 * 浮动比例
	 */
	private String upDownPercent;

	/**
	 * CHAR(1)<br>
	 * 1:上浮；2：下浮
	 */
	private String upDown;

	/**
	 * VARCHAR(50)<br>
	 * 
	 */
	private String baseRate;

	/**
	 * VARCHAR(50)<br>
	 * 利率编号
	 */
	private String rateId;

	/**
	 * CHAR(1)<br>
	 * 利率类型：1-浮动;、2-固定
	 */
	private String rateType;

	/**
	 * VARCHAR(10)<br>
	 * 业务种类
	 */
	private String bussType;

	/**
	 * VARCHAR(50)<br>
	 * 融资类型
	 */
	private String loanType;

	/**
	 * VARCHAR(2)<br>
	 * 出账方式：01-贷款、02-银承
	 */
	private String loanWay;

	/**
	 * VARCHAR(50)<br>
	 * 
	 */
	private String bankno;

	/**
	 * VARCHAR(20)<br>
	 * 
	 */
	private String brcode2;

	/**
	 * DECIMAL(16,2)<br>
	 * 通用金额，可以放折让总金额、 承购总金额、核销总金额、回购总金额、 出池总金融、入池总金额、还款金额
	 */
	private BigDecimal amount;

	/**
	 * VARCHAR(10)<br>
	 * 融资期限
	 */
	private String loanDays;

	/**
	 * CHAR(8)<br>
	 * 单据日期
	 */
	private String billDate;

	/**
	 * CHAR(8)<br>
	 * 单据到期日
	 */
	private String billEndDate;

	/**
	 * VARCHAR(100)<br>
	 * 订单编号
	 */
	private String orderNo;

	/**
	 * DECIMAL(16,2)<br>
	 * 订单金额
	 */
	private BigDecimal orderAmt;

	/**
	 * VARCHAR(50)<br>
	 * 结算账号
	 */
	private String balanceAccount;

	/**
	 * DECIMAL(16,2)<br>
	 * 保证金金额
	 */
	private BigDecimal bailAmt;

	/**
	 * VARCHAR(50)<br>
	 * 保证金账号
	 */
	private String bailAccount;

	/**
	 * VARCHAR(100)<br>
	 * 
	 */
	private String billAccount;

	/**
	 * VARCHAR(100)<br>
	 * 
	 */
	private String coreAccount;

	/**
	 * CHAR(8)<br>
	 * 申请日期
	 */
	private String appDate;

	/**
	 * CHAR(8)<br>
	 * 申请放款日期
	 */
	private String appLoanDate;

	/**
	 * CHAR(8)<br>
	 * 融资到期日
	 */
	private String loanDueDate;

	/**
	 * CHAR(8)<br>
	 * 
	 */
	private String returnDate;

	/**
	 * CHAR(1)<br>
	 * 利息类型：1-利息，2-融资，3-融资本息，4-无
	 */
	private String returnType;

	/**
	 * CHAR(1)<br>
	 * 1-买方付款，2-间接还款，3-卖方还款，4-担保付款，5-担保公司赔款
	 */
	private String returnMethod;

	/**
	 * DECIMAL(16,2)<br>
	 * 回款金额
	 */
	private BigDecimal returnAmount;

	/**
	 * DECIMAL(16,2)<br>
	 * 
	 */
	private BigDecimal returnInterestAmount;

	/**
	 * DECIMAL(16,2)<br>
	 * 
	 */
	private BigDecimal returnCapitalAmount;

	/**
	 * DECIMAL(16,2)<br>
	 * 
	 */
	private BigDecimal toSallerAmount;

	/**
	 * DECIMAL(16,2)<br>
	 * 入池金额
	 */
	private BigDecimal toPoolAmount;

	/**
	 * CHAR(1)<br>
	 * 尾款是否解付：1-是、2-否
	 */
	private String toSallerFlag;

	/**
	 * VARCHAR(100)<br>
	 * 通用原因
	 */
	private String reason;

	/**
	 * VARCHAR(100)<br>
	 * 其他原因
	 */
	private String otherReason;

	/**
	 * CHAR(3)<br>
	 * 币种
	 */
	private String curcd;

	/**
	 * VARCHAR(500)<br>
	 * 备注
	 */
	private String memo;

	/**
	 * CHAR(8)<br>
	 * 为通用日期时间，包含 出池日期、 入池日期、 承购日期、 核销日期 根据业务操作类型来确定。等等
	 */
	private String commonDate;

	/**
	 * VARCHAR(32)<br>
	 * 登记人
	 */
	private String tlrcd;

	/**
	 * VARCHAR(20)<br>
	 * 登记机构
	 */
	private String brcode;

	/**
	 * VARCHAR(2)<br>
	 * 
	 */
	private String bailType;

	/**
	 * VARCHAR(20)<br>
	 * 借据编号
	 */
	private String debetNo;

	/**
	 * VARCHAR(2)<br>
	 * 
	 */
	private String initType;

	/**
	 * VARCHAR(2)<br>
	 * 确认状态
	 */
	private String confirmStatus;

	/**
	 * TIMESTAMP(11,6)<br>
	 * 创建时间
	 */
	private Date crtTime;

	/**
	 * TIMESTAMP(11,6)<br>
	 * 最后更新时间
	 */
	private Date lastUptTime;

	/**
	 * VARCHAR(50)<br>
	 * 入账账号(回款帐户)
	 */
	private String returnAccount;

	/**
	 * DECIMAL(16,2)<br>
	 * 本次入保证金金额
	 */
	private BigDecimal tobailAmount;

	/**
	 * DECIMAL(16,2)<br>
	 * 本次核销金额
	 */
	private BigDecimal rebateAmount;

	/**
	 * DECIMAL(16,2)<br>
	 * 入账账户(回款账户)余额
	 */
	private BigDecimal returnAccountBalance;

	/**
	 * DECIMAL(16,2)<br>
	 * 本次总计尾款金额
	 */
	private BigDecimal totalOverAmount;

	/**
	 * CHAR(2)<br>
	 * 自动分配规则
	 */
	private String assignRule;

	/**
	 * VARCHAR(40)<br>
	 * 入账交易编号
	 */
	private String transactionNo;

	/**
	 * DECIMAL(22)<br>
	 * 退款期限
	 */
	private BigDecimal refundTerm;

	/**
	 * VARCHAR(100)<br>
	 * 收款人名称
	 */
	private String payee;

	/**
	 * VARCHAR(50)<br>
	 * 退款账号
	 */
	private String refundAcctNo;

	/**
	 * VARCHAR(100)<br>
	 * 开户行
	 */
	private String depositBank;

	/**
	 * VARCHAR(10)<br>
	 * 回款结算方式：1-票据、2-汇款
	 */
	private String settleMethod;

	/**
	 * VARCHAR(120)<br>
	 * 付款单位
	 */
	private String payer;

	/**
	 * VARCHAR(50)<br>
	 * 付款人账号
	 */
	private String payerAcctNo;

	/**
	 * VARCHAR(120)<br>
	 * 付款银行
	 */
	private String payerBank;

	/**
	 * DECIMAL(16,2)<br>
	 * 转账金额
	 */
	private BigDecimal transferAmt;

	/**
	 * CHAR(8)<br>
	 * 交易日期
	 */
	private String transactionDate;

	/**
	 * VARCHAR(50)<br>
	 * 借据号/承兑协议号
	 */
	private String debetId;

	/**
	 * CHAR(8)<br>
	 * 到期日（借据）
	 */
	private String finacingEndDate;

	/**
	 * CHAR(8)<br>
	 * 发放日（借据）
	 */
	private String finacingStartDate;

	/**
	 * DECIMAL(16,2)<br>
	 * 借据金额
	 */
	private BigDecimal lnciAmt;

	/**
	 * VARCHAR(20)<br>
	 * 信贷合同
	 */
	private String mastContcode;

	/**
	 * VARCHAR(32) 必填<br>
	 * 获得 主键
	 */
	public String getId() {
		return id;
	}

	/**
	 * VARCHAR(32) 必填<br>
	 * 设置 主键
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 申请号
	 */
	public String getAppno() {
		return appno;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 申请号
	 */
	public void setAppno(String appno) {
		this.appno = appno == null ? null : appno.trim();
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
	 * CHAR(4)<br>
	 * 获得 业务申请类型：00：录入；01：承购；02：入池；03：出池；04:折让；05：回购；06：核销；07：发票账龄变更；08：还款;
	 * 09：瑕疵；10:商纠；11：逾期；12：呆账；
	 */
	public String getApplyType() {
		return applyType;
	}

	/**
	 * CHAR(4)<br>
	 * 设置 业务申请类型：00：录入；01：承购；02：入池；03：出池；04:折让；05：回购；06：核销；07：发票账龄变更；08：还款;
	 * 09：瑕疵；10:商纠；11：逾期；12：呆账；
	 */
	public void setApplyType(String applyType) {
		this.applyType = applyType == null ? null : applyType.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 主合同号
	 */
	public String getMastContno() {
		return mastContno;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 主合同号
	 */
	public void setMastContno(String mastContno) {
		this.mastContno = mastContno == null ? null : mastContno.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 登记日期
	 */
	public String getInsertDate() {
		return insertDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 登记日期
	 */
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate == null ? null : insertDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 转让日期
	 */
	public String getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 转让日期
	 */
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate == null ? null : purchaseDate.trim();
	}

	/**
	 * DECIMAL(22)<br>
	 * 获得 应收账款单据总数
	 */
	public Integer getDebtNum() {
		return debtNum;
	}

	/**
	 * DECIMAL(22)<br>
	 * 设置 应收账款单据总数
	 */
	public void setDebtNum(Integer debtNum) {
		this.debtNum = debtNum;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 应收账款单据总金额
	 */
	public BigDecimal getTotalDebtAmount() {
		return totalDebtAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 应收账款单据总金额
	 */
	public void setTotalDebtAmount(BigDecimal totalDebtAmount) {
		this.totalDebtAmount = totalDebtAmount;
	}

	/**
	 * CHAR(2)<br>
	 * 获得 费用收取方式：1-先收、2-后收、3-免收
	 */
	public String getChargeType() {
		return chargeType;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 费用收取方式：1-先收、2-后收、3-免收
	 */
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType == null ? null : chargeType.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 费用扣取方式：1-外扣、2-内收
	 */
	public String getFinacingDiscountType() {
		return finacingDiscountType;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 费用扣取方式：1-外扣、2-内收
	 */
	public void setFinacingDiscountType(String finacingDiscountType) {
		this.finacingDiscountType = finacingDiscountType == null ? null : finacingDiscountType.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 */
	public BigDecimal getFinacingCost() {
		return finacingCost;
	}

	/**
	 * DECIMAL(16,2)<br>
	 */
	public void setFinacingCost(BigDecimal finacingCost) {
		this.finacingCost = finacingCost;
	}

	/**
	 * DECIMAL(16,2)<br>
	 */
	public BigDecimal getCost() {
		return cost;
	}

	/**
	 * DECIMAL(16,2)<br>
	 */
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	/**
	 * DECIMAL(16,2)<br>
	 */
	public BigDecimal getHandlingFee() {
		return handlingFee;
	}

	/**
	 * DECIMAL(16,2)<br>
	 */
	public void setHandlingFee(BigDecimal handlingFee) {
		this.handlingFee = handlingFee;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 减免金额
	 */
	public BigDecimal getReduceAmount() {
		return reduceAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 减免金额
	 */
	public void setReduceAmount(BigDecimal reduceAmount) {
		this.reduceAmount = reduceAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 费用总额
	 */
	public BigDecimal getTotalFee() {
		return totalFee;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 费用总额
	 */
	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 减免总额
	 */
	public BigDecimal getTotalReduce() {
		return totalReduce;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 减免总额
	 */
	public void setTotalReduce(BigDecimal totalReduce) {
		this.totalReduce = totalReduce;
	}

	/**
	 * DECIMAL(16,2)<br>
	 */
	public BigDecimal getReceiveAmount() {
		return receiveAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 */
	public void setReceiveAmount(BigDecimal receiveAmount) {
		this.receiveAmount = receiveAmount;
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 扣费账号
	 */
	public String getCostAccount() {
		return costAccount;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 扣费账号
	 */
	public void setCostAccount(String costAccount) {
		this.costAccount = costAccount == null ? null : costAccount.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * VARCHAR(50)<br>
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo == null ? null : accountNo.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 */
	public String getPayDayMonth() {
		return payDayMonth;
	}

	/**
	 * VARCHAR(50)<br>
	 */
	public void setPayDayMonth(String payDayMonth) {
		this.payDayMonth = payDayMonth == null ? null : payDayMonth.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 1-到期收息；2-按月收息；3-预收利息
	 */
	public String getRateCollectType() {
		return rateCollectType;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 1-到期收息；2-按月收息；3-预收利息
	 */
	public void setRateCollectType(String rateCollectType) {
		this.rateCollectType = rateCollectType == null ? null : rateCollectType.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 逾期利率
	 */
	public String getOverDueRate() {
		return overDueRate;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 逾期利率
	 */
	public void setOverDueRate(String overDueRate) {
		this.overDueRate = overDueRate == null ? null : overDueRate.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 执行利率
	 */
	public String getExecuteRate() {
		return executeRate;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 执行利率
	 */
	public void setExecuteRate(String executeRate) {
		this.executeRate = executeRate == null ? null : executeRate.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 浮动比例
	 */
	public String getUpDownPercent() {
		return upDownPercent;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 浮动比例
	 */
	public void setUpDownPercent(String upDownPercent) {
		this.upDownPercent = upDownPercent == null ? null : upDownPercent.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 1:上浮；2：下浮
	 */
	public String getUpDown() {
		return upDown;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 1:上浮；2：下浮
	 */
	public void setUpDown(String upDown) {
		this.upDown = upDown == null ? null : upDown.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 */
	public String getBaseRate() {
		return baseRate;
	}

	/**
	 * VARCHAR(50)<br>
	 */
	public void setBaseRate(String baseRate) {
		this.baseRate = baseRate == null ? null : baseRate.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 利率编号
	 */
	public String getRateId() {
		return rateId;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 利率编号
	 */
	public void setRateId(String rateId) {
		this.rateId = rateId == null ? null : rateId.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 利率类型：1-浮动;、2-固定
	 */
	public String getRateType() {
		return rateType;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 利率类型：1-浮动;、2-固定
	 */
	public void setRateType(String rateType) {
		this.rateType = rateType == null ? null : rateType.trim();
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 业务种类
	 */
	public String getBussType() {
		return bussType;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 业务种类
	 */
	public void setBussType(String bussType) {
		this.bussType = bussType == null ? null : bussType.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 融资类型
	 */
	public String getLoanType() {
		return loanType;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 融资类型
	 */
	public void setLoanType(String loanType) {
		this.loanType = loanType == null ? null : loanType.trim();
	}

	/**
	 * VARCHAR(2)<br>
	 * 获得 出账方式：01-贷款、02-银承
	 */
	public String getLoanWay() {
		return loanWay;
	}

	/**
	 * VARCHAR(2)<br>
	 * 设置 出账方式：01-贷款、02-银承
	 */
	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay == null ? null : loanWay.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 */
	public String getBankno() {
		return bankno;
	}

	/**
	 * VARCHAR(50)<br>
	 */
	public void setBankno(String bankno) {
		this.bankno = bankno == null ? null : bankno.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 */
	public String getBrcode2() {
		return brcode2;
	}

	/**
	 * VARCHAR(20)<br>
	 */
	public void setBrcode2(String brcode2) {
		this.brcode2 = brcode2 == null ? null : brcode2.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 通用金额，可以放折让总金额、 承购总金额、核销总金额、回购总金额、 出池总金融、入池总金额、还款金额
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 通用金额，可以放折让总金额、 承购总金额、核销总金额、回购总金额、 出池总金融、入池总金额、还款金额
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 融资期限
	 */
	public String getLoanDays() {
		return loanDays;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 融资期限
	 */
	public void setLoanDays(String loanDays) {
		this.loanDays = loanDays == null ? null : loanDays.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 单据日期
	 */
	public String getBillDate() {
		return billDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 单据日期
	 */
	public void setBillDate(String billDate) {
		this.billDate = billDate == null ? null : billDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 单据到期日
	 */
	public String getBillEndDate() {
		return billEndDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 单据到期日
	 */
	public void setBillEndDate(String billEndDate) {
		this.billEndDate = billEndDate == null ? null : billEndDate.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 订单编号
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 订单编号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo == null ? null : orderNo.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 订单金额
	 */
	public BigDecimal getOrderAmt() {
		return orderAmt;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 订单金额
	 */
	public void setOrderAmt(BigDecimal orderAmt) {
		this.orderAmt = orderAmt;
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 结算账号
	 */
	public String getBalanceAccount() {
		return balanceAccount;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 结算账号
	 */
	public void setBalanceAccount(String balanceAccount) {
		this.balanceAccount = balanceAccount == null ? null : balanceAccount.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 保证金金额
	 */
	public BigDecimal getBailAmt() {
		return bailAmt;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 保证金金额
	 */
	public void setBailAmt(BigDecimal bailAmt) {
		this.bailAmt = bailAmt;
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 保证金账号
	 */
	public String getBailAccount() {
		return bailAccount;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 保证金账号
	 */
	public void setBailAccount(String bailAccount) {
		this.bailAccount = bailAccount == null ? null : bailAccount.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 */
	public String getBillAccount() {
		return billAccount;
	}

	/**
	 * VARCHAR(100)<br>
	 */
	public void setBillAccount(String billAccount) {
		this.billAccount = billAccount == null ? null : billAccount.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 */
	public String getCoreAccount() {
		return coreAccount;
	}

	/**
	 * VARCHAR(100)<br>
	 */
	public void setCoreAccount(String coreAccount) {
		this.coreAccount = coreAccount == null ? null : coreAccount.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 申请日期
	 */
	public String getAppDate() {
		return appDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 申请日期
	 */
	public void setAppDate(String appDate) {
		this.appDate = appDate == null ? null : appDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 申请放款日期
	 */
	public String getAppLoanDate() {
		return appLoanDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 申请放款日期
	 */
	public void setAppLoanDate(String appLoanDate) {
		this.appLoanDate = appLoanDate == null ? null : appLoanDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 融资到期日
	 */
	public String getLoanDueDate() {
		return loanDueDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 融资到期日
	 */
	public void setLoanDueDate(String loanDueDate) {
		this.loanDueDate = loanDueDate == null ? null : loanDueDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 */
	public String getReturnDate() {
		return returnDate;
	}

	/**
	 * CHAR(8)<br>
	 */
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate == null ? null : returnDate.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 利息类型：1-利息，2-融资，3-融资本息，4-无
	 */
	public String getReturnType() {
		return returnType;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 利息类型：1-利息，2-融资，3-融资本息，4-无
	 */
	public void setReturnType(String returnType) {
		this.returnType = returnType == null ? null : returnType.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 1-买方付款，2-间接还款，3-卖方还款，4-担保付款，5-担保公司赔款
	 */
	public String getReturnMethod() {
		return returnMethod;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 1-买方付款，2-间接还款，3-卖方还款，4-担保付款，5-担保公司赔款
	 */
	public void setReturnMethod(String returnMethod) {
		this.returnMethod = returnMethod == null ? null : returnMethod.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 回款金额
	 */
	public BigDecimal getReturnAmount() {
		return returnAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 回款金额
	 */
	public void setReturnAmount(BigDecimal returnAmount) {
		this.returnAmount = returnAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 */
	public BigDecimal getReturnInterestAmount() {
		return returnInterestAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 */
	public void setReturnInterestAmount(BigDecimal returnInterestAmount) {
		this.returnInterestAmount = returnInterestAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 */
	public BigDecimal getReturnCapitalAmount() {
		return returnCapitalAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 */
	public void setReturnCapitalAmount(BigDecimal returnCapitalAmount) {
		this.returnCapitalAmount = returnCapitalAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 */
	public BigDecimal getToSallerAmount() {
		return toSallerAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 */
	public void setToSallerAmount(BigDecimal toSallerAmount) {
		this.toSallerAmount = toSallerAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 入池金额
	 */
	public BigDecimal getToPoolAmount() {
		return toPoolAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 入池金额
	 */
	public void setToPoolAmount(BigDecimal toPoolAmount) {
		this.toPoolAmount = toPoolAmount;
	}

	/**
	 * CHAR(1)<br>
	 * 获得 尾款是否解付：1-是、2-否
	 */
	public String getToSallerFlag() {
		return toSallerFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 尾款是否解付：1-是、2-否
	 */
	public void setToSallerFlag(String toSallerFlag) {
		this.toSallerFlag = toSallerFlag == null ? null : toSallerFlag.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 通用原因
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 通用原因
	 */
	public void setReason(String reason) {
		this.reason = reason == null ? null : reason.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 其他原因
	 */
	public String getOtherReason() {
		return otherReason;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 其他原因
	 */
	public void setOtherReason(String otherReason) {
		this.otherReason = otherReason == null ? null : otherReason.trim();
	}

	/**
	 * CHAR(3)<br>
	 * 获得 币种
	 */
	public String getCurcd() {
		return curcd;
	}

	/**
	 * CHAR(3)<br>
	 * 设置 币种
	 */
	public void setCurcd(String curcd) {
		this.curcd = curcd == null ? null : curcd.trim();
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
	 * CHAR(8)<br>
	 * 获得 为通用日期时间，包含 出池日期、 入池日期、 承购日期、 核销日期 根据业务操作类型来确定。等等
	 */
	public String getCommonDate() {
		return commonDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 为通用日期时间，包含 出池日期、 入池日期、 承购日期、 核销日期 根据业务操作类型来确定。等等
	 */
	public void setCommonDate(String commonDate) {
		this.commonDate = commonDate == null ? null : commonDate.trim();
	}

	/**
	 * VARCHAR(32)<br>
	 * 获得 登记人
	 */
	public String getTlrcd() {
		return tlrcd;
	}

	/**
	 * VARCHAR(32)<br>
	 * 设置 登记人
	 */
	public void setTlrcd(String tlrcd) {
		this.tlrcd = tlrcd == null ? null : tlrcd.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 登记机构
	 */
	public String getBrcode() {
		return brcode;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 登记机构
	 */
	public void setBrcode(String brcode) {
		this.brcode = brcode == null ? null : brcode.trim();
	}

	/**
	 * VARCHAR(2)<br>
	 */
	public String getBailType() {
		return bailType;
	}

	/**
	 * VARCHAR(2)<br>
	 */
	public void setBailType(String bailType) {
		this.bailType = bailType == null ? null : bailType.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 借据编号
	 */
	public String getDebetNo() {
		return debetNo;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 借据编号
	 */
	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo == null ? null : debetNo.trim();
	}

	/**
	 * VARCHAR(2)<br>
	 */
	public String getInitType() {
		return initType;
	}

	/**
	 * VARCHAR(2)<br>
	 */
	public void setInitType(String initType) {
		this.initType = initType == null ? null : initType.trim();
	}

	/**
	 * VARCHAR(2)<br>
	 * 获得 确认状态
	 */
	public String getConfirmStatus() {
		return confirmStatus;
	}

	/**
	 * VARCHAR(2)<br>
	 * 设置 确认状态
	 */
	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus == null ? null : confirmStatus.trim();
	}

	/**
	 * TIMESTAMP(11,6)<br>
	 * 获得 创建时间
	 */
	public Date getCrtTime() {
		return crtTime;
	}

	/**
	 * TIMESTAMP(11,6)<br>
	 * 设置 创建时间
	 */
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	/**
	 * TIMESTAMP(11,6)<br>
	 * 获得 最后更新时间
	 */
	public Date getLastUptTime() {
		return lastUptTime;
	}

	/**
	 * TIMESTAMP(11,6)<br>
	 * 设置 最后更新时间
	 */
	public void setLastUptTime(Date lastUptTime) {
		this.lastUptTime = lastUptTime;
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 入账账号(回款帐户)
	 */
	public String getReturnAccount() {
		return returnAccount;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 入账账号(回款帐户)
	 */
	public void setReturnAccount(String returnAccount) {
		this.returnAccount = returnAccount == null ? null : returnAccount.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 本次入保证金金额
	 */
	public BigDecimal getTobailAmount() {
		return tobailAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 本次入保证金金额
	 */
	public void setTobailAmount(BigDecimal tobailAmount) {
		this.tobailAmount = tobailAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 本次核销金额
	 */
	public BigDecimal getRebateAmount() {
		return rebateAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 本次核销金额
	 */
	public void setRebateAmount(BigDecimal rebateAmount) {
		this.rebateAmount = rebateAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 入账账户(回款账户)余额
	 */
	public BigDecimal getReturnAccountBalance() {
		return returnAccountBalance;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 入账账户(回款账户)余额
	 */
	public void setReturnAccountBalance(BigDecimal returnAccountBalance) {
		this.returnAccountBalance = returnAccountBalance;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 本次总计尾款金额
	 */
	public BigDecimal getTotalOverAmount() {
		return totalOverAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 本次总计尾款金额
	 */
	public void setTotalOverAmount(BigDecimal totalOverAmount) {
		this.totalOverAmount = totalOverAmount;
	}

	/**
	 * CHAR(2)<br>
	 * 获得 自动分配规则
	 */
	public String getAssignRule() {
		return assignRule;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 自动分配规则
	 */
	public void setAssignRule(String assignRule) {
		this.assignRule = assignRule == null ? null : assignRule.trim();
	}

	/**
	 * VARCHAR(40)<br>
	 * 获得 入账交易编号
	 */
	public String getTransactionNo() {
		return transactionNo;
	}

	/**
	 * VARCHAR(40)<br>
	 * 设置 入账交易编号
	 */
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo == null ? null : transactionNo.trim();
	}

	/**
	 * DECIMAL(22)<br>
	 * 获得 退款期限
	 */
	public BigDecimal getRefundTerm() {
		return refundTerm;
	}

	/**
	 * DECIMAL(22)<br>
	 * 设置 退款期限
	 */
	public void setRefundTerm(BigDecimal refundTerm) {
		this.refundTerm = refundTerm;
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 收款人名称
	 */
	public String getPayee() {
		return payee;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 收款人名称
	 */
	public void setPayee(String payee) {
		this.payee = payee == null ? null : payee.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 退款账号
	 */
	public String getRefundAcctNo() {
		return refundAcctNo;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 退款账号
	 */
	public void setRefundAcctNo(String refundAcctNo) {
		this.refundAcctNo = refundAcctNo == null ? null : refundAcctNo.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 开户行
	 */
	public String getDepositBank() {
		return depositBank;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 开户行
	 */
	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank == null ? null : depositBank.trim();
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 回款结算方式：1-票据、2-汇款
	 */
	public String getSettleMethod() {
		return settleMethod;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 回款结算方式：1-票据、2-汇款
	 */
	public void setSettleMethod(String settleMethod) {
		this.settleMethod = settleMethod == null ? null : settleMethod.trim();
	}

	/**
	 * VARCHAR(120)<br>
	 * 获得 付款单位
	 */
	public String getPayer() {
		return payer;
	}

	/**
	 * VARCHAR(120)<br>
	 * 设置 付款单位
	 */
	public void setPayer(String payer) {
		this.payer = payer == null ? null : payer.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 付款人账号
	 */
	public String getPayerAcctNo() {
		return payerAcctNo;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 付款人账号
	 */
	public void setPayerAcctNo(String payerAcctNo) {
		this.payerAcctNo = payerAcctNo == null ? null : payerAcctNo.trim();
	}

	/**
	 * VARCHAR(120)<br>
	 * 获得 付款银行
	 */
	public String getPayerBank() {
		return payerBank;
	}

	/**
	 * VARCHAR(120)<br>
	 * 设置 付款银行
	 */
	public void setPayerBank(String payerBank) {
		this.payerBank = payerBank == null ? null : payerBank.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 转账金额
	 */
	public BigDecimal getTransferAmt() {
		return transferAmt;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 转账金额
	 */
	public void setTransferAmt(BigDecimal transferAmt) {
		this.transferAmt = transferAmt;
	}

	/**
	 * CHAR(8)<br>
	 * 获得 交易日期
	 */
	public String getTransactionDate() {
		return transactionDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 交易日期
	 */
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate == null ? null : transactionDate.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 借据号/承兑协议号
	 */
	public String getDebetId() {
		return debetId;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 借据号/承兑协议号
	 */
	public void setDebetId(String debetId) {
		this.debetId = debetId == null ? null : debetId.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 到期日（借据）
	 */
	public String getFinacingEndDate() {
		return finacingEndDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 到期日（借据）
	 */
	public void setFinacingEndDate(String finacingEndDate) {
		this.finacingEndDate = finacingEndDate == null ? null : finacingEndDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 发放日（借据）
	 */
	public String getFinacingStartDate() {
		return finacingStartDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 发放日（借据）
	 */
	public void setFinacingStartDate(String finacingStartDate) {
		this.finacingStartDate = finacingStartDate == null ? null : finacingStartDate.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 借据金额
	 */
	public BigDecimal getLnciAmt() {
		return lnciAmt;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 借据金额
	 */
	public void setLnciAmt(BigDecimal lnciAmt) {
		this.lnciAmt = lnciAmt;
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 信贷合同
	 */
	public String getMastContcode() {
		return mastContcode;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 信贷合同
	 */
	public void setMastContcode(String mastContcode) {
		this.mastContcode = mastContcode == null ? null : mastContcode.trim();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", appno=").append(appno);
		sb.append(", custcdBuyer=").append(custcdBuyer);
		sb.append(", custcdSaller=").append(custcdSaller);
		sb.append(", applyType=").append(applyType);
		sb.append(", mastContno=").append(mastContno);
		sb.append(", insertDate=").append(insertDate);
		sb.append(", purchaseDate=").append(purchaseDate);
		sb.append(", debtNum=").append(debtNum);
		sb.append(", totalDebtAmount=").append(totalDebtAmount);
		sb.append(", chargeType=").append(chargeType);
		sb.append(", finacingDiscountType=").append(finacingDiscountType);
		sb.append(", finacingCost=").append(finacingCost);
		sb.append(", cost=").append(cost);
		sb.append(", handlingFee=").append(handlingFee);
		sb.append(", reduceAmount=").append(reduceAmount);
		sb.append(", totalFee=").append(totalFee);
		sb.append(", totalReduce=").append(totalReduce);
		sb.append(", receiveAmount=").append(receiveAmount);
		sb.append(", costAccount=").append(costAccount);
		sb.append(", accountNo=").append(accountNo);
		sb.append(", payDayMonth=").append(payDayMonth);
		sb.append(", rateCollectType=").append(rateCollectType);
		sb.append(", overDueRate=").append(overDueRate);
		sb.append(", executeRate=").append(executeRate);
		sb.append(", upDownPercent=").append(upDownPercent);
		sb.append(", upDown=").append(upDown);
		sb.append(", baseRate=").append(baseRate);
		sb.append(", rateId=").append(rateId);
		sb.append(", rateType=").append(rateType);
		sb.append(", bussType=").append(bussType);
		sb.append(", loanType=").append(loanType);
		sb.append(", loanWay=").append(loanWay);
		sb.append(", bankno=").append(bankno);
		sb.append(", brcode2=").append(brcode2);
		sb.append(", amount=").append(amount);
		sb.append(", loanDays=").append(loanDays);
		sb.append(", billDate=").append(billDate);
		sb.append(", billEndDate=").append(billEndDate);
		sb.append(", orderNo=").append(orderNo);
		sb.append(", orderAmt=").append(orderAmt);
		sb.append(", balanceAccount=").append(balanceAccount);
		sb.append(", bailAmt=").append(bailAmt);
		sb.append(", bailAccount=").append(bailAccount);
		sb.append(", billAccount=").append(billAccount);
		sb.append(", coreAccount=").append(coreAccount);
		sb.append(", appDate=").append(appDate);
		sb.append(", appLoanDate=").append(appLoanDate);
		sb.append(", loanDueDate=").append(loanDueDate);
		sb.append(", returnDate=").append(returnDate);
		sb.append(", returnType=").append(returnType);
		sb.append(", returnMethod=").append(returnMethod);
		sb.append(", returnAmount=").append(returnAmount);
		sb.append(", returnInterestAmount=").append(returnInterestAmount);
		sb.append(", returnCapitalAmount=").append(returnCapitalAmount);
		sb.append(", toSallerAmount=").append(toSallerAmount);
		sb.append(", toPoolAmount=").append(toPoolAmount);
		sb.append(", toSallerFlag=").append(toSallerFlag);
		sb.append(", reason=").append(reason);
		sb.append(", otherReason=").append(otherReason);
		sb.append(", curcd=").append(curcd);
		sb.append(", memo=").append(memo);
		sb.append(", commonDate=").append(commonDate);
		sb.append(", tlrcd=").append(tlrcd);
		sb.append(", brcode=").append(brcode);
		sb.append(", bailType=").append(bailType);
		sb.append(", debetNo=").append(debetNo);
		sb.append(", initType=").append(initType);
		sb.append(", confirmStatus=").append(confirmStatus);
		sb.append(", crtTime=").append(crtTime);
		sb.append(", lastUptTime=").append(lastUptTime);
		sb.append(", returnAccount=").append(returnAccount);
		sb.append(", tobailAmount=").append(tobailAmount);
		sb.append(", rebateAmount=").append(rebateAmount);
		sb.append(", returnAccountBalance=").append(returnAccountBalance);
		sb.append(", totalOverAmount=").append(totalOverAmount);
		sb.append(", assignRule=").append(assignRule);
		sb.append(", transactionNo=").append(transactionNo);
		sb.append(", refundTerm=").append(refundTerm);
		sb.append(", payee=").append(payee);
		sb.append(", refundAcctNo=").append(refundAcctNo);
		sb.append(", depositBank=").append(depositBank);
		sb.append(", settleMethod=").append(settleMethod);
		sb.append(", payer=").append(payer);
		sb.append(", payerAcctNo=").append(payerAcctNo);
		sb.append(", payerBank=").append(payerBank);
		sb.append(", transferAmt=").append(transferAmt);
		sb.append(", transactionDate=").append(transactionDate);
		sb.append(", debetId=").append(debetId);
		sb.append(", finacingEndDate=").append(finacingEndDate);
		sb.append(", finacingStartDate=").append(finacingStartDate);
		sb.append(", lnciAmt=").append(lnciAmt);
		sb.append(", mastContcode=").append(mastContcode);
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
		RBcpAppliBussInfo other = (RBcpAppliBussInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
				&& (this.getCustcdBuyer() == null ? other.getCustcdBuyer() == null
						: this.getCustcdBuyer().equals(other.getCustcdBuyer()))
				&& (this.getCustcdSaller() == null ? other.getCustcdSaller() == null
						: this.getCustcdSaller().equals(other.getCustcdSaller()))
				&& (this.getApplyType() == null ? other.getApplyType() == null
						: this.getApplyType().equals(other.getApplyType()))
				&& (this.getMastContno() == null ? other.getMastContno() == null
						: this.getMastContno().equals(other.getMastContno()))
				&& (this.getInsertDate() == null ? other.getInsertDate() == null
						: this.getInsertDate().equals(other.getInsertDate()))
				&& (this.getPurchaseDate() == null ? other.getPurchaseDate() == null
						: this.getPurchaseDate().equals(other.getPurchaseDate()))
				&& (this.getDebtNum() == null ? other.getDebtNum() == null
						: this.getDebtNum().equals(other.getDebtNum()))
				&& (this.getTotalDebtAmount() == null ? other.getTotalDebtAmount() == null
						: this.getTotalDebtAmount().equals(other.getTotalDebtAmount()))
				&& (this.getChargeType() == null ? other.getChargeType() == null
						: this.getChargeType().equals(other.getChargeType()))
				&& (this.getFinacingDiscountType() == null ? other.getFinacingDiscountType() == null
						: this.getFinacingDiscountType().equals(other.getFinacingDiscountType()))
				&& (this.getFinacingCost() == null ? other.getFinacingCost() == null
						: this.getFinacingCost().equals(other.getFinacingCost()))
				&& (this.getCost() == null ? other.getCost() == null : this.getCost().equals(other.getCost()))
				&& (this.getHandlingFee() == null ? other.getHandlingFee() == null
						: this.getHandlingFee().equals(other.getHandlingFee()))
				&& (this.getReduceAmount() == null ? other.getReduceAmount() == null
						: this.getReduceAmount().equals(other.getReduceAmount()))
				&& (this.getTotalFee() == null ? other.getTotalFee() == null
						: this.getTotalFee().equals(other.getTotalFee()))
				&& (this.getTotalReduce() == null ? other.getTotalReduce() == null
						: this.getTotalReduce().equals(other.getTotalReduce()))
				&& (this.getReceiveAmount() == null ? other.getReceiveAmount() == null
						: this.getReceiveAmount().equals(other.getReceiveAmount()))
				&& (this.getCostAccount() == null ? other.getCostAccount() == null
						: this.getCostAccount().equals(other.getCostAccount()))
				&& (this.getAccountNo() == null ? other.getAccountNo() == null
						: this.getAccountNo().equals(other.getAccountNo()))
				&& (this.getPayDayMonth() == null ? other.getPayDayMonth() == null
						: this.getPayDayMonth().equals(other.getPayDayMonth()))
				&& (this.getRateCollectType() == null ? other.getRateCollectType() == null
						: this.getRateCollectType().equals(other.getRateCollectType()))
				&& (this.getOverDueRate() == null ? other.getOverDueRate() == null
						: this.getOverDueRate().equals(other.getOverDueRate()))
				&& (this.getExecuteRate() == null ? other.getExecuteRate() == null
						: this.getExecuteRate().equals(other.getExecuteRate()))
				&& (this.getUpDownPercent() == null ? other.getUpDownPercent() == null
						: this.getUpDownPercent().equals(other.getUpDownPercent()))
				&& (this.getUpDown() == null ? other.getUpDown() == null : this.getUpDown().equals(other.getUpDown()))
				&& (this.getBaseRate() == null ? other.getBaseRate() == null
						: this.getBaseRate().equals(other.getBaseRate()))
				&& (this.getRateId() == null ? other.getRateId() == null : this.getRateId().equals(other.getRateId()))
				&& (this.getRateType() == null ? other.getRateType() == null
						: this.getRateType().equals(other.getRateType()))
				&& (this.getBussType() == null ? other.getBussType() == null
						: this.getBussType().equals(other.getBussType()))
				&& (this.getLoanType() == null ? other.getLoanType() == null
						: this.getLoanType().equals(other.getLoanType()))
				&& (this.getLoanWay() == null ? other.getLoanWay() == null
						: this.getLoanWay().equals(other.getLoanWay()))
				&& (this.getBankno() == null ? other.getBankno() == null : this.getBankno().equals(other.getBankno()))
				&& (this.getBrcode2() == null ? other.getBrcode2() == null
						: this.getBrcode2().equals(other.getBrcode2()))
				&& (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
				&& (this.getLoanDays() == null ? other.getLoanDays() == null
						: this.getLoanDays().equals(other.getLoanDays()))
				&& (this.getBillDate() == null ? other.getBillDate() == null
						: this.getBillDate().equals(other.getBillDate()))
				&& (this.getBillEndDate() == null ? other.getBillEndDate() == null
						: this.getBillEndDate().equals(other.getBillEndDate()))
				&& (this.getOrderNo() == null ? other.getOrderNo() == null
						: this.getOrderNo().equals(other.getOrderNo()))
				&& (this.getOrderAmt() == null ? other.getOrderAmt() == null
						: this.getOrderAmt().equals(other.getOrderAmt()))
				&& (this.getBalanceAccount() == null ? other.getBalanceAccount() == null
						: this.getBalanceAccount().equals(other.getBalanceAccount()))
				&& (this.getBailAmt() == null ? other.getBailAmt() == null
						: this.getBailAmt().equals(other.getBailAmt()))
				&& (this.getBailAccount() == null ? other.getBailAccount() == null
						: this.getBailAccount().equals(other.getBailAccount()))
				&& (this.getBillAccount() == null ? other.getBillAccount() == null
						: this.getBillAccount().equals(other.getBillAccount()))
				&& (this.getCoreAccount() == null ? other.getCoreAccount() == null
						: this.getCoreAccount().equals(other.getCoreAccount()))
				&& (this.getAppDate() == null ? other.getAppDate() == null
						: this.getAppDate().equals(other.getAppDate()))
				&& (this.getAppLoanDate() == null ? other.getAppLoanDate() == null
						: this.getAppLoanDate().equals(other.getAppLoanDate()))
				&& (this.getLoanDueDate() == null ? other.getLoanDueDate() == null
						: this.getLoanDueDate().equals(other.getLoanDueDate()))
				&& (this.getReturnDate() == null ? other.getReturnDate() == null
						: this.getReturnDate().equals(other.getReturnDate()))
				&& (this.getReturnType() == null ? other.getReturnType() == null
						: this.getReturnType().equals(other.getReturnType()))
				&& (this.getReturnMethod() == null ? other.getReturnMethod() == null
						: this.getReturnMethod().equals(other.getReturnMethod()))
				&& (this.getReturnAmount() == null ? other.getReturnAmount() == null
						: this.getReturnAmount().equals(other.getReturnAmount()))
				&& (this.getReturnInterestAmount() == null ? other.getReturnInterestAmount() == null
						: this.getReturnInterestAmount().equals(other.getReturnInterestAmount()))
				&& (this.getReturnCapitalAmount() == null ? other.getReturnCapitalAmount() == null
						: this.getReturnCapitalAmount().equals(other.getReturnCapitalAmount()))
				&& (this.getToSallerAmount() == null ? other.getToSallerAmount() == null
						: this.getToSallerAmount().equals(other.getToSallerAmount()))
				&& (this.getToPoolAmount() == null ? other.getToPoolAmount() == null
						: this.getToPoolAmount().equals(other.getToPoolAmount()))
				&& (this.getToSallerFlag() == null ? other.getToSallerFlag() == null
						: this.getToSallerFlag().equals(other.getToSallerFlag()))
				&& (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
				&& (this.getOtherReason() == null ? other.getOtherReason() == null
						: this.getOtherReason().equals(other.getOtherReason()))
				&& (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
				&& (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
				&& (this.getCommonDate() == null ? other.getCommonDate() == null
						: this.getCommonDate().equals(other.getCommonDate()))
				&& (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
				&& (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
				&& (this.getBailType() == null ? other.getBailType() == null
						: this.getBailType().equals(other.getBailType()))
				&& (this.getDebetNo() == null ? other.getDebetNo() == null
						: this.getDebetNo().equals(other.getDebetNo()))
				&& (this.getInitType() == null ? other.getInitType() == null
						: this.getInitType().equals(other.getInitType()))
				&& (this.getConfirmStatus() == null ? other.getConfirmStatus() == null
						: this.getConfirmStatus().equals(other.getConfirmStatus()))
				&& (this.getCrtTime() == null ? other.getCrtTime() == null
						: this.getCrtTime().equals(other.getCrtTime()))
				&& (this.getLastUptTime() == null ? other.getLastUptTime() == null
						: this.getLastUptTime().equals(other.getLastUptTime()))
				&& (this.getReturnAccount() == null ? other.getReturnAccount() == null
						: this.getReturnAccount().equals(other.getReturnAccount()))
				&& (this.getTobailAmount() == null ? other.getTobailAmount() == null
						: this.getTobailAmount().equals(other.getTobailAmount()))
				&& (this.getRebateAmount() == null ? other.getRebateAmount() == null
						: this.getRebateAmount().equals(other.getRebateAmount()))
				&& (this.getReturnAccountBalance() == null ? other.getReturnAccountBalance() == null
						: this.getReturnAccountBalance().equals(other.getReturnAccountBalance()))
				&& (this.getTotalOverAmount() == null ? other.getTotalOverAmount() == null
						: this.getTotalOverAmount().equals(other.getTotalOverAmount()))
				&& (this.getAssignRule() == null ? other.getAssignRule() == null
						: this.getAssignRule().equals(other.getAssignRule()))
				&& (this.getTransactionNo() == null ? other.getTransactionNo() == null
						: this.getTransactionNo().equals(other.getTransactionNo()))
				&& (this.getRefundTerm() == null ? other.getRefundTerm() == null
						: this.getRefundTerm().equals(other.getRefundTerm()))
				&& (this.getPayee() == null ? other.getPayee() == null : this.getPayee().equals(other.getPayee()))
				&& (this.getRefundAcctNo() == null ? other.getRefundAcctNo() == null
						: this.getRefundAcctNo().equals(other.getRefundAcctNo()))
				&& (this.getDepositBank() == null ? other.getDepositBank() == null
						: this.getDepositBank().equals(other.getDepositBank()))
				&& (this.getSettleMethod() == null ? other.getSettleMethod() == null
						: this.getSettleMethod().equals(other.getSettleMethod()))
				&& (this.getPayer() == null ? other.getPayer() == null : this.getPayer().equals(other.getPayer()))
				&& (this.getPayerAcctNo() == null ? other.getPayerAcctNo() == null
						: this.getPayerAcctNo().equals(other.getPayerAcctNo()))
				&& (this.getPayerBank() == null ? other.getPayerBank() == null
						: this.getPayerBank().equals(other.getPayerBank()))
				&& (this.getTransferAmt() == null ? other.getTransferAmt() == null
						: this.getTransferAmt().equals(other.getTransferAmt()))
				&& (this.getTransactionDate() == null ? other.getTransactionDate() == null
						: this.getTransactionDate().equals(other.getTransactionDate()))
				&& (this.getDebetId() == null ? other.getDebetId() == null
						: this.getDebetId().equals(other.getDebetId()))
				&& (this.getFinacingEndDate() == null ? other.getFinacingEndDate() == null
						: this.getFinacingEndDate().equals(other.getFinacingEndDate()))
				&& (this.getFinacingStartDate() == null ? other.getFinacingStartDate() == null
						: this.getFinacingStartDate().equals(other.getFinacingStartDate()))
				&& (this.getLnciAmt() == null ? other.getLnciAmt() == null
						: this.getLnciAmt().equals(other.getLnciAmt()))
				&& (this.getMastContcode() == null ? other.getMastContcode() == null
						: this.getMastContcode().equals(other.getMastContcode()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
		result = prime * result + ((getCustcdBuyer() == null) ? 0 : getCustcdBuyer().hashCode());
		result = prime * result + ((getCustcdSaller() == null) ? 0 : getCustcdSaller().hashCode());
		result = prime * result + ((getApplyType() == null) ? 0 : getApplyType().hashCode());
		result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
		result = prime * result + ((getInsertDate() == null) ? 0 : getInsertDate().hashCode());
		result = prime * result + ((getPurchaseDate() == null) ? 0 : getPurchaseDate().hashCode());
		result = prime * result + ((getDebtNum() == null) ? 0 : getDebtNum().hashCode());
		result = prime * result + ((getTotalDebtAmount() == null) ? 0 : getTotalDebtAmount().hashCode());
		result = prime * result + ((getChargeType() == null) ? 0 : getChargeType().hashCode());
		result = prime * result + ((getFinacingDiscountType() == null) ? 0 : getFinacingDiscountType().hashCode());
		result = prime * result + ((getFinacingCost() == null) ? 0 : getFinacingCost().hashCode());
		result = prime * result + ((getCost() == null) ? 0 : getCost().hashCode());
		result = prime * result + ((getHandlingFee() == null) ? 0 : getHandlingFee().hashCode());
		result = prime * result + ((getReduceAmount() == null) ? 0 : getReduceAmount().hashCode());
		result = prime * result + ((getTotalFee() == null) ? 0 : getTotalFee().hashCode());
		result = prime * result + ((getTotalReduce() == null) ? 0 : getTotalReduce().hashCode());
		result = prime * result + ((getReceiveAmount() == null) ? 0 : getReceiveAmount().hashCode());
		result = prime * result + ((getCostAccount() == null) ? 0 : getCostAccount().hashCode());
		result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
		result = prime * result + ((getPayDayMonth() == null) ? 0 : getPayDayMonth().hashCode());
		result = prime * result + ((getRateCollectType() == null) ? 0 : getRateCollectType().hashCode());
		result = prime * result + ((getOverDueRate() == null) ? 0 : getOverDueRate().hashCode());
		result = prime * result + ((getExecuteRate() == null) ? 0 : getExecuteRate().hashCode());
		result = prime * result + ((getUpDownPercent() == null) ? 0 : getUpDownPercent().hashCode());
		result = prime * result + ((getUpDown() == null) ? 0 : getUpDown().hashCode());
		result = prime * result + ((getBaseRate() == null) ? 0 : getBaseRate().hashCode());
		result = prime * result + ((getRateId() == null) ? 0 : getRateId().hashCode());
		result = prime * result + ((getRateType() == null) ? 0 : getRateType().hashCode());
		result = prime * result + ((getBussType() == null) ? 0 : getBussType().hashCode());
		result = prime * result + ((getLoanType() == null) ? 0 : getLoanType().hashCode());
		result = prime * result + ((getLoanWay() == null) ? 0 : getLoanWay().hashCode());
		result = prime * result + ((getBankno() == null) ? 0 : getBankno().hashCode());
		result = prime * result + ((getBrcode2() == null) ? 0 : getBrcode2().hashCode());
		result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
		result = prime * result + ((getLoanDays() == null) ? 0 : getLoanDays().hashCode());
		result = prime * result + ((getBillDate() == null) ? 0 : getBillDate().hashCode());
		result = prime * result + ((getBillEndDate() == null) ? 0 : getBillEndDate().hashCode());
		result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
		result = prime * result + ((getOrderAmt() == null) ? 0 : getOrderAmt().hashCode());
		result = prime * result + ((getBalanceAccount() == null) ? 0 : getBalanceAccount().hashCode());
		result = prime * result + ((getBailAmt() == null) ? 0 : getBailAmt().hashCode());
		result = prime * result + ((getBailAccount() == null) ? 0 : getBailAccount().hashCode());
		result = prime * result + ((getBillAccount() == null) ? 0 : getBillAccount().hashCode());
		result = prime * result + ((getCoreAccount() == null) ? 0 : getCoreAccount().hashCode());
		result = prime * result + ((getAppDate() == null) ? 0 : getAppDate().hashCode());
		result = prime * result + ((getAppLoanDate() == null) ? 0 : getAppLoanDate().hashCode());
		result = prime * result + ((getLoanDueDate() == null) ? 0 : getLoanDueDate().hashCode());
		result = prime * result + ((getReturnDate() == null) ? 0 : getReturnDate().hashCode());
		result = prime * result + ((getReturnType() == null) ? 0 : getReturnType().hashCode());
		result = prime * result + ((getReturnMethod() == null) ? 0 : getReturnMethod().hashCode());
		result = prime * result + ((getReturnAmount() == null) ? 0 : getReturnAmount().hashCode());
		result = prime * result + ((getReturnInterestAmount() == null) ? 0 : getReturnInterestAmount().hashCode());
		result = prime * result + ((getReturnCapitalAmount() == null) ? 0 : getReturnCapitalAmount().hashCode());
		result = prime * result + ((getToSallerAmount() == null) ? 0 : getToSallerAmount().hashCode());
		result = prime * result + ((getToPoolAmount() == null) ? 0 : getToPoolAmount().hashCode());
		result = prime * result + ((getToSallerFlag() == null) ? 0 : getToSallerFlag().hashCode());
		result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
		result = prime * result + ((getOtherReason() == null) ? 0 : getOtherReason().hashCode());
		result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
		result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
		result = prime * result + ((getCommonDate() == null) ? 0 : getCommonDate().hashCode());
		result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
		result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
		result = prime * result + ((getBailType() == null) ? 0 : getBailType().hashCode());
		result = prime * result + ((getDebetNo() == null) ? 0 : getDebetNo().hashCode());
		result = prime * result + ((getInitType() == null) ? 0 : getInitType().hashCode());
		result = prime * result + ((getConfirmStatus() == null) ? 0 : getConfirmStatus().hashCode());
		result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
		result = prime * result + ((getLastUptTime() == null) ? 0 : getLastUptTime().hashCode());
		result = prime * result + ((getReturnAccount() == null) ? 0 : getReturnAccount().hashCode());
		result = prime * result + ((getTobailAmount() == null) ? 0 : getTobailAmount().hashCode());
		result = prime * result + ((getRebateAmount() == null) ? 0 : getRebateAmount().hashCode());
		result = prime * result + ((getReturnAccountBalance() == null) ? 0 : getReturnAccountBalance().hashCode());
		result = prime * result + ((getTotalOverAmount() == null) ? 0 : getTotalOverAmount().hashCode());
		result = prime * result + ((getAssignRule() == null) ? 0 : getAssignRule().hashCode());
		result = prime * result + ((getTransactionNo() == null) ? 0 : getTransactionNo().hashCode());
		result = prime * result + ((getRefundTerm() == null) ? 0 : getRefundTerm().hashCode());
		result = prime * result + ((getPayee() == null) ? 0 : getPayee().hashCode());
		result = prime * result + ((getRefundAcctNo() == null) ? 0 : getRefundAcctNo().hashCode());
		result = prime * result + ((getDepositBank() == null) ? 0 : getDepositBank().hashCode());
		result = prime * result + ((getSettleMethod() == null) ? 0 : getSettleMethod().hashCode());
		result = prime * result + ((getPayer() == null) ? 0 : getPayer().hashCode());
		result = prime * result + ((getPayerAcctNo() == null) ? 0 : getPayerAcctNo().hashCode());
		result = prime * result + ((getPayerBank() == null) ? 0 : getPayerBank().hashCode());
		result = prime * result + ((getTransferAmt() == null) ? 0 : getTransferAmt().hashCode());
		result = prime * result + ((getTransactionDate() == null) ? 0 : getTransactionDate().hashCode());
		result = prime * result + ((getDebetId() == null) ? 0 : getDebetId().hashCode());
		result = prime * result + ((getFinacingEndDate() == null) ? 0 : getFinacingEndDate().hashCode());
		result = prime * result + ((getFinacingStartDate() == null) ? 0 : getFinacingStartDate().hashCode());
		result = prime * result + ((getLnciAmt() == null) ? 0 : getLnciAmt().hashCode());
		result = prime * result + ((getMastContcode() == null) ? 0 : getMastContcode().hashCode());
		return result;
	}
}
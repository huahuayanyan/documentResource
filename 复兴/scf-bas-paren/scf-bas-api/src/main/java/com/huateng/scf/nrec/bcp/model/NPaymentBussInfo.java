package com.huateng.scf.nrec.bcp.model;

import java.math.BigDecimal;
import java.util.Date;

public class NPaymentBussInfo {
	private String productId;//产品ID
	private String repayPurpose;//回款用途
	private BigDecimal totalRepayAmount;//偿还融资金额
	private BigDecimal totalBillsAmount;//池应收账款余额
	private BigDecimal bailAmount;//保证金金额（池保证金余额）
	private BigDecimal poolRiskAmt;//池敞口
	
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
	 * 买方客户名称
	 */
	private String cnameBuyer;

	/**
	 * VARCHAR(15)<br>
	 * 卖方客户号
	 */
	private String custcdSaller;
	/**
	 * VARCHAR(15)<br>
	 * 卖方客户名称
	 */
	private String cnameSeller;

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
	 * DECIMAL(16,2)<br>
	 * 对应账款主合同额度金额
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
	 * 实收费用总额
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
	 * VARCHAR(10)<br>
	 * 保理类型
	 */
	private String factType;

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
	
    private  String  bussTypeName;  

	public String getFactType() {
		return factType;
	}

	public void setFactType(String factType) {
		this.factType = factType;
	}

	public BigDecimal getContAmount() {
		return contAmount;
	}

	public void setContAmount(BigDecimal contAmount) {
		this.contAmount = contAmount;
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

	public String getCnameBuyer() {
		return cnameBuyer;
	}

	public void setCnameBuyer(String cnameBuyer) {
		this.cnameBuyer = cnameBuyer;
	}

	public String getCnameSeller() {
		return cnameSeller;
	}

	public void setCnameSeller(String cnameSeller) {
		this.cnameSeller = cnameSeller;
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
	 * @return the debtNum
	 */
	public Integer getDebtNum() {
		return debtNum;
	}

	/**
	 * @param debtNum the debtNum to set
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

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getRepayPurpose() {
		return repayPurpose;
	}
	public void setRepayPurpose(String repayPurpose) {
		this.repayPurpose = repayPurpose;
	}
	public BigDecimal getTotalRepayAmount() {
		return totalRepayAmount;
	}
	public void setTotalRepayAmount(BigDecimal totalRepayAmount) {
		this.totalRepayAmount = totalRepayAmount;
	}

	public String getBussTypeName() {
		return bussTypeName;
	}

	public void setBussTypeName(String bussTypeName) {
		this.bussTypeName = bussTypeName;
	}

	/**
	 * @return the totalBillsAmount
	 */
	public BigDecimal getTotalBillsAmount() {
		return totalBillsAmount;
	}

	/**
	 * @param totalBillsAmount the totalBillsAmount to set
	 */
	public void setTotalBillsAmount(BigDecimal totalBillsAmount) {
		this.totalBillsAmount = totalBillsAmount;
	}

	/**
	 * @return the bailAmount
	 */
	public BigDecimal getBailAmount() {
		return bailAmount;
	}

	/**
	 * @param bailAmount the bailAmount to set
	 */
	public void setBailAmount(BigDecimal bailAmount) {
		this.bailAmount = bailAmount;
	}

	/**
	 * @return the poolRiskAmt
	 */
	public BigDecimal getPoolRiskAmt() {
		return poolRiskAmt;
	}

	/**
	 * @param poolRiskAmt the poolRiskAmt to set
	 */
	public void setPoolRiskAmt(BigDecimal poolRiskAmt) {
		this.poolRiskAmt = poolRiskAmt;
	}


}

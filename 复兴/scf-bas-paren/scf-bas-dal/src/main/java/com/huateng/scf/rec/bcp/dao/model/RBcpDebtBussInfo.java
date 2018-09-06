package com.huateng.scf.rec.bcp.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class RBcpDebtBussInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 申请编号
     */
    private String appno;

    /**
     * VARCHAR(4)<br>
     * 申请类型【00:录入;01:承购;02:入池;03:出池;04:折让;05:回购;6:核销;07:发票账龄变更;08:还款;09:瑕疵;10:商纠设定;11:逾期;12:呆账;13:发票融资;14:池融资;15:单据修改;16:单据删除;17:商纠解除;18:催收19:发票费用补录;20:融资展期;21:后收费用收取;22:保证金转入;23:提前还贷;24:担保回购;】
     */
    private String applyType;

    /**
     * VARCHAR(20)<br>
     * 卖方客户号
     */
    private String custcdSaller;

    /**
     * VARCHAR(20)<br>
     * 买方客户号
     */
    private String custcdBuyer;

    /**
     * VARCHAR(20)<br>
     * 主合同号
     */
    private String mastContno;

    /**
     * CHAR(8)<br>
     * 插入日期
     */
    private String insertDate;

    /**
     * CHAR(8)<br>
     * 承购日期
     */
    private String purchaseDate;

    /**
     * DECIMAL(22)<br>
     * 应收账款份数（明细列表记录数）
     */
    private Integer debtNum;

    /**
     * DECIMAL(16,2)<br>
     * 应收账款总金额
     */
    private BigDecimal totalDebtAmount;

    /**
     * CHAR(2)<br>
     * 手续费收取方式【1-先收；2-后收；3-免收】
     */
    private String chargeType;

    /**
     * CHAR(1)<br>
     * 扣取方式【1：外扣，2： 内收】
     */
    private String finacingDiscountType;

    /**
     * DECIMAL(16,2)<br>
     * 手续费用
     */
    private BigDecimal finacingCost;

    /**
     * DECIMAL(16,2)<br>
     * 管理费
     */
    private BigDecimal cost;

    /**
     * DECIMAL(16,2)<br>
     * 处理费
     */
    private BigDecimal handlingFee;

    /**
     * DECIMAL(16,2)<br>
     * 减免金额
     */
    private BigDecimal reduceAmount;

    /**
     * DECIMAL(16,2)<br>
     * 费用总计
     */
    private BigDecimal totalFee;

    /**
     * DECIMAL(16,2)<br>
     * 减免总计
     */
    private BigDecimal totalReduce;

    /**
     * DECIMAL(16,2)<br>
     * 实收费用小计
     */
    private BigDecimal receiveAmount;

    /**
     * VARCHAR(50)<br>
     * 扣费账号
     */
    private String costAccount;

    /**
     * VARCHAR(50)<br>
     * 约定每月缴息日
     */
    private String payDayMonth;

    /**
     * CHAR(1)<br>
     * 利息收取方式【1-到期收息；2-按月收息；3-预收利息】
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
     * 利率浮动百分比
     */
    private String upDownPercent;

    /**
     * CHAR(1)<br>
     * 利率上下浮动标记【1:上浮；2：下浮】
     */
    private String upDown;

    /**
     * VARCHAR(50)<br>
     * 基准利率
     */
    private String baseRate;

    /**
     * VARCHAR(50)<br>
     * 利率代码
     */
    private String rateId;

    /**
     * CHAR(1)<br>
     * 利率类型【1-浮动; 2- 固定】
     */
    private String rateType;

    /**
     * VARCHAR(10)<br>
     * 业务类型【供应链产品小类ID】
     */
    private String bussType;

    /**
     * VARCHAR(50)<br>
     * 贷款种类
     */
    private String loanType;

    /**
     * VARCHAR(50)<br>
     * 开户行
     */
    private String bankno;

    /**
     * VARCHAR(20)<br>
     * 质权行
     */
    private String brcode2;

    /**
     * DECIMAL(16,2)<br>
     * 业务金额
     */
    private BigDecimal amount;

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
     * 融资到期日期
     */
    private String loanDueDate;

    /**
     * CHAR(8)<br>
     * 还款日期
     */
    private String returnDate;

    /**
     * CHAR(3)<br>
     * 币别
     */
    private String curcd;

    /**
     * CHAR(500)<br>
     * 备注
     */
    private String memo;

    /**
     * TIMESTAMP(11,6)<br>
     * 为通用日期时间，包含
出池日期、
入池日期、
承购日期、
核销日期
根据业务操作类型来确定。等等
     */
    private String commonDate;

    /**
     * VARCHAR(20)<br>
     * 操作员ID
     */
    private String tlrcd;

    /**
     * VARCHAR(20)<br>
     * 登记机构
     */
    private String brcode;

    /**
     * CHAR(1)<br>
     * 利率类型【1-利息，2-融资，3-融资本息，4-无】
     */
    private String returnType;

    /**
     * CHAR(1)<br>
     * 尾款是否进入卖方账户标志【1-是，2-否】
     */
    private String toSallerFlag;

    /**
     * DECIMAL(16,2)<br>
     * 还款金额
     */
    private BigDecimal returnAmount;

    /**
     * VARCHAR(100)<br>
     * 通用原因
     */
    private String reason;

    /**
     * VARCHAR(100)<br>
     * 其它原因
     */
    private String otherReason;

    /**
     * VARCHAR(50)<br>
     * 账号
     */
    private String accountNo;

    /**
     * CHAR(1)<br>
     * 还款方式【1-买方付款，2-间接还款，3-卖方还款，4-担保付款，5-担保公司赔款】
     */
    private String returnMethod;

    /**
     * DECIMAL(16,2)<br>
     * 还息金额
     */
    private BigDecimal returnInterestAmount;

    /**
     * DECIMAL(16,2)<br>
     * 还本金额
     */
    private BigDecimal returnCapitalAmount;

    /**
     * DECIMAL(16,2)<br>
     * 入卖方结算账号金额
     */
    private BigDecimal toSallerAmount;

    /**
     * DECIMAL(16,2)<br>
     * 入现金池金额
     */
    private BigDecimal toPoolAmount;

    /**
     * VARCHAR(50)<br>
     * 回款账号
     */
    private String returnAccount;

    /**
     * VARCHAR(40)<br>
     * 入账交易编号
     */
    private String transactionNo;

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
     * VARCHAR(10)<br>
     * 回款结算方式：1-票据、2-汇款
     */
    private String settleMethod;

    /**
     * CHAR(2)<br>
     * 回款用途：01-入保证金、02-还贷、03-尾款
     */
    private String repayPurpose;

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
     * 获得 申请编号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 申请编号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * VARCHAR(4)<br>
     * 获得 申请类型【00:录入;01:承购;02:入池;03:出池;04:折让;05:回购;6:核销;07:发票账龄变更;08:还款;09:瑕疵;10:商纠设定;11:逾期;12:呆账;13:发票融资;14:池融资;15:单据修改;16:单据删除;17:商纠解除;18:催收19:发票费用补录;20:融资展期;21:后收费用收取;22:保证金转入;23:提前还贷;24:担保回购;】
     */
    public String getApplyType() {
        return applyType;
    }

    /**
     * VARCHAR(4)<br>
     * 设置 申请类型【00:录入;01:承购;02:入池;03:出池;04:折让;05:回购;6:核销;07:发票账龄变更;08:还款;09:瑕疵;10:商纠设定;11:逾期;12:呆账;13:发票融资;14:池融资;15:单据修改;16:单据删除;17:商纠解除;18:催收19:发票费用补录;20:融资展期;21:后收费用收取;22:保证金转入;23:提前还贷;24:担保回购;】
     */
    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 卖方客户号
     */
    public String getCustcdSaller() {
        return custcdSaller;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 卖方客户号
     */
    public void setCustcdSaller(String custcdSaller) {
        this.custcdSaller = custcdSaller == null ? null : custcdSaller.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 买方客户号
     */
    public String getCustcdBuyer() {
        return custcdBuyer;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 买方客户号
     */
    public void setCustcdBuyer(String custcdBuyer) {
        this.custcdBuyer = custcdBuyer == null ? null : custcdBuyer.trim();
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
     * 获得 插入日期
     */
    public String getInsertDate() {
        return insertDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 插入日期
     */
    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate == null ? null : insertDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 承购日期
     */
    public String getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 承购日期
     */
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate == null ? null : purchaseDate.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 应收账款份数（明细列表记录数）
     */
    public Integer getDebtNum() {
        return debtNum;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 应收账款份数（明细列表记录数）
     */
    public void setDebtNum(Integer debtNum) {
        this.debtNum = debtNum;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 应收账款总金额
     */
    public BigDecimal getTotalDebtAmount() {
        return totalDebtAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 应收账款总金额
     */
    public void setTotalDebtAmount(BigDecimal totalDebtAmount) {
        this.totalDebtAmount = totalDebtAmount;
    }

    /**
     * CHAR(2)<br>
     * 获得 手续费收取方式【1-先收；2-后收；3-免收】
     */
    public String getChargeType() {
        return chargeType;
    }

    /**
     * CHAR(2)<br>
     * 设置 手续费收取方式【1-先收；2-后收；3-免收】
     */
    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 扣取方式【1：外扣，2： 内收】
     */
    public String getFinacingDiscountType() {
        return finacingDiscountType;
    }

    /**
     * CHAR(1)<br>
     * 设置 扣取方式【1：外扣，2： 内收】
     */
    public void setFinacingDiscountType(String finacingDiscountType) {
        this.finacingDiscountType = finacingDiscountType == null ? null : finacingDiscountType.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 手续费用
     */
    public BigDecimal getFinacingCost() {
        return finacingCost;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 手续费用
     */
    public void setFinacingCost(BigDecimal finacingCost) {
        this.finacingCost = finacingCost;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 管理费
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 管理费
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 处理费
     */
    public BigDecimal getHandlingFee() {
        return handlingFee;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 处理费
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
     * 获得 费用总计
     */
    public BigDecimal getTotalFee() {
        return totalFee;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 费用总计
     */
    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 减免总计
     */
    public BigDecimal getTotalReduce() {
        return totalReduce;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 减免总计
     */
    public void setTotalReduce(BigDecimal totalReduce) {
        this.totalReduce = totalReduce;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 实收费用小计
     */
    public BigDecimal getReceiveAmount() {
        return receiveAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 实收费用小计
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
     * 获得 约定每月缴息日
     */
    public String getPayDayMonth() {
        return payDayMonth;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 约定每月缴息日
     */
    public void setPayDayMonth(String payDayMonth) {
        this.payDayMonth = payDayMonth == null ? null : payDayMonth.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 利息收取方式【1-到期收息；2-按月收息；3-预收利息】
     */
    public String getRateCollectType() {
        return rateCollectType;
    }

    /**
     * CHAR(1)<br>
     * 设置 利息收取方式【1-到期收息；2-按月收息；3-预收利息】
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
     * 获得 利率浮动百分比
     */
    public String getUpDownPercent() {
        return upDownPercent;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 利率浮动百分比
     */
    public void setUpDownPercent(String upDownPercent) {
        this.upDownPercent = upDownPercent == null ? null : upDownPercent.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 利率上下浮动标记【1:上浮；2：下浮】
     */
    public String getUpDown() {
        return upDown;
    }

    /**
     * CHAR(1)<br>
     * 设置 利率上下浮动标记【1:上浮；2：下浮】
     */
    public void setUpDown(String upDown) {
        this.upDown = upDown == null ? null : upDown.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 基准利率
     */
    public String getBaseRate() {
        return baseRate;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 基准利率
     */
    public void setBaseRate(String baseRate) {
        this.baseRate = baseRate == null ? null : baseRate.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 利率代码
     */
    public String getRateId() {
        return rateId;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 利率代码
     */
    public void setRateId(String rateId) {
        this.rateId = rateId == null ? null : rateId.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 利率类型【1-浮动; 2- 固定】
     */
    public String getRateType() {
        return rateType;
    }

    /**
     * CHAR(1)<br>
     * 设置 利率类型【1-浮动; 2- 固定】
     */
    public void setRateType(String rateType) {
        this.rateType = rateType == null ? null : rateType.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 业务类型【供应链产品小类ID】
     */
    public String getBussType() {
        return bussType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 业务类型【供应链产品小类ID】
     */
    public void setBussType(String bussType) {
        this.bussType = bussType == null ? null : bussType.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 贷款种类
     */
    public String getLoanType() {
        return loanType;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 贷款种类
     */
    public void setLoanType(String loanType) {
        this.loanType = loanType == null ? null : loanType.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 开户行
     */
    public String getBankno() {
        return bankno;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 开户行
     */
    public void setBankno(String bankno) {
        this.bankno = bankno == null ? null : bankno.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 质权行
     */
    public String getBrcode2() {
        return brcode2;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 质权行
     */
    public void setBrcode2(String brcode2) {
        this.brcode2 = brcode2 == null ? null : brcode2.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 业务金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 业务金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
     * 获得 融资到期日期
     */
    public String getLoanDueDate() {
        return loanDueDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 融资到期日期
     */
    public void setLoanDueDate(String loanDueDate) {
        this.loanDueDate = loanDueDate == null ? null : loanDueDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 还款日期
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 还款日期
     */
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate == null ? null : returnDate.trim();
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
     * CHAR(500)<br>
     * 获得 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * CHAR(500)<br>
     * 设置 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 为通用日期时间，包含
出池日期、
入池日期、
承购日期、
核销日期
根据业务操作类型来确定。等等
     */
    public String getCommonDate() {
        return commonDate;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 为通用日期时间，包含
出池日期、
入池日期、
承购日期、
核销日期
根据业务操作类型来确定。等等
     */
    public void setCommonDate(String commonDate) {
        this.commonDate = commonDate;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 操作员ID
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 操作员ID
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
     * CHAR(1)<br>
     * 获得 利率类型【1-利息，2-融资，3-融资本息，4-无】
     */
    public String getReturnType() {
        return returnType;
    }

    /**
     * CHAR(1)<br>
     * 设置 利率类型【1-利息，2-融资，3-融资本息，4-无】
     */
    public void setReturnType(String returnType) {
        this.returnType = returnType == null ? null : returnType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 尾款是否进入卖方账户标志【1-是，2-否】
     */
    public String getToSallerFlag() {
        return toSallerFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 尾款是否进入卖方账户标志【1-是，2-否】
     */
    public void setToSallerFlag(String toSallerFlag) {
        this.toSallerFlag = toSallerFlag == null ? null : toSallerFlag.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 还款金额
     */
    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 还款金额
     */
    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
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
     * VARCHAR(50)<br>
     * 获得 账号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 账号
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 还款方式【1-买方付款，2-间接还款，3-卖方还款，4-担保付款，5-担保公司赔款】
     */
    public String getReturnMethod() {
        return returnMethod;
    }

    /**
     * CHAR(1)<br>
     * 设置 还款方式【1-买方付款，2-间接还款，3-卖方还款，4-担保付款，5-担保公司赔款】
     */
    public void setReturnMethod(String returnMethod) {
        this.returnMethod = returnMethod == null ? null : returnMethod.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 还息金额
     */
    public BigDecimal getReturnInterestAmount() {
        return returnInterestAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 还息金额
     */
    public void setReturnInterestAmount(BigDecimal returnInterestAmount) {
        this.returnInterestAmount = returnInterestAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 还本金额
     */
    public BigDecimal getReturnCapitalAmount() {
        return returnCapitalAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 还本金额
     */
    public void setReturnCapitalAmount(BigDecimal returnCapitalAmount) {
        this.returnCapitalAmount = returnCapitalAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 入卖方结算账号金额
     */
    public BigDecimal getToSallerAmount() {
        return toSallerAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 入卖方结算账号金额
     */
    public void setToSallerAmount(BigDecimal toSallerAmount) {
        this.toSallerAmount = toSallerAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 入现金池金额
     */
    public BigDecimal getToPoolAmount() {
        return toPoolAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 入现金池金额
     */
    public void setToPoolAmount(BigDecimal toPoolAmount) {
        this.toPoolAmount = toPoolAmount;
    }

    /**
     * VARCHAR(50)<br>
     * 获得 回款账号
     */
    public String getReturnAccount() {
        return returnAccount;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 回款账号
     */
    public void setReturnAccount(String returnAccount) {
        this.returnAccount = returnAccount == null ? null : returnAccount.trim();
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
     * CHAR(2)<br>
     * 获得 回款用途：01-入保证金、02-还贷、03-尾款
     */
    public String getRepayPurpose() {
        return repayPurpose;
    }

    /**
     * CHAR(2)<br>
     * 设置 回款用途：01-入保证金、02-还贷、03-尾款
     */
    public void setRepayPurpose(String repayPurpose) {
        this.repayPurpose = repayPurpose == null ? null : repayPurpose.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appno=").append(appno);
        sb.append(", applyType=").append(applyType);
        sb.append(", custcdSaller=").append(custcdSaller);
        sb.append(", custcdBuyer=").append(custcdBuyer);
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
        sb.append(", bankno=").append(bankno);
        sb.append(", brcode2=").append(brcode2);
        sb.append(", amount=").append(amount);
        sb.append(", appDate=").append(appDate);
        sb.append(", appLoanDate=").append(appLoanDate);
        sb.append(", loanDueDate=").append(loanDueDate);
        sb.append(", returnDate=").append(returnDate);
        sb.append(", curcd=").append(curcd);
        sb.append(", memo=").append(memo);
        sb.append(", commonDate=").append(commonDate);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", brcode=").append(brcode);
        sb.append(", returnType=").append(returnType);
        sb.append(", toSallerFlag=").append(toSallerFlag);
        sb.append(", returnAmount=").append(returnAmount);
        sb.append(", reason=").append(reason);
        sb.append(", otherReason=").append(otherReason);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", returnMethod=").append(returnMethod);
        sb.append(", returnInterestAmount=").append(returnInterestAmount);
        sb.append(", returnCapitalAmount=").append(returnCapitalAmount);
        sb.append(", toSallerAmount=").append(toSallerAmount);
        sb.append(", toPoolAmount=").append(toPoolAmount);
        sb.append(", returnAccount=").append(returnAccount);
        sb.append(", transactionNo=").append(transactionNo);
        sb.append(", tobailAmount=").append(tobailAmount);
        sb.append(", rebateAmount=").append(rebateAmount);
        sb.append(", returnAccountBalance=").append(returnAccountBalance);
        sb.append(", totalOverAmount=").append(totalOverAmount);
        sb.append(", assignRule=").append(assignRule);
        sb.append(", settleMethod=").append(settleMethod);
        sb.append(", repayPurpose=").append(repayPurpose);
        sb.append(", payer=").append(payer);
        sb.append(", payerAcctNo=").append(payerAcctNo);
        sb.append(", payerBank=").append(payerBank);
        sb.append(", transferAmt=").append(transferAmt);
        sb.append(", transactionDate=").append(transactionDate);
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
        RBcpDebtBussInfo other = (RBcpDebtBussInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getApplyType() == null ? other.getApplyType() == null : this.getApplyType().equals(other.getApplyType()))
            && (this.getCustcdSaller() == null ? other.getCustcdSaller() == null : this.getCustcdSaller().equals(other.getCustcdSaller()))
            && (this.getCustcdBuyer() == null ? other.getCustcdBuyer() == null : this.getCustcdBuyer().equals(other.getCustcdBuyer()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getInsertDate() == null ? other.getInsertDate() == null : this.getInsertDate().equals(other.getInsertDate()))
            && (this.getPurchaseDate() == null ? other.getPurchaseDate() == null : this.getPurchaseDate().equals(other.getPurchaseDate()))
            && (this.getDebtNum() == null ? other.getDebtNum() == null : this.getDebtNum().equals(other.getDebtNum()))
            && (this.getTotalDebtAmount() == null ? other.getTotalDebtAmount() == null : this.getTotalDebtAmount().equals(other.getTotalDebtAmount()))
            && (this.getChargeType() == null ? other.getChargeType() == null : this.getChargeType().equals(other.getChargeType()))
            && (this.getFinacingDiscountType() == null ? other.getFinacingDiscountType() == null : this.getFinacingDiscountType().equals(other.getFinacingDiscountType()))
            && (this.getFinacingCost() == null ? other.getFinacingCost() == null : this.getFinacingCost().equals(other.getFinacingCost()))
            && (this.getCost() == null ? other.getCost() == null : this.getCost().equals(other.getCost()))
            && (this.getHandlingFee() == null ? other.getHandlingFee() == null : this.getHandlingFee().equals(other.getHandlingFee()))
            && (this.getReduceAmount() == null ? other.getReduceAmount() == null : this.getReduceAmount().equals(other.getReduceAmount()))
            && (this.getTotalFee() == null ? other.getTotalFee() == null : this.getTotalFee().equals(other.getTotalFee()))
            && (this.getTotalReduce() == null ? other.getTotalReduce() == null : this.getTotalReduce().equals(other.getTotalReduce()))
            && (this.getReceiveAmount() == null ? other.getReceiveAmount() == null : this.getReceiveAmount().equals(other.getReceiveAmount()))
            && (this.getCostAccount() == null ? other.getCostAccount() == null : this.getCostAccount().equals(other.getCostAccount()))
            && (this.getPayDayMonth() == null ? other.getPayDayMonth() == null : this.getPayDayMonth().equals(other.getPayDayMonth()))
            && (this.getRateCollectType() == null ? other.getRateCollectType() == null : this.getRateCollectType().equals(other.getRateCollectType()))
            && (this.getOverDueRate() == null ? other.getOverDueRate() == null : this.getOverDueRate().equals(other.getOverDueRate()))
            && (this.getExecuteRate() == null ? other.getExecuteRate() == null : this.getExecuteRate().equals(other.getExecuteRate()))
            && (this.getUpDownPercent() == null ? other.getUpDownPercent() == null : this.getUpDownPercent().equals(other.getUpDownPercent()))
            && (this.getUpDown() == null ? other.getUpDown() == null : this.getUpDown().equals(other.getUpDown()))
            && (this.getBaseRate() == null ? other.getBaseRate() == null : this.getBaseRate().equals(other.getBaseRate()))
            && (this.getRateId() == null ? other.getRateId() == null : this.getRateId().equals(other.getRateId()))
            && (this.getRateType() == null ? other.getRateType() == null : this.getRateType().equals(other.getRateType()))
            && (this.getBussType() == null ? other.getBussType() == null : this.getBussType().equals(other.getBussType()))
            && (this.getLoanType() == null ? other.getLoanType() == null : this.getLoanType().equals(other.getLoanType()))
            && (this.getBankno() == null ? other.getBankno() == null : this.getBankno().equals(other.getBankno()))
            && (this.getBrcode2() == null ? other.getBrcode2() == null : this.getBrcode2().equals(other.getBrcode2()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getAppDate() == null ? other.getAppDate() == null : this.getAppDate().equals(other.getAppDate()))
            && (this.getAppLoanDate() == null ? other.getAppLoanDate() == null : this.getAppLoanDate().equals(other.getAppLoanDate()))
            && (this.getLoanDueDate() == null ? other.getLoanDueDate() == null : this.getLoanDueDate().equals(other.getLoanDueDate()))
            && (this.getReturnDate() == null ? other.getReturnDate() == null : this.getReturnDate().equals(other.getReturnDate()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getCommonDate() == null ? other.getCommonDate() == null : this.getCommonDate().equals(other.getCommonDate()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getReturnType() == null ? other.getReturnType() == null : this.getReturnType().equals(other.getReturnType()))
            && (this.getToSallerFlag() == null ? other.getToSallerFlag() == null : this.getToSallerFlag().equals(other.getToSallerFlag()))
            && (this.getReturnAmount() == null ? other.getReturnAmount() == null : this.getReturnAmount().equals(other.getReturnAmount()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getOtherReason() == null ? other.getOtherReason() == null : this.getOtherReason().equals(other.getOtherReason()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getReturnMethod() == null ? other.getReturnMethod() == null : this.getReturnMethod().equals(other.getReturnMethod()))
            && (this.getReturnInterestAmount() == null ? other.getReturnInterestAmount() == null : this.getReturnInterestAmount().equals(other.getReturnInterestAmount()))
            && (this.getReturnCapitalAmount() == null ? other.getReturnCapitalAmount() == null : this.getReturnCapitalAmount().equals(other.getReturnCapitalAmount()))
            && (this.getToSallerAmount() == null ? other.getToSallerAmount() == null : this.getToSallerAmount().equals(other.getToSallerAmount()))
            && (this.getToPoolAmount() == null ? other.getToPoolAmount() == null : this.getToPoolAmount().equals(other.getToPoolAmount()))
            && (this.getReturnAccount() == null ? other.getReturnAccount() == null : this.getReturnAccount().equals(other.getReturnAccount()))
            && (this.getTransactionNo() == null ? other.getTransactionNo() == null : this.getTransactionNo().equals(other.getTransactionNo()))
            && (this.getTobailAmount() == null ? other.getTobailAmount() == null : this.getTobailAmount().equals(other.getTobailAmount()))
            && (this.getRebateAmount() == null ? other.getRebateAmount() == null : this.getRebateAmount().equals(other.getRebateAmount()))
            && (this.getReturnAccountBalance() == null ? other.getReturnAccountBalance() == null : this.getReturnAccountBalance().equals(other.getReturnAccountBalance()))
            && (this.getTotalOverAmount() == null ? other.getTotalOverAmount() == null : this.getTotalOverAmount().equals(other.getTotalOverAmount()))
            && (this.getAssignRule() == null ? other.getAssignRule() == null : this.getAssignRule().equals(other.getAssignRule()))
            && (this.getSettleMethod() == null ? other.getSettleMethod() == null : this.getSettleMethod().equals(other.getSettleMethod()))
            && (this.getRepayPurpose() == null ? other.getRepayPurpose() == null : this.getRepayPurpose().equals(other.getRepayPurpose()))
            && (this.getPayer() == null ? other.getPayer() == null : this.getPayer().equals(other.getPayer()))
            && (this.getPayerAcctNo() == null ? other.getPayerAcctNo() == null : this.getPayerAcctNo().equals(other.getPayerAcctNo()))
            && (this.getPayerBank() == null ? other.getPayerBank() == null : this.getPayerBank().equals(other.getPayerBank()))
            && (this.getTransferAmt() == null ? other.getTransferAmt() == null : this.getTransferAmt().equals(other.getTransferAmt()))
            && (this.getTransactionDate() == null ? other.getTransactionDate() == null : this.getTransactionDate().equals(other.getTransactionDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getApplyType() == null) ? 0 : getApplyType().hashCode());
        result = prime * result + ((getCustcdSaller() == null) ? 0 : getCustcdSaller().hashCode());
        result = prime * result + ((getCustcdBuyer() == null) ? 0 : getCustcdBuyer().hashCode());
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
        result = prime * result + ((getBankno() == null) ? 0 : getBankno().hashCode());
        result = prime * result + ((getBrcode2() == null) ? 0 : getBrcode2().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getAppDate() == null) ? 0 : getAppDate().hashCode());
        result = prime * result + ((getAppLoanDate() == null) ? 0 : getAppLoanDate().hashCode());
        result = prime * result + ((getLoanDueDate() == null) ? 0 : getLoanDueDate().hashCode());
        result = prime * result + ((getReturnDate() == null) ? 0 : getReturnDate().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getCommonDate() == null) ? 0 : getCommonDate().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getReturnType() == null) ? 0 : getReturnType().hashCode());
        result = prime * result + ((getToSallerFlag() == null) ? 0 : getToSallerFlag().hashCode());
        result = prime * result + ((getReturnAmount() == null) ? 0 : getReturnAmount().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getOtherReason() == null) ? 0 : getOtherReason().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getReturnMethod() == null) ? 0 : getReturnMethod().hashCode());
        result = prime * result + ((getReturnInterestAmount() == null) ? 0 : getReturnInterestAmount().hashCode());
        result = prime * result + ((getReturnCapitalAmount() == null) ? 0 : getReturnCapitalAmount().hashCode());
        result = prime * result + ((getToSallerAmount() == null) ? 0 : getToSallerAmount().hashCode());
        result = prime * result + ((getToPoolAmount() == null) ? 0 : getToPoolAmount().hashCode());
        result = prime * result + ((getReturnAccount() == null) ? 0 : getReturnAccount().hashCode());
        result = prime * result + ((getTransactionNo() == null) ? 0 : getTransactionNo().hashCode());
        result = prime * result + ((getTobailAmount() == null) ? 0 : getTobailAmount().hashCode());
        result = prime * result + ((getRebateAmount() == null) ? 0 : getRebateAmount().hashCode());
        result = prime * result + ((getReturnAccountBalance() == null) ? 0 : getReturnAccountBalance().hashCode());
        result = prime * result + ((getTotalOverAmount() == null) ? 0 : getTotalOverAmount().hashCode());
        result = prime * result + ((getAssignRule() == null) ? 0 : getAssignRule().hashCode());
        result = prime * result + ((getSettleMethod() == null) ? 0 : getSettleMethod().hashCode());
        result = prime * result + ((getRepayPurpose() == null) ? 0 : getRepayPurpose().hashCode());
        result = prime * result + ((getPayer() == null) ? 0 : getPayer().hashCode());
        result = prime * result + ((getPayerAcctNo() == null) ? 0 : getPayerAcctNo().hashCode());
        result = prime * result + ((getPayerBank() == null) ? 0 : getPayerBank().hashCode());
        result = prime * result + ((getTransferAmt() == null) ? 0 : getTransferAmt().hashCode());
        result = prime * result + ((getTransactionDate() == null) ? 0 : getTransactionDate().hashCode());
        return result;
    }
}
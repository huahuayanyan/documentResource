package com.huateng.scf.bas.lan.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BLanAppliLnciBase implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 业务申请号
     */
    private String appno;

    /**
     * VARCHAR(32)<br>
     * 自动生成的数字主键
     */
    private String debetNo;

    /**
     * VARCHAR(100)<br>
     * 借据号/承兑协议号
     */
    private String debetId;

    /**
     * VARCHAR(20)<br>
     * 主合同号
     */
    private String mastContno;

    /**
     * CHAR(2)<br>
     * 借据类型：01-流贷、02-银承
     */
    private String lnciType;

    /**
     * CHAR(2)<br>
     * 借据状态
     */
    private String lnciStatus;

    /**
     * DECIMAL(16,2)<br>
     * 借据金额/出票金额
     */
    private BigDecimal lnciAmt;

    /**
     * DECIMAL(16,2)<br>
     * 借据余额
     */
    private BigDecimal lnciBal;

    /**
     * CHAR(2)<br>
     * 贷款五级分类
     */
    private String fivelevel;

    /**
     * CHAR(2)<br>
     * 贷款形态
     */
    private String loanType;

    /**
     * CHAR(8)<br>
     * 起息日期/出票日期
     */
    private String startDate;

    /**
     * CHAR(8)<br>
     * 到期日期/票据到期日
     */
    private String endDate;

    /**
     * VARCHAR(32)<br>
     * 客户经理
     */
    private String mgrno;

    /**
     * DECIMAL(16,2)<br>
     * 初始保证金金额
     */
    private BigDecimal bailAmount;

    /**
     * DECIMAL(16,2)<br>
     * 最低保证金比例(%)
     */
    private BigDecimal firstBailRatio;

    /**
     * VARCHAR(100)<br>
     * 订单号
     */
    private String orderNo;

    /**
     * VARCHAR(50)<br>
     * 结算账号
     */
    private String accountNo;

    /**
     * CHAR(1)<br>
     * 出票方式
     */
    private String billType;

    /**
     * VARCHAR(50)<br>
     * 保证金账号
     */
    private String bailAccount;

    /**
     * DECIMAL(22)<br>
     * 出票笔数
     */
    private BigDecimal billNum;

    /**
     * VARCHAR(10)<br>
     * 融资天数
     */
    private String loanDays;

    /**
     * DECIMAL(16,2)<br>
     * 追加保证金金额
     */
    private BigDecimal addBailAmount;

    /**
     * CHAR(1)<br>
     * 借据确认收款/票状态：0-未收到、1-已收到
     */
    private String confirmStatus;

    /**
     * DECIMAL(16,2)<br>
     * 保证金总金额
     */
    private BigDecimal totalBailAmount;

    /**
     * VARCHAR(6)<br>
     * 填平敞口期限(天)
     */
    private String slaveLimit;

    /**
     * VARCHAR(20)<br>
     * 抵质押合同号
     */
    private String slaveContno;

    /**
     * DECIMAL(16,2)<br>
     * 追加现金等价物金额
     */
    private BigDecimal addCashEqtAmt;

    /**
     * DECIMAL(16,2)<br>
     * 初始现金等价物金额
     */
    private BigDecimal initCashEqtAmt;

    /**
     * DECIMAL(16,2)<br>
     * 剩余提货金额
     */
    private BigDecimal amountIn;

    /**
     * DECIMAL(16,2)<br>
     * 累计提货金额
     */
    private BigDecimal amountOut;

    /**
     * DECIMAL(16,2)<br>
     * 累计向上游厂商提货金额
     */
    private BigDecimal amountUpOut;

    /**
     * VARCHAR(20)<br>
     * 通知书编号
     */
    private String num;

    /**
     * VARCHAR(20)<br>
     * 经办机构/申请机构号
     */
    private String bussBrcode;

    /**
     * DECIMAL(10,6)<br>
     * 执行利率
     */
    private BigDecimal rate;

    /**
     * VARCHAR(10)<br>
     * 还款方式
     */
    private String repayMethod;

    /**
     * DECIMAL(22)<br>
     * 宽限期(天)
     */
    private BigDecimal graceDays;

    /**
     * VARCHAR(200)<br>
     * 贷款用途
     */
    private String loanUse;

    /**
     * VARCHAR(10)<br>
     * 利率类型
     */
    private String rateType;

    /**
     * VARCHAR(10)<br>
     * 利率浮动方式
     */
    private String rateFloatType;

    /**
     * DECIMAL(10,6)<br>
     * 利率浮动值
     */
    private BigDecimal rateFloatValue;

    /**
     * DECIMAL(10,6)<br>
     * 基准年利率
     */
    private BigDecimal baseYearRate;

    /**
     * VARCHAR(10)<br>
     * 浮动利率调整方式
     */
    private String rateAdjustType;

    /**
     * VARCHAR(20)<br>
     * 协议号
     */
    private String protocolNo;

    /**
     * VARCHAR(20)<br>
     * 承兑机构号
     */
    private String draftBrcode;

    /**
     * VARCHAR(20)<br>
     * 签发机构号
     */
    private String signBrcode;

    /**
     * VARCHAR(20)<br>
     * 垫款机构号
     */
    private String prePayBrcode;

    /**
     * CHAR(1)<br>
     * 电票标志：0-否、1-是
     */
    private String ebFlag;

    /**
     * DECIMAL(16,2)<br>
     * 本笔风险敞口
     */
    private BigDecimal riskAmt;

    /**
     * DECIMAL(16,2)<br>
     * 可融资金额
     */
    private BigDecimal avaliableAmt;

    /**
     * VARCHAR(20)<br>
     * 入账机构
     */
    private String acctBrcode;

    /**
     * VARCHAR(100)<br>
     * 信贷合同号
     */
    private String mastContcode;

    /**
     * VARCHAR(10)<br>
     * 业务品种
     */
    private String productId;

    /**
     * VARCHAR(15)<br>
     * 客户号
     */
    private String custcd;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * VARCHAR(10)<br>
     * 间接额度类型：有、无
     */
    private String hasIndirectCredit;

    /**
     * VARCHAR(15)<br>
     * 间接额度占用方客户号
     */
    private String creditCustcd;

    /**
     * VARCHAR(15)<br>
     * 其他客户号(保理买方等)
     */
    private String otherCustcd;

    /**
     * VARCHAR(100)<br>
     * 原借据号
     */
    private String orgDebetId;

    /**
     * DECIMAL(22)<br>
     * 赎货期限(天)
     */
    private BigDecimal drawbackTerm;

    /**
     * VARCHAR(50)<br>
     * 融资出账流水号
     */
    private String loanAppno;

    /**
     * VARCHAR(10)<br>
     * 产品代码
     */
    private String productCode;

    /**
     * CHAR(1)<br>
     * 记录状态：0-正常、1-删除
     */
    private String state;

    /**
     * VARCHAR(20)<br>
     * 占用额度编号
     */
    private String creditNo;

    /**
     * DECIMAL(16,2)<br>
     * 自有资金支付金额
     */
    private BigDecimal ownFundPayAmt;

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
     * VARCHAR(20)<br>
     * 获得 业务申请号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 业务申请号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 自动生成的数字主键
     */
    public String getDebetNo() {
        return debetNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 自动生成的数字主键
     */
    public void setDebetNo(String debetNo) {
        this.debetNo = debetNo == null ? null : debetNo.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 借据号/承兑协议号
     */
    public String getDebetId() {
        return debetId;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 借据号/承兑协议号
     */
    public void setDebetId(String debetId) {
        this.debetId = debetId == null ? null : debetId.trim();
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
     * CHAR(2)<br>
     * 获得 借据类型：01-流贷、02-银承
     */
    public String getLnciType() {
        return lnciType;
    }

    /**
     * CHAR(2)<br>
     * 设置 借据类型：01-流贷、02-银承
     */
    public void setLnciType(String lnciType) {
        this.lnciType = lnciType == null ? null : lnciType.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 借据状态
     */
    public String getLnciStatus() {
        return lnciStatus;
    }

    /**
     * CHAR(2)<br>
     * 设置 借据状态
     */
    public void setLnciStatus(String lnciStatus) {
        this.lnciStatus = lnciStatus == null ? null : lnciStatus.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 借据金额/出票金额
     */
    public BigDecimal getLnciAmt() {
        return lnciAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 借据金额/出票金额
     */
    public void setLnciAmt(BigDecimal lnciAmt) {
        this.lnciAmt = lnciAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 借据余额
     */
    public BigDecimal getLnciBal() {
        return lnciBal;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 借据余额
     */
    public void setLnciBal(BigDecimal lnciBal) {
        this.lnciBal = lnciBal;
    }

    /**
     * CHAR(2)<br>
     * 获得 贷款五级分类
     */
    public String getFivelevel() {
        return fivelevel;
    }

    /**
     * CHAR(2)<br>
     * 设置 贷款五级分类
     */
    public void setFivelevel(String fivelevel) {
        this.fivelevel = fivelevel == null ? null : fivelevel.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 贷款形态
     */
    public String getLoanType() {
        return loanType;
    }

    /**
     * CHAR(2)<br>
     * 设置 贷款形态
     */
    public void setLoanType(String loanType) {
        this.loanType = loanType == null ? null : loanType.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 起息日期/出票日期
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 起息日期/出票日期
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 到期日期/票据到期日
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 到期日期/票据到期日
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 客户经理
     */
    public String getMgrno() {
        return mgrno;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 客户经理
     */
    public void setMgrno(String mgrno) {
        this.mgrno = mgrno == null ? null : mgrno.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 初始保证金金额
     */
    public BigDecimal getBailAmount() {
        return bailAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 初始保证金金额
     */
    public void setBailAmount(BigDecimal bailAmount) {
        this.bailAmount = bailAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 最低保证金比例(%)
     */
    public BigDecimal getFirstBailRatio() {
        return firstBailRatio;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 最低保证金比例(%)
     */
    public void setFirstBailRatio(BigDecimal firstBailRatio) {
        this.firstBailRatio = firstBailRatio;
    }

    /**
     * VARCHAR(100)<br>
     * 获得 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
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
     * CHAR(1)<br>
     * 获得 出票方式
     */
    public String getBillType() {
        return billType;
    }

    /**
     * CHAR(1)<br>
     * 设置 出票方式
     */
    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
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
     * DECIMAL(22)<br>
     * 获得 出票笔数
     */
    public BigDecimal getBillNum() {
        return billNum;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 出票笔数
     */
    public void setBillNum(BigDecimal billNum) {
        this.billNum = billNum;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 融资天数
     */
    public String getLoanDays() {
        return loanDays;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 融资天数
     */
    public void setLoanDays(String loanDays) {
        this.loanDays = loanDays == null ? null : loanDays.trim();
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
     * 获得 借据确认收款/票状态：0-未收到、1-已收到
     */
    public String getConfirmStatus() {
        return confirmStatus;
    }

    /**
     * CHAR(1)<br>
     * 设置 借据确认收款/票状态：0-未收到、1-已收到
     */
    public void setConfirmStatus(String confirmStatus) {
        this.confirmStatus = confirmStatus == null ? null : confirmStatus.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 保证金总金额
     */
    public BigDecimal getTotalBailAmount() {
        return totalBailAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 保证金总金额
     */
    public void setTotalBailAmount(BigDecimal totalBailAmount) {
        this.totalBailAmount = totalBailAmount;
    }

    /**
     * VARCHAR(6)<br>
     * 获得 填平敞口期限(天)
     */
    public String getSlaveLimit() {
        return slaveLimit;
    }

    /**
     * VARCHAR(6)<br>
     * 设置 填平敞口期限(天)
     */
    public void setSlaveLimit(String slaveLimit) {
        this.slaveLimit = slaveLimit == null ? null : slaveLimit.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 抵质押合同号
     */
    public String getSlaveContno() {
        return slaveContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 抵质押合同号
     */
    public void setSlaveContno(String slaveContno) {
        this.slaveContno = slaveContno == null ? null : slaveContno.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 追加现金等价物金额
     */
    public BigDecimal getAddCashEqtAmt() {
        return addCashEqtAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 追加现金等价物金额
     */
    public void setAddCashEqtAmt(BigDecimal addCashEqtAmt) {
        this.addCashEqtAmt = addCashEqtAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 初始现金等价物金额
     */
    public BigDecimal getInitCashEqtAmt() {
        return initCashEqtAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 初始现金等价物金额
     */
    public void setInitCashEqtAmt(BigDecimal initCashEqtAmt) {
        this.initCashEqtAmt = initCashEqtAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 剩余提货金额
     */
    public BigDecimal getAmountIn() {
        return amountIn;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 剩余提货金额
     */
    public void setAmountIn(BigDecimal amountIn) {
        this.amountIn = amountIn;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 累计提货金额
     */
    public BigDecimal getAmountOut() {
        return amountOut;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 累计提货金额
     */
    public void setAmountOut(BigDecimal amountOut) {
        this.amountOut = amountOut;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 累计向上游厂商提货金额
     */
    public BigDecimal getAmountUpOut() {
        return amountUpOut;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 累计向上游厂商提货金额
     */
    public void setAmountUpOut(BigDecimal amountUpOut) {
        this.amountUpOut = amountUpOut;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 通知书编号
     */
    public String getNum() {
        return num;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 通知书编号
     */
    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 经办机构/申请机构号
     */
    public String getBussBrcode() {
        return bussBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 经办机构/申请机构号
     */
    public void setBussBrcode(String bussBrcode) {
        this.bussBrcode = bussBrcode == null ? null : bussBrcode.trim();
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 执行利率
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 执行利率
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 还款方式
     */
    public String getRepayMethod() {
        return repayMethod;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 还款方式
     */
    public void setRepayMethod(String repayMethod) {
        this.repayMethod = repayMethod == null ? null : repayMethod.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 宽限期(天)
     */
    public BigDecimal getGraceDays() {
        return graceDays;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 宽限期(天)
     */
    public void setGraceDays(BigDecimal graceDays) {
        this.graceDays = graceDays;
    }

    /**
     * VARCHAR(200)<br>
     * 获得 贷款用途
     */
    public String getLoanUse() {
        return loanUse;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 贷款用途
     */
    public void setLoanUse(String loanUse) {
        this.loanUse = loanUse == null ? null : loanUse.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 利率类型
     */
    public String getRateType() {
        return rateType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 利率类型
     */
    public void setRateType(String rateType) {
        this.rateType = rateType == null ? null : rateType.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 利率浮动方式
     */
    public String getRateFloatType() {
        return rateFloatType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 利率浮动方式
     */
    public void setRateFloatType(String rateFloatType) {
        this.rateFloatType = rateFloatType == null ? null : rateFloatType.trim();
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 利率浮动值
     */
    public BigDecimal getRateFloatValue() {
        return rateFloatValue;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 利率浮动值
     */
    public void setRateFloatValue(BigDecimal rateFloatValue) {
        this.rateFloatValue = rateFloatValue;
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 基准年利率
     */
    public BigDecimal getBaseYearRate() {
        return baseYearRate;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 基准年利率
     */
    public void setBaseYearRate(BigDecimal baseYearRate) {
        this.baseYearRate = baseYearRate;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 浮动利率调整方式
     */
    public String getRateAdjustType() {
        return rateAdjustType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 浮动利率调整方式
     */
    public void setRateAdjustType(String rateAdjustType) {
        this.rateAdjustType = rateAdjustType == null ? null : rateAdjustType.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 协议号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 协议号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 承兑机构号
     */
    public String getDraftBrcode() {
        return draftBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 承兑机构号
     */
    public void setDraftBrcode(String draftBrcode) {
        this.draftBrcode = draftBrcode == null ? null : draftBrcode.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 签发机构号
     */
    public String getSignBrcode() {
        return signBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 签发机构号
     */
    public void setSignBrcode(String signBrcode) {
        this.signBrcode = signBrcode == null ? null : signBrcode.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 垫款机构号
     */
    public String getPrePayBrcode() {
        return prePayBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 垫款机构号
     */
    public void setPrePayBrcode(String prePayBrcode) {
        this.prePayBrcode = prePayBrcode == null ? null : prePayBrcode.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 电票标志：0-否、1-是
     */
    public String getEbFlag() {
        return ebFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 电票标志：0-否、1-是
     */
    public void setEbFlag(String ebFlag) {
        this.ebFlag = ebFlag == null ? null : ebFlag.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 本笔风险敞口
     */
    public BigDecimal getRiskAmt() {
        return riskAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 本笔风险敞口
     */
    public void setRiskAmt(BigDecimal riskAmt) {
        this.riskAmt = riskAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 可融资金额
     */
    public BigDecimal getAvaliableAmt() {
        return avaliableAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 可融资金额
     */
    public void setAvaliableAmt(BigDecimal avaliableAmt) {
        this.avaliableAmt = avaliableAmt;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 入账机构
     */
    public String getAcctBrcode() {
        return acctBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 入账机构
     */
    public void setAcctBrcode(String acctBrcode) {
        this.acctBrcode = acctBrcode == null ? null : acctBrcode.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 信贷合同号
     */
    public String getMastContcode() {
        return mastContcode;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 信贷合同号
     */
    public void setMastContcode(String mastContcode) {
        this.mastContcode = mastContcode == null ? null : mastContcode.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 业务品种
     */
    public String getProductId() {
        return productId;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 业务品种
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
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
     * VARCHAR(10)<br>
     * 获得 间接额度类型：有、无
     */
    public String getHasIndirectCredit() {
        return hasIndirectCredit;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 间接额度类型：有、无
     */
    public void setHasIndirectCredit(String hasIndirectCredit) {
        this.hasIndirectCredit = hasIndirectCredit == null ? null : hasIndirectCredit.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 间接额度占用方客户号
     */
    public String getCreditCustcd() {
        return creditCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 间接额度占用方客户号
     */
    public void setCreditCustcd(String creditCustcd) {
        this.creditCustcd = creditCustcd == null ? null : creditCustcd.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 其他客户号(保理买方等)
     */
    public String getOtherCustcd() {
        return otherCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 其他客户号(保理买方等)
     */
    public void setOtherCustcd(String otherCustcd) {
        this.otherCustcd = otherCustcd == null ? null : otherCustcd.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 原借据号
     */
    public String getOrgDebetId() {
        return orgDebetId;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 原借据号
     */
    public void setOrgDebetId(String orgDebetId) {
        this.orgDebetId = orgDebetId == null ? null : orgDebetId.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 赎货期限(天)
     */
    public BigDecimal getDrawbackTerm() {
        return drawbackTerm;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 赎货期限(天)
     */
    public void setDrawbackTerm(BigDecimal drawbackTerm) {
        this.drawbackTerm = drawbackTerm;
    }

    /**
     * VARCHAR(50)<br>
     * 获得 融资出账流水号
     */
    public String getLoanAppno() {
        return loanAppno;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 融资出账流水号
     */
    public void setLoanAppno(String loanAppno) {
        this.loanAppno = loanAppno == null ? null : loanAppno.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 产品代码
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 产品代码
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 记录状态：0-正常、1-删除
     */
    public String getState() {
        return state;
    }

    /**
     * CHAR(1)<br>
     * 设置 记录状态：0-正常、1-删除
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 占用额度编号
     */
    public String getCreditNo() {
        return creditNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 占用额度编号
     */
    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo == null ? null : creditNo.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 自有资金支付金额
     */
    public BigDecimal getOwnFundPayAmt() {
        return ownFundPayAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 自有资金支付金额
     */
    public void setOwnFundPayAmt(BigDecimal ownFundPayAmt) {
        this.ownFundPayAmt = ownFundPayAmt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appno=").append(appno);
        sb.append(", debetNo=").append(debetNo);
        sb.append(", debetId=").append(debetId);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", lnciType=").append(lnciType);
        sb.append(", lnciStatus=").append(lnciStatus);
        sb.append(", lnciAmt=").append(lnciAmt);
        sb.append(", lnciBal=").append(lnciBal);
        sb.append(", fivelevel=").append(fivelevel);
        sb.append(", loanType=").append(loanType);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", mgrno=").append(mgrno);
        sb.append(", bailAmount=").append(bailAmount);
        sb.append(", firstBailRatio=").append(firstBailRatio);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", billType=").append(billType);
        sb.append(", bailAccount=").append(bailAccount);
        sb.append(", billNum=").append(billNum);
        sb.append(", loanDays=").append(loanDays);
        sb.append(", addBailAmount=").append(addBailAmount);
        sb.append(", confirmStatus=").append(confirmStatus);
        sb.append(", totalBailAmount=").append(totalBailAmount);
        sb.append(", slaveLimit=").append(slaveLimit);
        sb.append(", slaveContno=").append(slaveContno);
        sb.append(", addCashEqtAmt=").append(addCashEqtAmt);
        sb.append(", initCashEqtAmt=").append(initCashEqtAmt);
        sb.append(", amountIn=").append(amountIn);
        sb.append(", amountOut=").append(amountOut);
        sb.append(", amountUpOut=").append(amountUpOut);
        sb.append(", num=").append(num);
        sb.append(", bussBrcode=").append(bussBrcode);
        sb.append(", rate=").append(rate);
        sb.append(", repayMethod=").append(repayMethod);
        sb.append(", graceDays=").append(graceDays);
        sb.append(", loanUse=").append(loanUse);
        sb.append(", rateType=").append(rateType);
        sb.append(", rateFloatType=").append(rateFloatType);
        sb.append(", rateFloatValue=").append(rateFloatValue);
        sb.append(", baseYearRate=").append(baseYearRate);
        sb.append(", rateAdjustType=").append(rateAdjustType);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", draftBrcode=").append(draftBrcode);
        sb.append(", signBrcode=").append(signBrcode);
        sb.append(", prePayBrcode=").append(prePayBrcode);
        sb.append(", ebFlag=").append(ebFlag);
        sb.append(", riskAmt=").append(riskAmt);
        sb.append(", avaliableAmt=").append(avaliableAmt);
        sb.append(", acctBrcode=").append(acctBrcode);
        sb.append(", mastContcode=").append(mastContcode);
        sb.append(", productId=").append(productId);
        sb.append(", custcd=").append(custcd);
        sb.append(", curcd=").append(curcd);
        sb.append(", hasIndirectCredit=").append(hasIndirectCredit);
        sb.append(", creditCustcd=").append(creditCustcd);
        sb.append(", otherCustcd=").append(otherCustcd);
        sb.append(", orgDebetId=").append(orgDebetId);
        sb.append(", drawbackTerm=").append(drawbackTerm);
        sb.append(", loanAppno=").append(loanAppno);
        sb.append(", productCode=").append(productCode);
        sb.append(", state=").append(state);
        sb.append(", creditNo=").append(creditNo);
        sb.append(", ownFundPayAmt=").append(ownFundPayAmt);
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
        BLanAppliLnciBase other = (BLanAppliLnciBase) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getDebetNo() == null ? other.getDebetNo() == null : this.getDebetNo().equals(other.getDebetNo()))
            && (this.getDebetId() == null ? other.getDebetId() == null : this.getDebetId().equals(other.getDebetId()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getLnciType() == null ? other.getLnciType() == null : this.getLnciType().equals(other.getLnciType()))
            && (this.getLnciStatus() == null ? other.getLnciStatus() == null : this.getLnciStatus().equals(other.getLnciStatus()))
            && (this.getLnciAmt() == null ? other.getLnciAmt() == null : this.getLnciAmt().equals(other.getLnciAmt()))
            && (this.getLnciBal() == null ? other.getLnciBal() == null : this.getLnciBal().equals(other.getLnciBal()))
            && (this.getFivelevel() == null ? other.getFivelevel() == null : this.getFivelevel().equals(other.getFivelevel()))
            && (this.getLoanType() == null ? other.getLoanType() == null : this.getLoanType().equals(other.getLoanType()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getMgrno() == null ? other.getMgrno() == null : this.getMgrno().equals(other.getMgrno()))
            && (this.getBailAmount() == null ? other.getBailAmount() == null : this.getBailAmount().equals(other.getBailAmount()))
            && (this.getFirstBailRatio() == null ? other.getFirstBailRatio() == null : this.getFirstBailRatio().equals(other.getFirstBailRatio()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getBillType() == null ? other.getBillType() == null : this.getBillType().equals(other.getBillType()))
            && (this.getBailAccount() == null ? other.getBailAccount() == null : this.getBailAccount().equals(other.getBailAccount()))
            && (this.getBillNum() == null ? other.getBillNum() == null : this.getBillNum().equals(other.getBillNum()))
            && (this.getLoanDays() == null ? other.getLoanDays() == null : this.getLoanDays().equals(other.getLoanDays()))
            && (this.getAddBailAmount() == null ? other.getAddBailAmount() == null : this.getAddBailAmount().equals(other.getAddBailAmount()))
            && (this.getConfirmStatus() == null ? other.getConfirmStatus() == null : this.getConfirmStatus().equals(other.getConfirmStatus()))
            && (this.getTotalBailAmount() == null ? other.getTotalBailAmount() == null : this.getTotalBailAmount().equals(other.getTotalBailAmount()))
            && (this.getSlaveLimit() == null ? other.getSlaveLimit() == null : this.getSlaveLimit().equals(other.getSlaveLimit()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
            && (this.getAddCashEqtAmt() == null ? other.getAddCashEqtAmt() == null : this.getAddCashEqtAmt().equals(other.getAddCashEqtAmt()))
            && (this.getInitCashEqtAmt() == null ? other.getInitCashEqtAmt() == null : this.getInitCashEqtAmt().equals(other.getInitCashEqtAmt()))
            && (this.getAmountIn() == null ? other.getAmountIn() == null : this.getAmountIn().equals(other.getAmountIn()))
            && (this.getAmountOut() == null ? other.getAmountOut() == null : this.getAmountOut().equals(other.getAmountOut()))
            && (this.getAmountUpOut() == null ? other.getAmountUpOut() == null : this.getAmountUpOut().equals(other.getAmountUpOut()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getBussBrcode() == null ? other.getBussBrcode() == null : this.getBussBrcode().equals(other.getBussBrcode()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
            && (this.getRepayMethod() == null ? other.getRepayMethod() == null : this.getRepayMethod().equals(other.getRepayMethod()))
            && (this.getGraceDays() == null ? other.getGraceDays() == null : this.getGraceDays().equals(other.getGraceDays()))
            && (this.getLoanUse() == null ? other.getLoanUse() == null : this.getLoanUse().equals(other.getLoanUse()))
            && (this.getRateType() == null ? other.getRateType() == null : this.getRateType().equals(other.getRateType()))
            && (this.getRateFloatType() == null ? other.getRateFloatType() == null : this.getRateFloatType().equals(other.getRateFloatType()))
            && (this.getRateFloatValue() == null ? other.getRateFloatValue() == null : this.getRateFloatValue().equals(other.getRateFloatValue()))
            && (this.getBaseYearRate() == null ? other.getBaseYearRate() == null : this.getBaseYearRate().equals(other.getBaseYearRate()))
            && (this.getRateAdjustType() == null ? other.getRateAdjustType() == null : this.getRateAdjustType().equals(other.getRateAdjustType()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getDraftBrcode() == null ? other.getDraftBrcode() == null : this.getDraftBrcode().equals(other.getDraftBrcode()))
            && (this.getSignBrcode() == null ? other.getSignBrcode() == null : this.getSignBrcode().equals(other.getSignBrcode()))
            && (this.getPrePayBrcode() == null ? other.getPrePayBrcode() == null : this.getPrePayBrcode().equals(other.getPrePayBrcode()))
            && (this.getEbFlag() == null ? other.getEbFlag() == null : this.getEbFlag().equals(other.getEbFlag()))
            && (this.getRiskAmt() == null ? other.getRiskAmt() == null : this.getRiskAmt().equals(other.getRiskAmt()))
            && (this.getAvaliableAmt() == null ? other.getAvaliableAmt() == null : this.getAvaliableAmt().equals(other.getAvaliableAmt()))
            && (this.getAcctBrcode() == null ? other.getAcctBrcode() == null : this.getAcctBrcode().equals(other.getAcctBrcode()))
            && (this.getMastContcode() == null ? other.getMastContcode() == null : this.getMastContcode().equals(other.getMastContcode()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getHasIndirectCredit() == null ? other.getHasIndirectCredit() == null : this.getHasIndirectCredit().equals(other.getHasIndirectCredit()))
            && (this.getCreditCustcd() == null ? other.getCreditCustcd() == null : this.getCreditCustcd().equals(other.getCreditCustcd()))
            && (this.getOtherCustcd() == null ? other.getOtherCustcd() == null : this.getOtherCustcd().equals(other.getOtherCustcd()))
            && (this.getOrgDebetId() == null ? other.getOrgDebetId() == null : this.getOrgDebetId().equals(other.getOrgDebetId()))
            && (this.getDrawbackTerm() == null ? other.getDrawbackTerm() == null : this.getDrawbackTerm().equals(other.getDrawbackTerm()))
            && (this.getLoanAppno() == null ? other.getLoanAppno() == null : this.getLoanAppno().equals(other.getLoanAppno()))
            && (this.getProductCode() == null ? other.getProductCode() == null : this.getProductCode().equals(other.getProductCode()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCreditNo() == null ? other.getCreditNo() == null : this.getCreditNo().equals(other.getCreditNo()))
            && (this.getOwnFundPayAmt() == null ? other.getOwnFundPayAmt() == null : this.getOwnFundPayAmt().equals(other.getOwnFundPayAmt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getDebetNo() == null) ? 0 : getDebetNo().hashCode());
        result = prime * result + ((getDebetId() == null) ? 0 : getDebetId().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getLnciType() == null) ? 0 : getLnciType().hashCode());
        result = prime * result + ((getLnciStatus() == null) ? 0 : getLnciStatus().hashCode());
        result = prime * result + ((getLnciAmt() == null) ? 0 : getLnciAmt().hashCode());
        result = prime * result + ((getLnciBal() == null) ? 0 : getLnciBal().hashCode());
        result = prime * result + ((getFivelevel() == null) ? 0 : getFivelevel().hashCode());
        result = prime * result + ((getLoanType() == null) ? 0 : getLoanType().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getMgrno() == null) ? 0 : getMgrno().hashCode());
        result = prime * result + ((getBailAmount() == null) ? 0 : getBailAmount().hashCode());
        result = prime * result + ((getFirstBailRatio() == null) ? 0 : getFirstBailRatio().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getBillType() == null) ? 0 : getBillType().hashCode());
        result = prime * result + ((getBailAccount() == null) ? 0 : getBailAccount().hashCode());
        result = prime * result + ((getBillNum() == null) ? 0 : getBillNum().hashCode());
        result = prime * result + ((getLoanDays() == null) ? 0 : getLoanDays().hashCode());
        result = prime * result + ((getAddBailAmount() == null) ? 0 : getAddBailAmount().hashCode());
        result = prime * result + ((getConfirmStatus() == null) ? 0 : getConfirmStatus().hashCode());
        result = prime * result + ((getTotalBailAmount() == null) ? 0 : getTotalBailAmount().hashCode());
        result = prime * result + ((getSlaveLimit() == null) ? 0 : getSlaveLimit().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        result = prime * result + ((getAddCashEqtAmt() == null) ? 0 : getAddCashEqtAmt().hashCode());
        result = prime * result + ((getInitCashEqtAmt() == null) ? 0 : getInitCashEqtAmt().hashCode());
        result = prime * result + ((getAmountIn() == null) ? 0 : getAmountIn().hashCode());
        result = prime * result + ((getAmountOut() == null) ? 0 : getAmountOut().hashCode());
        result = prime * result + ((getAmountUpOut() == null) ? 0 : getAmountUpOut().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getBussBrcode() == null) ? 0 : getBussBrcode().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getRepayMethod() == null) ? 0 : getRepayMethod().hashCode());
        result = prime * result + ((getGraceDays() == null) ? 0 : getGraceDays().hashCode());
        result = prime * result + ((getLoanUse() == null) ? 0 : getLoanUse().hashCode());
        result = prime * result + ((getRateType() == null) ? 0 : getRateType().hashCode());
        result = prime * result + ((getRateFloatType() == null) ? 0 : getRateFloatType().hashCode());
        result = prime * result + ((getRateFloatValue() == null) ? 0 : getRateFloatValue().hashCode());
        result = prime * result + ((getBaseYearRate() == null) ? 0 : getBaseYearRate().hashCode());
        result = prime * result + ((getRateAdjustType() == null) ? 0 : getRateAdjustType().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getDraftBrcode() == null) ? 0 : getDraftBrcode().hashCode());
        result = prime * result + ((getSignBrcode() == null) ? 0 : getSignBrcode().hashCode());
        result = prime * result + ((getPrePayBrcode() == null) ? 0 : getPrePayBrcode().hashCode());
        result = prime * result + ((getEbFlag() == null) ? 0 : getEbFlag().hashCode());
        result = prime * result + ((getRiskAmt() == null) ? 0 : getRiskAmt().hashCode());
        result = prime * result + ((getAvaliableAmt() == null) ? 0 : getAvaliableAmt().hashCode());
        result = prime * result + ((getAcctBrcode() == null) ? 0 : getAcctBrcode().hashCode());
        result = prime * result + ((getMastContcode() == null) ? 0 : getMastContcode().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getHasIndirectCredit() == null) ? 0 : getHasIndirectCredit().hashCode());
        result = prime * result + ((getCreditCustcd() == null) ? 0 : getCreditCustcd().hashCode());
        result = prime * result + ((getOtherCustcd() == null) ? 0 : getOtherCustcd().hashCode());
        result = prime * result + ((getOrgDebetId() == null) ? 0 : getOrgDebetId().hashCode());
        result = prime * result + ((getDrawbackTerm() == null) ? 0 : getDrawbackTerm().hashCode());
        result = prime * result + ((getLoanAppno() == null) ? 0 : getLoanAppno().hashCode());
        result = prime * result + ((getProductCode() == null) ? 0 : getProductCode().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreditNo() == null) ? 0 : getCreditNo().hashCode());
        result = prime * result + ((getOwnFundPayAmt() == null) ? 0 : getOwnFundPayAmt().hashCode());
        return result;
    }
}
package com.huateng.scf.bas.pbc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BPbcAppliOrderBussInfoVO implements Serializable {
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
     * VARCHAR(20)<br>
     * 买方客户号
     */
    private String custcdBuyer;

    /**
     * VARCHAR(20)<br>
     * 卖方客户号
     */
    private String custcdSeller;

    /**
     * VARCHAR(4)<br>
     * 业务申请类型：00：录入；01：承购；02：入池；03：出池；04:折让；05：回购；06：核销；07：发票账龄变更；08：还款; 09：瑕疵；10:商纠；11：逾期；12：呆账；
     */
    private String applyType;

    /**
     * VARCHAR(20)<br>
     * 订单融资合同号
     */
    private String orderContno;

    /**
     * VARCHAR(20)<br>
     * 主合同号
     */
    private String mastContno;

    /**
     * DATE(7)<br>
     * 登记日期
     */
    private Date insertDate;

    /**
     * DECIMAL(22)<br>
     * 单据总数
     */
    private BigDecimal billsNum;

    /**
     * DECIMAL(16,2)<br>
     * 通用总金额
     */
    private BigDecimal totalAmount;

    /**
     * VARCHAR(10)<br>
     * 业务类型(产品小类ID)
     */
    private String bussType;

    /**
     * VARCHAR(2)<br>
     * 01：贷款；02：银承
     */
    private String loanWay;

    /**
     * DECIMAL(16,2)<br>
     * 通用金额
     */
    private BigDecimal amount;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * VARCHAR(50)<br>
     * 备注
     */
    private String memo;

    /**
     * DATE(7)<br>
     * 为通用日期时间，包含转让日期、催收日期等根据业务操作类型来确定。等等
     */
    private Date bussDate;

    /**
     * VARCHAR(20)<br>
     * 登记人
     */
    private String tlrcd;

    /**
     * VARCHAR(20)<br>
     * 登记机构
     */
    private String brcode;

    /**
     * VARCHAR(32)<br>
     * 订单阶段融资编号
     */
    private String orderDebetNo;

    /**
     * DECIMAL(16,2)<br>
     * 敞口余额
     */
    private BigDecimal balanceRiskAmt;

    /**
     * DECIMAL(16,2)<br>
     * 本笔风险敞口
     */
    private BigDecimal riskAmt;

    /**
     * VARCHAR(10)<br>
     * 业务方式(催收方式、回款方式、放款发放方式)
     */
    private String bussWay;

    /**
     * DECIMAL(16,2)<br>
     * 交货后总净额
     */
    private BigDecimal billsTtlAmount;

    /**
     * DECIMAL(16,2)<br>
     * 可融资金额
     */
    private BigDecimal avaliableAmt;

    /**
     * VARCHAR(100)<br>
     * 通用原因
     */
    private String reason;

    /**
     * VARCHAR(40)<br>
     * 交易编号
     */
    private String transactionNo;

    /**
     * VARCHAR(2)<br>
     * 规则
     */
    private String assignRule;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String accountNo;

    /**
     * VARCHAR(50)<br>
     * 入账账号(回款帐户)
     */
    private String returnAccount;

    /**
     * DECIMAL(16,2)<br>
     * 入账账户(回款账户)余额
     */
    private BigDecimal returnAccountBalance;

    /**
     * CHAR(1)<br>
     * 尾款是否解付：1-是、2-否
     */
    private String toSallerFlag;

    /**
     * DECIMAL(16,2)<br>
     * 尾款金额
     */
    private BigDecimal overAmount;

    /**
     * DECIMAL(16,2)<br>
     * 偿还金额
     */
    private BigDecimal repayAmount;

    /**
     * CHAR(2)<br>
     * 回款用途(入保证金\还贷\尾款)
     */
    private String returnUsage;

    /**
     * CHAR(1)<br>
     * 结算方式
     */
    private String clearWay;

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
     * DATE(7)<br>
     * 交易日期
     */
    private Date transactionDate;

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
     * 获得 卖方客户号
     */
    public String getCustcdSeller() {
        return custcdSeller;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 卖方客户号
     */
    public void setCustcdSeller(String custcdSeller) {
        this.custcdSeller = custcdSeller == null ? null : custcdSeller.trim();
    }

    /**
     * VARCHAR(4)<br>
     * 获得 业务申请类型：00：录入；01：承购；02：入池；03：出池；04:折让；05：回购；06：核销；07：发票账龄变更；08：还款; 09：瑕疵；10:商纠；11：逾期；12：呆账；
     */
    public String getApplyType() {
        return applyType;
    }

    /**
     * VARCHAR(4)<br>
     * 设置 业务申请类型：00：录入；01：承购；02：入池；03：出池；04:折让；05：回购；06：核销；07：发票账龄变更；08：还款; 09：瑕疵；10:商纠；11：逾期；12：呆账；
     */
    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 订单融资合同号
     */
    public String getOrderContno() {
        return orderContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 订单融资合同号
     */
    public void setOrderContno(String orderContno) {
        this.orderContno = orderContno == null ? null : orderContno.trim();
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
     * DATE(7)<br>
     * 获得 登记日期
     */
    public Date getInsertDate() {
        return insertDate;
    }

    /**
     * DATE(7)<br>
     * 设置 登记日期
     */
    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    /**
     * DECIMAL(22)<br>
     * 获得 单据总数
     */
    public BigDecimal getBillsNum() {
        return billsNum;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 单据总数
     */
    public void setBillsNum(BigDecimal billsNum) {
        this.billsNum = billsNum;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 通用总金额
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 通用总金额
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 业务类型(产品小类ID)
     */
    public String getBussType() {
        return bussType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 业务类型(产品小类ID)
     */
    public void setBussType(String bussType) {
        this.bussType = bussType == null ? null : bussType.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 01：贷款；02：银承
     */
    public String getLoanWay() {
        return loanWay;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 01：贷款；02：银承
     */
    public void setLoanWay(String loanWay) {
        this.loanWay = loanWay == null ? null : loanWay.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 通用金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 通用金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
     * VARCHAR(50)<br>
     * 获得 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * DATE(7)<br>
     * 获得 为通用日期时间，包含转让日期、催收日期等根据业务操作类型来确定。等等
     */
    public Date getBussDate() {
        return bussDate;
    }

    /**
     * DATE(7)<br>
     * 设置 为通用日期时间，包含转让日期、催收日期等根据业务操作类型来确定。等等
     */
    public void setBussDate(Date bussDate) {
        this.bussDate = bussDate;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 登记人
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(20)<br>
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
     * VARCHAR(32)<br>
     * 获得 订单阶段融资编号
     */
    public String getOrderDebetNo() {
        return orderDebetNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 订单阶段融资编号
     */
    public void setOrderDebetNo(String orderDebetNo) {
        this.orderDebetNo = orderDebetNo == null ? null : orderDebetNo.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 敞口余额
     */
    public BigDecimal getBalanceRiskAmt() {
        return balanceRiskAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 敞口余额
     */
    public void setBalanceRiskAmt(BigDecimal balanceRiskAmt) {
        this.balanceRiskAmt = balanceRiskAmt;
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
     * VARCHAR(10)<br>
     * 获得 业务方式(催收方式、回款方式、放款发放方式)
     */
    public String getBussWay() {
        return bussWay;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 业务方式(催收方式、回款方式、放款发放方式)
     */
    public void setBussWay(String bussWay) {
        this.bussWay = bussWay == null ? null : bussWay.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 交货后总净额
     */
    public BigDecimal getBillsTtlAmount() {
        return billsTtlAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 交货后总净额
     */
    public void setBillsTtlAmount(BigDecimal billsTtlAmount) {
        this.billsTtlAmount = billsTtlAmount;
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
     * VARCHAR(40)<br>
     * 获得 交易编号
     */
    public String getTransactionNo() {
        return transactionNo;
    }

    /**
     * VARCHAR(40)<br>
     * 设置 交易编号
     */
    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo == null ? null : transactionNo.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 规则
     */
    public String getAssignRule() {
        return assignRule;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 规则
     */
    public void setAssignRule(String assignRule) {
        this.assignRule = assignRule == null ? null : assignRule.trim();
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
     * DECIMAL(16,2)<br>
     * 获得 尾款金额
     */
    public BigDecimal getOverAmount() {
        return overAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 尾款金额
     */
    public void setOverAmount(BigDecimal overAmount) {
        this.overAmount = overAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 偿还金额
     */
    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 偿还金额
     */
    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

    /**
     * CHAR(2)<br>
     * 获得 回款用途(入保证金\还贷\尾款)
     */
    public String getReturnUsage() {
        return returnUsage;
    }

    /**
     * CHAR(2)<br>
     * 设置 回款用途(入保证金\还贷\尾款)
     */
    public void setReturnUsage(String returnUsage) {
        this.returnUsage = returnUsage == null ? null : returnUsage.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 结算方式
     */
    public String getClearWay() {
        return clearWay;
    }

    /**
     * CHAR(1)<br>
     * 设置 结算方式
     */
    public void setClearWay(String clearWay) {
        this.clearWay = clearWay == null ? null : clearWay.trim();
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
     * DATE(7)<br>
     * 获得 交易日期
     */
    public Date getTransactionDate() {
        return transactionDate;
    }

    /**
     * DATE(7)<br>
     * 设置 交易日期
     */
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
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
        sb.append(", custcdSeller=").append(custcdSeller);
        sb.append(", applyType=").append(applyType);
        sb.append(", orderContno=").append(orderContno);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", insertDate=").append(insertDate);
        sb.append(", billsNum=").append(billsNum);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", bussType=").append(bussType);
        sb.append(", loanWay=").append(loanWay);
        sb.append(", amount=").append(amount);
        sb.append(", curcd=").append(curcd);
        sb.append(", memo=").append(memo);
        sb.append(", bussDate=").append(bussDate);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", brcode=").append(brcode);
        sb.append(", orderDebetNo=").append(orderDebetNo);
        sb.append(", balanceRiskAmt=").append(balanceRiskAmt);
        sb.append(", riskAmt=").append(riskAmt);
        sb.append(", bussWay=").append(bussWay);
        sb.append(", billsTtlAmount=").append(billsTtlAmount);
        sb.append(", avaliableAmt=").append(avaliableAmt);
        sb.append(", reason=").append(reason);
        sb.append(", transactionNo=").append(transactionNo);
        sb.append(", assignRule=").append(assignRule);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", returnAccount=").append(returnAccount);
        sb.append(", returnAccountBalance=").append(returnAccountBalance);
        sb.append(", toSallerFlag=").append(toSallerFlag);
        sb.append(", overAmount=").append(overAmount);
        sb.append(", repayAmount=").append(repayAmount);
        sb.append(", returnUsage=").append(returnUsage);
        sb.append(", clearWay=").append(clearWay);
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
        BPbcAppliOrderBussInfoVO other = (BPbcAppliOrderBussInfoVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getCustcdBuyer() == null ? other.getCustcdBuyer() == null : this.getCustcdBuyer().equals(other.getCustcdBuyer()))
            && (this.getCustcdSeller() == null ? other.getCustcdSeller() == null : this.getCustcdSeller().equals(other.getCustcdSeller()))
            && (this.getApplyType() == null ? other.getApplyType() == null : this.getApplyType().equals(other.getApplyType()))
            && (this.getOrderContno() == null ? other.getOrderContno() == null : this.getOrderContno().equals(other.getOrderContno()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getInsertDate() == null ? other.getInsertDate() == null : this.getInsertDate().equals(other.getInsertDate()))
            && (this.getBillsNum() == null ? other.getBillsNum() == null : this.getBillsNum().equals(other.getBillsNum()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getBussType() == null ? other.getBussType() == null : this.getBussType().equals(other.getBussType()))
            && (this.getLoanWay() == null ? other.getLoanWay() == null : this.getLoanWay().equals(other.getLoanWay()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getBussDate() == null ? other.getBussDate() == null : this.getBussDate().equals(other.getBussDate()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getOrderDebetNo() == null ? other.getOrderDebetNo() == null : this.getOrderDebetNo().equals(other.getOrderDebetNo()))
            && (this.getBalanceRiskAmt() == null ? other.getBalanceRiskAmt() == null : this.getBalanceRiskAmt().equals(other.getBalanceRiskAmt()))
            && (this.getRiskAmt() == null ? other.getRiskAmt() == null : this.getRiskAmt().equals(other.getRiskAmt()))
            && (this.getBussWay() == null ? other.getBussWay() == null : this.getBussWay().equals(other.getBussWay()))
            && (this.getBillsTtlAmount() == null ? other.getBillsTtlAmount() == null : this.getBillsTtlAmount().equals(other.getBillsTtlAmount()))
            && (this.getAvaliableAmt() == null ? other.getAvaliableAmt() == null : this.getAvaliableAmt().equals(other.getAvaliableAmt()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getTransactionNo() == null ? other.getTransactionNo() == null : this.getTransactionNo().equals(other.getTransactionNo()))
            && (this.getAssignRule() == null ? other.getAssignRule() == null : this.getAssignRule().equals(other.getAssignRule()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getReturnAccount() == null ? other.getReturnAccount() == null : this.getReturnAccount().equals(other.getReturnAccount()))
            && (this.getReturnAccountBalance() == null ? other.getReturnAccountBalance() == null : this.getReturnAccountBalance().equals(other.getReturnAccountBalance()))
            && (this.getToSallerFlag() == null ? other.getToSallerFlag() == null : this.getToSallerFlag().equals(other.getToSallerFlag()))
            && (this.getOverAmount() == null ? other.getOverAmount() == null : this.getOverAmount().equals(other.getOverAmount()))
            && (this.getRepayAmount() == null ? other.getRepayAmount() == null : this.getRepayAmount().equals(other.getRepayAmount()))
            && (this.getReturnUsage() == null ? other.getReturnUsage() == null : this.getReturnUsage().equals(other.getReturnUsage()))
            && (this.getClearWay() == null ? other.getClearWay() == null : this.getClearWay().equals(other.getClearWay()))
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
        result = prime * result + ((getCustcdBuyer() == null) ? 0 : getCustcdBuyer().hashCode());
        result = prime * result + ((getCustcdSeller() == null) ? 0 : getCustcdSeller().hashCode());
        result = prime * result + ((getApplyType() == null) ? 0 : getApplyType().hashCode());
        result = prime * result + ((getOrderContno() == null) ? 0 : getOrderContno().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getInsertDate() == null) ? 0 : getInsertDate().hashCode());
        result = prime * result + ((getBillsNum() == null) ? 0 : getBillsNum().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getBussType() == null) ? 0 : getBussType().hashCode());
        result = prime * result + ((getLoanWay() == null) ? 0 : getLoanWay().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getBussDate() == null) ? 0 : getBussDate().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getOrderDebetNo() == null) ? 0 : getOrderDebetNo().hashCode());
        result = prime * result + ((getBalanceRiskAmt() == null) ? 0 : getBalanceRiskAmt().hashCode());
        result = prime * result + ((getRiskAmt() == null) ? 0 : getRiskAmt().hashCode());
        result = prime * result + ((getBussWay() == null) ? 0 : getBussWay().hashCode());
        result = prime * result + ((getBillsTtlAmount() == null) ? 0 : getBillsTtlAmount().hashCode());
        result = prime * result + ((getAvaliableAmt() == null) ? 0 : getAvaliableAmt().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getTransactionNo() == null) ? 0 : getTransactionNo().hashCode());
        result = prime * result + ((getAssignRule() == null) ? 0 : getAssignRule().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getReturnAccount() == null) ? 0 : getReturnAccount().hashCode());
        result = prime * result + ((getReturnAccountBalance() == null) ? 0 : getReturnAccountBalance().hashCode());
        result = prime * result + ((getToSallerFlag() == null) ? 0 : getToSallerFlag().hashCode());
        result = prime * result + ((getOverAmount() == null) ? 0 : getOverAmount().hashCode());
        result = prime * result + ((getRepayAmount() == null) ? 0 : getRepayAmount().hashCode());
        result = prime * result + ((getReturnUsage() == null) ? 0 : getReturnUsage().hashCode());
        result = prime * result + ((getClearWay() == null) ? 0 : getClearWay().hashCode());
        result = prime * result + ((getPayer() == null) ? 0 : getPayer().hashCode());
        result = prime * result + ((getPayerAcctNo() == null) ? 0 : getPayerAcctNo().hashCode());
        result = prime * result + ((getPayerBank() == null) ? 0 : getPayerBank().hashCode());
        result = prime * result + ((getTransferAmt() == null) ? 0 : getTransferAmt().hashCode());
        result = prime * result + ((getTransactionDate() == null) ? 0 : getTransactionDate().hashCode());
        return result;
    }
}
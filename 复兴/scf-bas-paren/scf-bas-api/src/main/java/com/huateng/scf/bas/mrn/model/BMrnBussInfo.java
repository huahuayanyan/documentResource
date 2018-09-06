package com.huateng.scf.bas.mrn.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BMrnBussInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String appno;

    /**
     * VARCHAR(4)<br>
     * 
     */
    private String applyType;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String custcdSaller;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String custcdBuyer;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String mastContno;

    /**
     * DATE(7)<br>
     * 
     */
    private Date insertDate;

    /**
     * DATE(7)<br>
     * 
     */
    private Date purchaseDate;

    /**
     * DECIMAL(22)<br>
     * 
     */
    private BigDecimal debtNum;

    /**
     * DECIMAL(16,2)<br>
     * 
     */
    private BigDecimal totalDebtAmount;

    /**
     * CHAR(1)<br>
     * 
     */
    private String chargeType;

    /**
     * CHAR(1)<br>
     * 
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
     * 
     */
    private BigDecimal reduceAmount;

    /**
     * DECIMAL(16,2)<br>
     * 
     */
    private BigDecimal totalFee;

    /**
     * DECIMAL(16,2)<br>
     * 
     */
    private BigDecimal totalReduce;

    /**
     * DECIMAL(16,2)<br>
     * 
     */
    private BigDecimal receiveAmount;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String costAccount;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String payDayMonth;

    /**
     * CHAR(1)<br>
     * 
     */
    private String rateCollectType;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String overDueRate;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String executeRate;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String upDownPercent;

    /**
     * CHAR(1)<br>
     * 
     */
    private String upDown;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String baseRate;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String rateId;

    /**
     * CHAR(1)<br>
     * 
     */
    private String rateType;

    /**
     * VARCHAR(10)<br>
     * 
     */
    private String bussType;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String loanType;

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
     * 
     */
    private BigDecimal amount;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String accountno;

    /**
     * DATE(7)<br>
     * 
     */
    private Date appDate;

    /**
     * DATE(7)<br>
     * 
     */
    private Date appLoanDate;

    /**
     * DATE(7)<br>
     * 
     */
    private Date loanDueDate;

    /**
     * DATE(7)<br>
     * 
     */
    private Date returnDate;

    /**
     * CHAR(3)<br>
     * 
     */
    private String curcd;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String memo;

    /**
     * TIMESTAMP(11,6)<br>
     * 
     */
    private Date commonDate;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String tlrcd;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String brcode;

    /**
     * CHAR(1)<br>
     * 
     */
    private String returnType;

    /**
     * CHAR(1)<br>
     * 
     */
    private String toSallerFlag;

    /**
     * DECIMAL(16,2)<br>
     * 
     */
    private BigDecimal returnAmount;

    /**
     * VARCHAR(100)<br>
     * 
     */
    private String reason;

    /**
     * VARCHAR(100)<br>
     * 
     */
    private String otherReason;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String accountNo;

    /**
     * CHAR(1)<br>
     * 
     */
    private String returnMethod;

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
     * 
     */
    private BigDecimal toPoolAmount;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String subContno;

    /**
     * VARCHAR(2)<br>
     * 
     */
    private String bailType;

    /**
     * VARCHAR(20)<br>
     * 借据号
     */
    private String debetNo;

    /**
     * VARCHAR(2)<br>
     * 
     */
    private String initType;

    /**
     * VARCHAR(2)<br>
     * 
     */
    private String confirmStatus;

    /**
     * VARCHAR(100)<br>
     * 订单号
     */
    private String orderNo;

    /**
     * DECIMAL(16,2)<br>
     * 订单金额
     */
    private BigDecimal orderAmt;

    /**
     * VARCHAR(20)<br>
     * 抵质押合同号
     */
    private String slaveContno;

    /**
     * VARCHAR(32) 必填<br>
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(20)<br>
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * VARCHAR(4)<br>
     */
    public String getApplyType() {
        return applyType;
    }

    /**
     * VARCHAR(4)<br>
     */
    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
    }

    /**
     * VARCHAR(20)<br>
     */
    public String getCustcdSaller() {
        return custcdSaller;
    }

    /**
     * VARCHAR(20)<br>
     */
    public void setCustcdSaller(String custcdSaller) {
        this.custcdSaller = custcdSaller == null ? null : custcdSaller.trim();
    }

    /**
     * VARCHAR(20)<br>
     */
    public String getCustcdBuyer() {
        return custcdBuyer;
    }

    /**
     * VARCHAR(20)<br>
     */
    public void setCustcdBuyer(String custcdBuyer) {
        this.custcdBuyer = custcdBuyer == null ? null : custcdBuyer.trim();
    }

    /**
     * VARCHAR(20)<br>
     */
    public String getMastContno() {
        return mastContno;
    }

    /**
     * VARCHAR(20)<br>
     */
    public void setMastContno(String mastContno) {
        this.mastContno = mastContno == null ? null : mastContno.trim();
    }

    /**
     * DATE(7)<br>
     */
    public Date getInsertDate() {
        return insertDate;
    }

    /**
     * DATE(7)<br>
     */
    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    /**
     * DATE(7)<br>
     */
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * DATE(7)<br>
     */
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * DECIMAL(22)<br>
     */
    public BigDecimal getDebtNum() {
        return debtNum;
    }

    /**
     * DECIMAL(22)<br>
     */
    public void setDebtNum(BigDecimal debtNum) {
        this.debtNum = debtNum;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public BigDecimal getTotalDebtAmount() {
        return totalDebtAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public void setTotalDebtAmount(BigDecimal totalDebtAmount) {
        this.totalDebtAmount = totalDebtAmount;
    }

    /**
     * CHAR(1)<br>
     */
    public String getChargeType() {
        return chargeType;
    }

    /**
     * CHAR(1)<br>
     */
    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    /**
     * CHAR(1)<br>
     */
    public String getFinacingDiscountType() {
        return finacingDiscountType;
    }

    /**
     * CHAR(1)<br>
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
     */
    public BigDecimal getReduceAmount() {
        return reduceAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public void setReduceAmount(BigDecimal reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public BigDecimal getTotalFee() {
        return totalFee;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public BigDecimal getTotalReduce() {
        return totalReduce;
    }

    /**
     * DECIMAL(16,2)<br>
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
     */
    public String getCostAccount() {
        return costAccount;
    }

    /**
     * VARCHAR(50)<br>
     */
    public void setCostAccount(String costAccount) {
        this.costAccount = costAccount == null ? null : costAccount.trim();
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
     */
    public String getRateCollectType() {
        return rateCollectType;
    }

    /**
     * CHAR(1)<br>
     */
    public void setRateCollectType(String rateCollectType) {
        this.rateCollectType = rateCollectType == null ? null : rateCollectType.trim();
    }

    /**
     * VARCHAR(50)<br>
     */
    public String getOverDueRate() {
        return overDueRate;
    }

    /**
     * VARCHAR(50)<br>
     */
    public void setOverDueRate(String overDueRate) {
        this.overDueRate = overDueRate == null ? null : overDueRate.trim();
    }

    /**
     * VARCHAR(50)<br>
     */
    public String getExecuteRate() {
        return executeRate;
    }

    /**
     * VARCHAR(50)<br>
     */
    public void setExecuteRate(String executeRate) {
        this.executeRate = executeRate == null ? null : executeRate.trim();
    }

    /**
     * VARCHAR(50)<br>
     */
    public String getUpDownPercent() {
        return upDownPercent;
    }

    /**
     * VARCHAR(50)<br>
     */
    public void setUpDownPercent(String upDownPercent) {
        this.upDownPercent = upDownPercent == null ? null : upDownPercent.trim();
    }

    /**
     * CHAR(1)<br>
     */
    public String getUpDown() {
        return upDown;
    }

    /**
     * CHAR(1)<br>
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
     */
    public String getRateId() {
        return rateId;
    }

    /**
     * VARCHAR(50)<br>
     */
    public void setRateId(String rateId) {
        this.rateId = rateId == null ? null : rateId.trim();
    }

    /**
     * CHAR(1)<br>
     */
    public String getRateType() {
        return rateType;
    }

    /**
     * CHAR(1)<br>
     */
    public void setRateType(String rateType) {
        this.rateType = rateType == null ? null : rateType.trim();
    }

    /**
     * VARCHAR(10)<br>
     */
    public String getBussType() {
        return bussType;
    }

    /**
     * VARCHAR(10)<br>
     */
    public void setBussType(String bussType) {
        this.bussType = bussType == null ? null : bussType.trim();
    }

    /**
     * VARCHAR(50)<br>
     */
    public String getLoanType() {
        return loanType;
    }

    /**
     * VARCHAR(50)<br>
     */
    public void setLoanType(String loanType) {
        this.loanType = loanType == null ? null : loanType.trim();
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
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * VARCHAR(50)<br>
     */
    public String getAccountno() {
        return accountno;
    }

    /**
     * VARCHAR(50)<br>
     */
    public void setAccountno(String accountno) {
        this.accountno = accountno == null ? null : accountno.trim();
    }

    /**
     * DATE(7)<br>
     */
    public Date getAppDate() {
        return appDate;
    }

    /**
     * DATE(7)<br>
     */
    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    /**
     * DATE(7)<br>
     */
    public Date getAppLoanDate() {
        return appLoanDate;
    }

    /**
     * DATE(7)<br>
     */
    public void setAppLoanDate(Date appLoanDate) {
        this.appLoanDate = appLoanDate;
    }

    /**
     * DATE(7)<br>
     */
    public Date getLoanDueDate() {
        return loanDueDate;
    }

    /**
     * DATE(7)<br>
     */
    public void setLoanDueDate(Date loanDueDate) {
        this.loanDueDate = loanDueDate;
    }

    /**
     * DATE(7)<br>
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * DATE(7)<br>
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * CHAR(3)<br>
     */
    public String getCurcd() {
        return curcd;
    }

    /**
     * CHAR(3)<br>
     */
    public void setCurcd(String curcd) {
        this.curcd = curcd == null ? null : curcd.trim();
    }

    /**
     * VARCHAR(50)<br>
     */
    public String getMemo() {
        return memo;
    }

    /**
     * VARCHAR(50)<br>
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     */
    public Date getCommonDate() {
        return commonDate;
    }

    /**
     * TIMESTAMP(11,6)<br>
     */
    public void setCommonDate(Date commonDate) {
        this.commonDate = commonDate;
    }

    /**
     * VARCHAR(20)<br>
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(20)<br>
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
    }

    /**
     * VARCHAR(20)<br>
     */
    public String getBrcode() {
        return brcode;
    }

    /**
     * VARCHAR(20)<br>
     */
    public void setBrcode(String brcode) {
        this.brcode = brcode == null ? null : brcode.trim();
    }

    /**
     * CHAR(1)<br>
     */
    public String getReturnType() {
        return returnType;
    }

    /**
     * CHAR(1)<br>
     */
    public void setReturnType(String returnType) {
        this.returnType = returnType == null ? null : returnType.trim();
    }

    /**
     * CHAR(1)<br>
     */
    public String getToSallerFlag() {
        return toSallerFlag;
    }

    /**
     * CHAR(1)<br>
     */
    public void setToSallerFlag(String toSallerFlag) {
        this.toSallerFlag = toSallerFlag == null ? null : toSallerFlag.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    /**
     * VARCHAR(100)<br>
     */
    public String getReason() {
        return reason;
    }

    /**
     * VARCHAR(100)<br>
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * VARCHAR(100)<br>
     */
    public String getOtherReason() {
        return otherReason;
    }

    /**
     * VARCHAR(100)<br>
     */
    public void setOtherReason(String otherReason) {
        this.otherReason = otherReason == null ? null : otherReason.trim();
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
     * CHAR(1)<br>
     */
    public String getReturnMethod() {
        return returnMethod;
    }

    /**
     * CHAR(1)<br>
     */
    public void setReturnMethod(String returnMethod) {
        this.returnMethod = returnMethod == null ? null : returnMethod.trim();
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
     */
    public BigDecimal getToPoolAmount() {
        return toPoolAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public void setToPoolAmount(BigDecimal toPoolAmount) {
        this.toPoolAmount = toPoolAmount;
    }

    /**
     * VARCHAR(20)<br>
     */
    public String getSubContno() {
        return subContno;
    }

    /**
     * VARCHAR(20)<br>
     */
    public void setSubContno(String subContno) {
        this.subContno = subContno == null ? null : subContno.trim();
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
     * 获得 借据号
     */
    public String getDebetNo() {
        return debetNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 借据号
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
     */
    public String getConfirmStatus() {
        return confirmStatus;
    }

    /**
     * VARCHAR(2)<br>
     */
    public void setConfirmStatus(String confirmStatus) {
        this.confirmStatus = confirmStatus == null ? null : confirmStatus.trim();
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
        sb.append(", accountno=").append(accountno);
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
        sb.append(", subContno=").append(subContno);
        sb.append(", bailType=").append(bailType);
        sb.append(", debetNo=").append(debetNo);
        sb.append(", initType=").append(initType);
        sb.append(", confirmStatus=").append(confirmStatus);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", orderAmt=").append(orderAmt);
        sb.append(", slaveContno=").append(slaveContno);
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
        BMrnBussInfo other = (BMrnBussInfo) that;
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
            && (this.getAccountno() == null ? other.getAccountno() == null : this.getAccountno().equals(other.getAccountno()))
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
            && (this.getSubContno() == null ? other.getSubContno() == null : this.getSubContno().equals(other.getSubContno()))
            && (this.getBailType() == null ? other.getBailType() == null : this.getBailType().equals(other.getBailType()))
            && (this.getDebetNo() == null ? other.getDebetNo() == null : this.getDebetNo().equals(other.getDebetNo()))
            && (this.getInitType() == null ? other.getInitType() == null : this.getInitType().equals(other.getInitType()))
            && (this.getConfirmStatus() == null ? other.getConfirmStatus() == null : this.getConfirmStatus().equals(other.getConfirmStatus()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getOrderAmt() == null ? other.getOrderAmt() == null : this.getOrderAmt().equals(other.getOrderAmt()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()));
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
        result = prime * result + ((getAccountno() == null) ? 0 : getAccountno().hashCode());
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
        result = prime * result + ((getSubContno() == null) ? 0 : getSubContno().hashCode());
        result = prime * result + ((getBailType() == null) ? 0 : getBailType().hashCode());
        result = prime * result + ((getDebetNo() == null) ? 0 : getDebetNo().hashCode());
        result = prime * result + ((getInitType() == null) ? 0 : getInitType().hashCode());
        result = prime * result + ((getConfirmStatus() == null) ? 0 : getConfirmStatus().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getOrderAmt() == null) ? 0 : getOrderAmt().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        return result;
    }
}
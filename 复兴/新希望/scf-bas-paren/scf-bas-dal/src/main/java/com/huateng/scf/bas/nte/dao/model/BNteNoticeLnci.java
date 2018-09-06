package com.huateng.scf.bas.nte.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BNteNoticeLnci implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 业务申请编号
     */
    private String appno;

    /**
     * VARCHAR(15)<br>
     * 经销商
     */
    private String custcd;

    /**
     * VARCHAR(80)<br>
     * 经销商名称
     */
    private String cname;

    /**
     * VARCHAR(15)<br>
     * 核心厂商
     */
    private String thrCd;

    /**
     * VARCHAR(80)<br>
     * 核心厂商名称
     */
    private String thrName;

    /**
     * VARCHAR(15)<br>
     * 回购商
     */
    private String fouCd;

    /**
     * VARCHAR(80)<br>
     * 回购商名名称
     */
    private String fouName;

    /**
     * DECIMAL(16,2)<br>
     * 额度金额
     */
    private BigDecimal creditAmount;

    /**
     * DECIMAL(16,2)<br>
     * 监管下限
     */
    private BigDecimal lowPrice;

    /**
     * DECIMAL(16,2)<br>
     * 风险总敞口
     */
    private BigDecimal totRiskAmount;

    /**
     * DECIMAL(16,2)<br>
     * 借据金额
     */
    private BigDecimal lnciAmt;

    /**
     * CHAR(8)<br>
     * 开始日期/出账日期
     */
    private String startDate;

    /**
     * CHAR(8)<br>
     * 结束日期
     */
    private String endDate;

    /**
     * VARCHAR(32)<br>
     * 借据表主键
     */
    private String debetNo;

    /**
     * CHAR(2)<br>
     * 出账方式
     */
    private String loanWay;

    /**
     * VARCHAR(6)<br>
     * 填平敞口日期
     */
    private String slaveLimit;

    /**
     * DECIMAL(16,2)<br>
     * 保证金金额
     */
    private BigDecimal bailAmount;

    /**
     * VARCHAR(100)<br>
     * 保证金帐号
     */
    private String bailAccountNo;

    /**
     * DECIMAL(22,6)<br>
     * 现金等价物初始比例(%)
     */
    private BigDecimal firstBailRatio;

    /**
     * DECIMAL(16,2)<br>
     * 本次风险敞口
     */
    private BigDecimal riskAmount;

    /**
     * DECIMAL(16,2)<br>
     * 费用
     */
    private BigDecimal cost;

    /**
     * DECIMAL(16,2)<br>
     * 占用回购厂商额度
     */
    private BigDecimal usedCreditAmt;

    /**
     * DECIMAL(16,2)<br>
     * 货物总价值
     */
    private BigDecimal totalMortAmt;

    /**
     * VARCHAR(100)<br>
     * 保证金账号
     */
    private String mortBailAccountno;

    /**
     * DECIMAL(16,2)<br>
     * 保证金金额
     */
    private BigDecimal mortBailAmount;

    /**
     * DECIMAL(22,6)<br>
     * 保证金比例
     */
    private BigDecimal bailRate;

    /**
     * DECIMAL(16,2)<br>
     * 保险金额
     */
    private BigDecimal insuranceAmt;

    /**
     * DECIMAL(16,2)<br>
     * 质押率
     */
    private BigDecimal ration;

    /**
     * DECIMAL(22,6)<br>
     * 利率
     */
    private BigDecimal rate;

    /**
     * DECIMAL(22,6)<br>
     * 核定利率
     */
    private BigDecimal auditRate;

    /**
     * VARCHAR(32)<br>
     * 通知书表主键
     */
    private String pid;

    /**
     * VARCHAR(100)<br>
     * 借据号
     */
    private String debetId;

    /**
     * DECIMAL(16,2)<br>
     * 已发货数量
     */
    private BigDecimal deliveryQuantity;

    /**
     * DECIMAL(16,2)<br>
     * 已发货价值
     */
    private BigDecimal deliveryValue;

    /**
     * VARCHAR(100)<br>
     * 已发货品种
     */
    private String deliveryClass;

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
     * 获得 业务申请编号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 业务申请编号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 经销商
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 经销商
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 经销商名称
     */
    public String getCname() {
        return cname;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 经销商名称
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 核心厂商
     */
    public String getThrCd() {
        return thrCd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 核心厂商
     */
    public void setThrCd(String thrCd) {
        this.thrCd = thrCd == null ? null : thrCd.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 核心厂商名称
     */
    public String getThrName() {
        return thrName;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 核心厂商名称
     */
    public void setThrName(String thrName) {
        this.thrName = thrName == null ? null : thrName.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 回购商
     */
    public String getFouCd() {
        return fouCd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 回购商
     */
    public void setFouCd(String fouCd) {
        this.fouCd = fouCd == null ? null : fouCd.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 回购商名名称
     */
    public String getFouName() {
        return fouName;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 回购商名名称
     */
    public void setFouName(String fouName) {
        this.fouName = fouName == null ? null : fouName.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 额度金额
     */
    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 额度金额
     */
    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 监管下限
     */
    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 监管下限
     */
    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 风险总敞口
     */
    public BigDecimal getTotRiskAmount() {
        return totRiskAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 风险总敞口
     */
    public void setTotRiskAmount(BigDecimal totRiskAmount) {
        this.totRiskAmount = totRiskAmount;
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
     * CHAR(8)<br>
     * 获得 开始日期/出账日期
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 开始日期/出账日期
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 结束日期
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 结束日期
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 借据表主键
     */
    public String getDebetNo() {
        return debetNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 借据表主键
     */
    public void setDebetNo(String debetNo) {
        this.debetNo = debetNo == null ? null : debetNo.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 出账方式
     */
    public String getLoanWay() {
        return loanWay;
    }

    /**
     * CHAR(2)<br>
     * 设置 出账方式
     */
    public void setLoanWay(String loanWay) {
        this.loanWay = loanWay == null ? null : loanWay.trim();
    }

    /**
     * VARCHAR(6)<br>
     * 获得 填平敞口日期
     */
    public String getSlaveLimit() {
        return slaveLimit;
    }

    /**
     * VARCHAR(6)<br>
     * 设置 填平敞口日期
     */
    public void setSlaveLimit(String slaveLimit) {
        this.slaveLimit = slaveLimit == null ? null : slaveLimit.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 保证金金额
     */
    public BigDecimal getBailAmount() {
        return bailAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 保证金金额
     */
    public void setBailAmount(BigDecimal bailAmount) {
        this.bailAmount = bailAmount;
    }

    /**
     * VARCHAR(100)<br>
     * 获得 保证金帐号
     */
    public String getBailAccountNo() {
        return bailAccountNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 保证金帐号
     */
    public void setBailAccountNo(String bailAccountNo) {
        this.bailAccountNo = bailAccountNo == null ? null : bailAccountNo.trim();
    }

    /**
     * DECIMAL(22,6)<br>
     * 获得 现金等价物初始比例(%)
     */
    public BigDecimal getFirstBailRatio() {
        return firstBailRatio;
    }

    /**
     * DECIMAL(22,6)<br>
     * 设置 现金等价物初始比例(%)
     */
    public void setFirstBailRatio(BigDecimal firstBailRatio) {
        this.firstBailRatio = firstBailRatio;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 本次风险敞口
     */
    public BigDecimal getRiskAmount() {
        return riskAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 本次风险敞口
     */
    public void setRiskAmount(BigDecimal riskAmount) {
        this.riskAmount = riskAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 费用
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 费用
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 占用回购厂商额度
     */
    public BigDecimal getUsedCreditAmt() {
        return usedCreditAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 占用回购厂商额度
     */
    public void setUsedCreditAmt(BigDecimal usedCreditAmt) {
        this.usedCreditAmt = usedCreditAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 货物总价值
     */
    public BigDecimal getTotalMortAmt() {
        return totalMortAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 货物总价值
     */
    public void setTotalMortAmt(BigDecimal totalMortAmt) {
        this.totalMortAmt = totalMortAmt;
    }

    /**
     * VARCHAR(100)<br>
     * 获得 保证金账号
     */
    public String getMortBailAccountno() {
        return mortBailAccountno;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 保证金账号
     */
    public void setMortBailAccountno(String mortBailAccountno) {
        this.mortBailAccountno = mortBailAccountno == null ? null : mortBailAccountno.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 保证金金额
     */
    public BigDecimal getMortBailAmount() {
        return mortBailAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 保证金金额
     */
    public void setMortBailAmount(BigDecimal mortBailAmount) {
        this.mortBailAmount = mortBailAmount;
    }

    /**
     * DECIMAL(22,6)<br>
     * 获得 保证金比例
     */
    public BigDecimal getBailRate() {
        return bailRate;
    }

    /**
     * DECIMAL(22,6)<br>
     * 设置 保证金比例
     */
    public void setBailRate(BigDecimal bailRate) {
        this.bailRate = bailRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 保险金额
     */
    public BigDecimal getInsuranceAmt() {
        return insuranceAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 保险金额
     */
    public void setInsuranceAmt(BigDecimal insuranceAmt) {
        this.insuranceAmt = insuranceAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 质押率
     */
    public BigDecimal getRation() {
        return ration;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 质押率
     */
    public void setRation(BigDecimal ration) {
        this.ration = ration;
    }

    /**
     * DECIMAL(22,6)<br>
     * 获得 利率
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * DECIMAL(22,6)<br>
     * 设置 利率
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * DECIMAL(22,6)<br>
     * 获得 核定利率
     */
    public BigDecimal getAuditRate() {
        return auditRate;
    }

    /**
     * DECIMAL(22,6)<br>
     * 设置 核定利率
     */
    public void setAuditRate(BigDecimal auditRate) {
        this.auditRate = auditRate;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 通知书表主键
     */
    public String getPid() {
        return pid;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 通知书表主键
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 借据号
     */
    public String getDebetId() {
        return debetId;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 借据号
     */
    public void setDebetId(String debetId) {
        this.debetId = debetId == null ? null : debetId.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 已发货数量
     */
    public BigDecimal getDeliveryQuantity() {
        return deliveryQuantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 已发货数量
     */
    public void setDeliveryQuantity(BigDecimal deliveryQuantity) {
        this.deliveryQuantity = deliveryQuantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 已发货价值
     */
    public BigDecimal getDeliveryValue() {
        return deliveryValue;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 已发货价值
     */
    public void setDeliveryValue(BigDecimal deliveryValue) {
        this.deliveryValue = deliveryValue;
    }

    /**
     * VARCHAR(100)<br>
     * 获得 已发货品种
     */
    public String getDeliveryClass() {
        return deliveryClass;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 已发货品种
     */
    public void setDeliveryClass(String deliveryClass) {
        this.deliveryClass = deliveryClass == null ? null : deliveryClass.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appno=").append(appno);
        sb.append(", custcd=").append(custcd);
        sb.append(", cname=").append(cname);
        sb.append(", thrCd=").append(thrCd);
        sb.append(", thrName=").append(thrName);
        sb.append(", fouCd=").append(fouCd);
        sb.append(", fouName=").append(fouName);
        sb.append(", creditAmount=").append(creditAmount);
        sb.append(", lowPrice=").append(lowPrice);
        sb.append(", totRiskAmount=").append(totRiskAmount);
        sb.append(", lnciAmt=").append(lnciAmt);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", debetNo=").append(debetNo);
        sb.append(", loanWay=").append(loanWay);
        sb.append(", slaveLimit=").append(slaveLimit);
        sb.append(", bailAmount=").append(bailAmount);
        sb.append(", bailAccountNo=").append(bailAccountNo);
        sb.append(", firstBailRatio=").append(firstBailRatio);
        sb.append(", riskAmount=").append(riskAmount);
        sb.append(", cost=").append(cost);
        sb.append(", usedCreditAmt=").append(usedCreditAmt);
        sb.append(", totalMortAmt=").append(totalMortAmt);
        sb.append(", mortBailAccountno=").append(mortBailAccountno);
        sb.append(", mortBailAmount=").append(mortBailAmount);
        sb.append(", bailRate=").append(bailRate);
        sb.append(", insuranceAmt=").append(insuranceAmt);
        sb.append(", ration=").append(ration);
        sb.append(", rate=").append(rate);
        sb.append(", auditRate=").append(auditRate);
        sb.append(", pid=").append(pid);
        sb.append(", debetId=").append(debetId);
        sb.append(", deliveryQuantity=").append(deliveryQuantity);
        sb.append(", deliveryValue=").append(deliveryValue);
        sb.append(", deliveryClass=").append(deliveryClass);
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
        BNteNoticeLnci other = (BNteNoticeLnci) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()))
            && (this.getThrCd() == null ? other.getThrCd() == null : this.getThrCd().equals(other.getThrCd()))
            && (this.getThrName() == null ? other.getThrName() == null : this.getThrName().equals(other.getThrName()))
            && (this.getFouCd() == null ? other.getFouCd() == null : this.getFouCd().equals(other.getFouCd()))
            && (this.getFouName() == null ? other.getFouName() == null : this.getFouName().equals(other.getFouName()))
            && (this.getCreditAmount() == null ? other.getCreditAmount() == null : this.getCreditAmount().equals(other.getCreditAmount()))
            && (this.getLowPrice() == null ? other.getLowPrice() == null : this.getLowPrice().equals(other.getLowPrice()))
            && (this.getTotRiskAmount() == null ? other.getTotRiskAmount() == null : this.getTotRiskAmount().equals(other.getTotRiskAmount()))
            && (this.getLnciAmt() == null ? other.getLnciAmt() == null : this.getLnciAmt().equals(other.getLnciAmt()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getDebetNo() == null ? other.getDebetNo() == null : this.getDebetNo().equals(other.getDebetNo()))
            && (this.getLoanWay() == null ? other.getLoanWay() == null : this.getLoanWay().equals(other.getLoanWay()))
            && (this.getSlaveLimit() == null ? other.getSlaveLimit() == null : this.getSlaveLimit().equals(other.getSlaveLimit()))
            && (this.getBailAmount() == null ? other.getBailAmount() == null : this.getBailAmount().equals(other.getBailAmount()))
            && (this.getBailAccountNo() == null ? other.getBailAccountNo() == null : this.getBailAccountNo().equals(other.getBailAccountNo()))
            && (this.getFirstBailRatio() == null ? other.getFirstBailRatio() == null : this.getFirstBailRatio().equals(other.getFirstBailRatio()))
            && (this.getRiskAmount() == null ? other.getRiskAmount() == null : this.getRiskAmount().equals(other.getRiskAmount()))
            && (this.getCost() == null ? other.getCost() == null : this.getCost().equals(other.getCost()))
            && (this.getUsedCreditAmt() == null ? other.getUsedCreditAmt() == null : this.getUsedCreditAmt().equals(other.getUsedCreditAmt()))
            && (this.getTotalMortAmt() == null ? other.getTotalMortAmt() == null : this.getTotalMortAmt().equals(other.getTotalMortAmt()))
            && (this.getMortBailAccountno() == null ? other.getMortBailAccountno() == null : this.getMortBailAccountno().equals(other.getMortBailAccountno()))
            && (this.getMortBailAmount() == null ? other.getMortBailAmount() == null : this.getMortBailAmount().equals(other.getMortBailAmount()))
            && (this.getBailRate() == null ? other.getBailRate() == null : this.getBailRate().equals(other.getBailRate()))
            && (this.getInsuranceAmt() == null ? other.getInsuranceAmt() == null : this.getInsuranceAmt().equals(other.getInsuranceAmt()))
            && (this.getRation() == null ? other.getRation() == null : this.getRation().equals(other.getRation()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
            && (this.getAuditRate() == null ? other.getAuditRate() == null : this.getAuditRate().equals(other.getAuditRate()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getDebetId() == null ? other.getDebetId() == null : this.getDebetId().equals(other.getDebetId()))
            && (this.getDeliveryQuantity() == null ? other.getDeliveryQuantity() == null : this.getDeliveryQuantity().equals(other.getDeliveryQuantity()))
            && (this.getDeliveryValue() == null ? other.getDeliveryValue() == null : this.getDeliveryValue().equals(other.getDeliveryValue()))
            && (this.getDeliveryClass() == null ? other.getDeliveryClass() == null : this.getDeliveryClass().equals(other.getDeliveryClass()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
        result = prime * result + ((getThrCd() == null) ? 0 : getThrCd().hashCode());
        result = prime * result + ((getThrName() == null) ? 0 : getThrName().hashCode());
        result = prime * result + ((getFouCd() == null) ? 0 : getFouCd().hashCode());
        result = prime * result + ((getFouName() == null) ? 0 : getFouName().hashCode());
        result = prime * result + ((getCreditAmount() == null) ? 0 : getCreditAmount().hashCode());
        result = prime * result + ((getLowPrice() == null) ? 0 : getLowPrice().hashCode());
        result = prime * result + ((getTotRiskAmount() == null) ? 0 : getTotRiskAmount().hashCode());
        result = prime * result + ((getLnciAmt() == null) ? 0 : getLnciAmt().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getDebetNo() == null) ? 0 : getDebetNo().hashCode());
        result = prime * result + ((getLoanWay() == null) ? 0 : getLoanWay().hashCode());
        result = prime * result + ((getSlaveLimit() == null) ? 0 : getSlaveLimit().hashCode());
        result = prime * result + ((getBailAmount() == null) ? 0 : getBailAmount().hashCode());
        result = prime * result + ((getBailAccountNo() == null) ? 0 : getBailAccountNo().hashCode());
        result = prime * result + ((getFirstBailRatio() == null) ? 0 : getFirstBailRatio().hashCode());
        result = prime * result + ((getRiskAmount() == null) ? 0 : getRiskAmount().hashCode());
        result = prime * result + ((getCost() == null) ? 0 : getCost().hashCode());
        result = prime * result + ((getUsedCreditAmt() == null) ? 0 : getUsedCreditAmt().hashCode());
        result = prime * result + ((getTotalMortAmt() == null) ? 0 : getTotalMortAmt().hashCode());
        result = prime * result + ((getMortBailAccountno() == null) ? 0 : getMortBailAccountno().hashCode());
        result = prime * result + ((getMortBailAmount() == null) ? 0 : getMortBailAmount().hashCode());
        result = prime * result + ((getBailRate() == null) ? 0 : getBailRate().hashCode());
        result = prime * result + ((getInsuranceAmt() == null) ? 0 : getInsuranceAmt().hashCode());
        result = prime * result + ((getRation() == null) ? 0 : getRation().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getAuditRate() == null) ? 0 : getAuditRate().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getDebetId() == null) ? 0 : getDebetId().hashCode());
        result = prime * result + ((getDeliveryQuantity() == null) ? 0 : getDeliveryQuantity().hashCode());
        result = prime * result + ((getDeliveryValue() == null) ? 0 : getDeliveryValue().hashCode());
        result = prime * result + ((getDeliveryClass() == null) ? 0 : getDeliveryClass().hashCode());
        return result;
    }
}
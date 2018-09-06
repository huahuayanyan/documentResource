package com.huateng.scf.adv.bcp.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ABcpAppliImprestBuss implements Serializable {
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
     * VARCHAR(15)<br>
     * 客户号/买方客户号
     */
    private String custcd;

    /**
     * VARCHAR(15)<br>
     * 上游厂商客户号/卖方客户号
     */
    private String upCustcd;

    /**
     * VARCHAR(15)<br>
     * 监管公司客户号
     */
    private String moniCustcd;

    /**
     * VARCHAR(15)<br>
     * 担保方客户号
     */
    private String guaranteeCustcd;

    /**
     * VARCHAR(32)<br>
     * 借据表主键
     */
    private String debetNo;

    /**
     * VARCHAR(20)<br>
     * 主合同号
     */
    private String mastContno;

    /**
     * VARCHAR(20)<br>
     * 关联预付款协议号
     */
    private String protocolNo;

    /**
     * VARCHAR(20)<br>
     * 监管协议号
     */
    private String moniProtocolNo;

    /**
     * VARCHAR(20)<br>
     * 质押合同号
     */
    private String slaveContno;

    /**
     * DECIMAL(16,2)<br>
     * 通用金额
     */
    private BigDecimal commonAmt;

    /**
     * DECIMAL(16,2)<br>
     * 收款金额
     */
    private BigDecimal collectedAmt;

    /**
     * DECIMAL(16,2)<br>
     * 已发货金额
     */
    private BigDecimal deliveryAmt;

    /**
     * DECIMAL(16,2)<br>
     * 未发货金额
     */
    private BigDecimal undeliveryAmt;

    /**
     * DECIMAL(22)<br>
     * 退款期限
     */
    private BigDecimal paybackTerm;

    /**
     * VARCHAR(100)<br>
     * 收款人名称
     */
    private String payee;

    /**
     * VARCHAR(50)<br>
     * 退款账号
     */
    private String paybackAcctNo;

    /**
     * VARCHAR(100)<br>
     * 开户行
     */
    private String depositBank;

    /**
     * VARCHAR(256)<br>
     * 退款原因
     */
    private String paybackReason;

    /**
     * DECIMAL(16,2)<br>
     * 本次可提货金额
     */
    private BigDecimal pickAmt;

    /**
     * DECIMAL(16,2)<br>
     * 本次追加保证金
     */
    private BigDecimal addBailAmt;

    /**
     * DECIMAL(16,2)<br>
     * 核心保证金金额
     */
    private BigDecimal coreBailAmt;

    /**
     * DECIMAL(10,6)<br>
     * 初始自有资金比例
     */
    private BigDecimal initAmtPercent;

    /**
     * DECIMAL(16,2)<br>
     * 现金等价物金额
     */
    private BigDecimal cashEqtAmt;

    /**
     * DECIMAL(16,2)<br>
     * 借据金额
     */
    private BigDecimal lnciAmt;

    /**
     * DECIMAL(16,2)<br>
     * 借据余额
     */
    private BigDecimal lnciBal;

    /**
     * DECIMAL(16,2)<br>
     * 敞口金额
     */
    private BigDecimal riskAmt;

    /**
     * VARCHAR(32)<br>
     * 客户经理
     */
    private String mgrno;

    /**
     * VARCHAR(20)<br>
     * 经办机构
     */
    private String brcode;

    /**
     * VARCHAR(10)<br>
     * 业务品种
     */
    private String bussType;

    /**
     * VARCHAR(20)<br>
     * 票款确认书编号
     */
    private String num;

    /**
     * CHAR(1)<br>
     * 首笔保证金提货模式：1-首笔保证金可全额提货、2-首笔保证金在后期按比例提货、3-首笔保证金全额最后提货
     */
    private String firstBailType;

    /**
     * CHAR(4)<br>
     * 业务申请类型
     */
    private String applyType;

    /**
     * CHAR(8)<br>
     * 创建日期
     */
    private String createDate;

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
     * VARCHAR(15)<br>
     * 获得 客户号/买方客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 客户号/买方客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 上游厂商客户号/卖方客户号
     */
    public String getUpCustcd() {
        return upCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 上游厂商客户号/卖方客户号
     */
    public void setUpCustcd(String upCustcd) {
        this.upCustcd = upCustcd == null ? null : upCustcd.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 监管公司客户号
     */
    public String getMoniCustcd() {
        return moniCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 监管公司客户号
     */
    public void setMoniCustcd(String moniCustcd) {
        this.moniCustcd = moniCustcd == null ? null : moniCustcd.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 担保方客户号
     */
    public String getGuaranteeCustcd() {
        return guaranteeCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 担保方客户号
     */
    public void setGuaranteeCustcd(String guaranteeCustcd) {
        this.guaranteeCustcd = guaranteeCustcd == null ? null : guaranteeCustcd.trim();
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
     * VARCHAR(20)<br>
     * 获得 关联预付款协议号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 关联预付款协议号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 监管协议号
     */
    public String getMoniProtocolNo() {
        return moniProtocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 监管协议号
     */
    public void setMoniProtocolNo(String moniProtocolNo) {
        this.moniProtocolNo = moniProtocolNo == null ? null : moniProtocolNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 质押合同号
     */
    public String getSlaveContno() {
        return slaveContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 质押合同号
     */
    public void setSlaveContno(String slaveContno) {
        this.slaveContno = slaveContno == null ? null : slaveContno.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 通用金额
     */
    public BigDecimal getCommonAmt() {
        return commonAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 通用金额
     */
    public void setCommonAmt(BigDecimal commonAmt) {
        this.commonAmt = commonAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 收款金额
     */
    public BigDecimal getCollectedAmt() {
        return collectedAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 收款金额
     */
    public void setCollectedAmt(BigDecimal collectedAmt) {
        this.collectedAmt = collectedAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 已发货金额
     */
    public BigDecimal getDeliveryAmt() {
        return deliveryAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 已发货金额
     */
    public void setDeliveryAmt(BigDecimal deliveryAmt) {
        this.deliveryAmt = deliveryAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 未发货金额
     */
    public BigDecimal getUndeliveryAmt() {
        return undeliveryAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 未发货金额
     */
    public void setUndeliveryAmt(BigDecimal undeliveryAmt) {
        this.undeliveryAmt = undeliveryAmt;
    }

    /**
     * DECIMAL(22)<br>
     * 获得 退款期限
     */
    public BigDecimal getPaybackTerm() {
        return paybackTerm;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 退款期限
     */
    public void setPaybackTerm(BigDecimal paybackTerm) {
        this.paybackTerm = paybackTerm;
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
    public String getPaybackAcctNo() {
        return paybackAcctNo;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 退款账号
     */
    public void setPaybackAcctNo(String paybackAcctNo) {
        this.paybackAcctNo = paybackAcctNo == null ? null : paybackAcctNo.trim();
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
     * VARCHAR(256)<br>
     * 获得 退款原因
     */
    public String getPaybackReason() {
        return paybackReason;
    }

    /**
     * VARCHAR(256)<br>
     * 设置 退款原因
     */
    public void setPaybackReason(String paybackReason) {
        this.paybackReason = paybackReason == null ? null : paybackReason.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 本次可提货金额
     */
    public BigDecimal getPickAmt() {
        return pickAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 本次可提货金额
     */
    public void setPickAmt(BigDecimal pickAmt) {
        this.pickAmt = pickAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 本次追加保证金
     */
    public BigDecimal getAddBailAmt() {
        return addBailAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 本次追加保证金
     */
    public void setAddBailAmt(BigDecimal addBailAmt) {
        this.addBailAmt = addBailAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 核心保证金金额
     */
    public BigDecimal getCoreBailAmt() {
        return coreBailAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 核心保证金金额
     */
    public void setCoreBailAmt(BigDecimal coreBailAmt) {
        this.coreBailAmt = coreBailAmt;
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 初始自有资金比例
     */
    public BigDecimal getInitAmtPercent() {
        return initAmtPercent;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 初始自有资金比例
     */
    public void setInitAmtPercent(BigDecimal initAmtPercent) {
        this.initAmtPercent = initAmtPercent;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 现金等价物金额
     */
    public BigDecimal getCashEqtAmt() {
        return cashEqtAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 现金等价物金额
     */
    public void setCashEqtAmt(BigDecimal cashEqtAmt) {
        this.cashEqtAmt = cashEqtAmt;
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
     * DECIMAL(16,2)<br>
     * 获得 敞口金额
     */
    public BigDecimal getRiskAmt() {
        return riskAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 敞口金额
     */
    public void setRiskAmt(BigDecimal riskAmt) {
        this.riskAmt = riskAmt;
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
     * VARCHAR(20)<br>
     * 获得 经办机构
     */
    public String getBrcode() {
        return brcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 经办机构
     */
    public void setBrcode(String brcode) {
        this.brcode = brcode == null ? null : brcode.trim();
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
     * VARCHAR(20)<br>
     * 获得 票款确认书编号
     */
    public String getNum() {
        return num;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 票款确认书编号
     */
    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 首笔保证金提货模式：1-首笔保证金可全额提货、2-首笔保证金在后期按比例提货、3-首笔保证金全额最后提货
     */
    public String getFirstBailType() {
        return firstBailType;
    }

    /**
     * CHAR(1)<br>
     * 设置 首笔保证金提货模式：1-首笔保证金可全额提货、2-首笔保证金在后期按比例提货、3-首笔保证金全额最后提货
     */
    public void setFirstBailType(String firstBailType) {
        this.firstBailType = firstBailType == null ? null : firstBailType.trim();
    }

    /**
     * CHAR(4)<br>
     * 获得 业务申请类型
     */
    public String getApplyType() {
        return applyType;
    }

    /**
     * CHAR(4)<br>
     * 设置 业务申请类型
     */
    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 创建日期
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 创建日期
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
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
        sb.append(", upCustcd=").append(upCustcd);
        sb.append(", moniCustcd=").append(moniCustcd);
        sb.append(", guaranteeCustcd=").append(guaranteeCustcd);
        sb.append(", debetNo=").append(debetNo);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", moniProtocolNo=").append(moniProtocolNo);
        sb.append(", slaveContno=").append(slaveContno);
        sb.append(", commonAmt=").append(commonAmt);
        sb.append(", collectedAmt=").append(collectedAmt);
        sb.append(", deliveryAmt=").append(deliveryAmt);
        sb.append(", undeliveryAmt=").append(undeliveryAmt);
        sb.append(", paybackTerm=").append(paybackTerm);
        sb.append(", payee=").append(payee);
        sb.append(", paybackAcctNo=").append(paybackAcctNo);
        sb.append(", depositBank=").append(depositBank);
        sb.append(", paybackReason=").append(paybackReason);
        sb.append(", pickAmt=").append(pickAmt);
        sb.append(", addBailAmt=").append(addBailAmt);
        sb.append(", coreBailAmt=").append(coreBailAmt);
        sb.append(", initAmtPercent=").append(initAmtPercent);
        sb.append(", cashEqtAmt=").append(cashEqtAmt);
        sb.append(", lnciAmt=").append(lnciAmt);
        sb.append(", lnciBal=").append(lnciBal);
        sb.append(", riskAmt=").append(riskAmt);
        sb.append(", mgrno=").append(mgrno);
        sb.append(", brcode=").append(brcode);
        sb.append(", bussType=").append(bussType);
        sb.append(", num=").append(num);
        sb.append(", firstBailType=").append(firstBailType);
        sb.append(", applyType=").append(applyType);
        sb.append(", createDate=").append(createDate);
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
        ABcpAppliImprestBuss other = (ABcpAppliImprestBuss) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getUpCustcd() == null ? other.getUpCustcd() == null : this.getUpCustcd().equals(other.getUpCustcd()))
            && (this.getMoniCustcd() == null ? other.getMoniCustcd() == null : this.getMoniCustcd().equals(other.getMoniCustcd()))
            && (this.getGuaranteeCustcd() == null ? other.getGuaranteeCustcd() == null : this.getGuaranteeCustcd().equals(other.getGuaranteeCustcd()))
            && (this.getDebetNo() == null ? other.getDebetNo() == null : this.getDebetNo().equals(other.getDebetNo()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getMoniProtocolNo() == null ? other.getMoniProtocolNo() == null : this.getMoniProtocolNo().equals(other.getMoniProtocolNo()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
            && (this.getCommonAmt() == null ? other.getCommonAmt() == null : this.getCommonAmt().equals(other.getCommonAmt()))
            && (this.getCollectedAmt() == null ? other.getCollectedAmt() == null : this.getCollectedAmt().equals(other.getCollectedAmt()))
            && (this.getDeliveryAmt() == null ? other.getDeliveryAmt() == null : this.getDeliveryAmt().equals(other.getDeliveryAmt()))
            && (this.getUndeliveryAmt() == null ? other.getUndeliveryAmt() == null : this.getUndeliveryAmt().equals(other.getUndeliveryAmt()))
            && (this.getPaybackTerm() == null ? other.getPaybackTerm() == null : this.getPaybackTerm().equals(other.getPaybackTerm()))
            && (this.getPayee() == null ? other.getPayee() == null : this.getPayee().equals(other.getPayee()))
            && (this.getPaybackAcctNo() == null ? other.getPaybackAcctNo() == null : this.getPaybackAcctNo().equals(other.getPaybackAcctNo()))
            && (this.getDepositBank() == null ? other.getDepositBank() == null : this.getDepositBank().equals(other.getDepositBank()))
            && (this.getPaybackReason() == null ? other.getPaybackReason() == null : this.getPaybackReason().equals(other.getPaybackReason()))
            && (this.getPickAmt() == null ? other.getPickAmt() == null : this.getPickAmt().equals(other.getPickAmt()))
            && (this.getAddBailAmt() == null ? other.getAddBailAmt() == null : this.getAddBailAmt().equals(other.getAddBailAmt()))
            && (this.getCoreBailAmt() == null ? other.getCoreBailAmt() == null : this.getCoreBailAmt().equals(other.getCoreBailAmt()))
            && (this.getInitAmtPercent() == null ? other.getInitAmtPercent() == null : this.getInitAmtPercent().equals(other.getInitAmtPercent()))
            && (this.getCashEqtAmt() == null ? other.getCashEqtAmt() == null : this.getCashEqtAmt().equals(other.getCashEqtAmt()))
            && (this.getLnciAmt() == null ? other.getLnciAmt() == null : this.getLnciAmt().equals(other.getLnciAmt()))
            && (this.getLnciBal() == null ? other.getLnciBal() == null : this.getLnciBal().equals(other.getLnciBal()))
            && (this.getRiskAmt() == null ? other.getRiskAmt() == null : this.getRiskAmt().equals(other.getRiskAmt()))
            && (this.getMgrno() == null ? other.getMgrno() == null : this.getMgrno().equals(other.getMgrno()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getBussType() == null ? other.getBussType() == null : this.getBussType().equals(other.getBussType()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getFirstBailType() == null ? other.getFirstBailType() == null : this.getFirstBailType().equals(other.getFirstBailType()))
            && (this.getApplyType() == null ? other.getApplyType() == null : this.getApplyType().equals(other.getApplyType()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getUpCustcd() == null) ? 0 : getUpCustcd().hashCode());
        result = prime * result + ((getMoniCustcd() == null) ? 0 : getMoniCustcd().hashCode());
        result = prime * result + ((getGuaranteeCustcd() == null) ? 0 : getGuaranteeCustcd().hashCode());
        result = prime * result + ((getDebetNo() == null) ? 0 : getDebetNo().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getMoniProtocolNo() == null) ? 0 : getMoniProtocolNo().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        result = prime * result + ((getCommonAmt() == null) ? 0 : getCommonAmt().hashCode());
        result = prime * result + ((getCollectedAmt() == null) ? 0 : getCollectedAmt().hashCode());
        result = prime * result + ((getDeliveryAmt() == null) ? 0 : getDeliveryAmt().hashCode());
        result = prime * result + ((getUndeliveryAmt() == null) ? 0 : getUndeliveryAmt().hashCode());
        result = prime * result + ((getPaybackTerm() == null) ? 0 : getPaybackTerm().hashCode());
        result = prime * result + ((getPayee() == null) ? 0 : getPayee().hashCode());
        result = prime * result + ((getPaybackAcctNo() == null) ? 0 : getPaybackAcctNo().hashCode());
        result = prime * result + ((getDepositBank() == null) ? 0 : getDepositBank().hashCode());
        result = prime * result + ((getPaybackReason() == null) ? 0 : getPaybackReason().hashCode());
        result = prime * result + ((getPickAmt() == null) ? 0 : getPickAmt().hashCode());
        result = prime * result + ((getAddBailAmt() == null) ? 0 : getAddBailAmt().hashCode());
        result = prime * result + ((getCoreBailAmt() == null) ? 0 : getCoreBailAmt().hashCode());
        result = prime * result + ((getInitAmtPercent() == null) ? 0 : getInitAmtPercent().hashCode());
        result = prime * result + ((getCashEqtAmt() == null) ? 0 : getCashEqtAmt().hashCode());
        result = prime * result + ((getLnciAmt() == null) ? 0 : getLnciAmt().hashCode());
        result = prime * result + ((getLnciBal() == null) ? 0 : getLnciBal().hashCode());
        result = prime * result + ((getRiskAmt() == null) ? 0 : getRiskAmt().hashCode());
        result = prime * result + ((getMgrno() == null) ? 0 : getMgrno().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getBussType() == null) ? 0 : getBussType().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getFirstBailType() == null) ? 0 : getFirstBailType().hashCode());
        result = prime * result + ((getApplyType() == null) ? 0 : getApplyType().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        return result;
    }
}
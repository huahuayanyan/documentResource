package com.huateng.scf.rec.wrn.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BWrnRiskOfInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * DECIMAL(16,2)<br>
     * 预警基表主键
     */
    private BigDecimal warnId;

    /**
     * VARCHAR(20)<br>
     * 业务合同号
     */
    private String bussContno;

    /**
     * VARCHAR(10)<br>
     * 业务品种
     */
    private String productId;

    /**
     * VARCHAR(15)<br>
     * 卖方客户号
     */
    private String sellerCustcd;

    /**
     * VARCHAR(80)<br>
     * 卖方名称
     */
    private String sellerName;

    /**
     * VARCHAR(20)<br>
     * 信贷合同表主键
     */
    private String mastContno;

    /**
     * VARCHAR(200)<br>
     * 信贷合同号
     */
    private String mastContcode;

    /**
     * VARCHAR(50)<br>
     * 出账流水号
     */
    private String loanAppno;

    /**
     * VARCHAR(100)<br>
     * 借据号/承兑协议号
     */
    private String debetId;

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
     * 池/应收账款总金额/池票据总金额
     */
    private BigDecimal debtAmt;

    /**
     * DECIMAL(10,6)<br>
     * 融资比例
     */
    private BigDecimal loanPercent;

    /**
     * DECIMAL(16,2)<br>
     * 保证金总额
     */
    private BigDecimal bailAmt;

    /**
     * DECIMAL(16,2)<br>
     * 现金等价物总额
     */
    private BigDecimal cashEqtAmt;

    /**
     * DECIMAL(16,2)<br>
     * 敞口余额
     */
    private BigDecimal riskAmt;

    /**
     * DECIMAL(16,2)<br>
     * 敞口暴露金额
     */
    private BigDecimal overflowAmt;

    /**
     * DECIMAL(10,6)<br>
     * 票据池质押率(%)
     */
    private BigDecimal ratio;

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
     * DECIMAL(16,2)<br>
     * 获得 预警基表主键
     */
    public BigDecimal getWarnId() {
        return warnId;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 预警基表主键
     */
    public void setWarnId(BigDecimal warnId) {
        this.warnId = warnId;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 业务合同号
     */
    public String getBussContno() {
        return bussContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 业务合同号
     */
    public void setBussContno(String bussContno) {
        this.bussContno = bussContno == null ? null : bussContno.trim();
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
     * 获得 卖方客户号
     */
    public String getSellerCustcd() {
        return sellerCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 卖方客户号
     */
    public void setSellerCustcd(String sellerCustcd) {
        this.sellerCustcd = sellerCustcd == null ? null : sellerCustcd.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 卖方名称
     */
    public String getSellerName() {
        return sellerName;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 卖方名称
     */
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName == null ? null : sellerName.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 信贷合同表主键
     */
    public String getMastContno() {
        return mastContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 信贷合同表主键
     */
    public void setMastContno(String mastContno) {
        this.mastContno = mastContno == null ? null : mastContno.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 信贷合同号
     */
    public String getMastContcode() {
        return mastContcode;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 信贷合同号
     */
    public void setMastContcode(String mastContcode) {
        this.mastContcode = mastContcode == null ? null : mastContcode.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 出账流水号
     */
    public String getLoanAppno() {
        return loanAppno;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 出账流水号
     */
    public void setLoanAppno(String loanAppno) {
        this.loanAppno = loanAppno == null ? null : loanAppno.trim();
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
     * 获得 池/应收账款总金额/池票据总金额
     */
    public BigDecimal getDebtAmt() {
        return debtAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 池/应收账款总金额/池票据总金额
     */
    public void setDebtAmt(BigDecimal debtAmt) {
        this.debtAmt = debtAmt;
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 融资比例
     */
    public BigDecimal getLoanPercent() {
        return loanPercent;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 融资比例
     */
    public void setLoanPercent(BigDecimal loanPercent) {
        this.loanPercent = loanPercent;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 保证金总额
     */
    public BigDecimal getBailAmt() {
        return bailAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 保证金总额
     */
    public void setBailAmt(BigDecimal bailAmt) {
        this.bailAmt = bailAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 现金等价物总额
     */
    public BigDecimal getCashEqtAmt() {
        return cashEqtAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 现金等价物总额
     */
    public void setCashEqtAmt(BigDecimal cashEqtAmt) {
        this.cashEqtAmt = cashEqtAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 敞口余额
     */
    public BigDecimal getRiskAmt() {
        return riskAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 敞口余额
     */
    public void setRiskAmt(BigDecimal riskAmt) {
        this.riskAmt = riskAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 敞口暴露金额
     */
    public BigDecimal getOverflowAmt() {
        return overflowAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 敞口暴露金额
     */
    public void setOverflowAmt(BigDecimal overflowAmt) {
        this.overflowAmt = overflowAmt;
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 票据池质押率(%)
     */
    public BigDecimal getRatio() {
        return ratio;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 票据池质押率(%)
     */
    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", warnId=").append(warnId);
        sb.append(", bussContno=").append(bussContno);
        sb.append(", productId=").append(productId);
        sb.append(", sellerCustcd=").append(sellerCustcd);
        sb.append(", sellerName=").append(sellerName);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", mastContcode=").append(mastContcode);
        sb.append(", loanAppno=").append(loanAppno);
        sb.append(", debetId=").append(debetId);
        sb.append(", lnciAmt=").append(lnciAmt);
        sb.append(", lnciBal=").append(lnciBal);
        sb.append(", debtAmt=").append(debtAmt);
        sb.append(", loanPercent=").append(loanPercent);
        sb.append(", bailAmt=").append(bailAmt);
        sb.append(", cashEqtAmt=").append(cashEqtAmt);
        sb.append(", riskAmt=").append(riskAmt);
        sb.append(", overflowAmt=").append(overflowAmt);
        sb.append(", ratio=").append(ratio);
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
        BWrnRiskOfInfo other = (BWrnRiskOfInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWarnId() == null ? other.getWarnId() == null : this.getWarnId().equals(other.getWarnId()))
            && (this.getBussContno() == null ? other.getBussContno() == null : this.getBussContno().equals(other.getBussContno()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getSellerCustcd() == null ? other.getSellerCustcd() == null : this.getSellerCustcd().equals(other.getSellerCustcd()))
            && (this.getSellerName() == null ? other.getSellerName() == null : this.getSellerName().equals(other.getSellerName()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getMastContcode() == null ? other.getMastContcode() == null : this.getMastContcode().equals(other.getMastContcode()))
            && (this.getLoanAppno() == null ? other.getLoanAppno() == null : this.getLoanAppno().equals(other.getLoanAppno()))
            && (this.getDebetId() == null ? other.getDebetId() == null : this.getDebetId().equals(other.getDebetId()))
            && (this.getLnciAmt() == null ? other.getLnciAmt() == null : this.getLnciAmt().equals(other.getLnciAmt()))
            && (this.getLnciBal() == null ? other.getLnciBal() == null : this.getLnciBal().equals(other.getLnciBal()))
            && (this.getDebtAmt() == null ? other.getDebtAmt() == null : this.getDebtAmt().equals(other.getDebtAmt()))
            && (this.getLoanPercent() == null ? other.getLoanPercent() == null : this.getLoanPercent().equals(other.getLoanPercent()))
            && (this.getBailAmt() == null ? other.getBailAmt() == null : this.getBailAmt().equals(other.getBailAmt()))
            && (this.getCashEqtAmt() == null ? other.getCashEqtAmt() == null : this.getCashEqtAmt().equals(other.getCashEqtAmt()))
            && (this.getRiskAmt() == null ? other.getRiskAmt() == null : this.getRiskAmt().equals(other.getRiskAmt()))
            && (this.getOverflowAmt() == null ? other.getOverflowAmt() == null : this.getOverflowAmt().equals(other.getOverflowAmt()))
            && (this.getRatio() == null ? other.getRatio() == null : this.getRatio().equals(other.getRatio()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWarnId() == null) ? 0 : getWarnId().hashCode());
        result = prime * result + ((getBussContno() == null) ? 0 : getBussContno().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getSellerCustcd() == null) ? 0 : getSellerCustcd().hashCode());
        result = prime * result + ((getSellerName() == null) ? 0 : getSellerName().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getMastContcode() == null) ? 0 : getMastContcode().hashCode());
        result = prime * result + ((getLoanAppno() == null) ? 0 : getLoanAppno().hashCode());
        result = prime * result + ((getDebetId() == null) ? 0 : getDebetId().hashCode());
        result = prime * result + ((getLnciAmt() == null) ? 0 : getLnciAmt().hashCode());
        result = prime * result + ((getLnciBal() == null) ? 0 : getLnciBal().hashCode());
        result = prime * result + ((getDebtAmt() == null) ? 0 : getDebtAmt().hashCode());
        result = prime * result + ((getLoanPercent() == null) ? 0 : getLoanPercent().hashCode());
        result = prime * result + ((getBailAmt() == null) ? 0 : getBailAmt().hashCode());
        result = prime * result + ((getCashEqtAmt() == null) ? 0 : getCashEqtAmt().hashCode());
        result = prime * result + ((getRiskAmt() == null) ? 0 : getRiskAmt().hashCode());
        result = prime * result + ((getOverflowAmt() == null) ? 0 : getOverflowAmt().hashCode());
        result = prime * result + ((getRatio() == null) ? 0 : getRatio().hashCode());
        return result;
    }
}
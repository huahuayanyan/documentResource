package com.huateng.scf.rec.bcp.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class RBcpDebtPool implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 应收账款池合同号
     */
    private String mastContno;

    /**
     * VARCHAR(15)<br>
     * 卖方客户号
     */
    private String custcdSaller;

    /**
     * VARCHAR(15)<br>
     * 买方客户号
     */
    private String custcdBuyer;

    /**
     * CHAR(8)<br>
     * 创建日期
     */
    private String insertDate;

    /**
     * DECIMAL(22)<br>
     * 发票份数
     */
    private BigDecimal debtNum;

    /**
     * DECIMAL(16,2)<br>
     * 发票总金额
     */
    private BigDecimal totalDebtAmount;

    /**
     * DECIMAL(16,2)<br>
     * 发票总余额
     */
    private BigDecimal totalDebtRemainAmount;

    /**
     * DECIMAL(16,2)<br>
     * 现金总金额
     */
    private BigDecimal totalCashAmount;

    /**
     * DECIMAL(16,2)<br>
     * 融资总余额
     */
    private BigDecimal poolRemainingAmount;

    /**
     * DECIMAL(16,2)<br>
     * 可融资总余额：发票余额*比率+现金余额-融资余额
     */
    private BigDecimal poolUseableAmount;

    /**
     * VARCHAR(10)<br>
     * 业务品种
     */
    private String bussType;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * CHAR(500)<br>
     * 备注
     */
    private String memo;

    /**
     * DECIMAL(16,2)<br>
     * 利息总余额
     */
    private BigDecimal totalRateRemainAmount;

    /**
     * DECIMAL(16,2)<br>
     * 利息总金额
     */
    private BigDecimal totalRateAmount;

    /**
     * DECIMAL(16,2)<br>
     * 融资总金额
     */
    private BigDecimal totalCapitalAmount;

    /**
     * DECIMAL(16,2)<br>
     * 已还本总金额
     */
    private BigDecimal refundAmount;

    /**
     * DECIMAL(16,2)<br>
     * 已还息总金额
     */
    private BigDecimal returnRateAmount;

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
     * 获得 应收账款池合同号
     */
    public String getMastContno() {
        return mastContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 应收账款池合同号
     */
    public void setMastContno(String mastContno) {
        this.mastContno = mastContno == null ? null : mastContno.trim();
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
     * CHAR(8)<br>
     * 获得 创建日期
     */
    public String getInsertDate() {
        return insertDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 创建日期
     */
    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate == null ? null : insertDate.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 发票份数
     */
    public BigDecimal getDebtNum() {
        return debtNum;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 发票份数
     */
    public void setDebtNum(BigDecimal debtNum) {
        this.debtNum = debtNum;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 发票总金额
     */
    public BigDecimal getTotalDebtAmount() {
        return totalDebtAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 发票总金额
     */
    public void setTotalDebtAmount(BigDecimal totalDebtAmount) {
        this.totalDebtAmount = totalDebtAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 发票总余额
     */
    public BigDecimal getTotalDebtRemainAmount() {
        return totalDebtRemainAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 发票总余额
     */
    public void setTotalDebtRemainAmount(BigDecimal totalDebtRemainAmount) {
        this.totalDebtRemainAmount = totalDebtRemainAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 现金总金额
     */
    public BigDecimal getTotalCashAmount() {
        return totalCashAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 现金总金额
     */
    public void setTotalCashAmount(BigDecimal totalCashAmount) {
        this.totalCashAmount = totalCashAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 融资总余额
     */
    public BigDecimal getPoolRemainingAmount() {
        return poolRemainingAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 融资总余额
     */
    public void setPoolRemainingAmount(BigDecimal poolRemainingAmount) {
        this.poolRemainingAmount = poolRemainingAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 可融资总余额：发票余额*比率+现金余额-融资余额
     */
    public BigDecimal getPoolUseableAmount() {
        return poolUseableAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 可融资总余额：发票余额*比率+现金余额-融资余额
     */
    public void setPoolUseableAmount(BigDecimal poolUseableAmount) {
        this.poolUseableAmount = poolUseableAmount;
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
     * DECIMAL(16,2)<br>
     * 获得 利息总余额
     */
    public BigDecimal getTotalRateRemainAmount() {
        return totalRateRemainAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 利息总余额
     */
    public void setTotalRateRemainAmount(BigDecimal totalRateRemainAmount) {
        this.totalRateRemainAmount = totalRateRemainAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 利息总金额
     */
    public BigDecimal getTotalRateAmount() {
        return totalRateAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 利息总金额
     */
    public void setTotalRateAmount(BigDecimal totalRateAmount) {
        this.totalRateAmount = totalRateAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 融资总金额
     */
    public BigDecimal getTotalCapitalAmount() {
        return totalCapitalAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 融资总金额
     */
    public void setTotalCapitalAmount(BigDecimal totalCapitalAmount) {
        this.totalCapitalAmount = totalCapitalAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 已还本总金额
     */
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 已还本总金额
     */
    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 已还息总金额
     */
    public BigDecimal getReturnRateAmount() {
        return returnRateAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 已还息总金额
     */
    public void setReturnRateAmount(BigDecimal returnRateAmount) {
        this.returnRateAmount = returnRateAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", custcdSaller=").append(custcdSaller);
        sb.append(", custcdBuyer=").append(custcdBuyer);
        sb.append(", insertDate=").append(insertDate);
        sb.append(", debtNum=").append(debtNum);
        sb.append(", totalDebtAmount=").append(totalDebtAmount);
        sb.append(", totalDebtRemainAmount=").append(totalDebtRemainAmount);
        sb.append(", totalCashAmount=").append(totalCashAmount);
        sb.append(", poolRemainingAmount=").append(poolRemainingAmount);
        sb.append(", poolUseableAmount=").append(poolUseableAmount);
        sb.append(", bussType=").append(bussType);
        sb.append(", curcd=").append(curcd);
        sb.append(", memo=").append(memo);
        sb.append(", totalRateRemainAmount=").append(totalRateRemainAmount);
        sb.append(", totalRateAmount=").append(totalRateAmount);
        sb.append(", totalCapitalAmount=").append(totalCapitalAmount);
        sb.append(", refundAmount=").append(refundAmount);
        sb.append(", returnRateAmount=").append(returnRateAmount);
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
        RBcpDebtPool other = (RBcpDebtPool) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getCustcdSaller() == null ? other.getCustcdSaller() == null : this.getCustcdSaller().equals(other.getCustcdSaller()))
            && (this.getCustcdBuyer() == null ? other.getCustcdBuyer() == null : this.getCustcdBuyer().equals(other.getCustcdBuyer()))
            && (this.getInsertDate() == null ? other.getInsertDate() == null : this.getInsertDate().equals(other.getInsertDate()))
            && (this.getDebtNum() == null ? other.getDebtNum() == null : this.getDebtNum().equals(other.getDebtNum()))
            && (this.getTotalDebtAmount() == null ? other.getTotalDebtAmount() == null : this.getTotalDebtAmount().equals(other.getTotalDebtAmount()))
            && (this.getTotalDebtRemainAmount() == null ? other.getTotalDebtRemainAmount() == null : this.getTotalDebtRemainAmount().equals(other.getTotalDebtRemainAmount()))
            && (this.getTotalCashAmount() == null ? other.getTotalCashAmount() == null : this.getTotalCashAmount().equals(other.getTotalCashAmount()))
            && (this.getPoolRemainingAmount() == null ? other.getPoolRemainingAmount() == null : this.getPoolRemainingAmount().equals(other.getPoolRemainingAmount()))
            && (this.getPoolUseableAmount() == null ? other.getPoolUseableAmount() == null : this.getPoolUseableAmount().equals(other.getPoolUseableAmount()))
            && (this.getBussType() == null ? other.getBussType() == null : this.getBussType().equals(other.getBussType()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getTotalRateRemainAmount() == null ? other.getTotalRateRemainAmount() == null : this.getTotalRateRemainAmount().equals(other.getTotalRateRemainAmount()))
            && (this.getTotalRateAmount() == null ? other.getTotalRateAmount() == null : this.getTotalRateAmount().equals(other.getTotalRateAmount()))
            && (this.getTotalCapitalAmount() == null ? other.getTotalCapitalAmount() == null : this.getTotalCapitalAmount().equals(other.getTotalCapitalAmount()))
            && (this.getRefundAmount() == null ? other.getRefundAmount() == null : this.getRefundAmount().equals(other.getRefundAmount()))
            && (this.getReturnRateAmount() == null ? other.getReturnRateAmount() == null : this.getReturnRateAmount().equals(other.getReturnRateAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getCustcdSaller() == null) ? 0 : getCustcdSaller().hashCode());
        result = prime * result + ((getCustcdBuyer() == null) ? 0 : getCustcdBuyer().hashCode());
        result = prime * result + ((getInsertDate() == null) ? 0 : getInsertDate().hashCode());
        result = prime * result + ((getDebtNum() == null) ? 0 : getDebtNum().hashCode());
        result = prime * result + ((getTotalDebtAmount() == null) ? 0 : getTotalDebtAmount().hashCode());
        result = prime * result + ((getTotalDebtRemainAmount() == null) ? 0 : getTotalDebtRemainAmount().hashCode());
        result = prime * result + ((getTotalCashAmount() == null) ? 0 : getTotalCashAmount().hashCode());
        result = prime * result + ((getPoolRemainingAmount() == null) ? 0 : getPoolRemainingAmount().hashCode());
        result = prime * result + ((getPoolUseableAmount() == null) ? 0 : getPoolUseableAmount().hashCode());
        result = prime * result + ((getBussType() == null) ? 0 : getBussType().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getTotalRateRemainAmount() == null) ? 0 : getTotalRateRemainAmount().hashCode());
        result = prime * result + ((getTotalRateAmount() == null) ? 0 : getTotalRateAmount().hashCode());
        result = prime * result + ((getTotalCapitalAmount() == null) ? 0 : getTotalCapitalAmount().hashCode());
        result = prime * result + ((getRefundAmount() == null) ? 0 : getRefundAmount().hashCode());
        result = prime * result + ((getReturnRateAmount() == null) ? 0 : getReturnRateAmount().hashCode());
        return result;
    }
}
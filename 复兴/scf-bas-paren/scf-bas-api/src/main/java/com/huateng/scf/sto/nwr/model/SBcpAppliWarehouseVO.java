package com.huateng.scf.sto.nwr.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class SBcpAppliWarehouseVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 
     */
    private String appno;

    /**
     * DECIMAL(16,2)<br>
     * 
     */
    private BigDecimal theRPAmount;

    /**
     * DECIMAL(16,2)<br>
     * 
     */
    private BigDecimal riskAmount;

    /**
     * DECIMAL(4,2)<br>
     * 
     */
    private BigDecimal ration;

    /**
     * DECIMAL(16,2)<br>
     * 
     */
    private BigDecimal removePledgeAmount;

    /**
     * DECIMAL(16,2)<br>
     * 
     */
    private BigDecimal removePledgeHighestAmount;

    /**
     * DECIMAL(16,2)<br>
     * 
     */
    private BigDecimal receiptPledgeAmount;

    /**
     * VARCHAR(100)<br>
     * 
     */
    private String description;

    /**
     * VARCHAR(32) 必填<br>
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(32) 必填<br>
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public BigDecimal getTheRPAmount() {
        return theRPAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public void setTheRPAmount(BigDecimal theRPAmount) {
        this.theRPAmount = theRPAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public BigDecimal getRiskAmount() {
        return riskAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public void setRiskAmount(BigDecimal riskAmount) {
        this.riskAmount = riskAmount;
    }

    /**
     * DECIMAL(4,2)<br>
     */
    public BigDecimal getRation() {
        return ration;
    }

    /**
     * DECIMAL(4,2)<br>
     */
    public void setRation(BigDecimal ration) {
        this.ration = ration;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public BigDecimal getRemovePledgeAmount() {
        return removePledgeAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public void setRemovePledgeAmount(BigDecimal removePledgeAmount) {
        this.removePledgeAmount = removePledgeAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public BigDecimal getRemovePledgeHighestAmount() {
        return removePledgeHighestAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public void setRemovePledgeHighestAmount(BigDecimal removePledgeHighestAmount) {
        this.removePledgeHighestAmount = removePledgeHighestAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public BigDecimal getReceiptPledgeAmount() {
        return receiptPledgeAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public void setReceiptPledgeAmount(BigDecimal receiptPledgeAmount) {
        this.receiptPledgeAmount = receiptPledgeAmount;
    }

    /**
     * VARCHAR(100)<br>
     */
    public String getDescription() {
        return description;
    }

    /**
     * VARCHAR(100)<br>
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", appno=").append(appno);
        sb.append(", theRPAmount=").append(theRPAmount);
        sb.append(", riskAmount=").append(riskAmount);
        sb.append(", ration=").append(ration);
        sb.append(", removePledgeAmount=").append(removePledgeAmount);
        sb.append(", removePledgeHighestAmount=").append(removePledgeHighestAmount);
        sb.append(", receiptPledgeAmount=").append(receiptPledgeAmount);
        sb.append(", description=").append(description);
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
        SBcpAppliWarehouseVO other = (SBcpAppliWarehouseVO) that;
        return (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getTheRPAmount() == null ? other.getTheRPAmount() == null : this.getTheRPAmount().equals(other.getTheRPAmount()))
            && (this.getRiskAmount() == null ? other.getRiskAmount() == null : this.getRiskAmount().equals(other.getRiskAmount()))
            && (this.getRation() == null ? other.getRation() == null : this.getRation().equals(other.getRation()))
            && (this.getRemovePledgeAmount() == null ? other.getRemovePledgeAmount() == null : this.getRemovePledgeAmount().equals(other.getRemovePledgeAmount()))
            && (this.getRemovePledgeHighestAmount() == null ? other.getRemovePledgeHighestAmount() == null : this.getRemovePledgeHighestAmount().equals(other.getRemovePledgeHighestAmount()))
            && (this.getReceiptPledgeAmount() == null ? other.getReceiptPledgeAmount() == null : this.getReceiptPledgeAmount().equals(other.getReceiptPledgeAmount()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getTheRPAmount() == null) ? 0 : getTheRPAmount().hashCode());
        result = prime * result + ((getRiskAmount() == null) ? 0 : getRiskAmount().hashCode());
        result = prime * result + ((getRation() == null) ? 0 : getRation().hashCode());
        result = prime * result + ((getRemovePledgeAmount() == null) ? 0 : getRemovePledgeAmount().hashCode());
        result = prime * result + ((getRemovePledgeHighestAmount() == null) ? 0 : getRemovePledgeHighestAmount().hashCode());
        result = prime * result + ((getReceiptPledgeAmount() == null) ? 0 : getReceiptPledgeAmount().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }
}
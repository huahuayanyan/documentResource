package com.huateng.scf.bas.cnt.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * <p>BCntInsuranceBaseInfo</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月24日下午1:34:25
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月24日下午1:34:25	     新增
 *
 * </pre>
 */
public class BCntInsuranceBaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String insuranceNo;

    /**
     * VARCHAR(100)<br>
     * 保单号
     */
    private String insuranceCode;

    /**
     * VARCHAR(100)<br>
     * 保险类型
     */
    private String insuranceType;

    /**
     * VARCHAR(100)<br>
     * 受益人
     */
    private String beneficiary;

    /**
     * DECIMAL(16,2)<br>
     * 保险金额
     */
    private BigDecimal amount;

    /**
     * CHAR(8)<br>
     * 保险投保日
     */
    private String startDate;

    /**
     * CHAR(8)<br>
     * 保险到期日
     */
    private String endDate;

    /**
     * VARCHAR(20)<br>
     * 质押合同编号
     */
    private String slaveContno;

    /**
     * VARCHAR(120)<br>
     * 保险公司名称
     */
    private String insuranceName;

    /**
     * CHAR(500)<br>
     * 备注
     */
    private String memo;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 主键
     */
    public String getInsuranceNo() {
        return insuranceNo;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 主键
     */
    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo == null ? null : insuranceNo.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 保单号
     */
    public String getInsuranceCode() {
        return insuranceCode;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 保单号
     */
    public void setInsuranceCode(String insuranceCode) {
        this.insuranceCode = insuranceCode == null ? null : insuranceCode.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 保险类型
     */
    public String getInsuranceType() {
        return insuranceType;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 保险类型
     */
    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType == null ? null : insuranceType.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 受益人
     */
    public String getBeneficiary() {
        return beneficiary;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 受益人
     */
    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary == null ? null : beneficiary.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 保险金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 保险金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * CHAR(8)<br>
     * 获得 保险投保日
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 保险投保日
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 保险到期日
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 保险到期日
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 质押合同编号
     */
    public String getSlaveContno() {
        return slaveContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 质押合同编号
     */
    public void setSlaveContno(String slaveContno) {
        this.slaveContno = slaveContno == null ? null : slaveContno.trim();
    }

    /**
     * VARCHAR(120)<br>
     * 获得 保险公司名称
     */
    public String getInsuranceName() {
        return insuranceName;
    }

    /**
     * VARCHAR(120)<br>
     * 设置 保险公司名称
     */
    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName == null ? null : insuranceName.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", insuranceNo=").append(insuranceNo);
        sb.append(", insuranceCode=").append(insuranceCode);
        sb.append(", insuranceType=").append(insuranceType);
        sb.append(", beneficiary=").append(beneficiary);
        sb.append(", amount=").append(amount);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", slaveContno=").append(slaveContno);
        sb.append(", insuranceName=").append(insuranceName);
        sb.append(", memo=").append(memo);
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
        BCntInsuranceBaseInfo other = (BCntInsuranceBaseInfo) that;
        return (this.getInsuranceNo() == null ? other.getInsuranceNo() == null : this.getInsuranceNo().equals(other.getInsuranceNo()))
            && (this.getInsuranceCode() == null ? other.getInsuranceCode() == null : this.getInsuranceCode().equals(other.getInsuranceCode()))
            && (this.getInsuranceType() == null ? other.getInsuranceType() == null : this.getInsuranceType().equals(other.getInsuranceType()))
            && (this.getBeneficiary() == null ? other.getBeneficiary() == null : this.getBeneficiary().equals(other.getBeneficiary()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
            && (this.getInsuranceName() == null ? other.getInsuranceName() == null : this.getInsuranceName().equals(other.getInsuranceName()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInsuranceNo() == null) ? 0 : getInsuranceNo().hashCode());
        result = prime * result + ((getInsuranceCode() == null) ? 0 : getInsuranceCode().hashCode());
        result = prime * result + ((getInsuranceType() == null) ? 0 : getInsuranceType().hashCode());
        result = prime * result + ((getBeneficiary() == null) ? 0 : getBeneficiary().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        result = prime * result + ((getInsuranceName() == null) ? 0 : getInsuranceName().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        return result;
    }
}
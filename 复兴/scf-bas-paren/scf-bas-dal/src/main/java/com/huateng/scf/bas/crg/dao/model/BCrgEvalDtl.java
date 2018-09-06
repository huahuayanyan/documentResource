package com.huateng.scf.bas.crg.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BCrgEvalDtl implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 
     */
    private String evalDtlId;

    /**
     * VARCHAR(32) 必填<br>
     * 
     */
    private String evalId;

    /**
     * VARCHAR(18) 必填<br>
     * ��������
     */
    private String rltTyp;

    /**
     * VARCHAR(32) 必填<br>
     * ��������
     */
    private String rltId;

    /**
     * VARCHAR(32) 必填<br>
     * 
     */
    private String itNo;

    /**
     * VARCHAR(80)<br>
     * ���ֵ
     */
    private String itVal;

    /**
     * DECIMAL(24,2)<br>
     * ת�������
     */
    private BigDecimal chgVal;

    /**
     * VARCHAR(32) 必填<br>
     */
    public String getEvalDtlId() {
        return evalDtlId;
    }

    /**
     * VARCHAR(32) 必填<br>
     */
    public void setEvalDtlId(String evalDtlId) {
        this.evalDtlId = evalDtlId == null ? null : evalDtlId.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     */
    public String getEvalId() {
        return evalId;
    }

    /**
     * VARCHAR(32) 必填<br>
     */
    public void setEvalId(String evalId) {
        this.evalId = evalId == null ? null : evalId.trim();
    }

    /**
     * VARCHAR(18) 必填<br>
     * 获得 ��������
     */
    public String getRltTyp() {
        return rltTyp;
    }

    /**
     * VARCHAR(18) 必填<br>
     * 设置 ��������
     */
    public void setRltTyp(String rltTyp) {
        this.rltTyp = rltTyp == null ? null : rltTyp.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 ��������
     */
    public String getRltId() {
        return rltId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 ��������
     */
    public void setRltId(String rltId) {
        this.rltId = rltId == null ? null : rltId.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     */
    public String getItNo() {
        return itNo;
    }

    /**
     * VARCHAR(32) 必填<br>
     */
    public void setItNo(String itNo) {
        this.itNo = itNo == null ? null : itNo.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 ���ֵ
     */
    public String getItVal() {
        return itVal;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 ���ֵ
     */
    public void setItVal(String itVal) {
        this.itVal = itVal == null ? null : itVal.trim();
    }

    /**
     * DECIMAL(24,2)<br>
     * 获得 ת�������
     */
    public BigDecimal getChgVal() {
        return chgVal;
    }

    /**
     * DECIMAL(24,2)<br>
     * 设置 ת�������
     */
    public void setChgVal(BigDecimal chgVal) {
        this.chgVal = chgVal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", evalDtlId=").append(evalDtlId);
        sb.append(", evalId=").append(evalId);
        sb.append(", rltTyp=").append(rltTyp);
        sb.append(", rltId=").append(rltId);
        sb.append(", itNo=").append(itNo);
        sb.append(", itVal=").append(itVal);
        sb.append(", chgVal=").append(chgVal);
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
        BCrgEvalDtl other = (BCrgEvalDtl) that;
        return (this.getEvalDtlId() == null ? other.getEvalDtlId() == null : this.getEvalDtlId().equals(other.getEvalDtlId()))
            && (this.getEvalId() == null ? other.getEvalId() == null : this.getEvalId().equals(other.getEvalId()))
            && (this.getRltTyp() == null ? other.getRltTyp() == null : this.getRltTyp().equals(other.getRltTyp()))
            && (this.getRltId() == null ? other.getRltId() == null : this.getRltId().equals(other.getRltId()))
            && (this.getItNo() == null ? other.getItNo() == null : this.getItNo().equals(other.getItNo()))
            && (this.getItVal() == null ? other.getItVal() == null : this.getItVal().equals(other.getItVal()))
            && (this.getChgVal() == null ? other.getChgVal() == null : this.getChgVal().equals(other.getChgVal()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEvalDtlId() == null) ? 0 : getEvalDtlId().hashCode());
        result = prime * result + ((getEvalId() == null) ? 0 : getEvalId().hashCode());
        result = prime * result + ((getRltTyp() == null) ? 0 : getRltTyp().hashCode());
        result = prime * result + ((getRltId() == null) ? 0 : getRltId().hashCode());
        result = prime * result + ((getItNo() == null) ? 0 : getItNo().hashCode());
        result = prime * result + ((getItVal() == null) ? 0 : getItVal().hashCode());
        result = prime * result + ((getChgVal() == null) ? 0 : getChgVal().hashCode());
        return result;
    }
}
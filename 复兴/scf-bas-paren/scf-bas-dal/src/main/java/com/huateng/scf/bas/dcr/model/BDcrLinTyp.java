package com.huateng.scf.bas.dcr.model;

import java.io.Serializable;

public class BDcrLinTyp implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 额度类型编号
     */
    private String crId;

    /**
     * VARCHAR(80)<br>
     * 额度类型名称
     */
    private String crNm;

    /**
     * VARCHAR(300)<br>
     * 额度判断类名
     */
    private String chkExpr;

    /**
     * CHAR(1)<br>
     * 生效标志
     */
    private String stat;

    /**
     * CHAR(1)<br>
     * 循环标志
     */
    private String circFlag;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 额度类型编号
     */
    public String getCrId() {
        return crId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 额度类型编号
     */
    public void setCrId(String crId) {
        this.crId = crId == null ? null : crId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 额度类型名称
     */
    public String getCrNm() {
        return crNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 额度类型名称
     */
    public void setCrNm(String crNm) {
        this.crNm = crNm == null ? null : crNm.trim();
    }

    /**
     * VARCHAR(300)<br>
     * 获得 额度判断类名
     */
    public String getChkExpr() {
        return chkExpr;
    }

    /**
     * VARCHAR(300)<br>
     * 设置 额度判断类名
     */
    public void setChkExpr(String chkExpr) {
        this.chkExpr = chkExpr == null ? null : chkExpr.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 生效标志
     */
    public String getStat() {
        return stat;
    }

    /**
     * CHAR(1)<br>
     * 设置 生效标志
     */
    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 循环标志
     */
    public String getCircFlag() {
        return circFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 循环标志
     */
    public void setCircFlag(String circFlag) {
        this.circFlag = circFlag == null ? null : circFlag.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", crId=").append(crId);
        sb.append(", crNm=").append(crNm);
        sb.append(", chkExpr=").append(chkExpr);
        sb.append(", stat=").append(stat);
        sb.append(", circFlag=").append(circFlag);
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
        BDcrLinTyp other = (BDcrLinTyp) that;
        return (this.getCrId() == null ? other.getCrId() == null : this.getCrId().equals(other.getCrId()))
            && (this.getCrNm() == null ? other.getCrNm() == null : this.getCrNm().equals(other.getCrNm()))
            && (this.getChkExpr() == null ? other.getChkExpr() == null : this.getChkExpr().equals(other.getChkExpr()))
            && (this.getStat() == null ? other.getStat() == null : this.getStat().equals(other.getStat()))
            && (this.getCircFlag() == null ? other.getCircFlag() == null : this.getCircFlag().equals(other.getCircFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCrId() == null) ? 0 : getCrId().hashCode());
        result = prime * result + ((getCrNm() == null) ? 0 : getCrNm().hashCode());
        result = prime * result + ((getChkExpr() == null) ? 0 : getChkExpr().hashCode());
        result = prime * result + ((getStat() == null) ? 0 : getStat().hashCode());
        result = prime * result + ((getCircFlag() == null) ? 0 : getCircFlag().hashCode());
        return result;
    }
}
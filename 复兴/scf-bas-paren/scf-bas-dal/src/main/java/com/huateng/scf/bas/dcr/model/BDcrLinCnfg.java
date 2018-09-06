package com.huateng.scf.bas.dcr.model;

import java.io.Serializable;

public class BDcrLinCnfg implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 检查类型ID
     */
    private String typId;

    /**
     * VARCHAR(80)<br>
     * 检查类型说明
     */
    private String typNm;

    /**
     * VARCHAR(200)<br>
     * 检查器类名
     */
    private String chkExpr;

    /**
     * VARCHAR(32)<br>
     * 检查对象类型
     */
    private String rltTyp;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 检查类型ID
     */
    public String getTypId() {
        return typId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 检查类型ID
     */
    public void setTypId(String typId) {
        this.typId = typId == null ? null : typId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 检查类型说明
     */
    public String getTypNm() {
        return typNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 检查类型说明
     */
    public void setTypNm(String typNm) {
        this.typNm = typNm == null ? null : typNm.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 检查器类名
     */
    public String getChkExpr() {
        return chkExpr;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 检查器类名
     */
    public void setChkExpr(String chkExpr) {
        this.chkExpr = chkExpr == null ? null : chkExpr.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 检查对象类型
     */
    public String getRltTyp() {
        return rltTyp;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 检查对象类型
     */
    public void setRltTyp(String rltTyp) {
        this.rltTyp = rltTyp == null ? null : rltTyp.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", typId=").append(typId);
        sb.append(", typNm=").append(typNm);
        sb.append(", chkExpr=").append(chkExpr);
        sb.append(", rltTyp=").append(rltTyp);
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
        BDcrLinCnfg other = (BDcrLinCnfg) that;
        return (this.getTypId() == null ? other.getTypId() == null : this.getTypId().equals(other.getTypId()))
            && (this.getTypNm() == null ? other.getTypNm() == null : this.getTypNm().equals(other.getTypNm()))
            && (this.getChkExpr() == null ? other.getChkExpr() == null : this.getChkExpr().equals(other.getChkExpr()))
            && (this.getRltTyp() == null ? other.getRltTyp() == null : this.getRltTyp().equals(other.getRltTyp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTypId() == null) ? 0 : getTypId().hashCode());
        result = prime * result + ((getTypNm() == null) ? 0 : getTypNm().hashCode());
        result = prime * result + ((getChkExpr() == null) ? 0 : getChkExpr().hashCode());
        result = prime * result + ((getRltTyp() == null) ? 0 : getRltTyp().hashCode());
        return result;
    }
}
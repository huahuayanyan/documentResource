package com.huateng.scf.bas.dcr.model;

import java.io.Serializable;

public class BDcrChkDir implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 检查目录ID
     */
    private String chkDirId;

    /**
     * VARCHAR(32) 必填<br>
     * 额度ID
     */
    private String linId;

    /**
     * VARCHAR(18)<br>
     * 检查类型ID
     */
    private String typId;

    /**
     * VARCHAR(32)<br>
     * 检查对象类型
     */
    private String rltTyp;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 检查目录ID
     */
    public String getChkDirId() {
        return chkDirId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 检查目录ID
     */
    public void setChkDirId(String chkDirId) {
        this.chkDirId = chkDirId == null ? null : chkDirId.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 额度ID
     */
    public String getLinId() {
        return linId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 额度ID
     */
    public void setLinId(String linId) {
        this.linId = linId == null ? null : linId.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 检查类型ID
     */
    public String getTypId() {
        return typId;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 检查类型ID
     */
    public void setTypId(String typId) {
        this.typId = typId == null ? null : typId.trim();
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
        sb.append(", chkDirId=").append(chkDirId);
        sb.append(", linId=").append(linId);
        sb.append(", typId=").append(typId);
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
        BDcrChkDir other = (BDcrChkDir) that;
        return (this.getChkDirId() == null ? other.getChkDirId() == null : this.getChkDirId().equals(other.getChkDirId()))
            && (this.getLinId() == null ? other.getLinId() == null : this.getLinId().equals(other.getLinId()))
            && (this.getTypId() == null ? other.getTypId() == null : this.getTypId().equals(other.getTypId()))
            && (this.getRltTyp() == null ? other.getRltTyp() == null : this.getRltTyp().equals(other.getRltTyp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChkDirId() == null) ? 0 : getChkDirId().hashCode());
        result = prime * result + ((getLinId() == null) ? 0 : getLinId().hashCode());
        result = prime * result + ((getTypId() == null) ? 0 : getTypId().hashCode());
        result = prime * result + ((getRltTyp() == null) ? 0 : getRltTyp().hashCode());
        return result;
    }
}
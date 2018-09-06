package com.huateng.scf.bas.dcr.model;

import java.io.Serializable;

public class BDcrChkDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 检查条件项
     */
    private String chkDetailId;

    /**
     * VARCHAR(32)<br>
     * 检查目录ID
     */
    private String chkDirId;

    /**
     * VARCHAR(40)<br>
     * 限定值
     */
    private String rltVl;

    /**
     * VARCHAR(40)<br>
     * 限定值名
     */
    private String rltNm;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 检查条件项
     */
    public String getChkDetailId() {
        return chkDetailId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 检查条件项
     */
    public void setChkDetailId(String chkDetailId) {
        this.chkDetailId = chkDetailId == null ? null : chkDetailId.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 检查目录ID
     */
    public String getChkDirId() {
        return chkDirId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 检查目录ID
     */
    public void setChkDirId(String chkDirId) {
        this.chkDirId = chkDirId == null ? null : chkDirId.trim();
    }

    /**
     * VARCHAR(40)<br>
     * 获得 限定值
     */
    public String getRltVl() {
        return rltVl;
    }

    /**
     * VARCHAR(40)<br>
     * 设置 限定值
     */
    public void setRltVl(String rltVl) {
        this.rltVl = rltVl == null ? null : rltVl.trim();
    }

    /**
     * VARCHAR(40)<br>
     * 获得 限定值名
     */
    public String getRltNm() {
        return rltNm;
    }

    /**
     * VARCHAR(40)<br>
     * 设置 限定值名
     */
    public void setRltNm(String rltNm) {
        this.rltNm = rltNm == null ? null : rltNm.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", chkDetailId=").append(chkDetailId);
        sb.append(", chkDirId=").append(chkDirId);
        sb.append(", rltVl=").append(rltVl);
        sb.append(", rltNm=").append(rltNm);
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
        BDcrChkDetail other = (BDcrChkDetail) that;
        return (this.getChkDetailId() == null ? other.getChkDetailId() == null : this.getChkDetailId().equals(other.getChkDetailId()))
            && (this.getChkDirId() == null ? other.getChkDirId() == null : this.getChkDirId().equals(other.getChkDirId()))
            && (this.getRltVl() == null ? other.getRltVl() == null : this.getRltVl().equals(other.getRltVl()))
            && (this.getRltNm() == null ? other.getRltNm() == null : this.getRltNm().equals(other.getRltNm()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChkDetailId() == null) ? 0 : getChkDetailId().hashCode());
        result = prime * result + ((getChkDirId() == null) ? 0 : getChkDirId().hashCode());
        result = prime * result + ((getRltVl() == null) ? 0 : getRltVl().hashCode());
        result = prime * result + ((getRltNm() == null) ? 0 : getRltNm().hashCode());
        return result;
    }
}
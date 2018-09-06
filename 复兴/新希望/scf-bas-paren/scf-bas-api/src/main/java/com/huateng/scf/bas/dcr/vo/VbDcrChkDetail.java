package com.huateng.scf.bas.dcr.vo;

import java.io.Serializable;

public class VbDcrChkDetail implements Serializable {
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

}
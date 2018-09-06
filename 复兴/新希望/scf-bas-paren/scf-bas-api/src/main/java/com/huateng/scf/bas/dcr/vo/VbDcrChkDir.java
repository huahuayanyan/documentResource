package com.huateng.scf.bas.dcr.vo;

import java.io.Serializable;

public class VbDcrChkDir implements Serializable {
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

}
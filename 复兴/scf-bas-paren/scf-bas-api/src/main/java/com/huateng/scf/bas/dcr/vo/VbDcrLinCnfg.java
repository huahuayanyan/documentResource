package com.huateng.scf.bas.dcr.vo;

import java.io.Serializable;

public class VbDcrLinCnfg implements Serializable {
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

}
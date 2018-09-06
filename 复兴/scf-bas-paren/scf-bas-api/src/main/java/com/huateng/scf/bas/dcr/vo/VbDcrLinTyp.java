package com.huateng.scf.bas.dcr.vo;

import java.io.Serializable;

public class VbDcrLinTyp implements Serializable {
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

}
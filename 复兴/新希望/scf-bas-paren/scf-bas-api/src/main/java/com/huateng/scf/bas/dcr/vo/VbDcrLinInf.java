package com.huateng.scf.bas.dcr.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class VbDcrLinInf implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 额度ID
     */
    private String linId;

    /**
     * CHAR(1)<br>
     * 类型
     */
    private String linTyp;

    /**
     * VARCHAR(60)<br>
     * 品种名称
     */
    private String busNm;

    /**
     * VARCHAR(32)<br>
     * 品种编号
     */
    private String busTyp;

    /**
     * VARCHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * DECIMAL(14,2)<br>
     * 信贷业务额度
     */
    private BigDecimal crAmt;

    /**
     * DECIMAL(14,2)<br>
     * 信贷敞口额度
     */
    private BigDecimal riskAmt;

    /**
     * CHAR(1)<br>
     * 循环标志
     */
    private String circFlag;

    /**
     * VARCHAR(32)<br>
     * 父额度ID
     */
    private String parentId;

    /**
     * DECIMAL(22)<br>
     * 节点层级
     */
    private BigDecimal linLvl;
    
    

    /**
     * DECIMAL(14,2)<br>
     * 已占用额度
     */
    private BigDecimal usedNum;

    /**
     * DECIMAL(14,2)<br>
     * 可用额度
     */
    private BigDecimal ableNum;
    
    
    /**
     * DECIMAL(14,2)<br>
     * 获得 已占用额度
     */
    public BigDecimal getUsedNum() {
        return usedNum;
    }

    /**
     * DECIMAL(14,2)<br>
     * 设置 已占用额度
     */
    public void setUsedNum(BigDecimal usedNum) {
        this.usedNum = usedNum;
    }

    
    /**
     * DECIMAL(14,2)<br>
     * 获得 可用额度
     */
    public BigDecimal getAbleNum() {
        return ableNum;
    }

    /**
     * DECIMAL(14,2)<br>
     * 设置 可用额度
     */
    public void setAbleNum(BigDecimal ableNum) {
        this.ableNum = ableNum;
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
     * CHAR(1)<br>
     * 获得 类型
     */
    public String getLinTyp() {
        return linTyp;
    }

    /**
     * CHAR(1)<br>
     * 设置 类型
     */
    public void setLinTyp(String linTyp) {
        this.linTyp = linTyp == null ? null : linTyp.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 品种名称
     */
    public String getBusNm() {
        return busNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 品种名称
     */
    public void setBusNm(String busNm) {
        this.busNm = busNm == null ? null : busNm.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 品种编号
     */
    public String getBusTyp() {
        return busTyp;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 品种编号
     */
    public void setBusTyp(String busTyp) {
        this.busTyp = busTyp == null ? null : busTyp.trim();
    }

    /**
     * VARCHAR(3)<br>
     * 获得 币种
     */
    public String getCurcd() {
        return curcd;
    }

    /**
     * VARCHAR(3)<br>
     * 设置 币种
     */
    public void setCurcd(String curcd) {
        this.curcd = curcd == null ? null : curcd.trim();
    }

    /**
     * DECIMAL(14,2)<br>
     * 获得 信贷业务额度
     */
    public BigDecimal getCrAmt() {
        return crAmt;
    }

    /**
     * DECIMAL(14,2)<br>
     * 设置 信贷业务额度
     */
    public void setCrAmt(BigDecimal crAmt) {
        this.crAmt = crAmt;
    }

    /**
     * DECIMAL(14,2)<br>
     * 获得 信贷敞口额度
     */
    public BigDecimal getRiskAmt() {
        return riskAmt;
    }

    /**
     * DECIMAL(14,2)<br>
     * 设置 信贷敞口额度
     */
    public void setRiskAmt(BigDecimal riskAmt) {
        this.riskAmt = riskAmt;
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

    /**
     * VARCHAR(32)<br>
     * 获得 父额度ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 父额度ID
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 节点层级
     */
    public BigDecimal getLinLvl() {
        return linLvl;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 节点层级
     */
    public void setLinLvl(BigDecimal linLvl) {
        this.linLvl = linLvl;
    }

}
package com.huateng.scf.nbas.prd.dao.domodel;

import java.io.Serializable;
import java.math.BigDecimal;

public class BPrdCostInfoDO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(2)<br>
     * 费用收取阶段
     */
    private String costPhase;

    /**
     * VARCHAR(10) 必填<br>
     * 产品ID
     */
    private String productId;
    

    /**
     * VARCHAR(2)<br>
     * 获得 费用收取阶段
     */
    public String getCostPhase() {
        return costPhase;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 费用收取阶段
     */
    public void setCostPhase(String costPhase) {
        this.costPhase = costPhase == null ? null : costPhase.trim();
    }

    /**
     * VARCHAR(10) 必填<br>
     * 获得 产品ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * VARCHAR(10) 必填<br>
     * 设置 产品ID
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }
    /**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String id;

    /**
     * CHAR(4)<br>
     * 费用代码
     */
    private String costCode;

    /**
     * VARCHAR(100)<br>
     * 费用名称
     */
    private String costName;

    /**
     * CHAR(2)<br>
     * 允许收取种类：1-整体、2-单张
     */
    private String costClass;

    /**
     * CHAR(3)<br>
     * 允许第1位-先收；第2位-后收；第3位-免收
     */
    private String costType;

    /**
     * CHAR(2)<br>
     * 允许计算方式：第1位-固定、第2位-按比率
     */
    private String costCalcType;

    /**
     * DECIMAL(5,2)<br>
     * 最小比率，按比率收取时使用
     */
    private BigDecimal minRate;

    /**
     * DECIMAL(5,2)<br>
     * 最大比率，按比率收取时使用
     */
    private BigDecimal maxRate;

    /**
     * CHAR(2)<br>
     * 先收时使用  第1位-外扣，第2位-内收
     */
    private String chargeType;

    /**
     * VARCHAR(200)<br>
     * 备注
     */
    private String costDesc;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 主键UUID
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 主键UUID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * CHAR(4)<br>
     * 获得 费用代码
     */
    public String getCostCode() {
        return costCode;
    }

    /**
     * CHAR(4)<br>
     * 设置 费用代码
     */
    public void setCostCode(String costCode) {
        this.costCode = costCode == null ? null : costCode.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 费用名称
     */
    public String getCostName() {
        return costName;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 费用名称
     */
    public void setCostName(String costName) {
        this.costName = costName == null ? null : costName.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 允许收取种类：1-整体、2-单张
     */
    public String getCostClass() {
        return costClass;
    }

    /**
     * CHAR(2)<br>
     * 设置 允许收取种类：1-整体、2-单张
     */
    public void setCostClass(String costClass) {
        this.costClass = costClass == null ? null : costClass.trim();
    }

    /**
     * CHAR(3)<br>
     * 获得 允许第1位-先收；第2位-后收；第3位-免收
     */
    public String getCostType() {
        return costType;
    }

    /**
     * CHAR(3)<br>
     * 设置 允许第1位-先收；第2位-后收；第3位-免收
     */
    public void setCostType(String costType) {
        this.costType = costType == null ? null : costType.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 允许计算方式：第1位-固定、第2位-按比率
     */
    public String getCostCalcType() {
        return costCalcType;
    }

    /**
     * CHAR(2)<br>
     * 设置 允许计算方式：第1位-固定、第2位-按比率
     */
    public void setCostCalcType(String costCalcType) {
        this.costCalcType = costCalcType == null ? null : costCalcType.trim();
    }

    /**
     * DECIMAL(5,2)<br>
     * 获得 最小比率，按比率收取时使用
     */
    public BigDecimal getMinRate() {
        return minRate;
    }

    /**
     * DECIMAL(5,2)<br>
     * 设置 最小比率，按比率收取时使用
     */
    public void setMinRate(BigDecimal minRate) {
        this.minRate = minRate;
    }

    /**
     * DECIMAL(5,2)<br>
     * 获得 最大比率，按比率收取时使用
     */
    public BigDecimal getMaxRate() {
        return maxRate;
    }

    /**
     * DECIMAL(5,2)<br>
     * 设置 最大比率，按比率收取时使用
     */
    public void setMaxRate(BigDecimal maxRate) {
        this.maxRate = maxRate;
    }

    /**
     * CHAR(2)<br>
     * 获得 先收时使用
		第1位-外扣，第2位-内收
     */
    public String getChargeType() {
        return chargeType;
    }

    /**
     * CHAR(2)<br>
     * 设置 先收时使用
		第1位-外扣，第2位-内收
     */
    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 备注
     */
    public String getCostDesc() {
        return costDesc;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 备注
     */
    public void setCostDesc(String costDesc) {
        this.costDesc = costDesc == null ? null : costDesc.trim();
    }
}
package com.huateng.scf.bas.prd.model;

import java.io.Serializable;

public class BPrdCreditBind implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(10) 必填<br>
     * 产品ID
     */
    private String productId;

    /**
     * VARCHAR(20)<br>
     * 额度类型
     */
    private String creditType;

    /**
     * CHAR(2)<br>
     * 额度阶段：00-动产出质、01-保理承购 、02-保理融资
     */
    private String creditPhase;

    /**
     * CHAR(1)<br>
     * 操作类型：1-占用、2-恢复
     */
    private String oprType;

    /**
     * CHAR(2)<br>
     * 额度操作金额
     */
    private String oprField;

    /**
     * CHAR(2)<br>
     * 操作模式：00-卖方、01-卖方+买方、02-买方、3-买方+卖方
     */
    private String oprMode;

    /**
     * VARCHAR(32)<br>
     * 功能编号
     */
    private String funNo;
    
    
    /**--------------------------------
    * 产品名称 用于页面展示，不入库
    */
    private String productName;
    public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
    
    
    
    

    /**
     * VARCHAR(32) 必填<br>
     * 获得 主键
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
     * VARCHAR(20)<br>
     * 获得 额度类型
     */
    public String getCreditType() {
        return creditType;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 额度类型
     */
    public void setCreditType(String creditType) {
        this.creditType = creditType == null ? null : creditType.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 额度阶段：00-动产出质、01-保理承购 、02-保理融资
     */
    public String getCreditPhase() {
        return creditPhase;
    }

    /**
     * CHAR(2)<br>
     * 设置 额度阶段：00-动产出质、01-保理承购 、02-保理融资
     */
    public void setCreditPhase(String creditPhase) {
        this.creditPhase = creditPhase == null ? null : creditPhase.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 操作类型：1-占用、2-恢复
     */
    public String getOprType() {
        return oprType;
    }

    /**
     * CHAR(1)<br>
     * 设置 操作类型：1-占用、2-恢复
     */
    public void setOprType(String oprType) {
        this.oprType = oprType == null ? null : oprType.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 额度操作金额
     */
    public String getOprField() {
        return oprField;
    }

    /**
     * CHAR(2)<br>
     * 设置 额度操作金额
     */
    public void setOprField(String oprField) {
        this.oprField = oprField == null ? null : oprField.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 操作模式：00-卖方、01-卖方+买方、02-买方、3-买方+卖方
     */
    public String getOprMode() {
        return oprMode;
    }

    /**
     * CHAR(2)<br>
     * 设置 操作模式：00-卖方、01-卖方+买方、02-买方、3-买方+卖方
     */
    public void setOprMode(String oprMode) {
        this.oprMode = oprMode == null ? null : oprMode.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 功能编号
     */
    public String getFunNo() {
        return funNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 功能编号
     */
    public void setFunNo(String funNo) {
        this.funNo = funNo == null ? null : funNo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", creditType=").append(creditType);
        sb.append(", creditPhase=").append(creditPhase);
        sb.append(", oprType=").append(oprType);
        sb.append(", oprField=").append(oprField);
        sb.append(", oprMode=").append(oprMode);
        sb.append(", funNo=").append(funNo);
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
        BPrdCreditBind other = (BPrdCreditBind) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getCreditType() == null ? other.getCreditType() == null : this.getCreditType().equals(other.getCreditType()))
            && (this.getCreditPhase() == null ? other.getCreditPhase() == null : this.getCreditPhase().equals(other.getCreditPhase()))
            && (this.getOprType() == null ? other.getOprType() == null : this.getOprType().equals(other.getOprType()))
            && (this.getOprField() == null ? other.getOprField() == null : this.getOprField().equals(other.getOprField()))
            && (this.getOprMode() == null ? other.getOprMode() == null : this.getOprMode().equals(other.getOprMode()))
            && (this.getFunNo() == null ? other.getFunNo() == null : this.getFunNo().equals(other.getFunNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getCreditType() == null) ? 0 : getCreditType().hashCode());
        result = prime * result + ((getCreditPhase() == null) ? 0 : getCreditPhase().hashCode());
        result = prime * result + ((getOprType() == null) ? 0 : getOprType().hashCode());
        result = prime * result + ((getOprField() == null) ? 0 : getOprField().hashCode());
        result = prime * result + ((getOprMode() == null) ? 0 : getOprMode().hashCode());
        result = prime * result + ((getFunNo() == null) ? 0 : getFunNo().hashCode());
        return result;
    }

	
}
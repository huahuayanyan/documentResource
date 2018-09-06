package com.huateng.scf.bas.icr.model;

import java.io.Serializable;
import java.util.Date;

import com.huateng.scf.bas.common.model.ScfBaseModel;

public class BIcrType extends ScfBaseModel implements Serializable {
	private static final long serialVersionUID = 6181874511434039844L;

	/**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * CHAR(1) 必填<br>
     * 额度种类：1-直接授信额度、2-第三方授信额度、3-间接额度、4-买方授信限额
     */
    private String creditClass;

    /**
     * VARCHAR(20) 必填<br>
     * 额度类型：保理买方额度、担保提货卖方、先票/款后货卖方、商票保贴交易对手、订单融资的买方
     */
    private String creditType;

    /**
     * VARCHAR(60) 必填<br>
     * 额度名称
     */
    private String creditName;

    /**
     * VARCHAR(500)<br>
     * 备注
     */
    private String remark;


    /**
     * VARCHAR(20)<br>
     * 经办机构
     */
    private String brcode;



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
     * CHAR(1) 必填<br>
     * 获得 额度种类：1-直接授信额度、2-第三方授信额度、3-间接额度、4-买方授信限额
     */
    public String getCreditClass() {
        return creditClass;
    }

    /**
     * CHAR(1) 必填<br>
     * 设置 额度种类：1-直接授信额度、2-第三方授信额度、3-间接额度、4-买方授信限额
     */
    public void setCreditClass(String creditClass) {
        this.creditClass = creditClass == null ? null : creditClass.trim();
    }

    /**
     * VARCHAR(20) 必填<br>
     * 获得 额度类型：保理买方额度、担保提货卖方、先票/款后货卖方、商票保贴交易对手、订单融资的买方
     */
    public String getCreditType() {
        return creditType;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 额度类型：保理买方额度、担保提货卖方、先票/款后货卖方、商票保贴交易对手、订单融资的买方
     */
    public void setCreditType(String creditType) {
        this.creditType = creditType == null ? null : creditType.trim();
    }

    /**
     * VARCHAR(60) 必填<br>
     * 获得 额度名称
     */
    public String getCreditName() {
        return creditName;
    }

    /**
     * VARCHAR(60) 必填<br>
     * 设置 额度名称
     */
    public void setCreditName(String creditName) {
        this.creditName = creditName == null ? null : creditName.trim();
    }

    /**
     * VARCHAR(500)<br>
     * 获得 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }



    /**
     * VARCHAR(20)<br>
     * 获得 经办机构
     */
    public String getBrcode() {
        return brcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 经办机构
     */
    public void setBrcode(String brcode) {
        this.brcode = brcode == null ? null : brcode.trim();
    }

   

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", creditClass=").append(creditClass);
        sb.append(", creditType=").append(creditType);
        sb.append(", creditName=").append(creditName);
        sb.append(", remark=").append(remark);
        sb.append(", brcode=").append(brcode);
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
        BIcrType other = (BIcrType) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreditClass() == null ? other.getCreditClass() == null : this.getCreditClass().equals(other.getCreditClass()))
            && (this.getCreditType() == null ? other.getCreditType() == null : this.getCreditType().equals(other.getCreditType()))
            && (this.getCreditName() == null ? other.getCreditName() == null : this.getCreditName().equals(other.getCreditName()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getCrtTime() == null ? other.getCrtTime() == null : this.getCrtTime().equals(other.getCrtTime()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getLastUpdTlrcd() == null ? other.getLastUpdTlrcd() == null : this.getLastUpdTlrcd().equals(other.getLastUpdTlrcd()))
            && (this.getLastUpdTime() == null ? other.getLastUpdTime() == null : this.getLastUpdTime().equals(other.getLastUpdTime()))
            && (this.getLastUpdBrcode() == null ? other.getLastUpdBrcode() == null : this.getLastUpdBrcode().equals(other.getLastUpdBrcode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreditClass() == null) ? 0 : getCreditClass().hashCode());
        result = prime * result + ((getCreditType() == null) ? 0 : getCreditType().hashCode());
        result = prime * result + ((getCreditName() == null) ? 0 : getCreditName().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
        result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
        result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
        return result;
    }
}
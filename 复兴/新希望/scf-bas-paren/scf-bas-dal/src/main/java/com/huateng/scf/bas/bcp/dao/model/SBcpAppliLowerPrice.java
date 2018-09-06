package com.huateng.scf.bas.bcp.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class SBcpAppliLowerPrice extends SBcpExt implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 申请号
     */
    private String appno;

    /**
     * CHAR(2)<br>
     * 监管模式
     */
    private String moniModel;

    /**
     * VARCHAR(80)<br>
     * 监管公司客户号
     */
    private String moniOfCustcd;

    /**
     * VARCHAR(20)<br>
     * 监管协议号
     */
    private String protocolNo;

    /**
     * DECIMAL(16,2)<br>
     * 调整后监管下限
     */
    private BigDecimal lowPriceNew;

    /**
     * DECIMAL(16,2)<br>
     * 调整前监管下限
     */
    private BigDecimal lowPrice;

    /**
     * VARCHAR(20)<br>
     * 抵质押合同号
     */
    private String slaveContno;

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
     * VARCHAR(20)<br>
     * 获得 申请号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 申请号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 监管模式
     */
    public String getMoniModel() {
        return moniModel;
    }

    /**
     * CHAR(2)<br>
     * 设置 监管模式
     */
    public void setMoniModel(String moniModel) {
        this.moniModel = moniModel == null ? null : moniModel.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 监管公司客户号
     */
    public String getMoniOfCustcd() {
        return moniOfCustcd;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 监管公司客户号
     */
    public void setMoniOfCustcd(String moniOfCustcd) {
        this.moniOfCustcd = moniOfCustcd == null ? null : moniOfCustcd.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 监管协议号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 监管协议号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 调整后监管下限
     */
    public BigDecimal getLowPriceNew() {
        return lowPriceNew;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 调整后监管下限
     */
    public void setLowPriceNew(BigDecimal lowPriceNew) {
        this.lowPriceNew = lowPriceNew;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 调整前监管下限
     */
    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 调整前监管下限
     */
    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 抵质押合同号
     */
    public String getSlaveContno() {
        return slaveContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 抵质押合同号
     */
    public void setSlaveContno(String slaveContno) {
        this.slaveContno = slaveContno == null ? null : slaveContno.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appno=").append(appno);
        sb.append(", moniModel=").append(moniModel);
        sb.append(", moniOfCustcd=").append(moniOfCustcd);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", lowPriceNew=").append(lowPriceNew);
        sb.append(", lowPrice=").append(lowPrice);
        sb.append(", slaveContno=").append(slaveContno);
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
        SBcpAppliLowerPrice other = (SBcpAppliLowerPrice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getMoniModel() == null ? other.getMoniModel() == null : this.getMoniModel().equals(other.getMoniModel()))
            && (this.getMoniOfCustcd() == null ? other.getMoniOfCustcd() == null : this.getMoniOfCustcd().equals(other.getMoniOfCustcd()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getLowPriceNew() == null ? other.getLowPriceNew() == null : this.getLowPriceNew().equals(other.getLowPriceNew()))
            && (this.getLowPrice() == null ? other.getLowPrice() == null : this.getLowPrice().equals(other.getLowPrice()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getMoniModel() == null) ? 0 : getMoniModel().hashCode());
        result = prime * result + ((getMoniOfCustcd() == null) ? 0 : getMoniOfCustcd().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getLowPriceNew() == null) ? 0 : getLowPriceNew().hashCode());
        result = prime * result + ((getLowPrice() == null) ? 0 : getLowPrice().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        return result;
    }
}
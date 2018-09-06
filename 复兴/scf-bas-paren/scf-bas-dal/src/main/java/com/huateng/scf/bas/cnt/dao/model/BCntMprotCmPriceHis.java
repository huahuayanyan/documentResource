package com.huateng.scf.bas.cnt.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BCntMprotCmPriceHis implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(20) 必填<br>
     * 押品编号
     */
    private String mortgageNo;

    /**
     * CHAR(8) 必填<br>
     * 交易时间
     */
    private String txdate;

    /**
     * DECIMAL(16,2)<br>
     * 原始质物最低价值|原监管下限
     */
    private BigDecimal lowPrice;

    /**
     * VARCHAR(20) 必填<br>
     * 监管协议号
     */
    private String protocolNo;

    /**
     * DECIMAL(16,2)<br>
     * 调整后监管下限|新质物最低价值
     */
    private BigDecimal lowPriceNew;

    /**
     * VARCHAR(20) 必填<br>
     * 抵质押合同号
     */
    private String slaveContno;

    /**
     * VARCHAR(32) 必填<br>
     * 登记人
     */
    private String recordTlrcd;

    /**
     * VARCHAR(20) 必填<br>
     * 登记机构
     */
    private String recordBrcode;

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
     * VARCHAR(20) 必填<br>
     * 获得 押品编号
     */
    public String getMortgageNo() {
        return mortgageNo;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 押品编号
     */
    public void setMortgageNo(String mortgageNo) {
        this.mortgageNo = mortgageNo == null ? null : mortgageNo.trim();
    }

    /**
     * CHAR(8) 必填<br>
     * 获得 交易时间
     */
    public String getTxdate() {
        return txdate;
    }

    /**
     * CHAR(8) 必填<br>
     * 设置 交易时间
     */
    public void setTxdate(String txdate) {
        this.txdate = txdate == null ? null : txdate.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 原始质物最低价值|原监管下限
     */
    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 原始质物最低价值|原监管下限
     */
    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 获得 监管协议号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 监管协议号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 调整后监管下限|新质物最低价值
     */
    public BigDecimal getLowPriceNew() {
        return lowPriceNew;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 调整后监管下限|新质物最低价值
     */
    public void setLowPriceNew(BigDecimal lowPriceNew) {
        this.lowPriceNew = lowPriceNew;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 获得 抵质押合同号
     */
    public String getSlaveContno() {
        return slaveContno;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 抵质押合同号
     */
    public void setSlaveContno(String slaveContno) {
        this.slaveContno = slaveContno == null ? null : slaveContno.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 登记人
     */
    public String getRecordTlrcd() {
        return recordTlrcd;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 登记人
     */
    public void setRecordTlrcd(String recordTlrcd) {
        this.recordTlrcd = recordTlrcd == null ? null : recordTlrcd.trim();
    }

    /**
     * VARCHAR(20) 必填<br>
     * 获得 登记机构
     */
    public String getRecordBrcode() {
        return recordBrcode;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 登记机构
     */
    public void setRecordBrcode(String recordBrcode) {
        this.recordBrcode = recordBrcode == null ? null : recordBrcode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mortgageNo=").append(mortgageNo);
        sb.append(", txdate=").append(txdate);
        sb.append(", lowPrice=").append(lowPrice);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", lowPriceNew=").append(lowPriceNew);
        sb.append(", slaveContno=").append(slaveContno);
        sb.append(", recordTlrcd=").append(recordTlrcd);
        sb.append(", recordBrcode=").append(recordBrcode);
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
        BCntMprotCmPriceHis other = (BCntMprotCmPriceHis) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMortgageNo() == null ? other.getMortgageNo() == null : this.getMortgageNo().equals(other.getMortgageNo()))
            && (this.getTxdate() == null ? other.getTxdate() == null : this.getTxdate().equals(other.getTxdate()))
            && (this.getLowPrice() == null ? other.getLowPrice() == null : this.getLowPrice().equals(other.getLowPrice()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getLowPriceNew() == null ? other.getLowPriceNew() == null : this.getLowPriceNew().equals(other.getLowPriceNew()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
            && (this.getRecordTlrcd() == null ? other.getRecordTlrcd() == null : this.getRecordTlrcd().equals(other.getRecordTlrcd()))
            && (this.getRecordBrcode() == null ? other.getRecordBrcode() == null : this.getRecordBrcode().equals(other.getRecordBrcode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMortgageNo() == null) ? 0 : getMortgageNo().hashCode());
        result = prime * result + ((getTxdate() == null) ? 0 : getTxdate().hashCode());
        result = prime * result + ((getLowPrice() == null) ? 0 : getLowPrice().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getLowPriceNew() == null) ? 0 : getLowPriceNew().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        result = prime * result + ((getRecordTlrcd() == null) ? 0 : getRecordTlrcd().hashCode());
        result = prime * result + ((getRecordBrcode() == null) ? 0 : getRecordBrcode().hashCode());
        return result;
    }
}
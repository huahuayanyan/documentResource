package com.huateng.scf.adv.wrn.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BWrnDropCtlInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(32)<br>
     * 预警主表标识
     */
    private String warnId;

    /**
     * VARCHAR(20)<br>
     * 质押合同号
     */
    private String slaveContno;

    /**
     * VARCHAR(200)<br>
     * 质押合同号
     */
    private String slaveContcode;

    /**
     * VARCHAR(15)<br>
     * 出质人客户号
     */
    private String custcd;

    /**
     * VARCHAR(80)<br>
     * 出质人名称
     */
    private String cname;

    /**
     * VARCHAR(15)<br>
     * 监管公司客户号
     */
    private String moniCustcd;

    /**
     * VARCHAR(80)<br>
     * 监管公司名称
     */
    private String moniCname;

    /**
     * VARCHAR(20)<br>
     * 监管合同号
     */
    private String protocolNo;

    /**
     * DECIMAL(16,2)<br>
     * 最低控货价值
     */
    private BigDecimal leastMortAmt;

    /**
     * DECIMAL(16,2)<br>
     * 押品总价值
     */
    private BigDecimal mortAmt;

    /**
     * DECIMAL(10,6)<br>
     * 质押率（%）
     */
    private BigDecimal ratio;

    /**
     * DECIMAL(10,6)<br>
     * 当前市值质押率
     */
    private BigDecimal currentRatio;

    /**
     * DECIMAL(10,6)<br>
     * 市值质押率警戒线
     */
    private BigDecimal warnLine;

    /**
     * DECIMAL(16,2)<br>
     * 价值差额
     */
    private BigDecimal mortBalance;

    /**
     * DECIMAL(16,2)<br>
     * 敞口余额
     */
    private BigDecimal riskBal;

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
     * VARCHAR(32)<br>
     * 获得 预警主表标识
     */
    public String getWarnId() {
        return warnId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 预警主表标识
     */
    public void setWarnId(String warnId) {
        this.warnId = warnId == null ? null : warnId.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 质押合同号
     */
    public String getSlaveContno() {
        return slaveContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 质押合同号
     */
    public void setSlaveContno(String slaveContno) {
        this.slaveContno = slaveContno == null ? null : slaveContno.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 质押合同号
     */
    public String getSlaveContcode() {
        return slaveContcode;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 质押合同号
     */
    public void setSlaveContcode(String slaveContcode) {
        this.slaveContcode = slaveContcode == null ? null : slaveContcode.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 出质人客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 出质人客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 出质人名称
     */
    public String getCname() {
        return cname;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 出质人名称
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 监管公司客户号
     */
    public String getMoniCustcd() {
        return moniCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 监管公司客户号
     */
    public void setMoniCustcd(String moniCustcd) {
        this.moniCustcd = moniCustcd == null ? null : moniCustcd.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 监管公司名称
     */
    public String getMoniCname() {
        return moniCname;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 监管公司名称
     */
    public void setMoniCname(String moniCname) {
        this.moniCname = moniCname == null ? null : moniCname.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 监管合同号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 监管合同号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 最低控货价值
     */
    public BigDecimal getLeastMortAmt() {
        return leastMortAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 最低控货价值
     */
    public void setLeastMortAmt(BigDecimal leastMortAmt) {
        this.leastMortAmt = leastMortAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 押品总价值
     */
    public BigDecimal getMortAmt() {
        return mortAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 押品总价值
     */
    public void setMortAmt(BigDecimal mortAmt) {
        this.mortAmt = mortAmt;
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 质押率（%）
     */
    public BigDecimal getRatio() {
        return ratio;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 质押率（%）
     */
    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 当前市值质押率
     */
    public BigDecimal getCurrentRatio() {
        return currentRatio;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 当前市值质押率
     */
    public void setCurrentRatio(BigDecimal currentRatio) {
        this.currentRatio = currentRatio;
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 市值质押率警戒线
     */
    public BigDecimal getWarnLine() {
        return warnLine;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 市值质押率警戒线
     */
    public void setWarnLine(BigDecimal warnLine) {
        this.warnLine = warnLine;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 价值差额
     */
    public BigDecimal getMortBalance() {
        return mortBalance;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 价值差额
     */
    public void setMortBalance(BigDecimal mortBalance) {
        this.mortBalance = mortBalance;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 敞口余额
     */
    public BigDecimal getRiskBal() {
        return riskBal;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 敞口余额
     */
    public void setRiskBal(BigDecimal riskBal) {
        this.riskBal = riskBal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", warnId=").append(warnId);
        sb.append(", slaveContno=").append(slaveContno);
        sb.append(", slaveContcode=").append(slaveContcode);
        sb.append(", custcd=").append(custcd);
        sb.append(", cname=").append(cname);
        sb.append(", moniCustcd=").append(moniCustcd);
        sb.append(", moniCname=").append(moniCname);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", leastMortAmt=").append(leastMortAmt);
        sb.append(", mortAmt=").append(mortAmt);
        sb.append(", ratio=").append(ratio);
        sb.append(", currentRatio=").append(currentRatio);
        sb.append(", warnLine=").append(warnLine);
        sb.append(", mortBalance=").append(mortBalance);
        sb.append(", riskBal=").append(riskBal);
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
        BWrnDropCtlInfo other = (BWrnDropCtlInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWarnId() == null ? other.getWarnId() == null : this.getWarnId().equals(other.getWarnId()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
            && (this.getSlaveContcode() == null ? other.getSlaveContcode() == null : this.getSlaveContcode().equals(other.getSlaveContcode()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()))
            && (this.getMoniCustcd() == null ? other.getMoniCustcd() == null : this.getMoniCustcd().equals(other.getMoniCustcd()))
            && (this.getMoniCname() == null ? other.getMoniCname() == null : this.getMoniCname().equals(other.getMoniCname()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getLeastMortAmt() == null ? other.getLeastMortAmt() == null : this.getLeastMortAmt().equals(other.getLeastMortAmt()))
            && (this.getMortAmt() == null ? other.getMortAmt() == null : this.getMortAmt().equals(other.getMortAmt()))
            && (this.getRatio() == null ? other.getRatio() == null : this.getRatio().equals(other.getRatio()))
            && (this.getCurrentRatio() == null ? other.getCurrentRatio() == null : this.getCurrentRatio().equals(other.getCurrentRatio()))
            && (this.getWarnLine() == null ? other.getWarnLine() == null : this.getWarnLine().equals(other.getWarnLine()))
            && (this.getMortBalance() == null ? other.getMortBalance() == null : this.getMortBalance().equals(other.getMortBalance()))
            && (this.getRiskBal() == null ? other.getRiskBal() == null : this.getRiskBal().equals(other.getRiskBal()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWarnId() == null) ? 0 : getWarnId().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        result = prime * result + ((getSlaveContcode() == null) ? 0 : getSlaveContcode().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
        result = prime * result + ((getMoniCustcd() == null) ? 0 : getMoniCustcd().hashCode());
        result = prime * result + ((getMoniCname() == null) ? 0 : getMoniCname().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getLeastMortAmt() == null) ? 0 : getLeastMortAmt().hashCode());
        result = prime * result + ((getMortAmt() == null) ? 0 : getMortAmt().hashCode());
        result = prime * result + ((getRatio() == null) ? 0 : getRatio().hashCode());
        result = prime * result + ((getCurrentRatio() == null) ? 0 : getCurrentRatio().hashCode());
        result = prime * result + ((getWarnLine() == null) ? 0 : getWarnLine().hashCode());
        result = prime * result + ((getMortBalance() == null) ? 0 : getMortBalance().hashCode());
        result = prime * result + ((getRiskBal() == null) ? 0 : getRiskBal().hashCode());
        return result;
    }
}
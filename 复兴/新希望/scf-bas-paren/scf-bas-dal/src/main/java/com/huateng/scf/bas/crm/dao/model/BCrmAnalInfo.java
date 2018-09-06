package com.huateng.scf.bas.crm.dao.model;

import java.io.Serializable;

public class BCrmAnalInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * UUID主键
     */
    private String id;

    /**
     * VARCHAR(15) 必填<br>
     * 客户号
     */
    private String custcd;

    /**
     * CHAR(8)<br>
     * 分析日期
     */
    private String analDate;

    /**
     * VARCHAR(100)<br>
     * 企业经营管理素质
     */
    private String manageQual;

    /**
     * VARCHAR(100)<br>
     * 经营环境和市场环境
     */
    private String marketEnvir;

    /**
     * VARCHAR(500)<br>
     * 备注
     */
    private String remarks;

    /**
     * VARCHAR(20)<br>
     * 登记人
     */
    private String register;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 UUID主键
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 UUID主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(15) 必填<br>
     * 获得 客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15) 必填<br>
     * 设置 客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 分析日期
     */
    public String getAnalDate() {
        return analDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 分析日期
     */
    public void setAnalDate(String analDate) {
        this.analDate = analDate == null ? null : analDate.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 企业经营管理素质
     */
    public String getManageQual() {
        return manageQual;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 企业经营管理素质
     */
    public void setManageQual(String manageQual) {
        this.manageQual = manageQual == null ? null : manageQual.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 经营环境和市场环境
     */
    public String getMarketEnvir() {
        return marketEnvir;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 经营环境和市场环境
     */
    public void setMarketEnvir(String marketEnvir) {
        this.marketEnvir = marketEnvir == null ? null : marketEnvir.trim();
    }

    /**
     * VARCHAR(500)<br>
     * 获得 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 登记人
     */
    public String getRegister() {
        return register;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 登记人
     */
    public void setRegister(String register) {
        this.register = register == null ? null : register.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", custcd=").append(custcd);
        sb.append(", analDate=").append(analDate);
        sb.append(", manageQual=").append(manageQual);
        sb.append(", marketEnvir=").append(marketEnvir);
        sb.append(", remarks=").append(remarks);
        sb.append(", register=").append(register);
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
        BCrmAnalInfo other = (BCrmAnalInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getAnalDate() == null ? other.getAnalDate() == null : this.getAnalDate().equals(other.getAnalDate()))
            && (this.getManageQual() == null ? other.getManageQual() == null : this.getManageQual().equals(other.getManageQual()))
            && (this.getMarketEnvir() == null ? other.getMarketEnvir() == null : this.getMarketEnvir().equals(other.getMarketEnvir()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getRegister() == null ? other.getRegister() == null : this.getRegister().equals(other.getRegister()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getAnalDate() == null) ? 0 : getAnalDate().hashCode());
        result = prime * result + ((getManageQual() == null) ? 0 : getManageQual().hashCode());
        result = prime * result + ((getMarketEnvir() == null) ? 0 : getMarketEnvir().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getRegister() == null) ? 0 : getRegister().hashCode());
        return result;
    }
}
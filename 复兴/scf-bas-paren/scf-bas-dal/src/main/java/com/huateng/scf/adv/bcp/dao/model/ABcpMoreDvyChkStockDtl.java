package com.huateng.scf.adv.bcp.dao.model;

import java.io.Serializable;

public class ABcpMoreDvyChkStockDtl implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String id;

    /**
     * VARCHAR(32)<br>
     * 发货对账主表ID
     */
    private String checkId;

    /**
     * VARCHAR(20)<br>
     * 借据号
     */
    private String debetNo;

    /**
     * VARCHAR(20)<br>
     * 购销合同号
     */
    private String tradeContno;

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
     * VARCHAR(32)<br>
     * 获得 发货对账主表ID
     */
    public String getCheckId() {
        return checkId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 发货对账主表ID
     */
    public void setCheckId(String checkId) {
        this.checkId = checkId == null ? null : checkId.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 借据号
     */
    public String getDebetNo() {
        return debetNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 借据号
     */
    public void setDebetNo(String debetNo) {
        this.debetNo = debetNo == null ? null : debetNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 购销合同号
     */
    public String getTradeContno() {
        return tradeContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 购销合同号
     */
    public void setTradeContno(String tradeContno) {
        this.tradeContno = tradeContno == null ? null : tradeContno.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", checkId=").append(checkId);
        sb.append(", debetNo=").append(debetNo);
        sb.append(", tradeContno=").append(tradeContno);
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
        ABcpMoreDvyChkStockDtl other = (ABcpMoreDvyChkStockDtl) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCheckId() == null ? other.getCheckId() == null : this.getCheckId().equals(other.getCheckId()))
            && (this.getDebetNo() == null ? other.getDebetNo() == null : this.getDebetNo().equals(other.getDebetNo()))
            && (this.getTradeContno() == null ? other.getTradeContno() == null : this.getTradeContno().equals(other.getTradeContno()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCheckId() == null) ? 0 : getCheckId().hashCode());
        result = prime * result + ((getDebetNo() == null) ? 0 : getDebetNo().hashCode());
        result = prime * result + ((getTradeContno() == null) ? 0 : getTradeContno().hashCode());
        return result;
    }
}
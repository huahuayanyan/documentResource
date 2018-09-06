package com.huateng.scf.bas.prd.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * <p>BPrdBranchAuth实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年1月5日下午3:34:44
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年1月5日下午3:34:44	     新增
 *
 * </pre>
 */
public class BPrdBranchAuth implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(10)<br>
     * 产品ID
     */
    private String supplyChainPdId;

    /**
     * VARCHAR(20)<br>
     * 机构号
     */
    private String brcode;

    /**
     * VARCHAR(32)<br>
     * 最后更新操作员
     */
    private String tlrcd;

    /**
     * CHAR(2)<br>
     * 状态
     */
    private String status;

    /**
     * CHAR(8)<br>
     * 开始日期
     */
    private String startDate;

    /**
     * CHAR(8)<br>
     * 结束日期
     */
    private String endDate;

    /**
     * CHAR(8)<br>
     * 创建日期
     */
    private String insertDate;

    /**
     * CHAR(500)<br>
     * 备注
     */
    private String description;

    /**
     * DECIMAL(16,2) 默认值[0.00]<br>
     * 融资限额
     */
    private BigDecimal loanLimit;

    /**
     * DECIMAL(16,2) 默认值[0.00]<br>
     * 已用额度
     */
    private BigDecimal occupiedAmt;

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
     * VARCHAR(10)<br>
     * 获得 产品ID
     */
    public String getSupplyChainPdId() {
        return supplyChainPdId;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 产品ID
     */
    public void setSupplyChainPdId(String supplyChainPdId) {
        this.supplyChainPdId = supplyChainPdId == null ? null : supplyChainPdId.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 机构号
     */
    public String getBrcode() {
        return brcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 机构号
     */
    public void setBrcode(String brcode) {
        this.brcode = brcode == null ? null : brcode.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 最后更新操作员
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 最后更新操作员
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * CHAR(2)<br>
     * 设置 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 开始日期
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 开始日期
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 结束日期
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 结束日期
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 创建日期
     */
    public String getInsertDate() {
        return insertDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 创建日期
     */
    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate == null ? null : insertDate.trim();
    }

    /**
     * CHAR(500)<br>
     * 获得 备注
     */
    public String getDescription() {
        return description;
    }

    /**
     * CHAR(500)<br>
     * 设置 备注
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * DECIMAL(16,2) 默认值[0.00]<br>
     * 获得 融资限额
     */
    public BigDecimal getLoanLimit() {
        return loanLimit;
    }

    /**
     * DECIMAL(16,2) 默认值[0.00]<br>
     * 设置 融资限额
     */
    public void setLoanLimit(BigDecimal loanLimit) {
        this.loanLimit = loanLimit;
    }

    /**
     * DECIMAL(16,2) 默认值[0.00]<br>
     * 获得 已用额度
     */
    public BigDecimal getOccupiedAmt() {
        return occupiedAmt;
    }

    /**
     * DECIMAL(16,2) 默认值[0.00]<br>
     * 设置 已用额度
     */
    public void setOccupiedAmt(BigDecimal occupiedAmt) {
        this.occupiedAmt = occupiedAmt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", supplyChainPdId=").append(supplyChainPdId);
        sb.append(", brcode=").append(brcode);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", status=").append(status);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", insertDate=").append(insertDate);
        sb.append(", description=").append(description);
        sb.append(", loanLimit=").append(loanLimit);
        sb.append(", occupiedAmt=").append(occupiedAmt);
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
        BPrdBranchAuth other = (BPrdBranchAuth) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSupplyChainPdId() == null ? other.getSupplyChainPdId() == null : this.getSupplyChainPdId().equals(other.getSupplyChainPdId()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getInsertDate() == null ? other.getInsertDate() == null : this.getInsertDate().equals(other.getInsertDate()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getLoanLimit() == null ? other.getLoanLimit() == null : this.getLoanLimit().equals(other.getLoanLimit()))
            && (this.getOccupiedAmt() == null ? other.getOccupiedAmt() == null : this.getOccupiedAmt().equals(other.getOccupiedAmt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSupplyChainPdId() == null) ? 0 : getSupplyChainPdId().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getInsertDate() == null) ? 0 : getInsertDate().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getLoanLimit() == null) ? 0 : getLoanLimit().hashCode());
        result = prime * result + ((getOccupiedAmt() == null) ? 0 : getOccupiedAmt().hashCode());
        return result;
    }
}
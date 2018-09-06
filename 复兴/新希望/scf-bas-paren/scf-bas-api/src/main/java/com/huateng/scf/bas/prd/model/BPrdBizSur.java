package com.huateng.scf.bas.prd.model;

import java.io.Serializable;
import java.util.Date;

import com.huateng.scf.bas.common.model.ScfBaseModel;

public class BPrdBizSur extends ScfBaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(255) 必填<br>
     * 材料名称
     */
    private String matlName;

    /**
     * CHAR(4) 必填<br>
     * 材料类型：1-业务调查资料，2-制度相关资料
     */
    private String matlType;

    /**
     * VARCHAR(500) 必填<br>
     * 材料名称
     */
    private String fileName;

    /**
     * VARCHAR(10) 必填<br>
     * 产品大类ID
     */
    private String productId;

    /**
     * VARCHAR(100) 必填<br>
     * 产品大类名称
     */
    private String productName;

    /**
     * VARCHAR(500)<br>
     * 备注
     */
    private String remark;

    /**
     * VARCHAR(32)<br>
     * 创建人
     */
    private String tlrcd;

    /**
     * TIMESTAMP(11,6)<br>
     * 创建时间
     */
    private Date crtTime;

    /**
     * VARCHAR(20)<br>
     * 经办机构
     */
    private String brcode;

    /**
     * VARCHAR(32)<br>
     * 最后更新操作员
     */
    private String lastUpdTlrcd;

    /**
     * TIMESTAMP(11,6)<br>
     * 最后更新时间
     */
    private Date lastUpdTime;

    /**
     * VARCHAR(20)<br>
     * 最后更新机构
     */
    private String lastUpdBrcode;

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
     * VARCHAR(255) 必填<br>
     * 获得 材料名称
     */
    public String getMatlName() {
        return matlName;
    }

    /**
     * VARCHAR(255) 必填<br>
     * 设置 材料名称
     */
    public void setMatlName(String matlName) {
        this.matlName = matlName == null ? null : matlName.trim();
    }

    /**
     * CHAR(4) 必填<br>
     * 获得 材料类型：1-业务调查资料，2-制度相关资料
     */
    public String getMatlType() {
        return matlType;
    }

    /**
     * CHAR(4) 必填<br>
     * 设置 材料类型：1-业务调查资料，2-制度相关资料
     */
    public void setMatlType(String matlType) {
        this.matlType = matlType == null ? null : matlType.trim();
    }

    /**
     * VARCHAR(500) 必填<br>
     * 获得 材料名称
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * VARCHAR(500) 必填<br>
     * 设置 材料名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * VARCHAR(10) 必填<br>
     * 获得 产品大类ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * VARCHAR(10) 必填<br>
     * 设置 产品大类ID
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * VARCHAR(100) 必填<br>
     * 获得 产品大类名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 设置 产品大类名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
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
     * VARCHAR(32)<br>
     * 获得 创建人
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 创建人
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 创建时间
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 创建时间
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
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

    /**
     * VARCHAR(32)<br>
     * 获得 最后更新操作员
     */
    public String getLastUpdTlrcd() {
        return lastUpdTlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 最后更新操作员
     */
    public void setLastUpdTlrcd(String lastUpdTlrcd) {
        this.lastUpdTlrcd = lastUpdTlrcd == null ? null : lastUpdTlrcd.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 最后更新时间
     */
    public Date getLastUpdTime() {
        return lastUpdTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 最后更新时间
     */
    public void setLastUpdTime(Date lastUpdTime) {
        this.lastUpdTime = lastUpdTime;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 最后更新机构
     */
    public String getLastUpdBrcode() {
        return lastUpdBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 最后更新机构
     */
    public void setLastUpdBrcode(String lastUpdBrcode) {
        this.lastUpdBrcode = lastUpdBrcode == null ? null : lastUpdBrcode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", matlName=").append(matlName);
        sb.append(", matlType=").append(matlType);
        sb.append(", fileName=").append(fileName);
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", remark=").append(remark);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", crtTime=").append(crtTime);
        sb.append(", brcode=").append(brcode);
        sb.append(", lastUpdTlrcd=").append(lastUpdTlrcd);
        sb.append(", lastUpdTime=").append(lastUpdTime);
        sb.append(", lastUpdBrcode=").append(lastUpdBrcode);
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
        BPrdBizSur other = (BPrdBizSur) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMatlName() == null ? other.getMatlName() == null : this.getMatlName().equals(other.getMatlName()))
            && (this.getMatlType() == null ? other.getMatlType() == null : this.getMatlType().equals(other.getMatlType()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
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
        result = prime * result + ((getMatlName() == null) ? 0 : getMatlName().hashCode());
        result = prime * result + ((getMatlType() == null) ? 0 : getMatlType().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
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
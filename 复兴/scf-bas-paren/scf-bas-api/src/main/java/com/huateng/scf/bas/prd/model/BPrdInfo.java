package com.huateng.scf.bas.prd.model;

import java.io.Serializable;
import java.util.Date;

import com.huateng.scf.bas.common.model.ScfBaseModel;

public class BPrdInfo extends ScfBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(10) 必填<br>
	 * 产品ID
	 */
	private String productId;

	/**
	 * VARCHAR(100)<br>
	 * 产品名称
	 */
	private String productName;

	/**
	 * CHAR(3)<br>
	 * 产品类型
	 */
	private String productType;

	/**
	 * VARCHAR(10)<br>
	 * 产品父ID
	 */
	private String parentId;

	/**
	 * CHAR(8)<br>
	 * 生效日期
	 */
	private String activeDate;

	/**
	 * CHAR(8)<br>
	 * 启用日期
	 */
	private String startDate;

	/**
	 * CHAR(8)<br>
	 * 终止日期
	 */
	private String endDate;

	/**
	 * CHAR(1)<br>
	 * 状态:1-启用，2-停用
	 */
	private String status;

	/**
	 * VARCHAR(50)<br>
	 * 扩展字段1
	 */
	private String ext1;

	/**
	 * VARCHAR(100)<br>
	 * 扩展字段2
	 */
	private String ext2;

	/**
	 * VARCHAR(200)<br>
	 * 扩展字段3
	 */
	private String ext3;

	/**
	 * VARCHAR(500)<br>
	 * 备注
	 */
	private String memo;

	/**
	 * VARCHAR(30)<br>
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
	 * VARCHAR(30)<br>
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
	 * VARCHAR(100)<br>
	 * 获得 产品名称
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
	}

	/**
	 * CHAR(3)<br>
	 * 获得 产品类型
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * CHAR(3)<br>
	 * 设置 产品类型
	 */
	public void setProductType(String productType) {
		this.productType = productType == null ? null : productType.trim();
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 产品父ID
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 产品父ID
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId == null ? null : parentId.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 生效日期
	 */
	public String getActiveDate() {
		return activeDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 生效日期
	 */
	public void setActiveDate(String activeDate) {
		this.activeDate = activeDate == null ? null : activeDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 启用日期
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 启用日期
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate == null ? null : startDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 终止日期
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 终止日期
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate == null ? null : endDate.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 状态:1-启用，2-停用
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 状态:1-启用，2-停用
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 扩展字段1
	 */
	public String getExt1() {
		return ext1;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 扩展字段1
	 */
	public void setExt1(String ext1) {
		this.ext1 = ext1 == null ? null : ext1.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 扩展字段2
	 */
	public String getExt2() {
		return ext2;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 扩展字段2
	 */
	public void setExt2(String ext2) {
		this.ext2 = ext2 == null ? null : ext2.trim();
	}

	/**
	 * VARCHAR(200)<br>
	 * 获得 扩展字段3
	 */
	public String getExt3() {
		return ext3;
	}

	/**
	 * VARCHAR(200)<br>
	 * 设置 扩展字段3
	 */
	public void setExt3(String ext3) {
		this.ext3 = ext3 == null ? null : ext3.trim();
	}

	/**
	 * VARCHAR(500)<br>
	 * 获得 备注
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * VARCHAR(500)<br>
	 * 设置 备注
	 */
	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}

	/**
	 * VARCHAR(30)<br>
	 * 获得 创建人
	 */
	public String getTlrcd() {
		return tlrcd;
	}

	/**
	 * VARCHAR(30)<br>
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
	 * VARCHAR(30)<br>
	 * 获得 最后更新操作员
	 */
	public String getLastUpdTlrcd() {
		return lastUpdTlrcd;
	}

	/**
	 * VARCHAR(30)<br>
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
		sb.append(", productId=").append(productId);
		sb.append(", productName=").append(productName);
		sb.append(", productType=").append(productType);
		sb.append(", parentId=").append(parentId);
		sb.append(", activeDate=").append(activeDate);
		sb.append(", startDate=").append(startDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", status=").append(status);
		sb.append(", ext1=").append(ext1);
		sb.append(", ext2=").append(ext2);
		sb.append(", ext3=").append(ext3);
		sb.append(", memo=").append(memo);
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
		BPrdInfo other = (BPrdInfo) that;
		return (this.getProductId() == null ? other.getProductId() == null
				: this.getProductId().equals(other.getProductId()))
				&& (this.getProductName() == null ? other.getProductName() == null
						: this.getProductName().equals(other.getProductName()))
				&& (this.getProductType() == null ? other.getProductType() == null
						: this.getProductType().equals(other.getProductType()))
				&& (this.getParentId() == null ? other.getParentId() == null
						: this.getParentId().equals(other.getParentId()))
				&& (this.getActiveDate() == null ? other.getActiveDate() == null
						: this.getActiveDate().equals(other.getActiveDate()))
				&& (this.getStartDate() == null ? other.getStartDate() == null
						: this.getStartDate().equals(other.getStartDate()))
				&& (this.getEndDate() == null ? other.getEndDate() == null
						: this.getEndDate().equals(other.getEndDate()))
				&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
				&& (this.getExt1() == null ? other.getExt1() == null : this.getExt1().equals(other.getExt1()))
				&& (this.getExt2() == null ? other.getExt2() == null : this.getExt2().equals(other.getExt2()))
				&& (this.getExt3() == null ? other.getExt3() == null : this.getExt3().equals(other.getExt3()))
				&& (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
				&& (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
				&& (this.getCrtTime() == null ? other.getCrtTime() == null
						: this.getCrtTime().equals(other.getCrtTime()))
				&& (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
				&& (this.getLastUpdTlrcd() == null ? other.getLastUpdTlrcd() == null
						: this.getLastUpdTlrcd().equals(other.getLastUpdTlrcd()))
				&& (this.getLastUpdTime() == null ? other.getLastUpdTime() == null
						: this.getLastUpdTime().equals(other.getLastUpdTime()))
				&& (this.getLastUpdBrcode() == null ? other.getLastUpdBrcode() == null
						: this.getLastUpdBrcode().equals(other.getLastUpdBrcode()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
		result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
		result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
		result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
		result = prime * result + ((getActiveDate() == null) ? 0 : getActiveDate().hashCode());
		result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
		result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getExt1() == null) ? 0 : getExt1().hashCode());
		result = prime * result + ((getExt2() == null) ? 0 : getExt2().hashCode());
		result = prime * result + ((getExt3() == null) ? 0 : getExt3().hashCode());
		result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
		result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
		result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
		result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
		result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
		result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
		result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
		return result;
	}
}
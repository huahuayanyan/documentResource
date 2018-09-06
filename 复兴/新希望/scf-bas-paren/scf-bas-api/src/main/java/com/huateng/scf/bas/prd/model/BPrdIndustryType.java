package com.huateng.scf.bas.prd.model;

import java.io.Serializable;

public class BPrdIndustryType implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(32) 必填<br>
	 * 主键UUID
	 */
	private String id;

	/**
	 * VARCHAR(10) 必填<br>
	 * 产品ID
	 */
	private String productId;

	/**
	 * VARCHAR(50)<br>
	 * 行业类别
	 */
	private String industryType;

	/**
	 * 页面需要的行业代码与行业名称的拼接字段
	 * 
	 */
	private String industryTypeName;

	public synchronized String getIndustryTypeName() {
		return industryTypeName;
	}

	public synchronized void setIndustryTypeName(String industryTypeName) {
		this.industryTypeName = industryTypeName;
	}

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
	 * VARCHAR(50)<br>
	 * 获得 行业类别
	 */
	public String getIndustryType() {
		return industryType;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 行业类别
	 */
	public void setIndustryType(String industryType) {
		this.industryType = industryType == null ? null : industryType.trim();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", productId=").append(productId);
		sb.append(", industryType=").append(industryType);
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
		BPrdIndustryType other = (BPrdIndustryType) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getProductId() == null ? other.getProductId() == null
						: this.getProductId().equals(other.getProductId()))
				&& (this.getIndustryType() == null ? other.getIndustryType() == null
						: this.getIndustryType().equals(other.getIndustryType()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
		result = prime * result + ((getIndustryType() == null) ? 0 : getIndustryType().hashCode());
		return result;
	}
}
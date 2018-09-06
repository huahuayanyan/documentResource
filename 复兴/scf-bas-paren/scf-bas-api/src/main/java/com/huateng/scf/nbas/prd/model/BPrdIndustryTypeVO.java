package com.huateng.scf.nbas.prd.model;

import java.io.Serializable;

public class BPrdIndustryTypeVO implements Serializable {
	private static final long serialVersionUID = 1L;

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
}
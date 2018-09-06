package com.huateng.scf.bas.crm.dao.model;

import java.io.Serializable;
import java.util.Date;

public class BCrmRelationInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(32) 必填<br>
	 * 主键UUID
	 */
	private String id;

	/**
	 * VARCHAR(15) 必填<br>
	 * 买方客户号
	 */
	private String buyerCustcd;

	/**
	 * VARCHAR(15) 必填<br>
	 * 卖方客户号
	 */
	private String sellerCustcd;

	/**
	 * VARCHAR(15)<br>
	 * 核心厂商客户号
	 */
	private String coreCustcd;

	/**
	 * VARCHAR(15)<br>
	 * 监管公司客户号
	 */
	private String moniCustcd;

	/**
	 * CHAR(2) 必填<br>
	 * 状态
	 */
	private String state;

	/**
	 * CHAR(1)<br>
	 * 客户关联类型：1-保理客户关联关系;2-应收账款质押客户关联关系
	 */
	private String relaType;

	/**
	 * VARCHAR(20) 必填<br>
	 * 创建人
	 */
	private String tlrcd;

	/**
	 * TIMESTAMP(11,6) 必填<br>
	 * 创建时间
	 */
	private Date crtTime;

	/**
	 * VARCHAR(20)<br>
	 * 经办机构
	 */
	private String brcode;

	/**
	 * VARCHAR(20)<br>
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
	 * 
	 * 创建人姓名
	 */
	private String tlrName;
	/**
	 * 
	 * 经办机构名称
	 */
	private String brName;
	/**
	 * 
	 * 最后更新操作员名称
	 */
	private String lastUpdTlrName;
	/**
	 * 
	 * 最后更新机构名称
	 */
	private String lastUpdBrName;

	public String getTlrName() {
		return tlrName;
	}

	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}

	public String getBrName() {
		return brName;
	}

	public void setBrName(String brName) {
		this.brName = brName;
	}

	public String getLastUpdTlrName() {
		return lastUpdTlrName;
	}

	public void setLastUpdTlrName(String lastUpdTlrName) {
		this.lastUpdTlrName = lastUpdTlrName;
	}

	public String getLastUpdBrName() {
		return lastUpdBrName;
	}

	public void setLastUpdBrName(String lastUpdBrName) {
		this.lastUpdBrName = lastUpdBrName;
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
	 * VARCHAR(15) 必填<br>
	 * 获得 买方客户号
	 */
	public String getBuyerCustcd() {
		return buyerCustcd;
	}

	/**
	 * VARCHAR(15) 必填<br>
	 * 设置 买方客户号
	 */
	public void setBuyerCustcd(String buyerCustcd) {
		this.buyerCustcd = buyerCustcd == null ? null : buyerCustcd.trim();
	}

	/**
	 * VARCHAR(15) 必填<br>
	 * 获得 卖方客户号
	 */
	public String getSellerCustcd() {
		return sellerCustcd;
	}

	/**
	 * VARCHAR(15) 必填<br>
	 * 设置 卖方客户号
	 */
	public void setSellerCustcd(String sellerCustcd) {
		this.sellerCustcd = sellerCustcd == null ? null : sellerCustcd.trim();
	}

	/**
	 * VARCHAR(15)<br>
	 * 获得 核心厂商客户号
	 */
	public String getCoreCustcd() {
		return coreCustcd;
	}

	/**
	 * VARCHAR(15)<br>
	 * 设置 核心厂商客户号
	 */
	public void setCoreCustcd(String coreCustcd) {
		this.coreCustcd = coreCustcd == null ? null : coreCustcd.trim();
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
	 * CHAR(2) 必填<br>
	 * 获得 状态
	 */
	public String getState() {
		return state;
	}

	/**
	 * CHAR(2) 必填<br>
	 * 设置 状态
	 */
	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 客户关联类型：1-保理客户关联关系;2-应收账款质押客户关联关系
	 */
	public String getRelaType() {
		return relaType;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 客户关联类型：1-保理客户关联关系;2-应收账款质押客户关联关系
	 */
	public void setRelaType(String relaType) {
		this.relaType = relaType == null ? null : relaType.trim();
	}

	/**
	 * VARCHAR(20) 必填<br>
	 * 获得 创建人
	 */
	public String getTlrcd() {
		return tlrcd;
	}

	/**
	 * VARCHAR(20) 必填<br>
	 * 设置 创建人
	 */
	public void setTlrcd(String tlrcd) {
		this.tlrcd = tlrcd == null ? null : tlrcd.trim();
	}

	/**
	 * TIMESTAMP(11,6) 必填<br>
	 * 获得 创建时间
	 */
	public Date getCrtTime() {
		return crtTime;
	}

	/**
	 * TIMESTAMP(11,6) 必填<br>
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
	 * VARCHAR(20)<br>
	 * 获得 最后更新操作员
	 */
	public String getLastUpdTlrcd() {
		return lastUpdTlrcd;
	}

	/**
	 * VARCHAR(20)<br>
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
		sb.append(", buyerCustcd=").append(buyerCustcd);
		sb.append(", sellerCustcd=").append(sellerCustcd);
		sb.append(", coreCustcd=").append(coreCustcd);
		sb.append(", moniCustcd=").append(moniCustcd);
		sb.append(", state=").append(state);
		sb.append(", relaType=").append(relaType);
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
		BCrmRelationInfo other = (BCrmRelationInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getBuyerCustcd() == null ? other.getBuyerCustcd() == null
						: this.getBuyerCustcd().equals(other.getBuyerCustcd()))
				&& (this.getSellerCustcd() == null ? other.getSellerCustcd() == null
						: this.getSellerCustcd().equals(other.getSellerCustcd()))
				&& (this.getCoreCustcd() == null ? other.getCoreCustcd() == null
						: this.getCoreCustcd().equals(other.getCoreCustcd()))
				&& (this.getMoniCustcd() == null ? other.getMoniCustcd() == null
						: this.getMoniCustcd().equals(other.getMoniCustcd()))
				&& (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
				&& (this.getRelaType() == null ? other.getRelaType() == null
						: this.getRelaType().equals(other.getRelaType()))
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
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getBuyerCustcd() == null) ? 0 : getBuyerCustcd().hashCode());
		result = prime * result + ((getSellerCustcd() == null) ? 0 : getSellerCustcd().hashCode());
		result = prime * result + ((getCoreCustcd() == null) ? 0 : getCoreCustcd().hashCode());
		result = prime * result + ((getMoniCustcd() == null) ? 0 : getMoniCustcd().hashCode());
		result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
		result = prime * result + ((getRelaType() == null) ? 0 : getRelaType().hashCode());
		result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
		result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
		result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
		result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
		result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
		result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
		return result;
	}
}
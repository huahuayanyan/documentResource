package com.huateng.scf.bas.crm.dao.model;

import java.io.Serializable;
import java.util.Date;

public class BCrmUpanddownRel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(32) 必填<br>
	 * 主键UUID
	 */
	private String id;

	/**
	 * VARCHAR(15) 必填<br>
	 * 客户号
	 */
	private String custcd;

	/**
	 * VARCHAR(15) 必填<br>
	 * 核心厂商客户号
	 */
	private String coreCustcd;
	/**
	 * VARCHAR(15) 必填<br>
	 * 核心厂商客户名称
	 */
	private String coreCustName;

	/**
	 * VARCHAR(10) 必填<br>
	 * 组织机构代码
	 */
	private String orgCode;

	/**
	 * CHAR(1) 必填<br>
	 * 状态：1-正常、2-终止
	 */
	private String state;

	/**
	 * CHAR(2) 必填<br>
	 * 与核心厂商关系:01-上游；02-下游
	 */
	private String coreRelationFlg;

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
	 * VARCHAR(15) 必填<br>
	 * 获得 核心厂商客户号
	 */
	public String getCoreCustcd() {
		return coreCustcd;
	}

	/**
	 * VARCHAR(15) 必填<br>
	 * 设置 核心厂商客户号
	 */
	public void setCoreCustcd(String coreCustcd) {
		this.coreCustcd = coreCustcd == null ? null : coreCustcd.trim();
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 获得 组织机构代码
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 设置 组织机构代码
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode == null ? null : orgCode.trim();
	}

	/**
	 * CHAR(1) 必填<br>
	 * 获得 状态：1-正常、2-终止
	 */
	public String getState() {
		return state;
	}

	/**
	 * CHAR(1) 必填<br>
	 * 设置 状态：1-正常、2-终止
	 */
	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	/**
	 * CHAR(2) 必填<br>
	 * 获得 与核心厂商关系:01-上游；02-下游
	 */
	public String getCoreRelationFlg() {
		return coreRelationFlg;
	}

	/**
	 * CHAR(2) 必填<br>
	 * 设置 与核心厂商关系:01-上游；02-下游
	 */
	public void setCoreRelationFlg(String coreRelationFlg) {
		this.coreRelationFlg = coreRelationFlg == null ? null : coreRelationFlg.trim();
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

	public String getCoreCustName() {
		return coreCustName;
	}

	public void setCoreCustName(String coreCustName) {
		this.coreCustName = coreCustName;
	}

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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", custcd=").append(custcd);
		sb.append(", coreCustcd=").append(coreCustcd);
		sb.append(", orgCode=").append(orgCode);
		sb.append(", state=").append(state);
		sb.append(", coreRelationFlg=").append(coreRelationFlg);
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
		BCrmUpanddownRel other = (BCrmUpanddownRel) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
				&& (this.getCoreCustcd() == null ? other.getCoreCustcd() == null
						: this.getCoreCustcd().equals(other.getCoreCustcd()))
				&& (this.getOrgCode() == null ? other.getOrgCode() == null
						: this.getOrgCode().equals(other.getOrgCode()))
				&& (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
				&& (this.getCoreRelationFlg() == null ? other.getCoreRelationFlg() == null
						: this.getCoreRelationFlg().equals(other.getCoreRelationFlg()))
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
		result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
		result = prime * result + ((getCoreCustcd() == null) ? 0 : getCoreCustcd().hashCode());
		result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
		result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
		result = prime * result + ((getCoreRelationFlg() == null) ? 0 : getCoreRelationFlg().hashCode());
		result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
		result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
		result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
		result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
		result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
		result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
		return result;
	}
}
package com.huateng.scf.bas.brp.dao.model;

import java.io.Serializable;
import java.util.Date;

public class BBrpIndustryTypes implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(10) 必填<br>
	 * 行业代码
	 */
	private String industryCode;

	/**
	 * VARCHAR(128) 必填<br>
	 * 行业名称
	 */
	private String industryName;

	/**
	 * CHAR(1) 必填<br>
	 * 1-门类、2-大类、3-中类、4-小类
	 */
	private String industryLevel;

	/**
	 * VARCHAR(10) 必填<br>
	 * 父行业代码
	 */
	private String industryUplevel;

	/**
	 * VARCHAR(20)<br>
	 * 最后更新操作员
	 */
	private String lastUpdTlr;

	/**
	 * DATE(7)<br>
	 * 最后更新时间
	 */
	private Date lastUpdDate;

	/**
	 * VARCHAR(20)<br>
	 * 最后更新机构
	 */
	private String lastUpdBrcode;

	/**
	 * TIMESTAMP(11,6)<br>
	 * 时间戳
	 */
	private Date timestamps;
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
	 * VARCHAR(10) 必填<br>
	 * 获得 行业代码
	 */
	public String getIndustryCode() {
		return industryCode;
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 设置 行业代码
	 */
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode == null ? null : industryCode.trim();
	}

	/**
	 * VARCHAR(128) 必填<br>
	 * 获得 行业名称
	 */
	public String getIndustryName() {
		return industryName;
	}

	/**
	 * VARCHAR(128) 必填<br>
	 * 设置 行业名称
	 */
	public void setIndustryName(String industryName) {
		this.industryName = industryName == null ? null : industryName.trim();
	}

	/**
	 * CHAR(1) 必填<br>
	 * 获得 1-门类、2-大类、3-中类、4-小类
	 */
	public String getIndustryLevel() {
		return industryLevel;
	}

	/**
	 * CHAR(1) 必填<br>
	 * 设置 1-门类、2-大类、3-中类、4-小类
	 */
	public void setIndustryLevel(String industryLevel) {
		this.industryLevel = industryLevel == null ? null : industryLevel.trim();
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 获得 父行业代码
	 */
	public String getIndustryUplevel() {
		return industryUplevel;
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 设置 父行业代码
	 */
	public void setIndustryUplevel(String industryUplevel) {
		this.industryUplevel = industryUplevel == null ? null : industryUplevel.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 最后更新操作员
	 */
	public String getLastUpdTlr() {
		return lastUpdTlr;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 最后更新操作员
	 */
	public void setLastUpdTlr(String lastUpdTlr) {
		this.lastUpdTlr = lastUpdTlr == null ? null : lastUpdTlr.trim();
	}

	/**
	 * DATE(7)<br>
	 * 获得 最后更新时间
	 */
	public Date getLastUpdDate() {
		return lastUpdDate;
	}

	/**
	 * DATE(7)<br>
	 * 设置 最后更新时间
	 */
	public void setLastUpdDate(Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
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

	/**
	 * TIMESTAMP(11,6)<br>
	 * 获得 时间戳
	 */
	public Date getTimestamps() {
		return timestamps;
	}

	/**
	 * TIMESTAMP(11,6)<br>
	 * 设置 时间戳
	 */
	public void setTimestamps(Date timestamps) {
		this.timestamps = timestamps;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", industryCode=").append(industryCode);
		sb.append(", industryName=").append(industryName);
		sb.append(", industryLevel=").append(industryLevel);
		sb.append(", industryUplevel=").append(industryUplevel);
		sb.append(", lastUpdTlr=").append(lastUpdTlr);
		sb.append(", lastUpdDate=").append(lastUpdDate);
		sb.append(", lastUpdBrcode=").append(lastUpdBrcode);
		sb.append(", timestamps=").append(timestamps);
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
		BBrpIndustryTypes other = (BBrpIndustryTypes) that;
		return (this.getIndustryCode() == null ? other.getIndustryCode() == null
				: this.getIndustryCode().equals(other.getIndustryCode()))
				&& (this.getIndustryName() == null ? other.getIndustryName() == null
						: this.getIndustryName().equals(other.getIndustryName()))
				&& (this.getIndustryLevel() == null ? other.getIndustryLevel() == null
						: this.getIndustryLevel().equals(other.getIndustryLevel()))
				&& (this.getIndustryUplevel() == null ? other.getIndustryUplevel() == null
						: this.getIndustryUplevel().equals(other.getIndustryUplevel()))
				&& (this.getLastUpdTlr() == null ? other.getLastUpdTlr() == null
						: this.getLastUpdTlr().equals(other.getLastUpdTlr()))
				&& (this.getLastUpdDate() == null ? other.getLastUpdDate() == null
						: this.getLastUpdDate().equals(other.getLastUpdDate()))
				&& (this.getLastUpdBrcode() == null ? other.getLastUpdBrcode() == null
						: this.getLastUpdBrcode().equals(other.getLastUpdBrcode()))
				&& (this.getTimestamps() == null ? other.getTimestamps() == null
						: this.getTimestamps().equals(other.getTimestamps()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getIndustryCode() == null) ? 0 : getIndustryCode().hashCode());
		result = prime * result + ((getIndustryName() == null) ? 0 : getIndustryName().hashCode());
		result = prime * result + ((getIndustryLevel() == null) ? 0 : getIndustryLevel().hashCode());
		result = prime * result + ((getIndustryUplevel() == null) ? 0 : getIndustryUplevel().hashCode());
		result = prime * result + ((getLastUpdTlr() == null) ? 0 : getLastUpdTlr().hashCode());
		result = prime * result + ((getLastUpdDate() == null) ? 0 : getLastUpdDate().hashCode());
		result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
		result = prime * result + ((getTimestamps() == null) ? 0 : getTimestamps().hashCode());
		return result;
	}
}
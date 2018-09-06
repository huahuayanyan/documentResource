package com.huateng.scf.bas.crm.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BCrmMoniEvaInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(32) 必填<br>
	 * 主键
	 */
	private String id;

	/**
	 * VARCHAR(15) 必填<br>
	 * 客户号
	 */
	private String custcd;
	/**
	 * VARCHAR(15) 必填<br>
	 * 客户名称
	 */
	private String cname;

	public synchronized String getCname() {
		return cname;
	}

	public synchronized void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * VARCHAR(10)<br>
	 * 监管方等级
	 */
	private String levels;

	/**
	 * VARCHAR(10)<br>
	 * 监管区域
	 */
	private String monitorArea;

	/**
	 * VARCHAR(10) 必填<br>
	 * 监管模式
	 */
	private String monitortype;

	/**
	 * VARCHAR(100)<br>
	 * 具体监管区域（省/市）
	 */
	private String detailMonitorArea;

	/**
	 * DECIMAL(16,2)<br>
	 * 监管限额
	 */
	private BigDecimal limitSum;

	/**
	 * CHAR(8)<br>
	 * 等级认定日期
	 */
	private String levelCogniDate;

	/**
	 * CHAR(8)<br>
	 * 等级到期日期
	 */
	private String levelEndDate;

	/**
	 * VARCHAR(10) 必填<br>
	 * 状态
	 */
	private String monitorStatus;

	/**
	 * VARCHAR(500)<br>
	 * 备注
	 */
	private String remark;

	/**
	 * CHAR(8)<br>
	 * 生成日期
	 */
	private String createDate;

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
	 * VARCHAR(10)<br>
	 * 获得 监管方等级
	 */
	public String getLevels() {
		return levels;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 监管方等级
	 */
	public void setLevels(String levels) {
		this.levels = levels == null ? null : levels.trim();
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 监管区域
	 */
	public String getMonitorArea() {
		return monitorArea;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 监管区域
	 */
	public void setMonitorArea(String monitorArea) {
		this.monitorArea = monitorArea == null ? null : monitorArea.trim();
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 获得 监管模式
	 */
	public String getMonitortype() {
		return monitortype;
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 设置 监管模式
	 */
	public void setMonitortype(String monitortype) {
		this.monitortype = monitortype == null ? null : monitortype.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 具体监管区域（省/市）
	 */
	public String getDetailMonitorArea() {
		return detailMonitorArea;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 具体监管区域（省/市）
	 */
	public void setDetailMonitorArea(String detailMonitorArea) {
		this.detailMonitorArea = detailMonitorArea == null ? null : detailMonitorArea.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 监管限额
	 */
	public BigDecimal getLimitSum() {
		return limitSum;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 监管限额
	 */
	public void setLimitSum(BigDecimal limitSum) {
		this.limitSum = limitSum;
	}

	/**
	 * CHAR(8)<br>
	 * 获得 等级认定日期
	 */
	public String getLevelCogniDate() {
		return levelCogniDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 等级认定日期
	 */
	public void setLevelCogniDate(String levelCogniDate) {
		this.levelCogniDate = levelCogniDate == null ? null : levelCogniDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 等级到期日期
	 */
	public String getLevelEndDate() {
		return levelEndDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 等级到期日期
	 */
	public void setLevelEndDate(String levelEndDate) {
		this.levelEndDate = levelEndDate == null ? null : levelEndDate.trim();
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 获得 状态
	 */
	public String getMonitorStatus() {
		return monitorStatus;
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 设置 状态
	 */
	public void setMonitorStatus(String monitorStatus) {
		this.monitorStatus = monitorStatus == null ? null : monitorStatus.trim();
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
	 * CHAR(8)<br>
	 * 获得 生成日期
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 生成日期
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate == null ? null : createDate.trim();
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
		sb.append(", custcd=").append(custcd);
		sb.append(", levels=").append(levels);
		sb.append(", monitorArea=").append(monitorArea);
		sb.append(", monitortype=").append(monitortype);
		sb.append(", detailMonitorArea=").append(detailMonitorArea);
		sb.append(", limitSum=").append(limitSum);
		sb.append(", levelCogniDate=").append(levelCogniDate);
		sb.append(", levelEndDate=").append(levelEndDate);
		sb.append(", monitorStatus=").append(monitorStatus);
		sb.append(", remark=").append(remark);
		sb.append(", createDate=").append(createDate);
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
		BCrmMoniEvaInfo other = (BCrmMoniEvaInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
				&& (this.getLevels() == null ? other.getLevels() == null : this.getLevels().equals(other.getLevels()))
				&& (this.getMonitorArea() == null ? other.getMonitorArea() == null
						: this.getMonitorArea().equals(other.getMonitorArea()))
				&& (this.getMonitortype() == null ? other.getMonitortype() == null
						: this.getMonitortype().equals(other.getMonitortype()))
				&& (this.getDetailMonitorArea() == null ? other.getDetailMonitorArea() == null
						: this.getDetailMonitorArea().equals(other.getDetailMonitorArea()))
				&& (this.getLimitSum() == null ? other.getLimitSum() == null
						: this.getLimitSum().equals(other.getLimitSum()))
				&& (this.getLevelCogniDate() == null ? other.getLevelCogniDate() == null
						: this.getLevelCogniDate().equals(other.getLevelCogniDate()))
				&& (this.getLevelEndDate() == null ? other.getLevelEndDate() == null
						: this.getLevelEndDate().equals(other.getLevelEndDate()))
				&& (this.getMonitorStatus() == null ? other.getMonitorStatus() == null
						: this.getMonitorStatus().equals(other.getMonitorStatus()))
				&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
				&& (this.getCreateDate() == null ? other.getCreateDate() == null
						: this.getCreateDate().equals(other.getCreateDate()))
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
		result = prime * result + ((getLevels() == null) ? 0 : getLevels().hashCode());
		result = prime * result + ((getMonitorArea() == null) ? 0 : getMonitorArea().hashCode());
		result = prime * result + ((getMonitortype() == null) ? 0 : getMonitortype().hashCode());
		result = prime * result + ((getDetailMonitorArea() == null) ? 0 : getDetailMonitorArea().hashCode());
		result = prime * result + ((getLimitSum() == null) ? 0 : getLimitSum().hashCode());
		result = prime * result + ((getLevelCogniDate() == null) ? 0 : getLevelCogniDate().hashCode());
		result = prime * result + ((getLevelEndDate() == null) ? 0 : getLevelEndDate().hashCode());
		result = prime * result + ((getMonitorStatus() == null) ? 0 : getMonitorStatus().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
		result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
		result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
		result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
		result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
		result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
		result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
		return result;
	}
}
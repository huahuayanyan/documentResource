package com.huateng.scf.bas.pbc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BPbcMtgClassVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * DECIMAL(22) 必填<br>
	 * 押品代码
	 */
	private BigDecimal mortgageCode;

	/**
	 * VARCHAR(100)<br>
	 * 押品名称
	 */
	private String mortgageName;

	/**
	 * DECIMAL(22)<br>
	 * 上级押品代码
	 */
	private BigDecimal parentCode;

	/**
	 * CHAR(1)<br>
	 * 状态
	 */
	private String status;

	/**
	 * CHAR(4)<br>
	 * 押品种类
	 */
	private String mortgageType;

	/**
	 * CHAR(1)<br>
	 * 押品等级
	 */
	private String levels;

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
	 * VARCHAR(100)<br>
	 * 扩展字段5
	 */
	private String ext4;

	/**
	 * VARCHAR(100)<br>
	 * 扩展字段6
	 */
	private String ext5;

	/**
	 * VARCHAR(100)<br>
	 * 扩展字段7
	 */
	private String ext6;

	/**
	 * VARCHAR(200)<br>
	 * 扩展字段8
	 */
	private String ext7;

	/**
	 * VARCHAR(200)<br>
	 * 扩展字段9
	 */
	private String ext8;

	/**
	 * DECIMAL(9,2)<br>
	 * 质押率
	 */
	private BigDecimal ration;

	/**
	 * VARCHAR(3)<br>
	 * 单位
	 */
	private String units;

	/**
	 * VARCHAR(50)<br>
	 * 单位名称
	 */
	private String unitsname;

	/**
	 * VARCHAR(10)<br>
	 * 重估市价间隔(天)
	 */
	private String revaluationInterval;

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
	 * VARCHAR(20)<br>
	 * 是否管理押品一级
	 */
	private Boolean associateOne;

	/**
	 * DECIMAL(22) 必填<br>
	 * 获得 押品代码
	 */
	public BigDecimal getMortgageCode() {
		return mortgageCode;
	}

	/**
	 * DECIMAL(22) 必填<br>
	 * 设置 押品代码
	 */
	public void setMortgageCode(BigDecimal mortgageCode) {
		this.mortgageCode = mortgageCode;
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 押品名称
	 */
	public String getMortgageName() {
		return mortgageName;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 押品名称
	 */
	public void setMortgageName(String mortgageName) {
		this.mortgageName = mortgageName == null ? null : mortgageName.trim();
	}

	/**
	 * DECIMAL(22)<br>
	 * 获得 上级押品代码
	 */
	public BigDecimal getParentCode() {
		return parentCode;
	}

	/**
	 * DECIMAL(22)<br>
	 * 设置 上级押品代码
	 */
	public void setParentCode(BigDecimal parentCode) {
		this.parentCode = parentCode;
	}

	/**
	 * CHAR(1)<br>
	 * 获得 状态
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 状态
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	/**
	 * CHAR(4)<br>
	 * 获得 押品种类
	 */
	public String getMortgageType() {
		return mortgageType;
	}

	/**
	 * CHAR(4)<br>
	 * 设置 押品种类
	 */
	public void setMortgageType(String mortgageType) {
		this.mortgageType = mortgageType == null ? null : mortgageType.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 押品等级
	 */
	public String getLevels() {
		return levels;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 押品等级
	 */
	public void setLevels(String levels) {
		this.levels = levels == null ? null : levels.trim();
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
	 * VARCHAR(100)<br>
	 * 获得 扩展字段5
	 */
	public String getExt4() {
		return ext4;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 扩展字段5
	 */
	public void setExt4(String ext4) {
		this.ext4 = ext4 == null ? null : ext4.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 扩展字段6
	 */
	public String getExt5() {
		return ext5;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 扩展字段6
	 */
	public void setExt5(String ext5) {
		this.ext5 = ext5 == null ? null : ext5.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 扩展字段7
	 */
	public String getExt6() {
		return ext6;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 扩展字段7
	 */
	public void setExt6(String ext6) {
		this.ext6 = ext6 == null ? null : ext6.trim();
	}

	/**
	 * VARCHAR(200)<br>
	 * 获得 扩展字段8
	 */
	public String getExt7() {
		return ext7;
	}

	/**
	 * VARCHAR(200)<br>
	 * 设置 扩展字段8
	 */
	public void setExt7(String ext7) {
		this.ext7 = ext7 == null ? null : ext7.trim();
	}

	/**
	 * VARCHAR(200)<br>
	 * 获得 扩展字段9
	 */
	public String getExt8() {
		return ext8;
	}

	/**
	 * VARCHAR(200)<br>
	 * 设置 扩展字段9
	 */
	public void setExt8(String ext8) {
		this.ext8 = ext8 == null ? null : ext8.trim();
	}

	/**
	 * DECIMAL(9,2)<br>
	 * 获得 质押率
	 */
	public BigDecimal getRation() {
		return ration;
	}

	/**
	 * DECIMAL(9,2)<br>
	 * 设置 质押率
	 */
	public void setRation(BigDecimal ration) {
		this.ration = ration;
	}

	/**
	 * VARCHAR(3)<br>
	 * 获得 单位
	 */
	public String getUnits() {
		return units;
	}

	/**
	 * VARCHAR(3)<br>
	 * 设置 单位
	 */
	public void setUnits(String units) {
		this.units = units == null ? null : units.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 单位名称
	 */
	public String getUnitsname() {
		return unitsname;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 单位名称
	 */
	public void setUnitsname(String unitsname) {
		this.unitsname = unitsname == null ? null : unitsname.trim();
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 重估市价间隔(天)
	 */
	public String getRevaluationInterval() {
		return revaluationInterval;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 重估市价间隔(天)
	 */
	public void setRevaluationInterval(String revaluationInterval) {
		this.revaluationInterval = revaluationInterval == null ? null : revaluationInterval.trim();
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
		sb.append(", mortgageCode=").append(mortgageCode);
		sb.append(", mortgageName=").append(mortgageName);
		sb.append(", parentCode=").append(parentCode);
		sb.append(", status=").append(status);
		sb.append(", mortgageType=").append(mortgageType);
		sb.append(", levels=").append(levels);
		sb.append(", ext1=").append(ext1);
		sb.append(", ext2=").append(ext2);
		sb.append(", ext3=").append(ext3);
		sb.append(", ext4=").append(ext4);
		sb.append(", ext5=").append(ext5);
		sb.append(", ext6=").append(ext6);
		sb.append(", ext7=").append(ext7);
		sb.append(", ext8=").append(ext8);
		sb.append(", ration=").append(ration);
		sb.append(", units=").append(units);
		sb.append(", unitsname=").append(unitsname);
		sb.append(", revaluationInterval=").append(revaluationInterval);
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
		BPbcMtgClassVO other = (BPbcMtgClassVO) that;
		return (this.getMortgageCode() == null ? other.getMortgageCode() == null : this.getMortgageCode().equals(other.getMortgageCode()))
				&& (this.getMortgageName() == null ? other.getMortgageName() == null : this.getMortgageName().equals(other.getMortgageName()))
				&& (this.getParentCode() == null ? other.getParentCode() == null : this.getParentCode().equals(other.getParentCode()))
				&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
				&& (this.getMortgageType() == null ? other.getMortgageType() == null : this.getMortgageType().equals(other.getMortgageType()))
				&& (this.getLevels() == null ? other.getLevels() == null : this.getLevels().equals(other.getLevels()))
				&& (this.getExt1() == null ? other.getExt1() == null : this.getExt1().equals(other.getExt1()))
				&& (this.getExt2() == null ? other.getExt2() == null : this.getExt2().equals(other.getExt2()))
				&& (this.getExt3() == null ? other.getExt3() == null : this.getExt3().equals(other.getExt3()))
				&& (this.getExt4() == null ? other.getExt4() == null : this.getExt4().equals(other.getExt4()))
				&& (this.getExt5() == null ? other.getExt5() == null : this.getExt5().equals(other.getExt5()))
				&& (this.getExt6() == null ? other.getExt6() == null : this.getExt6().equals(other.getExt6()))
				&& (this.getExt7() == null ? other.getExt7() == null : this.getExt7().equals(other.getExt7()))
				&& (this.getExt8() == null ? other.getExt8() == null : this.getExt8().equals(other.getExt8()))
				&& (this.getRation() == null ? other.getRation() == null : this.getRation().equals(other.getRation()))
				&& (this.getUnits() == null ? other.getUnits() == null : this.getUnits().equals(other.getUnits()))
				&& (this.getUnitsname() == null ? other.getUnitsname() == null : this.getUnitsname().equals(other.getUnitsname()))
				&& (this.getRevaluationInterval() == null ? other.getRevaluationInterval() == null
						: this.getRevaluationInterval().equals(other.getRevaluationInterval()))
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
		result = prime * result + ((getMortgageCode() == null) ? 0 : getMortgageCode().hashCode());
		result = prime * result + ((getMortgageName() == null) ? 0 : getMortgageName().hashCode());
		result = prime * result + ((getParentCode() == null) ? 0 : getParentCode().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getMortgageType() == null) ? 0 : getMortgageType().hashCode());
		result = prime * result + ((getLevels() == null) ? 0 : getLevels().hashCode());
		result = prime * result + ((getExt1() == null) ? 0 : getExt1().hashCode());
		result = prime * result + ((getExt2() == null) ? 0 : getExt2().hashCode());
		result = prime * result + ((getExt3() == null) ? 0 : getExt3().hashCode());
		result = prime * result + ((getExt4() == null) ? 0 : getExt4().hashCode());
		result = prime * result + ((getExt5() == null) ? 0 : getExt5().hashCode());
		result = prime * result + ((getExt6() == null) ? 0 : getExt6().hashCode());
		result = prime * result + ((getExt7() == null) ? 0 : getExt7().hashCode());
		result = prime * result + ((getExt8() == null) ? 0 : getExt8().hashCode());
		result = prime * result + ((getRation() == null) ? 0 : getRation().hashCode());
		result = prime * result + ((getUnits() == null) ? 0 : getUnits().hashCode());
		result = prime * result + ((getUnitsname() == null) ? 0 : getUnitsname().hashCode());
		result = prime * result + ((getRevaluationInterval() == null) ? 0 : getRevaluationInterval().hashCode());
		result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
		result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
		result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
		result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
		result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
		result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
		return result;
	}

	public Boolean getAssociateOne() {
		return associateOne;
	}

	public void setAssociateOne(Boolean associateOne) {
		this.associateOne = associateOne;
	}
}
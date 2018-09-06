package com.huateng.scf.bas.crm.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.huateng.scf.bas.common.model.ScfBaseModel;

public class BCrmMoniEntInfo extends ScfBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(15) 必填<br>
	 * 客户号
	 */
	private String custcd;

	/**
	 * CHAR(2)<br>
	 * 监管公司类型
	 */
	private String monitoryType;

	/**
	 * VARCHAR(300)<br>
	 * 注册地址
	 */
	private String regAddr;

	/**
	 * CHAR(3)<br>
	 * 币种
	 */
	private String curcd;

	/**
	 * DECIMAL(16,2)<br>
	 * 监管总限额
	 */
	private BigDecimal limitSum;

	/**
	 * DECIMAL(16,2)<br>
	 * 单笔最大限额
	 */
	private BigDecimal limitSingle;

	/**
	 * DECIMAL(16,2)<br>
	 * 已监管限额
	 */
	private BigDecimal userdLimit;

	/**
	 * CHAR(8) 必填<br>
	 * 建档日期
	 */
	private String createDate;

	/**
	 * VARCHAR(500)<br>
	 * 备注
	 */
	private String description;

	/**
	 * VARCHAR(2)<br>
	 * 监管方等级
	 */
	private String levels;

	/**
	 * VARCHAR(10) 必填<br>
	 * 监管模式:自有库监管、输出监管
	 */
	private String monitortype;

	/**
	 * CHAR(1)<br>
	 * 是否集团公司：1-集团模式;0-单户模式
	 */
	private String grouped;

	/**
	 * CHAR(1)<br>
	 * 是否集团成员：1-是;0-否
	 */
	private String groupedMember;

	/**
	 * VARCHAR(15)<br>
	 * 上级监管公司客户号
	 */
	private String parentId;
	/**
	 * VARCHAR(15)<br>
	 * 上级监管公司名称
	 */
	private String parentName;

	public synchronized String getParentName() {
		return parentName;
	}

	public synchronized void setParentName(String parentName) {
		this.parentName = parentName;
	}

	/**
	 * VARCHAR(300)<br>
	 * 仓库所在地（1:异地/2:本地自有/3:本地租用/4:本地第三方）
	 */
	private String warehouseAddrType;

	/**
	 * CHAR(1)<br>
	 * 渠道模式(1：银企直连 /2：企业网银在线 /3：线下书面面函）
	 */
	private String channelMode;

	/**
	 * VARCHAR(6)<br>
	 * 银企直连模式(1：中远；2：青岛大宗；3：武汉银安通；4：南京慕燕)
	 */
	private String bankCorporateMode;

	/**
	 * CHAR(1)<br>
	 * 集团监管公司授信类型：1:总对总，0：非总对总
	 */
	private String creditType;

	/**
	 * CHAR(1)<br>
	 * 监管区域：1-所属省份（或直辖市）下辖区域内;2-地级市（或直辖市）下辖区域内;3-无监管区域限制
	 */
	private String monitorArea;

	/**
	 * VARCHAR(100)<br>
	 * 具体监管区域（省/市）
	 */
	private String detailMonitorArea;

	/**
	 * CHAR(8) 必填<br>
	 * 等级认定日期
	 */
	private String levelCogniDate;

	/**
	 * CHAR(8) 必填<br>
	 * 等级到期日期
	 */
	private String levelEndDate;

	/**
	 * CHAR(1) 必填<br>
	 * 状态：1-正常、2-终止
	 */
	private String monitorStatus;

	/**
	 * DECIMAL(22)<br>
	 * 巡库频率(天)
	 */
	private BigDecimal inspectFrequence;

	/**
	 * CHAR(1)<br>
	 * 业务受理控制：0-关、1-开
	 */
	private String bussControlFlag;

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
	 * CHAR(2)<br>
	 * 获得 监管公司类型
	 */
	public String getMonitoryType() {
		return monitoryType;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 监管公司类型
	 */
	public void setMonitoryType(String monitoryType) {
		this.monitoryType = monitoryType == null ? null : monitoryType.trim();
	}

	/**
	 * VARCHAR(300)<br>
	 * 获得 注册地址
	 */
	public String getRegAddr() {
		return regAddr;
	}

	/**
	 * VARCHAR(300)<br>
	 * 设置 注册地址
	 */
	public void setRegAddr(String regAddr) {
		this.regAddr = regAddr == null ? null : regAddr.trim();
	}

	/**
	 * CHAR(3)<br>
	 * 获得 币种
	 */
	public String getCurcd() {
		return curcd;
	}

	/**
	 * CHAR(3)<br>
	 * 设置 币种
	 */
	public void setCurcd(String curcd) {
		this.curcd = curcd == null ? null : curcd.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 监管总限额
	 */
	public BigDecimal getLimitSum() {
		return limitSum;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 监管总限额
	 */
	public void setLimitSum(BigDecimal limitSum) {
		this.limitSum = limitSum;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 单笔最大限额
	 */
	public BigDecimal getLimitSingle() {
		return limitSingle;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 单笔最大限额
	 */
	public void setLimitSingle(BigDecimal limitSingle) {
		this.limitSingle = limitSingle;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 已监管限额
	 */
	public BigDecimal getUserdLimit() {
		return userdLimit;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 已监管限额
	 */
	public void setUserdLimit(BigDecimal userdLimit) {
		this.userdLimit = userdLimit;
	}

	/**
	 * CHAR(8) 必填<br>
	 * 获得 建档日期
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * CHAR(8) 必填<br>
	 * 设置 建档日期
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate == null ? null : createDate.trim();
	}

	/**
	 * VARCHAR(500)<br>
	 * 获得 备注
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * VARCHAR(500)<br>
	 * 设置 备注
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * VARCHAR(2)<br>
	 * 获得 监管方等级
	 */
	public String getLevels() {
		return levels;
	}

	/**
	 * VARCHAR(2)<br>
	 * 设置 监管方等级
	 */
	public void setLevels(String levels) {
		this.levels = levels == null ? null : levels.trim();
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 获得 监管模式:自有库监管、输出监管
	 */
	public String getMonitortype() {
		return monitortype;
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 设置 监管模式:自有库监管、输出监管
	 */
	public void setMonitortype(String monitortype) {
		this.monitortype = monitortype == null ? null : monitortype.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否集团公司：1-集团模式;0-单户模式
	 */
	public String getGrouped() {
		return grouped;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否集团公司：1-集团模式;0-单户模式
	 */
	public void setGrouped(String grouped) {
		this.grouped = grouped == null ? null : grouped.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否集团成员：1-是;0-否
	 */
	public String getGroupedMember() {
		return groupedMember;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否集团成员：1-是;0-否
	 */
	public void setGroupedMember(String groupedMember) {
		this.groupedMember = groupedMember == null ? null : groupedMember.trim();
	}

	/**
	 * VARCHAR(15)<br>
	 * 获得 上级监管公司客户号
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * VARCHAR(15)<br>
	 * 设置 上级监管公司客户号
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId == null ? null : parentId.trim();
	}

	/**
	 * VARCHAR(300)<br>
	 * 获得 仓库所在地（1:异地/2:本地自有/3:本地租用/4:本地第三方）
	 */
	public String getWarehouseAddrType() {
		return warehouseAddrType;
	}

	/**
	 * VARCHAR(300)<br>
	 * 设置 仓库所在地（1:异地/2:本地自有/3:本地租用/4:本地第三方）
	 */
	public void setWarehouseAddrType(String warehouseAddrType) {
		this.warehouseAddrType = warehouseAddrType == null ? null : warehouseAddrType.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 渠道模式(1：银企直连 /2：企业网银在线 /3：线下书面面函）
	 */
	public String getChannelMode() {
		return channelMode;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 渠道模式(1：银企直连 /2：企业网银在线 /3：线下书面面函）
	 */
	public void setChannelMode(String channelMode) {
		this.channelMode = channelMode == null ? null : channelMode.trim();
	}

	/**
	 * VARCHAR(6)<br>
	 * 获得 银企直连模式(1：中远；2：青岛大宗；3：武汉银安通；4：南京慕燕)
	 */
	public String getBankCorporateMode() {
		return bankCorporateMode;
	}

	/**
	 * VARCHAR(6)<br>
	 * 设置 银企直连模式(1：中远；2：青岛大宗；3：武汉银安通；4：南京慕燕)
	 */
	public void setBankCorporateMode(String bankCorporateMode) {
		this.bankCorporateMode = bankCorporateMode == null ? null : bankCorporateMode.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 集团监管公司授信类型：1:总对总，0：非总对总
	 */
	public String getCreditType() {
		return creditType;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 集团监管公司授信类型：1:总对总，0：非总对总
	 */
	public void setCreditType(String creditType) {
		this.creditType = creditType == null ? null : creditType.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 监管区域：1-所属省份（或直辖市）下辖区域内;2-地级市（或直辖市）下辖区域内;3-无监管区域限制
	 */
	public String getMonitorArea() {
		return monitorArea;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 监管区域：1-所属省份（或直辖市）下辖区域内;2-地级市（或直辖市）下辖区域内;3-无监管区域限制
	 */
	public void setMonitorArea(String monitorArea) {
		this.monitorArea = monitorArea == null ? null : monitorArea.trim();
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
	 * CHAR(8) 必填<br>
	 * 获得 等级认定日期
	 */
	public String getLevelCogniDate() {
		return levelCogniDate;
	}

	/**
	 * CHAR(8) 必填<br>
	 * 设置 等级认定日期
	 */
	public void setLevelCogniDate(String levelCogniDate) {
		this.levelCogniDate = levelCogniDate == null ? null : levelCogniDate.trim();
	}

	/**
	 * CHAR(8) 必填<br>
	 * 获得 等级到期日期
	 */
	public String getLevelEndDate() {
		return levelEndDate;
	}

	/**
	 * CHAR(8) 必填<br>
	 * 设置 等级到期日期
	 */
	public void setLevelEndDate(String levelEndDate) {
		this.levelEndDate = levelEndDate == null ? null : levelEndDate.trim();
	}

	/**
	 * CHAR(1) 必填<br>
	 * 获得 状态：1-正常、2-终止
	 */
	public String getMonitorStatus() {
		return monitorStatus;
	}

	/**
	 * CHAR(1) 必填<br>
	 * 设置 状态：1-正常、2-终止
	 */
	public void setMonitorStatus(String monitorStatus) {
		this.monitorStatus = monitorStatus == null ? null : monitorStatus.trim();
	}

	/**
	 * DECIMAL(22)<br>
	 * 获得 巡库频率(天)
	 */
	public BigDecimal getInspectFrequence() {
		return inspectFrequence;
	}

	/**
	 * DECIMAL(22)<br>
	 * 设置 巡库频率(天)
	 */
	public void setInspectFrequence(BigDecimal inspectFrequence) {
		this.inspectFrequence = inspectFrequence;
	}

	/**
	 * CHAR(1)<br>
	 * 获得 业务受理控制：0-关、1-开
	 */
	public String getBussControlFlag() {
		return bussControlFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 业务受理控制：0-关、1-开
	 */
	public void setBussControlFlag(String bussControlFlag) {
		this.bussControlFlag = bussControlFlag == null ? null : bussControlFlag.trim();
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
		sb.append(", custcd=").append(custcd);
		sb.append(", monitoryType=").append(monitoryType);
		sb.append(", regAddr=").append(regAddr);
		sb.append(", curcd=").append(curcd);
		sb.append(", limitSum=").append(limitSum);
		sb.append(", limitSingle=").append(limitSingle);
		sb.append(", userdLimit=").append(userdLimit);
		sb.append(", createDate=").append(createDate);
		sb.append(", description=").append(description);
		sb.append(", levels=").append(levels);
		sb.append(", monitortype=").append(monitortype);
		sb.append(", grouped=").append(grouped);
		sb.append(", groupedMember=").append(groupedMember);
		sb.append(", parentId=").append(parentId);
		sb.append(", warehouseAddrType=").append(warehouseAddrType);
		sb.append(", channelMode=").append(channelMode);
		sb.append(", bankCorporateMode=").append(bankCorporateMode);
		sb.append(", creditType=").append(creditType);
		sb.append(", monitorArea=").append(monitorArea);
		sb.append(", detailMonitorArea=").append(detailMonitorArea);
		sb.append(", levelCogniDate=").append(levelCogniDate);
		sb.append(", levelEndDate=").append(levelEndDate);
		sb.append(", monitorStatus=").append(monitorStatus);
		sb.append(", inspectFrequence=").append(inspectFrequence);
		sb.append(", bussControlFlag=").append(bussControlFlag);
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
		BCrmMoniEntInfo other = (BCrmMoniEntInfo) that;
		return (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
				&& (this.getMonitoryType() == null ? other.getMonitoryType() == null
						: this.getMonitoryType().equals(other.getMonitoryType()))
				&& (this.getRegAddr() == null ? other.getRegAddr() == null
						: this.getRegAddr().equals(other.getRegAddr()))
				&& (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
				&& (this.getLimitSum() == null ? other.getLimitSum() == null
						: this.getLimitSum().equals(other.getLimitSum()))
				&& (this.getLimitSingle() == null ? other.getLimitSingle() == null
						: this.getLimitSingle().equals(other.getLimitSingle()))
				&& (this.getUserdLimit() == null ? other.getUserdLimit() == null
						: this.getUserdLimit().equals(other.getUserdLimit()))
				&& (this.getCreateDate() == null ? other.getCreateDate() == null
						: this.getCreateDate().equals(other.getCreateDate()))
				&& (this.getDescription() == null ? other.getDescription() == null
						: this.getDescription().equals(other.getDescription()))
				&& (this.getLevels() == null ? other.getLevels() == null : this.getLevels().equals(other.getLevels()))
				&& (this.getMonitortype() == null ? other.getMonitortype() == null
						: this.getMonitortype().equals(other.getMonitortype()))
				&& (this.getGrouped() == null ? other.getGrouped() == null
						: this.getGrouped().equals(other.getGrouped()))
				&& (this.getGroupedMember() == null ? other.getGroupedMember() == null
						: this.getGroupedMember().equals(other.getGroupedMember()))
				&& (this.getParentId() == null ? other.getParentId() == null
						: this.getParentId().equals(other.getParentId()))
				&& (this.getWarehouseAddrType() == null ? other.getWarehouseAddrType() == null
						: this.getWarehouseAddrType().equals(other.getWarehouseAddrType()))
				&& (this.getChannelMode() == null ? other.getChannelMode() == null
						: this.getChannelMode().equals(other.getChannelMode()))
				&& (this.getBankCorporateMode() == null ? other.getBankCorporateMode() == null
						: this.getBankCorporateMode().equals(other.getBankCorporateMode()))
				&& (this.getCreditType() == null ? other.getCreditType() == null
						: this.getCreditType().equals(other.getCreditType()))
				&& (this.getMonitorArea() == null ? other.getMonitorArea() == null
						: this.getMonitorArea().equals(other.getMonitorArea()))
				&& (this.getDetailMonitorArea() == null ? other.getDetailMonitorArea() == null
						: this.getDetailMonitorArea().equals(other.getDetailMonitorArea()))
				&& (this.getLevelCogniDate() == null ? other.getLevelCogniDate() == null
						: this.getLevelCogniDate().equals(other.getLevelCogniDate()))
				&& (this.getLevelEndDate() == null ? other.getLevelEndDate() == null
						: this.getLevelEndDate().equals(other.getLevelEndDate()))
				&& (this.getMonitorStatus() == null ? other.getMonitorStatus() == null
						: this.getMonitorStatus().equals(other.getMonitorStatus()))
				&& (this.getInspectFrequence() == null ? other.getInspectFrequence() == null
						: this.getInspectFrequence().equals(other.getInspectFrequence()))
				&& (this.getBussControlFlag() == null ? other.getBussControlFlag() == null
						: this.getBussControlFlag().equals(other.getBussControlFlag()))
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
		result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
		result = prime * result + ((getMonitoryType() == null) ? 0 : getMonitoryType().hashCode());
		result = prime * result + ((getRegAddr() == null) ? 0 : getRegAddr().hashCode());
		result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
		result = prime * result + ((getLimitSum() == null) ? 0 : getLimitSum().hashCode());
		result = prime * result + ((getLimitSingle() == null) ? 0 : getLimitSingle().hashCode());
		result = prime * result + ((getUserdLimit() == null) ? 0 : getUserdLimit().hashCode());
		result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
		result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
		result = prime * result + ((getLevels() == null) ? 0 : getLevels().hashCode());
		result = prime * result + ((getMonitortype() == null) ? 0 : getMonitortype().hashCode());
		result = prime * result + ((getGrouped() == null) ? 0 : getGrouped().hashCode());
		result = prime * result + ((getGroupedMember() == null) ? 0 : getGroupedMember().hashCode());
		result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
		result = prime * result + ((getWarehouseAddrType() == null) ? 0 : getWarehouseAddrType().hashCode());
		result = prime * result + ((getChannelMode() == null) ? 0 : getChannelMode().hashCode());
		result = prime * result + ((getBankCorporateMode() == null) ? 0 : getBankCorporateMode().hashCode());
		result = prime * result + ((getCreditType() == null) ? 0 : getCreditType().hashCode());
		result = prime * result + ((getMonitorArea() == null) ? 0 : getMonitorArea().hashCode());
		result = prime * result + ((getDetailMonitorArea() == null) ? 0 : getDetailMonitorArea().hashCode());
		result = prime * result + ((getLevelCogniDate() == null) ? 0 : getLevelCogniDate().hashCode());
		result = prime * result + ((getLevelEndDate() == null) ? 0 : getLevelEndDate().hashCode());
		result = prime * result + ((getMonitorStatus() == null) ? 0 : getMonitorStatus().hashCode());
		result = prime * result + ((getInspectFrequence() == null) ? 0 : getInspectFrequence().hashCode());
		result = prime * result + ((getBussControlFlag() == null) ? 0 : getBussControlFlag().hashCode());
		result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
		result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
		result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
		result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
		result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
		result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
		return result;
	}
}
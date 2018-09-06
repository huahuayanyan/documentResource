package com.huateng.scf.bas.crm.model;

import java.io.Serializable;
import java.util.Date;

import com.huateng.scf.bas.common.model.ScfBaseModel;

public class BCrmBaseInfo extends ScfBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(15) 必填<br>
	 * 客户号
	 */
	private String custcd;

	/**
	 * VARCHAR(50)<br>
	 * 核心客户号
	 */
	private String custno;

	/**
	 * CHAR(1) 必填<br>
	 * 客户类型：1-法人;2-自然人;3-同业
	 */
	private String custType;

	/**
	 * VARCHAR(10) 必填<br>
	 * 证件类型：01-组织机构代码证、02-营业执照、03-其他企业证件、04-社会信用代码证
	 */
	private String idtype;
	/**
	 * 客户删除标识
	 * 
	 */
	private String deleteFlag;

	private String factType;
	/**
	 * CHAR(2)<br>
	 * 融资模式：1-发票融资;2-池融资
	 */
	private String financingType;
	/**
	 * VARCHAR(30) 必填<br>
	 * 证件号码
	 */
	private String idno;

	/**
	 * VARCHAR(80) 必填<br>
	 * 客户名称
	 */
	private String cname;

	/**
	 * VARCHAR(120)<br>
	 * 客户英文名
	 */
	private String ename;

	/**
	 * VARCHAR(80)<br>
	 * 客户别名
	 */
	private String aliasName;

	/**
	 * VARCHAR(10) 必填<br>
	 * 组织机构代码
	 */
	private String orgCode;

	/**
	 * VARCHAR(50)<br>
	 * 社会信用代码
	 */
	private String socCreditNo;

	/**
	 * VARCHAR(20)<br>
	 * 营业执照注册号
	 */
	private String licenseNo;

	/**
	 * CHAR(8)<br>
	 * 营业执照到期日
	 */
	private String licenseDate;

	/**
	 * CHAR(8)<br>
	 * 开户日期
	 */
	private String openDate;

	/**
	 * CHAR(8)<br>
	 * 核心开户日期
	 */
	private String coreOpenDate;

	/**
	 * CHAR(2)<br>
	 * 客户状态(DATA_DIC.840)
	 */
	private String custStatus;

	/**
	 * VARCHAR(50)<br>
	 * 管户员
	 */
	private String mgrno;

	/**
	 * CHAR(1)<br>
	 * 是否核心厂商：0-否、1-是
	 */
	private String coreFlag;

	/**
	 * CHAR(1)<br>
	 * 是否监管公司：0-否、1-是
	 */
	private String moniFlag;

	/**
	 * CHAR(1)<br>
	 * 是否期货经纪公司：0-否、1-是
	 */
	private String futuresFlag;

	/**
	 * CHAR(1)<br>
	 * 是否金融租赁公司：0-否、1-是
	 */
	private String flcFlag;

	/**
	 * CHAR(8)<br>
	 * 建档日期
	 */
	private String createDate;

	/**
	 * CHAR(1)<br>
	 * 授信客户标识：0-否、1-是
	 */
	private String creditFlag;

	/**
	 * CHAR(1)<br>
	 * 黑名单标识：0-否、1-是
	 */
	private String blackFlag;

	/**
	 * CHAR(1)<br>
	 * 是否保险公司：0-否、1-是
	 */
	private String insureFlag;

	/**
	 * CHAR(1)<br>
	 * 是否保理商：0-否、1-是
	 */
	private String factorFlag;

	/**
	 * VARCHAR(50)<br>
	 * 信贷客户号
	 */
	private String ccmsCustcd;

	/**
	 * CHAR(1)<br>
	 * 是否贸融重点客户：0-否、1-是
	 */
	private String importantFlag;

	/**
	 * CHAR(1)<br>
	 * 是否贸易对手：0-否、1-是
	 */
	private String commercialFalg;

	/**
	 * CHAR(1)<br>
	 * 是否境外：0-否、1-是
	 */
	private String overseasFlag;

	/**
	 * CHAR(1)<br>
	 * 是否是本行客户：0-否、1-是
	 */
	private String banksCustFlag;

	/**
	 * CHAR(1)<br>
	 * 是否是EF进口商：0-否、1-是
	 */
	private String efBuyerFlag;

	/**
	 * CHAR(1)<br>
	 * 是否是IF出口商：0-否、1-是
	 */
	private String ifSellerFlag;

	/**
	 * CHAR(1)<br>
	 * 是否是银行：0-否、1-是
	 */
	private String isBank;

	/**
	 * VARCHAR(10)<br>
	 * FCI代号
	 */
	private String fciCode;

	/**
	 * CHAR(1)<br>
	 * 是否国际保理客户
	 */
	private String isIntl;

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
	 * 
	 * 管户员名称--客户经理名称 mgrno
	 */
	private String brManagerName;

	public synchronized String getBrManagerName() {
		return brManagerName;
	}

	public synchronized void setBrManagerName(String brManagerName) {
		this.brManagerName = brManagerName;
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
	 * VARCHAR(50)<br>
	 * 获得 核心客户号
	 */
	public String getCustno() {
		return custno;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 核心客户号
	 */
	public void setCustno(String custno) {
		this.custno = custno == null ? null : custno.trim();
	}

	/**
	 * CHAR(1) 必填<br>
	 * 获得 客户类型：1-法人;2-自然人;3-同业
	 */
	public String getCustType() {
		return custType;
	}

	/**
	 * CHAR(1) 必填<br>
	 * 设置 客户类型：1-法人;2-自然人;3-同业
	 */
	public void setCustType(String custType) {
		this.custType = custType == null ? null : custType.trim();
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 获得 证件类型：01-组织机构代码证、02-营业执照、03-其他企业证件、04-社会信用代码证
	 */
	public String getIdtype() {
		return idtype;
	}

	/**
	 * VARCHAR(10) 必填<br>
	 * 设置 证件类型：01-组织机构代码证、02-营业执照、03-其他企业证件、04-社会信用代码证
	 */
	public void setIdtype(String idtype) {
		this.idtype = idtype == null ? null : idtype.trim();
	}

	public String getFactType() {
		return factType;
	}

	public void setFactType(String factType) {
		this.factType = factType;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getFinancingType() {
		return financingType;
	}

	public void setFinancingType(String financingType) {
		this.financingType = financingType;
	}

	/**
	 * VARCHAR(30) 必填<br>
	 * 获得 证件号码
	 */
	public String getIdno() {
		return idno;
	}

	/**
	 * VARCHAR(30) 必填<br>
	 * 设置 证件号码
	 */
	public void setIdno(String idno) {
		this.idno = idno == null ? null : idno.trim();
	}

	/**
	 * VARCHAR(80) 必填<br>
	 * 获得 客户名称
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * VARCHAR(80) 必填<br>
	 * 设置 客户名称
	 */
	public void setCname(String cname) {
		this.cname = cname == null ? null : cname.trim();
	}

	/**
	 * VARCHAR(120)<br>
	 * 获得 客户英文名
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * VARCHAR(120)<br>
	 * 设置 客户英文名
	 */
	public void setEname(String ename) {
		this.ename = ename == null ? null : ename.trim();
	}

	/**
	 * VARCHAR(80)<br>
	 * 获得 客户别名
	 */
	public String getAliasName() {
		return aliasName;
	}

	/**
	 * VARCHAR(80)<br>
	 * 设置 客户别名
	 */
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName == null ? null : aliasName.trim();
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
	 * VARCHAR(50)<br>
	 * 获得 社会信用代码
	 */
	public String getSocCreditNo() {
		return socCreditNo;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 社会信用代码
	 */
	public void setSocCreditNo(String socCreditNo) {
		this.socCreditNo = socCreditNo == null ? null : socCreditNo.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 营业执照注册号
	 */
	public String getLicenseNo() {
		return licenseNo;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 营业执照注册号
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo == null ? null : licenseNo.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 营业执照到期日
	 */
	public String getLicenseDate() {
		return licenseDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 营业执照到期日
	 */
	public void setLicenseDate(String licenseDate) {
		this.licenseDate = licenseDate == null ? null : licenseDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 开户日期
	 */
	public String getOpenDate() {
		return openDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 开户日期
	 */
	public void setOpenDate(String openDate) {
		this.openDate = openDate == null ? null : openDate.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 核心开户日期
	 */
	public String getCoreOpenDate() {
		return coreOpenDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 核心开户日期
	 */
	public void setCoreOpenDate(String coreOpenDate) {
		this.coreOpenDate = coreOpenDate == null ? null : coreOpenDate.trim();
	}

	/**
	 * CHAR(2)<br>
	 * 获得 客户状态(DATA_DIC.840)
	 */
	public String getCustStatus() {
		return custStatus;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 客户状态(DATA_DIC.840)
	 */
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus == null ? null : custStatus.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 管户员
	 */
	public String getMgrno() {
		return mgrno;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 管户员
	 */
	public void setMgrno(String mgrno) {
		this.mgrno = mgrno == null ? null : mgrno.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否核心厂商：0-否、1-是
	 */
	public String getCoreFlag() {
		return coreFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否核心厂商：0-否、1-是
	 */
	public void setCoreFlag(String coreFlag) {
		this.coreFlag = coreFlag == null ? null : coreFlag.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否监管公司：0-否、1-是
	 */
	public String getMoniFlag() {
		return moniFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否监管公司：0-否、1-是
	 */
	public void setMoniFlag(String moniFlag) {
		this.moniFlag = moniFlag == null ? null : moniFlag.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否期货经纪公司：0-否、1-是
	 */
	public String getFuturesFlag() {
		return futuresFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否期货经纪公司：0-否、1-是
	 */
	public void setFuturesFlag(String futuresFlag) {
		this.futuresFlag = futuresFlag == null ? null : futuresFlag.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否金融租赁公司：0-否、1-是
	 */
	public String getFlcFlag() {
		return flcFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否金融租赁公司：0-否、1-是
	 */
	public void setFlcFlag(String flcFlag) {
		this.flcFlag = flcFlag == null ? null : flcFlag.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 建档日期
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 建档日期
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate == null ? null : createDate.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 授信客户标识：0-否、1-是
	 */
	public String getCreditFlag() {
		return creditFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 授信客户标识：0-否、1-是
	 */
	public void setCreditFlag(String creditFlag) {
		this.creditFlag = creditFlag == null ? null : creditFlag.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 黑名单标识：0-否、1-是
	 */
	public String getBlackFlag() {
		return blackFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 黑名单标识：0-否、1-是
	 */
	public void setBlackFlag(String blackFlag) {
		this.blackFlag = blackFlag == null ? null : blackFlag.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否保险公司：0-否、1-是
	 */
	public String getInsureFlag() {
		return insureFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否保险公司：0-否、1-是
	 */
	public void setInsureFlag(String insureFlag) {
		this.insureFlag = insureFlag == null ? null : insureFlag.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否保理商：0-否、1-是
	 */
	public String getFactorFlag() {
		return factorFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否保理商：0-否、1-是
	 */
	public void setFactorFlag(String factorFlag) {
		this.factorFlag = factorFlag == null ? null : factorFlag.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 信贷客户号
	 */
	public String getCcmsCustcd() {
		return ccmsCustcd;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 信贷客户号
	 */
	public void setCcmsCustcd(String ccmsCustcd) {
		this.ccmsCustcd = ccmsCustcd == null ? null : ccmsCustcd.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否贸融重点客户：0-否、1-是
	 */
	public String getImportantFlag() {
		return importantFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否贸融重点客户：0-否、1-是
	 */
	public void setImportantFlag(String importantFlag) {
		this.importantFlag = importantFlag == null ? null : importantFlag.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否贸易对手：0-否、1-是
	 */
	public String getCommercialFalg() {
		return commercialFalg;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否贸易对手：0-否、1-是
	 */
	public void setCommercialFalg(String commercialFalg) {
		this.commercialFalg = commercialFalg == null ? null : commercialFalg.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否境外：0-否、1-是
	 */
	public String getOverseasFlag() {
		return overseasFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否境外：0-否、1-是
	 */
	public void setOverseasFlag(String overseasFlag) {
		this.overseasFlag = overseasFlag == null ? null : overseasFlag.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否是本行客户：0-否、1-是
	 */
	public String getBanksCustFlag() {
		return banksCustFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否是本行客户：0-否、1-是
	 */
	public void setBanksCustFlag(String banksCustFlag) {
		this.banksCustFlag = banksCustFlag == null ? null : banksCustFlag.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否是EF进口商：0-否、1-是
	 */
	public String getEfBuyerFlag() {
		return efBuyerFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否是EF进口商：0-否、1-是
	 */
	public void setEfBuyerFlag(String efBuyerFlag) {
		this.efBuyerFlag = efBuyerFlag == null ? null : efBuyerFlag.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否是IF出口商：0-否、1-是
	 */
	public String getIfSellerFlag() {
		return ifSellerFlag;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否是IF出口商：0-否、1-是
	 */
	public void setIfSellerFlag(String ifSellerFlag) {
		this.ifSellerFlag = ifSellerFlag == null ? null : ifSellerFlag.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否是银行：0-否、1-是
	 */
	public String getIsBank() {
		return isBank;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否是银行：0-否、1-是
	 */
	public void setIsBank(String isBank) {
		this.isBank = isBank == null ? null : isBank.trim();
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 FCI代号
	 */
	public String getFciCode() {
		return fciCode;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 FCI代号
	 */
	public void setFciCode(String fciCode) {
		this.fciCode = fciCode == null ? null : fciCode.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否国际保理客户
	 */
	public String getIsIntl() {
		return isIntl;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否国际保理客户
	 */
	public void setIsIntl(String isIntl) {
		this.isIntl = isIntl == null ? null : isIntl.trim();
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
		sb.append(", custno=").append(custno);
		sb.append(", custType=").append(custType);
		sb.append(", idtype=").append(idtype);
		sb.append(", idno=").append(idno);
		sb.append(", cname=").append(cname);
		sb.append(", ename=").append(ename);
		sb.append(", aliasName=").append(aliasName);
		sb.append(", orgCode=").append(orgCode);
		sb.append(", socCreditNo=").append(socCreditNo);
		sb.append(", licenseNo=").append(licenseNo);
		sb.append(", licenseDate=").append(licenseDate);
		sb.append(", openDate=").append(openDate);
		sb.append(", coreOpenDate=").append(coreOpenDate);
		sb.append(", custStatus=").append(custStatus);
		sb.append(", mgrno=").append(mgrno);
		sb.append(", coreFlag=").append(coreFlag);
		sb.append(", moniFlag=").append(moniFlag);
		sb.append(", futuresFlag=").append(futuresFlag);
		sb.append(", flcFlag=").append(flcFlag);
		sb.append(", createDate=").append(createDate);
		sb.append(", creditFlag=").append(creditFlag);
		sb.append(", blackFlag=").append(blackFlag);
		sb.append(", insureFlag=").append(insureFlag);
		sb.append(", factorFlag=").append(factorFlag);
		sb.append(", ccmsCustcd=").append(ccmsCustcd);
		sb.append(", importantFlag=").append(importantFlag);
		sb.append(", commercialFalg=").append(commercialFalg);
		sb.append(", overseasFlag=").append(overseasFlag);
		sb.append(", banksCustFlag=").append(banksCustFlag);
		sb.append(", efBuyerFlag=").append(efBuyerFlag);
		sb.append(", ifSellerFlag=").append(ifSellerFlag);
		sb.append(", isBank=").append(isBank);
		sb.append(", fciCode=").append(fciCode);
		sb.append(", isIntl=").append(isIntl);
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
		BCrmBaseInfo other = (BCrmBaseInfo) that;
		return (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
				&& (this.getCustno() == null ? other.getCustno() == null : this.getCustno().equals(other.getCustno()))
				&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
				&& (this.getIdtype() == null ? other.getIdtype() == null : this.getIdtype().equals(other.getIdtype()))
				&& (this.getIdno() == null ? other.getIdno() == null : this.getIdno().equals(other.getIdno()))
				&& (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()))
				&& (this.getEname() == null ? other.getEname() == null : this.getEname().equals(other.getEname()))
				&& (this.getAliasName() == null ? other.getAliasName() == null : this.getAliasName().equals(other.getAliasName()))
				&& (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
				&& (this.getSocCreditNo() == null ? other.getSocCreditNo() == null : this.getSocCreditNo().equals(other.getSocCreditNo()))
				&& (this.getLicenseNo() == null ? other.getLicenseNo() == null : this.getLicenseNo().equals(other.getLicenseNo()))
				&& (this.getLicenseDate() == null ? other.getLicenseDate() == null : this.getLicenseDate().equals(other.getLicenseDate()))
				&& (this.getOpenDate() == null ? other.getOpenDate() == null : this.getOpenDate().equals(other.getOpenDate()))
				&& (this.getCoreOpenDate() == null ? other.getCoreOpenDate() == null : this.getCoreOpenDate().equals(other.getCoreOpenDate()))
				&& (this.getCustStatus() == null ? other.getCustStatus() == null : this.getCustStatus().equals(other.getCustStatus()))
				&& (this.getMgrno() == null ? other.getMgrno() == null : this.getMgrno().equals(other.getMgrno()))
				&& (this.getCoreFlag() == null ? other.getCoreFlag() == null : this.getCoreFlag().equals(other.getCoreFlag()))
				&& (this.getMoniFlag() == null ? other.getMoniFlag() == null : this.getMoniFlag().equals(other.getMoniFlag()))
				&& (this.getFuturesFlag() == null ? other.getFuturesFlag() == null : this.getFuturesFlag().equals(other.getFuturesFlag()))
				&& (this.getFlcFlag() == null ? other.getFlcFlag() == null : this.getFlcFlag().equals(other.getFlcFlag()))
				&& (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
				&& (this.getCreditFlag() == null ? other.getCreditFlag() == null : this.getCreditFlag().equals(other.getCreditFlag()))
				&& (this.getBlackFlag() == null ? other.getBlackFlag() == null : this.getBlackFlag().equals(other.getBlackFlag()))
				&& (this.getInsureFlag() == null ? other.getInsureFlag() == null : this.getInsureFlag().equals(other.getInsureFlag()))
				&& (this.getFactorFlag() == null ? other.getFactorFlag() == null : this.getFactorFlag().equals(other.getFactorFlag()))
				&& (this.getCcmsCustcd() == null ? other.getCcmsCustcd() == null : this.getCcmsCustcd().equals(other.getCcmsCustcd()))
				&& (this.getImportantFlag() == null ? other.getImportantFlag() == null : this.getImportantFlag().equals(other.getImportantFlag()))
				&& (this.getCommercialFalg() == null ? other.getCommercialFalg() == null : this.getCommercialFalg().equals(other.getCommercialFalg()))
				&& (this.getOverseasFlag() == null ? other.getOverseasFlag() == null : this.getOverseasFlag().equals(other.getOverseasFlag()))
				&& (this.getBanksCustFlag() == null ? other.getBanksCustFlag() == null : this.getBanksCustFlag().equals(other.getBanksCustFlag()))
				&& (this.getEfBuyerFlag() == null ? other.getEfBuyerFlag() == null : this.getEfBuyerFlag().equals(other.getEfBuyerFlag()))
				&& (this.getIfSellerFlag() == null ? other.getIfSellerFlag() == null : this.getIfSellerFlag().equals(other.getIfSellerFlag()))
				&& (this.getIsBank() == null ? other.getIsBank() == null : this.getIsBank().equals(other.getIsBank()))
				&& (this.getFciCode() == null ? other.getFciCode() == null : this.getFciCode().equals(other.getFciCode()))
				&& (this.getIsIntl() == null ? other.getIsIntl() == null : this.getIsIntl().equals(other.getIsIntl()))
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
		result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
		result = prime * result + ((getCustno() == null) ? 0 : getCustno().hashCode());
		result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
		result = prime * result + ((getIdtype() == null) ? 0 : getIdtype().hashCode());
		result = prime * result + ((getIdno() == null) ? 0 : getIdno().hashCode());
		result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
		result = prime * result + ((getEname() == null) ? 0 : getEname().hashCode());
		result = prime * result + ((getAliasName() == null) ? 0 : getAliasName().hashCode());
		result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
		result = prime * result + ((getSocCreditNo() == null) ? 0 : getSocCreditNo().hashCode());
		result = prime * result + ((getLicenseNo() == null) ? 0 : getLicenseNo().hashCode());
		result = prime * result + ((getLicenseDate() == null) ? 0 : getLicenseDate().hashCode());
		result = prime * result + ((getOpenDate() == null) ? 0 : getOpenDate().hashCode());
		result = prime * result + ((getCoreOpenDate() == null) ? 0 : getCoreOpenDate().hashCode());
		result = prime * result + ((getCustStatus() == null) ? 0 : getCustStatus().hashCode());
		result = prime * result + ((getMgrno() == null) ? 0 : getMgrno().hashCode());
		result = prime * result + ((getCoreFlag() == null) ? 0 : getCoreFlag().hashCode());
		result = prime * result + ((getMoniFlag() == null) ? 0 : getMoniFlag().hashCode());
		result = prime * result + ((getFuturesFlag() == null) ? 0 : getFuturesFlag().hashCode());
		result = prime * result + ((getFlcFlag() == null) ? 0 : getFlcFlag().hashCode());
		result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
		result = prime * result + ((getCreditFlag() == null) ? 0 : getCreditFlag().hashCode());
		result = prime * result + ((getBlackFlag() == null) ? 0 : getBlackFlag().hashCode());
		result = prime * result + ((getInsureFlag() == null) ? 0 : getInsureFlag().hashCode());
		result = prime * result + ((getFactorFlag() == null) ? 0 : getFactorFlag().hashCode());
		result = prime * result + ((getCcmsCustcd() == null) ? 0 : getCcmsCustcd().hashCode());
		result = prime * result + ((getImportantFlag() == null) ? 0 : getImportantFlag().hashCode());
		result = prime * result + ((getCommercialFalg() == null) ? 0 : getCommercialFalg().hashCode());
		result = prime * result + ((getOverseasFlag() == null) ? 0 : getOverseasFlag().hashCode());
		result = prime * result + ((getBanksCustFlag() == null) ? 0 : getBanksCustFlag().hashCode());
		result = prime * result + ((getEfBuyerFlag() == null) ? 0 : getEfBuyerFlag().hashCode());
		result = prime * result + ((getIfSellerFlag() == null) ? 0 : getIfSellerFlag().hashCode());
		result = prime * result + ((getIsBank() == null) ? 0 : getIsBank().hashCode());
		result = prime * result + ((getFciCode() == null) ? 0 : getFciCode().hashCode());
		result = prime * result + ((getIsIntl() == null) ? 0 : getIsIntl().hashCode());
		result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
		result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
		result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
		result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
		result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
		result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
		return result;
	}
}
package com.huateng.scf.bas.crm.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.huateng.scf.bas.common.model.ScfBaseModel;

public class BCrmBaseInfoAndEntInfo extends ScfBaseModel implements Serializable {
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
	 * VARCHAR(10) 必填<br>
	 * 证件类型：01-组织机构代码证、02-营业执照、03-其他企业证件、04-社会信用代码证
	 */
	private String idtype;

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

	public synchronized String getBrManagerName() {
		return brManagerName;
	}

	public synchronized void setBrManagerName(String brManagerName) {
		this.brManagerName = brManagerName;
	}

	/**
	 * VARCHAR(50)<br>
	 * 管户员 （客户经理名称）
	 */
	private String brManagerName;
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
	 * VARCHAR(50) 必填<br>
	 * 法定代表人
	 */
	private String legal;

	/**
	 * VARCHAR(6) 必填<br>
	 * 企业类型
	 */
	private String enterpriseType;

	/**
	 * VARCHAR(10)<br>
	 * 国标行业分类
	 */
	private String industryType;

	/**
	 * VARCHAR(2)<br>
	 * 企业规模
	 */
	private String enterpriseScope;

	/**
	 * VARCHAR(800)<br>
	 * 主营业务范围
	 */
	private String mainBussiness;

	/**
	 * VARCHAR(300)<br>
	 * 通讯地址
	 */
	private String contactAddr;

	/**
	 * VARCHAR(300)<br>
	 * 注册地址
	 */
	private String regAddr;

	/**
	 * CHAR(6)<br>
	 * 邮政编码
	 */
	private String postCode;

	/**
	 * VARCHAR(80)<br>
	 * 联系人
	 */
	private String contactName;

	/**
	 * VARCHAR(30)<br>
	 * 联系电话
	 */
	private String contactTel;

	/**
	 * VARCHAR(30)<br>
	 * 传真号码
	 */
	private String fax;

	/**
	 * VARCHAR(80)<br>
	 * 信用评级(DATA_DIC.4)
	 */
	private String creditLevel;
    private BigDecimal creditScr;

    private String creditDate;
	/**
	 * CHAR(8)<br>
	 * 本行评估日期
	 */
	private String evaluateDate;
    /**
     * CHAR(1)<br>
     * 下游/经销商
     */
    private String downFlag;

    /**
     * CHAR(1)<br>
     * 上游/供应商
     */
    private String upFlag;
    /**
     * VARCHAR(100)<br>
     * 省
     */
    private String province;
    
	/**
	 * VARCHAR(80)<br>
	 * 基本帐户开户行
	 */
	private String baseActBank;

	/**
	 * VARCHAR(50)<br>
	 * 基本帐户帐号
	 */
	private String baseActno;

	/**
	 * VARCHAR(20)<br>
	 * 本行开户行
	 */
	private String actBrcode;

	/**
	 * VARCHAR(50)<br>
	 * 本行开户账号
	 */
	private String actno;

	/**
	 * VARCHAR(500)<br>
	 * 备注
	 */
	private String description;

	/**
	 * VARCHAR(100)<br>
	 * 客户特征
	 */
	private String custType;

	/**
	 * DECIMAL(16,2)<br>
	 * 注册资本
	 */
	private BigDecimal regCapital;

	/**
	 * DECIMAL(16,2)<br>
	 * 实收资本
	 */
	private BigDecimal capital;

	/**
	 * CHAR(3)<br>
	 * 币种
	 */
	private String curcd;

	/**
	 * CHAR(2)<br>
	 * 客户角色
	 */
	private String custRole;

	/**
	 * CHAR(1)<br>
	 * 业务边界认定(DATA_DIC.11251)
	 */
	private String businessScope;

	/**
	 * CHAR(1)<br>
	 * 客户所属行业属性(DATA_DIC.11252)
	 */
	private String industryOutlook;

	/**
	 * DECIMAL(22)<br>
	 * 员工人数
	 */
	private BigDecimal employeeNumber;

	/**
	 * DECIMAL(16,2)<br>
	 * 年营业额
	 */
	private BigDecimal turnover;

	/**
	 * DECIMAL(22)<br>
	 * 开业时间（年）
	 */
	private BigDecimal businessDuration;

	/**
	 * DECIMAL(22)<br>
	 * 本行开户时间（年）
	 */
	private BigDecimal accountDuration;

	/**
	 * VARCHAR(100)<br>
	 * 省份、直辖市、自治区
	 */
	private String area;
	/**
	 * VARCHAR(100)<br>
	 * 省份、直辖市、自治区
	 */
	private String areaName;
	private String provinceName;
	private String cityName;
	/**
	 * CHAR(1)<br>
	 * 区域边界认定（0：辖区内/1：辖区外）
	 */
	private String boundary;

	/**
	 * VARCHAR(2)<br>
	 * 客户等级(DATA_DIC.11255)
	 */
	private String custLevel;

	/**
	 * VARCHAR(2)<br>
	 * 厂商等级：00:全国性核心厂商，01：区域性核心厂商,02：单笔单批
	 */
	private String coreLevel;

	/**
	 * VARCHAR(10)<br>
	 * 供应链所处地位
	 */
	private String supplyPosition;

	/**
	 * VARCHAR(10)<br>
	 * 是否上市公司
	 */
	private String isMarketCorp;

	/**
	 * TIMESTAMP(11,6)<br>
	 * 企业成立时间
	 */
	private String establishDate;

	/**
	 * CHAR(2)<br>
	 * 国家代码
	 */
	private String counCode;

	/**
	 * VARCHAR(100)<br>
	 * 注册机构
	 */
	private String regOrg;

	/**
	 * VARCHAR(100)<br>
	 * 街道
	 */
	private String street;

	/**
	 * VARCHAR(100)<br>
	 * 城市
	 */
	private String city;

	/**
	 * VARCHAR(200)<br>
	 * 通讯地址(英文)
	 */
	private String enAddr;

	/**
	 * VARCHAR(80)<br>
	 * 联系人英文
	 */
	private String contactEnName;

	/**
	 * VARCHAR(200)<br>
	 * 汇款路径
	 */
	private String payRoute;

	/**
	 * VARCHAR(50)<br>
	 * 提供的服务
	 */
	private String services;

	/**
	 * VARCHAR(200)<br>
	 * 附件： (保理商介绍信、转让条款)
	 */
	private String appendix;

	/**
	 * VARCHAR(50)<br>
	 * 电子邮件
	 */
	private String email;

	/**
	 * VARCHAR(80)<br>
	 * 核心厂商网络名称
	 */
	private String coreNetworkName;
	/**
	 * VARCHAR(10)<br>
	 * 国标行业分类名称
	 */
	private String industryTypeName;
	 /**
     * VARCHAR(50)<br>
     * 国税编号
     */
    private String nationalTax;

    /**
     * VARCHAR(50)<br>
     * 地税编号
     */
    private String landTax;

    /**
     * CHAR(1)<br>
     * 是否自有房产，0：否，1：是
     */
    private String ownHouse;
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public synchronized String getCustcd() {
		return custcd;
	}

	public synchronized void setCustcd(String custcd) {
		this.custcd = custcd;
	}

	public synchronized String getCustno() {
		return custno;
	}

	public synchronized void setCustno(String custno) {
		this.custno = custno;
	}

	public synchronized String getIdtype() {
		return idtype;
	}

	public synchronized void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	public synchronized String getIdno() {
		return idno;
	}

	public synchronized void setIdno(String idno) {
		this.idno = idno;
	}

	public synchronized String getCname() {
		return cname;
	}

	public synchronized void setCname(String cname) {
		this.cname = cname;
	}

	public synchronized String getEname() {
		return ename;
	}

	public synchronized void setEname(String ename) {
		this.ename = ename;
	}

	public synchronized String getAliasName() {
		return aliasName;
	}

	public synchronized void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public synchronized String getOrgCode() {
		return orgCode;
	}

	public synchronized void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public synchronized String getSocCreditNo() {
		return socCreditNo;
	}

	public synchronized void setSocCreditNo(String socCreditNo) {
		this.socCreditNo = socCreditNo;
	}

	public synchronized String getLicenseNo() {
		return licenseNo;
	}

	public synchronized void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public synchronized String getLicenseDate() {
		return licenseDate;
	}

	public synchronized void setLicenseDate(String licenseDate) {
		this.licenseDate = licenseDate;
	}

	public synchronized String getOpenDate() {
		return openDate;
	}

	public synchronized void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public synchronized String getCoreOpenDate() {
		return coreOpenDate;
	}

	public synchronized void setCoreOpenDate(String coreOpenDate) {
		this.coreOpenDate = coreOpenDate;
	}

	public synchronized String getCustStatus() {
		return custStatus;
	}

	public synchronized void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}

	public synchronized String getMgrno() {
		return mgrno;
	}

	public synchronized void setMgrno(String mgrno) {
		this.mgrno = mgrno;
	}

	public synchronized String getCoreFlag() {
		return coreFlag;
	}

	public synchronized void setCoreFlag(String coreFlag) {
		this.coreFlag = coreFlag;
	}

	public synchronized String getMoniFlag() {
		return moniFlag;
	}

	public synchronized void setMoniFlag(String moniFlag) {
		this.moniFlag = moniFlag;
	}

	public synchronized String getFuturesFlag() {
		return futuresFlag;
	}

	public synchronized void setFuturesFlag(String futuresFlag) {
		this.futuresFlag = futuresFlag;
	}

	public synchronized String getFlcFlag() {
		return flcFlag;
	}

	public synchronized void setFlcFlag(String flcFlag) {
		this.flcFlag = flcFlag;
	}

	public synchronized String getCreateDate() {
		return createDate;
	}

	public synchronized void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public synchronized String getCreditFlag() {
		return creditFlag;
	}

	public synchronized void setCreditFlag(String creditFlag) {
		this.creditFlag = creditFlag;
	}

	public synchronized String getBlackFlag() {
		return blackFlag;
	}

	public synchronized void setBlackFlag(String blackFlag) {
		this.blackFlag = blackFlag;
	}

	public synchronized String getInsureFlag() {
		return insureFlag;
	}

	public synchronized void setInsureFlag(String insureFlag) {
		this.insureFlag = insureFlag;
	}

	public synchronized String getFactorFlag() {
		return factorFlag;
	}

	public synchronized void setFactorFlag(String factorFlag) {
		this.factorFlag = factorFlag;
	}

	public synchronized String getCcmsCustcd() {
		return ccmsCustcd;
	}

	public synchronized void setCcmsCustcd(String ccmsCustcd) {
		this.ccmsCustcd = ccmsCustcd;
	}

	public synchronized String getImportantFlag() {
		return importantFlag;
	}

	public synchronized void setImportantFlag(String importantFlag) {
		this.importantFlag = importantFlag;
	}

	public synchronized String getCommercialFalg() {
		return commercialFalg;
	}

	public synchronized void setCommercialFalg(String commercialFalg) {
		this.commercialFalg = commercialFalg;
	}

	public synchronized String getOverseasFlag() {
		return overseasFlag;
	}

	public synchronized void setOverseasFlag(String overseasFlag) {
		this.overseasFlag = overseasFlag;
	}

	public synchronized String getBanksCustFlag() {
		return banksCustFlag;
	}

	public synchronized void setBanksCustFlag(String banksCustFlag) {
		this.banksCustFlag = banksCustFlag;
	}

	public synchronized String getEfBuyerFlag() {
		return efBuyerFlag;
	}

	public synchronized void setEfBuyerFlag(String efBuyerFlag) {
		this.efBuyerFlag = efBuyerFlag;
	}

	public synchronized String getIfSellerFlag() {
		return ifSellerFlag;
	}

	public synchronized void setIfSellerFlag(String ifSellerFlag) {
		this.ifSellerFlag = ifSellerFlag;
	}

	public synchronized String getIsBank() {
		return isBank;
	}

	public synchronized void setIsBank(String isBank) {
		this.isBank = isBank;
	}

	public synchronized String getFciCode() {
		return fciCode;
	}

	public synchronized void setFciCode(String fciCode) {
		this.fciCode = fciCode;
	}

	public synchronized String getIsIntl() {
		return isIntl;
	}

	public synchronized void setIsIntl(String isIntl) {
		this.isIntl = isIntl;
	}

	public synchronized String getTlrcd() {
		return tlrcd;
	}

	public synchronized void setTlrcd(String tlrcd) {
		this.tlrcd = tlrcd;
	}

	public synchronized Date getCrtTime() {
		return crtTime;
	}

	public synchronized void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public synchronized String getBrcode() {
		return brcode;
	}

	public synchronized void setBrcode(String brcode) {
		this.brcode = brcode;
	}

	public synchronized String getLastUpdTlrcd() {
		return lastUpdTlrcd;
	}

	public synchronized void setLastUpdTlrcd(String lastUpdTlrcd) {
		this.lastUpdTlrcd = lastUpdTlrcd;
	}

	public synchronized Date getLastUpdTime() {
		return lastUpdTime;
	}

	public synchronized void setLastUpdTime(Date lastUpdTime) {
		this.lastUpdTime = lastUpdTime;
	}

	public synchronized String getLastUpdBrcode() {
		return lastUpdBrcode;
	}

	public synchronized void setLastUpdBrcode(String lastUpdBrcode) {
		this.lastUpdBrcode = lastUpdBrcode;
	}

	public synchronized String getTlrName() {
		return tlrName;
	}

	public synchronized void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}

	public synchronized String getBrName() {
		return brName;
	}

	public synchronized void setBrName(String brName) {
		this.brName = brName;
	}

	public synchronized String getLastUpdTlrName() {
		return lastUpdTlrName;
	}

	public synchronized void setLastUpdTlrName(String lastUpdTlrName) {
		this.lastUpdTlrName = lastUpdTlrName;
	}

	public synchronized String getLastUpdBrName() {
		return lastUpdBrName;
	}

	public synchronized void setLastUpdBrName(String lastUpdBrName) {
		this.lastUpdBrName = lastUpdBrName;
	}

	public synchronized String getLegal() {
		return legal;
	}

	public synchronized void setLegal(String legal) {
		this.legal = legal;
	}

	public synchronized String getEnterpriseType() {
		return enterpriseType;
	}

	public synchronized void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}

	public synchronized String getIndustryType() {
		return industryType;
	}

	public synchronized void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public synchronized String getEnterpriseScope() {
		return enterpriseScope;
	}

	public synchronized void setEnterpriseScope(String enterpriseScope) {
		this.enterpriseScope = enterpriseScope;
	}

	public synchronized String getMainBussiness() {
		return mainBussiness;
	}

	public synchronized void setMainBussiness(String mainBussiness) {
		this.mainBussiness = mainBussiness;
	}

	public synchronized String getContactAddr() {
		return contactAddr;
	}

	public synchronized void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}

	public synchronized String getRegAddr() {
		return regAddr;
	}

	public synchronized void setRegAddr(String regAddr) {
		this.regAddr = regAddr;
	}

	public synchronized String getPostCode() {
		return postCode;
	}

	public synchronized void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public synchronized String getContactName() {
		return contactName;
	}

	public synchronized void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public synchronized String getContactTel() {
		return contactTel;
	}

	public synchronized void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public synchronized String getFax() {
		return fax;
	}

	public synchronized void setFax(String fax) {
		this.fax = fax;
	}

	public synchronized String getCreditLevel() {
		return creditLevel;
	}

	public synchronized void setCreditLevel(String creditLevel) {
		this.creditLevel = creditLevel;
	}

	public synchronized String getEvaluateDate() {
		return evaluateDate;
	}

	public synchronized void setEvaluateDate(String evaluateDate) {
		this.evaluateDate = evaluateDate;
	}

	public synchronized String getBaseActBank() {
		return baseActBank;
	}

	public synchronized void setBaseActBank(String baseActBank) {
		this.baseActBank = baseActBank;
	}

	public synchronized String getBaseActno() {
		return baseActno;
	}

	public synchronized void setBaseActno(String baseActno) {
		this.baseActno = baseActno;
	}

	public synchronized String getActBrcode() {
		return actBrcode;
	}

	public synchronized void setActBrcode(String actBrcode) {
		this.actBrcode = actBrcode;
	}

	public synchronized String getActno() {
		return actno;
	}

	public synchronized void setActno(String actno) {
		this.actno = actno;
	}

	public synchronized String getDescription() {
		return description;
	}

	public synchronized void setDescription(String description) {
		this.description = description;
	}

	public synchronized String getCustType() {
		return custType;
	}

	public synchronized void setCustType(String custType) {
		this.custType = custType;
	}

	public synchronized BigDecimal getRegCapital() {
		return regCapital;
	}

	public synchronized void setRegCapital(BigDecimal regCapital) {
		this.regCapital = regCapital;
	}

	public synchronized BigDecimal getCapital() {
		return capital;
	}

	public synchronized void setCapital(BigDecimal capital) {
		this.capital = capital;
	}

	public synchronized String getCurcd() {
		return curcd;
	}

	public synchronized void setCurcd(String curcd) {
		this.curcd = curcd;
	}

	public synchronized String getCustRole() {
		return custRole;
	}

	public synchronized void setCustRole(String custRole) {
		this.custRole = custRole;
	}

	public synchronized String getBusinessScope() {
		return businessScope;
	}

	public synchronized void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public synchronized String getIndustryOutlook() {
		return industryOutlook;
	}

	public synchronized void setIndustryOutlook(String industryOutlook) {
		this.industryOutlook = industryOutlook;
	}

	public synchronized BigDecimal getEmployeeNumber() {
		return employeeNumber;
	}

	public synchronized void setEmployeeNumber(BigDecimal employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public synchronized BigDecimal getTurnover() {
		return turnover;
	}

	public synchronized void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}

	public synchronized BigDecimal getBusinessDuration() {
		return businessDuration;
	}

	public synchronized void setBusinessDuration(BigDecimal businessDuration) {
		this.businessDuration = businessDuration;
	}

	public synchronized BigDecimal getAccountDuration() {
		return accountDuration;
	}

	public synchronized void setAccountDuration(BigDecimal accountDuration) {
		this.accountDuration = accountDuration;
	}

	public synchronized String getArea() {
		return area;
	}

	public synchronized void setArea(String area) {
		this.area = area;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public synchronized String getBoundary() {
		return boundary;
	}

	public synchronized void setBoundary(String boundary) {
		this.boundary = boundary;
	}

	public synchronized String getCustLevel() {
		return custLevel;
	}

	public synchronized void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public synchronized String getCoreLevel() {
		return coreLevel;
	}

	public synchronized void setCoreLevel(String coreLevel) {
		this.coreLevel = coreLevel;
	}

	public synchronized String getSupplyPosition() {
		return supplyPosition;
	}

	public synchronized void setSupplyPosition(String supplyPosition) {
		this.supplyPosition = supplyPosition;
	}

	public synchronized String getIsMarketCorp() {
		return isMarketCorp;
	}

	public synchronized void setIsMarketCorp(String isMarketCorp) {
		this.isMarketCorp = isMarketCorp;
	}

	public synchronized String getEstablishDate() {
		return establishDate;
	}

	public synchronized void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
	}

	public synchronized String getCounCode() {
		return counCode;
	}

	public synchronized void setCounCode(String counCode) {
		this.counCode = counCode;
	}

	public synchronized String getRegOrg() {
		return regOrg;
	}

	public synchronized void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}

	public synchronized String getStreet() {
		return street;
	}

	public synchronized void setStreet(String street) {
		this.street = street;
	}

	public synchronized String getCity() {
		return city;
	}

	public synchronized void setCity(String city) {
		this.city = city;
	}

	public synchronized String getEnAddr() {
		return enAddr;
	}

	public synchronized void setEnAddr(String enAddr) {
		this.enAddr = enAddr;
	}

	public synchronized String getContactEnName() {
		return contactEnName;
	}

	public synchronized void setContactEnName(String contactEnName) {
		this.contactEnName = contactEnName;
	}

	public synchronized String getPayRoute() {
		return payRoute;
	}

	public synchronized void setPayRoute(String payRoute) {
		this.payRoute = payRoute;
	}

	public synchronized String getServices() {
		return services;
	}

	public synchronized void setServices(String services) {
		this.services = services;
	}

	public synchronized String getAppendix() {
		return appendix;
	}

	public synchronized void setAppendix(String appendix) {
		this.appendix = appendix;
	}

	public synchronized String getEmail() {
		return email;
	}

	public synchronized void setEmail(String email) {
		this.email = email;
	}

	public synchronized String getCoreNetworkName() {
		return coreNetworkName;
	}

	public synchronized void setCoreNetworkName(String coreNetworkName) {
		this.coreNetworkName = coreNetworkName;
	}

	public synchronized String getIndustryTypeName() {
		return industryTypeName;
	}

	public synchronized void setIndustryTypeName(String industryTypeName) {
		this.industryTypeName = industryTypeName;
	}
	   /**
     * VARCHAR(50)<br>
     * 获得 国税编号
     */
    public String getNationalTax() {
        return nationalTax;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 国税编号
     */
    public void setNationalTax(String nationalTax) {
        this.nationalTax = nationalTax == null ? null : nationalTax.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 地税编号
     */
    public String getLandTax() {
        return landTax;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 地税编号
     */
    public void setLandTax(String landTax) {
        this.landTax = landTax == null ? null : landTax.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否自有房产，0：否，1：是
     */
    public String getOwnHouse() {
        return ownHouse;
    }

    public BigDecimal getCreditScr() {
		return creditScr;
	}

	public void setCreditScr(BigDecimal creditScr) {
		this.creditScr = creditScr;
	}

	public String getCreditDate() {
		return creditDate;
	}

	public void setCreditDate(String creditDate) {
		this.creditDate = creditDate;
	}

	public String getDownFlag() {
		return downFlag;
	}

	public void setDownFlag(String downFlag) {
		this.downFlag = downFlag;
	}

	public String getUpFlag() {
		return upFlag;
	}

	public void setUpFlag(String upFlag) {
		this.upFlag = upFlag;
	}

	/**
     * CHAR(1)<br>
     * 设置 是否自有房产，0：否，1：是
     */
    public void setOwnHouse(String ownHouse) {
        this.ownHouse = ownHouse == null ? null : ownHouse.trim();
    }
	@Override
	public String toString() {
		return "BCrmBaseInfoAndEntInfo [custcd=" + custcd + ", custno=" + custno + ", idtype=" + idtype + ", idno="
				+ idno + ", cname=" + cname + ", ename=" + ename + ", aliasName=" + aliasName + ", orgCode=" + orgCode
				+ ", socCreditNo=" + socCreditNo + ", licenseNo=" + licenseNo + ", licenseDate=" + licenseDate
				+ ", openDate=" + openDate + ", coreOpenDate=" + coreOpenDate + ", custStatus=" + custStatus
				+ ", mgrno=" + mgrno + ", coreFlag=" + coreFlag + ", moniFlag=" + moniFlag + ", futuresFlag="
				+ futuresFlag + ", flcFlag=" + flcFlag + ", createDate=" + createDate + ", creditFlag=" + creditFlag
				+ ", blackFlag=" + blackFlag + ", insureFlag=" + insureFlag + ", factorFlag=" + factorFlag
				+ ", ccmsCustcd=" + ccmsCustcd + ", importantFlag=" + importantFlag + ", commercialFalg="
				+ commercialFalg + ", overseasFlag=" + overseasFlag + ", banksCustFlag=" + banksCustFlag
				+ ", efBuyerFlag=" + efBuyerFlag + ", ifSellerFlag=" + ifSellerFlag + ", isBank=" + isBank
				+ ", fciCode=" + fciCode + ", isIntl=" + isIntl + ", tlrcd=" + tlrcd + ", crtTime=" + crtTime
				+ ", brcode=" + brcode + ", lastUpdTlrcd=" + lastUpdTlrcd + ", lastUpdTime=" + lastUpdTime
				+ ", lastUpdBrcode=" + lastUpdBrcode + ", tlrName=" + tlrName + ", brName=" + brName
				+ ", lastUpdTlrName=" + lastUpdTlrName + ", lastUpdBrName=" + lastUpdBrName + ", legal=" + legal
				+ ", enterpriseType=" + enterpriseType + ", industryType=" + industryType + ", enterpriseScope="
				+ enterpriseScope + ", mainBussiness=" + mainBussiness + ", contactAddr=" + contactAddr + ", regAddr="
				+ regAddr + ", postCode=" + postCode + ", contactName=" + contactName + ", contactTel=" + contactTel
				+ ", fax=" + fax + ", creditLevel=" + creditLevel + ", evaluateDate=" + evaluateDate + ", baseActBank="
				+ baseActBank + ", baseActno=" + baseActno + ", actBrcode=" + actBrcode + ", actno=" + actno
				+ ", description=" + description + ", custType=" + custType + ", regCapital=" + regCapital
				+ ", capital=" + capital + ", curcd=" + curcd + ", custRole=" + custRole + ", businessScope="
				+ businessScope + ", industryOutlook=" + industryOutlook + ", employeeNumber=" + employeeNumber
				+ ", turnover=" + turnover + ", businessDuration=" + businessDuration + ", accountDuration="
				+ accountDuration + ", area=" + area + ", boundary=" + boundary + ", custLevel=" + custLevel
				+ ", coreLevel=" + coreLevel + ", supplyPosition=" + supplyPosition + ", isMarketCorp=" + isMarketCorp
				+ ", establishDate=" + establishDate + ", counCode=" + counCode + ", regOrg=" + regOrg + ", street="
				+ street + ", city=" + city + ", enAddr=" + enAddr + ", contactEnName=" + contactEnName + ", payRoute="
				+ payRoute + ", services=" + services + ", appendix=" + appendix + ", email=" + email
				+ ", coreNetworkName=" + coreNetworkName + ", industryTypeName=" + industryTypeName + "]";
	}

}
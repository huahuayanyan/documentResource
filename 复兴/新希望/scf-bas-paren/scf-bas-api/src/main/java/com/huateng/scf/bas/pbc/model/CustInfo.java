package com.huateng.scf.bas.pbc.model;

import java.math.BigDecimal;
import java.util.Date;

public class CustInfo {
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

	/**
	 * CHAR(8)<br>
	 * 本行评估日期
	 */
	private String evaluateDate;

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
	 * CHAR(8)<br>
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
	
	private String areaName; //地区名称
	public String getCustcd() {
		return custcd;
	}
	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}
	public String getCustno() {
		return custno;
	}
	public void setCustno(String custno) {
		this.custno = custno;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getIdtype() {
		return idtype;
	}
	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}
	public String getIdno() {
		return idno;
	}
	public void setIdno(String idno) {
		this.idno = idno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getSocCreditNo() {
		return socCreditNo;
	}
	public void setSocCreditNo(String socCreditNo) {
		this.socCreditNo = socCreditNo;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getLicenseDate() {
		return licenseDate;
	}
	public void setLicenseDate(String licenseDate) {
		this.licenseDate = licenseDate;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public String getCoreOpenDate() {
		return coreOpenDate;
	}
	public void setCoreOpenDate(String coreOpenDate) {
		this.coreOpenDate = coreOpenDate;
	}
	public String getCustStatus() {
		return custStatus;
	}
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
	public String getMgrno() {
		return mgrno;
	}
	public void setMgrno(String mgrno) {
		this.mgrno = mgrno;
	}
	public String getCoreFlag() {
		return coreFlag;
	}
	public void setCoreFlag(String coreFlag) {
		this.coreFlag = coreFlag;
	}
	public String getMoniFlag() {
		return moniFlag;
	}
	public void setMoniFlag(String moniFlag) {
		this.moniFlag = moniFlag;
	}
	public String getFuturesFlag() {
		return futuresFlag;
	}
	public void setFuturesFlag(String futuresFlag) {
		this.futuresFlag = futuresFlag;
	}
	public String getFlcFlag() {
		return flcFlag;
	}
	public void setFlcFlag(String flcFlag) {
		this.flcFlag = flcFlag;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreditFlag() {
		return creditFlag;
	}
	public void setCreditFlag(String creditFlag) {
		this.creditFlag = creditFlag;
	}
	public String getBlackFlag() {
		return blackFlag;
	}
	public void setBlackFlag(String blackFlag) {
		this.blackFlag = blackFlag;
	}
	public String getInsureFlag() {
		return insureFlag;
	}
	public void setInsureFlag(String insureFlag) {
		this.insureFlag = insureFlag;
	}
	public String getFactorFlag() {
		return factorFlag;
	}
	public void setFactorFlag(String factorFlag) {
		this.factorFlag = factorFlag;
	}
	public String getCcmsCustcd() {
		return ccmsCustcd;
	}
	public void setCcmsCustcd(String ccmsCustcd) {
		this.ccmsCustcd = ccmsCustcd;
	}
	public String getImportantFlag() {
		return importantFlag;
	}
	public void setImportantFlag(String importantFlag) {
		this.importantFlag = importantFlag;
	}
	public String getCommercialFalg() {
		return commercialFalg;
	}
	public void setCommercialFalg(String commercialFalg) {
		this.commercialFalg = commercialFalg;
	}
	public String getOverseasFlag() {
		return overseasFlag;
	}
	public void setOverseasFlag(String overseasFlag) {
		this.overseasFlag = overseasFlag;
	}
	public String getBanksCustFlag() {
		return banksCustFlag;
	}
	public void setBanksCustFlag(String banksCustFlag) {
		this.banksCustFlag = banksCustFlag;
	}
	public String getEfBuyerFlag() {
		return efBuyerFlag;
	}
	public void setEfBuyerFlag(String efBuyerFlag) {
		this.efBuyerFlag = efBuyerFlag;
	}
	public String getIfSellerFlag() {
		return ifSellerFlag;
	}
	public void setIfSellerFlag(String ifSellerFlag) {
		this.ifSellerFlag = ifSellerFlag;
	}
	public String getIsBank() {
		return isBank;
	}
	public void setIsBank(String isBank) {
		this.isBank = isBank;
	}
	public String getFciCode() {
		return fciCode;
	}
	public void setFciCode(String fciCode) {
		this.fciCode = fciCode;
	}
	public String getIsIntl() {
		return isIntl;
	}
	public void setIsIntl(String isIntl) {
		this.isIntl = isIntl;
	}
	public String getTlrcd() {
		return tlrcd;
	}
	public void setTlrcd(String tlrcd) {
		this.tlrcd = tlrcd;
	}
	public Date getCrtTime() {
		return crtTime;
	}
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}
	public String getBrcode() {
		return brcode;
	}
	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}
	public String getLastUpdTlrcd() {
		return lastUpdTlrcd;
	}
	public void setLastUpdTlrcd(String lastUpdTlrcd) {
		this.lastUpdTlrcd = lastUpdTlrcd;
	}
	public Date getLastUpdTime() {
		return lastUpdTime;
	}
	public void setLastUpdTime(Date lastUpdTime) {
		this.lastUpdTime = lastUpdTime;
	}
	public String getLastUpdBrcode() {
		return lastUpdBrcode;
	}
	public void setLastUpdBrcode(String lastUpdBrcode) {
		this.lastUpdBrcode = lastUpdBrcode;
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
	public String getBrManagerName() {
		return brManagerName;
	}
	public void setBrManagerName(String brManagerName) {
		this.brManagerName = brManagerName;
	}
	public String getLegal() {
		return legal;
	}
	public void setLegal(String legal) {
		this.legal = legal;
	}
	public String getEnterpriseType() {
		return enterpriseType;
	}
	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	public String getIndustryType() {
		return industryType;
	}
	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}
	public String getEnterpriseScope() {
		return enterpriseScope;
	}
	public void setEnterpriseScope(String enterpriseScope) {
		this.enterpriseScope = enterpriseScope;
	}
	public String getMainBussiness() {
		return mainBussiness;
	}
	public void setMainBussiness(String mainBussiness) {
		this.mainBussiness = mainBussiness;
	}
	public String getContactAddr() {
		return contactAddr;
	}
	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}
	public String getRegAddr() {
		return regAddr;
	}
	public void setRegAddr(String regAddr) {
		this.regAddr = regAddr;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getCreditLevel() {
		return creditLevel;
	}
	public void setCreditLevel(String creditLevel) {
		this.creditLevel = creditLevel;
	}
	public String getEvaluateDate() {
		return evaluateDate;
	}
	public void setEvaluateDate(String evaluateDate) {
		this.evaluateDate = evaluateDate;
	}
	public String getBaseActBank() {
		return baseActBank;
	}
	public void setBaseActBank(String baseActBank) {
		this.baseActBank = baseActBank;
	}
	public String getBaseActno() {
		return baseActno;
	}
	public void setBaseActno(String baseActno) {
		this.baseActno = baseActno;
	}
	public String getActBrcode() {
		return actBrcode;
	}
	public void setActBrcode(String actBrcode) {
		this.actBrcode = actBrcode;
	}
	public String getActno() {
		return actno;
	}
	public void setActno(String actno) {
		this.actno = actno;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getRegCapital() {
		return regCapital;
	}
	public void setRegCapital(BigDecimal regCapital) {
		this.regCapital = regCapital;
	}
	public BigDecimal getCapital() {
		return capital;
	}
	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}
	public String getCurcd() {
		return curcd;
	}
	public void setCurcd(String curcd) {
		this.curcd = curcd;
	}
	public String getCustRole() {
		return custRole;
	}
	public void setCustRole(String custRole) {
		this.custRole = custRole;
	}
	public String getBusinessScope() {
		return businessScope;
	}
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	public String getIndustryOutlook() {
		return industryOutlook;
	}
	public void setIndustryOutlook(String industryOutlook) {
		this.industryOutlook = industryOutlook;
	}
	public BigDecimal getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(BigDecimal employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public BigDecimal getTurnover() {
		return turnover;
	}
	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}
	public BigDecimal getBusinessDuration() {
		return businessDuration;
	}
	public void setBusinessDuration(BigDecimal businessDuration) {
		this.businessDuration = businessDuration;
	}
	public BigDecimal getAccountDuration() {
		return accountDuration;
	}
	public void setAccountDuration(BigDecimal accountDuration) {
		this.accountDuration = accountDuration;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getBoundary() {
		return boundary;
	}
	public void setBoundary(String boundary) {
		this.boundary = boundary;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCoreLevel() {
		return coreLevel;
	}
	public void setCoreLevel(String coreLevel) {
		this.coreLevel = coreLevel;
	}
	public String getSupplyPosition() {
		return supplyPosition;
	}
	public void setSupplyPosition(String supplyPosition) {
		this.supplyPosition = supplyPosition;
	}
	public String getIsMarketCorp() {
		return isMarketCorp;
	}
	public void setIsMarketCorp(String isMarketCorp) {
		this.isMarketCorp = isMarketCorp;
	}
	public String getEstablishDate() {
		return establishDate;
	}
	public void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
	}
	public String getCounCode() {
		return counCode;
	}
	public void setCounCode(String counCode) {
		this.counCode = counCode;
	}
	public String getRegOrg() {
		return regOrg;
	}
	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEnAddr() {
		return enAddr;
	}
	public void setEnAddr(String enAddr) {
		this.enAddr = enAddr;
	}
	public String getContactEnName() {
		return contactEnName;
	}
	public void setContactEnName(String contactEnName) {
		this.contactEnName = contactEnName;
	}
	public String getPayRoute() {
		return payRoute;
	}
	public void setPayRoute(String payRoute) {
		this.payRoute = payRoute;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getAppendix() {
		return appendix;
	}
	public void setAppendix(String appendix) {
		this.appendix = appendix;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCoreNetworkName() {
		return coreNetworkName;
	}
	public void setCoreNetworkName(String coreNetworkName) {
		this.coreNetworkName = coreNetworkName;
	}
	public String getIndustryTypeName() {
		return industryTypeName;
	}
	public void setIndustryTypeName(String industryTypeName) {
		this.industryTypeName = industryTypeName;
	}
	@Override
	public String toString() {
		return "CustInfo [custcd=" + custcd + ", custno=" + custno + ", custType=" + custType + ", idtype=" + idtype
				+ ", idno=" + idno + ", cname=" + cname + ", ename=" + ename + ", aliasName=" + aliasName + ", orgCode="
				+ orgCode + ", socCreditNo=" + socCreditNo + ", licenseNo=" + licenseNo + ", licenseDate=" + licenseDate
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
				+ ", lastUpdTlrName=" + lastUpdTlrName + ", lastUpdBrName=" + lastUpdBrName + ", brManagerName="
				+ brManagerName + ", legal=" + legal + ", enterpriseType=" + enterpriseType + ", industryType="
				+ industryType + ", enterpriseScope=" + enterpriseScope + ", mainBussiness=" + mainBussiness
				+ ", contactAddr=" + contactAddr + ", regAddr=" + regAddr + ", postCode=" + postCode + ", contactName="
				+ contactName + ", contactTel=" + contactTel + ", fax=" + fax + ", creditLevel=" + creditLevel
				+ ", evaluateDate=" + evaluateDate + ", baseActBank=" + baseActBank + ", baseActno=" + baseActno
				+ ", actBrcode=" + actBrcode + ", actno=" + actno + ", description=" + description + ", regCapital="
				+ regCapital + ", capital=" + capital + ", curcd=" + curcd + ", custRole=" + custRole
				+ ", businessScope=" + businessScope + ", industryOutlook=" + industryOutlook + ", employeeNumber="
				+ employeeNumber + ", turnover=" + turnover + ", businessDuration=" + businessDuration
				+ ", accountDuration=" + accountDuration + ", area=" + area + ", boundary=" + boundary + ", custLevel="
				+ custLevel + ", coreLevel=" + coreLevel + ", supplyPosition=" + supplyPosition + ", isMarketCorp="
				+ isMarketCorp + ", establishDate=" + establishDate + ", counCode=" + counCode + ", regOrg=" + regOrg
				+ ", street=" + street + ", city=" + city + ", enAddr=" + enAddr + ", contactEnName=" + contactEnName
				+ ", payRoute=" + payRoute + ", services=" + services + ", appendix=" + appendix + ", email=" + email
				+ ", coreNetworkName=" + coreNetworkName + ", industryTypeName=" + industryTypeName + ", areaName =" 
				+areaName +"]";
	}
	/**
	 * @return the areaName
	 */
	public String getAreaName() {
		return areaName;
	}
	/**
	 * @param areaName the areaName to set
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
}

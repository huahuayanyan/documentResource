package com.huateng.scf.bas.crm.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BCrmEntInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(15) 必填<br>
	 * 客户号
	 */
	private String custcd;

	/**
	 * VARCHAR(20) 必填<br>
	 * 组织机构代码
	 */
	private String orgCode;

	/**
	 * VARCHAR(50) 必填<br>
	 * 法定代表人
	 */
	private String legal;

	/**
	 * VARCHAR(100)<br>
	 * 客户英文名
	 */
	private String ename;

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
	 * 省份、直辖市、自治区名称
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
    
    private BigDecimal creditScr;

    private String creditDate;
    
    private String creditId;
    
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
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

   	public String getCreditId() {
   		return creditId;
   	}

   	public void setCreditId(String creditId) {
   		this.creditId = creditId;
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

	public synchronized String getIndustryTypeName() {
		return industryTypeName;
	}

	public synchronized void setIndustryTypeName(String industryTypeName) {
		this.industryTypeName = industryTypeName;
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
	 * VARCHAR(20) 必填<br>
	 * 获得 组织机构代码
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * VARCHAR(20) 必填<br>
	 * 设置 组织机构代码
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode == null ? null : orgCode.trim();
	}

	/**
	 * VARCHAR(50) 必填<br>
	 * 获得 法定代表人
	 */
	public String getLegal() {
		return legal;
	}

	/**
	 * VARCHAR(50) 必填<br>
	 * 设置 法定代表人
	 */
	public void setLegal(String legal) {
		this.legal = legal == null ? null : legal.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 客户英文名
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 客户英文名
	 */
	public void setEname(String ename) {
		this.ename = ename == null ? null : ename.trim();
	}

	/**
	 * VARCHAR(6) 必填<br>
	 * 获得 企业类型
	 */
	public String getEnterpriseType() {
		return enterpriseType;
	}

	/**
	 * VARCHAR(6) 必填<br>
	 * 设置 企业类型
	 */
	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType == null ? null : enterpriseType.trim();
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 国标行业分类
	 */
	public String getIndustryType() {
		return industryType;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 国标行业分类
	 */
	public void setIndustryType(String industryType) {
		this.industryType = industryType == null ? null : industryType.trim();
	}

	/**
	 * VARCHAR(2)<br>
	 * 获得 企业规模
	 */
	public String getEnterpriseScope() {
		return enterpriseScope;
	}

	/**
	 * VARCHAR(2)<br>
	 * 设置 企业规模
	 */
	public void setEnterpriseScope(String enterpriseScope) {
		this.enterpriseScope = enterpriseScope == null ? null : enterpriseScope.trim();
	}

	/**
	 * VARCHAR(800)<br>
	 * 获得 主营业务范围
	 */
	public String getMainBussiness() {
		return mainBussiness;
	}

	/**
	 * VARCHAR(800)<br>
	 * 设置 主营业务范围
	 */
	public void setMainBussiness(String mainBussiness) {
		this.mainBussiness = mainBussiness == null ? null : mainBussiness.trim();
	}

	/**
	 * VARCHAR(300)<br>
	 * 获得 通讯地址
	 */
	public String getContactAddr() {
		return contactAddr;
	}

	/**
	 * VARCHAR(300)<br>
	 * 设置 通讯地址
	 */
	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr == null ? null : contactAddr.trim();
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
	 * CHAR(6)<br>
	 * 获得 邮政编码
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * CHAR(6)<br>
	 * 设置 邮政编码
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode == null ? null : postCode.trim();
	}

	/**
	 * VARCHAR(80)<br>
	 * 获得 联系人
	 */
	public String getContactName() {
		return contactName;
	}

	/**
	 * VARCHAR(80)<br>
	 * 设置 联系人
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName == null ? null : contactName.trim();
	}

	/**
	 * VARCHAR(30)<br>
	 * 获得 联系电话
	 */
	public String getContactTel() {
		return contactTel;
	}

	/**
	 * VARCHAR(30)<br>
	 * 设置 联系电话
	 */
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel == null ? null : contactTel.trim();
	}

	/**
	 * VARCHAR(30)<br>
	 * 获得 传真号码
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * VARCHAR(30)<br>
	 * 设置 传真号码
	 */
	public void setFax(String fax) {
		this.fax = fax == null ? null : fax.trim();
	}

	/**
	 * VARCHAR(80)<br>
	 * 获得 信用评级(DATA_DIC.4)
	 */
	public String getCreditLevel() {
		return creditLevel;
	}

	/**
	 * VARCHAR(80)<br>
	 * 设置 信用评级(DATA_DIC.4)
	 */
	public void setCreditLevel(String creditLevel) {
		this.creditLevel = creditLevel == null ? null : creditLevel.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 本行评估日期
	 */
	public String getEvaluateDate() {
		return evaluateDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 本行评估日期
	 */
	public void setEvaluateDate(String evaluateDate) {
		this.evaluateDate = evaluateDate == null ? null : evaluateDate.trim();
	}

	/**
	 * VARCHAR(80)<br>
	 * 获得 基本帐户开户行
	 */
	public String getBaseActBank() {
		return baseActBank;
	}

	/**
	 * VARCHAR(80)<br>
	 * 设置 基本帐户开户行
	 */
	public void setBaseActBank(String baseActBank) {
		this.baseActBank = baseActBank == null ? null : baseActBank.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 基本帐户帐号
	 */
	public String getBaseActno() {
		return baseActno;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 基本帐户帐号
	 */
	public void setBaseActno(String baseActno) {
		this.baseActno = baseActno == null ? null : baseActno.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 本行开户行
	 */
	public String getActBrcode() {
		return actBrcode;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 本行开户行
	 */
	public void setActBrcode(String actBrcode) {
		this.actBrcode = actBrcode == null ? null : actBrcode.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 本行开户账号
	 */
	public String getActno() {
		return actno;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 本行开户账号
	 */
	public void setActno(String actno) {
		this.actno = actno == null ? null : actno.trim();
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
	 * VARCHAR(100)<br>
	 * 获得 客户特征
	 */
	public String getCustType() {
		return custType;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 客户特征
	 */
	public void setCustType(String custType) {
		this.custType = custType == null ? null : custType.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 注册资本
	 */
	public BigDecimal getRegCapital() {
		return regCapital;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 注册资本
	 */
	public void setRegCapital(BigDecimal regCapital) {
		this.regCapital = regCapital;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 实收资本
	 */
	public BigDecimal getCapital() {
		return capital;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 实收资本
	 */
	public void setCapital(BigDecimal capital) {
		this.capital = capital;
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
	 * CHAR(2)<br>
	 * 获得 客户角色
	 */
	public String getCustRole() {
		return custRole;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 客户角色
	 */
	public void setCustRole(String custRole) {
		this.custRole = custRole == null ? null : custRole.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 业务边界认定(DATA_DIC.11251)
	 */
	public String getBusinessScope() {
		return businessScope;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 业务边界认定(DATA_DIC.11251)
	 */
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope == null ? null : businessScope.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 客户所属行业属性(DATA_DIC.11252)
	 */
	public String getIndustryOutlook() {
		return industryOutlook;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 客户所属行业属性(DATA_DIC.11252)
	 */
	public void setIndustryOutlook(String industryOutlook) {
		this.industryOutlook = industryOutlook == null ? null : industryOutlook.trim();
	}

	/**
	 * DECIMAL(22)<br>
	 * 获得 员工人数
	 */
	public BigDecimal getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * DECIMAL(22)<br>
	 * 设置 员工人数
	 */
	public void setEmployeeNumber(BigDecimal employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 年营业额
	 */
	public BigDecimal getTurnover() {
		return turnover;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 年营业额
	 */
	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}

	/**
	 * DECIMAL(22)<br>
	 * 获得 开业时间（年）
	 */
	public BigDecimal getBusinessDuration() {
		return businessDuration;
	}

	/**
	 * DECIMAL(22)<br>
	 * 设置 开业时间（年）
	 */
	public void setBusinessDuration(BigDecimal businessDuration) {
		this.businessDuration = businessDuration;
	}

	/**
	 * DECIMAL(22)<br>
	 * 获得 本行开户时间（年）
	 */
	public BigDecimal getAccountDuration() {
		return accountDuration;
	}

	/**
	 * DECIMAL(22)<br>
	 * 设置 本行开户时间（年）
	 */
	public void setAccountDuration(BigDecimal accountDuration) {
		this.accountDuration = accountDuration;
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 省份、直辖市、自治区
	 */
	public String getArea() {
		return area;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 省份、直辖市、自治区
	 */
	public void setArea(String area) {
		this.area = area == null ? null : area.trim();
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

	/**
	 * CHAR(1)<br>
	 * 获得 区域边界认定（0：辖区内/1：辖区外）
	 */
	public String getBoundary() {
		return boundary;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 区域边界认定（0：辖区内/1：辖区外）
	 */
	public void setBoundary(String boundary) {
		this.boundary = boundary == null ? null : boundary.trim();
	}

	/**
	 * VARCHAR(2)<br>
	 * 获得 客户等级(DATA_DIC.11255)
	 */
	public String getCustLevel() {
		return custLevel;
	}

	/**
	 * VARCHAR(2)<br>
	 * 设置 客户等级(DATA_DIC.11255)
	 */
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel == null ? null : custLevel.trim();
	}

	/**
	 * VARCHAR(2)<br>
	 * 获得 厂商等级：00:全国性核心厂商，01：区域性核心厂商,02：单笔单批
	 */
	public String getCoreLevel() {
		return coreLevel;
	}

	/**
	 * VARCHAR(2)<br>
	 * 设置 厂商等级：00:全国性核心厂商，01：区域性核心厂商,02：单笔单批
	 */
	public void setCoreLevel(String coreLevel) {
		this.coreLevel = coreLevel == null ? null : coreLevel.trim();
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 供应链所处地位
	 */
	public String getSupplyPosition() {
		return supplyPosition;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 供应链所处地位
	 */
	public void setSupplyPosition(String supplyPosition) {
		this.supplyPosition = supplyPosition == null ? null : supplyPosition.trim();
	}

	/**
	 * VARCHAR(10)<br>
	 * 获得 是否上市公司
	 */
	public String getIsMarketCorp() {
		return isMarketCorp;
	}

	/**
	 * VARCHAR(10)<br>
	 * 设置 是否上市公司
	 */
	public void setIsMarketCorp(String isMarketCorp) {
		this.isMarketCorp = isMarketCorp == null ? null : isMarketCorp.trim();
	}

	/**
	 * TIMESTAMP(11,6)<br>
	 * 获得 企业成立时间
	 */
	public synchronized String getEstablishDate() {
		return establishDate;
	}

	public synchronized void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
	}

	/**
	 * CHAR(2)<br>
	 * 获得 国家代码
	 */
	public String getCounCode() {
		return counCode;
	}

	/**
	 * CHAR(2)<br>
	 * 设置 国家代码
	 */
	public void setCounCode(String counCode) {
		this.counCode = counCode == null ? null : counCode.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 注册机构
	 */
	public String getRegOrg() {
		return regOrg;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 注册机构
	 */
	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg == null ? null : regOrg.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 街道
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 街道
	 */
	public void setStreet(String street) {
		this.street = street == null ? null : street.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 城市
	 */
	public String getCity() {
		return city;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 城市
	 */
	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	/**
	 * VARCHAR(200)<br>
	 * 获得 通讯地址(英文)
	 */
	public String getEnAddr() {
		return enAddr;
	}

	/**
	 * VARCHAR(200)<br>
	 * 设置 通讯地址(英文)
	 */
	public void setEnAddr(String enAddr) {
		this.enAddr = enAddr == null ? null : enAddr.trim();
	}

	/**
	 * VARCHAR(80)<br>
	 * 获得 联系人英文
	 */
	public String getContactEnName() {
		return contactEnName;
	}

	/**
	 * VARCHAR(80)<br>
	 * 设置 联系人英文
	 */
	public void setContactEnName(String contactEnName) {
		this.contactEnName = contactEnName == null ? null : contactEnName.trim();
	}

	/**
	 * VARCHAR(200)<br>
	 * 获得 汇款路径
	 */
	public String getPayRoute() {
		return payRoute;
	}

	/**
	 * VARCHAR(200)<br>
	 * 设置 汇款路径
	 */
	public void setPayRoute(String payRoute) {
		this.payRoute = payRoute == null ? null : payRoute.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 提供的服务
	 */
	public String getServices() {
		return services;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 提供的服务
	 */
	public void setServices(String services) {
		this.services = services == null ? null : services.trim();
	}

	/**
	 * VARCHAR(200)<br>
	 * 获得 附件： (保理商介绍信、转让条款)
	 */
	public String getAppendix() {
		return appendix;
	}

	/**
	 * VARCHAR(200)<br>
	 * 设置 附件： (保理商介绍信、转让条款)
	 */
	public void setAppendix(String appendix) {
		this.appendix = appendix == null ? null : appendix.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 电子邮件
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 电子邮件
	 */
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	/**
	 * VARCHAR(80)<br>
	 * 获得 核心厂商网络名称
	 */
	public String getCoreNetworkName() {
		return coreNetworkName;
	}

	/**
	 * VARCHAR(80)<br>
	 * 设置 核心厂商网络名称
	 */
	public void setCoreNetworkName(String coreNetworkName) {
		this.coreNetworkName = coreNetworkName == null ? null : coreNetworkName.trim();
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

    /**
     * CHAR(1)<br>
     * 设置 是否自有房产，0：否，1：是
     */
    public void setOwnHouse(String ownHouse) {
        this.ownHouse = ownHouse == null ? null : ownHouse.trim();
    }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", custcd=").append(custcd);
		sb.append(", orgCode=").append(orgCode);
		sb.append(", legal=").append(legal);
		sb.append(", ename=").append(ename);
		sb.append(", enterpriseType=").append(enterpriseType);
		sb.append(", industryType=").append(industryType);
		sb.append(", enterpriseScope=").append(enterpriseScope);
		sb.append(", mainBussiness=").append(mainBussiness);
		sb.append(", contactAddr=").append(contactAddr);
		sb.append(", regAddr=").append(regAddr);
		sb.append(", postCode=").append(postCode);
		sb.append(", contactName=").append(contactName);
		sb.append(", contactTel=").append(contactTel);
		sb.append(", fax=").append(fax);
		sb.append(", creditLevel=").append(creditLevel);
		sb.append(", evaluateDate=").append(evaluateDate);
		sb.append(", baseActBank=").append(baseActBank);
		sb.append(", baseActno=").append(baseActno);
		sb.append(", actBrcode=").append(actBrcode);
		sb.append(", actno=").append(actno);
		sb.append(", description=").append(description);
		sb.append(", custType=").append(custType);
		sb.append(", regCapital=").append(regCapital);
		sb.append(", capital=").append(capital);
		sb.append(", curcd=").append(curcd);
		sb.append(", custRole=").append(custRole);
		sb.append(", businessScope=").append(businessScope);
		sb.append(", industryOutlook=").append(industryOutlook);
		sb.append(", employeeNumber=").append(employeeNumber);
		sb.append(", turnover=").append(turnover);
		sb.append(", businessDuration=").append(businessDuration);
		sb.append(", accountDuration=").append(accountDuration);
		sb.append(", area=").append(area);
		sb.append(", boundary=").append(boundary);
		sb.append(", custLevel=").append(custLevel);
		sb.append(", coreLevel=").append(coreLevel);
		sb.append(", supplyPosition=").append(supplyPosition);
		sb.append(", isMarketCorp=").append(isMarketCorp);
		sb.append(", establishDate=").append(establishDate);
		sb.append(", counCode=").append(counCode);
		sb.append(", regOrg=").append(regOrg);
		sb.append(", street=").append(street);
		sb.append(", city=").append(city);
		sb.append(", enAddr=").append(enAddr);
		sb.append(", contactEnName=").append(contactEnName);
		sb.append(", payRoute=").append(payRoute);
		sb.append(", services=").append(services);
		sb.append(", appendix=").append(appendix);
		sb.append(", email=").append(email);
		sb.append(", coreNetworkName=").append(coreNetworkName);
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
		BCrmEntInfo other = (BCrmEntInfo) that;
		return (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
				&& (this.getOrgCode() == null ? other.getOrgCode() == null
						: this.getOrgCode().equals(other.getOrgCode()))
				&& (this.getLegal() == null ? other.getLegal() == null : this.getLegal().equals(other.getLegal()))
				&& (this.getEname() == null ? other.getEname() == null : this.getEname().equals(other.getEname()))
				&& (this.getEnterpriseType() == null ? other.getEnterpriseType() == null
						: this.getEnterpriseType().equals(other.getEnterpriseType()))
				&& (this.getIndustryType() == null ? other.getIndustryType() == null
						: this.getIndustryType().equals(other.getIndustryType()))
				&& (this.getEnterpriseScope() == null ? other.getEnterpriseScope() == null
						: this.getEnterpriseScope().equals(other.getEnterpriseScope()))
				&& (this.getMainBussiness() == null ? other.getMainBussiness() == null
						: this.getMainBussiness().equals(other.getMainBussiness()))
				&& (this.getContactAddr() == null ? other.getContactAddr() == null
						: this.getContactAddr().equals(other.getContactAddr()))
				&& (this.getRegAddr() == null ? other.getRegAddr() == null
						: this.getRegAddr().equals(other.getRegAddr()))
				&& (this.getPostCode() == null ? other.getPostCode() == null
						: this.getPostCode().equals(other.getPostCode()))
				&& (this.getContactName() == null ? other.getContactName() == null
						: this.getContactName().equals(other.getContactName()))
				&& (this.getContactTel() == null ? other.getContactTel() == null
						: this.getContactTel().equals(other.getContactTel()))
				&& (this.getFax() == null ? other.getFax() == null : this.getFax().equals(other.getFax()))
				&& (this.getCreditLevel() == null ? other.getCreditLevel() == null
						: this.getCreditLevel().equals(other.getCreditLevel()))
				&& (this.getEvaluateDate() == null ? other.getEvaluateDate() == null
						: this.getEvaluateDate().equals(other.getEvaluateDate()))
				&& (this.getBaseActBank() == null ? other.getBaseActBank() == null
						: this.getBaseActBank().equals(other.getBaseActBank()))
				&& (this.getBaseActno() == null ? other.getBaseActno() == null
						: this.getBaseActno().equals(other.getBaseActno()))
				&& (this.getActBrcode() == null ? other.getActBrcode() == null
						: this.getActBrcode().equals(other.getActBrcode()))
				&& (this.getActno() == null ? other.getActno() == null : this.getActno().equals(other.getActno()))
				&& (this.getDescription() == null ? other.getDescription() == null
						: this.getDescription().equals(other.getDescription()))
				&& (this.getCustType() == null ? other.getCustType() == null
						: this.getCustType().equals(other.getCustType()))
				&& (this.getRegCapital() == null ? other.getRegCapital() == null
						: this.getRegCapital().equals(other.getRegCapital()))
				&& (this.getCapital() == null ? other.getCapital() == null
						: this.getCapital().equals(other.getCapital()))
				&& (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
				&& (this.getCustRole() == null ? other.getCustRole() == null
						: this.getCustRole().equals(other.getCustRole()))
				&& (this.getBusinessScope() == null ? other.getBusinessScope() == null
						: this.getBusinessScope().equals(other.getBusinessScope()))
				&& (this.getIndustryOutlook() == null ? other.getIndustryOutlook() == null
						: this.getIndustryOutlook().equals(other.getIndustryOutlook()))
				&& (this.getEmployeeNumber() == null ? other.getEmployeeNumber() == null
						: this.getEmployeeNumber().equals(other.getEmployeeNumber()))
				&& (this.getTurnover() == null ? other.getTurnover() == null
						: this.getTurnover().equals(other.getTurnover()))
				&& (this.getBusinessDuration() == null ? other.getBusinessDuration() == null
						: this.getBusinessDuration().equals(other.getBusinessDuration()))
				&& (this.getAccountDuration() == null ? other.getAccountDuration() == null
						: this.getAccountDuration().equals(other.getAccountDuration()))
				&& (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
				&& (this.getBoundary() == null ? other.getBoundary() == null
						: this.getBoundary().equals(other.getBoundary()))
				&& (this.getCustLevel() == null ? other.getCustLevel() == null
						: this.getCustLevel().equals(other.getCustLevel()))
				&& (this.getCoreLevel() == null ? other.getCoreLevel() == null
						: this.getCoreLevel().equals(other.getCoreLevel()))
				&& (this.getSupplyPosition() == null ? other.getSupplyPosition() == null
						: this.getSupplyPosition().equals(other.getSupplyPosition()))
				&& (this.getIsMarketCorp() == null ? other.getIsMarketCorp() == null
						: this.getIsMarketCorp().equals(other.getIsMarketCorp()))
				&& (this.getEstablishDate() == null ? other.getEstablishDate() == null
						: this.getEstablishDate().equals(other.getEstablishDate()))
				&& (this.getCounCode() == null ? other.getCounCode() == null
						: this.getCounCode().equals(other.getCounCode()))
				&& (this.getRegOrg() == null ? other.getRegOrg() == null : this.getRegOrg().equals(other.getRegOrg()))
				&& (this.getStreet() == null ? other.getStreet() == null : this.getStreet().equals(other.getStreet()))
				&& (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
				&& (this.getEnAddr() == null ? other.getEnAddr() == null : this.getEnAddr().equals(other.getEnAddr()))
				&& (this.getContactEnName() == null ? other.getContactEnName() == null
						: this.getContactEnName().equals(other.getContactEnName()))
				&& (this.getPayRoute() == null ? other.getPayRoute() == null
						: this.getPayRoute().equals(other.getPayRoute()))
				&& (this.getServices() == null ? other.getServices() == null
						: this.getServices().equals(other.getServices()))
				&& (this.getAppendix() == null ? other.getAppendix() == null
						: this.getAppendix().equals(other.getAppendix()))
				&& (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
				&& (this.getCoreNetworkName() == null ? other.getCoreNetworkName() == null
						: this.getCoreNetworkName().equals(other.getCoreNetworkName()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
		result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
		result = prime * result + ((getLegal() == null) ? 0 : getLegal().hashCode());
		result = prime * result + ((getEname() == null) ? 0 : getEname().hashCode());
		result = prime * result + ((getEnterpriseType() == null) ? 0 : getEnterpriseType().hashCode());
		result = prime * result + ((getIndustryType() == null) ? 0 : getIndustryType().hashCode());
		result = prime * result + ((getEnterpriseScope() == null) ? 0 : getEnterpriseScope().hashCode());
		result = prime * result + ((getMainBussiness() == null) ? 0 : getMainBussiness().hashCode());
		result = prime * result + ((getContactAddr() == null) ? 0 : getContactAddr().hashCode());
		result = prime * result + ((getRegAddr() == null) ? 0 : getRegAddr().hashCode());
		result = prime * result + ((getPostCode() == null) ? 0 : getPostCode().hashCode());
		result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
		result = prime * result + ((getContactTel() == null) ? 0 : getContactTel().hashCode());
		result = prime * result + ((getFax() == null) ? 0 : getFax().hashCode());
		result = prime * result + ((getCreditLevel() == null) ? 0 : getCreditLevel().hashCode());
		result = prime * result + ((getEvaluateDate() == null) ? 0 : getEvaluateDate().hashCode());
		result = prime * result + ((getBaseActBank() == null) ? 0 : getBaseActBank().hashCode());
		result = prime * result + ((getBaseActno() == null) ? 0 : getBaseActno().hashCode());
		result = prime * result + ((getActBrcode() == null) ? 0 : getActBrcode().hashCode());
		result = prime * result + ((getActno() == null) ? 0 : getActno().hashCode());
		result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
		result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
		result = prime * result + ((getRegCapital() == null) ? 0 : getRegCapital().hashCode());
		result = prime * result + ((getCapital() == null) ? 0 : getCapital().hashCode());
		result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
		result = prime * result + ((getCustRole() == null) ? 0 : getCustRole().hashCode());
		result = prime * result + ((getBusinessScope() == null) ? 0 : getBusinessScope().hashCode());
		result = prime * result + ((getIndustryOutlook() == null) ? 0 : getIndustryOutlook().hashCode());
		result = prime * result + ((getEmployeeNumber() == null) ? 0 : getEmployeeNumber().hashCode());
		result = prime * result + ((getTurnover() == null) ? 0 : getTurnover().hashCode());
		result = prime * result + ((getBusinessDuration() == null) ? 0 : getBusinessDuration().hashCode());
		result = prime * result + ((getAccountDuration() == null) ? 0 : getAccountDuration().hashCode());
		result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
		result = prime * result + ((getBoundary() == null) ? 0 : getBoundary().hashCode());
		result = prime * result + ((getCustLevel() == null) ? 0 : getCustLevel().hashCode());
		result = prime * result + ((getCoreLevel() == null) ? 0 : getCoreLevel().hashCode());
		result = prime * result + ((getSupplyPosition() == null) ? 0 : getSupplyPosition().hashCode());
		result = prime * result + ((getIsMarketCorp() == null) ? 0 : getIsMarketCorp().hashCode());
		result = prime * result + ((getEstablishDate() == null) ? 0 : getEstablishDate().hashCode());
		result = prime * result + ((getCounCode() == null) ? 0 : getCounCode().hashCode());
		result = prime * result + ((getRegOrg() == null) ? 0 : getRegOrg().hashCode());
		result = prime * result + ((getStreet() == null) ? 0 : getStreet().hashCode());
		result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
		result = prime * result + ((getEnAddr() == null) ? 0 : getEnAddr().hashCode());
		result = prime * result + ((getContactEnName() == null) ? 0 : getContactEnName().hashCode());
		result = prime * result + ((getPayRoute() == null) ? 0 : getPayRoute().hashCode());
		result = prime * result + ((getServices() == null) ? 0 : getServices().hashCode());
		result = prime * result + ((getAppendix() == null) ? 0 : getAppendix().hashCode());
		result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
		result = prime * result + ((getCoreNetworkName() == null) ? 0 : getCoreNetworkName().hashCode());
		return result;
	}
}
package com.huateng.scf.bas.crm.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CustomerVO implements Serializable {
	
	// primary key
		private java.lang.String id;
		/** TblContBaseInfo */
		// primary key
		private java.lang.String debetId;
		private java.util.Date signDate;
		private java.util.Date dueDate;
		private java.lang.String mastContno;
		private java.lang.String lnciType;
		private java.lang.String lnciStatus;
		private java.math.BigDecimal lnciAmt;
		private java.math.BigDecimal lnciBal;
		private java.lang.String fivelevel;
		private java.math.BigDecimal pcontAmount;
		private java.math.BigDecimal repayBalamt;
		/** TblCustAuthorizeInfo */
		private java.lang.String supplyChainPdId;
		private java.lang.String authTlrcd;
		private java.util.Date authDate;
		private java.lang.String checkTlrcd;
		private java.util.Date checkDate;
		private java.lang.String mutiProtStatus;
		private java.util.Date startDate;
		private java.util.Date endDate;
		private java.lang.String description;
		private java.lang.String appno;
		private java.lang.String status;
		private java.lang.String appliStatus; // 申请流程状态
		private java.lang.String appliStatusDtl;// 申请状态明细

		/** BCrmBaseInfo */
		private java.lang.String custno;
		private java.lang.String cname;
		private java.lang.String ename;
		private java.lang.String aliasName;
		private java.lang.String orgCode;
		private java.lang.String licenseNo;
		private java.lang.String licenseDate;
		private java.lang.String lastUpdTlrcd;
		private java.util.Date lastUpdTime;
		private java.lang.String custType;
		private java.lang.String idtype;
		private java.lang.String idno;
		private java.lang.String openDate;
		private java.lang.String coreOpenDate;
		private java.lang.String custStatus;
		private java.lang.Integer returnFlag;
		private String coreFlag;
		private String moniFlag;
		private String futuresFlag;
		private String flcFlag; //是否为金融租赁公司
		private String creditFlag;
		private String insureFlag;	//是否保险公司
		private String factorFlag;  //是否保理商
		private String isMarketCorp;//是否上市公司
		private String importantFlag;//是否贸融重点客户
		private String commercialFlag;//是否贸易对手
		private String ccmsCustcd;//信贷客户号
		private String fciCode;//FCI代号
		private String isBank;//是否是银行：0-否、1-是
		private String isIntl;
		private String relationType;//关联关系--上游、下游、监管公司

		private java.lang.String otherprotocolNo;

		/** BCrmEntInfo */
		// private java.lang.String orgCode;
		private java.lang.String legal;
		// private java.lang.String ename;
		private java.lang.String enterpriseType;
		private java.lang.String industryType;
		private java.lang.String enterpriseScope;
		private java.lang.String mainBussiness;
		private java.lang.String contactAddr;
		private java.lang.String regAddr;
		private java.lang.String postCode;
		private java.lang.String contactName;
		private java.lang.String contactTel;
		private java.lang.String fax;
		private java.lang.String creditLevel;
		private java.util.Date evaluateDate;
		private java.lang.String baseActBank;
		private java.lang.String baseActno;
		private java.lang.String actBrcode;
		private java.lang.String actno;
		private java.lang.String fjsellerCustno;
		private java.lang.String whetherOpen;
		private java.lang.String belongOrg;
		private java.util.Date firstpassed;
		private BigDecimal regCapital;
		private BigDecimal capital;
		private java.lang.String custRole;
		// private java.lang.String description;
		private java.lang.String businessScope;
		private java.lang.String industryOutlook;
		private java.math.BigDecimal employeeNumber;
		private java.math.BigDecimal turnover;
		private java.math.BigDecimal businessDuration;
		private java.math.BigDecimal accountDuration;
		private java.lang.String area;
		private java.lang.String boundary;
		private java.lang.String custLevel;
		private java.lang.String coreLevel;
		private java.lang.String supplyPosition;	//供应链所处地位
		private java.lang.String establishDate;
		private java.lang.String email;

		/** BCrmMoniEntInfo */
		private java.lang.String monitoryType;
		// private java.lang.String regAddr;
		private java.lang.String curcd;
		private java.math.BigDecimal limitSum;
		private java.math.BigDecimal limitSingle;
		private java.math.BigDecimal userdLimit;
		private java.lang.String createDate;
		private java.lang.String levels;
		private java.lang.String level;
		private java.lang.String monitortype;// 监管模式
		private java.lang.String grouped;// 是否总公司
		private java.lang.String groupedMember;// 是否集团成员
		private java.lang.String parentId;// 上级监管公司
		private java.lang.String warehouseAddrType;
		private java.lang.String channelMode;
		private java.lang.String bankCorporateMode;
		private java.lang.String monitorArea;	//监管区域
		private java.lang.String detailMonitorArea;	//具体监管区域（省/市）
		private java.util.Date levelCogniDate;	//等级认定日期
		private java.util.Date levelEndDate;	//等级到期日期
		private java.lang.String monitorStatus;	//监管公司状态
		// private java.lang.String description;

		/** TblFinSrvNet */
		private java.lang.Integer netNo;
		private java.lang.String netName;
		private java.lang.String custcd;
		// private java.lang.String description;
		private java.lang.String creatTlrcd;
		private java.lang.String creatOrgNo;
		private java.util.Date creatDate;
		// private java.lang.String mutiProtStatus;
		// private java.lang.String checkTlrcd;

		/** TblFinSrvNetMember */
		private java.lang.String memberCustcd;
		private java.lang.String memberName;
		private java.lang.String memberRole;
		// private java.lang.String description;

		/** TblWarehouseInfo */
		private java.lang.Integer warehouseId;
		private java.lang.String moniOfCustcd;
		private java.lang.String warehouseName;
		private java.lang.String warehouseAddr;
		private java.lang.String postno;
		private java.lang.String contact;
		private java.lang.String teleno;
		private java.lang.String warehouseNo;
		// private java.lang.String description;

		/** TblCustOfTlr */
		// private java.lang.String custcd;
		private java.lang.String tlrcd;
		private java.lang.String custOfTlrType;
		private java.util.Date txdate;
		private java.util.Date txtime;
		// private java.lang.String description;
		private java.lang.String brcode;
		private java.lang.String brName;

		private java.lang.String custClass;
		private java.lang.String mgrno;
		private java.math.BigDecimal amount;
		private java.math.BigDecimal userdAmount;
		private java.lang.String industryName;
		private String industryTypeName;
		private java.lang.String feature1;
		private java.lang.String feature2;
		private java.lang.String feature3;
		private java.lang.String feature4;
		private java.lang.String feature5;
		private java.lang.String feature13;
		private java.lang.String feature15;
		private java.lang.String feature16;
		private java.lang.String registerCapital;
		private java.lang.String actualCapital;

		// TblCustRelationInfo
		private java.lang.String buyerCustcd;
		private java.lang.String sellerCustcd;
		private java.lang.String coreCustcd;
		private java.lang.String moniCustcd;
		private java.lang.String state;
		private java.lang.String lastUpdateTlrcd;
		private java.util.Date lastUpdateDate;
		private java.lang.String usedType;
		private java.lang.String relaType;

		/* TblCustReleationCredit */
		private java.lang.String relationId;
		private java.math.BigDecimal creditAmount;
		private java.math.BigDecimal creditUsableAmount;
		private java.lang.String frozenState;
		private java.lang.String recycle;
		private java.lang.String creditType;
		private java.math.BigDecimal preUsedAmount;
		private java.math.BigDecimal usedAmount;
		/* TblCustAccount */
		private java.lang.String accountType;// 账户类型
		private java.lang.String accountNo;// 账号
		private java.lang.String inputorgname;// 经办机构名称
		private java.lang.String creditNo;// 额度编号
		private java.lang.String accountName;// 账号名称
		private java.lang.String tlrName;// 维护人姓名
		private java.math.BigDecimal account;// 账户金额
		private java.lang.String srcfrom;// 黑名单来源
		private java.lang.String relation;// 是否本行利害关系人
		private java.lang.String mail;// 客户邮箱
		private java.lang.String tlrno;
		private java.lang.String slaveContno;
		private java.lang.String idtypeName;
		private java.lang.String secRole;
		private java.lang.String secActUbankno;
		private java.lang.String firCd;

		//TblNetworkCustImp
		private java.lang.String coreOrgCode;//核心组织机构代码
		private java.lang.String coreCustName;
		private java.lang.String custName;//客户名称
		private java.lang.String regCaptial;//注册资本金额
		private java.lang.String batchId;
		private java.lang.String netProtocolNo;
		private java.lang.String lastUpdName;
		private java.lang.String networkName;
		private java.lang.String netProtocolCode;
		private java.lang.Integer regYear;//注册年限
		private java.math.BigDecimal totalAssets;//资产总额(万元)
		private java.lang.String orgSoundFlag;//营业收入(万元)
		private java.lang.String managementFlag;//内部管理制度是否健全
		private java.lang.String riskControlFlag;//风险控制制度是否健全
		private java.lang.Integer badRecord;//不良记录
		private java.lang.Integer cycleDays;//周期(天)
		private java.lang.Integer coperateYear;//合作年限
		private java.lang.Integer coperateTimes;//合作次数
		private java.math.BigDecimal tradeAmount;//核心厂商供应、采购量(万)
		private java.math.BigDecimal tradePercent;//核心厂商供应、采购占比
		private java.math.BigDecimal lastYearPercent;//上年同比

		private java.lang.String counCode;
		private java.lang.String regOrg;
		private java.lang.String street;
		private java.lang.String city;
		private java.lang.String enAddr;
		private java.lang.String contactEnName;
		private String payRoute;
		private String services;
		private String appendix;

		private java.lang.String overseasFlag;
		private java.lang.String banksCustFlag;
		private java.lang.String efBuyerFlag;
		private java.lang.String ifSellerFlag;

		//TblCustIfSeller
		private boolean signedProtocal;
		private java.lang.String efId;
		private java.lang.String efName;
		private java.lang.Integer payTerm;
		private java.lang.Integer payGrace;
		private java.lang.Integer majorRebateDate;
		private java.math.BigDecimal majorRebateRate;
		private java.lang.Integer minorRebateDate;
		private java.math.BigDecimal minorRebateRate;
		private java.lang.String curcd1;
		private java.lang.String curcd2;
		private java.lang.String curcd3;
		private java.lang.String curcd4;
		private java.lang.String curcd5;
		private java.math.BigDecimal shortSectionRate;
		private java.math.BigDecimal shortSectionAmount;
		private java.lang.String shortSectionCurcd;
		private java.math.BigDecimal totalSaleAmount;
		private java.lang.Integer ifCountryCustNum;
		private java.lang.Integer ifBillNum;
		private java.lang.Integer ifGoodsListNum;
		private java.math.BigDecimal ifChargeSaleAmount;
		private java.math.BigDecimal ifOtherSaleAmount;
		private java.lang.String otherFactor;
		private java.lang.String serviceReq;
		private java.lang.Integer deliverTerm;
		private java.lang.String efAccount;
		private java.lang.String efBank;
		private java.lang.String efSubbank;
		private java.lang.String msgDetail;


		public String getRelationType() {
			return relationType;
		}

		public void setRelationType(String relationType) {
			this.relationType = relationType;
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

		public boolean isSignedProtocal() {
			return signedProtocal;
		}

		public void setSignedProtocal(boolean signedProtocal) {
			this.signedProtocal = signedProtocal;
		}

		public java.lang.String getEfId() {
			return efId;
		}

		public void setEfId(java.lang.String efId) {
			this.efId = efId;
		}

		public java.lang.String getEfName() {
			return efName;
		}

		public void setEfName(java.lang.String efName) {
			this.efName = efName;
		}

		public java.lang.Integer getPayTerm() {
			return payTerm;
		}

		public void setPayTerm(java.lang.Integer payTerm) {
			this.payTerm = payTerm;
		}

		public java.lang.Integer getPayGrace() {
			return payGrace;
		}

		public void setPayGrace(java.lang.Integer payGrace) {
			this.payGrace = payGrace;
		}

		public java.lang.Integer getMajorRebateDate() {
			return majorRebateDate;
		}

		public void setMajorRebateDate(java.lang.Integer majorRebateDate) {
			this.majorRebateDate = majorRebateDate;
		}

		public java.math.BigDecimal getMajorRebateRate() {
			return majorRebateRate;
		}

		public void setMajorRebateRate(java.math.BigDecimal majorRebateRate) {
			this.majorRebateRate = majorRebateRate;
		}

		public java.lang.Integer getMinorRebateDate() {
			return minorRebateDate;
		}

		public void setMinorRebateDate(java.lang.Integer minorRebateDate) {
			this.minorRebateDate = minorRebateDate;
		}

		public java.math.BigDecimal getMinorRebateRate() {
			return minorRebateRate;
		}

		public void setMinorRebateRate(java.math.BigDecimal minorRebateRate) {
			this.minorRebateRate = minorRebateRate;
		}

		public java.lang.String getCurcd1() {
			return curcd1;
		}

		public void setCurcd1(java.lang.String curcd1) {
			this.curcd1 = curcd1;
		}

		public java.lang.String getCurcd2() {
			return curcd2;
		}

		public void setCurcd2(java.lang.String curcd2) {
			this.curcd2 = curcd2;
		}

		public java.lang.String getCurcd3() {
			return curcd3;
		}

		public void setCurcd3(java.lang.String curcd3) {
			this.curcd3 = curcd3;
		}

		public java.lang.String getCurcd4() {
			return curcd4;
		}

		public void setCurcd4(java.lang.String curcd4) {
			this.curcd4 = curcd4;
		}

		public java.lang.String getCurcd5() {
			return curcd5;
		}

		public void setCurcd5(java.lang.String curcd5) {
			this.curcd5 = curcd5;
		}

		public java.math.BigDecimal getShortSectionRate() {
			return shortSectionRate;
		}

		public void setShortSectionRate(java.math.BigDecimal shortSectionRate) {
			this.shortSectionRate = shortSectionRate;
		}

		public java.math.BigDecimal getShortSectionAmount() {
			return shortSectionAmount;
		}

		public void setShortSectionAmount(java.math.BigDecimal shortSectionAmount) {
			this.shortSectionAmount = shortSectionAmount;
		}

		public java.lang.String getShortSectionCurcd() {
			return shortSectionCurcd;
		}

		public void setShortSectionCurcd(java.lang.String shortSectionCurcd) {
			this.shortSectionCurcd = shortSectionCurcd;
		}

		public java.math.BigDecimal getTotalSaleAmount() {
			return totalSaleAmount;
		}

		public void setTotalSaleAmount(java.math.BigDecimal totalSaleAmount) {
			this.totalSaleAmount = totalSaleAmount;
		}

		public java.lang.Integer getIfCountryCustNum() {
			return ifCountryCustNum;
		}

		public void setIfCountryCustNum(java.lang.Integer ifCountryCustNum) {
			this.ifCountryCustNum = ifCountryCustNum;
		}

		public java.lang.Integer getIfBillNum() {
			return ifBillNum;
		}

		public void setIfBillNum(java.lang.Integer ifBillNum) {
			this.ifBillNum = ifBillNum;
		}

		public java.lang.Integer getIfGoodsListNum() {
			return ifGoodsListNum;
		}

		public void setIfGoodsListNum(java.lang.Integer ifGoodsListNum) {
			this.ifGoodsListNum = ifGoodsListNum;
		}

		public java.math.BigDecimal getIfChargeSaleAmount() {
			return ifChargeSaleAmount;
		}

		public void setIfChargeSaleAmount(java.math.BigDecimal ifChargeSaleAmount) {
			this.ifChargeSaleAmount = ifChargeSaleAmount;
		}

		public java.math.BigDecimal getIfOtherSaleAmount() {
			return ifOtherSaleAmount;
		}

		public void setIfOtherSaleAmount(java.math.BigDecimal ifOtherSaleAmount) {
			this.ifOtherSaleAmount = ifOtherSaleAmount;
		}

		public java.lang.String getOtherFactor() {
			return otherFactor;
		}

		public void setOtherFactor(java.lang.String otherFactor) {
			this.otherFactor = otherFactor;
		}

		public java.lang.String getServiceReq() {
			return serviceReq;
		}

		public void setServiceReq(java.lang.String serviceReq) {
			this.serviceReq = serviceReq;
		}

		public java.lang.Integer getDeliverTerm() {
			return deliverTerm;
		}

		public void setDeliverTerm(java.lang.Integer deliverTerm) {
			this.deliverTerm = deliverTerm;
		}

		public java.lang.String getEfAccount() {
			return efAccount;
		}

		public void setEfAccount(java.lang.String efAccount) {
			this.efAccount = efAccount;
		}

		public java.lang.String getEfBank() {
			return efBank;
		}

		public void setEfBank(java.lang.String efBank) {
			this.efBank = efBank;
		}

		public java.lang.String getEfSubbank() {
			return efSubbank;
		}

		public void setEfSubbank(java.lang.String efSubbank) {
			this.efSubbank = efSubbank;
		}

		public java.lang.String getMsgDetail() {
			return msgDetail;
		}

		public void setMsgDetail(java.lang.String msgDetail) {
			this.msgDetail = msgDetail;
		}

		public java.lang.String getCounCode() {
			return counCode;
		}

		public void setCounCode(java.lang.String counCode) {
			this.counCode = counCode;
		}

		public java.lang.String getRegOrg() {
			return regOrg;
		}

		public void setRegOrg(java.lang.String regOrg) {
			this.regOrg = regOrg;
		}

		public java.lang.String getStreet() {
			return street;
		}

		public void setStreet(java.lang.String street) {
			this.street = street;
		}

		public java.lang.String getCity() {
			return city;
		}

		public void setCity(java.lang.String city) {
			this.city = city;
		}

		public java.lang.String getEnAddr() {
			return enAddr;
		}

		public void setEnAddr(java.lang.String enAddr) {
			this.enAddr = enAddr;
		}

		public java.lang.String getContactEnName() {
			return contactEnName;
		}

		public void setContactEnName(java.lang.String contactEnName) {
			this.contactEnName = contactEnName;
		}

		public java.lang.String getOverseasFlag() {
			return overseasFlag;
		}

		public void setOverseasFlag(java.lang.String overseasFlag) {
			this.overseasFlag = overseasFlag;
		}

		public java.lang.String getBanksCustFlag() {
			return banksCustFlag;
		}

		public void setBanksCustFlag(java.lang.String banksCustFlag) {
			this.banksCustFlag = banksCustFlag;
		}

		public java.lang.String getEfBuyerFlag() {
			return efBuyerFlag;
		}

		public void setEfBuyerFlag(java.lang.String efBuyerFlag) {
			this.efBuyerFlag = efBuyerFlag;
		}

		public java.lang.String getIfSellerFlag() {
			return ifSellerFlag;
		}

		public void setIfSellerFlag(java.lang.String ifSellerFlag) {
			this.ifSellerFlag = ifSellerFlag;
		}

		public java.lang.String getSlaveContno() {
			return slaveContno;
		}

		public void setSlaveContno(java.lang.String slaveContno) {
			this.slaveContno = slaveContno;
		}

		public java.lang.String getIdtypeName() {
			return idtypeName;
		}

		public void setIdtypeName(java.lang.String idtypeName) {
			this.idtypeName = idtypeName;
		}

		public java.lang.String getSecRole() {
			return secRole;
		}

		public void setSecRole(java.lang.String secRole) {
			this.secRole = secRole;
		}

		public java.lang.String getSecActUbankno() {
			return secActUbankno;
		}

		public void setSecActUbankno(java.lang.String secActUbankno) {
			this.secActUbankno = secActUbankno;
		}

		public java.lang.String getCreditNo() {
			return creditNo;
		}

		public void setCreditNo(java.lang.String creditNo) {
			this.creditNo = creditNo;
		}

		public java.lang.String getAccountType() {
			return accountType;
		}

		public void setAccountType(java.lang.String accountType) {
			this.accountType = accountType;
		}

		public java.lang.String getAccountNo() {
			return accountNo;
		}

		public void setAccountNo(java.lang.String accountNo) {
			this.accountNo = accountNo;
		}

		public java.lang.String getInputorgname() {
			return inputorgname;
		}

		public void setInputorgname(java.lang.String inputorgname) {
			this.inputorgname = inputorgname;
		}

		public java.lang.String getCreditType() {
			return creditType;
		}

		public void setCreditType(java.lang.String creditType) {
			this.creditType = creditType;
		}

		public java.math.BigDecimal getPreUsedAmount() {
			return preUsedAmount;
		}

		public void setPreUsedAmount(java.math.BigDecimal preUsedAmount) {
			this.preUsedAmount = preUsedAmount;
		}

		public java.math.BigDecimal getUsedAmount() {
			return usedAmount;
		}

		public void setUsedAmount(java.math.BigDecimal usedAmount) {
			this.usedAmount = usedAmount;
		}

		public java.lang.String getMonitortype() {
			return monitortype;
		}

		public void setMonitortype(java.lang.String monitortype) {
			this.monitortype = monitortype;
		}

		public java.lang.String getGrouped() {
			return grouped;
		}

		public void setGrouped(java.lang.String grouped) {
			this.grouped = grouped;
		}

		public java.lang.String getGroupedMember() {
			return groupedMember;
		}

		public void setGroupedMember(java.lang.String groupedMember) {
			this.groupedMember = groupedMember;
		}

		public java.lang.String getLevel() {
			return level;
		}

		public void setLevel(java.lang.String level) {
			this.level = level;
		}

		public java.lang.String getParentId() {
			return parentId;
		}

		public void setParentId(java.lang.String parentId) {
			this.parentId = parentId;
		}

		public java.lang.String getBrcode() {
			return brcode;
		}

		public void setBrcode(java.lang.String brcode) {
			this.brcode = brcode;
		}

		public java.lang.String getBrName() {
			return brName;
		}

		public void setBrName(java.lang.String brName) {
			this.brName = brName;
		}

		public java.lang.String getId() {
			return id;
		}

		public void setId(java.lang.String id) {
			this.id = id;
		}

		public java.lang.String getSupplyChainPdId() {
			return supplyChainPdId;
		}

		public void setSupplyChainPdId(java.lang.String supplyChainPdId) {
			this.supplyChainPdId = supplyChainPdId;
		}

		public java.lang.String getAuthTlrcd() {
			return authTlrcd;
		}

		public void setAuthTlrcd(java.lang.String authTlrcd) {
			this.authTlrcd = authTlrcd;
		}

		public java.util.Date getAuthDate() {
			return authDate;
		}

		public void setAuthDate(java.util.Date authDate) {
			this.authDate = authDate;
		}

		public java.lang.String getCheckTlrcd() {
			return checkTlrcd;
		}

		public void setCheckTlrcd(java.lang.String checkTlrcd) {
			this.checkTlrcd = checkTlrcd;
		}

		public java.util.Date getCheckDate() {
			return checkDate;
		}

		public void setCheckDate(java.util.Date checkDate) {
			this.checkDate = checkDate;
		}

		public java.lang.String getMutiProtStatus() {
			return mutiProtStatus;
		}

		public void setMutiProtStatus(java.lang.String mutiProtStatus) {
			this.mutiProtStatus = mutiProtStatus;
		}

		public java.util.Date getStartDate() {
			return startDate;
		}

		public void setStartDate(java.util.Date startDate) {
			this.startDate = startDate;
		}

		public java.util.Date getEndDate() {
			return endDate;
		}

		public void setEndDate(java.util.Date endDate) {
			this.endDate = endDate;
		}

		public java.lang.String getDescription() {
			return description;
		}

		public BigDecimal getCapital() {
			return capital;
		}

		public void setCapital(BigDecimal capital) {
			this.capital = capital;
		}

		public void setDescription(java.lang.String description) {
			this.description = description;
		}

		public java.lang.String getCustno() {
			return custno;
		}

		public void setCustno(java.lang.String custno) {
			this.custno = custno;
		}

		public java.lang.String getCname() {
			return cname;
		}

		public void setCname(java.lang.String cname) {
			this.cname = cname;
		}

		public java.lang.String getEname() {
			return ename;
		}

		public void setEname(java.lang.String ename) {
			this.ename = ename;
		}

		public java.lang.String getAliasName() {
			return aliasName;
		}

		public void setAliasName(java.lang.String aliasName) {
			this.aliasName = aliasName;
		}

		public java.lang.String getOrgCode() {
			return orgCode;
		}

		public void setOrgCode(java.lang.String orgCode) {
			this.orgCode = orgCode;
		}

		public java.lang.String getLicenseNo() {
			return licenseNo;
		}

		public void setLicenseNo(java.lang.String licenseNo) {
			this.licenseNo = licenseNo;
		}

		public java.lang.String getLicenseDate() {
			return licenseDate;
		}

		public void setLicenseDate(java.lang.String licenseDate) {
			this.licenseDate = licenseDate;
		}

		public java.lang.String getLastUpdTlrcd() {
			return lastUpdTlrcd;
		}

		public void setLastUpdTlrcd(java.lang.String lastUpdTlrcd) {
			this.lastUpdTlrcd = lastUpdTlrcd;
		}

		public java.util.Date getLastUpdTime() {
			return lastUpdTime;
		}

		public void setLastUpdTime(java.util.Date lastUpdTime) {
			this.lastUpdTime = lastUpdTime;
		}

		public java.lang.String getLegal() {
			return legal;
		}

		public void setLegal(java.lang.String legal) {
			this.legal = legal;
		}

		public java.lang.String getEnterpriseType() {
			return enterpriseType;
		}

		public void setEnterpriseType(java.lang.String enterpriseType) {
			this.enterpriseType = enterpriseType;
		}

		public java.lang.String getIndustryType() {
			return industryType;
		}

		public void setIndustryType(java.lang.String industryType) {
			this.industryType = industryType;
		}

		public java.lang.String getEnterpriseScope() {
			return enterpriseScope;
		}

		public void setEnterpriseScope(java.lang.String enterpriseScope) {
			this.enterpriseScope = enterpriseScope;
		}

		public java.lang.String getMainBussiness() {
			return mainBussiness;
		}

		public void setMainBussiness(java.lang.String mainBussiness) {
			this.mainBussiness = mainBussiness;
		}

		public java.lang.String getContactAddr() {
			return contactAddr;
		}

		public void setContactAddr(java.lang.String contactAddr) {
			this.contactAddr = contactAddr;
		}

		public java.lang.String getRegAddr() {
			return regAddr;
		}

		public void setRegAddr(java.lang.String regAddr) {
			this.regAddr = regAddr;
		}

		public java.lang.String getCustRole() {
			return custRole;
		}

		public void setCustRole(java.lang.String custRole) {
			this.custRole = custRole;
		}

		public java.lang.String getPostCode() {
			return postCode;
		}

		public void setPostCode(java.lang.String postCode) {
			this.postCode = postCode;
		}

		public java.lang.String getContactName() {
			return contactName;
		}

		public void setContactName(java.lang.String contactName) {
			this.contactName = contactName;
		}

		public java.lang.String getContactTel() {
			return contactTel;
		}

		public void setContactTel(java.lang.String contactTel) {
			this.contactTel = contactTel;
		}

		public java.lang.String getFax() {
			return fax;
		}

		public void setFax(java.lang.String fax) {
			this.fax = fax;
		}

		public java.lang.String getCreditLevel() {
			return creditLevel;
		}

		public void setCreditLevel(java.lang.String creditLevel) {
			this.creditLevel = creditLevel;
		}

		public java.util.Date getEvaluateDate() {
			return evaluateDate;
		}

		public BigDecimal getRegCapital() {
			return regCapital;
		}

		public void setRegCapital(BigDecimal regCapital) {
			this.regCapital = regCapital;
		}

		public void setEvaluateDate(java.util.Date evaluateDate) {
			this.evaluateDate = evaluateDate;
		}

		public java.lang.String getBaseActBank() {
			return baseActBank;
		}

		public void setBaseActBank(java.lang.String baseActBank) {
			this.baseActBank = baseActBank;
		}

		public java.lang.String getBaseActno() {
			return baseActno;
		}

		public void setBaseActno(java.lang.String baseActno) {
			this.baseActno = baseActno;
		}

		public java.lang.String getActBrcode() {
			return actBrcode;
		}

		public void setActBrcode(java.lang.String actBrcode) {
			this.actBrcode = actBrcode;
		}

		public java.lang.String getActno() {
			return actno;
		}

		public void setActno(java.lang.String actno) {
			this.actno = actno;
		}

		public java.lang.String getMonitoryType() {
			return monitoryType;
		}

		public void setMonitoryType(java.lang.String monitoryType) {
			this.monitoryType = monitoryType;
		}

		public java.lang.String getCurcd() {
			return curcd;
		}

		public void setCurcd(java.lang.String curcd) {
			this.curcd = curcd;
		}

		public java.math.BigDecimal getLimitSum() {
			return limitSum;
		}

		public void setLimitSum(java.math.BigDecimal limitSum) {
			this.limitSum = limitSum;
		}

		public java.math.BigDecimal getLimitSingle() {
			return limitSingle;
		}

		public void setLimitSingle(java.math.BigDecimal limitSingle) {
			this.limitSingle = limitSingle;
		}

		public java.math.BigDecimal getUserdLimit() {
			return userdLimit;
		}

		public void setUserdLimit(java.math.BigDecimal userdLimit) {
			this.userdLimit = userdLimit;
		}

		public java.lang.String getCreateDate() {
			return createDate;
		}

		public void setCreateDate(java.lang.String createDate) {
			this.createDate = createDate;
		}

		public java.lang.Integer getNetNo() {
			return netNo;
		}

		public void setNetNo(java.lang.Integer netNo) {
			this.netNo = netNo;
		}

		public java.lang.String getNetName() {
			return netName;
		}

		public void setNetName(java.lang.String netName) {
			this.netName = netName;
		}

		public java.lang.String getCustcd() {
			return custcd;
		}

		public void setCustcd(java.lang.String custcd) {
			this.custcd = custcd;
		}

		public java.lang.String getCreatTlrcd() {
			return creatTlrcd;
		}

		public void setCreatTlrcd(java.lang.String creatTlrcd) {
			this.creatTlrcd = creatTlrcd;
		}

		public java.lang.String getCreatOrgNo() {
			return creatOrgNo;
		}

		public void setCreatOrgNo(java.lang.String creatOrgNo) {
			this.creatOrgNo = creatOrgNo;
		}

		public java.util.Date getCreatDate() {
			return creatDate;
		}

		public void setCreatDate(java.util.Date creatDate) {
			this.creatDate = creatDate;
		}

		public java.lang.String getMemberCustcd() {
			return memberCustcd;
		}

		public void setMemberCustcd(java.lang.String memberCustcd) {
			this.memberCustcd = memberCustcd;
		}

		public java.lang.String getMemberName() {
			return memberName;
		}

		public void setMemberName(java.lang.String memberName) {
			this.memberName = memberName;
		}

		public java.lang.String getMemberRole() {
			return memberRole;
		}

		public void setMemberRole(java.lang.String memberRole) {
			this.memberRole = memberRole;
		}

		public java.lang.Integer getWarehouseId() {
			return warehouseId;
		}

		public void setWarehouseId(java.lang.Integer warehouseId) {
			this.warehouseId = warehouseId;
		}

		public java.lang.String getMoniOfCustcd() {
			return moniOfCustcd;
		}

		public void setMoniOfCustcd(java.lang.String moniOfCustcd) {
			this.moniOfCustcd = moniOfCustcd;
		}

		public java.lang.String getWarehouseName() {
			return warehouseName;
		}

		public void setWarehouseName(java.lang.String warehouseName) {
			this.warehouseName = warehouseName;
		}

		public java.lang.String getWarehouseAddr() {
			return warehouseAddr;
		}

		public void setWarehouseAddr(java.lang.String warehouseAddr) {
			this.warehouseAddr = warehouseAddr;
		}

		public java.lang.String getPostno() {
			return postno;
		}

		public void setPostno(java.lang.String postno) {
			this.postno = postno;
		}

		public java.lang.String getContact() {
			return contact;
		}

		public void setContact(java.lang.String contact) {
			this.contact = contact;
		}

		public java.lang.String getTeleno() {
			return teleno;
		}

		public void setTeleno(java.lang.String teleno) {
			this.teleno = teleno;
		}

		public java.lang.String getTlrcd() {
			return tlrcd;
		}

		public void setTlrcd(java.lang.String tlrcd) {
			this.tlrcd = tlrcd;
		}

		public java.lang.String getCustOfTlrType() {
			return custOfTlrType;
		}

		public void setCustOfTlrType(java.lang.String custOfTlrType) {
			this.custOfTlrType = custOfTlrType;
		}

		public java.util.Date getTxdate() {
			return txdate;
		}

		public void setTxdate(java.util.Date txdate) {
			this.txdate = txdate;
		}

		public java.util.Date getTxtime() {
			return txtime;
		}

		public void setTxtime(java.util.Date txtime) {
			this.txtime = txtime;
		}

		/**
		 * @return the appno
		 */
		public java.lang.String getAppno() {
			return appno;
		}

		/**
		 * @param appno
		 *            the appno to set
		 */
		public void setAppno(java.lang.String appno) {
			this.appno = appno;
		}

		/**
		 * @return the status
		 */
		public java.lang.String getStatus() {
			return status;
		}

		/**
		 * @param status
		 *            the status to set
		 */
		public void setStatus(java.lang.String status) {
			this.status = status;
		}

		/**
		 * @return the appliStatus
		 */
		public java.lang.String getAppliStatus() {
			return appliStatus;
		}

		/**
		 * @param appliStatus
		 *            the appliStatus to set
		 */
		public void setAppliStatus(java.lang.String appliStatus) {
			this.appliStatus = appliStatus;
		}

		public java.lang.String getCustType() {
			return custType;
		}

		public void setCustType(java.lang.String custType) {
			this.custType = custType;
		}

		public java.lang.String getIdtype() {
			return idtype;
		}

		public void setIdtype(java.lang.String idtype) {
			this.idtype = idtype;
		}

		public java.lang.String getIdno() {
			return idno;
		}

		public void setIdno(java.lang.String idno) {
			this.idno = idno;
		}

		public java.lang.String getOpenDate() {
			return openDate;
		}

		public void setOpenDate(java.lang.String openDate) {
			this.openDate = openDate;
		}

		public java.lang.String getCoreOpenDate() {
			return coreOpenDate;
		}

		public void setCoreOpenDate(java.lang.String coreOpenDate) {
			this.coreOpenDate = coreOpenDate;
		}

		public java.lang.String getCustStatus() {
			return custStatus;
		}

		public void setCustStatus(java.lang.String custStatus) {
			this.custStatus = custStatus;
		}

		/**
		 * @return the appliStatusDtl
		 */
		public java.lang.String getAppliStatusDtl() {
			return appliStatusDtl;
		}

		/**
		 * @param appliStatusDtl
		 *            the appliStatusDtl to set
		 */
		public void setAppliStatusDtl(java.lang.String appliStatusDtl) {
			this.appliStatusDtl = appliStatusDtl;
		}

		public java.lang.String getWarehouseNo() {
			return warehouseNo;
		}

		public void setWarehouseNo(java.lang.String warehouseNo) {
			this.warehouseNo = warehouseNo;
		}

		public java.lang.String getDebetId() {
			return debetId;
		}

		public void setDebetId(java.lang.String debetId) {
			this.debetId = debetId;
		}

		public java.lang.String getMastContno() {
			return mastContno;
		}

		public void setMastContno(java.lang.String mastContno) {
			this.mastContno = mastContno;
		}

		public java.lang.String getLnciType() {
			return lnciType;
		}

		public void setLnciType(java.lang.String lnciType) {
			this.lnciType = lnciType;
		}

		public java.lang.String getLnciStatus() {
			return lnciStatus;
		}

		public void setLnciStatus(java.lang.String lnciStatus) {
			this.lnciStatus = lnciStatus;
		}

		public java.math.BigDecimal getLnciAmt() {
			return lnciAmt;
		}

		public void setLnciAmt(java.math.BigDecimal lnciAmt) {
			this.lnciAmt = lnciAmt;
		}

		public java.math.BigDecimal getLnciBal() {
			return lnciBal;
		}

		public void setLnciBal(java.math.BigDecimal lnciBal) {
			this.lnciBal = lnciBal;
		}

		public java.lang.String getFivelevel() {
			return fivelevel;
		}

		public void setFivelevel(java.lang.String fivelevel) {
			this.fivelevel = fivelevel;
		}

		public java.util.Date getSignDate() {
			return signDate;
		}

		public void setSignDate(java.util.Date signDate) {
			this.signDate = signDate;
		}

		public java.util.Date getDueDate() {
			return dueDate;
		}

		public void setDueDate(java.util.Date dueDate) {
			this.dueDate = dueDate;
		}

		public java.math.BigDecimal getPcontAmount() {
			return pcontAmount;
		}

		public void setPcontAmount(java.math.BigDecimal pcontAmount) {
			this.pcontAmount = pcontAmount;
		}

		public java.math.BigDecimal getRepayBalamt() {
			return repayBalamt;
		}

		public void setRepayBalamt(java.math.BigDecimal repayBalamt) {
			this.repayBalamt = repayBalamt;
		}

		public java.lang.String getCustClass() {
			return custClass;
		}

		public void setCustClass(java.lang.String custClass) {
			this.custClass = custClass;
		}

		public java.lang.String getMgrno() {
			return mgrno;
		}

		public void setMgrno(java.lang.String mgrno) {
			this.mgrno = mgrno;
		}

		public java.math.BigDecimal getAmount() {
			return amount;
		}

		public void setAmount(java.math.BigDecimal amount) {
			this.amount = amount;
		}

		public java.math.BigDecimal getUserdAmount() {
			return userdAmount;
		}

		public void setUserdAmount(java.math.BigDecimal userdAmount) {
			this.userdAmount = userdAmount;
		}

		public java.lang.String getIndustryName() {
			return industryName;
		}

		public void setIndustryName(java.lang.String industryName) {
			this.industryName = industryName;
		}

		public java.lang.String getFeature1() {
			return feature1;
		}

		public void setFeature1(java.lang.String feature1) {
			this.feature1 = feature1;
		}

		public java.lang.String getFeature2() {
			return feature2;
		}

		public void setFeature2(java.lang.String feature2) {
			this.feature2 = feature2;
		}

		public java.lang.String getFeature3() {
			return feature3;
		}

		public void setFeature3(java.lang.String feature3) {
			this.feature3 = feature3;
		}

		public java.lang.String getFeature4() {
			return feature4;
		}

		public void setFeature4(java.lang.String feature4) {
			this.feature4 = feature4;
		}

		public java.lang.String getFeature5() {
			return feature5;
		}

		public void setFeature5(java.lang.String feature5) {
			this.feature5 = feature5;
		}

		public java.lang.String getFeature13() {
			return feature13;
		}

		public void setFeature13(java.lang.String feature13) {
			this.feature13 = feature13;
		}

		public java.lang.String getFeature15() {
			return feature15;
		}

		public void setFeature15(java.lang.String feature15) {
			this.feature15 = feature15;
		}

		public java.lang.String getFeature16() {
			return feature16;
		}

		public void setFeature16(java.lang.String feature16) {
			this.feature16 = feature16;
		}

		public java.lang.String getRegisterCapital() {
			return registerCapital;
		}

		public void setRegisterCapital(java.lang.String registerCapital) {
			this.registerCapital = registerCapital;
		}

		public java.lang.String getActualCapital() {
			return actualCapital;
		}

		public void setActualCapital(java.lang.String actualCapital) {
			this.actualCapital = actualCapital;
		}

		public java.lang.String getBuyerCustcd() {
			return buyerCustcd;
		}

		public void setBuyerCustcd(java.lang.String buyerCustcd) {
			this.buyerCustcd = buyerCustcd;
		}

		public java.lang.String getSellerCustcd() {
			return sellerCustcd;
		}

		public void setSellerCustcd(java.lang.String sellerCustcd) {
			this.sellerCustcd = sellerCustcd;
		}

		public java.lang.String getCoreCustcd() {
			return coreCustcd;
		}

		public void setCoreCustcd(java.lang.String coreCustcd) {
			this.coreCustcd = coreCustcd;
		}

		public java.lang.String getMoniCustcd() {
			return moniCustcd;
		}

		public void setMoniCustcd(java.lang.String moniCustcd) {
			this.moniCustcd = moniCustcd;
		}

		public java.lang.String getState() {
			return state;
		}

		public void setState(java.lang.String state) {
			this.state = state;
		}

		public java.lang.String getLastUpdateTlrcd() {
			return lastUpdateTlrcd;
		}

		public void setLastUpdateTlrcd(java.lang.String lastUpdateTlrcd) {
			this.lastUpdateTlrcd = lastUpdateTlrcd;
		}

		public java.util.Date getLastUpdateDate() {
			return lastUpdateDate;
		}

		public void setLastUpdateDate(java.util.Date lastUpdateDate) {
			this.lastUpdateDate = lastUpdateDate;
		}

		public java.lang.String getUsedType() {
			return usedType;
		}

		public void setUsedType(java.lang.String usedType) {
			this.usedType = usedType;
		}

		public java.lang.String getRelationId() {
			return relationId;
		}

		public void setRelationId(java.lang.String relationId) {
			this.relationId = relationId;
		}

		public java.math.BigDecimal getCreditAmount() {
			return creditAmount;
		}

		public void setCreditAmount(java.math.BigDecimal creditAmount) {
			this.creditAmount = creditAmount;
		}

		public java.math.BigDecimal getCreditUsableAmount() {
			return creditUsableAmount;
		}

		public void setCreditUsableAmount(java.math.BigDecimal creditUsableAmount) {
			this.creditUsableAmount = creditUsableAmount;
		}

		public java.lang.String getFrozenState() {
			return frozenState;
		}

		public void setFrozenState(java.lang.String frozenState) {
			this.frozenState = frozenState;
		}

		public java.lang.String getRecycle() {
			return recycle;
		}

		public void setRecycle(java.lang.String recycle) {
			this.recycle = recycle;
		}

		public java.lang.String getFjsellerCustno() {
			return fjsellerCustno;
		}

		public void setFjsellerCustno(java.lang.String fjsellerCustno) {
			this.fjsellerCustno = fjsellerCustno;
		}

		public java.lang.String getWhetherOpen() {
			return whetherOpen;
		}

		public void setWhetherOpen(java.lang.String whetherOpen) {
			this.whetherOpen = whetherOpen;
		}

		public java.lang.String getBelongOrg() {
			return belongOrg;
		}

		public void setBelongOrg(java.lang.String belongOrg) {
			this.belongOrg = belongOrg;
		}

		public java.util.Date getFirstpassed() {
			return firstpassed;
		}

		public void setFirstpassed(java.util.Date firstpassed) {
			this.firstpassed = firstpassed;
		}

		private boolean select = false;

		public boolean isSelect() {
			return select;
		}

		public void setSelect(boolean select) {
			this.select = select;
		}

		public java.lang.String getAccountName() {
			return accountName;
		}

		public void setAccountName(java.lang.String accountName) {
			this.accountName = accountName;
		}

		private String applyType;

		public String getApplyType() {
			return applyType;
		}

		public void setApplyType(String applyType) {
			this.applyType = applyType;
		}

		private String bussType;

		public String getBussType() {
			return bussType;
		}

		public void setBussType(String bussType) {
			this.bussType = bussType;
		}

		private java.util.Date commonDate;

		public java.util.Date getCommonDate() {
			return commonDate;
		}

		public void setCommonDate(java.util.Date commonDate) {
			this.commonDate = commonDate;
		}

		public java.lang.String getTlrName() {
			return tlrName;
		}

		public void setTlrName(java.lang.String tlrName) {
			this.tlrName = tlrName;
		}

		public java.math.BigDecimal getAccount() {
			return account;
		}

		public void setAccount(java.math.BigDecimal account) {
			this.account = account;
		}

		public java.lang.String getSrcfrom() {
			return srcfrom;
		}

		public void setSrcfrom(java.lang.String srcfrom) {
			this.srcfrom = srcfrom;
		}

		public java.lang.String getRelation() {
			return relation;
		}

		public void setRelation(java.lang.String relation) {
			this.relation = relation;
		}

		public java.lang.String getMail() {
			return mail;
		}

		public void setMail(java.lang.String mail) {
			this.mail = mail;
		}

		public java.lang.String getTlrno() {
			return tlrno;
		}

		public void setTlrno(java.lang.String tlrno) {
			this.tlrno = tlrno;
		}

		public java.lang.String getFirCd() {
			return firCd;
		}

		public void setFirCd(java.lang.String firCd) {
			this.firCd = firCd;
		}

		/**
		 * @return the relaType
		 */
		public java.lang.String getRelaType() {
			return relaType;
		}

		/**
		 * @param relaType
		 *            the relaType to set
		 */
		public void setRelaType(java.lang.String relaType) {
			this.relaType = relaType;
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

		public String getCreditFlag() {
			return creditFlag;
		}

		public void setCreditFlag(String creditFlag) {
			this.creditFlag = creditFlag;
		}

		public java.lang.String getOtherprotocolNo() {
			return otherprotocolNo;
		}

		public void setOtherprotocolNo(java.lang.String otherprotocolNo) {
			this.otherprotocolNo = otherprotocolNo;
		}

		public java.lang.Integer getReturnFlag() {
			return returnFlag;
		}

		public java.lang.String getBusinessScope() {
			return businessScope;
		}


		public void setReturnFlag(java.lang.Integer returnFlag) {
			this.returnFlag = returnFlag;
		}

		public void setBusinessScope(java.lang.String businessScope) {
			this.businessScope = businessScope;
		}

		public java.lang.String getIndustryOutlook() {
			return industryOutlook;
		}

		public void setIndustryOutlook(java.lang.String industryOutlook) {
			this.industryOutlook = industryOutlook;
		}

		public java.math.BigDecimal getEmployeeNumber() {
			return employeeNumber;
		}

		public void setEmployeeNumber(java.math.BigDecimal employeeNumber) {
			this.employeeNumber = employeeNumber;
		}

		public java.math.BigDecimal getTurnover() {
			return turnover;
		}

		public void setTurnover(java.math.BigDecimal turnover) {
			this.turnover = turnover;
		}

		public java.math.BigDecimal getBusinessDuration() {
			return businessDuration;
		}

		public void setBusinessDuration(java.math.BigDecimal businessDuration) {
			this.businessDuration = businessDuration;
		}

		public java.math.BigDecimal getAccountDuration() {
			return accountDuration;
		}

		public void setAccountDuration(java.math.BigDecimal accountDuration) {
			this.accountDuration = accountDuration;
		}

		public java.lang.String getArea() {
			return area;
		}

		public void setArea(java.lang.String area) {
			this.area = area;
		}

		public java.lang.String getBoundary() {
			return boundary;
		}

		public void setBoundary(java.lang.String boundary) {
			this.boundary = boundary;
		}

		public java.lang.String getCustLevel() {
			return custLevel;
		}

		public void setCustLevel(java.lang.String custLevel) {
			this.custLevel = custLevel;
		}

		public java.lang.String getWarehouseAddrType() {
			return warehouseAddrType;
		}

		public void setWarehouseAddrType(java.lang.String warehouseAddrType) {
			this.warehouseAddrType = warehouseAddrType;
		}

		public java.lang.String getChannelMode() {
			return channelMode;
		}

		public void setChannelMode(java.lang.String channelMode) {
			this.channelMode = channelMode;
		}

		public java.lang.String getBankCorporateMode() {
			return bankCorporateMode;
		}

		public void setBankCorporateMode(java.lang.String bankCorporateMode) {
			this.bankCorporateMode = bankCorporateMode;
		}

		public java.lang.String getLevels() {
			return levels;
		}

		public void setLevels(java.lang.String levels) {
			this.levels = levels;
		}

		public java.lang.String getCoreOrgCode() {
			return coreOrgCode;
		}

		public void setCoreOrgCode(java.lang.String coreOrgCode) {
			this.coreOrgCode = coreOrgCode;
		}

		public java.lang.String getCoreCustName() {
			return coreCustName;
		}

		public void setCoreCustName(java.lang.String coreCustName) {
			this.coreCustName = coreCustName;
		}

		public java.lang.String getCustName() {
			return custName;
		}

		public void setCustName(java.lang.String custName) {
			this.custName = custName;
		}

		public java.lang.String getRegCaptial() {
			return regCaptial;
		}

		public void setRegCaptial(java.lang.String regCaptial) {
			this.regCaptial = regCaptial;
		}

		public java.lang.String getBatchId() {
			return batchId;
		}

		public void setBatchId(java.lang.String batchId) {
			this.batchId = batchId;
		}

		public java.lang.String getNetProtocolNo() {
			return netProtocolNo;
		}

		public void setNetProtocolNo(java.lang.String netProtocolNo) {
			this.netProtocolNo = netProtocolNo;
		}

		public java.lang.String getLastUpdName() {
			return lastUpdName;
		}

		public void setLastUpdName(java.lang.String lastUpdName) {
			this.lastUpdName = lastUpdName;
		}

		public java.lang.String getNetworkName() {
			return networkName;
		}

		public void setNetworkName(java.lang.String networkName) {
			this.networkName = networkName;
		}

		public java.lang.String getNetProtocolCode() {
			return netProtocolCode;
		}

		public void setNetProtocolCode(java.lang.String netProtocolCode) {
			this.netProtocolCode = netProtocolCode;
		}

		public Integer getRegYear() {
			return regYear;
		}

		public void setRegYear(Integer regYear) {
			this.regYear = regYear;
		}

		public java.math.BigDecimal getTotalAssets() {
			return totalAssets;
		}

		public void setTotalAssets(java.math.BigDecimal totalAssets) {
			this.totalAssets = totalAssets;
		}

		public String getOrgSoundFlag() {
			return orgSoundFlag;
		}

		public void setOrgSoundFlag(String orgSoundFlag) {
			this.orgSoundFlag = orgSoundFlag;
		}

		public String getManagementFlag() {
			return managementFlag;
		}

		public void setManagementFlag(String managementFlag) {
			this.managementFlag = managementFlag;
		}

		public String getRiskControlFlag() {
			return riskControlFlag;
		}

		public void setRiskControlFlag(String riskControlFlag) {
			this.riskControlFlag = riskControlFlag;
		}

		public Integer getBadRecord() {
			return badRecord;
		}

		public void setBadRecord(Integer badRecord) {
			this.badRecord = badRecord;
		}

		public Integer getCycleDays() {
			return cycleDays;
		}

		public void setCycleDays(Integer cycleDays) {
			this.cycleDays = cycleDays;
		}

		public Integer getCoperateYear() {
			return coperateYear;
		}

		public void setCoperateYear(Integer coperateYear) {
			this.coperateYear = coperateYear;
		}

		public Integer getCoperateTimes() {
			return coperateTimes;
		}

		public void setCoperateTimes(Integer coperateTimes) {
			this.coperateTimes = coperateTimes;
		}

		public java.math.BigDecimal getTradeAmount() {
			return tradeAmount;
		}

		public void setTradeAmount(java.math.BigDecimal tradeAmount) {
			this.tradeAmount = tradeAmount;
		}

		public java.math.BigDecimal getTradePercent() {
			return tradePercent;
		}

		public void setTradePercent(java.math.BigDecimal tradePercent) {
			this.tradePercent = tradePercent;
		}

		public java.math.BigDecimal getLastYearPercent() {
			return lastYearPercent;
		}

		public void setLastYearPercent(java.math.BigDecimal lastYearPercent) {
			this.lastYearPercent = lastYearPercent;
		}

		public java.lang.String getCoreLevel() {
			return coreLevel;
		}

		public void setCoreLevel(java.lang.String coreLevel) {
			this.coreLevel = coreLevel;
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

		public java.lang.String getMonitorArea() {
			return monitorArea;
		}

		public void setMonitorArea(java.lang.String monitorArea) {
			this.monitorArea = monitorArea;
		}

		public java.lang.String getDetailMonitorArea() {
			return detailMonitorArea;
		}

		public void setDetailMonitorArea(java.lang.String detailMonitorArea) {
			this.detailMonitorArea = detailMonitorArea;
		}

		public java.util.Date getLevelCogniDate() {
			return levelCogniDate;
		}

		public void setLevelCogniDate(java.util.Date levelCogniDate) {
			this.levelCogniDate = levelCogniDate;
		}

		public java.util.Date getLevelEndDate() {
			return levelEndDate;
		}

		public void setLevelEndDate(java.util.Date levelEndDate) {
			this.levelEndDate = levelEndDate;
		}

		public java.lang.String getMonitorStatus() {
			return monitorStatus;
		}

		public void setMonitorStatus(java.lang.String monitorStatus) {
			this.monitorStatus = monitorStatus;
		}

		public java.lang.String getSupplyPosition() {
			return supplyPosition;
		}

		public void setSupplyPosition(java.lang.String supplyPosition) {
			this.supplyPosition = supplyPosition;
		}

		public String getIsMarketCorp() {
			return isMarketCorp;
		}

		public void setIsMarketCorp(String isMarketCorp) {
			this.isMarketCorp = isMarketCorp;
		}

		public String getImportantFlag() {
			return importantFlag;
		}

		public void setImportantFlag(String importantFlag) {
			this.importantFlag = importantFlag;
		}

		public String getCommercialFlag() {
			return commercialFlag;
		}

		public void setCommercialFlag(String commercialFlag) {
			this.commercialFlag = commercialFlag;
		}

		public java.lang.String getEstablishDate() {
			return establishDate;
		}

		public void setEstablishDate(java.lang.String establishDate) {
			this.establishDate = establishDate;
		}

		public String getCcmsCustcd() {
			return ccmsCustcd;
		}

		public void setCcmsCustcd(String ccmsCustcd) {
			this.ccmsCustcd = ccmsCustcd;
		}

		public String getFciCode() {
			return fciCode;
		}

		public void setFciCode(String fciCode) {
			this.fciCode = fciCode;
		}

		public String getIsBank() {
			return isBank;
		}

		public void setIsBank(String isBank) {
			this.isBank = isBank;
		}

		public java.lang.String getEmail() {
			return email;
		}

		public void setEmail(java.lang.String email) {
			this.email = email;
		}

		public String getIsIntl() {
			return isIntl;
		}

		public void setIsIntl(String isIntl) {
			this.isIntl = isIntl;
		}

		public String getIndustryTypeName() {
			return industryTypeName;
		}

		public void setIndustryTypeName(String industryTypeName) {
			this.industryTypeName = industryTypeName;
		}

		

}

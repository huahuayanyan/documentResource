package com.huateng.scf.bas.mrn.vo;

/*
 * 功  能：通用查询VO
 * 文件名：CommonQueryVo.java
 * 描  述：
 * [变更履历
 * Version   变更日         部署              作者           变更内容
 * -----------------------------------------------------------------------------
 * V1.00     2010-11-11    huateng        lin_junyun        create
 * -----------------------------------------------------------------------------
 * Copyright (c) 2010 huateng  All Rights Reserved.
 */


import java.math.BigDecimal;

/**
 * @deprecated
 * 通用查询VO,用于前台查询条件的传输
 * <p>
 * <a href="CommonQueryVo.java.html"><i>View Source</i></a>
 * </p>
 * @author <a href="mailto:lin_junyun@huateng.com">lin_junyun</a>
 * @version Revision: 1.0  Date: 2010-11-11 上午09:43:38
 */

public class OldCommonQueryVO {

	// Constructor
	public OldCommonQueryVO() {}

	private int pageSize = 10;	// 每页记录数(分页用)

	private int pageIndex = 1;	// 页数(分页用)

	private String startDate_Q; //起始日期
	private String stratDate_Q; //起始日期

	private String endDate_Q; //截止日期

	private String contractID_Q; //合同号

	private String mastContno_Q; //主合同编号

	private String mastContCode_Q; //主合同编号

	private String tradeContno_Q; //贸易合同号 数字主键

	private String tradeContcode_Q; //贸易合同号 字符

	private String slaveContno_Q; //从合同编号

	private String accType_Q; //合同类型

	private String custcd_Q; //客户号

	private String mortgageBizType;

	private String cname_Q; //客户名称

	private String secCname_Q; //卖方客户名称

	private String actBrcode_Q;//客户开户行号

	private String actNo_Q;//客户开户行号

	private String regAddr_Q;//地址

	private String accountNo;//客户帐号

	private String accountName;//账户名称

	private String custIdType_Q; //客户证件类型

	private String custIdNo_Q; //客户证件号码

	private String orgCode_Q; //组织机构代码

	private String finacNetName_Q; //网络名称

	private String coreCompName_Q; //核心客户名称

	private String supplyChainProduct_Q; //供应链产品

	private String cepName_Q; //授信产品

	private String lastStockDate_Q; //上次盘库日

	private String storageWarehouse_Q; //仓库

	private String storageComp_Q; //监管公司

    private String storageCompAddr_Q;//监管公司地址

	private String contractNo_Q; //合同号

	private String contractDate_Q; //签订日期

	private String storagePerson_Q; //经办人

	private String num_Q;

	private String dealerCustcd_Q; //经销商客户号

	private String dealerCname_Q; //经销商

	private java.lang.String appno_Q;	// 申请编号
	private java.lang.String taskName_Q;
	private java.lang.String nodeType_Q;
	private String orgName_Q; //机构名称
	private String user_Q;  //用户
    private String suppChainPdType_Q; //供应链产品类型
	private String beginDate_Q; // 开始时期

	private java.lang.String bigGageClass_Q;	// 押品大类号

	private java.lang.String smallGageClass_Q;	// 押品小类号

	private java.lang.String mortgageMaketPriceID_Q;	// 押品市价表ID

	private java.lang.String mortgageModel_Q;	// 押品规格编号

	private String signDate_Q; //签约日期

	private String mortgageClass_Q; //押品打类编号

	private String mortgageClassNo_Q; //押品小类编号

	private String chargeTypeNm_Q; //大类名称

	private String storOrDeli_Q; //出入库类型

	private String storDeliBizType_Q; //出入库业务类型

	private String flag_Q; //标识

	private String custOfTlrType_Q; //我的客户类型

	private String billId;

	private String billId_Q;

	private String aliasName_Q; //客户别名

	private String supplyChainPdId_Q;	// 供应链产品PK

	private String financingType_Q;	// 融资方式（授信品种）PK

	private String netNo_Q; //网络号

	private String debetNo_Q; //借据号
	private String debetId_Q; //借据号

	private String lnciType_Q; //借据类型

	private String lnciStatus_Q; //借据状态

	private String id_Q; //PK

	private String contractType_Q;


	private String appliStatusDtl_Q; //申请状态

	private String suppProductName_Q;

	private String appliMortBizType_Q; // 申请业务押品清单业务类型

	private int flag;

	private String exchangeStatus;//置换状态（仓单）

	private String brcode_Q;//机构号

	// ADD BY GUIXIU.LIU 20110322
	private String brName_Q;//机构名称

	private String oprcode_Q;//操作员号

	private String mortgageNo_Q; //押品编号

	private String fluctuation_Q; //波动率

	private Integer srvNetId;	// 网络号

	private String unrepayTime_Q;//未还款时间

	private String netProtocolNo_Q; // 网络主协议号

	private String netProtocolSubNo_Q; // 网络从协议号

	private String netName_Q;	// 网络名称

	private String coreCname_Q;	// 核心客户名称

	private String selectType_Q; // 查询类型

	private String dataName_Q; // 查询数据名字

	private String analyzeType_Q;	// 额度分析类性格

	private String billno_Q; //仓单编号
	private String billCode_Q; //仓单编号

	private String state_Q;	// 分析状态

	private String warehouseNo;	// 分析状态

	private String modelType_Q;	// 模型类型

	private String term_Q;	// 期数

	private String termType_Q;	// 期数类型

	private String appType_Q;  //类型

	private String warnDueType_Q;//到期预警类型

	private String ProtocolType_Q;//合同申请的协议类型

	/*added by Huaidong.Li Time 2011-3-21 19:18*/
	private String roleName_Q;//角色名

	private String effectDate_Q;//生效日期

	private String expireDate_Q;//失效日期
	/*added by Huaidong.Li Time 2011-3-21 19:18*/

	private String infoPublishId_Q;//发布信息编号
	/*added by DuJianFei Time 2011-4-11 19:18*/

	private String fileClass;//发布信息类别
	/*added by DuJianFei Time 2011-4-11 19:18*/

	private String fileType;//上传文件分类

	private String filePro;//发布信息附件关联号
	/*added by DuJianFei Time 2011-4-18 12:18*/

	private String fileFlag;//发布信息附件关联号
	/*added by DuJianFei Time 2011-4-18 13:18*/

	private java.sql.Timestamp uploadTime;
	/*added by DuJianFei Time 2011-4-16 19:18*/

	//ADD BY LIUGUIXIU  2011-04-12 18:02
	private String dealStatus_Q;//处理状态
	private String moniOfCustcd;//监管公司客户号
	private String netProtocolCode;

	private String batchId_Q;//核库批次号
	private String checkStockResults_Q;//核库结果
	private String checkStockDate_Q;//核库日期

	private String appliType;//申请类型

	private String moniType_Q;//监管类型

	//add by hui.liu 2011-05-05
	private String noticeType_Q; //通知书类型
	private String noticeName_Q; //通知书类型
	private String notictNo_Q;
	private String mortgageType_Q; //货物类型
	private String monitorProtocolNo_Q; //监管协议号
	private String pid_Q;
	private String results_Q;
	private String subContno_Q;
	private String bailType_Q;
	//add by lan.mingzhao 2011-06-22
	private String slaveContcode_Q;
	//added by huaidong.li 2011-6-8
	private String procName_Q;//流程名

	private String bussType;//
	private String dataNo_Q;
	private String type_Q;
	private String checkStockWay_Q;//对账方式
	private String mortgageCode;
	private String mortgageName;
	private String parentCode;
	private String level;

	private String brcodes;//机构集，要求格式为9999,1111/0221

	private String moniWarehouseType_Q;//是否独立三方
	private String secCd_Q;//客户号
	private String thrCd_Q;//监管公司客户号

	private String value;//下拉框筛选值
	private String exchangeName;//交易所
	private String productId_Q;//产品Id
	private String productType_Q;//产品类型
	private String midProductId_Q;//产品Id

	//add by dujianfei 2011-08-13
	private String storeName_Q;//门店名称
	private String custCdName_Q;//供应商名称
	private java.util.Date publishDate;//日期
	private java.util.Date publishDate1;//备用日期
	private String cnameSeller_Q;//卖方企业名称
	private String cnameBuyer_Q;//买方企业名称

	//add by dujianfei 2011-08-14
	private String loanProductCode_Q;//贷款产品代码
	private String brname_Q;//银行名称

	private String gebtId_Q;//还款ID
	private String tatdId_Q;//还款ID
	private String tatdeId_Q;//还款ID
	private String custRole;//客户 角色---应收账款用
	private String sellerName;//卖方客户名称
	private String buyerName;//买方客户名称
	private String debtAppno_Q;//贷款申请编码

	private String custcdSaller_Q;//卖方客户号
	private String custcdBuyer_Q; //买方客户号
	private String debtId_Q;//结算单号

	private String relaType_Q;//保理买方卖方关系维护类型

	//add by zhaoyang.lv 2011-08-24
	private String industryName_Q;//行业类型
	private String mgrNO_Q;//管护员
	private String mainBussiness_Q;//主营业务
	private String status_Q;
	private String custType_Q;//客户特征
	private String belongOrg_Q;//所属机构
	private String monitortype_Q;//监管模式
	private String tlrcd_Q;//操作员
	private java.lang.String lastUpdTlrcd_Q;//最近操作员
	private java.lang.String billsNo_Q;//发票编号
	private java.lang.String billsPeriod;//账期
	private java.lang.String billsType_Q;//单据类型
	private java.lang.String noticeId;//通知书编号
	private java.lang.String chReportNo;

	private java.lang.String returnStatus_Q;
	private String bussTypeName_Q;//业务品种名称
	private String recoverType_Q;//业务类型
	private String calcRateType_Q;//计息方式

	private String billsAmount1_Q; // 发票金额
	private String billsAmount2_Q; // 发票金额

	private String payType;//还款方式
	private String isInSeller;//尾款是否划入卖方结算户
	private String payAmount;//还款金额
	private String issueFlag;//商纠状态
	private String warningType;//预警方式
	private String loanWay_Q;//出账方式
	private String warnLevel;//预警等级

	private String debtNo_Q; //票据编号

	private java.math.BigDecimal firstBailRatio_Q;
	private java.lang.String firstBailType_Q;
	private java.lang.String coreAccount_Q;
	private java.lang.String bailAccount_Q;
	private java.lang.String balanceAccount_Q;

	private String contType_Q;//合同类型
	private String custClass;//客户类型
	private String curcd;
	private String intratecdName;
	private String mortgageLevelThreeName_Q;//押品三级名称
    private String productName_Q;//盯市产品名称
    private String mortgageLevelOne_Q;
    private String mortgageLevelTwo_Q;
    private String mortgageLevelThree_Q;
    private java.util.Date txdate_Q;
    private String processTemplateName_Q;
    private String appliStatus_Q;
    private String brClass_Q;//机构级别
    private String ruleNo_Q;//规则引擎
    private String returnMethod_Q;//还款方式

    //信用证：
    private String lcno_Q;//信用证号码
    private String fid_Q;//来单批次号
    private String lccode_Q;//信用证编号
    private String branch_Q;//信用证分支
    private String applyDate_Q;//来单日期
    private String totAmt_Q;//单据金额
    private String Serialno_Q;//通知书中来单编号
    private String bankFlag_Q;//银行标识
    private String networkName;//网络名称
    private String isUnmatch;//是否含有不符点
    private String LCID;
    private String ext1; //押品还款状态
    private String processStatus_Q;//信用证状态

	private String collFlag;//委托收款
    private String negotiationFlag;//议付

    private String payStatus_Q;//付款状态
    private String engineNo_Q;//发动机号
    private String chassisNo_Q;//车架号
    private String billDueDate_Q;//出厂日期

    private String title;//标题
    private String content;//内容
    private String authorTlrno;//授权操作员编号
    private java.util.Date infoDeleteDate;//删除日期
    private String infoDelTlrno;//删除操作员编号
    private String protocolText;//协议内容
    private String state;//状态
    private String arrivedManageMode_Q;//状态


	private java.lang.String brcode;
	private java.lang.String intratecd;
	private java.util.Date effectDate;
	private java.util.Date expireDate;
	private java.lang.String term;
	private java.lang.String unit;
	private java.math.BigDecimal intrate;
	private java.math.BigDecimal yrIntrate;
	private java.lang.String cnfNo;
	private java.lang.String sts;
	private java.util.Date updDt;
	private java.lang.String updTlr;

    //费用参数
    private String costCode_Q;//费用代码
    private String costName_Q;//费用名称
    private String costClassId_Q;//允许收取种类ID
    private String costClassName_Q; //允许收取种类名称
    private String costTypeId_Q;//允许收取方式
    private String costTypeName_Q;//保理手续费 收取方式 第1位-先收；第2位-后收；第3位-免收
    private String costPhaseId_Q;//费用收取阶段Id
    private String costPhaseName_Q;//费用收取阶段名称
    private String costCalcTypeId_Q;//允许计算方式
    private String costCalcTypeName_Q;//保理手续费 计算方式  第1位-固定；第2位-按比率
    private String chargeTypeId_Q;//允许扣取方式
    private String chargeTypeName_Q;//融资手续费 扣取方式  第1位-固定；第2位-按比率
    private String costDesc;//费用说明
    private java.math.BigDecimal minRate;//允许最小利率
    private java.math.BigDecimal maxRate;//允许最大利率
    private String costInfoId_Q;//费用基本表ID
    private String relaNo_Q;//关联合同/协议号

    private String coreOrgCode_Q;//核心企业组织机构代码

    private String MarketPriceSrc;//押品市价来源

    private String moniProtocolType;//监管协议类型

    private String billcode_Q;//仓单编号

    private String warnStatus_Q;

    private String fluctuation1_Q;//价格波动率从

    private String fluctuation2_Q;//价格波动率到

    private String contactName_Q;//联系人

    private String marketPriceSrc_Q;//押品市价来源

	private String factType;// 保理业务类型 1 国内保理，2 国际保理，3 反向保理

	private String rateNo_Q;//利率代码

	private String mortgageThreeName_Q;//
	private String warehouseType_Q;//产品类型

	private String inspectReportNo_Q;//巡库编号
	private String checkReprotNo_Q;//核库编号
	private String isSettle_Q;//是否结清
	public String getMarketPriceSrc() {
		return MarketPriceSrc;
	}

	public void setMarketPriceSrc(String marketPriceSrc) {
		MarketPriceSrc = marketPriceSrc;
	}

	public String getCoreOrgCode_Q() {
		return coreOrgCode_Q;
	}

	public void setCoreOrgCode_Q(String coreOrgCode_Q) {
		this.coreOrgCode_Q = coreOrgCode_Q;
	}

	public String getCostDesc() {
		return costDesc;
	}

	public void setCostDesc(String costDesc) {
		this.costDesc = costDesc;
	}

	public java.math.BigDecimal getMinRate() {
		return minRate;
	}

	public void setMinRate(java.math.BigDecimal minRate) {
		this.minRate = minRate;
	}

	public java.math.BigDecimal getMaxRate() {
		return maxRate;
	}

	public void setMaxRate(java.math.BigDecimal maxRate) {
		this.maxRate = maxRate;
	}

	public String getCostCode_Q() {
		return costCode_Q;
	}

	public void setCostCode_Q(String costCode_Q) {
		this.costCode_Q = costCode_Q;
	}

	public String getCostName_Q() {
		return costName_Q;
	}

	public void setCostName_Q(String costName_Q) {
		this.costName_Q = costName_Q;
	}

	// fields
	private java.lang.String intNm;
	private java.lang.String intExp;
	private java.lang.String intType;
	private java.lang.String intYmd;

	private java.lang.String ruleNo;
    private String role_Q;//协议参与者角色
	//币别维护 add by shuidan.huang 2012.07.27
	private String curcd_Q;//币别代码
	private String curCname_Q;//币别中文名称
	private String curEname_Q;//币别英文名称
	//国家维护 add by shuidan.huang 2012.07.30
	private String counCode_Q;//国家代码
	private String counCname_Q;//国家中文名称
	private String counEname_Q;//国家英文名称
	private String counBriefCname_Q;//中文简称
	private String counBriefEname_Q;//英文简称
	private String creitClass_Q;

	public java.lang.String getRuleNo() {
		return ruleNo;
	}

	public void setRuleNo(java.lang.String ruleNo) {
		this.ruleNo = ruleNo;
	}

	public java.lang.String getRuleName() {
		return ruleName;
	}

	public void setRuleName(java.lang.String ruleName) {
		this.ruleName = ruleName;
	}

	public java.lang.String getRuleRelation() {
		return ruleRelation;
	}

	public void setRuleRelation(java.lang.String ruleRelation) {
		this.ruleRelation = ruleRelation;
	}

	public java.lang.String getRuleValue() {
		return ruleValue;
	}

	public void setRuleValue(java.lang.String ruleValue) {
		this.ruleValue = ruleValue;
	}

	public java.lang.String getRuleStatus() {
		return ruleStatus;
	}

	public void setRuleStatus(java.lang.String ruleStatus) {
		this.ruleStatus = ruleStatus;
	}

	public java.lang.String getRuleType() {
		return ruleType;
	}

	public void setRuleType(java.lang.String ruleType) {
		this.ruleType = ruleType;
	}

	public java.lang.String getRecordTlrcd() {
		return recordTlrcd;
	}

	public void setRecordTlrcd(java.lang.String recordTlrcd) {
		this.recordTlrcd = recordTlrcd;
	}

	public java.util.Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(java.util.Date recordDate) {
		this.recordDate = recordDate;
	}

	public java.lang.String getSupplyChainPdId() {
		return supplyChainPdId;
	}

	public void setSupplyChainPdId(java.lang.String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}

	public java.lang.String getExt2() {
		return ext2;
	}

	public void setExt2(java.lang.String ext2) {
		this.ext2 = ext2;
	}

	public java.lang.String getExt3() {
		return ext3;
	}

	public void setExt3(java.lang.String ext3) {
		this.ext3 = ext3;
	}

	private java.lang.String ruleName;
	private java.lang.String ruleRelation;
	private java.lang.String ruleValue;
	private java.lang.String ruleStatus;
	private java.lang.String ruleType;
	private java.lang.String recordTlrcd;
	private java.util.Date recordDate;
	private java.lang.String supplyChainPdId;
	private java.lang.String ext2;
	private java.lang.String ext3;
	private java.lang.String parentId_Q;


	public java.lang.String getIntNm() {
		return intNm;
	}

	public void setIntNm(java.lang.String intNm) {
		this.intNm = intNm;
	}

	public java.lang.String getIntExp() {
		return intExp;
	}

	public void setIntExp(java.lang.String intExp) {
		this.intExp = intExp;
	}

	public java.lang.String getIntType() {
		return intType;
	}

	public void setIntType(java.lang.String intType) {
		this.intType = intType;
	}

	public java.lang.String getIntYmd() {
		return intYmd;
	}

	public void setIntYmd(java.lang.String intYmd) {
		this.intYmd = intYmd;
	}

	public java.lang.String getBrcode() {
		return brcode;
	}

	public void setBrcode(java.lang.String brcode) {
		this.brcode = brcode;
	}

	public java.lang.String getIntratecd() {
		return intratecd;
	}

	public void setIntratecd(java.lang.String intratecd) {
		this.intratecd = intratecd;
	}

	public java.util.Date getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(java.util.Date effectDate) {
		this.effectDate = effectDate;
	}

	public java.util.Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(java.util.Date expireDate) {
		this.expireDate = expireDate;
	}

	public java.lang.String getTerm() {
		return term;
	}

	public void setTerm(java.lang.String term) {
		this.term = term;
	}

	public java.lang.String getUnit() {
		return unit;
	}

	public void setUnit(java.lang.String unit) {
		this.unit = unit;
	}

	public java.math.BigDecimal getIntrate() {
		return intrate;
	}

	public void setIntrate(java.math.BigDecimal intrate) {
		this.intrate = intrate;
	}

	public java.math.BigDecimal getYrIntrate() {
		return yrIntrate;
	}

	public void setYrIntrate(java.math.BigDecimal yrIntrate) {
		this.yrIntrate = yrIntrate;
	}

	public java.lang.String getCnfNo() {
		return cnfNo;
	}

	public void setCnfNo(java.lang.String cnfNo) {
		this.cnfNo = cnfNo;
	}

	public java.lang.String getSts() {
		return sts;
	}

	public void setSts(java.lang.String sts) {
		this.sts = sts;
	}

	public java.util.Date getUpdDt() {
		return updDt;
	}

	public void setUpdDt(java.util.Date updDt) {
		this.updDt = updDt;
	}

	public java.lang.String getUpdTlr() {
		return updTlr;
	}

	public void setUpdTlr(java.lang.String updTlr) {
		this.updTlr = updTlr;
	}

	public String getProcessStatus_Q() {
		return processStatus_Q;
	}

	public void setProcessStatus_Q(String processStatusQ) {
		processStatus_Q = processStatusQ;
	}
	public String getEngineNo_Q() {
		return engineNo_Q;
	}

	public void setEngineNo_Q(String engineNo_Q) {
		this.engineNo_Q = engineNo_Q;
	}

	public String getChassisNo_Q() {
		return chassisNo_Q;
	}

	public void setChassisNo_Q(String chassisNo_Q) {
		this.chassisNo_Q = chassisNo_Q;
	}

	public String getBillDueDate_Q() {
		return billDueDate_Q;
	}

	public void setBillDueDate_Q(String billDueDate_Q) {
		this.billDueDate_Q = billDueDate_Q;
	}

	public String getCollFlag() {
		return collFlag;
	}

	public void setCollFlag(String collFlag) {
		this.collFlag = collFlag;
	}

	public String getNegotiationFlag() {
		return negotiationFlag;
	}

	public void setNegotiationFlag(String negotiationFlag) {
		this.negotiationFlag = negotiationFlag;
	}

	public String getLCID() {
		return LCID;
	}

	public void setLCID(String lcid) {
		LCID = lcid;
	}

	//汽车金融
    private String networkName_Q;
    private String netProtocolCode_Q;
    private String netProtocolSubCode_Q;
    private String loanWayNm_Q;
	public String getNetworkName_Q() {
		return networkName_Q;
	}

	public void setNetworkName_Q(String networkNameQ) {
		networkName_Q = networkNameQ;
	}

	public String getNetProtocolCode_Q() {
		return netProtocolCode_Q;
	}

	public void setNetProtocolCode_Q(String netProtocolCodeQ) {
		netProtocolCode_Q = netProtocolCodeQ;
	}

	public String getNetProtocolSubCode_Q() {
		return netProtocolSubCode_Q;
	}

	public void setNetProtocolSubCode_Q(String netProtocolSubCodeQ) {
		netProtocolSubCode_Q = netProtocolSubCodeQ;
	}

	public String getLoanWayNm_Q() {
		return loanWayNm_Q;
	}

	public void setLoanWayNm_Q(String loanWayNmQ) {
		loanWayNm_Q = loanWayNmQ;
	}

	public String getNetworkName() {
		return networkName;
	}

	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	public String getContType_Q() {
		return contType_Q;
	}
	public void setContType_Q(String contTypeQ) {
		contType_Q = contTypeQ;
	}

	public String getWarningType() {
		return warningType;
	}

	public void setWarningType(String warningType) {
		this.warningType = warningType;
	}

	public String getIssueFlag() {
		return issueFlag;
	}
	public void setIssueFlag(String issueFlag) {
		this.issueFlag = issueFlag;
	}
	public String getBillsAmount1_Q() {
		return billsAmount1_Q;
	}

	public void setBillsAmount1_Q(String billsAmount1_Q) {
		this.billsAmount1_Q = billsAmount1_Q;
	}

	public String getRecoverType_Q() {
		return recoverType_Q;
	}

	public void setRecoverType_Q(String recoverTypeQ) {
		recoverType_Q = recoverTypeQ;
	}

	public String getCalcRateType_Q() {
		return calcRateType_Q;
	}

	public void setCalcRateType_Q(String calcRateTypeQ) {
		calcRateType_Q = calcRateTypeQ;
	}

	public java.lang.String getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(java.lang.String noticeId) {
		this.noticeId = noticeId;
	}
	private java.lang.String sellerCustcd_Q;
	private java.lang.String buyerCustcd_Q;
	private java.lang.String limitNumber;
	private java.lang.String creditType_Q;
	private java.lang.String flawFlag_Q;
	private java.lang.String overdueFlag_Q;
	private java.lang.String badFlag_Q;

	private java.lang.String creditClass_Q;

	private java.lang.String swiftType_Q;

	public java.lang.String getSwiftType_Q() {
		return swiftType_Q;
	}

	public void setSwiftType_Q(java.lang.String swiftTypeQ) {
		swiftType_Q = swiftTypeQ;
	}

	public java.lang.String getSellerCustcd_Q() {
		return sellerCustcd_Q;
	}

	public void setSellerCustcd_Q(java.lang.String sellerCustcdQ) {
		sellerCustcd_Q = sellerCustcdQ;
	}

	public java.lang.String getBuyerCustcd_Q() {
		return buyerCustcd_Q;
	}

	public void setBuyerCustcd_Q(java.lang.String buyerCustcdQ) {
		buyerCustcd_Q = buyerCustcdQ;
	}

	public java.lang.String getLimitNumber() {
		return limitNumber;
	}

	public java.lang.String getFlawFlag_Q() {
		return flawFlag_Q;
	}

	public void setFlawFlag_Q(java.lang.String flawFlag_Q) {
		this.flawFlag_Q = flawFlag_Q;
	}

	public java.lang.String getOverdueFlag_Q() {
		return overdueFlag_Q;
	}

	public void setOverdueFlag_Q(java.lang.String overdueFlag_Q) {
		this.overdueFlag_Q = overdueFlag_Q;
	}

	public java.lang.String getBadFlag_Q() {
		return badFlag_Q;
	}

	public void setBadFlag_Q(java.lang.String badFlag_Q) {
		this.badFlag_Q = badFlag_Q;
	}

	public void setLimitNumber(java.lang.String limitNumber) {
		this.limitNumber = limitNumber;
	}

	public java.lang.String getCreditType_Q() {
		return creditType_Q;
	}

	public void setCreditType_Q(java.lang.String creditTypeQ) {
		creditType_Q = creditTypeQ;
	}
	public java.lang.String getLastUpdTlrcd_Q() {
		return lastUpdTlrcd_Q;
	}

	public void setLastUpdTlrcd_Q(java.lang.String lastUpdTlrcd_Q) {
		this.lastUpdTlrcd_Q = lastUpdTlrcd_Q;
	}

	public String getMonitortype_Q() {
		return monitortype_Q;
	}

	public void setMonitortype_Q(String monitortype_Q) {
		this.monitortype_Q = monitortype_Q;
	}

	public String getTlrcd_Q() {
		return tlrcd_Q;
	}

	public void setTlrcd_Q(String tlrcd_Q) {
		this.tlrcd_Q = tlrcd_Q;
	}

	public String getStatus_Q() {
		return status_Q;
	}

	public String getCustType_Q() {
		return custType_Q;
	}

	public void setCustType_Q(String custType_Q) {
		this.custType_Q = custType_Q;
	}

	public String getBelongOrg_Q() {
		return belongOrg_Q;
	}

	public void setBelongOrg_Q(String belongOrg_Q) {
		this.belongOrg_Q = belongOrg_Q;
	}

	public void setStatus_Q(String status_Q) {
		this.status_Q = status_Q;
	}

	public String getMainBussiness_Q() {
		return mainBussiness_Q;
	}

	public void setMainBussiness_Q(String mainBussiness_Q) {
		this.mainBussiness_Q = mainBussiness_Q;
	}

	public String getMgrNO_Q() {
		return mgrNO_Q;
	}

	public void setMgrNO_Q(String mgrNO_Q) {
		this.mgrNO_Q = mgrNO_Q;
	}

	public String getIndustryName_Q() {
		return industryName_Q;
	}

	public void setIndustryName_Q(String industryName_Q) {
		this.industryName_Q = industryName_Q;
	}


	public String getDebtId_Q() {
		return debtId_Q;
	}

	public void setDebtId_Q(String debtIdQ) {
		debtId_Q = debtIdQ;
	}

	public String getDebtAppno_Q() {
		return debtAppno_Q;
	}
	public void setDebtAppno_Q(String debtAppnoQ) {
		debtAppno_Q = debtAppnoQ;
	}
	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getCustRole() {
		return custRole;
	}

	public void setCustRole(String custRole) {
		this.custRole = custRole;
	}

	public String getTatdId_Q() {
		return tatdId_Q;
	}

	public void setTatdId_Q(String tatdId_Q) {
		this.tatdId_Q = tatdId_Q;
	}

	public String getTatdeId_Q() {
		return tatdeId_Q;
	}

	public void setTatdeId_Q(String tatdeId_Q) {
		this.tatdeId_Q = tatdeId_Q;
	}

	public String getGebtId_Q() {
		return gebtId_Q;
	}

	public void setGebtId_Q(String gebtId_Q) {
		this.gebtId_Q = gebtId_Q;
	}

	public String getProcName_Q() {
		return procName_Q;
	}

	public void setProcName_Q(String procName_Q) {
		this.procName_Q = procName_Q;
	}

	public String getCheckStockResults_Q() {
		return checkStockResults_Q;
	}

	public void setCheckStockResults_Q(String checkStockResults_Q) {
		this.checkStockResults_Q = checkStockResults_Q;
	}


	public String getAppliType() {
		return appliType;
	}

	public void setAppliType(String appliType) {
		this.appliType = appliType;
	}


	public String getDealStatus_Q() {
		return dealStatus_Q;
	}

	public void setDealStatus_Q(String dealStatus_Q) {
		this.dealStatus_Q = dealStatus_Q;
	}

	public String getFileClass() {
		return fileClass;
	}

	public void setFileClass(String fileClass) {
		this.fileClass = fileClass;
	}

	public String getRoleName_Q() {
		return roleName_Q;
	}

	public void setRoleName_Q(String roleName_Q) {
		this.roleName_Q = roleName_Q;
	}

	public String getEffectDate_Q() {
		return effectDate_Q;
	}

	public void setEffectDate_Q(String effectDate_Q) {
		this.effectDate_Q = effectDate_Q;
	}

	public String getExpireDate_Q() {
		return expireDate_Q;
	}

	public void setExpireDate_Q(String expireDate_Q) {
		this.expireDate_Q = expireDate_Q;
	}

	public String getProtocolType_Q() {
		return ProtocolType_Q;
	}

	public void setProtocolType_Q(String protocolType_Q) {
		ProtocolType_Q = protocolType_Q;
	}

	public String getWarnDueType_Q() {
		return warnDueType_Q;
	}

	public void setWarnDueType_Q(String warnDueType_Q) {
		this.warnDueType_Q = warnDueType_Q;
	}

	public String getAppType_Q() {
		return appType_Q;
	}

	public void setAppType_Q(String appType_Q) {
		this.appType_Q = appType_Q;
	}

	private String warehouseReceiptId_Q;//仓单ID

	public String getWarehouseReceiptId_Q() {
		return warehouseReceiptId_Q;
	}

	public void setWarehouseReceiptId_Q(String warehouseReceiptId_Q) {
		this.warehouseReceiptId_Q = warehouseReceiptId_Q;
	}

	public String getTerm_Q() {
		return term_Q;
	}

	public void setTerm_Q(String term_Q) {
		this.term_Q = term_Q;
	}

	public String getTermType_Q() {
		return termType_Q;
	}

	public void setTermType_Q(String termType_Q) {
		this.termType_Q = termType_Q;
	}

	/**
	 * @return the state_Q
	 */
	public String getState_Q() {
		return state_Q;
	}

	/**
	 * @param state_Q the state_Q to set
	 */
	public void setState_Q(String state_Q) {
		this.state_Q = state_Q;
	}

	private String protocolNo_Q; // 监管协议编号

	private String protocolCode_Q;//监管协议代码

	private String otherProtocolNo_Q;//场地租赁协议存放监管协议

	public String getProtocolNo_Q() {
		return protocolNo_Q;
	}

	public void setProtocolNo_Q(String protocolNo_Q) {
		this.protocolNo_Q = protocolNo_Q;
	}

	public String getProtocolCode_Q() {
		return protocolCode_Q;
	}

	public void setProtocolCode_Q(String protocolCode_Q) {
		this.protocolCode_Q = protocolCode_Q;
	}

	public String getOtherProtocolNo_Q() {
		return otherProtocolNo_Q;
	}

	public void setOtherProtocolNo_Q(String otherProtocolNo_Q) {
		this.otherProtocolNo_Q = otherProtocolNo_Q;
	}

	public String getDataName_Q() {
		return dataName_Q;
	}

	public void setDataName_Q(String dataName_Q) {
		this.dataName_Q = dataName_Q;
	}

	public String getDataTypeNo_Q() {
		return dataTypeNo_Q;
	}

	public void setDataTypeNo_Q(String dataTypeNo_Q) {
		this.dataTypeNo_Q = dataTypeNo_Q;
	}

	private String dataTypeNo_Q; // 查询数据类型号


	private String ruleType_Q; // 业务类型

	/**
	 * @return the selectType_Q
	 */
	public String getSelectType_Q() {
		return selectType_Q;
	}

	/**
	 * @param selectType_Q the selectType_Q to set
	 */
	public void setSelectType_Q(String selectType_Q) {
		this.selectType_Q = selectType_Q;
	}

	/**
	 * @return the netName_Q
	 */
	public String getNetName_Q() {
		return netName_Q;
	}

	/**
	 * @param netName_Q the netName_Q to set
	 */
	public void setNetName_Q(String netName_Q) {
		this.netName_Q = netName_Q;
	}

	/**
	 * @return the coreCname_Q
	 */
	public String getCoreCname_Q() {
		return coreCname_Q;
	}

	/**
	 * @param coreCname_Q the coreCname_Q to set
	 */
	public void setCoreCname_Q(String coreCname_Q) {
		this.coreCname_Q = coreCname_Q;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getLnciStatus_Q() {
		return lnciStatus_Q;
	}

	public String getContractType_Q() {
		return contractType_Q;
	}

	public void setContractType_Q(String contractType_Q) {
		this.contractType_Q = contractType_Q;
	}

	public void setLnciStatus_Q(String lnciStatus_Q) {
		this.lnciStatus_Q = lnciStatus_Q;
	}

	/**
	 * @return the mortgageModel_Q
	 */
	public java.lang.String getMortgageModel_Q() {
		return mortgageModel_Q;
	}

	/**
	 * @param mortgageModel_Q the mortgageModel_Q to set
	 */
	public void setMortgageModel_Q(java.lang.String mortgageModel_Q) {
		this.mortgageModel_Q = mortgageModel_Q;
	}

	/**
	 * @return the mortgageMaketPriceID_Q
	 */
	public java.lang.String getMortgageMaketPriceID_Q() {
		return mortgageMaketPriceID_Q;
	}

	/**
	 * @param mortgageMaketPriceID_Q the mortgageMaketPriceID_Q to set
	 */
	public void setMortgageMaketPriceID_Q(java.lang.String mortgageMaketPriceID_Q) {
		this.mortgageMaketPriceID_Q = mortgageMaketPriceID_Q;
	}

	/**
	 * @return the bigGageClass_Q
	 */
	public java.lang.String getBigGageClass_Q() {
		return bigGageClass_Q;
	}

	/**
	 * @param bigGageClass_Q the bigGageClass_Q to set
	 */
	public void setBigGageClass_Q(java.lang.String bigGageClass_Q) {
		this.bigGageClass_Q = bigGageClass_Q;
	}

	/**
	 * @return the smallGageClass_Q
	 */
	public java.lang.String getSmallGageClass_Q() {
		return smallGageClass_Q;
	}

	/**
	 * @param smallGageClass_Q the smallGageClass_Q to set
	 */
	public void setSmallGageClass_Q(java.lang.String smallGageClass_Q) {
		this.smallGageClass_Q = smallGageClass_Q;
	}

	/**
	 * @return the appno_Q
	 */
	public java.lang.String getAppno_Q() {
		return appno_Q;
	}

	/**
	 * @param appno_Q
	 */
	public void setAppno_Q(java.lang.String appno_Q) {
		this.appno_Q = appno_Q;
	}

	/**
	 * @return the startDate_Q
	 */
	public String getStartDate_Q() {
		return startDate_Q;
	}

	/**
	 * @param startDate_Q the startDate_Q to set
	 */
	public void setStartDate_Q(String startDate_Q) {
		this.startDate_Q = startDate_Q;
	}

	/**
	 * @return the endDate_Q
	 */
	public String getEndDate_Q() {
		return endDate_Q;
	}

	/**
	 * @param endDate_Q the endDate_Q to set
	 */
	public void setEndDate_Q(String endDate_Q) {
		this.endDate_Q = endDate_Q;
	}

	/**
	 * @return the contractID_Q
	 */
	public String getContractID_Q() {
		return contractID_Q;
	}

	/**
	 * @param contractID_Q the contractID_Q to set
	 */
	public void setContractID_Q(String contractID_Q) {
		this.contractID_Q = contractID_Q;
	}

	public String getCustcd_Q() {
		return custcd_Q;
	}

	public void setCustcd_Q(String custcd_Q) {
		this.custcd_Q = custcd_Q;
	}

	public String getCname_Q() {
		return cname_Q;
	}

	public void setCname_Q(String cname_Q) {
		this.cname_Q = cname_Q;
	}

	/**
	 * @return the orgCode_Q
	 */
	public String getOrgCode_Q() {
		return orgCode_Q;
	}

	/**
	 * @param orgCode_Q the orgCode_Q to set
	 */
	public void setOrgCode_Q(String orgCode_Q) {
		this.orgCode_Q = orgCode_Q;
	}

	/**
	 * @return the accType_Q
	 */
	public String getAccType_Q() {
		return accType_Q;
	}

	/**
	 * @param accType_Q the accType_Q to set
	 */
	public void setAccType_Q(String accType_Q) {
		this.accType_Q = accType_Q;
	}

	/**
	 * @return the custIdType_Q
	 */
	public String getCustIdType_Q() {
		return custIdType_Q;
	}

	/**
	 * @param custIdType_Q the custIdType_Q to set
	 */
	public void setCustIdType_Q(String custIdType_Q) {
		this.custIdType_Q = custIdType_Q;
	}

	/**
	 * @return the custIdNo_Q
	 */
	public String getCustIdNo_Q() {
		return custIdNo_Q;
	}

	/**
	 * @param custIdNo_Q the custIdNo_Q to set
	 */
	public void setCustIdNo_Q(String custIdNo_Q) {
		this.custIdNo_Q = custIdNo_Q;
	}

	/**
	 * @return the finacNetName_Q
	 */
	public String getFinacNetName_Q() {
		return finacNetName_Q;
	}

	/**
	 * @param finacNetName_Q the finacNetName_Q to set
	 */
	public void setFinacNetName_Q(String finacNetName_Q) {
		this.finacNetName_Q = finacNetName_Q;
	}

	/**
	 * @return the coreCompName_Q
	 */
	public String getCoreCompName_Q() {
		return coreCompName_Q;
	}

	/**
	 * @param coreCompName_Q the coreCompName_Q to set
	 */
	public void setCoreCompName_Q(String coreCompName_Q) {
		this.coreCompName_Q = coreCompName_Q;
	}

	/**
	 * @return the supplyChainProduct_Q
	 */
	public String getSupplyChainProduct_Q() {
		return supplyChainProduct_Q;
	}

	/**
	 * @param supplyChainProduct_Q the supplyChainProduct_Q to set
	 */
	public void setSupplyChainProduct_Q(String supplyChainProduct_Q) {
		this.supplyChainProduct_Q = supplyChainProduct_Q;
	}

	/**
	 * @return the cepName_Q
	 */
	public String getCepName_Q() {
		return cepName_Q;
	}

	/**
	 * @param cepName_Q the cepName_Q to set
	 */
	public void setCepName_Q(String cepName_Q) {
		this.cepName_Q = cepName_Q;
	}

	/**
	 * @return the lastStockDate_Q
	 */
	public String getLastStockDate_Q() {
		return lastStockDate_Q;
	}

	/**
	 * @param lastStockDate_Q the lastStockDate_Q to set
	 */
	public void setLastStockDate_Q(String lastStockDate_Q) {
		this.lastStockDate_Q = lastStockDate_Q;
	}

	/**
	 * @return the storageWarehouse_Q
	 */
	public String getStorageWarehouse_Q() {
		return storageWarehouse_Q;
	}

	/**
	 * @param storageWarehouse_Q the storageWarehouse_Q to set
	 */
	public void setStorageWarehouse_Q(String storageWarehouse_Q) {
		this.storageWarehouse_Q = storageWarehouse_Q;
	}

	/**
	 * @return the storageComp_Q
	 */
	public String getStorageComp_Q() {
		return storageComp_Q;
	}

	/**
	 * @param storageComp_Q the storageComp_Q to set
	 */
	public void setStorageComp_Q(String storageComp_Q) {
		this.storageComp_Q = storageComp_Q;
	}

	/**
	 * @return the contractNo_Q
	 */
	public String getContractNo_Q() {
		return contractNo_Q;
	}

	/**
	 * @param contractNo_Q the contractNo_Q to set
	 */
	public void setContractNo_Q(String contractNo_Q) {
		this.contractNo_Q = contractNo_Q;
	}

	/**
	 * @return the contractDate_Q
	 */
	public String getContractDate_Q() {
		return contractDate_Q;
	}

	/**
	 * @param contractDate_Q the contractDate_Q to set
	 */
	public void setContractDate_Q(String contractDate_Q) {
		this.contractDate_Q = contractDate_Q;
	}

	/**
	 * @return the storagePerson_Q
	 */
	public String getStoragePerson_Q() {
		return storagePerson_Q;
	}

	/**
	 * @param storagePerson_Q the storagePerson_Q to set
	 */
	public void setStoragePerson_Q(String storagePerson_Q) {
		this.storagePerson_Q = storagePerson_Q;
	}

	/**
	 * @return the mastContno_Q
	 */
	public String getMastContno_Q() {
		return mastContno_Q;
	}

	/**
	 * @param mastContno_Q the mastContno_Q to set
	 */
	public void setMastContno_Q(String mastContno_Q) {
		this.mastContno_Q = mastContno_Q;
	}

	/**
	 * @return the slaveContno_Q
	 */
	public String getSlaveContno_Q() {
		return slaveContno_Q;
	}

	/**
	 * @param slaveContno_Q the slaveContno_Q to set
	 */
	public void setSlaveContno_Q(String slaveContno_Q) {
		this.slaveContno_Q = slaveContno_Q;
	}

	public String getOrgName_Q() {
		return orgName_Q;
	}

	public void setOrgName_Q(String orgName_Q) {
		this.orgName_Q = orgName_Q;
	}

	public String getUser_Q() {
		return user_Q;
	}

	public void setUser_Q(String user_Q) {
		this.user_Q = user_Q;
	}

	public String getBeginDate_Q() {
		return beginDate_Q;
	}

	public void setBeginDate_Q(String beginDate_Q) {
		this.beginDate_Q = beginDate_Q;
	}

	/**
	 * @return the signDate_Q
	 */
	public String getSignDate_Q() {
		return signDate_Q;
	}

	/**
	 * @param signDate_Q the signDate_Q to set
	 */
	public void setSignDate_Q(String signDate_Q) {
		this.signDate_Q = signDate_Q;
	}

	public String getMortgageClassNo_Q() {
		return mortgageClassNo_Q;
	}

	public void setMortgageClassNo_Q(String mortgageClassNo_Q) {
		this.mortgageClassNo_Q = mortgageClassNo_Q;
	}

	public String getMortgageClass_Q() {
		return mortgageClass_Q;
	}

	public void setMortgageClass_Q(String mortgageClass_Q) {
		this.mortgageClass_Q = mortgageClass_Q;
	}

	public String getChargeTypeNm_Q() {
		return chargeTypeNm_Q;
	}

	public void setChargeTypeNm_Q(String chargeTypeNm_Q) {
		this.chargeTypeNm_Q = chargeTypeNm_Q;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the pageIndex
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getStorOrDeli_Q() {
		return storOrDeli_Q;
	}

	public void setStorOrDeli_Q(String storOrDeli_Q) {
		this.storOrDeli_Q = storOrDeli_Q;
	}

	public String getCustOfTlrType_Q() {
		return custOfTlrType_Q;
	}

	public void setCustOfTlrType_Q(String custOfTlrType_Q) {
		this.custOfTlrType_Q = custOfTlrType_Q;
	}

	public String getFlag_Q() {
		return flag_Q;
	}

	public void setFlag_Q(String flag_Q) {
		this.flag_Q = flag_Q;
	}

	/**
	 * @return the aliasName_Q
	 */
	public String getAliasName_Q() {
		return aliasName_Q;
	}

	/**
	 * @param aliasName_Q the aliasName_Q to set
	 */
	public void setAliasName_Q(String aliasName_Q) {
		this.aliasName_Q = aliasName_Q;
	}

	/**
	 * @return the supplyChainPdId_Q
	 */
	public String getSupplyChainPdId_Q() {
		return supplyChainPdId_Q;
	}

	/**
	 * @param supplyChainPdId_Q the supplyChainPdId_Q to set
	 */
	public void setSupplyChainPdId_Q(String supplyChainPdId_Q) {
		this.supplyChainPdId_Q = supplyChainPdId_Q;
	}

	/**
	 * @return the financingType_Q
	 */
	public String getFinancingType_Q() {
		return financingType_Q;
	}

	/**
	 * @param financingType_Q the financingType_Q to set
	 */
	public void setFinancingType_Q(String financingType_Q) {
		this.financingType_Q = financingType_Q;
	}

	public String getNetNo_Q() {
		return netNo_Q;
	}

	public void setNetNo_Q(String netNo_Q) {
		this.netNo_Q = netNo_Q;
	}

	public String getDebetId_Q() {
		return debetId_Q;
	}

	public void setDebetId_Q(String debetId_Q) {
		this.debetId_Q = debetId_Q;
	}

	public String getLnciType_Q() {
		return lnciType_Q;
	}

	public void setLnciType_Q(String lnciType_Q) {
		this.lnciType_Q = lnciType_Q;
	}

	public String getId_Q() {
		return id_Q;
	}

	public void setId_Q(String id_Q) {
		this.id_Q = id_Q;
	}

	/**
	 * @return the suppProductName_Q
	 */
	public String getSuppProductName_Q() {
		return suppProductName_Q;
	}

	/**
	 * @param suppProductName_Q the suppProductName_Q to set
	 */
	public void setSuppProductName_Q(String suppProductName_Q) {
		this.suppProductName_Q = suppProductName_Q;
	}

	/**
	 * @return the appliMortBizType_Q
	 */
	public String getAppliMortBizType_Q() {
		return appliMortBizType_Q;
	}

	/**
	 * @param appliMortBizType_Q the appliMortBizType_Q to set
	 */
	public void setAppliMortBizType_Q(String appliMortBizType_Q) {
		this.appliMortBizType_Q = appliMortBizType_Q;
	}

	public String getBrcode_Q() {
		return brcode_Q;
	}

	public void setBrcode_Q(String brcode_Q) {
		this.brcode_Q = brcode_Q;
	}

	public String getOprcode_Q() {
		return oprcode_Q;
	}

	public void setOprcode_Q(String oprcode_Q) {
		this.oprcode_Q = oprcode_Q;
	}

	public String getSuppChainPdType_Q() {
		return suppChainPdType_Q;
	}

	public void setSuppChainPdType_Q(String suppChainPdType_Q) {
		this.suppChainPdType_Q = suppChainPdType_Q;
	}

	/**
	 * @return the mortgageNo_Q
	 */
	public String getMortgageNo_Q() {
		return mortgageNo_Q;
	}

	/**
	 * @param mortgageNo_Q the mortgageNo_Q to set
	 */
	public void setMortgageNo_Q(String mortgageNo_Q) {
		this.mortgageNo_Q = mortgageNo_Q;
	}

	/**
	 * @return the srvNetId
	 */
	public Integer getSrvNetId() {
		return srvNetId;
	}

	/**
	 * @param srvNetId the srvNetId to set
	 */
	public void setSrvNetId(Integer srvNetId) {
		this.srvNetId = srvNetId;
	}

	public String getFluctuation_Q() {
		return fluctuation_Q;
	}

	public void setFluctuation_Q(String fluctuation_Q) {
		this.fluctuation_Q = fluctuation_Q;
	}

	public String getUnrepayTime_Q() {
		return unrepayTime_Q;
	}

	public void setUnrepayTime_Q(String unrepayTime_Q) {
		this.unrepayTime_Q = unrepayTime_Q;
	}

	public String getNetProtocolNo_Q() {
		return netProtocolNo_Q;
	}

	public void setNetProtocolNo_Q(String netProtocolNo_Q) {
		this.netProtocolNo_Q = netProtocolNo_Q;
	}

	public String getRuleType_Q() {
		return ruleType_Q;
	}

	public void setRuleType_Q(String ruleType_Q) {
		this.ruleType_Q = ruleType_Q;
	}

	/**
	 * @return the analyzeType_Q
	 */
	public String getAnalyzeType_Q() {
		return analyzeType_Q;
	}

	/**
	 * @param analyzeType_Q the analyzeType_Q to set
	 */
	public void setAnalyzeType_Q(String analyzeType_Q) {
		this.analyzeType_Q = analyzeType_Q;
	}

	public String getAppliStatusDtl_Q() {
		return appliStatusDtl_Q;
	}

	public void setAppliStatusDtl_Q(String appliStatusDtl_Q) {
		this.appliStatusDtl_Q = appliStatusDtl_Q;
	}

	public String getWarehouseNo() {
		return warehouseNo;
	}

	public void setWarehouseNo(String warehouseNo) {
		this.warehouseNo = warehouseNo;
	}

	public String getModelType_Q() {
		return modelType_Q;
	}

	public void setModelType_Q(String modelType_Q) {
		this.modelType_Q = modelType_Q;
	}

	public String getStorageCompAddr_Q() {
		return storageCompAddr_Q;
	}

	public void setStorageCompAddr_Q(String storageCompAddr_Q) {
		this.storageCompAddr_Q = storageCompAddr_Q;
	}

	public String getBrName_Q() {
		return brName_Q;
	}

	public void setBrName_Q(String brName_Q) {
		this.brName_Q = brName_Q;
	}

	public String getInfoPublishId_Q() {
		return infoPublishId_Q;
	}

	public void setInfoPublishId_Q(String infoPublishId_Q) {
		this.infoPublishId_Q = infoPublishId_Q;
	}

	public java.sql.Timestamp getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(java.sql.Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getFilePro() {
		return filePro;
	}

	public void setFilePro(String filePro) {
		this.filePro = filePro;
	}

	public String getFileFlag() {
		return fileFlag;
	}

	public void setFileFlag(String fileFlag) {
		this.fileFlag = fileFlag;
	}

	public String getBillno_Q() {
		return billno_Q;
	}

	public void setBillno_Q(String billno_Q) {
		this.billno_Q = billno_Q;
	}

	public String getNoticeType_Q() {
		return noticeType_Q;
	}

	public void setNoticeType_Q(String noticeType_Q) {
		this.noticeType_Q = noticeType_Q;
	}

	public String getMortgageType_Q() {
		return mortgageType_Q;
	}

	public void setMortgageType_Q(String mortgageType_Q) {
		this.mortgageType_Q = mortgageType_Q;
	}

	public String getExchangeStatus() {
		return exchangeStatus;
	}

	public void setExchangeStatus(String exchangeStatus) {
		this.exchangeStatus = exchangeStatus;
	}

	public String getMonitorProtocolNo_Q() {
		return monitorProtocolNo_Q;
	}

	public void setMonitorProtocolNo_Q(String monitorProtocolNo_Q) {
		this.monitorProtocolNo_Q = monitorProtocolNo_Q;
	}

	public String getMortgageBizType() {
		return mortgageBizType;
	}

	public void setMortgageBizType(String mortgageBizType) {
		this.mortgageBizType = mortgageBizType;
	}

	public String getMoniOfCustcd() {
		return moniOfCustcd;
	}

	public void setMoniOfCustcd(String moniOfCustcd) {
		this.moniOfCustcd = moniOfCustcd;
	}

	public String getPid_Q() {
		return pid_Q;
	}

	public void setPid_Q(String pid_Q) {
		this.pid_Q = pid_Q;
	}

	public String getSlaveContcode_Q() {
		return slaveContcode_Q;
	}

	public void setSlaveContcode_Q(String slaveContcode_Q) {
		this.slaveContcode_Q = slaveContcode_Q;
	}

	public String getStorDeliBizType_Q() {
		return storDeliBizType_Q;
	}

	public void setStorDeliBizType_Q(String storDeliBizType_Q) {
		this.storDeliBizType_Q = storDeliBizType_Q;
	}

	public String getBussType() {
		return bussType;
	}

	public void setBussType(String bussType) {
		this.bussType = bussType;
	}

	public String getDataNo_Q() {
		return dataNo_Q;
	}

	public void setDataNo_Q(String dataNo_Q) {
		this.dataNo_Q = dataNo_Q;
	}

	public String getResults_Q() {
		return results_Q;
	}

	public void setResults_Q(String results_Q) {
		this.results_Q = results_Q;
	}

	public String getCheckStockWay_Q() {
		return checkStockWay_Q;
	}

	public void setCheckStockWay_Q(String checkStockWay_Q) {
		this.checkStockWay_Q = checkStockWay_Q;
	}

	public String getMortgageName() {
		return mortgageName;
	}

	public void setMortgageName(String mortgageName) {
		this.mortgageName = mortgageName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMortgageCode() {
		return mortgageCode;
	}

	public void setMortgageCode(String mortgageCode) {
		this.mortgageCode = mortgageCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getBrcodes() {
		return brcodes;
	}

	public void setBrcodes(String brcodes) {
		this.brcodes = brcodes;
	}

	public String getMoniWarehouseType_Q() {
		return moniWarehouseType_Q;
	}

	public void setMoniWarehouseType_Q(String moniWarehouseType_Q) {
		this.moniWarehouseType_Q = moniWarehouseType_Q;
	}

	public String getSecCd_Q() {
		return secCd_Q;
	}

	public void setSecCd_Q(String secCd_Q) {
		this.secCd_Q = secCd_Q;
	}

	public String getThrCd_Q() {
		return thrCd_Q;
	}

	public void setThrCd_Q(String thrCd_Q) {
		this.thrCd_Q = thrCd_Q;
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public String getProductId_Q() {
		return productId_Q;
	}

	public void setProductId_Q(String productId_Q) {
		this.productId_Q = productId_Q;
	}

	public String getType_Q() {
		return type_Q;
	}

	public void setType_Q(String type_Q) {
		this.type_Q = type_Q;
	}

	public String getStoreName_Q() {
		return storeName_Q;
	}

	public void setStoreName_Q(String storeName_Q) {
		this.storeName_Q = storeName_Q;
	}

	public String getCustCdName_Q() {
		return custCdName_Q;
	}

	public void setCustCdName_Q(String custCdName_Q) {
		this.custCdName_Q = custCdName_Q;
	}

	public java.util.Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(java.util.Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getLoanProductCode_Q() {
		return loanProductCode_Q;
	}

	public void setLoanProductCode_Q(String loanProductCode_Q) {
		this.loanProductCode_Q = loanProductCode_Q;
	}

	public String getBrname_Q() {
		return brname_Q;
	}

	public void setBrname_Q(String brname_Q) {
		this.brname_Q = brname_Q;
	}

	public java.util.Date getPublishDate1() {
		return publishDate1;
	}

	public void setPublishDate1(java.util.Date publishDate1) {
		this.publishDate1 = publishDate1;
	}

	public String getCnameSeller_Q() {
		return cnameSeller_Q;
	}

	public void setCnameSeller_Q(String cnameSeller_Q) {
		this.cnameSeller_Q = cnameSeller_Q;
	}

	public String getCnameBuyer_Q() {
		return cnameBuyer_Q;
	}

	public void setCnameBuyer_Q(String cnameBuyer_Q) {
		this.cnameBuyer_Q = cnameBuyer_Q;
	}

	public String getStratDate_Q() {
		return stratDate_Q;
	}

	public void setStratDate_Q(String stratDate_Q) {
		this.stratDate_Q = stratDate_Q;
	}

	public String getCustcdSaller_Q() {
		return custcdSaller_Q;
	}

	public void setCustcdSaller_Q(String custcdSaller_Q) {
		this.custcdSaller_Q = custcdSaller_Q;
	}

	public String getCustcdBuyer_Q() {
		return custcdBuyer_Q;
	}

	public void setCustcdBuyer_Q(String custcdBuyer_Q) {
		this.custcdBuyer_Q = custcdBuyer_Q;
	}

	public String getMastContCode_Q() {
		return mastContCode_Q;
	}

	public void setMastContCode_Q(String mastContCode_Q) {
		this.mastContCode_Q = mastContCode_Q;
	}

	public java.lang.String getBillsPeriod() {
		return billsPeriod;
	}

	public void setBillsPeriod(java.lang.String billsPeriod) {
		this.billsPeriod = billsPeriod;
	}

	public String getMoniType_Q() {
		return moniType_Q;
	}

	public void setMoniType_Q(String moniType_Q) {
		this.moniType_Q = moniType_Q;
	}
	public String getDebetNo_Q() {
		return debetNo_Q;
	}

	public void setDebetNo_Q(String debetNo_Q) {
		this.debetNo_Q = debetNo_Q;
	}

	private String custno_Q;

	public String getCustno_Q() {
		return custno_Q;
	}

	public void setCustno_Q(String custnoQ) {
		custno_Q = custnoQ;
	}
	public String getCheckStockDate_Q() {
		return checkStockDate_Q;
	}

	public void setCheckStockDate_Q(String checkStockDate_Q) {
		this.checkStockDate_Q = checkStockDate_Q;
	}

	public String getBatchId_Q() {
		return batchId_Q;
	}

	public void setBatchId_Q(String batchId_Q) {
		this.batchId_Q = batchId_Q;
	}
	private String accountType_Q;//账户类型
	private String mgrno;//客户
	private String custno;//核心客户号
	private String id;//序列号

	public String getAccountType_Q() {
		return accountType_Q;
	}

	public void setAccountType_Q(String accountTypeQ) {
		accountType_Q = accountTypeQ;
	}

	public String getCustno() {
		return custno;
	}

	public void setCustno(String custno) {
		this.custno = custno;
	}

	public String getMgrno() {
		return mgrno;
	}

	public void setMgrno(String mgrno) {
		this.mgrno = mgrno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	private java.lang.String bussType_Q;

	public java.lang.String getBussType_Q() {
		return bussType_Q;
	}

	public void setBussType_Q(java.lang.String bussTypeQ) {
		bussType_Q = bussTypeQ;
	}
	private String recycle_Q;

	public String getRecycle_Q() {
		return recycle_Q;
	}

	public void setRecycle_Q(String recycleQ) {
		recycle_Q = recycleQ;
	}

	public java.lang.String getChReportNo() {
		return chReportNo;
	}

	public void setChReportNo(java.lang.String chReportNo) {
		this.chReportNo = chReportNo;
	}

	private java.lang.String relationId_Q;//关联关系id
	private java.lang.String creditNo_Q;//关联关系id

	public java.lang.String getRelationId_Q() {
		return relationId_Q;
	}

	public void setRelationId_Q(java.lang.String relationIdQ) {
		relationId_Q = relationIdQ;
	}

	public java.lang.String getCreditNo_Q() {
		return creditNo_Q;
	}

	public void setCreditNo_Q(java.lang.String creditNoQ) {
		creditNo_Q = creditNoQ;
	}

	public java.lang.String getReturnStatus_Q() {
		return returnStatus_Q;
	}

	public void setReturnStatus_Q(java.lang.String returnStatus_Q) {
		this.returnStatus_Q = returnStatus_Q;
	}

	public java.lang.String getBillsNo_Q() {
		return billsNo_Q;
	}

	public void setBillsNo_Q(java.lang.String billsNo_Q) {
		this.billsNo_Q = billsNo_Q;
	}

	public String getBussTypeName_Q() {
		return bussTypeName_Q;
	}

	public void setBussTypeName_Q(String bussTypeNameQ) {
		bussTypeName_Q = bussTypeNameQ;
	}

	public String getBillsAmount2_Q() {
		return billsAmount2_Q;
	}

	public void setBillsAmount2_Q(String billsAmount2_Q) {
		this.billsAmount2_Q = billsAmount2_Q;
	}
	private String mastContcode_Q;

	public String getMastContcode_Q() {
		return mastContcode_Q;
	}

	public void setMastContcode_Q(String mastContcodeQ) {
		mastContcode_Q = mastContcodeQ;
	}
	private String mastContStatus_Q;


	public String getMastContStatus_Q() {
		return mastContStatus_Q;
	}

	public void setMastContStatus_Q(String mastContStatusQ) {
		mastContStatus_Q = mastContStatusQ;
	}
	private String purchaseDate1_Q;
	private String purchaseDate2_Q;


	public String getPurchaseDate1_Q() {
		return purchaseDate1_Q;
	}

	public void setPurchaseDate1_Q(String purchaseDate1Q) {
		purchaseDate1_Q = purchaseDate1Q;
	}

	public String getPurchaseDate2_Q() {
		return purchaseDate2_Q;
	}

	public void setPurchaseDate2_Q(String purchaseDate2Q) {
		purchaseDate2_Q = purchaseDate2Q;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getIsInSeller() {
		return isInSeller;
	}

	public void setIsInSeller(String isInSeller) {
		this.isInSeller = isInSeller;
	}

	public String getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}
	private String debetid_Q;
	private String startDate1_Q;
	private String startDate2_Q;
	private String fivelevel;
	private String endDate1_Q;
	private String endDate2_Q;
	private BigDecimal ownRateCollectAmount;

	public String getDebetid_Q() {
		return debetid_Q;
	}

	public void setDebetid_Q(String debetid_Q) {
		this.debetid_Q = debetid_Q;
	}



	public String getFivelevel() {
		return fivelevel;
	}

	public void setFivelevel(String fivelevel) {
		this.fivelevel = fivelevel;
	}

	public String getStartDate1_Q() {
		return startDate1_Q;
	}

	public void setStartDate1_Q(String startDate1_Q) {
		this.startDate1_Q = startDate1_Q;
	}

	public String getStartDate2_Q() {
		return startDate2_Q;
	}

	public void setStartDate2_Q(String startDate2_Q) {
		this.startDate2_Q = startDate2_Q;
	}

	public String getEndDate1_Q() {
		return endDate1_Q;
	}

	public void setEndDate1_Q(String endDate1_Q) {
		this.endDate1_Q = endDate1_Q;
	}

	public String getEndDate2_Q() {
		return endDate2_Q;
	}

	public void setEndDate2_Q(String endDate2_Q) {
		this.endDate2_Q = endDate2_Q;
	}

	public BigDecimal getOwnRateCollectAmount() {
		return ownRateCollectAmount;
	}

	public void setOwnRateCollectAmount(BigDecimal ownRateCollectAmount) {
		this.ownRateCollectAmount = ownRateCollectAmount;
	}
	private String commonDate1_Q;
	private String commonDate2_Q;
	public String getCommonDate1_Q() {
		return commonDate1_Q;
	}

	public void setCommonDate1_Q(String commonDate1Q) {
		commonDate1_Q = commonDate1Q;
	}

	public String getCommonDate2_Q() {
		return commonDate2_Q;
	}

	public void setCommonDate2_Q(String commonDate2Q) {
		commonDate2_Q = commonDate2Q;
	}
	private String applyType_Q;
	public String getApplyType_Q() {
		return applyType_Q;
	}

	public void setApplyType_Q(String applyTypeQ) {
		applyType_Q = applyTypeQ;
	}
	private String loanOverdueFlag_Q;
	public String getLoanOverdueFlag_Q() {
		return loanOverdueFlag_Q;
	}

	public void setLoanOverdueFlag_Q(String loanOverdueFlagQ) {
		loanOverdueFlag_Q = loanOverdueFlagQ;
	}
	private String insertDate_Q;
	public String getInsertDate_Q() {
		return insertDate_Q;
	}

	public void setInsertDate_Q(String insertDateQ) {
		insertDate_Q = insertDateQ;
	}
	private String billsDate_Q;
	private String debtEnd_Q;
	public String getBillsDate_Q() {
		return billsDate_Q;
	}

	public void setBillsDate_Q(String billsDateQ) {
		billsDate_Q = billsDateQ;
	}

	public String getDebtEnd_Q() {
		return debtEnd_Q;
	}

	public void setDebtEnd_Q(String debtEndQ) {
		debtEnd_Q = debtEndQ;
	}

	public String getLoanWay_Q() {
		return loanWay_Q;
	}

	public void setLoanWay_Q(String loanWay_Q) {
		this.loanWay_Q = loanWay_Q;
	}
	private String mastContType_Q; //主合同类型
	private String coreCustcd_Q;//核心厂商
	private String moniCustcd_Q;//监管公司
	private String backCoreCustcd_Q;//回购厂商


	public String getMastContType_Q() {
		return mastContType_Q;
	}

	public void setMastContType_Q(String mastContTypeQ) {
		mastContType_Q = mastContTypeQ;
	}

	public String getCoreCustcd_Q() {
		return coreCustcd_Q;
	}

	public void setCoreCustcd_Q(String coreCustcdQ) {
		coreCustcd_Q = coreCustcdQ;
	}

	public String getMoniCustcd_Q() {
		return moniCustcd_Q;
	}

	public void setMoniCustcd_Q(String moniCustcdQ) {
		moniCustcd_Q = moniCustcdQ;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getDebtNo_Q() {
		return debtNo_Q;
	}

	public void setDebtNo_Q(String debtNo_Q) {
		this.debtNo_Q = debtNo_Q;
	}
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	private String thrName_Q;


	public String getThrName_Q() {
		return thrName_Q;
	}

	public void setThrName_Q(String thrNameQ) {
		thrName_Q = thrNameQ;
	}

	public java.math.BigDecimal getFirstBailRatio_Q() {
		return firstBailRatio_Q;
	}

	public void setFirstBailRatio_Q(java.math.BigDecimal firstBailRatio_Q) {
		this.firstBailRatio_Q = firstBailRatio_Q;
	}

	public java.lang.String getFirstBailType_Q() {
		return firstBailType_Q;
	}

	public void setFirstBailType_Q(java.lang.String firstBailType_Q) {
		this.firstBailType_Q = firstBailType_Q;
	}

	public java.lang.String getCoreAccount_Q() {
		return coreAccount_Q;
	}

	public void setCoreAccount_Q(java.lang.String coreAccount_Q) {
		this.coreAccount_Q = coreAccount_Q;
	}

	public java.lang.String getBailAccount_Q() {
		return bailAccount_Q;
	}

	public void setBailAccount_Q(java.lang.String bailAccount_Q) {
		this.bailAccount_Q = bailAccount_Q;
	}

	public java.lang.String getBalanceAccount_Q() {
		return balanceAccount_Q;
	}

	public void setBalanceAccount_Q(java.lang.String balanceAccount_Q) {
		this.balanceAccount_Q = balanceAccount_Q;
	}

	public String getNum_Q() {
		return num_Q;
	}

	public void setNum_Q(String num_Q) {
		this.num_Q = num_Q;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getCustClass() {
		return custClass;
	}

	public void setCustClass(String custClass) {
		this.custClass = custClass;
	}

	public String getCurcd() {
		return curcd;
	}

	public void setCurcd(String curcd) {
		this.curcd = curcd;
	}

	public String getIntratecdName() {
		return intratecdName;
	}

	public void setIntratecdName(String intratecdName) {
		this.intratecdName = intratecdName;
	}

	public String getMortgageLevelThreeName_Q() {
		return mortgageLevelThreeName_Q;
	}

	public void setMortgageLevelThreeName_Q(String mortgageLevelThreeName_Q) {
		this.mortgageLevelThreeName_Q = mortgageLevelThreeName_Q;
	}

	public String getProductName_Q() {
		return productName_Q;
	}

	public void setProductName_Q(String productName_Q) {
		this.productName_Q = productName_Q;
	}

	public String getMortgageLevelOne_Q() {
		return mortgageLevelOne_Q;
	}

	public void setMortgageLevelOne_Q(String mortgageLevelOne_Q) {
		this.mortgageLevelOne_Q = mortgageLevelOne_Q;
	}

	public String getMortgageLevelTwo_Q() {
		return mortgageLevelTwo_Q;
	}

	public void setMortgageLevelTwo_Q(String mortgageLevelTwo_Q) {
		this.mortgageLevelTwo_Q = mortgageLevelTwo_Q;
	}

	public String getMortgageLevelThree_Q() {
		return mortgageLevelThree_Q;
	}

	public void setMortgageLevelThree_Q(String mortgageLevelThree_Q) {
		this.mortgageLevelThree_Q = mortgageLevelThree_Q;
	}

	public String getNotictNo_Q() {
		return notictNo_Q;
	}

	public void setNotictNo_Q(String notictNo_Q) {
		this.notictNo_Q = notictNo_Q;
	}

	public java.util.Date getTxdate_Q() {
		return txdate_Q;
	}

	public void setTxdate_Q(java.util.Date txdate_Q) {
		this.txdate_Q = txdate_Q;
	}

	public String getProcessTemplateName_Q() {
		return processTemplateName_Q;
	}

	public void setProcessTemplateName_Q(String processTemplateName_Q) {
		this.processTemplateName_Q = processTemplateName_Q;
	}

	public String getAppliStatus_Q() {
		return appliStatus_Q;
	}

	public void setAppliStatus_Q(String appliStatus_Q) {
		this.appliStatus_Q = appliStatus_Q;
	}

	public String getBrClass_Q() {
		return brClass_Q;
	}

	public void setBrClass_Q(String brClass_Q) {
		this.brClass_Q = brClass_Q;
	}

	public String getRuleNo_Q() {
		return ruleNo_Q;
	}

	public void setRuleNo_Q(String ruleNo_Q) {
		this.ruleNo_Q = ruleNo_Q;
	}

	public String getReturnMethod_Q() {
		return returnMethod_Q;
	}

	public void setReturnMethod_Q(String returnMethod_Q) {
		this.returnMethod_Q = returnMethod_Q;
	}

	public String getLcno_Q() {
		return lcno_Q;
	}

	public void setLcno_Q(String lcno_Q) {
		this.lcno_Q = lcno_Q;
	}

	public String getTradeContno_Q() {
		return tradeContno_Q;
	}

	public void setTradeContno_Q(String tradeContno_Q) {
		this.tradeContno_Q = tradeContno_Q;
	}

	public String getTradeContcode_Q() {
		return tradeContcode_Q;
	}

	public void setTradeContcode_Q(String tradeContcode_Q) {
		this.tradeContcode_Q = tradeContcode_Q;
	}

	public String getActBrcode_Q() {
		return actBrcode_Q;
	}

	public void setActBrcode_Q(String actBrcode_Q) {
		this.actBrcode_Q = actBrcode_Q;
	}

	public String getActNo_Q() {
		return actNo_Q;
	}

	public void setActNo_Q(String actNo_Q) {
		this.actNo_Q = actNo_Q;
	}

	public String getRegAddr_Q() {
		return regAddr_Q;
	}

	public void setRegAddr_Q(String regAddr_Q) {
		this.regAddr_Q = regAddr_Q;
	}

	public String getBranch_Q() {
		return branch_Q;
	}

	public void setBranch_Q(String branch_Q) {
		this.branch_Q = branch_Q;
	}

	public String getTotAmt_Q() {
		return totAmt_Q;
	}

	public void setTotAmt_Q(String totAmt_Q) {
		this.totAmt_Q = totAmt_Q;
	}

	public String getApplyDate_Q() {
		return applyDate_Q;
	}

	public void setApplyDate_Q(String applyDate_Q) {
		this.applyDate_Q = applyDate_Q;
	}

	public String getSerialno_Q() {
		return Serialno_Q;
	}

	public void setSerialno_Q(String serialno_Q) {
		Serialno_Q = serialno_Q;
	}

	public String getSecCname_Q() {
		return secCname_Q;
	}

	public void setSecCname_Q(String secCname_Q) {
		this.secCname_Q = secCname_Q;
	}

	public String getLccode_Q() {
		return lccode_Q;
	}

	public void setLccode_Q(String lccode_Q) {
		this.lccode_Q = lccode_Q;
	}

	public String getBankFlag_Q() {
		return bankFlag_Q;
	}

	public void setBankFlag_Q(String bankFlag_Q) {
		this.bankFlag_Q = bankFlag_Q;
	}

	public String getNetProtocolSubNo_Q() {
		return netProtocolSubNo_Q;
	}

	public void setNetProtocolSubNo_Q(String netProtocolSubNo_Q) {
		this.netProtocolSubNo_Q = netProtocolSubNo_Q;
	}

	public String getDealerCname_Q() {
		return dealerCname_Q;
	}

	public void setDealerCname_Q(String dealerCname_Q) {
		this.dealerCname_Q = dealerCname_Q;
	}

	public String getFid_Q() {
		return fid_Q;
	}

	public void setFid_Q(String fid_Q) {
		this.fid_Q = fid_Q;
	}

	public String getIsUnmatch() {
		return isUnmatch;
	}

	public void setIsUnmatch(String isUnmatch) {
		this.isUnmatch = isUnmatch;
	}

	public String getDealerCustcd_Q() {
		return dealerCustcd_Q;
	}

	public void setDealerCustcd_Q(String dealerCustcd_Q) {
		this.dealerCustcd_Q = dealerCustcd_Q;
	}

	public String getBillId_Q() {
		return billId_Q;
	}

	public void setBillId_Q(String billId_Q) {
		this.billId_Q = billId_Q;
	}

	public String getPayStatus_Q() {
		return payStatus_Q;
	}

	public void setPayStatus_Q(String payStatus_Q) {
		this.payStatus_Q = payStatus_Q;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getBillCode_Q() {
		return billCode_Q;
	}

	public void setBillCode_Q(String billCode_Q) {
		this.billCode_Q = billCode_Q;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthorTlrno() {
		return authorTlrno;
	}

	public void setAuthorTlrno(String authorTlrno) {
		this.authorTlrno = authorTlrno;
	}


	public String getInfoDelTlrno() {
		return infoDelTlrno;
	}

	public void setInfoDelTlrno(String infoDelTlrno) {
		this.infoDelTlrno = infoDelTlrno;
	}

	public String getProtocolText() {
		return protocolText;
	}

	public void setProtocolText(String protocolText) {
		this.protocolText = protocolText;
	}

	public java.util.Date getInfoDeleteDate() {
		return infoDeleteDate;
	}

	public void setInfoDeleteDate(java.util.Date infoDeleteDate) {
		this.infoDeleteDate = infoDeleteDate;
	}

	private java.lang.String paramId;//参数ID
	private java.lang.String paramIndex;//参数索引

	// fields
	private java.lang.String paramName;//参数名
	private java.lang.String paramValue;//参数值
	private java.lang.String paramDesc;//参数描述
	private java.util.Date lastUpdDate;//最后更新时间
	private java.lang.String lastUpdTlr;//最后更新操作员

	private java.lang.String priceWay_Q;//价格调整  维护方式
	public java.lang.String getParamId() {
		return paramId;
	}

	public void setParamId(java.lang.String paramId) {
		this.paramId = paramId;
	}

	public java.lang.String getParamIndex() {
		return paramIndex;
	}

	public void setParamIndex(java.lang.String paramIndex) {
		this.paramIndex = paramIndex;
	}

	public java.lang.String getParamName() {
		return paramName;
	}

	public void setParamName(java.lang.String paramName) {
		this.paramName = paramName;
	}

	public java.lang.String getParamValue() {
		return paramValue;
	}

	public void setParamValue(java.lang.String paramValue) {
		this.paramValue = paramValue;
	}

	public java.lang.String getParamDesc() {
		return paramDesc;
	}

	public void setParamDesc(java.lang.String paramDesc) {
		this.paramDesc = paramDesc;
	}

	public java.util.Date getLastUpdDate() {
		return lastUpdDate;
	}

	public void setLastUpdDate(java.util.Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}

	public java.lang.String getLastUpdTlr() {
		return lastUpdTlr;
	}

	public void setLastUpdTlr(java.lang.String lastUpdTlr) {
		this.lastUpdTlr = lastUpdTlr;
	}

	public java.lang.String getTaskName_Q() {
		return taskName_Q;
	}

	public void setTaskName_Q(java.lang.String taskName_Q) {
		this.taskName_Q = taskName_Q;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRole_Q() {
		return role_Q;
	}

	public void setRole_Q(String role_Q) {
		this.role_Q = role_Q;
	}

	public String getCurcd_Q() {
		return curcd_Q;
	}

	public void setCurcd_Q(String curcd_Q) {
		this.curcd_Q = curcd_Q;
	}

	public String getCurCname_Q() {
		return curCname_Q;
	}

	public void setCurCname_Q(String curCname_Q) {
		this.curCname_Q = curCname_Q;
	}
	public String getCurEname_Q() {
		return curEname_Q;
	}

	public void setCurEname_Q(String curEname_Q) {
		this.curEname_Q = curEname_Q;
	}

	public String getCounCode_Q() {
		return counCode_Q;
	}

	public void setCounCode_Q(String counCode_Q) {
		this.counCode_Q = counCode_Q;
	}

	public String getCounCname_Q() {
		return counCname_Q;
	}

	public void setCounCname_Q(String counCname_Q) {
		this.counCname_Q = counCname_Q;
	}

	public String getCounEname_Q() {
		return counEname_Q;
	}

	public void setCounEname_Q(String counEname_Q) {
		this.counEname_Q = counEname_Q;
	}

	public String getCounBriefCname_Q() {
		return counBriefCname_Q;
	}

	public void setCounBriefCname_Q(String counBriefCname_Q) {
		this.counBriefCname_Q = counBriefCname_Q;
	}

	public String getCounBriefEname_Q() {
		return counBriefEname_Q;
	}

	public void setCounBriefEname_Q(String counBriefEname_Q) {
		this.counBriefEname_Q = counBriefEname_Q;
	}

	public String getCostClassName_Q() {
		return costClassName_Q;
	}

	public void setCostClassName_Q(String costClassName_Q) {
		this.costClassName_Q = costClassName_Q;
	}

	public String getCostTypeName_Q() {
		return costTypeName_Q;
	}

	public void setCostTypeName_Q(String costTypeName_Q) {
		this.costTypeName_Q = costTypeName_Q;
	}

	public String getChargeTypeName_Q() {
		return chargeTypeName_Q;
	}

	public void setChargeTypeName_Q(String chargeTypeName_Q) {
		this.chargeTypeName_Q = chargeTypeName_Q;
	}

	public String getCostCalcTypeName_Q() {
		return costCalcTypeName_Q;
	}

	public void setCostCalcTypeName_Q(String costCalcTypeName_Q) {
		this.costCalcTypeName_Q = costCalcTypeName_Q;
	}

	public String getCostClassId_Q() {
		return costClassId_Q;
	}

	public void setCostClassId_Q(String costClassId_Q) {
		this.costClassId_Q = costClassId_Q;
	}

	public String getCostTypeId_Q() {
		return costTypeId_Q;
	}

	public void setCostTypeId_Q(String costTypeId_Q) {
		this.costTypeId_Q = costTypeId_Q;
	}

	public String getCostCalcTypeId_Q() {
		return costCalcTypeId_Q;
	}

	public void setCostCalcTypeId_Q(String costCalcTypeId_Q) {
		this.costCalcTypeId_Q = costCalcTypeId_Q;
	}

	public String getChargeTypeId_Q() {
		return chargeTypeId_Q;
	}

	public void setChargeTypeId_Q(String chargeTypeId_Q) {
		this.chargeTypeId_Q = chargeTypeId_Q;
	}

	public String getCostPhaseId_Q() {
		return costPhaseId_Q;
	}

	public void setCostPhaseId_Q(String costPhaseId_Q) {
		this.costPhaseId_Q = costPhaseId_Q;
	}

	public String getCostPhaseName_Q() {
		return costPhaseName_Q;
	}

	public void setCostPhaseName_Q(String costPhaseName_Q) {
		this.costPhaseName_Q = costPhaseName_Q;
	}

	public String getwarnLevel() {
		return warnLevel;
	}

	public void setwarnLevel(String warnLevel) {
		this.warnLevel = warnLevel;
	}

	public String getCreitClass_Q() {
		return creitClass_Q;
	}

	public void setCreitClass_Q(String creitClass_Q) {
		this.creitClass_Q = creitClass_Q;
	}

	public String getWarnLevel() {
		return warnLevel;
	}

	public void setWarnLevel(String warnLevel) {
		this.warnLevel = warnLevel;
	}

	public String getCostInfoId_Q() {
		return costInfoId_Q;
	}

	public void setCostInfoId_Q(String costInfoId_Q) {
		this.costInfoId_Q = costInfoId_Q;
	}

	public java.lang.String getCreditClass_Q() {
		return creditClass_Q;
	}

	public void setCreditClass_Q(java.lang.String creditClass_Q) {
		this.creditClass_Q = creditClass_Q;
	}

	/**
	 * @return the relaType_Q
	 */
	public String getRelaType_Q() {
		return relaType_Q;
	}

	/**
	 * @param relaType_Q the relaType_Q to set
	 */
	public void setRelaType_Q(String relaType_Q) {
		this.relaType_Q = relaType_Q;
	}

	public String getProductType_Q() {
		return productType_Q;
	}

	public void setProductType_Q(String productType_Q) {
		this.productType_Q = productType_Q;
	}

	public String getRelaNo_Q() {
		return relaNo_Q;
	}

	public void setRelaNo_Q(String relaNo_Q) {
		this.relaNo_Q = relaNo_Q;
	}

	public String getSubContno_Q() {
		return subContno_Q;
	}

	public void setSubContno_Q(String subContno_Q) {
		this.subContno_Q = subContno_Q;
	}

	public String getBailType_Q() {
		return bailType_Q;
	}

	public void setBailType_Q(String bailType_Q) {
		this.bailType_Q = bailType_Q;
	}

	/**
	 * @return the billsType_Q
	 */
	public java.lang.String getBillsType_Q() {
		return billsType_Q;
	}

	/**
	 * @param billsType_Q the billsType_Q to set
	 */
	public void setBillsType_Q(java.lang.String billsType_Q) {
		this.billsType_Q = billsType_Q;
	}

	public String getNetProtocolCode() {
		return netProtocolCode;
	}

	public void setNetProtocolCode(String netProtocolCode) {
		this.netProtocolCode = netProtocolCode;
	}

	public java.lang.String getNodeType_Q() {
		return nodeType_Q;
	}

	public void setNodeType_Q(java.lang.String nodeType_Q) {
		this.nodeType_Q = nodeType_Q;
	}

	public String getMoniProtocolType() {
		return moniProtocolType;
	}

	public void setMoniProtocolType(String moniProtocolType) {
		this.moniProtocolType = moniProtocolType;
	}

	public String getBillcode_Q() {
		return billcode_Q;
	}

	public void setBillcode_Q(String billcode_Q) {
		this.billcode_Q = billcode_Q;
	}

	public String getWarnStatus_Q() {
		return warnStatus_Q;
	}

	public void setWarnStatus_Q(String warnStatus_Q) {
		this.warnStatus_Q = warnStatus_Q;
	}

	public String getFluctuation1_Q() {
		return fluctuation1_Q;
	}

	public void setFluctuation1_Q(String fluctuation1_Q) {
		this.fluctuation1_Q = fluctuation1_Q;
	}

	public String getFluctuation2_Q() {
		return fluctuation2_Q;
	}

	public void setFluctuation2_Q(String fluctuation2_Q) {
		this.fluctuation2_Q = fluctuation2_Q;
	}

	public String getArrivedManageMode_Q() {
		return arrivedManageMode_Q;
	}

	public void setArrivedManageMode_Q(String arrivedManageMode_Q) {
		this.arrivedManageMode_Q = arrivedManageMode_Q;
	}

	public String getContactName_Q() {
		return contactName_Q;
	}

	public void setContactName_Q(String contactNameQ) {
		contactName_Q = contactNameQ;
	}

	public String getMarketPriceSrc_Q() {
		return marketPriceSrc_Q;
	}

	public void setMarketPriceSrc_Q(String marketPriceSrc_Q) {
		this.marketPriceSrc_Q = marketPriceSrc_Q;
	}

	public String getFactType() {
		return factType;
	}

	public void setFactType(String factType) {
		this.factType = factType;
	}

	public String getBackCoreCustcd_Q() {
		return backCoreCustcd_Q;
	}

	public void setBackCoreCustcd_Q(String backCoreCustcd_Q) {
		this.backCoreCustcd_Q = backCoreCustcd_Q;
	}

	public String getMortgageThreeName_Q() {
		return mortgageThreeName_Q;
	}

	public void setMortgageThreeName_Q(String mortgageThreeName_Q) {
		this.mortgageThreeName_Q = mortgageThreeName_Q;
	}

	public String getRateNo_Q() {
		return rateNo_Q;
	}

	public void setRateNo_Q(String rateNo_Q) {
		this.rateNo_Q = rateNo_Q;
	}

	public String getWarehouseType_Q() {
		return warehouseType_Q;
	}

	public void setWarehouseType_Q(String warehouseType_Q) {
		this.warehouseType_Q = warehouseType_Q;
	}

	public String getMidProductId_Q() {
		return midProductId_Q;
	}

	public void setMidProductId_Q(String midProductId_Q) {
		this.midProductId_Q = midProductId_Q;
	}

	public String getInspectReportNo_Q() {
		return inspectReportNo_Q;
	}

	public void setInspectReportNo_Q(String inspectReportNo_Q) {
		this.inspectReportNo_Q = inspectReportNo_Q;
	}

	public String getCheckReprotNo_Q() {
		return checkReprotNo_Q;
	}

	public void setCheckReprotNo_Q(String checkReprotNo_Q) {
		this.checkReprotNo_Q = checkReprotNo_Q;
	}

	public String getNoticeName_Q() {
		return noticeName_Q;
	}

	public void setNoticeName_Q(String noticeName_Q) {
		this.noticeName_Q = noticeName_Q;
	}

	public String getPriceWay_Q() {
		return priceWay_Q;
	}

	public void setPriceWay_Q(String priceWay_Q) {
		this.priceWay_Q = priceWay_Q;
	}

	public java.lang.String getParentId_Q() {
		return parentId_Q;
	}

	public void setParentId_Q(java.lang.String parentId_Q) {
		this.parentId_Q = parentId_Q;
	}

	public String getIsSettle_Q() {
		return isSettle_Q;
	}

	public void setIsSettle_Q(String isSettle_Q) {
		this.isSettle_Q = isSettle_Q;
	}

}

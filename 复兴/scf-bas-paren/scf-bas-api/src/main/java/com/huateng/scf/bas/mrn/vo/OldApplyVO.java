/*
 * 功  能：
 * 文件名：OldApplyVO.java
 * 描  述：
 * [变更履历]
 * Version   变更日         部署              作者           变更内容
 * -----------------------------------------------------------------------------
 * V1.00     2010-11-22    huateng        Zhongxin-Cao          create
 * -----------------------------------------------------------------------------
 * Copyright (c) 2010 huateng  All Rights Reserved.
 */

package com.huateng.scf.bas.mrn.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 类功能：
 * <p>
 * <a href="OldApplyVO.java.html"><i>View Source</i></a>
 * </p>
 * @author <a href="mailto:Zhongxin-Cao@huateng.com">Zhongxin-Cao</a>
 * @version Revision: 1.0  Date: 2010-11-22 下午09:09:13
 *
 */

public class OldApplyVO {
    private String id;
    private String dataType;//数据类型
    private String dataSource;//数据源
    private java.math.BigDecimal bailRate;
    private String lnciType;
    private String contType;
    private java.math.BigDecimal  bailRatio;
    private String  slaveLimit;
    private java.math.BigDecimal  rate;
    //Tbl_APPLI_LOWER_PRICE
//	private java.lang.String appno;
//	private java.lang.String moniModel;
//	private java.lang.String moniOfCustcd;
//	private java.lang.String protocolNo;
//	private java.math.BigDecimal lowPriceNew;
	private java.math.BigDecimal lowPrice;
    private java.lang.String recordTlrcd;
    private java.lang.String recordBrcode;

    // TblAppliBaseInfo fields
    private java.lang.String appno;
    private java.lang.String supplyChainPdId;
    private java.lang.String custcd;
    private java.lang.String authTlrcd;
    private java.util.Date authDate;
    private java.lang.String checkTlrcd;
    private java.util.Date checkDate;
    private java.lang.String status;
    private java.util.Date startDate;
    private java.util.Date endDate;
    private java.lang.String description;
    private java.lang.String businessno;
    private java.lang.String appliStatusDtl;// 申请状态明细
    private java.util.Date appDate;
    private java.lang.String appTlrcd;
    private java.lang.String appBrcode;
    private java.math.BigDecimal bailAmount;//保证金余额
    private java.util.Date exchangeDate;
    private java.util.Date billsDate;
    private java.util.Date debtEnd;
	private java.math.BigDecimal creditamt;
	private java.math.BigDecimal stockamt;
	private java.math.BigDecimal riskamt;
	private java.lang.String mortgageName;
	private java.lang.String memo;
	private java.lang.String netbankAppno;
	private java.lang.String applyid;
	private java.lang.String moniCustcd;
	private java.lang.String pledgeMode;
	private java.math.BigDecimal deliverValue;
	private java.lang.String debtId;
    // TblAppliAuthorizeInfo  fields
    //private java.lang.String id;
    private java.lang.String piid;
    private java.lang.String appliType;
    private java.lang.String processTemplateName;
    private java.lang.String businessnoType;
    private java.lang.String contno;
    //private java.lang.String custcd;
    private java.math.BigDecimal amt;
    private java.lang.String startBrcode;
    private java.lang.String startTlrcd;
    private java.util.Date stratDate;
    private java.util.Date startTime;
    private java.lang.String appliStatus;
    private java.lang.String approveBrcode;
    private java.lang.String approver;
    private java.util.Date approveDate;
    private java.util.Date approveTime;
    //private java.lang.String description;
    private java.lang.String workflowAppno;
    private java.math.BigDecimal billsAmount;
    private java.math.BigDecimal remainingAmount;
    //TblAppliChkWarning  fields
    //private java.lang.String appno;
    private java.lang.String appliChkWarnClass;
    private java.lang.String appliChkWarnCode;
    //private java.lang.String description;

    //TblAppliContBaseInfo
    //private java.lang.String appno;
    //private java.lang.String supplyChainPdId;
    private java.math.BigDecimal contAmount;
    private java.util.Date signDate;
    //private java.util.Date startDate;
    //private java.util.Date endDate;
    private java.lang.String financingType;
    //private java.lang.String description;

    //TblAppliMortgageBaseInfo
    //private java.lang.String appno;
    private java.lang.String appliMortBizType;
    private java.lang.String mortgageNo;
    private java.lang.String mortgageBizType;
    private java.lang.String mortgageClass;
    private java.lang.String mortgageSubClass;
    private java.lang.String monitorProtocolNo;
    private java.lang.String otherProtocolNo;
    private java.lang.String mortgageModel;
    private java.lang.String slaveContno;
    //private java.lang.String custcd;
    private java.lang.String mortgageUnits;
    private java.math.BigDecimal quantity;
//	private java.lang.String curcd;
    private java.math.BigDecimal price;
    private java.math.BigDecimal totPrice;
    private java.lang.String description1;
    private java.math.BigDecimal balQuantity;
    private java.lang.String flag;

    //TblAppliMutiProtBaseInfo fields
    //private java.lang.String appno;
    private java.lang.String protocolNo;
    private java.lang.String protocolCode;
    private java.lang.String protocolType;
    //private java.util.Date signDate;
    //private java.util.Date startDate;
    //private java.util.Date endDate;
    private java.lang.String curcd;
    private java.math.BigDecimal protAmt;
    private java.lang.String firName;
    private java.lang.String firAddress;
    private java.lang.String firLegal;
    private java.lang.String firActUbankno;
    private java.lang.String firActno;
    private java.lang.String firTel;
    private java.lang.String firRole;
    private java.lang.String secName;
    private java.lang.String secAddress;
    private java.lang.String secLegal;
    private java.lang.String secActUbankno;
    private java.lang.String secActno;
    private java.lang.String secTel;
    private java.lang.String secRole;
    private java.lang.String thrName;
    private java.lang.String thrAddress;
    private java.lang.String thrLegal;
    private java.lang.String thrActUbankno;
    private java.lang.String thrActno;
    private java.lang.String thrTel;
    private java.lang.String thrRole;
    private java.lang.String fouFirName;
    private java.lang.String fouAddress;
    private java.lang.String fouLegal;
    private java.lang.String fouActUbankno;
    private java.lang.String fouActno;
    private java.lang.String fouTel;
    private java.lang.String fouRole;
    private java.lang.String mutiProtStatus;

    //TblAppliProtCmInfo fields
    //private java.lang.String appno;
    //private java.lang.String protocolNo;
    private java.lang.String moniOfCustcd;
    private java.lang.String moniModel;
    private java.math.BigDecimal lowPriceNew;

    //TblAppliReplaceExtInfo
    //private java.lang.String appno;
    private java.util.Date appReplaceDate;
    private java.lang.String billsNo;
    //TblApplydtl fields
    //private java.lang.String appno;
    private java.util.Date txdate;
    private java.lang.String brcode;
    private java.lang.String tlrcd;
    private java.lang.String tlsrno;
    private java.util.Date txtime;
    private java.lang.String funccode;
    private java.lang.String attitude;
    private java.lang.String roleId;
    private java.lang.String role;
    private java.lang.String reason;

    //TblAppliMoniCreditInfo
    //private java.lang.String appno;
    //private java.lang.String curcd;
    private java.math.BigDecimal limitSum;
    private java.math.BigDecimal limitSingle;
    //private java.util.Date startDate;
    //private java.util.Date endDate;
    private java.math.BigDecimal userdLimit;
    //private java.lang.String description;
    private java.lang.String useType;


    /** 流程模板信息  */
    private java.lang.String packageId;  //流程包id
    private java.lang.String templateId;  //流程模板id

    //TblAppliMoniMortReal
    //private java.lang.String appno;
    //private java.lang.String mortgageClass;
    //private java.lang.String mortgageSubClass;
    //private java.util.Date startDate;
    //private java.util.Date endDate;
    //private java.lang.String status;


    //TblAppliContBaseInfo
//	private java.lang.String appno;
//	private java.lang.String supplyChainPdId;
//	private java.lang.String curcd;
//	private java.math.BigDecimal contAmount;
//	private java.util.Date signDate;
//	private java.util.Date startDate;
//	private java.util.Date endDate;
//	private java.lang.String financingType;
    private java.lang.String netSlaveId;
    private java.lang.String netMastId;
    private java.lang.String assureType;
    private java.math.BigDecimal firstBailRatio;
    //private java.lang.String description;


    //talProductIndustryType
	private String industryType;

	//TblAppliContSlaveInfo
//	private java.lang.String appno;
//	private java.lang.String slaveContno;
    private java.lang.String slaveContType;
//	private java.lang.String custcd;
//	private java.lang.String curcd;
    private java.math.BigDecimal slaveContAmt;
    private java.math.BigDecimal preAmt;
    private java.math.BigDecimal moniCreditAmout;
//	private java.util.Date signDate;
//	private java.util.Date startDate;
//	private java.util.Date endDate;
//	private java.lang.String description;
    private java.lang.String mortHoldDesc;
    private java.lang.String mortQualityDesc;
    private java.lang.String planMoniEnt;
    private java.util.Date planStorageDate;

    //TblAppliContInvoiceInfo
    //private java.lang.String appno;
    private java.lang.Integer contTradeId;
    private java.lang.String invoiceType;
    private java.lang.String invoiceCode;
    private java.lang.String invoiceNo;
    private java.lang.String invoiceName;
    private java.math.BigDecimal invoiceAmount;
    private java.util.Date invoiceDate;
    private java.util.Date invoiceDueDate;
    private java.lang.String invoiceStartPos;
    private java.lang.String invoiceEndPos;
    private java.util.Date invoiceSendDate;
    private java.lang.String invoiceDesc;
    private java.lang.Integer invoiceNum;
    private java.math.BigDecimal invoicePrice;
    private java.math.BigDecimal invoiceTotalValue;
    //private java.lang.String description;

    //TblAppliContInvoiceInfo改过后的
    private java.math.BigDecimal useableAmount;
    private java.math.BigDecimal pricerateAmount;
    private java.math.BigDecimal userdAmount;
    private java.lang.String invoiceNumName;
    private java.lang.String sallerName;
    private java.lang.String sallerNo;
    private java.lang.String buyNo;
    private java.lang.String secret1;
    private java.lang.String secret2;
    private java.lang.Boolean  select;

    //TblAppliContTradeInfo
    //private java.lang.String appno;
    //private java.lang.String mastContno;
    private java.lang.String tradeContno;
    private java.math.BigDecimal tradeContAmt;
    private java.lang.String buyName;
    private java.lang.String sellName;
    //private java.util.Date signDate;
    private java.lang.String loanDesc;
    private java.lang.String tradeDesc;
    //private java.lang.String description;

    // TblCurrencyInfo
    //private java.lang.String curcd;
    private java.lang.String cname;
    private java.lang.String ename;
    private java.lang.String cursymbol;
    private java.lang.String isusd;
    private java.math.BigDecimal cursecunit;
    private java.math.BigDecimal currndunit;
    private java.lang.Integer iscurexch;
    private java.lang.String iscureuro;
    private java.lang.Integer minbillunit;
    private java.lang.Integer minexchunit;
    private java.lang.Integer minchgunit;
    private java.lang.Integer dratedays;
    private java.util.Date lstupdts;

    //TblBusinessProduct
    //private Integer id;
    private String productName;//产品名称
    private String productType;//产品类型，大类，中类，小类
    private String parentId;//父产品ID
    private String productId;//产品代码
    private String maxProductName;//产品大类
    private String maxProductId;//产品大类ID
    private String middProductName;//产品中类
    private String middProductId;//产品中类ID
    private java.util.Date activeDate;//产品生效日期

    // TblCustBaseInfo
    private java.lang.String idtype;// 证件类型
    private java.lang.String idno;	// 证件号
    private java.lang.String custno;
    private java.lang.String aliasName;
    private java.lang.String orgCode;
    private java.lang.String licenseNo;
    private java.util.Date licenseDate;
    private java.lang.String lastUpdTlrcd;
    private java.util.Date lastUpdTime;
    private java.lang.String custType;
    private java.util.Date openDate;
    private java.util.Date coreOpenDate;
    private java.lang.String custStatus;
    // TblContSlaveInfo
//	private java.lang.String slaveContno;
    // fields
    private java.lang.String mastContno;
    private java.lang.String mastContcode;
    private java.lang.String mastContCode;
//	private java.lang.String slaveContType;
//	private java.lang.String custcd;
//	private java.lang.String curcd;
//	private java.math.BigDecimal slaveContAmt;
//	private java.math.BigDecimal preAmt;
//	private java.util.Date signDate;
//	private java.util.Date startDate;
//	private java.util.Date endDate;
//	private java.lang.String description;
//	private java.lang.String mortHoldDesc;
//	private java.lang.String mortQualityDesc;
//	private java.lang.String planMoniEnt;
//	private java.util.Date planStorageDate;
    private java.lang.String warehouseId;
    private java.lang.String manufacturer;

    private java.lang.String button;

    // TblAppliEntryNet
//	private java.lang.String appno;
    private java.lang.Integer srvNetId;
    private java.lang.String memberCustcd;
    private java.lang.String memberRole;
//	private java.lang.String description;

    // TblAppliCreatNet
//	private java.lang.String appno;
    private java.lang.Integer netNo;
    private java.lang.String netName;
//	private java.lang.String description;

    private java.lang.String tradeContId;
    private java.lang.String tradeContIdName;

    //TblAppliMortgagePrice
    //private java.lang.String appno;
    //private java.lang.String mortgageNo;
    //private java.util.Date txdate;
    private java.lang.String priceWay;
    private java.lang.String priceBasis;
    private java.lang.String priceSource;
    //private java.lang.String description;
    private java.lang.String evalOrg;
    private java.lang.String evalTime;
    //private java.lang.String curcd;
    private java.math.BigDecimal priceOld;
    private java.math.BigDecimal priceNew;
    //private java.math.BigDecimal price;
    //private java.lang.String tlrcd;
    private java.lang.String ext1;
    private java.lang.String ext2;
    private java.lang.String ext3;

    //TblMortgageBillStand
    private java.lang.String billno;
    private java.lang.String exchangeName;
    private java.lang.String seatcd;
    private java.lang.String tradecd;
    private java.lang.String address;
    private java.lang.String postno;
    private java.lang.String storageAddress;
    private java.lang.String phone;
    private java.lang.String fax;
    private java.lang.String standLose;
    private java.util.Date storageCostEndDate;
    private java.lang.String gallerycd;
    private java.lang.String galleryName;
    private java.lang.String pawneeName;
    private java.lang.String specialTradeCode;
    private java.lang.String futureCustcd;
    private java.util.Date billDueDate;
    private java.util.Date confirmDate;
	private java.lang.String registrationNum;

    //TblAppliMortgageBillStand
    private java.lang.String mortgageLevelOne;
    private java.lang.String mortgageLevelTwo;
    private java.lang.String mortgageLevelThree;
    private java.lang.String mortgageLevelFour;
    private java.lang.String mortgageLevelFive;
    private java.lang.String mortgageLevelSix;
    private java.math.BigDecimal originalPrice;
    private java.math.BigDecimal originalTotPrice;
    private java.math.BigDecimal marketPrice;
    private java.math.BigDecimal confirmPrice;
    private java.lang.String stockStatus;
    private java.lang.String vender;
    private java.lang.String productArea;
    private java.lang.String incomeNo;
    private java.math.BigDecimal ration;
    private java.lang.String wrappage;
    private java.lang.String qualityLevel;
    private java.lang.String sn;
    private java.lang.String year;
    private java.lang.String billType;
    private java.math.BigDecimal weightAll;
    private java.lang.String weightUnits;
    private java.math.BigDecimal upDownMoney;
    private java.math.BigDecimal billQuantity;
    private java.lang.String exchangeStatus;
    private java.lang.String upDownMoneyFlag;

    //GAOSAIYAO
	private java.lang.String mortgageClassNo;
	private java.lang.String firstAppno;
	private java.util.Date firstStorageDate;

	private java.lang.String suppChainPdType;
	private java.lang.String slaveContcode;


	private java.math.BigDecimal totalRemainAmount;
	private java.math.BigDecimal totalRateAmount;
	private java.math.BigDecimal totalRateRemainAmount;
	private java.math.BigDecimal loanRemainingAmount;
	private java.math.BigDecimal rateCollectAmount;
	private java.math.BigDecimal ownRateCollectAmount;
	private java.math.BigDecimal cashRemainingAmount;
	private java.math.BigDecimal payAmount;

//--------------------------------------------------------------
//gaosaiyao
	private java.lang.String warehouseAddress;
	private java.math.BigDecimal beforeChangePrice;
	private java.math.BigDecimal afterChangePrice;
    //ADD BY GUIXIU.LIU 客户表字段
    private java.lang.String custClass;

    private java.util.Date insertDate;
	private java.util.Date effectDate;
	private java.lang.String type;
	private java.lang.String misc;

	//WorkflowAppInfo
	//added by huaidong.li
	private java.lang.String draftType;
//	private java.lang.String bussType;
	private java.lang.String procName;
	private java.lang.String brhno;
	private java.lang.String custName;
	private java.lang.String currRole;
	private java.lang.String currOprno;
	private java.lang.String oprno;
	private java.util.Date timestamps;

	//add by hui.liu TblPricingMortgageInfo 核价押品信息表
	private java.lang.Integer pid;
	private java.math.BigDecimal oldConfirmPrice;
	private java.math.BigDecimal contPrice;
	private java.math.BigDecimal thirdPartyPrice;
	private java.lang.String approveAccording;
	private java.lang.String confirmAccording;

	private java.lang.Integer custId;
	private java.lang.String transno;
	private java.lang.String procInsId;
	private java.lang.String taskId;
	private java.lang.String taskName;
	private java.lang.String processTemplate;
	private java.util.Date flowStartTime;
	private java.util.Date flowEndTime;
	private java.lang.String flowEndFlag;
	private java.util.Date taskStartTime;
	private java.util.Date taskEndTime;
	private java.lang.String taskEndFlag;
	private java.lang.String roleType;
	private java.lang.String miscflgs;

	private java.math.BigDecimal creditAmt;
	private java.math.BigDecimal stockAmt;
	private java.math.BigDecimal riskAmt;
	private java.math.BigDecimal stockBalanceAmt;//存货余额
	private java.lang.String detail;
	private java.lang.String dataNo;
	private java.util.Date pledgeDate;
	private java.lang.String firCd;
	private java.lang.String billCode;
	private java.lang.String billcode;

	/** add by mingzhao.lan 2011-7-20*/
	private java.lang.Integer handInDate;
	private java.lang.String receiveName;
	private java.lang.String stopReason;
	private java.lang.String reasonType;
	private java.lang.String conventionNo;
	private java.lang.String faultA;
	private java.lang.String faultB;
	private java.lang.String serialno;
	private java.lang.String adviceid;
	private java.lang.String moniCname;
	private java.lang.String moniOfCname;


	private String coreCustcd;//核心厂商
	private String accountAppno;//出账申请号
	private String bussType;//四方保兑仓业务品种
	private String bussTypeName;//
	private String loanWay;//出账方式
	private BigDecimal accountAmountSum;//出账总金额
	private BigDecimal bookMortAmountSum;//订货总金额
	private BigDecimal sendMortAmountSum;//发货总金额

	private String billNos;//票号/贷款编号  组合字符串

	private String firstBailType;
	private BigDecimal bailAmtAdd;
	private BigDecimal okPrice;
	private BigDecimal totalPrice;

	private String noticeId;//通知书编号

	private java.lang.String num;
	private java.lang.String noticeType;
	private java.lang.String mortgageChangeType;
	private java.util.Date pledgorDate;
	private java.util.Date pledgeeDate;
	private java.util.Date moniOfDate;
	private java.util.Date appliDate;
	private java.math.BigDecimal protLowPric;
	private java.lang.String moniOfName;
	private java.util.Date moniOfTimestamp;
	private java.lang.String tlrn;
	private java.lang.String msrno;
	private java.lang.String slaveType;
	private java.math.BigDecimal mortgageAmount;
	private java.lang.Integer handinDate;
	private java.lang.String protocolcode;
	private java.lang.String pledgeorgidcode;
	private java.lang.String pledgeorgidcodetype;
	private java.lang.String adviceackid;
	private java.lang.String pawneeorgid;
	private java.math.BigDecimal pledgeminimumvalue;
	private java.lang.String pledgeitemreceivedate;
	private java.lang.String collateralmanagermemo;
	private java.lang.String adviceackstatus;
	private java.math.BigDecimal money;
	private java.lang.String billNum;

	private java.lang.String secCd;
	private java.lang.String thrCd;

	private BigDecimal bailPercent;//保证金比例
	private BigDecimal quantitySum;//入库数量/ 重量
	private BigDecimal mottgageTotAmount;//入库押品总价值
	private BigDecimal exposureAmount;//业务敞口金额

	private String payStatus;
	private String transferFlag;

	private String sendStatus;//出账信息发货状态

	private String sellerNm;//经销商
	private String coreNm;//核心厂商

	private String lcno;//信用证编号
	private String businesstypename;//业务品种名称
	private String url;//供应链产品配置跳转url

	private String bailType;
	private String accountType;
	private java.math.BigDecimal dismortBailAmount;
	private java.math.BigDecimal billsAmountView;

	private String state;//监管协议状态
	private String moniType;//监管协议类型：1-动态；2-静态

	private Date loanDate;
	private String mortBillAccountNo;
	private BigDecimal mortBillAmount;
	private BigDecimal sumMortBillAmount;
	private BigDecimal sumTransBillAmount;
	private BigDecimal openAmount;
	private BigDecimal SumTransBailAmount;
	private BigDecimal sumBailAmount;
	private String bailAccountno;
	private String tradeContcode;
	private Date applyDate;
	private BigDecimal amountOut;
	private BigDecimal currOutAmt;


	private String moniPriceModel;//是否可调整监管下限
	/**信用证***********/
	private String lccode;

	public String getBailType() {
		return bailType;
	}

	public void setBailType(String bailType) {
		this.bailType = bailType;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBusinesstypename() {
		return businesstypename;
	}

	public void setBusinesstypename(String businesstypename) {
		this.businesstypename = businesstypename;
	}

	public String getLcno() {
		return lcno;
	}

	public void setLcno(String lcno) {
		this.lcno = lcno;
	}

	public OldApplyVO(){}

	public OldApplyVO(String appno,String piid,String workflowAppno,String processTemplateName,String custcd,java.util.Date startTime,String appliStatusDtl,String startTlrcd){
		this.setProcessTemplateName(processTemplateName);
		this.setCustcd(custcd);
		this.setStartTime(startTime);
		this.setAppliStatusDtl(appliStatusDtl);
		this.setStartTlrcd(startTlrcd);
		this.setPiid(piid);
		this.setAppno(appno);
		this.setWorkflowAppno(workflowAppno);
	}

	public String getSellerNm() {
		return sellerNm;
	}
	public void setSellerNm(String sellerNm) {
		this.sellerNm = sellerNm;
	}
	public String getCoreNm() {
		return coreNm;
	}
	public void setCoreNm(String coreNm) {
		this.coreNm = coreNm;
	}
	public String getSendStatus() {
		return sendStatus;
	}
	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
	}
	public BigDecimal getBailPercent() {
		return bailPercent;
	}
	public void setBailPercent(BigDecimal bailPercent) {
		this.bailPercent = bailPercent;
	}
	public java.lang.String getSecCd() {
		return secCd;
	}
	public BigDecimal getQuantitySum() {
		return quantitySum;
	}
	public void setQuantitySum(BigDecimal quantitySum) {
		this.quantitySum = quantitySum;
	}
	public BigDecimal getMottgageTotAmount() {
		return mottgageTotAmount;
	}
	public void setMottgageTotAmount(BigDecimal mottgageTotAmount) {
		this.mottgageTotAmount = mottgageTotAmount;
	}
	public BigDecimal getExposureAmount() {
		return exposureAmount;
	}
	public void setExposureAmount(BigDecimal exposureAmount) {
		this.exposureAmount = exposureAmount;
	}
	public void setSecCd(java.lang.String secCd) {
		this.secCd = secCd;
	}
	public java.lang.String getThrCd() {
		return thrCd;
	}
	public void setThrCd(java.lang.String thrCd) {
		this.thrCd = thrCd;
	}
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	public String getBillNos() {
		return billNos;
	}
	public void setBillNos(String billNos) {
		this.billNos = billNos;
	}
	public BigDecimal getAccountAmountSum() {
		return accountAmountSum;
	}
	public void setAccountAmountSum(BigDecimal accountAmountSum) {
		this.accountAmountSum = accountAmountSum;
	}
	public BigDecimal getBookMortAmountSum() {
		return bookMortAmountSum;
	}
	public void setBookMortAmountSum(BigDecimal bookMortAmountSum) {
		this.bookMortAmountSum = bookMortAmountSum;
	}
	public BigDecimal getSendMortAmountSum() {
		return sendMortAmountSum;
	}
	public void setSendMortAmountSum(BigDecimal sendMortAmountSum) {
		this.sendMortAmountSum = sendMortAmountSum;
	}
	//TBL_APPLY_BUSS_BASE_INFO
	private java.lang.String custcdBuyer;
	private java.lang.String custcdSaller;
	private java.lang.String applyType;
	private java.util.Date purchaseDate;
	private java.lang.Integer debtNum;
	private java.math.BigDecimal totalDebtAmount;
	private java.lang.String chargeType;
	private java.lang.String finacingDiscountType;
	private java.math.BigDecimal finacingCost;
	private java.math.BigDecimal cost;
	private java.math.BigDecimal handlingFee;
	private java.math.BigDecimal reduceAmount;
	private java.math.BigDecimal totalFee;
	private java.math.BigDecimal totalReduce;
	private java.math.BigDecimal receiveAmount;
	private java.lang.String costAccount;
	private java.lang.String accountNo;
	private java.lang.String payDayMonth;
	private java.lang.String rateCollectType;
	private java.lang.String overDueRate;
	private java.lang.String executeRate;
	private java.lang.String upDownPercent;
	private java.lang.String upDown;
	private java.lang.String baseRate;
	private java.lang.String rateId;
	private java.lang.String rateType;
	private java.lang.String loanType;
	private java.lang.String bankno;
	private java.lang.String brcode2;
	private java.math.BigDecimal amount;
	private java.lang.Integer loanDays;
	private java.util.Date billDate;
	private java.util.Date billEndDate;
	private java.lang.String orderNo;
	private java.math.BigDecimal orderAmt;
	private java.lang.String balanceAccount;
	private java.math.BigDecimal bailAmt;
	private java.lang.String bailAccount;
	private java.lang.String billAccount;
	private java.lang.String coreAccount;
	private java.util.Date appLoanDate;
	private java.util.Date loanDueDate;
	private java.util.Date returnDate;
	private java.lang.String returnType;
	private java.lang.String returnMethod;
	private java.math.BigDecimal returnAmount;
	private java.math.BigDecimal returnInterestAmount;
	private java.math.BigDecimal returnCapitalAmount;
	private java.math.BigDecimal toSallerAmount;
	private java.math.BigDecimal toPoolAmount;
	private java.lang.String toSallerFlag;
	private java.lang.String otherReason;
	private java.lang.String commonDate;
	private java.math.BigDecimal totalVariances;
	private java.lang.String deductionsAccount;
	private String debetNo;
	private String debetId;
	private java.lang.Integer billId;
	private java.lang.String billNo;
	private java.math.BigDecimal lnciAmt;
	private java.math.BigDecimal refundAmount;
	private java.math.BigDecimal businessOpenAmount;
	private java.lang.String creditNo;

	private java.lang.String actno;//经销商结算账号
	private java.lang.String bailActno;//经销商保证金账号

	private java.lang.String drawType;
	private java.lang.String confirmStatus;

	 /** 产品渠道模式中使用*/
	 private String sellarId;
	private String sellarRZId;
	 private String buyerId;
	 private String buyerRZId;
	 private String moniId;
	 private String companyNetSilver;
	 private String bankDirectCompany;
	 private String belowLineFlag;
	 private String sellerCompanyNetSilver;
	 private String sellerBankDirectCompany;
	 private String sellerBelowLineFlag;
	 private String buyerRZCompanyNetSilver;
	 private String buyerRZBankDirectCompany;
	 private String buyerRZBelowLineFlag;
	 private String sellerRZCompanyNetSilver;
	 private String sellerRZBankDirectCompany;
	 private String sellerRZBelowLineFlag;
	 private String buyerCompanyNetSilver;
	 private String buyerBankDirectCompany;
	 private String buyerBelowLineFlag;
	 private String moniCompanyNetSilver;
	 private String moniBankDirectCompany;
	 private String moniBelowLineFlag;
	 private java.lang.String busiPhase;

	 private java.math.BigDecimal debtAmount;//敞口
	 private java.math.BigDecimal mortAmount;//货物总价值

	public java.lang.String getCreditNo() {
		return creditNo;
	}

	public void setCreditNo(java.lang.String creditNo) {
		this.creditNo = creditNo;
	}

	public java.math.BigDecimal getLnciAmt() {
		return lnciAmt;
	}
	public void setLnciAmt(java.math.BigDecimal lnciAmt) {
		this.lnciAmt = lnciAmt;
	}
	public java.math.BigDecimal getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(java.math.BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}
	public java.math.BigDecimal getBusinessOpenAmount() {
		return businessOpenAmount;
	}
	public void setBusinessOpenAmount(java.math.BigDecimal businessOpenAmount) {
		this.businessOpenAmount = businessOpenAmount;
	}
	public java.lang.Integer getBillId() {
		return billId;
	}
	public void setBillId(java.lang.Integer billId) {
		this.billId = billId;
	}
	public java.lang.String getBillNo() {
		return billNo;
	}
	public void setBillNo(java.lang.String billNo) {
		this.billNo = billNo;
	}
	private String fourProtocolNo;//四方保兑仓协议
	private String fourProtocolCode;//四方保兑仓协议

	public String getFourProtocolNo() {
		return fourProtocolNo;
	}
	public void setFourProtocolNo(String fourProtocolNo) {
		this.fourProtocolNo = fourProtocolNo;
	}
	public String getDebetNo() {
		return debetNo;
	}
	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}
	public java.math.BigDecimal getTotalVariances() {
		return totalVariances;
	}
	public void setTotalVariances(java.math.BigDecimal totalVariances) {
		this.totalVariances = totalVariances;
	}
	public java.lang.String getDeductionsAccount() {
		return deductionsAccount;
	}
	public void setDeductionsAccount(java.lang.String deductionsAccount) {
		this.deductionsAccount = deductionsAccount;
	}
	public String getBussType() {
		return bussType;
	}
	public void setBussType(String bussType) {
		this.bussType = bussType;
	}
	public String getAccountAppno() {
		return accountAppno;
	}
	public void setAccountAppno(String accountAppno) {
		this.accountAppno = accountAppno;
	}
	public String getCoreCustcd() {
		return coreCustcd;
	}
	public void setCoreCustcd(String coreCustcd) {
		this.coreCustcd = coreCustcd;
	}
	public java.lang.String getSerialno() {
		return serialno;
	}
	public void setSerialno(java.lang.String serialno) {
		this.serialno = serialno;
	}
	public java.lang.String getMoniCname() {
		return moniCname;
	}
	public void setMoniCname(java.lang.String moniCname) {
		this.moniCname = moniCname;
	}
	public java.lang.String getMoniOfCname() {
		return moniOfCname;
	}
	public void setMoniOfCname(java.lang.String moniOfCname) {
		this.moniOfCname = moniOfCname;
	}
	public java.lang.String getDraftType() {
		return draftType;
	}
	public void setDraftType(java.lang.String draftType) {
		this.draftType = draftType;
	}
	public java.lang.String getProcName() {
		return procName;
	}
	public void setProcName(java.lang.String procName) {
		this.procName = procName;
	}
	public java.lang.String getBrhno() {
		return brhno;
	}
	public void setBrhno(java.lang.String brhno) {
		this.brhno = brhno;
	}
	public java.lang.String getCustName() {
		return custName;
	}
	public void setCustName(java.lang.String custName) {
		this.custName = custName;
	}
	public java.lang.String getCurrRole() {
		return currRole;
	}
	public void setCurrRole(java.lang.String currRole) {
		this.currRole = currRole;
	}
	public java.lang.String getCurrOprno() {
		return currOprno;
	}
	public void setCurrOprno(java.lang.String currOprno) {
		this.currOprno = currOprno;
	}
	public java.lang.String getOprno() {
		return oprno;
	}
	public void setOprno(java.lang.String oprno) {
		this.oprno = oprno;
	}
	public java.util.Date getTimestamps() {
		return timestamps;
	}
	public void setTimestamps(java.util.Date timestamps) {
		this.timestamps = timestamps;
	}
	public java.lang.String getCustClass() {
        return custClass;
    }
    public void setCustClass(java.lang.String custClass) {
        this.custClass = custClass;
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
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
    public String  getParentId() {
        return parentId;
    }
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public java.lang.String getProductName() {
        return productName;
    }
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }
    /**
     * @return the netSlaveId
     */
    public java.lang.String getNetSlaveId() {
        return netSlaveId;
    }
    /**
     * @param netSlaveId the netSlaveId to set
     */
    public void setNetSlaveId(java.lang.String netSlaveId) {
        this.netSlaveId = netSlaveId;
    }
    /**
     * @return the netMastId
     */
    public java.lang.String getNetMastId() {
        return netMastId;
    }
    /**
     * @param netMastId the netMastId to set
     */
    public void setNetMastId(java.lang.String netMastId) {
        this.netMastId = netMastId;
    }
    public java.lang.String getAssureType() {
        return assureType;
    }
    public void setAssureType(java.lang.String assureType) {
        this.assureType = assureType;
    }
    public java.math.BigDecimal getFirstBailRatio() {
        return firstBailRatio;
    }
    public void setFirstBailRatio(java.math.BigDecimal firstBailRatio) {
        this.firstBailRatio = firstBailRatio;
    }
    public java.lang.String getSlaveContType() {
        return slaveContType;
    }
    public void setSlaveContType(java.lang.String slaveContType) {
        this.slaveContType = slaveContType;
    }
    public java.math.BigDecimal getSlaveContAmt() {
        return slaveContAmt;
    }
    public void setSlaveContAmt(java.math.BigDecimal slaveContAmt) {
        this.slaveContAmt = slaveContAmt;
    }
    public java.math.BigDecimal getPreAmt() {
        return preAmt;
    }
    public void setPreAmt(java.math.BigDecimal preAmt) {
        this.preAmt = preAmt;
    }
    public java.lang.String getMortHoldDesc() {
        return mortHoldDesc;
    }
    public void setMortHoldDesc(java.lang.String mortHoldDesc) {
        this.mortHoldDesc = mortHoldDesc;
    }
    public java.lang.String getMortQualityDesc() {
        return mortQualityDesc;
    }
    public void setMortQualityDesc(java.lang.String mortQualityDesc) {
        this.mortQualityDesc = mortQualityDesc;
    }
    public java.lang.String getPlanMoniEnt() {
        return planMoniEnt;
    }
    public void setPlanMoniEnt(java.lang.String planMoniEnt) {
        this.planMoniEnt = planMoniEnt;
    }
    public java.util.Date getPlanStorageDate() {
        return planStorageDate;
    }
    public void setPlanStorageDate(java.util.Date planStorageDate) {
        this.planStorageDate = planStorageDate;
    }
    public java.lang.String getAppno() {
        return appno;
    }
    public void setAppno(java.lang.String appno) {
        this.appno = appno;
    }
    public java.lang.String getSupplyChainPdId() {
        return supplyChainPdId;
    }
    public void setSupplyChainPdId(java.lang.String supplyChainPdId) {
        this.supplyChainPdId = supplyChainPdId;
    }
    public java.lang.String getCustcd() {
        return custcd;
    }
    public void setCustcd(java.lang.String custcd) {
        this.custcd = custcd;
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
    public java.lang.String getStatus() {
        return status;
    }
    public void setStatus(java.lang.String status) {
        this.status = status;
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
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
//	public java.lang.String getId() {
//		return id;
//	}
//	public void setId(java.lang.String id) {
//		this.id = id;
//	}
    public java.lang.String getPiid() {
        return piid;
    }
    public void setPiid(java.lang.String piid) {
        this.piid = piid;
    }
    public java.lang.String getAppliType() {
        return appliType;
    }
    public void setAppliType(java.lang.String appliType) {
        this.appliType = appliType;
    }
    public java.lang.String getProcessTemplateName() {
        return processTemplateName;
    }
    public void setProcessTemplateName(java.lang.String processTemplateName) {
        this.processTemplateName = processTemplateName;
    }
    public java.lang.String getBusinessnoType() {
        return businessnoType;
    }
    public void setBusinessnoType(java.lang.String businessnoType) {
        this.businessnoType = businessnoType;
    }
    public java.lang.String getContno() {
        return contno;
    }
    public void setContno(java.lang.String contno) {
        this.contno = contno;
    }
    public java.math.BigDecimal getAmt() {
        return amt;
    }
    public void setAmt(java.math.BigDecimal amt) {
        this.amt = amt;
    }
    public java.lang.String getStartBrcode() {
        return startBrcode;
    }
    public void setStartBrcode(java.lang.String startBrcode) {
        this.startBrcode = startBrcode;
    }
    public java.lang.String getStartTlrcd() {
        return startTlrcd;
    }
    public void setStartTlrcd(java.lang.String startTlrcd) {
        this.startTlrcd = startTlrcd;
    }
    public java.util.Date getStratDate() {
        return stratDate;
    }
    public void setStratDate(java.util.Date stratDate) {
        this.stratDate = stratDate;
    }
    public java.util.Date getStartTime() {
        return startTime;
    }
    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }
    public java.lang.String getAppliStatus() {
        return appliStatus;
    }
    public void setAppliStatus(java.lang.String appliStatus) {
        this.appliStatus = appliStatus;
    }
    public java.lang.String getApproveBrcode() {
        return approveBrcode;
    }
    public void setApproveBrcode(java.lang.String approveBrcode) {
        this.approveBrcode = approveBrcode;
    }
    public java.lang.String getApprover() {
        return approver;
    }
    public void setApprover(java.lang.String approver) {
        this.approver = approver;
    }
    public java.util.Date getApproveDate() {
        return approveDate;
    }
    public void setApproveDate(java.util.Date approveDate) {
        this.approveDate = approveDate;
    }
    public java.util.Date getApproveTime() {
        return approveTime;
    }
    public void setApproveTime(java.util.Date approveTime) {
        this.approveTime = approveTime;
    }
    public java.lang.String getWorkflowAppno() {
        return workflowAppno;
    }
    public void setWorkflowAppno(java.lang.String workflowAppno) {
        this.workflowAppno = workflowAppno;
    }
    public java.lang.String getAppliChkWarnClass() {
        return appliChkWarnClass;
    }
    public void setAppliChkWarnClass(java.lang.String appliChkWarnClass) {
        this.appliChkWarnClass = appliChkWarnClass;
    }
    public java.lang.String getAppliChkWarnCode() {
        return appliChkWarnCode;
    }
    public void setAppliChkWarnCode(java.lang.String appliChkWarnCode) {
        this.appliChkWarnCode = appliChkWarnCode;
    }
    public java.math.BigDecimal getContAmount() {
        return contAmount;
    }
    public void setContAmount(java.math.BigDecimal contAmount) {
        this.contAmount = contAmount;
    }
    public java.util.Date getSignDate() {
        return signDate;
    }
    public void setSignDate(java.util.Date signDate) {
        this.signDate = signDate;
    }
    public java.lang.String getFinancingType() {
        return financingType;
    }
    public void setFinancingType(java.lang.String financingType) {
        this.financingType = financingType;
    }
    public java.lang.String getAppliMortBizType() {
        return appliMortBizType;
    }
    public void setAppliMortBizType(java.lang.String appliMortBizType) {
        this.appliMortBizType = appliMortBizType;
    }
    public java.lang.String getMortgageNo() {
        return mortgageNo;
    }
    public void setMortgageNo(java.lang.String mortgageNo) {
        this.mortgageNo = mortgageNo;
    }
    public java.lang.String getMortgageBizType() {
        return mortgageBizType;
    }
    public void setMortgageBizType(java.lang.String mortgageBizType) {
        this.mortgageBizType = mortgageBizType;
    }
    public java.lang.String getMortgageClass() {
        return mortgageClass;
    }
    public void setMortgageClass(java.lang.String mortgageClass) {
        this.mortgageClass = mortgageClass;
    }
    public java.lang.String getMortgageSubClass() {
        return mortgageSubClass;
    }
    public void setMortgageSubClass(java.lang.String mortgageSubClass) {
        this.mortgageSubClass = mortgageSubClass;
    }
    public java.lang.String getMonitorProtocolNo() {
        return monitorProtocolNo;
    }
    public void setMonitorProtocolNo(java.lang.String monitorProtocolNo) {
        this.monitorProtocolNo = monitorProtocolNo;
    }
    public java.lang.String getOtherProtocolNo() {
        return otherProtocolNo;
    }
    public void setOtherProtocolNo(java.lang.String otherProtocolNo) {
        this.otherProtocolNo = otherProtocolNo;
    }
    public java.lang.String getMortgageModel() {
        return mortgageModel;
    }
    public void setMortgageModel(java.lang.String mortgageModel) {
        this.mortgageModel = mortgageModel;
    }
    public java.lang.String getSlaveContno() {
        return slaveContno;
    }
    public void setSlaveContno(java.lang.String slaveContno) {
        this.slaveContno = slaveContno;
    }
    public java.lang.String getMortgageUnits() {
        return mortgageUnits;
    }
    public void setMortgageUnits(java.lang.String mortgageUnits) {
        this.mortgageUnits = mortgageUnits;
    }
    public java.math.BigDecimal getQuantity() {
        return quantity;
    }
    public void setQuantity(java.math.BigDecimal quantity) {
        this.quantity = quantity;
    }
    public java.math.BigDecimal getPrice() {
        return price;
    }
    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }
    public java.math.BigDecimal getTotPrice() {
        return totPrice;
    }
    public void setTotPrice(java.math.BigDecimal totPrice) {
        this.totPrice = totPrice;
    }
    public java.lang.String getDescription1() {
        return description1;
    }
    public void setDescription1(java.lang.String description1) {
        this.description1 = description1;
    }
    public java.lang.String getProtocolNo() {
        return protocolNo;
    }
    public void setProtocolNo(java.lang.String protocolNo) {
        this.protocolNo = protocolNo;
    }
    public java.lang.String getProtocolType() {
        return protocolType;
    }
    public void setProtocolType(java.lang.String protocolType) {
        this.protocolType = protocolType;
    }
    public java.lang.String getCurcd() {
        return curcd;
    }
    public void setCurcd(java.lang.String curcd) {
        this.curcd = curcd;
    }
    public java.math.BigDecimal getProtAmt() {
        return protAmt;
    }
    public void setProtAmt(java.math.BigDecimal protAmt) {
        this.protAmt = protAmt;
    }
    public java.lang.String getFirName() {
        return firName;
    }
    public void setFirName(java.lang.String firName) {
        this.firName = firName;
    }
    public java.lang.String getFirAddress() {
        return firAddress;
    }
    public void setFirAddress(java.lang.String firAddress) {
        this.firAddress = firAddress;
    }
    public java.lang.String getFirLegal() {
        return firLegal;
    }
    public void setFirLegal(java.lang.String firLegal) {
        this.firLegal = firLegal;
    }
    public java.lang.String getFirActUbankno() {
        return firActUbankno;
    }
    public void setFirActUbankno(java.lang.String firActUbankno) {
        this.firActUbankno = firActUbankno;
    }
    public java.lang.String getFirActno() {
        return firActno;
    }
    public void setFirActno(java.lang.String firActno) {
        this.firActno = firActno;
    }
    public java.lang.String getFirTel() {
        return firTel;
    }
    public void setFirTel(java.lang.String firTel) {
        this.firTel = firTel;
    }
    public java.lang.String getFirRole() {
        return firRole;
    }
    public void setFirRole(java.lang.String firRole) {
        this.firRole = firRole;
    }
    public java.lang.String getSecName() {
        return secName;
    }
    public void setSecName(java.lang.String secName) {
        this.secName = secName;
    }
    public java.lang.String getSecAddress() {
        return secAddress;
    }
    public void setSecAddress(java.lang.String secAddress) {
        this.secAddress = secAddress;
    }
    public java.lang.String getSecLegal() {
        return secLegal;
    }
    public void setSecLegal(java.lang.String secLegal) {
        this.secLegal = secLegal;
    }
    public java.lang.String getSecActUbankno() {
        return secActUbankno;
    }
    public void setSecActUbankno(java.lang.String secActUbankno) {
        this.secActUbankno = secActUbankno;
    }
    public java.lang.String getSecActno() {
        return secActno;
    }
    public void setSecActno(java.lang.String secActno) {
        this.secActno = secActno;
    }
    public java.lang.String getSecTel() {
        return secTel;
    }
    public void setSecTel(java.lang.String secTel) {
        this.secTel = secTel;
    }
    public java.lang.String getSecRole() {
        return secRole;
    }
    public void setSecRole(java.lang.String secRole) {
        this.secRole = secRole;
    }
    public java.lang.String getThrName() {
        return thrName;
    }
    public void setThrName(java.lang.String thrName) {
        this.thrName = thrName;
    }
    public java.lang.String getThrAddress() {
        return thrAddress;
    }
    public void setThrAddress(java.lang.String thrAddress) {
        this.thrAddress = thrAddress;
    }
    public java.lang.String getThrLegal() {
        return thrLegal;
    }
    public void setThrLegal(java.lang.String thrLegal) {
        this.thrLegal = thrLegal;
    }
    public java.lang.String getThrActUbankno() {
        return thrActUbankno;
    }
    public void setThrActUbankno(java.lang.String thrActUbankno) {
        this.thrActUbankno = thrActUbankno;
    }
    public java.lang.String getThrActno() {
        return thrActno;
    }
    public void setThrActno(java.lang.String thrActno) {
        this.thrActno = thrActno;
    }
    public java.lang.String getThrTel() {
        return thrTel;
    }
    public void setThrTel(java.lang.String thrTel) {
        this.thrTel = thrTel;
    }
    public java.lang.String getThrRole() {
        return thrRole;
    }
    public void setThrRole(java.lang.String thrRole) {
        this.thrRole = thrRole;
    }
    public java.lang.String getFouFirName() {
        return fouFirName;
    }
    public void setFouFirName(java.lang.String fouFirName) {
        this.fouFirName = fouFirName;
    }
    public java.lang.String getFouAddress() {
        return fouAddress;
    }
    public void setFouAddress(java.lang.String fouAddress) {
        this.fouAddress = fouAddress;
    }
    public java.lang.String getFouLegal() {
        return fouLegal;
    }
    public void setFouLegal(java.lang.String fouLegal) {
        this.fouLegal = fouLegal;
    }
    public java.lang.String getFouActUbankno() {
        return fouActUbankno;
    }
    public void setFouActUbankno(java.lang.String fouActUbankno) {
        this.fouActUbankno = fouActUbankno;
    }
    public java.lang.String getFouActno() {
        return fouActno;
    }
    public void setFouActno(java.lang.String fouActno) {
        this.fouActno = fouActno;
    }
    public java.lang.String getFouTel() {
        return fouTel;
    }
    public void setFouTel(java.lang.String fouTel) {
        this.fouTel = fouTel;
    }
    public java.lang.String getFouRole() {
        return fouRole;
    }
    public void setFouRole(java.lang.String fouRole) {
        this.fouRole = fouRole;
    }
    public java.lang.String getMutiProtStatus() {
        return mutiProtStatus;
    }
    public void setMutiProtStatus(java.lang.String mutiProtStatus) {
        this.mutiProtStatus = mutiProtStatus;
    }
    public java.lang.String getMoniOfCustcd() {
        return moniOfCustcd;
    }
    public void setMoniOfCustcd(java.lang.String moniOfCustcd) {
        this.moniOfCustcd = moniOfCustcd;
    }
    public java.lang.String getMoniModel() {
        return moniModel;
    }
    public void setMoniModel(java.lang.String moniModel) {
        this.moniModel = moniModel;
    }
    public java.math.BigDecimal getLowPriceNew() {
        return lowPriceNew;
    }
    public void setLowPriceNew(java.math.BigDecimal lowPriceNew) {
        this.lowPriceNew = lowPriceNew;
    }
    public java.util.Date getAppReplaceDate() {
        return appReplaceDate;
    }
    public void setAppReplaceDate(java.util.Date appReplaceDate) {
        this.appReplaceDate = appReplaceDate;
    }
    public java.util.Date getTxdate() {
        return txdate;
    }
    public void setTxdate(java.util.Date txdate) {
        this.txdate = txdate;
    }
    public java.lang.String getBrcode() {
        return brcode;
    }
    public void setBrcode(java.lang.String brcode) {
        this.brcode = brcode;
    }
    public java.lang.String getTlrcd() {
        return tlrcd;
    }
    public void setTlrcd(java.lang.String tlrcd) {
        this.tlrcd = tlrcd;
    }
    public java.lang.String getTlsrno() {
        return tlsrno;
    }
    public void setTlsrno(java.lang.String tlsrno) {
        this.tlsrno = tlsrno;
    }
    public java.util.Date getTxtime() {
        return txtime;
    }
    public void setTxtime(java.util.Date txtime) {
        this.txtime = txtime;
    }
    public java.lang.String getFunccode() {
        return funccode;
    }
    public void setFunccode(java.lang.String funccode) {
        this.funccode = funccode;
    }
    public java.lang.String getAttitude() {
        return attitude;
    }
    public void setAttitude(java.lang.String attitude) {
        this.attitude = attitude;
    }
    public java.lang.String getRoleId() {
        return roleId;
    }
    public void setRoleId(java.lang.String roleId) {
        this.roleId = roleId;
    }
    public java.lang.String getReason() {
        return reason;
    }
    public void setReason(java.lang.String reason) {
        this.reason = reason;
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
    public java.lang.Integer getContTradeId() {
        return contTradeId;
    }
    public void setContTradeId(java.lang.Integer contTradeId) {
        this.contTradeId = contTradeId;
    }
    public java.lang.String getInvoiceType() {
        return invoiceType;
    }
    public void setInvoiceType(java.lang.String invoiceType) {
        this.invoiceType = invoiceType;
    }
    public java.lang.String getInvoiceCode() {
        return invoiceCode;
    }
    public void setInvoiceCode(java.lang.String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }
    public java.lang.String getInvoiceNo() {
        return invoiceNo;
    }
    public void setInvoiceNo(java.lang.String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }
    public java.lang.String getInvoiceName() {
        return invoiceName;
    }
    public void setInvoiceName(java.lang.String invoiceName) {
        this.invoiceName = invoiceName;
    }
    public java.math.BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }
    public void setInvoiceAmount(java.math.BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }
    public java.util.Date getInvoiceDate() {
        return invoiceDate;
    }
    public void setInvoiceDate(java.util.Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    public java.util.Date getInvoiceDueDate() {
        return invoiceDueDate;
    }
    public void setInvoiceDueDate(java.util.Date invoiceDueDate) {
        this.invoiceDueDate = invoiceDueDate;
    }
    public java.lang.String getInvoiceStartPos() {
        return invoiceStartPos;
    }
    public void setInvoiceStartPos(java.lang.String invoiceStartPos) {
        this.invoiceStartPos = invoiceStartPos;
    }
    public java.lang.String getInvoiceEndPos() {
        return invoiceEndPos;
    }
    public void setInvoiceEndPos(java.lang.String invoiceEndPos) {
        this.invoiceEndPos = invoiceEndPos;
    }
    public java.util.Date getInvoiceSendDate() {
        return invoiceSendDate;
    }
    public void setInvoiceSendDate(java.util.Date invoiceSendDate) {
        this.invoiceSendDate = invoiceSendDate;
    }
    public java.lang.String getInvoiceDesc() {
        return invoiceDesc;
    }
    public void setInvoiceDesc(java.lang.String invoiceDesc) {
        this.invoiceDesc = invoiceDesc;
    }
    public java.lang.Integer getInvoiceNum() {
        return invoiceNum;
    }
    public void setInvoiceNum(java.lang.Integer invoiceNum) {
        this.invoiceNum = invoiceNum;
    }
    public java.math.BigDecimal getInvoicePrice() {
        return invoicePrice;
    }
    public void setInvoicePrice(java.math.BigDecimal invoicePrice) {
        this.invoicePrice = invoicePrice;
    }
    public java.math.BigDecimal getInvoiceTotalValue() {
        return invoiceTotalValue;
    }
    public void setInvoiceTotalValue(java.math.BigDecimal invoiceTotalValue) {
        this.invoiceTotalValue = invoiceTotalValue;
    }
    public java.lang.String getTradeContno() {
        return tradeContno;
    }
    public void setTradeContno(java.lang.String tradeContno) {
        this.tradeContno = tradeContno;
    }
    public java.math.BigDecimal getTradeContAmt() {
        return tradeContAmt;
    }
    public void setTradeContAmt(java.math.BigDecimal tradeContAmt) {
        this.tradeContAmt = tradeContAmt;
    }
    public java.lang.String getBuyName() {
        return buyName;
    }
    public void setBuyName(java.lang.String buyName) {
        this.buyName = buyName;
    }
    public java.lang.String getSellName() {
        return sellName;
    }
    public void setSellName(java.lang.String sellName) {
        this.sellName = sellName;
    }
    public java.lang.String getLoanDesc() {
        return loanDesc;
    }
    public void setLoanDesc(java.lang.String loanDesc) {
        this.loanDesc = loanDesc;
    }
    public java.lang.String getTradeDesc() {
        return tradeDesc;
    }
    public void setTradeDesc(java.lang.String tradeDesc) {
        this.tradeDesc = tradeDesc;
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
    public java.lang.String getCursymbol() {
        return cursymbol;
    }
    public void setCursymbol(java.lang.String cursymbol) {
        this.cursymbol = cursymbol;
    }
    public java.lang.String getIsusd() {
        return isusd;
    }
    public void setIsusd(java.lang.String isusd) {
        this.isusd = isusd;
    }
    public java.math.BigDecimal getCursecunit() {
        return cursecunit;
    }
    public void setCursecunit(java.math.BigDecimal cursecunit) {
        this.cursecunit = cursecunit;
    }
    public java.math.BigDecimal getCurrndunit() {
        return currndunit;
    }
    public void setCurrndunit(java.math.BigDecimal currndunit) {
        this.currndunit = currndunit;
    }
    public java.lang.Integer getIscurexch() {
        return iscurexch;
    }
    public void setIscurexch(java.lang.Integer iscurexch) {
        this.iscurexch = iscurexch;
    }
    public java.lang.String getIscureuro() {
        return iscureuro;
    }
    public void setIscureuro(java.lang.String iscureuro) {
        this.iscureuro = iscureuro;
    }
    public java.lang.Integer getMinbillunit() {
        return minbillunit;
    }
    public void setMinbillunit(java.lang.Integer minbillunit) {
        this.minbillunit = minbillunit;
    }
    public java.lang.Integer getMinexchunit() {
        return minexchunit;
    }
    public void setMinexchunit(java.lang.Integer minexchunit) {
        this.minexchunit = minexchunit;
    }
    public java.lang.Integer getMinchgunit() {
        return minchgunit;
    }
    public void setMinchgunit(java.lang.Integer minchgunit) {
        this.minchgunit = minchgunit;
    }
    public java.lang.Integer getDratedays() {
        return dratedays;
    }
    public void setDratedays(java.lang.Integer dratedays) {
        this.dratedays = dratedays;
    }
    public java.util.Date getLstupdts() {
        return lstupdts;
    }
    public void setLstupdts(java.util.Date lstupdts) {
        this.lstupdts = lstupdts;
    }
    /**
     * @return the productId
     */
    public String  getProductId() {
        return productId;
    }
    /**
     * @param productId the productId to set
     */
    public void setProductId(String  productId) {
        this.productId = productId;
    }
    /**
     * @return the idtype
     */
    public java.lang.String getIdtype() {
        return idtype;
    }
    /**
     * @param idtype the idtype to set
     */
    public void setIdtype(java.lang.String idtype) {
        this.idtype = idtype;
    }
    /**
     * @return the idno
     */
    public java.lang.String getIdno() {
        return idno;
    }
    /**
     * @param idno the idno to set
     */
    public void setIdno(java.lang.String idno) {
        this.idno = idno;
    }
    /**
     * @return the mastContno
     */
    public java.lang.String getMastContno() {
        return mastContno;
    }
    /**
     * @param mastContno the mastContno to set
     */
    public void setMastContno(java.lang.String mastContno) {
        this.mastContno = mastContno;
    }

    /**
     * @return the manufacturer
     */
    public java.lang.String getManufacturer() {
        return manufacturer;
    }
    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(java.lang.String manufacturer) {
        this.manufacturer = manufacturer;
    }
    /**
     * @return the businessno
     */
    public java.lang.String getBusinessno() {
        return businessno;
    }
    /**
     * @param businessno the businessno to set
     */
    public void setBusinessno(java.lang.String businessno) {
        this.businessno = businessno;
    }
    /**
     * @return the appliStatusDtl
     */
    public java.lang.String getAppliStatusDtl() {
        return appliStatusDtl;
    }
    /**
     * @param appliStatusDtl the appliStatusDtl to set
     */
    public void setAppliStatusDtl(java.lang.String appliStatusDtl) {
        this.appliStatusDtl = appliStatusDtl;
    }
    /**
     * @return the button
     */
    public java.lang.String getButton() {
        return button;
    }
    /**
     * @param button the button to set
     */
    public void setButton(java.lang.String button) {
        this.button = button;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public java.lang.Integer getSrvNetId() {
        return srvNetId;
    }
    public void setSrvNetId(java.lang.Integer srvNetId) {
        this.srvNetId = srvNetId;
    }
    public java.lang.String getMemberCustcd() {
        return memberCustcd;
    }
    public void setMemberCustcd(java.lang.String memberCustcd) {
        this.memberCustcd = memberCustcd;
    }
    public java.lang.String getMemberRole() {
        return memberRole;
    }
    public void setMemberRole(java.lang.String memberRole) {
        this.memberRole = memberRole;
    }
    public java.lang.String getCustno() {
        return custno;
    }
    public void setCustno(java.lang.String custno) {
        this.custno = custno;
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
    public java.util.Date getLicenseDate() {
        return licenseDate;
    }
    public void setLicenseDate(java.util.Date licenseDate) {
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
    public java.lang.String getCustType() {
        return custType;
    }
    public void setCustType(java.lang.String custType) {
        this.custType = custType;
    }
    public java.util.Date getOpenDate() {
        return openDate;
    }
    public void setOpenDate(java.util.Date openDate) {
        this.openDate = openDate;
    }
    public java.util.Date getCoreOpenDate() {
        return coreOpenDate;
    }
    public void setCoreOpenDate(java.util.Date coreOpenDate) {
        this.coreOpenDate = coreOpenDate;
    }
    public java.lang.String getCustStatus() {
        return custStatus;
    }
    public void setCustStatus(java.lang.String custStatus) {
        this.custStatus = custStatus;
    }
    /**
     * @return the useType
     */
    public java.lang.String getUseType() {
        return useType;
    }
    /**
     * @param useType the useType to set
     */
    public void setUseType(java.lang.String useType) {
        this.useType = useType;
    }
    public java.util.Date getAppDate() {
        return appDate;
    }
    public void setAppDate(java.util.Date appDate) {
        this.appDate = appDate;
    }
    public java.lang.String getAppTlrcd() {
        return appTlrcd;
    }
    public void setAppTlrcd(java.lang.String appTlrcd) {
        this.appTlrcd = appTlrcd;
    }
    public java.lang.String getAppBrcode() {
        return appBrcode;
    }
    public void setAppBrcode(java.lang.String appBrcode) {
        this.appBrcode = appBrcode;
    }
    public java.lang.String getTradeContId() {
        return tradeContId;
    }
    public void setTradeContId(java.lang.String tradeContId) {
        this.tradeContId = tradeContId;
    }
    public java.lang.String getTradeContIdName() {
        return tradeContIdName;
    }
    public void setTradeContIdName(java.lang.String tradeContIdName) {
        this.tradeContIdName = tradeContIdName;
    }
    /**
     * @return the balQuantity
     */
    public java.math.BigDecimal getBalQuantity() {
        return balQuantity;
    }
    /**
     * @param balQuantity the balQuantity to set
     */
    public void setBalQuantity(java.math.BigDecimal balQuantity) {
        this.balQuantity = balQuantity;
    }
    /**
     * @return the flag
     */
    public java.lang.String getFlag() {
        return flag;
    }
    /**
     * @param flag the flag to set
     */
    public void setFlag(java.lang.String flag) {
        this.flag = flag;
    }
    public java.math.BigDecimal getUseableAmount() {
        return useableAmount;
    }
    public void setUseableAmount(java.math.BigDecimal useableAmount) {
        this.useableAmount = useableAmount;
    }
    public java.math.BigDecimal getPricerateAmount() {
        return pricerateAmount;
    }
    public void setPricerateAmount(java.math.BigDecimal pricerateAmount) {
        this.pricerateAmount = pricerateAmount;
    }
    public java.math.BigDecimal getUserdAmount() {
        return userdAmount;
    }
    public void setUserdAmount(java.math.BigDecimal userdAmount) {
        this.userdAmount = userdAmount;
    }
    public java.lang.String getInvoiceNumName() {
        return invoiceNumName;
    }
    public void setInvoiceNumName(java.lang.String invoiceNumName) {
        this.invoiceNumName = invoiceNumName;
    }
    public java.lang.String getSallerName() {
        return sallerName;
    }
    public void setSallerName(java.lang.String sallerName) {
        this.sallerName = sallerName;
    }
    public java.lang.String getSallerNo() {
        return sallerNo;
    }
    public void setSallerNo(java.lang.String sallerNo) {
        this.sallerNo = sallerNo;
    }
    public java.lang.String getBuyNo() {
        return buyNo;
    }
    public void setBuyNo(java.lang.String buyNo) {
        this.buyNo = buyNo;
    }
    public java.lang.String getSecret1() {
        return secret1;
    }
    public void setSecret1(java.lang.String secret1) {
        this.secret1 = secret1;
    }
    public java.lang.String getSecret2() {
        return secret2;
    }
    public void setSecret2(java.lang.String secret2) {
        this.secret2 = secret2;
    }
    /**
     * @return the moniCreditAmout
     */
    public java.math.BigDecimal getMoniCreditAmout() {
        return moniCreditAmout;
    }
    /**
     * @param moniCreditAmout the moniCreditAmout to set
     */
    public void setMoniCreditAmout(java.math.BigDecimal moniCreditAmout) {
        this.moniCreditAmout = moniCreditAmout;
    }
    public java.lang.String getPriceWay() {
        return priceWay;
    }
    public void setPriceWay(java.lang.String priceWay) {
        this.priceWay = priceWay;
    }
    public java.lang.String getPriceBasis() {
        return priceBasis;
    }
    public void setPriceBasis(java.lang.String priceBasis) {
        this.priceBasis = priceBasis;
    }
    public java.lang.String getPriceSource() {
        return priceSource;
    }
    public void setPriceSource(java.lang.String priceSource) {
        this.priceSource = priceSource;
    }
    public java.lang.String getEvalOrg() {
        return evalOrg;
    }
    public void setEvalOrg(java.lang.String evalOrg) {
        this.evalOrg = evalOrg;
    }
    public java.lang.String getEvalTime() {
        return evalTime;
    }
    public void setEvalTime(java.lang.String evalTime) {
        this.evalTime = evalTime;
    }
    public java.math.BigDecimal getPriceOld() {
        return priceOld;
    }
    public void setPriceOld(java.math.BigDecimal priceOld) {
        this.priceOld = priceOld;
    }
    public java.math.BigDecimal getPriceNew() {
        return priceNew;
    }
    public void setPriceNew(java.math.BigDecimal priceNew) {
        this.priceNew = priceNew;
    }
    public java.lang.String getExt1() {
        return ext1;
    }
    public void setExt1(java.lang.String ext1) {
        this.ext1 = ext1;
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


    public java.lang.String getBillno() {
        return billno;
    }
    public void setBillno(java.lang.String billno) {
        this.billno = billno;
    }
    public java.lang.String getExchangeName() {
        return exchangeName;
    }
    public void setExchangeName(java.lang.String exchangeName) {
        this.exchangeName = exchangeName;
    }
    public java.lang.String getSeatcd() {
        return seatcd;
    }
    public void setSeatcd(java.lang.String seatcd) {
        this.seatcd = seatcd;
    }
    public java.lang.String getTradecd() {
        return tradecd;
    }
    public void setTradecd(java.lang.String tradecd) {
        this.tradecd = tradecd;
    }
    public java.lang.String getAddress() {
        return address;
    }
    public void setAddress(java.lang.String address) {
        this.address = address;
    }
    public java.lang.String getPostno() {
        return postno;
    }
    public void setPostno(java.lang.String postno) {
        this.postno = postno;
    }
    public java.lang.String getStorageAddress() {
        return storageAddress;
    }
    public void setStorageAddress(java.lang.String storageAddress) {
        this.storageAddress = storageAddress;
    }
    public java.lang.String getPhone() {
        return phone;
    }
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }
    public java.lang.String getFax() {
        return fax;
    }
    public void setFax(java.lang.String fax) {
        this.fax = fax;
    }
    public java.lang.String getStandLose() {
        return standLose;
    }
    public void setStandLose(java.lang.String standLose) {
        this.standLose = standLose;
    }
    public java.util.Date getStorageCostEndDate() {
        return storageCostEndDate;
    }
    public void setStorageCostEndDate(java.util.Date storageCostEndDate) {
        this.storageCostEndDate = storageCostEndDate;
    }
    public java.lang.String getGallerycd() {
        return gallerycd;
    }
    public void setGallerycd(java.lang.String gallerycd) {
        this.gallerycd = gallerycd;
    }
    public java.lang.String getGalleryName() {
        return galleryName;
    }
    public void setGalleryName(java.lang.String galleryName) {
        this.galleryName = galleryName;
    }
    public java.lang.String getPawneeName() {
        return pawneeName;
    }
    public void setPawneeName(java.lang.String pawneeName) {
        this.pawneeName = pawneeName;
    }
    public java.lang.String getSpecialTradeCode() {
        return specialTradeCode;
    }
    public void setSpecialTradeCode(java.lang.String specialTradeCode) {
        this.specialTradeCode = specialTradeCode;
    }
    public java.lang.String getFutureCustcd() {
        return futureCustcd;
    }
    public void setFutureCustcd(java.lang.String futureCustcd) {
        this.futureCustcd = futureCustcd;
    }
    public java.util.Date getBillDueDate() {
        return billDueDate;
    }
    public void setBillDueDate(java.util.Date billDueDate) {
        this.billDueDate = billDueDate;
    }
    public java.util.Date getConfirmDate() {
        return confirmDate;
    }
    public void setConfirmDate(java.util.Date confirmDate) {
        this.confirmDate = confirmDate;
    }
    public java.lang.String getMortgageLevelOne() {
        return mortgageLevelOne;
    }
    public void setMortgageLevelOne(java.lang.String mortgageLevelOne) {
        this.mortgageLevelOne = mortgageLevelOne;
    }
    public java.lang.String getMortgageLevelTwo() {
        return mortgageLevelTwo;
    }
    public void setMortgageLevelTwo(java.lang.String mortgageLevelTwo) {
        this.mortgageLevelTwo = mortgageLevelTwo;
    }
    public java.lang.String getMortgageLevelThree() {
        return mortgageLevelThree;
    }
    public void setMortgageLevelThree(java.lang.String mortgageLevelThree) {
        this.mortgageLevelThree = mortgageLevelThree;
    }
    public java.lang.String getMortgageLevelFour() {
        return mortgageLevelFour;
    }
    public void setMortgageLevelFour(java.lang.String mortgageLevelFour) {
        this.mortgageLevelFour = mortgageLevelFour;
    }
    public java.lang.String getMortgageLevelFive() {
        return mortgageLevelFive;
    }
    public void setMortgageLevelFive(java.lang.String mortgageLevelFive) {
        this.mortgageLevelFive = mortgageLevelFive;
    }
    public java.lang.String getMortgageLevelSix() {
        return mortgageLevelSix;
    }
    public void setMortgageLevelSix(java.lang.String mortgageLevelSix) {
        this.mortgageLevelSix = mortgageLevelSix;
    }
    public java.math.BigDecimal getOriginalPrice() {
        return originalPrice;
    }
    public void setOriginalPrice(java.math.BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }
    public java.math.BigDecimal getOriginalTotPrice() {
        return originalTotPrice;
    }
    public void setOriginalTotPrice(java.math.BigDecimal originalTotPrice) {
        this.originalTotPrice = originalTotPrice;
    }
    public java.math.BigDecimal getMarketPrice() {
        return marketPrice;
    }
    public void setMarketPrice(java.math.BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }
    public java.math.BigDecimal getConfirmPrice() {
        return confirmPrice;
    }
    public void setConfirmPrice(java.math.BigDecimal confirmPrice) {
        this.confirmPrice = confirmPrice;
    }
    public java.lang.String getStockStatus() {
        return stockStatus;
    }
    public void setStockStatus(java.lang.String stockStatus) {
        this.stockStatus = stockStatus;
    }
    public java.lang.String getVender() {
        return vender;
    }
    public void setVender(java.lang.String vender) {
        this.vender = vender;
    }
    public java.lang.String getProductArea() {
        return productArea;
    }
    public void setProductArea(java.lang.String productArea) {
        this.productArea = productArea;
    }
    public java.lang.String getIncomeNo() {
        return incomeNo;
    }
    public void setIncomeNo(java.lang.String incomeNo) {
        this.incomeNo = incomeNo;
    }
    public java.math.BigDecimal getRation() {
        return ration;
    }
    public void setRation(java.math.BigDecimal ration) {
        this.ration = ration;
    }
    public java.lang.String getQualityLevel() {
        return qualityLevel;
    }
    public void setQualityLevel(java.lang.String qualityLevel) {
        this.qualityLevel = qualityLevel;
    }
    public java.lang.String getSn() {
        return sn;
    }
    public void setSn(java.lang.String sn) {
        this.sn = sn;
    }
    public java.lang.String getYear() {
        return year;
    }
    public void setYear(java.lang.String year) {
        this.year = year;
    }
    public java.lang.String getBillType() {
        return billType;
    }
    public void setBillType(java.lang.String billType) {
        this.billType = billType;
    }
    public java.math.BigDecimal getWeightAll() {
        return weightAll;
    }
    public void setWeightAll(java.math.BigDecimal weightAll) {
        this.weightAll = weightAll;
    }

    public java.math.BigDecimal getBillQuantity() {
        return billQuantity;
    }
    public void setBillQuantity(java.math.BigDecimal billQuantity) {
        this.billQuantity = billQuantity;
    }
    public java.math.BigDecimal getBailAmount() {
        return bailAmount;
    }
    public void setBailAmount(java.math.BigDecimal bailAmount) {
        this.bailAmount = bailAmount;
    }
	public java.lang.String getRegistrationNum() {
		return registrationNum;
	}
	public void setRegistrationNum(java.lang.String registrationNum) {
		this.registrationNum = registrationNum;
	}
	public java.lang.String getExchangeStatus() {
		return exchangeStatus;
	}
	public void setExchangeStatus(java.lang.String exchangeStatus) {
		this.exchangeStatus = exchangeStatus;
	}
	public java.lang.String getWarehouseAddress() {
		return warehouseAddress;
	}
	public void setWarehouseAddress(java.lang.String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}
	public java.lang.String getMortgageClassNo() {
		return mortgageClassNo;
	}
	public void setMortgageClassNo(java.lang.String mortgageClassNo) {
		this.mortgageClassNo = mortgageClassNo;
	}
	public java.lang.String getFirstAppno() {
		return firstAppno;
	}
	public void setFirstAppno(java.lang.String firstAppno) {
		this.firstAppno = firstAppno;
	}
	public java.util.Date getFirstStorageDate() {
		return firstStorageDate;
	}
	public void setFirstStorageDate(java.util.Date firstStorageDate) {
		this.firstStorageDate = firstStorageDate;
	}
	public java.lang.String getWrappage() {
		return wrappage;
	}
	public void setWrappage(java.lang.String wrappage) {
		this.wrappage = wrappage;
	}
	public java.util.Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(java.util.Date insertDate) {
		this.insertDate = insertDate;
	}
	public java.util.Date getEffectDate() {
		return effectDate;
	}
	public void setEffectDate(java.util.Date effectDate) {
		this.effectDate = effectDate;
	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	public java.lang.String getMisc() {
		return misc;
	}
	public void setMisc(java.lang.String misc) {
		this.misc = misc;
	}
	public java.math.BigDecimal getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(java.math.BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}
	public java.lang.String getRecordTlrcd() {
		return recordTlrcd;
	}
	public void setRecordTlrcd(java.lang.String recordTlrcd) {
		this.recordTlrcd = recordTlrcd;
	}
	public java.lang.String getRecordBrcode() {
		return recordBrcode;
	}
	public void setRecordBrcode(java.lang.String recordBrcode) {
		this.recordBrcode = recordBrcode;
	}
	public java.math.BigDecimal getBeforeChangePrice() {
		return beforeChangePrice;
	}
	public void setBeforeChangePrice(java.math.BigDecimal beforeChangePrice) {
		this.beforeChangePrice = beforeChangePrice;
	}
	public java.math.BigDecimal getAfterChangePrice() {
		return afterChangePrice;
	}
	public void setAfterChangePrice(java.math.BigDecimal afterChangePrice) {
		this.afterChangePrice = afterChangePrice;
	}
	public java.lang.String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(java.lang.String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public java.lang.Integer getPid() {
		return pid;
	}
	public void setPid(java.lang.Integer pid) {
		this.pid = pid;
	}
	public java.math.BigDecimal getOldConfirmPrice() {
		return oldConfirmPrice;
	}
	public void setOldConfirmPrice(java.math.BigDecimal oldConfirmPrice) {
		this.oldConfirmPrice = oldConfirmPrice;
	}
	public java.math.BigDecimal getContPrice() {
		return contPrice;
	}
	public void setContPrice(java.math.BigDecimal contPrice) {
		this.contPrice = contPrice;
	}
	public java.math.BigDecimal getThirdPartyPrice() {
		return thirdPartyPrice;
	}
	public void setThirdPartyPrice(java.math.BigDecimal thirdPartyPrice) {
		this.thirdPartyPrice = thirdPartyPrice;
	}
	public java.lang.String getApproveAccording() {
		return approveAccording;
	}
	public void setApproveAccording(java.lang.String approveAccording) {
		this.approveAccording = approveAccording;
	}
	public java.lang.String getConfirmAccording() {
		return confirmAccording;
	}
	public void setConfirmAccording(java.lang.String confirmAccording) {
		this.confirmAccording = confirmAccording;
	}
	public java.lang.String getSuppChainPdType() {
		return suppChainPdType;
	}
	public void setSuppChainPdType(java.lang.String suppChainPdType) {
		this.suppChainPdType = suppChainPdType;
	}
	public java.lang.String getSlaveContcode() {
		return slaveContcode;
	}
	public void setSlaveContcode(java.lang.String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}
	public java.lang.Integer getCustId() {
		return custId;
	}
	public void setCustId(java.lang.Integer custId) {
		this.custId = custId;
	}
	public java.lang.String getTransno() {
		return transno;
	}
	public void setTransno(java.lang.String transno) {
		this.transno = transno;
	}
	public java.lang.String getProcInsId() {
		return procInsId;
	}
	public void setProcInsId(java.lang.String procInsId) {
		this.procInsId = procInsId;
	}
	public java.lang.String getTaskId() {
		return taskId;
	}
	public void setTaskId(java.lang.String taskId) {
		this.taskId = taskId;
	}
	public java.lang.String getTaskName() {
		return taskName;
	}
	public void setTaskName(java.lang.String taskName) {
		this.taskName = taskName;
	}
	public java.lang.String getProcessTemplate() {
		return processTemplate;
	}
	public void setProcessTemplate(java.lang.String processTemplate) {
		this.processTemplate = processTemplate;
	}
	public java.util.Date getFlowStartTime() {
		return flowStartTime;
	}
	public void setFlowStartTime(java.util.Date flowStartTime) {
		this.flowStartTime = flowStartTime;
	}
	public java.util.Date getFlowEndTime() {
		return flowEndTime;
	}
	public void setFlowEndTime(java.util.Date flowEndTime) {
		this.flowEndTime = flowEndTime;
	}
	public java.lang.String getFlowEndFlag() {
		return flowEndFlag;
	}
	public void setFlowEndFlag(java.lang.String flowEndFlag) {
		this.flowEndFlag = flowEndFlag;
	}
	public java.util.Date getTaskStartTime() {
		return taskStartTime;
	}
	public void setTaskStartTime(java.util.Date taskStartTime) {
		this.taskStartTime = taskStartTime;
	}
	public java.util.Date getTaskEndTime() {
		return taskEndTime;
	}
	public void setTaskEndTime(java.util.Date taskEndTime) {
		this.taskEndTime = taskEndTime;
	}
	public java.lang.String getTaskEndFlag() {
		return taskEndFlag;
	}
	public void setTaskEndFlag(java.lang.String taskEndFlag) {
		this.taskEndFlag = taskEndFlag;
	}
	public java.lang.String getRoleType() {
		return roleType;
	}
	public void setRoleType(java.lang.String roleType) {
		this.roleType = roleType;
	}
	public java.lang.String getMiscflgs() {
		return miscflgs;
	}
	public void setMiscflgs(java.lang.String miscflgs) {
		this.miscflgs = miscflgs;
	}
	public java.util.Date getExchangeDate() {
		return exchangeDate;
	}
	public void setExchangeDate(java.util.Date exchangeDate) {
		this.exchangeDate = exchangeDate;
	}
	public java.math.BigDecimal getCreditAmt() {
		return creditAmt;
	}
	public void setCreditAmt(java.math.BigDecimal creditAmt) {
		this.creditAmt = creditAmt;
	}
	public java.math.BigDecimal getStockAmt() {
		return stockAmt;
	}
	public void setStockAmt(java.math.BigDecimal stockAmt) {
		this.stockAmt = stockAmt;
	}
	public java.math.BigDecimal getRiskAmt() {
		return riskAmt;
	}
	public void setRiskAmt(java.math.BigDecimal riskAmt) {
		this.riskAmt = riskAmt;
	}
	public java.math.BigDecimal getStockBalanceAmt() {
		return stockBalanceAmt;
	}
	public void setStockBalanceAmt(java.math.BigDecimal stockBalanceAmt) {
		this.stockBalanceAmt = stockBalanceAmt;
	}
	public java.lang.String getDetail() {
		return detail;
	}
	public void setDetail(java.lang.String detail) {
		this.detail = detail;
	}
	public java.lang.String getDataNo() {
		return dataNo;
	}
	public void setDataNo(java.lang.String dataNo) {
		this.dataNo = dataNo;
	}
	public java.util.Date getPledgeDate() {
		return pledgeDate;
	}
	public void setPledgeDate(java.util.Date pledgeDate) {
		this.pledgeDate = pledgeDate;
	}
	public java.math.BigDecimal getUpDownMoney() {
		return upDownMoney;
	}
	public void setUpDownMoney(java.math.BigDecimal upDownMoney) {
		this.upDownMoney = upDownMoney;
	}
	public java.lang.String getFirCd() {
		return firCd;
	}
	public void setFirCd(java.lang.String firCd) {
		this.firCd = firCd;
	}
	public java.lang.String getBillCode() {
		return billCode;
	}
	public void setBillCode(java.lang.String billCode) {
		this.billCode = billCode;
	}
	public java.lang.Integer getHandInDate() {
		return handInDate;
	}
	public void setHandInDate(java.lang.Integer handInDate) {
		this.handInDate = handInDate;
	}
	public java.lang.String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(java.lang.String receiveName) {
		this.receiveName = receiveName;
	}
	public java.lang.String getStopReason() {
		return stopReason;
	}
	public void setStopReason(java.lang.String stopReason) {
		this.stopReason = stopReason;
	}
	public java.lang.String getReasonType() {
		return reasonType;
	}
	public void setReasonType(java.lang.String reasonType) {
		this.reasonType = reasonType;
	}
	public java.lang.String getConventionNo() {
		return conventionNo;
	}
	public void setConventionNo(java.lang.String conventionNo) {
		this.conventionNo = conventionNo;
	}
	public java.lang.String getFaultA() {
		return faultA;
	}
	public void setFaultA(java.lang.String faultA) {
		this.faultA = faultA;
	}
	public java.lang.String getFaultB() {
		return faultB;
	}
	public void setFaultB(java.lang.String faultB) {
		this.faultB = faultB;
	}
	public java.math.BigDecimal getCreditamt() {
		return creditamt;
	}
	public void setCreditamt(java.math.BigDecimal creditamt) {
		this.creditamt = creditamt;
	}
	public java.math.BigDecimal getStockamt() {
		return stockamt;
	}
	public void setStockamt(java.math.BigDecimal stockamt) {
		this.stockamt = stockamt;
	}
	public java.math.BigDecimal getRiskamt() {
		return riskamt;
	}
	public void setRiskamt(java.math.BigDecimal riskamt) {
		this.riskamt = riskamt;
	}
	public java.lang.String getMortgageName() {
		return mortgageName;
	}
	public void setMortgageName(java.lang.String mortgageName) {
		this.mortgageName = mortgageName;
	}
	public java.lang.String getMemo() {
		return memo;
	}
	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}
	public java.lang.String getNetbankAppno() {
		return netbankAppno;
	}
	public void setNetbankAppno(java.lang.String netbankAppno) {
		this.netbankAppno = netbankAppno;
	}
	public java.lang.String getApplyid() {
		return applyid;
	}
	public void setApplyid(java.lang.String applyid) {
		this.applyid = applyid;
	}
	public java.lang.String getMoniCustcd() {
		return moniCustcd;
	}
	public void setMoniCustcd(java.lang.String moniCustcd) {
		this.moniCustcd = moniCustcd;
	}
	public java.lang.String getPledgeMode() {
		return pledgeMode;
	}
	public void setPledgeMode(java.lang.String pledgeMode) {
		this.pledgeMode = pledgeMode;
	}
	public java.math.BigDecimal getDeliverValue() {
		return deliverValue;
	}
	public void setDeliverValue(java.math.BigDecimal deliverValue) {
		this.deliverValue = deliverValue;
	}
	public java.lang.String getAdviceid() {
		return adviceid;
	}
	public void setAdviceid(java.lang.String adviceid) {
		this.adviceid = adviceid;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public java.lang.String getProtocolCode() {
		return protocolCode;
	}
	public void setProtocolCode(java.lang.String protocolCode) {
		this.protocolCode = protocolCode;
	}
	public java.lang.Boolean getSelect() {
		return select;
	}
	public void setSelect(java.lang.Boolean select) {
		this.select = select;
	}
	public java.lang.String getWeightUnits() {
		return weightUnits;
	}
	public void setWeightUnits(java.lang.String weightUnits) {
		this.weightUnits = weightUnits;
	}
	public java.lang.String getCustcdBuyer() {
		return custcdBuyer;
	}
	public void setCustcdBuyer(java.lang.String custcdBuyer) {
		this.custcdBuyer = custcdBuyer;
	}
	public java.lang.String getCustcdSaller() {
		return custcdSaller;
	}
	public void setCustcdSaller(java.lang.String custcdSaller) {
		this.custcdSaller = custcdSaller;
	}
	public java.lang.String getApplyType() {
		return applyType;
	}
	public void setApplyType(java.lang.String applyType) {
		this.applyType = applyType;
	}
	public java.util.Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(java.util.Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public java.lang.Integer getDebtNum() {
		return debtNum;
	}
	public void setDebtNum(java.lang.Integer debtNum) {
		this.debtNum = debtNum;
	}
	public java.math.BigDecimal getTotalDebtAmount() {
		return totalDebtAmount;
	}
	public void setTotalDebtAmount(java.math.BigDecimal totalDebtAmount) {
		this.totalDebtAmount = totalDebtAmount;
	}
	public java.lang.String getChargeType() {
		return chargeType;
	}
	public void setChargeType(java.lang.String chargeType) {
		this.chargeType = chargeType;
	}
	public java.lang.String getFinacingDiscountType() {
		return finacingDiscountType;
	}
	public void setFinacingDiscountType(java.lang.String finacingDiscountType) {
		this.finacingDiscountType = finacingDiscountType;
	}
	public java.math.BigDecimal getFinacingCost() {
		return finacingCost;
	}
	public void setFinacingCost(java.math.BigDecimal finacingCost) {
		this.finacingCost = finacingCost;
	}
	public java.math.BigDecimal getCost() {
		return cost;
	}
	public void setCost(java.math.BigDecimal cost) {
		this.cost = cost;
	}
	public java.math.BigDecimal getHandlingFee() {
		return handlingFee;
	}
	public void setHandlingFee(java.math.BigDecimal handlingFee) {
		this.handlingFee = handlingFee;
	}
	public java.math.BigDecimal getReduceAmount() {
		return reduceAmount;
	}
	public void setReduceAmount(java.math.BigDecimal reduceAmount) {
		this.reduceAmount = reduceAmount;
	}
	public java.math.BigDecimal getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(java.math.BigDecimal totalFee) {
		this.totalFee = totalFee;
	}
	public java.math.BigDecimal getTotalReduce() {
		return totalReduce;
	}
	public void setTotalReduce(java.math.BigDecimal totalReduce) {
		this.totalReduce = totalReduce;
	}
	public java.math.BigDecimal getReceiveAmount() {
		return receiveAmount;
	}
	public void setReceiveAmount(java.math.BigDecimal receiveAmount) {
		this.receiveAmount = receiveAmount;
	}
	public java.lang.String getCostAccount() {
		return costAccount;
	}
	public void setCostAccount(java.lang.String costAccount) {
		this.costAccount = costAccount;
	}
	public java.lang.String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(java.lang.String accountNo) {
		this.accountNo = accountNo;
	}
	public java.lang.String getPayDayMonth() {
		return payDayMonth;
	}
	public void setPayDayMonth(java.lang.String payDayMonth) {
		this.payDayMonth = payDayMonth;
	}
	public java.lang.String getRateCollectType() {
		return rateCollectType;
	}
	public void setRateCollectType(java.lang.String rateCollectType) {
		this.rateCollectType = rateCollectType;
	}
	public java.lang.String getOverDueRate() {
		return overDueRate;
	}
	public void setOverDueRate(java.lang.String overDueRate) {
		this.overDueRate = overDueRate;
	}
	public java.lang.String getExecuteRate() {
		return executeRate;
	}
	public void setExecuteRate(java.lang.String executeRate) {
		this.executeRate = executeRate;
	}
	public java.lang.String getUpDownPercent() {
		return upDownPercent;
	}
	public void setUpDownPercent(java.lang.String upDownPercent) {
		this.upDownPercent = upDownPercent;
	}
	public java.lang.String getUpDown() {
		return upDown;
	}
	public void setUpDown(java.lang.String upDown) {
		this.upDown = upDown;
	}
	public java.lang.String getBaseRate() {
		return baseRate;
	}
	public void setBaseRate(java.lang.String baseRate) {
		this.baseRate = baseRate;
	}
	public java.lang.String getRateId() {
		return rateId;
	}
	public void setRateId(java.lang.String rateId) {
		this.rateId = rateId;
	}
	public java.lang.String getRateType() {
		return rateType;
	}
	public void setRateType(java.lang.String rateType) {
		this.rateType = rateType;
	}
	public java.lang.String getLoanType() {
		return loanType;
	}
	public void setLoanType(java.lang.String loanType) {
		this.loanType = loanType;
	}
	public java.lang.String getLoanWay() {
		return loanWay;
	}
	public void setLoanWay(java.lang.String loanWay) {
		this.loanWay = loanWay;
	}
	public java.lang.String getBankno() {
		return bankno;
	}
	public void setBankno(java.lang.String bankno) {
		this.bankno = bankno;
	}
	public java.lang.String getBrcode2() {
		return brcode2;
	}
	public void setBrcode2(java.lang.String brcode2) {
		this.brcode2 = brcode2;
	}
	public java.math.BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}
	public java.lang.Integer getLoanDays() {
		return loanDays;
	}
	public void setLoanDays(java.lang.Integer loanDays) {
		this.loanDays = loanDays;
	}
	public java.util.Date getBillDate() {
		return billDate;
	}
	public void setBillDate(java.util.Date billDate) {
		this.billDate = billDate;
	}
	public java.util.Date getBillEndDate() {
		return billEndDate;
	}
	public void setBillEndDate(java.util.Date billEndDate) {
		this.billEndDate = billEndDate;
	}
	public java.lang.String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(java.lang.String orderNo) {
		this.orderNo = orderNo;
	}
	public java.math.BigDecimal getOrderAmt() {
		return orderAmt;
	}
	public void setOrderAmt(java.math.BigDecimal orderAmt) {
		this.orderAmt = orderAmt;
	}
	public java.lang.String getBalanceAccount() {
		return balanceAccount;
	}
	public void setBalanceAccount(java.lang.String balanceAccount) {
		this.balanceAccount = balanceAccount;
	}
	public java.math.BigDecimal getBailAmt() {
		return bailAmt;
	}
	public void setBailAmt(java.math.BigDecimal bailAmt) {
		this.bailAmt = bailAmt;
	}
	public java.lang.String getBailAccount() {
		return bailAccount;
	}
	public void setBailAccount(java.lang.String bailAccount) {
		this.bailAccount = bailAccount;
	}
	public java.lang.String getBillAccount() {
		return billAccount;
	}
	public void setBillAccount(java.lang.String billAccount) {
		this.billAccount = billAccount;
	}
	public java.lang.String getCoreAccount() {
		return coreAccount;
	}
	public void setCoreAccount(java.lang.String coreAccount) {
		this.coreAccount = coreAccount;
	}
	public java.util.Date getAppLoanDate() {
		return appLoanDate;
	}
	public void setAppLoanDate(java.util.Date appLoanDate) {
		this.appLoanDate = appLoanDate;
	}
	public java.util.Date getLoanDueDate() {
		return loanDueDate;
	}
	public void setLoanDueDate(java.util.Date loanDueDate) {
		this.loanDueDate = loanDueDate;
	}
	public java.util.Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(java.util.Date returnDate) {
		this.returnDate = returnDate;
	}
	public java.lang.String getReturnType() {
		return returnType;
	}
	public void setReturnType(java.lang.String returnType) {
		this.returnType = returnType;
	}
	public java.lang.String getReturnMethod() {
		return returnMethod;
	}
	public void setReturnMethod(java.lang.String returnMethod) {
		this.returnMethod = returnMethod;
	}
	public java.math.BigDecimal getReturnAmount() {
		return returnAmount;
	}
	public void setReturnAmount(java.math.BigDecimal returnAmount) {
		this.returnAmount = returnAmount;
	}
	public java.math.BigDecimal getReturnInterestAmount() {
		return returnInterestAmount;
	}
	public void setReturnInterestAmount(java.math.BigDecimal returnInterestAmount) {
		this.returnInterestAmount = returnInterestAmount;
	}
	public java.math.BigDecimal getReturnCapitalAmount() {
		return returnCapitalAmount;
	}
	public void setReturnCapitalAmount(java.math.BigDecimal returnCapitalAmount) {
		this.returnCapitalAmount = returnCapitalAmount;
	}
	public java.math.BigDecimal getToSallerAmount() {
		return toSallerAmount;
	}
	public void setToSallerAmount(java.math.BigDecimal toSallerAmount) {
		this.toSallerAmount = toSallerAmount;
	}
	public java.math.BigDecimal getToPoolAmount() {
		return toPoolAmount;
	}
	public void setToPoolAmount(java.math.BigDecimal toPoolAmount) {
		this.toPoolAmount = toPoolAmount;
	}
	public java.lang.String getToSallerFlag() {
		return toSallerFlag;
	}
	public void setToSallerFlag(java.lang.String toSallerFlag) {
		this.toSallerFlag = toSallerFlag;
	}
	public java.lang.String getOtherReason() {
		return otherReason;
	}
	public void setOtherReason(java.lang.String otherReason) {
		this.otherReason = otherReason;
	}
	public java.lang.String getCommonDate() {
		return commonDate;
	}
	public void setCommonDate(java.lang.String commonDate) {
		this.commonDate = commonDate;
	}
	public String getFirstBailType() {
		return firstBailType;
	}
	public void setFirstBailType(String firstBailType) {
		this.firstBailType = firstBailType;
	}
	public BigDecimal getBailAmtAdd() {
		return bailAmtAdd;
	}
	public void setBailAmtAdd(BigDecimal bailAmtAdd) {
		this.bailAmtAdd = bailAmtAdd;
	}
	public BigDecimal getOkPrice() {
		return okPrice;
	}
	public void setOkPrice(BigDecimal okPrice) {
		this.okPrice = okPrice;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public java.lang.String getNum() {
		return num;
	}
	public void setNum(java.lang.String num) {
		this.num = num;
	}
	public java.lang.String getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(java.lang.String noticeType) {
		this.noticeType = noticeType;
	}
	public java.lang.String getMortgageChangeType() {
		return mortgageChangeType;
	}
	public void setMortgageChangeType(java.lang.String mortgageChangeType) {
		this.mortgageChangeType = mortgageChangeType;
	}
	public java.util.Date getPledgorDate() {
		return pledgorDate;
	}
	public void setPledgorDate(java.util.Date pledgorDate) {
		this.pledgorDate = pledgorDate;
	}
	public java.util.Date getPledgeeDate() {
		return pledgeeDate;
	}
	public void setPledgeeDate(java.util.Date pledgeeDate) {
		this.pledgeeDate = pledgeeDate;
	}
	public java.util.Date getMoniOfDate() {
		return moniOfDate;
	}
	public void setMoniOfDate(java.util.Date moniOfDate) {
		this.moniOfDate = moniOfDate;
	}
	public java.util.Date getAppliDate() {
		return appliDate;
	}
	public void setAppliDate(java.util.Date appliDate) {
		this.appliDate = appliDate;
	}
	public java.math.BigDecimal getProtLowPric() {
		return protLowPric;
	}
	public void setProtLowPric(java.math.BigDecimal protLowPric) {
		this.protLowPric = protLowPric;
	}
	public java.lang.String getMoniOfName() {
		return moniOfName;
	}
	public void setMoniOfName(java.lang.String moniOfName) {
		this.moniOfName = moniOfName;
	}
	public java.util.Date getMoniOfTimestamp() {
		return moniOfTimestamp;
	}
	public void setMoniOfTimestamp(java.util.Date moniOfTimestamp) {
		this.moniOfTimestamp = moniOfTimestamp;
	}
	public java.lang.String getTlrn() {
		return tlrn;
	}
	public void setTlrn(java.lang.String tlrn) {
		this.tlrn = tlrn;
	}
	public java.lang.String getMsrno() {
		return msrno;
	}
	public void setMsrno(java.lang.String msrno) {
		this.msrno = msrno;
	}
	public java.lang.String getSlaveType() {
		return slaveType;
	}
	public void setSlaveType(java.lang.String slaveType) {
		this.slaveType = slaveType;
	}
	public java.math.BigDecimal getMortgageAmount() {
		return mortgageAmount;
	}
	public void setMortgageAmount(java.math.BigDecimal mortgageAmount) {
		this.mortgageAmount = mortgageAmount;
	}
	public java.lang.Integer getHandinDate() {
		return handinDate;
	}
	public void setHandinDate(java.lang.Integer handinDate) {
		this.handinDate = handinDate;
	}
	public java.lang.String getProtocolcode() {
		return protocolcode;
	}
	public void setProtocolcode(java.lang.String protocolcode) {
		this.protocolcode = protocolcode;
	}
	public java.lang.String getPledgeorgidcode() {
		return pledgeorgidcode;
	}
	public void setPledgeorgidcode(java.lang.String pledgeorgidcode) {
		this.pledgeorgidcode = pledgeorgidcode;
	}
	public java.lang.String getPledgeorgidcodetype() {
		return pledgeorgidcodetype;
	}
	public void setPledgeorgidcodetype(java.lang.String pledgeorgidcodetype) {
		this.pledgeorgidcodetype = pledgeorgidcodetype;
	}
	public java.lang.String getAdviceackid() {
		return adviceackid;
	}
	public void setAdviceackid(java.lang.String adviceackid) {
		this.adviceackid = adviceackid;
	}
	public java.lang.String getPawneeorgid() {
		return pawneeorgid;
	}
	public void setPawneeorgid(java.lang.String pawneeorgid) {
		this.pawneeorgid = pawneeorgid;
	}
	public java.math.BigDecimal getPledgeminimumvalue() {
		return pledgeminimumvalue;
	}
	public void setPledgeminimumvalue(java.math.BigDecimal pledgeminimumvalue) {
		this.pledgeminimumvalue = pledgeminimumvalue;
	}
	public java.lang.String getPledgeitemreceivedate() {
		return pledgeitemreceivedate;
	}
	public void setPledgeitemreceivedate(java.lang.String pledgeitemreceivedate) {
		this.pledgeitemreceivedate = pledgeitemreceivedate;
	}
	public java.lang.String getCollateralmanagermemo() {
		return collateralmanagermemo;
	}
	public void setCollateralmanagermemo(java.lang.String collateralmanagermemo) {
		this.collateralmanagermemo = collateralmanagermemo;
	}
	public java.lang.String getAdviceackstatus() {
		return adviceackstatus;
	}
	public void setAdviceackstatus(java.lang.String adviceackstatus) {
		this.adviceackstatus = adviceackstatus;
	}
	public java.math.BigDecimal getMoney() {
		return money;
	}
	public void setMoney(java.math.BigDecimal money) {
		this.money = money;
	}
	public java.lang.String getBillNum() {
		return billNum;
	}
	public void setBillNum(java.lang.String billNum) {
		this.billNum = billNum;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public String getTransferFlag() {
		return transferFlag;
	}
	public void setTransferFlag(String transferFlag) {
		this.transferFlag = transferFlag;
	}
	public String getFourProtocolCode() {
		return fourProtocolCode;
	}
	public void setFourProtocolCode(String fourProtocolCode) {
		this.fourProtocolCode = fourProtocolCode;
	}
	public String getBussTypeName() {
		return bussTypeName;
	}
	public void setBussTypeName(String bussTypeName) {
		this.bussTypeName = bussTypeName;
	}
	public java.lang.String getMastContcode() {
		return mastContcode;
	}
	public void setMastContcode(java.lang.String mastContcode) {
		this.mastContcode = mastContcode;
	}
	public java.lang.String getMastContCode() {
		return mastContCode;
	}
	public void setMastContCode(java.lang.String mastContCode) {
		this.mastContCode = mastContCode;
	}

	public String getMaxProductName() {
		return maxProductName;
	}

	public void setMaxProductName(String maxProductName) {
		this.maxProductName = maxProductName;
	}

	public String getMiddProductName() {
		return middProductName;
	}

	public void setMiddProductName(String middProductName) {
		this.middProductName = middProductName;
	}

	public String getMaxProductId() {
		return maxProductId;
	}

	public void setMaxProductId(String maxProductId) {
		this.maxProductId = maxProductId;
	}

	public String getMiddProductId() {
		return middProductId;
	}

	public void setMiddProductId(String middProductId) {
		this.middProductId = middProductId;
	}

	public java.util.Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(java.util.Date activeDate) {
		this.activeDate = activeDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public java.lang.String getActno() {
		return actno;
	}

	public void setActno(java.lang.String actno) {
		this.actno = actno;
	}

	public java.lang.String getBailActno() {
		return bailActno;
	}

	public void setBailActno(java.lang.String bailActno) {
		this.bailActno = bailActno;
	}

	public java.lang.String getRole() {
		return role;
	}

	public void setRole(java.lang.String role) {
		this.role = role;
	}

	public java.math.BigDecimal getDismortBailAmount() {
		return dismortBailAmount;
	}

	public void setDismortBailAmount(java.math.BigDecimal dismortBailAmount) {
		this.dismortBailAmount = dismortBailAmount;
	}

	public java.math.BigDecimal getBillsAmountView() {
		return billsAmountView;
	}

	public void setBillsAmountView(java.math.BigDecimal billsAmountView) {
		this.billsAmountView = billsAmountView;
	}

	public java.lang.String getDrawType() {
		return drawType;
	}

	public void setDrawType(java.lang.String drawType) {
		this.drawType = drawType;
	}

	public java.lang.String getConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(java.lang.String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public String getSellarId() {
		return sellarId;
	}

	public void setSellarId(String sellarId) {
		this.sellarId = sellarId;
	}

	public String getSellarRZId() {
		return sellarRZId;
	}

	public void setSellarRZId(String sellarRZId) {
		this.sellarRZId = sellarRZId;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerRZId() {
		return buyerRZId;
	}

	public void setBuyerRZId(String buyerRZId) {
		this.buyerRZId = buyerRZId;
	}

	public String getMoniId() {
		return moniId;
	}

	public void setMoniId(String moniId) {
		this.moniId = moniId;
	}

	public String getCompanyNetSilver() {
		return companyNetSilver;
	}

	public void setCompanyNetSilver(String companyNetSilver) {
		this.companyNetSilver = companyNetSilver;
	}

	public String getBankDirectCompany() {
		return bankDirectCompany;
	}

	public void setBankDirectCompany(String bankDirectCompany) {
		this.bankDirectCompany = bankDirectCompany;
	}

	public String getBelowLineFlag() {
		return belowLineFlag;
	}

	public void setBelowLineFlag(String belowLineFlag) {
		this.belowLineFlag = belowLineFlag;
	}

	public String getSellerCompanyNetSilver() {
		return sellerCompanyNetSilver;
	}

	public void setSellerCompanyNetSilver(String sellerCompanyNetSilver) {
		this.sellerCompanyNetSilver = sellerCompanyNetSilver;
	}

	public String getSellerBankDirectCompany() {
		return sellerBankDirectCompany;
	}

	public void setSellerBankDirectCompany(String sellerBankDirectCompany) {
		this.sellerBankDirectCompany = sellerBankDirectCompany;
	}

	public String getSellerBelowLineFlag() {
		return sellerBelowLineFlag;
	}

	public void setSellerBelowLineFlag(String sellerBelowLineFlag) {
		this.sellerBelowLineFlag = sellerBelowLineFlag;
	}

	public String getBuyerRZCompanyNetSilver() {
		return buyerRZCompanyNetSilver;
	}

	public void setBuyerRZCompanyNetSilver(String buyerRZCompanyNetSilver) {
		this.buyerRZCompanyNetSilver = buyerRZCompanyNetSilver;
	}

	public String getBuyerRZBankDirectCompany() {
		return buyerRZBankDirectCompany;
	}

	public void setBuyerRZBankDirectCompany(String buyerRZBankDirectCompany) {
		this.buyerRZBankDirectCompany = buyerRZBankDirectCompany;
	}

	public String getBuyerRZBelowLineFlag() {
		return buyerRZBelowLineFlag;
	}

	public void setBuyerRZBelowLineFlag(String buyerRZBelowLineFlag) {
		this.buyerRZBelowLineFlag = buyerRZBelowLineFlag;
	}

	public String getSellerRZCompanyNetSilver() {
		return sellerRZCompanyNetSilver;
	}

	public void setSellerRZCompanyNetSilver(String sellerRZCompanyNetSilver) {
		this.sellerRZCompanyNetSilver = sellerRZCompanyNetSilver;
	}

	public String getSellerRZBankDirectCompany() {
		return sellerRZBankDirectCompany;
	}

	public void setSellerRZBankDirectCompany(String sellerRZBankDirectCompany) {
		this.sellerRZBankDirectCompany = sellerRZBankDirectCompany;
	}

	public String getSellerRZBelowLineFlag() {
		return sellerRZBelowLineFlag;
	}

	public void setSellerRZBelowLineFlag(String sellerRZBelowLineFlag) {
		this.sellerRZBelowLineFlag = sellerRZBelowLineFlag;
	}

	public String getBuyerCompanyNetSilver() {
		return buyerCompanyNetSilver;
	}

	public void setBuyerCompanyNetSilver(String buyerCompanyNetSilver) {
		this.buyerCompanyNetSilver = buyerCompanyNetSilver;
	}

	public String getBuyerBankDirectCompany() {
		return buyerBankDirectCompany;
	}

	public void setBuyerBankDirectCompany(String buyerBankDirectCompany) {
		this.buyerBankDirectCompany = buyerBankDirectCompany;
	}

	public String getBuyerBelowLineFlag() {
		return buyerBelowLineFlag;
	}

	public void setBuyerBelowLineFlag(String buyerBelowLineFlag) {
		this.buyerBelowLineFlag = buyerBelowLineFlag;
	}

	public String getMoniCompanyNetSilver() {
		return moniCompanyNetSilver;
	}

	public void setMoniCompanyNetSilver(String moniCompanyNetSilver) {
		this.moniCompanyNetSilver = moniCompanyNetSilver;
	}

	public String getMoniBankDirectCompany() {
		return moniBankDirectCompany;
	}

	public void setMoniBankDirectCompany(String moniBankDirectCompany) {
		this.moniBankDirectCompany = moniBankDirectCompany;
	}

	public String getMoniBelowLineFlag() {
		return moniBelowLineFlag;
	}

	public void setMoniBelowLineFlag(String moniBelowLineFlag) {
		this.moniBelowLineFlag = moniBelowLineFlag;
	}

	public java.lang.String getBusiPhase() {
		return busiPhase;
	}

	public void setBusiPhase(java.lang.String busiPhase) {
		this.busiPhase = busiPhase;
	}

	public java.lang.String getDebtId() {
		return debtId;
	}

	public void setDebtId(java.lang.String debtId) {
		this.debtId = debtId;
	}

	public java.math.BigDecimal getTotalRemainAmount() {
		return totalRemainAmount;
	}

	public void setTotalRemainAmount(java.math.BigDecimal totalRemainAmount) {
		this.totalRemainAmount = totalRemainAmount;
	}

	public java.math.BigDecimal getTotalRateAmount() {
		return totalRateAmount;
	}

	public void setTotalRateAmount(java.math.BigDecimal totalRateAmount) {
		this.totalRateAmount = totalRateAmount;
	}

	public java.math.BigDecimal getTotalRateRemainAmount() {
		return totalRateRemainAmount;
	}

	public void setTotalRateRemainAmount(java.math.BigDecimal totalRateRemainAmount) {
		this.totalRateRemainAmount = totalRateRemainAmount;
	}

	public java.math.BigDecimal getLoanRemainingAmount() {
		return loanRemainingAmount;
	}

	public void setLoanRemainingAmount(java.math.BigDecimal loanRemainingAmount) {
		this.loanRemainingAmount = loanRemainingAmount;
	}

	public java.math.BigDecimal getRateCollectAmount() {
		return rateCollectAmount;
	}

	public void setRateCollectAmount(java.math.BigDecimal rateCollectAmount) {
		this.rateCollectAmount = rateCollectAmount;
	}

	public java.math.BigDecimal getOwnRateCollectAmount() {
		return ownRateCollectAmount;
	}

	public void setOwnRateCollectAmount(java.math.BigDecimal ownRateCollectAmount) {
		this.ownRateCollectAmount = ownRateCollectAmount;
	}

	public java.math.BigDecimal getCashRemainingAmount() {
		return cashRemainingAmount;
	}

	public void setCashRemainingAmount(java.math.BigDecimal cashRemainingAmount) {
		this.cashRemainingAmount = cashRemainingAmount;
	}

	public java.math.BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(java.math.BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public java.lang.String getBillsNo() {
		return billsNo;
	}

	public void setBillsNo(java.lang.String billsNo) {
		this.billsNo = billsNo;
	}

	public java.util.Date getBillsDate() {
		return billsDate;
	}

	public void setBillsDate(java.util.Date billsDate) {
		this.billsDate = billsDate;
	}

	public java.util.Date getDebtEnd() {
		return debtEnd;
	}

	public void setDebtEnd(java.util.Date debtEnd) {
		this.debtEnd = debtEnd;
	}

	public java.math.BigDecimal getBillsAmount() {
		return billsAmount;
	}

	public void setBillsAmount(java.math.BigDecimal billsAmount) {
		this.billsAmount = billsAmount;
	}

	public java.math.BigDecimal getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(java.math.BigDecimal remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLccode() {
		return lccode;
	}

	public void setLccode(String lccode) {
		this.lccode = lccode;
	}

	public java.math.BigDecimal getDebtAmount() {
		return debtAmount;
	}

	public void setDebtAmount(java.math.BigDecimal debtAmount) {
		this.debtAmount = debtAmount;
	}

	public java.math.BigDecimal getMortAmount() {
		return mortAmount;
	}

	public void setMortAmount(java.math.BigDecimal mortAmount) {
		this.mortAmount = mortAmount;
	}

	public String getDebetId() {
		return debetId;
	}

	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}



	public java.math.BigDecimal getBailRate() {
		return bailRate;
	}

	public void setBailRate(java.math.BigDecimal bailRate) {
		this.bailRate = bailRate;
	}

	public String getLnciType() {
		return lnciType;
	}

	public void setLnciType(String lnciType) {
		this.lnciType = lnciType;
	}

	public String getContType() {
		return contType;
	}

	public void setContType(String contType) {
		this.contType = contType;
	}

	public java.math.BigDecimal getBailRatio() {
		return bailRatio;
	}

	public void setBailRatio(java.math.BigDecimal bailRatio) {
		this.bailRatio = bailRatio;
	}

	public String getSlaveLimit() {
		return slaveLimit;
	}

	public void setSlaveLimit(String slaveLimit) {
		this.slaveLimit = slaveLimit;
	}

	public java.math.BigDecimal getRate() {
		return rate;
	}

	public void setRate(java.math.BigDecimal rate) {
		this.rate = rate;
	}

	public String getMoniType() {
		return moniType;
	}

	public void setMoniType(String moniType) {
		this.moniType = moniType;
	}

	public java.lang.String getBillcode() {
		return billcode;
	}

	public void setBillcode(java.lang.String billcode) {
		this.billcode = billcode;
	}

	public java.lang.String getPackageId() {
		return packageId;
	}

	public void setPackageId(java.lang.String packageId) {
		this.packageId = packageId;
	}

	public java.lang.String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(java.lang.String templateId) {
		this.templateId = templateId;
	}

	public java.lang.String getUpDownMoneyFlag() {
		return upDownMoneyFlag;
	}

	public void setUpDownMoneyFlag(java.lang.String upDownMoneyFlag) {
		this.upDownMoneyFlag = upDownMoneyFlag;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public String getMortBillAccountNo() {
		return mortBillAccountNo;
	}

	public void setMortBillAccountNo(String mortBillAccountNo) {
		this.mortBillAccountNo = mortBillAccountNo;
	}

	public BigDecimal getMortBillAmount() {
		return mortBillAmount;
	}

	public void setMortBillAmount(BigDecimal mortBillAmount) {
		this.mortBillAmount = mortBillAmount;
	}

	public BigDecimal getSumMortBillAmount() {
		return sumMortBillAmount;
	}

	public void setSumMortBillAmount(BigDecimal sumMortBillAmount) {
		this.sumMortBillAmount = sumMortBillAmount;
	}

	public BigDecimal getSumTransBillAmount() {
		return sumTransBillAmount;
	}

	public void setSumTransBillAmount(BigDecimal sumTransBillAmount) {
		this.sumTransBillAmount = sumTransBillAmount;
	}

	public BigDecimal getOpenAmount() {
		return openAmount;
	}

	public void setOpenAmount(BigDecimal openAmount) {
		this.openAmount = openAmount;
	}

	public BigDecimal getSumTransBailAmount() {
		return SumTransBailAmount;
	}

	public void setSumTransBailAmount(BigDecimal sumTransBailAmount) {
		SumTransBailAmount = sumTransBailAmount;
	}

	public BigDecimal getSumBailAmount() {
		return sumBailAmount;
	}

	public void setSumBailAmount(BigDecimal sumBailAmount) {
		this.sumBailAmount = sumBailAmount;
	}

	public String getBailAccountno() {
		return bailAccountno;
	}

	public void setBailAccountno(String bailAccountno) {
		this.bailAccountno = bailAccountno;
	}

	public String getTradeContcode() {
		return tradeContcode;
	}

	public void setTradeContcode(String tradeContcode) {
		this.tradeContcode = tradeContcode;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public BigDecimal getAmountOut() {
		return amountOut;
	}

	public void setAmountOut(BigDecimal amountOut) {
		this.amountOut = amountOut;
	}

	public BigDecimal getCurrOutAmt() {
		return currOutAmt;
	}

	public void setCurrOutAmt(BigDecimal currOutAmt) {
		this.currOutAmt = currOutAmt;
	}

	public String getMoniPriceModel() {
		return moniPriceModel;
	}

	public void setMoniPriceModel(String moniPriceModel) {
		this.moniPriceModel = moniPriceModel;
	}
}
